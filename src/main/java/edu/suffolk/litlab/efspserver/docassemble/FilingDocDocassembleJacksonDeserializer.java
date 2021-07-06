package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FilingDocDocassembleJacksonDeserializer extends StdDeserializer<FilingDoc> {

  private static final long serialVersionUID = 1L;

  protected FilingDocDocassembleJacksonDeserializer(Class<FilingDoc> t) {
    super(t);
  }
  
  /** Parses a filing from the DA Json Object. Used by Deserializers that include filings. */
  public static FilingDoc fromNode(JsonNode node, JsonParser p) throws JsonParseException {
    if (!node.isObject()) {
      throw new JsonParseException(p, "Refusing to parse filing that isn't a object");
    }
    
    try {
      if (!node.has("data_url") || !node.get("data_url").isTextual()) {
        throw new JsonParseException(p, "Refusing to parse filing without data_url");
      }
      if (!node.has("filename") || !node.get("filename").isTextual()) {
        throw new JsonParseException(p, "Refusing to parse filename without filename");
      }
      // TODO(brycew): we need to put URLs of all of the other filings and read in those files
      URL inUrl = new URL(node.get("data_url").asText().replace("localhost", "docassemble"));
      // Get: filename
      String fileName = node.get("filename").asText() + ".pdf";
      // TODO(brycew): where can I get the "Motion" from the interview?
      NameAndCode regActionDesc = new NameAndCode("Motion", "");
      HttpURLConnection conn = (HttpURLConnection) inUrl.openConnection();
      conn.setRequestMethod("GET");
      InputStream inStream = conn.getInputStream();
      if (inStream == null) {
        throw new JsonParseException(p, "Couldn't connect to " + inUrl.toString());
      }
      return new FilingDoc(fileName, inStream, regActionDesc);
      
    } catch (IOException ex)  {
      throw new JsonParseException(p, "IOException trying to parse data_url: " + ex);
    }
  }

  @Override
  public FilingDoc deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    return fromNode(node, p);
  }

}
