package edu.suffolk.litlab.efsp.model;

import java.util.Map;
import java.util.Optional;

public record ContactInformation(
    Map<PhoneType, String> phoneNumbers,
    Optional<Address> address,
    Optional<Address> mailingAddress,
    Optional<String> email) {

  public enum PhoneType {
    DEFAULT,
    MOBILE,
    HOME,
    WORK,
    OTHER
  };

  /** Minimal constructor, empty lists and empty optionals. */
  public ContactInformation(String email) {
    this(Map.of(), Optional.empty(), Optional.empty(), Optional.ofNullable(email));
  }

  public Map<PhoneType, String> getPhoneNumbers() {
    return phoneNumbers;
  }

  public Optional<String> getEmail() {
    return email;
  }

  public Optional<Address> getAddress() {
    return address;
  }
}
