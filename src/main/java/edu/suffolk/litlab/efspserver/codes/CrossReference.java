package edu.suffolk.litlab.efspserver.codes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrossReference {
  public final String code;
  public final String name;
  public final String casetypeid;
  public final boolean isdefault;
  public final boolean isrequired;
  public final Pattern validationregex;
  public final String customvalidationfailuremessage;
  public final String efspcode;
  public final String location;
  
  public CrossReference(String code, String name, String casetypeid, String isdefault, 
      String isrequired, String validationregex, String customvalidationfailuremessage,
      String efspcode, String location) {
    this.code = code;
    this.name = name;
    this.casetypeid = casetypeid;
    this.isdefault = Boolean.parseBoolean(isdefault);
    this.isrequired = Boolean.parseBoolean(isrequired);
    if (validationregex == null || validationregex.isEmpty()) {
      this.validationregex = null;
    } else {
      this.validationregex = Pattern.compile(validationregex);
    }
    this.customvalidationfailuremessage = customvalidationfailuremessage;
    this.efspcode = efspcode;
    this.location = location;
  }
  
  public CrossReference(ResultSet rs) throws SQLException {
    this(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
  }
  
  public static String query() {
    return """
        SELECT code, name, casetypeid, isdefault, isrequired, validationregex, customvalidationfailuremessage
        FROM crossreference WHERE location=? AND casetypeid=?
        """;
  }
  
  public boolean matchesRegex(String value) {
    if (this.validationregex == null) {
      return true;
    }
    
    Matcher matcher = this.validationregex.matcher(value);
    return matcher.find();
  }

}
