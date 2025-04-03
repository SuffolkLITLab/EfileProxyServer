package edu.suffolk.litlab.efspserver.tyler.codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseCategory {
  /** The Tyler specific code for this case category. E.g.: 183528 */
  public final String code;

  /**
   * A human understandable name for this category. Can be broad, like "Probate", or specific, like
   * "Law Magistrate: Damages over $10,000 up to $50,000
   */
  public final String name;

  /**
   * The ECF Case Type Schema Name. These are things like "AppellateCase", "BankruptcyCase", etc.
   * The full list is at
   * https://docs.oasis-open.org/legalxml-courtfiling/specs/ecf/v4.01/ecf-v4.01-spec/errata02/os/ecf-v4.01-spec-errata02-os-complete.html#_Toc425241622
   */
  public final String ecfcasetype;

  // TODO(brycew-later): turn these into enums
  /**
   * Indicates the behavior of the Procedure/Remedy code field for initial filings E.g.: (Not
   * Available, Available, Required)
   */
  public final String procedureremedyinitial;

  /**
   * Indicates the behavior of the Procedure/Remedy code field for subsequent filings E.g.: (Not
   * Available, Available, Required)
   */
  public final String procedureremedysubsequent;

  /**
   * Indicates the behavior of the DamageAmount code field for initial filings. E.g.: (Not
   * Available, Available, Required)
   */
  public final String damageamountinitial;

  public final String damageamountsubsequent;

  public CaseCategory(
      String code,
      String name,
      String ecfCaseType,
      String procedureremedyinitial,
      String procedureSub,
      String damageinitial,
      String damagesubsequent) {
    this.code = code;
    this.name = name;
    this.ecfcasetype = ecfCaseType;
    this.procedureremedyinitial = procedureremedyinitial;
    this.procedureremedysubsequent = procedureSub;
    this.damageamountinitial = damageinitial;
    this.damageamountsubsequent = damagesubsequent;
  }

  public CaseCategory(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5),
        rs.getString(6),
        rs.getString(7));
  }

  public String getCode() {
    return code;
  }

  public static PreparedStatement prepFilableQueryTiming(
      Connection conn, String domain, String courtLocationId, Boolean isInitial)
      throws SQLException {
    if (isInitial) {
      PreparedStatement st = conn.prepareStatement(getFileableCaseCategoryForTiming());
      st.setString(1, domain);
      st.setString(2, courtLocationId);
      st.setString(3, Boolean.toString(isInitial));
      return st;
    }
    return prepFileableQuery(conn, domain, courtLocationId);
  }

  public static PreparedStatement prepFileableQuery(
      Connection conn, String domain, String courtLocationId) throws SQLException {
    PreparedStatement st = conn.prepareStatement(getFileableCaseCategoryForLoc());
    st.setString(1, domain);
    st.setString(2, courtLocationId);
    return st;
  }

  public static String searchCaseCategories() {
    return """
    SELECT DISTINCT name
    FROM casecategory
    WHERE domain=? AND name ILIKE ?
    ORDER BY name
    """;
  }

  public static String retrieveCaseCategoryForName() {
    return """
    SELECT DISTINCT code, location
    FROM casecategory
    WHERE domain=? AND name=?
    ORDER BY location
    """;
  }

  // TODO(#86): stop filtering out criminal categories
  public static String getCaseCategoriesForLoc() {
    return """
    SELECT code, name, ecfcasetype, procedureremedyinitial,
      procedureremedysubsequent, damageamountinitial, damageamountsubsequent
    FROM casecategory WHERE domain=? AND location=? AND ecfcasetype !='CriminalCase'\
    """;
  }

  public static String getFileableCaseCategoryForLoc() {
    return """
    SELECT cat.code, cat.name, cat.ecfcasetype, cat.procedureremedyinitial,
      cat.procedureremedysubsequent, cat.damageamountinitial, cat.damageamountsubsequent
    FROM (
            SELECT cate.code, cate.name, cate.ecfcasetype, cate.procedureremedyinitial,
              cate.procedureremedysubsequent, cate.damageamountinitial,
              cate.damageamountsubsequent,
              type.code AS type_code,
              ROW_NUMBER() OVER(PARTITION BY cate.code ORDER BY type.code) AS RN
            FROM casecategory as cate
              INNER JOIN casetype AS type
              ON cate.code = type.casecategory AND cate.location = type.location
            WHERE cate.domain=? AND cate.location=? AND cate.ecfcasetype != 'CriminalCase'
        ) cat
    WHERE cat.RN = 1
    """;
  }

  public static String getFileableCaseCategoryForTiming() {
    return """
    SELECT cat.code, cat.name, cat.ecfcasetype, cat.procedureremedyinitial,
      cat.procedureremedysubsequent, cat.damageamountinitial, cat.damageamountsubsequent
    FROM (
            SELECT cate.code, cate.name, cate.ecfcasetype, cate.procedureremedyinitial,
              cate.procedureremedysubsequent, cate.damageamountinitial,
              cate.damageamountsubsequent,
              type.code AS type_code,
              ROW_NUMBER() OVER(PARTITION BY cate.code ORDER BY type.code) AS RN
            FROM casecategory as cate
              INNER JOIN casetype AS type
              ON cate.code = type.casecategory AND cate.location = type.location
            WHERE cate.domain=? AND cate.location=? AND cate.ecfcasetype != 'CriminalCase' AND type.initial ILIKE ?
        ) cat
    WHERE cat.RN = 1
    """;
  }

  public static String getCaseCategoryWithCode() {
    return """
    SELECT code, name, ecfcasetype, procedureremedyinitial,
      procedureremedysubsequent, damageamountinitial, damageamountsubsequent
    FROM casecategory WHERE domain=? AND location=? AND code=?
    """;
  }
}
