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
import java.util.List;
import java.util.UUID;

import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Updates all of the collective tables for a consistent "schema".
 * Since this class should work going back to extremely old versions of the 
 * code, this class should be completely self contained, only using SQL queries
 * from here.
 *
 * @author brycew
 *
 */
public class DatabaseVersion {
  
  private static int CURRENT_VERSION = 2;
  private static Logger log = 
      LoggerFactory.getLogger(DatabaseVersion.class);
  private final Connection codeConn;
  private final Connection userConn;
  
  // Copied from CodeTableConstants
  private final static String TABLE_EXISTS = """
        SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public'
        AND table_name = ? LIMIT 1;
      """;
  
  public DatabaseVersion(Connection codeConn, Connection userConn) {
    this.codeConn = codeConn;
    this.userConn = userConn;
  }
  
  public void createTablesIfAbsent() throws SQLException {
    String tableExistsQuery = TABLE_EXISTS; 
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
      setSchemaVersion(CURRENT_VERSION);
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
      try (Statement st = userConn.createStatement()) {
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
          try (PreparedStatement insertSt = userConn.prepareStatement(updateTable)) {
            insertSt.setObject(1, serverId);
            insertSt.setObject(2, hashedKey);
            insertSt.setObject(3, hashedKey);
            insertSt.executeUpdate();
          }
        }
      }
    } else if (onDiskVersion == 1) {
      // Conincides with the "jurisdiction" refactor: all codes need to also note which jurisdiction / domain they came from.
      // Need to add the "domain text" column to every code table, with the value "illinois-stage" as the value.
      final String alterCodes = "ALTER TABLE %s ADD COLUMN domain text";
      final String updateCodes = "UPDATE %s SET domain='illinois-stage'";
      final String alterNotNull = "ALTER TABLE %s ALTER COLUMN domain SET NOT NULL";
      
      final List<String> tableNames = List.of("location", "error", "version", "installedversion",
          "country", "state", "filingstatus", "datafieldconfig", "answer", "arrestlocation",
          "bond", "casecategory", "casesubtype", "casetype", "chargephase", "citationjurisdiction",
          "crossreference", "damageamount", "degree", "disclaimerrequirement", "driverlicensetype",
          "documenttype", "ethnicity", "eyecolor", "filertype", "filetype", "filing", 
          "filingcomponent", "generaloffense", "haircolor", "language", "lawenforcementunit",
          "motiontype", "namesuffix", "optionalservices", "partytype", "physicalfeature",
          "procedureremedy", "question", "race", "servicetype", "statute", "statutetype",
          "vehiclecolor", "vehiclemake", "vehicletype");

      // Also need to make the indices on domain + location for the bigger tables.
      final String osIndex = "CREATE INDEX ON optionalservices (domain)";
      final String fIndex = "CREATE INDEX ON filing (domain)";
      final String fcIndex = "CREATE INDEX ON filingcomponent (domain)";
      
      try (Statement st = codeConn.createStatement()) {
        for (String tableName : tableNames) {
          st.executeUpdate(alterCodes.formatted(tableName));
          st.executeUpdate(updateCodes.formatted(tableName));
          st.executeUpdate(alterNotNull.formatted(tableName));
        }
        
        st.executeUpdate(osIndex); 
        st.executeUpdate(fIndex);
        st.executeUpdate(fcIndex);
      }
      codeConn.commit();
    }
    setSchemaVersion(onDiskVersion + 1);
    userConn.commit();
    return true;
  }
}
