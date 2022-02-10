package edu.suffolk.litlab.efspserver.services;

import static com.hubspot.assertj.algebra.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hubspot.algebra.Result;
import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.docassemble.DocassembleToFilingEntityConverter;
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
    Result<FilingInformation, FilingError> result = converter.extractEntities(contents1);
    assertThat(result).isErr();
    assertEquals(result.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);

    String contents2 = getFileContents("/invalid_2.json");
    Result<FilingInformation, FilingError> result2 = converter.extractEntities(contents2);
    assertThat(result2).isErr();
    assertEquals(result2.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);
  }
  
  @Test
  public void testEmptyOnUnsupportedJson() throws IOException {
    String justStr = getFileContents("/just_str.json");
    Result<FilingInformation, FilingError> result = converter.extractEntities(justStr);
    assertThat(result).isErr();
    assertEquals(result.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);

    String justNull = getFileContents("/just_null.json");
    Result<FilingInformation, FilingError> result2 = converter.extractEntities(justNull);
    assertThat(result2).isErr();
    assertEquals(result2.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);
  }
  
  @Test
  public void testEnsureUserEmail() throws IOException {
    String contents = getFileContents("/housing_tro_2_plaintiff_business_def_no_email.json"); 
    Result<FilingInformation, FilingError> result = converter.extractEntities(contents);
    System.out.println(result);
    assertThat(result).isErr()
        .containsErr(FilingError.missingRequired(new InterviewVariable(
            "users[0].email", "", "text", List.of()))); 
  }
  
  @Test
  public void testGetsUserInformation() throws IOException {
    String interviewContents = getFileContents("/housing_tro_2_plaintiff_business_def.json");
    Result<FilingInformation, FilingError> maybeEntities = 
        converter.extractEntities(interviewContents);
    assertThat(maybeEntities).isOk(); 
    FilingInformation entities = maybeEntities.unwrapOrElseThrow();
    assertEquals(2, entities.getNewPlaintiffs().size(), 
        entities.getNewPlaintiffs().stream().map((p) -> p.getName().getFullName())
          .reduce("", (p, p2) -> p + " " + p2));
    assertEquals(1, entities.getNewDefendants().size(),
        entities.getNewDefendants().stream().map((p) -> p.getName().getFullName())
          .reduce("", (p, p2) -> p + ", " + p2));
    
    Person plaintiff = entities.getNewPlaintiffs().get(0);
    assertEquals("Bob Zombie", plaintiff.getName().getFullName());
    assertTrue(plaintiff.getContactInfo().getEmail().isPresent(),
        "user[0] should have email");
    assertEquals("test@example.com", plaintiff.getContactInfo().getEmail().get());
    assertEquals("Boston", plaintiff.getContactInfo().getAddress().get().getCity());
    assertEquals(1, plaintiff.getContactInfo().getPhoneNumbers().size());
    assertEquals("123-456-7890", plaintiff.getContactInfo().getPhoneNumbers().get(0));
    assertTrue(plaintiff.getLanguage().isPresent(), "user[0] should have a specified language");
    assertEquals("Spanish", plaintiff.getLanguage().get());
    
    Person plaintiff2 = entities.getNewPlaintiffs().get(1);
    assertEquals("Jill Vampire", plaintiff2.getName().getFullName());
    assertTrue(plaintiff2.getContactInfo().getEmail().isEmpty(), "user[1] should have empty email");
    
    Person defendant = entities.getNewDefendants().get(0);
    assertEquals("Company LLC", defendant.getName().getFullName());
    assertTrue(defendant.getContactInfo().getAddress().isPresent());
    assertEquals("Boston", defendant.getContactInfo().getAddress().get().getCity());
  }
  
  @Test
  public void testGetFilingInformation() throws IOException {
    String contents = getFileContents("/housing_tro_2_plaintiff_business_def.json");
    Result<FilingInformation, FilingError> maybeEntities = converter.extractEntities(contents);
    assertThat(maybeEntities).isOk();
    FilingInformation entities = maybeEntities.unwrapOrElseThrow();
    assertNotNull(entities.getCaseCategoryCode());
    assertEquals("CivilCase", entities.getCaseCategoryCode());
    assertEquals("Motion", entities.getCaseTypeCode());
    assertEquals("", entities.getCaseSubtypeCode());
    
    List<FilingDoc> filingDocs = entities.getFilings();
    assertEquals(1, filingDocs.size());
  }
  
  @Test
  public void testHasIsFormFiller() throws IOException {
    String contents = getFileContents("/existing_is_form_filler.json");
    Result<FilingInformation, FilingError> maybeInfo = converter.extractEntities(contents);
    assertThat(maybeInfo).isOk();
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    assertEquals(info.getPartyAttorneyMap().size(), 1);
    info.getPartyAttorneyMap().entrySet().forEach(x -> {
      assertTrue(x.getKey().isInCurrentFiling(), "User " + x.getKey().id + " should be in current filing");
      assertTrue(x.getValue().isEmpty(), "User " + x.getKey().id + " shouldn't have any attorneys");
    });
    assertEquals(info.getNewPlaintiffs().size(), 1);
    assertTrue(info.getNewPlaintiffs().get(0).isFormFiller());
  }
}
