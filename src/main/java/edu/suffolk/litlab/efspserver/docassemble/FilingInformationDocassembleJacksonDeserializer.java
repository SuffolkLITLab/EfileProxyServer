package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilingInformationDocassembleJacksonDeserializer
    extends StdDeserializer<FilingInformation> {
  private static Logger log = LoggerFactory.getLogger(
      FilingInformationDocassembleJacksonDeserializer.class);

  private static final long serialVersionUID = 1L;

  private LegalIssuesTaxonomyCodes codes;
  private InfoCollector classCollector;
  
  public FilingInformationDocassembleJacksonDeserializer(Class<FilingInformation> t, 
      LegalIssuesTaxonomyCodes codes, InfoCollector collector) {
    super(t);
    this.codes = codes;
    this.classCollector = collector;
  }

  private List<Person> collectPeople(JsonNode topObj, 
      String potentialMember, InfoCollector collector) throws FilingError {
    if (!topObj.has(potentialMember)) {
      return List.of();  // Just an empty list: we don't know if it's required
    }
    if (!(topObj.get(potentialMember).isObject()
          && topObj.get(potentialMember).has("elements")
          && topObj.get(potentialMember).get("elements").isArray())) {
      throw FilingError.malformedInterview(
          potentialMember + " isn't an List with an elements array"); 
    }
    List<Person> people = new ArrayList<Person>();
    JsonNode peopleElements = topObj.get(potentialMember).get("elements");
    for (int i = 0; i < peopleElements.size(); i++) {
      Result<Person, FilingError> per = 
          PersonDocassembleJacksonDeserializer.fromNode(peopleElements.get(i), collector);
      if (per.isErr()) {
        FilingError ex = per.unwrapErrOrElseThrow();
        log.warn("Person exception: " + ex);
        throw ex;
      }
      people.add(per.unwrapOrElseThrow());
    }
    return people;
  }

  public Result<FilingInformation, FilingError> fromNode(JsonNode node, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview("interview isn't a json object"); 
      collector.error(err);
      return Result.err(err);
    }
    List<Person> users = collectPeople(node, "users", collector);
    if (users.isEmpty()) {
      // TODO(brycew): does this need to be split up into every single thing that could be in users?
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
    // TODO(brycew): optional
    Optional<String> userEmail = users.get(0).getContactInfo().getEmail(); 
    if (userEmail.isEmpty() || userEmail.get().isBlank()) { 
      InterviewVariable var = new InterviewVariable(
          "users[0].email", "Email is required for at least one user", "text", List.of());
      collector.addRequired(var);
    }
      
    log.debug("Got users");
    final List<Person> otherParties = collectPeople(node, "other_parties", collector);
    if (otherParties.isEmpty()) {
      InterviewVariable othersExpected = new InterviewVariable("other_parties", 
          "the side of the matter that current person answering this interview is on",
          "ALPeopleList", List.of());
      collector.addOptional(othersExpected);
    }
    log.debug("Got other parties");
      
    Optional<Boolean> userStartedCase = Optional.empty(); 
    if (node.has("user_started_case") 
        && node.get("user_started_case").isBoolean()) {
      userStartedCase = Optional.of(node.get("user_started_case").asBoolean());
    }
    log.debug("user_started_case: " + userStartedCase.orElse(null));

    FilingInformation entities = new FilingInformation();
    if (userStartedCase.isEmpty()) {
      InterviewVariable var = collector.requestVar("user_started_case", 
          "Whether or the user is the plantiff or petitioner", "boolean", List.of("true", "false"));
      collector.addRequired(var);
    }
    // TODO(brycew): plaintiff and petitioners are both defined. 
    // Typical role might have the difference, take which is available
    // TODO(brycew): better way to get the parties types?
    // TODO(brycew): make the party types use the SALI standard
    JsonNode plantiffPartyJson = node.get("plantiff_party_type");
    if (plantiffPartyJson == null || !plantiffPartyJson.isTextual()) {
      InterviewVariable var = collector.requestVar("plantiff_party_type", 
          "What legal role the plaintiff fulfills", "text"); 
      collector.addOptional(var);
      plantiffPartyJson = NullNode.getInstance(); 
    }
    entities.setPlaintiffPartyType(plantiffPartyJson.asText(""));
    JsonNode defendantPartyJson = node.get("defendant_party_type");
    if (defendantPartyJson == null || !defendantPartyJson.isTextual()) {
      InterviewVariable var = collector.requestVar("defendant_party_type", 
          "What legal role the defendant fulfills", "text"); 
      collector.addOptional(var);
      defendantPartyJson = NullNode.getInstance();
    }
    entities.setDefendantPartyType(defendantPartyJson.asText(""));

    boolean started = userStartedCase.get(); 
    if (started) {
      users.forEach((user) -> {
        user.setRole("Plaintiff");
      });
      entities.setPlaintiffs(users);
      otherParties.forEach((other) -> {
        other.setRole("Defendant");
      });
      entities.setDefendants(otherParties);
    } else {
      users.forEach((user) -> {
        user.setRole("Defendant");
      });
      entities.setPlaintiffs(otherParties);
      otherParties.forEach((other) -> {
        other.setRole("Plaintiff");
      });
      entities.setDefendants(users);
    }
      
    // TODO(brycew): this approach is a complete mess, don't know
    // how to best map LIST onto case categories, ECF is too high level
    String category_var_name = "tyler_case_category";
    JsonNode category = node.get(category_var_name);
    JsonNode metadataElems = node.get("interview_metadata").get("elements");
    String key = metadataElems.fieldNames().next();
    if (metadataElems.size() >= 1) {
      log.warn("Only the first metadata element will be looked at: " + key); 
    }

    JsonNode metadata = metadataElems.get(key).get("elements"); 
    if (category != null && !category.isNull() && category.isTextual()) {
      // TODO(brycew): stop passing in this case category stuff right now
      CaseCategory caseCat = new CaseCategory(category.asText(), category.asText());
      entities.setCaseCategory(caseCat);
    } else if (metadata.has("categories") && metadata.get("categories").isArray()) {
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
    } else {
      InterviewVariable var = collector.requestVar(category_var_name, "", "text"); 
      collector.addRequired(var);
    }

    String type_var_name = "tyler_case_type";
    JsonNode type = node.get(type_var_name);
    if (type != null && type.isTextual()) {
      String typeStr = type.asText();
      entities.setCaseType(typeStr);
    } else if (metadata.has("title") && metadata.get("title").isTextual()) {
      entities.setCaseType(metadata.get("title").asText());
    } else { 
      InterviewVariable var = collector.requestVar(type_var_name,  "", "text");
      collector.addRequired(var);
    }

    String subtype_var_name = "tyler_case_subtype";
    JsonNode subtype = node.get(subtype_var_name);
    if (subtype != null && subtype.isTextual()) {
      String subtypeStr = subtype.asText();
      entities.setCaseType(subtypeStr);
    } else {
      InterviewVariable var = collector.requestVar(subtype_var_name, "TODO(brycew)", "text");
      collector.addOptional(var);
      entities.setCaseSubtype("");
    }

    // Get the interview metadablock TODO(brycew): just one for now
    /*
    log.info("Keyset: " + metadataElems.fieldNames());
    */
      
    List<String> filingPartyIds = users.stream()
        .map((per) -> per.getIdString())    
        .collect(Collectors.toList());
    List<FilingDoc> filingDocs = new ArrayList<FilingDoc>();
    final InterviewVariable bundleVar = collector.requestVar("al_court_bundle", 
        "The full court bundle", "ALDocumentBundle");
    if (!node.has("al_court_bundle")) {
      collector.addRequired(bundleVar);
    }
    if (!node.get("al_court_bundle").isObject() || !node.get("al_court_bundle").has("elements")
        || !node.get("al_court_bundle").get("elements").isArray()) {
      return Result.err(FilingError.malformedInterview(
          "al_court_bundle should be a JSON object with a elements array (i.e. a python DAList)"));
    }
    JsonNode bundle = node.get("al_court_bundle");
    if (bundle == null) {
      collector.addRequired(bundleVar);
    }

    JsonNode elems = bundle.get("elements");
    if (elems == null || elems.isEmpty()) {
      collector.addRequired(bundleVar);
    }

    for (int i = 0; i < elems.size(); i++) {
      Result<Optional<FilingDoc>, FilingError> fil = FilingDocDocassembleJacksonDeserializer.fromNode(elems.get(i), i, collector);
      if (fil.isOk()) {
        Optional<FilingDoc> maybeDoc = fil.unwrapOrElseThrow();
        maybeDoc.ifPresent(doc -> {
          doc.setFilingPartyIds(filingPartyIds);
          filingDocs.add(doc);
        });
      } else {
        FilingError err = fil.unwrapErrOrElseThrow();
        if (err.getType().equals(FilingError.Type.MissingRequired)) {
          collector.addRequired(bundleVar); 
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
