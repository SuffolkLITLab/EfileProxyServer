package edu.suffolk.litlab.efspserver.services;

import edu.suffolk.litlab.efspserver.Person;
import java.util.List;
import java.util.UUID;

public class FilingResult {
  public final String caseId;
  public final String envelopeId;
  public final List<UUID> filingIds;
  public final Person leadContact;
  public final String caseTitle;
  public final String caseCategoryName;
  public final String courtName;

  public FilingResult(
      String caseId,
      String envelopeId,
      List<UUID> filingIds,
      Person leadContact,
      String caseTitle,
      String caseCategoryName,
      String courtName) {
    this.caseId = caseId;
    this.envelopeId = envelopeId;
    this.filingIds = filingIds;
    this.leadContact = leadContact;
    this.caseTitle = caseTitle;
    this.caseCategoryName = caseCategoryName;
    this.courtName = courtName;
  }

  public FilingResult(List<UUID> filingIds, Person leadContact) {
    this("", "", filingIds, leadContact, "", "", "");
  }
}
