package edu.suffolk.litlab.efspserver.codes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceCodeType {
  public final String code;
  public final String name;
  public final String servicemethod;
  public final String fee;
  public final String disclaimertext;

  public ServiceCodeType(
      String code, String name, String servicemethod, String fee, String disclaimertext) {
    this.code = code;
    this.name = name;
    this.servicemethod = servicemethod;
    this.fee = fee;
    this.disclaimertext = disclaimertext;
  }

  public ServiceCodeType(ResultSet rs) throws SQLException {
    this(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
  }

  public static String query() {
    return "SELECT code, name, servicemethod, fee, disclaimertext FROM servicetype WHERE domain=?"
        + " AND location=?";
  }
}
