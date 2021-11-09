package edu.suffolk.litlab.efspserver;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

/**
 * Values for each individual legal person (a business or individual) involved in a case
 * 
 * @author brycew 
 */
public class Person {

  private final Name name;
  // NOTE: from docassemble, we will take the mailing address if present, not the standard
  // address.
  private final ContactInformation contactInfo;
  private final Optional<String> gender;
  private Optional<String> language;
  private final Optional<LocalDate> birthdate;
  // If true, this is actually a business or organization, i.e. a legal person, not an individual.
  private final boolean isOrg;

  private final UUID id;
  private String role;
  /** Is true if the person who's Tyler id is being used to file the form is this user. */
  private final boolean isFormFiller;

  /** Minimal constructor, empty lists and empty optionals. Should only be used in tests. */
  public static Person TestPerson(Name name, String email, boolean isOrg) {
    return new Person(name, new ContactInformation(email),
        Optional.empty(), Optional.empty(), Optional.empty(), isOrg, false, "");
  }

  /** Default constructor. */
  public Person(Name name,
      ContactInformation contactInfo,
      Optional<String> gender,
      Optional<String> language,
      Optional<LocalDate> birthdate,
      boolean isOrg,
      boolean isFormFiller,
      String role) {
    this.name = name;
    this.contactInfo = contactInfo;
    this.gender = gender;
    this.language = language;
    this.birthdate = birthdate;
    this.isOrg = isOrg;
    this.isFormFiller = isFormFiller;

    this.id = UUID.randomUUID();
    this.role = role;
  }

  public Name getName() {
    return name;
  }

  public boolean isOrg() {
    return isOrg;
  }
  
  public boolean isFormFiller() {
    return isFormFiller;
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
