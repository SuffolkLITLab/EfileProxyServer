package edu.suffolk.litlab.efspserver.db;

import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Very similar to the CodeDatabase, but for user data, kept at a minimum.
 *
 * <p>At the most, we save the transaction ID for the filing and some method of
 * contact (maybe their name too), so they can have instructions on what to do.</p>
 *
 * @author brycew
 */
public class UserDatabase implements DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(UserDatabase.class); 
  
  private final Connection conn;

  public UserDatabase(Connection conn) {
    this.conn = conn;
  }
  
  public Connection getConnection() {
    return conn;
  }

  /** Creates the userdatabase table if it doesn't exist yet. */
  public void createTablesIfAbsent() throws SQLException {
    String tableExistsQuery = CodeTableConstants.getTableExists();
    try (PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery)) {
      existsSt.setString(1, "submitted_filings");
      ResultSet rs = existsSt.executeQuery();
      if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
        String createQuery = """ 
             CREATE TABLE submitted_filings (
             "user_id" uuid, "name" text, "phone_number" text,
             "email" text, "transaction_id" uuid PRIMARY KEY, "server_id" uuid, "api_key_used" text, 
             "court_id" text, "casetype" text, 
             "submitted" date, "accepted_msg_template" text, "rejected_msg_template" text,
             "neutral_msg_template" text, "case_title" text)""";
        try (Statement createSt = conn.createStatement()) {
          log.info("Full statement: " + createQuery); 
          int retVal = createSt.executeUpdate(createQuery);
          if (retVal < 0) {
            log.warn("Issue when creating submitted_filings: retVal == " + retVal);
          }
        }
      }
      rs.close();
    }
  }
  
  public void addToTable(String name,
      UUID filingPartyId, Optional<String> phoneNumber, String email,
      List<UUID> transactionIds, UUID serverId, String apiKeyUsed, String caseType, String courtId, Timestamp submitted,
      String acceptedTmpl, String rejectedTmpl, String neutralTmpl, String caseTitle) throws SQLException {
    for (UUID id : transactionIds) {
      addToTable(name, filingPartyId, phoneNumber, email, id, serverId, apiKeyUsed, caseType, courtId, submitted,
        acceptedTmpl, rejectedTmpl, neutralTmpl, caseTitle);
    }
  }
  
  /** Adds the given values as a row in the submitted table. */
  public void addToTable(String name,
      UUID filingPartyId, Optional<String> phoneNumber, String email, 
      UUID transactionId, UUID serverId, String apiKeyUsed, String caseType, 
      String courtId, Timestamp submitted, String acceptedTmpl, String rejectedTmpl,
      String neutralTmpl, String caseTitle) throws SQLException {
    if (conn == null) {
      log.error("Connection in addToTable wasn't open yet!");
      throw new SQLException();
    }
    String insertIntoTable = """
                    INSERT INTO submitted_filings (
                        "user_id", "name", 
                        "phone_number", "email", "transaction_id", "server_id",
                        "api_key_used", "casetype", "court_id", "submitted", 
                        "accepted_msg_template", "rejected_msg_template", 
                        "neutral_msg_template", "case_title"
                    ) VALUES (
                        ?, ?, 
                        ?, ?, ?, ?,
                        ?, ?, ?, ?, ?, ?, ?, ?)""";
    try (PreparedStatement insertSt = conn.prepareStatement(insertIntoTable)) {
      insertSt.setObject(1, filingPartyId);
      insertSt.setString(2, name);
      String phone = phoneNumber.orElse(null); 
      insertSt.setString(3, phone);
      insertSt.setString(4, email);
      insertSt.setObject(5, transactionId);
      insertSt.setObject(6, serverId);
      insertSt.setString(7, apiKeyUsed);
      insertSt.setString(8, caseType);
      insertSt.setString(9, courtId);
      insertSt.setTimestamp(10, submitted);
      insertSt.setString(11, acceptedTmpl);
      insertSt.setString(12, rejectedTmpl);
      insertSt.setString(13, neutralTmpl);
      insertSt.setString(14, caseTitle);
      insertSt.executeUpdate();
    }
  }
  
  // TODO(brycew-later): consider having to lookup "callbacked" users: either in DB or just in Logs
  /** Gets the info from the table by using the (Primary key'd) transaction id.
   */
  public Optional<Transaction> findTransaction(UUID transactionToFind) throws SQLException {
    if (conn == null) {
      log.error("Connection in findTransaction wasn't open yet!");
      throw new SQLException();
    }
    String query = """
        SELECT name, user_id, phone_number, email, transaction_id, server_id,
            api_key_used, casetype, court_id, submitted, accepted_msg_template, 
            rejected_msg_template, neutral_msg_template, case_title
        FROM submitted_filings
        WHERE transaction_id = ?""";
    
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setObject(1, transactionToFind);
      ResultSet rs = st.executeQuery();
      if (!rs.next()) {
        return Optional.empty();
      }
      Transaction trans = Transaction.fromResults(rs);
      return Optional.of(trans);
    }
  }
  
  public boolean removeFromTable(UUID transactionToRm) throws SQLException {
    if (conn == null) {
      log.error("Connection in removeFromTable wasn't open yet");
      throw new SQLException();
    }
    
    String rmUpdate = "DELETE FROM submitted_filings WHERE transaction_id = ?";
    try (PreparedStatement st = conn.prepareStatement(rmUpdate)) {
      st.setObject(1, transactionToRm);
      int result = st.executeUpdate();
      return (result >= 1);
    }
  }
}
