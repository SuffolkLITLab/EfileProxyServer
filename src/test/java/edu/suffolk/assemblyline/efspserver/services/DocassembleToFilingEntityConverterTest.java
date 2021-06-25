package edu.suffolk.assemblyline.efspserver.services;

import static com.hubspot.assertj.algebra.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hubspot.algebra.Result;
import com.opencsv.exceptions.CsvValidationException;

import edu.suffolk.assemblyline.efspserver.Filing;
import edu.suffolk.assemblyline.efspserver.FilingEntities;
import edu.suffolk.assemblyline.efspserver.Person;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocassembleToFilingEntityConverterTest {
  
  InterviewToFilingEntityConverter converter;
  
  @BeforeEach
  public void setUp() throws CsvValidationException, IOException {
    converter = new DocassembleToFilingEntityConverter(
        this.getClass().getResourceAsStream("/taxonomy.csv"));
  }
  
  private String getFileContents(String inFileName) throws IOException {
    InputStream inputStream = this.getClass().getResourceAsStream(inFileName); 
    // https://stackoverflow.com/a/35446009/11416267, number 8
    ByteArrayOutputStream result = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    for (int length; (length = inputStream.read(buffer)) != -1; ) {
      result.write(buffer, 0, length);
    }
    inputStream.close();
    return result.toString(StandardCharsets.UTF_8.name()); 
  }
  
  @Test
  public void testEmptyOnInvalidJson() throws IOException {
    String contents1 = getFileContents("/invalid_1.json");
    assertThat(converter.extractEntities(contents1))
        .isErr()
        .containsErr(new ExtractError(ExtractError.Type.MalformedInterview));
    String contents2 = getFileContents("/invalid_2.json");
    assertThat(converter.extractEntities(contents2))
        .isErr()
        .containsErr(new ExtractError(ExtractError.Type.MalformedInterview));
  }
  
  @Test
  public void testEmptyOnUnsupportedJson() throws IOException {
    String justStr = getFileContents("/just_str.json");
    assertThat(converter.extractEntities(justStr))
        .isErr()
        .containsErr(new ExtractError(ExtractError.Type.MalformedInterview));
    assertTrue(converter.extractEntities(justStr).isErr());
    String justNull = getFileContents("/just_null.json");
    assertThat(converter.extractEntities(justNull))
        .isErr()
        .containsErr(new ExtractError(ExtractError.Type.MalformedInterview));
  }
  
  @Test
  public void testEnsureUserEmail() throws IOException {
    String contents = getFileContents("/housing_tro_2_plaintiff_business_def_no_email.json"); 
    Result<FilingEntities, ExtractError> result = converter.extractEntities(contents);
    assertThat(result).isErr()
        .containsErr(new ExtractError(ExtractError.Type.MissingRequired, "users[0]", "users[0].email"));
  }
  
  @Test
  public void testGetsUserInformation() throws IOException {
    String interviewContents = getFileContents("/housing_tro_2_plaintiff_business_def.json");
    Result<FilingEntities, ExtractError> maybeEntities = 
        converter.extractEntities(interviewContents);
    assertThat(maybeEntities).isOk(); 
    FilingEntities entities = maybeEntities.unwrapOrElseThrow();
    assertEquals(2, entities.getPlaintiffs().size(), 
        entities.getPlaintiffs().stream().map((p) -> p.getName().getFullName())
          .reduce("", (p, p2) -> p + " " + p2));
    assertEquals(1, entities.getDefendants().size(),
        entities.getDefendants().stream().map((p) -> p.getName().getFullName())
          .reduce("", (p, p2) -> p + ", " + p2));
    
    Person plaintiff = entities.getPlaintiffs().get(0);
    assertEquals("Bob Zombie", plaintiff.getName().getFullName());
    assertTrue(plaintiff.getContactInfo().getEmail().isPresent(),
        "user[0] should have email");
    assertEquals("test@example.com", plaintiff.getContactInfo().getEmail().get());
    assertEquals("Boston", plaintiff.getContactInfo().getAddress().get().getCity());
    assertEquals(1, plaintiff.getContactInfo().getPhoneNumbers().size());
    assertEquals("123-456-7890", plaintiff.getContactInfo().getPhoneNumbers().get(0));
    assertTrue(plaintiff.getLanguage().isPresent(), "user[0] should have a specified language");
    assertEquals("Spanish", plaintiff.getLanguage().get());
    
    Person plaintiff2 = entities.getPlaintiffs().get(1);
    assertEquals("Jill Vampire", plaintiff2.getName().getFullName());
    assertTrue(plaintiff2.getContactInfo().getEmail().isEmpty(), "user[1] should have empty email");
    
    Person defendant = entities.getDefendants().get(0);
    assertEquals("Company LLC", defendant.getName().getFullName());
    assertTrue(defendant.getContactInfo().getAddress().isPresent());
    assertEquals("Boston", defendant.getContactInfo().getAddress().get().getCity());
  }
  
  @Test
  public void testGetFilingInformation() throws IOException {
    String contents = getFileContents("/housing_tro_2_plaintiff_business_def.json");
    Result<FilingEntities, ExtractError> maybeEntities = converter.extractEntities(contents);
    assertThat(maybeEntities).isOk();
    FilingEntities entities = maybeEntities.unwrapOrElseThrow();
    assertNotNull(entities.getCaseCategory());
    assertEquals("CivilCase", entities.getCaseCategory().ecfcasetype);
    assertEquals("Housing temporary restraining order", entities.getCaseType());
    assertEquals("", entities.getCaseSubtype());
    
    List<Filing> filings = entities.getFilings();
    assertEquals(1, filings.size());
  }
}
