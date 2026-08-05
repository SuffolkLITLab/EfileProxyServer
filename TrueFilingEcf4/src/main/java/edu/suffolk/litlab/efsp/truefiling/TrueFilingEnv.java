package edu.suffolk.litlab.efsp.truefiling;

import edu.suffolk.litlab.efsp.ServerEnv;

public enum TrueFilingEnv {
  DEV("dev"),
  TEST("test"),
  PROD("prod");

  private String name;

  private TrueFilingEnv(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static TrueFilingEnv parse(String value) {
    for (var env : TrueFilingEnv.values()) {
      if (value.equalsIgnoreCase(env.getName())) {
        return env;
      }
    }
    throw new IllegalArgumentException("Can't make a `TylerEnv` from: `" + value + "`");
  }

  public static TrueFilingEnv from(ServerEnv env) {
    return switch (env) {
      case ServerEnv.PROD -> PROD;
      case ServerEnv.TEST -> DEV;
    };
  }
}
