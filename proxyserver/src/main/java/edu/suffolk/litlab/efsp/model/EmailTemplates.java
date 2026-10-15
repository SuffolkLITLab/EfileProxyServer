package edu.suffolk.litlab.efsp.model;

import java.util.Optional;

public record EmailTemplates(
    String confirmationTemplate,
    String confirmationSubject,
    String acceptedTemplate,
    String acceptedSubject,
    String rejectedTemplate,
    String rejectedSubject,
    String neutralTemplate,
    String neutralSubject,
    String fromEmail) {

  public EmailTemplates() {
    this("", "", "", "", "", "", "", "", "");
  }

  public Optional<String> checkFromEmail() {
    if (fromEmail == null || fromEmail.isBlank()) {
      return Optional.empty();
    } else {
      return Optional.of(fromEmail);
    }
  }
}
