package edu.suffolk.litlab.efspserver;

import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import java.util.List;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Provide;
import net.jqwik.api.domains.DomainContextBase;

public class InterviewVariableExample extends DomainContextBase {

  @Provide
  Arbitrary<InterviewVariable> vars() {
    Arbitrary<List<String>> choicePossibilities = Arbitraries.strings().collect(l -> l.size() > 10);
    return Combinators.combine(
            Arbitraries.strings(),
            Arbitraries.strings(),
            Arbitraries.strings(),
            choicePossibilities,
            Arbitraries.strings().optional())
        .as(
            (name, description, datatype, choice, currentVal) -> {
              return new InterviewVariable(name, description, datatype, choice, currentVal);
            });
  }
}
