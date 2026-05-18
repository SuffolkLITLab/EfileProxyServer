package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.utils.FilingError.malformedInterview;
import static edu.suffolk.litlab.efsp.utils.FilingError.serverError;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getIntMember;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getMemberList;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getNonEmptyStringMember;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getNumberMember;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringDefault;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringMember;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.model.FilingAction;
import edu.suffolk.litlab.efsp.model.FilingAttachment;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.InputOptionalService;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import edu.suffolk.litlab.efsp.utils.JsonHelpers;
import fj.data.NonEmptyList;
import fj.data.Option;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilingDocDocassembleJacksonDeserializer {
  private static Logger log =
      LoggerFactory.getLogger(FilingDocDocassembleJacksonDeserializer.class);

  /** Parses a filing from the DA Json Object. Used by Deserializers that include filings. */
  public static Optional<FilingDoc> fromNode(
      JsonNode node,
      Map<String, PartyId> varToPartyId,
      int sequenceNum,
      List<FilingCode> filingOptions,
      CodesParser parser,
      InfoCollector collector)
      throws FilingError {
    if (!node.isObject()) {
      FilingError err =
          malformedInterview(
              "Refusing to parse filing doc that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
    }

    if (!node.has("proxy_enabled") || !node.get("proxy_enabled").asBoolean(false)) {
      log.info("Filing doc isn't proxy enabled, won't parse it or attachments");
      return Optional.empty();
    }
    Optional<String> filingStr = JsonHelpers.getStringMember(node, "filing_type");
    var filingRes = parser.vetFilingType(filingStr, filingOptions);
    var name = (node.has("instanceName")) ? node.get("instanceName").asText("?") : "?";
    var filingBuilder =
        collector.varBuilder().name("filing_type").description("What filing type is this?" + name);
    if (filingRes.isErr()) {
      collector.addCodeError(filingRes.unwrapErrOrElseThrow(), filingBuilder);
    } else if (filingRes.unwrapOrElseThrow().isEmpty()) {
      collector.addOptional(filingBuilder.build());
    }
    var filingType = filingRes.unwrapOrElseThrow();

    Optional<String> motionName = getStringMember(node, "motion_type");
    var motionBuilder = collector.varBuilder().name("motion_type").description("(optional)");
    var motionRes = parser.vetMotionCode(motionName, filingType);
    if (motionRes.isErr()) {
      collector.addCodeError(motionRes.expectErr(""), motionBuilder);
    }
    var motionCode = motionRes.expect("");

    List<OptionalService> optServices = new ArrayList<>();
    Optional<JsonNode> maybeOptServs = JsonHelpers.unwrapDAList(node.get("optional_services"));
    if (maybeOptServs.isPresent()) {
      var optServs = maybeOptServs.get();
      List<InputOptionalService> inputOpts = new ArrayList<>();
      optServs
          .elements()
          .forEachRemaining(
              optServ -> {
                String code = optServ.get("code").asText();
                Optional<Integer> mult = getIntMember(optServ, "multiplier");
                Optional<BigDecimal> fee = getNumberMember(optServ, "fee_amount");
                inputOpts.add(new InputOptionalService(code, mult, fee));
              });
      var res = parser.vetOptionalServices(inputOpts, filingType);
      if (res.isErr()) {
        var varBuilder = collector.varBuilder().name("optional_services");
        var errors = res.expectErr("");
        for (var error : errors) {
          collector.addCodeError(error, varBuilder);
        }
      } else {
        optServices = res.expect("");
      }
    }

    JsonNode jsonDueDate = node.get("due_date");
    Optional<LocalDate> maybeDueDate = Optional.empty();
    if (jsonDueDate != null && jsonDueDate.isTextual()) {
      maybeDueDate =
          Optional.of(
              LocalDate.ofInstant(
                  // TODO(brycew): why do we even pass this as a date time? Shouldn't it just be a
                  // date?
                  Instant.parse(jsonDueDate.asText()), ZoneId.of("America/Chicago")));
    }
    String userDescription = getStringDefault(node, "filing_description", "");
    Optional<String> filingRefNum = getStringMember(node, "reference_number");
    Optional<String> filingAttorney = getNonEmptyStringMember(node, "filing_attorney");
    String filingComment = getStringDefault(node, "filing_comment", "");

    String _logName =
        (userDescription.isBlank()) ? filingStr.orElse(filingComment) : userDescription;

    List<String> courtesyCopies = getMemberList(node, "courtesy_copies");
    List<String> preliminaryCopies = getMemberList(node, "preliminary_copies");
    List<String> filingParties = getMemberList(node, "filing_parties");

    Optional<String> actionStr = getStringMember(node, "filing_action");
    Optional<FilingAction> action = Optional.empty();
    if (actionStr.isPresent()) {
      String s = actionStr.get();
      if (s.equalsIgnoreCase("e_file") || s.equalsIgnoreCase("efile")) {
        action = Optional.of(FilingAction.E_FILE);
      } else if (s.equalsIgnoreCase("efile_and_serve") || s.equalsIgnoreCase("e_file_and_serve")) {
        action = Optional.of(FilingAction.E_FILE_AND_SERVE);
      } else if (s.equalsIgnoreCase("serve")) {
        action = Optional.of(FilingAction.SERVE);
      } else {
        log.warn(
            "Filing Action "
                + s
                + " isn't an allowed action, defaulting to default action for the operation");
      }
    }
    List<PartyId> fullParties =
        filingParties.stream()
            .map(
                fp -> {
                  if (varToPartyId.containsKey(fp)) {
                    log.info("Filing party id in {}: {}: {}", _logName, fp, varToPartyId.get(fp));
                    return varToPartyId.get(fp);
                  }
                  log.info("Existing filing party id in doc: {}", fp);
                  return PartyId.Already(fp);
                })
            .collect(Collectors.toList());
    var components = new ArrayList<FilingComponent>(parser.retrieveFilingComponents(filingType));
    fj.data.List<FilingAttachment> attachments = fj.data.List.nil();
    if (node.has("tyler_merge_attachments")
        && node.get("tyler_merge_attachments").asBoolean(false)) {
      log.info(
          "{} indicated that we should only use the parent document; skipping parsing child"
              + " elements",
          _logName);
    } else {
      if (node.has("elements") && node.get("elements").isArray()) {
        Iterable<JsonNode> nodes = node.get("elements")::elements;
        int idx = 0;
        for (var attachNode : nodes) {
          collector.pushAttributeStack(".elements[" + idx + "]");
          // TODO(brycew): I don't like orElse(null), but unsure how to handle optional filing codes
          // yet? Revisit with Alaska's stuff
          var maybeAttachment =
              getAttachment(attachNode, components, filingType.orElse(null), parser, collector);
          if (maybeAttachment.isPresent()) {
            attachments = attachments.snoc(maybeAttachment.get());
          }
          collector.popAttributeStack();
          idx += 1;
        }
      }
    }
    if (attachments.isEmpty()) {
      log.info("No attachments present in {}", _logName);
      Optional<FilingAttachment> attachment =
          getAttachment(node, components, filingType.orElse(null), parser, collector);
      if (attachment.isPresent()) {
        attachments = fj.data.List.single(attachment.get());
      }
    }
    Option<NonEmptyList<FilingAttachment>> goodAttachments =
        NonEmptyList.<FilingAttachment>fromList(attachments);
    if (goodAttachments.isNone()) {
      log.warn(
          "The {}"
              + " document doesn't have sub documents / PDFs. It's possible that the document was"
              + " turned off at runtime.",
          _logName);
      return Optional.empty();
    }
    return Optional.of(
        new FilingDoc(
            filingType,
            userDescription,
            filingRefNum,
            maybeDueDate,
            fullParties,
            filingAttorney,
            goodAttachments.some(),
            filingComment,
            motionCode,
            optServices,
            courtesyCopies,
            preliminaryCopies,
            action,
            sequenceNum));
  }

  private static Optional<FilingAttachment> getAttachment(
      JsonNode node,
      ArrayList<FilingComponent> components,
      FilingCode filingCode,
      CodesParser parser,
      InfoCollector collector)
      throws FilingError {
    String documentTypeFormatName = getStringDefault(node, "document_type", "");
    var documentTypeRes = parser.vetDocType(documentTypeFormatName, filingCode);
    var documentBuilder = collector.varBuilder().name("document_type");
    if (documentTypeRes.isErr()) {
      var documentVar = collector.addCodeError(documentTypeRes.expectErr(""), documentBuilder);
      throw FilingError.wrongValue(documentVar);
    }
    var documentType = documentTypeRes.expect("");

    String filingComponentCode = getStringDefault(node, "filing_component", "");
    var componentRes = parser.vetFilingComponent(filingComponentCode, components);
    var componentBuilder =
        collector
            .varBuilder()
            .name("filing_component")
            .description("Filing component: Lead or attachment");
    if (componentRes.isErr()) {
      var componentVar = collector.addCodeError(componentRes.expectErr(""), componentBuilder);
      // I don't care, throw.
      throw FilingError.wrongValue(componentVar);
    }
    // TODO: use this default fallback?
    // new FilingComponent("NO CODE", "NOT PRESENT", "", false, false, 0, "", "");
    var filingComponent = componentRes.expect("");
    JsonNode filenameNode = node.get("filename");
    if (filenameNode == null || !filenameNode.isTextual()) {
      InterviewVariable nameVar =
          collector.requestVar("filename", "The file name of the filing document", "text");
      collector.addRequired(nameVar);
      filenameNode = NullNode.getInstance();
    }
    String fileName = (filenameNode != null) ? filenameNode.asText("") : "";
    if (!fileName.endsWith(".pdf")) {
      fileName += ".pdf";
    }
    String documentDescription = getStringDefault(node, "document_description", fileName);
    if (!node.has("proxy_enabled") || !node.get("proxy_enabled").asBoolean(false)) {
      log.info("{} isn't proxy enabled", fileName);
      return Optional.empty();
    }

    if (!node.has("data_url")
        || !node.get("data_url").isTextual()
        || node.get("data_url").asText("").isBlank()) {
      collector.error(FilingError.malformedInterview("Refusing to parse filing without data_url"));
    }
    String dataUrl = node.get("data_url").asText();
    if (!(dataUrl.startsWith("http://") || dataUrl.startsWith("https://"))) {
      collector.error(
          malformedInterview(
              "Refusing non-HTTP schemas (needs to start with 'http://' or 'https://', was actually"
                  + " "
                  + dataUrl
                  + ")"));
    }
    // Difficult to hardcode more SSRF solutions, since deployment can be varied. Can't block local
    // network /
    // localhost, since things could be on the same server / network. TODO: inject an allow-list
    // into here somehow
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
          new FilingAttachment(
              fileName,
              (inStream != null) ? inStream.readAllBytes() : new byte[0],
              documentType,
              filingComponent,
              documentDescription));
    } catch (MalformedURLException ex) {
      FilingError err =
          serverError(
              "MalformedURLException trying to parse the data_url (" + dataUrl + "): " + ex);
      collector.error(err);
      throw err;
    } catch (IOException ex) {
      FilingError err =
          serverError("IOException trying to connect to data_url (" + dataUrl + "):" + ex);
      collector.error(err);
      throw err;
    }
  }
}
