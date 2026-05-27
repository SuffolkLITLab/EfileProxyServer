package edu.suffolk.litlab.efsp.server.ecf4.tyler;

import static com.hubspot.assertj.algebra.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.OptionalServiceCode;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.BadCode;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.NoMatchingCode;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.NoMatchingRef;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.RequiredCodeNotPresent;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.TooLongVar;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser.WrongRefVal;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

  @Nested
  @DisplayName("Parsing cross_references")
  class CrossRefTests {

    @BeforeEach
    void setUp() {
      when(cd.getCrossReference("01", exampleCaseType.code))
          .thenReturn(
              List.of(
                  new CrossReference(
                      "87374",
                      "Test cross reference (based on Cook County Attorney/Self-Rep code",
                      exampleCaseType.code,
                      "False",
                      "True",
                      "^[0-9]{5}$",
                      "Requires a 5-digit Case Cross Reference number. if self-represented, use 99500",
                      "COOKCOUNTYATTORNEY",
                      "01"),
                  new CrossReference(
                      "76343", "PIN#", exampleCaseType.code, "True", "False", "", "", "", "01")));
      when(cd.getCrossReference("01", exampleCaseType2.code)).thenReturn(List.of());
    }

    @Test
    public void shouldThrowIfRequiredButNotPresent() {
      assertThat(parser.getCrossRefIds(Map.of(), exampleCaseType)).isErr();
    }

    @Test
    public void shouldBeOkayIfNoneRequired() {
      assertThat(parser.getCrossRefIds(Map.of(), exampleCaseType2)).containsOk(Map.of());
    }

    @Test
    public void shouldAllowRequiredWithoutOptionalRefs() {
      var the_map = Map.of("87374", "99500");
      var res = parser.getCrossRefIds(the_map, exampleCaseType);
      assertThat(res).isOk();
      var crossRefIds = res.unwrapOrElseThrow();
      assertThat(crossRefIds).hasSize(1);
      assertThat(crossRefIds).contains(Map.entry("87374", "99500"));
    }

    @Test
    public void shouldAllowRequiredWithOneOptionalRef() {
      var the_map = Map.of("87374", "99502", "76343", "12345");
      var res = parser.getCrossRefIds(the_map, exampleCaseType);
      assertThat(res).isOk();
      var crossRefIds = res.expect("");
      assertThat(crossRefIds).hasSize(2);
      assertThat(crossRefIds).contains(Map.entry("87374", "99502"));
      assertThat(crossRefIds).contains(Map.entry("76343", "12345"));
    }

    @Test
    public void shouldThrowOnBadCrossRefKey() {
      var the_map = Map.of("87374", "99500", "12345", "bad key");
      var res = parser.getCrossRefIds(the_map, exampleCaseType);
      assertThat(res)
          .isErr()
          .extractingErr()
          .isInstanceOf(NoMatchingRef.class)
          .withFailMessage(
              () -> "Should have failed, we passed a cross reference code that isn't really there");
    }

    @Test
    public void shouldThrowOnBadCrossRefValue() {
      var the_map = Map.of("87374", "123456");
      var res = parser.getCrossRefIds(the_map, exampleCaseType);
      assertThat(res)
          .isErr()
          .extractingErr()
          .isInstanceOf(WrongRefVal.class)
          .withFailMessage(
              () ->
                  "Should have failed, we passed a value for a cross reference code that was too long");
    }
  }

  @Nested
  class MotionTypeTests {

    @Test
    public void noMotionCodeNoFilingCodeNotVisible() {
      when(dataFields.getFieldRow("FilingMotionType"))
          .thenReturn(DataFieldRow.MissingDataField("FilingMotionType"));
      assertThat(parser.vetMotionCode(Optional.empty(), filingCode)).containsOk(Optional.empty());
    }

    @Test
    public void noMotionCodeYesFilingCodeVisible() {
      when(dataFields.getFieldRow("FilingMotionType"))
          .thenReturn(new DataFieldRow("FilingMotionType", "", true, false, "01"));
      assertThat(parser.vetMotionCode(Optional.empty(), filingCode)).containsOk(Optional.empty());
    }

    @Test
    public void noMotionCodeYesFilingCodeRequired() {
      when(dataFields.getFieldRow("FilingMotionType"))
          .thenReturn(new DataFieldRow("FilingMotionType", "", true, true, "01"));
      assertThat(parser.vetMotionCode(Optional.empty(), filingCode))
          .extractingErr()
          .isInstanceOf(RequiredCodeNotPresent.class);
    }

    @Test
    public void yesMotionCodeYesFilingCodeNoMatching() {
      when(dataFields.getFieldRow("FilingMotionType"))
          .thenReturn(new DataFieldRow("FilingMotionType", "", true, false, "01"));
      when(cd.getMotionTypes("01", filingCode.code)).thenReturn(List.of());
      var res = parser.vetMotionCode(Optional.of("1234"), filingCode);
      assertThat(res).extractingErr().isInstanceOf(NoMatchingCode.class);
    }

    @Test
    public void yesMotionCodeYesFilingCodePresent() {
      when(dataFields.getFieldRow("FilingMotionType"))
          .thenReturn(new DataFieldRow("FilingMotionType", "", true, false, "01"));
      when(cd.getMotionTypes("01", filingCode.code))
          .thenReturn(List.of(new NameAndCode("idk", "1234")));
      var res = parser.vetMotionCode(Optional.of("1234"), filingCode);
      assertThat(res).containsOk(Optional.of(new NameAndCode("idk", "1234")));
    }
  }

  @Nested
  class OptionalServiceTests {

    OptionalServiceCode optServCode =
        new OptionalServiceCode(
            "9876", "Optional but really required", 0, "10", null, false, null, false, null);
    OptionalServiceCode optServFeeCode =
        new OptionalServiceCode(
            "9877",
            "Optional but really required",
            0,
            "10",
            null,
            false,
            null,
            true,
            "fee prompt text");
    OptionalServiceCode optServMultCode =
        new OptionalServiceCode(
            "9878", "Optional but really required", 0, "10", null, true, null, false, null);

    @BeforeEach
    public void setup() {
      when(cd.getOptionalServices("01", filingCode.code))
          .thenReturn(List.of(optServCode, optServFeeCode, optServMultCode));
    }

    @Test
    public void testNoOptServs() {
      var res2 = parser.vetOptionalServices(List.of(), filingCode);
      assertThat(res2).containsOk(List.of());
    }

    @Test
    public void testOptServsNoMatch() {
      var res =
          parser.vetOptionalServices(
              List.of(
                  new CodesParser.InputOptionalService("2233", Optional.empty(), Optional.empty())),
              filingCode);
      assertThat(res).isErr();
      var errs = res.expectErr("");
      assertThat(errs).hasSize(1).allMatch(err -> err instanceof NoMatchingCode);
    }

    @Test
    public void testOptServsFeeWrong() {
      var res =
          parser.vetOptionalServices(
              List.of(
                  new CodesParser.InputOptionalService("9877", Optional.empty(), Optional.empty())),
              filingCode);
      assertThat(res).isErr();
      var errs = res.expectErr("");
      assertThat(errs).hasSize(1).allMatch(err -> err instanceof BadCode);
    }

    @Test
    public void testOptServsFeeRight() {
      var res =
          parser.vetOptionalServices(
              List.of(
                  new CodesParser.InputOptionalService(
                      "9877", Optional.empty(), Optional.of(new BigDecimal(13)))),
              filingCode);
      assertThat(res).isOk();
      var list = res.expect("");
      assertThat(list)
          .hasSize(1)
          .allMatch(
              opt ->
                  opt.equals(
                      new OptionalService(
                          optServFeeCode, Optional.empty(), Optional.of(new BigDecimal(13)))));
    }

    @Test
    public void testOptServsMultWrong() {
      var res =
          parser.vetOptionalServices(
              List.of(
                  new CodesParser.InputOptionalService("9878", Optional.empty(), Optional.empty())),
              filingCode);
      assertThat(res).isErr();
      var errs = res.expectErr("");
      assertThat(errs).hasSize(1).allMatch(err -> err instanceof BadCode);
    }

    @Test
    public void testOptServsMultRight() {
      var res =
          parser.vetOptionalServices(
              List.of(
                  new CodesParser.InputOptionalService("9878", Optional.of(3), Optional.empty())),
              filingCode);
      assertThat(res).isOk();
      var list = res.expect("");
      assertThat(list)
          .allMatch(
              opt ->
                  opt.equals(
                      new OptionalService(optServMultCode, Optional.of(3), Optional.empty())));
    }
  }

  FilingComponent component =
      new FilingComponent("333", "Test Filing Component", "", false, false, 0, "", "01");

  @Test
  public void testFilingComponents() {
    var components = new ArrayList<FilingComponent>();
    components.add(component);
    var res = parser.vetFilingComponent("333", components);
    assertThat(res).containsOk(component);
    var resAgain = parser.vetFilingComponent("333", components);
    assertThat(resAgain).containsErr(new NoMatchingCode("333", List.of()));
  }

  DocumentTypeTableRow docType =
      new DocumentTypeTableRow("4444", null, filingCode.code, "false", null, null, null);

  @Test
  public void testDocumentType() {
    when(dataFields.getFieldRow("DocumentType"))
        .thenReturn(new DataFieldRow("DocumenType", null, true, false, null));
    when(cd.getDocumentTypes("01", filingCode.code)).thenReturn(List.of(docType));
    var res = parser.vetDocType("4444", filingCode);
    assertThat(res).containsOk(Optional.of(docType));
  }

  @Nested
  class ProcedureRemedyTests {
    CaseCategory exampleCatProcRem =
        new CaseCategory(
            "123987",
            "Test Category",
            "",
            "Available",
            "Not Available",
            "Not Available",
            "Not Available");

    @Test
    public void testNoProcedureRemedyType() {
      var res = parser.vetProcedureRemedy(Optional.of("2244"), true, exampleCategory);
      assertThat(res).containsOk(Optional.empty());
    }

    @Test
    public void testProcedureRemedyNoMatching() {
      when(dataFields.getFieldRow("CivilCaseProcedureViewInitial"))
          .thenReturn(new DataFieldRow("CivilCaseProcedureViewInitial", "proc", true, false, "01"));
      when(cd.getProcedureOrRemedy("01", exampleCatProcRem.code)).thenReturn(List.of());
      var res = parser.vetProcedureRemedy(Optional.of("2244"), true, exampleCatProcRem);
      assertThat(res).isErr().extractingErr().isInstanceOf(NoMatchingCode.class);
    }

    @Test
    public void testProcedureRemedyType() {
      var procRem = new NameAndCode("Proc Rem Example", "2244");
      when(dataFields.getFieldRow("CivilCaseProcedureViewInitial"))
          .thenReturn(new DataFieldRow("CivilCaseProcedureViewInitial", "proc", true, false, "01"));
      when(cd.getProcedureOrRemedy("01", exampleCatProcRem.code)).thenReturn(List.of(procRem));
      var res = parser.vetProcedureRemedy(Optional.of("2244"), true, exampleCatProcRem);
      assertThat(res).containsOk(Optional.of(procRem));
    }

    @Nested
    class PhoneNumberTests {
      @BeforeEach
      public void setup() {
        when(dataFields.getFieldRow("PartyPhone"))
            .thenReturn(
                new DataFieldRow(
                    "PartyPhone",
                    "phone number",
                    true,
                    false,
                    "",
                    "",
                    "",
                    "",
                    "^(\\+0?1\\s)?\\(?\\d{3}\\)?\\d{3}\\d{4}$",
                    null,
                    false,
                    "01"));
      }

      @Test
      public void testNormalPhoneNumber() {
        var phones = List.of("4092345678");
        var res = parser.vetPhoneNumbers(phones);
        assertThat(res).containsOk(phones);
      }

      @Test
      public void testBadPhoneNumber() {
        var phones = List.of("+34092345678");
        var res = parser.vetPhoneNumbers(phones);
        assertThat(res).isErr();
      }

      @Test
      public void testOneBadOneOkayPhoneNumber() {
        var phones = List.of("+34092345678", "+1 4092345678");
        var res = parser.vetPhoneNumbers(phones);
        assertThat(res).containsOk(List.of("+1 4092345678"));
      }
    }
  }
}
