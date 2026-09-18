package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;

public record Disclaimer(String code, String name, int listorder, String requirementText)
    implements NameAndCode {

  public Disclaimer(String code, String name, int listorder, String requirementText) {
    this.code = code;
    this.name = name;
    this.listorder = listorder;
    this.requirementText = requirementText;
  }

  public Disclaimer(String code, String name, String listOrder, String requirementText) {
    this(code, name, Integer.parseInt(listOrder), requirementText);
  }

  public static String getDisclaimerRequirements() {
    return "SELECT code, name, listorder, requirementtext FROM disclaimerrequirement WHERE jurisdiction=?"
        + " AND location=?";
  }
}
