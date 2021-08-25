package edu.suffolk.litlab.efspserver.services;

import java.util.Optional;
import java.util.Set;

public interface EfmModuleSetup {

  void preSetup();
  
  Set<String> getCourts();
  EfmFilingInterface getInterface();
  Optional<EfmRestCallbackInterface> getCallback();
  
  void setupGlobals();

  /** Quick wrapper to get an env var as an optional. */
  public static Optional<String> GetEnv(String envVarName) {
    String val = System.getenv(envVarName);
    if (val == null || val.isBlank()) {
      return Optional.empty(); 
    }
    return Optional.of(val);
  }
}
