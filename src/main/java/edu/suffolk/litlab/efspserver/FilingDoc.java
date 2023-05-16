package edu.suffolk.litlab.efspserver;

import fj.data.NonEmptyList;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO(brycew-later): this class is a mess. Refactor, considering the same pattern that's in
// FilingInformation: add a JsonNode / generic container for EFM specific settings
public class FilingDoc {
  private final Optional<NonEmptyString> userProvidedDescription;
  // TODO(#57): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  private final Optional<String> filingReferenceNum;
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  private final Optional<LocalDate> dueDate;
  // A valid filing code (complaint, motion, Appearance, Motion, etc.)
  // Sets the RegActionDesc attribute
  private final Optional<String> filingCode;
  private final UUID id;

  // Required to at least have one
  private List<PartyId> filingPartyIds;
  private Optional<String> filingAttorney;

  private final NonEmptyList<FilingAttachment> filingAttachments;

  // From filer, about this filing
  private String filingComments;
  // Only necessary if it's a motion?
  private final Optional<String> motionType;
  private final List<String> courtesyCopies;
  private final List<String> preliminaryCopies;

  private final List<OptionalService> optServices;
  private final Optional<FilingAction> filingAction;

  private final int seqNum;

  public FilingDoc(
      Optional<String> filingCode,
      List<PartyId> filingPartyIds,
      NonEmptyList<FilingAttachment> filingAttachments,
      int seqNum) {
    this(
        filingCode,
        "",
        Optional.empty(),
        Optional.empty(),
        filingPartyIds,
        Optional.empty(),
        filingAttachments,
        "",
        Optional.empty(),
        List.of(),
        List.of(),
        List.of(),
        Optional.empty(),
        seqNum);
  }

  /** Full constructor, in all it's mess. */
  public FilingDoc(
      Optional<String> filingCode,
      String userProvidedDescription,
      Optional<String> filingReferenceNum,
      Optional<LocalDate> dueDate,
      List<PartyId> filingPartyIds,
      Optional<String> filingAttorney,
      NonEmptyList<FilingAttachment> filingAttachments,
      String filingComments,
      Optional<String> motionType,
      List<OptionalService> optionalServices,
      List<String> courtesyCopies,
      List<String> preliminaryCopies,
      Optional<FilingAction> filingAction,
      int seqNum) {
    this.filingCode = filingCode;
    this.userProvidedDescription = NonEmptyString.create(userProvidedDescription);
    this.filingReferenceNum = filingReferenceNum;
    this.dueDate = dueDate;
    this.id = UUID.randomUUID();
    this.filingPartyIds = filingPartyIds;
    this.filingAttorney = filingAttorney;
    this.filingAttachments = filingAttachments;

    this.filingComments = filingComments;
    this.optServices = optionalServices;
    this.motionType = motionType;
    this.courtesyCopies = courtesyCopies;
    this.preliminaryCopies = preliminaryCopies;
    this.filingAction = filingAction;
    this.seqNum = seqNum;
  }

  /** Returns the sum of all of the attachment files lengths. */
  public int allAttachmentsLength() {
    int length = 0;
    for (var attachment : filingAttachments) {
      length += attachment.getFileContents().length;
    }
    return length;
  }

  public String getIdString() {
    return "id-" + id.toString();
  }

  public NonEmptyList<FilingAttachment> getFilingAttachments() {
    return filingAttachments;
  }

  public UUID getId() {
    return id;
  }

  public int seqNum() {
    return seqNum;
  }

  public List<PartyId> getFilingPartyIds() {
    return filingPartyIds;
  }

  public Optional<NonEmptyString> getDescription() {
    return userProvidedDescription;
  }

  public String getFilingComments() {
    return filingComments;
  }

  public void setFilingComments(String comments) {
    this.filingComments = comments;
  }

  public Optional<String> getFilingReferenceNum() {
    return filingReferenceNum;
  }

  public Optional<String> getFilingAttorney() {
    return filingAttorney;
  }

  public Optional<LocalDate> getDueDate() {
    return dueDate;
  }

  public List<String> getCourtesyCopies() {
    return courtesyCopies;
  }

  public List<String> getPreliminaryCopies() {
    return preliminaryCopies;
  }

  public Optional<String> getMotionType() {
    return motionType;
  }

  public List<OptionalService> getOptionalServices() {
    return optServices;
  }

  public Optional<String> getFilingCode() {
    return filingCode;
  }

  public Optional<FilingAction> getFilingAction() {
    return filingAction;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
