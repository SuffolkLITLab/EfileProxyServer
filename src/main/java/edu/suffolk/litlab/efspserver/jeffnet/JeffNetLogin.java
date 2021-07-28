package edu.suffolk.litlab.efspserver.jeffnet;

import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.services.LoginInterface;

public class JeffNetLogin implements LoginInterface {
  
  @Override
  public Optional<String> login(JsonNode loginInfo) {
    // Just let the user directly pass us the JeffNet Token
    if (!loginInfo.isObject()
        || !loginInfo.has("token")
        || !loginInfo.get("token").isTextual()) {
      return Optional.empty();
    }
    return Optional.of(loginInfo.get("token").asText());
  }

}
