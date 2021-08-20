package edu.suffolk.litlab.efspserver;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.LoginInfo;
import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetLogin;
import edu.suffolk.litlab.efspserver.services.LoginInterface;

/**
 * Language might be loose, but we try to use "Key" as a permanent
 * string (keep it secret!) that you use to authenticate with some
 * system. Kinda like a username and password, but combined as one
 * piece of info, not two.
 * 
 * "Token" on the other hand, holds the same purpose, but is ephemeral,
 * and not intended to be saved for a long time. The login token is
 * generated when the server receives an api key, and the client
 * should use the token for subsequent logins, not the key.
 *
 * @author litlab
 *
 */
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
   * @apiKey The api key that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login to
   * @return The new API Token that the REST client should now send to the Server
   */
  public Optional<String> login(String apiKey, String jsonLoginInfo) {
    Map<String, Function<JsonNode, Optional<Map<String, String>>>> loginFunctions = Map.of(
        "tyler", (info) -> tylerLoginObj.login(info),
        "jeffnet", (info) -> jeffNetLoginObj.login(info));
    
    try {
      return ld.login(apiKey,  jsonLoginInfo, loginFunctions);
    } catch (SQLException e) {
      log.error(e.toString());
      return Optional.empty();
    }
  }
  
  public boolean checkLogin(String activeToken) {
    return checkLogin(activeToken, "").isPresent();
  }

  public Optional<LoginInfo> checkLogin(String activeToken, String orgName) {
    try {
      return ld.checkLogin(activeToken, orgName);
    } catch (SQLException e) {
      log.error(e.toString());
      return Optional.empty();
    }
  }

  /**
   * Force a logout for the given active login token. 
   * 
   * Called when the user resets for a new Tyler password
   * @param activeToken
   * @return True if the given token was actually removed (i.e. it was presenet in the login table)
   */
  public boolean removeLogin(String activeToken) {
    try {
      ld.removeActiveToken(activeToken);
      return true;
    } catch (SQLException ex) {
      log.error(ex.toString());
      return false;
    }
  }

  /** Serves a similar purpose to {@link removeLogin}, but is used when the client resets 
   * someone else's Tyler password. */
  public boolean removeTylerUserId(String id) {
    try {
      ld.removeTylerUserId(id);
      return true;
    } catch (SQLException ex) {
      log.error(ex.toString());
      return false;
    }
  }
  
}
