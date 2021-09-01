package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import tyler.ecf.extensions.common.FilingTypeType;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;

public class FilingDocDocassembleJacksonDeserializer {
  private static Logger log = LoggerFactory.getLogger(
      FilingInformationDocassembleJacksonDeserializer.class);

  /** Parses a filing from the DA Json Object. Used by Deserializers that include filings. */
  public static Result<Optional<FilingDoc>, FilingError> fromNode(JsonNode node, int sequenceNum, InfoCollector collector) {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview(
              "Refusing to parse filing doc that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      return Result.err(err);
    }
    
    // Get: filename
    String fileName = node.get("filename").asText("") + ".pdf";
    
    if (!node.has("proxy_enabled") || !node.get("proxy_enabled").asBoolean(false)) {
      log.info(fileName + " isn't proxy enabled");
      return Result.ok(Optional.empty());
    }
      
    try {
      if (!node.has("data_url") || !node.get("data_url").isTextual()) {
        FilingError err = FilingError.malformedInterview(
            "Refusing to parse filing without data_url");
        collector.error(err);
        return Result.err(err);
      }
      if (!node.has("filename") || !node.get("filename").isTextual()) {
        FilingError err = FilingError.malformedInterview(
            "Refusing to parse filing without filename");
        collector.error(err);
        return Result.err(err);
      }

      // TODO(brycew): we need to put URLs of all of the other filings and read in those files
      URL inUrl = new URL(node.get("data_url").asText().replace("localhost", "docassemble"));
      Optional<String> motionName = Optional.empty();
      if (node.has("motion_type") && node.get("motion_type").isTextual()) {
        motionName = Optional.of(node.get("motion_type").asText());
      } else {
        InterviewVariable var = collector.requestVar("motion",
            "The Type of Motion that this interview is", "text");
        collector.addOptional(var);
      }
      // TODO(brycew): CONTINUE
      String documentTypeFormatName = "";
      if (node.has("document_type") && node.get("document_type").isTextual()) {
        documentTypeFormatName = node.get("document_type").asText();
        // Doesn't have to be a document type
      }
      
      String filingComponentCode = "";
      JsonNode filingComponentJson = node.get("filing_component");
      if (filingComponentJson != null && filingComponentJson.isTextual()) {
        filingComponentCode = filingComponentJson.asText();
      }
      HttpURLConnection conn = (HttpURLConnection) inUrl.openConnection();
      conn.setRequestMethod("GET");
      InputStream inStream = conn.getInputStream();
      if (inStream == null) {
        FilingError err = FilingError.serverError("Couldn't connect to " + inUrl.toString());
        return Result.err(err);
      }
      return Result.ok(Optional.of(
          new FilingDoc(fileName, 
              inStream.readAllBytes(),
              Optional.empty(),
              "", 
              Optional.empty(),
              List.of(), 
              Optional.empty(),
              documentTypeFormatName, filingComponentCode,
              "",
              motionName,
              List.of(),
              List.of(),
              FilingTypeType.E_FILE, 
              sequenceNum == 0)));
    } catch (IOException ex)  {
      FilingError err = FilingError.serverError("IOException trying to parse data_url: " + ex);
      return Result.err(err);
    }
  }
}
