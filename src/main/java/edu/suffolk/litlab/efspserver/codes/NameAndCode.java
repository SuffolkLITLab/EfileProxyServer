package edu.suffolk.litlab.efspserver.codes;

public class NameAndCode implements Comparable<NameAndCode> {
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

  @Override
  // < 0 is means this is before arg0, > means after
  public int compareTo(NameAndCode arg0) {
    return name.compareTo(arg0.name);
  }
}
