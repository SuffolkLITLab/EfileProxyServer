package edu.suffolk.litlab.efspserver.ecf;

import java.util.List;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.FilingCode;

public class ComboCaseCodes {
  
  public final CaseCategory cat;
  public final CaseType type;
  public final List<FilingCode> filings;
  
  public ComboCaseCodes(CaseCategory cat, CaseType type, List<FilingCode> filings) {
    this.cat = cat;
    this.type = type;
    this.filings = filings;
  }

}
