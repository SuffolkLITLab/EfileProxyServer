package edu.suffolk.litlab.efsp.ecfcodes;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.model.FilingAction;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.OptionalService;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.model.Person.Gender;
import edu.suffolk.litlab.efsp.utils.FilingError;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Given the strings from an input case, 'parses' them (i.e. checks, confirms, and converts them
 * into slightly more strict types).
 *
 * <p>TODO(brycew): still needs to remove the tyler specific codes from this API
 */
public interface CodesParser extends AutoCloseable {
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

  public sealed interface AttorneyError {}
  public record NoMultipleAttorneys() implements AttorneyError {}
  public record RequiredAttorneys() implements AttorneyError {}

  public record ThingRequired() {}

  public record DueDateRequired() {}

  public record InvalidFilingAction(String reason) {}

  public sealed interface FileNameError {}
  public record FileExtensionNotAllowed(String given, List<NameAndCode> allowed) implements FileNameError {}
  public record FileNameTextError(TextVarError err) implements FileNameError {}

  public sealed interface FilingDocError {}
  public record DocTooBig(int idx) implements FilingDocError {}
  public record CumulativeDocsTooBig(long cumulativeBytes) implements FilingDocError {}
  // spotless:on

  // Methods

  public Result<NameAndCode, CodeError> vetCaseCat(String caseCategoryCode);

  public Result<NameAndCode, CodeError> vetCaseType(
      String caseTypeCode, NameAndCode caseCategory, boolean isInitialFiling);

  public Result<Optional<NameAndCode>, NoMatchingCode> vetSubType(
      String subtypeCode, NameAndCode caseType);

  public Result<List<NameAndCode>, BadCode> retrieveFilingOptions(
      NameAndCode caseCategory, NameAndCode type, boolean isInitialFiling);

  public Result<NameAndCode, CodeError> vetFilingType(
      Optional<String> filingCode, List<NameAndCode> filingOptions);

  public Result<String, CodeError> vetSuffix(Optional<String> suffix);

  public Result<Optional<String>, CodeError> vetLangCode(Optional<String> lang);

  public Result<String, CodeError> vetStateCode(String state, String countryString);

  public Result<Map<String, String>, CrossReferenceError> getCrossRefIds(
      Map<String, String> crossRefs, NameAndCode caseType);

  public Result<Map<PartyId, PartyInfo>, CodeError> vetPartyTypes(
      Collection<Person> existingParties,
      Collection<Person> newParties,
      NameAndCode type,
      boolean isFirstIndexedFiling);

  public Result<List<PartyId>, ThingRequired> vetFilingParties(List<PartyId> filingParties);

  public Result<Optional<NameAndCode>, CodeError> vetMotionCode(
      Optional<String> motionCode, NameAndCode filing);

  public record InputOptionalService(
      String code, Optional<Integer> multiplier, Optional<BigDecimal> feeAmount) {}

  public Result<List<OptionalService>, List<CodeError>> vetOptionalServices(
      List<InputOptionalService> servs, NameAndCode filing);

  public List<NameAndCode> retrieveFilingComponents(NameAndCode filingCode);

  public Result<NameAndCode, CodeError> vetFilingComponent(
      String filingComponent, ArrayList<NameAndCode> components);

  public Result<Optional<NameAndCode>, CodeError> vetFilerType(Optional<String> maybeFilerType);

  public Result<Optional<NameAndCode>, CodeError> vetDocType(String docTypeStr, NameAndCode filing);

  public Result<Optional<NameAndCode>, CodeError> vetDamageAmount(
      boolean initial, NameAndCode cat, Optional<String> maybeDamageAmount);

  public Result<Optional<NameAndCode>, CodeError> vetProcedureRemedy(
      Optional<String> maybeProRem, boolean initial, NameAndCode cat);

  public Result<Optional<Map<PartyId, List<String>>>, AttorneyError> vetPartyAttorneyMap(
      Map<PartyId, List<String>> partyAttyMap,
      Collection<PartyId> partyIdSet,
      Collection<String> attySet);

  public Result<Optional<String>, TextVarError> vetFilingAttorney(Optional<String> filingAttorney);

  public Result<Optional<String>, TextVarError> vetEmail(Optional<String> email);

  public Result<List<String>, TextVarError> vetPhoneNumbers(List<String> numbers);

  public Result<String, TextVarError> vetFirstName(Optional<String> name);

  public Result<String, TextVarError> vetMiddleName(Optional<String> name);

  public Result<String, TextVarError> vetLastName(Optional<String> name);

  public Result<String, TextVarError> vetOrgName(String name);

  public Result<Optional<Gender>, TextVarError> vetGender(Optional<String> gender);

  public Result<Optional<String>, TextVarError> vetFilingRefNum(Optional<String> fileRefNum);

  public Result<Optional<String>, TextVarError> vetComment(Optional<String> comment);

  public Result<Optional<LocalDate>, DueDateRequired> vetDueDate(
      Optional<LocalDate> dueDate, NameAndCode filing);

  public Result<Optional<FilingAction>, InvalidFilingAction> vetFilingAction(
      Optional<FilingAction> filingAction, boolean isInitialFiling, boolean hasServiceContacts);

  public Optional<String> getDocumentDescription(
      String description, String firstFileName, NameAndCode filing);

  public Result<String, FileNameError> vetFileName(String fileName);

  public Result<NullValue, FilingDocError> vetFilingDocSize(List<FilingDoc> docs);

  public Result<Optional<BigDecimal>, ThingRequired> vetAmountInControversy(
      Optional<BigDecimal> amt, List<NameAndCode> filings);

  public Optional<BigDecimal> vetMaxAmount(Optional<BigDecimal> maxAmount);

  public boolean useFilingAssociations();
}
