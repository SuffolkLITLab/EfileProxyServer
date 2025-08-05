package edu.suffolk.litlab.efsp.tyler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FileType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilerType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.OptionalServiceCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;
import edu.suffolk.litlab.efsp.model.FilingAction;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;

/**
 * All of the Tyler code specific conversions and logic checks from our objects (really light
 * wrappers over the JSON objects).
 *
 * <p>The `vetXYZ` functions here check that the given inputs work with Tyler's expectations.
 */
public class TylerCodesParser {
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

  public Result<CaseCategory, List<String>> vetCaseCat(String caseCategoryCode) {
    Optional<CaseCategory> maybeCaseCat =
        cd.getCaseCategoryWithCode(this.court.code, caseCategoryCode);
   if (maybeCaseCat.isEmpty()) {
      List<CaseCategory> categories = cd.getCaseCategoriesFor(court.code);
      return Result.err(categories.stream().map(cat -> cat.code).toList());
    }
    return Result.ok(maybeCaseCat.get());
  }


  /////////////////// Methods that access the codes database.

  // Types specifically for errors.
  public sealed interface CodeError {}
  public sealed interface FilingTypeError {}
  public record NoMatchingCode(String given, List<String> options) implements CodeError, FilingTypeError {}
  public record BadCaseType(FilingError err) implements CodeError {}
  public record RestrictedCaseType() implements FilingTypeError {}

  public Result<CaseType, CodeError> vetCaseType(String caseTypeCode, CaseCategory caseCategory, boolean isInitialFiling) {
    List<CaseType> caseTypes = cd.getCaseTypesFor(court.code, caseCategory.code, Optional.empty());
    if (caseTypes.isEmpty()) {
      FilingError err =
          FilingError.serverError(
              "There are no caseTypes for " + court.code + " and " + caseCategory.code);
      return Result.err(new BadCaseType(err));
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
      FilingError err =
          FilingError.malformedInterview(
              "An Initial"
                  + " filing can't be filed at "
                  + court.name
                  + " or be of filing type "
                  + type.name);
        return Result.err(new BadCaseType(err));
    } else if (!isInitialFiling && (!court.subsequent)) {
      FilingError err =
          FilingError.malformedInterview(
              "An Subsequent" + " filing can't be filed at " + court.name);
      return Result.err(new BadCaseType(err));
    }

    return Result.ok(maybeType.get());
  }
  
