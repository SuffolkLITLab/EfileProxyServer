package edu.suffolk.litlab.efspserver.codes;

import java.math.BigDecimal;

public class CaseType {
  String code;
  String name;
  String casecategory;
  boolean initial;
  BigDecimal fee;
  String willfileddate;
  String efspcode;
  String location;
  
  public CaseType(String code, String name, String casecategory, String initial,
      String fee, String willfileddate, String efspcode, String location) {
    this.code = code;
    this.name = name;
    this.casecategory = casecategory;
    this.initial = Boolean.parseBoolean(initial);
    this.fee = BigDecimal.valueOf(Double.parseDouble(fee));
    this.willfileddate = willfileddate;
    this.efspcode = efspcode;
    this.location = location;
  }
}
