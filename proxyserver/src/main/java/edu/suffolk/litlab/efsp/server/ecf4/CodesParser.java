package edu.suffolk.litlab.efsp.server.ecf4;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

  public sealed interface CrossReferenceError {}
  public record WrongRefVal(String refCode, String refVal, Pattern regex, String msg) implements CrossReferenceError {}
  public record NoMatchingRef(String refCode, String refVal) implements CrossReferenceError {}
  public record MissingRequiredRefs(Set<String> refCodes) implements CrossReferenceError {}
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

  public Result<Map<String, String>, CrossReferenceError> getCrossRefIds(
      Map<String, String> crossRefs, CaseType caseType);

  public Result<Optional<NameAndCode>, CodeError> vetMotionCode(
      Optional<String> motionCode, Optional<FilingCode> filing);

  public record InputOptionalService(
      String code, Optional<Integer> multiplier, Optional<BigDecimal> feeAmount) {}

  public Result<List<OptionalService>, List<CodeError>> vetOptionalServices(
      List<InputOptionalService> servs, Optional<FilingCode> filing);

  public List<FilingComponent> retrieveFilingComponents(Optional<FilingCode> filingCode);

  public Result<FilingComponent, CodeError> vetFilingComponent(
      String filingComponent, ArrayList<FilingComponent> components);

  public Result<Optional<DocumentTypeTableRow>, CodeError> vetDocType(
      String docTypeStr, FilingCode filing);

  public Result<Optional<NameAndCode>, CodeError> vetDamageAmount(
      boolean initial, CaseCategory cat, Optional<String> maybeDamageAmount);

  public Result<Optional<NameAndCode>, CodeError> vetProcedureRemedy(
      Optional<String> maybeProRem, boolean initial, CaseCategory cat);

  public Result<String, TextVarError> vetFirstName(Optional<String> name);

  public Result<String, TextVarError> vetMiddleName(Optional<String> name);

  public Result<String, TextVarError> vetLastName(Optional<String> name);
}
