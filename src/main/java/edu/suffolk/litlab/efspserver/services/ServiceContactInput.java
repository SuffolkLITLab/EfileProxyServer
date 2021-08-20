package edu.suffolk.litlab.efspserver.services;

import tyler.efm.services.schema.common.AddressType;

public class ServiceContactInput {
  public String firstName;
  public String middleName;
  public String lastName;
  public String email;
  public String administrativeCopy;
  public boolean isPublic;
  public boolean isInFirmMaster;
  public String phoneNumber;
  public AddressType address;
  
  public static class ContactAddress {
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String zipCode;
    public String country;
  }
}
