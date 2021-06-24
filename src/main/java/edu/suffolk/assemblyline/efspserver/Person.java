package edu.suffolk.assemblyline.efspserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import gov.niem.niem.fbi._2.SEXCodeSimpleType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonLanguageType;
import gov.niem.niem.structures._2.AugmentationType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
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

  private String id;
  
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
    
    this.id = "id-" + UUID.randomUUID().toString();
  }

  public Name getName() {
    return name;
  }

  public String getId() {
    return id;
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

  // TODO(brycew): does this need to return a Java object, then to JSON later?
  // TODO(brycew): turn this into a custom deserializer
  public JsonElement getAsStandardJson(Gson gson, String role) {
    JsonObject finalObj = new JsonObject(); 
    finalObj.add("ContactInformation", contactInfo.getAsStandardJson(gson));
    finalObj.add("PersonName", name.getAsStandardJson());
    if (birthdate.isPresent()) {
      finalObj.add("PersonBirthDate", new JsonPrimitive(birthdate.get().format(DateTimeFormatter.ISO_LOCAL_DATE)));
    }
    if (gender.isPresent()) {
      finalObj.add("Gender", new JsonPrimitive(gender.get()));
    }
    if (language.isPresent()) {
      finalObj.add("PersonPrimaryLanguage", new JsonPrimitive(language.get()));
    }
    finalObj.add("CaseParticipantRoleCode", new JsonPrimitive(role));
    finalObj.add("id", new JsonPrimitive(id));
    return gson.toJsonTree(finalObj);
  }
  
  public static class Builder {
    private static Logger log = Logger.getLogger("edu.suffolk.assemblyline.efspserver.Person"); 

    private static boolean hasStringMember(JsonObject obj, String memberName) {
      return obj.has(memberName) 
          && obj.get(memberName).isJsonPrimitive() 
          && obj.getAsJsonPrimitive(memberName).isString();
    }
    
    private static Optional<String> getStringMember(JsonObject obj, String memberName) {
      if (obj.has(memberName) 
          && obj.get(memberName).isJsonPrimitive() 
          && obj.getAsJsonPrimitive(memberName).isString()) {
        return Optional.of(obj.getAsJsonPrimitive(memberName).getAsString());
      }
      return Optional.empty();
    }

    public static Optional<Person> createPerson(JsonElement personJson) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      if (!personJson.isJsonObject()) {
        log.warning("Refusing to parse person that isn't a Json Object: " 
            + gson.toJson(personJson)); 
        return Optional.empty();
      }
      JsonObject personSubset = personJson.getAsJsonObject();

      List<String> phones = new ArrayList<String>();
      if (hasStringMember(personSubset, "mobile_number")) {
        String mobile = personSubset.getAsJsonPrimitive("mobile_number").getAsString();
        if (!mobile.isBlank()) {
          phones.add(mobile);
        }
      }
      if (hasStringMember(personSubset, "phone_number")) {
        String phone = personSubset.getAsJsonPrimitive("phone_number").getAsString();
        if (!phone.isBlank()) {
          phones.add(phone);
        }
      }
      Optional<Address> addr = Optional.empty();
      if (personSubset.has("address") && personSubset.get("address").isJsonObject()) {
        JsonObject addressSubset = personSubset.getAsJsonObject("address");
        addr = Address.Builder.createAddress(addressSubset);
      }
      Optional<String> email = getStringMember(personSubset, "email"); 
      ContactInformation info = new ContactInformation(phones, addr, email);

      if (!(personSubset.has("name") 
          && personSubset.get("name").isJsonObject() 
          && personSubset.getAsJsonObject("name").has("first"))) {
        log.warning("Refusing to parse a person without a name / or first name");
        return Optional.empty();
      }
      JsonObject nameSubset = personSubset.getAsJsonObject("name");
      boolean isOrg = !(nameSubset.has("middle") || nameSubset.has("last"));
      Name name = new Name(
          "", // TODO(brycew): where should we handle prefixes? Are they always empty?
          getStringMember(nameSubset, "first").orElse(""),
          getStringMember(nameSubset, "middle").orElse(""),
          getStringMember(nameSubset, "last").orElse(""),
          getStringMember(nameSubset, "suffix").orElse(""),
          "" // TODO(brycew): where would Maiden name go, if asked for?
      );
      
      Optional<String> language = getStringMember(personSubset, "prefered_language");
      Optional<String> gender = getStringMember(personSubset, "gender");
      Optional<LocalDate> birthdate = Optional.empty(); // TODO(brycew): read in birthdate
      Person per = new Person(name, info, gender, language, birthdate, isOrg);
      return Optional.of(per);
    }
  }
}
