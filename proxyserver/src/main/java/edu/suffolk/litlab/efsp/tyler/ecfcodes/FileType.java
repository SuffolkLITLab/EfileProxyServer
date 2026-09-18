package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.sql.ResultSet;
import java.sql.SQLException;

public record FileType(String name, String code, String extension, String location)
    implements NameAndCode {

  public FileType(String name, String code, String extension, String location) {
    this.name = name;
    this.code = code;
    this.extension = extension.toLowerCase();
    this.location = location;
  }

  public FileType(ResultSet rs) throws SQLException {
    this(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
  }

  public String name() {
    return name;
  }

  public String code() {
    return code;
  }

  public boolean matchesFile(String file) {
    String lower = file.toLowerCase();
    return lower.endsWith(this.extension);
  }

  public static String fileTypeQueries() {
    return """
    SELECT name, code, extension, location
    FROM filetype WHERE jurisdiction=? AND location=?\
    """;
  }

  @Override
  public String toString() {
    return "FileType[name: "
        + name
        + ", code: "
        + code
        + ", extension: "
        + extension
        + ", location: "
        + location
        + "]";
  }
}
