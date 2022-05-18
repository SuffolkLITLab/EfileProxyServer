package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Each module has a jurisdiction it's associated too, and a set of courts that it can handle.
 */
public interface EfmModuleSetup {
  static Logger log = LoggerFactory.getLogger(EfmModuleSetup.class);

  void preSetup();
  void shutdown();
  
  Set<String> getCourts();
  JurisdictionServiceHandle getServiceHandle();
  Optional<EfmRestCallbackInterface> getCallback();
  String getJurisdiction();
  
  void setupGlobals();

  /** Quick wrapper to get an env var as an optional. */
  public static Optional<String> GetEnv(String envVarName) {
    String val = System.getenv(envVarName);
    if (val == null || val.isBlank()) {
      return Optional.empty(); 
    }
    return Optional.of(val);
  }
  
  public static Map<Boolean, List<Optional<String>>> GetAllEnvs(Stream<String> vars) {
    return vars.map(s -> {
      Optional<String> maybeVar = EfmModuleSetup.GetEnv(s);
      if (maybeVar.isEmpty()) {
        log.warn("You need " + s + " as an env var");
      }
      return maybeVar;
    }).collect(Collectors.partitioningBy(opt -> opt.isEmpty()));
  }
}
