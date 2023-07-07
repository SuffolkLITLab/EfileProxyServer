package edu.suffolk.litlab.efsp.model;

import java.util.stream.Stream;

public record Name(
    String prefix,
    String firstName,
    String middleName,
    String lastName,
    String suffix,
    String maidenName) {

  /** Default constructor with all members. */
  public Name(
      String prefix,
      String firstName,
      String middleName,
      String lastName,
      String suffix,
      String maidenName) {
    if (prefix == null) {
      prefix = "";
    }
    this.prefix = prefix;
    if (firstName == null) {
      firstName = "";
    }
    this.firstName = firstName;
    if (middleName == null) {
      middleName = "";
    }
    this.middleName = middleName;
    if (lastName == null) {
      lastName = "";
    }
    this.lastName = lastName;
    if (suffix == null) {
      suffix = "";
    }
    this.suffix = suffix;
    if (maidenName == null) {
      maidenName = "";
    }
    this.maidenName = maidenName;
  }

  public Name(String companyName) {
    this("", companyName, "", "", "", "");
  }

  public Name(String firstName, String middleName, String lastName) {
    this("", firstName, middleName, lastName, "", "");
  }

  /** The full name, with no extra spaces. */
  public String makeFullName() {
    if (prefix.isBlank() && firstName.isBlank() && middleName.isBlank() && suffix.isBlank()) {
      return "(No name given)";
    }
    return Stream.of(prefix, firstName, middleName, lastName, suffix)
        .reduce(
            (wd, namePart) -> {
              if (namePart == null || namePart.isBlank()) {
                return wd;
              } else if (wd == null || wd.isBlank()) {
                return namePart;
              } else {
                return wd + " " + namePart;
              }
            })
        .orElse("");
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  /**
   * If there's only a first name, then us it, otherwise take only the last name. Used to create the
   * titles of cases, i.e. Jones v. Discover, etc.
   */
  public String makeTitleName() {
    if (lastName == null || lastName.isBlank()) {
      if (firstName == null || firstName.isBlank()) {
        return "(Unnamed)";
      }
      return firstName;
    } else {
      return lastName;
    }
  }

  public String getSuffix() {
    return suffix;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getMaidenName() {
    return maidenName;
  }
}
