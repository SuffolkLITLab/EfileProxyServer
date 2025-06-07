package edu.suffolk.litlab.efsp.ecfcodes;

/**
 * An exception used solely when parsing Genericode CodeDocs (i.e. the XML).
 *
 * <p>Can be specifically caught and separated from SQL issues and flagged as a developer issue
 * (instead of an ops issue).
 */
public class CodeDocException extends Exception {
  public CodeDocException(String message, Throwable ex) {
    super(message, ex);
  }
}
