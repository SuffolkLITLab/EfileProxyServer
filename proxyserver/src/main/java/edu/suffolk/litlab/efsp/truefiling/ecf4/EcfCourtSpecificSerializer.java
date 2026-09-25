package edu.suffolk.litlab.efsp.truefiling.ecf4;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.model.Address;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.FilingAttachment;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import edu.suffolk.litlab.efsp.truefiling.ecf4.EcfCaseTypeFactory.ComboCaseCodes;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.CaseCategory;
import edu.suffolk.litlab.efsp.utils.FilingError;
import gov.niem.niem.fbi._2.SEXCodeSimpleType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.FullTelephoneNumberType;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentAttachmentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcfCourtSpecificSerializer {
  private static Logger log = LoggerFactory.getLogger(EcfCourtSpecificSerializer.class);

  private static final gov.niem.niem.niem_core._2.ObjectFactory niemObjFac =
      new gov.niem.niem.niem_core._2.ObjectFactory();
  private static final gov.niem.niem.niem_core._2.ObjectFactory coreObjFac =
      new gov.niem.niem.niem_core._2.ObjectFactory();
  private static final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory
      ecfOf = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();

  public ComboCaseCodes serializeCaseCodes(
      FilingInformation info, Map<PartyId, PartyInfo> partyTypes) {
    var caseCategory = (CaseCategory) info.getCaseCategoryCode();
    var type = info.getCaseTypeCode();
    List<NameAndCode> filingCodes = info.getFilings().stream().map(f -> f.getFilingCode()).toList();

    return new ComboCaseCodes(caseCategory, type, filingCodes, partyTypes);
  }

  public JAXBElement<? extends Object> serializeCaseEntity(Person per) {
    var contactInfoList = serializeEcfContactInfo(per.getContactInfo());
    if (per.isOrg()) {
      return ecfOf.createEntityOrganization(serializeOrganization(per, contactInfoList));
    } else {
      return ecfOf.createEntityPerson(serializePerson(per, contactInfoList));
    }
  }

  public EntityType serializeNiemEntity(Person per) {
    var contactInfoList = serializeEcfContactInfo(per.getContactInfo());
    var et = niemObjFac.createEntityType();
    if (per.isOrg()) {
      var org = serializeOrganization(per, contactInfoList);
      org.setId(null);
      et.setEntityRepresentation(ecfOf.createEntityOrganization(org));
    } else {
      var person = serializePerson(per, contactInfoList);
      person.setId(null);
      et.setEntityRepresentation(ecfOf.createEntityPerson(person));
    }
    return et;
  }

  private OrganizationType serializeOrganization(
      Person per, List<ContactInformationType> contactInfoList) {
    OrganizationAugmentationType aug = ecfOf.createOrganizationAugmentationType();
    for (var cit : contactInfoList) {
      aug.getContactInformation().add(cit);
    }
    OrganizationType ot = ecfOf.createOrganizationType();
    ot.setOrganizationName(Ecf4Helper.convertText(per.getName().makeFullName()));
    ot.setId(per.getIdString());
    ot.getRest().add(ecfOf.createOrganizationAugmentation(aug));
    return ot;
  }

  private PersonType serializePerson(Person per, List<ContactInformationType> infos) {
    // Else, it's a person: add other optional person stuff
    PersonType pt = ecfOf.createPersonType();
    pt.setId(per.getIdString());

    // TODO: properly set Document submitted based on this?
    // if (per.isFormFiller()) {
    //  var extObjFac = new ecf4.latest.tyler.ecf.extensions.common.ObjectFactory();
    //  CapabilityType ct = extObjFac.createCapabilityType();
    //  ct.setIAmThisUserIndicator(Ecf4Helper.convertBool(true));
    //  pt.setPersonCapability(extObjFac.createPersonCapability(ct));
    // }

    pt.setPersonName(serializeNameType(per.getName()));
    PersonAugmentationType aug = ecfOf.createPersonAugmentationType();
    for (var cit : infos) {
      aug.getContactInformation().add(cit);
    }
    pt.setPersonAugmentation(aug);
    per.getRole()
        .ifPresent(
            role -> {
              var partyId = Ecf4Helper.convertId(role, "PTY_CD");
              pt.getPersonOtherIdentification().add(partyId);
            });

    // NOTE: where the Bar number goes for attorneys, should always be this for individuals
    pt.setPersonStateIdentification(Ecf4Helper.convertId("Pro Per"));

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

    /*
    per.getLanguage()
        .ifPresent(
            lang -> {
              LanguageCodeType lct = iso639Fac.createLanguageCodeType();
              PersonLanguageType plt = niemObjFac.createPersonLanguageType();
              // TODO: need to test this with TrueFiling still:
              // lct.setValue(lang);
              plt.getLanguage();
              plt.getLanguage().add(niemObjFac.createLanguageCode(lct));
              pt.setPersonPrimaryLanguage(plt);
            });
    */

    per.getBirthdate()
        .ifPresent(
            (bd) -> {
              pt.setPersonBirthDate(Ecf4Helper.convertDate(bd));
            });

    return pt;
  }

  /**
   * Needs to have participant role set.
   *
   * @throws FilingError
   */
  public CaseParticipantType serializeEcfCaseParticipant(Person per, PartyInfo info) {
    final CaseParticipantType cpt = ecfOf.createCaseParticipantType();
    cpt.setEntityRepresentation(serializeCaseEntity(per));

    TextType tt = niemObjFac.createTextType();
    tt.setValue(info.type().code());
    cpt.setCaseParticipantRoleCode(tt);
    return cpt;
  }

  public List<ContactInformationType> serializeEcfContactInfo(ContactInformation contactInfo) {
    var contactList = new ArrayList<ContactInformationType>();
    if (contactInfo.mailingAddress().isPresent()) {
      ContactInformationType addrCit = niemObjFac.createContactInformationType();
      Address addr = contactInfo.mailingAddress().get();
      JAXBElement<AddressType> contactMeans = serializeNiemContactMeans(addr);
      addrCit.getContactMeans().add(contactMeans);
      addrCit.setContactInformationDescriptionText(
          Ecf4Helper.convertText("DEFAULT")); // mailing addr
      contactList.add(addrCit);
    }
    if (contactInfo.getAddress().isPresent()) {
      ContactInformationType addrCit = niemObjFac.createContactInformationType();
      Address addr = contactInfo.getAddress().get();
      JAXBElement<AddressType> contactMeans = serializeNiemContactMeans(addr);
      addrCit.getContactMeans().add(contactMeans);
      addrCit.setContactInformationDescriptionText(Ecf4Helper.convertText("HA2")); // Home Address 2
      contactList.add(addrCit);
    }
    // TODO: business address: code is BA1

    List<String> numbers = contactInfo.getPhoneNumbers();
    for (String phoneNumber : numbers) {
      ContactInformationType phoneCit = niemObjFac.createContactInformationType();
      TelephoneNumberType tnt = niemObjFac.createTelephoneNumberType();
      FullTelephoneNumberType ftnt = niemObjFac.createFullTelephoneNumberType();
      ftnt.setTelephoneNumberFullID(Ecf4Helper.convertString(phoneNumber));
      tnt.setTelephoneNumberRepresentation(niemObjFac.createFullTelephoneNumber(ftnt));
      phoneCit.getContactMeans().add(niemObjFac.createContactTelephoneNumber(tnt));
      // TODO: change phone codes:
      // BP, Business Phone, CP, Cell Phone
      // DEFAULT, Primary Phone
      // HP2, Home Phone
      // MP, Message Phone
      // OTH, Other Phone
      contactList.add(phoneCit);
    }
    contactInfo
        .getEmail()
        .ifPresent(
            email -> {
              ContactInformationType cit = niemObjFac.createContactInformationType();
              cit.getContactMeans()
                  .add(niemObjFac.createContactEmailID(Ecf4Helper.convertString(email)));
              // TODO(brycew): how to change default? do we need to?
              cit.setContactInformationDescriptionText(Ecf4Helper.convertText("DEFAULT"));
              contactList.add(cit);
            });
    return contactList;
  }

  /**
   * Returns the "ContactMeans" XML object from this address. Can be used in the ContactInformation
   * element.
   */
  public JAXBElement<AddressType> serializeNiemContactMeans(Address address) {
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
    fillStateCode(address.getState(), cct, sat);
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
  public gov.niem.niem.niem_core._2.PersonNameType serializeNameType(Name name) {
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
    personName.setPersonFullName(wrapName.apply(name.makeFullName()));
    return personName;
  }

  public DocumentType filingDocToXml(FilingDoc doc, NameAndCode filing) throws IOException {
    DocumentType docType = ecfOf.createDocumentType();
    docType.setDocumentDescriptionText(
        Ecf4Helper.convertText(doc.getFilingCode().name())); // "Complaint/Petition/Application"));
    docType.setDocumentFileControlID(Ecf4Helper.convertString(filing.code()));

    docType.setDocumentSequenceID(Ecf4Helper.convertString(Integer.toString(doc.sequenceNum())));
    var idType = niemObjFac.createIdentificationType();

    idType.setIdentificationSourceText(Ecf4Helper.convertText("TrueFiling"));
    idType.setIdentificationCategory(
        niemObjFac.createIdentificationCategoryText(Ecf4Helper.convertText("DOCUMENTTYPE")));
    idType.setIdentificationID(
        Ecf4Helper.convertString(
            doc.getFilingCode().name())); // "Complaint/Petition/Application"));
    docType.getDocumentIdentification().add(idType);

    DocumentMetadataType metadata = ecfOf.createDocumentMetadataType();
    // Should this be the name of the code?
    metadata.setRegisterActionDescriptionText(
        Ecf4Helper.convertText(doc.getFilingCode().name())); // "Complaint/Petition/Application"));

    // FilingAttorneyID and FilingPartyId are blank in the example
    // TODO: check if they are always
    metadata.setFilingAttorneyID(
        doc.getFilingAttorney()
            .map(atty -> Ecf4Helper.convertId(atty, "REFERENCE"))
            // It's required, even if it's not visible or an Individual filer. So keep it empty.
            .orElse(Ecf4Helper.convertId("", "")));

    // for (PartyId filingPartyId : doc.getFilingPartyIds())
    metadata.getFilingPartyID().add(Ecf4Helper.convertId(""));
    // filingPartyId.getIdentificationString(),
    // (filingPartyId.isNewInCurrentFiling()) ? "REFERENCE" : "IDENTIFICATION"));
    // }
    docType.setDocumentMetadata(metadata);

    // The document itself
    DocumentRenditionMetadataType renditionMetadata = ecfOf.createDocumentRenditionMetadataType();
    int idx = 0;
    for (var attachment : doc.getFilingAttachments()) {
      renditionMetadata.getDocumentAttachment().add(attachmentToXml(attachment, filing, idx));
      idx += 1;
    }

    DocumentRenditionType rendition = ecfOf.createDocumentRenditionType();
    rendition.setDocumentRenditionMetadata(renditionMetadata);
    docType.getDocumentRendition().add(rendition);
    docType.setId(doc.getIdString());

    return docType;
  }

  private DocumentAttachmentType attachmentToXml(
      FilingAttachment fa, NameAndCode filing, int seqNum) throws IOException {
    // TODO(brycew-later): what should this actually be? Very unclear
    DocumentAttachmentType attachment = ecfOf.createDocumentAttachmentType();

    JAXBElement<Base64Binary> n =
        niemObjFac.createBinaryBase64Object(Ecf4Helper.convertBase64(fa.fileContents()));
    // System.err.println(Ecf4Helper.objectToXmlStrOrError(n.getValue(), Base64Binary.class));
    attachment.setBinaryObject(n);
    attachment.setBinaryFormatStandardName(Ecf4Helper.convertText("application/pdf"));
    attachment.setAttachmentSequenceID(Ecf4Helper.convertString(Integer.toString(seqNum)));
    return attachment;
  }

  /** True if it worked. */
  private boolean fillStateCode(String state, CountryCodeType country, StructuredAddressType sat) {
    if (country.getValue().equalsIgnoreCase("US")) {
      try {
        USStateCodeSimpleType stateSimple = USStateCodeSimpleType.fromValue(state);

        USStateCodeType stateCode = new USStateCodeType();
        stateCode.setValue(stateSimple);
        // NOTE(brycew): we used to be able to set the USPostalServiceCode element, but
        // Tyler (haven't tested with TrueFiling yet) responds with "Incomplete address ...
        // LocationStateName ... required.
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
