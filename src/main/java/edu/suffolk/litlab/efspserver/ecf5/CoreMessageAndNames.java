package edu.suffolk.litlab.efspserver.ecf5;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.FilingMessageType;
import jakarta.annotation.Nullable;

public class CoreMessageAndNames {
  public final FilingMessageType filingMsg;
  public final @Nullable String existingCaseTitle;
  public final String caseCategoryName;
  public final String courtName;

  public CoreMessageAndNames(
      FilingMessageType filingMsg, String caseTitle, String caseCategory, String courtName) {
    this.filingMsg = filingMsg;
    this.existingCaseTitle = caseTitle;
    this.caseCategoryName = caseCategory;
    this.courtName = courtName;
  }
}
