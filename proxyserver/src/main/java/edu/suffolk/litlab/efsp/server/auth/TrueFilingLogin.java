package edu.suffolk.litlab.efsp.server.auth;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.Jurisdiction;
import jakarta.ws.rs.core.MultivaluedMap;
import java.util.Map;
import java.util.Optional;

public class TrueFilingLogin implements LoginInterface {

  private final Jurisdiction jurisdiction;

  public TrueFilingLogin(Jurisdiction jurisdiction) {
    this.jurisdiction = jurisdiction;
  }

  @Override
  public Optional<LoginResult> login(JsonNode loginInfo) {
    // TrueFiling doesn't have a user account system, so nothing to do!
    return Optional.of(new LoginResult(Map.of(), Optional.empty()));
  }

  @Override
  public String getLoginName() {
    return "truefiling-" + jurisdiction.getName();
  }

  @Override
  public String getTokenHeaderValue(MultivaluedMap<String, String> headers) {
    return null;
  }

  @Override
  public String getUserIdHeaderValue(MultivaluedMap<String, String> headers) {
    return null;
  }
}
