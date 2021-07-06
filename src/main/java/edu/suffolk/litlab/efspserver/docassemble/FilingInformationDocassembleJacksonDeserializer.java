package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.services.ExtractError;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FilingInformationDocassembleJacksonDeserializer 
    extends StdDeserializer<FilingInformation> {
  private static Logger log = Logger.getLogger("mylogger"); 

  private static final long serialVersionUID = 1L;

  private LegalIssuesTaxonomyCodes codes;
  
  public FilingInformationDocassembleJacksonDeserializer(Class<FilingInformation> t, 
      LegalIssuesTaxonomyCodes codes) {
    super(t);
    this.codes = codes;
  }

  private Result<List<Person>, ExtractError> collectPeople(JsonNode topObj, 
      String potentialMember, JsonParser p) {
    if (!(topObj.has(potentialMember) 
          && topObj.get(potentialMember).isObject()
          && topObj.get(potentialMember).has("elements")
          && topObj.get(potentialMember).get("elements").isArray())) {
      return Result.err(new ExtractError(ExtractError.Type.MissingRequired, "", potentialMember));
    }
    List<Person> people = new ArrayList<Person>();
    JsonNode peopleElements = topObj.get(potentialMember).get("elements");
    for (int i = 0; i < peopleElements.size(); i++) {
      try {
        Person per = PersonDocassembleJacksonDeserializer.fromNode(peopleElements.get(i), p);
        people.add(per);
      } catch (JsonProcessingException ex) {
        log.warning("Person exception: " + ex);
      }
    }
    return Result.ok(people);
  }

  @Override
  public FilingInformation deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    if (!node.isObject()) {
      throw new JsonExtractException(p, new ExtractError(ExtractError.Type.MalformedInterview)); 
    }
    Result<List<Person>, ExtractError> maybeUsers = collectPeople(node, "users", p);
    if (maybeUsers.isErr()) {
      throw new JsonExtractException(p, maybeUsers.unwrapErrOrElseThrow());
    }
    List<Person> users = maybeUsers.unwrapOrElseThrow();
    if (users.isEmpty()) {
      throw new JsonExtractException(p, 
          new ExtractError(ExtractError.Type.MissingRequired, "ahhh", "users"));
    }

    if (node.has("user_preferred_language") 
        && node.get("user_preferred_language").isTextual()) {
      users.get(0).setLanguage(
          node.get("user_preferred_language").asText());
    }
    boolean userHasEmail = users.get(0).getContactInfo().getEmail().isPresent();
    if (!userHasEmail) { 
      throw new JsonExtractException(p,
          new ExtractError(ExtractError.Type.MissingRequired, "users[0]", "users[0].email"));
    }
      
    log.fine("Got users");
    Result<List<Person>, ExtractError> maybeOthers = collectPeople(node, "other_parties", p);
    if (maybeOthers.isErr()) {
      throw new JsonExtractException(p, maybeOthers.unwrapErrOrElseThrow());
    }
    final List<Person> otherParties = maybeOthers.unwrapOrElseThrow(); 
    log.fine("Got other parties");
      
    Optional<Boolean> userStartedCase = Optional.empty(); 
    if (node.has("user_started_case") 
        && node.get("user_started_case").isBoolean()) {
      userStartedCase = Optional.of(node.get("user_started_case").asBoolean());
    }
    log.fine("user_started_case: " + userStartedCase.orElse(null));

    FilingInformation entities = new FilingInformation();
    if (userStartedCase.isEmpty()) {
      throw new JsonExtractException(p, 
          new ExtractError(ExtractError.Type.MissingRequired, "", "user_started_case"));
    }
    // TODO(brycew): plaintiff and petitioners are both defined. 
    // Typical role might have the difference, take which is available
    userStartedCase.ifPresent((started) -> {
      if (started) {
        entities.setPlaintiffs(users);
        entities.setDefendants(otherParties);
      } else {
        entities.setPlaintiffs(otherParties);
        entities.setDefendants(users);
      }
    });
      
    // Get the interview metadablock TODO(brycew): just one for now
    // TODO(brycew): also be better at errors here
    JsonNode metadataElems = 
        node.get("interview_metadata").get("elements");
    log.info("Keyset: " + metadataElems.fieldNames());
    if (metadataElems.size() == 1) {
      String key = metadataElems.fieldNames().next();
      JsonNode metadata = metadataElems.get(key).get("elements");
      if (metadata.has("categories") && metadata.get("categories").isArray()) {
        List<String> categories = new ArrayList<String>(); 
        metadata.get("categories").forEach((cat) -> categories.add(cat.asText()));
        log.info("Categories: " + categories.toString());
        Set<String> ecfs = codes.allEcfCaseTypes(categories);
        log.info("ECFs:" + ecfs.size());
        if (ecfs.size() == 1) {
          String caseType = ecfs.iterator().next();
          // TODO(brycew): better title
          CaseCategory caseCat = new CaseCategory(categories.toString(), caseType); 
          entities.setCaseCategory(caseCat);
        }
      }
      if (metadata.has("title") && metadata.get("title").isTextual()) {
        entities.setCaseType(metadata.get("title").asText());
        // TODO(brycew): fill in subtype?
        entities.setCaseSubtype("");
      }
    }
      
    List<String> filingPartyIds = users.stream()
        .map((per) -> per.getId())
        .collect(Collectors.toList());
    List<FilingDoc> filingDocs = new ArrayList<FilingDoc>();
    JsonNode elems = node.get("al_court_bundle").get("elements");
    for (int i = 0; i < elems.size(); i++) {
      try {
        FilingDoc fil = FilingDocDocassembleJacksonDeserializer.fromNode(elems.get(i), p);
        fil.setFilingPartyIds(filingPartyIds);
        filingDocs.add(fil);
      } catch (JsonParseException ex) {
        // continue
      }
    }
    // TODO(brycew): grab the user's comments to the court clerk from the cover page
    // TODO(brycew): the above will require us to pass the full json
    //String filingComments = "";
    entities.setFilings(filingDocs);
      
    return entities;  
  }

}
