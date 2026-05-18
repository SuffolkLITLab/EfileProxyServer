package edu.suffolk.litlab.efsp.server.ecf4.tyler;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.OptionalServiceCode;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
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

  public Result<Optional<String>, CodeError> vetLangCode(Optional<String> lang) {
    if (lang.isEmpty()) {
      return Result.ok(Optional.empty());
    }

    List<NameAndCode> langs = cd.getLanguages(this.court.code);
    if (langs.isEmpty()) {
      log.warn(
          "Court {} can't handle any languages; simply dropping the language {}",
          this.court.code,
          lang);
      // This court cannot handle languages.
      return Result.ok(Optional.empty());
    }

    var matchedLang =
        langs.stream().filter(l -> l.getName().equalsIgnoreCase(lang.get())).findFirst();
    if (matchedLang.isEmpty()) {
      log.info("Can't have language: {}", lang);
      return Result.err(
          new NoMatchingCode(lang.get(), langs.stream().map(l -> l.getName()).toList()));
    }
    return Result.ok(matchedLang.map(l -> l.getCode()));
  }

  public Result<Map<String, String>, CrossReferenceError> getCrossRefIds(
      Map<String, String> crossRefs, CaseType caseType) {
    List<CrossReference> refs = cd.getCrossReference(court.code, caseType.code);
    var refMap = refs.stream().collect(Collectors.toMap(r -> r.code, r -> r));
    Set<String> usedCodes = new HashSet<>();
    Map<String, String> ids = new HashMap<>();
    for (var ref : crossRefs.entrySet()) {
      String refKey = ref.getKey();
      String refValue = ref.getValue();
      if (refMap.containsKey(refKey)) {
        CrossReference refData = refMap.get(refKey);
        if (!refData.matchesRegex(refValue)) {
          return Result.err(
              new WrongRefVal(
                  refKey,
                  refValue,
                  refData.validationregex,
                  refData.customvalidationfailuremessage));
        }
        ids.put(refData.code, refValue);
        usedCodes.add(refData.code);
      } else {
        return Result.err(new NoMatchingRef(refKey, refValue));
      }
    }

    Set<String> missingRefs =
        refs.stream()
            .filter(ref -> ref.isrequired && !usedCodes.contains(ref.code))
            .map(ref -> ref.name)
            .collect(Collectors.toSet());
    if (!missingRefs.isEmpty()) {
      return Result.err(new MissingRequiredRefs(missingRefs));
    }
    return Result.ok(ids);
  }

  // TODO: leaving a gap for PartyType related checks.

  // TODO: do good tests here
  public Result<Optional<NameAndCode>, CodeError> vetMotionCode(
      Optional<String> motionCode, Optional<FilingCode> filing) {
    DataFieldRow motionRow = allDataFields.getFieldRow("FilingMotionType");
    if (!motionRow.isvisible) {
      return Result.ok(Optional.empty());
    }
    if (!motionRow.isrequired && motionCode.isEmpty()) {
      return Result.ok(Optional.empty());
    }
    if (filing.isEmpty()) {
      return Result.err(
          new BadCode(FilingError.malformedInterview("Need filing type to handle motion types")));
    }
    List<NameAndCode> motionTypes = cd.getMotionTypes(this.court.code, filing.get().code);
    if (motionCode.isPresent()) {
      String mt = motionCode.get();
      Optional<NameAndCode> matchedMotion =
          motionTypes.stream().filter(m -> m.getCode().equalsIgnoreCase(mt)).findFirst();
      if (matchedMotion.isEmpty()) {
        return Result.err(
            new NoMatchingCode(mt, motionTypes.stream().map(m -> m.getCode()).toList()));
      }
      return Result.ok(matchedMotion);
    } else if (motionRow.isrequired) {
      // TODO(brycew-later): "A motion type may be required for a filing type, and may or may not
      // allow multiple occurances"
      // What does it actually mean? Motion types are empty for most IL courts (not Cook), so IDK
      // what to do if there's nothing there
      return Result.err(
          new RequiredCodeNotPresent(motionTypes.stream().map(m -> m.getCode()).toList()));
    }
    return Result.ok(Optional.empty());
  }

  /**
   * Checks all of the optional services in one go. Can't return OptionalServiceCode, since it
   * doesn't have the selected multiplier / fee amount.
   */
  public Result<List<OptionalService>, List<CodeError>> vetOptionalServices(
      List<InputOptionalService> servs, Optional<FilingCode> filing) {
    if (servs.isEmpty()) {
      return Result.ok(List.of());
    }

    if (filing.isEmpty()) {
      return Result.err(
          List.of(
              new BadCode(
                  FilingError.malformedInterview(
                      "Need to use filing code if you have optional services"))));
    }

    List<OptionalServiceCode> codes = cd.getOptionalServices(this.court.code, filing.get().code);
    Map<String, OptionalServiceCode> codeMap =
        codes.stream().collect(Collectors.toMap(sv -> sv.code, sv -> sv));
    List<CodeError> errs = new ArrayList<>();
    List<OptionalService> opts = new ArrayList<>();
    for (var serv : servs) {
      if (!codeMap.containsKey(serv.code())) {
        errs.add(new NoMatchingCode(serv.code(), codeMap.keySet().stream().toList()));
        continue;
      }
      OptionalServiceCode codeSettings = codeMap.get(serv.code());
      if (codeSettings.hasfeeprompt && serv.feeAmount().isEmpty()) {
        var err =
            FilingError.malformedInterview(
                "Optional service " + serv.code() + " needs a fee amount.");
        errs.add(new BadCode(err));
      }
      if (!codeSettings.hasfeeprompt && serv.feeAmount().isPresent()) {
        var err =
            FilingError.malformedInterview(
                "Optional service "
                    + serv.code()
                    + " doesn't support a fee amount, which was given.");
        errs.add(new BadCode(err));
      }
      if (codeSettings.multiplier == true && serv.multiplier().isEmpty()) {
        var err =
            FilingError.malformedInterview(
                "Optional service " + serv.code() + " needs a multiplier");
        errs.add(new BadCode(err));
      }
      opts.add(new OptionalService(codeSettings, serv.multiplier(), serv.feeAmount()));
    }
    if (errs.isEmpty()) {
      return Result.ok(opts);
    }
    return Result.err(errs);
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
