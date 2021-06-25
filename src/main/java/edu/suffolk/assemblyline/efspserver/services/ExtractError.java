package edu.suffolk.assemblyline.efspserver.services;

import java.util.Optional;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ExtractError {
  public enum Type {
    MalformedInterview, /// For when the json is somehow not well formed, or just plain wrong
    MissingRequired /// For when the json doesn't have a member that is needed, like "users"
  }
  
  public ExtractError(Type type) {
    this(type, Optional.empty(), Optional.empty());
  }
  
  /** A lazy constructor, because "" should really be an empty, and it's easier to call. */
  public ExtractError(Type type, String instanceName, String missingVariable) {
    this(type, Optional.of(instanceName), Optional.of(missingVariable));
    if (this.instanceName.orElse("").isBlank()) {
      this.instanceName = Optional.empty(); 
    }
    if (this.missingVariable.orElse("").isBlank()) {
      this.missingVariable = Optional.empty(); 
    }
  }
  
  public ExtractError(Type type, Optional<String> instanceName, Optional<String> missingVariable) {
    this.type = type;
    this.instanceName = instanceName;
    this.missingVariable = missingVariable;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof ExtractError)) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    
    ExtractError other = (ExtractError) obj;
    return this.type.equals(other.type) 
        && this.instanceName.equals(other.instanceName)
        && this.missingVariable.equals(other.missingVariable);
  }
  
  @Override
  public String toString() {
    return type.toString() + " " + instanceName + " " + missingVariable;
  }
  
  public Type getType() {
    return type;
  }
  
  public Optional<String> getInstanceName() {
    return instanceName;
  }
  
  public Optional<String> getMissingVariable() {
    return missingVariable;
  }
  
  @Override
  public int hashCode() {
    HashCodeBuilder bd = new HashCodeBuilder();
    return bd.append(type).append(instanceName).append(missingVariable).build();
  }

  private Type type;
  private Optional<String> instanceName;
  private Optional<String> missingVariable;
}

