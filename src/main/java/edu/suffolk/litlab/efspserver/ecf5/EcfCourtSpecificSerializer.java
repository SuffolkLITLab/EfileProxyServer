package edu.suffolk.litlab.efspserver.ecf5;

import static edu.suffolk.litlab.efspserver.ecf5.Ecf5Helper.convertPersonText;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.FilingAction;
import edu.suffolk.litlab.efspserver.FilingAttachment;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.tyler.TylerCodesSerializer;
import edu.suffolk.litlab.efspserver.tyler.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.tyler.codes.CaseType;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.ComboCaseCodes;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFields;
import edu.suffolk.litlab.efspserver.tyler.codes.FileType;
import edu.suffolk.litlab.efspserver.tyler.codes.FilingCode;
import edu.suffolk.litlab.efspserver.tyler.codes.FilingComponent;
import edu.suffolk.litlab.efspserver.tyler.codes.PartyType;
import gov.niem.release.niem.codes.fbi_ncic._4.SEXCodeSimpleType;
import gov.niem.release.niem.codes.fbi_ncic._4.SEXCodeType;
import gov.niem.release.niem.niem_core._4.AddressType;
import gov.niem.release.niem.niem_core._4.ContactInformationType;
import gov.niem.release.niem.niem_core._4.CountryType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.FullTelephoneNumberType;
import gov.niem.release.niem.niem_core._4.OrganizationType;
import gov.niem.release.niem.niem_core._4.PersonLanguageType;
import gov.niem.release.niem.niem_core._4.PersonNameType;
import gov.niem.release.niem.niem_core._4.PersonType;
import gov.niem.release.niem.niem_core._4.StateType;
import gov.niem.release.niem.niem_core._4.StreetType;
import gov.niem.release.niem.niem_core._4.TelephoneNumberType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caseresponse.GetCaseResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentRenditionType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.OrganizationAugmentationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAugmentationType;
import jakarta.xml.bind.JAXBElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.v5_0.extensions.common.AddressAugmentationType;
import tyler.ecf.v5_0.extensions.common.DocumentOptionalServiceType;
import tyler.ecf.v5_0.extensions.common.FilingActionSimpleType;
import tyler.ecf.v5_0.extensions.common.FilingActionType;

public class EcfCourtSpecificSerializer {
  private static Logger log = LoggerFactory.getLogger(EcfCourtSpecificSerializer.class);

  private static final gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac =
      new gov.niem.release.niem.niem_core._4.ObjectFactory();
  private static final gov.niem.release.niem.proxy.xsd._4.ObjectFactory proxyObjFac =
      new gov.niem.release.niem.proxy.xsd._4.ObjectFactory();
  private static final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac =
      new tyler.ecf.v5_0.extensions.common.ObjectFactory();
  private static final gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxdmObjFac =
      new gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
  private static final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory
      ecfObjFac = new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory();
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.ObjectFactory
      filingObjFac =
          new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.ObjectFactory();

  private final CourtLocationInfo court;
  private final CodeDatabase cd;
  private final TylerCodesSerializer tylerSerializer;

  public EcfCourtSpecificSerializer(CodeDatabase cd, CourtLocationInfo court) {
    this.cd = cd;
    this.court = court;
    this.tylerSerializer = new TylerCodesSerializer(cd, court);
  }

  public EcfCourtSpecificSerializer(
      CodeDatabase cd, CourtLocationInfo court, DataFields allDataFields) {
    this.cd = cd;
    this.court = court;
    this.tylerSerializer = new TylerCodesSerializer(cd, court, allDataFields);
  }

