package edu.suffolk.litlab.efspserver.ecf4;

import jakarta.annotation.Nullable;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;

public class CoreMessageAndNames {
  public final CoreFilingMessageType cfm;
  public final @Nullable String existingCaseTitle;
  public final String caseCategoryName;
  public final String courtName;

  public CoreMessageAndNames(
      CoreFilingMessageType cfm, String caseTitle, String caseCategoryName, String courtName) {
    this.cfm = cfm;
    this.existingCaseTitle = caseTitle;
    this.caseCategoryName = caseCategoryName;
    this.courtName = courtName;
  }
}
