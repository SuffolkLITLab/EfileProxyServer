package edu.suffolk.litlab.efsp.server.auth;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerJurisdiction;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType;

public class TylerLogin implements LoginInterface {
  private static Logger log = LoggerFactory.getLogger(LoginInterface.class);

  private final TylerUserFactory userServiceFactory;
  private static final String HEADER_KEY_PREFIX = "TYLER-TOKEN";
  private final TylerJurisdiction jurisdiction;

  public TylerLogin(TylerDomain domain) {
    this.jurisdiction = domain.jurisdiction();
    Optional<TylerUserFactory> maybeUserFactory = TylerClients.getEfmUserFactory(domain);
    if (maybeUserFactory.isPresent()) {
      userServiceFactory = maybeUserFactory.get();
    } else {
      throw new RuntimeException(domain + " not in SoapClientChooser for EFMUser");
    }
  }

  public static String getHeaderKeyFromJurisdiction(TylerJurisdiction jurisdiction) {
    return HEADER_KEY_PREFIX + "-" + jurisdiction.getName().toUpperCase();
  }

  @Override
  public Optional<Map<String, String>> login(JsonNode loginInfo) {
    if (!loginInfo.isObject()
        || !loginInfo.has("username")
        || !loginInfo.get("username").isTextual()) {
      log.warn("Tried to login without passing in `username`");
      return Optional.empty();
    }
    String username = loginInfo.get("username").asText();
    if (!loginInfo.has("password") || !loginInfo.get("password").isTextual()) {
      log.warn("Tried to login without passing in `password`");
      return Optional.empty();
    }
    String password = loginInfo.get("password").asText();
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail(username);
    authReq.setPassword(password);
    if (authReq.getPassword() == null || authReq.getPassword().isBlank()) {
      return Optional.empty();
    }
    TylerUserClient userClient =
        userServiceFactory.makeUserClient(ServiceHelpers::setupServicePort);
    AuthenticateResponseType authRes = userClient.authenticateUser(authReq);
    if (!authRes.getError().getErrorCode().equals("0")) {
      log.warn(
          "Got Tyler error when authing: "
              + authRes.getError().getErrorCode()
              + ", "
              + authRes.getError().getErrorText());
      return Optional.empty();
    } else {
      return Optional.of(
          Map.of(
              getHeaderKey(),
              authRes.getEmail() + ":" + authRes.getPasswordHash(),
              getHeaderId(jurisdiction),
              authRes.getUserID()));
    }
  }

  @Override
  public String getHeaderKey() {
    return getHeaderKeyFromJurisdiction(this.jurisdiction);
  }

  @Override
  public String getLoginName() {
    return "tyler-" + this.jurisdiction.getName();
  }

  public static String getHeaderId(TylerJurisdiction jurisdiction) {
    return "TYLER-ID-" + jurisdiction.getName().toUpperCase();
  }
}
