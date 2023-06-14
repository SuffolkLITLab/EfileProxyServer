package edu.suffolk.litlab.efspserver.codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FilingCode {

  public final String code;
  public final String name;
  public final String fee;
  public final String casecategory;
  public final String casetypeid;
  public final String filingtype;
  public final boolean iscourtuseonly;
  public final String civilclaimamount;
  public final String probateestateamount;
  public final String amountincontroversy;
  public final boolean useduedate;
  public final boolean isproposedorder;
  public final String efspcode;
  public final String location;
  
  public FilingCode(String code, String name, String fee, String casecategory,
          String casetypeid, String filingtype, boolean iscourtuseonly, String civilclaimamount,
          String probabeestateamount, String amountincontroversy, boolean useduedate,
          boolean isproposedorder, String efspcode, String location) {
    this.code = code;
    this.name = name;
    this.fee = fee;
    this.casecategory = casecategory;
    this.casetypeid = casetypeid;
    this.filingtype = filingtype;
    this.iscourtuseonly = iscourtuseonly;
    this.civilclaimamount = civilclaimamount;
    this.probateestateamount = probabeestateamount;
    this.amountincontroversy = amountincontroversy;
    this.useduedate = useduedate;
    this.isproposedorder = isproposedorder;
    this.efspcode = efspcode;
    this.location = location;
  }
  
  public FilingCode(ResultSet rs) throws SQLException {
      this(
          rs.getString(1),
          rs.getString(2), 
          rs.getString(3),
          rs.getString(4), 
          rs.getString(5), 
          rs.getString(6), 
          rs.getBoolean(7), 
          rs.getString(8), 
          rs.getString(9), 
          rs.getString(10), 
          rs.getBoolean(11), 
          rs.getBoolean(12), 
          rs.getString(13),
          rs.getString(14));
  }

  public Map<String, Object> toMap() {
    return Map.ofEntries(
      Map.entry("code", code),
      Map.entry("name", name),
      Map.entry("fee", fee),
      Map.entry("casecategory", casecategory),
      Map.entry("filingtype", filingtype),
      Map.entry("iscourtuseonly", iscourtuseonly),
      Map.entry("civilclaimamount", civilclaimamount),
      Map.entry("probateestateamount", probateestateamount),
      Map.entry("amountincontroversy", amountincontroversy),
      Map.entry("useduedate", useduedate),
      Map.entry("isproposedorder", isproposedorder),
      Map.entry("efspcode", efspcode),
      Map.entry("location", location)
    );
  }
  
  public static PreparedStatement prepQueryWithCaseInfo(Connection conn, 
      boolean initial, String domain, String courtLocationId, String categoryId, String caseTypeId) throws SQLException {
    PreparedStatement st = conn.prepareStatement(getFilingWithCaseInfo(initial));
    st.setString(1, domain);
    st.setString(2, courtLocationId);
    st.setString(3, categoryId);
    st.setString(4, caseTypeId);
    return st;
  }

  public static PreparedStatement prepQueryNoCaseInfo(Connection conn, 
      boolean initial, String domain, String courtLocationId) throws SQLException {
    PreparedStatement st = conn.prepareStatement(getFilingNoCaseInfo(initial));
    st.setString(1, domain);
    st.setString(2, courtLocationId);
    return st;
  }
  
  // TODO(brycew): test this one in particular, it was wrong
  public static PreparedStatement prepQueryWithKey(Connection conn, String domain, String courtId, String typeCode) throws SQLException {
    PreparedStatement st = conn.prepareStatement(getFilingWithKey());
    st.setString(1, domain);
    st.setString(2, courtId);
    st.setString(3, typeCode);
    return st;
  }
  
  /** @param initial true if its an initial filing, false if it's a subsequent. */
  private static String getFilingWithCaseInfo(boolean initial) {
    String mainQuery = """
          SELECT code, name, fee, casecategory, casetypeid, filingtype, iscourtuseonly, 
                 civilclaimamount, probateestateamount, amountincontroversy, useduedate, 
                 isproposedorder, efspcode, location
          FROM filing 
          WHERE domain=? AND location=? AND iscourtuseonly='False' AND ((casecategory=? AND casetypeid='') OR casetypeid=?) """;
    if (initial) {
      return mainQuery + "AND (filingtype='Initial' OR filingtype='Both')";
    } else {
      return mainQuery + "AND (filingtype='Subsequent' OR filingtype='Both')";
    }
  }
  
  private static String getFilingNoCaseInfo(boolean initial) {
    String mainQuery = """
          SELECT code, name, fee, casecategory, casetypeid, filingtype, iscourtuseonly, 
                 civilclaimamount, probateestateamount, amountincontroversy, useduedate, 
                 isproposedorder, efspcode, location
          FROM filing 
          WHERE domain=? AND location=? AND iscourtuseonly='False' AND 
            ((casecategory='' OR casecategory=null) AND (casetypeid='' OR casetypeid=null)) """;
    if (initial) {
      return mainQuery + "AND (filingtype='Initial' OR filingtype='Both')";
    } else {
      return mainQuery + "AND (filingtype='Subsequent' OR filingtype='Both')";
    }
  }
  
  private static String getFilingWithKey() {
    return """
        SELECT code, name, fee, casecategory, casetypeid, filingtype, iscourtuseonly,
               civilclaimamount, probateestateamount, amountincontroversy, useduedate,
               isproposedorder, efspcode, location
        FROM filing
        WHERE domain=? AND location=? AND code=?
        """;
  }
  
}
