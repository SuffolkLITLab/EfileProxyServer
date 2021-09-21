package edu.suffolk.litlab.efspserver.jeffnet;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tyler.ecf.extensions.common.FilingTypeType;

public class FilingInformationToJeffNetTest {

  FilingInformation info;
  
  /** Does standard set for the test. */
  @BeforeEach
  public void setUp() throws IOException {
    info = new FilingInformation();
    info.setCaseType("Housing temporary restraining order");
    info.setCaseSubtype("");
    info.setCourtLocation("JeffersonParish");
    info.setCaseCategory(new CaseCategory("C", "CivilCase"));
    info.setFilings(null);
    
    Person plaintiff = new Person(new Name("Bob", "Zombie"), "test@example.com", false);
    Person plaintiff2 = new Person(new Name("Jill", "Vampire"), 
        new ContactInformation(List.of(), Optional.empty(), Optional.empty()), Optional.empty(), 
        Optional.empty(), Optional.empty(), false);
    info.setPlaintiffs(List.of(plaintiff, plaintiff2));
    
    Person defendant = new Person(new Name("Company LLC"), "", true);
    info.setDefendants(List.of(defendant));
    
    // TODO(#52): Make and test multiple filings 

    String componentCode = "332";
    String fileName = "quality_check_overlay.pdf";
    InputStream x = this.getClass().getResourceAsStream("/" + fileName); 
    FilingDoc filingDoc = new FilingDoc(fileName, x,
        info.getPlaintiffs().stream().map((p) -> p.getIdString()).collect(
            Collectors.toList()), "5766",
        componentCode, FilingTypeType.E_FILE, true);
    info.setFilings(List.of(filingDoc));
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree("{\"tyler_filing_type\": \"27967\"}"); 
    info.setMiscInfo(node);
  }
  
  @Test
  public void testGetCaseParticipants() throws IOException {
    SimpleModule module = new SimpleModule();
    module.addSerializer(new FilingInformationJeffNetSerializer(FilingInformation.class));
    module.addSerializer(
        new ContactInfoJeffNetJacksonSerializer(ContactInformation.class));
    module.addSerializer(new NameJeffNetJacksonSerializer(Name.class));
    module.addSerializer(new FilingJeffNetJacksonSerializer(FilingDoc.class));
    module.addSerializer(new PersonJeffNetJacksonSerializer(Person.class));
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);
    
    String finalStr = mapper.writeValueAsString(info);
    JsonParser parser = mapper.createParser(finalStr);
    JsonNode node = parser.readValueAsTree(); 
    assertNotNull(node.get("CaseInfo").get("CaseParticipants"));
  }
}
