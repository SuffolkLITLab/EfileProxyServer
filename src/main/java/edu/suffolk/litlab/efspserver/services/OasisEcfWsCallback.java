package edu.suffolk.litlab.efspserver.services;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.NotifyFilingReviewCompleteRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingAssemblyMDEPort;
import tyler.ecf.extensions.eventcallbackmessage.EventCallbackMessageType;
import tyler.ecf.extensions.servicecallbackmessage.ServiceCallbackMessageType;

public class OasisEcfWsCallback implements FilingAssemblyMDEPort {

  
  public MessageReceiptMessageType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestMessageType msg) {
    // TODO(brycew): implement this here, hook it up
    return null;
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
