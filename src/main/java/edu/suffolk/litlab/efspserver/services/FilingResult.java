package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.UUID;

import edu.suffolk.litlab.efspserver.Person;

public class FilingResult {
  public final List<UUID> filingIds;
  public final Person leadContact;
  
  
  public FilingResult(List<UUID> filingIds, Person leadContact) {
    this.filingIds = filingIds;
    this.leadContact = leadContact;
  }

}
