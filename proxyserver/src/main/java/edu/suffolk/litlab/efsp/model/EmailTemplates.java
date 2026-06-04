package edu.suffolk.litlab.efsp.model;

public record EmailTemplates(
    String confirmationTemplate,
    String confirmationSubject,
    String acceptedTemplate,
    String acceptedSubject,
    String rejectedTemplate,
    String rejectedSubject,
    String neutralTemplate,
    String neutralSubject) {

  public EmailTemplates() {
    this("", "", "", "", "", "", "", "");
  }
}