  public Optional<Map<PartyId, Person>> getCaseParticipants(
      gov.niem.release.niem.niem_core._4.CaseType theCase) {
    // TODO(brycew): full QName?
    // new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseParty");

    Map<PartyId, Person> existingParticipants = new HashMap<>();
    var allParties =
        theCase.getCaseAugmentationPoint().stream()
            .filter(
                aug ->
                    aug.getValue()
                        instanceof
                        https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
                            .CaseAugmentationType)
            .map(
                aug ->
                    (https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
                            .CaseAugmentationType)
                        aug.getValue())
            .flatMap(ecfAug -> ecfAug.getRest().stream())
            .filter(rest -> rest.getName().getLocalPart().equalsIgnoreCase("CaseParty"))
            .map(rest -> (gov.niem.release.niem.niem_core._4.EntityType) rest.getValue())
            .toList();

    var people =
        allParties.stream()
            .filter(
                entity ->
                    entity.getEntityRepresentation().getValue()
                        instanceof gov.niem.release.niem.niem_core._4.PersonType)
            .map(
                entity ->
                    (gov.niem.release.niem.niem_core._4.PersonType)
                        entity.getEntityRepresentation().getValue())
            .toList();

    var orgs =
        allParties.stream()
            .filter(
                entity ->
                    entity.getEntityRepresentation().getValue()
                        instanceof gov.niem.release.niem.niem_core._4.OrganizationType)
            .map(
                entity ->
                    (gov.niem.release.niem.niem_core._4.OrganizationType)
                        entity.getEntityRepresentation().getValue())
            .toList();

    people.forEach(
        person -> {
          var xmlName = person.getPersonName();
          String firstName =
              (xmlName.getPersonGivenName() != null) ? xmlName.getPersonGivenName().getValue() : "";
          String middleName =
              (xmlName.getPersonMiddleName() != null)
                  ? xmlName.getPersonMiddleName().getValue()
                  : "";
          String lastName =
              (xmlName.getPersonSurName() != null) ? xmlName.getPersonSurName().getValue() : "";
          Name name = new Name(firstName, middleName, lastName);
          var tylerAug =
              person.getPersonAugmentationPoint().stream()
                  .filter(
                      aug ->
                          aug.getValue()
                              instanceof tyler.ecf.v5_0.extensions.common.PersonAugmentationType)
                  .map(
                      aug ->
                          (tyler.ecf.v5_0.extensions.common.PersonAugmentationType) aug.getValue())
                  .findFirst();
          var efmId =
              tylerAug
                  .map(aug -> aug.getPartyIdentification().getIdentificationID().getValue())
                  .orElse("");
          var ecfAug =
              person.getPersonAugmentationPoint().stream()
                  .filter(
                      aug ->
                          aug.getValue()
                              instanceof
                              https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
                                  .PersonAugmentationType)
                  .map(
                      aug ->
                          (https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
                                  .PersonAugmentationType)
                              aug.getValue())
                  .findFirst();
          var maybeRoleCode =
              ecfAug.flatMap(
                  aug ->
                      aug.getCaseParticipantRoleCode().stream()
                          .map(rc -> rc.getValue())
                          .findFirst());

          Person per =
              Person.FromEfm(
                  name,
                  new ContactInformation(""),
                  Optional.empty(),
                  Optional.empty(),
                  Optional.empty(),
                  false,
                  maybeRoleCode.orElse(""),
                  UUID.fromString(efmId));
          existingParticipants.put(PartyId.Already(efmId), per);
        });

    orgs.forEach(
        org -> {
          String orgName = org.getOrganizationName().getValue();
          String efmId = org.getOrganizationIdentification().getIdentificationID().getValue();

          var maybeRoleCode =
              org.getOrganizationAugmentationPoint().stream()
                  .filter(
                      aug ->
                          aug.getValue()
                              instanceof
                              https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
                                  .OrganizationAugmentationType)
                  .map(
                      aug ->
                          (https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
                                  .OrganizationAugmentationType)
                              aug.getValue())
                  .findFirst()
                  .flatMap(
                      aug ->
                          aug.getCaseParticipantRoleCode().stream()
                              .map(rc -> rc.getValue())
                              .findFirst());
          existingParticipants.put(
              PartyId.Already(efmId),
              Person.FromEfm(
                  new Name(orgName),
                  new ContactInformation(""),
                  Optional.empty(),
                  Optional.empty(),
                  Optional.empty(),
                  true,
                  maybeRoleCode.orElse(""),
                  UUID.fromString(efmId)));
        });

    return Optional.of(existingParticipants);
  }

