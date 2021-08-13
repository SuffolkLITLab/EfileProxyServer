package edu.suffolk.litlab.efspserver.codes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilingCode {

  public String code;
  public String name;
  public String fee;
  public String casecategory;
  public String casetypeid;
  public String filingtype;
  public boolean iscourtuseonly;
  public String civilclaimamount;
  public String probateestateamount;
  public String amountincontroversy;
  public String useduedate;
  public String isproposedorder;
  public String efspcode;
  public String location;
  
  public FilingCode(String code, String name, String fee, String casecategory,
          String casetypeid, String filingtype, String iscourtuseonly, String civilclaimamount,
          String probabeestateamount, String amountincontroversy, String useduedate,
          String isproposedorder, String efspcode, String location) {
    this.code = code;
    this.name = name;
    this.fee = fee;
    this.casecategory = casecategory;
    this.casetypeid = casetypeid;
    this.filingtype = filingtype;
    this.iscourtuseonly = Boolean.parseBoolean(iscourtuseonly);
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
          rs.getString(7), 
          rs.getString(8), 
          rs.getString(9), 
          rs.getString(10), 
          rs.getString(11), 
          rs.getString(12), 
          rs.getString(13),
          rs.getString(14));
  }
  
  /** @param initial true if its an initial filing, false if it's a subsequent. */
  public static String getFilingWithCaseInfo(boolean initial) {
    String mainQuery = """
          SELECT code, name, fee, casecategory, casetypeid, filingtype, iscourtuseonly, 
                 civilclaimamount, probateestateamount, amountincontroversy, useduedate, 
                 isproposedorder, efspcode, location
          FROM filing 
          WHERE location=? AND iscourtuseonly='False' AND (casecategory=? OR casetypeid=?) """;
    if (initial) {
      return mainQuery + "AND (filingtype='Initial' OR filingtype='Both')";
    } else {
      return mainQuery + "AND (filingtype='Subsequent' OR filingtype='Both')";
    }
  }
  
  public static String getFilingNoCaseInfo(boolean initial) {
    String mainQuery = """
          SELECT code, name, fee, casecategory, casetypeid, filingtype, iscourtuseonly, 
                 civilclaimamount, probateestateamount, amountincontroversy, useduedate, 
                 isproposedorder, efspcode, location
          FROM filing 
          WHERE location=? AND iscourtuseonly='False' AND 
            ((casecategory='' OR casecategory=null) AND (casetypeid='' OR casetypeid=null)) """;
    if (initial) {
      return mainQuery + "AND (filingtype='Initial' OR filingtype='Both')";
    } else {
      return mainQuery + "AND (filingtype='Subsequent' OR filingtype='Both')";
    }
  }
  
}
