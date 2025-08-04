package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;

public class Person {
  private final Name name;
  private final ContactInformation contactInfo;

  public Person(Name name, ContactInformation contactInfo) {
    this.name = name;
    this.contactInfo = contactInfo;
  }

  public Name getName() {
    return name;
  }

  public ContactInformation getContactInformation() {
    return contactInfo;
  }
}
