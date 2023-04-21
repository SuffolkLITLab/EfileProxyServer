package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import java.util.Optional;

public interface LoginInterface {

  Optional<Map<String, String>> login(JsonNode loginInfo);

  String getLoginName();

  String getHeaderKey();
}
