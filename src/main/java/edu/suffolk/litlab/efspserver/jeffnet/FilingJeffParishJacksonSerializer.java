package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efspserver.Filing;
import java.io.IOException;
import java.util.Base64;

public class FilingJeffParishJacksonSerializer extends StdSerializer<Filing> {

  private static final long serialVersionUID = 1L;

  protected FilingJeffParishJacksonSerializer(Class<Filing> t) {
    super(t);
  }

  @Override
  public void serialize(Filing filing, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    // TODO(brycew): get David Benton to let us have multiple filing parties
    //List<FilingParty> filingParties = new ArrayList(); 
    /*
    for (String filingPartyId : filing.getFilingPartyIds()) { 
      FilingParty p = new FilingParty
      p.id = filingPartyId; 
      p.idCategoryText = "REFERENCE";
      filingParties.add(p);
    }
    metadata.filingPartyId = filingParties;
    */
    FilingParty p = new FilingParty();
    p.id = filing.getFilingPartyIds().get(0);
    p.idCategoryText = "REFERENCE";
    Metadata metadata = new Metadata(); 
    metadata.filingPartyId = p;
    metadata.regAction = filing.getRegisterAction().getName();
    
    DocAttachment docAttachment = new DocAttachment(); 
    byte[] data = filing.getFileContents(); 
    String encodedDoc = new String(Base64.getEncoder().encode(data));
    docAttachment.encodedDoc = encodedDoc;
    docAttachment.documentName = filing.getFileName(); 
    
    gen.writeStartObject();
    gen.writeObjectField("DocumentMetadata", metadata);
    gen.writeObjectField("DocumentAttachment", docAttachment);
    gen.writeStringField("FilingCommentsText", filing.getFilingComments());
    gen.writeEndObject();
  }
  
  private class DocAttachment {
    @JsonProperty("BinaryBase64Object")
    String encodedDoc;
    
    @JsonProperty("DocumentName")
    String documentName;
  }
  
  private class Metadata {
    // TODO(brycew): get David Benton to let us have multiple filing parties
    @JsonProperty("FilingPartyID")
    FilingParty filingPartyId;
    
    @JsonProperty("RegisterActionDescriptionText")
    String regAction;
  }
  
  private class FilingParty {
    @JsonProperty("IdentificationID")
    String id;

    @JsonProperty("IdentificationCategoryText")
    String idCategoryText;
  }

}
