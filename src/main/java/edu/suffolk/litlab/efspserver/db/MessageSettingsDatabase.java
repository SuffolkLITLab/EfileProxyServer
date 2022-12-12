package edu.suffolk.litlab.efspserver.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.codes.CodeTableConstants;

public class MessageSettingsDatabase implements DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(MessageSettingsDatabase.class); 
  
  private final Connection conn;
  
  public MessageSettingsDatabase(Connection conn) {
    this.conn = conn;
  }
  
  public Connection getConnection() {
    return conn;
  }
  
  @Override
  public void createTablesIfAbsent() throws SQLException {
    if (conn == null) {
      log.error("Connection in createTablesifAbsent wasn't open yet");
      throw new SQLException();
    }
    
    String tableExistsQuery = CodeTableConstants.getTableExists();
    try (PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery)) {
      existsSt.setString(1, "message_settings");
      ResultSet rs = existsSt.executeQuery();
      if (!rs.next() || rs.getInt(1) <= 0) {
        String createQuery = """
            CREATE TABLE message_settings (
            "server_id" uuid PRIMARY KEY, "from_email" text, "subject_line" text,
            "email_template" text, "email_confirmation" text, "confirmation_subject_line" text)""";
        try (Statement createSt = conn.createStatement()) {
          int retVal = createSt.executeUpdate(createQuery);
          if (retVal < 0) {
            log.warn("Issue when creating \"message_settings\" table: retVal == " + retVal);
          }
        }
      }
      rs.close();
    }
  }
  
  public void updateTable(MessageInfo info) throws SQLException {
    updateTable(info.serverId, info.fromEmail, info.subjectLine, info.emailResponseTemplate,
        info.confirmationSubjectLine,
        info.emailConfirmation);
  }
  
  public void updateTable(UUID serverId, String toEmail, String subjectLine, 
      String emailTemplate, String confirmationSubjectLine, String emailConfirmation) throws SQLException {
    if (conn == null) {
      log.error("Connection in addToTable wasn't open yet!");
      throw new SQLException();
    }
    
    String insertIntoTable = """
        INSERT INTO message_settings (
            "server_id", "from_email", "subject_line", "email_template", "confirmation_subject_line", "email_confirmation"
        ) VALUES (
          ?, ?, ?, ?, ?, ?) ON CONFLICT (server_id) DO UPDATE SET from_email=?, subject_line=?, 
              email_template=?, confirmation_subject_line=?, email_confirmation=?
        """; 
    
    try (PreparedStatement insertSt = conn.prepareStatement(insertIntoTable)) {
      insertSt.setObject(1, serverId);
      insertSt.setString(2, toEmail);
      insertSt.setString(3, subjectLine);
      insertSt.setString(4, emailTemplate);
      insertSt.setString(5, confirmationSubjectLine);
      insertSt.setString(6, emailConfirmation);
      insertSt.setString(7, toEmail);
      insertSt.setString(8, subjectLine);
      insertSt.setString(9, emailTemplate);
      insertSt.setString(10, confirmationSubjectLine);
      insertSt.setString(11, emailConfirmation);
      insertSt.executeUpdate();
    }
  }
  
  public Optional<MessageInfo> findMessageInfo(UUID serverId) {
    if (conn == null) {
      log.error("Connection in addToTable wasn't open yet!");
      return Optional.empty();
    }
    
    String query = """
        SELECT server_id, from_email, subject_line, email_template, confirmation_subject_line,
        email_confirmation 
        FROM message_settings 
        WHERE server_id=?""";
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setObject(1, serverId);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        MessageInfo info = new MessageInfo((UUID)rs.getObject(1), rs.getString(2), 
            rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        return Optional.of(info);
      }
    } catch (SQLException e) {
      log.error("Exception getting message settings: " + e);
      return Optional.empty();
    }
    log.warn("No settings for " + serverId.toString());
    return Optional.empty();
  }
}


