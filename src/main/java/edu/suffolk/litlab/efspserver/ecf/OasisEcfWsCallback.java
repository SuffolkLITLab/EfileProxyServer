package edu.suffolk.litlab.efspserver.ecf;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.Transaction;
import edu.suffolk.litlab.efspserver.UserDatabase;
import edu.suffolk.litlab.efspserver.XmlHelper;
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

public class OasisEcfWsCallback implements FilingAssemblyMDEPort {
  private static Logger log = 
      LoggerFactory.getLogger(OasisEcfFiler.class); 
  
  private ObjectFactory recepitFac;
  private UserDatabase ud;
  private OrgMessageSender msgSender;
  
  public OasisEcfWsCallback(UserDatabase ud, OrgMessageSender msgSender) {
    recepitFac = new ObjectFactory();
    this.ud = ud;
    this.msgSender = msgSender;
  }

  
  public MessageReceiptMessageType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestMessageType msg) {
    // TODO(brycew): implement this here, hook it up
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
    // TODO(brycew): there is a Payment ID that we should save when handling payments
    // Skip for now: shouldn't be getting those
    
    // Now for the review filing
    revFiling.getCase().getValue();
    revFiling.getFilingStatus();
    List<IdentificationType> ids = revFiling.getDocumentIdentification();
    String filingId = "";
    for (IdentificationType id : ids) {
      TextType category = (TextType) (id.getIdentificationCategory().getValue());
      if (category.getValue().toUpperCase().equals("FILINGID")) {
        filingId = id.getIdentificationID().getValue();
      }
      // TODO(brycew): do we need to do anything with the parent envelope or filing ID?
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
      boolean success = msgSender.sendMessage(trans.get(), revFiling.getFilingStatus().getStatusText().getValue());
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MessageReceiptMessageType notifyServiceComplete(
      ServiceCallbackMessageType serviceCallbackMessage) {
    // TODO Auto-generated method stub
    return null;
  }
}
