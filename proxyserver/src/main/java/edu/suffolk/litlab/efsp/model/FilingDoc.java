package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.stdlib.NonEmptyString;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.FilingCode;
import fj.data.NonEmptyList;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO(brycew-later): this class is a mess. Refactor
public class FilingDoc {
  private final Optional<NonEmptyString> userProvidedDescription;
  // Tyler has crazy dumb rules regarding the title of a doc; it's set here
  private final Optional<String> descriptionFromSpec;
  // TODO(#57): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  private final Optional<String> filingReferenceNum;
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  private final Optional<LocalDate> dueDate;
  // A valid filing code (complaint, motion, Appearance, Motion, etc.)
  // Sets the RegActionDesc attribute
  private final FilingCode filingCode;
  private final UUID id;

  // Required to at least have one
  private List<PartyId> filingPartyIds;
  private Optional<String> filingAttorney;

  private final NonEmptyList<FilingAttachment> filingAttachments;

  // From filer, about this filing
  private Optional<String> filingComments;
  // Only necessary if it's a motion?
  private final Optional<NameAndCode> motionType;
  private final List<String> courtesyCopies;
  private final List<String> preliminaryCopies;

  private final List<OptionalService> optServices;
  private final Optional<FilingAction> filingAction;

  private final int sequenceNum;

  public FilingDoc(
      FilingCode filingCode,
      List<PartyId> filingPartyIds,
      NonEmptyList<FilingAttachment> filingAttachments,
      int sequenceNum) {
    this(
        filingCode,
        "",
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        filingPartyIds,
        Optional.empty(),
        filingAttachments,
        Optional.empty(),
        Optional.empty(),
        List.of(),
        List.of(),
        List.of(),
        Optional.empty(),
        sequenceNum);
  }

  /** Full constructor, in all it's mess. */
  public FilingDoc(
      FilingCode filingCode,
      String userProvidedDescription,
      Optional<String> descriptionFromSpec,
      Optional<String> filingReferenceNum,
      Optional<LocalDate> dueDate,
      List<PartyId> filingPartyIds,
      Optional<String> filingAttorney,
      NonEmptyList<FilingAttachment> filingAttachments,
      Optional<String> filingComments,
      Optional<NameAndCode> motionType,
      List<OptionalService> optionalServices,
      List<String> courtesyCopies,
      List<String> preliminaryCopies,
      Optional<FilingAction> filingAction,
      int sequenceNum) {
    this.filingCode = filingCode;
    this.userProvidedDescription = NonEmptyString.create(userProvidedDescription);
    this.descriptionFromSpec = descriptionFromSpec;
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
    this.sequenceNum = sequenceNum;
  }

  /** Returns the sum of all of the attachment files lengths. */
  public int allAttachmentsLength() {
    int length = 0;
    for (var attachment : filingAttachments) {
      length += attachment.fileContents().length;
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

  public int sequenceNum() {
    return sequenceNum;
  }

  public List<PartyId> getFilingPartyIds() {
    return filingPartyIds;
  }

  public Optional<NonEmptyString> getDescription() {
    return userProvidedDescription;
  }

  public Optional<String> getFilingComments() {
    return filingComments;
  }

  public void setFilingComments(String comments) {
    this.filingComments = Optional.of(comments);
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

  public Optional<NameAndCode> getMotionType() {
    return motionType;
  }

  public List<OptionalService> getOptionalServices() {
    return optServices;
  }

  public FilingCode getFilingCode() {
    return filingCode;
  }

  public Optional<FilingAction> getFilingAction() {
    return filingAction;
  }

  public Optional<String> descriptionFromSpec() {
    return descriptionFromSpec;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }
}