  public Optional<String> getCaseCategory(gov.niem.release.niem.niem_core._4.CaseType theCase) {
    // TODO(brycew): full QName?
    // new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf",
    // "CaseCategoryCode");
    for (var aug : theCase.getCaseAugmentationPoint()) {
      if (aug.getValue()
          instanceof
          https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType
          ecfAug) {
        for (var rest : ecfAug.getRest()) {
          if (rest.getName().getLocalPart().equalsIgnoreCase("CaseCategoryCode")) {
            return Optional.of(
                ((gov.niem.release.niem.niem_core._4.TextType) rest.getValue()).getValue());
          }
        }
      }
    }
    return Optional.empty();
  }

  public Optional<String> getCaseType(gov.niem.release.niem.niem_core._4.CaseType theCase) {
    // TODO(brycew): full QName?
    // new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseTypeCode");
    for (var aug : theCase.getCaseAugmentationPoint()) {
      if (aug.getValue()
          instanceof
          https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType
          ecfAug) {
        for (var rest : ecfAug.getRest()) {
          if (rest.getName().getLocalPart().equalsIgnoreCase("CaseTypeCode")) {
            return Optional.of(
                ((gov.niem.release.niem.proxy.xsd._4.NormalizedString) rest.getValue()).getValue());
          }
        }
      }
    }
    return Optional.empty();
  }

  public ComboCaseCodes serializeCaseCodesIndexed(
      FilingInformation info, InfoCollector collector, GetCaseResponseMessageType resp)
      throws FilingError {
    String catCode = getCaseCategory(resp.getCase().getValue()).orElse("");
    String typeCode = getCaseType(resp.getCase().getValue()).orElse("");
    List<Optional<String>> maybeFilingCodes =
        info.getFilings().stream().map(f -> f.getFilingCode()).toList();
    if (maybeFilingCodes.stream().anyMatch(fc -> fc.isEmpty())) {
      InterviewVariable filingVar =
          collector.requestVar("court_bundle[i].filing_type", "What filing type is this?", "text");
      collector.addRequired(filingVar);
    }
    List<String> filingCodeStrs = maybeFilingCodes.stream().map(fc -> fc.orElse("")).toList();
    Map<String, Person> newPartyCodes =
        Stream.concat(info.getNewPlaintiffs().stream(), info.getNewDefendants().stream())
            .collect(Collectors.toMap(per -> per.getIdString(), per -> per));
    Map<PartyId, Person> existingPartips = getCaseParticipants(resp.getCase().getValue()).get();
    Map<String, Person> existingPartyCodes =
        existingPartips.entrySet().stream()
            .collect(
                Collectors.toMap(
                    ent -> ent.getKey().getIdentificationString(), ent -> ent.getValue()));
    log.info("Existing cat, type, and filings: " + catCode + "," + typeCode + "," + filingCodeStrs);
    return tylerSerializer.serializeCaseCodesIndexedRaw(
        catCode, typeCode, filingCodeStrs, existingPartyCodes, newPartyCodes, collector);
  }

