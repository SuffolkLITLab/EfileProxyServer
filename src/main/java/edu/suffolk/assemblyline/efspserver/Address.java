package edu.suffolk.assemblyline.efspserver;

import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.StreetType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import javax.xml.bind.JAXBElement;

public class Address {
  private String streetLine;
  private String apartmentLine;
  private String cityName;
  private String stateName;
  private String zipCode;
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
  public JAXBElement<Object> getNiemContactMeans() {
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
    return niemObjFac.createContactMeans(niemObjFac.createContactMailingAddress(at));
  }
  
  /** Returns the Tyler specific "AddressType" from this address. 
   * Used for service contacts, etc. 
   */
  public tyler.efm.services.schema.common.AddressType getTylerAddress() {
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
}
