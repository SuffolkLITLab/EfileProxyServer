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
import edu.suffolk.litlab.efspserver.JsonHelpers;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilingInformationDocassembleJacksonDeserializer
    extends StdDeserializer<FilingInformation> {
  private static Logger log = LoggerFactory.getLogger(
      FilingInformationDocassembleJacksonDeserializer.class);

  private static final long serialVersionUID = 1L;
  private final InfoCollector classCollector;

  public FilingInformationDocassembleJacksonDeserializer(Class<FilingInformation> t, InfoCollector collector) {
    super(t);
    this.classCollector = collector;
  }

  /** 
   * @param topObj
   * @param potentialMember
   * @param collector
   * @param filterFlag: the person will be skipped if that attribute is set to false.
   * @return
   * @throws FilingError
   */
  private static List<Person> collectPeople(JsonNode topObj,
      String potentialMember, InfoCollector collector, String filterFlag) throws FilingError {
    if (!topObj.has(potentialMember)) {
      return List.of();  // Just an empty list: we don't know if it's required
    }
    Optional<JsonNode> maybePplElements = JsonHelpers.unwrapDAList(topObj.get(potentialMember));
    if (maybePplElements.isEmpty()) {
      throw FilingError.malformedInterview(
          potentialMember + " isn't an List with an array attribute called '.elements'");
    }
    List<Person> people = new ArrayList<Person>();
    JsonNode peopleElements = maybePplElements.get(); 
    for (int i = 0; i < peopleElements.size(); i++) {
      JsonNode personJson = peopleElements.get(i);
      if (filterFlag != null && !filterFlag.isBlank()) {
        // Assume not setting filterFlag is the same as it being false (i.e. skipping)
        if (!personJson.has(filterFlag) || !personJson.get(filterFlag).asBoolean(false)) {
          continue;
        }
      }
      collector.pushAttributeStack(potentialMember + "[" + i + "]");
      Result<Person, FilingError> per =
          PersonDocassembleJacksonDeserializer.fromNode(personJson, collector);
      collector.popAttributeStack();
      if (per.isErr()) {
        FilingError ex = per.unwrapErrOrElseThrow();
        log.warn("Person exception: " + ex);
        collector.error(ex);
      }
      
      people.add(per.unwrapOrElseThrow());
    }
    return List.copyOf(people); 
  }

  public static FilingInformation fromNode(JsonNode node, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview("interview isn't a json object");
      collector.error(err);
      throw err;
    }
    FilingInformation entities = new FilingInformation();
    entities.setPreviousCaseId(extractNullableString(node.get("previous_case_id")));
    entities.setCaseDocketNumber(extractNullableString(node.get("docket_number"))); 
    boolean isFirstIndexedFiling = entities.getPreviousCaseId().isEmpty();

    List<Person> users = collectPeople(node, "users", collector, "");
    List<Person> otherParties = collectPeople(node, "other_parties", collector, "");

    var varToPartyId = new HashMap<String, PartyId>();
    int perIdx = 0;
    for (Person user : users) {
      varToPartyId.put("users[" + perIdx + "]", user.getPartyId()); 
      varToPartyId.put(user.getPartyId().getIdentificationString(), user.getPartyId());
      perIdx++;
    }
    perIdx = 0;
    for (Person party : otherParties) {
      varToPartyId.put("other_parties[" + perIdx + "]", party.getPartyId()); 
      varToPartyId.put(party.getPartyId().getIdentificationString(), party.getPartyId());
      perIdx++;
    }
    users = users.stream()
        .filter(u -> u.getPartyId().isNewInCurrentFiling())
        .collect(Collectors.toUnmodifiableList());
    otherParties = otherParties.stream()
        .filter(o -> o.getPartyId().isNewInCurrentFiling())
        .collect(Collectors.toUnmodifiableList());
    if (isFirstIndexedFiling) {
      if (users.isEmpty()) {
        InterviewVariable varExpected = new InterviewVariable("users",
            "the side of the matter that current person answering this interview is on (must have is_new=True)",
            "ALPeopleList", List.of());
        collector.addRequired(varExpected);
        throw FilingError.missingRequired(varExpected);
      }
      if (otherParties.isEmpty()) {
        InterviewVariable othersExpected = new InterviewVariable("other_parties",
            "the side of the matter that current person answering this interview is on (must have is_new=True)",
            "ALPeopleList", List.of());
        collector.addOptional(othersExpected);
      }
      JsonNode prefLang = node.get("user_preferred_language");
      if (prefLang != null && prefLang.isTextual()) {
        users.get(0).setLanguage(prefLang.asText()); 
      }

      Optional<String> userEmail = Optional.empty();
      if (users.size() > 0) {
        userEmail = users.get(0).getContactInfo().getEmail();
      }
      if (userEmail.isEmpty() || userEmail.orElse("").isBlank()) {
        InterviewVariable var = new InterviewVariable(
            "users[0].email", "Email is required for at least one user", "text", List.of());
        collector.addRequired(var);
      }
    } 

    boolean userStartedCase = true; 
    JsonNode startedCaseJson = node.get("user_started_case");
    if (startedCaseJson != null && startedCaseJson.isBoolean()) {
      userStartedCase = startedCaseJson.asBoolean(); 
    } else {
      InterviewVariable var = collector.requestVar("user_started_case",
          "Whether or not the user is the plaintiff or petitioner", "boolean", List.of("true", "false"));
      collector.addRequired(var);
    }

    // TODO(brycew-later): plaintiff and petitioners are both defined.
    // Typical role might have the difference, take which is available
    // TODO(#60): better way to get the parties types?
    // TODO(brycew-later): make the party types use the SALI standard
    if (userStartedCase) {
      entities.setNewPlaintiffs(users);
      entities.setNewDefendants(otherParties);
    } else {
      entities.setNewDefendants(users);
      entities.setNewPlaintiffs(otherParties);
    }

    entities.setAttorneyIds(extractAttorneyIds(node.get("attorney_ids")));
    entities.setPartyAttorneyMap(extractPartyAttorneyMap(node.get("party_to_attorneys"), varToPartyId));
    entities.setServiceContacts(extractServiceContacts(node.get("service_contacts"), varToPartyId, collector));

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
    //log.info("Keyset: " + metadataElems.fieldNames());

    entities.setFilings(extractFilingDocs(node.get("al_court_bundle"), 
        node.get("comments_to_clerk"), varToPartyId, collector));
    entities.setPaymentId(extractNullableString(node.get("tyler_payment_id"))); 
    
    JsonNode leadJson = node.get("lead_contact");
    if (leadJson == null) {
      InterviewVariable var = collector.requestVar("lead_contact", "Someone to contact about this case", "ALIndividual");
      collector.addRequired(var);
    } else {
      collector.pushAttributeStack("lead_contact");
      Result<Person, FilingError> per =
          PersonDocassembleJacksonDeserializer.fromNode(node.get("lead_contact"), collector);
      collector.popAttributeStack();
      if (per.isErr()) {
        FilingError ex = per.unwrapErrOrElseThrow();
        log.warn("Person exception: " + ex);
        collector.error(ex);
        entities.setLeadContact(null);
      } else {
        Person person = per.unwrapOrElseThrow();
        if (person.getContactInfo().getEmail().isEmpty()) {
          InterviewVariable var = collector.requestVar("lead_contact.email", 
              "We need an email to contact someone about this case.", "text");
          collector.addRequired(var);
        }
        entities.setLeadContact(person); 
      } 
    }
    
    entities.setReturnDate(extractReturnDate(node.get("return_date"), collector));
    entities.setMiscInfo(node);

    return entities;
  }
  
  private static List<String> extractAttorneyIds(JsonNode attorneyIdsJson) {
    List<String> ids = new ArrayList<String>();
    if (attorneyIdsJson != null && attorneyIdsJson.isArray()) {
      attorneyIdsJson.elements().forEachRemaining(jId -> ids.add(jId.asText()));
    }
    return ids;
  }
  
  private static Map<PartyId, List<String>> extractPartyAttorneyMap(JsonNode maybePartyToAttorney, 
      Map<String, PartyId> varToPartyId) {
    Map<PartyId, List<String>> partyToAttorney = new HashMap<>(); 
    Optional<JsonNode> partyToAttorneyJson = JsonHelpers.unwrapDADict(maybePartyToAttorney);
    log.info("" + varToPartyId);
    if (partyToAttorneyJson.isPresent()) {
      Iterable<Entry<String, JsonNode>> fields = partyToAttorneyJson.get()::fields;
      for (Entry<String, JsonNode> elem : fields) {
        final String userStr = elem.getKey();
        PartyId realId = null;
        if (varToPartyId.containsKey(userStr)) {
          realId = varToPartyId.get(userStr);
        } else {
          realId = PartyId.Already(userStr);
        }
        log.info("filing party for attorney map: " + userStr + ": " + realId);
        // Get the attorney elements (just strings in a list or DAList) into this Java List
        var theseAttorneys = new ArrayList<String>();
        JsonHelpers.unwrapDAList(elem.getValue()).ifPresent(x -> x.elements().forEachRemaining(v -> theseAttorneys.add(v.asText())));
        partyToAttorney.put(realId, theseAttorneys);
      }
    }
    return partyToAttorney;
  }
  
  private static List<CaseServiceContact> extractServiceContacts(
          JsonNode maybeContacts, 
          Map<String, PartyId> varToPartyId, 
          InfoCollector collector) throws FilingError {
    Optional<JsonNode> serviceContactsJson = JsonHelpers.unwrapDAList(maybeContacts);
    if (serviceContactsJson.isPresent()) {
      List<CaseServiceContact> contacts = new ArrayList<>();
      Iterable<JsonNode> servObjs = serviceContactsJson.get()::elements;
      int servIdx = 0;
      for (JsonNode servObj : servObjs) {
        collector.pushAttributeStack("service_contacts[" + servIdx + "]");
        Optional<PartyId> realId = Optional.empty();
        JsonNode partyAssoc = servObj.get("party_association");
        if (partyAssoc != null && partyAssoc.isTextual()) {
          if (varToPartyId.containsKey(partyAssoc.asText())) {
            realId = Optional.of(varToPartyId.get(partyAssoc.asText()));
          } else {
            realId = Optional.of(PartyId.Already(partyAssoc.asText()));
          }
          log.info("Filing party id (" + partyAssoc.asText() + ") for service party assoc ("
              + servObj.get("contact_id").asText() + "): " + realId);
        } else if (partyAssoc != null && !partyAssoc.isNull()) {
          log.warn("What is party_association? should be text: " + partyAssoc); 
          collector.addWrong(collector.requestVar("party_association", 
              "Party association should be text, is" + partyAssoc.toString(), "text"));
        }
        JsonNode contactId = servObj.get("contact_id");
        if (contactId == null || !contactId.isTextual()) {
          collector.addWrong(collector.requestVar("contact_id", "Service contacts must have a contact id", "text"));
        }
        JsonNode serviceType = servObj.get("service_type");
        if (serviceType == null || !serviceType.isTextual()) {
          collector.addWrong(collector.requestVar("service_type", "Service contacts must have a service type code", "text"));
        }
        CaseServiceContact contact = new CaseServiceContact(
            contactId.asText(),
            serviceType.asText(), realId);
        contacts.add(contact);
        servIdx++;
        collector.popAttributeStack(); 
      }
      return contacts;
    } else {
      return List.of();
    }
  }
  
  private static List<FilingDoc> extractFilingDocs(
          JsonNode bundle, 
          JsonNode clerkComments, 
          Map<String, PartyId> varToPartyId, 
          InfoCollector collector) throws FilingError {
    List<FilingDoc> filingDocs = new ArrayList<FilingDoc>();
    final InterviewVariable bundleVar = collector.requestVar("al_court_bundle",
        "The full court bundle", "ALDocumentBundle");
    if (bundle == null) {
      collector.addRequired(bundleVar);
    }
    Optional<JsonNode> maybeElems = JsonHelpers.unwrapDAList(bundle);
    if (maybeElems.isEmpty()) {
      throw FilingError.malformedInterview(
          "al_court_bundle should be a JSON object with a elements array (i.e. a python DAList)");
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
            elems.get(i), varToPartyId, i == 0,  // the 0th doc is the Lead doc by default
            collector); 
        collector.popAttributeStack();
        maybeDoc.ifPresent(doc -> {
          filingDocs.add(doc);
        });
      } catch (FilingError err) {
        if (err.getType().equals(FilingError.Type.MissingRequired)) {
          collector.addRequired(err.getMissingVariable().get());
        }
        throw err;
      }
    }
    if (clerkComments != null && clerkComments.isTextual()) {
      String filingComments = clerkComments.asText("");
      if (!filingDocs.isEmpty()) {
        filingDocs.get(0).setFilingComments(filingComments);
      }
    }
    return filingDocs;
  }

  private static Optional<LocalDate> extractReturnDate(JsonNode jsonReturnDate, InfoCollector collector) throws FilingError {
    Optional<LocalDate> maybeReturnDate = Optional.empty();
    if (jsonReturnDate != null && jsonReturnDate.isTextual() && !jsonReturnDate.asText("").isBlank()) {
      // TODO(#47): Time zone user is using?
      try {
        maybeReturnDate = Optional.of(LocalDate.parse(jsonReturnDate.asText(), DateTimeFormatter.ISO_DATE)); 
      } catch (DateTimeParseException ex) {
        InterviewVariable var = collector.requestVar("return_date", "Should be as YYYY-MM-DD+01:00", "date");
        collector.addWrong(var);
      }
    }
    return maybeReturnDate;
  }
  
  private static String extractNullableString(JsonNode json) {
    if (json != null && json.isTextual()) {
      return json.asText();
    }
    return null;
  }

  @Override
  public FilingInformation deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    try {
      return fromNode(node, this.classCollector);
    } catch (FilingError err) {
      throw new JsonExtractException(p, err);
    }
  }

}
