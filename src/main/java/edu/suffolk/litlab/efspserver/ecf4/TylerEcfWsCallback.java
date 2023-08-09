package edu.suffolk.litlab.efspserver.ecf4;

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.Transaction;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.services.MDCWrappers;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;
import edu.suffolk.litlab.efspserver.services.UpdateMessageStatus;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.NameAndCode;
import gov.niem.niem.domains.jxdm._4.CaseAugmentationType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import javax.sql.DataSource;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CardAccountType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.ObjectFactory;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ReviewFilingCallbackMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.NotifyFilingReviewCompleteRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingAssemblyMDEPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.ecf.extensions.eventcallbackmessage.EventCallbackMessageType;
import tyler.ecf.extensions.servicecallbackmessage.ServiceCallbackMessageType;

// TODO(brycew): does this need to become multiple different files, one for each jurisdiction? Can't
// have multiple wsdlLocations

@jakarta.jws.WebService(
    serviceName = "FilingAssemblyMDEService",
    portName = "FilingAssemblyMDEPort",
    targetNamespace = "urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0",
    // "Typically, users never use the attribute in their own JWS files":
    // https://docs.oracle.com/cd/E13222_01/wls/docs92/webserv/annotations.html
    // wsdlLocation="file:src/main/resources/wsdl/stage/illinois-ECF-4.0-FilingAssemblyMDEService-mod.wsdl",
    endpointInterface =
        "oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingAssemblyMDEPort")
public class TylerEcfWsCallback implements FilingAssemblyMDEPort {
  private static Logger log = LoggerFactory.getLogger(TylerEcfWsCallback.class);

  private final ObjectFactory recepitFac;
  private final DataSource userDs;
  private final Supplier<CodeDatabase> cdSupplier;
  private final OrgMessageSender msgSender;

  public TylerEcfWsCallback(
      String jurisdiction,
      String env,
      Supplier<CodeDatabase> cdSupplier,
      DataSource userDs,
      OrgMessageSender msgSender) {
    this.recepitFac = new ObjectFactory();
    this.cdSupplier = cdSupplier;
    this.userDs = userDs;
    this.msgSender = msgSender;
  }

  private static String chargeToStr(AllowanceChargeType charge) {
    StringBuilder chargeReason = new StringBuilder();
    String amountText = Ecf4Helper.amountToString(charge.getAmount());
    chargeReason.append(amountText);
    if (charge.getAllowanceChargeReason() != null) {
      chargeReason.append(" for ").append(charge.getAllowanceChargeReason());
    }
    charge.getPaymentMeans().stream()
        .forEach(
            m -> {
              CardAccountType acct = m.getCardAccount();
              if (acct != null) {
                String cardInfo = "";
                if (acct.getCardTypeCode() != null) {
                  cardInfo += acct.getCardTypeCode().getValue();
                }
                if (acct.getPrimaryAccountNumberID() != null) {
                  cardInfo += " (" + acct.getPrimaryAccountNumberID().getValue() + ")";
                }
                if (acct.getExpiryDate() != null && acct.getExpiryDate().getValue() != null) {
                  cardInfo += " (exp " + acct.getExpiryDate().getValue().toString() + ")";
                }
                chargeReason.append(" paid for using " + cardInfo);
              }
            });
    return chargeReason.toString();
  }

  private static String documentToStr(ReviewedDocumentType doc, CourtLocationInfo courtInfo) {
    StringBuilder docText = new StringBuilder();
    if (doc instanceof tyler.ecf.extensions.common.ReviewedDocumentType tylerDoc) {
      if (tylerDoc.getDocumentDescriptionText() != null
          && tylerDoc.getDocumentDescriptionText().getValue() != null
          && tylerDoc.getDocumentDescriptionText().getValue().isBlank()) {
        docText
            .append("The document (")
            .append(tylerDoc.getDocumentDescriptionText().getValue())
            .append(") ");
      }
      if (tylerDoc.getDocumentBinary() != null
          && tylerDoc.getDocumentBinary().getBinaryDescriptionText() != null) {
        docText
            .append("with file name ")
            .append(tylerDoc.getDocumentBinary().getBinaryDescriptionText().getValue());
      } else if (tylerDoc.getDocumentRendition() != null) {
        for (DocumentRenditionType ren : tylerDoc.getDocumentRendition()) {
          if (ren.getDocumentBinary() != null
              && ren.getDocumentBinary().getBinaryDescriptionText() != null) {
            docText
                .append(", file name ")
                .append(ren.getDocumentBinary().getBinaryDescriptionText().getValue());
          }
        }
      }

      if (tylerDoc.getFilingReviewCommentsText() != null
          && tylerDoc.getFilingReviewCommentsText().getValue() != null
          && !tylerDoc.getFilingReviewCommentsText().getValue().isBlank()) {
        docText
            .append(" has the following review comments: ")
            .append(tylerDoc.getFilingReviewCommentsText().getValue());
      }

      if (tylerDoc.getRejectReasonText() != null
          && tylerDoc.getRejectReasonText().getValue() != null
          && !tylerDoc.getRejectReasonText().getValue().isBlank()) {
        if (courtInfo.showreturnonreject) {
          docText.append(", was returned for the following reason: ");
        } else {
          docText.append(", was rejected for the following reason: ");
        }
        docText.append(tylerDoc.getRejectReasonText().getValue());
      }
    } else {
      docText.append("The review was about the document ");
      for (DocumentRenditionType ren : doc.getDocumentRendition()) {
        if (ren.getDocumentBinary() != null
            && ren.getDocumentBinary().getBinaryDescriptionText() != null) {
          docText
              .append(", file name ")
              .append(ren.getDocumentBinary().getBinaryDescriptionText().getValue());
        }
      }
    }
    if (docText.length() > 0) {
      docText.append('.');
      if (!docText.substring(0, 12).equals("The document")) {
        docText.insert(0, "The document ");
      }
    }
    return docText.toString();
  }

