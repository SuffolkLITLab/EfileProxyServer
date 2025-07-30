package edu.suffolk.litlab.efsp.model;

/** An individual PDF, all a part of the same "document". The equivalent of an ALDocument. */
public class FilingAttachment {
  private final String filingComponentCode;
  // For the setBinaryDescriptionText
  private final String documentDescription;
  private final String fileName;
  private final byte[] fileContents;
  // This is, "determined via configuration within the EFM for each EFSP"?
  // So, we can just say yes?
  // Provides Document Type code / BinaryFormatStandardName
  private final String documentTypeFormatStandardName;

  // page count?

  public FilingAttachment(
      String fileName,
      byte[] fileStream,
      String documentTypeFormatStandardName,
      String filingComponentCode,
      String documentDescription) {
    this.filingComponentCode = filingComponentCode;
    this.fileName = fileName;
    this.documentTypeFormatStandardName = documentTypeFormatStandardName;
    this.documentDescription = documentDescription;
    this.fileContents = fileStream;
  }

  public byte[] getFileContents() {
    return fileContents;
  }

  public String getFileName() {
    return fileName;
  }

  public String getFilingComponent() {
    return filingComponentCode;
  }

  public String getDocumentTypeFormatStandardName() {
    return documentTypeFormatStandardName;
  }

  /** The description of this document. Goes into BinaryDescriptionText for Tyler. */
  public String getDocumentDescription() {
    return documentDescription;
  }
}
