package edu.suffolk.litlab.efspserver.docassemble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
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

  Optional<FilingDoc> doc;
  InfoCollector collector;
  Map<String, PartyId> varToPartyId;
  
  @BeforeEach
  public void setUp() {
    collector = new FailFastCollector();
    varToPartyId = Map.of("users[0]", PartyId.CurrentFilingNew("abc"));
  }
  
  @Test
  public void oldStyleShouldLoadDocument() throws FilingError, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/old_style_doc.json"));
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertTrue(doc.isPresent());
    assertEquals(doc.get().getFilingAttachments().length(), 1);
    assertEquals("6586", doc.get().getFilingAttachments().head().getDocumentTypeFormatStandardName());
  }
  
  @Test
  public void oneAttachmentShouldLoadDocument() throws FilingError, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/one_attachment.json"));
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertTrue(doc.isPresent());
    assertEquals(doc.get().getFilingAttachments().length(), 1);
    assertEquals("6586", doc.get().getFilingAttachments().head().getDocumentTypeFormatStandardName());
  }

  @Test
  public void oneEnabledOneDisabledShouldLoadOneAttachment() throws FilingError, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/one_enabled_one_disabled.json"));
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertTrue(doc.isPresent());
    assertEquals(doc.get().getFilingAttachments().length(), 1);
    assertEquals("6586", doc.get().getFilingAttachments().head().getDocumentTypeFormatStandardName());
  }
  
  @Test
  public void noEnabledShouldFilingError() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/fail_no_enabled_attachment.json"));
    try {
      doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
      assertTrue("Document shouldn't have parsed!", doc.isEmpty());
    } catch (FilingError err) {
      // okay
    }
  }

  @Test
  public void shouldFallbackToParentDocIfNoEnabled() throws FilingError, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/fallback_to_upper_doc.json"));
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertTrue(doc.isPresent());
    assertEquals(doc.get().getFilingAttachments().length(), 1);
    assertEquals("6586", doc.get().getFilingAttachments().head().getDocumentTypeFormatStandardName());
    assertEquals("motion_to_stay_eviction.pdf", doc.get().getFilingAttachments().head().getFileName());
  }
  
  @Test
  public void noDocTypesShouldBeEmptyStrings() throws IOException, FilingError {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/fail_missing_doc_types.json"));
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertTrue(doc.isPresent());
    assertEquals(doc.get().getFilingAttachments().length(), 1);
    assertEquals("", doc.get().getFilingAttachments().head().getDocumentTypeFormatStandardName());
  }

  @Test
  public void twoAttachmentsShouldLoadTwoAttachments() throws FilingError, IOException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/two_attachments.json"));
    doc = FilingDocDocassembleJacksonDeserializer.fromNode(node, varToPartyId, true, collector);
    assertTrue(doc.isPresent());
    assertEquals(2, doc.get().getFilingAttachments().length());
    assertEquals("6586", doc.get().getFilingAttachments().head().getDocumentTypeFormatStandardName());
    assertEquals("motion-to-stay-eviction.pdf", doc.get().getFilingAttachments().head().getFileName());
    assertEquals("exhibits.pdf", doc.get().getFilingAttachments().tail().head().getFileName());
  }
  
}
