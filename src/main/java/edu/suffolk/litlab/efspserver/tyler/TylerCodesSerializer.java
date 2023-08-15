package edu.suffolk.litlab.efspserver.tyler;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efspserver.FilingAction;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.LowerCourtInfo;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.OptionalService;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.tyler.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.tyler.codes.CaseType;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.ComboCaseCodes;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.CrossReference;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFields;
import edu.suffolk.litlab.efspserver.tyler.codes.DocumentTypeTableRow;
import edu.suffolk.litlab.efspserver.tyler.codes.FileType;
import edu.suffolk.litlab.efspserver.tyler.codes.FilerType;
import edu.suffolk.litlab.efspserver.tyler.codes.FilingCode;
import edu.suffolk.litlab.efspserver.tyler.codes.FilingComponent;
import edu.suffolk.litlab.efspserver.tyler.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.tyler.codes.OptionalServiceCode;
import edu.suffolk.litlab.efspserver.tyler.codes.PartyType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All of the Tyler code specific conversions and logic checks from our objects (really light
 * wrappers over the JSON objects).
 *
 * <p>The `vetXYZ` functions here check that the given inputs work with Tyler's expectations.
 */
public class TylerCodesSerializer {
  private static Logger log = LoggerFactory.getLogger(TylerCodesSerializer.class);
  private final CodeDatabase cd;
  private final CourtLocationInfo court;
  private final DataFields allDataFields;

  public TylerCodesSerializer(CodeDatabase cd, CourtLocationInfo court, DataFields allDataFields) {
    this.cd = cd;
    this.court = court;
    this.allDataFields = allDataFields;
  }

  public TylerCodesSerializer(CodeDatabase cd, CourtLocationInfo court) {
    this(cd, court, cd.getDataFields(court.code));
  }

  /**
   * Given the case info from a case that's already in the court's system on a subsequent filing.
   */
  public ComboCaseCodes serializeCaseCodesIndexedRaw(
      String caseCategoryCode,
      String caseTypeCode,
      List<String> filingCodeStrs,
      Map<String, Person> existingParties,
      Map<String, Person> newParties,
      InfoCollector collector)
      throws FilingError {
    CaseCategory caseCategory =
        vetCaseCat(cd.getCaseCategoryWithKey(this.court.code, caseCategoryCode), collector);
    List<CaseType> caseTypes = cd.getCaseTypesFor(court.code, caseCategory.code, Optional.empty());
    Optional<CaseType> maybeType = cd.getCaseTypeWith(court.code, caseTypeCode);
    CaseType type = vetCaseType(maybeType, caseTypes, caseCategory, collector, false);
    List<FilingCode> filingRealCodes =
        vetFilingTypes(filingCodeStrs, caseCategory, type, collector, false);
    Map<String, Pair<PartyType, Boolean>> partyTypes =
        vetPartyTypes(existingParties, newParties, type);
    return new ComboCaseCodes(caseCategory, type, filingRealCodes, partyTypes);
  }

  /** Either an initial filing, or a non-indexed case. */
  public ComboCaseCodes serializeCaseCodes(
      FilingInformation info, InfoCollector collector, boolean isInitialFiling) throws FilingError {
    Optional<CaseCategory> maybeCaseCat =
        cd.getCaseCategoryWithKey(this.court.code, info.getCaseCategoryCode());
    CaseCategory caseCategory = vetCaseCat(maybeCaseCat, collector);

    List<CaseType> caseTypes = cd.getCaseTypesFor(court.code, caseCategory.code, Optional.empty());
    Optional<CaseType> maybeType =
        caseTypes.stream().filter(type -> type.code.equals(info.getCaseTypeCode())).findFirst();
    CaseType type = vetCaseType(maybeType, caseTypes, caseCategory, collector, isInitialFiling);

    if (!type.initial && info.getCaseDocketNumber().isEmpty()) {
      FilingError err =
          FilingError.malformedInterview(
              "Subsequent filing case type ("
                  + type.code
                  + ") needs docket number, but not present");
      collector.error(err);
    }

    int idx = 0;
    for (var filing : info.getFilings()) {
      collector.pushAttributeStack("al_court_bundle[" + idx + "]");
      if (filing.getFilingCode().isEmpty()) {
        InterviewVariable filingVar =
            collector.requestVar("filing_type", "What filing type is this?", "text");
        collector.addRequired(filingVar);
      }
      idx += 1;
      collector.popAttributeStack();
    }
    List<String> filingCodeStrs =
        info.getFilings().stream().map(f -> f.getFilingCode().orElse("")).toList();
    List<FilingCode> filingCodes =
        vetFilingTypes(filingCodeStrs, caseCategory, type, collector, isInitialFiling);
    Map<String, Person> partyInfo =
        Stream.concat(info.getNewPlaintiffs().stream(), info.getNewDefendants().stream())
            .collect(Collectors.toMap(per -> per.getIdString(), per -> per));
    Map<String, Pair<PartyType, Boolean>> partyTypes = vetPartyTypes(Map.of(), partyInfo, type);
    return new ComboCaseCodes(caseCategory, type, filingCodes, partyTypes);
  }

