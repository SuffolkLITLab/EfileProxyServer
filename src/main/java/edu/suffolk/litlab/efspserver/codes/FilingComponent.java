package edu.suffolk.litlab.efspserver.codes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilingComponent {

  public final String code;
  public final String name;
  public final String filingcodeid;
  public final boolean required;
  public final boolean allowmultiple;
  public final int displayorder;
  public final String efspcode;
  public final String location;

  public FilingComponent(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getBoolean(4),
        rs.getBoolean(5),
        rs.getInt(6),
        rs.getString(7),
        rs.getString(8));
  }

  public FilingComponent(
      String code,
      String name,
      String filingcodeid,
      boolean required,
      boolean allowmultiple,
      int displayorder,
      String efspcode,
      String location) {
    this.code = code;
    this.name = name;
    this.filingcodeid = filingcodeid;
    this.required = required;
    this.allowmultiple = allowmultiple;
    this.displayorder = displayorder;
    this.efspcode = efspcode;
    this.location = location;
  }

  public static String getFilingComponents() {
    return """
        SELECT code, name, filingcodeid, required, allowmultiple, displayorder, efspcode, location
        FROM filingcomponent
        WHERE domain=? AND location=? AND filingcodeid=?
        """;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("FilingComponent[code=");
    sb.append(code);
    sb.append(",name=");
    sb.append(name);
    sb.append(",location=");
    sb.append(location);
    sb.append("]");
    return sb.toString();
  }
}
