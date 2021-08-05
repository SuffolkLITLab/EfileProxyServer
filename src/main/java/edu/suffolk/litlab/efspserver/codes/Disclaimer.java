package edu.suffolk.litlab.efspserver.codes;

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

}
