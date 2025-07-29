package edu.suffolk.litlab.efsp.server.jeffnet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.FilingAttachment;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.utils.LegalIssuesTaxonomyCodes;
import fj.data.NonEmptyList;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilingInformationToJeffNetTest {

  FilingInformation info;

  /** Does standard set for the test. */
  @BeforeEach
  public void setUp() throws IOException {
    info = new FilingInformation();
    info.setCaseTypeCode("Housing temporary restraining order");
    info.setCaseSubtypeCode("");
    info.setCourtLocation("JeffersonParish");
    info.setCaseCategoryCode("CivilCase");
    info.setFilings(null);

    Person plaintiff = Person.TestPerson(new Name("Bob", "", "Zombie"), "test@example.com", false);
    Person plaintiff2 =
        Person.FromInput(
            new Name("Jill", "", "Vampire"),
            new ContactInformation(List.of(), Optional.empty(), Optional.empty()),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            false,
            false,
            "",
            Optional.empty());
    info.setNewPlaintiffs(List.of(plaintiff, plaintiff2));

    Person defendant = Person.TestPerson(new Name("Company LLC"), "", true);
    info.setNewDefendants(List.of(defendant));

    // TODO(#52): Make and test multiple filings

    String componentCode = "332";
    String fileName = "quality_check_overlay.pdf";
    InputStream x = this.getClass().getResourceAsStream("/" + fileName);
    FilingAttachment fa =
        new FilingAttachment(
            fileName, x.readAllBytes(), "5766", componentCode, "The Quality Check Overlay");
    FilingDoc filingDoc =
        new FilingDoc(
            Optional.empty(),
            info.getNewPlaintiffs().stream()
                .map(p -> PartyId.CurrentFilingNew(p.getIdString()))
                .collect(Collectors.toList()),
            NonEmptyList.fromList(fj.data.List.list(fa)).some(),
            true);
    info.setFilings(List.of(filingDoc));
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree("{\"tyler_filing_type\": \"27967\"}");
    info.setMiscInfo(node);
  }

  @Test
  public void testGetCaseParticipants() throws IOException, CsvValidationException {
    SimpleModule module = new SimpleModule();
    module.addSerializer(
        new FilingInformationJeffNetSerializer(
            FilingInformation.class,
            new LegalIssuesTaxonomyCodes(
                FilingInformationToJeffNetTest.class.getResourceAsStream("/taxonomy.csv"))));
    module.addSerializer(new ContactInfoJeffNetJacksonSerializer(ContactInformation.class));
    module.addSerializer(new NameJeffNetJacksonSerializer(Name.class));
    module.addSerializer(new FilingJeffNetJacksonSerializer(FilingDoc.class));
    module.addSerializer(new PersonJeffNetJacksonSerializer(Person.class));
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);

    String finalStr = mapper.writeValueAsString(info);
    JsonParser parser = mapper.createParser(finalStr);
    JsonNode node = parser.readValueAsTree();
    assertNotNull(node.get("CaseInfo").get("CaseParticipants"));
    assertEquals("CivilCase", node.get("CaseInfo").get("CaseCategoryText").asText());
    assertEquals("JeffersonParish", node.get("CaseInfo").get("CaseCourt").asText());
  }
}
