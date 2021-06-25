package edu.suffolk.assemblyline.efspserver.codes;

public class NameAndCode {
  String name;
  String code;
  
  public NameAndCode(String name, String code) {
    this.name = name;
    this.code = code;
  }
  
  public String getName() {
    return name;
  }
  
  public String getCode() {
    return code;
  }
}
