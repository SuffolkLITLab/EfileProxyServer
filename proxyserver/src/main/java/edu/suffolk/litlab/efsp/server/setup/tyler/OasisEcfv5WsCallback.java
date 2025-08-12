package edu.suffolk.litlab.efsp.server.setup.tyler;

import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.db.model.Transaction;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.server.services.api.UpdateMessageStatus;
import edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeSimpleType;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeSimpleType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeType;
import gov.niem.release.niem.domains.cbrn._4.MessageContentErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.PersonType;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.FilingStatusType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ReviewedDocumentAugmentationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ReviewedDocumentType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyFilingReviewCompleteRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyFilingReviewCompleteResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback.NotifyFilingReviewCompleteMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.filingassemblymde.FilingAssemblyMDE;
import jakarta.xml.bind.JAXBElement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CardAccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@jakarta.jws.WebService(
    serviceName = "FilingAssemblyMDEService",
    portName = "FilingAssemblyMDEPort",
    targetNamespace = "urn:tyler:efm:wsdl:WebServicesProfile-Implementation-5.0",
    // "Typically, users never use the attribute in their own JWS files":
    // https://docs.oracle.com/cd/E13222_01/wls/docs92/webserv/annotations.html
    // wsdlLocation="file:src/main/resources/wsdl/stage/illinois-v5-FilingAssemblyMDE.wsdl",
    endpointInterface =
        "https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.filingassemblymde.FilingAssemblyMDE")
public class OasisEcfv5WsCallback implements FilingAssemblyMDE {
  private static Logger log = LoggerFactory.getLogger(Ecf4Filer.class);

  private final Supplier<CodeDatabase> cdSupplier;
  private final Supplier<UserDatabase> udSupplier;
  private final OrgMessageSender msgSender;

  public OasisEcfv5WsCallback(
      Supplier<CodeDatabase> cdSupplier,
      Supplier<UserDatabase> udSupplier,
      OrgMessageSender msgSender) {
    this.cdSupplier = cdSupplier;
    this.udSupplier = udSupplier;
    this.msgSender = msgSender;
  }

