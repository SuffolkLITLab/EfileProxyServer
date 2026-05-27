package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.docassemble.FilingDocDocassembleJacksonDeserializer.fromNode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.OptionalServiceCode;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.tyler.TylerCodesParser;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class FilingDocDocassembleJacksonDeserializerTest {

  // TODO in original source file:
  // - don't concat in logs (use {} and params.)
  // - put as many of the json object reading stuff into dto objects as we can (much more readable).
  // - better names, etc.
  // - FilingError should take exceptions as an object, not just concatted to a string.

  // TODO: more tests FilingAttachment separately, if possible

  InfoCollector collector;
  Map<String, PartyId> varToPartyId;
  List<FilingCode> filingCodes =
      List.of(
          new FilingCode("6553", "idk", "0", "", "", "", false, "", "", "", false, false, "", ""));
  CodesParser parser;

  @BeforeEach
  public void setUp() {
    collector = new FailFastCollector();
    varToPartyId = Map.of("users[0]", PartyId.CurrentFilingNew("abc"));
    CodeDatabase cd = mock(CodeDatabase.class);
    when(cd.getOptionalServices("adams", "6553"))
        .thenReturn(
            List.of(new OptionalServiceCode("1234", null, 0, null, null, false, null, true, null)));
    when(cd.getFilingComponents("adams", "6553"))
        .thenReturn(List.of(new FilingComponent("332", null, null, false, true, 0, null, null)));
    when(cd.getDocumentTypes("adams", "6553"))
        .thenReturn(
            List.of(
                new DocumentTypeTableRow("6586", "idk", "6553", "false", "false", "", "adams"),
                new DocumentTypeTableRow("7788", "idk 2", "6553", "false", "false", "", "adams")));
    var dataFields =
        new DataFields(
            List.of(
                Map.of(
                    "DocumentType",
                    new DataFieldRow("DocumentType", "Document Type", true, false, "adams"))));
    parser = new TylerCodesParser(cd, new CourtLocationInfo("adams"), dataFields);
  }

  @Test
  public void testWeirdJsonShouldBeEmpty()
      throws JsonMappingException, JsonProcessingException, FilingError {
    ObjectMapper m = new ObjectMapper();
    assertThatThrownBy(
            () -> fromNode(m.readTree("null"), varToPartyId, 0, filingCodes, parser, collector))
        .isInstanceOf(FilingError.class);
    assertThatThrownBy(
            () -> fromNode(m.readTree("[]"), varToPartyId, 0, filingCodes, parser, collector))
        .isInstanceOf(FilingError.class);
    var doc = fromNode(m.readTree("{}"), varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isEmpty();
  }

  // Aka, the old style
  @Test
  public void noAttachmentsShouldLoadDocument() throws FilingError, IOException {
    JsonNode node = readFile("old_style_doc.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("6586");
  }

  @Test
  public void oneAttachmentShouldLoadDocument() throws FilingError, IOException {
    JsonNode node = readFile("one_attachment.json");
    var maybeDoc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(maybeDoc).isPresent();
    var doc = maybeDoc.get();
    assertThat(doc.getFilingCode()).isEqualTo(filingCodes.get(0));
    assertThat(doc.sequenceNum()).isEqualTo(0);
    var attachments = doc.getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("6586");
    var parties = doc.getFilingPartyIds();
    assertThat(parties.size()).isEqualTo(1);
    assertThat(parties.get(0).isNewInCurrentFiling()).isTrue();
    assertThat(doc.getDescription()).isPresent();
    assertThat(doc.getDescription().get().get())
        .isEqualTo("The Motion to Stay Eviction for Bob Ma");
  }

  @Test
  public void oneAttachmentAsSecondSequenceShouldLoadDocument() throws FilingError, IOException {
    JsonNode node = readFile("one_attachment.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 2, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    assertThat(doc.get().sequenceNum()).isEqualTo(2);
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("6586");
    var parties = doc.get().getFilingPartyIds();
    assertThat(parties.size()).isEqualTo(1);
    assertThat(parties.get(0).isNewInCurrentFiling()).isTrue();
  }

  @Test
  public void partyIdNotPresent() throws IOException, FilingError {
    JsonNode node = readFile("one_attachment.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, Map.of(), 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var parties = doc.get().getFilingPartyIds();
    assertThat(parties.size()).isEqualTo(1);
    assertThat(parties.get(0).isAlreadyInCase()).isTrue();
  }

  @Test
  public void oneEnabledOneDisabledShouldLoadOneAttachment() throws FilingError, IOException {
    JsonNode node = readFile("one_enabled_one_disabled.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("6586");
  }

  @Test
  public void noEnabledShouldFilingError() throws IOException, FilingError {
    JsonNode node = readFile("fail_no_enabled_attachment.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).as("Document shouldn't have parsed").isEmpty();
  }

  @Test
  public void shouldFallbackToParentDocIfNoEnabled() throws FilingError, IOException {
    JsonNode node = readFile("fallback_to_upper_doc.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("6586");
    assertThat(attachments.head().getFileName()).isEqualTo("motion_to_stay_eviction.pdf");
  }

  @Test
  public void noDocTypesShouldFail() throws IOException, FilingError {
    JsonNode node = readFile("fail_missing_doc_types.json");
    try {
      FilingDocDocassembleJacksonDeserializer.fromNode(
          node, varToPartyId, 0, filingCodes, parser, collector);
      fail("Should have thrown a filing error, didn't");
    } catch (FilingError err) {
      assertThat(err.getType()).isEqualTo(FilingError.Type.WrongValue);
    }
  }

  @Test
  public void twoAttachmentsShouldLoadTwoAttachments() throws FilingError, IOException {
    JsonNode node = readFile("two_attachments.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(2);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("6586");
    assertThat(attachments.head().getFileName()).isEqualTo("motion-to-stay-eviction.pdf");
    assertThat(attachments.tail().head().getFileName()).isEqualTo("exhibits.pdf");
  }

  // TODO: use readTemplate to test has_optional_services.json, with various numbers in place of
  // fee amount.
  @Test
  public void hasOptionalServicesShouldParse() throws FilingError, IOException {
    JsonNode node = readFile("has_optional_services.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var optionalServices = doc.get().getOptionalServices();
    assertThat(optionalServices).hasSize(1);
    assertThat(optionalServices.get(0).feeAmount()).contains(new BigDecimal("12.54"));
  }

  @Test
  public void filingActionShouldAlwaysParse() throws IOException, FilingError {
    for (var emptyData : List.of("null", "\"\"", "\"clearly_wrong\"")) {
      JsonNode node = readTemplate("template_filing_action.json", emptyData);
      var doc =
          FilingDocDocassembleJacksonDeserializer.fromNode(
              node, varToPartyId, 0, filingCodes, parser, collector);
      assertThat(doc).isPresent();
      assertThat(doc.get().getFilingAction()).isEmpty();
    }
    for (var data :
        List.of(
            "\"efile\"",
            "\"e_file\"",
            "\"efile_and_serve\"",
            "\"e_file_and_serve\"",
            "\"serve\"")) {
      JsonNode node = readTemplate("template_filing_action.json", data);
      var doc =
          FilingDocDocassembleJacksonDeserializer.fromNode(
              node, varToPartyId, 0, filingCodes, parser, collector);
      assertThat(doc).isPresent();
      assertThat(doc.get().getFilingAction()).isPresent();
    }
  }

  @Test
  public void testTylerMergeAttachments() throws IOException, FilingError {
    JsonNode node = readFile("tyler_merge_attachments.json");
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 0, filingCodes, parser, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isPresent();
    assertThat(attachments.head().getDocumentTypeFormatStandardName().get().code).isEqualTo("7788");
    assertThat(attachments.head().getFileName())
        .isEqualTo("motion-to-stay-eviction-root-object.pdf");
  }

  @Nested
  @DisplayName("Handling `due_date`")
  class ForDueDate {
    final String INPUT_FILE = "template_due_date.json";

    @Test
    public void validDueDateShouldParse() throws IOException, FilingError {
      record InputSaved(String dateInput, String savedDate) {}
      for (var testData :
          List.of(
              new InputSaved("\"2023-11-11T16:00:00.000Z\"", "2023-11-11"),
              new InputSaved("\"2024-02-29T10:19:00.123Z\"", "2024-02-29"),
              // TODO: weird behavior: local date parses based on server's timezone? Should fix
              new InputSaved("\"2024-02-29T01:19:00.123Z\"", "2024-02-28"))) {
        JsonNode node = readTemplate(INPUT_FILE, testData.dateInput);
        var doc =
            FilingDocDocassembleJacksonDeserializer.fromNode(
                node, varToPartyId, 0, filingCodes, parser, collector);
        assertThat(doc).isPresent();
        assertThat(doc.get().getDueDate()).isPresent();
        assertThat(doc.get().getDueDate().get()).isEqualTo(testData.savedDate);
      }
    }

    @Test
    public void nonTextDueDateShouldBeEmpty() throws IOException, FilingError {
      for (var emptyData :
          List.of(
              "null", "20231111" // just an int
              )) { // TODO(brycew): Should also include an empty and blank string, but those error
        // right now
        JsonNode node = readTemplate(INPUT_FILE, emptyData);
        var doc =
            FilingDocDocassembleJacksonDeserializer.fromNode(
                node, varToPartyId, 0, filingCodes, parser, collector);
        assertThat(doc).isPresent();
        assertThat(doc.get().getDueDate()).isEmpty();
      }
    }

    // TODO(brycew): this behavior should be changed to not throw Parse errors
    @Test
    public void invalidDueDateShouldThrow() throws IOException, FilingError {
      for (var badData :
          List.of(
              "\"\"",
              "\" \"",
              "\"2023-11-11\"",
              "\"2023-11-34T01:00:00.000Z\"",
              "\"2023-11-11T26:00:00.000Z\"",
              "\"2023-11-11T16:00:;00.123+01:00\"")) {
        JsonNode node = readTemplate(INPUT_FILE, badData);
        assertThatThrownBy(
                () ->
                    FilingDocDocassembleJacksonDeserializer.fromNode(
                        node, varToPartyId, 0, filingCodes, parser, collector))
            .withFailMessage("Failed on %s", badData)
            .isInstanceOf(DateTimeParseException.class);
      }
    }
  }

  @Nested
  @DisplayName("Handling `data_url`")
  class ForDataUrl {
    final String INPUT_FILE = "template_data_url.json";

    @Test
    public void testMalformedDataUrlShouldThrow() throws IOException {
      for (var badData :
          List.of(
              "",
              "ftp://example.com/sample.pdf",
              "http://example.com,/sample.pdf",
              "http://example.com,/sample.pdf?with_val=abc\\\"def")) {
        JsonNode node = readTemplate(INPUT_FILE, badData);
        assertThatThrownBy(
                () ->
                    FilingDocDocassembleJacksonDeserializer.fromNode(
                        node, varToPartyId, 0, filingCodes, parser, collector))
            .withFailMessage("Using %s", badData)
            .isInstanceOf(FilingError.class);
      }
    }
  }

  private JsonNode readFile(String jsonFile) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/" + jsonFile));
  }

  private JsonNode readTemplate(String jsonFile, Object... args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    var inputStream = this.getClass().getResourceAsStream("/filingdocs/" + jsonFile);
    var templateString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8.name());
    return mapper.readTree(templateString.formatted(args));
  }
}
