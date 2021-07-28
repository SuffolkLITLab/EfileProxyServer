package edu.suffolk.litlab.efspserver;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetLogin;
import edu.suffolk.litlab.efspserver.services.LoginInterface;

public class SecurityHub {
  private static Logger log = 
      LoggerFactory.getLogger(SecurityHub.class); 
  
  private LoginDatabase ld;
  private LoginInterface tylerLoginObj;
  private LoginInterface jeffNetLoginObj;
  
  public SecurityHub(LoginDatabase ld) {
    this.ld = ld;
    this.tylerLoginObj = new TylerLogin();
    this.jeffNetLoginObj = new JeffNetLogin();
  }

  /** 
   * Actually completes the REST client's login to the server. Completes each login to the 
   * EFMFiling Interfaces separately.
   *
   * @apiToken The api token that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login to
   * @return The new API Token that the REST client should now send to the Server
   */
  public Optional<String> login(String apiToken, String jsonLoginInfo) {
    Map<String, Function<JsonNode, Optional<String>>> loginFunctions = Map.of(
        "tyler", (info) -> tylerLoginObj.login(info),
        "jeffnet", (info) -> jeffNetLoginObj.login(info));
    
    try {
      return ld.login(apiToken,  jsonLoginInfo, loginFunctions);
    } catch (SQLException e) {
      log.error(e.toString());
      return Optional.empty();
    }
  }
  
  public boolean checkLogin(String activeToken) {
    return checkLogin(activeToken, "").isPresent();
  }

  public Optional<String> checkLogin(String activeToken, String orgName) {
    try {
      return ld.checkLogin(activeToken, orgName);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      log.error(e.toString());
      return Optional.empty();
    }
  }
  
}
