package edu.suffolk.litlab.efsp.server.auth;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.ws.rs.core.MultivaluedMap;
import java.util.Optional;

public interface LoginInterface {

  /** If LoginResult is present, login succeeded. */
  Optional<LoginResult> login(JsonNode loginInfo);

  String getLoginName();

  /**
   * Gets the required login token for all subsequent calls.
   *
   * @return might be null
   */
  String getTokenHeaderValue(MultivaluedMap<String, String> headers);

  /**
   * Gets the user ID of the user initiating these calls.
   *
   * @return might be null
   */
  String getUserIdHeaderValue(MultivaluedMap<String, String> headers);
}
