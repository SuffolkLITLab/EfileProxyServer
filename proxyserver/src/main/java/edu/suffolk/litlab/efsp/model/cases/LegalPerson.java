package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;

public record LegalPerson(Name name, ContactInformation contactInfo, PersonType personType) {
    public enum PersonType {
        INDIVIDUAL,
        BUSINESS
    }
}