  private CaseCategory vetCaseCat(Optional<CaseCategory> caseCat, InfoCollector collector)
      throws FilingError {
    if (caseCat.isEmpty()) {
      List<CaseCategory> categories = cd.getCaseCategoriesFor(court.code);
      // TODO(brycew-later): handle that these variables could be different from different
      // deserializers
      InterviewVariable var =
          collector.requestVar(
              "efile_case_category",
              "",
              "choice",
              categories.stream().map(cat -> cat.code).toList());
      collector.addWrong(var);
      // Foundational error: Category is sorely needed
      throw FilingError.wrongValue(var);
    }
    return caseCat.get();
  }

  private CaseType vetCaseType(
      Optional<CaseType> maybeType,
      List<CaseType> caseTypes,
      CaseCategory caseCategory,
      InfoCollector collector,
      boolean isInitialFiling)
      throws FilingError {
    if (caseTypes.isEmpty()) {
      FilingError err =
          FilingError.serverError(
              "There are no caseTypes for " + court.code + " and " + caseCategory.code);
      collector.error(err);
    }
    if (maybeType.isEmpty()) {
      InterviewVariable var =
          collector.requestVar(
              "efile_case_type", "", "choice", caseTypes.stream().map(type -> type.name).toList());
      collector.addWrong(var);
      throw FilingError.wrongValue(var);
    }
    CaseType type = maybeType.get();
    // Check if the court doesn't handle this type (initial vs subsequent) of filing
    if (isInitialFiling && (!type.initial || !court.initial)) {
      FilingError err =
          FilingError.malformedInterview(
              "An Initial"
                  + " filing can't be filed at "
                  + court.name
                  + " or be of filing type "
                  + type.name);
      collector.error(err);
    } else if (!isInitialFiling && (!court.subsequent)) {
      FilingError err =
          FilingError.malformedInterview(
              "An Subsequent" + " filing can't be filed at " + court.name);
      collector.error(err);
    }

    return maybeType.get();
  }

  public Optional<String> vetSubType(
      String caseSubtypeCode, String caseTypeCode, InfoCollector collector) throws FilingError {
    DataFieldRow subTypeConfig = allDataFields.getFieldRow("CaseInformationCaseSubType");
    if (subTypeConfig.isvisible) {
      List<NameAndCode> subTypes = cd.getCaseSubtypesFor(this.court.code, caseTypeCode);
      Optional<NameAndCode> maybeSubtype =
          subTypes.stream().filter(type -> type.getCode().equals(caseSubtypeCode)).findFirst();

      if (!maybeSubtype.isPresent() && subTypeConfig.isrequired) {
        InterviewVariable subTypeVar =
            collector.requestVar(
                "efile_case_subtype",
                "Sub type of the case",
                "choices",
                subTypes.stream().map(nac -> nac.getName()).toList());
        collector.addWrong(subTypeVar);
      }
      return maybeSubtype.map(s -> s.getCode());
    }
    return Optional.empty();
  }

  private List<FilingCode> vetFilingTypes(
      List<String> maybeCodeStrs,
      CaseCategory caseCategory,
      CaseType type,
      InfoCollector collector,
      boolean isInitialFiling)
      throws FilingError {
    List<FilingCode> filingOptions =
        cd.getFilingType(court.code, caseCategory.code, type.code, isInitialFiling);
    List<Optional<FilingCode>> maybeCodes =
        maybeCodeStrs.stream()
            .map(
                code -> {
                  return filingOptions.stream().filter(fil -> fil.code.equals(code)).findFirst();
                })
            .toList();

    collector.pushAttributeStack("al_court_bundle[i]");
    if (filingOptions.isEmpty()) {
      log.error(
          "Need a filing type! FilingTypes are empty, so "
              + caseCategory
              + " and "
              + type
              + " are restricted");
      InterviewVariable var =
          collector.requestVar("filing_type", "What type of filing is this?", "text");
      collector.addWrong(var);
      collector.popAttributeStack();
      // Is foundational, so returning now
      throw FilingError.wrongValue(var);
    }
    collector.popAttributeStack();

    if (maybeCodes.stream().anyMatch(f -> f.isEmpty())) {
      log.error("Nothing matches filing in the info!");
      int idx = 0;
      for (var maybeCode : maybeCodes) {
        if (maybeCode.isEmpty()) {
          collector.pushAttributeStack("al_court_bundle[" + idx + "]");
          var filingVar =
              collector.requestVar(
                  "filing_type",
                  "What filing type is this? (can't be " + maybeCodeStrs.get(idx) + ")",
                  "text",
                  filingOptions.stream().map(f -> f.code).toList());
          collector.addWrong(filingVar);
          collector.popAttributeStack();
          throw FilingError.missingRequired(filingVar);
        }
        idx += 1;
      }
    }

    return maybeCodes.stream().map(f -> f.get()).toList();
  }

  /**
   * Throws if something is wrong; otherwise, an optional email (empty does not mean error!).
   *
   * <p>Note that the collector type is what determines if it throws.
   *
   * @param email
   * @param collector
   * @return
   * @throws FilingError
   */
  public Optional<String> vetEmail(Optional<String> email, InfoCollector collector)
      throws FilingError {
    DataFieldRow emailRow = allDataFields.getFieldRow("PartyEmail");
    if (emailRow.isvisible) {
      InterviewVariable var =
          collector.requestVar(
              "email", "Email (regex is " + emailRow.regularexpression.toString() + ")", "email");
      if (email.isPresent()) {
        if (!emailRow.matchRegex(email.get())) {
          collector.addWrong(var);
        }
      } else if (emailRow.isrequired) {
        collector.addRequired(var);
      }
    }
    return email;
  }

