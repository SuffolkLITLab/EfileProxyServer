package edu.suffolk.assemblyline.efspserver;

public class PartyType {
  public String partyTypeCode;
  public String partyTypeName;
  public boolean isAvailableForNewParties;
  // TODO(brycew): DON'T use floating point, not precise enough
  public double fee;
  
  public PartyType(String code, String name, String isAvailable, String fee) {
    this.partyTypeCode = code;
    this.partyTypeName = name;
    this.isAvailableForNewParties = Boolean.parseBoolean(isAvailable);
    this.fee = Double.parseDouble(fee);
  }


}