  private static String chargeToStr(AllowanceChargeType charge) {
    StringBuilder chargeReasonStr = new StringBuilder();
    String amountText = Ecfv5XmlHelper.amountToString(charge.getAmount());
    chargeReasonStr.append(amountText);
    chargeReasonStr.append(" for ").append(charge.getAllowanceChargeReason());
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
                chargeReasonStr.append(" paid for using " + cardInfo);
              }
            });
    return chargeReasonStr.toString();
  }

  private static String documentToStr(ReviewedDocumentType doc) {
    StringBuilder docText = new StringBuilder();
    if (doc.getDocumentDescriptionText() != null
        && doc.getDocumentDescriptionText().getValue() != null
        && doc.getDocumentDescriptionText().getValue().isBlank()) {
      docText
          .append("The document (")
          .append(doc.getDocumentDescriptionText().getValue())
          .append(") ");
    } else {
      docText.append("The document ");
    }
    if (doc.getDocumentTitleText() != null) {
      docText.append("with file name ").append(doc.getDocumentTitleText());
    }

    docText.append("The review was about the document ");
    for (JAXBElement<?> ren : doc.getReviewedDocumentAugmentationPoint()) {
      if (ren.getValue() != null
          && ren.getValue() instanceof ReviewedDocumentAugmentationType revAug) {
        if (revAug.getDocumentReviewer() != null
            && revAug.getDocumentReviewer().getEntityRepresentation() != null) {
          JAXBElement<?> entityRep = revAug.getDocumentReviewer().getEntityRepresentation();
          ;
          if (entityRep.getValue() instanceof PersonType perType) {
            // TODO(brycew): read out the whole person's name
            docText.append(", was reviewed by : ").append(perType.getPersonName());
          }
        }
        if (revAug.getDocumentReviewStatus() != null
            && revAug.getDocumentReviewStatus().getStatusDescriptionText() != null
            && revAug.getDocumentReviewStatus().getStatusDescriptionText().getValue() != null
            && !revAug.getDocumentReviewStatus().getStatusDescriptionText().getValue().isBlank()) {
          docText
              .append(" has the following review comments: ")
              .append(revAug.getDocumentReviewStatus().getStatusDescriptionText().getValue());
        }
      }
    }
    docText.append('.');
    return docText.toString();
  }

  private String reviewedFilingMessageText(
      NotifyFilingReviewCompleteMessageType revFiling, Transaction trans) {
    StringBuilder messageText = new StringBuilder();
    if (revFiling.getReviewedLeadDocument() != null
        && !revFiling.getReviewedLeadDocument().isEmpty()) {
      for (ReviewedDocumentType leadDoc : revFiling.getReviewedLeadDocument()) {
        messageText.append(documentToStr(leadDoc));
      }
    }
    if (revFiling.getReviewedConnectedDocument() != null) {
      for (var doc : revFiling.getReviewedConnectedDocument()) {
        if (doc != null) {
          messageText.append(documentToStr(doc));
        }
      }
    }
    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {
      messageText.append(' ').append(revFiling.getFilingStatus().getStatusDescriptionText());
    }
    return messageText.toString();
  }

  private String reviewedFilingStatusText(
      NotifyFilingReviewCompleteMessageType revFiling, Transaction trans) {
    List<NameAndCode> names = List.of();
    try (CodeDatabase cd = cdSupplier.get()) {
      names = cd.getFilingStatuses(trans.courtId);
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db: " + StdLib.strFromException(ex));
    }

    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {

      final String replyCode = filingStat.getFilingStatusCode().getValue();
      Optional<String> statusText =
          names.stream()
              .filter(nac -> nac.getCode().equalsIgnoreCase(replyCode))
              .map(nac -> nac.getName())
              .findFirst();

      String statusCode = replyCode;
      if (replyCode == null || replyCode.isBlank()) {
        if (filingStat.getStatusDescriptionText() != null) {
          statusCode = filingStat.getStatusDescriptionText().getValue();
        } else {
          statusCode = "";
        }
      }
      return statusText.orElse(statusCode);
    }
    return "unknown";
  }

  private UpdateMessageStatus reviewedFilingStatusCode(
      NotifyFilingReviewCompleteMessageType revFiling) {
    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {
      final String replyCode = filingStat.getFilingStatusCode().getValue();
      return UpdateMessageStatus.fromStr(replyCode);
    } else {
      return UpdateMessageStatus.NEUTRAL;
    }
  }

  @Override
  public NotifyCourtDateResponseType notifyCourtDate(NotifyCourtDateRequestType body) {
    log.info("Full NotifyCourtDate msg" + body);
    NotifyCourtDateResponseType reply = new NotifyCourtDateResponseType();
    reply.setMessageStatus(ok());
    return reply;
  }

  @Override
  public NotifyFilingReviewCompleteResponseType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestType body) {
    log.info("Full NotifyFilingReviewComplete msg" + body);
    // The bare minimum: get the Document ID, see if we have it in the db, send email response
    NotifyFilingReviewCompleteMessageType revFiling = body.getNotifyFilingReviewCompleteMessage();
    PaymentMessageType payment = body.getPaymentMessage();
    NotifyFilingReviewCompleteResponseType reply = new NotifyFilingReviewCompleteResponseType();
    reply.setMessageStatus(ok());
    // This shouldn't happen, but I don't trust this XML BS
    if (payment == null || revFiling == null) {
      log.error(
          "Why did Tyler send us a notifyFilingReviewComplete without either a filing"
              + " review or a payment receipt?");
      log.error(body.toString());
      reply.setMessageStatus(
          error(
              MessageStatusCodeSimpleType.DATA_ERROR,
              "705",
              "NotifyFilingReviewComplete message not found"));
      return reply;
    }

    // Handle payment stuff: Address is usually empty, it's all in Payment and AllowanceCharges
    List<String> charges = new ArrayList<>();
    for (var charge : payment.getAllowanceCharge()) {
      charges.add(chargeToStr(charge));
    }

    // Now for the review filing
    String filingId = "";
    for (IdentificationType id : revFiling.getDocumentIdentification()) {
      if (id.getIdentificationCategoryAbstract().getValue() instanceof NormalizedString category) {
        if (category.getValue().equalsIgnoreCase("FILINGID")) {
          filingId = id.getIdentificationID().getValue();
        }
      }
      // TODO(brycew-later): do we need to do anything with the parent envelope?
      // Maybe check them as well? But the filingId should be the same overall, and we'll save
      // most of them.
    }
    if (filingId.isBlank()) {
      log.error("Got back a review filing that has a blank / no FILINGID? " + revFiling.toString());
      reply.setMessageStatus(
          error(
              MessageStatusCodeSimpleType.ACTIVITY_CODE_FAILURE,
              "720",
              "Filing code not found in message"));
      return reply;
    }
    try (UserDatabase ud = udSupplier.get()) {
      Optional<Transaction> trans = ud.findTransaction(UUID.fromString(filingId));
      if (trans.isEmpty()) {
        log.warn("No transaction on record for filingId: " + filingId + " no one to send to");
        reply.setMessageStatus(
            error(
                MessageStatusCodeSimpleType.ACTIVITY_CODE_FAILURE,
                "724",
                "Filing ID " + filingId + " not found"));
        return reply;
      }
      String statusText = reviewedFilingStatusText(revFiling, trans.get());
      String messageText = reviewedFilingMessageText(revFiling, trans.get());
      UpdateMessageStatus status = reviewedFilingStatusCode(revFiling);
      String courtName =
          trans.get().courtId.substring(0, 1).toUpperCase() + trans.get().courtId.substring(1);
      try (CodeDatabase cd = cdSupplier.get()) {
        courtName =
            cd.getFullLocationInfo(trans.get().courtId).map(li -> li.name).orElse(courtName);
      } catch (SQLException ex) {
        log.error("In ECF v4 callback, couldn't get codes db: " + StdLib.strFromException(ex));
      }
      boolean success =
          msgSender.sendMessage(trans.get(), status, statusText, messageText, null, courtName);
      if (!success) {
        log.error("Couldn't properly send message to " + trans.get().name + "!");
      }
      reply.setMessageStatus(ok());
      return reply;
    } catch (SQLException e) {
      log.error("Couldn't connect to the SQL database to get the transaction: " + e.toString());
      reply.setMessageStatus(error(MessageStatusCodeSimpleType.SYSTEM_ERROR, "-1", "Server error"));
      return reply;
    }
  }

  private static MessageStatusType ok() {
    MessageStatusType st = common();
    MessageStatusCodeType ct = new MessageStatusCodeType();
    ct.setValue(MessageStatusCodeSimpleType.SUCCESS);
    st.setMessageStatusCode(ct);
    MessageContentErrorType contentError = new MessageContentErrorType();
    MessageErrorType errType = new MessageErrorType();
    errType.setErrorCodeText(Ecfv5XmlHelper.convertText("0"));
    contentError.setErrorDescription(errType);
    st.getMessageContentError().add(contentError);
    return st;
  }

  private static MessageStatusType common() {
    MessageStatusType st = new MessageStatusType();
    st.setSystemSimulatedIndicator(false);
    st.setSystemEventDateTime(Ecfv5XmlHelper.convertProxyDate(LocalDateTime.now()));
    CredentialsAuthenticatedCodeType act = new CredentialsAuthenticatedCodeType();
    act.setValue(CredentialsAuthenticatedCodeSimpleType.AUTHENTICATED);
    st.setCredentialsAuthenticatedCode(act);
    // SystemOperatingModeCodeType mct = new SystemOperatingModeCodeType();
    // mct.setValue(SystemOperatingModeCodeSimpleType.OPS);
    var statusFac = new gov.niem.release.niem.domains.cbrn._4.ObjectFactory();
    st.setSystemOperatingModeAbstract(statusFac.createCredentialsAuthenticatedCode(act));
    st.setResendRequestIndicator(Ecfv5XmlHelper.convertBool(false));
    MessageErrorType okHandling = new MessageErrorType();
    okHandling.setErrorCodeText(Ecfv5XmlHelper.convertText("0"));
    st.setMessageHandlingError(okHandling);
    return st;
  }

  private static MessageStatusType error(
      MessageStatusCodeSimpleType status, String code, String text) {
    MessageStatusType st = common();
    MessageStatusCodeType ct = new MessageStatusCodeType();
    ct.setValue(status);
    st.setMessageStatusCode(ct);
    MessageContentErrorType contentError = new MessageContentErrorType();
    MessageErrorType errType = new MessageErrorType();
    errType.setErrorCodeText(Ecfv5XmlHelper.convertText(code));
    errType.setErrorCodeDescriptionText(Ecfv5XmlHelper.convertText(text));
    contentError.setErrorDescription(errType);
    st.getMessageContentError().add(contentError);
    return null;
  }
}
