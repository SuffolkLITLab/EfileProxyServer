package edu.suffolk.litlab.efspserver.db;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class DatabaseVersionTest {
  @Container
  public PostgreSQLContainer<?> userDb =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));

  @Container
  public PostgreSQLContainer<?> codeDb =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));

  private static final String v0AtRestCreate = """
           CREATE TABLE at_rest_keys (
           "server_id" uuid PRIMARY KEY, "server_name" text, "api_key" text NOT NULL,
           "tyler_enabled" boolean, "jeffnet_enabled" boolean, 
           "created" timestamp)"""; 
  
  private static final String v0AtRestInsert = """
           INSERT INTO at_rest_keys (
               "server_id", "server_name", "api_key", "tyler_enabled",
               "jeffnet_enabled", "created"
           ) VALUES (
               ?, ?, ?, ?,
               ?, ?)"""; 
  
  private DatabaseVersion dv;
  private Connection userConn;
  private static final String apiKey = "p9AoR183QwMun7bvCmYkf";
  
  @BeforeEach
  public void setUp() throws SQLException {
    userDb.start();
    codeDb.start();
    userConn = DatabaseCreator.makeSingleConnection(
        userDb.getDatabaseName(), userDb.getJdbcUrl(), 
        userDb.getUsername(), userDb.getPassword());
    Connection codeConn = DatabaseCreator.makeSingleConnection(
        codeDb.getDatabaseName(), codeDb.getJdbcUrl(), 
        codeDb.getUsername(), userDb.getPassword());
    Statement st = userConn.createStatement();
    st.executeUpdate(v0AtRestCreate);
    PreparedStatement pst = userConn.prepareStatement(v0AtRestInsert);
    pst.setObject(1, UUID.randomUUID());
    pst.setString(2, "MyServerName");
    pst.setString(3, apiKey);
    pst.setBoolean(4, true);
    pst.setBoolean(5, true);
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    pst.setTimestamp(6, ts);
    dv = new DatabaseVersion(codeConn, userConn);
  }
  
  @Test
  public void testUpdateFrom0To1() throws SQLException, NoSuchAlgorithmException {
    dv.createTablesIfAbsent();
    dv.createTablesIfAbsent();
    assertEquals(0, dv.getSchemaVersion());
    dv.updateToLatest();
    assertEquals(1, dv.getSchemaVersion());
    String selectApiKey = "SELECT api_key FROM at_rest_keys";
    Statement st = userConn.createStatement();
    ResultSet rs = st.executeQuery(selectApiKey);

    LoginDatabase ld = new LoginDatabase(userConn);
    String manualHash = ld.makeHash(apiKey);
    
    while (rs.next()) {
      assertEquals(rs.getString(1), manualHash);
    }
  }
}
