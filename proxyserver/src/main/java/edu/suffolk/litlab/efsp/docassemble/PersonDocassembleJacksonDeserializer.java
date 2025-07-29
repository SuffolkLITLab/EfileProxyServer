package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getBoolMember;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringMember;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.model.Address;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
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

  /**
   * Parses a person from the Json Object. Used by Deserializers that include people.
   *
   * @throws FilingError
   */
  public static Result<Person, FilingError> fromNode(JsonNode node, InfoCollector collector)
      throws FilingError {
    if (!node.isObject()) {
      FilingError err =
          FilingError.malformedInterview(
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
      InterviewVariable var =
          collector.requestVar("mobile_number", "A mobile or cell phone number", "text");
      collector.addOptional(var);
    }

    if (node.has("phone_number")) {
      if (node.get("phone_number").isTextual()) {
        String phone = node.get("phone_number").asText();
        if (!phone.isBlank()) {
          phones.add(phone);
        }
      } else {
        FilingError err =
            FilingError.malformedInterview(
                "phone number needs to be text: " + node.get("phone_number").toPrettyString());
        return Result.err(err);
      }
    } else {
      InterviewVariable var =
          collector.requestVar("phone_number", "A mobile or cell phone number", "text");
      collector.addOptional(var);
    }

    Optional<Address> addr = Optional.empty();
    if (node.has("address") && node.get("address").isObject()) {
      collector.pushAttributeStack("address");
      try {
        addr = AddressDocassembleJacksonDeserializer.fromNode(node.get("address"), collector);
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
      InterviewVariable var =
          collector.requestVar("party_type", "What legal role the party fulfills", "text");
      collector.addOptional(var);
      partyJson = NullNode.getInstance();
    }
    String partyType = partyJson.asText("");

    Optional<String> language = getStringMember(node, "prefered_language");
    Optional<String> gender = getStringMember(node, "gender");
    Optional<String> birthdateString = getStringMember(node, "date_of_birth");
    boolean isFormFiller = getBoolMember(node, "is_form_filler").orElse(false);
    Optional<LocalDate> birthdate =
        birthdateString
            .map(
                bdStr -> {
                  try {
                    return Optional.<LocalDate>of(LocalDate.parse(bdStr));
                  } catch (DateTimeParseException ex) {
                    return Optional.<LocalDate>empty();
                  }
                })
            .orElse(Optional.<LocalDate>empty());
    collector.pushAttributeStack("name");
    Name name = NameDocassembleDeserializer.fromNode(node.get("name"), collector);
    collector.popAttributeStack();
    boolean isPer = !name.getMiddleName().isBlank() || !name.getLastName().isBlank();

    Optional<String> efmId = getStringMember(node, "tyler_id");
    if (node.has("is_new")) {
      var isNew = node.get("is_new");
      if (!isNew.isBoolean()) {
        collector.addWrong(
            collector.requestVar(
                "is_new",
                "if the party is new to the the case",
                "bool",
                List.of(),
                Optional.of(isNew.toString())));
      }
      if (isNew.asBoolean() && efmId.isPresent()) {
        collector.addWrong(
            collector.requestVar(
                "is_new",
                "Can't have an EFM (tyler) ID on a "
                    + "brand new party to the case: their tyler id shouldn't exist yet",
                "bool",
                List.of(),
                Optional.of(isNew.toString())));
      }
      if (!isNew.asBoolean() && efmId.isEmpty()) {
        collector.addWrong(
            collector.requestVar(
                "tyler_id",
                "Can't be marked as not new, but not have an EFM ID",
                "text",
                List.of(),
                Optional.of(isNew.toString())));
      }
      // if marked as is_new and no EFM id, that's fine! They're brand new to the case
    }
    // if not marked as new, completely depend on the presence of "tyler_id"

    Person per =
        Person.FromInput(
            name, info, gender, language, birthdate, !isPer, isFormFiller, partyType, efmId);
    log.debug("Read in a new person: " + per.getName().getFullName());
    return Result.ok(per);
  }
}
