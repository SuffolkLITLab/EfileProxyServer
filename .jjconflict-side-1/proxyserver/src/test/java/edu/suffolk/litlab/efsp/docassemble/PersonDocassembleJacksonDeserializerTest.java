package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.docassemble.PersonDocassembleJacksonDeserializer.fromNode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.model.PartyId;
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

  @BeforeEach
  public void setUp() {
    collector = new FailFastCollector();
  }

  @Test
  public void testShouldParseWithAllJsonFields() throws FilingError, IOException {
    JsonNode node = readFile("person_with_all.json");
    var res = fromNode(node, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getContactInfo().getEmail()).contains("john.brown@example.com");
    assertThat(per.getContactInfo().getPhoneNumbers()).hasSize(1);
    assertThat(per.getContactInfo().getAddress())
        .isPresent(); // contains(new Address("123 Fake St", "", "Chicago", "IL", "60007",
    assertThat(per.getContactInfo().getAddress().get().getCity()).isEqualTo("Chicago");
    assertThat(per.getPartyId()).isEqualTo(PartyId.Already("abcd1234-1234-1234-1234-abcdabcd1234"));
    assertThat(per.getRole()).isEqualTo("29738");
  }

  @Test
  public void testShouldParseWithMinimal() throws FilingError, IOException {
    JsonNode node = readFile("person_with_minimal.json");
    var res = fromNode(node, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getName().getFirstName()).isEqualTo("John");
  }

  @Test
  public void testShouldParseWithExtraJson() throws FilingError, IOException {
    JsonNode node = readFile("person_with_extras.json");
    var res = fromNode(node, collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getContactInfo().getEmail()).contains("john.brown@example.com");
    assertThat(per.getContactInfo().getPhoneNumbers()).hasSize(1);
    assertThat(per.getContactInfo().getAddress())
        .isPresent(); // contains(new Address("123 Fake St", "", "Chicago", "IL", "60007",
    assertThat(per.getContactInfo().getAddress().get().getCity()).isEqualTo("Chicago");
    assertThat(per.getPartyId()).isEqualTo(PartyId.Already("abcd1234-1234-1234-1234-abcdabcd1234"));
    assertThat(per.getRole()).isEqualTo("29738");
  }

  @Test
  public void testDontParseBadJson() throws FilingError, IOException {
    collector = new AllWrongCollector();
    assertThrows(FilingError.class, () -> fromNode(readString("\"abc\""), collector));
    collector = new AllWrongCollector();
    assertThrows(FilingError.class, () -> fromNode(readString("[{}]"), collector));
    collector = new AllWrongCollector();
    fromNode(readString("{\"abc\": \"def\"}"), collector);
    assertThat(collector.getRequired()).hasSize(1); // only requires name
  }

  @Test
  public void testValidBirthDate() throws IOException, FilingError {
    var res = fromNode(readTemplate("person_birthdate_template.json", "2000-11-02"), collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getBirthdate()).isPresent();
    assertThat(per.getBirthdate().get()).isEqualTo("2000-11-02");
  }

  @Test
  public void testInvalidBirthDate() throws IOException, FilingError {
    var res = fromNode(readTemplate("person_birthdate_template.json", "2000-11-32"), collector);
    assertThat(res.isOk()).isTrue();
    var per = res.unwrapOrElseThrow();
    assertThat(per.getBirthdate()).isEmpty();
  }

  @Test
  public void testIsNewNotABoolean() throws FilingError, IOException {
    collector = new AllWrongCollector();
    fromNode(readTemplate("person_new_id.json", "\"abc\"", "\"this will fail\""), collector);
    assertThat(collector.getWrong()).hasSize(1);
  }

  @Test
  public void testIsNewAndEfmId() throws FilingError, IOException {
    collector = new AllWrongCollector();
    fromNode(readTemplate("person_new_id.json", "\"abc\"", "true"), collector);
    assertThat(collector.getWrong()).hasSize(1);
    assertThat(collector.getWrong().get(0).getDescription())
        .contains("EFM (tyler) ID on a brand new party to the case");
  }

  @Test
  public void testIsNotNewAndNoEfmId() throws FilingError, IOException {
    collector = new AllWrongCollector();
    fromNode(readTemplate("person_new_id.json", "null", "false"), collector);
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
