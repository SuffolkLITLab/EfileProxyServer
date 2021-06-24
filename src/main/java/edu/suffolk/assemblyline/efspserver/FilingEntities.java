package edu.suffolk.assemblyline.efspserver;

import java.util.List;

import edu.suffolk.assemblyline.efspserver.codes.CaseCategory;

public class FilingEntities {
  List<Person> plaintiffs;
  List<Person> defendants;

  // TODO(brycew): refactor so this is selected only in Tyler stuff
  CaseCategory caseCategoryCode;
  String caseType;
  String caseSubtype;
  List<Filing> filings;
  String paymentId;
  
  public List<Person> getPlaintiffs() {
    return plaintiffs;
  }
  
  public List<Person> getDefendants() {
    return defendants;
  }
  
  public void setDefendants(List<Person> defendants) {
    this.defendants = defendants;
  }

  public void setPlaintiffs(List<Person> plaintiffs) {
    this.plaintiffs = plaintiffs;
  }
}
