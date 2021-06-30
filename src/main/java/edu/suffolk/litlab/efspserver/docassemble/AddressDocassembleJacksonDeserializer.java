package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import edu.suffolk.litlab.efspserver.Address;
import java.io.IOException;
import java.util.List;

public class AddressDocassembleJacksonDeserializer extends StdDeserializer<Address> {

  private static final long serialVersionUID = 1L;

  protected AddressDocassembleJacksonDeserializer(Class<Address> t) {
    super(t);
  }

  /** Parses an address from the DA Json Object. Used by Deserializers that include addresses. */
  public Address fromNode(JsonNode node, JsonParser p) throws JsonProcessingException {
    if (!node.isObject()) {
      throw new JsonParseException(p, "Refusing to parse Address that isn't a JsonObject");
    }

    for (String member : List.of("address", "unit", "city", "state", "zip")) {
      if (!node.has(member) || !node.get(member).isTextual()) {
        throw new JsonParseException(p, "Refusing to parse Address that doesn't have a " + member);
      }
    }
    String address = node.get("address").asText();
    String unit = node.get("unit").asText();
    String city = node.get("city").asText();
    String state = node.get("state").asText();
    String zip = node.get("zip").asText();
    String country = "US"; 
    JsonNode countryNode = node.get("country");
    if (countryNode != null) {
      country = countryNode.asText("US");
    }
    Address addr = new Address(address, unit, city, state, zip, country);
    return addr; 
  }

  @Override
  public Address deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    return fromNode(node, p);
  }
  
}
