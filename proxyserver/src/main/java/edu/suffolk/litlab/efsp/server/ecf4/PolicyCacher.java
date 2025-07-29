package edu.suffolk.litlab.efsp.server.ecf4;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;

public class PolicyCacher {
  public PolicyCacher() {
    this.policyInMemoryCache = new ConcurrentHashMap<String, CourtPolicyResponseMessageType>();
    this.lastFlushed = LocalDateTime.now();
  }

  public CourtPolicyResponseMessageType getPolicyFor(
      FilingReviewMDEPort filingPort, String courtId) {
    if (needToFlushCache()) {
      flushCache();
    }

    if (policyInMemoryCache.containsKey(courtId)) {
      return policyInMemoryCache.get(courtId);
    } else {
      CourtPolicyQueryMessageType policyQuery =
          Ecf4Helper.prep(new CourtPolicyQueryMessageType(), courtId);
      CourtPolicyResponseMessageType p = filingPort.getPolicy(policyQuery);
      policyInMemoryCache.put(courtId, p);
      return p;
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

  private Map<String, CourtPolicyResponseMessageType> policyInMemoryCache;
  private LocalDateTime lastFlushed;
}
