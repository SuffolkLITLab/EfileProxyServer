package edu.suffolk.litlab.efsp.docassemble;

import static com.hubspot.assertj.algebra.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.tyler.TylerCodesParser;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocassembleToFilingInformationConverterTest {

  InterviewToFilingInformationConverter converter;
  CodesParser parser;

  CaseCategory exampleCategory =
      new CaseCategory(
          "123987",
          "Test Category",
          "",
          "Not Available",
          "Not Available",
          "Not Available",
          "Not Available");
  CaseType exampleCaseType =
      new CaseType("456098", "Test Case Type", "123987", "true", "0", "", "", "01");
  FilingCode exampleFilingType =
      new FilingCode("1234fake", "", "", "", "", "", false, "", "", "", false, false, "", "01");

  @BeforeEach
  public void setUp() throws IOException {
    converter = new DocassembleToFilingInformationConverter(TylerEnv.STAGE);
    CodeDatabase cd = mock(CodeDatabase.class);
    when(cd.getCaseCategoriesFor("01")).thenReturn(List.of(exampleCategory));
    when(cd.getCaseCategoryWithCode("01", "123987")).thenReturn(Optional.of(exampleCategory));
    when(cd.getCaseTypesFor("01", "123987", Optional.empty())).thenReturn(List.of(exampleCaseType));
    when(cd.getFilingType("01", "123987", exampleCaseType.code, true))
        .thenReturn(List.of(exampleFilingType));
    when(cd.getFilingType("01", "123987", exampleCaseType.code, false))
        .thenReturn(List.of(exampleFilingType));
    when(cd.getFilingComponents("01", exampleFilingType.code))
        .thenReturn(List.of(new FilingComponent("332", null, null, false, false, 0, null, null)));
    when(cd.getDataFields("01"))
        .thenReturn(
            new DataFields(
                List.of(
                    Map.of(
                        "PartyFirstName",
                            new DataFieldRow("PartyFirstName", "first name", true, true, "adams"),
                        "PartyMiddleName",
                            new DataFieldRow(
                                "PartyMiddleName", "middle name", true, false, "adams"),
                        "PartyLastName",
                            new DataFieldRow(
                                "PartyLastName", "last name", true, false, "adams")))));
    var loc = new CourtLocationInfo("01");
    loc.initial = true;
    loc.subsequent = true;
    parser = new TylerCodesParser(cd, loc);
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
    Result<FilingInformation, FilingError> result = converter.extractInformation(contents1, parser);
    assertThat(result).isErr();
    assertEquals(result.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);

    String contents2 = getFileContents("/invalid_2.json");
    Result<FilingInformation, FilingError> result2 =
        converter.extractInformation(contents2, parser);
    assertThat(result2).isErr();
    assertEquals(result2.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);
  }

  @Test
  public void testEmptyOnUnsupportedJson() throws IOException {
    String justStr = getFileContents("/just_str.json");
    Result<FilingInformation, FilingError> result = converter.extractInformation(justStr, parser);
    assertThat(result).isErr();
    assertEquals(result.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);

    String justNull = getFileContents("/just_null.json");
    Result<FilingInformation, FilingError> result2 = converter.extractInformation(justNull, parser);
    assertThat(result2).isErr();
    assertEquals(result2.unwrapErrOrElseThrow().getType(), FilingError.Type.MalformedInterview);
  }

  @Test
  public void testEnsureUserEmail() throws IOException {
    String contents = getFileContents("/housing_tro_2_plaintiff_business_def_no_email.json");
    Result<FilingInformation, FilingError> result = converter.extractInformation(contents, parser);
    System.out.println(result);
    assertThat(result)
        .isErr()
        .containsErr(
            FilingError.missingRequired(
                new InterviewVariable("users[0].email", "", "text", List.of(), Optional.empty())));
  }

  @Test
  public void testGetsUserInformation() throws IOException {
    String interviewContents = getFileContents("/housing_tro_2_plaintiff_business_def.json");
    Result<FilingInformation, FilingError> maybeEntities =
        converter.extractInformation(interviewContents, parser);
    assertThat(maybeEntities).isOk();
    FilingInformation entities = maybeEntities.unwrapOrElseThrow();
    assertEquals(
        2,
        entities.getNewPlaintiffs().size(),
        entities.getNewPlaintiffs().stream()
            .map((p) -> p.getName().getFullName())
            .reduce("", (p, p2) -> p + " " + p2));
    assertEquals(
        1,
        entities.getNewDefendants().size(),
        entities.getNewDefendants().stream()
            .map((p) -> p.getName().getFullName())
            .reduce("", (p, p2) -> p + ", " + p2));

    Person plaintiff = entities.getNewPlaintiffs().get(0);
    assertEquals("Bob Zombie", plaintiff.getName().getFullName());
    assertTrue(plaintiff.getContactInfo().getEmail().isPresent(), "user[0] should have email");
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
    Result<FilingInformation, FilingError> maybeEntities =
        converter.extractInformation(contents, parser);
    assertThat(maybeEntities).isOk();
    FilingInformation entities = maybeEntities.unwrapOrElseThrow();
    assertNotNull(entities.getCaseCategoryCode());
    assertEquals("123987", entities.getCaseCategoryCode().code);
    assertEquals("456098", entities.getCaseTypeCode().code);
    assertEquals(Optional.empty(), entities.getCaseSubtypeCode());

    List<FilingDoc> filingDocs = entities.getFilings();
    assertEquals(1, filingDocs.size());
  }

  @Test
  public void testHasIsFormFiller() throws IOException {
    String contents = getFileContents("/existing_is_form_filler.json");
    Result<FilingInformation, FilingError> maybeInfo =
        converter.extractInformation(contents, parser);
    assertThat(maybeInfo).isOk();
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    assertEquals(info.getPartyAttorneyMap().size(), 1);
    info.getPartyAttorneyMap()
        .entrySet()
        .forEach(
            x -> {
              assertTrue(
                  x.getKey().isNewInCurrentFiling(),
                  "User " + x.getKey().getIdentificationString() + " should be in current filing");
              assertTrue(
                  x.getValue().isEmpty(),
                  "User " + x.getKey().getIdentificationString() + " shouldn't have any attorneys");
            });
    assertEquals(info.getNewPlaintiffs().size(), 1);
    assertTrue(info.getNewPlaintiffs().get(0).isFormFiller());
  }

  @Test
  public void testfilteredOutNotNew() throws IOException {
    String contents = getFileContents("/checking_filtered_users.json");
    Result<FilingInformation, FilingError> maybeInfo =
        converter.extractInformation(contents, parser);
    assertThat(maybeInfo).isOk();
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    assertEquals(
        2,
        info.getNewPlaintiffs().size(),
        "Should have only been 2 plaintiffs, but were " + info.getNewPlaintiffs().size());
    assertTrue(info.getNewPlaintiffs().get(0).isFormFiller());
  }
}
