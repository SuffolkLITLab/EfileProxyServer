package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.model.Person;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/** All of the information Tyler sends about a particular case. */
public class CaseResponse {
  List<Person> participants;
  Map<String, Attorney> attorneys;

  CaseCategory caseCategory;
  CaseType caseType;
  String caseTitle;
  LocalDateTime filedDate;
  // TODO(Attorneys)
}
