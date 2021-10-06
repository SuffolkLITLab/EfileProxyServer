package edu.suffolk.litlab.efspserver.ecf;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.db.Transaction;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.ObjectFactory;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ReviewFilingCallbackMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.NotifyFilingReviewCompleteRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingAssemblyMDEPort;
import tyler.ecf.extensions.eventcallbackmessage.EventCallbackMessageType;
import tyler.ecf.extensions.servicecallbackmessage.ServiceCallbackMessageType;

@javax.jws.WebService(
    serviceName=  "FilingAssemblyMEDService",
    portName="FilingAssemblyMDEPort",
    targetNamespace="urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0",
    wsdlLocation="file:src/main/resources/wsdl/filingreview/ECF-4.0-FilingAssemblyMDEService.wsdl",
    endpointInterface="oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingAssemblyMDEPort")
public class OasisEcfWsCallback implements FilingAssemblyMDEPort {
  private static Logger log =
      LoggerFactory.getLogger(OasisEcfFiler.class);

  private ObjectFactory recepitFac;
  private UserDatabase ud;
  private CodeDatabase cd;
  private OrgMessageSender msgSender;

  public OasisEcfWsCallback(UserDatabase ud, CodeDatabase cd, OrgMessageSender msgSender) {
    recepitFac = new ObjectFactory();
    this.ud = ud;
    this.cd = cd;
    this.msgSender = msgSender;
  }

  public MessageReceiptMessageType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestMessageType msg) {
    log.info("Full NotifyFilingReviewComplete msg" + msg);
    // The bare minimum: get the Document ID, see if we have it in the db, send email response
    PaymentMessageType payment = msg.getPaymentReceiptMessage();
    ReviewFilingCallbackMessageType revFiling = msg.getReviewFilingCallbackMessage();
    MessageReceiptMessageType reply = recepitFac.createMessageReceiptMessageType();
    ServiceHelpers.setupReplys(reply);
    // This shouldn't happen, but I don't trust this XML BS
    if (payment == null || revFiling == null) {
      log.error("Why did Tyler send us a notifyFilingReviewComplete without either a filing"
          + " review or a payment receipt?");
      log.error(msg.toString());
      ErrorType err = new ErrorType();
      err.setErrorCode(XmlHelper.convertText("-1"));
      err.setErrorText(XmlHelper.convertText("notifyFilingReviewComplete without a filing review or payment receipt"));
      reply.getError().add(err);
      return reply;
    }

    // Handle payment stuff first
    // TODO(#64): there is a Payment ID that we should save when handling payments
    // Skip for now: shouldn't be getting those


    // Now for the review filing
    revFiling.getCase().getValue();
    revFiling.getFilingStatus();
    List<IdentificationType> ids = revFiling.getDocumentIdentification();
    String filingId = "";
    for (IdentificationType id : ids) {
      TextType category = (TextType) (id.getIdentificationCategory().getValue());
      if (category.getValue().equalsIgnoreCase("FILINGID")) {
        filingId = id.getIdentificationID().getValue();
      }
      // TODO(brycew-later): do we need to do anything with the parent envelope?
      // Maybe check them as well? But the filingId should be the same overall, and we'll save
      // most of them.
    }
    if (filingId.isBlank()) {
      log.error("Got back a review filing that has a blank / no FILINGID?!");
      log.error(revFiling.toString());
      return reply;
    }
    try {
      Optional<Transaction> trans = ud.findTransaction(UUID.fromString(filingId));
      if (trans.isEmpty()) {
        log.warn("No transaction on record for filingId: " + filingId);
        return reply;
      }
      reply.setCaseCourt(XmlHelper.convertCourtType(trans.get().courtId));
      List<NameAndCode> names = cd.getFilingStatuses(trans.get().courtId);
      String replyCode = revFiling.getFilingStatus().getStatusText().getValue();
      Optional<String> statusText = names.stream()
          .filter(nac -> nac.getCode().equalsIgnoreCase(replyCode))
          .map(nac -> nac.getName()).findFirst();
      Map<String, String> statuses = Map.of(
          "status", statusText.orElse(replyCode),
          "message_text", revFiling.getFilingStatus().getStatusDescriptionText().stream().reduce("", (des, tt) -> des + tt.getValue(), (des1, des2) -> des1 + des2)
          );
      boolean success = msgSender.sendMessage(trans.get(), statuses);
      if (!success) {
        log.error("Couldn't properly send message to " + trans.get().name + "!");
      }
      return reply;
    } catch (SQLException e) {
      log.error("Couldn't connect to the SQL database to get the transaction: " + e.toString());
      return reply;
    }
  }

  @Override
  public MessageReceiptMessageType notifyEvent(EventCallbackMessageType eventCallbackMessage) {
    log.info("Full NotifyEvent msg" + eventCallbackMessage);
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MessageReceiptMessageType notifyServiceComplete(
      ServiceCallbackMessageType serviceCallbackMessage) {
    log.info("Full NotifyServiceComplete msg" + serviceCallbackMessage);
    // TODO Auto-generated method stub
    return null;
  }
}
