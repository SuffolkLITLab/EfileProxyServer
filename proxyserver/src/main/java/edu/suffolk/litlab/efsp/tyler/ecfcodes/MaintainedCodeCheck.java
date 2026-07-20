package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import java.util.List;

// One entry in the hand-maintained list of interview code lookups. Each entry
// mirrors a _filters list from a real interview's efiling.yml
public record MaintainedCodeCheck(
    String jurisdiction,
    String courtCode,
    CodeTable table,
    List<String> filters,
    String sourceInterviewUrl,
    String caseCategoryCode) {

  public enum CodeTable {
    CASE_CATEGORY,
    CASE_TYPE,
    FILING_TYPE,
    DOCUMENT_TYPE,
    MOTION_TYPE,
    FILING_COMPONENT
  }
}
