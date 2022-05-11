package edu.suffolk.litlab.efspserver.db;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.RandomString;
import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;

public class LoginDatabase implements DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(LoginDatabase.class); 
  
  private static final String atRestCreate = """
           CREATE TABLE at_rest_keys (
           "server_id" uuid PRIMARY KEY, "server_name" text, "api_key" text NOT NULL,
           "tyler_enabled" boolean, "jeffnet_enabled" boolean, 
           "created" timestamp)"""; 
  
  private static final String atRestInsert = """
           INSERT INTO at_rest_keys (
               "server_id", "server_name", "api_key", "tyler_enabled",
               "jeffnet_enabled", "created"
           ) VALUES (
               ?, ?, ?, ?,
               ?, ?)"""; 

  private static RandomString tokenGenerator = new RandomString();
  private final Connection conn;
  private final MessageDigest digest;

  public LoginDatabase(Connection conn) throws NoSuchAlgorithmException {
    this.digest = MessageDigest.getInstance("SHA-256");
    this.conn = conn;
  }
  
  public Connection getConnection() {
    return conn;
  }

  @Override
  public void createTablesIfAbsent() throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    
    List<String> tableNames = List.of("at_rest_keys");
    List<String> creates = List.of(atRestCreate); 
    String tableExistsQuery = CodeTableConstants.getTableExists();
    for (int i = 0; i < tableNames.size(); i++) {
      try (PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery)) {
        existsSt.setString(1, tableNames.get(i));
        ResultSet rs = existsSt.executeQuery();
        if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
          String createQuery = creates.get(i); 
          try (PreparedStatement createSt = conn.prepareStatement(createQuery)) {
            log.info("Full statement: " + createSt.toString());
            int retVal = createSt.executeUpdate();
            if (retVal < 0) {
              log.warn("Issue when creating " + tableNames.get(i) + ": retVal == " + retVal);
            }
          }
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
    String apiKey = tokenGenerator.nextString();
    String hash = makeHash(apiKey);
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    try (PreparedStatement insertSt = conn.prepareStatement(atRestInsert)) {
      insertSt.setObject(1, serverId);
      insertSt.setString(2, serverName);
      insertSt.setString(3, hash);
      insertSt.setBoolean(4, tylerEnabled);
      insertSt.setBoolean(5, jeffNetEnabled);
      insertSt.setTimestamp(6, ts);
      insertSt.executeUpdate();
    }
    return apiKey;
  }
  
  public Optional<AtRest> getAtRestInfo(String apiKey) throws SQLException {
    String hash = makeHash(apiKey);
    String query = """
        SELECT server_id, server_name, api_key, tyler_enabled,
            jeffnet_enabled, created
        FROM at_rest_keys 
        WHERE api_key = ?""";

    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, hash);
      ResultSet rs = st.executeQuery();
      if (!rs.next()) {
        log.warn("API Key hash not present in at rest: " + hash);
        return Optional.empty();
      }
      AtRest atRest = new AtRest();
      atRest.serverId = (UUID) rs.getObject(1);
      atRest.enabled = Map.of("tyler", rs.getBoolean(4), "jeffnet", rs.getBoolean(5));
      atRest.serverName = rs.getString(2);
      atRest.created = rs.getTimestamp(6);
      return Optional.of(atRest);
    }
  }
  
  public String makeHash(String input) {
    return new String(Hex.encode(digest.digest(input.getBytes(StandardCharsets.UTF_8))));
  }
  
  /** 
   * Actually completes the REST client's login to the server. Completes each login to the 
   * EFMFiling Interfaces separately.
   *
   * @apiKey The api key that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login to
   * @return The new API Token that the REST client should now send to the Server
   */
  public Optional<NewTokens> login(String apiKey, String jsonLoginInfo, 
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
      log.error("Error processing login json:" + e.toString());
      return Optional.empty();
    }

    // TODO(brycew-later): the only hacky part, how can this be modulized?
    if (!loginInfo.isObject()) {
      log.error("Can't login with a json that's not an object: " + loginInfo.toPrettyString());
      return Optional.empty();
    }
    Map<String, String> newTokens = new HashMap<String, String>();
    Iterable<String> orgs = loginInfo::fieldNames;
    for (String orgName : orgs) {
      orgName = orgName.toLowerCase(); 
      if (orgName.equalsIgnoreCase("api_key")) {
        continue;
      }
      if (!loginFunctions.containsKey(orgName) 
          || !atRest.get().enabled.containsKey(orgName)
          || !atRest.get().enabled.get(orgName)) {
        log.error("There is no " + orgName + " to login to: enabled map: " + atRest.get().enabled); 
        return Optional.empty();
      }
      Optional<Map<String, String>> maybeNewTokens = loginFunctions.get(orgName).apply(loginInfo.get(orgName));
      if (maybeNewTokens.isEmpty()) {
        log.error("Couldn't login to " + orgName);
        return Optional.empty();
      }
      log.info("New tokens: " + maybeNewTokens.get());
      newTokens.putAll(maybeNewTokens.get());
    }
    if (newTokens.isEmpty()) {
      log.error("No successful logins occurred: returning nothing");
      return Optional.empty();
    }
    return Optional.of(new NewTokens(newTokens));
  }
  
  /** Example on how to trigger: mvn exec:java@LoginDatabase -Dexec.args="localhostServer true true" 
   * @throws ClassNotFoundException 
   * @throws NumberFormatException 
   * @throws NoSuchAlgorithmException */
  public static void main(final String args[]) throws SQLException, NumberFormatException, ClassNotFoundException, NoSuchAlgorithmException {
    if (args.length != 3) {
      System.out.println("Only 3 params: server name, tyler enabled, jeffnet enabled");
    }
    String serverName = args[0].strip();
    String tylerEnabled = args[1].strip();
    String jeffnetEnabled = args[2].strip();
    
    DataSource ds = DatabaseCreator.makeDataSource(System.getenv("POSTGRES_URL"),
        Integer.parseInt(System.getenv("POSTGRES_PORT")), System.getenv("POSTGRES_USER_DB"),
        System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"), 2, 100);
    try (Connection conn = ds.getConnection()) {
      conn.setAutoCommit(true);
      LoginDatabase ld = new LoginDatabase(conn); 
      boolean tylerBool = Boolean.parseBoolean(tylerEnabled);
      boolean jeffnetBool = Boolean.parseBoolean(jeffnetEnabled);
      String newApiKey = ld.addNewUser(serverName, tylerBool, jeffnetBool);
      System.out.println("New Api Key for " + serverName + ": " + newApiKey);
      System.out.println("Using tyler: " + tylerBool + " and using jeffnet: " + jeffnetBool);
    }
  }

}
