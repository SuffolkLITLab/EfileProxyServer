package edu.suffolk.litlab.efsp.tyler;

/** The type of server environents that Tyler owns themselves. */
public enum TylerEnv {
  /// i.e. the production / live environment
  PROD("prod"),
  /// to "deploy patches and new releases prior to introduction into" PROD
  STAGE("stage");

  private String name;

  private TylerEnv(String name) {
    this.name = name;
  }

  // ** Used for when the env determines a URL / filepath. */
  public String getPath() {
    return name;
  }

  public String getName() {
    return name;
  }

  public static TylerEnv parse(String value) {
    if (value.equalsIgnoreCase(STAGE.getName())) {
      return STAGE;
    } else if (value.equalsIgnoreCase(PROD.getName())) {
      return PROD;
    } else {
      throw new IllegalArgumentException("Can't make a `TylerEnv` from: `" + value + "`'");
    }
  }
}