  private static String reviewedFilingMessageText(
      ReviewFilingCallbackMessageType revFiling, Transaction trans, CourtLocationInfo courtInfo) {
    StringBuilder messageText = new StringBuilder();
    if (revFiling.getReviewedLeadDocument() != null
        && revFiling.getReviewedLeadDocument().getValue() != null) {
      ReviewedDocumentType leadDoc = revFiling.getReviewedLeadDocument().getValue();
      messageText.append(documentToStr(leadDoc, courtInfo));
    }
    if (revFiling.getReviewedConnectedDocument() != null) {
      for (var doc : revFiling.getReviewedConnectedDocument()) {
        if (doc != null && doc.getValue() != null) {
          messageText.append(documentToStr(doc.getValue(), courtInfo));
        }
      }
    }
    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {
      messageText
          .append('\n')
          .append(
              filingStat.getStatusDescriptionText().stream()
                  .reduce(
                      "",
                      (des, tt) -> des + ((tt != null) ? tt.getValue() : ""),
                      (des1, des2) -> des1 + ". " + des2));
    }
    return messageText.toString();
  }

  private String reviewedFilingStatusText(
      ReviewFilingCallbackMessageType revFiling, Transaction trans) {
    List<NameAndCode> names = List.of();
    try (CodeDatabase cd = cdSupplier.get()) {
      names = cd.getFilingStatuses(trans.courtId);
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db: " + StdLib.strFromException(ex));
    }

    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {
      final String replyCode = filingStat.getFilingStatusCode();
      Optional<String> statusText =
          names.stream()
              .filter(nac -> nac.getCode().equalsIgnoreCase(replyCode))
              .map(nac -> nac.getName())
              .findFirst();

      String statusCode = replyCode;
      if (replyCode == null || replyCode.isBlank()) {
        if (filingStat.getStatusText() != null) {
          statusCode = filingStat.getStatusText().getValue();
        } else {
          statusCode = "";
        }
      }
      return statusText.orElse(statusCode);
    } else {
      return "unknown";
    }
  }

  private static UpdateMessageStatus reviewedFilingStatusCode(
      ReviewFilingCallbackMessageType revFiling) {
    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {
      final String replyCode = filingStat.getFilingStatusCode();
      return UpdateMessageStatus.fromStr(replyCode);
    } else {
      return UpdateMessageStatus.NEUTRAL;
    }
  }

