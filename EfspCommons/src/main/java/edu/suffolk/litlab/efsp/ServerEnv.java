package edu.suffolk.litlab.efsp;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.GetEnv;

/** The server software environments that we (Suffolk) have set up. */
public enum ServerEnv {
  /// i.e. the production / live environment
  PROD("prod"),
  /// where we do integration, development, and testing.
  TEST("test");

  private String name;

  private ServerEnv(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static ServerEnv parse(String value) {
    for (var env : ServerEnv.values()) {
      if (value.equalsIgnoreCase(env.getName())) {
        return env;
      }
    }
    throw new IllegalArgumentException("Can't make a `ServerEnv` from: `" + value + "`");
  }

  public static ServerEnv fromEnvVar() {
    return GetEnv("SERVER_ENV")
        .map(ServerEnv::parse)
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "Can't make a `ServerEnv`, Env Var SERVER_ENV isn't present"));
  }
}
