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
import java.net.HttpURLConnection;
import java.net.URL;

public class FilingDocDocassembleJacksonDeserializer {

  /** Parses a filing from the DA Json Object. Used by Deserializers that include filings. */
  public static Result<Optional<FilingDoc>, FilingError> fromNode(JsonNode node, int sequenceNum, InfoCollector collector) {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview(
              "Refusing to parse filing doc that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      return Result.err(err);
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
      
      if (!node.has("enabled") || !node.get("enabled").asBoolean(false)) {
        return Result.ok(Optional.empty());
      }
      
      // TODO(brycew): we need to put URLs of all of the other filings and read in those files
      URL inUrl = new URL(node.get("data_url").asText().replace("localhost", "docassemble"));
      // Get: filename
      String fileName = node.get("filename").asText() + ".pdf";
      if (true /* TODO(brycew): CONTINUE put some check for motion here. */) {
        InterviewVariable var = collector.requestVar("motion",
            "The Type of Motion that this interview is", "text");
        collector.addOptional(var);
      }
      // TODO(brycew): CONTINUE
      //NameAndCode regActionDesc = new NameAndCode("Motion", "");
      String documentTypeFormatName = "";
      if (node.has("document_type") && node.get("document_type").isTextual()) {
        documentTypeFormatName = node.get("document_type").asText();
        // Doesn't have to be a document type
      }
      HttpURLConnection conn = (HttpURLConnection) inUrl.openConnection();
      conn.setRequestMethod("GET");
      InputStream inStream = conn.getInputStream();
      if (inStream == null) {
        FilingError err = FilingError.serverError("Couldn't connect to " + inUrl.toString());
        return Result.err(err);
      }
      return Result.ok(Optional.of(new FilingDoc(fileName, inStream,
              List.of(), documentTypeFormatName, "", FilingTypeType.E_FILE, sequenceNum == 0)));
    } catch (IOException ex)  {
      FilingError err = FilingError.serverError("IOException trying to parse data_url: " + ex);
      return Result.err(err);
    }
  }
}
