package edu.suffolk.litlab.efspserver.ecf5;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest.GetPolicyRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest.PolicyQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetPolicyRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetPolicyResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDE;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PolicyCacher {
  private Map<String, GetPolicyResponseMessageType> policyInMemoryCache;
  private LocalDateTime lastFlushed;

  public PolicyCacher() {
    this.policyInMemoryCache = new ConcurrentHashMap<String, GetPolicyResponseMessageType>();
    this.lastFlushed = LocalDateTime.now();
  }

  public GetPolicyResponseMessageType getPolicyFor(CourtPolicyMDE policyPort, String courtId) {
    if (needToFlushCache()) {
      flushCache();
    }

    if (policyInMemoryCache.containsKey(courtId)) {
      return policyInMemoryCache.get(courtId);
    } else {
      GetPolicyRequestType policyRequest = new GetPolicyRequestType();
      var msg = new GetPolicyRequestMessageType();
      msg.setCaseCourt(Ecf5Helper.convertCourt(courtId));
      msg.setSendingMDELocationID(Ecf5Helper.convertId("https://efile.suffolklitlab.org"));
      msg.setServiceInteractionProfileCode(
          Ecf5Helper.convertNormalizedString(
              "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-5.0"));
      msg.setDocumentPostDate(Ecf5Helper.convertNow());
      msg.getDocumentIdentification().add(Ecf5Helper.convertId("1", "FilingAssembly", "messageID"));
      PolicyQueryCriteriaType pqct = new PolicyQueryCriteriaType();
      msg.setPolicyQueryCriteria(pqct);
      policyRequest.setGetPolicyRequestMessage(msg);

      GetPolicyResponseType p = policyPort.getPolicy(policyRequest);
      policyInMemoryCache.put(courtId, p.getGetPolicyResponseMessage());
      return p.getGetPolicyResponseMessage();
    }
  }

  /**
   * Returns true if the policies need to be flushed, which is 2 am the day after when they were
   * last flushed.
   */
  private boolean needToFlushCache() {
    LocalDateTime toFlush =
        LocalDateTime.of(
                lastFlushed.getYear(), lastFlushed.getMonth(), lastFlushed.getDayOfMonth(), 2, 0, 0)
            .plusDays(1);
    return LocalDateTime.now().isAfter(toFlush);
  }

  private void flushCache() {
    policyInMemoryCache.clear();
    lastFlushed = LocalDateTime.now();
  }
}
