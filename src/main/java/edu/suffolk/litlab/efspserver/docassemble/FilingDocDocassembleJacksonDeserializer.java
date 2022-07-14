package edu.suffolk.litlab.efspserver.docassemble;

import static edu.suffolk.litlab.efspserver.JsonHelpers.getIntMember;
import static edu.suffolk.litlab.efspserver.JsonHelpers.getMemberList;
import static edu.suffolk.litlab.efspserver.JsonHelpers.getNumberMember;
import static edu.suffolk.litlab.efspserver.JsonHelpers.getStringDefault;
import static edu.suffolk.litlab.efspserver.JsonHelpers.getStringMember;
import static edu.suffolk.litlab.efspserver.services.FilingError.malformedInterview;
import static edu.suffolk.litlab.efspserver.services.FilingError.serverError;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.FilingAttachment;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.JsonHelpers;
import edu.suffolk.litlab.efspserver.OptionalService;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;

import fj.data.NonEmptyList;
import fj.data.Option;
import tyler.ecf.extensions.common.FilingTypeType;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class FilingDocDocassembleJacksonDeserializer {
  private static Logger log = LoggerFactory.getLogger(
      FilingInformationDocassembleJacksonDeserializer.class);

  /** Parses a filing from the DA Json Object. Used by Deserializers that include filings. */
  public static Optional<FilingDoc> fromNode(JsonNode node, Map<String, PartyId> varToPartyId,
      boolean isLeadDoc, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = malformedInterview(
              "Refusing to parse filing doc that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
    }

    JsonNode filingJson = node.get("filing_type");
    Optional<String> filingType = Optional.empty(); 
    if (filingJson != null && filingJson.isTextual()) {
      filingType = Optional.of(filingJson.asText());
    } else {
      InterviewVariable filingVar = collector.requestVar("filing_type", "What filing type is this?", "text"); 
      log.warn("filing_type not present in the info!: " + node);
      // Optional for non-tyler ones. Will be enforced at the tyler level
      collector.addOptional(filingVar.appendDesc((node.has("instanceName")) ? node.get("instanceName").asText("?") : "?"));
    }
    Optional<String> motionName = Optional.empty();
    if (node.has("motion_type") && node.get("motion_type").isTextual()) {
      motionName = Optional.of(node.get("motion_type").asText());
    } else {
      InterviewVariable var = collector.requestVar("motion",
          "The Type of Motion that this interview is", "text");
      collector.addOptional(var);
    }

    List<OptionalService> optServices = new ArrayList<OptionalService>();
    Optional<JsonNode> maybeOptServs = JsonHelpers.unwrapDAList(node.get("optional_services"));
    maybeOptServs.ifPresent(optServs -> {
      optServs.elements().forEachRemaining(optServ -> {
        String code = optServ.get("code").asText();
        Optional<Integer> mult = getIntMember(optServ, "multiplier"); 
        Optional<BigDecimal> fee = getNumberMember(optServ, "fee_amount"); 
        optServices.add(new OptionalService(code, mult, fee));
      });
    });
    JsonNode jsonDueDate = node.get("due_date");
    Optional<LocalDate> maybeDueDate = Optional.empty();
    if (jsonDueDate != null && jsonDueDate.isTextual()) {
      maybeDueDate = Optional.of(LocalDate.ofInstant(Instant.parse(jsonDueDate.asText()), ZoneId.of("America/Chicago")));
    }
    Optional<String> userDescription = getStringMember(node, "filing_description");
    Optional<String> filingRefNum = getStringMember(node, "reference_number");
    Optional<String> filingAttorney = getStringMember(node, "filing_attorney");
    String filingComment = getStringDefault(node, "filing_comment", "");
      
    List<String> courtesyCopies = getMemberList(node, "courtesy_copies");
    List<String> preliminaryCopies = getMemberList(node, "preliminary_copies");
    List<String> filingParties = getMemberList(node, "filing_parties");

    Optional<String> actionStr = getStringMember(node, "filing_action");
    Optional<FilingTypeType> action = Optional.empty(); 
    if (actionStr.isPresent()) {
      String s = actionStr.get();
      if (s.equalsIgnoreCase("e_file") || s.equalsIgnoreCase("efile")) {
        action = Optional.of(FilingTypeType.E_FILE);
      } else if (s.equalsIgnoreCase("efile_and_serve") || s.equalsIgnoreCase("e_file_and_serve")) {
        action = Optional.of(FilingTypeType.E_FILE_AND_SERVE);
      } else if (s.equalsIgnoreCase("serve")) {
        action = Optional.of(FilingTypeType.SERVE);
      } else {
        log.warn("Filing Action " + s + " isn't an allowed action, defaulting to default action for the operation");
      }
    }
    List<PartyId> fullParties = filingParties.stream().map(fp -> {
      if (varToPartyId.containsKey(fp)) {
        log.info("Filing party id in doc: " + fp + ": " + varToPartyId.get(fp));
        return varToPartyId.get(fp);
      } 
      log.info("Existing filing party id in doc: " + fp);
      return PartyId.Already(fp);
    }).collect(Collectors.toList());
      
      
    fj.data.List<FilingAttachment> attachments = fj.data.List.nil();
    if (node.has("tyler_merge_attachments") && node.get("tyler_merge_attachments").asBoolean(false)) {
      log.info(userDescription.orElse(filingComment) + " indicated that we should only use the parent document; skipping parsing child elements");
    } else {
      if (node.has("elements") && node.get("elements").isArray()) {
        Iterable<JsonNode> nodes = node.get("elements")::elements;
        System.out.println("In multi attachments");
        for (var attachNode : nodes) {
          var maybeAttachment = getAttachment(attachNode, collector);
          if (maybeAttachment.isPresent()) {
            attachments = attachments.snoc(maybeAttachment.get());
          }
        }
      }
    }
    if (attachments.isEmpty()) {
      System.out.println("In no attachments");
      Optional<FilingAttachment> attachment = getAttachment(node, collector);
      if (attachment.isPresent()) {
        attachments = fj.data.List.single(attachment.get());
      }
    }
    Option<NonEmptyList<FilingAttachment>> goodAttachments = NonEmptyList.<FilingAttachment>fromList(attachments);
    if (goodAttachments.isNone()) {
      FilingError err = FilingError.malformedInterview("the document needs to be a bundle and have sub documents, each with a PDF URL, or needs to have that info itself");
      collector.error(err);
    }
    return Optional.of(
        new FilingDoc(filingType, 
            userDescription,
            filingRefNum,
            maybeDueDate,
            fullParties,
            filingAttorney,
            goodAttachments.some(),
            filingComment,
            motionName,
            optServices,
            courtesyCopies,
            preliminaryCopies,
            action,
            isLeadDoc));
  }
  
  private static Optional<FilingAttachment> getAttachment(JsonNode node, InfoCollector collector) throws FilingError {
    String documentTypeFormatName = getStringDefault(node, "document_type", "");
    String filingComponentCode = getStringDefault(node, "filing_component", "");
    JsonNode filenameNode = node.get("filename");
    if (filenameNode == null || !filenameNode.isTextual()) {
      InterviewVariable nameVar = collector.requestVar("filename", "The file name of the filing document", "text");
      collector.addRequired(nameVar);
    }
    String fileName = filenameNode.asText("");
    if (!fileName.endsWith(".pdf")) {
      fileName += ".pdf";
    }
    if (!node.has("proxy_enabled") || !node.get("proxy_enabled").asBoolean(false)) {
      log.info(fileName + " isn't proxy enabled");
      return Optional.empty();
    }
    
    if (!node.has("data_url") || !node.get("data_url").isTextual() || node.get("data_url").asText("").isBlank()) {
      collector.error(FilingError.malformedInterview("Refusing to parse filing without data_url"));
    }
    String dataUrl = node.get("data_url").asText();
    if (!(dataUrl.startsWith("http://") || dataUrl.startsWith("https://"))) {
      collector.error(malformedInterview(
          "Refusing non-HTTP schemas (needs to start with 'http://' or 'https://', was actually " + dataUrl + ")"));
    }
    // Difficult to hardcode more SSRF solutions, since deployment can be varied. Can't block local network / 
    // localhost, since things could be on the same server / network. TODO: inject an allow-list into here somehow
    try {
      URL inUrl = new URL(dataUrl); 
      
      HttpURLConnection conn = (HttpURLConnection) inUrl.openConnection();
      conn.setRequestMethod("GET");
      conn.setConnectTimeout(15000); // set connection timeout (not read timeout) in milliseconds
      InputStream inStream = conn.getInputStream();
      if (inStream == null) {
        FilingError err = serverError("Couldn't connect to " + inUrl.toString());
        collector.error(err);
      }
      
      return Optional.of(
          new FilingAttachment(fileName,
              inStream.readAllBytes(),
              documentTypeFormatName,
              filingComponentCode)); 
    } catch (MalformedURLException ex) {
      FilingError err = serverError("MalformedURLException trying to parse the data_url (" + dataUrl + "): " + ex);
      collector.error(err);
      throw err;
    } catch (IOException ex)  {
      FilingError err = serverError("IOException trying to connect to data_url (" + dataUrl + "):" + ex);
      collector.error(err);
      throw err;
    }
  }
}