  public List<String> vetPhoneNumbers(List<String> numbers, InfoCollector collector)
      throws FilingError {
    DataFieldRow phoneRow = allDataFields.getFieldRow("PartyPhone");
    if (phoneRow.isvisible) {
      InterviewVariable var = collector.requestVar("phone_number", "Phone number", "text");
      if (phoneRow.isrequired && numbers.isEmpty()) {
        collector.addRequired(var);
      }
      List<String> newNumbers = new ArrayList<>();
      for (String phoneNumber : numbers) {
        if (!phoneRow.matchRegex(phoneNumber)) {
          if (phoneNumber.contains("-")) {
            // HACK(brycew): Massachusetts doesn't like dashes in the number, just numbers
            phoneNumber = phoneNumber.replace("-", "").replace("(", "").replace(")", "");
          }
          if (!phoneRow.matchRegex(phoneNumber)) {
            collector.addWrong(var);
          }
        }
        newNumbers.add(phoneNumber);
      }
      return newNumbers;
    }
    return numbers;
  }

  /**
   * Get if we need to add an association between filings and case parties. Is simply a boolean
   * because there's no filing error that needs to be swallowed.
   *
   * @return
   */
  public boolean useFilingAssociations() {
    return allDataFields.getFieldRow("FilingEventCaseParties").isrequired;
  }

  public Optional<Map<PartyId, List<String>>> vetPartyAttorneyMap(
      Map<PartyId, List<String>> partyAttyMap,
      Map<String, ? extends Object> partyIdToRefObj,
      InfoCollector collector)
      throws FilingError {
    DataFieldRow attRow = allDataFields.getFieldRow("PartyAttorney");
    for (Map.Entry<PartyId, List<String>> partyAttys : partyAttyMap.entrySet()) {
      log.info("Setting Attorneys for : " + partyAttys.getKey());
      if (partyIdToRefObj.isEmpty()) {
        log.warn(
            "No current filing parties, but "
                + partyAttys.getKey().getIdString()
                + " is in the current filing?");
        continue;
      } else if (!partyIdToRefObj.containsKey(partyAttys.getKey().getIdString())) {
        log.warn(
            "Can't handle current filing participant ("
                + partyAttys.getKey().getIdString()
                + ") not already added?!");
        continue;
      }
      if (!attRow.isvisible) {
        continue;
      }
      if (partyAttys.getValue().isEmpty()) {
        // Is Self-Represented
        if (attRow.isrequired) {
          InterviewVariable var =
              collector.requestVar(
                  "party_to_attorney", "Attorneys are required for this court", "DADict");
          collector.addRequired(var);
        }
      } else {
        if (!this.court.allowmultipleattorneys && partyAttys.getValue().size() > 1) {
          FilingError err =
              FilingError.malformedInterview(
                  "Court " + this.court + " doesn't allow multiple lawyers per case party.");
          collector.error(err);
        }
      }
    }
    if (!attRow.isvisible) {
      return Optional.empty();
    }

    return Optional.of(partyAttyMap);
  }

  public Optional<FilerType> vetFilerTypes(JsonNode miscInfo, InfoCollector collector)
      throws FilingError {
    DataFieldRow filertype = allDataFields.getFieldRow("FilingFilerType");
    if (filertype.isvisible) {
      List<FilerType> allTypes = cd.getFilerTypes(this.court.code);
      String filerTypeName = "filer_type";
      JsonNode filerTypeNode = miscInfo.get(filerTypeName);
      InterviewVariable var =
          collector.requestVar(
              filerTypeName,
              "Metadata about the filer of this case",
              "choices",
              allTypes.stream().map(t -> t.name).toList());
      // TODO(brycew) is this ever required?
      if (filerTypeNode != null && filerTypeNode.isTextual()) {
        String filerType = filerTypeNode.asText();
        Optional<FilerType> typeInfo =
            allTypes.stream().filter(t -> t.name.equalsIgnoreCase(filerType)).findFirst();
        if (typeInfo.isEmpty()) {
          collector.addWrong(var);
        }
        return typeInfo;
      } else {
        Optional<FilerType> defaultType = allTypes.stream().filter(t -> t.isDefault).findFirst();
        if (defaultType.isEmpty()) {
          collector.addRequired(var);
        }
        return defaultType;
      }
    }
    return Optional.empty();
  }

