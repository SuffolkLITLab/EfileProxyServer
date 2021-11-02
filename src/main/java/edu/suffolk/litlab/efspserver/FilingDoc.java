package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// TODO(brycew-later): this class is a mess. Refactor, considering the same pattern that's in
// FilingInformation: add a JsonNode / generic container for EFM specific settings
public class FilingDoc {
  // Provides Document Type code / BinaryFormatStandardName
  final private String fileName;
  final private byte[] fileContents;
  final private Optional<String> userProvidedDescription;
  // TODO(#57): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  final private Optional<String> filingReferenceNum;
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  final private Optional<LocalDate> dueDate;
  // A valid filing code (complaint, motion, Appearance, Motion, etc.)
  // Sets the RegActionDesc attribute
  final private Optional<String> filingCode;
  final private UUID id;

  
  // Required to at least have one
  private List<PartyId> filingPartyIds;
  private Optional<String> filingAttorney;

  // This is, "determined via configuration within the EFM for each EFSP"?
  // So, we can just say yes?
  private String documentTypeFormatStandardName;
  final private boolean sendInBase64 = true;
  final private String filingComponentName;

  // From filer, about this filing
  private String filingComments;
  // Only necessary if it's a motion?
  final private Optional<String> motionType;
  final private List<String> courtesyCopies;
  final private List<String> preliminaryCopies;

  final private List<OptionalService> optServices;

  final private boolean isLeadDoc;

  public FilingDoc(Optional<String> filingCode, String fileName, InputStream fileStream) throws IOException {
    this(filingCode, fileName, fileStream, List.of(), "");
  }

  /** FilingDoc constructor for Jefferson Parish data.
   *
   * @throws IOException If the input stream can't be opened or read from
   */
  public FilingDoc(Optional<String> filingCode, String fileName, InputStream fileStream,
      List<PartyId> filingPartyIds,
      String filingComments) throws IOException  {
    this(filingCode, fileName, fileStream.readAllBytes(), Optional.empty(), Optional.empty(), Optional.empty(),
        filingPartyIds, Optional.empty(), "", "", "", Optional.empty(),
        List.of(), List.of(), List.of(), true);
    this.documentTypeFormatStandardName = ""; // Default to blank: we can't get the confidential code
  }

  public FilingDoc(Optional<String> filingCode, String fileName, InputStream fileStream,
      List<PartyId> filingPartyIds,
      String documentTypeFormatStandardName,
      String filingComponentName, boolean isLeadDoc) throws IOException {
    this(filingCode, fileName, fileStream.readAllBytes(), Optional.empty(), Optional.empty(), Optional.empty(),
        filingPartyIds, Optional.empty(), documentTypeFormatStandardName,
        filingComponentName, "", Optional.empty(), List.of(), List.of(), List.of(),
        isLeadDoc);
  }

  /** Full constructor, in all it's mess. */
  public FilingDoc(Optional<String> filingCode, String fileName, 
      byte[] fileContents, 
      Optional<String> userProvidedDescription,
      Optional<String> filingReferenceNum, Optional<LocalDate> dueDate, 
      List<PartyId> filingPartyIds, Optional<String> filingAttorney,
      String documentTypeFormatStandardName, String filingComponentName,
      String filingComments, Optional<String> motionType, List<OptionalService> optionalServices,
      List<String> courtesyCopies, List<String> preliminaryCopies, 
      boolean isLeadDoc) {
    this.filingCode = filingCode;
    this.fileName = fileName;
    this.fileContents = fileContents;
    this.userProvidedDescription = userProvidedDescription;
    this.filingReferenceNum= filingReferenceNum;
    this.dueDate = dueDate;
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

  public List<PartyId> getFilingPartyIds() {
    return filingPartyIds;
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

  public Optional<String> getFilingReferenceNum() {
    return filingReferenceNum;
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

  public Optional<String> getFilingCode() {
    return filingCode;
  }
}
