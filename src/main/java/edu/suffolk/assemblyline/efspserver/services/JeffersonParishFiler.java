package edu.suffolk.assemblyline.efspserver.services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import edu.suffolk.assemblyline.efspserver.Filing;
import edu.suffolk.assemblyline.efspserver.Person;
import edu.suffolk.assemblyline.efspserver.codes.CaseCategory;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import tyler.efm.services.schema.common.ErrorType;

public class JeffersonParishFiler implements EfmFilingInterface {
  
  private URI filingEndpoint;
  private String apiToken;
  
  public JeffersonParishFiler(String filingEndpoint, String apiToken) throws URISyntaxException {
    this.filingEndpoint = new URI(filingEndpoint);
    this.apiToken = apiToken;
  }

  @Override
  public Optional<ErrorType> sendFiling(String courtLocationId, List<Person> plaintiffs,
      List<Person> defendants, CaseCategory caseCategoryCode, String caseType, String caseSubtype,
      List<Filing> filings, String paymentId) {
    
    JsonArray participantList = new JsonArray();
    Gson gson = new Gson();
    for (Person defendant : defendants) {
      participantList.add(defendant.getAsStandardJson(gson, "Defendant"));
    }
    for (Person plaintiff : plaintiffs) {
      participantList.add(plaintiff.getAsStandardJson(gson, "Plaintiff"));
    }
    JsonObject caseInfo = new JsonObject(); 
    caseInfo.add("CaseCourt", new JsonPrimitive(courtLocationId));
    caseInfo.add("CaseCategoryText", new JsonPrimitive(caseCategoryCode.name));
    caseInfo.add("CaseParticipants", participantList);
    caseInfo.add("CaseTypeText", new JsonPrimitive(caseType));
    caseInfo.add("CaseSubTypeText", new JsonPrimitive(caseSubtype));
    // TODO(brycew): remove
    //caseInfo.add("CauseOfActionCode", new JsonPrimitive(""));
    //caseInfo.add("CaseContestedIndicator", new JsonPrimitive(false));
    
    JsonObject sendingMde = new JsonObject(); 
    sendingMde.add("IdentificationID", new JsonPrimitive("https://suffolk-operating-url.org"));
    
    JsonObject finalObj = new JsonObject(); 
    // TODO(brycew): is this one or multiple filings? What are we sending over?
    finalObj.add("SendingMDELocationID", sendingMde);
    finalObj.add("CaseInfo", caseInfo);
    JsonObject callbackObj = new JsonObject(); 
    callbackObj.add("Url", new JsonPrimitive("https://suffolk-operating-url.org/DocassembleHook"));
    // TODO(brycew): Setup callback/webhook handler
    // TODO(brycew): add this GUID to the database with the email to alert when we get the hook back
    String filingUid = UUID.randomUUID().toString();
    callbackObj.add("Id", new JsonPrimitive(filingUid));
    finalObj.add("Callback", callbackObj);

    try {
      finalObj.add("FilingLeadDocument", filings.get(0).getAsStandardJson(gson));
      String finalStr = gson.toJson(finalObj);
      System.err.println("Final Json object: " + finalStr); 
    
      System.err.println("Sending to " + this.filingEndpoint + ", with token: " + this.apiToken);
      HttpClient client = HttpClient.newBuilder().build();
      HttpRequest request = HttpRequest.newBuilder()
          .POST(HttpRequest.BodyPublishers.ofString(finalStr))
          .header("X-API-KEY", this.apiToken)
          .header("Content-type", "application/json")
          .header("Accept", "application/json")
          .uri(this.filingEndpoint)
          .build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      System.err.println("Got err response code: " + response.body() + " " + response.statusCode());
    } catch (InterruptedException ex) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error getting response from " + this.filingEndpoint + ", " + ex);
      return Optional.of(err);
    } catch (IOException ex) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error connecting to " + this.filingEndpoint + ", " + ex);
      return Optional.of(err);
    }
    return Optional.empty();
  }
}
