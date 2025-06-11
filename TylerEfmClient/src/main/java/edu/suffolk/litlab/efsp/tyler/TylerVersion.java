package edu.suffolk.litlab.efsp.tyler;

/** All of the versions of Tyler's servers that we need to interact with. */
public enum TylerVersion {
  v2022_1("v2022-1"),
  v2024_6("v2024-6"),
  v2025_0("v2025-0");

  private String versionPath;

  private TylerVersion(String versionPath) {
    this.versionPath = versionPath;
  }

  /**
   * The path in the <code>resources/wsdl</code> directory where the WSDLs for this version of the
   * Tyler servers will be.
   *
   * @return
   */
  public String getVersionPath() {
    return versionPath;
  }
}
