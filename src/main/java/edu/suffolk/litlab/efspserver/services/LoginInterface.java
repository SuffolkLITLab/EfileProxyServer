package edu.suffolk.litlab.efspserver.services;

import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

public interface LoginInterface {
  
  Optional<String> login(JsonNode loginInfo);

}
