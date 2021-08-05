package edu.suffolk.litlab.efspserver.ecf;

import java.net.URL;
import java.util.Optional;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.services.LoginInterface;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;

public class TylerLogin implements LoginInterface {
  private static Logger log = 
      LoggerFactory.getLogger(LoginInterface.class); 

  private EfmUserService userServiceFactory;

  public TylerLogin() {
    URL userWsdlUrl = EfmUserService.WSDL_LOCATION;
    userServiceFactory = makeUserServiceFactory(userWsdlUrl);
  }
  @Override
  public Optional<String> login(JsonNode loginInfo) {
    log.info("Invoking User Auth for " + loginInfo.toPrettyString()); 
    if (!loginInfo.isObject()
        || !loginInfo.has("username")
        || !loginInfo.get("username").isTextual()) {
      log.warn("Tried to login without passing in a username");
      return Optional.empty();
    }
    String username = loginInfo.get("username").asText();
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
      log.warn("Got Tyler error when authing: " + authRes.toString());
      return Optional.empty(); 
    } else {
      return Optional.of(authRes.getEmail() + ":" + authRes.getPasswordHash()); 
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

  public static EfmUserService makeUserServiceFactory(URL userWsdlUrl) {
    return new EfmUserService(userWsdlUrl, EfmUserService.SERVICE);
  }

}
