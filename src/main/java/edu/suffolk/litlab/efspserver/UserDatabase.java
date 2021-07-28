package edu.suffolk.litlab.efspserver;

import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class UserDatabase extends DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(UserDatabase.class); 

  private static final String tableName = "submitted_filings";
  
  public UserDatabase(String pgUrl, int pgPort, String pgDb) {
    super(pgUrl, pgPort, pgDb);
  }

  public UserDatabase(String pgFullUrl, String pgDb) {
    super(pgFullUrl, pgDb);
  }
  
  /** Creates the userdatabase table if it doesn't exist yet. */
  public void createTablesIfAbsent() throws SQLException {
    if (conn == null) {
      log.error("Connection in createTablesIfAbsert wasn't open yet");
      throw new SQLException();
    }
    // TODO(brycew): maybe refactor: constants is useful, but no longer just for code tables
    String tableExistsQuery = CodeTableConstants.getTableExists();
    PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery);

    existsSt.setString(1, tableName);
    ResultSet rs = existsSt.executeQuery();
    if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
      String createQuery = """ 
           CREATE TABLE %s (
           "user_id" uuid, "name" text, "phone_number" text,
           "email" text, "transaction_id" uuid PRIMARY KEY, "api_key_used" text, 
           "court_id" text, "casetype" text, 
           "submitted" date)""".formatted(tableName);
      PreparedStatement createSt = conn.prepareStatement(createQuery);
      log.info("Full statement: " + createSt.toString());
      int retVal = createSt.executeUpdate();
      if (retVal < 0) {
        log.warn("Issue when creating " + tableName + ": retVal == " + retVal);
      }
    }
  }
  
  public void addToTable(String name,
      UUID filingPartyId, Optional<String> phoneNumber, String email,
      List<UUID> transactionIds, String apiKeyUsed, String caseType, String courtId, Timestamp submitted) throws SQLException {
    for (UUID id : transactionIds) {
      addToTable(name, filingPartyId, phoneNumber, email, id, apiKeyUsed, caseType, courtId, submitted);
    }
  }
  
  // TODO(bryceW): add the title of the case ("John vs Jones")
  // Can generate it from the Plaintiff vs Defendant (in the matter of Respondant)
  /** Adds the given values as a row in the submitted table. */
  public void addToTable(String name,
      UUID filingPartyId, Optional<String> phoneNumber, String email, 
      UUID transactionId, String apiKeyUsed, String caseType, String courtId, Timestamp submitted) throws SQLException {
    if (conn == null) {
      log.error("Connection in addToTable wasn't open yet!");
      throw new SQLException();
    }
    String insertIntoTable = """
                    INSERT INTO %s (
                        "user_id", "name", 
                        "phone_number", "email", "transaction_id", 
                        "api_key_used", "casetype", "court_id", "submitted" 
                    ) VALUES (
                        ?, ?, 
                        ?, ?, ?, 
                        ?, ?, ?, ?)""".formatted(tableName);
    PreparedStatement insertSt = conn.prepareStatement(insertIntoTable);
    insertSt.setObject(1, filingPartyId);
    insertSt.setString(2, name);
    String phone = phoneNumber.orElse(null); 
    try {
      insertSt.setString(3, phone);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    insertSt.setString(4, email);
    insertSt.setObject(5, transactionId);
    insertSt.setString(6, apiKeyUsed);
    insertSt.setString(7, caseType);
    insertSt.setString(8, courtId);
    insertSt.setTimestamp(9, submitted);

    insertSt.executeUpdate();
  }
  
  // TODO(brycew): consider having to lookup "callbacked" users: either in DB or just in Logs
  /** Gets the info from the table by using the (Primary key'd) transaction id.
   */
  public Optional<Transaction> findTransaction(UUID transactionToFind) throws SQLException {
    if (conn == null) {
      log.error("Connection in findTransaction wasn't open yet!");
      throw new SQLException();
    }
    String query = "SELECT name, user_id, phone_number, email, transaction_id, "
        + " api_key_used, casetype, court_id, submitted"
        + " FROM " + tableName
        + " WHERE transaction_id = ?";
    
    PreparedStatement st = conn.prepareStatement(query);
    st.setObject(1, transactionToFind);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) {
      return Optional.empty();
    }
    Transaction trans = new Transaction();
    trans.name = rs.getString(1);
    trans.filingPartyId = (UUID) rs.getObject(2);
    if (rs.getString(3) == null) {
      trans.phoneNumber = Optional.empty();
    } else {
      trans.phoneNumber = Optional.of(rs.getString(3));
    }
    trans.email = rs.getString(4);
    trans.transactionId = (UUID) rs.getObject(5);
    trans.apiKeyUsed = rs.getString(6);
    trans.caseType = rs.getString(7);
    trans.courtId = rs.getString(8);
    trans.submitted = rs.getTimestamp(9);
    return Optional.of(trans);
  }
  
  public boolean removeFromTable(UUID transactionToRm) throws SQLException {
    if (conn == null) {
      log.error("Connection in removeFromTable wasn't open yet");
      throw new SQLException();
    }
    
    String rmUpdate = "DELETE FROM " + tableName + " WHERE transaction_id = ?";
    PreparedStatement st = conn.prepareStatement(rmUpdate);
    st.setObject(1, transactionToRm);
    int result = st.executeUpdate();
    return (result >= 1);
  }
}
