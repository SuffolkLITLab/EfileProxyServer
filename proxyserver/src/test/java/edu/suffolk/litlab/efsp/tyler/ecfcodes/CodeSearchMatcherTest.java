package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CodeSearchMatcherTest {

  @Test
  public void exactMatchWinsOverSubstring() {
    var options =
        List.of(
            new NameAndCode("Civil", "8151"),
            new NameAndCode("Appeals Court Single Justice - Civil", "8199"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.OK, result.type());
    assertEquals("8151", result.matches().get(0).getCode());
  }

  @Test
  public void fallsBackToSubstringWhenNoExactMatch() {
    var options = List.of(new NameAndCode("Civil Small Claims", "8155"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.OK, result.type());
    assertEquals("8155", result.matches().get(0).getCode());
  }

  @Test
  public void noMatchWhenNothingMatchesAnyFilter() {
    var options = List.of(new NameAndCode("Family", "9000"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.NO_MATCH, result.type());
    assertTrue(result.matches().isEmpty());
  }

  @Test
  public void ambiguousWhenMultipleMatchTheSameFilter() {
    var options =
        List.of(
            new NameAndCode("Civil Small Claims", "8155"), new NameAndCode("Civil Appeal", "8156"));
    var result = CodeSearchMatcher.filterCodes(options, List.of("Civil"));
    assertEquals(CodeSearchMatcher.ResultType.AMBIGUOUS, result.type());
    assertEquals(2, result.matches().size());
  }

  @Test
  public void secondFilterUsedWhenFirstMatchesNothing() {
    var options = List.of(new NameAndCode("Civil", "8151"));
    var result =
        CodeSearchMatcher.filterCodes(
            options, List.of("Appeals Court Single Justice - Civil", "Civil"));
    assertEquals(CodeSearchMatcher.ResultType.OK, result.type());
    assertEquals("8151", result.matches().get(0).getCode());
  }
}
