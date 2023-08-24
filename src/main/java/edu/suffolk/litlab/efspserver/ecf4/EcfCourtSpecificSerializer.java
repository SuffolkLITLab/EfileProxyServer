package edu.suffolk.litlab.efspserver.ecf4;

import static edu.suffolk.litlab.efspserver.ecf4.Ecf4Helper.convertId;
import static edu.suffolk.litlab.efspserver.ecf4.Ecf4Helper.convertString;
import static edu.suffolk.litlab.efspserver.ecf4.Ecf4Helper.convertText;

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
import gov.niem.niem.fbi._2.SEXCodeSimpleType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;
import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import gov.niem.niem.niem_core._2.NonNegativeDecimalType;
import gov.niem.niem.niem_core._2.PersonLanguageType;
import gov.niem.niem.niem_core._2.PersonNameTextType;
import gov.niem.niem.niem_core._2.PersonNameType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.StreetType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import gov.niem.niem.niem_core._2.TelephoneNumberType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Base64Binary;
import gov.niem.niem.usps_states._2.USStateCodeSimpleType;
import gov.niem.niem.usps_states._2.USStateCodeType;
import jakarta.xml.bind.JAXBElement;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentAttachmentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.extensions.common.CapabilityType;
import tyler.ecf.extensions.common.DocumentOptionalServiceType;
import tyler.ecf.extensions.common.DocumentType;
import tyler.ecf.extensions.common.FilingTypeType;

public class EcfCourtSpecificSerializer {
  private static Logger log = LoggerFactory.getLogger(EcfCourtSpecificSerializer.class);

  private final CodeDatabase cd;
  private final CourtLocationInfo court;
  private final TylerCodesSerializer tylerSerializer;
  private static final gov.niem.niem.niem_core._2.ObjectFactory niemObjFac =
      new gov.niem.niem.niem_core._2.ObjectFactory();
  private static final gov.niem.niem.niem_core._2.ObjectFactory coreObjFac =
      new gov.niem.niem.niem_core._2.ObjectFactory();
  private static final tyler.ecf.extensions.common.ObjectFactory tylerObjFac =
      new tyler.ecf.extensions.common.ObjectFactory();
  static final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf =
      new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();

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

  public ComboCaseCodes serializeCaseCodesIndexed(
      FilingInformation info, InfoCollector collector, CaseResponseMessageType resp)
      throws FilingError {
    String catCode = resp.getCase().getValue().getCaseCategoryText().getValue();
    String typeCode =
        EcfCaseTypeFactory.getCaseAugmentation(resp.getCase().getValue())
            .get()
            .getCaseTypeText()
            .getValue();
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
    Map<PartyId, Person> existingPartips =
        EcfCaseTypeFactory.getCaseParticipants(resp.getCase().getValue()).get();
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
   * Needs to have participant role set.
   *
   * @throws FilingError
   */
  public CaseParticipantType serializeEcfCaseParticipant(
      Person per, InfoCollector collector, List<PartyType> partyTypes) throws FilingError {
    final CaseParticipantType cpt = ecfOf.createCaseParticipantType();
    ContactInformationType cit = serializeEcfContactInformation(per.getContactInfo(), collector);
    if (per.isOrg()) {
      OrganizationType ot = ecfOf.createOrganizationType();
      ot.setOrganizationName(
          Ecf4Helper.convertText(
              tylerSerializer.vetOrgName(per.getName().getFullName(), collector)));
      ot.setId(per.getIdString());
      OrganizationAugmentationType aug = ecfOf.createOrganizationAugmentationType();
      aug.getContactInformation().add(cit);
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
        var extObjFac = new tyler.ecf.extensions.common.ObjectFactory();
        CapabilityType ct = extObjFac.createCapabilityType();
        ct.setIAmThisUserIndicator(Ecf4Helper.convertBool(true));
        pt.setPersonCapability(extObjFac.createPersonCapability(ct));
      }

      pt.setPersonName(serializeNameType(per.getName(), collector));
      pt.setPersonAugmentation(aug);

      tylerSerializer
          .vetGender(per.getGender(), collector)
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
                pt.setPersonSex(niemObjFac.createPersonSexCode(sct));
              });

