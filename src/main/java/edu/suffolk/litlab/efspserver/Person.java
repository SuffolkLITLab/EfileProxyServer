package edu.suffolk.litlab.efspserver;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


public class Person {

  // NOTE: from DA, we will take the mailing address if present, not the standard
  // address.
  private Name name;
  private ContactInformation contactInfo;
  private Optional<String> gender;
  private Optional<String> language;
  private Optional<LocalDate> birthdate;
  private boolean isOrg;

  private UUID id;
  private String role;

  /** Minimal constructor, empty lists and empty optionals. */
  public Person(Name name, String email, boolean isOrg) {
    this(name, new ContactInformation(email),
        Optional.empty(), Optional.empty(), Optional.empty(), isOrg);
  }

  /** Default constructor. */
  public Person(Name name,
      ContactInformation contactInfo,
      Optional<String> gender,
      Optional<String> language,
      Optional<LocalDate> birthdate,
      boolean isOrg) {
    this.name = name;
    this.contactInfo = contactInfo;
    this.gender = gender;
    this.language = language;
    this.birthdate = birthdate;
    this.isOrg = isOrg;

    this.id = UUID.randomUUID();
  }

  public Name getName() {
    return name;
  }

  public boolean isOrg() {
    return isOrg;
  }

  public UUID getId() {
    return id;
  }

  public Optional<LocalDate> getBirthdate() {
    return birthdate;
  }

  public Optional<String> getGender() {
    return gender;
  }

  public String getRole() {
    return role;
  }

  public ContactInformation getContactInfo() {
    return contactInfo;
  }

  public Optional<String> getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = Optional.of(language);
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getIdString() {
    return "id-" + id.toString();
  }

}
