package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.Person;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDocassembleJacksonDeserializer extends StdDeserializer<Person> {

  private static final long serialVersionUID = 1L;

  protected PersonDocassembleJacksonDeserializer(Class<Person> vc) {
    super(vc);
  }

  private static Optional<String> getStringMember(JsonNode obj, String memberName) {
    if (obj.has(memberName) 
        && obj.get(memberName).isTextual()) {
      return Optional.of(obj.get(memberName).asText());
    }
    return Optional.empty();
  }
  
  /** Parses a person from the Json Object. Used by Deserializers that include people. */
  public static Person fromNode(JsonNode node, JsonParser p) throws JsonProcessingException {
    if (!node.isObject()) {
      throw new JsonParseException(p, "Refusing to parse person that isn't a Json Object: " + node.toPrettyString());
    }
    
    List<String> phones = new ArrayList<String>();
    if (node.has("mobile_number") && node.get("mobile_number").isTextual()) {
      String mobile = node.get("mobile_number").asText();
      if (!mobile.isBlank()) {
        phones.add(mobile);
      }
    }
    if (node.has("phone_number") && node.get("phone_number").isTextual()) {
      String phone = node.get("phone_number").asText();
      if (!phone.isBlank()) {
        phones.add(phone);
      }
    }
    Optional<Address> addr = Optional.empty(); 
    if (node.has("address") && node.get("address").isObject()) {
      AddressDocassembleJacksonDeserializer deser = 
          new AddressDocassembleJacksonDeserializer(Address.class);
      try {
        addr = Optional.of(deser.fromNode(node.get("address"), p));
      } catch (JsonProcessingException ex) {
        // do nothing
      }
    }
    Optional<String> email = getStringMember(node, "email"); 
    ContactInformation info = new ContactInformation(phones, addr, email);

    if (!(node.has("name") 
        && node.get("name").isObject() 
        && node.get("name").has("first"))) {
      throw new JsonParseException(p, "Refusing to parse a person without a name / or first name");
    }

    JsonNode nameSubset = node.get("name");
    boolean isOrg = !(nameSubset.has("middle") || nameSubset.has("last"));
    Name name = new Name(
          "", // TODO(brycew): where should we handle prefixes? Are they always empty?
          getStringMember(nameSubset, "first").orElse(""),
          getStringMember(nameSubset, "middle").orElse(""),
          getStringMember(nameSubset, "last").orElse(""),
          getStringMember(nameSubset, "suffix").orElse(""),
          "" // TODO(brycew): where would Maiden name go, if asked for?
    );
      
    Optional<String> language = getStringMember(node, "prefered_language");
    Optional<String> gender = getStringMember(node, "gender");
    Optional<LocalDate> birthdate = Optional.empty(); // TODO(brycew): read in birthdate
    Person per = new Person(name, info, gender, language, birthdate, isOrg);
    return per;
  }

  @Override
  public Person deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    return fromNode(node, p);
  }

}
