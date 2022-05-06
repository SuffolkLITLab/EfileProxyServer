package edu.suffolk.litlab.efspserver.db;

import static edu.suffolk.litlab.efspserver.StdLib.strFromException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseVersion {
  
  private static int CURRENT_VERSION = 1;
  
  private static Logger log = 
      LoggerFactory.getLogger(DatabaseVersion.class);
  
  public boolean updateDatabase(Connection conn, int onDiskVersion) {
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
        while (rs.next()) {
          String serverId = rs.getString(1);
          String apiKey = rs.getString(2);
        }
      }
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
