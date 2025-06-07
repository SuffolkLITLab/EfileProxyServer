package edu.suffolk.litlab.efsp.model;

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

  /**
   * the identifier that might be used reference back here from other parts on the input filing.
   * From the service contacts, attorney assignment, etc.
   */
  private final PartyId partyId;

  /** A random identifier for this specific object */
  private final UUID id;

  private String role;

  /** Is true if the person who's Tyler id is being used to file the form is this user. */
  private final boolean isFormFiller;

  /** Minimal constructor, empty lists and empty optionals. Should only be used in tests. */
  public static Person TestPerson(Name name, String email, boolean isOrg) {
    return Person.FromInput(
        name,
        new ContactInformation(email),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        isOrg,
        false,
        "",
        Optional.empty());
  }

  public static Person FromEfm(
      Name name,
      ContactInformation contactInfo,
      Optional<String> gender,
      Optional<String> language,
      Optional<LocalDate> birthdate,
      boolean isOrg,
      String role,
      UUID efmId) {
    PartyId partyId = PartyId.Already(efmId.toString());
    return new Person(
        name, contactInfo, gender, language, birthdate, isOrg, false, role, partyId, efmId);
  }

  /** Default constructor. */
  public static Person FromInput(
      Name name,
      ContactInformation contactInfo,
      Optional<String> gender,
      Optional<String> language,
      Optional<LocalDate> birthdate,
      boolean isOrg,
      boolean isFormFiller,
      String role,
      Optional<String> efmIdIfAlreadyIn) {
    UUID uuid = UUID.randomUUID();
    PartyId partyId =
        efmIdIfAlreadyIn
            .map(efmId -> PartyId.Already(efmId))
            .orElse(PartyId.CurrentFilingNew(uuid.toString()));
    return new Person(
        name, contactInfo, gender, language, birthdate, isOrg, isFormFiller, role, partyId, uuid);
  }

  private Person(
      Name name,
      ContactInformation contactInfo,
      Optional<String> gender,
      Optional<String> language,
      Optional<LocalDate> birthdate,
      boolean isOrg,
      boolean isFormFiller,
      String role,
      PartyId partyId,
      UUID id) {
    this.name = name;
    this.contactInfo = contactInfo;
    this.gender = gender;
    this.language = language;
    this.birthdate = birthdate;
    this.isOrg = isOrg;
    this.isFormFiller = isFormFiller;
    this.partyId = partyId;
    this.id = id;
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

  public PartyId getPartyId() {
    return partyId;
  }

  /** In order to be an XML referfence ID, it needs to start with a letter, not a number. */
  public String getIdString() {
    return "id-" + id.toString();
  }
}
