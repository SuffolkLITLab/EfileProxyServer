package edu.suffolk.litlab.efspserver.ecf;

import java.util.List;
import java.util.Map;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.FilingCode;
import edu.suffolk.litlab.efspserver.codes.PartyType;

public class ComboCaseCodes {
  
  public final CaseCategory cat;
  public final CaseType type;
  public final List<FilingCode> filings;
  public final Map<String, PartyType> partyTypes;
  
  public ComboCaseCodes(CaseCategory cat, CaseType type, List<FilingCode> filings, 
      Map<String, PartyType> allPartyTypes) {
    this.cat = cat;
    this.type = type;
    this.filings = filings;
    this.partyTypes = allPartyTypes;
  }

}
