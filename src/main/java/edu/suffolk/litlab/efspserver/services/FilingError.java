package edu.suffolk.litlab.efspserver.services;

import java.util.Optional;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class FilingError extends Exception {
  private static final long serialVersionUID = 1L;

  public enum Type {
    MalformedInterview, /// For when the json is somehow not well formed, or just plain wrong
    MissingRequired, /// For when the json doesn't have a member that is needed, like "users"
    WrongValue,
    EfmReplyError,
    ServerError
  }
  
  /** Factory function to make an Server Error, with a human-readable description. */
  public static FilingError serverError(String description) {
    return new FilingError(Type.ServerError, description);
  }
  
  public static FilingError malformedInterview(String description) {
    return new FilingError(Type.MalformedInterview, description);
  }
  
  public static FilingError missingRequired(InterviewVariable missingVariable) {
    return new FilingError(Type.MissingRequired, "", Optional.of(missingVariable));
  }
  
  public static FilingError wrongValue(InterviewVariable rightVariableInfo) {
    return new FilingError(Type.WrongValue, "", Optional.of(rightVariableInfo));
  }
  
  private FilingError(Type type, String description) {
    this(type, description, Optional.empty());
  }
  
  private FilingError(Type type, String description, Optional<InterviewVariable> missingVariable) {
    this.type = type;
    this.description = description;
    this.missingVariable = missingVariable;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof FilingError)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    
    FilingError other = (FilingError) obj;
    return this.type.equals(other.type) 
        && this.description.equals(other.description)
        && this.missingVariable.equals(other.missingVariable);
  }
  
  @Override
  public String toString() {
    return type.toString() + " " + description + " " + missingVariable;
  }
  
  public String toJson() {
    if (type.equals(Type.ServerError)) {
      return """
             {
               "type": "Server Error",
               "description": "%s"
             }
             """.formatted(this.description);
    } else if (type.equals(Type.MalformedInterview)) {
      return """
             {
               "type": "Malformed Interview",
               "description": "%s"
             }
             """.formatted(this.description);
    } else if (missingVariable.isPresent()){ // Missing Required
      InterviewVariable var = missingVariable.get();
      return var.toJson();
    }
    return """
        {
          "type": "Unknown",
          "description": "%s"
        }
        """.formatted(this.type + " :: " + this.description); 
  }
  
  public Type getType() {
    return type;
  }
  
  public String getDescription() {
    return description;
  }
  
  public Optional<InterviewVariable> getMissingVariable() {
    return missingVariable;
  }
  
  @Override
  public int hashCode() {
    HashCodeBuilder bd = new HashCodeBuilder();
    return bd.append(type).append(description).append(missingVariable).build();
  }

  private Type type;
  private String description;
  private Optional<InterviewVariable> missingVariable;
}

