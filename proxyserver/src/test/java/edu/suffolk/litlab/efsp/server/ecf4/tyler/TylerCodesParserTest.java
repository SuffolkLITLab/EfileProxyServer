package edu.suffolk.litlab.efsp.server.ecf4.tyler;

import static com.hubspot.assertj.algebra.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.BadCode;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.NoMatchingCode;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.TooLongVar;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TylerCodesParserTest {

  CodesParser parser;
  CodeDatabase cd;
  DataFields dataFields;

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
  CaseType exampleCaseType2 =
      new CaseType("54321", "Test Case Type (no initial)", "123987", "false", "0", "", "", "01");
  FilingCode filingCode =
      new FilingCode(
          "777",
          "",
          "",
          exampleCategory.code,
          exampleCaseType.code,
          "",
          false,
          "",
          "",
          "",
          false,
          false,
          "",
          "01");

  @BeforeEach
  public void setUp() {
    cd = mock(CodeDatabase.class);
    when(cd.getCaseCategoriesFor("01")).thenReturn(List.of(exampleCategory));
    when(cd.getCaseCategoryWithCode("01", "123987")).thenReturn(Optional.of(exampleCategory));
    when(cd.getCaseTypesFor("01", "123987", Optional.empty()))
        .thenReturn(List.of(exampleCaseType, exampleCaseType2));
    when(cd.getCaseSubtypesFor("01", "456098"))
        .thenReturn(List.of(new NameAndCode("SubType code", "998877")));
    when(cd.getFilingType("01", exampleCategory.code, exampleCaseType.code, true))
        .thenReturn(List.of(filingCode));
    var loc = new CourtLocationInfo("01");
    loc.initial = true;

    dataFields = mock(DataFields.class);
    parser = new TylerCodesParser(cd, loc, dataFields);
  }

  @Test
  public void testVetCaseCatSuccess() {
    var res = parser.vetCaseCat("123987");
    assertThat(res).containsOk(exampleCategory);
  }

  @Test
  public void testVetCaseCatNoMatchingCode() {
    var res = parser.vetCaseCat("123fake");
    assertThat(res).containsErr(new NoMatchingCode("123fake", List.of("123987")));
  }

  @Test
  public void testVetCaseTypeSuccess() {
    var res = parser.vetCaseType("456098", exampleCategory, true);
    assertThat(res).isOk();
    var ex = res.unwrapOrElseThrow();
    // TODO(brycew): discovered that normal equals doesn't exist, even though
    // all attributes match. Equals isn't set right somehow, but don't
    // want to break anything if it's already working for some reason.
    assertThat(ex.casecategory).isEqualTo(exampleCaseType.casecategory);
    assertThat(ex.code).isEqualTo(exampleCaseType.code);
    assertThat(ex.efspcode).isEqualTo(exampleCaseType.efspcode);
    assertThat(ex.fee).isEqualTo(exampleCaseType.fee);
    assertThat(ex.initial).isEqualTo(exampleCaseType.initial);
    assertThat(ex.location).isEqualTo(exampleCaseType.location);
    assertThat(ex.name).isEqualTo(exampleCaseType.name);
    assertThat(ex.willfileddate).isEqualTo(exampleCaseType.willfileddate);
  }

  @Test
  public void testVetCaseTypeNoInitial() {
    var res = parser.vetCaseType("456098", exampleCategory, false);
    assertThat(res)
        .containsErr(
            new BadCode(
                FilingError.malformedInterview(
                    "A Subsequent filing can't be filed at Court with code 01")));
  }

  @Test
  public void testVetCaseTypeNoMatch() {
    var res = parser.vetCaseType("123fake", exampleCategory, true);
    assertThat(res).containsErr(new NoMatchingCode("123fake", List.of("456098", "54321")));
  }

  @Test
  public void testVetCaseTypeBadCode() {
    var res = parser.vetCaseType("54321", exampleCategory, true);
    assertThat(res)
        .containsErr(
            new BadCode(
                FilingError.malformedInterview(
                    "An Initial filing can't be filed at Court with code 01 or be of filing type Test Case Type (no initial)")));
  }

  @Test
  public void testVetCaseSubTypeSuccess() {
    when(dataFields.getFieldRow("CaseInformationCaseSubType"))
        .thenReturn(new DataFieldRow("CaseInformationCaseSubType", "Sub type", true, false, "01"));
    var res = parser.vetSubType("998877", exampleCaseType);
    assertThat(res).containsOk(Optional.of(new NameAndCode("SubType code", "998877")));
  }

  @Test
  public void testVetCaseSubTypeNone() {
    when(dataFields.getFieldRow("CaseInformationCaseSubType"))
        .thenReturn(new DataFieldRow("CaseInformationCaseSubType", "Sub type", false, false, "01"));
    var res = parser.vetSubType("9988877", exampleCaseType);
    assertThat(res).containsOk(Optional.empty());
  }

  @Test
  public void testVetCaseSubTypeRequired() {
    when(dataFields.getFieldRow("CaseInformationCaseSubType"))
        .thenReturn(new DataFieldRow("CaseInformationCaseSubType", "Sub type", true, true, "01"));
    var res = parser.vetSubType("998800", exampleCaseType);
    assertThat(res).containsErr(new NoMatchingCode("998800", List.of("998877")));
  }

  @Test
  public void testVetFilingCodesRestricted() {
    when(cd.getFilingType("01", exampleCategory.code, exampleCaseType.code, true))
        .thenReturn(List.of());
    var res = parser.retrieveFilingOptions(exampleCategory, exampleCaseType, true);
    assertThat(res)
        .containsErr(
            new BadCode(
                FilingError.malformedInterview(
                    "Need a filing type! FilingTypes are empty, so 123987, Test Category,  and 456098, Test Case Type, 123987, true, 0.0, , , 01 are restricted")));
  }

  @Test
  public void testSuffixVisibleNotVisible() {
    when(dataFields.getFieldRow("PartyNameSuffix"))
        .thenReturn(DataFieldRow.MissingDataField("PartyNameSuffix"));
    var res = parser.vetSuffix(Optional.empty());
    assertThat(res).containsOk("");
  }

  @Test
  public void testSuffixVisibleAndRequired() {
    when(dataFields.getFieldRow("PartyNameSuffix"))
        .thenReturn(new DataFieldRow("PartyNameSuffix", "suffix", true, true, "01"));
    var res = parser.vetSuffix(Optional.empty());
    assertThat(res).containsErr(new NoMatchingCode("", List.of()));
  }

  @Test
  public void testSuffixVisibleAndPresent() {
    when(dataFields.getFieldRow("PartyNameSuffix"))
        .thenReturn(new DataFieldRow("PartyNameSuffix", "suffix", true, true, "01"));
    when(cd.getNameSuffixes("01")).thenReturn(List.of(new NameAndCode("MD", "MD")));
    var res = parser.vetSuffix(Optional.of("md"));
    assertThat(res).containsOk("MD");
  }

  @Test
  public void testNameTooLong() {
    when(dataFields.getFieldRow("PartyFirstName"))
        .thenReturn(new DataFieldRow("PartyFirstName", "first name", true, true, "01"));
    String longName =
        "abcdefghijklmnopqrstuvwxyz"
            + "abcdefghijklmnopqrstuvwxyz"
            + "abcdefghijklmnopqrstuvwxyz"
            + "abcdefghijklmnopqrstuvwxyz"
            + "abcdefghijklmnopqrstuvwxyz";
    var res = parser.vetFirstName(Optional.of(longName));
    assertThat(res).containsErr(new TooLongVar(longName, 100));
  }
}
