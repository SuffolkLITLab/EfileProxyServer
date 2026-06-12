package edu.suffolk.litlab.efsp;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.GetEnv;

import java.util.Optional;

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
        .or(
            () -> {
              var tylerEnv = GetEnv("TYLER_ENV").map(e -> e.toLowerCase());
              Optional<ServerEnv> maybeServer =
                  tylerEnv.map(
                      e -> {
                        return switch (e) {
                          case "prod" -> ServerEnv.PROD;
                          case "stage" -> ServerEnv.TEST;
                          default -> ServerEnv.TEST;
                        };
                      });
              return maybeServer;
            })
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "The Env vars 'SERVER_ENV' ('test' or 'prod') or 'TYLER_ENV' ('stage' or 'prod') needs to be defined"));
  }
}
