package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.EfmFilingInterface;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tyler.efm.services.schema.common.ErrorType;

public class JeffNetFiler implements EfmFilingInterface {
  private static Logger log =
      LoggerFactory.getLogger(JeffNetFiler.class);

  private URI filingEndpoint;
  private String apiToken;
  private SimpleModule module;
  
  /** Constructor that takes the URL endpoint of JeffNet to call, and the API token to call it. */
  public JeffNetFiler(String filingEndpoint, String apiToken) throws URISyntaxException {
    this.filingEndpoint = new URI(filingEndpoint);
    this.apiToken = apiToken;
    
    this.module = new SimpleModule();
    module.addSerializer(new FilingInformationJeffNetSerializer(FilingInformation.class));
    module.addSerializer(
        new ContactInfoJeffNetJacksonSerializer(ContactInformation.class));
    module.addSerializer(new NameJeffNetJacksonSerializer(Name.class));
    module.addSerializer(new FilingJeffNetJacksonSerializer(FilingDoc.class));
    module.addSerializer(new PersonJeffNetJacksonSerializer(Person.class));
  }
  
  @Override
  public Result<UUID, ErrorType> sendFiling(FilingInformation info) {
    
    if (info.getFilings().isEmpty()) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error: cannot file with no filings ");
      return Result.err(err);
    }
    
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(this.module);
    
    try {
      String finalStr = mapper.writeValueAsString(info);
      log.debug("Final Json object: " + finalStr);
    
      log.info("Sending to " + this.filingEndpoint);
      HttpClient client = HttpClient.newBuilder().build();
      HttpRequest request = HttpRequest.newBuilder()
          .POST(HttpRequest.BodyPublishers.ofString(finalStr))
          .header("X-API-KEY", this.apiToken)
          .header("Content-type", "application/json")
          .header("Accept", "application/json")
          .uri(this.filingEndpoint)
          .build();
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      log.info("Got response code: " + response.body() + " " + response.statusCode());
      if (response.statusCode() != 200) {
        ErrorType err = new ErrorType();
        err.setErrorCode(Integer.toString(response.statusCode()));
        err.setErrorText(response.body());
        return Result.err(err);
      }
      ApiResult result = mapper.readValue(response.body(), ApiResult.class);
      UUID transactionId = UUID.fromString(result.transactionId);
      return Result.ok(transactionId); 
    } catch (InterruptedException ex) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error getting response from " + this.filingEndpoint + ", " + ex);
      return Result.err(err);
    } catch (JsonMappingException ex) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error when trying to understand JeffNet's response b/c: " + ex); 
      return Result.err(err);
    } catch (IOException ex) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error connecting to " + this.filingEndpoint + ", " + ex);
      return Result.err(err);
    }
  }
  
  private static class ApiResult {
    @JsonProperty("resultCode")
    int resultCode;
    
    @JsonProperty("message")
    String message;
    
    @JsonProperty("transactionID")
    String transactionId;
  }
}
