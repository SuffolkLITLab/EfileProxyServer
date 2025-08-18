package edu.suffolk.litlab.efsp.server.setup.tyler;

import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.db.model.Transaction;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.server.services.api.UpdateMessageStatus;
import edu.suffolk.litlab.efsp.server.utils.MDCWrappers;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import gov.niem.niem.domains.jxdm._4.CaseAugmentationType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
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
public class OasisEcfWsCallback implements FilingAssemblyMDEPort {
  private static Logger log = LoggerFactory.getLogger(OasisEcfWsCallback.class);

  private static final ObjectFactory receiptFac = new ObjectFactory();
  private final Supplier<CodeDatabase> cdSupplier;
  private final Supplier<UserDatabase> udSupplier;
  private final OrgMessageSender msgSender;

  public OasisEcfWsCallback(
      Supplier<CodeDatabase> cdSupplier,
      Supplier<UserDatabase> udSupplier,
      OrgMessageSender msgSender) {
    this.cdSupplier = cdSupplier;
    this.udSupplier = udSupplier;
    this.msgSender = msgSender;
  }

  private static String chargeToStr(AllowanceChargeType charge) {
    StringBuilder chargeReason = new StringBuilder();
    String amountText = Ecf4Helper.amountToString(charge.getAmount());
    chargeReason.append(amountText);
    if (charge.getAllowanceChargeReason() != null) {
      chargeReason.append(" for ").append(charge.getAllowanceChargeReason().getValue());
    }
    charge.getPaymentMeans().stream()
        .filter(m -> m != null)
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
                if (!cardInfo.isBlank()) {
                  chargeReason.append(" paid for using " + cardInfo);
                }
              }
            });
    return chargeReason.toString();
  }

  private static String documentToStr(ReviewedDocumentType doc, CourtLocationInfo courtInfo) {
    if (doc == null) {
      return "";
    }
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
      ReviewFilingCallbackMessageType revFiling, CourtLocationInfo courtInfo) {
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
                  .filter(des -> des != null)
                  .reduce(
                      "", (all, des) -> all + des.getValue(), (des1, des2) -> des1 + ". " + des2));
    }
    return messageText.toString();
  }

  private String reviewedFilingStatusText(FilingStatusType filingStat, Transaction trans) {
    List<NameAndCode> names = List.of();
    try (CodeDatabase cd = cdSupplier.get()) {
      names = cd.getFilingStatuses(trans.courtId);
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db", ex);
      return "";
    }

    if (filingStat != null) {
      final String replyCode = filingStat.getFilingStatusCode();
      Optional<String> statusText =
          names.stream()
              .filter(nac -> nac.getCode().equalsIgnoreCase(replyCode))
              .map(nac -> nac.getName())
              .findFirst();

      return statusText.orElseGet(
          () -> {
            if (replyCode != null && !replyCode.isBlank()) {
              return replyCode;
            }
            if (filingStat.getStatusText() != null
                && filingStat.getStatusText().getValue() != null) {
              return filingStat.getStatusText().getValue();
            }
            return "";
          });
    } else {
      return "unknown";
    }
  }

  private static UpdateMessageStatus parseFilingStatusCode(FilingStatusType filingStat) {
    if (filingStat != null) {
      final String replyCode = filingStat.getFilingStatusCode();
      return UpdateMessageStatus.fromStr(replyCode);
    } else {
      return UpdateMessageStatus.NEUTRAL;
    }
  }

  private static void stripDocumentObjects(ReviewedDocumentType doc) {
    if (doc == null) {
      return;
    }
    if (doc.getDocumentBinary() != null) {
      doc.getDocumentBinary().setBinaryObject(null);
    }
    if (doc.getDocumentRendition() != null) {
      for (var renDoc : doc.getDocumentRendition()) {
        if (renDoc.getDocumentBinary() != null) {
          renDoc.getDocumentBinary().setBinaryObject(null);
        }
      }
    }
  }

  @Override
  public MessageReceiptMessageType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestMessageType msg) {
    MDC.put(MDCWrappers.OPERATION, "notifyFilingReviewComplete");

    MessageReceiptMessageType reply = receiptFac.createMessageReceiptMessageType();
    Ecf4Helper.setupReplys(reply);
    if (msg == null) {
      log.error("Tyler sent a null message! Why??");
      MDCWrappers.removeAllMDCs();
      return error(reply, "705", "NotifyFilingReviewComplete message not found");
    }

    PaymentMessageType payment = msg.getPaymentReceiptMessage();
    ReviewFilingCallbackMessageType revFiling = msg.getReviewFilingCallbackMessage();

    if (revFiling != null) {
      var leadDoc = revFiling.getReviewedLeadDocument();
      if (leadDoc != null && leadDoc.getValue() != null) {
        stripDocumentObjects(leadDoc.getValue());
      }
      var sideDocs = revFiling.getReviewedConnectedDocument();
      if (sideDocs != null) {
        for (var sideDoc : sideDocs) {
          if (sideDoc != null && sideDoc.getValue() != null) {
            stripDocumentObjects(sideDoc.getValue());
          }
        }
      }
    }
    // The bare minimum: get the Document ID, see if we have it in the db, send email response
    // This shouldn't happen, but I don't trust this XML BS
    if (payment == null || revFiling == null) {
      log.error("Tyler sent a message w/o filing review or payment receipt? Full msg: {}", msg);
      MDCWrappers.removeAllMDCs();
      return error(reply, "705", "NotifyFilingReviewComplete message not found");
    }

    // Now for the review filing
    String filingId = "";
    for (IdentificationType id : revFiling.getDocumentIdentification()) {
      if (id == null) {
        continue;
      }
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
      log.error("Got back a review filing that has a blank / no FILINGID? {}", revFiling);
      MDCWrappers.removeAllMDCs();
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
    Optional<Transaction> maybeTrans = Optional.empty();
    try (UserDatabase ud = udSupplier.get()) {
      maybeTrans = ud.findTransaction(UUID.fromString(filingId));
      if (maybeTrans.isEmpty()) {
        log.warn("No transaction on record for filingId: {}, no one to send to", filingId);
        return error(reply, "724", "Filing ID " + filingId + " not found");
      }
    } catch (SQLException e) {
      log.error("Couldn't connect to SQL DB to get transaction", e);
      return error(reply, "-1", "Server error");
    } finally {
      MDCWrappers.removeAllMDCs();
    }
    Transaction trans = maybeTrans.get();

    MDC.put(MDCWrappers.SERVER_ID, trans.serverId.toString());
    log.info(
        "Full NotifyFilingReviewComplete msg: {}",
        Ecf4Helper.objectToXmlStrOrError(msg, NotifyFilingReviewCompleteRequestMessageType.class));

    // Handle payment stuff: Address is usually empty, it's all in Payment and AllowanceCharges
    List<String> charges =
        payment.getAllowanceCharge().stream()
            .filter(c -> c != null)
            .map(OasisEcfWsCallback::chargeToStr)
            .toList();

    // Trust in Tyler's courtId over ours, maybe location can change on their side
    String courtId = (courtIdFromMsg.isBlank()) ? trans.courtId : courtIdFromMsg;
    String caseName = revFiling.getCase().getValue().getCaseTitleText().getValue();
    Optional<CourtLocationInfo> courtInfo = Optional.empty();
    try (CodeDatabase cd = cdSupplier.get()) {
      courtInfo = cd.getFullLocationInfo(courtId);
      if (courtInfo.isEmpty()) {
        log.warn(
            "Court {} no longer exists in codes? ({} from msg, {} from db)",
            courtId,
            courtIdFromMsg,
            trans.courtId);
        MDCWrappers.removeAllMDCs();
        return error(reply, "70", "Location " + courtId + " not found");
      }
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db", ex);
      courtInfo = Optional.of(new CourtLocationInfo());
      courtInfo.get().name = courtId;
    }

    reply.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    String statusText = reviewedFilingStatusText(revFiling.getFilingStatus(), trans);
    String messageText = reviewedFilingMessageText(revFiling, courtInfo.get());

    UpdateMessageStatus status = parseFilingStatusCode(revFiling.getFilingStatus());
    log.info(
        "Replying to litigant with: status: `{}` (statusText: `{}`), messageText: `{}`, courtName: {}",
        status,
        statusText,
        messageText,
        courtInfo.get().name);
    boolean success =
        msgSender.sendMessage(
            trans, status, statusText, messageText, null, courtInfo.get().name, caseName);
    if (!success) {
      log.error("Couldn't properly send message for transaction ID {}!", trans.transactionId);
    }
    MDCWrappers.removeAllMDCs();
    return ok(reply);
  }

  @Override
  public MessageReceiptMessageType notifyEvent(EventCallbackMessageType eventCallbackMessage) {
    log.info("Full NotifyEvent msg {}", eventCallbackMessage);
    // TODO(brycew): not going to do anything with for now
    MessageReceiptMessageType reply = receiptFac.createMessageReceiptMessageType();
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
    MessageReceiptMessageType reply = receiptFac.createMessageReceiptMessageType();
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