  /**
   * Only use if this is a new participant; don't if the participant is simply the filing party.
   * etc.
   */
  public JAXBElement<EntityType> createFullEcfCaseParticipant(
      Person person, InfoCollector collector, List<PartyType> partyTypes) throws FilingError {
    var entity = niemObjFac.createEntityType();

    var partRoleCode =
        Ecf5Helper.convertText(
            tylerSerializer.vetPartyCode(person.getRole(), partyTypes, collector));

    if (person.isOrg()) {
      OrganizationType orgType = niemObjFac.createOrganizationType();
      orgType.setOrganizationName(
          Ecf5Helper.convertText(
              tylerSerializer.vetOrgName(person.getName().getFullName(), collector)));
      orgType.setId(person.getIdString());
      OrganizationAugmentationType oat = ecfObjFac.createOrganizationAugmentationType();
      oat.getCaseParticipantRoleCode().add(partRoleCode);
      oat.getContactInformation().add(createContactInfoFrom(person.getContactInfo(), collector));
      orgType.getOrganizationAugmentationPoint().add(ecfObjFac.createOrganizationAugmentation(oat));
      entity.setEntityRepresentation(niemObjFac.createEntityOrganization(orgType));
    } else {
      PersonType per = niemObjFac.createPersonType();
      per.setId(person.getIdString());
      PersonAugmentationType pat = ecfObjFac.createPersonAugmentationType();
      // Tyler docs: "ParticipantID is required by the schema but may empty especially on an initial
      // filing with a new party"
      pat.setParticipantID(Ecf5Helper.convertId(""));
      pat.getCaseParticipantRoleCode().add(partRoleCode);
      per.getPersonAugmentationPoint().add(ecfObjFac.createPersonAugmentation(pat));

      var tylerAug = tylerObjFac.createPersonAugmentationType();
      if (person.isFormFiller()) {
        tylerAug.setIAmThisUserIndicator(Ecf5Helper.convertBool(true));
      }
      per.getPersonAugmentationPoint().add(tylerObjFac.createPersonAugmentation(tylerAug));

      per.setPersonName(createPersonName(person.getName(), collector));

      tylerSerializer
          .getLangCode(person.getLanguage(), collector)
          .ifPresent(
              l -> {
                var lct = new gov.niem.release.niem.codes.iso_639_3._4.LanguageCodeType();
                lct.setValue(l);
                PersonLanguageType plt = niemObjFac.createPersonLanguageType();
                plt.setLanguageAbstract(niemObjFac.createLanguageCode(lct));
                per.setPersonPrimaryLanguage(plt);
              });

      person
          .getBirthdate()
          .ifPresent(
              bd -> {
                per.setPersonBirthDate(Ecf5Helper.convertDate(bd));
              });

      tylerSerializer
          .vetGender(person.getGender(), collector)
          .ifPresent(
              gen -> {
                SEXCodeType sct = new SEXCodeType();
                if (gen.equalsIgnoreCase("male") || gen.equalsIgnoreCase("m")) {
                  sct.setValue(SEXCodeSimpleType.M);
                } else if (gen.equalsIgnoreCase("female") || gen.equals("f")) {
                  sct.setValue(SEXCodeSimpleType.F);
                } else {
                  sct.setValue(SEXCodeSimpleType.U);
                }
                per.setPersonSexAbstract(jxdmObjFac.createPersonSexCode(sct));
              });

      entity.setEntityRepresentation(niemObjFac.createEntityRepresentation(per));
    }
    return ecfObjFac.createCaseParty(entity);
  }

  public PersonNameType createPersonName(Name name, InfoCollector collector) throws FilingError {
    Name betterName = tylerSerializer.vetFullName(name, collector);
    PersonNameType personName = niemObjFac.createPersonNameType();
    personName.setPersonNamePrefixText(convertPersonText(betterName.getPrefix()));
    personName.setPersonGivenName(convertPersonText(betterName.getFirstName()));
    personName.setPersonMaidenName(convertPersonText(betterName.getMaidenName()));
    personName.setPersonMiddleName(convertPersonText(betterName.getMiddleName()));
    personName.setPersonSurName(convertPersonText(betterName.getLastName()));
    personName.setPersonNameSuffixText(convertPersonText(betterName.getSuffix()));
    return personName;
  }

  public ContactInformationType createContactInfoFrom(
      ContactInformation inputContact, InfoCollector collector) throws FilingError {
    ContactInformationType cit = niemObjFac.createContactInformationType();
    inputContact
        .getAddress()
        .ifPresent(
            addr -> {
              cit.getContactMeansAbstract()
                  .add(niemObjFac.createContactMailingAddress(createNiemAddressFrom(addr)));
            });
    tylerSerializer
        .vetEmail(inputContact.getEmail(), collector)
        .ifPresent(
            email -> {
              cit.getContactMeansAbstract()
                  .add(niemObjFac.createContactEmailID(Ecf5Helper.convertString(email)));
            });

    tylerSerializer.vetPhoneNumbers(inputContact.getPhoneNumbers(), collector).stream()
        .forEach(
            number -> {
              cit.getContactMeansAbstract()
                  .add(niemObjFac.createContactTelephoneNumber(createNiemTelephone(number)));
            });
    return cit;
  }

