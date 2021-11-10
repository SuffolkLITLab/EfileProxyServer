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
  private Map<String, String> tokens = new HashMap<>();
  
  public NewTokens() {}
  public NewTokens(Map<String, String> tokens) {
    this.tokens = tokens;
  }
 
  public Map<String, String> getTokens() {
      return tokens;
  }
 
  public void setEmployeeMap(Map<String, String> tokens) {
      this.tokens = tokens;
  }
}
