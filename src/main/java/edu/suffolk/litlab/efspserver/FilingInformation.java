package edu.suffolk.litlab.efspserver;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class FilingInformation {
  private String courtLocationId;
  private List<Person> plaintiffs;
  private List<Person> defendants;

  // TODO(brycew): refactor so this is selected only in Tyler stuff
  private CaseCategory caseCategory;
  private String caseType;
  private String caseSubtype;
  private String paymentId;
  private List<FilingDoc> filingDocs;
  
  private JsonNode miscInfo;
  
  /** Gets all of the peole who are listed by filer ids in the filing docs.
   * This corresponds to the `users` variable in Docassemble interviews.
   *
   * @return The People who are filers in the filing documents
   */
  public List<Person> getFilers() {
    // Add this information to the transaction database
    if (filingDocs.isEmpty()) {
      return List.of();
    }
    List<String> allIds = new ArrayList<String>();
    for (FilingDoc doc : filingDocs) {
      allIds.addAll(doc.getFilingPartyIds());
    }
    List<Person> allFilers = new ArrayList<Person>();
    for (Person per : defendants) {
      if (allIds.contains(per.getIdString())) {
        allFilers.add(per);
      }
    }
    for (Person per : plaintiffs) {
      if (allIds.contains(per.getIdString())) {
        allFilers.add(per);
      }
    }
    return allFilers;
  }
  
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
  
  public List<FilingDoc> getFilings() {
    return filingDocs;
  }
  
  public String getPaymentId() {
    return paymentId;
  }
  
  public JsonNode getMiscInfo() {
    return miscInfo;
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
  
  public void setFilings(List<FilingDoc> filingDocs) {
    this.filingDocs = filingDocs;
  }
  
  public void setPaymentId(String paymentId) {
    this.paymentId = paymentId;
  }
  
  public void setMiscInfo(JsonNode node) {
    this.miscInfo = node; 
  }
  
}
