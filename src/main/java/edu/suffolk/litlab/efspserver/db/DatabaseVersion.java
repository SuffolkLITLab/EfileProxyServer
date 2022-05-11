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

public class DatabaseVersion {
  
  private static int CURRENT_VERSION = 1;
  
  private static Logger log = 
      LoggerFactory.getLogger(DatabaseVersion.class);
  
  public boolean createTableIfAbsent(Connection conn) throws SQLException {
    String createSt = """
        CREATE TABLE schema_version ("version" integer NOT NULL)
        """;
    PreparedStatement pst = conn.prepareStatement(createSt);
    int retVal = pst.executeUpdate();
    return retVal >= 0;
  }
  
  public boolean setSchemaVersion(Connection conn, int newVersion) throws SQLException {
    String deleteSt = "DELETE FROM schema_version";
    Statement delete = conn.createStatement(); 
    delete.executeUpdate(deleteSt);
    String insertSt = "INSERT INTO schema_version (version) VALUES (?)";
    PreparedStatement insert = conn.prepareStatement(insertSt);
    insert.setInt(1, newVersion);
    int retVal = insert.executeUpdate();
    // Only worked it if inserted 1 row (the new version)
    return retVal > 0;
  }
  
  public boolean updateDatabase(Connection conn, int onDiskVersion) throws NoSuchAlgorithmException {
    boolean autoCommitVal = false; 
    Savepoint savepoint = null;
    try {
      autoCommitVal = conn.getAutoCommit();
      conn.setAutoCommit(false);
      savepoint = conn.setSavepoint("beginning_update");
    } catch (SQLException ex) {
      log.error("Cannot set autocommit to false / set a savepoint: " + strFromException(ex) + ", not going to upgrade.");
      return false;
    }
    try {
      if (onDiskVersion == 0) {
        // This version mistakenly had API keys directly stored in the db instead of their hashes.
        String query = "SELECT server_id, api_key FROM at_rest_keys";
        Statement st = conn.createStatement();
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
          PreparedStatement insertSt = conn.prepareStatement(updateTable);
          insertSt.setObject(1, serverId);
          insertSt.setObject(2, hashedKey);
          insertSt.setObject(3, hashedKey);
          insertSt.executeUpdate();
        }
      }
      setSchemaVersion(conn, onDiskVersion + 1);
      conn.commit();
    } catch (SQLException ex) {
      log.error("Couldn't update from version " + onDiskVersion + " to " + CURRENT_VERSION + ": " 
          + strFromException(ex) + ": , reverting to on disk db");
      try {
        conn.rollback(savepoint);
      } catch (SQLException rollbackEx) {
        log.error("Couldn't rollback! Error: " + strFromException(rollbackEx));
        return false;
      }
    }
    try {
      conn.releaseSavepoint(savepoint);
      conn.setAutoCommit(autoCommitVal);
    } catch (SQLException ex) {
      log.error("Couldn't release save point / reset autocommit: " + strFromException(ex));
      return false;
    }
    return true;
  }
}