      tylerSerializer
          .getLangCode(per.getLanguage(), collector)
          .ifPresent(
              l -> {
                // TODO(brycew): currently taking the safer option: if no languages are specified,
                // don't add one
                // TODO(brycew): need to have an ISO 639_2 (language codes) converter, from general
                // language name
                /// https://en.wikipedia.org/wiki/List_of_ISO_639-2_codes
                final var lctOf = new gov.niem.niem.iso_639_3._2.ObjectFactory();
                LanguageCodeType lct = lctOf.createLanguageCodeType();
                lct.setValue(l);
                PersonLanguageType plt = niemObjFac.createPersonLanguageType();
                plt.getLanguage().add(niemObjFac.createLanguageCode(lct));
                pt.setPersonPrimaryLanguage(plt);
              });

      per.getBirthdate()
          .ifPresent(
              (bd) -> {
                pt.setPersonBirthDate(Ecf4Helper.convertDate(bd));
              });

      cpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
    }

    TextType tt = niemObjFac.createTextType();
    tt.setValue(tylerSerializer.vetPartyCode(per.getRole(), partyTypes, collector));
    cpt.setCaseParticipantRoleCode(tt);
    return cpt;
  }

  public ContactInformationType serializeEcfContactInformation(
      ContactInformation contactInfo, InfoCollector collector) throws FilingError {
    ContactInformationType cit = niemObjFac.createContactInformationType();
    if (contactInfo.getAddress().isPresent()) {
      Address addr = contactInfo.getAddress().get();
      JAXBElement<AddressType> contactMeans = serializeNiemAddress(addr, collector);
      cit.getContactMeans().add(contactMeans);
    }

    tylerSerializer.vetPhoneNumbers(contactInfo.getPhoneNumbers(), collector).stream()
        .forEach(
            number -> {
              TelephoneNumberType tnt = niemObjFac.createTelephoneNumberType();
              FullTelephoneNumberType ftnt = niemObjFac.createFullTelephoneNumberType();
              ftnt.setTelephoneNumberFullID(Ecf4Helper.convertString(number));
              tnt.setTelephoneNumberRepresentation(niemObjFac.createFullTelephoneNumber(ftnt));
              cit.getContactMeans().add(niemObjFac.createContactTelephoneNumber(tnt));
            });

    tylerSerializer
        .vetEmail(contactInfo.getEmail(), collector)
        .ifPresent(
            email -> {
              cit.getContactMeans()
                  .add(niemObjFac.createContactEmailID(Ecf4Helper.convertString(email)));
            });
    return cit;
  }

  /**
   * Returns the "ContactMeans" XML object from this address. Can be used in the ContactInformation
   * element.
   */
  public JAXBElement<AddressType> serializeNiemAddress(Address address, InfoCollector collector)
      throws FilingError {
    StreetType st = niemObjFac.createStreetType();
    st.setStreetFullText(
        Ecf4Helper.convertText(address.getStreet() + " " + address.getApartment()));
    StructuredAddressType sat = niemObjFac.createStructuredAddressType();
    sat.getAddressDeliveryPoint().add(niemObjFac.createLocationStreet(st));
    ProperNameTextType pntt = niemObjFac.createProperNameTextType();
    pntt.setValue(address.getCity());
    sat.setLocationCityName(pntt);
    var country = Ecf4Helper.strToCountryCode(address.getCountry());
    if (country.isErr()) {
      List<String> countries =
          Arrays.stream(CountryCodeSimpleType.values())
              .map((t) -> t.toString())
              .collect(Collectors.toList());
      InterviewVariable var =
          collector.requestVar(
              "country", "County of the World, in an address", "choices", countries);
      collector.addWrong(var);
    }
    sat.setLocationCountry(
        niemObjFac.createLocationCountryFIPS104Code(country.unwrapOrElseThrow()));
    if (!fillStateCode(address.getState(), country.unwrapOrElseThrow(), sat)) {
      String countryString = country.unwrapOrElseThrow().getValue().value();
      List<String> stateCodes = cd.getStateCodes(this.court.code, countryString);
      InterviewVariable var =
          collector.requestVar("state", "State in a country", "choices", stateCodes);
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
  public gov.niem.niem.niem_core._2.PersonNameType serializeNameType(
      Name name, InfoCollector collector) throws FilingError {
    Function<String, PersonNameTextType> wrapName =
        (n) -> {
          PersonNameTextType t = niemObjFac.createPersonNameTextType();
          t.setValue(n);
          return t;
        };
    Name better = tylerSerializer.vetFullName(name, collector);
    PersonNameType personName = niemObjFac.createPersonNameType();
    personName.setPersonNamePrefixText(wrapName.apply(better.getPrefix()));
    personName.setPersonGivenName(wrapName.apply(better.getFirstName()));
    personName.setPersonMaidenName(wrapName.apply(better.getMaidenName()));
    personName.setPersonMiddleName(wrapName.apply(better.getMiddleName()));
    personName.setPersonSurName(wrapName.apply(better.getLastName()));
    personName.setPersonNameSuffixText(wrapName.apply(better.getSuffix()));
    return personName;
  }

  public DocumentType filingDocToXml(
      FilingDoc doc,
      boolean isInitialFiling,
      CaseCategory caseCategory,
      CaseType motionType,
      FilingCode filing,
      JsonNode miscInfo,
      InfoCollector collector)
      throws IOException, FilingError {
    DocumentType docType = tylerObjFac.createDocumentType();

    tylerSerializer
        .getDocumentDescription(doc, filing, collector)
        .ifPresent(
            desc -> {
              docType.setDocumentDescriptionText(convertText(desc));
            });
    tylerSerializer
        .vetFilingRefNum(doc.getFilingReferenceNum(), collector)
        .ifPresent(
            refNum -> {
              docType.setDocumentFileControlID(convertString(refNum));
            });

    tylerSerializer
        .vetDueDate(doc.getDueDate(), filing, collector)
        .ifPresent(
            date -> {
              DateType cutOffDate = Ecf4Helper.convertDate(date);
              docType.setDocumentInformationCutOffDate(cutOffDate);
            });

    docType.setDocumentSequenceID(convertString(Integer.toString(doc.seqNum())));

    DocumentMetadataType metadata = ecfOf.createDocumentMetadataType();
    metadata.setRegisterActionDescriptionText(convertText(filing.code));

    tylerSerializer
        .vetFilingAttorney(doc.getFilingAttorney(), collector)
        .ifPresentOrElse(
            atty -> {
              metadata.setFilingAttorneyID(convertId(doc.getFilingAttorney().get(), "REFERENCE"));
            },
            () -> {
              // "This field should contain empty values for Individual filers", and it's required
              // even if it's not visible. So keep it empty.
              metadata.setFilingAttorneyID(convertId("", ""));
            });

    for (PartyId filingPartyId : doc.getFilingPartyIds()) {
      metadata
          .getFilingPartyID()
          .add(
              convertId(
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
    docType.setCourtesyCopiesText(convertText(cc));
    String prelim = doc.getPreliminaryCopies().stream().reduce("", (base, str) -> base + "," + str);
    docType.setPreliminaryCopiesText(convertText(prelim));
    tylerSerializer
        .vetComment(doc.getFilingComments(), collector)
        .ifPresent(
            comment -> {
              docType.setFilingCommentsText(convertText(comment));
            });

    tylerSerializer
        .vetMotionCode(doc.getMotionType(), filing, collector)
        .ifPresent(
            mt -> {
              docType.setMotionTypeCode(convertText(mt));
            });
    tylerSerializer
        .vetFilingAction(doc.getFilingAction(), isInitialFiling, collector)
        .ifPresent(
            action -> {
              docType.setFilingAction(filingActionToXml(action));
            });

    tylerSerializer.vetOptionalServices(doc.getOptionalServices(), filing, collector).stream()
        .forEach(
            serv -> {
              DocumentOptionalServiceType xmlServ = tylerObjFac.createDocumentOptionalServiceType();
              xmlServ.setIdentificationID(convertString(serv.code));
              serv.feeAmount.ifPresent(
                  feeAmt -> xmlServ.setFeeAmount(Ecf4Helper.convertDecimal(feeAmt)));
              serv.multiplier.ifPresent(
                  mult -> xmlServ.setMultiplier(Ecf4Helper.convertDecimal(mult)));
              docType.getDocumentOptionalService().add(xmlServ);
            });

    // The document itself
    DocumentRenditionMetadataType renditionMetadata = ecfOf.createDocumentRenditionMetadataType();
    List<FilingComponent> components = cd.getFilingComponents(this.court.code, filing.code);
    List<FileType> allowedFileTypes = cd.getAllowedFileTypes(this.court.code);

    int idx = 0;
    for (var attachment : doc.getFilingAttachments()) {
      collector.pushAttributeStack(".elements[" + idx + "]");
      renditionMetadata
          .getDocumentAttachment()
          .add(
              attachmentToXml(
                  attachment,
                  filing,
                  components,
                  allowedFileTypes,
                  miscInfo,
                  collector,
                  doc.seqNum()));
      collector.popAttributeStack();
      idx += 1;
    }

    DocumentRenditionType rendition = ecfOf.createDocumentRenditionType();
    rendition.setDocumentRenditionMetadata(renditionMetadata);
    docType.getDocumentRendition().add(rendition);
    docType.setId(doc.getIdString());

    return docType;
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
        // TODO(brycew): I don't like enum defaults...
        return FilingTypeType.E_FILE;
    }
  }

  private DocumentAttachmentType attachmentToXml(
      FilingAttachment fa,
      FilingCode filing,
      List<FilingComponent> components,
      List<FileType> allowedFileTypes,
      JsonNode miscInfo,
      InfoCollector collector,
      int seqNum)
      throws IOException, FilingError {
    DocumentAttachmentType attachment = ecfOf.createDocumentAttachmentType();
    attachment.setBinaryDescriptionText(convertText(fa.getDocumentDescription()));
    attachment.setBinaryCategoryText(
        convertText(
            tylerSerializer.vetFilingComponent(
                fa.getFilingComponent(), components, filing, collector)));

    tylerSerializer
        .vetDocType(fa.getDocumentTypeFormatStandardName(), filing, collector)
        .ifPresent(
            dt -> {
              attachment.setBinaryFormatStandardName(convertText(dt));
            });

    // TODO(#62): DO this: make the file downloadable from the Proxy server
    tylerSerializer
        .vetFileName(fa.getFileName(), allowedFileTypes, collector)
        .ifPresent(
            fileName -> {
              attachment.setBinaryLocationURI(Ecf4Helper.convertUri(fa.getFileName()));
            });
    JAXBElement<Base64Binary> n =
        niemObjFac.createBinaryBase64Object(Ecf4Helper.convertBase64(fa.getFileContents()));
    attachment.setBinaryObject(n);

    NonNegativeDecimalType nndt = new NonNegativeDecimalType();
    nndt.setValue(new BigDecimal(fa.getPageCount()));
    attachment.setBinarySizeValue(tylerObjFac.createPageCount(nndt));
    attachment.setAttachmentSequenceID(convertString(Integer.toString(seqNum)));
    return attachment;
  }

  /** True if it worked. */
  private boolean fillStateCode(String state, CountryCodeType country, StructuredAddressType sat) {
    String countryString = country.getValue().toString();
    List<String> stateCodes = cd.getStateCodes(this.court.code, countryString);

    if (!stateCodes.contains(state)) {
      return false;
    }

    if (country.getValue().equals(CountryCodeSimpleType.US)) {
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
        log.error("DevOps ERROR: " + ex);
        return false;
      }
    }

    ProperNameTextType pntt = niemObjFac.createProperNameTextType();
    pntt.setValue(state);
    sat.setLocationState(coreObjFac.createLocationStateName(pntt));
    return true;
  }
}
