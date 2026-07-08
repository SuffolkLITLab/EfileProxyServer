package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.Column;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

// is per court
public record DocumentType(
    UUID id,
    UUID caseTypeId,
    String description,
    // TODO: idk what this is used for, not referenced elsewhere in the docs
    String filingServiceType,
    boolean courtUseOnly) {

  public static final String TABLE_NAME = "truefiling_documenttype";
  public static final List<Column> columns =
      List.of(
          new Column("id", "uuid"),
          new Column("casetypeid", "text"), // should be UUID?
          new Column("casetypecode", "text"),
          new Column("formlink", "text"),
          new Column("description", "text"),
          new Column("filingservicetype", "text"),
          new Column("courtuseonly", "boolean"));

  public static final String CREATE_QUERY =
      """
  CREATE TABLE truefiling_documenttype (
    "id" uuid PRIMARY KEY,
    "casetypeid" text,
    "casetypecode" text,
    "formlink" text,
    "description" text,
    "filingservicetype" text,
    "courtuseonly" boolean,
    "location" varchar(80),
    "jurisdiction" varchar(80)
  )
         """;

  public static final String INSERT_QUERY =
      """
  INSERT INTO truefiling_documenttype (
    "id", "casetypeid", "casetypecode", "formlink", "description", "filingservicetype", "courtuseonly", "location", "jurisdiction"
  ) VALUES (
    ?, ?, ?, ?, ?, ?, ?, ?, ?
  )
      """;

  public static final String DELETE_FROM_QUERY =
      """
  DELETE FROM truefiling_documenttype WHERE jurisdiction=? AND location=?
      """;

  public static final String DELETE_ALL_COURTS_FROM_QUERY =
      """
  DELETE FROM truefiling_documenttype WHERE jurisdiction=?
      """;

  public static PreparedStatement prepQuery(
      Connection conn, String jurisStr, String location, String casetypeid) throws SQLException {
    String query =
        """
      SELECT id, casetypeid, casetypecode, formlink, description, filingservicetype, courtuseonly
      FROM truefiling_documenttype
      WHERE jurisdiction=? AND location=? AND casetypeid=?
      """;
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, jurisStr);
    st.setString(2, location);
    st.setString(3, casetypeid);
    return st;
  }
}
