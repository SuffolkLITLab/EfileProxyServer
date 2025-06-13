package edu.suffolk.litlab.efsp.tyler;

/** The type of server environents that Tyler owns themselves. */
public enum TylerEnv {
  /// i.e. the production / live environment
  PROD("prod"),
  /// should be "identical" to PROD
  TEST("test"),
  /// to "deploy patches and new releases prior to introduction into" PROD
  STAGE("stage");

  private String path;

  private TylerEnv(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }
}
