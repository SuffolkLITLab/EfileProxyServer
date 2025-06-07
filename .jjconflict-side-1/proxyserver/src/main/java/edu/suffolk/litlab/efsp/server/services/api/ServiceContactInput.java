package edu.suffolk.litlab.efsp.server.services.api;

import tyler.efm.latest.services.schema.common.AddressType;

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
}
