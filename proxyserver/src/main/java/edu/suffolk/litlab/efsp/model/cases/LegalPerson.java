package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import java.util.UUID;

public record LegalPerson(
    Name name, ContactInformation contactInfo, UUID efmId, String role, PersonEnum personType) {
  public enum PersonEnum {
    INDIVIDUAL,
    BUSINESS
  }
}
