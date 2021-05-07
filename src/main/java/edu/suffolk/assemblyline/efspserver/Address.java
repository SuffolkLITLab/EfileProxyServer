package edu.suffolk.assemblyline.efspserver;

import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.StreetType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import gov.niem.niem.niem_core._2.TextType;
import javax.xml.bind.JAXBElement;

public class Address {
  private String streetLine;
  private String apartmentLine;
  private String cityName;
  private String stateName;
  private String zipCode;
  private String countryName;
  
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
    ObjectFactory of = new ObjectFactory();
    StreetType st = of.createStreetType();
    TextType tt = of.createTextType();
    tt.setValue(streetLine);
    st.setStreetFullText(tt); 
    StructuredAddressType sat = of.createStructuredAddressType();
    sat.getAddressDeliveryPoint().add(of.createLocationStreet(st));
    ProperNameTextType pntt = of.createProperNameTextType();
    pntt.setValue(cityName);
    sat.setLocationCityName(pntt);
    CountryCodeType cct = new CountryCodeType();
    cct.setValue(countryName);
    sat.setLocationCountry(of.createLocationCountryFIPS104Code(cct));
    gov.niem.niem.proxy.xsd._2.String zipCodeStr = new gov.niem.niem.proxy.xsd._2.String();
    sat.setLocationPostalCode(zipCodeStr);
    AddressType at = of.createAddressType();
    at.setAddressRepresentation(of.createStructuredAddress(sat));
    return of.createContactMeans(of.createContactMailingAddress(at));
  }
}
