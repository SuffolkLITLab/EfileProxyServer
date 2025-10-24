package edu.suffolk.litlab.efsp.db;

import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeTableConstants;
import edu.suffolk.litlab.efsp.server.utils.MDCWrappers;
import edu.suffolk.litlab.efsp.stdlib.RandomString;
import edu.suffolk.litlab.efsp.utils.Hasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;
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

  public LoginDatabase(Connection conn) {
    super(conn);
  }

  public static LoginDatabase fromDS(DataSource ds) {
    try {
      return new LoginDatabase(ds.getConnection());
    } catch (SQLException ex) {
      log.error("In LoginDatabase constructor, can't get connection: ", ex);
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
          log.info("Full statement: {}", createSt.toString());
          int retVal = createSt.executeUpdate(createQuery);
          if (retVal < 0) {
            log.warn("Issue when creating {}: retVal == {}", tableName, retVal);
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
    String hash = Hasher.makeHash(apiKey);
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
    String hash = Hasher.makeHash(apiKey);
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
        log.warn("API Key hash not present in at rest: {}", hash);
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
      log.error("SQL error when logging in", ex);
      return Optional.empty();
    }
  }

  public boolean updateServerName(AtRest atRest, String apiKey, String newName) {
    if (apiKey == null || apiKey.isBlank() || newName == null || newName.isBlank()) {
      return false;
    }
    String hash = Hasher.makeHash(apiKey);
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
      log.error("SQL error when updating server name", ex);
      return false;
    }
  }

  /**
   * Example on how to trigger: java -cp efspserver-with-deps.jar
   * edu.suffolk.litlab.efsp.db.LoginDatabase localhostServer true true
   *
   * @throws ClassNotFoundException
   * @throws NumberFormatException
   */
  public static void main(final String args[])
      throws SQLException, NumberFormatException, ClassNotFoundException {
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
            10,
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
