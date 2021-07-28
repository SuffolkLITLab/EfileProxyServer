package edu.suffolk.litlab.efspserver;

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
  
  private static final String atRestTable = "at_rest_tokens";
  private static final String activeTable = "active_tokens";
  
  private static final String atRestCreate = """
           CREATE TABLE %s (
           "server_id" uuid PRIMARY KEY, "server_name" text, "api_token" text,
           "tyler_enabled" boolean, "jeffnet_enabled" boolean, 
           "created" timestamp)""".formatted(atRestTable);

  private static final String activeCreate = """
           CREATE TABLE %s (
           "server_id" uuid PRIMARY KEY, "active_token" text,
           "tyler_token" text, "jeffnet_token" text, 
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
    UUID apiToken = UUID.randomUUID();
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String insertIntoTable = """
                    INSERT INTO %s (
                        "server_id", "server_name", "api_token", "tyler_enabled",
                        "jeffnet_enabled", "created"
                    ) VALUES (
                      ?, ?, ?, ?,
                      ?, ?)""".formatted(atRestTable);
    PreparedStatement insertSt = conn.prepareStatement(insertIntoTable);
    insertSt.setObject(1, serverId);
    insertSt.setString(2, serverName);
    insertSt.setString(3, apiToken.toString());
    insertSt.setBoolean(4, tylerEnabled);
    insertSt.setBoolean(5, jeffNetEnabled);
    insertSt.setTimestamp(6, ts);
    insertSt.executeUpdate();
    return apiToken.toString();
  }
  
  /** 
   * Actually completes the REST client's login to the server. Completes each login to the 
   * EFMFiling Interfaces separately.
   *
   * @apiToken The api token that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login to
   * @return The new API Token that the REST client should now send to the Server
   */
  public Optional<String> login(String apiToken, String jsonLoginInfo, Map<String, Function<JsonNode, Optional<String>>> loginFunctions) throws SQLException {
    if (conn == null) {
      log.error("Connection in login wasn't open yet!");
      throw new SQLException();
    }
    String query = "SELECT server_id, server_name, api_token, tyler_enabled, "
        + " jeffnet_enabled, created"
        + " FROM " + atRestTable
        + " WHERE api_token = ?";

    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, apiToken);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) {
      log.warn("API Token not present in at rest: " + apiToken);
      return Optional.empty();
    }
    UUID serverId = (UUID) rs.getObject(1);
    // Check the other table first:
    String activeQuery = "SELECT server_id, active_token, expires_at FROM %s WHERE server_id = ?".formatted(activeTable);
    PreparedStatement activeSt = conn.prepareStatement(activeQuery);
    activeSt.setObject(1, serverId);
    ResultSet activeRs = activeSt.executeQuery();
    if (activeRs.next()) {
      if (isExpired(activeRs.getTimestamp(3))) {
        // Remove from old table, but keep going!
        removeActiveToken(activeRs.getString(2));
      } else {
        log.info("Returning maybe nullable: " + activeRs.getString(2));
        return Optional.ofNullable(activeRs.getString(2));
      }
    }
    
    boolean tylerEnabled = rs.getBoolean(4);
    boolean jeffNetEnabled = rs.getBoolean(5);
    // TODO(brycew): kinda hacky, how can this be modulized?
    Map<String, Boolean> enabled = Map.of("tyler", tylerEnabled, "jeffnet", jeffNetEnabled);
    Map<String, String> newTokens = new HashMap<String, String>();
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode loginInfo = mapper.readTree(jsonLoginInfo);
      if (!loginInfo.isObject()) {
        log.error("Can't login with a json that's not an object: " + loginInfo.toPrettyString());
        return Optional.empty();
      }
      Iterator<String> orgs = loginInfo.fieldNames();
      while (orgs.hasNext()) {
        String orgName = orgs.next().toLowerCase();
        if (!loginFunctions.containsKey(orgName) 
            || !enabled.containsKey(orgName)
            || !enabled.get(orgName)) {
          log.error("There is no " + orgName + " to login to: tyler enabled: " 
            + tylerEnabled + " jeffnet enabled: " + jeffNetEnabled);
          return Optional.empty();
        }
        Optional<String> newToken = loginFunctions.get(orgName).apply(loginInfo.get(orgName));
        if (newToken.isEmpty()) {
          log.error("Couldn't login to " + orgName);
          return Optional.empty();
        }
        newTokens.put(orgName, newToken.get());
      }
     
      UUID activeToken = UUID.randomUUID();
      Timestamp expire = new Timestamp(System.currentTimeMillis() + expirationTime);
      String insertActive = """
              INSERT INTO %s (
                  "server_id", "active_token", "tyler_token", "jeffnet_token", "expires_at"
              ) VALUES (
                ?, ?, ?, ?, ?)""".formatted(activeTable);
      PreparedStatement insertSt = conn.prepareStatement(insertActive);
      insertSt.setObject(1, serverId);
      insertSt.setString(2, activeToken.toString());
      if (newTokens.containsKey("tyler")) {
        insertSt.setString(3, newTokens.get("tyler"));
      } else {
        insertSt.setString(3, null);
      }
      if (newTokens.containsKey("jeffnet")) {
        insertSt.setString(4, newTokens.get("jeffnet"));
      } else {
        insertSt.setString(4, null);
      }
      insertSt.setTimestamp(5, expire);
      insertSt.executeUpdate();
      return Optional.of(activeToken.toString());
    } catch (JsonProcessingException e) {
      log.error(e.toString());
      return Optional.empty();
    }
  }
  
  public Optional<String> checkLogin(String activeToken, String orgName) throws SQLException {
    if (conn == null) {
      log.error("Connection in checkLogin wasn't open yet");
      throw new SQLException();
    }
    String query = """
            SELECT "server_id", "active_token", "tyler_token", "jeffnet_token", "expires_at"
            FROM %s
            WHERE active_token = ?""".formatted(activeTable);
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, activeToken);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) {
      log.error("Couldn't find an active token: " + activeToken);
      return Optional.empty();
    }
    Timestamp expires = rs.getTimestamp(5);
    if (isExpired(expires)) { 
      log.warn("Token expired! Removing");
      removeActiveToken(activeToken);
      return Optional.empty();
    }
    orgName = orgName.toLowerCase();
    if (orgName.equals("tyler")) {
      log.info("Getting for tyler: " + rs.getString(3));
      return Optional.ofNullable(rs.getString(3));
    }
    if (orgName.equals("jeffnet")) {
      log.info("Getting for jeffnet: " + rs.getString(4));
      return Optional.ofNullable(rs.getString(4));
    }
    if (!orgName.isBlank()) {
      log.error("What is " + orgName + "? Doesn't exist for active tokens");
      return Optional.empty();
    }
    // TODO(brycew): maybe make this better. What do we do for stuff without direct proxing?
    return Optional.of("");
  }
  
  private void removeActiveToken(String activeToken) throws SQLException {
    String rm = "DELETE FROM %s WHERE active_token = ?".formatted(activeTable);
    PreparedStatement rmSt = conn.prepareStatement(rm);
    rmSt.setString(1, activeToken);
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
    String newApiToken = ld.addNewUser(serverName, Boolean.parseBoolean(tylerEnabled), Boolean.parseBoolean(jeffnetEnabled));
    System.out.println("New Api Token for " + serverName + ": " + newApiToken);
  }
}
