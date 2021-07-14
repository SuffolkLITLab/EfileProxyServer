package edu.suffolk.litlab.efspserver.services;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public abstract class InfoCollector {
  public enum Dep {
    /** A foundational variable is used to complete other, non-nested variables.
     * For example, `users` and `user_started_case` are both foundational to `defendants`
     */
    FOUNDATIONAL, 
    /** A required variable is needed for filing, but the parsing into variables can
     * continue without it. An example of this is that user[0] needs an email, but none
     * of the other users do, and you can create the entire filing without one.
     */
    REQUIRED,
    /** Optional variables aren't necessary, and are only for extra info, like addresses for all
     * parties to the case. */
    OPTIONAL
  }
  
  protected List<InterviewVariable> optionalVars;
  protected List<InterviewVariable> requiredVars;
  protected Optional<ExtractError> err;
  protected Stack<String> variableAttributes;
  
  public InfoCollector() {
    this.err = Optional.empty();
    this.optionalVars = new ArrayList<InterviewVariable>();
    this.requiredVars = new ArrayList<InterviewVariable>();
    this.variableAttributes = new Stack<String>();
  }
  
  public void error(ExtractError err) {
    this.err = Optional.of(err);
  }
  
  /** Says if the Info collector is finished with the current unit of 
   * information and should break control flow and return. */
  public abstract boolean finished();
  
  public boolean okToSubmit() {
    if (err.isPresent() || !requiredVars.isEmpty()) { 
      return false;
    }
    return true;
  }
  
  public void addRequired(InterviewVariable var) {
    requiredVars.add(var);
  }

  public void addOptional(InterviewVariable var) {
    optionalVars.add(var);
  }

  public void pushAttributeStack(String variableName) {
    variableAttributes.push(variableName);
  }
  
  public void popAttributeStack() {
    variableAttributes.pop();
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
  
  /**
   * Creates an InterviewVariable with the correct stack information in the variable name.
   * @param localName
   * @param desc
   * @param datatype
   * @param choices
   * @return
   */
  public InterviewVariable requestVar(String localName, String desc, 
      String datatype, List<String> choices) {
    return new InterviewVariable(currentAttributeStack() + localName, desc, datatype, choices);
  }
  
  public InterviewVariable requestVar(String localName, String description, String datatype) {
    return requestVar(localName, description, datatype, List.of());
  }

  public String jsonSummary() {
    if (err.isPresent()) {
      return "{\"error\": {" + err.get().toJson() + "}}";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("{\"required_vars\": ["); 
    sb.append(requiredVars.stream()
        .map((v) -> v.toJson())
        .collect(Collectors.joining(", ")));
    sb.append("], \"optional_vars\": [");
    sb.append(optionalVars.stream()
        .map((v) -> v.toJson())
        .collect(Collectors.joining(", ")));
    sb.append("]}");
    return sb.toString();
  }
}
