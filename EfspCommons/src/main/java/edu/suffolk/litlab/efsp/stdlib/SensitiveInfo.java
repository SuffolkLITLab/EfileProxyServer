package edu.suffolk.litlab.efsp.stdlib;

public record SensitiveInfo<T>(T field) {
  public String toString() {
    return "SensitiveInfo[value=***]";
  }
}
