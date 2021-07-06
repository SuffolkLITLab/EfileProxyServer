package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efspserver.FilingDoc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class FilingJeffNetJacksonSerializer extends StdSerializer<FilingDoc> {

  private static final long serialVersionUID = 1L;

  protected FilingJeffNetJacksonSerializer(Class<FilingDoc> t) {
    super(t);
  }

  @Override
  public void serialize(FilingDoc filingDoc, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    List<FilingParty> filingPartyList = new ArrayList<FilingParty>(); 
    for (String filingPartyId : filingDoc.getFilingPartyIds()) { 
      FilingParty p = new FilingParty();
      p.id = filingPartyId; 
      p.idCategoryText = "REFERENCE";
      filingPartyList.add(p);
    }
    FilingParties filingParties = new FilingParties();
    filingParties.filingParties = filingPartyList;
    Metadata metadata = new Metadata(); 
    metadata.filingParties = filingParties;
    metadata.regAction = filingDoc.getRegisterAction().getName();
    
    DocAttachment docAttachment = new DocAttachment(); 
    byte[] data = filingDoc.getFileContents(); 
    String encodedDoc = new String(Base64.getEncoder().encode(data));
    docAttachment.encodedDoc = encodedDoc;
    docAttachment.documentName = filingDoc.getFileName(); 
    
    gen.writeStartObject();
    gen.writeObjectField("DocumentMetadata", metadata);
    gen.writeObjectField("DocumentAttachment", docAttachment);
    gen.writeStringField("FilingCommentsText", filingDoc.getFilingComments());
    gen.writeEndObject();
  }
  
  private class DocAttachment {
    @JsonProperty("BinaryBase64Object")
    String encodedDoc;
    
    @JsonProperty("DocumentName")
    String documentName;
  }
  
  private class Metadata {
    @JsonProperty("FilingParties")
    FilingParties filingParties;
    
    @JsonProperty("RegisterActionDescriptionText")
    String regAction;
  }
  
  private class FilingParties {
    @JsonProperty("FilingParty")
    List<FilingParty> filingParties;
  }
  
  private class FilingParty {
    @JsonProperty("IdentificationID")
    String id;

    @JsonProperty("IdentificationCategoryText")
    String idCategoryText;
  }

}
