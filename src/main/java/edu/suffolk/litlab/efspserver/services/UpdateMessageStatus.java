package edu.suffolk.litlab.efspserver.services;

public enum UpdateMessageStatus {
  ACCEPTED,
  REJECTED,
  NEUTRAL;

  public static UpdateMessageStatus fromStr(String str) {
    if (str.equalsIgnoreCase("accepted")) {
      return UpdateMessageStatus.ACCEPTED;
    } else if (str.equalsIgnoreCase("rejected")) {
      return UpdateMessageStatus.REJECTED;
    } else {
      return UpdateMessageStatus.NEUTRAL;
    }
  }
}
