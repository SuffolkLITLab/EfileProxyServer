package edu.suffolk.litlab.efspserver.jeffnet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import edu.suffolk.litlab.efspserver.db.Transaction;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.services.EfmRestCallbackInterface;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;
import edu.suffolk.litlab.efspserver.services.UpdateMessageStatus;

public class JeffNetRestCallback implements EfmRestCallbackInterface {
  private static Logger log =
      LoggerFactory.getLogger(JeffNetRestCallback.class);

  private final DataSource ds;
  private final OrgMessageSender msgSender;

  public JeffNetRestCallback(DataSource ds, OrgMessageSender msgSender) {
    this.ds = ds;
    this.msgSender = msgSender;
  }

  @Override
  public Response statusCallback(HttpHeaders httpHeaders, String statusReport) {
    String callbackApiKey = httpHeaders.getHeaderString("X-API-KEY");
    if (callbackApiKey == null || callbackApiKey.isBlank()) {
      log.error("Call didn't pass in an API Key");
      return Response.status(400).build();
    }

    ObjectMapper mapper = JsonMapper.builder().configure(
        MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true).build();
    FileResponse resp;
    try {
      resp = mapper.readValue(statusReport, FileResponse.class);
    } catch (JsonProcessingException e) {
      // Trying to parse XML
      try {
        JAXBContext jaxContext = JAXBContext.newInstance(FileResponse.class);
        Unmarshaller unmar = jaxContext.createUnmarshaller();
        InputStream stream = new ByteArrayInputStream(statusReport.getBytes(StandardCharsets.UTF_8));
        resp = (FileResponse) unmar.unmarshal(stream);
      } catch (JAXBException jaxbEx) {
        log.error("Couldn't process the status report in XML or JSON: " + statusReport);
        log.error(jaxbEx.toString());
        return Response.status(400).build();
      }
    }
    try (Connection conn = ds.getConnection()){
      UserDatabase ud = new UserDatabase(conn);
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
      UpdateMessageStatus status = UpdateMessageStatus.fromStr(resp.status);
      boolean success = msgSender.sendMessage(transaction, status, resp.status, resp.messageText, resp.messageUrl, "Jefferson Parish court");
      if (success) {
        return Response.status(204).build();
      } else {
        log.error("Grabed info from db, but couldn't send message");
        return Response.status(500).build();
      }
    } catch (SQLException e) {
      log.error("Couldn't connect to the SQL database to get the transaction: ");
      log.error(e.toString());
      return Response.status(500).build();
    }

    }

  @XmlType(name="")
  @XmlRootElement(name= "FileResponse")
  public static class FileResponse {
    @XmlElement(name = "TransactionID")
    @JsonProperty("TransactionID")
    String transactionId;

    @XmlElement(name = "Status")
    @JsonProperty("Status")
    String status;

    @XmlElement(name = "MessageText")
    @JsonProperty("MessageText")
    String messageText;

    @XmlElement(name = "MessageURL")
    @JsonProperty("MessageURL")
    String messageUrl;
  }

}
