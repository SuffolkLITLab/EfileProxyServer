package edu.suffolk.litlab.efspserver.ecf5;

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.Transaction;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.services.MDCWrappers;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;
import edu.suffolk.litlab.efspserver.services.UpdateMessageStatus;
import edu.suffolk.litlab.efspserver.tyler.TylerConstants;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.NameAndCode;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeSimpleType;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeSimpleType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeType;
import gov.niem.release.niem.domains.cbrn._4.MessageContentErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentAugmentationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentRenditionType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.FilingStatusType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ReviewedDocumentType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyFilingReviewCompleteRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyFilingReviewCompleteResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback.NotifyFilingReviewCompleteMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.filingassemblymde.FilingAssemblyMDE;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import javax.sql.DataSource;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CardAccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.ecf.v5_0.extensions.common.AttachmentAugmentationType;
import tyler.ecf.v5_0.extensions.common.FilingStatusAugmentationType;

// TODO(brycew): does this need to become multiple different files, one for each jurisdiction? Can't
// have multiple wsdlLocations

@jakarta.jws.WebService(
    serviceName = "FilingAssemblyMDEService",
    portName = "FilingAssemblyMDEPort",
    targetNamespace = "urn:tyler:efm:wsdl:WebServicesProfile-Implementation-5.0",
    // "Typically, users never use the attribute in their own JWS files":
    // https://docs.oracle.com/cd/E13222_01/wls/docs92/webserv/annotations.html
    // wsdlLocation="file:src/main/resources/wsdl/stage/illinois-v5-FilingAssemblyMDE.wsdl",
    endpointInterface =
        "https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.filingassemblymde.FilingAssemblyMDE")
public class EcfWsCallback implements FilingAssemblyMDE {
  private static Logger log = LoggerFactory.getLogger(EcfWsCallback.class);
  private static final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers
          .ObjectFactory
      wrappersObjFac =
          new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers
              .ObjectFactory();

  private final DataSource userDs;
  private final Supplier<CodeDatabase> cdSupplier;
  private final OrgMessageSender msgSender;

  public EcfWsCallback(
      String jurisdiction,
      String env,
      Supplier<CodeDatabase> cdSupplier,
      DataSource userDs,
      OrgMessageSender msgSender) {
    this.cdSupplier = cdSupplier;
    this.userDs = userDs;
    this.msgSender = msgSender;
  }

