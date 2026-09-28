package edu.suffolk.litlab.efsp.server.setup.truefiling;

import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.db.model.Transaction;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCodeType;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import edu.suffolk.litlab.efsp.server.services.api.UpdateMessageStatus;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import edu.suffolk.litlab.efsp.truefiling.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodeDatabase;
import gov.niem.niem.domains.jxdm._4.CaseAugmentationType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
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

// TODO(brycew): does this need to become multiple different files, one for each jurisdiction? Can't
// have multiple wsdlLocations

@jakarta.jws.WebService(
    serviceName = "FilingAssemblyMDEService",
    portName = "FilingAssemblyMDEPort",
    targetNamespace = "urn:ImageSoft:ecf:wsdl:WebServicesProfile-Implementation-4.0",
    // "Typically, users never use the attribute in their own JWS files":
    // https://docs.oracle.com/cd/E13222_01/wls/docs92/webserv/annotations.html
    endpointInterface =
        "oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingAssemblyMDEPort")
public class TrueFilingWsCallback implements FilingAssemblyMDEPort {
  private static Logger log = LoggerFactory.getLogger(TrueFilingWsCallback.class);

  private static final ObjectFactory receiptFac = new ObjectFactory();
  private final Supplier<TFCodeDatabase> cdSupplier;
  private final Supplier<UserDatabase> udSupplier;
  private final OrgMessageSender msgSender;

  public TrueFilingWsCallback(
      Supplier<TFCodeDatabase> cdSupplier,
      Supplier<UserDatabase> udSupplier,
      OrgMessageSender msgSender) {
    this.cdSupplier = cdSupplier;
    this.udSupplier = udSupplier;
    this.msgSender = msgSender;
  }

  /*
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
  */

  private static String documentToStr(ReviewedDocumentType doc, NameAndCode courtName) {
    if (doc == null) {
      return "";
    }
    StringBuilder docText = new StringBuilder();
    var description = Ecf4Helper.getNonEmptyText(doc.getDocumentDescriptionText());
    description.ifPresent(
        desc -> {
          docText.append("The document (").append(desc).append(") ");
        });
    if (doc.getDocumentBinary() != null
        && doc.getDocumentBinary().getBinaryDescriptionText() != null) {
      docText
          .append("with file name ")
          .append(doc.getDocumentBinary().getBinaryDescriptionText().getValue());
    } else if (doc.getDocumentRendition() != null) {
      for (DocumentRenditionType ren : doc.getDocumentRendition()) {
        if (ren.getDocumentBinary() != null
            && ren.getDocumentBinary().getBinaryDescriptionText() != null) {
          docText
              .append(", file name ")
              .append(ren.getDocumentBinary().getBinaryDescriptionText().getValue());
        }
      }
    }

    /*
      var maybeComments = Ecf4Helper.getNonEmptyText(doc.getFilingReviewCommentsText());
      maybeComments.ifPresent(
          comments -> {
            docText.append(" has the following review comments: ").append(comments);
          });

      var maybeRejectText = Ecf4Helper.getNonEmptyText(doc.getRejectReasonText());
      if (maybeRejectText.isPresent()) {
        docText.append(", was rejected for the following reason: ");
        docText.append(maybeRejectText.get());
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
    */
    if (docText.length() > 0) {
      docText.append('.');
      if (!docText.substring(0, 12).equals("The document")) {
        docText.insert(0, "The document ");
      }
    }
    return docText.toString();
  }

