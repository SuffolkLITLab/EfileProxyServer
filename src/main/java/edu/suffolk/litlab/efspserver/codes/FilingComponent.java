package edu.suffolk.litlab.efspserver.codes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilingComponent {

  public String code;
  public String name;
  public String filingcodeid;
  public boolean required;
  public boolean allowmultiple;
  public int displayorder;
  public String efspcode;
  public String location;
  
  public FilingComponent(ResultSet rs) throws SQLException {
    this.code = rs.getString(1);
    this.name = rs.getString(2);
    this.filingcodeid = rs.getString(3);
    this.required = Boolean.parseBoolean(rs.getString(4));
    this.allowmultiple = Boolean.parseBoolean(rs.getString(5));
    this.displayorder = Integer.parseInt(rs.getString(6));
    this.efspcode = rs.getString(7);
    this.location = rs.getString(8);
  }
  
  public static String getFilingComponents() {
    return """
        SELECT code, name, filingcodeid, required, allowmultiple, displayorder, efspcode, location
        FROM filingcomponent
        WHERE domain=? AND location=? AND filingcodeid=?
        """;
  }
  
}
