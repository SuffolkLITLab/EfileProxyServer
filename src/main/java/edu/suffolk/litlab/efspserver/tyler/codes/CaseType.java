package edu.suffolk.litlab.efspserver.tyler.codes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CaseType {
  public final String code;
  public final String name;
  public final String casecategory;
  /** Whether the court accepts new cases of this type. */
  public final boolean initial;

  public final BigDecimal fee;
  public final String willfileddate;
  public final String efspcode;
  public final String location;

  public CaseType(
      String code,
      String name,
      String casecategory,
      String initial,
      String fee,
      String willfileddate,
      String efspcode,
      String location) {
    this.code = code;
    this.name = name;
    this.casecategory = casecategory;
    this.initial = Boolean.parseBoolean(initial);
    this.fee = BigDecimal.valueOf(Double.parseDouble(fee));
    this.willfileddate = willfileddate;
    this.efspcode = efspcode;
    this.location = location;
  }

  /**
   * A constructor that takes a result set (DOES NOT modify it), gotten from executing the below
   * {@link prepQueryBroad} query.
   *
   * @param rs
   * @throws SQLException
   */
  public CaseType(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5),
        rs.getString(6),
        rs.getString(7),
        rs.getString(8));
  }

  // HACK(brycew): here for when CaseType isn't present, but we have AllWrong collector
  public static CaseType DummyCase() {
    return new CaseType(
        "Bad code",
        "Bad name",
        "Bad Case Categor",
        "true",
        "-1",
        "Bad date",
        "Bade code",
        "Bad loc");
  }

  public static PreparedStatement prepQueryBroad(
      Connection conn, String domain, String courtLocationId, String caseCategoryCode)
      throws SQLException {
    PreparedStatement st = conn.prepareStatement(getCaseTypesForCategory());
    st.setString(1, domain);
    st.setString(2, courtLocationId);
    st.setString(3, caseCategoryCode);
    return st;
  }

  public static PreparedStatement prepQueryTiming(
      Connection conn,
      String domain,
      String courtLocationId,
      String caseCategoryCode,
      Optional<Boolean> isInitial)
      throws SQLException {
    boolean specifiedInitial = isInitial.orElse(false);
    if (specifiedInitial) {
      PreparedStatement st = conn.prepareStatement(getCaseTypesForTiming());
      st.setString(1, domain);
      st.setString(2, courtLocationId);
      st.setString(3, caseCategoryCode);
      st.setString(4, Boolean.toString(specifiedInitial));
      return st;
    }

    PreparedStatement st = conn.prepareStatement(getCaseTypesForCategory());
    st.setString(1, domain);
    st.setString(2, courtLocationId);
    st.setString(3, caseCategoryCode);
    return st;
  }

  public static PreparedStatement prepQueryWithCode(
      Connection conn, String domain, String courtLocationId, String caseTypeCode)
      throws SQLException {
    PreparedStatement st = conn.prepareStatement(getCaseTypesWithCode());
    st.setString(1, domain);
    st.setString(2, courtLocationId);
    st.setString(3, caseTypeCode);
    return st;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(code);
    sb.append(", ");
    sb.append(name);
    sb.append(", ");
    sb.append(casecategory);
    sb.append(", ");
    sb.append(initial);
    sb.append(", ");
    sb.append(fee);
    sb.append(", ");
    sb.append(willfileddate);
    sb.append(", ");
    sb.append(efspcode);
    sb.append(", ");
    sb.append(location);
    return sb.toString();
  }

  private static String getCaseTypesForCategory() {
    return """
        SELECT code, name, casecategory, initial,
        fee, willfileddate, efspcode, location
        FROM casetype WHERE domain=? AND location=? AND casecategory=?""";
  }

  private static String getCaseTypesForTiming() {
    return getCaseTypesForCategory() + " AND initial ILIKE ?";
  }

  private static String getCaseTypesWithCode() {
    return """
        SELECT code, name, casecategory, initial,
          fee, willfileddate, efspcode, location
        FROM casetype WHERE domain=? AND location=? AND code=?
        """;
  }
}
