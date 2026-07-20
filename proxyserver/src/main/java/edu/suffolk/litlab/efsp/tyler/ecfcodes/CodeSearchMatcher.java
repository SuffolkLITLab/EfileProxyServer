package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Java port of filter_codes() from docassemble-EFSPIntegration's interview_logic.py.
public class CodeSearchMatcher {

  public enum ResultType {
    OK,
    NO_MATCH,
    AMBIGUOUS
  }

  public record MatchResult(ResultType type, List<NameAndCode> matches) {}

  private CodeSearchMatcher() {}

  public static MatchResult filterCodes(List<NameAndCode> options, List<String> filters) {
    List<Predicate<NameAndCode>> attempts = new ArrayList<>();
    for (String filter : filters) {
      attempts.add(exactMatch(filter));
    }
    for (String filter : filters) {
      attempts.add(substringMatch(filter));
    }

    for (Predicate<NameAndCode> attempt : attempts) {
      List<NameAndCode> matched = options.stream().filter(attempt).toList();
      if (!matched.isEmpty()) {
        return new MatchResult(matched.size() == 1 ? ResultType.OK : ResultType.AMBIGUOUS, matched);
      }
    }
    return new MatchResult(ResultType.NO_MATCH, List.of());
  }

  private static Predicate<NameAndCode> exactMatch(String filter) {
    String needle = filter.toLowerCase().strip();
    return opt -> opt.getName() != null && opt.getName().toLowerCase().strip().equals(needle);
  }

  private static Predicate<NameAndCode> substringMatch(String filter) {
    String needle = filter.toLowerCase();
    return opt -> opt.getName() != null && opt.getName().toLowerCase().contains(needle);
  }
}
