package edu.suffolk.assemblyline.efspserver;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import gov.niem.niem.niem_core._2.TelephoneNumberType;
import java.util.List;
import java.util.Optional;

public class ContactInformation {
  private List<String> phoneNumbers;
  private Optional<Address> address;
  private String email;
  
  
  /** Default constructor. */
  public ContactInformation(List<String> phoneNumbers, 
      Optional<Address> address, String email) {
    this.phoneNumbers = phoneNumbers;
    this.address = address;
    this.email = email;
  }
  
  /** Minimal constructor, empty lists and empty optionals. */
  public ContactInformation(String email) {
    this(List.of(), Optional.empty(), email);
  }
  
  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public String getEmail() {
    return email;
  }
  
  /** Gets the ECF XML for contact information. */
  public ContactInformationType getEcfContactInformation() {
    final gov.niem.niem.niem_core._2.ObjectFactory niemObjFac = 
        new gov.niem.niem.niem_core._2.ObjectFactory();

    ContactInformationType cit = niemObjFac.createContactInformationType();
    address.ifPresent((addr) -> cit.getContactMeans().add(addr.getAsNiemContactMeans()));
    for (String phoneNumber : phoneNumbers) {
      TelephoneNumberType tnt = niemObjFac.createTelephoneNumberType();
      FullTelephoneNumberType ftnt = niemObjFac.createFullTelephoneNumberType();
      ftnt.setTelephoneNumberFullID(XmlHelper.convertString(phoneNumber));
      tnt.setTelephoneNumberRepresentation(niemObjFac.createFullTelephoneNumber(ftnt));
      cit.getContactMeans().add(niemObjFac.createContactTelephoneNumber(tnt));
    }
    cit.getContactMeans().add(niemObjFac.createContactEmailID(XmlHelper.convertString(email))); 
    return cit;
  }
  
  /** Gets as a json object, used to communicate mainly with Jefferson Parish. */
  public JsonElement getAsStandardJson(Gson gson) {
    JsonObject contactInfo = new JsonObject(); 
    contactInfo.add("ContactEmailID", new JsonPrimitive(email));
    if (address.isPresent()) {
      contactInfo.add("Address", address.get().getAsStandardJson(gson));
    }
    int i = 0;
    for (String phoneNumber : phoneNumbers) {
      if (i == 0) {
        contactInfo.add("PhoneNumber", new JsonPrimitive(phoneNumber));
      } else {
        contactInfo.add("PhoneNumber" + i, new JsonPrimitive(phoneNumber));
      }
      i += 1;
    }
    return gson.toJsonTree(contactInfo);
  }
  
}
