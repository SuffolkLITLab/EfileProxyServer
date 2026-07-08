package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.ecf4.EcfCaseTypes;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.Column;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Heavily based on {@link edu.suffolk.litlab.efsp.tyler.ecfcodes.CaseCategory}, but replacing name
 * with description.
 */
public record CaseCategory(
    /** Actually a string, different from Tyler's numerical codes. */
    String code,
    /* Description to show user*/
    String description,
    /* which ECF Case Type to make for this Case Category */
    EcfCaseTypes ecfCaseType) {

  public CaseCategory(String code, String description, String ecfCaseType) {
    this(code, description, EcfCaseTypes.valueOf(ecfCaseType));
  }

  public CaseCategory(ResultSet rs) throws SQLException {
    this(rs.getString(2), rs.getString(3), EcfCaseTypes.valueOf(rs.getString(4)));
  }

  public static final String TABLE_NAME = "truefiling_casecategory";
  public static final List<Column> columns =
      List.of(
          new Column("code", "text"),
          new Column("description", "text"),
          new Column("ecfcasetype", "text"));

  public static final String CREATE_QUERY =
      """
    CREATE TABLE truefiling_casecategory (
      "code" text PRIMARY KEY,
      "description" text,
      "ecfcasetype" text,
      "location" varchar(80),
      "jurisdiction" varchar(80)
    )
    """;

  public static final String INSERT_QUERY =
      """
    INSERT INTO truefiling_casecategory (
      "code", "description", "ecfcasetype", "location", "jurisdiction"
    ) VALUES (
      ?, ?, ?, ?, ?
    )
    """;

  public static final String DELETE_FROM_QUERY =
      """
    DELETE FROM truefiling_casecategory WHERE jurisdiction=? AND location=?
    """;

  public static final String DELETE_ALL_COURTS_FROM_QUERY =
      """
    DELETE FROM truefiling_casecategory WHERE jurisdiction=?
    """;

  public static String searchCaseCategories() {
    return """
    SELECT DISTINCT description
    FROM truefiling_casecategory
    WHERE jurisdiction=? AND description ILIKE ?
    ORDER BY description
    """;
  }

  public static String courtCoverageCaseCategories() {
    return """
        SELECT DISTINCT location
        FROM truefiling_casecategory
        WHERE jurisdiction=? AND description ILIKE ?
        ORDER BY location
        """;
  }

  public static String retrieveCaseCategoryForName() {
    return """
    SELECT DISTINCT code, location
    FROM truefiling_casecategory
    WHERE jurisdiction=? AND description=?
    ORDER BY location
    """;
  }

  // TODO(#86): stop filtering out criminal categories
  public static String getCaseCategoriesForLoc() {
    return """
    SELECT code, description, ecfcasetype
    FROM truefiling_casecategory
    WHERE jurisdiction=? AND location=? AND ecfcasetype !='CriminalCase'
    """;
  }

  public static String getFileableCaseCategoryForLoc() {
    return """
    SELECT cat.code, cat.description, cat.ecfcasetype
    FROM (
            SELECT cate.code, cate.description, cate.ecfcasetype,
              type.id AS type_id,
              ROW_NUMBER() OVER(PARTITION BY cate.code ORDER BY type.id) AS RN
            FROM truefiling_casecategory AS cate
              INNER JOIN truefiling_casetype AS type
              ON cate.code = type.casecategory AND cate.location = type.location AND cate.jurisdiction = type.jurisdiction
            WHERE cate.jurisdiction=? AND cate.location=? AND cate.ecfcasetype != 'CriminalCase'
        ) cat
    WHERE cat.RN = 1
    """;
  }

  public static String getFileableCaseCategoryForTiming() {
    // TODO: just ignore the timing param higher up
    return getFileableCaseCategoryForLoc();
  }

  public static String getCaseCategoryWithCode() {
    return """
    SELECT code, description, ecfcasetype
    FROM truefiling_casecategory
    WHERE jurisdiction=? AND location=? AND code=?
    """;
  }
}
