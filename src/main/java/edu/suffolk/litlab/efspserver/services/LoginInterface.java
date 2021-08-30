package edu.suffolk.litlab.efspserver.services;

import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

public interface LoginInterface {
  
  Optional<Map<String, String>> login(JsonNode loginInfo);
  
  String getHeaderKey();

}
