package edu.suffolk.litlab.efspserver;

import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonNameTextType;
import gov.niem.niem.niem_core._2.PersonNameType;
import java.util.stream.Stream;

import edu.suffolk.litlab.efspserver.ecf5.Ecf5Helper;

public class Name {
  private String firstName;
  private String middleName;
  private String lastName;
  private String suffix;
  private String maidenName;
  private String prefix;

  /** Default constructor with all members. */
  public Name(
      String prefix,
      String firstName,
      String middleName,
      String lastName,
      String suffix,
      String maidenName) {
    this.prefix = prefix;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.suffix = suffix;
    this.maidenName = maidenName;
  }

  public Name(String companyName) {
    this("", companyName, "", "", "", "");
  }

  public Name(String firstName, String middleName, String lastName) {
    this("", firstName, middleName, lastName, "", "");
  }

  /** The full name, with no extra spaces. */
  public String getFullName() {
    return Stream.of(prefix, firstName, middleName, lastName, suffix)
        .reduce(
            (wd, n) -> {
              if (n.isBlank()) {
                return wd;
              } else if (wd.isBlank()) {
                return n;
              } else {
                return wd + " " + n;
              }
            })
        .get();
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

  /** If there's only a first name, then us it, otherwise take only the last name */
  public String getTitleName() {
    if (lastName == null || lastName.isBlank()) {
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

  private static gov.niem.niem.niem_core._2.PersonNameTextType wrapName(String name) {
    ObjectFactory of = new ObjectFactory();
    PersonNameTextType t = of.createPersonNameTextType();
    t.setValue(name);
    return t;
  }

  /** Returns the PersonNameType Niem 2.0 XML object from this Name. */
  public gov.niem.niem.niem_core._2.PersonNameType getNameType() {
    ObjectFactory of = new ObjectFactory();
    PersonNameType personName = of.createPersonNameType();
    personName.setPersonGivenName(wrapName(firstName));
    personName.setPersonMaidenName(wrapName(maidenName));
    personName.setPersonMiddleName(wrapName(middleName));
    personName.setPersonSurName(wrapName(lastName));
    personName.setPersonNamePrefixText(wrapName(prefix));
    personName.setPersonNameSuffixText(wrapName(suffix));
    return personName;
  }

  /** Returns the PersonNameType Niem 4.0 XML object from this Name. */
  public gov.niem.release.niem.niem_core._4.PersonNameType getNameTypeEcf5() {
    gov.niem.release.niem.niem_core._4.ObjectFactory of = new gov.niem.release.niem.niem_core._4.ObjectFactory();
    gov.niem.release.niem.niem_core._4.PersonNameType personName = of.createPersonNameType();
    personName.setPersonGivenName(Ecf5Helper.convertPersonText(firstName));
    personName.setPersonMaidenName(Ecf5Helper.convertPersonText(maidenName));
    personName.setPersonMiddleName(Ecf5Helper.convertPersonText(middleName));
    personName.setPersonSurName(Ecf5Helper.convertPersonText(lastName));
    personName.setPersonNamePrefixText(Ecf5Helper.convertPersonText(prefix));
    personName.setPersonNameSuffixText(Ecf5Helper.convertPersonText(suffix));
    return personName;
  }

}