  public Optional<LowerCourtInfo> vetLowerCourtInfo(
      Optional<LowerCourtInfo> lowerCourtInfo, InfoCollector collector) throws FilingError {
    if (lowerCourtInfo.isEmpty()) {
      InterviewVariable lowerCourtVar =
          collector.requestVar(
              "lower_court_case",
              "The details of the lower court case, including the docke number, judge name, title,"
                  + " and trial court code.",
              "object");
      collector.addRequired(lowerCourtVar);
      return Optional.empty();
    }

    collector.pushAttributeStack("lower_court_case");
    var title = lowerCourtInfo.get().caseTitleText;
    InterviewVariable titleVar =
        collector.requestVar("title", "The name of the lower court case", "text");
    if (title.isBlank()) {
      collector.addRequired(titleVar);
    } else if (title.length() > 5000) {
      collector.addWrong(
          titleVar.appendDesc(
              ": title cannot be longer than 5000 characters (is " + title.length() + ")"));
    }

    var docketNumber = lowerCourtInfo.get().caseDocketId;
    InterviewVariable docketVar =
        collector.requestVar("docket_number", "The docket number of the lower court case", "text");
    if (docketNumber.isBlank()) {
      collector.addRequired(docketVar);
    } else if (docketNumber.length() > 30) {
      collector.addWrong(
          docketVar.appendDesc(
              "Case docket id cannot be longer than 30 characters. (is "
                  + docketNumber.length()
                  + ")"));
    }

    var judge = lowerCourtInfo.get().lowerCourtJudgeName;
    InterviewVariable judgeVar =
        collector.requestVar(
            "judge", "The name of the Judge who gave the lower court decision", "text");
    if (judge.isBlank()) {
      collector.addRequired(judgeVar);
    } else if (judge.length() > 150) {
      collector.addWrong(
          judgeVar.appendDesc(
              ": Lower court judge name cannot be longer that 150 characters (is "
                  + judge.length()
                  + ")"));
    }
    collector.popAttributeStack();

    // Unclear if this needs to be the code
    var lowerCode = lowerCourtInfo.get().lowerCourtCode;
    InterviewVariable lowerCodeVar =
        collector.requestVar("trial_court.name", "The lower court name", "text");
    if (lowerCode.isBlank()) {
      collector.addRequired(lowerCodeVar);
    } else if (lowerCode.length() > 30) {
      collector.addWrong(
          lowerCodeVar.appendDesc(
              "Lower Court Name cannot be longer than 30 characters (is "
                  + lowerCode.length()
                  + ")"));
    }

    return lowerCourtInfo;
  }

  /**
   * Doesn't return optional because we can set the People names to null / blank.
   *
   * @param name
   * @param row
   * @param collector
   * @param var
   * @return
   * @throws FilingError
   */
  public String vetName(
      String name, DataFieldRow row, InfoCollector collector, InterviewVariable var)
      throws FilingError {
    if (name == null) {
      name = "";
    }
    if (!row.matchRegex(name)) {
      collector.addWrong(var.appendDesc(": must match regex: " + row.regularexpression));
    }
    if (name.length() > 100) {
      collector.addWrong(var.appendDesc(": can't exceed 100 characters"));
    }
    return name;
  }

  public Name vetFullName(Name name, InfoCollector collector) throws FilingError {
    String betterFirst =
        vetName(
            name.getFirstName(),
            allDataFields.getFieldRow("PartyFirstName"),
            collector,
            collector.requestVar("name.first", "First name of a case party", "text"));
    String betterMiddle =
        vetName(
            name.getMiddleName(),
            allDataFields.getFieldRow("PartyMiddleName"),
            collector,
            collector.requestVar("name.middle", "Middle name of the case party", "text"));
    String betterLast =
        vetName(
            name.getLastName(),
            allDataFields.getFieldRow("PartyLastName"),
            collector,
            collector.requestVar("name.last", "Last name of the case party", "text"));
    String betterSuffix = vetSuffix(name.getSuffix(), collector);

    return new Name(
        name.getPrefix(),
        betterFirst,
        betterMiddle,
        betterLast,
        betterSuffix,
        name.getMaidenName());
  }

  /**
   * Doesn't return optional because we can set the People names to null / blank.
   *
   * @param name
   * @param row
   * @param collector
   * @param var
   * @return
   * @throws FilingError
   */
  public String vetOrgName(String name, InfoCollector collector) throws FilingError {
    if (name == null) {
      name = "";
    }
    InterviewVariable var = collector.requestVar("name", "Org Name", "text");
    if (name.length() > 400) {
      collector.addWrong(var.appendDesc(": can't exceed 400 characters"));
    }
    DataFieldRow row = allDataFields.getFieldRow("PartyBusinessName");
    if (!row.matchRegex(name)) {
      collector.addWrong(var.appendDesc(": must match regex: " + row.regularexpression));
    }
    return name;
  }

  public Optional<String> getLangCode(Optional<String> lang, InfoCollector collector)
      throws FilingError {
    if (lang.isEmpty()) {
      return lang;
    }

    List<NameAndCode> langs = cd.getLanguages(this.court.code);
    if (langs.isEmpty()) {
      log.warn(
          "Court " + this.court.code + " can't handle any languages; simply dropping the language");
      // This court cannot handle languages.
      return Optional.empty();
    }

    var matchedLang =
        langs.stream().filter(l -> l.getName().equalsIgnoreCase(lang.get())).findFirst();
    if (matchedLang.isEmpty()) {
      log.info("Can't have language: " + lang);
      collector.addWrong(
          collector.requestVar(
              "language",
              "The primary language of this person",
              "choice",
              langs.stream().map(l -> l.getName()).toList()));
      return Optional.empty();
    }
    return matchedLang.map(l -> l.getCode());
  }

  public Optional<String> vetGender(Optional<String> gender, InfoCollector collector)
      throws FilingError {
    DataFieldRow genderRow = allDataFields.getFieldRow("PartyGender");
    if (genderRow.isvisible) {
      if (!gender.isPresent() && genderRow.isrequired) {
        InterviewVariable var = collector.requestVar("gender", "Gender of this filer", "text");
        collector.addRequired(var);
      }
      return gender;
    } else {
      return Optional.empty();
    }
  }

