package edu.suffolk.litlab.efspserver;

import gov.niem.niem.fbi._2.SEXCodeSimpleType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonLanguageType;
import gov.niem.niem.structures._2.AugmentationType;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;

public class Person {

  // NOTE: from DA, we will take the mailing address if present, not the standard
  // address.
  private Name name;
  private ContactInformation contactInfo;
  private Optional<String> gender;
  private Optional<String> language;
  private Optional<LocalDate> birthdate;
  private boolean isOrg;

  private UUID id;
  // TODO(brycew): role doesn't normally go here. Can be constructed anyway. IDK
  private String role;
  
  /** Minimal constructor, empty lists and empty optionals. */
  public Person(Name name, String email, boolean isOrg) {
    this(name, new ContactInformation(email), 
        Optional.empty(), Optional.empty(), Optional.empty(), isOrg);
  }
  
  /** Default constructor. */
  public Person(Name name,
      ContactInformation contactInfo,
      Optional<String> gender,
      Optional<String> language,
      Optional<LocalDate> birthdate,
      boolean isOrg) {
    this.name = name;
    this.contactInfo = contactInfo;
    this.gender = gender;
    this.language = language;
    this.birthdate = birthdate;
    this.isOrg = isOrg;
    
    this.id = UUID.randomUUID();
  }

  public Name getName() {
    return name;
  }

  public UUID getId() {
    return id;
  }
  
  public Optional<LocalDate> getBirthdate() {
    return birthdate;
  }
  
  public Optional<String> getGender() {
    return gender;
  }
  
  public String getRole() {
    return role;
  }
  
  public ContactInformation getContactInfo() {
    return contactInfo;
  }
  
  public Optional<String> getLanguage() {
    return language;
  }
  
  public void setLanguage(String language) {
    this.language = Optional.of(language);
  }
  
  public void setRole(String role) {
    this.role = role;
  }
  
  public String getIdString() {
    return "id-" + id.toString();
  }
  
  /** Needs to have participant role set. */
  public CaseParticipantType getEcfCaseParticipant() {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    final ObjectFactory of = new ObjectFactory();
    AugmentationType aug;
    if (isOrg) {
      aug = ecfOf.createOrganizationAugmentationType();
    } else {
      aug = ecfOf.createPersonAugmentationType();
    }
    ContactInformationType cit = contactInfo.getEcfContactInformation();
    if (isOrg) {
      ((OrganizationAugmentationType) aug).getContactInformation().add(cit);
      OrganizationType ot = ecfOf.createOrganizationType();
      ot.setOrganizationName(XmlHelper.convertText(name.getFullName()));
      ot.getRest().add(ecfOf.createOrganizationAugmentation((OrganizationAugmentationType) aug));
      CaseParticipantType cpt = ecfOf.createCaseParticipantType();
      cpt.setEntityRepresentation(ecfOf.createEntityOrganization(ot));
      return cpt;
    }

    // Else, it's a person: add other optional person stuff
    ((PersonAugmentationType) aug).getContactInformation().add(cit);

    PersonType pt = ecfOf.createPersonType();
    pt.setId("id-" + id.toString());
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
      final gov.niem.niem.iso_639_3._2.ObjectFactory lctOf =
          new gov.niem.niem.iso_639_3._2.ObjectFactory();
      LanguageCodeType lct = lctOf.createLanguageCodeType();
      lct.setValue(lang);
      PersonLanguageType plt = of.createPersonLanguageType();
      plt.getLanguage().add(of.createLanguageCode(lct));
      pt.setPersonPrimaryLanguage(plt);
    });

    birthdate.ifPresent((bd) -> {
      pt.setPersonBirthDate(XmlHelper.convertDate(bd));
    });

    CaseParticipantType cpt = ecfOf.createCaseParticipantType();
    cpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
    return cpt;
  }
}
