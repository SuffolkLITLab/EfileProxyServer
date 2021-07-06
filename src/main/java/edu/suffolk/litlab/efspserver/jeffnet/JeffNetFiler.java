package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hubspot.algebra.NullValue;
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
import tyler.efm.services.schema.common.ErrorType;

public class JeffNetFiler implements EfmFilingInterface {
  
  private URI filingEndpoint;
  private String apiToken;
  
  public JeffNetFiler(String filingEndpoint, String apiToken) throws URISyntaxException {
    this.filingEndpoint = new URI(filingEndpoint);
    this.apiToken = apiToken;
  }

  @Override
  public Result<NullValue, ErrorType> sendFiling(FilingInformation info) {
    
    if (info.getFilings().isEmpty()) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error: cannot file with no filings ");
      return Result.err(err);
    }
    
    SimpleModule module = new SimpleModule();
    module.addSerializer(new FilingInformationJeffNetSerializer(FilingInformation.class));
    module.addSerializer(
        new ContactInfoJeffNetJacksonSerializer(ContactInformation.class));
    module.addSerializer(new NameJeffNetJacksonSerializer(Name.class));
    module.addSerializer(new FilingJeffNetJacksonSerializer(FilingDoc.class));
    module.addSerializer(new PersonJeffNetJacksonSerializer(Person.class));
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);
    
    try {
      String finalStr = mapper.writeValueAsString(info);
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
      return Result.err(err);
    } catch (IOException ex) {
      ErrorType err = new ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Error connecting to " + this.filingEndpoint + ", " + ex);
      return Result.err(err);
    }
    return Result.nullOk();
  }
}
