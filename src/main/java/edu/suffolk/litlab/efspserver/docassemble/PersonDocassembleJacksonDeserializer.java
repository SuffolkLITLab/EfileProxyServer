package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonDocassembleJacksonDeserializer {
  private static Logger log = LoggerFactory.getLogger(PersonDocassembleJacksonDeserializer.class);

  protected PersonDocassembleJacksonDeserializer() {}

  private static Optional<String> getStringMember(JsonNode obj, String memberName) {
    if (obj.has(memberName)
        && obj.get(memberName).isTextual()) {
      return Optional.of(obj.get(memberName).asText());
    }
    return Optional.empty();
  }

  /** Parses a person from the Json Object. Used by Deserializers that include people.
   * @throws FilingError */
  public static Result<Person, FilingError> fromNode(JsonNode node, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview(
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
        FilingError err = FilingError.malformedInterview("phone number needs to be text: "
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
          new AddressDocassembleJacksonDeserializer();
      collector.pushAttributeStack("address");
      try {
        addr = deser.fromNode(node.get("address"), collector);
        collector.popAttributeStack();
      } catch (FilingError err) {
        if (!err.getType().equals(FilingError.Type.MissingRequired)) {
          // Roughly speaking, the address isn't required. Rethrow anything els.
          throw err;
        }
      }
    }
    Optional<String> email = getStringMember(node, "email");
    final ContactInformation info = new ContactInformation(phones, addr, email);

    JsonNode partyJson = node.get("party_type");
    if (partyJson == null || !partyJson.isTextual()) {
      InterviewVariable var = collector.requestVar("party_type",
          "What legal role the party fulfills", "text");
      collector.addOptional(var);
      partyJson = NullNode.getInstance();
    }
    String partyType = partyJson.asText("");

    Optional<String> language = getStringMember(node, "prefered_language");
    Optional<String> gender = getStringMember(node, "gender");
    Optional<String> birthdateString = getStringMember(node, "date_of_birth");
    Optional<LocalDate> birthdate = birthdateString.map(bdStr -> {
      try {
        return Optional.<LocalDate>of(LocalDate.parse(bdStr)); 
      } catch (DateTimeParseException ex) {
        return Optional.<LocalDate>empty();
      }
    }).orElse(Optional.<LocalDate>empty());
    Name name = NameDocassembleDeserializer.fromNode(node.get("name"), collector);
    boolean isPer = !name.getMiddleName().isBlank() || !name.getLastName().isBlank();
    Person per = new Person(name, info, gender, language, birthdate, !isPer, partyType);
    log.debug("Read in a new person: " + per.getName().getFullName());
    return Result.ok(per);
  }

}
