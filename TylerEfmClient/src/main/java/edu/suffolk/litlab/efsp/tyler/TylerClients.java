package edu.suffolk.litlab.efsp.tyler;

import static edu.suffolk.litlab.efsp.tyler.TylerJurisdiction.*;

import java.net.URL;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.EfmFirmService;
import tyler.efm.EfmUserService;

public class TylerClients {
  private static final Logger log = LoggerFactory.getLogger(TylerClients.class);

  private static final String USER_WSDL = "-EFMUserServiceSingle.svc.wsdl";
  private static final String FIRM_WSDL = "-EFMFirmServiceSingle.svc.wsdl";

  private static final Map<TylerJurisdiction, TylerVersion> STAGE_VERSION_MAP =
      Map.of(
          CALIFORNIA, TylerVersion.v2024_6,
          ILLINOIS, TylerVersion.v2024_6,
          INDIANA, TylerVersion.v2024_6,
          MASSACHUSETTS, TylerVersion.v2025_0,
          TEXAS, TylerVersion.v2024_6);

  private static final Map<TylerJurisdiction, TylerVersion> PROD_VERSION_MAP =
      Map.of(
          ILLINOIS, TylerVersion.v2024_6,
          MASSACHUSETTS, TylerVersion.v2022_1);

  /**
   * Gets the EfmUserService from the individual jursdiction and env arguments.
   *
   * @param jurisdiction e.g. "illinois".
   * @param env e.g. "stage", "test", or "prod"
   */
  public static Optional<TylerUserFactory> getEfmUserFactory(TylerJurisdiction jurisdiction, TylerEnv env) {
    var version = getVersion(jurisdiction, env);
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(jurisdiction, env, v, USER_WSDL);
          return url.map(u -> new TylerUserFactory(new EfmUserService(u), v));
        });
  }

  public static Optional<TylerFirmFactory> getEfmFirmFactory(TylerJurisdiction jurisdiction, TylerEnv env) {
    var version = getVersion(jurisdiction, env);
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(jurisdiction, env, v, FIRM_WSDL);
          return url.map(u -> new TylerFirmFactory(new EfmFirmService(u), v));
        });
  }

  /**
   * Gets Tyler server's root URL for a given jurisdiction / Tyler Env (i.e. california stage).
   *
   * @param jurisdiction
   * @param envEnum
   * @return
   */
  public static String getTylerServerRootUrl(TylerJurisdiction jurisdiction, TylerEnv envEnum) {
    String env = envEnum.name().toLowerCase();
    if (jurisdiction == CALIFORNIA) {
      return "https://california-efm-" + env + ".tylertech.cloud/";
    }
    if (envEnum.equals(TylerEnv.PROD)) {
      return "https://" + jurisdiction.toString().toLowerCase() + ".tylertech.cloud/";
    }
    return "https://" + jurisdiction.toString().toLowerCase() + "-" + env + ".tylertech.cloud/";
  }

  private static Optional<TylerVersion> getVersion(TylerJurisdiction jurisdiction, TylerEnv tylerEnv) {
    Map<TylerJurisdiction, TylerVersion> versionMap =
        switch (tylerEnv) {
          case TylerEnv.STAGE -> STAGE_VERSION_MAP;
          case TylerEnv.PROD -> PROD_VERSION_MAP;
        };

    if (!versionMap.containsKey(jurisdiction)) {
      return Optional.empty();
    }

    return Optional.of(versionMap.get(jurisdiction));
  }

  private static Optional<URL> createLocalWsdlUrl(
      TylerJurisdiction jurisdiction, TylerEnv env, TylerVersion version, String suffix) {
    String wsdlPath =
        "wsdl/" + version.getVersionPath() + "/" + env.getPath() + "/" + jurisdiction.toString().toLowerCase() + suffix;
    URL url = TylerClients.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.warn("Could not find the wsdl at the classpath:{}", wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
