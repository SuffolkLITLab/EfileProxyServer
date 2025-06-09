package edu.suffolk.litlab.efspserver.tyler.codes;

public class Disclaimer {
  public String code;
  public String name;
  public int listorder;
  public String requirementText;

  public Disclaimer(String code, String name, int listOrder, String requirementText) {
    this.code = code;
    this.name = name;
    this.listorder = listOrder;
    this.requirementText = requirementText;
  }

  public Disclaimer(String code, String name, String listOrder, String requirementText) {
    this(code, name, Integer.parseInt(listOrder), requirementText);
  }

  public static String getDisclaimerRequirements() {
    return "SELECT code, name, listorder, requirementtext FROM disclaimerrequirement WHERE domain=?"
        + " AND location=?";
  }
}