  private static String chargeToStr(AllowanceChargeType charge) {
    StringBuilder chargeReason = new StringBuilder();
    String amountText = Ecf5Helper.amountToString(charge.getAmount());
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

  private static String documentToStr(
      ReviewedDocumentType revDoc, FilingStatusType status, CourtLocationInfo courtInfo) {
    if (revDoc == null) {
      return "";
    }
    Optional<String> docDesc = Optional.empty();
    Optional<String> fileName = Optional.empty();
    Optional<String> reviewComments = Optional.empty();
    Optional<String> rejectedReason = Optional.empty();
    docDesc = Ecf5Helper.getNonEmptyText(revDoc.getDocumentDescriptionText());
    for (var aug : revDoc.getDocumentAugmentationPoint()) {
      if (aug.getValue() instanceof DocumentAugmentationType docAug) {
        for (var rest : docAug.getRest()) {
          if (rest.getValue() instanceof DocumentRenditionType renAug) {
            for (var attach : renAug.getAttachment().getObjectAugmentationPoint()) {
              if (attach.getValue() instanceof AttachmentAugmentationType attachAug) {
                fileName = Ecf5Helper.getNonEmptyText(attachAug.getOriginalFileName());
              }
            }
          }
        }
      }
    }
    for (var aug : status.getObjectAugmentationPoint()) {
      if (aug.getValue() instanceof FilingStatusAugmentationType statusAug) {
        reviewComments = Ecf5Helper.getNonEmptyText(statusAug.getReviewCommentsText());
        rejectedReason = Ecf5Helper.getNonEmptyText(statusAug.getRejectReasonCode());
      }
    }
    return TylerConstants.documentToStr(
        docDesc, fileName, reviewComments, rejectedReason, courtInfo);
  }

  private static String reviewedFilingMessageText(
      NotifyFilingReviewCompleteMessageType revFiling,
      FilingStatusType status,
      Transaction trans,
      CourtLocationInfo courtInfo) {
    StringBuilder messageText = new StringBuilder();
    if (revFiling.getLeadDocumentReview() != null) {
      for (var doc : revFiling.getLeadDocumentReview()) {
        if (doc != null) {
          messageText.append(documentToStr(doc.getReviewedDocument(), status, courtInfo));
        }
      }
    }
    if (revFiling.getConnectedDocumentReview() != null) {
      for (var doc : revFiling.getConnectedDocumentReview()) {
        if (doc != null) {
          messageText.append(documentToStr(doc.getReviewedDocument(), status, courtInfo));
        }
      }
    }
    FilingStatusType filingStat = revFiling.getFilingStatus();
    if (filingStat != null) {
      var maybeDesc = Ecf5Helper.getNonEmptyText(filingStat.getStatusDescriptionText());
      maybeDesc.ifPresent(
          desc -> {
            messageText.append('\n').append(desc);
          });
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
      Optional<String> replyCode =
          Ecf5Helper.getNonEmptyText(filingStat.getFilingReviewStatusCode());
      Optional<String> statusText =
          names.stream()
              .filter(nac -> nac.getCode().equalsIgnoreCase(replyCode.orElse("")))
              .map(nac -> nac.getName())
              .findFirst();
      return statusText.orElseGet(
          () -> {
            return replyCode.orElseGet(
                () -> Ecf5Helper.getNonEmptyText(filingStat.getStatusDescriptionText()).orElse(""));
          });
    } else {
      return "unknown";
    }
  }

  private static UpdateMessageStatus reviewedFilingStatusCode(FilingStatusType filingStat) {
    if (filingStat != null) {
      final String replyCode =
          Ecf5Helper.getNonEmptyText(filingStat.getFilingReviewStatusCode()).orElse("");
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
      NotifyFilingReviewCompleteRequestType msg) {
    // The bare minimum: get the Document ID, see if we have it in the db, send email response
    PaymentMessageType payment = msg.getPaymentMessage();
    NotifyFilingReviewCompleteMessageType revFiling = msg.getNotifyFilingReviewCompleteMessage();
    NotifyFilingReviewCompleteResponseType resp =
        wrappersObjFac.createNotifyFilingReviewCompleteResponseType();
    // TODO(brycew): something with setupReplys?
    // This shouldn't happen, but I don't trust this XML BS
    if (payment == null || revFiling == null) {
      log.error(
          "Why did Tyler send us a notifyFilingReviewComplete without either a filing"
              + " review or a payment receipt?");
      log.error(msg.toString());
      resp.setMessageStatus(
          error(
              MessageStatusCodeSimpleType.INVALID_SCHEMA,
              "705",
              "NotifyFilingReviewComplete message not found"));
      return resp;
    }

    // Now for the review filing
    String filingId = "";
    for (IdentificationType id : revFiling.getDocumentIdentification()) {
      if (id.getIdentificationCategoryDescriptionText().getValue().equalsIgnoreCase("envelopeID")) {
        filingId = id.getIdentificationID().getValue();
      }
    }
    if (filingId.isBlank()) {
      log.error(
          "Got back a review filing that has a blank / no FILINGID? "
              + Ecf5Helper.objectToXmlStrOrError(
                  revFiling, NotifyFilingReviewCompleteMessageType.class));
      resp.setMessageStatus(
          error(
              MessageStatusCodeSimpleType.INVALID_SCHEMA,
              "720",
              "Filing code not found in message"));
      return resp;
    }

    String courtIdFromMsg = "";
    var court = revFiling.getCaseCourt();
    if (court != null && court.getOrganizationIdentification() != null) {
      var orgId = court.getOrganizationIdentification().getIdentificationID();
      if (orgId.getValue() != null) {
        courtIdFromMsg = orgId.getValue();
      }
    }

    Optional<Transaction> trans = Optional.empty();
    try (UserDatabase ud = new UserDatabase(userDs.getConnection())) {
      trans = ud.findTransaction(UUID.fromString(filingId));
    } catch (SQLException e) {
      log.error("Couldn't connect to the SQL database to get the transaction: " + e.toString());
      resp.setMessageStatus(error(MessageStatusCodeSimpleType.SYSTEM_ERROR, "-1", "Server error"));
      return resp;
    }
    if (trans.isEmpty()) {
      log.warn("No transaction on record for filingId: " + filingId + " no one to send to");
      resp.setMessageStatus(
          error(
              MessageStatusCodeSimpleType.DATA_ERROR,
              "724",
              "Filing ID " + filingId + " not found"));
      return resp;
    }

    // Handle payment stuff: Address is usually empty, it's all in Payment and AllowanceCharges
    List<String> charges =
        payment.getAllowanceCharge().stream().map(EcfWsCallback::chargeToStr).toList();

    MDC.put(MDCWrappers.SERVER_ID, trans.get().serverId.toString());
    log.info(
        "Full NotifyFilingReviewComplete msg: "
            + Ecf5Helper.objectToXmlStrOrError(msg, NotifyFilingReviewCompleteRequestType.class));

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
        resp.setMessageStatus(
            error(
                MessageStatusCodeSimpleType.DATA_ERROR,
                "70",
                "Location " + courtId + " not found"));
        return resp;
      }
    } catch (SQLException ex) {
      log.error("In ECF v4 callback, couldn't get codes db: " + StdLib.strFromException(ex));
      courtInfo = Optional.of(new CourtLocationInfo());
      courtInfo.get().name = courtId;
    }

    FilingStatusType status = revFiling.getFilingStatus();
    String statusText = reviewedFilingStatusText(revFiling, trans.get());
    String messageText = reviewedFilingMessageText(revFiling, status, trans.get(), courtInfo.get());
    String chargesText = charges.stream().reduce("", (ch1, ch2) -> ch1 + ", " + ch2);
    log.info("Filing status: " + statusText + ";; " + messageText + ";; " + status.toString());

    boolean success =
        msgSender.sendMessage(
            trans.get(),
            reviewedFilingStatusCode(status),
            statusText,
            messageText,
            null,
            courtInfo.get().name,
            caseName,
            chargesText);
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
    resp.setMessageStatus(ok());
    return resp;
  }

