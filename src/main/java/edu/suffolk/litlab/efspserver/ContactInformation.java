package edu.suffolk.litlab.efspserver;

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
}
