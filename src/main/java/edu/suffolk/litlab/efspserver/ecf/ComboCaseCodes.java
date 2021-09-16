package edu.suffolk.litlab.efspserver.ecf;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.FilingCode;

public class ComboCaseCodes {
  
  public final CaseCategory cat;
  public final CaseType type;
  public final FilingCode filing;
  
  public ComboCaseCodes(CaseCategory cat, CaseType type, FilingCode filing) {
    this.cat = cat;
    this.type = type;
    this.filing = filing;
  }

}
