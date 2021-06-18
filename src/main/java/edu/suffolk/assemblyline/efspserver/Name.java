package edu.suffolk.assemblyline.efspserver;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonNameTextType;
import gov.niem.niem.niem_core._2.PersonNameType;
import java.util.stream.Stream;
import javax.xml.bind.JAXBElement;

public class Name {
  private String firstName;
  private String middleName;
  private String lastName;
  private String suffix;
  private String maidenName;
  private String prefix;
  
  /** Default constructor with all members. */
  public Name(String prefix, String firstName, String middleName, String lastName, 
      String suffix, String maidenName) {
    this.prefix = prefix;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.suffix = suffix;
    this.maidenName = maidenName;
  }
  
  public Name(String firstName, String lastName) {
    this("", firstName, "", lastName, "", "");
  }

  /** The full name, with no extra spaces. */
  public String getFullName() {
    return Stream.of(prefix, firstName, middleName, lastName, suffix)
        .reduce((wd, n) -> {
          if (n.isBlank()) {
            return wd;
          } else {
            return wd + " " + n;
          }
        }).get();
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

  public String getSuffix() {
    return suffix;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getMaidenName() {
    return maidenName;
  }

  private gov.niem.niem.niem_core._2.PersonNameTextType wrapName(String name) {
    ObjectFactory of = new ObjectFactory();
    PersonNameTextType t = of.createPersonNameTextType();
    t.setValue(name);
    return t;
  }

  /** Returns the PersonNameType XML object from this Name. */
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

  public JAXBElement<gov.niem.niem.niem_core._2.PersonNameType> getNiemStruct() {
    ObjectFactory of = new ObjectFactory();
    return of.createPersonName(getNameType());
  }

  public JsonElement getAsStandardJson() {
    return new JsonPrimitive(getFullName());
  }
  
}