  public TelephoneNumberType createNiemTelephone(String number) {
    TelephoneNumberType tnt = niemObjFac.createTelephoneNumberType();
    FullTelephoneNumberType ftnt = niemObjFac.createFullTelephoneNumberType();
    ftnt.setTelephoneNumberFullID(Ecf5Helper.convertString(number));
    tnt.setTelephoneNumberAbstract(niemObjFac.createFullTelephoneNumber(ftnt));
    return tnt;
  }

  public AddressType createNiemAddressFrom(Address inputAddr) {
    AddressType at = niemObjFac.createAddressType();
    StreetType st = niemObjFac.createStreetType();
    st.setStreetFullText(Ecf5Helper.convertText(inputAddr.getStreet()));
    at.setAddressDeliveryPointAbstract(niemObjFac.createLocationStreet(st));
    AddressAugmentationType aat = tylerObjFac.createAddressAugmentationType();
    aat.setAddressSecondaryLine(Ecf5Helper.convertText(inputAddr.getApartment()));
    at.getObjectAugmentationPoint().add(tylerObjFac.createAddressAugmentation(aat));
    at.setLocationCityName(Ecf5Helper.convertProperName(inputAddr.getCity()));
    StateType state = niemObjFac.createStateType();
    state.setStateRepresentation(
        niemObjFac.createLocationStateName(Ecf5Helper.convertProperName(inputAddr.getState())));
    at.setLocationState(state);
    CountryType country = niemObjFac.createCountryType();
    country.setCountryRepresentation(
        niemObjFac.createLocationCountryName(Ecf5Helper.convertProperName(inputAddr.getCountry())));
    at.setLocationCountry(country);
    at.setLocationPostalCode(Ecf5Helper.convertString(inputAddr.getZip()));
    return at;
  }

  public gov.niem.release.niem.niem_core._4.DocumentType filingDocToXml(
      FilingDoc doc,
      int sequenceNum,
      boolean isInitialFiling,
      CaseCategory casecategory,
      CaseType motionType,
      FilingCode filing,
      JsonNode miscInfo,
      InfoCollector collector)
      throws FilingError {
    var docType = niemObjFac.createDocumentType();
    docType.setDocumentFiledDate(Ecf5Helper.convertNow());
    docType.setDocumentSequenceID(Ecf5Helper.convertString(Integer.toString(sequenceNum)));

    tylerSerializer
        .getDocumentDescription(doc, filing, collector)
        .ifPresent(
            desc -> {
              docType.setDocumentDescriptionText(Ecf5Helper.convertText(desc));
            });

    var tylerAug = tylerObjFac.createDocumentAugmentationType();
    tylerSerializer
        .vetFilingRefNum(doc.getFilingReferenceNum(), collector)
        .ifPresent(
            refNum -> {
              tylerAug.setFilerReferenceNumber(Ecf5Helper.convertText(refNum));
            });
    tylerSerializer
        .vetDueDate(doc.getDueDate(), filing, collector)
        .ifPresent(
            date -> {
              tylerAug.setDueDate(Ecf5Helper.convertDate(date));
            });
    tylerSerializer
        .vetComment(doc.getFilingComments(), collector)
        .ifPresent(
            comment -> {
              tylerAug.setFilingCommentsText(Ecf5Helper.convertText(comment));
            });

    tylerSerializer
        .vetMotionCode(doc.getMotionType(), filing, collector)
        .ifPresent(
            mt -> {
              tylerAug.setMotionTypeCode(Ecf5Helper.convertText(mt));
            });
    tylerSerializer
        .vetFilingAction(doc.getFilingAction(), isInitialFiling, collector)
        .ifPresent(
            action -> {
              FilingActionType fat = tylerObjFac.createFilingActionType();
              fat.setValue(filingActionToXml(action));
              tylerAug.setFilingAction(fat);
            });

    tylerSerializer.vetOptionalServices(doc.getOptionalServices(), filing, collector).stream()
        .forEach(
            serv -> {
              DocumentOptionalServiceType xmlServ = tylerObjFac.createDocumentOptionalServiceType();
              xmlServ.setIdentificationID(Ecf5Helper.convertString(serv.code));
              serv.feeAmount.ifPresent(
                  feeAmt -> xmlServ.setServiceFeeAmount(Ecf5Helper.convertAmount(feeAmt)));
              serv.multiplier.ifPresent(
                  mult -> xmlServ.setMultiplierAmount(Ecf5Helper.convertDecimal(mult)));
              tylerAug.getDocumentOptionalService().add(xmlServ);
            });

    var ecfAug = ecfObjFac.createDocumentAugmentationType();
    List<FilingComponent> components = cd.getFilingComponents(this.court.code, filing.code);
    List<FileType> allowedFileTypes = cd.getAllowedFileTypes(this.court.code);
    for (var fa : doc.getFilingAttachments()) {
      var rendition =
          attachmentToXml(fa, filing, components, allowedFileTypes, miscInfo, collector);
      ecfAug.getRest().add(ecfObjFac.createDocumentRendition(rendition));
    }

    // TODO(brycew): another thing that used to be per attachment that is now per document
    ecfAug
        .getRest()
        .add(
            ecfObjFac.createDocumentTypeCode(
                Ecf5Helper.convertText(
                    doc.getFilingAttachments()
                        .toList()
                        .toStream()
                        .map(fa -> fa.getDocumentTypeFormatStandardName())
                        .head())));
    ecfAug
        .getRest()
        .add(ecfObjFac.createRegisterActionDescriptionCode(Ecf5Helper.convertText(filing.code)));

    return docType;
  }