  @Override
  public MessageReceiptMessageType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestMessageType msg) {
    if (msg.getReviewFilingCallbackMessage() != null) {
      var leadDoc = msg.getReviewFilingCallbackMessage().getReviewedLeadDocument();
      if (leadDoc != null
          && leadDoc.getValue() != null
          && leadDoc.getValue().getDocumentBinary() != null) {
        msg.getReviewFilingCallbackMessage()
            .getReviewedLeadDocument()
            .getValue()
            .getDocumentBinary()
            .setBinaryObject(null);
      }
    }
    // The bare minimum: get the Document ID, see if we have it in the db, send email response
    PaymentMessageType payment = msg.getPaymentReceiptMessage();
    ReviewFilingCallbackMessageType revFiling = msg.getReviewFilingCallbackMessage();
    MessageReceiptMessageType reply = recepitFac.createMessageReceiptMessageType();
    Ecf4Helper.setupReplys(reply);
    // This shouldn't happen, but I don't trust this XML BS
    if (payment == null || revFiling == null) {
      log.error(
          "Why did Tyler send us a notifyFilingReviewComplete without either a filing"
              + " review or a payment receipt?");
      log.error(msg.toString());
      return error(reply, "705", "NotifyFilingReviewComplete message not found");
    }

    // Now for the review filing
    String filingId = "";
    for (IdentificationType id : revFiling.getDocumentIdentification()) {
      if (id.getIdentificationCategory().getValue() instanceof TextType category) {
        if (category.getValue() != null && category.getValue().equalsIgnoreCase("FILINGID")) {
          filingId = id.getIdentificationID().getValue();
        }
      }
      // TODO(brycew-later): do we need to do anything with the parent envelope?
      // Maybe check them as well? But the filingId should be the same overall, and we'll save
      // most of them.
    }
    if (filingId.isBlank()) {
      log.error("Got back a review filing that has a blank / no FILINGID? " + revFiling.toString());
      return error(reply, "720", "Filing code not found in message");
    }
    Optional<CaseAugmentationType> jAug =
        EcfCaseTypeFactory.getJCaseAugmentation(revFiling.getCase().getValue());
    String courtIdFromMsg = "";
    if (jAug.isPresent()) {
      var j = jAug.get();
      if (j.getCaseCourt() != null && j.getCaseCourt().getOrganizationIdentification() != null) {
        var orgId = j.getCaseCourt().getOrganizationIdentification();
        if (orgId.getValue() != null && orgId.getValue().getIdentificationID() != null) {
          courtIdFromMsg = orgId.getValue().getIdentificationID().getValue();
        }
      }
    }
    Optional<Transaction> trans = Optional.empty();
    try (UserDatabase ud = new UserDatabase(userDs.getConnection())) {
      trans = ud.findTransaction(UUID.fromString(filingId));
    } catch (SQLException e) {
      log.error("Couldn't connect to the SQL database to get the transaction: " + e.toString());
      return error(reply, "-1", "Server error");
    }
    if (trans.isEmpty()) {
      log.warn("No transaction on record for filingId: " + filingId + " no one to send to");
      return error(reply, "724", "Filing ID " + filingId + " not found");
    }

    // Handle payment stuff: Address is usually empty, it's all in Payment and AllowanceCharges
    List<String> charges = new ArrayList<>();
    for (AllowanceChargeType charge : payment.getAllowanceCharge()) {
      charges.add(chargeToStr(charge));
    }

    MDC.put(MDCWrappers.SERVER_ID, trans.get().serverId.toString());
    log.info(
        "Full NotifyFilingReviewComplete msg: "
            + Ecf4Helper.objectToXmlStrOrError(
                msg, NotifyFilingReviewCompleteRequestMessageType.class));

    // Trust in Tyler's courtId over ours, maybe location can change on their side
    String courtId = (courtIdFromMsg.isBlank()) ? trans.get().courtId : courtIdFromMsg;
    String caseName = revFiling.getCase().getValue().getCaseTitleText().getValue();
    Optional<CourtLocationInfo> courtInfo = Optional.empty();
    try (CodeDatabase cd = cdSupplier.get()) {
      courtInfo = cd.getFullLocationInfo(courtId);
      if (courtInfo.isEmpty()) {
        log.warn(
            "Court "
                + courtId
                + " no longer exists in codes? ("
                + courtIdFromMsg
                + " from msg, "
                + trans.get().courtId
                + " from db)");
        MDCWrappers.removeAllMDCs();
        return error(reply, "70", "Location " + courtId + " not found");
      }
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db: " + StdLib.strFromException(ex));
      courtInfo = Optional.of(new CourtLocationInfo());
      courtInfo.get().name = courtId;
    }

    reply.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    String statusText = reviewedFilingStatusText(revFiling, trans.get());
    String messageText = reviewedFilingMessageText(revFiling, trans.get(), courtInfo.get());

    UpdateMessageStatus status = reviewedFilingStatusCode(revFiling);

    log.info("Filing status: " + statusText + ";; " + messageText + ";; " + status.toString());
    boolean success =
        msgSender.sendMessage(
            trans.get(), status, statusText, messageText, null, courtInfo.get().name, caseName);
    log.info(
        "Replying to litigant with: status: "
            + status
            + ", statusText: "
            + statusText
            + ", messageText: "
            + messageText
            + ", courtName: "
            + courtInfo.get().name);
    if (!success) {
      log.error("Couldn't properly send message to " + trans.get().name + "!");
    }
    MDCWrappers.removeAllMDCs();
    return ok(reply);
  }

  @Override
  public MessageReceiptMessageType notifyEvent(EventCallbackMessageType eventCallbackMessage) {
    log.info("Full NotifyEvent msg" + eventCallbackMessage);
    // TODO(brycew): not going to do anything with for now
    MessageReceiptMessageType reply = recepitFac.createMessageReceiptMessageType();
    Ecf4Helper.setupReplys(reply);
    return ok(reply);
  }

  @Override
  public MessageReceiptMessageType notifyServiceComplete(
      ServiceCallbackMessageType serviceCallbackMessage) {
    log.info(
        "Full NotifyServiceComplete msg: "
            + Ecf4Helper.objectToXmlStrOrError(
                serviceCallbackMessage, ServiceCallbackMessageType.class));
    // TODO(brycew): not going to do anything with for now
    MessageReceiptMessageType reply = recepitFac.createMessageReceiptMessageType();
    Ecf4Helper.setupReplys(reply);
    return ok(reply);
  }

  private static MessageReceiptMessageType ok(MessageReceiptMessageType reply) {
    return error(reply, "0", "No Error");
  }

  private static MessageReceiptMessageType error(
      MessageReceiptMessageType reply, String code, String text) {
    ErrorType err = new ErrorType();
    err.setErrorCode(Ecf4Helper.convertText(code));
    err.setErrorText(Ecf4Helper.convertText(text));
    reply.getError().add(err);
    return reply;
  }
}
