package edu.suffolk.assemblyline.efspserver.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hubspot.algebra.Result;
import com.opencsv.exceptions.CsvValidationException;

import edu.suffolk.assemblyline.efspserver.Filing;
import edu.suffolk.assemblyline.efspserver.FilingEntities;
import edu.suffolk.assemblyline.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.assemblyline.efspserver.Person;
import edu.suffolk.assemblyline.efspserver.codes.CaseCategory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DocassembleToFilingEntityConverter implements InterviewToFilingEntityConverter {

  private static Logger log = Logger.getLogger("mylogger"); 
  private LegalIssuesTaxonomyCodes codes;
  
  public DocassembleToFilingEntityConverter(InputStream taxonomyCsv) throws CsvValidationException, IOException {
    codes = new LegalIssuesTaxonomyCodes(taxonomyCsv);
  }
  
  private Result<List<Person>, ExtractError> collectPeople(JsonObject topObj, String potentialMember) {
    if (!(topObj.has(potentialMember) 
          && topObj.get(potentialMember).isJsonObject()
          && topObj.getAsJsonObject(potentialMember).has("elements")
          && topObj.getAsJsonObject(potentialMember).get("elements").isJsonArray())) {
      return Result.err(new ExtractError(ExtractError.Type.MissingRequired, "", potentialMember));
    }
    List<Person> people = new ArrayList<Person>();
    JsonArray peopleElements = topObj.getAsJsonObject(potentialMember).getAsJsonArray("elements");
    for (int i = 0; i < peopleElements.size(); i++) {
      Person.Builder.createPerson(peopleElements.get(i)).ifPresent((per) -> {
        people.add(per);
      });
    }
    return Result.ok(people);
  }

  @Override
  public Result<FilingEntities, ExtractError> extractEntities(String interviewContents) {
    try {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      log.info("Reading in to JsonElement");
      JsonElement jsonVars = JsonParser.parseString(interviewContents); 
      if (!jsonVars.isJsonObject()) {
        return Result.err(new ExtractError(ExtractError.Type.MalformedInterview)); 
      }
      JsonObject topObj = jsonVars.getAsJsonObject();
      log.fine("Got the top object");
      Result<List<Person>, ExtractError> maybeUsers = collectPeople(topObj, "users");
      if (maybeUsers.isErr()) {
        return maybeUsers.mapOk((ppl) -> null); 
      }
      List<Person> users = maybeUsers.unwrapOrElseThrow();
      if (users.isEmpty()) {
        return Result.err(new ExtractError(ExtractError.Type.MissingRequired, "", "users"));
      }
      
      if (topObj.has("user_preferred_language") 
          && topObj.get("user_preferred_language").isJsonPrimitive() 
          && topObj.getAsJsonPrimitive("user_preferred_language").isString()) {
        users.get(0).setLanguage(
            topObj.getAsJsonPrimitive("user_preferred_language").getAsString());
      }
      boolean userHasEmail = users.get(0).getContactInfo().getEmail().isPresent();
      if (!userHasEmail) { 
        return Result.err(
            new ExtractError(ExtractError.Type.MissingRequired, "users[0]", "users[0].email"));
      }
      
      log.fine("Got users");
      Result<List<Person>, ExtractError> maybeOthers = collectPeople(topObj, "other_parties");
      if (maybeOthers.isErr()) {
        return maybeOthers.mapOk((ppl) -> null);
      }
      List<Person> otherParties = maybeOthers.unwrapOrElseThrow(); 
      log.fine("Got other parties");
      
      Optional<Boolean> userStartedCase = Optional.empty(); 
      if (topObj.has("user_started_case") 
          && topObj.get("user_started_case").isJsonPrimitive()
          && topObj.getAsJsonPrimitive("user_started_case").isBoolean()) {
        userStartedCase = Optional.of(topObj.getAsJsonPrimitive("user_started_case").getAsBoolean());
      }
      log.fine("user_started_case: " + userStartedCase.orElse(null));

      //log.info(gson.toJson(jsonVars));
      FilingEntities entities = new FilingEntities();
      if (userStartedCase.isEmpty()) {
        return Result.err(new ExtractError(ExtractError.Type.MissingRequired, "", "user_started_case"));
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
      JsonObject metadataElems = 
          topObj.getAsJsonObject("interview_metadata").getAsJsonObject("elements");
      log.info("Keyset: " + metadataElems.keySet());
      if (metadataElems.keySet().size() == 1) {
        String key = metadataElems.keySet().iterator().next();
        JsonObject metadata = metadataElems.getAsJsonObject(key).getAsJsonObject("elements");
        if (metadata.has("categories") && metadata.get("categories").isJsonArray()) {
          List<String> categories = new ArrayList<String>(); 
          metadata.getAsJsonArray("categories").forEach((cat) -> categories.add(cat.getAsString()));
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
        if (metadata.has("title") && metadata.get("title").isJsonPrimitive()) {
          entities.setCaseType(metadata.getAsJsonPrimitive("title").getAsString());
          // TODO(brycew): fill in subtype?
          entities.setCaseSubtype("");
        }
      }
      
      // TODO(CONTINUE): read in the filing information
      List<String> filingPartyIds = users.stream()
          .map((per) -> per.getId())
          .collect(Collectors.toList());
      List<Filing> filings = new ArrayList<Filing>();
      JsonArray elems = topObj.getAsJsonObject("al_court_bundle").getAsJsonArray("elements");
      for (int i = 0; i < elems.size(); i++) {
        Filing.Builder.createFiling(elems.get(i), filingPartyIds).ifPresent((fil) -> {
          filings.add(fil);
        });
      }
      entities.setFilings(filings);
      
      return Result.ok(entities);  
    } catch (JsonSyntaxException ex) {
      return Result.err(new ExtractError(ExtractError.Type.MalformedInterview));
    }
  }

}
