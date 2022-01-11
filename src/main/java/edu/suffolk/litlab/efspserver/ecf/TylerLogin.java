package edu.suffolk.litlab.efspserver.ecf;

import java.util.Map;
import java.util.Optional;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.services.LoginInterface;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;

public class TylerLogin implements LoginInterface {
  private static Logger log =
      LoggerFactory.getLogger(LoginInterface.class);

  private final EfmUserService userServiceFactory;
  private static final String HEADER_KEY = "TYLER-TOKEN";

  public TylerLogin(String jurisdiction) {
    Optional<EfmUserService> maybeUserFactory = SoapClientChooser.getEfmUserFactory(jurisdiction);
    if (maybeUserFactory.isPresent()) {
      userServiceFactory = maybeUserFactory.get(); 
    } else {
      throw new RuntimeException(jurisdiction + " not in SoapClientChooser for EFMUser");
    }
  }
  
  public static String getHeaderKeyStatic() {
    return HEADER_KEY;
  }

  @Override
  public Optional<Map<String, String>> login(JsonNode loginInfo) {
    if (!loginInfo.isObject()
        || !loginInfo.has("username")
        || !loginInfo.get("username").isTextual()) {
      log.warn("Tried to login without passing in a username");
      return Optional.empty();
    }
    String username = loginInfo.get("username").asText();
    log.info("Invoking User Auth for " + username);
    if (!loginInfo.has("password")
        || !loginInfo.get("password").isTextual()) {
      log.warn("Tried to login without passing in a password");
      return Optional.empty();
    }
    String password = loginInfo.get("password").asText();
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail(username);
    authReq.setPassword(password);
    if (authReq.getPassword() == null || authReq.getPassword().isBlank()) {
      return Optional.empty();
    }
    IEfmUserService userPort = makeUserPort(userServiceFactory);
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    if (!authRes.getError().getErrorCode().equals("0")) {
      log.warn("Got Tyler error when authing: " + authRes.getError().getErrorCode() + ", "
          + authRes.getError().getErrorText());
      return Optional.empty();
    } else {
      return Optional.of(Map.of(
          getHeaderKey(), authRes.getEmail() + ":" + authRes.getPasswordHash(),
          getHeaderId(), authRes.getUserID()));
    }
  }

  /** Creates a connection to Tyler's SOAP API WITHOUT any Auth headers.
   * Can be used to make an Auth request, or can have the header inserted later.
   *
   * @param EfmUserService the definition of the SOAP WSDL service
   * @return A port connection to the SOAP server
   */
  private static IEfmUserService makeUserPort(EfmUserService userService) {
    IEfmUserService port = userService.getBasicHttpBindingIEfmUserService();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }

  @Override
  public String getHeaderKey() {
    return HEADER_KEY; 
  }
  
  public static String getHeaderId() {
    return "TYLER-ID";
  }

}
