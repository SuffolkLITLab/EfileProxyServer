package edu.suffolk.litlab.efspserver.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;

public class LoginDatabase extends DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(LoginDatabase.class); 
  
  private static final String atRestTable = "at_rest_keys";
  private static final String activeTable = "active_tokens";
  
  private static final String atRestCreate = """
           CREATE TABLE %s (
           "server_id" uuid PRIMARY KEY, "server_name" text, "api_key" text NOT NULL,
           "tyler_enabled" boolean, "jeffnet_enabled" boolean, 
           "created" timestamp)""".formatted(atRestTable);

  private static final String activeCreate = """
           CREATE TABLE %s (
           "server_id" uuid PRIMARY KEY, "active_token" text NOT NULL,
           "tyler_token" text, "tyler_id" text, "jeffnet_token" text, 
           "expires_at" timestamp)""".formatted(activeTable);

  private final long expirationTime;

  public LoginDatabase(String pgUrl, int pgPort, String pgDb) {
    super(pgUrl, pgPort, pgDb);
    this.expirationTime = 3_600_000; // Expire 1 hour from login 
  }

  public LoginDatabase(String pgFullUrl, String pgDb) {
    super(pgFullUrl, pgDb);
    this.expirationTime = 3_600_000; // Expire 1 hour from login 
  }
  
  public void createTablesIfAbsent() throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    
    List<String> tableNames = List.of(atRestTable, activeTable);
    List<String> creates = List.of(atRestCreate, activeCreate);
    String tableExistsQuery = CodeTableConstants.getTableExists();
    for (int i = 0; i < tableNames.size(); i++) {
      PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery);
      existsSt.setString(1, tableNames.get(i));
      ResultSet rs = existsSt.executeQuery();
      if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
        // TODO(brycew): should the token be a string, or UUID?
        String createQuery = creates.get(i); 
        PreparedStatement createSt = conn.prepareStatement(createQuery);
        log.info("Full statement: " + createSt.toString());
        int retVal = createSt.executeUpdate();
        if (retVal < 0) {
          log.warn("Issue when creating " + tableNames.get(i) + ": retVal == " + retVal);
        }
      }
    }
  }
  
  public String addNewUser(String serverName, boolean tylerEnabled, boolean jeffNetEnabled) throws SQLException {
    if (conn == null) {
      log.error("Connection in addNewUser wasn't open yet!");
      throw new SQLException();
    }
    UUID serverId = UUID.randomUUID();
    UUID apiKey = UUID.randomUUID();
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String insertIntoTable = """
                    INSERT INTO %s (
                        "server_id", "server_name", "api_key", "tyler_enabled",
                        "jeffnet_enabled", "created"
                    ) VALUES (
                      ?, ?, ?, ?,
                      ?, ?)""".formatted(atRestTable);
    PreparedStatement insertSt = conn.prepareStatement(insertIntoTable);
    insertSt.setObject(1, serverId);
    insertSt.setString(2, serverName);
    insertSt.setString(3, apiKey.toString());
    insertSt.setBoolean(4, tylerEnabled);
    insertSt.setBoolean(5, jeffNetEnabled);
    insertSt.setTimestamp(6, ts);
    insertSt.executeUpdate();
    return apiKey.toString();
  }
  
  private class AtRest {
    UUID serverId;
    Map<String, Boolean> enabled;
  }
  
  private Optional<AtRest> getAtRestInfo(String apiKey) throws SQLException {
    String query = "SELECT server_id, server_name, api_key, tyler_enabled, "
        + " jeffnet_enabled, created"
        + " FROM " + atRestTable
        + " WHERE api_key = ?";

    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, apiKey);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) {
      log.warn("API Key not present in at rest: " + apiKey);
      return Optional.empty();
    }
    AtRest atRest = new AtRest();
    atRest.serverId = (UUID) rs.getObject(1);
    atRest.enabled = Map.of("tyler", rs.getBoolean(4), "jeffnet", rs.getBoolean(5));
    return Optional.of(atRest);
  }
  
  /** 
   * Actually completes the REST client's login to the server. Completes each login to the 
   * EFMFiling Interfaces separately.
   *
   * @apiKey The api key that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login to
   * @return The new API Token that the REST client should now send to the Server
   */
  public Optional<String> login(String apiKey, String jsonLoginInfo, 
      Map<String, Function<JsonNode, Optional<Map<String, String>>>> loginFunctions) throws SQLException {
    if (conn == null) {
      log.error("Connection in login wasn't open yet!");
      throw new SQLException();
    }
    Optional<AtRest> atRest = getAtRestInfo(apiKey);
    if (atRest.isEmpty()) {
      return Optional.empty();
    }

    ObjectMapper mapper = new ObjectMapper();
    JsonNode loginInfo;
    try {
      loginInfo = mapper.readTree(jsonLoginInfo);
    } catch (JsonProcessingException e) {
      log.error(e.toString());
      return Optional.empty();
    }

    // Check the other table first:
    String activeQuery = """
        SELECT server_id, active_token, expires_at, tyler_token, tyler_id, jeffnet_token 
        FROM %s WHERE server_id = ?""".formatted(activeTable);
    PreparedStatement activeSt = conn.prepareStatement(activeQuery);
    activeSt.setObject(1, atRest.get().serverId);
    ResultSet activeRs = activeSt.executeQuery();
    if (activeRs.next()) {
      if (isExpired(activeRs.getTimestamp(3))) {
        // Remove from old table, but keep going!
        removeActiveToken(activeRs.getString(2));
      } else {
        String tylerToken = activeRs.getString(4);
        String jeffNetToken = activeRs.getString(6);
        boolean newTyler = (tylerToken == null && loginInfo.has("tyler"));
        boolean newJeffNet = (jeffNetToken == null && loginInfo.has("jeffnet"));
        if (!newTyler && !newJeffNet) {
          log.info("Returning Existing active token: " + activeRs.getString(2));
          return Optional.ofNullable(activeRs.getString(2));
        }
      }
    }
    
    // TODO(brycew): the only hacky part, how can this be modulized?
    Map<String, String> newTokens = new HashMap<String, String>();
    if (!loginInfo.isObject()) {
      log.error("Can't login with a json that's not an object: " + loginInfo.toPrettyString());
      return Optional.empty();
    }
    Iterator<String> orgs = loginInfo.fieldNames();
    while (orgs.hasNext()) {
      String orgName = orgs.next().toLowerCase();
      if (orgName.equalsIgnoreCase("api_key")) {
        continue;
      }
      if (!loginFunctions.containsKey(orgName) 
          || !atRest.get().enabled.containsKey(orgName)
          || !atRest.get().enabled.get(orgName)) {
        log.error("There is no " + orgName + " to login to: enabled map: " + atRest.get().enabled); 
        return Optional.empty();
      }
      Optional<Map<String, String>> newToken = loginFunctions.get(orgName).apply(loginInfo.get(orgName));
      if (newToken.isEmpty()) {
        log.error("Couldn't login to " + orgName);
        return Optional.empty();
      }
      log.info("New tokens: " + newToken.get());
      newTokens.putAll(newToken.get());
    }
    for (Map.Entry<String, Boolean> enab : atRest.get().enabled.entrySet()) {
      if (enab.getValue() && !newTokens.containsKey(enab.getKey())) {
        log.warn(enab.getKey() + " enabled, but didn't attempt to login");
      }
    }
     
    UUID activeToken = UUID.randomUUID();
    Timestamp expire = new Timestamp(System.currentTimeMillis() + expirationTime);
    String insertActive = """
            INSERT INTO %s (
              "server_id", "active_token", "tyler_token", "tyler_id", "jeffnet_token", "expires_at"
            ) VALUES (
              ?, ?, ?, ?, ?, ?
            ) ON CONFLICT (server_id) DO UPDATE SET 
              active_token=?, tyler_token=?, tyler_id=?, jeffnet_token=?, expires_at=?""".formatted(activeTable);
    PreparedStatement insertSt = conn.prepareStatement(insertActive);
    insertSt.setObject(1, atRest.get().serverId);
    insertSt.setString(2, activeToken.toString());
    insertSt.setString(7, activeToken.toString());
    insertSt.setString(3, newTokens.getOrDefault("tyler_token", null));
    insertSt.setString(8, newTokens.getOrDefault("tyler_token", null));
    insertSt.setString(4, newTokens.getOrDefault("tyler_id", null));
    insertSt.setString(9, newTokens.getOrDefault("tyler_id", null));
    insertSt.setString(5, newTokens.getOrDefault("jeffnet_token", null));
    insertSt.setString(10, newTokens.getOrDefault("jeffnet_token", null));
    insertSt.setTimestamp(6, expire);
    insertSt.setTimestamp(11, expire);
    insertSt.executeUpdate();
    return Optional.of(activeToken.toString());
  }
  
  public Optional<LoginInfo> checkLogin(String activeToken, String orgName) throws SQLException {
    if (conn == null) {
      log.error("Connection in checkLogin wasn't open yet");
      throw new SQLException();
    }
    String query = """
            SELECT "server_id", "active_token", "tyler_token", "tyler_id", "jeffnet_token", "expires_at"
            FROM %s
            WHERE active_token=?""".formatted(activeTable);
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, activeToken);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) {
      log.error("Couldn't find an active token: " + activeToken);
      return Optional.empty();
    }
    Timestamp expires = rs.getTimestamp(6);
    if (isExpired(expires)) { 
      log.warn("Token expired! Removing");
      removeActiveToken(activeToken);
      return Optional.empty();
    }
    UUID serverId = (UUID) rs.getObject(1);
    if (orgName.equalsIgnoreCase("tyler")) {
      log.info("Getting for tyler: " + rs.getString(3));
      String token = rs.getString(3);
      if (token == null) {
        return Optional.empty();
      }
      return Optional.of(new LoginInfo(serverId, rs.getString(4), token)); 
    }
    if (orgName.equalsIgnoreCase("jeffnet")) {
      String token = rs.getString(5);
      log.info("Getting for jeffnet: " + token); 
      if (token == null) {
        return Optional.empty();
      }
      return Optional.of(new LoginInfo(serverId, token)); 
    }
    if (!orgName.isBlank()) {
      log.error("What is " + orgName + "? Doesn't exist for active tokens");
      return Optional.empty();
    }
    // TODO(brycew): maybe make this better. What do we do for stuff without direct proxing?
    return Optional.of(new LoginInfo(serverId, ""));
  }
  
  public void removeActiveToken(String activeToken) throws SQLException {
    String rm = "DELETE FROM %s WHERE active_token = ?".formatted(activeTable);
    PreparedStatement rmSt = conn.prepareStatement(rm);
    rmSt.setString(1, activeToken);
    rmSt.executeUpdate();
  }

  public void removeTylerUserId(String id) throws SQLException {
    String rm = "DELETE FROM %s WHERE tyler_id=?".formatted(activeTable);
    PreparedStatement rmSt = conn.prepareStatement(rm);
    rmSt.setString(1, id);
    rmSt.executeUpdate();
  }
  
  private boolean isExpired(Timestamp expires) {
    Timestamp now = new Timestamp(System.currentTimeMillis());
    return now.after(expires);
  }
  
  public static void main(final String args[]) throws SQLException {
    if (args.length != 3) {
      System.out.println("Only 3 params: server name, tyler enabled, jeffnet enabled");
    }
    String serverName = args[0];
    String tylerEnabled = args[1];
    String jeffnetEnabled = args[2];
    
    LoginDatabase ld = new LoginDatabase(System.getenv("POSTGRES_URL"), 
        Integer.parseInt(System.getenv("POSTGRES_PORT")), System.getenv("POSTGRES_USER_DB"));
    ld.createDbConnection(System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"));
    ld.setAutocommit(true);
    String newApiKey = ld.addNewUser(serverName, Boolean.parseBoolean(tylerEnabled), 
        Boolean.parseBoolean(jeffnetEnabled));
    System.out.println("New Api Key for " + serverName + ": " + newApiKey);
  }

}
