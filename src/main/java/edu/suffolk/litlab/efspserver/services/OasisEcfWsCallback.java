package edu.suffolk.litlab.efspserver.services;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.NotifyFilingReviewCompleteRequestMessageType;

@javax.jws.WebService(name = "FilingReviewMDE" serviceName = "FilingReviewMDEService")
public class OasisEcfWsCallback {

  
  public MessageReceiptMessageType notifyFilingReviewComplete(
      NotifyFilingReviewCompleteRequestMessageType msg) {
    // TODO(brycew): implement this here, hook it up
    return null;
  }
}
