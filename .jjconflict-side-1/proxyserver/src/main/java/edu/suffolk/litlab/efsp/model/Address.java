package edu.suffolk.litlab.efsp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
  // NOTE: annotations are for Gson
  @JsonProperty("AddressLine1")
  private String streetLine;

  @JsonProperty("AddressLine2")
  private String apartmentLine;

  @JsonProperty("City")
  private String cityName;

  @JsonProperty("State")
  private String stateName;

  @JsonProperty("ZipCode")
  private String zipCode;

  @JsonProperty("Country")
  private String countryName;

  /** Constructor, each address element in order as a string. No qualifications. */
  public Address(
      String streetLine,
      String apartmentLine,
      String cityName,
      String stateName,
      String zipCode,
      String countryName) {
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
}
