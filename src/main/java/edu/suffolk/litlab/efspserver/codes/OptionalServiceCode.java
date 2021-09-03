package edu.suffolk.litlab.efspserver.codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionalServiceCode {
  public final String code;
  public final String name;
  /** An int to represent the order in which to present the optional services. 
   * Will always be present, but might skip numbers or two rows might have the same value: ordering
   * doesn't matter then.
   */
  public final String displayorder;
  /** The Fee associated with this optional service. */
  public final String fee;
  /** This service is only allowed for this given filing code id. */
  public final String filingcodeid;
  /** Fee multiplire: for instance, a request for 3 certified copies would have a value of 3. */
  public final String multiplier;
  /** A textual description for a fee that has a calculated value. */
  public final String altfeedesc;
  /** True if the filer must provide a fee amount (?). */
  public final boolean hasfeeprompt;
  /** Text presented to the filer when prompting for the fee amount. */
  public final String feeprompttext;
  
  public OptionalServiceCode(String code, String name, String displayorder, String fee, String filingcodeid,
      String multiplier, String altfeedesc, String hasfeeprompt, String feeprompttext) {
    this.code = code;
    this.name = name;
    this.displayorder = displayorder;
    this.fee = fee;
    this.filingcodeid = filingcodeid;
    this.multiplier = multiplier;
    this.altfeedesc = altfeedesc;
    this.hasfeeprompt = Boolean.parseBoolean(hasfeeprompt);
    this.feeprompttext = feeprompttext;
  }
  
  public OptionalServiceCode(ResultSet rs) throws SQLException {
    this(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
  }
  
  public static PreparedStatement prepQuery(Connection conn, String courtId, String filingCodeId) throws SQLException {
    PreparedStatement st = conn.prepareStatement(query());
    st.setString(1, courtId);
    st.setString(1, filingCodeId);
    return st;
  }
  
  public static String query() {
    return """
        SELECT code, name, displayorder, fee, filingcodeid, multiplier, altfeedesc, hasfeeprompt, feeprompttext
        FROM optionalservices
        WHERE location=? AND filingcodeid=?
        """;
  }
  
}
