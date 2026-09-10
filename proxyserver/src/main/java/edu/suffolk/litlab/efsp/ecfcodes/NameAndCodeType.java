package edu.suffolk.litlab.efsp.ecfcodes;

public record NameAndCodeType(String name, String code)
    implements Comparable<NameAndCode>, NameAndCode {

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  @Override
  // < 0 is means this is before arg0, > means after
  public int compareTo(NameAndCode arg0) {
    int val = name.compareTo(arg0.name());
    if (val != 0) {
      return val;
    } else {
      return code.compareTo(arg0.code());
    }
  }
}
