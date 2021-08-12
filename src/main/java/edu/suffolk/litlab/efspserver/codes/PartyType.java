package edu.suffolk.litlab.efspserver.codes;

import java.math.BigDecimal;

public class PartyType {
  public String partyTypeCode;
  public String partyTypeName;
  public boolean isAvailableForNewParties;
  public BigDecimal fee;

  public PartyType(String code, String name, String isAvailable, String fee) {
    this.partyTypeCode = code;
    this.partyTypeName = name;
    this.isAvailableForNewParties = Boolean.parseBoolean(isAvailable);
    this.fee = new BigDecimal(Double.parseDouble(fee));
  }

  public static String getPartyTypeFromCaseType() {
    return """
        SELECT p.code, p.name, p.isavailablefornewparties, p.casetypeid, p.isrequired, p.amount, p.numberofpartiestoignore, p.sendforredaction, p.dateofdeath, p.displayorder, p.efspcode, p.location 
        FROM partytype AS p 
        WHERE p.location=? AND p.casetypeid=?""";
  }
  

}
