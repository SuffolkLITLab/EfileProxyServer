package edu.suffolk.litlab.efspserver;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import java.util.List;

public class FilingStuff {
  private String courtLocationId;
  private List<Person> plaintiffs;
  private List<Person> defendants;

  // TODO(brycew): refactor so this is selected only in Tyler stuff
  private CaseCategory caseCategory;
  private String caseType;
  private String caseSubtype;
  private List<Filing> filings;
  private String paymentId;
  
  public String getCourtLocation() {
    return courtLocationId;
  }

  public List<Person> getPlaintiffs() {
    return plaintiffs;
  }
  
  public List<Person> getDefendants() {
    return defendants;
  }
  
  public CaseCategory getCaseCategory() {
    return caseCategory;
  }
  
  public String getCaseType() {
    return caseType;
  }
  
  public String getCaseSubtype() {
    return caseSubtype;
  }
  
  public List<Filing> getFilings() {
    return filings;
  }
  
  public String getPaymentId() {
    return paymentId;
  }
  
  public void setCourtLocation(String courtLocationId) {
    this.courtLocationId = courtLocationId;
  }
  
  public void setDefendants(List<Person> defendants) {
    this.defendants = defendants;
  }

  public void setPlaintiffs(List<Person> plaintiffs) {
    this.plaintiffs = plaintiffs;
  }
  
  public void setCaseCategory(CaseCategory caseCategory) {
    this.caseCategory = caseCategory;
  }
  
  public void setCaseType(String caseType) {
    this.caseType = caseType;
  }
  
  public void setCaseSubtype(String caseSubtype) {
    this.caseSubtype = caseSubtype;
  }
  
  public void setFilings(List<Filing> filings) {
    this.filings = filings;
  }
  
  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }
  
}
