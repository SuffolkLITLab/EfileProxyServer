package edu.suffolk.assemblyline.efspserver.codes;

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

}
