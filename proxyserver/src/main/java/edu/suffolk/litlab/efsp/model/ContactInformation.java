package edu.suffolk.litlab.efsp.model;

import java.util.List;
import java.util.Optional;

public record ContactInformation(
    List<String> phoneNumbers,
    Optional<Address> address,
    Optional<Address> mailingAddress,
    Optional<String> email) {

  /** Minimal constructor, empty lists and empty optionals. */
  public ContactInformation(String email) {
    this(List.of(), Optional.empty(), Optional.empty(), Optional.ofNullable(email));
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
}
