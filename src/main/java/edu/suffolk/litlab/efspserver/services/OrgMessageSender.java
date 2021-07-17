package edu.suffolk.litlab.efspserver.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SendMessage;
import edu.suffolk.litlab.efspserver.Transaction;

/**
 * A wrapper around the lower level SendMesage that reads in and
 * handles the actual message sent from configurations.
 * 
 * TODO(brycew): this would be a good candidate for Spring I think
 * @author brycew 
 *
 */
public class OrgMessageSender {
  private static Logger log = 
      LoggerFactory.getLogger(OrgMessageSender.class); 

  // TODO(brycew): unhardcode this stuff somehow
  private String fromEmail = "bwilley@suffolk.edu";
  private String subjectLine = "An update on your filing";
  private String emailTemplate = 
      """
      Dear {{ name }},
      
      The {{ court_id }} has sent a response to your filing in {{ case_type }}:
      
      {{ status }}
      
      You should contact the court directly if you have questions
      about this status.
      
      Best,
      Court Forms Online
      """;
  
  public OrgMessageSender() {
  }
  
  public boolean sendMessage(Transaction transaction, String status) {
    boolean canEmail = transaction.email != null && SendMessage.isValidEmail(transaction.email);
    Map<String, Object> templateVars = new HashMap<String, Object>();
    if (canEmail) {
      int result;
      try {
        result = SendMessage.sendEmail(fromEmail, subjectLine, transaction.email, emailTemplate, templateVars);
        if (result == 200) {
          return true;
        } else {
          return false; 
        }
      } catch (IOException e) {
        log.error(e.toString());
        return false;
      }
    }
      
    // TODO(brycew): handle sending SMS as well
    return false;
  }
}
