package edu.suffolk.assemblyline.efspserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import edu.suffolk.assemblyline.efspserver.codes.NameAndCode;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.proxy.xsd._2.Base64Binary;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import javax.xml.bind.JAXBElement;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentAttachmentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionMetadataType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentRenditionType;
import tyler.ecf.extensions.common.DocumentType;
import tyler.ecf.extensions.common.FilingTypeType;

// TODO(brycew): this class is a mess. Redo please
public class Filing {
  // Provides Document Type code / BinaryFormatStandardName
  String fileName; 
  InputStream fileStream;
  Optional<String> userProvidedDescription;
  // TODO(brycew): what is this? Might be able to be a dup of the GUID,
  // it's returned with Get FilingList
  String documentFileControlId; 
  // See DueDateAvailableForFilers datafield and DocumentInformationCutOffDate
  Optional<LocalDate> dueDate; 
  // A valid filing code (complaint, motion, Appearance, Motion, etc.)
  NameAndCode regActionDesc;
  private String id;
  
  // Required to at least have one
  List<String> filingPartyIds;
  // TODO(brycew): see FilingFilingAttorneyView data field config
  Optional<String> filingAttorney; 
  
  // This is, "determined via configuration within the EFM for each EFSP"?
  // So, we can just say yes?
  boolean sendInBase64 = true;
  // Literally should just be if it's confidential or not. (or "Hot fix" or public).
  // Search options in "documenttype" table with location
  String documentTypeFormatStandardName;
  String binaryCategoryComponent;
  
  // From filer, about this filing
  String filingComments;
  // Only necessary if it's a motion?
  Optional<String> motionType;
  List<String> courtesyCopies;
  List<String> preliminaryCopies;
  FilingTypeType filingAction;

  private boolean isLeadDoc;
  
  /** Filing constructor for Jefferson Parish data. */
  public Filing(String fileName, InputStream fileStream,
      NameAndCode regActionDesc, List<String> filingPartyIds,
      String filingComments)  {
    this(fileName, fileStream, Optional.empty(), "", Optional.empty(), regActionDesc,
        filingPartyIds, Optional.empty(), "", "", "", Optional.empty(),
        List.of(), List.of(), FilingTypeType.E_FILE, true);
    String[] splits = fileName.split("\\.");
    if (splits.length > 1) {
      documentTypeFormatStandardName = splits[1]; 
    }
  }
  
  public Filing(String fileName, InputStream fileStream,
      NameAndCode regActionDesc, List<String> filingPartyIds,
      String documentTypeFormatStandardName,
      String binaryCategoryComponent, FilingTypeType filingAction) {
    this(fileName, fileStream, Optional.empty(), "", Optional.empty(), regActionDesc,
        filingPartyIds, Optional.empty(), documentTypeFormatStandardName, 
        binaryCategoryComponent, "", Optional.empty(), List.of(), List.of(), 
        filingAction, true);
  }

  /** Full constructor, in all it's mess. */
  public Filing(String fileName, InputStream fileStream, Optional<String> userProvidedDescription,
      String documentFileControlId, Optional<LocalDate> dueDate, NameAndCode regActionDesc,
      List<String> filingPartyIds, Optional<String> filingAttorney,
      String documentTypeFormatStandardName, String binaryCategoryComponent,
      String filingComments, Optional<String> motionType,
      List<String> courtesyCopies, List<String> preliminaryCopies, FilingTypeType filingAction,
      boolean isLeadDoc) {
    this.fileName = fileName;
    this.fileStream = fileStream;
    this.userProvidedDescription = userProvidedDescription;
    this.documentFileControlId = documentFileControlId;
    this.dueDate = dueDate;
    this.regActionDesc = regActionDesc;
    this.id = "id-" + UUID.randomUUID().toString();
    this.filingPartyIds = filingPartyIds;
    this.filingAttorney = filingAttorney;
    this.documentTypeFormatStandardName = documentTypeFormatStandardName;
    this.binaryCategoryComponent = binaryCategoryComponent;
    
    this.filingComments = filingComments;
    this.motionType = motionType;
    this.courtesyCopies = courtesyCopies;
    this.preliminaryCopies = preliminaryCopies;
    this.filingAction = filingAction;
    this.isLeadDoc = isLeadDoc;
  }
  
  public String getId() {
    return id;
  }
  
  public boolean isLead() {
    return isLeadDoc;
  }
  
