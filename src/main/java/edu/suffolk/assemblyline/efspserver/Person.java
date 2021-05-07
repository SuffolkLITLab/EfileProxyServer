package edu.suffolk.assemblyline.efspserver;

import gov.niem.niem.fbi._2.SEXCodeSimpleType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonLanguageType;
import gov.niem.niem.niem_core._2.TelephoneNumberType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.AugmentationType;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;

public class Person {
  // NOTE: from DA, we will take the mailing address if present, not the standard
  // address.
  private Address address;
  private Name name;
  private List<String> phoneNumbers;
  private String email;
  private Optional<String> gender;
  private Optional<String> language;
  private Optional<LocalDate> birthdate;
  private boolean isOrg;

  // TODO(brycew): GUID, should be set on construction
  private String id;
  // TODO(brycew): do we need some type of ID here?

  public Address getAddress() {
    return address;
  }

  public Name getName() {
    return name;
  }

  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public String getEmail() {
    return email;
  }

  /** Needs to have participant role set. */
  public CaseParticipantType getEcfCaseParticipant() {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    final gov.niem.niem.proxy.xsd._2.ObjectFactory proxyOf = new gov.niem.niem.proxy.xsd._2.ObjectFactory();
    final ObjectFactory of = new ObjectFactory();
    AugmentationType aug;
    if (isOrg) {
      aug = ecfOf.createOrganizationAugmentationType();
    } else {
      aug = ecfOf.createPersonAugmentationType();
    }
    ContactInformationType cit = of.createContactInformationType();
    cit.getContactMeans().add(address.getNiemContactMeans());
    for (String phoneNumber : phoneNumbers) {
      TelephoneNumberType tnt = of.createTelephoneNumberType();
      FullTelephoneNumberType ftnt = of.createFullTelephoneNumberType();
      gov.niem.niem.proxy.xsd._2.String s = proxyOf.createString();
      s.setValue(phoneNumber);
      ftnt.setTelephoneNumberFullID(s);
      tnt.setTelephoneNumberRepresentation(of.createFullTelephoneNumber(ftnt));
      cit.getContactMeans().add(of.createContactTelephoneNumber(tnt));
    }
    gov.niem.niem.proxy.xsd._2.String emailStr = proxyOf.createString();
    emailStr.setValue(email);
    cit.getContactMeans().add(of.createContactEmailID(emailStr));
    if (isOrg) {
      ((OrganizationAugmentationType) aug).getContactInformation().add(cit);
      OrganizationType ot = ecfOf.createOrganizationType();
      TextType tt = of.createTextType();
      tt.setValue(name.getFullName());
      ot.setOrganizationName(tt);
      ot.getRest().add(ecfOf.createOrganizationAugmentation((OrganizationAugmentationType) aug));
      CaseParticipantType cpt = ecfOf.createCaseParticipantType();
      cpt.setEntityRepresentation(ecfOf.createEntityOrganization(ot));
      return cpt;
    }

    // Else, it's a person: add other optional person stuff
    ((PersonAugmentationType) aug).getContactInformation().add(cit);

    PersonType pt = ecfOf.createPersonType();
    pt.setId(id);
    pt.setPersonName(name.getNameType());
    pt.setPersonAugmentation((PersonAugmentationType) aug);

    gender.ifPresent((gen) -> {
      of.createPersonSex(pt);
      SEXCodeType sct = new SEXCodeType();
      String lowerGen = gen.toLowerCase();
      if (lowerGen.equals("male") || lowerGen.equals("m")) {
        sct.setValue(SEXCodeSimpleType.M);
      } else if (lowerGen.equals("female") || lowerGen.equals("f")) {
        sct.setValue(SEXCodeSimpleType.F);
      } else {
        sct.setValue(SEXCodeSimpleType.U);
      }
      pt.setPersonSex(of.createPersonSexCode(sct));
    });

    language.ifPresent((lang) -> {
      final gov.niem.niem.iso_639_3._2.ObjectFactory lctOf = new gov.niem.niem.iso_639_3._2.ObjectFactory();
      LanguageCodeType lct = lctOf.createLanguageCodeType();
      lct.setValue(lang);
      PersonLanguageType plt = of.createPersonLanguageType();
      plt.getLanguage().add(of.createLanguageCode(lct));
      pt.setPersonPrimaryLanguage(plt);
    });

    birthdate.ifPresent((bd) -> {
      DateType dt = of.createDateType();
      gov.niem.niem.proxy.xsd._2.Date d = proxyOf.createDate();
      DatatypeFactory dtf;
      try {
        dtf = DatatypeFactory.newInstance();
      } catch (DatatypeConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return;
      }
      // TODO(brycew): THIS TIMEZONE IS WRONG: how should LocalDate +
      // GregorianCalendar operate?
      d.setValue(dtf.newXMLGregorianCalendarDate(bd.getYear(), bd.getMonth().getValue(),
          bd.getDayOfMonth(), 0));
      dt.setDateRepresentation(of.createDate(d));
      pt.setPersonBirthDate(dt);
    });

    CaseParticipantType cpt = ecfOf.createCaseParticipantType();
    cpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
    return cpt;
  }
}
