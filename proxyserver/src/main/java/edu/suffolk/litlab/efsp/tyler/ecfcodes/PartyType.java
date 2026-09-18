package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public final record PartyType(
    String code,
    String name,
    // NOTE: "Indicates whether a case can have more than one party with this party type." NOT that
    // it's only for new parties. Jesus
    boolean isAvailableForNewParties,
    String casetypeid,
    boolean isrequired,
    BigDecimal amount,
    String numberofpartiestoignore,
    String sendforredaction,
    String dateofdeath,
    int displayorder,
    String efspcode,
    String location)
    implements NameAndCode {

  public static PartyType TestObj(String code, String name, String location) {
    return new PartyType(code, name, true, "123", true, "386.53", "0", "", "", "", "", location);
  }

  public static PartyType MissingType(String code, String caseTypeCode, String location) {
    return new PartyType(
        code, "", true, caseTypeCode, false, "0.00", "0", "", "", "", "", location);
  }

  public PartyType(
      String code,
      String name,
      boolean isAvailable,
      String casetypeid,
      boolean isrequired,
      String fee,
      String numberofpartiestoignore,
      String sendforredaction,
      String dateofdeath,
      String displayorder,
      String efspcode,
      String location) {

    this(
        code,
        name,
        isAvailable,
        casetypeid,
        isrequired,
        new BigDecimal(Double.parseDouble(fee)),
        numberofpartiestoignore,
        sendforredaction,
        dateofdeath,
        (displayorder == null || displayorder.isBlank()) ? 100 : Integer.parseInt(displayorder),
        efspcode,
        location);
  }

  public PartyType(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        rs.getBoolean(3),
        rs.getString(4),
        rs.getBoolean(5),
        rs.getString(6),
        rs.getString(7),
        rs.getString(8),
        rs.getString(9),
        rs.getString(10),
        rs.getString(11),
        rs.getString(12));
  }

  public String name() {
    return name;
  }

  public String code() {
    return code;
  }

  public static String searchPartyType() {
    return """
    SELECT DISTINCT name
    FROM partytype
    WHERE jurisdiction=? AND name ILIKE ?
    ORDER BY name
    """;
  }

  public static String courtCoveragePartyType() {
    return """
    SELECT DISTINCT location
    FROM partytype
    WHERE jurisdiction=? and name ILIKE ?
    ORDER BY location
    """;
  }

  public static String retrievePartyTypeFromName() {
    return """
    SELECT DISTINCT code, location
    FROM partytype
    WHERE jurisdiction=? AND name=?
    ORDER BY location
    """;
  }

  public static String getPartyTypeFromCaseType() {
    return """
    SELECT code, name, isavailablefornewparties, casetypeid, isrequired, amount,
           numberofpartiestoignore, sendforredaction, dateofdeath, displayorder,
           efspcode, location
    FROM partytype
    WHERE jurisdiction=? AND location=? AND casetypeid=?
    ORDER BY isrequired DESC, displayorder, casetypeid DESC\
    """;
  }

  public static String getPartyTypeNoCaseType() {
    return """
    SELECT code, name, isavailablefornewparties, casetypeid, isrequired, amount,
           numberofpartiestoignore, sendforredaction, dateofdeath, displayorder,
           efspcode, location
    FROM partytype
    WHERE jurisdiction=? AND location=? AND casetypeid=''
    ORDER BY isrequired DESC, displayorder, casetypeid DESC\
    """;
  }

  public static String getPartyTypeFromCode() {
    return """
    SELECT code, name, isavailablefornewparties, casetypeid, isrequired, amount,
           numberofpartiestoignore, sendforredaction, dateofdeath, displayorder,
           efspcode, location
    FROM partytype
    WHERE jurisdiction=? AND location=? AND code=?\
    """;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(code)
        .append(", ")
        .append(name)
        .append(", ")
        .append(isrequired)
        .append(", ")
        .append(amount);
    return sb.toString();
  }
}
