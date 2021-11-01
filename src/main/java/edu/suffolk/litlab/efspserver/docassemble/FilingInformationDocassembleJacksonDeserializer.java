package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.CaseServiceContact;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilingInformationDocassembleJacksonDeserializer
    extends StdDeserializer<FilingInformation> {
  private static Logger log = LoggerFactory.getLogger(
      FilingInformationDocassembleJacksonDeserializer.class);

  private static final long serialVersionUID = 1L;
  private InfoCollector classCollector;

  public FilingInformationDocassembleJacksonDeserializer(Class<FilingInformation> t, InfoCollector collector) {
    super(t);
    this.classCollector = collector;
  }

  private static List<Person> collectPeople(JsonNode topObj,
      String potentialMember, InfoCollector collector) throws FilingError {
    if (!topObj.has(potentialMember)) {
      return List.of();  // Just an empty list: we don't know if it's required
    }
    Optional<JsonNode> maybePplElements = JsonHelpers.unwrapDAList(topObj.get(potentialMember));
    if (maybePplElements.isEmpty()) {
      throw FilingError.malformedInterview(
          potentialMember + " isn't an List with an elements array");
    }
    List<Person> people = new ArrayList<Person>();
    JsonNode peopleElements = maybePplElements.get(); 
    for (int i = 0; i < peopleElements.size(); i++) {
      collector.pushAttributeStack(potentialMember + "[" + i + "]");
      Result<Person, FilingError> per =
          PersonDocassembleJacksonDeserializer.fromNode(peopleElements.get(i), collector);
      collector.popAttributeStack();
      if (per.isErr()) {
        FilingError ex = per.unwrapErrOrElseThrow();
        log.warn("Person exception: " + ex);
        collector.error(ex);
      }
      people.add(per.unwrapOrElseThrow());
    }
    return people;
  }

  public static Result<FilingInformation, FilingError> fromNode(JsonNode node, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview("interview isn't a json object");
      collector.error(err);
      return Result.err(err);
    }
    List<Person> users = collectPeople(node, "users", collector);
    Map<String, String> varToId = new HashMap<String, String>();
    int perIdx = 0;
    for (Person user : users) {
      varToId.put("users[" + perIdx + "]", user.getIdString());
      perIdx++;
    }

    FilingInformation entities = new FilingInformation();
    JsonNode prevCaseId = node.get("previous_case_id");
    boolean hasPrevCaseId = prevCaseId != null && prevCaseId.isTextual();
    if (hasPrevCaseId) {
      entities.setPreviousCaseId(prevCaseId.asText());
    }

    JsonNode docketNumber = node.get("docket_number");
    boolean hasDocketNumber = docketNumber != null && docketNumber.isTextual();
    if (hasDocketNumber) {
      entities.setCaseDocketNumber(docketNumber.asText());
    }

    boolean isFirstIndexedFiling = !hasPrevCaseId;
    if (isFirstIndexedFiling && users.isEmpty()) {
      InterviewVariable varExpected = new InterviewVariable("users",
          "the side of the matter that current person answering this interview is on",
          "ALPeopleList", List.of());
      collector.addRequired(varExpected);
      throw FilingError.missingRequired(varExpected);
    }

    if (node.has("user_preferred_language")
        && node.get("user_preferred_language").isTextual()) {
      users.get(0).setLanguage(
          node.get("user_preferred_language").asText());
    }
    log.debug("Got users");

    Optional<String> userEmail = Optional.empty();
    if (users.size() > 0) {
      userEmail = users.get(0).getContactInfo().getEmail();
    }
    if (isFirstIndexedFiling && (userEmail.isEmpty() || userEmail.orElse("").isBlank())) {
      InterviewVariable var = new InterviewVariable(
          "users[0].email", "Email is required for at least one user", "text", List.of());
      collector.addRequired(var);
    }

    final List<Person> otherParties = collectPeople(node, "other_parties", collector);
    if (isFirstIndexedFiling && otherParties.isEmpty()) {
      InterviewVariable othersExpected = new InterviewVariable("other_parties",
          "the side of the matter that current person answering this interview is on",
          "ALPeopleList", List.of());
      collector.addOptional(othersExpected);
    }
    perIdx = 0;
    for (Person party : otherParties) {
      varToId.put("other_parties[" + perIdx + "]", party.getIdString());
      perIdx++;
    }
    log.debug("Got other parties");

    Optional<Boolean> userStartedCase = Optional.empty();
    if (node.has("user_started_case")
        && node.get("user_started_case").isBoolean()) {
      userStartedCase = Optional.of(node.get("user_started_case").asBoolean());
    }
    if (userStartedCase.isEmpty()) {
      InterviewVariable var = collector.requestVar("user_started_case",
          "Whether or not the user is the plaintiff or petitioner", "boolean", List.of("true", "false"));
      collector.addRequired(var);
    }
    log.debug("user_started_case: " + userStartedCase.orElse(null));

    // TODO(brycew-later): plaintiff and petitioners are both defined.
    // Typical role might have the difference, take which is available
    // TODO(#60): better way to get the parties types?
    // TODO(brycew-later): make the party types use the SALI standard
    boolean started = userStartedCase.get();
    if (started) {
      entities.setPlaintiffs(users);
      entities.setDefendants(otherParties);
    } else {
      entities.setDefendants(users);
      entities.setPlaintiffs(otherParties);
    }

    JsonNode attorneyIds = node.get("attorney_ids");
    Pattern usersPattern = Pattern.compile("users\\[[0-9]+\\]");
    Pattern otherPattern = Pattern.compile("other_parties\\[[0-9]+\\]");
    if (attorneyIds != null && attorneyIds.isArray()) {
      List<String> ids = new ArrayList<String>();
      attorneyIds.elements().forEachRemaining(jId -> ids.add(jId.asText()));
      entities.setAttorneyIds(ids);

      JsonNode partyToAttorneyJson = node.get("party_to_attorneys");
      if (partyToAttorneyJson != null && partyToAttorneyJson.isObject()) {
        Map<String, List<String>> partyToAttorney = new HashMap<>(); 
        Iterator<Entry<String, JsonNode>> elems = partyToAttorneyJson.fields();
        while (elems.hasNext()) {
          Entry<String, JsonNode> elem = elems.next();
          List<String> theseAttorneys = new ArrayList<String>();
          elem.getValue().elements().forEachRemaining(v -> theseAttorneys.add(v.asText()));
          Matcher matcher = usersPattern.matcher(elem.getKey());
          String realKey = elem.getKey();
          if (matcher.find()) {
            realKey = varToId.get(elem.getKey());
          } else {
            Matcher otherMatcher = otherPattern.matcher(elem.getKey());
            if (otherMatcher.find()) {
              realKey = varToId.get(elem.getKey());
            } else {
              log.info("Existing filing party id: " + elem.getKey());
              realKey = elem.getKey();
            }
          }
          partyToAttorney.put(realKey, theseAttorneys);
        }
        entities.setPartyAttorneyMap(partyToAttorney);
      }
    } else {
      entities.setAttorneyIds(List.of());
    }

    Optional<JsonNode> serviceContactsJson = JsonHelpers.unwrapDAList(node.get("service_contacts"));
    if (serviceContactsJson.isPresent()) {
      List<CaseServiceContact> contacts = new ArrayList<>();
      serviceContactsJson.get().elements().forEachRemaining(servObj -> {
        Optional<String> partyPerId = Optional.empty();
        if (servObj.has("party_association")) {
          JsonNode partyAssocJson = servObj.get("party_association");
          partyPerId = Optional.of(varToId.get(partyAssocJson.asText()));
        }
        CaseServiceContact contact = new CaseServiceContact(
            servObj.get("contact_id").asText(),
            servObj.get("service_type").asText(), partyPerId);
        contacts.add(contact);
      });
    } else {
      entities.setServiceContacts(List.of());
    }


    // TODO(brycew-later): this approach is a complete mess, don't know
    // how to best map LIST onto case categories, ECF is too high level
    JsonNode metadata = JsonNodeFactory.instance.nullNode();
    if (node.has("interview_metadata") && node.get("interview_metadata").has("elements")) {
      JsonNode metadataElems = node.get("interview_metadata").get("elements");
      String key = metadataElems.fieldNames().next();
      if (metadataElems.size() >= 1) {
        log.warn("Only the first metadata element will be looked at: " + key);
      }
      metadata = metadataElems.get(key).get("elements");
    }

    JsonNode category = node.get("tyler_case_category"); 
    if (category != null && !category.isNull() && category.isTextual()) {
      entities.setCaseCategoryCode(category.asText());
    } else if (metadata.has("categories") && metadata.get("categories").isArray()) {
      List<String> categories = new ArrayList<String>();
      metadata.get("categories").forEach((cat) -> categories.add(cat.asText()));
      entities.setCaseCategoryCode(String.join(", ", categories)); 
      log.info("Categories: " + categories.toString());
    } else if (isFirstIndexedFiling) {
      InterviewVariable var = collector.requestVar("tyler_case_category", "", "text");
      collector.addRequired(var);
    }

    JsonNode type = node.get("tyler_case_type");
    if (type != null && type.isTextual()) {
      entities.setCaseTypeCode(type.asText());
    } else if (metadata.has("title") && metadata.get("title").isTextual()) {
      entities.setCaseTypeCode(metadata.get("title").asText());
    } else if (isFirstIndexedFiling) {
      InterviewVariable var = collector.requestVar("tyler_case_type",  "", "text");
      collector.addRequired(var);
    }

    JsonNode subtype = node.get("tyler_case_subtype");
    if (subtype != null && subtype.isTextual()) {
      entities.setCaseSubtypeCode(subtype.asText());
    } else if (isFirstIndexedFiling) {
      InterviewVariable var = collector.requestVar("tyler_case_subtype", "subtype (not always present)", "text");
      collector.addOptional(var);
      entities.setCaseSubtypeCode("");
    }

    // Get the interview metadablock TODO(brycew-later): just one for now
    /*
    log.info("Keyset: " + metadataElems.fieldNames());
    */

    List<FilingDoc> filingDocs = new ArrayList<FilingDoc>();
    final InterviewVariable bundleVar = collector.requestVar("al_court_bundle",
        "The full court bundle", "ALDocumentBundle");
    JsonNode bundle = node.get("al_court_bundle");
    if (bundle == null) {
      collector.addRequired(bundleVar);
    }
    Optional<JsonNode> maybeElems = JsonHelpers.unwrapDAList(bundle);
    if (maybeElems.isEmpty()) {
      return Result.err(FilingError.malformedInterview(
          "al_court_bundle should be a JSON object with a elements array (i.e. a python DAList)"));
    }
    JsonNode elems = maybeElems.get(); 
    if (elems == null || elems.isEmpty()) {
      elems = NullNode.getInstance();
      collector.addRequired(bundleVar);
    }

    for (int i = 0; i < elems.size(); i++) {
      try {
        collector.pushAttributeStack("al_court_bundle.elements[" + i + "]");
        Optional<FilingDoc> maybeDoc = FilingDocDocassembleJacksonDeserializer.fromNode(
            elems.get(i), varToId, i, collector); 
        collector.popAttributeStack();
        maybeDoc.ifPresent(doc -> {
          filingDocs.add(doc);
        });
      } catch (FilingError err) {
        if (err.getType().equals(FilingError.Type.MissingRequired)) {
          collector.addRequired(err.getMissingVariable().get());
        }
        return Result.err(err);
      }
    }
    if (node.has("comments_to_clerk")
        && node.get("comments_to_clerk").isTextual()) {
      String filingComments = node.get("comments_to_clerk").asText("");
      if (!filingDocs.isEmpty()) {
        filingDocs.get(0).setFilingComments(filingComments);
      }
    }

    JsonNode paymentIdJson = node.get("tyler_payment_id");
    if (paymentIdJson != null && paymentIdJson.isTextual()) {
      entities.setPaymentId(paymentIdJson.asText());
    }
    
    JsonNode leadJson = node.get("lead_contact");
    if (leadJson == null) {
      InterviewVariable var = collector.requestVar("lead_contact", "Someone to contact about this case", "ALIndividual");
      collector.addRequired(var);
    } else {
      collector.pushAttributeStack("lead_contact");
      Result<Person, FilingError> per =
          PersonDocassembleJacksonDeserializer.fromNode(node.get("lead_contact"), collector);
      collector.popAttributeStack();
      if (per.isErr() || per.unwrapOrElseThrow().getContactInfo().getEmail().isEmpty()) {
        FilingError ex = per.unwrapErrOrElseThrow();
        log.warn("Person exception: " + ex);
        collector.error(ex);
      }
      if (per.unwrapOrElseThrow().getContactInfo().getEmail().isEmpty()) {
        InterviewVariable var = collector.requestVar("lead_contact.email", "We need an email to contact someone about this case.", "text");
        collector.addRequired(var);
      }
      entities.setLeadContact(per.unwrapOrElseThrow());
    }
    
    JsonNode jsonReturnDate = node.get("return_date");
    Optional<LocalDate> maybeReturnDate = Optional.empty();
    if (jsonReturnDate != null && jsonReturnDate.isTextual()) {
      // TODO(#47): Time zone user is using?
      maybeReturnDate = Optional.of(LocalDate.ofInstant(Instant.parse(jsonReturnDate.asText()), ZoneId.of("America/Chicago")));
    }
    entities.setReturnDate(maybeReturnDate);


    entities.setFilings(filingDocs);
    entities.setMiscInfo(node);

    return Result.ok(entities);
  }

  @Override
  public FilingInformation deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    try {
      Result<FilingInformation, FilingError> info = fromNode(node, this.classCollector);
      if (info.isErr()) {
        throw new JsonExtractException(p, info.unwrapErrOrElseThrow());
      }
      return info.unwrapOrElseThrow();
    } catch (FilingError err) {
      throw new JsonExtractException(p, err);
    }
  }

}
