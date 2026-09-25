package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.model.FilingAction;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.model.Person.Gender;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.PartyType;
import edu.suffolk.litlab.efsp.utils.FilingError;
import gov.niem.niem.niem_core._2.MeasureType;
import java.math.BigDecimal;
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
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TFCodesParser implements CodesParser {
  private static Logger log = LoggerFactory.getLogger(TFCodesParser.class);

  private final TFCodeDatabase cd;
  private final String court;
  private final DevelopmentPolicyParametersType policy;

  public TFCodesParser(TFCodeDatabase cd, DevelopmentPolicyParametersType policy, String court) {
    this.cd = cd;
    this.court = court;
    this.policy = policy;
  }

  public static Optional<CodesParser> makeParser(
      TFCodeDatabase cd, DevelopmentPolicyParametersType policy, String courtId) {
    return Optional.of(new TFCodesParser(cd, policy, courtId));
  }

  @Override
  public void close() throws Exception {
    if (this.cd != null) {
      this.cd.close();
    }
  }

  @Override
  public Result<NameAndCode, CodeError> vetCaseCat(String caseCategoryCode) {
    var codes = cd.getCaseCategories(court);
    Optional<CaseCategory> maybeCaseCat =
        codes.stream().filter(c -> c.code().equals(caseCategoryCode)).findFirst();
    if (maybeCaseCat.isPresent()) {
      return Result.ok(maybeCaseCat.get());
    } else {
      return Result.err(
          new NoMatchingCode(caseCategoryCode, codes.stream().map(c -> c.getCode()).toList()));
    }
  }

  @Override
  public Result<NameAndCode, CodeError> vetCaseType(
      String caseTypeCode, NameAndCode caseCategory, boolean isInitialFiling) {
    var namesAndCodes = cd.getCaseTypeNamesFor(court, caseCategory.code(), Optional.empty());
    Optional<NameAndCode> maybeCaseType =
        namesAndCodes.stream().filter(nac -> nac.code().equals(caseTypeCode)).findFirst();
    if (maybeCaseType.isPresent()) {
      return Result.ok(maybeCaseType.get());
    } else {
      return Result.err(
          new NoMatchingCode(caseTypeCode, namesAndCodes.stream().map(nac -> nac.code()).toList()));
    }
  }

  @Override
  public Result<Optional<NameAndCode>, NoMatchingCode> vetSubType(
      String subtypeCode, NameAndCode caseType) {
    // No subtypes in TrueFiling
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<List<NameAndCode>, BadCode> retrieveFilingOptions(
      NameAndCode caseCategory, NameAndCode type, boolean isInitialFiling) {
    var filingOptions = cd.getDocumentTypes(court, type.code());
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

  @Override
  public Result<NameAndCode, CodeError> vetFilingType(
      Optional<String> filingStr, List<NameAndCode> filingOptions) {
    if (filingStr.isEmpty()) {
      return Result.err(
          new RequiredCodeNotPresent(filingOptions.stream().map(f -> f.code()).toList()));
    }
    var maybeCode =
        filingOptions.stream().filter(fil -> fil.code().equals(filingStr.get())).findFirst();
    return maybeCode
        .map(c -> Result.<NameAndCode, CodeError>ok(c))
        .orElseGet(
            () -> {
              log.error("Nothing matches filing `{}` in the info!", filingStr);
              List<String> options = filingOptions.stream().map(f -> f.code()).toList();
              return Result.err(new NoMatchingCode(filingStr.get(), options));
            });
  }

  @Override
  public Result<String, CodeError> vetSuffix(Optional<String> suffix) {
    return Result.ok(suffix.orElse(""));
  }

  @Override
  public Result<Optional<String>, CodeError> vetLangCode(Optional<String> lang) {
    // No vetting of the lang code
    return Result.ok(lang);
  }

  @Override
  public Result<String, CodeError> vetStateCode(String state, String countryString) {
    // No vetting of the state code
    return Result.ok(state);
  }

  @Override
  public Result<Map<String, String>, CrossReferenceError> getCrossRefIds(
      Map<String, String> crossRefs, NameAndCode caseType) {
    return Result.ok(crossRefs);
  }

  @Override
  public Result<Map<PartyId, PartyInfo>, CodeError> vetPartyTypes(
      Collection<Person> existingParties,
      Collection<Person> newParties,
      NameAndCode type,
      boolean isFirstIndexedFiling) {

    List<NameAndCode> pTypesForCase = cd.getPartyTypeFor(court);
    Map<String, NameAndCode> codeToPartyType =
        pTypesForCase.stream().collect(Collectors.toMap(pt -> pt.code(), pt -> pt));
    Set<String> requiredTypes = new HashSet<>();
    // TODO: bryce: the real requirements are:
    // PET + RESP, or MPET + ADBM + RESP, or PET + ADBM + RESP, or MPET + ADBM + MRESP + ADBM
    // Haven't coded handling those combinations yet.
    // .filter(t -> t.isrequired)
    // .map(t -> t.code())
    // .collect(Collectors.toSet());
    Set<String> presentPartyTypes = new HashSet<>();
    // it (might be, haven't tested for TrueFiling) possible for older cases to have party types
    // that aren't allowed
    // on new cases anymore. So we'll make a backup map of all of the real party types, if
    // necessary.
    Map<String, NameAndCode> codeToAllPartyType = Map.of();
    Map<PartyId, PartyInfo> partyInfos = new HashMap<>();
    for (Person party : existingParties) {
      var key = party.getPartyId();
      if (key.isAlreadyInCase() && key.getIdentificationString().contains(" ")) {
        FilingError err =
            FilingError.serverError(
                "Party ID " + key.getIdentificationString() + " should be a GUID but isn't");
        return Result.err(new BadCode(err));
      }
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
          var allForCourt = cd.getPartyTypeFor(court);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code(), pt -> pt));
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
      presentPartyTypes.add(partyInfo.type().code());
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
          var allForCourt = cd.getPartyTypeFor(court);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code(), pt -> pt));
        }
        if (codeToAllPartyType.containsKey(role)) {
          partyInfo =
              new PartyInfo(codeToAllPartyType.get(role), party.getPartyId(), party.isOrg());
        } else {
          partyInfo =
              new PartyInfo(
                  PartyType.MissingType(role, type.code(), court),
                  party.getPartyId(),
                  party.isOrg());
        }
      }
      partyInfos.put(party.getPartyId(), partyInfo);
      presentPartyTypes.add(partyInfo.type().code());
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

  @Override
  public Result<List<PartyId>, ThingRequired> vetFilingParties(List<PartyId> filingParties) {
    return Result.ok(filingParties);
  }

  @Override
  public Result<Optional<NameAndCode>, CodeError> vetMotionCode(
      Optional<String> motionCode, NameAndCode filing) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<List<OptionalService>, List<CodeError>> vetOptionalServices(
      List<InputOptionalService> servs, NameAndCode filing) {
    return Result.ok(List.of());
  }

  @Override
  public List<NameAndCode> retrieveFilingComponents(NameAndCode filingCode) {
    return List.of();
  }

  @Override
  public Result<Optional<NameAndCode>, CodeError> vetFilingComponent(
      String filingComponent, ArrayList<NameAndCode> components) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<Optional<NameAndCode>, CodeError> vetFilerType(Optional<String> maybeFilerType) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<Optional<NameAndCode>, CodeError> vetDocType(
      String docTypeStr, NameAndCode filing) {
    // Even though Truefilings things are called DocumentTypes, they are nested under case types,
    // and act more like Tyler's Filing types, so we call them that.
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<Optional<NameAndCode>, CodeError> vetDamageAmount(
      boolean initial, NameAndCode cat, Optional<String> maybeDamageAmount) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<Optional<NameAndCode>, CodeError> vetProcedureRemedy(
      Optional<String> maybeProRem, boolean initial, NameAndCode cat) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<Optional<Map<PartyId, List<String>>>, AttorneyError> vetPartyAttorneyMap(
      Map<PartyId, List<String>> partyAttyMap,
      Collection<PartyId> partyIdSet,
      Collection<String> attySet) {
    for (Map.Entry<PartyId, List<String>> partyAttys : partyAttyMap.entrySet()) {
      for (String atty : partyAttys.getValue()) {
        if (!attySet.contains(atty)) {
          log.warn("Party attorney {} not present in attorney list? {}", atty, attySet);
        }
      }
    }
    return Result.ok(Optional.of(partyAttyMap));
  }

  @Override
  public Result<Optional<String>, TextVarError> vetFilingAttorney(Optional<String> filingAttorney) {
    return Result.ok(filingAttorney);
  }

  @Override
  public Result<Optional<String>, TextVarError> vetEmail(Optional<String> email) {
    return Result.ok(email);
  }

  @Override
  public Result<List<String>, TextVarError> vetPhoneNumbers(List<String> numbers) {
    return Result.ok(numbers);
  }

  @Override
  public Result<String, TextVarError> vetFirstName(Optional<String> name) {
    return Result.ok(name.orElse(""));
  }

  @Override
  public Result<String, TextVarError> vetMiddleName(Optional<String> name) {
    return Result.ok(name.orElse(""));
  }

  @Override
  public Result<String, TextVarError> vetLastName(Optional<String> name) {
    return Result.ok(name.orElse(""));
  }

  @Override
  public Result<String, TextVarError> vetOrgName(String name) {
    return Result.ok(name);
  }

  @Override
  public Result<Optional<Gender>, TextVarError> vetGender(Optional<String> gender) {
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
  }

  @Override
  public Result<Optional<String>, TextVarError> vetFilingRefNum(Optional<String> fileRefNum) {
    return Result.ok(fileRefNum);
  }

  @Override
  public Result<Optional<String>, TextVarError> vetComment(Optional<String> comment) {
    return Result.ok(comment);
  }

  @Override
  public Result<Optional<LocalDate>, DueDateRequired> vetDueDate(
      Optional<LocalDate> dueDate, NameAndCode filing) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Result<Optional<FilingAction>, InvalidFilingAction> vetFilingAction(
      Optional<FilingAction> filingAction, boolean isInitialFiling, boolean hasServiceContacts) {
    // Can only do e-filing, no service.
    return Result.ok(Optional.of(FilingAction.E_FILE));
  }

  @Override
  public Optional<String> getDocumentDescription(
      String description, String firstFileName, NameAndCode filing) {
    // From TrueFiling: CaseTitleText – use “*** NO CASE DESCRIPTION PROVIDED BY COURT ***” as this
    // is the default case title. Case titles are assigned by the court after submissions are
    // accepted.
    return Optional.of(description);
  }

  @Override
  public Result<String, FileNameError> vetFileName(String fileName) {
    return Result.ok(fileName);
  }

  @Override
  public Result<NullValue, FilingDocError> vetFilingDocSize(List<FilingDoc> docs) {
    MeasureType maxIndivDocSize = policy.getMaximumAllowedAttachmentSize();
    long maxEach = Ecf4Helper.sizeMeasureAsBytes(maxIndivDocSize);
    long cumulativeBytes = 0;
    for (int i = 0; i < docs.size(); i++) {
      var doc = docs.get(i);
      long docSize = doc.allAttachmentsLength();
      if (docSize > maxEach) {
        var docName =
            doc.getDescription().map(d -> d.get()).orElse(doc.getFilingComments().orElse(""));
        return Result.err(new DocTooBig(docName, docSize, maxEach));
      }
      cumulativeBytes += docSize;
    }
    MeasureType maxTotalDocSize = policy.getMaximumAllowedMessageSize();
    long maxTotal = Ecf4Helper.sizeMeasureAsBytes(maxTotalDocSize);
    if (cumulativeBytes > maxTotal) {
      return Result.err(new CumulativeDocsTooBig(cumulativeBytes, maxTotal));
    }
    return Result.nullOk();
  }

  @Override
  public Result<Optional<BigDecimal>, ThingRequired> vetAmountInControversy(
      Optional<BigDecimal> amt, List<NameAndCode> filings) {
    return Result.ok(Optional.empty());
  }

  @Override
  public Optional<BigDecimal> vetMaxAmount(Optional<BigDecimal> maxAmount) {
    // No amounts at the moment.
    return Optional.empty();
  }

  // Making this for "Person associations"? I think it's the same thing.
  @Override
  public boolean useFilingAssociations() {
    return false;
  }
}
