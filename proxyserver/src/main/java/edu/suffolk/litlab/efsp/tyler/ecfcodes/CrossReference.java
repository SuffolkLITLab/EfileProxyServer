package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record CrossReference(
    String code,
    String name,
    String casetypeid,
    boolean isdefault,
    boolean isrequired,
    Pattern validationregex,
    String customvalidationfailuremessage,
    String efspcode,
    String location)
    implements NameAndCode {

  public CrossReference(
      String code,
      String name,
      String casetypeid,
      String isdefault,
      String isrequired,
      String validationregex,
      String customvalidationfailuremessage,
      String efspcode,
      String location) {
    this(
        code,
        name,
        casetypeid,
        Boolean.parseBoolean(isdefault),
        Boolean.parseBoolean(isrequired),
        (validationregex == null || validationregex.isEmpty())
            ? null
            : Pattern.compile(validationregex),
        customvalidationfailuremessage,
        efspcode,
        location);
  }

  public CrossReference(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5),
        rs.getString(6),
        rs.getString(7),
        rs.getString(8),
        rs.getString(9));
  }

  public static String query() {
    return """
    SELECT code, name, casetypeid, isdefault, isrequired, validationregex,
      customvalidationfailuremessage, efspcode, location
    FROM crossreference WHERE jurisdiction=? AND location=? AND casetypeid=?
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
