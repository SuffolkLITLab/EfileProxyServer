package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.io.InputStream;

/** An individual PDF, all a part of the same "document". The equivalent of an ALDocument. */
public class FilingAttachment {
  final private String filingComponentCode;
  // For the setBinaryDescriptionText
  final private String fileName;
  final private byte[] fileContents;
  // This is, "determined via configuration within the EFM for each EFSP"?
  // So, we can just say yes?
  // Provides Document Type code / BinaryFormatStandardName
  final private String documentTypeFormatStandardName;
  // page count?
  
  public FilingAttachment(String fileName, InputStream fileStream,
      String documentTypeFormatStandardName, String filingComponentCode) throws IOException {
    this.filingComponentCode = filingComponentCode;
    this.fileName = fileName;
    this.documentTypeFormatStandardName = documentTypeFormatStandardName;
    this.fileContents = fileStream.readAllBytes();
  }
  
  public FilingAttachment(String fileName, byte[] fileStream,
      String documentTypeFormatStandardName, String filingComponentCode) {
    this.filingComponentCode = filingComponentCode;
    this.fileName = fileName;
    this.documentTypeFormatStandardName = documentTypeFormatStandardName;
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

}
