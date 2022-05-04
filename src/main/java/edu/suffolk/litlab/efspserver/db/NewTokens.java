package edu.suffolk.litlab.efspserver.db;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

@XmlRootElement(name="tokens")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewTokens {

  @JsonUnwrapped
  private final Map<String, String> tokens; 
  
  public NewTokens() {
    this.tokens = new HashMap<>();
  }
  public NewTokens(Map<String, String> tokens) {
    this.tokens = tokens;
  }
 
  public Map<String, String> getTokens() {
      return tokens;
  }
 
  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other instanceof NewTokens otherTokens) {
      return tokens.equals(otherTokens.tokens);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return tokens.hashCode();
  }
  
  @Override
  public String toString() {
    return tokens.toString();
  }
  
}