  private static String reviewedFilingMessageText(
      ReviewFilingCallbackMessageType revFiling, NameAndCode courtInfo) {
    StringBuilder messageText = new StringBuilder();
    if (revFiling.getReviewedLeadDocument() != null
        && revFiling.getReviewedLeadDocument() != null) {
      ReviewedDocumentType leadDoc = revFiling.getReviewedLeadDocument();
      messageText.append(documentToStr(leadDoc, courtInfo));
    }
    if (revFiling.getReviewedConnectedDocument() != null) {
      for (var doc : revFiling.getReviewedConnectedDocument()) {
        if (doc != null) {
          messageText.append(documentToStr(doc, courtInfo));
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
    if (filingStat != null) {
      String replyCode = filingStat.getFilingStatusCode();
      if (replyCode == null) {
        replyCode = "unknown";
      }
      // the codes table doesn't have any other info than the code itself, so just return that.
      return replyCode;
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
    setupReplys(reply);
    if (msg == null) {
      log.error("Tyler sent a null message! Why??");
      return error(reply, "705", "NotifyFilingReviewComplete message not found");
    }

    PaymentMessageType payment = msg.getPaymentReceiptMessage();
    ReviewFilingCallbackMessageType revFiling = msg.getReviewFilingCallbackMessage();

    if (revFiling != null) {
      var leadDoc = revFiling.getReviewedLeadDocument();
      if (leadDoc != null) {
        stripDocumentObjects(leadDoc);
      }
      var sideDocs = revFiling.getReviewedConnectedDocument();
      if (sideDocs != null) {
        for (var sideDoc : sideDocs) {
          if (sideDoc != null) {
            stripDocumentObjects(sideDoc);
          }
        }
      }
    }
    // The bare minimum: get the Document ID, see if we have it in the db, send email response
    // This shouldn't happen, but I don't trust this XML BS
    if (payment == null || revFiling == null) {
      log.error("Tyler sent a message w/o filing review or payment receipt? Full msg: {}", msg);
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
      return error(reply, "720", "Filing code not found in message");
    }
    Optional<CaseAugmentationType> jAug =
        EcfCaseTypeFactory.getJCaseAugmentation(revFiling.getCase().getValue());
    String courtIdFromMsg = "";
    if (jAug.isPresent()) {
      var j = jAug.get();
      if (j.getCaseCourt() != null && j.getCaseCourt().getOrganizationIdentification() != null) {
        var orgId = j.getCaseCourt().getOrganizationIdentification();
        if (orgId != null && orgId.getIdentificationID() != null) {
          courtIdFromMsg = orgId.getIdentificationID().getValue();
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
    }
    Transaction trans = maybeTrans.get();

    MDC.put(MDCWrappers.SERVER_ID, trans.serverId.toString());
    // TODO(brycew): consider setting server name here as well
    log.info(
        "Full NotifyFilingReviewComplete msg: {}",
        Ecf4Helper.objectToXmlStrOrError(msg, NotifyFilingReviewCompleteRequestMessageType.class));

    // Handle payment stuff: Address is usually empty, it's all in Payment and AllowanceCharges
    // List<String> charges =
    //    payment.getAllowanceCharge().stream()
    //        .filter(c -> c != null)
    //        .map(TrueFilingWsCallback::chargeToStr)
    //        .toList();

    // Trust in Tyler's courtId over ours, maybe location can change on their side
    String courtId = (courtIdFromMsg.isBlank()) ? trans.courtId : courtIdFromMsg;
    String caseName = revFiling.getCase().getValue().getCaseTitleText().getValue();
    Optional<NameAndCode> courtInfo = Optional.empty();
    try (TFCodeDatabase cd = cdSupplier.get()) {
      courtInfo =
          cd.getLocationNames().stream().filter(nac -> nac.code().equals(courtId)).findFirst();
      if (courtInfo.isEmpty()) {
        log.warn(
            "Court {} no longer exists in codes? ({} from msg, {} from db)",
            courtId,
            courtIdFromMsg,
            trans.courtId);
        return error(reply, "70", "Location " + courtId + " not found");
      }
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db", ex);
      courtInfo = Optional.of(new NameAndCodeType("The Court", courtId));
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
        courtInfo.get().name());
    boolean success =
        msgSender.sendMessage(
            trans, status, statusText, messageText, null, courtInfo.get().name(), caseName);
    if (!success) {
      log.error("Couldn't properly send message for transaction ID {}!", trans.transactionId);
    }
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

  public static void setupReplys(CaseFilingType reply) {
    Ecf4Helper.setupReplys(reply, ServiceHelpers.SENDING_MDE_LOCATION);
  }
}
