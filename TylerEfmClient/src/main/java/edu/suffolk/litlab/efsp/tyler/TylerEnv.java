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

  public String getName() {
    return name;
  }

  public static TylerEnv parse(String value) {
    for (var env : TylerEnv.values()) {
      if (value.equalsIgnoreCase(env.getName())) {
        return env;
      }
    }
    throw new IllegalArgumentException("Can't make a `TylerEnv` from: `" + value + "`");
  }
}
