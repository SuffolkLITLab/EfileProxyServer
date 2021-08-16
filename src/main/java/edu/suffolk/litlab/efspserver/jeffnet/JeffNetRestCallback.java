package edu.suffolk.litlab.efspserver.jeffnet;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.db.Transaction;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.services.EfmRestCallbackInterface;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;

public class JeffNetRestCallback implements EfmRestCallbackInterface {
  private static Logger log = 
      LoggerFactory.getLogger(JeffNetRestCallback.class); 
  
  private UserDatabase ud;
  private OrgMessageSender msgSender;
  
  public JeffNetRestCallback(UserDatabase ud, OrgMessageSender msgSender) {
    this.ud = ud;
    this.msgSender = msgSender;
  }

  @Override
  public Response statusCallback(HttpHeaders httpHeaders, String statusReport) {
    String callbackApiKey = httpHeaders.getHeaderString("X-API-KEY");
    if (callbackApiKey == null || callbackApiKey.isBlank()) {
      log.error("Call didn't pass in an API Key");
      return Response.status(400).build();
    }

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    FileResponse resp;
    try {
      resp = mapper.readValue(statusReport, FileResponse.class);
      Optional<Transaction> maybeTrans = ud.findTransaction(UUID.fromString(resp.transactionId));
      if (maybeTrans.isEmpty()) {
        log.error("Transaction " + resp.transactionId + " isn't present in the database!");
        return Response.status(404).build();
      }
      Transaction transaction = maybeTrans.get();
      if (transaction.apiKeyUsed == null || !transaction.apiKeyUsed.equals(callbackApiKey)) {
        log.error("Call with API key " + callbackApiKey + " didn't match original API key!");
        return Response.status(401).build();
      }
      // Done all the checks: now sending the message to the user
      boolean success = msgSender.sendMessage(transaction, resp.status);
      if (success) {
        return Response.status(204).build();
      } else {
        log.error("Grabed info from db: couldn't send message");
        return Response.status(500).build();
      }
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      log.error("Couldn't process the status report: " + statusReport);
      log.error(e.toString());
      return Response.status(400).build();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      log.error("Couldn't connect to the SQL database to get the transaction: ");
      log.error(e.toString());
      return Response.status(500).build();
    }
  }
  
  private static class FileResponse {
    @JsonProperty("TransactionID")
    String transactionId;

    @JsonProperty("Status")
    String status;
  }

}
