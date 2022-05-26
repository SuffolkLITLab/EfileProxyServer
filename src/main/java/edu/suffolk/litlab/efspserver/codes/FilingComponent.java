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
    this(rs.getString(1), rs.getString(2), rs.getString(3),
        Boolean.parseBoolean(rs.getString(4)),
        Boolean.parseBoolean(rs.getString(5)),
        Integer.parseInt(rs.getString(6)),
        rs.getString(7),
        rs.getString(8));
  }

  public FilingComponent(String code, String name, String filingcodeid, boolean required, 
      boolean allowmultiple, int displayorder, String efspcode, String location) {
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
    return "FilingComponent[code=" + code + ",name=" + name + ",location=" + location + "]";
  }

}
