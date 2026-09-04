package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.Column;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

// System-wide code list
public record ErrorCode(String code, String name) {

  public static final String TABLE_NAME = "truefiling_errorcode";
  public static final List<Column> columns =
      List.of(new Column("code", "text"), new Column("name", "text"));

  public static final String CREATE_QUERY =
      """
  CREATE TABLE truefiling_errorcode (
    "code" text PRIMARY KEY,
    "name" text,
    "location" varchar(80),
    "jurisdiction" varchar(80)
   )   """;

  public static final String INSERT_QUERY =
      """
  INSERT INTO truefiling_errorcode (
    "code", "name", "location", "jurisdiction"
  ) VALUES (
     ?, ?, ?, ?
  )
  """;

  public static final String DELETE_FROM_QUERY =
      """
    DELETE FROM truefiling_errorcode WHERE jurisdiction=? AND location=?
      """;

  public static final String DELETE_ALL_COURTS_FROM_QUERY =
      """
    DELETE FROM truefiling_errorcode WHERE jurisdiction=?
      """;

  public static PreparedStatement prepQuery(Connection conn, String jurisStr, String location)
      throws SQLException {
    String query =
        """
      SELECT code, name FROM truefiling_errorcode WHERE jurisdiction=? AND location=?
        """;
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, jurisStr);
    st.setString(2, location);
    return st;
  }
}
