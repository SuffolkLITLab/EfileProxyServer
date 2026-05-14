package edu.suffolk.litlab.efsp.server.ecf4.tyler;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All of the Tyler code specific conversions and logic checks from our objects (really light
 * wrappers over the JSON objects).
 *
 * <p>The `vetXYZ` functions here check that the given inputs work with Tyler's expectations. They
 * return Results; ok for this is good, and an error (with the specific typed-reason) when it will
 * be rejected.
 */
public class TylerCodesParser implements CodesParser {
  private static Logger log = LoggerFactory.getLogger(TylerCodesParser.class);
  private final CodeDatabase cd;
  private final CourtLocationInfo court;
  private final DataFields allDataFields;

  public TylerCodesParser(CodeDatabase cd, CourtLocationInfo court, DataFields allDataFields) {
    this.cd = cd;
    this.court = court;
    this.allDataFields = allDataFields;
  }

  public TylerCodesParser(CodeDatabase cd, CourtLocationInfo court) {
    this(cd, court, cd.getDataFields(court.code));
  }

  public Optional<TylerCodesParser> makeParser(CodeDatabase cd, String courtId) {
    Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId);
    return locationInfo.map(li -> new TylerCodesParser(cd, li));
  }

  /////////////////// Methods that access the codes database.

  public Result<CaseCategory, CodeError> vetCaseCat(String caseCategoryCode) {
    Optional<CaseCategory> maybeCaseCat =
        cd.getCaseCategoryWithCode(this.court.code, caseCategoryCode);
    if (maybeCaseCat.isEmpty()) {
      List<CaseCategory> categories = cd.getCaseCategoriesFor(court.code);
      return Result.err(
          new NoMatchingCode(caseCategoryCode, categories.stream().map(cat -> cat.code).toList()));
    }
    return Result.ok(maybeCaseCat.get());
  }

  public Result<CaseType, CodeError> vetCaseType(
      String caseTypeCode, CaseCategory caseCategory, boolean isInitialFiling) {
    List<CaseType> caseTypes = cd.getCaseTypesFor(court.code, caseCategory.code, Optional.empty());
    if (caseTypes.isEmpty()) {
      var err =
          FilingError.serverError(
              "There are no caseTypes for " + court.code + " and " + caseCategory.code);
      return Result.err(new BadCode(err));
    }

    Optional<CaseType> maybeType =
        caseTypes.stream().filter(type -> type.code.equals(caseTypeCode)).findFirst();
    if (maybeType.isEmpty()) {
      List<String> options = caseTypes.stream().map(type -> type.code).toList();
      return Result.err(new NoMatchingCode(caseTypeCode, options));
    }

    CaseType type = maybeType.get();
    // Check if the court doesn't handle this type (initial vs subsequent) of filing
    if (isInitialFiling && (!type.initial || !court.initial)) {
      var err =
          FilingError.malformedInterview(
              "An Initial filing can't be filed at "
                  + court.name
                  + " or be of filing type "
                  + type.name);
      return Result.err(new BadCode(err));
    } else if (!isInitialFiling && (!court.subsequent)) {
      var err =
          FilingError.malformedInterview("A Subsequent filing can't be filed at " + court.name);
      return Result.err(new BadCode(err));
    }

    return Result.ok(maybeType.get());
  }

  // TODO(brycew): should this be CodeError?
  public Result<Optional<NameAndCode>, NoMatchingCode> vetSubType(
      String subtypeCode, CaseType caseType) {
    DataFieldRow subTypeConfig = allDataFields.getFieldRow("CaseInformationCaseSubType");
    if (subTypeConfig.isvisible) {
      List<NameAndCode> subTypes = cd.getCaseSubtypesFor(this.court.code, caseType.code);
      Optional<NameAndCode> maybeSubtype =
          subTypes.stream().filter(type -> type.getCode().equals(subtypeCode)).findFirst();

      if (!maybeSubtype.isPresent() && subTypeConfig.isrequired) {
        List<String> options = subTypes.stream().map(nac -> nac.getCode()).toList();
        return Result.err(new NoMatchingCode(subtypeCode, options));
      }
      return Result.ok(maybeSubtype);
    }
    return Result.ok(Optional.empty());
  }

  public Result<List<FilingCode>, BadCode> retrieveFilingOptions(
      CaseCategory caseCategory, CaseType type, boolean isInitialFiling) {
    List<FilingCode> filingOptions =
        cd.getFilingType(court.code, caseCategory.code, type.code, isInitialFiling);
    if (filingOptions.isEmpty()) {
      return Result.err(
          new BadCode(
              FilingError.malformedInterview(
                  "Need a filing type! FilingTypes are empty, so "
                      + caseCategory
                      + " and "
                      + type
                      + " are restricted")));
    }
    return Result.ok(filingOptions);
  }

  public Result<Optional<FilingCode>, CodeError> vetFilingType(
      Optional<String> filingStr,
      /** Pass in so we only need to make 1 expensive DB query */
      List<FilingCode> filingOptions) {
    if (filingStr.isEmpty()) {
      return Result.err(
          new RequiredCodeNotPresent(filingOptions.stream().map(f -> f.code).toList()));
    }
    Optional<FilingCode> maybeCode =
        filingOptions.stream().filter(fil -> fil.code.equals(filingStr.get())).findFirst();

    if (maybeCode.isEmpty()) {
      log.error("Nothing matches filing `{}` in the info!", filingStr);
      List<String> options = filingOptions.stream().map(f -> f.code).toList();
      return Result.err(new NoMatchingCode(filingStr.get(), options));
    }
    return Result.ok(maybeCode);
  }

  public Result<String, CodeError> vetSuffix(Optional<String> maybeSuffix) {
    DataFieldRow suffixRow = allDataFields.getFieldRow("PartyNameSuffix");
    if (suffixRow.isvisible) {
      List<NameAndCode> suffixes = cd.getNameSuffixes(this.court.code);
      if ((maybeSuffix.isEmpty() || maybeSuffix.get().isBlank()) && suffixRow.isrequired) {
        // TODO(brycew-later):
        log.error(
            "DEV WARNING: Court {}: WHY would you ever require a suffix? There aren't empty suffix codes at all.",
            this.court.code);
      }
      String suffix = maybeSuffix.orElse("");
      Optional<NameAndCode> suffixMatch =
          suffixes.stream().filter(s -> s.getName().equalsIgnoreCase(suffix)).findFirst();
      if (suffixMatch.isEmpty()) {
        return Result.err(
            new NoMatchingCode(suffix, suffixes.stream().map(s -> s.getName()).toList()));
      } else {
        return Result.ok(suffixMatch.get().getName());
      }
    }
    return Result.ok(maybeSuffix.orElse(""));
  }

  /**
   * Doesn't return optional because we can set the People names to null / blank.
   *
   * @param name
   * @param row
   * @return
   */
  private Result<String, TextVarError> vetName(Optional<String> maybeName, DataFieldRow row) {
    var name = maybeName.orElse("");
    if (!row.matchRegex(name)) {
      return Result.err(new WrongVar(name, row.regularexpression));
    }
    if (name.length() > 100) {
      return Result.err(new TooLongVar(name, 100));
    }
    return Result.ok(name);
  }

  public Result<String, TextVarError> vetFirstName(Optional<String> name) {
    var dataField = allDataFields.getFieldRow("PartyFirstName");
    if (name.isEmpty() || name.get().isBlank()) {
      return Result.err(new MissingVar(dataField.regularexpression));
    }
    return vetName(name, dataField);
  }

  public Result<String, TextVarError> vetMiddleName(Optional<String> name) {
    return vetName(name, allDataFields.getFieldRow("PartyMiddleName"));
  }

  public Result<String, TextVarError> vetLastName(Optional<String> name) {
    return vetName(name, allDataFields.getFieldRow("PartyLastName"));
  }
}
