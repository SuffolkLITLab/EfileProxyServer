package edu.suffolk.assemblyline.efspserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBElement;

import gov.niem.niem.niem_core._2.DateType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentAttachmentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import tyler.ecf.extensions.common.DocumentType;
import tyler.ecf.extensions.common.FilingTypeType;

public class Filing {
  File file; // Provides Document Type code / BinaryFormatStandardName
  String filingCode;
  String title;
  Optional<String> userProvidedDescription;
  // TODO(brycew): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  String documentFileControlId; 
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  Optional<LocalDate> dueDate; 
  // A valid filing code
  String regActionDesc;
  // TODO(brycew): generate on construction
  private String id;

  List<String> filingPartyIds;
  Optional<String> filingAttorney; // TODO(brycew): see FilingFilingAttorneyView data field config
  
  boolean sendInBase64;
  String documentTypeFormatStandardName;
  String binaryCategoryComponent;
  
  // From filer, about this filing
  String filingComments;
  String motionType;
  List<String> courtesyCopies;
  List<String> preliminaryCopies;
  FilingTypeType filingAction;

  private boolean isLeadDoc;
  
  public String getId() {
    return id;
  }
  
  public boolean isLead() {
    return isLeadDoc;
  }
  
  public JAXBElement<DocumentType> getDocument(int sequenceNum) throws IOException {
    tyler.ecf.extensions.common.ObjectFactory tylerObjFac = 
        new tyler.ecf.extensions.common.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory oasisObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    gov.niem.niem.niem_core._2.ObjectFactory niemObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
    DocumentType docType = tylerObjFac.createDocumentType();
    String desc = userProvidedDescription.orElse(file.getName());
    docType.setDocumentDescriptionText(XmlHelper.convertText(desc));

    docType.setDocumentFileControlID(XmlHelper.convertString(documentFileControlId)); 
    dueDate.ifPresent((date) -> {
      DateType cutOffDate = XmlHelper.convertDate(date); 
      docType.setDocumentInformationCutOffDate(cutOffDate);
    });
    
    docType.setDocumentSequenceID(XmlHelper.convertString(Integer.toString(sequenceNum)));
    DocumentMetadataType metadata = oasisObjFac.createDocumentMetadataType();
    metadata.setRegisterActionDescriptionText(XmlHelper.convertText(regActionDesc));
    if (filingAttorney.isPresent()) {
      metadata.setFilingAttorneyID(XmlHelper.convertId(filingAttorney.get(), "REFERENCE"));
    } else {
      // "This field should contain empty values for Individual filers"
      metadata.setFilingAttorneyID(XmlHelper.convertId("", "")); 
    }
    for (String filingPartyId : filingPartyIds) {
      metadata.getFilingPartyID().add(XmlHelper.convertId(filingPartyId, "REFERENCE"));
    }
    docType.setDocumentMetadata(metadata);
    
    // The document itself
    DocumentRenditionType rendition = oasisObjFac.createDocumentRenditionType();
    DocumentRenditionMetadataType renditionMetadata = oasisObjFac.createDocumentRenditionMetadataType();
    // TODO(brycew): what should this actually be? Very unclear
    DocumentAttachmentType attachment = oasisObjFac.createDocumentAttachmentType();
    attachment.setBinaryDescriptionText(XmlHelper.convertText(file.getName()));
    attachment.setBinaryCategoryText(XmlHelper.convertText(binaryCategoryComponent));
    attachment.setBinaryFormatStandardName(XmlHelper.convertText(documentTypeFormatStandardName));
    if (sendInBase64) {
      attachment.setBinaryLocationURI(XmlHelper.convertUri(file.getName()));
      FileInputStream reader = new FileInputStream(file);
      byte[] data = new byte[(int) file.length()];
      reader.read(data);
      reader.close();
      attachment.setBinaryObject(
          niemObjFac.createBinaryBase64Object(XmlHelper.convertBase64(data)));
    } else {
      // TODO(brycew): DO this: make the file downloadable from the Proxy server
    }
    renditionMetadata.getDocumentAttachment().add(attachment);
    
    rendition.setDocumentRenditionMetadata(renditionMetadata);
    docType.getDocumentRendition().add(rendition);
    
    String cc = courtesyCopies.stream().reduce("", (base, str) -> base + "," + str);
    docType.setCourtesyCopiesText(XmlHelper.convertText(cc));
    String prelim = preliminaryCopies.stream().reduce("", (base, str) -> base + "," + str);
    docType.setPreliminaryCopiesText(XmlHelper.convertText(prelim));
    docType.setFilingCommentsText(XmlHelper.convertText(filingComments));
    docType.setMotionTypeCode(XmlHelper.convertText(motionType));
    docType.setFilingAction(filingAction);

    if (isLeadDoc) {
      return tylerObjFac.createFilingLeadDocument(docType);
    } else {
      return tylerObjFac.createFilingConnectedDocument(docType);
    }
  }
}
