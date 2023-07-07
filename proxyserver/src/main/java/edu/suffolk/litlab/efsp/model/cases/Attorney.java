package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;

public record Attorney (Name name, ContactInformation contactInfo, String attorneyId, String barNumber) {}
