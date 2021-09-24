package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tyler.ecf.extensions.common.FilingTypeType;

// TODO(brycew-later): this class is a mess. Refactor, considering the same pattern that's in
// FilingInformation: add a JsonNode / generic container for EFM specific settings
public class FilingDoc {
  // Provides Document Type code / BinaryFormatStandardName
  private String fileName;
  private byte[] fileContents;
  private Optional<String> userProvidedDescription;
  // TODO(#57): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  private Optional<String> filingReferenceNum;
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  private Optional<LocalDate> dueDate;
  // A valid filing code (complaint, motion, Appearance, Motion, etc.)
  // Sets the RegActionDesc attribute
  private String filingCodeName;
  private UUID id;

  
  public static class PartyId {
    public static PartyId CurrentFiling(String id) {
      return new PartyId(id, Kind.CURRENT_FILING);
    }
    
    public static PartyId Already(String id) {
      return new PartyId(id, Kind.ALREADY_IN);
    }
    
    private PartyId(String id, Kind kind) {
      this.id = id;
      this.kind = kind;
    }
    
    public boolean isInCurrentFiling() {
      return kind.equals(Kind.CURRENT_FILING);
    }

    public final String id;
    private enum Kind {
      CURRENT_FILING,
      ALREADY_IN
    }
    private final Kind kind;
  }

  // Required to at least have one
  private List<PartyId> filingPartyIds;
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

  public FilingDoc(String filingCodeName, String fileName, InputStream fileStream) throws IOException {
    this(filingCodeName, fileName, fileStream, List.of(), "");
  }

  /** FilingDoc constructor for Jefferson Parish data.
   *
   * @throws IOException If the input stream can't be opened or read from
   */
  public FilingDoc(String filingCodeName, String fileName, InputStream fileStream,
      List<PartyId> filingPartyIds,
      String filingComments) throws IOException  {
    this(filingCodeName, fileName, fileStream.readAllBytes(), Optional.empty(), Optional.empty(), Optional.empty(),
        filingPartyIds, Optional.empty(), "", "", "", Optional.empty(),
        List.of(), List.of(), List.of(), FilingTypeType.E_FILE, true);
    this.documentTypeFormatStandardName = ""; // Default to blank: we can't get the confidential code
  }

  public FilingDoc(String filingCodeName, String fileName, InputStream fileStream,
      List<PartyId> filingPartyIds,
      String documentTypeFormatStandardName,
      String filingComponentName, FilingTypeType filingAction, boolean isLeadDoc) throws IOException {
    this(filingCodeName, fileName, fileStream.readAllBytes(), Optional.empty(), Optional.empty(), Optional.empty(),
        filingPartyIds, Optional.empty(), documentTypeFormatStandardName,
        filingComponentName, "", Optional.empty(), List.of(), List.of(), List.of(),
        filingAction, isLeadDoc);
  }

  /** Full constructor, in all it's mess. */
  public FilingDoc(String filingCodeName, String fileName, 
      byte[] fileContents, 
      Optional<String> userProvidedDescription,
      Optional<String> filingReferenceNum, Optional<LocalDate> dueDate, 
      List<PartyId> filingPartyIds, Optional<String> filingAttorney,
      String documentTypeFormatStandardName, String filingComponentName,
      String filingComments, Optional<String> motionType, List<OptionalService> optionalServices,
      List<String> courtesyCopies, List<String> preliminaryCopies, FilingTypeType filingAction,
      boolean isLeadDoc) {
    this.filingCodeName = filingCodeName;
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

  public FilingTypeType getFilingAction() {
    return filingAction;
  }

  public String getFilingCodeName() {
    return filingCodeName;
  }
}
