package edu.suffolk.litlab.efspserver.db;

import static edu.suffolk.litlab.efspserver.StdLib.strFromException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.UUID;

import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;

public class DatabaseVersion {
  
  private static int CURRENT_VERSION = 1;
  private static Logger log = 
      LoggerFactory.getLogger(DatabaseVersion.class);
  private final Connection codeConn;
  private final Connection userConn;
  
  public DatabaseVersion(Connection codeConn, Connection userConn) {
    this.codeConn = codeConn;
    this.userConn = userConn;
  }
  
  public void createTablesIfAbsent() throws SQLException {
    String tableExistsQuery = CodeTableConstants.getTableExists();
    PreparedStatement existsSt  = userConn.prepareStatement(tableExistsQuery);
    existsSt.setString(1, "schema_version");
    ResultSet rs = existsSt.executeQuery();
    if (!rs.next() || rs.getInt(1) <= 0) {
      String createSt = """
          CREATE TABLE schema_version ("version" integer NOT NULL)
          """;
      PreparedStatement pst = userConn.prepareStatement(createSt);
      int retVal = pst.executeUpdate();
      if (retVal < 0) {
        log.warn("Issue when creating schema_version: retVal == " + retVal);
      }
    }
    return; 
  }
  
  public boolean setSchemaVersion(int newVersion) throws SQLException {
    String deleteSt = "DELETE FROM schema_version";
    Statement delete = userConn.createStatement(); 
    delete.executeUpdate(deleteSt);
    String insertSt = "INSERT INTO schema_version (version) VALUES (?)";
    PreparedStatement insert = userConn.prepareStatement(insertSt);
    insert.setInt(1, newVersion);
    int retVal = insert.executeUpdate();
    // Only worked it if inserted 1 row (the new version)
    return retVal > 0;
  }
  
  public int getSchemaVersion() throws SQLException {
    String select = "SELECT version from schema_version";
    Statement st = userConn.createStatement();
    ResultSet rs = st.executeQuery(select);
    while (rs.next()) {
      return rs.getInt(1);
    }
    return 0;
  }
  
  public boolean updateToLatest() throws NoSuchAlgorithmException {
    try {
      int onDiskVersion = getSchemaVersion();
      userConn.setAutoCommit(false);
      codeConn.setAutoCommit(false);
      while (onDiskVersion < CURRENT_VERSION) {
        Savepoint savepoint = userConn.setSavepoint("beginning_update");
        try {
          boolean successful = updateDatabase(onDiskVersion);
          if (!successful) {
            return false;
          }
        onDiskVersion += 1;
        } catch (SQLException ex) {
          log.error("Couldn't update from version " + onDiskVersion + " to " + CURRENT_VERSION + ": " 
            + strFromException(ex) + ": , reverting to on disk db");
          try {
            userConn.rollback(savepoint);
          } catch (SQLException rollbackEx) {
            log.error("Couldn't rollback! Error: " + strFromException(rollbackEx));
            return false;
          }
        }
      }
    } catch (SQLException ex) {
      log.error("Couldn't setup updating to latest! Error: " + strFromException(ex));
      return false;
    }
    return true;
  }
  
  private boolean updateDatabase(int onDiskVersion) throws NoSuchAlgorithmException, SQLException {
    if (onDiskVersion == 0) {
      // This version mistakenly had API keys directly stored in the db instead of their hashes.
      String query = "SELECT server_id, api_key FROM at_rest_keys";
        Statement st = userConn.createStatement();
        ResultSet rs = st.executeQuery(query);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String updateTable = """
            INSERT INTO at_rest_keys ("server_id", "api_key")
            VALUES (?, ?) ON CONFLICT (server_id) DO UPDATE SET api_key=?
            """;
        while (rs.next()) {
          UUID serverId = (UUID) rs.getObject(1);
          String apiKey = rs.getString(2);
          String hashedKey = new String(Hex.encode(digest.digest(apiKey.getBytes(StandardCharsets.UTF_8))));
          PreparedStatement insertSt = userConn.prepareStatement(updateTable);
          insertSt.setObject(1, serverId);
          insertSt.setObject(2, hashedKey);
          insertSt.setObject(3, hashedKey);
          insertSt.executeUpdate();
        }
      }
      setSchemaVersion(onDiskVersion + 1);
      userConn.commit();
    return true;
  }
}
