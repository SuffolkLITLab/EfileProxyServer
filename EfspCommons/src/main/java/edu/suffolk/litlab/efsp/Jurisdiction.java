package edu.suffolk.litlab.efsp;

/**
 * The jurisdictions (states) that our code works in and that we support. Even though all possible
 * jurisdictions might be listed here, only those set to the <code>TYLER_JURISDICTIONS</code> env
 * var are supported at runtime.
 *
 * <p>At the moment, each jurisdiction is uniquely mapped to a single API and Vendor of that API
 * (i.e. ECF, and Tyler). This is for when we expand to having multiple APIs (i.e. ECF v4 and ECF
 * v5) and multiple vendors(Tyler and SoftImage).
 */
public enum Jurisdiction {
  CALIFORNIA("california", Api.ECF_4, Vendor.TYLER),
  INDIANA("indiana", Api.ECF_4, Vendor.TYLER),
  ILLINOIS("illinois", Api.ECF_4_Schedule, Vendor.TYLER),
  LOUISIANA("louisiana", Api.JEFFNET, Vendor.JEFFERSON_PARISH),
  MASSACHUSETTS("massachusetts", Api.ECF_4, Vendor.TYLER),
  TEXAS("texas", Api.ECF_4, Vendor.TYLER),
  VERMONT("vermont", Api.ECF_4, Vendor.TYLER);

  public enum Api {
    JEFFNET,
    ECF_4,
    // Illinois uses a custom Tyler ECF4 version, which includes a pre-release ECF 5
    // version of the Court Scheduling MDE.
    ECF_4_Schedule;
  }

  public enum Vendor {
    JEFFERSON_PARISH,
    TYLER;
  }

  private String name;
  private Api api;
  private Vendor vendor;

  private Jurisdiction(String name, Api api, Vendor vendor) {
    this.name = name;
    this.api = api;
    this.vendor = vendor;
  }

  public String getName() {
    return name;
  }

  public Vendor getVendor() {
    return vendor;
  }

  public Api getApi() {
    return api;
  }

  public static Jurisdiction parse(String value) {
    for (var jurisdiction : Jurisdiction.values()) {
      if (value.equalsIgnoreCase(jurisdiction.getName())) {
        return jurisdiction;
      }
    }
    throw new IllegalArgumentException("Can't make a `Jurisdiction` from: `" + value + "`");
  }
}
