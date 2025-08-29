package edu.suffolk.litlab.efsp.tyler;

/**
 * The jurisdictions (states) that Tyler works in and that we support. Even though all possible
 * jurisdictions might be listed here, only those set to the <code>TYLER_JURISDICTIONS</code> env
 * var are supported at runtime.
 *
 * <p>TODO(brycew): eventually this enum should handle other EFM servers, and the "Tyler" part will
 * become a variable in it. Will use this in `JurisdictionServiceHandle` then.
 */
public enum TylerJurisdiction {
  CALIFORNIA("california"),
  INDIANA("indiana"),
  ILLINOIS("illinois"),
  MASSACHUSETTS("massachusetts"),
  TEXAS("texas");

  private String name;

  private TylerJurisdiction(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static TylerJurisdiction parse(String value) {
    for (var jurisdiction : TylerJurisdiction.values()) {
      if (value.equalsIgnoreCase(jurisdiction.getName())) {
        return jurisdiction;
      }
    }
    throw new IllegalArgumentException("Can't make a `TylerJurisdiction` from: `" + value + "`");
  }
}
