package edu.suffolk.litlab.efsp.server.ecf4;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public interface CodesParser {
  // Types specifically for errors.
  // spotless:off
  public sealed interface CodeError {}
  public record NoMatchingCode(String given, List<String> options) implements CodeError {}
  public record RequiredCodeNotPresent(List<String> options) implements CodeError {}
  public record BadCode(FilingError err) implements CodeError {}

  public sealed interface TextVarError {}
  public record MissingVar(Pattern regex) implements TextVarError {}
  public record WrongVar(String given, Pattern regex) implements TextVarError {}
  public record TooLongVar(String given, int length) implements TextVarError {}
  // spotless:on

  // Methods

  public Result<CaseCategory, CodeError> vetCaseCat(String caseCategoryCode);

  public Result<CaseType, CodeError> vetCaseType(
      String caseTypeCode, CaseCategory caseCategory, boolean isInitialFiling);

  public Result<Optional<NameAndCode>, NoMatchingCode> vetSubType(
      String subtypeCode, CaseType caseType);

  public Result<List<FilingCode>, BadCode> retrieveFilingOptions(
      CaseCategory caseCategory, CaseType type, boolean isInitialFiling);

  public Result<Optional<FilingCode>, CodeError> vetFilingType(
      Optional<String> filingCode, List<FilingCode> filingOptions);

  public Result<String, CodeError> vetSuffix(Optional<String> suffix);

  public Result<Optional<String>, CodeError> vetLangCode(Optional<String> lang);

  public Result<String, TextVarError> vetFirstName(Optional<String> name);

  public Result<String, TextVarError> vetMiddleName(Optional<String> name);

  public Result<String, TextVarError> vetLastName(Optional<String> name);
}
