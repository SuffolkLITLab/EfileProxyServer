package edu.suffolk.litlab.efspserver.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;

public class MessageSettingsDatabase extends DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(MessageSettingsDatabase.class); 
  
  private static final String tableName = "message_settings";

  public MessageSettingsDatabase(String pgUrl, int pgPort, String pgDb) {
    super(pgUrl, pgPort, pgDb);
  }
  
  public MessageSettingsDatabase(String pgFullUrl, String pgDb) {
    super(pgFullUrl, pgDb);
  }

  @Override
  public void createTablesIfAbsent() throws SQLException {
    if (conn == null) {
      log.error("Connection in createTablesifAbsent wasn't open yet");
      throw new SQLException();
    }
    
    String tableExistsQuery = CodeTableConstants.getTableExists();
    PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery);
    existsSt.setString(1, tableName);
    
    ResultSet rs = existsSt.executeQuery();
    if (!rs.next() || rs.getInt(1) <= 0) {
      String createQuery = """
          CREATE TABLE %s (
          "server_id" uuid PRIMARY KEY, "from_email" text, "subject_line" text,
          "email_template" text)""".formatted(tableName);
      PreparedStatement createSt = conn.prepareStatement(createQuery);
      int retVal = createSt.executeUpdate();
      if (retVal < 0) {
        log.warn("Issue when creating " + tableName + ": retVal == " + retVal);
      }
    }
  }
  
  public void updateTable(MessageInfo info) throws SQLException {
    updateTable(info.serverId, info.fromEmail, info.subjectLine, info.emailTemplate);
  }
  
  public void updateTable(UUID serverId, String toEmail, String subjectLine, String emailTemplate) throws SQLException {
    if (conn == null) {
      log.error("Connection in addToTable wasn't open yet!");
      throw new SQLException();
    }
    
    String insertIntoTable = """
        INSERT INTO %s (
            "server_id", "from_email", "subject_line", "email_template"
        ) VALUES (
          ?, ?, ?, ?) ON CONFLICT (server_id) DO UPDATE SET from_email=?, subject_line=?, email_template=?
        """.formatted(tableName);
    
    PreparedStatement insertSt = conn.prepareStatement(insertIntoTable);
    insertSt.setObject(1, serverId);
    insertSt.setString(2, toEmail);
    insertSt.setString(3, subjectLine);
    insertSt.setString(4, emailTemplate);
    insertSt.setString(5, toEmail);
    insertSt.setString(6, subjectLine);
    insertSt.setString(7, emailTemplate);
    insertSt.executeUpdate();
  }
  
  public Optional<MessageInfo> findMessageInfo(UUID serverId) {
    if (conn == null) {
      log.error("Connection in addToTable wasn't open yet!");
      return Optional.empty();
    }
    
    String query = "SELECT server_id, from_email, subject_line, email_template FROM message_settings WHERE server_id=?";
    PreparedStatement st;
    try {
      st = conn.prepareStatement(query);
      st.setObject(1, serverId);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        MessageInfo info = new MessageInfo((UUID)rs.getObject(1), rs.getString(2), rs.getString(3), rs.getString(4));
        return Optional.of(info);
      }
    } catch (SQLException e) {
      log.error("Exception getting message settings: " + e);
      return Optional.empty();
    }
    log.error("No settings for " + serverId.toString());
    return Optional.empty();
  }
}


