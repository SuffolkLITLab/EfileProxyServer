package edu.suffolk.litlab.efsp.utils;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;

public abstract class InfoCollector {
  public enum Dep {
    /**
     * A foundational variable is used to complete other, non-nested variables. For example, `users`
     * and `user_started_case` are both foundational to `defendants`
     */
    FOUNDATIONAL,
    /**
     * A required variable is needed for filing, but the parsing into variables can continue without
     * it. An example of this is that user[0] needs an email, but none of the other users do, and
     * you can create the entire filing without one.
     */
    REQUIRED,
    /**
     * Optional variables aren't necessary, and are only for extra info, like addresses for all
     * parties to the case.
     */
    OPTIONAL
  }

  protected List<InterviewVariable> optionalVars;
  protected List<InterviewVariable> requiredVars;
  protected List<InterviewVariable> wrongVars;
  protected Optional<FilingError> err;
  protected Stack<String> variableAttributes;

  public InfoCollector() {
    this.err = Optional.empty();
    this.optionalVars = new ArrayList<InterviewVariable>();
    this.requiredVars = new ArrayList<InterviewVariable>();
    this.variableAttributes = new Stack<String>();
    this.wrongVars = new ArrayList<InterviewVariable>();
  }

  public void error(FilingError err) throws FilingError {
    this.err = Optional.of(err);
    throw err;
  }

  public boolean hasError() {
    return this.err.isPresent();
  }

  /**
   * Says if the Info collector is finished with the current unit of information and should break
   * control flow and return.
   */
  public abstract boolean finished();

  public boolean okToSubmit() {
    if (err.isPresent() || !requiredVars.isEmpty() || !wrongVars.isEmpty()) {
      return false;
    }
    return true;
  }

  public void addRequired(InterviewVariable var) throws FilingError {
    requiredVars.add(var);
    if (finished()) {
      throw FilingError.missingRequired(var);
    }
  }

  public void addOptional(InterviewVariable var) {
    optionalVars.add(var);
  }

  public void addWrong(InterviewVariable var) throws FilingError {
    wrongVars.add(var);
    if (finished()) {
      throw FilingError.wrongValue(var);
    }
  }

  public void pushAttributeStack(String variableName) {
    variableAttributes.push(variableName);
  }

  /** Should never throw exceptions, that's a silly java thing. */
  public void popAttributeStack() {
    try {
      variableAttributes.pop();
    } catch (EmptyStackException ex) {
      // do nothing
    }
  }

  private String currentAttributeStack() {
    String x = variableAttributes.stream().collect(Collectors.joining("."));
    if (x.isEmpty()) {
      return x;
    } else {
      return x + ".";
    }
  }

  public List<InterviewVariable> getRequired() {
    return requiredVars;
  }

  public List<InterviewVariable> getOptional() {
    return optionalVars;
  }

  public List<InterviewVariable> getWrong() {
    return wrongVars;
  }

  /**
   * Creates an InterviewVariable with the correct stack information in the variable name.
   *
   * @param localName
   * @param desc
   * @param datatype
   * @param choices
   * @param currentVal the current value (if any) of the variable in this round of processing
   * @return
   */
  public InterviewVariable requestVar(
      String localName,
      String desc,
      String datatype,
      List<String> choices,
      Optional<String> currentVal) {
    return new InterviewVariable(
        currentAttributeStack() + localName, desc, datatype, choices, currentVal);
  }

  public InterviewVariable requestVar(String localName, String description, String datatype) {
    return requestVar(localName, description, datatype, List.of(), Optional.empty());
  }

  public String jsonSummary() {
    if (err.isPresent()) {
      return "{\"error\": " + err.get().toJson() + "}";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("{\"required_vars\": [");
    sb.append(requiredVars.stream().map((v) -> v.toJson()).collect(Collectors.joining(", ")));
    sb.append("], \"optional_vars\": [");
    sb.append(optionalVars.stream().map((v) -> v.toJson()).collect(Collectors.joining(", ")));
    sb.append("], \"wrong_vars\": [");
    sb.append(wrongVars.stream().map((v) -> v.toJson()).collect(Collectors.joining(", ")));
    sb.append("]}");

    return sb.toString();
  }
}
