package edu.suffolk.litlab.efspserver.tyler.codes;

/**
 * The code and location for a Tyler code.
 *
 * <p>Returned by the various "search" APIs; you search for all codes with "XYZ" in the name, and
 * then do `/filing_code_names/XYZ` to get the code and location, enough to find all of the
 * information you need about that code.
 */
public class CodeAndLocation {
  public final String code;
  public final String location;

  public CodeAndLocation(String code, String location) {
    this.code = code;
    this.location = location;
  }
}