  public Result<Optional<NameAndCode>, NoMatchingCode> vetSubType(String subtypeCode, CaseType caseType) {
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

  public Result<List<FilingCode>, FilingTypeError> vetFilingTypes(
      List<String> filingCodes,
      CaseCategory caseCategory,
      CaseType type,
      boolean isInitialFiling) {
    List<FilingCode> filingOptions =
        cd.getFilingType(court.code, caseCategory.code, type.code, isInitialFiling);
    if (filingOptions.isEmpty()) {
      log.error(
          "Need a filing type! FilingTypes are empty, so {} and {} are restricted",
              caseCategory, type);
      return Result.err(new RestrictedCaseType());
    }

    List<FilingCode> finalCodes = new ArrayList<>();
    for (String filingCode : filingCodes) {
      var res = vetFilingType(filingCode, filingOptions);
      if (res.isErr()) {
        return Result.err(res.expectErr("Should be filing code error"));
      }
      res.ifOk(fc -> finalCodes.add(fc));
    }
    return Result.ok(finalCodes);
  }

  private Result<FilingCode, FilingTypeError> vetFilingType(
      String filingCode,
      /** Pass in so we only need to make 1 expensive DB query */
      List<FilingCode> filingOptions) {
    Optional<FilingCode> maybeCode =
        filingOptions.stream().filter(fil -> fil.code.equals(filingCode)).findFirst();

    if (maybeCode.isEmpty()) {
      log.error("Nothing matches filing `{}` in the info!", filingCode);
      List<String> options = filingOptions.stream().map(f -> f.code).toList();
      return Result.err(new NoMatchingCode(filingCode, options));
    }
    return Result.ok(maybeCode.get());
  }

  public Result<String, CodeError> vetSuffix(String suffix) {
    DataFieldRow suffixRow = allDataFields.getFieldRow("PartyNameSuffix");
    if (suffixRow.isvisible) {
      List<NameAndCode> suffixes = cd.getNameSuffixes(this.court.code);
      if (suffix.isBlank() && suffixRow.isrequired) {
        // TODO(brycew-later):
        log.error(
            "DEV WARNING: Court {}: WHY would you ever require a suffix? There aren't empty suffix codes at all.",
            this.court.code);
      }
      Optional<NameAndCode> suffixMatch =
          suffixes.stream().filter(s -> s.getName().equalsIgnoreCase(suffix)).findFirst();
      if (suffixMatch.isEmpty()) {
        return Result.err(new NoMatchingCode(suffix, suffixes.stream().map(s -> s.getName()).toList()));
      } else {
        return Result.ok(suffixMatch.get().getName());
      }
    }
    return Result.ok(suffix);
  }

  public Result<Optional<String>, CodeError> getLangCode(Optional<String> lang) {
    if (lang.isEmpty()) {
      return Result.ok(lang);
    }

    List<NameAndCode> langs = cd.getLanguages(this.court.code);
    if (langs.isEmpty()) {
      log.warn(
          "Court {} can't handle any languages; simply dropping the language {}", this.court.code, lang);
      // This court cannot handle languages.
      return Result.ok(Optional.empty());
    }

    var matchedLang = langs.stream().filter(l -> l.getName().equalsIgnoreCase(lang.get())).findFirst();
    if (matchedLang.isEmpty()) {
      log.info("Can't have language: {}", lang);
      return Result.err(new NoMatchingCode(lang.get(), langs.stream().map(l -> l.getName()).toList()));
    }
    return Result.ok(matchedLang.map(l -> l.getCode()));
  }

  public sealed interface CrossReferenceError {}
  public record WrongRefVal(String refCode, String refVal, Pattern regex, String msg) implements CrossReferenceError {}
  public record NoMatchingRef(String refCode, String refVal) implements CrossReferenceError {}
  public record MissingRequiredRefs(Set<String> refCodes) implements CrossReferenceError {}

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
          return Result.err(new WrongRefVal(refKey, refValue, refData.validationregex, refData.customvalidationfailuremessage));
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


  public record PartyInfo(PartyType type, boolean isOrg) {}
  /**
   * @param existingPartyCodes: str of Tyler party ID to their role code string
   * @param newPartyCodes: str of our generated ID of party to their role code string
   * @return the combined map of tyler ids and our ids to each party type
   */
  public Map<String, PartyInfo> vetPartyTypes(
      Map<String, Person> existingParties, Map<String, Person> newParties, CaseType type) {
    List<PartyType> pTypesForCase = cd.getPartyTypeFor(court.code, type.code);
    Map<String, PartyType> codeToPartyType =
        pTypesForCase.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
    // So, Tyler lies: it's possible for older cases to have party types that aren't allowed
    // on new cases anymore. So we'll make a backup map of all of the real party types, if
    // necessary.
    Map<String, PartyType> codeToAllPartyType = Map.of();
    Map<String, PartyInfo> partyInfo = new HashMap<>();
    for (Map.Entry<String, Person> party : existingParties.entrySet()) {
      if (codeToPartyType.containsKey(party.getValue().getRole())) {
        partyInfo.put(
            party.getKey(),
            new PartyInfo(codeToPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
      } else {
        log.warn("Existing party {}'s role ({}) isn't a code?",
            party.getKey(),
            party.getValue().getRole());
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, null);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(party.getValue().getRole())) {
          partyInfo.put(
              party.getKey(),
              new PartyInfo(
                  codeToAllPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
        } else {
          log.warn("Existing party {}'s role ({}) still isn't a code?: {}",
              party.getKey(),
              party.getValue().getRole(),
              codeToAllPartyType.keySet());
          // partyInfo.put(party.getKey(), Pair.of(null, party.getValue().isOrg()));
        }
      }
    }
    for (Map.Entry<String, Person> party : newParties.entrySet()) {
      if (codeToPartyType.containsKey(party.getValue().getRole())) {
        partyInfo.put(
            party.getKey(),
            new PartyInfo(codeToPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
      } else {
        log.warn("New party {}'s role ({}) isn't a code?",
              party.getKey(),
              party.getValue().getRole());
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, type.code);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(party.getValue().getRole())) {
          partyInfo.put(
              party.getKey(),
              new PartyInfo(
                  codeToAllPartyType.get(party.getValue().getRole()), party.getValue().isOrg()));
        } else {
          partyInfo.put(party.getKey(), new PartyInfo(null, party.getValue().isOrg()));
        }
      }
    }
    return partyInfo;
  }

  // TODO(brycew): This is called from EcfCaseTypeFactory.java:214, but it should be called in the
  // function above.
  public Result<String, CodeError> vetPartyCode(String role, List<PartyType> allowedPartyTypes) {
    Optional<PartyType> matchingType =
        allowedPartyTypes.stream().filter(pt -> pt.code.equalsIgnoreCase(role)).findFirst();
    if (matchingType.isEmpty()) {
      return Result.err(new NoMatchingCode(role, allowedPartyTypes.stream().map(pt -> pt.code).toList()));
    } else {
      return Result.ok(matchingType.get().code);
    }
  }

  public record MissingRequiredPartyTypes(Set<String> present, Set<String> required) {}
  public Result<NullValue, MissingRequiredPartyTypes> vetRequiredPartyTypes(
      Set<String> presentPartyTypes, List<PartyType> partyTypes) {
    Set<String> requiredTypes =
        partyTypes.stream().filter(t -> t.isrequired).map(t -> t.code).collect(Collectors.toSet());
    requiredTypes.removeAll(presentPartyTypes);
    if (!requiredTypes.isEmpty()) {
      return Result.err(new MissingRequiredPartyTypes(presentPartyTypes, requiredTypes));
    }
    return Result.nullOk();
  }

  public Optional<String> vetMotionCode(
      Optional<String> motionCode, FilingCode filing) {
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
      List<OptionalService> servs, FilingCode filing) {
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

   /**
   * NOTE: modifies the components list, removing the current component if allowmultiple is false.
   *
   * @param filingComponent
   * @param components
   * @param collector
   * @return
   */
  public String vetFilingComponent(
      String filingComponent,
      List<FilingComponent> components,
      FilingCode filing) {
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

    public Optional<String> vetDocType(String docTypeStr, FilingCode filing) {
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

    public List<String> vetProcedureRemedy(
      JsonNode proRem, boolean initial, CaseCategory cat) {
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
      boolean initial, CaseCategory cat, JsonNode miscInfo) {
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

  ///////////////////// Methods that only deal with DataFields //////////////////
  public sealed interface AttorneyError {}
  public record NoMultipleAttorneys() implements AttorneyError {}
  public record RequiredAttorneys() implements AttorneyError {}
  public Result<Optional<Map<PartyId, List<String>>>, AttorneyError> vetPartyAttorneyMap(
      Map<PartyId, List<String>> partyAttyMap,
      Map<String, ? extends Object> partyIdToRefObj) {
    DataFieldRow attRow = allDataFields.getFieldRow("PartyAttorney");
    for (Map.Entry<PartyId, List<String>> partyAttys : partyAttyMap.entrySet()) {
      log.info("Setting Attorneys for : {}", partyAttys.getKey());
      if (partyIdToRefObj.isEmpty()) {
        log.warn(
            "No current filing parties, but {} is in the current filing?",
            partyAttys.getKey().getIdString());
        continue;
      } else if (!partyIdToRefObj.containsKey(partyAttys.getKey().getIdString())) {
        log.warn(
            "Can't handle current filing participant ({}) not already added?!",
            partyAttys.getKey().getIdString());
        continue;
      }
      if (!attRow.isvisible) {
        continue;
      }
      if (partyAttys.getValue().isEmpty()) {
        // Is Self-Represented
        if (attRow.isrequired) {
          return Result.err(new RequiredAttorneys());
        }
      } else {
        if (!this.court.allowmultipleattorneys && partyAttys.getValue().size() > 1) {
          return Result.err(new NoMultipleAttorneys());
        }
      }
    }
    if (!attRow.isvisible) {
      return Result.ok(Optional.empty());
    }

    return Result.ok(Optional.of(partyAttyMap));
  }

  // TODO(brycew): vetLowerCourtInfo is useful, but not really vetting (lots of assumptions outside of the function).
  // Need to refactor.

  // Error types for Text Vars
  public sealed interface FileNameError {}
  public record FileExtensionNotAllowed(String given, List<FileType> allowed) implements FileNameError {}

  public sealed interface TextVarError extends FileNameError {}
  public record MissingVar(Pattern regex) implements TextVarError {}
  public record WrongVar(String given, Pattern regex) implements TextVarError {}
  public record TooLongVar(String given, int length) implements TextVarError {}

  public Result<Optional<String>, MissingVar> vetFilingAttorney(Optional<String> filingAttorney, boolean isIndividual) {
    DataFieldRow attorneyRow = allDataFields.getFieldRow("FilingFilingAttorneyView");
    if (filingAttorney.isPresent() && filingAttorney.get().isBlank()) {
      filingAttorney = Optional.empty();
    }
    if (attorneyRow.isvisible) {
      if (!filingAttorney.isPresent() && attorneyRow.isrequired && !isIndividual) {
        return Result.err(new MissingVar(attorneyRow.regularexpression));
      }
      return Result.ok(filingAttorney);
    }
    return Result.ok(Optional.empty());
  }

  /**
   * Throws if something is wrong; otherwise, an optional email (empty does not mean error!).
   *
   * <p>Note that the collector type is what determines if it throws.
   *
   * @param email
   * @param collector
   * @return
   */
  public Result<Optional<String>, TextVarError> vetEmail(Optional<String> email) {
    DataFieldRow emailRow = allDataFields.getFieldRow("PartyEmail");
    if (emailRow.isvisible) {
      if (email.isPresent()) {
        if (!emailRow.matchRegex(email.get())) {
          return Result.err(new WrongVar(email.get(), emailRow.regularexpression));
        }
      } else if (emailRow.isrequired) {
        return Result.err(new MissingVar(emailRow.regularexpression));
      }
    }
    return Result.ok(email);
  }

  public Result<String, TextVarError> vetPhoneNumber(String number) {
    DataFieldRow phoneRow = allDataFields.getFieldRow("PartyPhone");
    if (phoneRow.isvisible) {
      if (phoneRow.isrequired && number.isEmpty()) {
        return Result.err(new MissingVar(phoneRow.regularexpression));
      }
      if (!phoneRow.matchRegex(number)) {
          if (number.contains("-")) {
            // HACK(brycew): Massachusetts doesn't like dashes in the number, just wants numbers
            number = number.replace("-", "").replace("(", "").replace(")", "");
          }
          if (!phoneRow.matchRegex(number)) {
            return Result.err(new WrongVar(number, phoneRow.regularexpression));
          }
      }
    }
    return Result.ok(number);
  }


  /**
   * Doesn't return optional because we can set the People names to null / blank.
   *
   * @param name
   * @param row
   * @return
   */
  private Result<String, TextVarError> vetName(String name, DataFieldRow row) {
    if (name == null) {
      name = "";
    }
    if (!row.matchRegex(name)) {
      return Result.err(new WrongVar(name, row.regularexpression));
    }
    if (name.length() > 100) {
      return Result.err(new TooLongVar(name, 100));
    }
    return Result.ok(name);
  }

  public Result<String, TextVarError> vetFirstName(String name) {
    return vetName(name, allDataFields.getFieldRow("PartyFirstName"));
  }

  public Result<String, TextVarError> vetMiddleName(String name) {
    return vetName(name, allDataFields.getFieldRow("PartyMiddleName"));
  }

  public Result<String, TextVarError> vetLastName(String name) {
    return vetName(name, allDataFields.getFieldRow("PartyLastName"));
  }

  /**
   * Doesn't return optional because we can set the People names to null / blank.
   *
   * @param name
   * @param row
   * @param collector
   * @param var
   * @return
   */
  public Result<String, TextVarError> vetOrgName(String name) {
    if (name == null) {
      name = "";
    }
    if (name.length() > 400) {
      return Result.err(new TooLongVar(name, 400)); 
    }
    DataFieldRow row = allDataFields.getFieldRow("PartyBusinessName");
    if (!row.matchRegex(name)) {
      return Result.err(new WrongVar(name, row.regularexpression));
    }
    return Result.ok(name);
  }

  public Result<Optional<String>, TextVarError> vetGender(Optional<String> gender) {
    DataFieldRow genderRow = allDataFields.getFieldRow("PartyGender");
    if (genderRow.isvisible) {
      if (!gender.isPresent() && genderRow.isrequired) {
        return Result.err(new MissingVar(genderRow.regularexpression));
      }
      return Result.ok(gender);
    } else {
      return Result.ok(Optional.empty());
    }
  }

  public Result<Optional<String>, TextVarError> vetFilingRefNum(Optional<String> fileRefNum) {
    DataFieldRow fileRefRow = allDataFields.getFieldRow("FilingReferenceNumber");
    if (fileRefRow.isvisible) {
      if (!fileRefNum.isPresent() && fileRefRow.isrequired) {
        return Result.err(new MissingVar(fileRefRow.regularexpression));
      }
      return Result.ok(fileRefNum);
    }
    return Result.ok(Optional.empty());
  }


  public Result<String, FileNameError> vetFileName(String fileName, List<FileType> allowedFileTypes) {
    if (allowedFileTypes.stream().noneMatch(t -> t.matchesFile(fileName))) {
      return Result.err(new FileExtensionNotAllowed(fileName, allowedFileTypes));
    }
    DataFieldRow originalName = allDataFields.getFieldRow("OriginalFileName");
    if (!originalName.matchRegex(fileName)) {
      return Result.err(new WrongVar(fileName, originalName.regularexpression));
    }
    if (fileName.length() < 50) {
      return Result.err(new TooLongVar(fileName, 50));
    }
    return Result.ok(fileName);
  }

  public Result<Optional<String>, TextVarError> vetComment(String comment) {
    DataFieldRow commentRow = allDataFields.getFieldRow("FilingFilingComments");
    if (commentRow.isvisible) {
      if (!commentRow.matchRegex(comment)) {
        return Result.err(new WrongVar(comment, commentRow.regularexpression));
      }
      // I absolutely refuse to require comments from the user on each individual document.
      if (commentRow.isrequired) {
        log.error(
            "Dev Ops Error: Comments are required per filing document apparently. "
                + "Not being forced yet");
      }
      return Result.ok(Optional.of(comment));
    }
    return Result.ok(Optional.empty());
  }

  public Optional<LocalDate> vetDueDate(
      Optional<LocalDate> dueDate, FilingCode filing) {
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

   public Optional<FilingAction> vetFilingAction(
      Optional<FilingAction> filingAction, boolean isInitialFiling) {
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

  public Result<Optional<String>, TextVarError> getDocumentDescription(
      FilingDoc doc, FilingCode filing) {
    DataFieldRow row = allDataFields.getFieldRow("DocumentDescription");
    if (!row.isvisible) {
      return Result.ok(Optional.empty());
    }
    if (doc.getDescription().isPresent()) {
      return Result.ok(doc.getDescription().map(des -> des.get()));
    } else {
      if (this.court.defaultdocumentdescription.equals("1")) {
        return Result.ok(Optional.of(filing.name));
      } else if (this.court.defaultdocumentdescription.equals("2")) {
        return Result.ok(Optional.of(doc.getFilingAttachments().head().getFileName()));
      } else if (row.defaultvalueexpression.equals("{{FilingCodeDescription}}")) {
        return Result.ok(Optional.of(filing.name));
      } else if (row.defaultvalueexpression.equals("{{FileName}}")) {
        return Result.ok(Optional.of(doc.getFilingAttachments().head().getFileName()));
      } else if (row.isrequired) {
        log.warn("DEVOPS Error: A document description is required, but not as Tyler defines in their docs: {}", row.defaultvalueexpression);
        return Result.ok(Optional.of("A document"));
      } else {
        return Result.ok(Optional.of(row.defaultvalueexpression));
      }
    }
  }

  public List<FilingDoc> vetFilingDocSize(
      List<FilingDoc> docs, long maxEach, long maxTotal) {
    long cumulativeBytes = 0;
    for (var doc : docs) {
      long docSize = doc.allAttachmentsLength();
      if (docSize > maxEach) {
        FilingError err =
            FilingError.malformedInterview(
                "Document "
                    + doc.getDescription().map(d -> d.get()).orElse(doc.getFilingComments())
                    + " is too big! Must be max "
                    + maxEach
                    + ", is "
                    + docSize);
        collector.error(err);
      }
      cumulativeBytes += docSize;
    }
    if (cumulativeBytes > maxTotal) {
      FilingError err =
          FilingError.malformedInterview(
              "All Documents combined are too big! Must be max"
                  + maxTotal
                  + ", are "
                  + cumulativeBytes);
      collector.error(err);
    }
    return docs;
  }

  public Optional<FilerType> vetFilerTypes(Optional<String> maybeFilerType) {
    DataFieldRow filertype = allDataFields.getFieldRow("FilingFilerType");
    if (filertype.isvisible) {
      List<FilerType> allTypes = cd.getFilerTypes(this.court.code);
      // allTypes.stream().map(t -> t.code).toList());
      if (maybeFilerType.isPresent()) {
        String filerType = maybeFilerType.get();
        Optional<FilerType> typeInfo =
            allTypes.stream().filter(t -> t.code.equalsIgnoreCase(filerType)).findFirst();
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

  /**
   * Get if we need to add an association between filings and case parties. Is simply a boolean
   * because there's no filing error that needs to be swallowed.
   *
   * @return
   */
  public boolean useFilingAssociations() {
    return allDataFields.getFieldRow("FilingEventCaseParties").isrequired;
  } 
}
