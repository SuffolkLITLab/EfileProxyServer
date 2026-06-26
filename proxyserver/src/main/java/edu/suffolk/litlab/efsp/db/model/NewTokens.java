package edu.suffolk.litlab.efsp.db.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "tokens")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewTokens {

  @JsonUnwrapped private final Map<String, String> tokens;
  private final Map<String, String> expirationTimes;

  public NewTokens() {
    this.tokens = Map.of();
    this.expirationTimes = Map.of();
  }

  public NewTokens(Map<String, String> tokens) {
    this.tokens = tokens;
    this.expirationTimes = Map.of();
  }

  public NewTokens(Map<String, String> tokens, Map<String, String> expirationTimes) {
    this.tokens = tokens;
    this.expirationTimes = expirationTimes;
  }

  public Map<String, String> getTokens() {
    return tokens;
  }

  public Map<String, String> getExpirationTimes() {
    return expirationTimes;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) {
      return false;
    }
    if (other instanceof NewTokens otherTokens) {
      return tokens.equals(otherTokens.tokens)
          && expirationTimes.equals(otherTokens.expirationTimes);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return tokens.hashCode() * 31 + expirationTimes.hashCode();
  }

  @Override
  public String toString() {
    return "tokens=" + tokens + ", expirationTimes=" + expirationTimes;
  }
}
