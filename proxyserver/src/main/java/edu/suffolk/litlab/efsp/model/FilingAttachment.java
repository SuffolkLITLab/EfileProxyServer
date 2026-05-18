package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import java.util.Optional;

/** An individual PDF, all a part of the same "document". The equivalent of an ALDocument. */
public class FilingAttachment {
  private final FilingComponent filingComponentCode;
  // For the setBinaryDescriptionText
  private final String documentDescription;
  private final String fileName;
  private final byte[] fileContents;
  // This is, "determined via configuration within the EFM for each EFSP"?
  // So, we can just say yes?
  // Provides Document Type code / BinaryFormatStandardName
  private final Optional<DocumentTypeTableRow> documentTypeFormatStandardName;

  // page count?

  public FilingAttachment(
      String fileName,
      byte[] fileStream,
      Optional<DocumentTypeTableRow> documentTypeFormatStandardName,
      FilingComponent filingComponentCode,
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

  public FilingComponent getFilingComponent() {
    return filingComponentCode;
  }

  public Optional<DocumentTypeTableRow> getDocumentTypeFormatStandardName() {
    return documentTypeFormatStandardName;
  }

  /** The description of this document. Goes into BinaryDescriptionText for Tyler. */
  public String getDocumentDescription() {
    return documentDescription;
  }
}
