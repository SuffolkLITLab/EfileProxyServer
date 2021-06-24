package edu.suffolk.assemblyline.efspserver.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hubspot.algebra.Result;
import edu.suffolk.assemblyline.efspserver.FilingEntities;
import edu.suffolk.assemblyline.efspserver.Person;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocassembleToFilingEntityConverterTest {
  
  InterviewToFilingEntityConverter converter;
  
  @BeforeEach
  public void setUp() {
    converter = new DocassembleToFilingEntityConverter();
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
    assertTrue(converter.extractEntities(contents1).isErr());
    String contents2 = getFileContents("/invalid_2.json");
    assertTrue(converter.extractEntities(contents2).isErr());
  }
  
  @Test
  public void testEmptyOnUnsupportedJson() throws IOException {
    String justStr = getFileContents("/just_str.json");
    assertTrue(converter.extractEntities(justStr).isErr());
    String onlyNull = getFileContents("/just_null.json");
    assertTrue(converter.extractEntities(onlyNull).isErr());
  }
  
  @Test
  public void testGetsUserInformation() throws IOException {
    String interviewContents = getFileContents("/housing_tro_2_plaintiff_business_def.json");
    Result<FilingEntities, ExtractError> maybeEntities = 
        converter.extractEntities(interviewContents);
    assertTrue(maybeEntities.isOk());
    FilingEntities entities = maybeEntities.unwrapOrElseThrow();
    assertEquals(2, entities.getPlaintiffs().size(), 
        entities.getPlaintiffs().stream().map((p) -> p.getName().getFullName())
          .reduce("", (p, p2) -> p + " " + p2));
    assertEquals(1, entities.getDefendants().size(),
        entities.getDefendants().stream().map((p) -> p.getName().getFullName())
          .reduce("", (p, p2) -> p + ", " + p2));
    
    Person plaintiff = entities.getPlaintiffs().get(0);
  }
}
