package edu.suffolk.litlab.efspserver.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SendMessage;
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
  
  private final MessageSettingsDatabase md;
  private final SendMessage sendMsg;

  private String defaultFrom = "massaccess@suffolk.edu";
  private String defaultSubject = "An update on your filing";
  private String defaultTemplate = 
      """
      Dear {{ name }},
      
      The {{ court_id }} has sent a response to your filing in {{ case_type }} 
      (transaction ID is {{ transaction_id }}):
      
      {{ status }}
      
      {{ message_text }}
      
      {% if variable is defined %}
      You can visit {{ message_url }} for more details.
      {% endif %}
      
      You should contact the court directly if you have questions.
      
      Best,
      Court Forms Online
      """;
  private String defaultConfirmation = 
      """
      Dear {{ name }},
      
      The {{ court_id }} has received your filing in {{ case_type }}!
      
      Its transaction ID is {{ transaction_id }}. You should keep track of this; the court might
      need it in your interactions with them.
      
      They will send you a response shortly.

      You should contact the court directly if you have questions.
      
      Best,
      Court Forms Online
      """;
  
  public OrgMessageSender(MessageSettingsDatabase md, SendMessage sendMsg) {
    this.md = md;
    this.sendMsg = sendMsg;
  }
  
  private MessageInfo getSettings(UUID serverId) {
    Optional<MessageInfo> maybeInfo;
    maybeInfo = md.findMessageInfo(serverId);
    if (maybeInfo.isPresent()) {
      MessageInfo info = maybeInfo.get();
      if (info.fromEmail == null) {
        info.fromEmail = defaultFrom;
      }
      if (info.subjectLine == null) {
        info.subjectLine = defaultSubject;
      }
      if (info.emailTemplate == null) {
        info.emailTemplate = defaultTemplate;
      }
      if (info.emailConfirmation == null) {
        info.emailConfirmation = defaultConfirmation;
      }
      return info;
    } else {
      log.warn("Couldn't get message settings, using defaults");
      return new MessageInfo(serverId, defaultFrom, defaultSubject, defaultTemplate, defaultConfirmation); 
    }
  }
  
  public boolean sendMessage(Transaction transaction, Map<String, String> statuses) {
    MessageInfo msgSettings = getSettings(transaction.serverId);
    Map<String, Object> templateVars = new HashMap<String, Object>();
    templateVars.put("name", transaction.name);
    templateVars.put("court_id", transaction.courtId);
    templateVars.put("case_type", transaction.caseType);
    templateVars.putAll(statuses);
    templateVars.put("transaction_id", transaction.transactionId.toString());
    boolean canEmail = transaction.email != null && SendMessage.isValidEmail(transaction.email);
    if (canEmail) {
      int result;
      try {
        result = sendMsg.sendEmail(msgSettings.fromEmail, msgSettings.subjectLine, transaction.email, msgSettings.emailTemplate, templateVars);
        return (result == 200 || result == 202 || result == 204);
      } catch (IOException e) {
        log.error(e.toString());
        return false;
      }
    }
      
    // TODO(brycew-later): handle sending SMS as well
    return false;
  }
  
  public boolean sendConfirmation(String email, UUID serverId, String name, 
      List<UUID> transactionIds, String courtId, String caseType) {
    MessageInfo msgSettings = getSettings(serverId);
    String ids = transactionIds.stream().map(t -> t.toString()).collect(Collectors.joining(", "));
    Map<String, Object> templateVars = new HashMap<String, Object>();
    templateVars.put("name", name);
    templateVars.put("court_id", courtId);
    templateVars.put("case_type", caseType);
    templateVars.put("transaction_id", ids);
    boolean canEmail = email != null && SendMessage.isValidEmail(email);
    if (canEmail) {
      int result;
      try {
        result = sendMsg.sendEmail(msgSettings.fromEmail, msgSettings.subjectLine, email, msgSettings.emailConfirmation, templateVars);
        return (result == 200 || result == 202 || result == 204);
      } catch (IOException e) {
        log.error(e.toString());
        return false;
      }
    }
    
    return false;
  }
}
