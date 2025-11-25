package edu.suffolk.litlab.efsp.server.ecf4;

import com.fasterxml.jackson.databind.JsonNode;
import ecf4.latest.gov.niem.niem.fbi._2.SEXCodeSimpleType;
import ecf4.latest.gov.niem.niem.fbi._2.SEXCodeType;
import ecf4.latest.gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;
import ecf4.latest.gov.niem.niem.fips_10_4._2.CountryCodeType;
import ecf4.latest.gov.niem.niem.iso_639_3._2.LanguageCodeType;
import ecf4.latest.gov.niem.niem.niem_core._2.AddressType;
import ecf4.latest.gov.niem.niem.niem_core._2.ContactInformationType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import ecf4.latest.gov.niem.niem.niem_core._2.NonNegativeDecimalType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonLanguageType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameTextType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType;
import ecf4.latest.gov.niem.niem.niem_core._2.ProperNameTextType;
import ecf4.latest.gov.niem.niem.niem_core._2.StreetType;
import ecf4.latest.gov.niem.niem.niem_core._2.StructuredAddressType;
import ecf4.latest.gov.niem.niem.niem_core._2.TelephoneNumberType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Base64Binary;
import ecf4.latest.gov.niem.niem.usps_states._2.USStateCodeSimpleType;
import ecf4.latest.gov.niem.niem.usps_states._2.USStateCodeType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentAttachmentType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentMetadataType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.tyler.ecf.extensions.common.CapabilityType;
import ecf4.latest.tyler.ecf.extensions.common.DocumentOptionalServiceType;
import ecf4.latest.tyler.ecf.extensions.common.DocumentType;
import ecf4.latest.tyler.ecf.extensions.common.FilingTypeType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.ComboCaseCodes;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FileType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.OptionalServiceCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;
import edu.suffolk.litlab.efsp.model.Address;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.FilingAction;
import edu.suffolk.litlab.efsp.model.FilingAttachment;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.stdlib.NonEmptyString;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import jakarta.xml.bind.JAXBElement;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcfCourtSpecificSerializer {
  private static Logger log = LoggerFactory.getLogger(EcfCourtSpecificSerializer.class);

  private final CodeDatabase cd;
  private final CourtLocationInfo court;
  public final DataFields allDataFields;
  private static final ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory niemObjFac =
      new ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory();
  private static final ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory coreObjFac =
      new ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory();
  private static final ecf4.latest.gov.niem.niem.iso_639_3._2.ObjectFactory iso639Fac =
      new ecf4.latest.gov.niem.niem.iso_639_3._2.ObjectFactory();
  private static final ecf4.latest.tyler.ecf.extensions.common.ObjectFactory tylerObjFac =
      new ecf4.latest.tyler.ecf.extensions.common.ObjectFactory();
  private static final ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
          .ObjectFactory
      ecfOf =
          new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
              .ObjectFactory();

  public EcfCourtSpecificSerializer(CodeDatabase cd, CourtLocationInfo court) {
    this.cd = cd;
    this.court = court;
    this.allDataFields = cd.getDataFields(court.code);
  }

  /**
   * Given the case info from a case that's already in the court's system on a subsequent filing.
   */
  public ComboCaseCodes serializeCaseCodesIndexed(
      String caseCategoryCode,
      String caseTypeCode,
      List<String> filingCodeStrs,
      Map<String, Person> existingParties,
      Map<String, Person> newParties,
      InfoCollector collector)
      throws FilingError {
    CaseCategory caseCategory =
        vetCaseCat(cd.getCaseCategoryWithCode(this.court.code, caseCategoryCode), collector);
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
        cd.getCaseCategoryWithCode(this.court.code, info.getCaseCategoryCode());
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
        info.getFilings().stream()
            .map(f -> f.getFilingCode().orElse(""))
            .collect(Collectors.toList());
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
              categories.stream().map(cat -> cat.code).collect(Collectors.toList()),
              caseCat.map(CaseCategory::getCode));
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
              "efile_case_type",
              "",
              "choice",
              caseTypes.stream().map(type -> type.name).collect(Collectors.toList()),
              maybeType.map(CaseType::toString));
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
          FilingError.malformedInterview("A Subsequent filing can't be filed at " + court.name);
      collector.error(err);
    }

    return maybeType.get();
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
            .collect(Collectors.toList());

    collector.pushAttributeStack("al_court_bundle[i]");
    if (filingOptions.isEmpty()) {
      log.error(
          "Need a filing type! FilingTypes are empty, so {} and {} are restricted",
          caseCategory,
          type);
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
                  filingOptions.stream().map(f -> f.code).collect(Collectors.toList()),
                  Optional.of(maybeCodeStrs.get(idx)));
          collector.addWrong(filingVar);
          collector.popAttributeStack();
          throw FilingError.missingRequired(filingVar);
        }
        idx += 1;
      }
    }

    return maybeCodes.stream().map(f -> f.get()).collect(Collectors.toList());
  }

  /**
   * existingPartyCodes: str of Tyler party ID to their role code string newPartyCodes: str of our
   * generated ID of party to their role code string
   *
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
    // TODO(brycew): move more detailed vetting to be here: stuff in EcfCaseTypeFactory.java:263
    return partyInfo;
  }

  /**
   * Needs to have participant role set.
   *
   * @throws FilingError
   */
  public CaseParticipantType serializeEcfCaseParticipant(
      Person per, InfoCollector collector, List<PartyType> partyTypes) throws FilingError {
    final CaseParticipantType cpt = ecfOf.createCaseParticipantType();
    ContactInformationType cit = serializeEcfContactInformation(per.getContactInfo(), collector);
    if (per.isOrg()) {
      OrganizationAugmentationType aug = ecfOf.createOrganizationAugmentationType();
      aug.getContactInformation().add(cit);
      OrganizationType ot = ecfOf.createOrganizationType();
      DataFieldRow orgNameRow = allDataFields.getFieldRow("PartyBusinessName");
      if (!orgNameRow.matchRegex(per.getName().getFullName())) {
        InterviewVariable var =
            collector.requestVar(
                "name", "Name needs to match the regex: " + orgNameRow.regularexpression, "text");
        collector.addWrong(var);
      } else if (per.getName().getFullName().length() > 400) {
        InterviewVariable var =
            collector.requestVar("name", "Name needs to be shorter that 400 characters", "text");
        collector.addWrong(var);
      }
      ot.setOrganizationName(Ecf4Helper.convertText(per.getName().getFullName()));
      ot.setId(per.getIdString());
      ot.getRest().add(ecfOf.createOrganizationAugmentation(aug));
      cpt.setEntityRepresentation(ecfOf.createEntityOrganization(ot));
    } else {
      // Else, it's a person: add other optional person stuff
      PersonAugmentationType aug = ecfOf.createPersonAugmentationType();
      aug.getContactInformation().add(cit);

      PersonType pt = ecfOf.createPersonType();
      pt.setId(per.getIdString());

      // Tyler docs have this as the only thing in a person if "I am user" is true, but
      // get filing fees API call complains about the Surname being empty. So now, it's everywhere
      if (per.isFormFiller()) {
        var extObjFac = new ecf4.latest.tyler.ecf.extensions.common.ObjectFactory();
        CapabilityType ct = extObjFac.createCapabilityType();
        ct.setIAmThisUserIndicator(Ecf4Helper.convertBool(true));
        pt.setPersonCapability(extObjFac.createPersonCapability(ct));
      }

      pt.setPersonName(serializeNameType(per.getName(), collector));
      pt.setPersonAugmentation(aug);

      DataFieldRow genderRow = allDataFields.getFieldRow("PartyGender");
      if (genderRow.isvisible) {
        if (per.getGender().isPresent()) {
          String gen = per.getGender().get();
          SEXCodeType sct = new SEXCodeType();
          if (gen.equalsIgnoreCase("male") || gen.equalsIgnoreCase("m")) {
            sct.setValue(SEXCodeSimpleType.M);
          } else if (gen.equalsIgnoreCase("female") || gen.equals("f")) {
            sct.setValue(SEXCodeSimpleType.F);
          } else {
            sct.setValue(SEXCodeSimpleType.U);
          }
          pt.setPersonSex(niemObjFac.createPersonSexCode(sct));
        } else if (genderRow.isrequired) {
          InterviewVariable var = collector.requestVar("gender", "Gender of this filer", "text");
          collector.addRequired(var);
        }
      }

      if (per.getLanguage().isPresent()) {
        String lang = per.getLanguage().get();
        List<String> langs = cd.getLanguageNames(this.court.code);
        if (!langs.isEmpty() && !langs.contains(lang)) {
          log.info("Can't have language: {}", lang);
          collector.addWrong(
              collector.requestVar(
                  "language",
                  "The primary language of this person",
                  "choice",
                  langs,
                  Optional.of(lang)));
        }
        if (!langs.isEmpty()) {
          // TODO(brycew): currently taking the safer option: if no languages are specified, don't
          // add one
          // TODO(brycew): need to have an ISO 639_2 (language codes) converter, from general
          // language name
          /// https://en.wikipedia.org/wiki/List_of_ISO_639-2_codes
          LanguageCodeType lct = iso639Fac.createLanguageCodeType();
          PersonLanguageType plt = niemObjFac.createPersonLanguageType();
          plt.getLanguage().add(niemObjFac.createLanguageCode(lct));
          pt.setPersonPrimaryLanguage(plt);
        }
      }
      ;

      per.getBirthdate()
          .ifPresent(
              (bd) -> {
                pt.setPersonBirthDate(Ecf4Helper.convertDate(bd));
              });

      cpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
    }

    Optional<PartyType> matchingType =
        partyTypes.stream().filter(pt -> pt.code.equalsIgnoreCase(per.getRole())).findFirst();
    TextType tt = niemObjFac.createTextType();
    if (matchingType.isEmpty()) {
      InterviewVariable ptVar =
          collector.requestVar(
              "party_type",
              "Legal role of the party",
              "choices",
              partyTypes.stream().map(pt -> pt.code).collect(Collectors.toList()),
              Optional.of(per.getRole()));
      collector.addWrong(ptVar);
      tt.setValue("");
    } else {
      tt.setValue(matchingType.get().code);
    }
    cpt.setCaseParticipantRoleCode(tt);
    return cpt;
  }

  public ContactInformationType serializeEcfContactInformation(
      ContactInformation contactInfo, InfoCollector collector) throws FilingError {
    ContactInformationType cit = niemObjFac.createContactInformationType();
    if (contactInfo.getAddress().isPresent()) {
      Address addr = contactInfo.getAddress().get();
      JAXBElement<AddressType> contactMeans = serializeNiemContactMeans(addr, collector);
      cit.getContactMeans().add(contactMeans);
    }

    DataFieldRow phoneRow = allDataFields.getFieldRow("PartyPhone");
    if (phoneRow.isvisible) {
      List<String> numbers = contactInfo.getPhoneNumbers();
      InterviewVariable var =
          collector.requestVar(
              "phone_number",
              "Phone number with regex: " + phoneRow.regularexpression,
              "text",
              List.of(),
              Optional.of(numbers.toString()));
      if (phoneRow.isrequired && numbers.isEmpty()) {
        collector.addRequired(var);
      }
      boolean atLeastOnePhoneAdded = false;
      for (String phoneNumber : numbers) {
        if (!phoneRow.matchRegex(phoneNumber)) {
          if (phoneNumber.contains("-")) {
            // HACK(brycew): Massachusetts doesn't like dashes in the number, just numbers
            phoneNumber = phoneNumber.replace("-", "").replace("(", "").replace(")", "").strip();
          }
          if (!phoneRow.matchRegex(phoneNumber)) {
            continue;
          }
        }

        TelephoneNumberType tnt = niemObjFac.createTelephoneNumberType();
        FullTelephoneNumberType ftnt = niemObjFac.createFullTelephoneNumberType();
        ftnt.setTelephoneNumberFullID(Ecf4Helper.convertString(phoneNumber));
        tnt.setTelephoneNumberRepresentation(niemObjFac.createFullTelephoneNumber(ftnt));
        cit.getContactMeans().add(niemObjFac.createContactTelephoneNumber(tnt));
        atLeastOnePhoneAdded = true;
      }
      if (!numbers.isEmpty() && !atLeastOnePhoneAdded) {
        collector.addWrong(var);
      }
    }

    DataFieldRow emailRow = allDataFields.getFieldRow("PartyEmail");
    if (emailRow.isvisible) {
      InterviewVariable var =
          collector.requestVar("email", "Email with regex " + emailRow.regularexpression, "email");
      if (contactInfo.getEmail().isPresent()) {
        String em = contactInfo.getEmail().get();
        if (emailRow.matchRegex(em)) {
          cit.getContactMeans().add(niemObjFac.createContactEmailID(Ecf4Helper.convertString(em)));
        } else {
          collector.addWrong(var);
        }
      }
      if (emailRow.isrequired) {
        collector.addRequired(var);
      }
    }
    return cit;
  }

  public static tyler.efm.latest.services.schema.common.AddressType serializeTylerAddress(
      Address myAddr) throws FilingError {
    var efmObjFac = new tyler.efm.latest.services.schema.common.ObjectFactory();
    var addr = efmObjFac.createAddressType();
    addr.setAddressLine1(myAddr.getStreet());
    addr.setAddressLine2(myAddr.getApartment());
    addr.setCity(myAddr.getCity());
    var cct = Ecf4Helper.strToCountryCode(myAddr.getCountry());
    if (cct.isErr()) {
      throw FilingError.serverError("Country Code is wrong: " + myAddr.getCountry());
    }
    addr.setState(myAddr.getState());
    addr.setZipCode(myAddr.getZip());
    addr.setCountry(myAddr.getCountry());
    return addr;
  }

  /**
   * Returns the "ContactMeans" XML object from this address. Can be used in the ContactInformation
   * element.
   */
  public JAXBElement<AddressType> serializeNiemContactMeans(
      Address address, InfoCollector collector) throws FilingError {
    StreetType st = niemObjFac.createStreetType();
    st.setStreetFullText(
        Ecf4Helper.convertText(address.getStreet() + " " + address.getApartment()));
    StructuredAddressType sat = niemObjFac.createStructuredAddressType();
    sat.getAddressDeliveryPoint().add(niemObjFac.createLocationStreet(st));
    ProperNameTextType pntt = niemObjFac.createProperNameTextType();
    pntt.setValue(address.getCity());
    sat.setLocationCityName(pntt);
    var cctResult = Ecf4Helper.strToCountryCode(address.getCountry());
    if (cctResult.isErr()) {
      List<String> countries =
          Arrays.stream(CountryCodeSimpleType.values())
              .map((t) -> t.toString())
              .collect(Collectors.toList());
      InterviewVariable var =
          collector.requestVar(
              "country",
              "County of the World, in an address",
              "choices",
              countries,
              Optional.of(address.getCountry()));
      collector.addWrong(var);
    }
    CountryCodeType cct = cctResult.unwrapOrElseThrow();
    sat.setLocationCountry(niemObjFac.createLocationCountryFIPS104Code(cct));
    if (!fillStateCode(address.getState(), cct, sat)) {
      String countryString = cct.getValue();
      List<String> stateCodes = cd.getStateCodes(this.court.code, countryString);
      InterviewVariable var =
          collector.requestVar(
              "state",
              "State in a country",
              "choices",
              stateCodes,
              Optional.of(address.getState()));
      if (stateCodes.isEmpty()) {
        FilingError err =
            FilingError.malformedInterview(
                "There are no allowed states for " + countryString + " in " + cd.getDomain());
        collector.error(err);
      }
      collector.addWrong(var);
    }
    sat.setLocationPostalCode(Ecf4Helper.convertString(address.getZip()));
    var addressType = niemObjFac.createAddressType();
    addressType.setAddressRepresentation(niemObjFac.createStructuredAddress(sat));
    return niemObjFac.createContactMailingAddress(addressType);
  }

  /**
   * Returns the PersonNameType XML object from the given Name.
   *
   * @throws FilingError
   */
  public ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType serializeNameType(
      Name name, InfoCollector collector) throws FilingError {
    Function<String, PersonNameTextType> wrapName =
        (n) -> {
          PersonNameTextType t = niemObjFac.createPersonNameTextType();
          t.setValue(n);
          return t;
        };
    PersonNameType personName = niemObjFac.createPersonNameType();
    personName.setPersonGivenName(
        checkName(
            name.getFirstName(),
            allDataFields.getFieldRow("PartyFirstName"),
            collector,
            collector.requestVar(
                "name.first",
                "First name of a case party",
                "text",
                List.of(),
                Optional.of(name.getFirstName()))));
    personName.setPersonMaidenName(wrapName.apply(name.getMaidenName()));
    personName.setPersonMiddleName(
        checkName(
            name.getMiddleName(),
            allDataFields.getFieldRow("PartyMiddleName"),
            collector,
            collector.requestVar("name.middle", "Middle name of the case party", "text")));
    personName.setPersonSurName(
        checkName(
            name.getLastName(),
            allDataFields.getFieldRow("PartyLastName"),
            collector,
            collector.requestVar("name.last", "Last name of the case party", "text")));
    personName.setPersonNamePrefixText(wrapName.apply(name.getPrefix()));
    DataFieldRow suffixRow = allDataFields.getFieldRow("PartyNameSuffix");
    if (suffixRow.isvisible) {
      List<NameAndCode> suffixes = cd.getNameSuffixes(this.court.code);
      InterviewVariable var =
          collector.requestVar(
              "name.suffix",
              "Suffix of the name of the party",
              "choices",
              suffixes.stream().map(s -> s.getName()).collect(Collectors.toList()),
              Optional.of(name.getSuffix()));
      if (name.getSuffix().isBlank()) {
        if (suffixRow.isrequired) {
          // TODO(brycew-later):
          log.error(
              "DEV WARNING: why would you ever require a suffix? There aren't empty suffix codes at"
                  + " all.");
          collector.addRequired(var);
        } else {
          personName.setPersonNameSuffixText(wrapName.apply(name.getSuffix()));
        }
      } else {
        Optional<NameAndCode> suffix =
            suffixes.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name.getSuffix()))
                .findFirst();
        if (suffix.isEmpty()) {
          collector.addWrong(var);
        } else {
          personName.setPersonNameSuffixText(wrapName.apply(name.getSuffix()));
        }
      }
    }
    return personName;
  }

  private PersonNameTextType checkName(
      String name, DataFieldRow row, InfoCollector collector, InterviewVariable var)
      throws FilingError {
    if (!row.matchRegex(name)) {
      collector.addWrong(var.appendDesc(": must match regex: " + row.regularexpression));
    }
    if (name.length() > 100) {
      collector.addWrong(var.appendDesc(": can't exceed 100 characters"));
    }
    PersonNameTextType t = niemObjFac.createPersonNameTextType();
    t.setValue(name);
    return t;
  }

  public JAXBElement<DocumentType> filingDocToXml(
      FilingDoc doc,
      int sequenceNum,
      boolean isInitialFiling,
      CaseCategory caseCategory,
      CaseType motionType,
      FilingCode filing,
      boolean isIndividual,
      JsonNode miscInfo,
      InfoCollector collector)
      throws IOException, FilingError {
    DocumentType docType = tylerObjFac.createDocumentType();
    DataFieldRow row = allDataFields.getFieldRow("DocumentDescription");
    if (row.isvisible) {
      docType.setDocumentDescriptionText(
          Ecf4Helper.convertText(
              findDocumentDescription(doc.getDescription(), row, doc, filing, collector)));
    }
    List<FileType> allowedFileTypes = cd.getAllowedFileTypes(this.court.code);
    for (var attachment : doc.getFilingAttachments()) {
      boolean correctExtension =
          allowedFileTypes.stream().anyMatch(t -> t.matchesFile(attachment.getFileName()));
      if (!correctExtension) {
        FilingError err =
            FilingError.malformedInterview(
                "Extension of "
                    + attachment.getFileName()
                    + " not allowed! Try these instead: "
                    + allowedFileTypes);
        collector.error(err);
      }
    }

    DataFieldRow fileRefRow = allDataFields.getFieldRow("FilingReferenceNumber");
    if (fileRefRow.isvisible) {
      if (doc.getFilingReferenceNum().isPresent()) {
        docType.setDocumentFileControlID(
            Ecf4Helper.convertString(doc.getFilingReferenceNum().get()));
      } else if (fileRefRow.isrequired) {
        InterviewVariable var =
            collector.requestVar(
                "reference_number",
                "Reference Number for a document, given by the user? TODO(brycew)",
                "text");
        collector.addRequired(var);
      }
    }
    DataFieldRow dueDateRow = allDataFields.getFieldRow("DueDateAvailableForFilers");
    if (filing.useduedate && dueDateRow.isvisible) {
      if (doc.getDueDate().isPresent()) {
        DateType cutOffDate = Ecf4Helper.convertDate(doc.getDueDate().get());
        docType.setDocumentInformationCutOffDate(cutOffDate);
      } else if (dueDateRow.isrequired) {
        InterviewVariable var =
            collector.requestVar(
                "due_date",
                "The due date of the filing, some number of days after the filing.",
                "date");
        collector.addRequired(var);
      }
    }

    docType.setDocumentSequenceID(Ecf4Helper.convertString(Integer.toString(sequenceNum)));

    DocumentMetadataType metadata = ecfOf.createDocumentMetadataType();
    metadata.setRegisterActionDescriptionText(Ecf4Helper.convertText(filing.code));

    DataFieldRow attorneyRow = allDataFields.getFieldRow("FilingFilingAttorneyView");
    if (attorneyRow.isvisible) {
      if (doc.getFilingAttorney().isPresent() && !doc.getFilingAttorney().get().isBlank()) {
        metadata.setFilingAttorneyID(
            Ecf4Helper.convertId(doc.getFilingAttorney().get(), "REFERENCE"));
      } else if (!attorneyRow.isrequired || isIndividual) {
        // "This field should contain empty values for Individual filers"
        metadata.setFilingAttorneyID(Ecf4Helper.convertId("", ""));
      } else {
        InterviewVariable attVar =
            collector.requestVar(
                "filing_attorney", "The Attorney that is filing this document", "text");
        collector.addRequired(attVar);
      }
    } else {
      // It's required, even if it's not visible. So keep it empty.
      metadata.setFilingAttorneyID(Ecf4Helper.convertId("", ""));
    }

    for (PartyId filingPartyId : doc.getFilingPartyIds()) {
      metadata
          .getFilingPartyID()
          .add(
              Ecf4Helper.convertId(
                  filingPartyId.getIdentificationString(),
                  (filingPartyId.isNewInCurrentFiling()) ? "REFERENCE" : "IDENTIFICATION"));
    }
    // TODO(brycew): needs to handle when we can avoid using filing party ids
    if (doc.getFilingPartyIds().isEmpty()) {
      InterviewVariable partyVar =
          collector.requestVar(
              "filing_parties", "The Parties that are filing this document", "text");
      collector.addRequired(partyVar);
    }
    docType.setDocumentMetadata(metadata);

    String cc = doc.getCourtesyCopies().stream().reduce("", (base, str) -> base + "," + str);
    docType.setCourtesyCopiesText(Ecf4Helper.convertText(cc));
    String prelim = doc.getPreliminaryCopies().stream().reduce("", (base, str) -> base + "," + str);
    docType.setPreliminaryCopiesText(Ecf4Helper.convertText(prelim));
    DataFieldRow commentRow = allDataFields.getFieldRow("FilingFilingComments");
    if (commentRow.isvisible) {
      String comment = doc.getFilingComments();
      if (!commentRow.matchRegex(comment)) {
        InterviewVariable var =
            collector.requestVar("comment", "", "text", List.of(), Optional.of(comment));
        collector.addWrong(var);
      }
      // I absolutely refuse to require comments from the user on each individual document.
      if (commentRow.isrequired) {
        log.error(
            "Dev Ops Error: Comments are required per filing document apparently. "
                + "Not being forced yet");
      }
      docType.setFilingCommentsText(Ecf4Helper.convertText(doc.getFilingComments()));
    }

    DataFieldRow motionRow = allDataFields.getFieldRow("FilingMotionType");
    if (motionRow.isvisible) {
      List<NameAndCode> motionTypes = cd.getMotionTypes(this.court.code, filing.code);
      InterviewVariable var =
          collector.requestVar(
              "motion_type",
              "the motion type (?)",
              "choices",
              motionTypes.stream().map(m -> m.getCode()).collect(Collectors.toList()),
              doc.getMotionType());
      if (doc.getMotionType().isPresent()) {
        String mt = doc.getMotionType().get();
        Optional<NameAndCode> matchedMotion =
            motionTypes.stream().filter(m -> m.getCode().equalsIgnoreCase(mt)).findFirst();
        if (matchedMotion.isPresent()) {
          docType.setMotionTypeCode(Ecf4Helper.convertText(matchedMotion.get().getCode()));
        } else {
          collector.addWrong(var);
        }
      } else if (motionRow.isrequired) {
        // TODO(brycew-later): "A motion type may be required for a filing type, and may or may not
        // allow multiple occurances"
        // What does it actually mean? Motion types are empty for most IL courts (not Cook), so IDK
        // what to do if there's nothing there
        collector.addRequired(var);
      }
    }
    Optional<Boolean> maybeServiceOnInitial = this.court.allowserviceoninitial;
    boolean serviceOnInitial =
        maybeServiceOnInitial.orElse(
            allDataFields.getFieldRow("FilingServiceCheckBoxInitial").isvisible);
    // From Reference Guide: if no FilingAction is provided, the original default behavior applies:
    // * ReviewFiling API w/o service contacts: EFile
    // * ReviewFiling API w/ service contacts: EfileAndServe
    // * ServeFiling API: Serve
    if (doc.getFilingAction().isPresent()) {
      FilingTypeType act = filingActionToXml(doc.getFilingAction().get());
      if (isInitialFiling
          && !serviceOnInitial
          && (act.equals(FilingTypeType.E_FILE_AND_SERVE) || act.equals(FilingTypeType.SERVE))) {
        InterviewVariable var =
            collector.requestVar(
                "filing_action",
                "Cannot do service on initial filing",
                "text",
                List.of(),
                doc.getFilingAction().map(FilingAction::toString));
        collector.addWrong(var);
      }
      docType.setFilingAction(act);
    }

    if (!doc.getOptionalServices().isEmpty()) {
      List<OptionalServiceCode> codes = cd.getOptionalServices(this.court.code, filing.code);
      var codeMap = new HashMap<String, OptionalServiceCode>();
      codes.stream().forEach(sv -> codeMap.put(sv.code, sv));
      int i = 0;
      for (OptionalService serv : doc.getOptionalServices()) {
        DocumentOptionalServiceType xmlServ = tylerObjFac.createDocumentOptionalServiceType();
        InterviewVariable servVar =
            collector.requestVar(
                "optional_services[" + i + "]",
                "things the court can do",
                "",
                List.of(),
                Optional.of(serv.code));
        if (!codeMap.containsKey(serv.code)) {
          collector.addWrong(servVar);
        }
        xmlServ.setIdentificationID(Ecf4Helper.convertString(serv.code));
        OptionalServiceCode codeSettings = codeMap.get(serv.code);
        if (codeSettings.hasfeeprompt) {
          if (serv.feeAmount.isEmpty()) {
            collector.addWrong(servVar.appendDesc(": needs fee prompt"));
          } else {
            xmlServ.setFeeAmount(Ecf4Helper.convertDecimal(serv.feeAmount.get()));
          }
        }
        if (!codeSettings.hasfeeprompt && serv.feeAmount.isPresent()) {
          collector.addWrong(servVar.appendDesc(": doesn't need fee prompt"));
        }
        if (codeSettings.multiplier == true) {
          if (serv.multiplier.isEmpty()) {
            collector.addWrong(servVar.appendDesc(": needs multiplier"));
          } else {
            xmlServ.setMultiplier(Ecf4Helper.convertDecimal(serv.multiplier.get()));
          }
        }
        docType.getDocumentOptionalService().add(xmlServ);
      }
    }

    // The document itself
    DocumentRenditionMetadataType renditionMetadata = ecfOf.createDocumentRenditionMetadataType();
    int seqNum = 0;
    List<FilingComponent> components = cd.getFilingComponents(this.court.code, filing.code);
    if (components.isEmpty()) {
      InterviewVariable filingComponentVar =
          collector.requestVar(
              "filing_component",
              "The filing component: Lead or Attachment (nothing there with filing "
                  + filing.code
                  + ")",
              "text");
      collector.addRequired(filingComponentVar);
      if (collector.finished()) {
        throw FilingError.missingRequired(filingComponentVar);
      }
    }
    int idx = 0;
    for (var attachment : doc.getFilingAttachments()) {
      collector.pushAttributeStack(".elements[" + idx + "]");
      renditionMetadata
          .getDocumentAttachment()
          .add(attachmentToXml(attachment, filing, components, miscInfo, collector, seqNum));
      collector.popAttributeStack();
      idx += 1;
    }

    DocumentRenditionType rendition = ecfOf.createDocumentRenditionType();
    rendition.setDocumentRenditionMetadata(renditionMetadata);
    docType.getDocumentRendition().add(rendition);
    docType.setId(doc.getIdString());

    if (doc.isLead()) {
      return tylerObjFac.createFilingLeadDocument(docType);
    } else {
      return tylerObjFac.createFilingConnectedDocument(docType);
    }
  }

  private FilingTypeType filingActionToXml(FilingAction action) {
    switch (action) {
      case E_FILE:
        return FilingTypeType.E_FILE;
      case E_FILE_AND_SERVE:
        return FilingTypeType.E_FILE_AND_SERVE;
      case SERVE:
        return FilingTypeType.SERVE;
      default:
        // I don't like enum defaults...
        return FilingTypeType.E_FILE;
    }
  }

  private DocumentAttachmentType attachmentToXml(
      FilingAttachment fa,
      FilingCode filing,
      List<FilingComponent> components,
      JsonNode miscInfo,
      InfoCollector collector,
      int seqNum)
      throws IOException, FilingError {
    // TODO(brycew-later): what should this actually be? Very unclear
    DocumentAttachmentType attachment = ecfOf.createDocumentAttachmentType();
    attachment.setBinaryDescriptionText(Ecf4Helper.convertText(fa.getDocumentDescription()));

    InterviewVariable var =
        collector.requestVar(
            "filing_component",
            "Filing component: Lead or attachment",
            "text",
            List.of(),
            Optional.of(fa.getFilingComponent()));
    if (components.isEmpty()) {
      log.error(
          "Filing Components List is empty! There are no other documents that can be added!"
              + " Stopping at {}",
          fa.getFileName());
      collector.addRequired(var);
    }

    Optional<FilingComponent> filtered =
        components.stream()
            .filter(c -> c.code.equalsIgnoreCase(fa.getFilingComponent()))
            .findFirst();
    if (filtered.isEmpty()) {
      log.error("Filing Components ({}) don't match `{}`.", components, fa.getFilingComponent());
      collector.addRequired(var);
    }

    FilingComponent filt =
        filtered.orElse(new FilingComponent("NO CODE", "NOT PRESENT", "", false, false, 0, "", ""));
    attachment.setBinaryCategoryText(Ecf4Helper.convertText(filt.code));
    if (!filt.allowmultiple) {
      components.remove(filt);
    }

    // Literally should just be if it's confidential or not. (or "Hot fix" or public).
    // Search options in "documenttype" table with location
    DataFieldRow documentType = allDataFields.getFieldRow("DocumentType");
    if (documentType.isvisible) {
      List<DocumentTypeTableRow> docTypes = cd.getDocumentTypes(court.code, filing.code);
      String docTypeStr = fa.getDocumentTypeFormatStandardName();
      InterviewVariable docTypeVar =
          collector.requestVar(
              "document_type",
              documentType.helptext + " " + documentType.validationmessage,
              "choices",
              docTypes.stream().map(dt -> dt.code).collect(Collectors.toList()),
              Optional.of(docTypeStr));
      if (documentType.isrequired) {
        if (docTypeStr.isBlank()) {
          collector.addRequired(docTypeVar);
        }

        Optional<DocumentTypeTableRow> code =
            docTypes.stream().filter(d -> d.code.equals(docTypeStr)).findFirst();
        if (code.isEmpty()) {
          collector.addWrong(docTypeVar);
        } else {
          attachment.setBinaryFormatStandardName(Ecf4Helper.convertText(code.get().code));
        }
      }
    }

    // log.info("Filing code: {} {}: {}///////{}", filing.code, filing.name, docType, attachment);
    // TODO(#62): DO this: make the file downloadable from the Proxy server
    DataFieldRow originalName = allDataFields.getFieldRow("OriginalFileName");
    if (originalName.matchRegex(fa.getFileName()) && fa.getFileName().length() < 50) {
      attachment.setBinaryLocationURI(Ecf4Helper.convertUri(fa.getFileName()));
    } else {
      InterviewVariable oriNameVar =
          collector.requestVar(
              "file_name",
              "file name of document: regex: " + originalName.regularexpression.toString(),
              "text",
              List.of(),
              Optional.of(fa.getFileName()));
      collector.addWrong(oriNameVar);
    }
    JAXBElement<Base64Binary> n =
        niemObjFac.createBinaryBase64Object(Ecf4Helper.convertBase64(fa.getFileContents()));
    // System.err.println(Ecf4Helper.objectToXmlStrOrError(n.getValue(), Base64Binary.class));
    attachment.setBinaryObject(n);
    // TODO(brycew): depends on some DA code, should read in the PDF if possible here. Might be
    // risky though.
    // https://stackoverflow.com/questions/6026971/page-count-of-pdf-with-java
    if (miscInfo.has("page_count")) {
      int count = miscInfo.get("page_count").asInt(1);
      NonNegativeDecimalType nndt = new NonNegativeDecimalType();
      nndt.setValue(new BigDecimal(count));
      attachment.setBinarySizeValue(tylerObjFac.createPageCount(nndt));
    }
    attachment.setAttachmentSequenceID(Ecf4Helper.convertString(Integer.toString(seqNum)));
    return attachment;
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

  private String findDocumentDescription(
      Optional<NonEmptyString> userProvidedDescription,
      DataFieldRow descriptionRow,
      FilingDoc doc,
      FilingCode filing,
      InfoCollector collector)
      throws FilingError {
    if (userProvidedDescription.isPresent()) {
      return userProvidedDescription.get().get();
    } else {
      if (this.court.defaultdocumentdescription.equals("1")) {
        return filing.name;
      } else if (this.court.defaultdocumentdescription.equals("2")) {
        return doc.getFilingAttachments().head().getFileName();
      } else if (descriptionRow.defaultvalueexpression.equals("{{FilingCodeDescription}}")) {
        return filing.name;
      } else if (descriptionRow.defaultvalueexpression.equals("{{FileName}}")) {
        return doc.getFilingAttachments().head().getFileName();
      } else if (descriptionRow.isrequired) {
        InterviewVariable var =
            collector.requestVar(
                "description",
                "A human understandable description of this filing document",
                "text");
        collector.addRequired(var);
        throw FilingError.missingRequired(var);
      } else {
        return descriptionRow.defaultvalueexpression;
      }
    }
  }

  /** True if it worked. */
  private boolean fillStateCode(String state, CountryCodeType country, StructuredAddressType sat) {
    String countryString = country.getValue().toString();
    List<String> stateCodes = cd.getStateCodes(this.court.code, countryString);

    if (!stateCodes.contains(state)) {
      return false;
    }

    if (country.getValue().equalsIgnoreCase("US")) {
      try {
        USStateCodeSimpleType stateSimple = USStateCodeSimpleType.fromValue(state);

        USStateCodeType stateCode = new USStateCodeType();
        stateCode.setValue(stateSimple);
        // NOTE(brycew): we used to be able to set the USPostalServiceCode element, but
        // Tyler responds with "Incomplete address ... LocationStateName ... required.
        // Letting this fall through to the bottom

        // sat.setLocationState(coreObjFac.createLocationStateUSPostalServiceCode(stateCode));
        // return true;
      } catch (IllegalArgumentException ex) {
        log.error("DevOps ERROR: ", ex);
        return false;
      }
    }

    ProperNameTextType pntt = niemObjFac.createProperNameTextType();
    pntt.setValue(state);
    sat.setLocationState(coreObjFac.createLocationStateName(pntt));
    return true;
  }
}
