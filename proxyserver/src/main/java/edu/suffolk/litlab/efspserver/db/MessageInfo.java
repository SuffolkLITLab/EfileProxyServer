package edu.suffolk.litlab.efspserver.db;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;

public class MessageInfo {
  public UUID serverId;
  public String fromEmail;
  public String subjectLine;
  public String emailResponseTemplate;
  public String confirmationSubjectLine;
  public String emailConfirmation;

  public MessageInfo(
      UUID serverId,
      String fromEmail,
      String subjectLine,
      String emailResponseTemplate,
      String confirmationSubjectLine,
      String emailConfirmation) {
    this.serverId = serverId;
    this.fromEmail = fromEmail;
    this.subjectLine = subjectLine;
    this.emailResponseTemplate = emailResponseTemplate;
    this.emailConfirmation = emailConfirmation;
    this.confirmationSubjectLine = confirmationSubjectLine;
  }

  public MessageInfo(JsonNode node) {
    this(
        (node.has("server_id")) ? UUID.fromString(node.get("server_id").asText(null)) : null,
        (node.has("from_email")) ? node.get("from_email").asText(null) : null,
        (node.has("subject_line")) ? node.get("subject_line").asText(null) : null,
        (node.has("email_template")) ? node.get("email_template").asText(null) : null,
        (node.has("email_confirmation_subject"))
            ? node.get("email_confirmation_subject").asText(null)
            : null,
        (node.has("email_confirmation")) ? node.get("email_confirmation").asText(null) : null);
  }
}
