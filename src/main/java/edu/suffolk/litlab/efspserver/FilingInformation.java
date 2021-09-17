package edu.suffolk.litlab.efspserver;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

public class FilingInformation {

  private String courtLocationId;
  private List<Person> plaintiffs = List.of();
  private String plaintiffPartyType;
  private List<Person> defendants = List.of();
  private String defendantPartyType;
  
  /** A list of attorney UIDs. 
   * 
   * For Tyler at least, the Attorneys are registered in the system beforehand. In that case, these
   * are the GUIDs of the Attorneys in that system.
   * 
   * TODO(brycew): this isn't super general, and relies on registering Attorneys elsewhere. 
   * Make it more generic if possible.
   */
  private List<String> attorneyIds = List.of();
  /** A map from party Ids (in the person Objs) to a list of their Attorneys
   * 
   * A party not present in the map means you don't know who the attorney is (or for subsequent filings,
   * don't want to modify any attorneys). 
   * A party with an empty list means the party is Pro Se.
   */
  private Map<String, List<String>> partyToAttorneyIds = Map.of();
  
  /** List of service contacts to add to the case. Contacts are mostly an ID of the contact already
   * registered within the EFM system.
   */
  private List<CaseServiceContact> serviceContacts = List.of();
 
  /** A tracking ID from the EFM system for the existing case. For subsequent filing. */
  private Optional<String> prevCaseId = Optional.empty();
  /** Existing docket number, NOT from EFM system. For subsequent filing into non-indexed cases. */
  private Optional<String> caseDocketNumber = Optional.empty();

  // TODO(brycew): refactor so this is selected only in Tyler stuff
  private CaseCategory caseCategory;
  private String caseType;
  private String caseSubtype;
  private String paymentId;
  private List<FilingDoc> filingDocs = List.of();
  private Optional<LocalDate> returnDate = Optional.empty();
  
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
  
  public String getPlaintiffPartyType() {
    return plaintiffPartyType;
  }
  
  public List<Person> getDefendants() {
    return defendants;
  }
  
  public String getDefendantPartyType() {
    return defendantPartyType;
  }
  
  public List<String> getAttorneyIds() {
    return attorneyIds;
  }
  
  public Map<String, List<String>> getPartyAttorneyMap() {
    return partyToAttorneyIds;
  }
  
  /** We only store the mapping from Party to attorneys (since parties can have multiple attorneys,
   * but not vice-versa. */
  public Optional<String> getPartyRepByAttorney(String attorneyId) {
    for (Map.Entry<String, List<String>> partyToAttorneys : partyToAttorneyIds.entrySet()) {
      if (partyToAttorneys.getValue().contains(attorneyId)) {
        return Optional.of(partyToAttorneys.getKey());
      }
    }
    return Optional.empty();
  }
  
  public CaseCategory getCaseCategory() {
    return caseCategory;
  }
  
  public String getCaseType() {
    return caseType;
  }
  
  public List<CaseServiceContact> getServiceContacts() {
    return serviceContacts;
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
  
  public Optional<String> getPreviousCaseId() {
    return prevCaseId;
  }

  public Optional<String> getCaseDocketNumber() {
    return caseDocketNumber;
  }
  
  public Optional<LocalDate> getReturnDate() {
    return returnDate;
  }
  
  public JsonNode getMiscInfo() {
    return miscInfo;
  }
  
  public void setCourtLocation(String courtLocationId) {
    this.courtLocationId = courtLocationId;
  }
  
  public void setPlaintiffs(List<Person> plaintiffs) {
    this.plaintiffs = plaintiffs;
  }
  
  public void setPlaintiffPartyType(String plaintiffPartyType) {
    this.plaintiffPartyType = plaintiffPartyType;
  }
  
  public void setDefendants(List<Person> defendants) {
    this.defendants = defendants;
  }
  
  public void setDefendantPartyType(String defendantPartyType) {
    this.defendantPartyType = defendantPartyType;
  }

  public void setAttorneyIds(List<String> attorneyIds) {
    this.attorneyIds = attorneyIds;
  }
  
  public void setPartyAttorneyMap(Map<String, List<String>> partyToAttorneyIds) {
    this.partyToAttorneyIds = partyToAttorneyIds; 
  }
  
  public void setServiceContacts(List<CaseServiceContact> serviceContacts) {
    this.serviceContacts = serviceContacts;
  }

  public void setCaseCategory(CaseCategory caseCategory) {
    this.caseCategory = caseCategory;
  }
  
  public void setPreviousCaseId(String id) {
    this.prevCaseId = Optional.of(id);
  }

  public void setCaseDocketNumber(String num) {
    this.caseDocketNumber = Optional.of(num);
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
  
  public void setReturnDate(Optional<LocalDate> returnDate) {
    this.returnDate = returnDate;
  }
  
  public void setMiscInfo(JsonNode node) {
    this.miscInfo = node; 
  }
  
}
