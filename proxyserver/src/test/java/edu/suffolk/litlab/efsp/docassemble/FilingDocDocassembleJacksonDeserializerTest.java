package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.docassemble.FilingDocDocassembleJacksonDeserializer.fromNode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

  Optional<FilingDoc> doc;
  InfoCollector collector;
  Map<String, PartyId> varToPartyId;

  @BeforeEach
  public void setUp() {
    collector = new FailFastCollector();
    varToPartyId = Map.of("users[0]", PartyId.CurrentFilingNew("abc"));
  }

  @Test
  public void testWeirdJsonShouldBeEmpty()
      throws JsonMappingException, JsonProcessingException, FilingError {
    ObjectMapper m = new ObjectMapper();
    assertThatThrownBy(() -> fromNode(m.readTree("null"), varToPartyId, true, collector))
        .isInstanceOf(FilingError.class);
    assertThatThrownBy(() -> fromNode(m.readTree("[]"), varToPartyId, true, collector))
        .isInstanceOf(FilingError.class);
    doc = fromNode(m.readTree("{}"), varToPartyId, true, collector);
    assertThat(doc).isEmpty();
  }

  // Aka, the old style
  @Test
  public void noAttachmentsShouldLoadDocument() throws FilingError, IOException {
    JsonNode node = readFile("old_style_doc.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEqualTo("6586");
  }

  @Test
  public void oneAttachmentShouldLoadDocument() throws FilingError, IOException {
    JsonNode node = readFile("one_attachment.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEqualTo("6586");
    var parties = doc.get().getFilingPartyIds();
    assertThat(parties.size()).isEqualTo(1);
    assertThat(parties.get(0).isNewInCurrentFiling()).isTrue();
  }

  @Test
  public void partyIdNotPresent() throws IOException, FilingError {
    JsonNode node = readFile("one_attachment.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, Map.of(), true, collector);
    assertThat(doc).isPresent();
    var parties = doc.get().getFilingPartyIds();
    assertThat(parties.size()).isEqualTo(1);
    assertThat(parties.get(0).isAlreadyInCase()).isTrue();
  }

  @Test
  public void oneEnabledOneDisabledShouldLoadOneAttachment() throws FilingError, IOException {
    JsonNode node = readFile("one_enabled_one_disabled.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEqualTo("6586");
  }

  @Test
  public void noEnabledShouldFilingError() throws IOException, FilingError {
    JsonNode node = readFile("fail_no_enabled_attachment.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).as("Document shouldn't have parsed").isEmpty();
  }

  @Test
  public void shouldFallbackToParentDocIfNoEnabled() throws FilingError, IOException {
    JsonNode node = readFile("fallback_to_upper_doc.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEqualTo("6586");
    assertThat(attachments.head().getFileName()).isEqualTo("motion_to_stay_eviction.pdf");
  }

  @Test
  public void noDocTypesShouldBeEmptyStrings() throws IOException, FilingError {
    JsonNode node = readFile("fail_missing_doc_types.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEmpty();
  }

  @Test
  public void twoAttachmentsShouldLoadTwoAttachments() throws FilingError, IOException {
    JsonNode node = readFile("two_attachments.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(2);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEqualTo("6586");
    assertThat(attachments.head().getFileName()).isEqualTo("motion-to-stay-eviction.pdf");
    assertThat(attachments.tail().head().getFileName()).isEqualTo("exhibits.pdf");
  }

  // TODO: use readTemplate to test has_optional_services.json, with various numbers in place of
  // fee amount.
  @Test
  public void hasOptionalServicesShouldParse() throws FilingError, IOException {
    JsonNode node = readFile("has_optional_services.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var optionalServices = doc.get().getOptionalServices();
    assertThat(optionalServices).hasSize(1);
    assertThat(optionalServices.get(0).feeAmount).contains(new BigDecimal("12.54"));
  }

  @Test
  public void filingActionShouldAlwaysParse() throws IOException, FilingError {
    for (var emptyData : List.of("null", "\"\"", "\"clearly_wrong\"")) {
      JsonNode node = readTemplate("template_filing_action.json", emptyData);
      doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
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
      doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
      assertThat(doc).isPresent();
      assertThat(doc.get().getFilingAction()).isPresent();
    }
  }

  @Test
  public void testTylerMergeAttachments() throws IOException, FilingError {
    JsonNode node = readFile("tyler_merge_attachments.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var attachments = doc.get().getFilingAttachments();
    assertThat(attachments.length()).isEqualTo(1);
    assertThat(attachments.head().getDocumentTypeFormatStandardName()).isEqualTo("7788");
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
        doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
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
        doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
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
                        node, varToPartyId, true, collector))
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
                        node, varToPartyId, true, collector))
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
