package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.UUID;

import edu.suffolk.litlab.efspserver.Person;

public class FilingResult {
  public final String caseId;
  public final String envelopeId;
  public final List<UUID> filingIds;
  public final Person leadContact;
  
  
  public FilingResult(String caseId, String envelopeId, List<UUID> filingIds, Person leadContact) {
    this.caseId = caseId;
    this.envelopeId = envelopeId;
    this.filingIds = filingIds;
    this.leadContact = leadContact;
  }
  
  public FilingResult(List<UUID> filingIds, Person leadContact) {
    this("", "", filingIds, leadContact);
  }

}
