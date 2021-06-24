package edu.suffolk.assemblyline.efspserver.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.hubspot.algebra.Result;
import edu.suffolk.assemblyline.efspserver.FilingEntities;
import edu.suffolk.assemblyline.efspserver.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class DocassembleToFilingEntityConverter implements InterviewToFilingEntityConverter {

  private static Logger log = Logger.getLogger("mylogger"); 
  
  private Result<List<Person>, ExtractError> collectPeople(JsonObject topObj, String potentialMember) {
    if (!(topObj.has(potentialMember) 
          && topObj.get(potentialMember).isJsonObject()
          && topObj.getAsJsonObject(potentialMember).has("elements")
          && topObj.getAsJsonObject(potentialMember).get("elements").isJsonArray())) {
      return Result.err(ExtractError.MissingRequired);
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
        return Result.err(ExtractError.MalformedInterview);
      }
      JsonObject topObj = jsonVars.getAsJsonObject();
      log.fine("Got the top object");
      Result<List<Person>, ExtractError> maybeUsers = collectPeople(topObj, "users");
      if (maybeUsers.isErr()) {
        return maybeUsers.mapOk((ppl) -> null); 
      }
      List<Person> users = maybeUsers.unwrapOrElseThrow();
      // TODO(brycew): enforce that someone has an email
      //boolean someoneHasEmail = users.stream().reduce(f
      
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
        return Result.err(ExtractError.MissingRequired);
      }
      userStartedCase.ifPresent((started) -> {
        if (started) {
          entities.setPlaintiffs(users);
          entities.setDefendants(otherParties);
        } else {
          entities.setPlaintiffs(otherParties);
          entities.setDefendants(users);
        }
      });
      // TODO(brycew): plaintiff and petitioners are both defined. 
      // Typical role might have the difference, take which is available
      //Person per = new Person();
      return Result.ok(entities);  
    } catch (JsonSyntaxException ex) {
      return Result.err(ExtractError.MalformedInterview);
    }
  }

}
