package edu.suffolk.litlab.efsp.ecfcodes.tyler;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PartyType {
  public final String code;
  public final String name;
  // NOTE: "Indicates whether a case can have more than one party with this party type." NOT that
  // it's only for new parties. Jesus
  public final boolean isAvailableForNewParties;
  public final String casetypeid;
  public final boolean isrequired;
  public final BigDecimal amount;
  public final String numberofpartiestoignore;
  public final String sendforredaction;
  public final String dateofdeath;
  public final int displayorder;
  public final String efspcode;
  public final String location;

  public static PartyType TestObj(String code, String name, String location) {
    return new PartyType(code, name, true, "123", true, "386.53", "0", "", "", "", "", location);
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
    this.code = code;
    this.name = name;
    this.isAvailableForNewParties = isAvailable;
    this.casetypeid = casetypeid;
    this.isrequired = isrequired;
    this.amount = new BigDecimal(Double.parseDouble(fee));
    this.numberofpartiestoignore = numberofpartiestoignore;
    this.sendforredaction = sendforredaction;
    this.dateofdeath = dateofdeath;
    if (displayorder.isBlank()) {
      this.displayorder = 100;
    } else {
      this.displayorder = Integer.parseInt(displayorder);
    }
    this.efspcode = efspcode;
    this.location = location;
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

  public static String searchPartyType() {
    return """
    SELECT DISTINCT name
    FROM partytype
    WHERE domain=? AND name ILIKE ?
    ORDER BY name
    """;
  }

  public static String retrievePartyTypeFromName() {
    return """
    SELECT DISTINCT code, location
    FROM partytype
    WHERE domain=? AND name=?
    ORDER BY location
    """;
  }

  public static String getPartyTypeFromCaseType() {
    return """
    SELECT code, name, isavailablefornewparties, casetypeid, isrequired, amount,
           numberofpartiestoignore, sendforredaction, dateofdeath, displayorder,
           efspcode, location
    FROM partytype
    WHERE domain=? AND location=? AND casetypeid=?
    ORDER BY isrequired DESC, displayorder, casetypeid DESC\
    """;
  }

  public static String getPartyTypeNoCaseType() {
    return """
    SELECT code, name, isavailablefornewparties, casetypeid, isrequired, amount,
           numberofpartiestoignore, sendforredaction, dateofdeath, displayorder,
           efspcode, location
    FROM partytype
    WHERE domain=? AND location=? AND casetypeid=''
    ORDER BY isrequired DESC, displayorder, casetypeid DESC\
    """;
  }

  public static String getPartyTypeFromCode() {
    return """
    SELECT code, name, isavailablefornewparties, casetypeid, isrequired, amount,
           numberofpartiestoignore, sendforredaction, dateofdeath, displayorder,
           efspcode, location
    FROM partytype
    WHERE domain=? AND location=? AND code=?\
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
