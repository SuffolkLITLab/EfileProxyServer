package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tyler.ecf.extensions.common.FilingTypeType;

// TODO(brycew): this class is a mess. Redo please. Consider the same pattern that's in
// FilingInformation: add a JsonNode / generic container for EFM specific settings
public class FilingDoc {
  // Provides Document Type code / BinaryFormatStandardName
  private String fileName;
  private byte[] fileContents;
  private Optional<String> userProvidedDescription;
  // TODO(brycew): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  private String documentFileControlId;
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  private Optional<LocalDate> dueDate;
  private Optional<LocalDate> returnDate;
  // A valid filing code (complaint, motion, Appearance, Motion, etc.)
  // Sets the RegActionDesc attribute
  //private String filingCodeName;
  private UUID id;

  // Required to at least have one
  private List<String> filingPartyIds;
  // TODO(brycew): see FilingFilingAttorneyView data field config
  private Optional<String> filingAttorney;

  // This is, "determined via configuration within the EFM for each EFSP"?
  // So, we can just say yes?
  String documentTypeFormatStandardName;
  boolean sendInBase64 = true;
  String filingComponentName;

  // From filer, about this filing
  String filingComments;
  // Only necessary if it's a motion?
  Optional<String> motionType;
  List<String> courtesyCopies;
  List<String> preliminaryCopies;
  FilingTypeType filingAction;

  List<OptionalService> optServices;

  private boolean isLeadDoc;

  public FilingDoc(String fileName, InputStream fileStream) throws IOException {
    this(fileName, fileStream, List.of(), "");
  }

  /** FilingDoc constructor for Jefferson Parish data.
   *
   * @throws IOException If the input stream can't be opened or read from
   */
  public FilingDoc(String fileName, InputStream fileStream,
      List<String> filingPartyIds,
      String filingComments) throws IOException  {
    this(fileName, fileStream.readAllBytes(), Optional.empty(), "", Optional.empty(), Optional.empty(),
        filingPartyIds, Optional.empty(), "", "", "", Optional.empty(),
        List.of(), List.of(), List.of(), FilingTypeType.E_FILE, true);
    this.documentTypeFormatStandardName = ""; // Default to blank: we can't get the confidential code
  }

  public FilingDoc(String fileName, InputStream fileStream,
      List<String> filingPartyIds,
      String documentTypeFormatStandardName,
      String filingComponentName, FilingTypeType filingAction, boolean isLeadDoc) throws IOException {
    this(fileName, fileStream.readAllBytes(), Optional.empty(), "", Optional.empty(), Optional.empty(),
        filingPartyIds, Optional.empty(), documentTypeFormatStandardName,
        filingComponentName, "", Optional.empty(), List.of(), List.of(), List.of(),
        filingAction, isLeadDoc);
  }

  /** Full constructor, in all it's mess. */
  public FilingDoc(String fileName, byte[] fileContents, Optional<String> userProvidedDescription,
      String documentFileControlId, Optional<LocalDate> dueDate, Optional<LocalDate> returnDate,
      List<String> filingPartyIds, Optional<String> filingAttorney,
      String documentTypeFormatStandardName, String filingComponentName,
      String filingComments, Optional<String> motionType, List<OptionalService> optionalServices,
      List<String> courtesyCopies, List<String> preliminaryCopies, FilingTypeType filingAction,
      boolean isLeadDoc) {
    this.fileName = fileName;
    this.fileContents = fileContents;
    this.userProvidedDescription = userProvidedDescription;
    this.documentFileControlId = documentFileControlId;
    this.dueDate = dueDate;
    this.returnDate = returnDate;
    this.id = UUID.randomUUID();
    this.filingPartyIds = filingPartyIds;
    this.filingAttorney = filingAttorney;
    this.documentTypeFormatStandardName = documentTypeFormatStandardName;
    this.filingComponentName = filingComponentName;

    this.filingComments = filingComments;
    this.optServices = optionalServices;
    this.motionType = motionType;
    this.courtesyCopies = courtesyCopies;
    this.preliminaryCopies = preliminaryCopies;
    this.filingAction = filingAction;
    this.isLeadDoc = isLeadDoc;
  }

  public String getIdString() {
    return "id-" + id.toString();
  }

  public UUID getId() {
    return id;
  }

  public boolean isLead() {
    return isLeadDoc;
  }

  public List<String> getFilingPartyIds() {
    return filingPartyIds;
  }

  public void setFilingPartyIds(List<String> filingPartyIds) {
    this.filingPartyIds = filingPartyIds;
  }

  public Optional<String> getDescription() {
    return userProvidedDescription;
  }

  public byte[] getFileContents() {
    return fileContents;
  }

  public String getFilingComments() {
    return filingComments;
  }

  public void setFilingComments(String comments) {
    this.filingComments = comments;
  }

  public String getFileName() {
    return fileName;
  }

  public String getDocumentFileControlId() {
    return documentFileControlId;
  }

  public Optional<String> getFilingAttorney() {
    return filingAttorney;
  }

  public Optional<LocalDate> getDueDate() {
    return dueDate;
  }

  public boolean getInBase64() {
    return sendInBase64;
  }

  public Optional<LocalDate> getReturnDate() {
    return returnDate;
  }

  public String getFilingComponentName() {
    return filingComponentName;
  }

  public String getDocumentTypeFormatStandardName() {
    return documentTypeFormatStandardName;
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

  public FilingTypeType getFilingAction() {
    return filingAction;
  }
}
