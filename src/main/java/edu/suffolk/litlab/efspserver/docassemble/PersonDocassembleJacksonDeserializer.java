package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.ExtractError;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonDocassembleJacksonDeserializer extends StdDeserializer<Person> {
  private static Logger log = LoggerFactory.getLogger(PersonDocassembleJacksonDeserializer.class); 

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
  public static Result<Person, ExtractError> fromNode(JsonNode node, InfoCollector collector) {
    if (!node.isObject()) {
      ExtractError err = ExtractError.malformedInterview(
              "Refusing to parse person that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      return Result.err(err);
    }
    
    List<String> phones = new ArrayList<String>();
    if (node.has("mobile_number") && node.get("mobile_number").isTextual()) {
      String mobile = node.get("mobile_number").asText();
      if (!mobile.isBlank()) {
        phones.add(mobile);
      }
    } else {
      InterviewVariable var = new InterviewVariable("mobile_number", 
          "A mobile or cell phone number", "text", List.of());
      collector.addOptional(var);
    }

    if (node.has("phone_number")) {
      if (node.get("phone_number").isTextual()) {
        String phone = node.get("phone_number").asText();
        if (!phone.isBlank()) {
          phones.add(phone);
        }
      } else {
        ExtractError err = ExtractError.malformedInterview("phone number needs to be text: " 
            + node.get("phone_number").toPrettyString());
        return Result.err(err);
      }
    } else {
      InterviewVariable var = new InterviewVariable("phone_number",
          "A mobile or cell phone number", "text", List.of());
      collector.addOptional(var);
    }

    Optional<Address> addr = Optional.empty(); 
    if (node.has("address") && node.get("address").isObject()) {
      AddressDocassembleJacksonDeserializer deser = 
          new AddressDocassembleJacksonDeserializer(Address.class);
      collector.pushAttributeStack("address");
      Result<Address, ExtractError> result = deser.fromNode(node.get("address"), collector);
      collector.popAttributeStack();
      if (result.isErr()) {
        ExtractError err = result.unwrapErrOrElseThrow();
        if (err.getType().equals(ExtractError.Type.MissingRequired)) {
          InterviewVariable var = collector.requestVar("address", 
              "The address of a person", "Address");
          collector.addRequired(var);
          if (collector.finished()) {
            return Result.err(err);
          }
        }  else {
          return Result.err(err);
        }
      } else {
        addr = Optional.of(result.unwrapOrElseThrow());
      }
    }
    Optional<String> email = getStringMember(node, "email"); 
    final ContactInformation info = new ContactInformation(phones, addr, email);

    if (!node.has("name")) {
      InterviewVariable var = collector.requestVar(
          "name", "The full name of the person", "IndividualName");
      collector.addRequired(var);
      if (collector.finished()) {
        ExtractError err = ExtractError.missingRequired(var);
        return Result.err(err);
      }
    }
    if (!node.get("name").isObject()) {
      ExtractError err = ExtractError.malformedInterview(
          "Can't parse person with name that's not a JSON object: " + node.get("name").toPrettyString());
      return Result.err(err);
    }
    if (!node.get("name").has("first")) {
      InterviewVariable var = collector.requestVar("name.first", 
          "The first name of a person / name of a business", "text");
      collector.addRequired(var);
      if (collector.finished()) {
        ExtractError err = ExtractError.missingRequired(var);
        return Result.err(err);
      }
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
    log.debug("Read in a new person: " + per.getName().getFullName());
    return Result.ok(per);
  }

  @Override
  public Person deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    InfoCollector collector = new FailFastCollector();
    Result<Person, ExtractError> person = fromNode(node, collector); 
    if (person.isErr()) {
      throw new JsonExtractException(p, person.unwrapErrOrElseThrow());
    }
    return person.unwrapOrElseThrow();
  }

}
