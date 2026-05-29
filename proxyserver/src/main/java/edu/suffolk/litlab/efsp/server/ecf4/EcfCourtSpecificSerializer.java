package edu.suffolk.litlab.efsp.server.ecf4;

import com.fasterxml.jackson.databind.JsonNode;
import ecf4.latest.gov.niem.niem.fbi._2.SEXCodeSimpleType;
import ecf4.latest.gov.niem.niem.fbi._2.SEXCodeType;
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
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FileType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
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
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import jakarta.xml.bind.JAXBElement;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
      CaseCategory caseCategory,
      CaseType type,
      List<FilingCode> filingCodes,
      Map<String, Person> existingParties,
      Map<String, Person> newParties,
      InfoCollector collector)
      throws FilingError {
    Map<String, PartyInfo> partyTypes = vetPartyTypes(existingParties, newParties, type);
    return new ComboCaseCodes(caseCategory, type, filingCodes, partyTypes);
  }

  /** Either an initial filing, or a non-indexed case. */
  public ComboCaseCodes serializeCaseCodes(
      FilingInformation info, InfoCollector collector, boolean isInitialFiling) throws FilingError {
    CaseCategory caseCategory = info.getCaseCategoryCode();
    CaseType type = info.getCaseTypeCode();

    if (!type.initial && info.getCaseDocketNumber().isEmpty()) {
      FilingError err =
          FilingError.malformedInterview(
              "Subsequent filing case type ("
                  + type.code
                  + ") needs docket number, but not present");
      collector.error(err);
    }

    List<FilingCode> filingCodes = info.getFilings().stream().map(f -> f.getFilingCode()).toList();
    Map<String, Person> partyInfo =
        Stream.concat(info.getNewPlaintiffs().stream(), info.getNewDefendants().stream())
            .collect(Collectors.toMap(per -> per.getIdString(), per -> per));
    Map<String, PartyInfo> partyTypes = vetPartyTypes(Map.of(), partyInfo, type);
    return new ComboCaseCodes(caseCategory, type, filingCodes, partyTypes);
  }

  /**
   * existingPartyCodes: str of Tyler party ID to their role code string newPartyCodes: str of our
   * generated ID of party to their role code string
   *
   * @return the combined map of tyler ids and our ids to each party type
   */
  private Map<String, PartyInfo> vetPartyTypes(
      Map<String, Person> existingParties, Map<String, Person> newParties, CaseType type)
      throws FilingError {
    List<PartyType> pTypesForCase = cd.getPartyTypeFor(court.code, type.code);
    Map<String, PartyType> codeToPartyType =
        pTypesForCase.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
    // So, Tyler lies: it's possible for older cases to have party types that aren't allowed
    // on new cases anymore. So we'll make a backup map of all of the real party types, if
    // necessary.
    Map<String, PartyType> codeToAllPartyType = Map.of();
    Map<String, PartyInfo> partyInfo = new HashMap<>();
    for (Map.Entry<String, Person> entity : existingParties.entrySet()) {
      Person party = entity.getValue();
      String key = entity.getKey();
      if (party.getRole().isEmpty()) {
        log.warn("Existing party {} doesn't have a role?", key);
        continue;
      }
      var role = party.getRole().get();
      if (codeToPartyType.containsKey(role)) {
        partyInfo.put(
            key, new PartyInfo(codeToPartyType.get(role), party.getPartyId(), party.isOrg()));
      } else {
        log.warn("Existing party " + key + "'s role (" + party.getRole() + ") isn't a code?");
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, null);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(role)) {
          partyInfo.put(
              key, new PartyInfo(codeToAllPartyType.get(role), party.getPartyId(), party.isOrg()));
        } else {
          log.warn(
              "Existing party {}'s role ({}) still isn't a code?: {}",
              key,
              party.getRole(),
              codeToAllPartyType.keySet());
          // partyInfo.put(party.getKey(), Pair.of(null, party.getValue().isOrg()));
        }
      }
    }
    for (Map.Entry<String, Person> entry : newParties.entrySet()) {
      Person party = entry.getValue();
      String key = entry.getKey();
      if (party.getRole().isEmpty()) {
        log.warn("New party {} doesn't have a role?", key);
        continue;
      }
      var role = party.getRole().get();
      if (codeToPartyType.containsKey(role)) {
        partyInfo.put(
            key, new PartyInfo(codeToPartyType.get(role), party.getPartyId(), party.isOrg()));
      } else {
        log.warn("New party " + key + "'s role (" + party.getRole() + ") isn't a code?");
        if (codeToAllPartyType.isEmpty()) {
          var allForCourt = cd.getPartyTypeFor(court.code, type.code);
          codeToAllPartyType =
              allForCourt.stream().collect(Collectors.toMap(pt -> pt.code, pt -> pt));
        }
        if (codeToAllPartyType.containsKey(role)) {
          partyInfo.put(
              key, new PartyInfo(codeToAllPartyType.get(role), party.getPartyId(), party.isOrg()));
        } else {
          partyInfo.put(key, new PartyInfo(null, party.getPartyId(), party.isOrg()));
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
      Person per, PartyInfo info, InfoCollector collector) throws FilingError {
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

      per.getGender()
          .ifPresent(
              gen -> {
                // We can't use the same ones that we want, but will use Unknown for gnc folks.
                // Representative of a bigger issue of mixing random govt agency definitions of
                // things. It's dumb.
                SEXCodeSimpleType sexEnum =
                    switch (gen) {
                      case MALE -> SEXCodeSimpleType.M;
                      case FEMALE -> SEXCodeSimpleType.F;
                      case NONBINARY -> SEXCodeSimpleType.U;
                      case OTHER -> SEXCodeSimpleType.U;
                      case UNKNOWN -> SEXCodeSimpleType.U;
                    };
                SEXCodeType sct = new SEXCodeType();
                sct.setValue(sexEnum);
                pt.setPersonSex(niemObjFac.createPersonSexCode(sct));
              });

      if (per.getLanguage().isPresent()) {
        List<String> langs = cd.getLanguageNames(this.court.code);
        if (!langs.isEmpty()) {
          // TODO(brycew): need to have an ISO 639_2 (language codes) converter, from general
          // language name
          /// https://en.wikipedia.org/wiki/List_of_ISO_639-2_codes
          LanguageCodeType lct = iso639Fac.createLanguageCodeType();
          PersonLanguageType plt = niemObjFac.createPersonLanguageType();
          plt.getLanguage().add(niemObjFac.createLanguageCode(lct));
          pt.setPersonPrimaryLanguage(plt);
        }
        // TODO(brycew): currently taking the safer option: if no languages are specified, don't
        // add one
      }

      per.getBirthdate()
          .ifPresent(
              (bd) -> {
                pt.setPersonBirthDate(Ecf4Helper.convertDate(bd));
              });

      cpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
    }

    TextType tt = niemObjFac.createTextType();
    tt.setValue(info.type().code);
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

    List<String> numbers = contactInfo.getPhoneNumbers();
    for (String phoneNumber : numbers) {
      TelephoneNumberType tnt = niemObjFac.createTelephoneNumberType();
      FullTelephoneNumberType ftnt = niemObjFac.createFullTelephoneNumberType();
      ftnt.setTelephoneNumberFullID(Ecf4Helper.convertString(phoneNumber));
      tnt.setTelephoneNumberRepresentation(niemObjFac.createFullTelephoneNumber(ftnt));
      cit.getContactMeans().add(niemObjFac.createContactTelephoneNumber(tnt));
    }

    contactInfo
        .getEmail()
        .ifPresent(
            email -> {
              cit.getContactMeans()
                  .add(niemObjFac.createContactEmailID(Ecf4Helper.convertString(email)));
            });
    return cit;
  }

  public static tyler.efm.latest.services.schema.common.AddressType serializeTylerAddress(
      Address myAddr) throws FilingError {
    var efmObjFac = new tyler.efm.latest.services.schema.common.ObjectFactory();
    var addr = efmObjFac.createAddressType();
    addr.setAddressLine1(myAddr.getStreet());
    addr.setAddressLine2(myAddr.getApartment());
    addr.setCity(myAddr.getCity());
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
    CountryCodeType cct = Ecf4Helper.strToCountryCode(address.getCountry());
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
    personName.setPersonGivenName(wrapName.apply(name.getFirstName()));
    personName.setPersonMaidenName(wrapName.apply(name.getMaidenName()));
    personName.setPersonMiddleName(wrapName.apply(name.getMiddleName()));
    personName.setPersonSurName(wrapName.apply(name.getLastName()));
    personName.setPersonNamePrefixText(wrapName.apply(name.getPrefix()));
    if (!name.getSuffix().isBlank()) {
      personName.setPersonNameSuffixText(wrapName.apply(name.getSuffix()));
    }
    return personName;
  }

  public JAXBElement<DocumentType> filingDocToXml(
      FilingDoc doc,
      boolean isInitialFiling,
      CaseCategory caseCategory,
      CaseType motionType,
      FilingCode filing,
      boolean isIndividual,
      JsonNode miscInfo,
      InfoCollector collector)
      throws IOException, FilingError {
    DocumentType docType = tylerObjFac.createDocumentType();
    doc.descriptionFromSpec()
        .ifPresent(
            desc -> {
              docType.setDocumentDescriptionText(Ecf4Helper.convertText(desc));
            });

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

    doc.getFilingReferenceNum()
        .ifPresent(
            refNum -> {
              docType.setDocumentFileControlID(Ecf4Helper.convertString(refNum));
            });

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

    docType.setDocumentSequenceID(Ecf4Helper.convertString(Integer.toString(doc.sequenceNum())));

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
    doc.getFilingComments()
        .ifPresent(
            comment -> {
              docType.setFilingCommentsText(Ecf4Helper.convertText(comment));
            });
    doc.getMotionType()
        .ifPresent(
            motion -> {
              docType.setMotionTypeCode(Ecf4Helper.convertText(motion.getCode()));
            });
    boolean serviceOnInitial =
        switch (this.court.allowserviceoninitial) {
          case TRUE -> true;
          case FALSE -> false;
          case DEFAULT -> allDataFields.getFieldRow("FilingServiceCheckBoxInitial").isvisible;
        };
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

    for (OptionalService serv : doc.getOptionalServices()) {
      DocumentOptionalServiceType xmlServ = tylerObjFac.createDocumentOptionalServiceType();
      xmlServ.setIdentificationID(Ecf4Helper.convertString(serv.code().code));
      if (serv.feeAmount().isPresent()) {
        xmlServ.setFeeAmount(Ecf4Helper.convertDecimal(serv.feeAmount().get()));
      }
      if (serv.multiplier().isPresent()) {
        xmlServ.setMultiplier(Ecf4Helper.convertDecimal(serv.multiplier().get()));
      }
      docType.getDocumentOptionalService().add(xmlServ);
    }

    // The document itself
    DocumentRenditionMetadataType renditionMetadata = ecfOf.createDocumentRenditionMetadataType();
    int idx = 0;
    for (var attachment : doc.getFilingAttachments()) {
      collector.pushAttributeStack(".elements[" + idx + "]");
      renditionMetadata
          .getDocumentAttachment()
          .add(attachmentToXml(attachment, filing, miscInfo, collector, idx));
      collector.popAttributeStack();
      idx += 1;
    }

    DocumentRenditionType rendition = ecfOf.createDocumentRenditionType();
    rendition.setDocumentRenditionMetadata(renditionMetadata);
    docType.getDocumentRendition().add(rendition);
    docType.setId(doc.getIdString());

    if (doc.sequenceNum() == 0) { // default to the first doc being the lead one.
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
      JsonNode miscInfo,
      InfoCollector collector,
      int seqNum)
      throws IOException, FilingError {
    // TODO(brycew-later): what should this actually be? Very unclear
    DocumentAttachmentType attachment = ecfOf.createDocumentAttachmentType();
    attachment.setBinaryDescriptionText(Ecf4Helper.convertText(fa.getDocumentDescription()));
    FilingComponent filt = fa.getFilingComponent();

    attachment.setBinaryCategoryText(Ecf4Helper.convertText(filt.code));

    // Literally should just be if it's confidential or not. (or "Hot fix" or public).
    // Search options in "documenttype" table with location
    fa.getDocumentTypeFormatStandardName()
        .ifPresent(
            code -> {
              attachment.setBinaryFormatStandardName(Ecf4Helper.convertText(code.code));
            });

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