  public String vetSuffix(String suffix, InfoCollector collector) throws FilingError {
    DataFieldRow suffixRow = allDataFields.getFieldRow("PartyNameSuffix");
    if (suffixRow.isvisible) {
      List<NameAndCode> suffixes = cd.getNameSuffixes(this.court.code);
      InterviewVariable var =
          collector.requestVar(
              "name.suffix",
              "Suffix of the name of the party",
              "choices",
              suffixes.stream().map(s -> s.getName()).toList());
      if (suffix.isBlank() && suffixRow.isrequired) {
        // TODO(brycew-later):
        log.error(
            "DEV WARNING: Court "
                + this.court.code
                + ": WHY would you ever require a suffix? There aren't empty suffix codes at"
                + " all.");
        collector.addRequired(var);
      }
      Optional<NameAndCode> suffixMatch =
          suffixes.stream().filter(s -> s.getName().equalsIgnoreCase(suffix)).findFirst();
      if (suffixMatch.isEmpty()) {
        collector.addWrong(var);
      }
    }
    return suffix;
  }

  public Map<String, String> getCrossRefIds(
      JsonNode miscInfo, InfoCollector collector, String caseTypeCode) throws FilingError {
    List<CrossReference> refs = cd.getCrossReference(court.code, caseTypeCode);
    Map<String, CrossReference> refMap = new HashMap<>();
    for (CrossReference ref : refs) {
      refMap.put(ref.code, ref);
    }
    InterviewVariable refsVar =
        collector.requestVar(
            "cross_references", "References to other cases in different systems", "DAList");
    Set<String> usedCodes = new HashSet<>();
    Map<String, String> ids = new HashMap<>();
    if (miscInfo.has("cross_references") && miscInfo.get("cross_references").isObject()) {
      JsonNode jsonRefs = miscInfo.get("cross_references");
      if (jsonRefs.has("_class") && jsonRefs.has("elements")) {
        jsonRefs = jsonRefs.get("elements");
      }
      Iterable<String> refNames = jsonRefs::fieldNames;
      for (String refKey : refNames) {
        if (refMap.containsKey(refKey)) {
          CrossReference myRef = refMap.get(refKey);
          String refValue = jsonRefs.get(refKey).asText();
          if (!myRef.matchesRegex(refValue)) {
            collector.addWrong(
                refsVar.appendDesc(
                    ": for " + refValue + ": " + myRef.customvalidationfailuremessage));
          }
          ids.put(myRef.code, refValue);
          usedCodes.add(myRef.code);
        } else {
          collector.addWrong(refsVar.appendDesc(": ref " + refKey + " isn't available"));
        }
      }
    }

    Set<String> missingRefs =
        refs.stream()
            .filter(ref -> ref.isrequired && !usedCodes.contains(ref.code))
            .map(ref -> ref.name)
            .collect(Collectors.toSet());
    if (!missingRefs.isEmpty()) {
      collector.addRequired(
          refsVar.appendDesc(": the following refs are required: " + missingRefs));
    }
    return ids;
  }