  public JAXBElement<DocumentType> getDocument(int sequenceNum) throws IOException {
    tyler.ecf.extensions.common.ObjectFactory tylerObjFac = 
        new tyler.ecf.extensions.common.ObjectFactory();
    gov.niem.niem.niem_core._2.ObjectFactory niemObjFac = 
        new gov.niem.niem.niem_core._2.ObjectFactory();
    DocumentType docType = tylerObjFac.createDocumentType();
    String desc = userProvidedDescription.orElse(fileName);
    docType.setDocumentDescriptionText(XmlHelper.convertText(desc));

    docType.setDocumentFileControlID(XmlHelper.convertString(documentFileControlId)); 
    dueDate.ifPresent((date) -> {
      DateType cutOffDate = XmlHelper.convertDate(date); 
      docType.setDocumentInformationCutOffDate(cutOffDate);
    });
    
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory oasisObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    docType.setDocumentSequenceID(XmlHelper.convertString(Integer.toString(sequenceNum)));
    DocumentMetadataType metadata = oasisObjFac.createDocumentMetadataType();
    metadata.setRegisterActionDescriptionText(XmlHelper.convertText(regActionDesc.getCode()));
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
    
    // TODO(brycew): what should this actually be? Very unclear
    DocumentAttachmentType attachment = oasisObjFac.createDocumentAttachmentType();
    attachment.setBinaryDescriptionText(XmlHelper.convertText(fileName)); 
    attachment.setBinaryCategoryText(XmlHelper.convertText(binaryCategoryComponent));
    attachment.setBinaryFormatStandardName(XmlHelper.convertText(documentTypeFormatStandardName));
    if (sendInBase64) {
      attachment.setBinaryLocationURI(XmlHelper.convertUri(fileName));
      byte[] data = fileStream.readAllBytes(); 
      JAXBElement<Base64Binary> n = 
          niemObjFac.createBinaryBase64Object(XmlHelper.convertBase64(data));
      System.err.println(XmlHelper.objectToXmlStrOrError(n.getValue(), Base64Binary.class));
      attachment.setBinaryObject(n); 
    } else {
      // TODO(brycew): DO this: make the file downloadable from the Proxy server
    }
    // The document itself
    DocumentRenditionMetadataType renditionMetadata = 
        oasisObjFac.createDocumentRenditionMetadataType();
    renditionMetadata.getDocumentAttachment().add(attachment);
    
    DocumentRenditionType rendition = oasisObjFac.createDocumentRenditionType();
    rendition.setDocumentRenditionMetadata(renditionMetadata);
    docType.getDocumentRendition().add(rendition);
    
    String cc = courtesyCopies.stream().reduce("", (base, str) -> base + "," + str);
    docType.setCourtesyCopiesText(XmlHelper.convertText(cc));
    String prelim = preliminaryCopies.stream().reduce("", (base, str) -> base + "," + str);
    docType.setPreliminaryCopiesText(XmlHelper.convertText(prelim));
    docType.setFilingCommentsText(XmlHelper.convertText(filingComments));
    motionType.ifPresent((mt) -> docType.setMotionTypeCode(XmlHelper.convertText(mt)));
    docType.setFilingAction(filingAction);

    if (isLeadDoc) {
      return tylerObjFac.createFilingLeadDocument(docType);
    } else {
      return tylerObjFac.createFilingConnectedDocument(docType);
    }
  }
  
  public JsonElement getAsStandardJson(Gson gson) throws IOException {
    // TODO(brycew): get David Benton to let us have multiple filing parties
    //JsonArray filingParties = new JsonArray(); 
    /*
    for (String filingPartyId : filingPartyIds) {
      JsonObject filingParty = new JsonObject(); 
      filingParty.add("IdentificationID", new JsonPrimitive(filingPartyId));
      filingParty.add("IdentificationCategoryText", new JsonPrimitive("REFERENCE"));
      filingParties.add(filingParty);
    }
    */
    JsonObject filingParty = new JsonObject(); 
    filingParty.add("IdentificationID", new JsonPrimitive(filingPartyIds.get(0)));
    filingParty.add("IdentificationCategoryText", new JsonPrimitive("REFERENCE"));
    JsonObject metadata = new JsonObject(); 
    metadata.add("FilingPartyID", filingParty);
    metadata.add("RegisterActionDescriptionText", new JsonPrimitive(regActionDesc.getName()));
    
    JsonObject docAttachment = new JsonObject(); 
    byte[] data = fileStream.readAllBytes();  
    String encodedDoc = new String(Base64.getEncoder().encode(data));
    docAttachment.add("BinaryBase64Object", new JsonPrimitive(encodedDoc));
    docAttachment.add("DocumentName", new JsonPrimitive(fileName));
    
    JsonObject finalObj = new JsonObject(); 
    finalObj.add("DocumentMetadata", metadata);
    finalObj.add("DocumentAttachment", docAttachment);
    finalObj.add("FilingCommentsText", new JsonPrimitive(filingComments));
    return finalObj; 
  }
  
  public static class Builder {
    private static Logger log = Logger.getLogger("mylogger"); 

    private static boolean hasStringMember(JsonObject obj, String memberName) {
      return obj.has(memberName) 
          && obj.get(memberName).isJsonPrimitive() 
          && obj.getAsJsonPrimitive(memberName).isString();
    }

    public static Optional<Filing> createFiling(JsonElement filingJson, 
        List<String> filingPartyIds) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      log.info("Starting to extract filing" + gson.toJson(filingJson));
      if (!filingJson.isJsonObject()) {
        return Optional.empty();
      }

      JsonObject filingSubset = filingJson.getAsJsonObject();

      try {
        if (!hasStringMember(filingSubset, "data_url")) {
          log.warning("Refusing to parse filing without data_url: " + gson.toJson(filingSubset));
          return Optional.empty();
        }
        if (!hasStringMember(filingSubset, "filename")) {
          log.warning("Refusing to parse filename without data_url: " + gson.toJson(filingSubset));
          return Optional.empty();
        }
        // TODO(brycew): we need to put URLs of all of the other filings and read in those files
        URL inUrl = new URL(filingSubset.getAsJsonPrimitive("data_url").getAsString());
        // Get: filename
        String fileName = filingSubset.getAsJsonPrimitive("filename").getAsString() + ".pdf";
        // TODO(brycew): where can I get the "Motion" from the interview?
        NameAndCode regActionDesc = new NameAndCode("Motion", "");
        // TODO(brycew): grab the user's comments to the court clerk from the cover page
        // TODO(brycew): the above will require us to pass the full json
        String filingComments = "";
        HttpURLConnection conn = (HttpURLConnection) inUrl.openConnection();
        conn.setRequestMethod("GET");
        return Optional.of(new Filing(fileName, conn.getInputStream(), regActionDesc, 
            filingPartyIds, filingComments));
      } catch (IOException ex) {
        log.warning("IOException trying to to parse data_url: " + ex + ";; " 
            + gson.toJson(filingSubset));
        // TODO(brycew): this is where we should start returning errors instead of optionals
        return Optional.empty();
      }
    }
    
  }
}