  private static MessageStatusType ok() {
    MessageStatusType st = common();
    MessageStatusCodeType ct = new MessageStatusCodeType();
    ct.setValue(MessageStatusCodeSimpleType.SUCCESS);
    st.setMessageStatusCode(ct);
    MessageContentErrorType contentError = new MessageContentErrorType();
    MessageErrorType errType = new MessageErrorType();
    errType.setErrorCodeText(Ecf5Helper.convertText("0"));
    contentError.setErrorDescription(errType);
    st.getMessageContentError().add(contentError);
    return st;
  }

  private static MessageStatusType common() {
    MessageStatusType st = new MessageStatusType();
    st.setSystemSimulatedIndicator(false);
    st.setSystemEventDateTime(Ecf5Helper.convertProxyDate(LocalDateTime.now()));
    CredentialsAuthenticatedCodeType act = new CredentialsAuthenticatedCodeType();
    act.setValue(CredentialsAuthenticatedCodeSimpleType.AUTHENTICATED);
    st.setCredentialsAuthenticatedCode(act);
    // SystemOperatingModeCodeType mct = new SystemOperatingModeCodeType();
    // mct.setValue(SystemOperatingModeCodeSimpleType.OPS);
    var statusFac = new gov.niem.release.niem.domains.cbrn._4.ObjectFactory();
    st.setSystemOperatingModeAbstract(statusFac.createCredentialsAuthenticatedCode(act));
    st.setResendRequestIndicator(Ecf5Helper.convertBool(false));
    MessageErrorType okHandling = new MessageErrorType();
    okHandling.setErrorCodeText(Ecf5Helper.convertText("0"));
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
    errType.setErrorCodeText(Ecf5Helper.convertText(code));
    errType.setErrorCodeDescriptionText(Ecf5Helper.convertText(text));
    contentError.setErrorDescription(errType);
    st.getMessageContentError().add(contentError);
    return st;
  }
}
