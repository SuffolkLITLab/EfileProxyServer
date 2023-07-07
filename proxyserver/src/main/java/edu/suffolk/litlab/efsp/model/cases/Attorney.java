package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;

public class Attorney extends Person {
  String attorneyId;
  String barNumber;

  public Attorney(Name name, ContactInformation contactInformation) {
    super(name, contactInformation);
  }
}
