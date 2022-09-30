package edu.suffolk.litlab.efspserver.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SendMessage;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.MessageInfo;
import edu.suffolk.litlab.efspserver.db.MessageSettingsDatabase;
import edu.suffolk.litlab.efspserver.db.Transaction;

/**
 * A wrapper around the lower level SendMesage that reads in and
 * handles the actual message sent from configurations.
 * 
 * @author brycew 
 *
 */
public class OrgMessageSender {
  private static Logger log = 
      LoggerFactory.getLogger(OrgMessageSender.class); 
  
  private final SendMessage sendMsg;
  private final DataSource ds;

  private String defaultFrom = "massaccess@suffolk.edu";
  private String defaultSubject = "An update on your filing";
  // TODO(#36): consider better HTML styling on these emails if possible
  private String defaultResponseTemplate =
      """
      Dear {{ name }},
      
      The {{ court_name }} has sent a response to your filing in {{ case_title }} ({{ case_type }})
      (transaction ID is {{ transaction_id }}):
      
      "{{ status }}"
      
      {{ message_text }}
      
      {% if message_url is defined %}
      You can visit {{ message_url }} for more details.
      {% endif %}
      
      You should contact the court directly if you have questions.
      
      Best,
      Court Forms Online
      """;
  private String defaultConfirmationSubject = "An update on your e-filing";
  private String defaultConfirmation = 
      """
      Dear {{ name }},
      
      The {{ court_name }} has received your filing in {{ case_title }} ({{ case_type }}).
      
      Its transaction ID is {{ transaction_id }}. You should keep track of this; the court might
      need it in your interactions with them.
      
      They will send you a response shortly.

      You should contact the court directly if you have questions.
      
      Best,
      Court Forms Online
      """;
  
  public OrgMessageSender(DataSource ds, SendMessage sendMsg) {
    this.ds = ds;
    this.sendMsg = sendMsg;
  }
  
  private MessageInfo getSettings(UUID serverId) {
    Optional<MessageInfo> maybeInfo = Optional.empty();
    try (Connection conn = ds.getConnection()) {
      var md = new MessageSettingsDatabase(conn);
      maybeInfo = md.findMessageInfo(serverId);
    } catch (SQLException ex) {
      log.error("Couldn't connect to message db: using defaults: " + StdLib.strFromException(ex));
    }

    if (maybeInfo.isPresent()) {
      MessageInfo info = maybeInfo.get();
      if (info.fromEmail == null) {
        info.fromEmail = defaultFrom;
      }
      if (info.subjectLine == null) {
        info.subjectLine = defaultSubject;
      }
      if (info.emailResponseTemplate == null) {
        info.emailResponseTemplate = defaultResponseTemplate;
      }
      if (info.emailConfirmation == null) {
        info.emailConfirmation = defaultConfirmation;
      }
      return info;
    } else {
      log.warn("Couldn't get message settings, using defaults");
      return new MessageInfo(serverId, defaultFrom, defaultSubject, defaultResponseTemplate, defaultConfirmationSubject, defaultConfirmation); 
    }
  }

  public boolean sendMessage(Transaction trans, UpdateMessageStatus status,
  String statusText, String messageText, String messageUrl, String courtName) {
    return sendMessage(trans, status, statusText, messageText, messageUrl, courtName, null);
  }
  
  public boolean sendMessage(Transaction trans, UpdateMessageStatus status, 
  String statusText, String messageText, String messageUrl, String courtName, String theirCaseTitle) {
    MessageInfo msgSettings = getSettings(trans.serverId);
    Map<String, Object> templateVars = new HashMap<String, Object>();
    String template = msgSettings.emailResponseTemplate;
    String subject = msgSettings.subjectLine;
    // Set neutral msg and subject first, since we prefer personalized messages over
    // defaults, even if tone isn't perfect.
    if (trans.neutralMsgTemplate != null && !trans.neutralMsgTemplate.isBlank()) {
      template = trans.neutralMsgTemplate;
    }
    if (trans.neutralMsgSubject != null && !trans.neutralMsgSubject.isBlank()) {
      subject = trans.neutralMsgSubject;
    }
    if (status.equals(UpdateMessageStatus.ACCEPTED)) {
      if (trans.acceptedMsgTemplate != null && !trans.acceptedMsgTemplate.isBlank()) {
        template = trans.acceptedMsgTemplate;
      }
      if (trans.acceptedMsgSubject != null && !trans.acceptedMsgTemplate.isBlank()) {
        subject = trans.acceptedMsgSubject;
      }
    } else if (status.equals(UpdateMessageStatus.REJECTED)) {
      if (trans.rejectedMsgTemplate != null && !trans.rejectedMsgTemplate.isBlank()) {
        template = trans.rejectedMsgTemplate;
      }
      if (trans.rejectedMsgSubject != null && !trans.rejectedMsgSubject.isBlank()) {
        subject = trans.rejectedMsgSubject;
      }
    }
    templateVars.put("name", trans.name);
    templateVars.put("court_name", courtName);
    templateVars.put("case_type", trans.caseTypeName);
    if (theirCaseTitle != null && !theirCaseTitle.isBlank()) {
      templateVars.put("case_title", theirCaseTitle);
    } else {
      templateVars.put("case_title", trans.caseTitle);
    }
    templateVars.put("status", statusText);
    templateVars.put("message_text", messageText);
    if (messageUrl != null && !messageUrl.isBlank()) {
      templateVars.put("message_url", messageUrl);
    }
    templateVars.put("transaction_id", trans.transactionId.toString());
    boolean canEmail = trans.email != null && SendMessage.isValidEmail(trans.email);
    if (canEmail) {
      int result;
      try {
        result = sendMsg.sendEmail(msgSettings.fromEmail, subject, trans.email, template, templateVars);
        return (result == 200 || result == 202 || result == 204);
      } catch (IOException e) {
        log.error(e.toString());
        return false;
      }
    } 

    // TODO(brycew-later): handle sending SMS as well
    log.warn("Can't send to this email: " + trans.email);
    return false;
  }
  
  public boolean sendConfirmation(String email, String emailTemplate, String emailSubject, UUID serverId, String name, 
      String courtName, List<UUID> transactionIds, String caseType, String caseTitle) {
    MessageInfo msgSettings = getSettings(serverId);
    if (emailTemplate == null || emailTemplate.isBlank()) {
      log.warn("given email template was blank (" + emailTemplate + "), using default");
      emailTemplate = msgSettings.emailConfirmation;
    }
    if (emailSubject == null || emailSubject.isBlank()) {
      emailSubject = msgSettings.subjectLine;
    }
    String ids = transactionIds.stream().map(t -> t.toString()).collect(Collectors.joining(", "));
    Map<String, Object> templateVars = new HashMap<String, Object>();
    templateVars.put("name", name);
    templateVars.put("court_name", courtName);
    templateVars.put("case_type", caseType);
    templateVars.put("transaction_id", ids);
    templateVars.put("case_title", caseTitle);
    boolean canEmail = email != null && SendMessage.isValidEmail(email);
    if (canEmail) {
      int result;
      try {
        result = sendMsg.sendEmail(msgSettings.fromEmail, emailSubject, email, emailTemplate, templateVars);
        return (result == 200 || result == 202 || result == 204);
      } catch (IOException e) {
        log.error(e.toString());
        return false;
      }
    }
    
    return false;
  }
}
