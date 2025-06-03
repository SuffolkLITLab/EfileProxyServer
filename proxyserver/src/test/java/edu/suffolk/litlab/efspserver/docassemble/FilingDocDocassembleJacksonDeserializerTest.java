package edu.suffolk.litlab.efspserver.docassemble;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;

public class FilingDocDocassembleJacksonDeserializerTest {

  // TODO in original source file:
  // - don't concat in logs
  // - put as many of the json object reading stuff into dto objects as we can (much more readable).
  // - better names, etc.
  // - FilingError should take exceptions as an object, not just concatted to a string.

  Optional<FilingDoc> doc;
  InfoCollector collector;
  Map<String, PartyId> varToPartyId;

  private ObjectMapper mapper = new ObjectMapper();
  
  @BeforeEach
  public void setUp() {
    collector = new FailFastCollector();
    varToPartyId = Map.of("users[0]", PartyId.CurrentFilingNew("abc"));
  }
  
  @Test
  public void oldStyleShouldLoadDocument() throws FilingError, IOException {
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
    assertThat(attachments.length()).isEqualTo( 1);
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

  @Test
  public void hasOptionalServicesShouldParse() throws FilingError, IOException {
    JsonNode node = readFile("has_optional_services.json");
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertThat(doc).isPresent();
    var optionalServices = doc.get().getOptionalServices();
    assertThat(optionalServices).hasSize(1);
    assertThat(optionalServices.get(0).feeAmount).contains(new BigDecimal("12.54"));
  }


  // TODO: test parsing due date
  //    sub-TODO: pass in timezone for due date (is it the court's timezone, or end-user's timezone)
  @Test
  public void validDueDateShouldParse() {}

  @Test
  public void invalidDueDateShouldThrow() {}

  // TODO: parsing different versions of FilingAction
  @Test
  public void filingActionShouldAlwaysParse() {}

  // TODO: test different combos of varToPartyId
  @Test
  public void partyIdNotPresent() {}

  // TODO: test tyler_merge_attachments
  @Test
  public void testTylerMergeAttachments() {}

  // TODO: test no attachments at all (instead of just proxy_enabled=false, just not there)
  @Test
  public void noAttachmentsShouldBeEmpty() {}

  // TODO: test FilingAttachment separately, if possible

  private JsonNode readFile(String jsonFile) throws IOException {
    return mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/" + jsonFile));
  }

  // TODO: use this function to test has_optional_services.json, with various numbers in place of fee amount.
  private JsonNode readTemplate(String jsonFile, Object... args) throws IOException {
    var inputStream = this.getClass().getResourceAsStream("/filingdocs/" + jsonFile);
    var templateString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8.name());
    return mapper.readTree(templateString.formatted(args));
  }
}
