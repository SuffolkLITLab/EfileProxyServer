package edu.suffolk.litlab.efsp.db.model;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.chooseNotBlank;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.stdlib.SensitiveInfo;
import java.util.Optional;
import java.util.UUID;

public record MessageInfo(
    UUID serverId,
    String fromEmail,
    Optional<SensitiveInfo<String>> sendgridApiKey,
    String subjectLine,
    String emailResponseTemplate,
    String confirmationSubjectLine,
    String emailConfirmation) {

  public MessageInfo(
      UUID serverId,
      String fromEmail,
      Optional<SensitiveInfo<String>> sendgridApiKey,
      String subjectLine,
      String emailResponseTemplate,
      String confirmationSubjectLine,
      String emailConfirmation) {
    this.serverId = serverId;
    this.fromEmail = fromEmail;
    this.sendgridApiKey = sendgridApiKey;
    this.subjectLine = subjectLine;
    this.emailResponseTemplate = emailResponseTemplate;
    this.emailConfirmation = emailConfirmation;
    this.confirmationSubjectLine = confirmationSubjectLine;
  }

  public MessageInfo(
      UUID serverId,
      String fromEmail,
      String sendgridApiKey,
      String subjectLine,
      String emailResponseTemplate,
      String confirmationSubjectLine,
      String emailConfirmation) {
    this(
        serverId,
        fromEmail,
        Optional.ofNullable(sendgridApiKey).map(key -> new SensitiveInfo<>(key)),
        subjectLine,
        emailResponseTemplate,
        confirmationSubjectLine,
        emailConfirmation);
  }

  public MessageInfo(
      UUID serverId,
      String fromEmail,
      String subjectLine,
      String emailResponseTemplate,
      String confirmationSubjectLine,
      String emailConfirmation) {
    this(
        serverId,
        fromEmail,
        Optional.empty(),
        subjectLine,
        emailResponseTemplate,
        confirmationSubjectLine,
        emailConfirmation);
  }

  public MessageInfo overlayOn(MessageInfo newInfo) {
    return new MessageInfo(
        serverId,
        chooseNotBlank(fromEmail, newInfo.fromEmail()),
        sendgridApiKey.or(() -> newInfo.sendgridApiKey()),
        chooseNotBlank(subjectLine, newInfo.subjectLine()),
        chooseNotBlank(emailResponseTemplate, newInfo.emailResponseTemplate()),
        chooseNotBlank(confirmationSubjectLine, newInfo.confirmationSubjectLine()),
        chooseNotBlank(emailConfirmation, newInfo.emailConfirmation()));
  }

  public MessageInfo(JsonNode node) {
    this(
        (node.has("server_id")) ? UUID.fromString(node.get("server_id").asText(null)) : null,
        (node.has("from_email")) ? node.get("from_email").asText(null) : null,
        (String) null,
        (node.has("subject_line")) ? node.get("subject_line").asText(null) : null,
        (node.has("email_template")) ? node.get("email_template").asText(null) : null,
        (node.has("email_confirmation_subject"))
            ? node.get("email_confirmation_subject").asText(null)
            : null,
        (node.has("email_confirmation")) ? node.get("email_confirmation").asText(null) : null);
  }
}
