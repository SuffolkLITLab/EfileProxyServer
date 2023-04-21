package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efspserver.services.LoginInterface;
import java.util.Map;
import java.util.Optional;

public class JeffNetLogin implements LoginInterface {

  @Override
  public Optional<Map<String, String>> login(JsonNode loginInfo) {
    // Just let the user directly pass us the JeffNet Key
    if (!loginInfo.isObject() || !loginInfo.has("key") || !loginInfo.get("key").isTextual()) {
      return Optional.empty();
    }
    return Optional.of(Map.of(getHeaderKey(), loginInfo.get("key").asText()));
  }

  @Override
  public String getHeaderKey() {
    return "JEFFNET-TOKEN";
  }

  @Override
  public String getLoginName() {
    return "jeffnet";
  }
}
