package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class InterviewVariable {
  /** An enum for how other variables rely on this one. */
  private String name;
  private String description;
  private String datatype;
  private List<String> choices;
  
  /** Default constructor, directly assing all variables from params. */
  public InterviewVariable(String name, String description, String datatype, 
      List<String> choices) {
    this.name = name;
    this.description = description;
    this.datatype = datatype;
    this.choices = choices;
  }
  
  public String getName() {
    return name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public String getDatatype() {
    return datatype;
  }
  
  public List<String> getChoices() {
    return choices;
  }
  
  public String toJson() {
      return """
             { 
               "name": "%s",
               "description": "%s",
               "datatype": "%s",
               "choices": %s
             }
             """.formatted(name, description, datatype, choices);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(name).append(' ').append(description).append(' ');
    sb.append(datatype).append(' ').append(choices).append(' ');
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
        && this.choices.equals(other.choices);
  }
  
  @Override
  public int hashCode() {
    HashCodeBuilder bd = new HashCodeBuilder();
    return bd.append(name).append(datatype).append(choices).build();
  }
}
