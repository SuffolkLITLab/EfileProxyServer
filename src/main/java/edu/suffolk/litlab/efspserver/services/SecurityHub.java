package edu.suffolk.litlab.efspserver.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.NewTokens;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetLogin;

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
  private final static Logger log = 
      LoggerFactory.getLogger(SecurityHub.class); 
  
  private final LoginInterface tylerLoginObj;
  private final LoginInterface jeffNetLoginObj;
  private final DataSource ds;
  
  public SecurityHub(DataSource ds, String jurisdiction) {
    this.ds = ds;
    this.tylerLoginObj = new TylerLogin(jurisdiction);
    this.jeffNetLoginObj = new JeffNetLogin();
  }

  /** 
   * Actually completes the REST client's login to the server. Completes each login to the 
   * EFMFiling Interfaces separately.
   *
   * @apiKey The api key that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login to
   * @return A map of expected Headers that subsequent calls should have to their expected values.
   *   For example, TYLER-TOKEN will have the provided Tyler email + ":" + password Hash, used to authenticate the
   *   user. 
   */
  public Optional<NewTokens> login(String apiKey, String jsonLoginInfo) {
    Map<String, Function<JsonNode, Optional<Map<String, String>>>> loginFunctions = Map.of(
        "tyler", (info) -> tylerLoginObj.login(info),
        "jeffnet", (info) -> jeffNetLoginObj.login(info));
    
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      return ld.login(apiKey,  jsonLoginInfo, loginFunctions);
    } catch (SQLException e) {
      log.error(e.toString());
      return Optional.empty();
    }
  }
  
  public Optional<AtRest> getAtRestInfo(String apiKey) {
    if (apiKey == null || apiKey.isBlank()) {
      return Optional.empty();
    }
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      return ld.getAtRestInfo(apiKey); 
    } catch (SQLException e) {
      log.error(e.toString());
      return Optional.empty();
    }
  }
  
  
  
}
