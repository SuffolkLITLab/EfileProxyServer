package edu.suffolk.litlab.efsp.stdlib;

import java.util.Optional;

/** Things that really should just be in the standard lib. */
public class StdLib {
  /** Wrapper to get an env var as an optional: there if present, empty if not. */
  public static Optional<String> GetEnv(String envVarName) {
    String val = System.getenv(envVarName);
    if (val == null || val.isBlank()) {
      return Optional.empty();
    }
    return Optional.of(val);
  }

  /** A simple check to make sure something isn't null or blank. Used in a lot of places. */
  public static boolean exists(String val) {
    return val != null && !val.isBlank();
  }
}
