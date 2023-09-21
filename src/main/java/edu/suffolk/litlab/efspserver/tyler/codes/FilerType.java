package edu.suffolk.litlab.efspserver.tyler.codes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilerType {
  public final String code;
  public final String name;
  public final boolean isDefault;
  public final String efspcode;
  public final String location;

  public FilerType(String code, String name, boolean isDefault, String efspcode, String location) {
    this.code = code;
    this.name = name;
    this.isDefault = isDefault;
    this.efspcode = efspcode;
    this.location = location;
  }

  public FilerType(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        Boolean.parseBoolean(rs.getString(3)),
        rs.getString(4),
        rs.getString(5));
  }

  public static String query() {
    return """
      SELECT "code", "name", "default", "efspcode", "location"
      FROM filertype
      WHERE domain=? AND location=?""";
  }
}
