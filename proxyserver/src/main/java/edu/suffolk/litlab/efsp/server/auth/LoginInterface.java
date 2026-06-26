package edu.suffolk.litlab.efsp.server.auth;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Optional;

public interface LoginInterface {

  Optional<LoginResult> login(JsonNode loginInfo);

  String getLoginName();

  String getHeaderKey();
}
