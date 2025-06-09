package edu.suffolk.litlab.efspserver.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efspserver.RandomString;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.services.MDCWrappers;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeTableConstants;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import javax.sql.DataSource;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class LoginDatabase extends Database {
  private static Logger log = LoggerFactory.getLogger(LoginDatabase.class);

  private static final String atRestCreate =
      """
      CREATE TABLE at_rest_keys (
      "server_id" uuid PRIMARY KEY, "server_name" text, "api_key" text NOT NULL,
      "tyler_enabled" boolean, "jeffnet_enabled" boolean,
      "created" timestamp)\
      """;

  private static final String atRestInsert =
      """
      INSERT INTO at_rest_keys (
          "server_id", "server_name", "api_key", "tyler_enabled",
          "jeffnet_enabled", "created"
      ) VALUES (
          ?, ?, ?, ?,
          ?, ?)\
      """;

  private static final RandomString tokenGenerator = new RandomString();
  private final MessageDigest digest;

  public LoginDatabase(Connection conn) {
    super(conn);
    try {
      this.digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException ex) {
      throw new AssertionError(ex);
    }
  }

  public static LoginDatabase fromDS(DataSource ds) {
    try {
      LoginDatabase cd = new LoginDatabase(ds.getConnection());
      return cd;
    } catch (SQLException ex) {
      log.error(
          "In LoginDatabase constructor, can't get connection: " + StdLib.strFromException(ex));
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void createTablesIfAbsent() throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }

    String tableName = "at_rest_keys";
    String createQuery = atRestCreate;
    String tableExistsQuery = CodeTableConstants.getTableExists();
    try (PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery)) {
      existsSt.setString(1, tableName);
      ResultSet rs = existsSt.executeQuery();
      if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
        try (Statement createSt = conn.createStatement()) {
          log.info("Full statement: " + createSt.toString());
          int retVal = createSt.executeUpdate(createQuery);
          if (retVal < 0) {
            log.warn("Issue when creating " + tableName + ": retVal == " + retVal);
          }
        }
      }
      rs.close();
    }
  }

  public boolean tablesExist() throws SQLException {
    String tableName = "at_rest_keys";
    String tableExistsQuery = CodeTableConstants.getTableExists();
    try (PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery)) {
      existsSt.setString(1, tableName);
      ResultSet rs = existsSt.executeQuery();
      return rs.next() && rs.getInt(1) > 0;
    }
  }

  public String addNewUser(String serverName, boolean tylerEnabled, boolean jeffNetEnabled)
      throws SQLException {
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

  public Optional<AtRest> getAtRestInfo(String apiKey) {
    if (apiKey == null || apiKey.isBlank()) {
      return Optional.empty();
    }
    String hash = makeHash(apiKey);
    String query =
        """
        SELECT server_id, server_name, api_key, tyler_enabled,
            jeffnet_enabled, created
        FROM at_rest_keys
        WHERE api_key = ?\
        """;

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
      // Assuming that we will only have the API key hash when directly given it, i.e.
      // when this server is calling the proxy server. So set the log param
      MDC.put(MDCWrappers.SERVER_ID, atRest.serverId.toString());
      return Optional.of(atRest);
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.empty();
    }
  }

  public boolean updateServerName(AtRest atRest, String apiKey, String newName) {
    if (apiKey == null || apiKey.isBlank() || newName == null || newName.isBlank()) {
      return false;
    }
    String hash = makeHash(apiKey);
    final String atRestUpdate =
        """
               UPDATE at_rest_keys SET server_name = ? WHERE server_id = ? AND api_key = ?
        """;

    try (PreparedStatement st = conn.prepareStatement(atRestUpdate)) {
      st.setString(1, newName);
      st.setObject(2, atRest.serverId);
      st.setObject(3, hash);
      st.executeUpdate();
      return true;
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return false;
    }
  }

  public String makeHash(String input) {
    if (input == null) {
      return "";
    }
    return new String(Hex.encode(digest.digest(input.getBytes(StandardCharsets.UTF_8))));
  }

  /**
   * Actually completes the REST client's login to the server. Completes each login to the EFMFiling
   * Interfaces separately.
   *
   * @param apiKey The api key that the server can use for logging in
   * @param jsonLoginInfo The JSON string with login info for whatever modules it's wants to login
   *     to
   * @return If the optional is empty, the apikey or one of the attempted logins failed. If not
   *     empty, it contains the new API Token that the REST client should now send to the Server, or
   *     an empty token list (which happens when querying Tyler code endpoints before the user is
   *     logged in)
   */
  public Optional<NewTokens> login(
      String apiKey,
      String jsonLoginInfo,
      Map<String, Function<JsonNode, Optional<Map<String, String>>>> loginFunctions)
      throws SQLException {
    if (conn == null) {
      log.error("Connection in login wasn't open yet!");
      throw new SQLException();
    }
    Optional<AtRest> maybeAtRest = getAtRestInfo(apiKey);
    if (maybeAtRest.isEmpty()) {
      return Optional.empty();
    }

    AtRest atRest = maybeAtRest.get();
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
    var newTokens = new HashMap<String, String>();
    Iterable<String> orgs = loginInfo::fieldNames;
    for (String orgName : orgs) {
      orgName = orgName.toLowerCase();
      if (orgName.equalsIgnoreCase("api_key")) {
        continue;
      }
      // TODO(brycew): feels hacky, but we don't want an additional column to the db for each new
      // jurisdiction
      if (!loginFunctions.containsKey(orgName)) {
        log.error(
            "There is no " + orgName + " to login to: loginFunctions: " + loginFunctions.keySet());
        return Optional.empty();
      }

      String permissionsName = orgName;
      if (orgName.contains("-")) {
        permissionsName = orgName.split("-")[0];
      }
      if (!atRest.enabled.containsKey(permissionsName) || !atRest.enabled.get(permissionsName)) {
        log.error(
            "There is no " + permissionsName + " to login to: enabled map: " + atRest.enabled);
        return Optional.empty();
      }
      Optional<Map<String, String>> maybeNewTokens =
          loginFunctions.get(orgName).apply(loginInfo.get(orgName));
      if (maybeNewTokens.isEmpty()) {
        log.warn("Couldn't login to " + orgName);
        return Optional.empty();
      }
      log.info("New tokens: " + maybeNewTokens.get());
      newTokens.putAll(maybeNewTokens.get());
    }
    if (newTokens.isEmpty()) {
      log.warn("No successful logins occurred: returning empty tokens object");
    }
    return Optional.of(new NewTokens(newTokens));
  }

  /**
   * Example on how to trigger: java -cp target/efspserver-with-deps.jar
   * edu.suffolk.litlab.efspserver.db.LoginDatabase localhostServer true true
   *
   * @throws ClassNotFoundException
   * @throws NumberFormatException
   * @throws NoSuchAlgorithmException
   */
  public static void main(final String args[])
      throws SQLException, NumberFormatException, ClassNotFoundException, NoSuchAlgorithmException {
    if (args.length != 3) {
      System.out.println("Only 3 params: server name, tyler enabled, jeffnet enabled");
    }
    String serverName = args[0].strip();
    String tylerEnabled = args[1].strip();
    String jeffnetEnabled = args[2].strip();

    DataSource ds =
        DatabaseCreator.makeDataSource(
            System.getenv("POSTGRES_URL"),
            Integer.parseInt(System.getenv("POSTGRES_PORT")),
            System.getenv("POSTGRES_USER_DB"),
            System.getenv("POSTGRES_USER"),
            System.getenv("POSTGRES_PASSWORD"),
            2,
            100);
    try (LoginDatabase ld = new LoginDatabase(ds.getConnection())) {
      ld.setAutoCommit(true);
      boolean tylerBool = Boolean.parseBoolean(tylerEnabled);
      boolean jeffnetBool = Boolean.parseBoolean(jeffnetEnabled);
      ld.createTablesIfAbsent();
      String newApiKey = ld.addNewUser(serverName, tylerBool, jeffnetBool);
      System.out.println("New Api Key for " + serverName + ": " + newApiKey);
      System.out.println("Using tyler: " + tylerBool + " and using jeffnet: " + jeffnetBool);
    }
  }
}
