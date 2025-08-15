package edu.suffolk.litlab.efsp.server.setup;

import edu.suffolk.litlab.efsp.server.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Each module has a jurisdiction it's associated too, and a set of courts that it can handle. */
public interface EfmModuleSetup {
  static Logger log = LoggerFactory.getLogger(EfmModuleSetup.class);

  void preSetup();

  void shutdown();

  JurisdictionServiceHandle getServiceHandle();

  Optional<EfmRestCallbackInterface> getCallback();

  String getJurisdiction();

  void setupGlobals();

  public static Map<Boolean, List<Optional<String>>> GetAllEnvs(Stream<String> vars) {
    return vars.map(
            s -> {
              Optional<String> maybeVar = StdLib.GetEnv(s);
              if (maybeVar.isEmpty()) {
                log.warn("You need {} as an env var", s);
              }
              return maybeVar;
            })
        .collect(Collectors.partitioningBy(opt -> opt.isEmpty()));
  }
}
