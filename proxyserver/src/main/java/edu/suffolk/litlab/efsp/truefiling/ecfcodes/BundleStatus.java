package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.Column;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BundleStatus {

  public static final String TABLE_NAME = "truefiling_bundlestatus";
  public static final List<Column> columns = List.of(new Column("code", "text"));

  public static final String CREATE_QUERY =
      """
  CREATE TABLE truefiling_bundlestatus (
    "code" text PRIMARY KEY,
    "location" varchar(80),
    "jurisdiction" varchar(80)
  )
  """;

  public static final String INSERT_QUERY =
      """
    INSERT INTO truefiling_bundlestatus (
      "code", "location", "jurisdiction"
    ) VALUES (
      ?, ?, ?
    )
    """;

  public static final String DELETE_FROM_QUERY =
      """
    DELETE FROM truefiling_bundlestatus WHERE jurisdiction=? AND location=?
    """;

  public static final String DELETE_ALL_COURTS_FROM_QUERY =
      """
    DELETE FROM truefiling_bundlestatus WHERE jurisdiction=?
    """;

  public static PreparedStatement prepQuery(Connection conn, String jurisStr, String location)
      throws SQLException {
    String query = "SELECT code FROM truefiling_bundlestatus WHERE jurisdiction=? AND location=?";
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, jurisStr);
    st.setString(2, location);
    return st;
  }
}
