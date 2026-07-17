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
      Optional<CourtLocationInfo> court = cd.getFullLocationInfo(courtCode);
      if (court.isEmpty()) {
        continue;
      }
      TylerCodesParser parser = new TylerCodesParser(cd, null, court.get(), false);
      parser.checkNeverRequiredFields();
    }
  }

  private void checkKnownCodeLookups() {
    for (MaintainedCodeCheck check : KnownCodeLookups.ALL) {
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
        String actualCode = result.matches().get(0).getCode();
        if (!actualCode.equals(check.expectedDefaultCode())) {
          log.error(
              "Court {} {}: filters {} now resolve to {}, but the interview at {} expects {}",
              check.courtCode(),
              check.table(),
              check.filters(),
              actualCode,
              check.sourceInterviewUrl(),
              check.expectedDefaultCode());
        }
      }
      case NO_MATCH ->
          log.error(
              "Court {} {}: filters {} matched nothing, but the interview at {} expects {}",
              check.courtCode(),
              check.table(),
              check.filters(),
              check.sourceInterviewUrl(),
              check.expectedDefaultCode());
      case AMBIGUOUS ->
          log.error(
              "Court {} {}: filters {} matched more than one code ({}), but the interview at {}"
                  + " expects {}",
              check.courtCode(),
              check.table(),
              check.filters(),
              result.matches(),
              check.sourceInterviewUrl(),
              check.expectedDefaultCode());
    }
  }
}
