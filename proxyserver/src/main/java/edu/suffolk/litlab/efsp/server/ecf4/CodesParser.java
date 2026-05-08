package edu.suffolk.litlab.efsp.server.ecf4;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.util.List;
import java.util.Optional;

public interface CodesParser {
  // Types specifically for errors.
  public sealed interface CodeError {}

  public record NoMatchingCode(String given, List<String> options) implements CodeError {}

  public record RequiredCodeNotPresent(List<String> options) implements CodeError {}

  public record BadCode(FilingError err) implements CodeError {}

  public Result<CaseCategory, CodeError> vetCaseCat(String caseCategoryCode);

  public Result<CaseType, CodeError> vetCaseType(
      String caseTypeCode, CaseCategory caseCategory, boolean isInitialFiling);

  public Result<Optional<NameAndCode>, NoMatchingCode> vetSubType(
      String subtypeCode, CaseType caseType);
}
