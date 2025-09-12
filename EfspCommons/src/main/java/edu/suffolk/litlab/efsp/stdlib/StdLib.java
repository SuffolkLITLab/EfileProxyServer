package edu.suffolk.litlab.efsp.stdlib;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Things that really should just be in the standard lib. */
public class StdLib {
  private static final Logger log = LoggerFactory.getLogger(StdLib.class);

  /** Quick wrapper to get an env var as an optional. */
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
