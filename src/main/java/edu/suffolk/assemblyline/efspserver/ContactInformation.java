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
  private Optional<String> email;
  
  
  /** Default constructor. */
  public ContactInformation(List<String> phoneNumbers, 
      Optional<Address> address, Optional<String> email) {
    this.phoneNumbers = phoneNumbers;
    this.address = address;
    this.email = email;
  }
  
  /** Minimal constructor, empty lists and empty optionals. */
  public ContactInformation(String email) {
    this(List.of(), Optional.empty(), Optional.of(email));
  }
  
  public List<String> getPhoneNumbers() {
    return phoneNumbers;
  }
  
  public Optional<String> getEmail() {
    return email;
  }
  
  public Optional<Address> getAddress() {
    return address;
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
    email.ifPresent((em) -> {
      cit.getContactMeans().add(niemObjFac.createContactEmailID(XmlHelper.convertString(em))); 
    });
    return cit;
  }
  
  /** Gets as a json object, used to communicate mainly with Jefferson Parish. */
  public JsonElement getAsStandardJson(Gson gson) {
    JsonObject contactInfo = new JsonObject(); 
    address.ifPresent((addr) -> contactInfo.add("Address", address.get().getAsStandardJson(gson)));
    email.ifPresent((em) -> contactInfo.add("ContactEmailID", new JsonPrimitive(em)));
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
