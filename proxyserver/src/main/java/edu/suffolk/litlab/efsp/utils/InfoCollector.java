package edu.suffolk.litlab.efsp.utils;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.BadCode;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.CodeError;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.CrossReferenceError;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.MissingRequiredRefs;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.MissingVar;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.NoMatchingCode;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.NoMatchingRef;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.RequiredCodeNotPresent;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.TextVarError;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.TooLongVar;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.WrongRefVal;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser.WrongVar;
import edu.suffolk.litlab.efsp.utils.InterviewVariable.VarBuilder;
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

  public InterviewVariable addCodeError(CodeError err, VarBuilder varBuilder) throws FilingError {
    switch (err) {
      case NoMatchingCode noMatch -> {
        var interviewVar =
            varBuilder
                .appendDesc(": no match found")
                .currentVal(noMatch.given())
                .choices(noMatch.options())
                .build();
        addWrong(interviewVar);
        return interviewVar;
      }
      case RequiredCodeNotPresent notPresent -> {
        var interviewVar = varBuilder.choices(notPresent.options()).build();
        addWrong(interviewVar);
        return interviewVar;
      }
      case BadCode badCode -> error(badCode.err());
    }
    return null;
  }

  public InterviewVariable addTextError(TextVarError err, VarBuilder varBuilder)
      throws FilingError {
    varBuilder.datatype("text");
    switch (err) {
      case MissingVar missing -> {
        varBuilder.appendDesc(", missing, must also match regex: " + missing.regex());
        var interviewVar = varBuilder.build();
        addRequired(interviewVar);
        return interviewVar;
      }
      case WrongVar wrong -> {
        varBuilder.appendDesc(": must match regex: " + wrong.regex()).currentVal(wrong.given());
        var interviewVar = varBuilder.build();
        addWrong(interviewVar);
        return interviewVar;
      }
      case TooLongVar tooLong -> {
        varBuilder
            .appendDesc(": can't exceed " + tooLong.length() + " characters")
            .currentVal(tooLong.given());
        var interviewVar = varBuilder.build();
        addWrong(interviewVar);
        return interviewVar;
      }
    }
  }

  public InterviewVariable addCrossRefError(CrossReferenceError err, VarBuilder varBuilder)
      throws FilingError {
    switch (err) {
      case NoMatchingRef noMatch -> {
        varBuilder.currentVal(noMatch.refCode() + ": " + noMatch.refVal());
        var interviewVar = varBuilder.build();
        addWrong(interviewVar);
        return interviewVar;
      }
      case WrongRefVal wrongRef -> {
        varBuilder
            .appendDesc(wrongRef.msg())
            .currentVal(wrongRef.refCode() + ":" + wrongRef.refVal());
        var interviewVar = varBuilder.build();
        addWrong(interviewVar);
        return interviewVar;
      }
      case MissingRequiredRefs missingReq -> {
        varBuilder.appendDesc("Needs all of the choices filled:").choices(missingReq.refCodes());
        var interviewVar = varBuilder.build();
        addRequired(interviewVar);
        return interviewVar;
      }
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

  public InterviewVariable.VarBuilder varBuilder() {
    return new InterviewVariable.VarBuilder(currentAttributeStack());
  }

  public InterviewVariable requestVar(
      String localName, String desc, List<String> choices, String currentVal) {
    return new InterviewVariable(
        currentAttributeStack() + localName, desc, "choice", choices, Optional.of(currentVal));
  }

  public InterviewVariable requestVar(String localName, String desc, List<String> choices) {
    return new InterviewVariable(
        currentAttributeStack() + localName, desc, "choice", choices, Optional.empty());
  }

  public InterviewVariable requestVar(String localName, String description, String datatype) {
    return requestVar(localName, description, datatype, List.of(), Optional.empty());
  }

  public String unwrap(Result<String, TextVarError> res, VarBuilder varBuilder) throws FilingError {
    if (res.isErr()) {
      addTextError(res.unwrapErrOrElseThrow(), varBuilder);
      return "";
    }
    return res.unwrapOrElseThrow();
  }

  public String unwrapCode(Result<String, CodeError> res, VarBuilder varBuilder)
      throws FilingError {
    if (res.isErr()) {
      addCodeError(res.unwrapErrOrElseThrow(), varBuilder);
      return "";
    }
    return res.unwrapOrElseThrow();
  }

  public Optional<String> unwrapOpt(Result<Optional<String>, CodeError> res, VarBuilder varBuilder)
      throws FilingError {
    if (res.isErr()) {
      addCodeError(res.unwrapErrOrElseThrow(), varBuilder);
      return Optional.empty();
    }
    return res.unwrapOrElseThrow();
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
