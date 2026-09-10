package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCodeType;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CodeSearchMatcherTest {

  @Test
  public void exactMatchWinsOverSubstring() {
    List<NameAndCode> options =
        List.of(
            new NameAndCodeType("Civil", "8151"),
            new NameAndCodeType("Appeals Court Single Justice - Civil", "8199"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.OK, result.type());
    assertEquals("8151", result.matches().get(0).getCode());
  }

  @Test
  public void fallsBackToSubstringWhenNoExactMatch() {
    List<NameAndCode> options = List.of(new NameAndCodeType("Civil Small Claims", "8155"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.OK, result.type());
    assertEquals("8155", result.matches().get(0).getCode());
  }

  @Test
  public void noMatchWhenNothingMatchesAnyFilter() {
    List<NameAndCode> options = List.of(new NameAndCodeType("Family", "9000"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.NO_MATCH, result.type());
    assertTrue(result.matches().isEmpty());
  }

  @Test
  public void ambiguousWhenMultipleMatchTheSameFilter() {
    List<NameAndCode> options =
        List.of(
            new NameAndCodeType("Civil Small Claims", "8155"),
            new NameAndCodeType("Civil Appeal", "8156"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.AMBIGUOUS, result.type());
    assertEquals(2, result.matches().size());
  }

  @Test
  public void secondFilterUsedWhenFirstMatchesNothing() {
    List<NameAndCode> options = List.of(new NameAndCodeType("Civil", "8151"));
    var result =
        CodeSearchMatcher.filterCodes(
            options, List.of("Appeals Court Single Justice - Civil", "Civil"));
    assertEquals(CodeSearchMatcher.ResultType.OK, result.type());
    assertEquals("8151", result.matches().get(0).getCode());
  }
}
