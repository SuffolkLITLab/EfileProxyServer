package edu.suffolk.litlab.efsp.ecfcodes.tyler;

import org.apache.commons.lang3.builder.HashCodeBuilder;

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
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj instanceof NameAndCode otherCode) {
      return name.equals(otherCode.name) && code.equals(otherCode.code);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return (new HashCodeBuilder()).append(name).append(code).build();
  }

  @Override
  // < 0 is means this is before arg0, > means after
  public int compareTo(NameAndCode arg0) {
    int val = name.compareTo(arg0.name);
    if (val != 0) {
      return val;
    } else {
      return code.compareTo(arg0.code);
    }
  }
}
