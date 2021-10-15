package edu.suffolk.litlab.efspserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

public class FilingInformation {

  private String courtLocationId;
  private List<Person> plaintiffs = List.of();
  private List<Person> defendants = List.of();
  
  /** A list of attorney UIDs. 
   * 
   * For Tyler at least, the Attorneys are registered in the system beforehand. In that case, these
   * are the GUIDs of the Attorneys in that system.
   * 
   * TODO(brycew-later): this isn't super general, and relies on registering Attorneys elsewhere. 
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

  // TODO(brycew-later): refactor so this is selected only in Tyler stuff
  private String caseCategoryCode;
  private String caseTypeCode;
  private String caseSubtypeCode;
  private String paymentId;
  private List<FilingDoc> filingDocs = List.of();
  private Optional<LocalDate> returnDate = Optional.empty();
  
  private Person leadContact;
  
  private JsonNode miscInfo;
  
  /** Gets all of the peole who are listed by filer ids in the filing docs.
   * This corresponds to the `users` variable in Docassemble interviews.
   *
   * @return The People who are filers in the filing documents
   */
  public List<FilingDoc.PartyId> getFilers() {
    List<FilingDoc.PartyId> filers = new ArrayList<FilingDoc.PartyId>();
    filingDocs.forEach(d -> filers.addAll(d.getFilingPartyIds()));
    return filers;
  }
  
  /** TODO(brycew): continue: 
   *  always get some DA specific contact info for the filing, they need to enter it there   
   * 
   * @return
   */
  public Person getLeadContact() {
    return leadContact;
  }
  
  public Optional<Person> getFilerById(String id) {
    for (Person per : plaintiffs) {
      if (per.getIdString().equals(id)) {
        return Optional.of(per);
      }
    }
    for (Person per : defendants) {
      if (per.getIdString().equals(id)) {
        return Optional.of(per);
      }
    }
    
    return Optional.empty();
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
  
  public String getCaseCategoryCode() {
    return caseCategoryCode;
  }
  
  public String getCaseTypeCode() {
    return caseTypeCode;
  }
  
  public List<CaseServiceContact> getServiceContacts() {
    return serviceContacts;
  }
  
  public String getCaseSubtypeCode() {
    return caseSubtypeCode;
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
  
  public void setDefendants(List<Person> defendants) {
    this.defendants = defendants;
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
  
  public void setCaseCategoryCode(String caseCategoryCode) {
    this.caseCategoryCode = caseCategoryCode;
  }
  
  public void setPreviousCaseId(String id) {
    this.prevCaseId = Optional.of(id);
  }

  public void setCaseDocketNumber(String num) {
    this.caseDocketNumber = Optional.of(num);
  }
  
  public void setCaseTypeCode(String caseTypeCode) {
    this.caseTypeCode = caseTypeCode;
  }
  
  public void setCaseSubtypeCode(String caseSubtypeId) {
    this.caseSubtypeCode = caseSubtypeId;
  }
  
  public void setLeadContact(Person leadContact) {
    this.leadContact = leadContact;
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
