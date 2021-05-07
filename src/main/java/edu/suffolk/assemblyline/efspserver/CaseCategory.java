package edu.suffolk.assemblyline.efspserver;

public class CaseCategory {
  public int code;
  public String name;
  public String ecfcasetype;
  public String procedureremedyinitial;
  public String procedureremedysubsequenty;
  public String damagaamountinitial;
  
  public CaseCategory(String code, String name, String ecfCaseType,
      String procedureremedyinitial, String procedureSub, String damage) {
    this.code = Integer.parseInt(code);
    this.name = name;
    this.ecfcasetype = ecfCaseType;
    this.procedureremedyinitial = procedureremedyinitial;
    this.procedureremedysubsequenty = procedureSub;
    this.damagaamountinitial = damage;
  }
}
