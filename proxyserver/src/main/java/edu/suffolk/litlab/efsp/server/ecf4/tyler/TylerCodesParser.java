package edu.suffolk.litlab.efsp.server.ecf4.tyler;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import ecf4.latest.gov.niem.niem.niem_core._2.MeasureType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType;
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
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.model.Person.Gender;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
  private final DevelopmentPolicyParametersType policy;
  private final DataFields allDataFields;
  private final boolean isIndividual;

  public TylerCodesParser(
      CodeDatabase cd,
      DevelopmentPolicyParametersType policy,
      CourtLocationInfo court,
      DataFields allDataFields,
      boolean isIndividual) {
    this.cd = cd;
    this.court = court;
    this.policy = policy;
    this.allDataFields = allDataFields;
    this.isIndividual = isIndividual;
  }

  public TylerCodesParser(
      CodeDatabase cd,
      DevelopmentPolicyParametersType policy,
      CourtLocationInfo court,
      boolean isIndividual) {
    this(cd, policy, court, cd.getDataFields(court.code), isIndividual);
  }

  public static Optional<CodesParser> makeParser(
      CodeDatabase cd,
      DevelopmentPolicyParametersType policy,
      String courtId,
      boolean isIndividual) {
    Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId);
    return locationInfo.map(li -> new TylerCodesParser(cd, policy, li, isIndividual));
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

  public Result<FilingCode, CodeError> vetFilingType(
      Optional<String> filingStr,
      /** Pass in so we only need to make 1 expensive DB query */
      List<FilingCode> filingOptions) {
    if (filingStr.isEmpty()) {
      return Result.err(
          new RequiredCodeNotPresent(filingOptions.stream().map(f -> f.code).toList()));
    }
    Optional<FilingCode> maybeCode =
        filingOptions.stream().filter(fil -> fil.code.equals(filingStr.get())).findFirst();
    return maybeCode
        .map(c -> Result.<FilingCode, CodeError>ok(c))
        .orElseGet(
            () -> {
              log.error("Nothing matches filing `{}` in the info!", filingStr);
              List<String> options = filingOptions.stream().map(f -> f.code).toList();
              return Result.err(new NoMatchingCode(filingStr.get(), options));
            });
  }

  public Result<String, CodeError> vetSuffix(Optional<String> maybeSuffix) {
    DataFieldRow suffixRow = allDataFields.getFieldRow("PartyNameSuffix");
    if (suffixRow.isvisible) {
      List<NameAndCode> suffixes = cd.getNameSuffixes(this.court.code);
      if ((maybeSuffix.isEmpty() || maybeSuffix.get().isBlank()) && suffixRow.isrequired) {
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

    // TODO(brycew): need to have an ISO 639_2 (language codes) converter, from general
    // language name
    // https://en.wikipedia.org/wiki/List_of_ISO_639-2_codes
    var matchedLang =
        langs.stream().filter(l -> l.getName().equalsIgnoreCase(lang.get())).findFirst();
    if (matchedLang.isEmpty()) {
      log.info("Can't have language: {}", lang);
      return Result.err(
          new NoMatchingCode(lang.get(), langs.stream().map(l -> l.getName()).toList()));
    }
    return Result.ok(matchedLang.map(l -> l.getCode()));
  }

  public Result<String, CodeError> vetStateCode(String state, String countryString) {
    List<String> stateCodes = cd.getStateCodes(this.court.code, countryString);
    if (stateCodes.isEmpty()) {
      FilingError err =
          FilingError.malformedInterview(
              "There are no allowed states for " + countryString + " in " + cd.getDomain());
      return Result.err(new BadCode(err));
    }
    if (!stateCodes.contains(state)) {
      return Result.err(new NoMatchingCode(state, stateCodes));
    }
    return Result.ok(state);
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

  /**
   * existingPartyCodes: str of Tyler party ID to their role code string newPartyCodes: str of our
   * generated ID of party to their role code string
   *
   * @return the combined map of tyler ids and our ids to each party type
   */
  public Result<Map<PartyId, PartyInfo>, CodeError> vetPartyTypes(
      Collection<Person> existingParties,
      Collection<Person> newParties,
      CaseType type,
      boolean isFirstIndexedFiling) {
    List<PartyType> pTypesForCase = cd.getPartyTypeFor(court.code, type.code);
    Map<String, PartyType> codeToPartyType =
        pTypesForCase.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
    Set<String> requiredTypes =
        pTypesForCase.stream()
            .filter(t -> t.isrequired)
            .map(t -> t.code)
            .collect(Collectors.toSet());
    Set<String> presentPartyTypes = new HashSet<>();
    // So, Tyler lies: it's possible for older cases to have party types that aren't allowed
    // on new cases anymore. So we'll make a backup map of all of the real party types, if
    // necessary.
    Map<String, PartyType> codeToAllPartyType = Map.of();
    Map<PartyId, PartyInfo> partyInfos = new HashMap<>();
    for (Person party : existingParties) {
      var key = party.getPartyId();
      if (party.getRole().isEmpty()) {
        log.warn("Existing party {} doesn't have a role?", key);
        continue;
      }
      var role = party.getRole().get();
      PartyInfo partyInfo = null;
      if (codeToPartyType.containsKey(role)) {
        partyInfo = new PartyInfo(codeToPartyType.get(role), party.getPartyId(), party.isOrg());
      } else {
        log.warn("Existing party " + key + "'s role (" + party.getRole() + ") isn't a code?");
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, null);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(role)) {
          partyInfo =
              new PartyInfo(codeToAllPartyType.get(role), party.getPartyId(), party.isOrg());
        } else {
          log.warn(
              "Existing party {}'s role ({}) still isn't a code?: {}",
              key,
              party.getRole(),
              codeToAllPartyType.keySet());
          continue;
        }
      }
      partyInfos.put(party.getPartyId(), partyInfo);
      presentPartyTypes.add(partyInfo.type().code);
    }
    for (Person party : newParties) {
      var key = party.getPartyId();
      if (party.getRole().isEmpty()) {
        log.warn("New party {} doesn't have a role?", key);
        continue;
      }
      var role = party.getRole().get();
      PartyInfo partyInfo = null;
      if (codeToPartyType.containsKey(role)) {
        partyInfo = new PartyInfo(codeToPartyType.get(role), party.getPartyId(), party.isOrg());
      } else {
        log.warn("New party " + key + "'s role (" + party.getRole() + ") isn't a code?");
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, type.code);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(role)) {
          partyInfo =
              new PartyInfo(codeToAllPartyType.get(role), party.getPartyId(), party.isOrg());
        } else {
          partyInfo =
              new PartyInfo(
                  PartyType.MissingType(role, type.code, court.code),
                  party.getPartyId(),
                  party.isOrg());
        }
      }
      partyInfos.put(party.getPartyId(), partyInfo);
      presentPartyTypes.add(partyInfo.type().code);
    }

    // We need to make sure the initial filing handles all required parties: subsequents we can
    // assume the required parties are there
    if (isFirstIndexedFiling) {
      requiredTypes.removeAll(presentPartyTypes);
      if (!requiredTypes.isEmpty()) {
        FilingError err =
            FilingError.serverError(
                "DEV ERROR: All required parties not covered by existing party types. ("
                    + presentPartyTypes
                    + ". Missing "
                    + requiredTypes);
        return Result.err(new BadCode(err));
      }
    }

    return Result.ok(partyInfos);
  }

  public Result<List<PartyId>, RequiredFilingParty> vetFilingParties(List<PartyId> filingParties) {
    // TODO(brycew): needs to handle when we can avoid using filing party ids
    if (filingParties.isEmpty()) {
      return Result.err(new RequiredFilingParty());
    }
    return Result.ok(filingParties);
  }

  // TODO: do good tests here
  public Result<Optional<NameAndCode>, CodeError> vetMotionCode(
      Optional<String> motionCode, FilingCode filing) {
    DataFieldRow motionRow = allDataFields.getFieldRow("FilingMotionType");
    if (!motionRow.isvisible) {
      return Result.ok(Optional.empty());
    }
    if (!motionRow.isrequired && motionCode.isEmpty()) {
      return Result.ok(Optional.empty());
    }
    List<NameAndCode> motionTypes = cd.getMotionTypes(this.court.code, filing.code);
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
      List<InputOptionalService> servs, FilingCode filing) {
    if (servs.isEmpty()) {
      return Result.ok(List.of());
    }

    List<OptionalServiceCode> codes = cd.getOptionalServices(this.court.code, filing.code);
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

  public List<FilingComponent> retrieveFilingComponents(FilingCode filingCode) {
    return cd.getFilingComponents(this.court.code, filingCode.code);
  }

  /**
   * NOTE: modifies the components list, removing the selected component if allowmultiple is false.
   *
   * @param filingComponent
   * @param components
   * @param collector
   * @return
   */
  public Result<FilingComponent, CodeError> vetFilingComponent(
      String filingComponent, ArrayList<FilingComponent> components) {
    if (components.isEmpty()) {
      log.error("Filing Components are empty! There are no other documents that can be added!");
      return Result.err(new NoMatchingCode(filingComponent, List.of()));
    }

    Optional<FilingComponent> filtered =
        components.stream().filter(c -> c.code.equalsIgnoreCase(filingComponent)).findFirst();
    if (filtered.isEmpty()) {
      log.error("Filing Components (" + components + ") don't match \"" + filingComponent + "\".");
      return Result.err(
          new NoMatchingCode(filingComponent, components.stream().map(c -> c.code).toList()));
    }
    var filt = filtered.get();
    if (!filt.allowmultiple) {
      components.remove(filt);
    }
    return Result.ok(filt);
  }

  // TODO(brycew): should add helptext / validationmessage from DataField?
  public Result<Optional<DocumentTypeTableRow>, CodeError> vetDocType(
      String docTypeStr, FilingCode filing) {
    // Literally should just be if it's confidential or not. (or "Hot fix" or public).
    // Search options in "documenttype" table with location
    DataFieldRow documentType = allDataFields.getFieldRow("DocumentType");
    if (documentType.isvisible) {
      List<DocumentTypeTableRow> docTypes = cd.getDocumentTypes(court.code, filing.code);
      if (documentType.isrequired && docTypeStr.isBlank()) {
        return Result.err(new RequiredCodeNotPresent(docTypes.stream().map(d -> d.code).toList()));
      }

      Optional<DocumentTypeTableRow> code =
          docTypes.stream().filter(d -> d.code.equals(docTypeStr)).findFirst();
      if (code.isPresent()) {
        return Result.ok(code);
      }
      return Result.err(
          new NoMatchingCode(docTypeStr, docTypes.stream().map(d -> d.code).toList()));
    }
    return Result.ok(Optional.empty());
  }

  public Result<Optional<FilerType>, CodeError> vetFilerType(Optional<String> maybeFilerType) {
    DataFieldRow filertype = allDataFields.getFieldRow("FilingFilerType");
    if (filertype.isvisible) {
      List<FilerType> allTypes = cd.getFilerTypes(this.court.code);
      // allTypes.stream().map(t -> t.code).toList());
      if (maybeFilerType.isPresent()) {
        String filerType = maybeFilerType.get();
        Optional<FilerType> typeInfo =
            allTypes.stream().filter(t -> t.code.equalsIgnoreCase(filerType)).findFirst();
        if (typeInfo.isEmpty()) {
          return Result.err(
              new NoMatchingCode(filerType, allTypes.stream().map(t -> t.code).toList()));
        }
        return Result.ok(typeInfo);
      } else {
        // Choose a default, if there's one present.
        Optional<FilerType> defaultType = allTypes.stream().filter(t -> t.isDefault).findFirst();
        if (defaultType.isPresent()) {
          return Result.ok(defaultType);
        } else if (filertype.isrequired) {
          return Result.err(
              new RequiredCodeNotPresent(allTypes.stream().map(t -> t.code).toList()));
        }
      }
    }
    return Result.ok(Optional.empty());
  }

  // Note: older versions of this code passed back a list of proc/rem codes. Doesn't make a ton of
  // sense,
  // and Tyler's docs only refer to the code in the singular. So only returning one here.
  public Result<Optional<NameAndCode>, CodeError> vetProcedureRemedy(
      Optional<String> maybeProRem, boolean initial, CaseCategory cat) {
    List<NameAndCode> procedureRemedies = cd.getProcedureOrRemedy(this.court.code, cat.getCode());
    String procedureViewName = "CivilCaseProcedureView" + ((initial) ? "Initial" : "Subsequent");
    DataFieldRow procedureView = DataFieldRow.MissingDataField(procedureViewName);
    String procBehavior = (initial) ? cat.procedureremedyinitial : cat.procedureremedysubsequent;
    if (!procBehavior.isEmpty() && !procBehavior.equals("Not Available")) {
      procedureView = allDataFields.getFieldRow(procedureViewName);
    }
    if (maybeProRem.isPresent()) {
      var proRemCode = maybeProRem.get();
      if (procedureView.isvisible) {
        Optional<NameAndCode> maybeProcedures =
            procedureRemedies.stream().filter(nac -> nac.getCode().equals(proRemCode)).findFirst();
        if (maybeProcedures.isEmpty()) {
          return Result.err(
              new NoMatchingCode(
                  proRemCode, procedureRemedies.stream().map(pr -> pr.getCode()).toList()));
        }
        return Result.ok(maybeProcedures);
      } else {
        log.info(
            "Dropping procedure_remedy "
                + proRemCode
                + ", since isvisible is false for "
                + this.court.code);
      }
    } else {
      if (procedureView.isrequired) {
        return Result.err(
            new RequiredCodeNotPresent(
                procedureRemedies.stream().map(pr -> pr.getCode()).toList()));
      }
    }
    return Result.ok(Optional.empty());
  }

  public Result<Optional<NameAndCode>, CodeError> vetDamageAmount(
      boolean initial, CaseCategory cat, Optional<String> maybeDamageAmount) {
    String courtLocationId = this.court.code;
    DataFieldRow damageConfig = allDataFields.getFieldRow("DamageAmount");
    String damgBehavior = (initial) ? cat.damageamountinitial : cat.damageamountsubsequent;
    if (!damgBehavior.isEmpty() && !damgBehavior.equals("Not Available")) {
      damageConfig =
          allDataFields.getFieldRow(
              "CivilCaseDamageAmount" + ((initial) ? "Initial" : "Subsequent"));
    }

    List<NameAndCode> damageAmounts = cd.getDamageAmount(courtLocationId, cat.getCode());
    if (maybeDamageAmount.isEmpty()) {
      if (damageConfig.isrequired) {
        return Result.err(
            new RequiredCodeNotPresent(damageAmounts.stream().map(da -> da.getCode()).toList()));
      } else {
        return Result.ok(Optional.empty());
      }
    }
    String damageAmountCode = maybeDamageAmount.get();
    if (damageConfig.isvisible) {
      Optional<NameAndCode> maybeDmg =
          damageAmounts.stream().filter(nac -> nac.getName().equals(damageAmountCode)).findFirst();
      if (maybeDmg.isPresent()) {
        return Result.ok(maybeDmg);
      } else {
        return Result.err(
            new NoMatchingCode(
                damageAmountCode, damageAmounts.stream().map(da -> da.getCode()).toList()));
      }
    } else {
      log.info(
          "Dropping damage_amount {}, since isvisible is false for {}",
          damageAmountCode,
          courtLocationId);
      return Result.ok(Optional.empty());
    }
  }

  ////////  Still TODO
  // Filing Associations
  // Anything else not currently checked

  // TODO: should rebuild attySet from scratch if it doesn't exist
  public Result<Optional<Map<PartyId, List<String>>>, AttorneyError> vetPartyAttorneyMap(
      Map<PartyId, List<String>> partyAttyMap,
      Collection<PartyId> partyIdSet,
      Collection<String> attySet) {
    DataFieldRow attRow = allDataFields.getFieldRow("PartyAttorney");
    if (!attRow.isvisible) {
      return Result.ok(Optional.empty());
    }
    for (Map.Entry<PartyId, List<String>> partyAttys : partyAttyMap.entrySet()) {
      log.info("Setting Attorneys for : {}", partyAttys.getKey());
      if (partyIdSet.isEmpty()) {
        log.warn(
            "No current filing parties, but {} is in the current filing?",
            partyAttys.getKey().getIdString());
        continue;
      } else if (!partyIdSet.contains(partyAttys.getKey())) {
        log.warn(
            "Can't handle current filing participant ({}) not already added?!",
            partyAttys.getKey().getIdString());
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
      for (String atty : partyAttys.getValue()) {
        if (!attySet.contains(atty)) {
          log.warn("Party attorney {} not present in attorney list? {}", atty, attySet);
        }
      }
    }

    return Result.ok(Optional.of(partyAttyMap));
  }

  // Should only return MissingVar
  // TODO: should check that filing attorney is in Atty set
  public Result<Optional<String>, TextVarError> vetFilingAttorney(Optional<String> filingAttorney) {
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

  public Result<List<String>, TextVarError> vetPhoneNumbers(List<String> numbers) {
    DataFieldRow phoneRow = allDataFields.getFieldRow("PartyPhone");
    if (phoneRow.isvisible) {
      if (phoneRow.isrequired && numbers.isEmpty()) {
        return Result.err(new MissingVar(phoneRow.regularexpression));
      }
      if (numbers.isEmpty()) {
        // if just visible but not required, keep the empty list
        return Result.ok(List.of());
      }
      var correctNumbers =
          numbers.stream()
              .map(
                  number -> {
                    if (phoneRow.matchRegex(number)) {
                      return number;
                    }
                    // HACK(brycew): Massachusetts doesn't like dashes in the number, just wants
                    // numbers
                    if (number.contains("+")) {
                      // there should be a space between the country code and the rest of the
                      // number, but no where else??
                      // TODO(brycew): really just needs to be checked in docassemble itself
                      return number.replace("-", "").replace("(", "").replace(")", "").strip();
                    } else {
                      return number
                          .replace("-", "")
                          .replace("(", "")
                          .replace(")", "")
                          .replace(" ", "");
                    }
                  })
              .filter(
                  number -> {
                    if (number.isEmpty()) {
                      return false;
                    }
                    return phoneRow.matchRegex(number);
                  })
              .toList();
      if (correctNumbers.isEmpty()) {
        return Result.err(new WrongVar(numbers.toString(), phoneRow.regularexpression));
      }
      return Result.ok(correctNumbers);
    }
    return Result.ok(List.of());
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

  public Result<Optional<Gender>, TextVarError> vetGender(Optional<String> gender) {
    DataFieldRow genderRow = allDataFields.getFieldRow("PartyGender");
    if (genderRow.isvisible) {
      if (gender.isEmpty()) {
        // Whether or not it's required, going to set unknown
        return Result.ok(Optional.of(Gender.UNKNOWN));
      }
      var genderString = gender.get();
      if (genderString.equalsIgnoreCase("male") || genderString.equalsIgnoreCase("m")) {
        return Result.ok(Optional.of(Gender.MALE));
      } else if (genderString.equalsIgnoreCase("female") || genderString.equals("f")) {
        return Result.ok(Optional.of(Gender.FEMALE));
      } else if (genderString.equalsIgnoreCase("nonbinary") || genderString.equals("nb")) {
        return Result.ok(Optional.of(Gender.NONBINARY));
      } else {
        return Result.ok(Optional.of(Gender.OTHER));
      }
    } else {
      return Result.ok(Optional.empty());
    }
  }

  public Result<Optional<String>, TextVarError> vetFilingRefNum(Optional<String> fileRefNum) {
    DataFieldRow fileRefRow = allDataFields.getFieldRow("FilingReferenceNumber");
    if (fileRefRow.isvisible) {
      if (fileRefNum.isEmpty() && fileRefRow.isrequired) {
        return Result.err(new MissingVar(fileRefRow.regularexpression));
      }
      return Result.ok(fileRefNum);
    }
    return Result.ok(Optional.empty());
  }

  public Result<Optional<String>, TextVarError> vetComment(Optional<String> maybeComment) {
    DataFieldRow commentRow = allDataFields.getFieldRow("FilingFilingComments");
    String comment = maybeComment.orElse("");
    if (commentRow.isvisible) {
      if (!commentRow.matchRegex(comment)) {
        return Result.err(new WrongVar(comment, commentRow.regularexpression));
      }
      // I absolutely refuse to require comments from the user on each individual document.
      if (commentRow.isrequired) {
        log.error(
            "Dev Ops Error: Comments are required per filing document apparently. "
                + "Not being forced yet");
        return Result.ok(Optional.of("(No comment)"));
      }
      return Result.ok(Optional.of(comment));
    }
    return Result.ok(Optional.empty());
  }

  public Result<Optional<LocalDate>, DueDateRequired> vetDueDate(
      Optional<LocalDate> dueDate, FilingCode filing) {
    DataFieldRow dueDateRow = allDataFields.getFieldRow("DueDateAvailableForFilers");
    if (filing.useduedate && dueDateRow.isvisible) {
      if (dueDate.isEmpty() && dueDateRow.isrequired) {
        return Result.err(new DueDateRequired());
      }
      return Result.ok(dueDate);
    }
    return Result.ok(Optional.empty());
  }

  public Result<Optional<FilingAction>, InvalidFilingAction> vetFilingAction(
      Optional<FilingAction> filingAction, boolean isInitialFiling, boolean hasServiceContacts) {
    if (filingAction.isPresent()) {
      FilingAction act = filingAction.get();
      boolean serviceOnInitial =
          switch (this.court.allowserviceoninitial) {
            case TRUE -> true;
            case FALSE -> false;
            case DEFAULT -> allDataFields.getFieldRow("FilingServiceCheckBoxInitial").isvisible;
          };
      boolean tryingToDoService = (act.equals(FilingAction.E_FILE_AND_SERVE) || act.equals(FilingAction.SERVE) || hasServiceContacts);
      if (isInitialFiling
          && !serviceOnInitial
          && tryingToDoService) {
        return Result.err(new InvalidFilingAction("Cannot do service on initial filing"));
      }
      DataFieldRow checkBoxSub = allDataFields.getFieldRow("FilingServiceCheckBoxSubsequent");
      if (!isInitialFiling && !checkBoxSub.isvisible && tryingToDoService) {
        return Result.err(new InvalidFilingAction("Court " + this.court.name + " cannot do service on subsequent filings"));
      }
    }
    return Result.ok(filingAction);
  }

  public Optional<String> getDocumentDescription(
      String description, String firstFileName, FilingCode filing) {
    DataFieldRow row = allDataFields.getFieldRow("DocumentDescription");
    if (!row.isvisible) {
      return Optional.empty();
    }
    if (!description.isBlank()) {
      return Optional.of(description);
    } else {
      if (this.court.defaultdocumentdescription.equals("1")) {
        return Optional.of(filing.name);
      } else if (this.court.defaultdocumentdescription.equals("2")) {
        return Optional.of(firstFileName);
      } else if (row.defaultvalueexpression.equals("{{FilingCodeDescription}}")) {
        return Optional.of(filing.name);
      } else if (row.defaultvalueexpression.equals("{{FileName}}")) {
        return Optional.of(firstFileName);
      } else if (row.isrequired) {
        log.warn(
            "DEVOPS Error: A document description is required, but not as Tyler defines in their docs: {}",
            row.defaultvalueexpression);
        return Optional.of("A document");
      } else {
        return Optional.of(row.defaultvalueexpression);
      }
    }
  }

  public Result<String, FileNameError> vetFileName(String fileName) {
    List<FileType> allowedFileTypes = cd.getAllowedFileTypes(this.court.code);
    if (allowedFileTypes.stream().noneMatch(t -> t.matchesFile(fileName))) {
      return Result.err(new FileExtensionNotAllowed(fileName, allowedFileTypes));
    }
    DataFieldRow originalName = allDataFields.getFieldRow("OriginalFileName");
    if (!originalName.matchRegex(fileName)) {
      return Result.err(
          new FileNameTextError(new WrongVar(fileName, originalName.regularexpression)));
    }
    if (fileName.length() > 50) {
      return Result.err(new FileNameTextError(new TooLongVar(fileName, 50)));
    }
    return Result.ok(fileName);
  }

  public Result<NullValue, FilingDocError> vetFilingDocSize(List<FilingDoc> docs) {
    MeasureType maxIndivDocSize = policy.getMaximumAllowedAttachmentSize();
    long maxEach = Ecf4Helper.sizeMeasureAsBytes(maxIndivDocSize);
    long cumulativeBytes = 0;
    for (int i = 0; i < docs.size(); i++) {
      var doc = docs.get(i);
      long docSize = doc.allAttachmentsLength();
      if (docSize > maxEach) {
        return Result.err(new DocTooBig(i));
      }
      cumulativeBytes += docSize;
    }
    MeasureType maxTotalDocSize = policy.getMaximumAllowedMessageSize();
    long maxTotal = Ecf4Helper.sizeMeasureAsBytes(maxTotalDocSize);
    if (cumulativeBytes > maxTotal) {
      return Result.err(new CumulativeDocsTooBig(cumulativeBytes));
    }
    return Result.nullOk();
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
