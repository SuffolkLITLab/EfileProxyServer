package edu.suffolk.litlab.efsp.tyler;

/** The type of server environents that Tyler owns themselves. */
public enum TylerEnv {
  /// i.e. the production / live environment
  PROD("prod"),
  /// to "deploy patches and new releases prior to introduction into" PROD
  STAGE("stage");

  private String path;

  private TylerEnv(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public static TylerEnv parse(String value) {
    if (value.equalsIgnoreCase(STAGE.getPath())) {
      return STAGE;
    } else if (value.equalsIgnoreCase(PROD.getPath())) {
      return PROD;
    } else {
      throw new IllegalArgumentException("Can't make a `TylerEnv` from: " + value);
    }
  }
}