  /**
   * @param existingPartyCodes: str of Tyler party ID to their role code string
   * @param newPartyCodes: str of our generated ID of party to their role code string
   * @return the combined map of tyler ids and our ids to each party type
   */
  private Map<String, Pair<PartyType, Boolean>> vetPartyTypes(
      Map<String, Person> existingParties, Map<String, Person> newParties, CaseType type)
      throws FilingError {
    List<PartyType> pTypesForCase = cd.getPartyTypeFor(court.code, type.code);
    Map<String, PartyType> codeToPartyType =
        pTypesForCase.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
    // So, Tyler lies: it's possible for older cases to have party types that aren't allowed
    // on new cases anymore. So we'll make a backup map of all of the real party types, if
    // necessary.
    Map<String, PartyType> codeToAllPartyType = Map.of();
    Map<String, Pair<PartyType, Boolean>> partyInfo = new HashMap<>();
    for (Map.Entry<String, Person> party : existingParties.entrySet()) {
      if (codeToPartyType.containsKey(party.getValue().getRole())) {
        partyInfo.put(
            party.getKey(),
            Pair.of(codeToPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
      } else {
        log.warn(
            "Existing party "
                + party.getKey()
                + "'s role ("
                + party.getValue().getRole()
                + ") isn't a code?");
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, null);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(party.getValue().getRole())) {
          partyInfo.put(
              party.getKey(),
              Pair.of(
                  codeToAllPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
        } else {
          log.warn(
              "Existing party "
                  + party.getKey()
                  + "'s role ("
                  + party.getValue().getRole()
                  + ") still isn't a code?: "
                  + codeToAllPartyType.keySet());
          // partyInfo.put(party.getKey(), Pair.of(null, party.getValue().isOrg()));
        }
      }
    }
    for (Map.Entry<String, Person> party : newParties.entrySet()) {
      if (codeToPartyType.containsKey(party.getValue().getRole())) {
        partyInfo.put(
            party.getKey(),
            Pair.of(codeToPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
      } else {
        log.warn(
            "New party "
                + party.getKey()
                + "'s role ("
                + party.getValue().getRole()
                + ") isn't a code?");
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, type.code);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(party.getValue().getRole())) {
          partyInfo.put(
              party.getKey(),
              Pair.of(
                  codeToAllPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
        } else {
          partyInfo.put(party.getKey(), Pair.of(null, party.getValue().isOrg()));
        }
      }
    }
    return partyInfo;
  }

  // TODO(brycew): This is called from EcfCaseTypeFactory.java:214, but it should be called in the
  // function above.
  public String vetPartyCode(
      String role, List<PartyType> allowedPartyTypes, InfoCollector collector) throws FilingError {
    Optional<PartyType> matchingType =
        allowedPartyTypes.stream().filter(pt -> pt.code.equalsIgnoreCase(role)).findFirst();
    if (matchingType.isEmpty()) {
      InterviewVariable ptVar =
          collector.requestVar(
              "party_type",
              "Legal role of the party",
              "choices",
              allowedPartyTypes.stream().map(pt -> pt.code).toList());
      collector.addWrong(ptVar);
      return "";
    } else {
      return matchingType.get().code;
    }
  }

  public void vetRequiredPartyTypes(
      Set<String> presentPartyTypes, List<PartyType> partyTypes, InfoCollector collector)
      throws FilingError {
    Set<String> requiredTypes =
        partyTypes.stream().filter(t -> t.isrequired).map(t -> t.code).collect(Collectors.toSet());
    requiredTypes.removeAll(presentPartyTypes);
    if (!requiredTypes.isEmpty()) {
      FilingError err =
          FilingError.serverError(
              "DEV ERROR: All required parties not covered by existing party types. ("
                  + presentPartyTypes
                  + ". Missing "
                  + requiredTypes);
      collector.error(err);
    }
  }

  public Optional<LocalDate> vetDueDate(
      Optional<LocalDate> dueDate, FilingCode filing, InfoCollector collector) throws FilingError {
    DataFieldRow dueDateRow = allDataFields.getFieldRow("DueDateAvailableForFilers");
    if (filing.useduedate && dueDateRow.isvisible) {
      if (!dueDate.isPresent() && dueDateRow.isrequired) {
        InterviewVariable var =
            collector.requestVar(
                "due_date",
                "The due date of the filing, some number of days after the filing.",
                "date");
        collector.addRequired(var);
      }
      return dueDate;
    }
    return Optional.empty();
  }

  public Optional<String> vetFilingRefNum(Optional<String> fileRefNum, InfoCollector collector)
      throws FilingError {
    DataFieldRow fileRefRow = allDataFields.getFieldRow("FilingReferenceNumber");
    if (fileRefRow.isvisible) {
      if (!fileRefNum.isPresent() && fileRefRow.isrequired) {
        InterviewVariable var =
            collector.requestVar(
                "reference_number",
                "Reference Number for a document, given by the user? TODO(brycew)",
                "text");
        collector.addRequired(var);
      }
      return fileRefNum;
    }
    return Optional.empty();
  }

  public Optional<String> vetMotionCode(
      Optional<String> motionCode, FilingCode filing, InfoCollector collector) throws FilingError {
    DataFieldRow motionRow = allDataFields.getFieldRow("FilingMotionType");
    if (motionRow.isvisible) {
      List<NameAndCode> motionTypes = cd.getMotionTypes(this.court.code, filing.code);
      InterviewVariable var =
          collector.requestVar(
              "motion_type",
              "the motion type (?)",
              "choices",
              motionTypes.stream().map(m -> m.getCode()).toList());
      if (motionCode.isPresent()) {
        String mt = motionCode.get();
        Optional<NameAndCode> matchedMotion =
            motionTypes.stream().filter(m -> m.getCode().equalsIgnoreCase(mt)).findFirst();
        if (!matchedMotion.isPresent()) {
          collector.addWrong(var);
        }
        return matchedMotion.map(m -> m.getCode());
      } else if (motionRow.isrequired) {
        // TODO(brycew-later): "A motion type may be required for a filing type, and may or may not
        // allow multiple occurances"
        // What does it actually mean? Motion types are empty for most IL courts (not Cook), so IDK
        // what to do if there's nothing there
        collector.addRequired(var);
      }
    }
    return Optional.empty();
  }

  public List<OptionalService> vetOptionalServices(
      List<OptionalService> servs, FilingCode filing, InfoCollector collector) throws FilingError {
    if (servs.isEmpty()) {
      return servs;
    }

    List<OptionalServiceCode> codes = cd.getOptionalServices(this.court.code, filing.code);
    Map<String, OptionalServiceCode> codeMap =
        codes.stream().collect(Collectors.toMap(sv -> sv.code, sv -> sv));
    InterviewVariable servVar =
        collector.requestVar("optional_services", "things the court can do", "DADict");
    for (OptionalService serv : servs) {
      if (!codeMap.containsKey(serv.code)) {
        collector.addWrong(servVar);
      }
      OptionalServiceCode codeSettings = codeMap.get(serv.code);
      if (codeSettings.hasfeeprompt) {
        if (serv.feeAmount.isEmpty()) {
          collector.addWrong(servVar.appendDesc(": needs fee prompt"));
        }
      }
      if (!codeSettings.hasfeeprompt && serv.feeAmount.isPresent()) {
        collector.addWrong(servVar.appendDesc(": doesn't need fee prompt"));
      }
      if (codeSettings.multiplier == true) {
        if (serv.multiplier.isEmpty()) {
          collector.addWrong(servVar.appendDesc(": needs multiplier"));
        }
      }
    }
    return servs;
  }

  public Optional<String> vetFilingAttorney(
      Optional<String> filingAttorney, InfoCollector collector) throws FilingError {
    DataFieldRow attorneyRow = allDataFields.getFieldRow("FilingFilingAttorneyView");
    if (attorneyRow.isvisible) {
      if (!filingAttorney.isPresent() && attorneyRow.isrequired) {
        InterviewVariable attVar =
            collector.requestVar(
                "filing_attorney", "The Attorney that is filing this document", "text");
        collector.addRequired(attVar);
      }
      return filingAttorney;
    }
    return Optional.empty();
  }

  /**
   * NOTE: modifies the components list, removing the current component if allowmultiple is false.
   *
   * @param filingComponent
   * @param components
   * @param collector
   * @return
   * @throws FilingError
   */
  public String vetFilingComponent(
      String filingComponent,
      List<FilingComponent> components,
      FilingCode filing,
      InfoCollector collector)
      throws FilingError {
    InterviewVariable var =
        collector.requestVar("filing_component", "Filing component: Lead or attachment", "text");
    if (components.isEmpty()) {
      log.error(
          "Filing Components List is empty! In "
              + filing.location
              + ", filing code "
              + filing.code
              + ". There are no other documents that can be added!");
      collector.addRequired(var);
    }

    Optional<FilingComponent> filtered =
        components.stream().filter(c -> c.code.equalsIgnoreCase(filingComponent)).findFirst();
    if (filtered.isEmpty()) {
      log.error("Filing Components (" + components + ") don't match \"" + filingComponent + "\".");
      collector.addRequired(var);
    }

    FilingComponent filt =
        filtered.orElse(new FilingComponent("NO CODE", "NOT PRESENT", "", false, false, 0, "", ""));
    if (!filt.allowmultiple) {
      components.remove(filt);
    }
    return filt.code;
  }

  public Optional<String> vetFileName(
      String fileName, List<FileType> allowedFileTypes, InfoCollector collector)
      throws FilingError {
    if (allowedFileTypes.stream().noneMatch(t -> t.matchesFile(fileName))) {
      FilingError err =
          FilingError.malformedInterview(
              "Extension of " + fileName + " not allowed! Try these instead: " + allowedFileTypes);
      collector.error(err);
    }
    DataFieldRow originalName = allDataFields.getFieldRow("OriginalFileName");
    if (originalName.matchRegex(fileName) && fileName.length() < 50) {
      return Optional.of(fileName);
    } else {
      InterviewVariable oriNameVar =
          collector.requestVar(
              "file_name",
              "file name of document: regex: " + originalName.regularexpression.toString(),
              "text");
      collector.addWrong(oriNameVar);
    }
    return Optional.empty();
  }

  public Optional<String> vetDocType(String docTypeStr, FilingCode filing, InfoCollector collector)
      throws FilingError {
    // Literally should just be if it's confidential or not. (or "Hot fix" or public).
    // Search options in "documenttype" table with location
    DataFieldRow documentType = allDataFields.getFieldRow("DocumentType");
    if (documentType.isvisible) {
      List<DocumentTypeTableRow> docTypes = cd.getDocumentTypes(court.code, filing.code);
      InterviewVariable docTypeVar =
          collector.requestVar(
              "document_type",
              documentType.helptext + " " + documentType.validationmessage,
              "choices",
              docTypes.stream().map(dt -> dt.code).collect(Collectors.toList()));
      if (documentType.isrequired) {
        if (docTypeStr.isBlank()) {
          collector.addRequired(docTypeVar);
        }
      }

      Optional<DocumentTypeTableRow> code =
          docTypes.stream().filter(d -> d.code.equals(docTypeStr)).findFirst();
      if (code.isEmpty()) {
        collector.addWrong(docTypeVar);
      }
      return code.map(c -> c.code);
    }
    return Optional.empty();
  }

  public Optional<String> vetComment(String comment, InfoCollector collector) throws FilingError {
    DataFieldRow commentRow = allDataFields.getFieldRow("FilingFilingComments");
    if (commentRow.isvisible) {
      if (!commentRow.matchRegex(comment)) {
        InterviewVariable var = collector.requestVar("comment", "", "text");
        collector.addWrong(var);
      }
      // I absolutely refuse to require comments from the user on each individual document.
      if (commentRow.isrequired) {
        log.error(
            "Dev Ops Error: Comments are required per filing document apparently. "
                + "Not being forced yet");
      }
      return Optional.of(comment);
    }
    return Optional.empty();
  }

  public Optional<FilingAction> vetFilingAction(
      Optional<FilingAction> filingAction, boolean isInitialFiling, InfoCollector collector)
      throws FilingError {
    boolean serviceOnInitial =
        this.court.allowserviceoninitial.orElse(
            allDataFields.getFieldRow("FilingServiceCheckBoxInitial").isvisible);
    // From Reference Guide: if no FilingAction is provided, the original default behavior applies:
    // * ReviewFiling API w/o service contacts: EFile
    // * ReviewFiling API w/ service contacts: EfileAndServe
    // * ServeFiling API: Serve
    if (filingAction.isPresent()) {
      FilingAction act = filingAction.get();
      if (isInitialFiling
          && !serviceOnInitial
          && (act.equals(FilingAction.E_FILE_AND_SERVE) || act.equals(FilingAction.SERVE))) {
        InterviewVariable var =
            collector.requestVar("filing_action", "Cannot do service on initial filing", "text");
        collector.addWrong(var);
      }
    }
    return filingAction;
  }

  public Optional<String> getDocumentDescription(
      FilingDoc doc, FilingCode filing, InfoCollector collector) throws FilingError {
    DataFieldRow row = allDataFields.getFieldRow("DocumentDescription");
    if (!row.isvisible) {
      return Optional.empty();
    }
    if (doc.getDescription().isPresent()) {
      return doc.getDescription().map(des -> des.get());
    } else {
      if (this.court.defaultdocumentdescription.equals("1")) {
        return Optional.of(filing.name);
      } else if (this.court.defaultdocumentdescription.equals("2")) {
        return Optional.of(doc.getFilingAttachments().head().getFileName());
      } else if (row.defaultvalueexpression.equals("{{FilingCodeDescription}}")) {
        return Optional.of(filing.name);
      } else if (row.defaultvalueexpression.equals("{{FileName}}")) {
        return Optional.of(doc.getFilingAttachments().head().getFileName());
      } else if (row.isrequired) {
        InterviewVariable var =
            collector.requestVar(
                "description",
                "A human understandable description of this filing document",
                "text");
        collector.addRequired(var);
        return Optional.of("A document");
      } else {
        return Optional.of(row.defaultvalueexpression);
      }
    }
  }

  public List<String> vetProcedureRemedy(
      JsonNode proRem, boolean initial, CaseCategory cat, InfoCollector collector)
      throws FilingError {
    List<NameAndCode> procedureRemedies = cd.getProcedureOrRemedy(this.court.code, cat.getCode());
    String procedureViewName = "CivilCaseProcedureView" + ((initial) ? "Initial" : "Subsequent");
    DataFieldRow procedureView = DataFieldRow.MissingDataField(procedureViewName);
    String procBehavior = (initial) ? cat.procedureremedyinitial : cat.procedureremedysubsequent;
    if (!procBehavior.isEmpty() && !procBehavior.equals("Not Available")) {
      procedureView = allDataFields.getFieldRow(procedureViewName);
    }
    InterviewVariable var;
    if (procedureRemedies.isEmpty()) {
      var =
          collector.requestVar(
              "procedure_remedy", "Procedure Remedy (no available choices?)", "text");
    } else {
      var =
          collector.requestVar(
              "procedure_remedy",
              "Procedure Remedy",
              "choices",
              procedureRemedies.stream().map(nac -> nac.getName()).toList());
    }
    if (proRem != null && !proRem.isNull() && proRem.isTextual()) {
      if (procedureView.isvisible) {
        List<NameAndCode> maybeProcedures =
            procedureRemedies.stream()
                .filter(nac -> nac.getName().equals(proRem.asText()))
                .toList();
        if (maybeProcedures.isEmpty()) {
          collector.addWrong(var);
        }
        return maybeProcedures.stream().map(nac -> nac.getCode()).toList();
      } else {
        log.info(
            "Dropping procedure_remedy "
                + proRem.asText()
                + ", since isvisible is false for "
                + this.court.code);
      }
    } else {
      if (procedureView.isrequired) {
        collector.addRequired(var);
      } else {
        collector.addOptional(var);
      }
    }
    return List.of();
  }

  public Optional<String> vetDamageAmount(
      boolean initial, CaseCategory cat, JsonNode miscInfo, InfoCollector collector)
      throws FilingError {
    String courtLocationId = this.court.code;
    List<NameAndCode> damageAmounts = cd.getDamageAmount(courtLocationId, cat.getCode());
    DataFieldRow damageConfig = cd.getDataField(courtLocationId, "DamageAmount");
    String damgBehavior = (initial) ? cat.damageamountinitial : cat.damageamountsubsequent;
    if (!damgBehavior.isEmpty() && !damgBehavior.equals("Not Available")) {
      damageConfig =
          allDataFields.getFieldRow(
              "CivilCaseDamageAmount" + ((initial) ? "Initial" : "Subsequent"));
    }
    InterviewVariable docVar;
    if (damageAmounts.isEmpty()) {
      docVar = collector.requestVar("procedure_remedy", "Procedure Remedy", "text");
    } else {
      docVar =
          collector.requestVar(
              "procedure_remedy",
              "Procedure Remedy",
              "choices",
              damageAmounts.stream().map(nac -> nac.getName()).toList());
    }
    JsonNode jsonDmg = miscInfo.get("damage_amount");
    if (jsonDmg != null && !jsonDmg.isNull() && jsonDmg.isTextual()) {
      if (damageConfig.isvisible) {
        Optional<NameAndCode> maybeDmg =
            damageAmounts.stream()
                .filter(nac -> nac.getName().equals(jsonDmg.asText()))
                .findFirst();
        if (maybeDmg.isPresent()) {
          return maybeDmg.map(nac -> nac.getCode());
        } else {
          collector.addWrong(docVar);
        }
      } else {
        log.info(
            "Dropping damage_amount "
                + jsonDmg.asText()
                + ", since isvisible is false for "
                + courtLocationId);
      }
    } else {
      if (damageConfig.isrequired) {
        collector.addRequired(docVar);
      } else {
        collector.addOptional(docVar);
      }
    }
    return Optional.empty();
  }
}
