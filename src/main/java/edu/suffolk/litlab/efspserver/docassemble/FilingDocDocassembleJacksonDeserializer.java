package edu.suffolk.litlab.efspserver.docassemble;

import static edu.suffolk.litlab.efspserver.docassemble.JsonHelpers.getIntMember;
import static edu.suffolk.litlab.efspserver.docassemble.JsonHelpers.getStringDefault;
import static edu.suffolk.litlab.efspserver.docassemble.JsonHelpers.getStringMember;
import static edu.suffolk.litlab.efspserver.docassemble.JsonHelpers.getMemberList;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.OptionalService;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import tyler.ecf.extensions.common.FilingTypeType;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class FilingDocDocassembleJacksonDeserializer {
  private static Logger log = LoggerFactory.getLogger(
      FilingInformationDocassembleJacksonDeserializer.class);

  /** Parses a filing from the DA Json Object. Used by Deserializers that include filings. */
  public static Optional<FilingDoc> fromNode(JsonNode node, Map<String, String> varToId,
      int sequenceNum, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview(
              "Refusing to parse filing doc that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
    }

    InterviewVariable filingVar = collector.requestVar("tyler_filing_type", "What filing type is this?", "text"); 
    JsonNode filingJson = node.get("tyler_filing_type");
    Optional<String> filingType = Optional.empty(); 
    if (filingJson != null && filingJson.isTextual()) {
      filingType = Optional.of(filingJson.asText());
    } else {
      log.warn("filing not present in the info!: " + node);
      // Optional for non-tyler ones. Will be enforced at the tyler level
      collector.addOptional(filingVar.appendDesc((node.has("instanceName")) ? node.get("instanceName").asText("?") : "?"));
    }

    // Get: filename
    String fileName = node.get("filename").asText("") + ".pdf";

    if (!node.has("proxy_enabled") || !node.get("proxy_enabled").asBoolean(false)) {
      log.info(fileName + " isn't proxy enabled");
      return Optional.empty();
    }

    try {
      if (!node.has("data_url") || !node.get("data_url").isTextual()) {
        FilingError err = FilingError.malformedInterview(
            "Refusing to parse filing without data_url");
        collector.error(err);
      }
      if (!node.has("filename") || !node.get("filename").isTextual()) {
        FilingError err = FilingError.malformedInterview(
            "Refusing to parse filing without filename");
        collector.error(err);
      }

      URL inUrl = new URL(node.get("data_url").asText().replace("localhost", "docassemble"));
      Optional<String> motionName = Optional.empty();
      if (node.has("motion_type") && node.get("motion_type").isTextual()) {
        motionName = Optional.of(node.get("motion_type").asText());
      } else {
        InterviewVariable var = collector.requestVar("motion",
            "The Type of Motion that this interview is", "text");
        collector.addOptional(var);
      }
      String documentTypeFormatName = getStringDefault(node, "document_type", "");

      List<OptionalService> optServices = new ArrayList<OptionalService>();
      JsonNode optServs = node.get("optional_services");
      if (optServs != null && optServs.isArray()) {
        optServs.elements().forEachRemaining(optServ -> {
          String code = optServ.get("code").asText();
          Optional<Integer> mult = getIntMember(optServ, "multiplier"); 
          JsonNode feeJson = optServ.get("fee_amount");
          Optional<BigDecimal> fee = (feeJson.isBigDecimal()) ? Optional.of(feeJson.decimalValue()) : Optional.empty();
          optServices.add(new OptionalService(code, mult, fee));
        });
      }
      JsonNode jsonDueDate = node.get("due_date");
      Optional<LocalDate> maybeDueDate = Optional.empty();
      if (jsonDueDate != null && jsonDueDate.isTextual()) {
        maybeDueDate = Optional.of(LocalDate.ofInstant(Instant.parse(jsonDueDate.asText()), ZoneId.of("America/Chicago")));
      }

      String filingComponentCode = getStringDefault(node, "filing_component", "");
      
      Optional<String> userDescription = getStringMember(node, "filing_description");
      Optional<String> filingRefNum = getStringMember(node, "reference_number");
      Optional<String> filingAttorney = getStringMember(node, "filing_attorney");
      String filingComment = getStringDefault(node, "filing_comment", "");
      
      List<String> courtesyCopies = getMemberList(node, "courtesy_copies");
      List<String> preliminaryCopies = getMemberList(node, "preliminary_copies");
      List<String> filingParties = getMemberList(node, "filing_parties");
      
      Pattern usersPattern = Pattern.compile("users\\[[0-9]+\\]");
      Pattern otherPattern = Pattern.compile("other_parties\\[[0-9]+\\]");
      List<FilingDoc.PartyId> fullParties = filingParties.stream().map(fp -> {
        Matcher matcher = usersPattern.matcher(fp);
        if (matcher.find()) {
          return FilingDoc.PartyId.CurrentFiling(varToId.get(fp)); 
        } else {
          Matcher otherMatcher = otherPattern.matcher(fp);
          if (otherMatcher.find()) {
            return FilingDoc.PartyId.CurrentFiling(varToId.get(fp)); 
          } else {
            log.info("Existing filing party id: " + fp);
            return FilingDoc.PartyId.Already(fp); 
          }
        }
      }).collect(Collectors.toList());
      
      
      HttpURLConnection conn = (HttpURLConnection) inUrl.openConnection();
      conn.setRequestMethod("GET");
      InputStream inStream = conn.getInputStream();
      if (inStream == null) {
        FilingError err = FilingError.serverError("Couldn't connect to " + inUrl.toString());
        collector.error(err);
      }

      return Optional.of(
          new FilingDoc(filingType, fileName,
              inStream.readAllBytes(),
              userDescription,
              filingRefNum,
              maybeDueDate,
              fullParties,
              filingAttorney,
              documentTypeFormatName, filingComponentCode,
              filingComment,
              motionName,
              optServices,
              courtesyCopies,
              preliminaryCopies,
              FilingTypeType.E_FILE,
              sequenceNum == 0));
    } catch (IOException ex)  {
      FilingError err = FilingError.serverError("IOException trying to parse data_url: " + ex);
      collector.error(err);
      throw err;
    }
  }
}
