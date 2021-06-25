package edu.suffolk.assemblyline.efspserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.StreetType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;

public class Address {
  // NOTE: annotations are for Gson
  @SerializedName("AddressLine1")
  private String streetLine;
  @SerializedName("AddressLine2")
  private String apartmentLine;
  @SerializedName("City")
  private String cityName;
  @SerializedName("State")
  private String stateName;
  @SerializedName("ZipCode")
  private String zipCode;
  @SerializedName("Country")
  private String countryName;
  
  /** Constructor, each address element in order as a string. No qualifications. */
  public Address(String streetLine, String apartmentLine, String cityName, 
      String stateName, String zipCode, String countryName) {
    this.streetLine = streetLine;
    this.apartmentLine = apartmentLine;
    this.cityName = cityName;
    this.stateName = stateName;
    this.zipCode = zipCode;
    this.countryName = countryName;
  }

  public String getStreet() {
    return streetLine;
  }
  
  public String getApartment() {
    return apartmentLine;
  }
  
  public String getCity() {
    return cityName;
  }
  
  public String getState() {
    return stateName;
  }
  
  public String getZip() {
    return zipCode;
  }
  
  public String getCountry() {
    return countryName;
  }
  
  /** Returns the "ContactMeans" XML object from this address. Can be used in the 
   * ContactInformation element.
   */
  public JAXBElement<AddressType> getAsNiemContactMeans() {
    gov.niem.niem.niem_core._2.ObjectFactory niemObjFac =
        new gov.niem.niem.niem_core._2.ObjectFactory();
    StreetType st = niemObjFac.createStreetType();
    st.setStreetFullText(XmlHelper.convertText(streetLine)); 
    StructuredAddressType sat = niemObjFac.createStructuredAddressType();
    sat.getAddressDeliveryPoint().add(niemObjFac.createLocationStreet(st));
    ProperNameTextType pntt = niemObjFac.createProperNameTextType();
    pntt.setValue(cityName);
    sat.setLocationCityName(pntt);
    CountryCodeType cct = new CountryCodeType();
    cct.setValue(countryName);
    sat.setLocationCountry(niemObjFac.createLocationCountryFIPS104Code(cct));
    sat.setLocationPostalCode(XmlHelper.convertString(zipCode)); 
    gov.niem.niem.niem_core._2.AddressType at = niemObjFac.createAddressType();
    at.setAddressRepresentation(niemObjFac.createStructuredAddress(sat));
    return niemObjFac.createContactMailingAddress(at);
  }
  
  /** Returns the Tyler specific "AddressType" from this address. 
   * Used for service contacts, etc. 
   */
  public tyler.efm.services.schema.common.AddressType getAsTylerAddress() {
    tyler.efm.services.schema.common.ObjectFactory efmObjFac = 
        new tyler.efm.services.schema.common.ObjectFactory();
    tyler.efm.services.schema.common.AddressType addr = efmObjFac.createAddressType();
    addr.setAddressLine1(streetLine);
    addr.setAddressLine2(apartmentLine);
    addr.setCity(cityName);
    addr.setState(stateName);
    addr.setZipCode(zipCode);
    addr.setCountry(countryName);
    return addr;
  }
  
  public JsonElement getAsStandardJson() {
    return getAsStandardJson(new Gson());
  }
  
  public JsonElement getAsStandardJson(Gson gson) {
    return gson.toJsonTree(this);
  }
  
  static class Builder {

    private static Logger log = Logger.getLogger("edu.suffolk.assemblyline.efspserver.Address"); 

    private static boolean hasStringMember(JsonObject obj, String memberName) {
      return obj.has(memberName) 
          && obj.get(memberName).isJsonPrimitive() 
          && obj.getAsJsonPrimitive(memberName).isString();
    }
    
    public static Optional<Address> createAddress(JsonElement addressJson) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      if (!addressJson.isJsonObject()) {
        log.warning("Refusing to parse Address that isn't a JsonObject: " 
            + gson.toJson(addressJson));
        return Optional.empty();
      }
      JsonObject addressSubset = addressJson.getAsJsonObject();
      for (String member : List.of("address", "unit", "city", "state", "zip")) {
        if (!hasStringMember(addressSubset, member)) {
          log.warning("Refusing to parse Address object that doesn't have a " + member 
              + ": " + gson.toJson(addressJson));
          return Optional.empty();
        }
      }
      String address = addressSubset.getAsJsonPrimitive("address").getAsString();
      String unit = addressSubset.getAsJsonPrimitive("unit").getAsString();
      String city = addressSubset.getAsJsonPrimitive("city").getAsString();
      String state = addressSubset.getAsJsonPrimitive("state").getAsString();
      String zip = addressSubset.getAsJsonPrimitive("zip").getAsString();
      String country = "US";
      if (hasStringMember(addressSubset, "country")) {
        country = addressSubset.getAsJsonPrimitive("country").getAsString();
      }
      Address addr = new Address(address, unit, city, state, zip, country);
      return Optional.of(addr);
    }
  }
}
