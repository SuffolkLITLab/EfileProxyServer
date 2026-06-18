package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getBoolMember;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getNonEmptyStringMember;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringDefault;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringMember;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser;
import edu.suffolk.litlab.efsp.model.Address;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.model.Person.Gender;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
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
  public static Result<Person, FilingError> fromNode(
      JsonNode node, CodesParser parser, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err =
          FilingError.malformedInterview(
              "Refusing to parse person that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      return Result.err(err);
    }

    List<String> inputPhones = new ArrayList<String>();
    var maybeMobile = getNonEmptyStringMember(node, "mobile_number");
    maybeMobile.ifPresent(number -> inputPhones.add(number));

    var maybePhone = getNonEmptyStringMember(node, "phone_number");
    maybePhone.ifPresent(number -> inputPhones.add(number));

    var phonesRes = parser.vetPhoneNumbers(inputPhones);
    List<String> phones;
    if (phonesRes.isErr()) {
      var phoneBuilder = collector.varBuilder().name("phone_number").datatype("text");
      collector.addTextError(phonesRes.expectErr(""), phoneBuilder);
      phones = List.of();
    } else {
      phones = phonesRes.expect("");
    }

    Optional<Address> addr = Optional.empty();
    if (node.has("address") && node.get("address").isObject()) {
      collector.pushAttributeStack("address");
      try {
        addr =
            AddressDocassembleJacksonDeserializer.fromNode(node.get("address"), parser, collector);
        collector.popAttributeStack();
      } catch (FilingError err) {
        if (!err.getType().equals(FilingError.Type.MissingRequired)) {
          // Roughly speaking, the address isn't required. Rethrow anything els.
          throw err;
        }
      }
    }
    var emailRes = parser.vetEmail(getStringMember(node, "email"));
    Optional<String> email;
    if (emailRes.isErr()) {
      collector.addTextError(emailRes.expectErr(""), collector.varBuilder().name("email"));
      email = Optional.empty();
    } else {
      email = emailRes.expect("");
    }
    final ContactInformation info = new ContactInformation(phones, addr, email);

    Optional<String> partyType = getStringMember(node, "party_type");

    boolean isFormFiller = getBoolMember(node, "is_form_filler").orElse(false);
    var langBuilder =
        collector
            .varBuilder()
            .name("prefered_language")
            .description("Preferred language of the user");
    Optional<String> language =
        collector.unwrapOpt(
            parser.vetLangCode(getStringMember(node, "prefered_language")), langBuilder);
    var genderRes = parser.vetGender(getStringMember(node, "gender"));
    Optional<Gender> gender;
    if (genderRes.isErr()) {
      collector.addTextError(genderRes.expectErr(""), collector.varBuilder().name("gender"));
      gender = Optional.empty();
    } else {
      gender = genderRes.expect("");
    }
    Optional<String> birthdateString = getStringMember(node, "date_of_birth");
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
    boolean isOrg = false;
    var personType = getStringDefault(node, "person_type", "");
    if (personType.equalsIgnoreCase("business") || personType.equalsIgnoreCase("organization")) {
      isOrg = true;
    }
    collector.pushAttributeStack("name");
    Name name = NameDocassembleDeserializer.fromNode(node.get("name"), isOrg, parser, collector);
    collector.popAttributeStack();

    Optional<String> efmId = getStringMember(node, "tyler_id");
    if (node.has("is_new")) {
      var isNew = node.get("is_new");
      if (!isNew.isBoolean()) {
        collector.addWrong(
            collector.requestVar(
                "is_new",
                "if the party is new to the case",
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
            name, info, gender, language, birthdate, isOrg, isFormFiller, partyType, efmId);
    log.debug("Read in a new person: {}", per.getName().getFullName());
    return Result.ok(per);
  }
}
