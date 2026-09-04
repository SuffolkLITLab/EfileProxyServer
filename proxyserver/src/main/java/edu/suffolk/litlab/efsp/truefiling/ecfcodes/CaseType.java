package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.Column;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public record CaseType(UUID id, String code, String description, String caseCategoryCode) {
  public CaseType(String id, String code, String description, String caseCategoryCode) {
    this(UUID.fromString(id), code, description, caseCategoryCode);
  }

  public CaseType(ResultSet rs) throws SQLException {
    this((UUID) rs.getObject(1), rs.getString(2), rs.getString(3), rs.getString(4));
  }

  public static final String TABLE_NAME = "truefiling_casetype";
  public static final List<Column> columns =
      List.of(
          new Column("id", "uuid"),
          new Column("code", "text"),
          new Column("description", "text"),
          new Column("casecategory", "text"));

  public static final String CREATE_QUERY =
      """
        CREATE TABLE truefiling_casetype (
          "id" uuid PRIMARY KEY,
          "code" text,
          "description" text,
          "casecategory" text,
          "location" varchar(80),
          "jurisdiction" varchar(80)
        )
        """;

  public static final String INSERT_QUERY =
      """
        INSERT INTO truefiling_casetype (
          "id", "code", "description", "casecategory", "location", "jurisdiction"
        ) VALUES (
          ?, ?, ?, ?, ?, ?
        )
    """;

  public static final String DELETE_FROM_QUERY =
      """
      DELETE FROM truefiling_casetype WHERE jurisdiction=? AND location=?
      """;

  public static final String DELETE_ALL_COURTS_FROM_QUERY =
      """
      DELETE FROM truefiling_casetype WHERE jurisdiction=?
      """;

  public static PreparedStatement prepQuery(
      Connection conn, String jurisdiction, String courtLocationId, String caseCategoryCode)
      throws SQLException {
    String query =
        """
        SELECT id, code, description, casecategory
        FROM truefiling_casetype
        WHERE jurisdiction=? AND location=? AND casecategory=?
        """;
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, jurisdiction);
    st.setString(2, courtLocationId);
    st.setString(3, caseCategoryCode);
    return st;
  }

  public static PreparedStatement prepQueryWithCode(
      Connection conn, String jurisdiction, String courtLocationId, UUID caseTypeId)
      throws SQLException {
    String withcode =
        """
        SELECT id, code, description, casecategory
        FROM truefiling_casetype
        WHERE jurisdiction=? AND location=? AND id=?
        """;
    PreparedStatement st = conn.prepareStatement(withcode);
    st.setString(1, jurisdiction);
    st.setString(2, courtLocationId);
    st.setObject(3, caseTypeId);

    return st;
  }

  public static PreparedStatement prepSearchQuery(
      Connection conn, String jurisdiction, String searchTerm) throws SQLException {
    String search =
        """
            SELECT DISTINCT description
            FROM casetype
            WHERE jurisdiction=? AND description ILIKE ?
            ORDER BY description
            """;
    PreparedStatement st = conn.prepareStatement(search);
    st.setString(1, jurisdiction);
    st.setString(2, searchTerm);
    return st;
  }

  public static PreparedStatement prepCourtCoverage(
      Connection conn, String jurisdiction, String searchTerm) throws SQLException {
    String search =
        """
        SELECT DISTINCT location
        FROM casetype
        WHERE jurisdiction=? AND name ILIKE ?
        ORDER BY location
        """;
    PreparedStatement st = conn.prepareStatement(search);
    st.setString(1, jurisdiction);
    st.setString(2, searchTerm);
    return st;
  }

  public static PreparedStatement prepRetrieveQuery(
      Connection conn, String jurisdiction, String caseTypeName) throws SQLException {
    String retrieve =
        """
        SELECT DISTINCT code, location
        FROM casetype
        WHERE jurisdiction=? AND name=?
        ORDER BY location
        """;
    PreparedStatement st = conn.prepareStatement(retrieve);
    st.setString(1, jurisdiction);
    st.setString(2, caseTypeName);
    return st;
  }
}
