package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.docassemble.PersonDocassembleJacksonDeserializer.fromNode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.tyler.TylerCodesParser;
import edu.suffolk.litlab.efsp.utils.AllWrongCollector;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonDocassembleJacksonDeserializerTest {

  InfoCollector collector;
  CodesParser parser;
  DataFields allDataFields;

  @BeforeEach
  public void setUp() {
    collector = new FailFastCollector();
    var cd = mock(CodeDatabase.class);
    var allDataFields = mock(DataFields.class);
    when(cd.getDataFields("adams")).thenReturn(allDataFields);
    when(allDataFields.getFieldRow("PartyFirstName"))
        .thenReturn(new DataFieldRow("PartyFirstName", "", true, true, "adams"));
    when(allDataFields.getFieldRow("PartyMiddleName"))
        .thenReturn(new DataFieldRow("PartyMiddleName", "", true, false, "adams"));
    when(allDataFields.getFieldRow("PartyLastName"))
        .thenReturn(new DataFieldRow("PartyLastName", "", true, false, "adams"));
    when(allDataFields.getFieldRow("PartyPhone"))
        .thenReturn(new DataFieldRow("PartyPhone", "", true, false, "adams"));
    when(allDataFields.getFieldRow("PartyEmail"))
        .thenReturn(new DataFieldRow("PartyEmail", "", true, false, "adams"));
    when(allDataFields.getFieldRow("PartyNameSuffix"))
        .thenReturn(new DataFieldRow("PartyNameSuffix", "", false, false, "adams"));
    when(allDataFields.getFieldRow("PartyGender"))
        .thenReturn(new DataFieldRow("PartyGender", "", true, false, "adams"));
    parser = new TylerCodesParser(cd, new CourtLocationInfo("adams"));
  }

  @Test
  public void testShouldParseWithAllJsonFields() throws FilingError, IOException {
    JsonNode node = readFile("person_with_all.json");
    var res = fromNode(node, parser, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getContactInfo().getEmail()).contains("john.brown@example.com");
    assertThat(per.getContactInfo().getPhoneNumbers()).hasSize(2);
    assertThat(per.getContactInfo().getAddress())
        .isPresent(); // contains(new Address("123 Fake St", "", "Chicago", "IL", "60007",
    assertThat(per.getContactInfo().getAddress().get().getCity()).isEqualTo("Chicago");
    assertThat(per.getPartyId()).isEqualTo(PartyId.Already("abcd1234-1234-1234-1234-abcdabcd1234"));
    assertThat(per.getRole()).isPresent();
    assertThat(per.getRole().get()).isEqualTo("29738");
  }

  @Test
  public void testShouldParseWithMinimal() throws FilingError, IOException {
    JsonNode node = readFile("person_with_minimal.json");
    var res = fromNode(node, parser, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getName().getFirstName()).isEqualTo("John");
  }

  @Test
  public void testShouldParseWithExtraJson() throws FilingError, IOException {
    JsonNode node = readFile("person_with_extras.json");
    var res = fromNode(node, parser, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getContactInfo().getEmail()).contains("john.brown@example.com");
    assertThat(per.getContactInfo().getPhoneNumbers()).hasSize(1);
    assertThat(per.getContactInfo().getAddress())
        .isPresent(); // contains(new Address("123 Fake St", "", "Chicago", "IL", "60007",
    assertThat(per.getContactInfo().getAddress().get().getCity()).isEqualTo("Chicago");
    assertThat(per.getPartyId()).isEqualTo(PartyId.Already("abcd1234-1234-1234-1234-abcdabcd1234"));
    assertThat(per.getRole()).isPresent();
    assertThat(per.getRole().get()).isEqualTo("29738");
  }

  @Test
  public void testDontParseBadJson() throws FilingError, IOException {
    collector = new AllWrongCollector();
    assertThrows(FilingError.class, () -> fromNode(readString("\"abc\""), parser, collector));
    collector = new AllWrongCollector();
    assertThrows(FilingError.class, () -> fromNode(readString("[{}]"), parser, collector));
    collector = new AllWrongCollector();
    fromNode(readString("{\"abc\": \"def\"}"), parser, collector);
    assertThat(collector.getRequired()).hasSize(1); // only requires name
  }

  @Test
  public void testValidBirthDate() throws IOException, FilingError {
    var res =
        fromNode(readTemplate("person_birthdate_template.json", "2000-11-02"), parser, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getBirthdate()).isPresent();
    assertThat(per.getBirthdate().get()).isEqualTo("2000-11-02");
  }

  @Test
  public void testInvalidBirthDate() throws IOException, FilingError {
    var res =
        fromNode(readTemplate("person_birthdate_template.json", "2000-11-32"), parser, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getBirthdate()).isEmpty();
  }

  @Test
  public void testIsNewNotABoolean() throws FilingError, IOException {
    collector = new AllWrongCollector();
    fromNode(
        readTemplate("person_new_id.json", "\"abc\"", "\"this will fail\""), parser, collector);
    assertThat(collector.getWrong()).hasSize(1);
  }

  @Test
  public void testIsNewAndEfmId() throws FilingError, IOException {
    collector = new AllWrongCollector();
    fromNode(readTemplate("person_new_id.json", "\"abc\"", "true"), parser, collector);
    assertThat(collector.getWrong()).hasSize(1);
    assertThat(collector.getWrong().get(0).getDescription())
        .contains("EFM (tyler) ID on a brand new party to the case");
  }

  @Test
  public void testIsNotNewAndNoEfmId() throws FilingError, IOException {
    collector = new AllWrongCollector();
    fromNode(readTemplate("person_new_id.json", "null", "false"), parser, collector);
    assertThat(collector.getWrong()).hasSize(1);
    assertThat(collector.getWrong().get(0).getDescription())
        .contains("Can't be marked as not new, but not have an EFM ID");
  }

  private JsonNode readFile(String jsonFile) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(this.getClass().getResourceAsStream("/people/" + jsonFile));
  }

  private JsonNode readTemplate(String jsonFile, Object... args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    var inputStream = this.getClass().getResourceAsStream("/people/" + jsonFile);
    var templateString = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8.name());
    return mapper.readTree(templateString.formatted(args));
  }

  private JsonNode readString(String jsonStr) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(jsonStr);
  }
}
