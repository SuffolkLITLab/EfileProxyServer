package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/** All of the information Tyler sends about a particular case. */
public record CaseResponse(
    List<LegalPerson> participants,
    Map<String, Attorney> attorneys,
    CaseCategory caseCategory,
    CaseType caseType,
    String caseTitle,
    LocalDateTime filedDate,
    String docketId, // the docket number
    String trackingId, // the internal court / tyler tracking number
    String courtCode,
    List<String> caseLineage, // a list of each case tracking id string (contains itself)
    boolean hasUserFiledIntoCase // ? new but probably useful
  ) {}
