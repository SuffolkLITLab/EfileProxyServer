package edu.suffolk.litlab.efsp.utils;

import java.util.Collection;
import java.util.Optional;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.text.StringEscapeUtils;

public class InterviewVariable {
  /** An enum for how other variables rely on this one. */
  private final String name;

  private final String description;
  private final String datatype;
  private final Collection<String> choices;
  private final Optional<String> currentVal;

  /** Default constructor, directly assing all variables from params. */
  public InterviewVariable(
      String name,
      String description,
      String datatype,
      Collection<String> choices,
      Optional<String> currentVal) {
    this.name = name;
    this.description = description;
    this.datatype = datatype;
    this.choices = choices;
    this.currentVal = currentVal;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public InterviewVariable appendDesc(String newDescription) {
    return new InterviewVariable(name, description + newDescription, datatype, choices, currentVal);
  }

  public String getDatatype() {
    return datatype;
  }

  public String toJson() {
    String choicesStr = "[]";
    if (!choices.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      boolean firstTime = true;
      sb.append("[");
      for (String choice : choices) {
        if (!firstTime) {
          sb.append(",");
        }
        sb.append("\"").append(StringEscapeUtils.escapeJson(choice)).append("\"");
        firstTime = false;
      }
      sb.append("]");
      choicesStr = sb.toString();
    }
    return """
    {
      "name": "%s",
      "description": "%s",
      "datatype": "%s",
      "currentVal": "%s",
      "choices": %s
    }
    """
        .formatted(
            StringEscapeUtils.escapeJson(name),
            StringEscapeUtils.escapeJson(description),
            StringEscapeUtils.escapeJson(datatype),
            StringEscapeUtils.escapeJson(currentVal.orElse("")),
            choicesStr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[InterviewVariable: ");
    sb.append("name: `").append(name).append("`, ");
    sb.append("description: `").append(description).append("`, ");
    sb.append("datatype: `").append(datatype).append(", ");
    sb.append("choices: `").append(choices).append("`, ");
    sb.append("currentVal: `").append(currentVal).append("]");
    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof InterviewVariable)) {
      return false;
    }
    if (obj == this) {
      return true;
    }

    InterviewVariable other = (InterviewVariable) obj;
    return this.name.equals(other.name)
        && this.datatype.equals(other.datatype)
        && this.choices.equals(other.choices)
        && this.currentVal.equals(other.currentVal);
  }

  @Override
  public int hashCode() {
    HashCodeBuilder bd = new HashCodeBuilder();
    return bd.append(name).append(datatype).append(choices).append(currentVal).build();
  }
}