  private FilingActionSimpleType filingActionToXml(FilingAction action) {
    switch (action) {
      case E_FILE:
        return FilingActionSimpleType.E_FILE;
      case E_FILE_AND_SERVE:
        return FilingActionSimpleType.E_FILE_AND_SERVE;
      case SERVE:
        return FilingActionSimpleType.SERVE;
      default:
        // TODO(brycew): I don't like enum defaults...
        return FilingActionSimpleType.E_FILE;
    }
  }

  private DocumentRenditionType attachmentToXml(
      FilingAttachment fa,
      FilingCode filing,
      List<FilingComponent> components,
      List<FileType> allowedFileTypes,
      JsonNode miscInfo,
      InfoCollector collector)
      throws FilingError {
    var rendition = ecfObjFac.createDocumentRenditionType();
    var binary = niemObjFac.createBinaryType();
    binary.setBinarySizeValue(Ecf5Helper.convertDecimal(fa.getFileContents().length));
    var base64 = proxyObjFac.createBase64Binary();
    base64.setValue(fa.getFileContents());
    binary.setBinaryObjectAbstract(niemObjFac.createBase64BinaryObject(base64));
    binary.setBinaryDescriptionText(Ecf5Helper.convertText(fa.getDocumentDescription()));
    var tylerAug = tylerObjFac.createAttachmentAugmentationType();
    tylerAug.setFilingComponentCode(
        Ecf5Helper.convertText(
            tylerSerializer.vetFilingComponent(
                fa.getFilingComponent(), components, filing, collector)));
    if (miscInfo.has("page_count")) {
      int count = miscInfo.get("page_count").asInt(1);
      tylerAug.setPageCount(Ecf5Helper.convertDecimal(count));
    }
    tylerSerializer
        .vetFileName(fa.getFileName(), allowedFileTypes, collector)
        .ifPresent(
            fileName -> {
              tylerAug.setOriginalFileName(Ecf5Helper.convertText(fileName));
            });
    // TODO(#39): handle documents being redacted
    tylerAug.setIsRedactedIndicator(Ecf5Helper.convertBool(false));
    binary.getObjectAugmentationPoint().add(tylerObjFac.createAttachmentAugmentation(tylerAug));
    rendition.setAttachment(binary);
    return rendition;
  }
}
