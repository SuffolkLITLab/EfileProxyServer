package edu.suffolk.litlab.efspserver.db;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;

public class MessageInfo {
    public UUID serverId;
    public String fromEmail;
    public String subjectLine;
    public String emailTemplate;
    
    public MessageInfo(UUID serverId, String fromEmail, String subjectLine, String emailTemplate) {
      this.serverId = serverId;
      this.fromEmail = fromEmail;
      this.subjectLine = subjectLine;
      this.emailTemplate = emailTemplate;
    }
    
    public MessageInfo(JsonNode node) {
      this((node.has("server_id")) ? UUID.fromString(node.get("server_id").asText(null)) : null, 
           (node.has("from_email")) ? node.get("from_email").asText(null) : null, 
           (node.has("subject_line")) ? node.get("subject_line").asText(null) : null, 
           (node.has("email_template")) ? node.get("email_template").asText(null) : null); 
    }
}
