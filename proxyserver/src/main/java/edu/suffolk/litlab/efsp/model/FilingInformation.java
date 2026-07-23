package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CaseCategory;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CaseType;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.FilerType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilingInformation {
  private static Logger log = LoggerFactory.getLogger(FilingInformation.class);

  private String courtLocationId;

  /** Plaintiffs that are new to the case; not in the case info before this filing */
  private List<Person> newPlaintiffs = List.of();

  private List<Person> newDefendants = List.of();

  /**
   * A list of attorney UIDs.
   *
   * <p>For Tyler at least, the Attorneys are registered in the system beforehand. In that case,
   * these are the GUIDs of the Attorneys in that system.
   *
   * <p>TODO(brycew-later): this isn't super general, and relies on registering Attorneys elsewhere.
   * Make it more generic if possible.
   */
  private List<String> attorneyIds = List.of();

  /**
   * A map from party Ids (in the person Objs) to a list of their Attorneys
   *
   * <p>A party not present in the map means you don't know who the attorney is (or for subsequent
   * filings, don't want to modify any attorneys). A party with an empty list means the party is Pro
   * Se.
   */
  private Map<PartyId, List<String>> partyToAttorneyIds = Map.of();

  /**
   * List of service contacts to add to the case. Contacts are mostly an ID of the contact already
   * registered within the EFM system.
   */
  private List<CaseServiceContact> serviceContacts = List.of();

  /** A tracking ID from the EFM system for the existing case. For subsequent filing. */
  private Optional<String> prevCaseId = Optional.empty();

  /** Existing docket number, NOT from EFM system. For subsequent filing into non-indexed cases. */
  private Optional<String> caseDocketNumber = Optional.empty();

  private CaseCategory caseCategoryCode;
  private CaseType caseTypeCode;
  private Optional<NameAndCode> caseSubtypeCode = Optional.empty();
  private Optional<NameAndCode> procedureRemedy = Optional.empty();
  private Optional<NameAndCode> damageAmount = Optional.empty();
  private Map<String, String> crossRefs;
  private String paymentId;
  private List<FilingDoc> filingDocs = List.of();
  private Optional<LocalDate> returnDate = Optional.empty();

  /** Information about the original case if this is an appeals court case. */
  private Optional<LowerCourtInfo> lowerCourtInfo = Optional.empty();

  private Optional<Person> leadContact = Optional.empty();

  private Optional<FilerType> filerType;

  private Optional<BigDecimal> amountInControversy = Optional.empty();
  private Optional<BigDecimal> maxFeeAmount = Optional.empty();
  private boolean contestedCase = false;
  private boolean outOfState = false;
  private EmailTemplates emailTemplates = new EmailTemplates();

  /**
   * Gets all of the peole who are listed by filer ids in the filing docs. This corresponds to the
   * `users` variable in Docassemble interviews.
   *
   * @return The People who are filers in the filing documents
   */
  public List<PartyId> getFilers() {
    List<PartyId> filers = new ArrayList<PartyId>();
    filingDocs.forEach(d -> filers.addAll(d.getFilingPartyIds()));
    return filers;
  }

  /**
   * TODO(brycew): continue: always get some DA specific contact info for the filing, they need to
   * enter it there
   *
   * @return
   */
  public Optional<Person> getLeadContact() {
    return leadContact;
  }

  public String makeCaseTitle() {
    if (getNewPlaintiffs().size() > 0 && getNewDefendants().size() > 0) {
      return getNewPlaintiffs().get(0).getName().getTitleName()
          + " v. "
          + getNewDefendants().get(0).getName().getTitleName();
    } else if (getNewPlaintiffs().size() > 0) {
      return "In the matter of " + getNewPlaintiffs().get(0).getName().getTitleName();
    } else if (getNewDefendants().size() > 0) {
      return "In the matter of " + getNewDefendants().get(0).getName().getTitleName();
    } else {
      log.warn(
          "Cannot guess title of the case (not existing case, no plaintiffs or defendants)"
              + " (filing "
              + getFilings().get(0).getFilingComments()
              + ")\nUsing backup of lead contact");
      return "On Behalf of " + leadContact.map(u -> u.getName().getFullName()).orElse("the Filer");
    }
  }

  public String getCourtLocation() {
    return courtLocationId;
  }

  public List<Person> getNewPlaintiffs() {
    return newPlaintiffs;
  }

  public List<Person> getNewDefendants() {
    return newDefendants;
  }

  public List<String> getAttorneyIds() {
    return attorneyIds;
  }

  public Map<PartyId, List<String>> getPartyAttorneyMap() {
    return partyToAttorneyIds;
  }

  /**
   * We only store the mapping from Party to attorneys (since parties can have multiple attorneys,
   * but not vice-versa.
   */
  public List<PartyId> getPartyRepByAttorney(String attorneyId) {
    List<PartyId> parties = new ArrayList<>();
    for (Map.Entry<PartyId, List<String>> partyToAttorneys : partyToAttorneyIds.entrySet()) {
      if (partyToAttorneys.getValue().contains(attorneyId)) {
        parties.add(partyToAttorneys.getKey());
      }
    }
    return parties;
  }

  public CaseCategory getCaseCategoryCode() {
    return caseCategoryCode;
  }

  public CaseType getCaseTypeCode() {
    return caseTypeCode;
  }

  public List<CaseServiceContact> getServiceContacts() {
    return serviceContacts;
  }

  public Optional<NameAndCode> getCaseSubtypeCode() {
    return caseSubtypeCode;
  }

  public Optional<NameAndCode> getProcedureRemedy() {
    return procedureRemedy;
  }

  public Optional<NameAndCode> getDamageAmount() {
    return damageAmount;
  }

  public Map<String, String> getCrossRefs() {
    return crossRefs;
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

  public Optional<FilerType> getFilerType() {
    return filerType;
  }

  public Optional<LowerCourtInfo> getLowerCourtInfo() {
    return lowerCourtInfo;
  }

  public Optional<BigDecimal> getAmountInControversy() {
    return amountInControversy;
  }

  public Optional<BigDecimal> getMaxFeeAmount() {
    return maxFeeAmount;
  }

  public boolean isContestedCase() {
    return contestedCase;
  }

  public boolean getOutOfState() {
    return outOfState;
  }

  public EmailTemplates getEmailTemplates() {
    return emailTemplates;
  }

  public void setCourtLocation(String courtLocationId) {
    this.courtLocationId = courtLocationId;
  }

  public void setNewPlaintiffs(List<Person> plaintiffs) {
    this.newPlaintiffs = plaintiffs;
  }

  public void setNewDefendants(List<Person> defendants) {
    this.newDefendants = defendants;
  }

  public void setAttorneyIds(List<String> attorneyIds) {
    this.attorneyIds = attorneyIds;
  }

  public void setPartyAttorneyMap(Map<PartyId, List<String>> partyToAttorneyIds) {
    this.partyToAttorneyIds = partyToAttorneyIds;
  }

  public void setServiceContacts(List<CaseServiceContact> serviceContacts) {
    this.serviceContacts = serviceContacts;
  }

  public void setCaseCategoryCode(CaseCategory caseCategoryCode) {
    this.caseCategoryCode = caseCategoryCode;
  }

  public void setPreviousCaseId(String id) {
    this.prevCaseId = Optional.ofNullable(id);
  }

  public void setCaseDocketNumber(String num) {
    this.caseDocketNumber = Optional.ofNullable(num);
  }

  public void setCaseTypeCode(CaseType caseTypeCode) {
    this.caseTypeCode = caseTypeCode;
  }

  public void setCaseSubtypeCode(Optional<NameAndCode> caseSubtypeId) {
    this.caseSubtypeCode = caseSubtypeId;
  }

  public void setProcedureRemedy(Optional<NameAndCode> procedureRemedy) {
    this.procedureRemedy = procedureRemedy;
  }

  public void setDamageAmount(Optional<NameAndCode> damageAmount) {
    this.damageAmount = damageAmount;
  }

  public void setCrossRefs(Map<String, String> crossRefs) {
    this.crossRefs = crossRefs;
  }

  public void setLeadContact(Person leadContact) {
    this.leadContact = Optional.of(leadContact);
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

  public void setFilerType(Optional<FilerType> filerType) {
    this.filerType = filerType;
  }

  public void setLowerCourtInfo(LowerCourtInfo info) {
    this.lowerCourtInfo = Optional.ofNullable(info);
  }

  public void setLowerCourtInfo(Optional<LowerCourtInfo> info) {
    this.lowerCourtInfo = info;
  }

  public void setAmountInControversy(Optional<BigDecimal> amtInControversy) {
    this.amountInControversy = amtInControversy;
  }

  public void setMaxFeeAmount(Optional<BigDecimal> maxFeeAmount) {
    this.maxFeeAmount = maxFeeAmount;
  }

  public void setIsContestedCase(boolean isContestedCase) {
    this.contestedCase = isContestedCase;
  }

  public void setOutOfState(boolean outOfState) {
    this.outOfState = outOfState;
  }

  public void setEmailTemplates(EmailTemplates emailTemplates) {
    this.emailTemplates = emailTemplates;
  }
}
