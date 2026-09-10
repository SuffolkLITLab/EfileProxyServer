package edu.suffolk.litlab.efsp.ecfcodes;

/**
 * The most generic wrapper for genericodes that we can make (a human readable part, and a machine
 * readable part).
 */
public interface NameAndCode {

  public String name();

  public String code();

  /** Should be deprecated and removed eventually. */
  public default String getCode() {
    return code();
  }

  /** Should be deprecated and removed eventually. */
  public default String getName() {
    return name();
  }
}
