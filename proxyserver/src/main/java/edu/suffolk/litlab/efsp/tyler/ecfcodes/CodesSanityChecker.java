package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Runs health checks for a single state/jurisdiction. It verifies configuration rules for every
// court,
// and makes sure our hardcoded code lookups actually match what is currently in the database.
public class CodesSanityChecker {

  private static final Logger log = LoggerFactory.getLogger(CodesSanityChecker.class);

  private static final List<String> neverRequiredFields =
      List.of("PartyNameSuffix", "PartyMiddleName");

  // Seed list, pulled from docassemble-MotionToStayEviction's efiling.yml. Add more as they come
  // up.
  private static final List<MaintainedCodeCheck> knownCodeLookups =
      List.of(
          new MaintainedCodeCheck(
              "massachusetts",
              "appeals:acsj",
              MaintainedCodeCheck.CodeTable.CASE_CATEGORY,
              List.of("Appeals Court Single Justice - Civil", "Civil"),
              "https://github.com/SuffolkLITLab/docassemble-MotionToStayEviction/blob/"
                  + "213bd40790525bb45fbc5b012c5649325c7e0bae/docassemble/MotionToStayEviction/"
                  + "data/questions/efiling.yml#L33-L34",
              null),
          new MaintainedCodeCheck(
              "massachusetts",
              "appeals:acsj",
              MaintainedCodeCheck.CodeTable.CASE_TYPE,
              List.of("MAC Rule 6.0"),
              "https://github.com/SuffolkLITLab/docassemble-MotionToStayEviction/blob/"
                  + "213bd40790525bb45fbc5b012c5649325c7e0bae/docassemble/MotionToStayEviction/"
                  + "data/questions/efiling.yml#L36-L38",
              "8151"));

  private final CodeDatabase cd;
  private final String jurisdiction;

  public CodesSanityChecker(CodeDatabase cd, String jurisdiction) {
    this.cd = cd;
    this.jurisdiction = jurisdiction;
  }

  public void runAll() {
    checkNeverRequiredFieldsForAllCourts();
    checkKnownCodeLookups();
  }

  private void checkNeverRequiredFieldsForAllCourts() {
    for (String courtCode : cd.getAllLocations()) {
      if (courtCode.equals("1")) {
        continue;
      }
      DataFields fields = cd.getDataFields(courtCode);
      for (String fieldCode : neverRequiredFields) {
        if (fields.getFieldRow(fieldCode).isrequired) {
          log.error(
              "Court {}: {} is marked required in datafieldconfig, which shouldn't happen",
              courtCode,
              fieldCode);
        }
      }
    }
  }

  private void checkKnownCodeLookups() {
    for (MaintainedCodeCheck check : knownCodeLookups) {
      if (!check.jurisdiction().equals(jurisdiction)) {
        continue;
      }
      List<NameAndCode> options = fetchOptions(check);
      CodeSearchMatcher.MatchResult result =
          CodeSearchMatcher.filterCodes(options, check.filters());
      report(check, result);
    }
  }

  private List<NameAndCode> fetchOptions(MaintainedCodeCheck check) {
    Function<String, List<NameAndCode>> fetch =
        courtCode ->
            switch (check.table()) {
              case CASE_CATEGORY -> cd.getCaseCategoryNames(courtCode);
              case CASE_TYPE ->
                  cd.getCaseTypeNamesFor(courtCode, check.caseCategoryCode(), Optional.empty());
              default ->
                  throw new UnsupportedOperationException(
                      "No lookup wired up yet for "
                          + check.table()
                          + " - add one before seeding an entry for it");
            };

    for (String court : cd.getParentList(check.courtCode())) {
      List<NameAndCode> options = fetch.apply(court);
      if (!options.isEmpty()) {
        return options;
      }
    }
    return List.of();
  }

  private void report(MaintainedCodeCheck check, CodeSearchMatcher.MatchResult result) {
    switch (result.type()) {
      case OK -> {
        // A single match means the interview's search still resolves cleanly(nothing to report)
      }
      case NO_MATCH ->
          log.error(
              "Court {} {}: filters {} matched nothing. See {}",
              check.courtCode(),
              check.table(),
              check.filters(),
              check.sourceInterviewUrl());
      case AMBIGUOUS ->
          log.warn(
              "Court {} {}: filters {} matched more than one code ({}). See {}",
              check.courtCode(),
              check.table(),
              check.filters(),
              result.matches(),
              check.sourceInterviewUrl());
    }
  }
}
