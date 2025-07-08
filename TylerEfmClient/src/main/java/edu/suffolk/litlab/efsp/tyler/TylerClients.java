package edu.suffolk.litlab.efsp.tyler;

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

  private static final Map<String, TylerVersion> STAGE_VERSION_MAP =
      Map.of(
          "california", TylerVersion.v2024_6,
          "illinois", TylerVersion.v2024_6,
          "indiana", TylerVersion.v2024_6,
          "massachusetts", TylerVersion.v2025_0,
          "texas", TylerVersion.v2024_6);

  private static final Map<String, TylerVersion> PROD_VERSION_MAP =
      Map.of(
          "illinois", TylerVersion.v2024_6,
          "massachusetts", TylerVersion.v2022_1);

  /**
   * Gets the EfmUserService from the individual jursdiction and env arguments.
   *
   * @param jurisdiction e.g. "illinois".
   * @param env e.g. "stage", "test", or "prod"
   */
  public static Optional<EfmUserService> getEfmUserFactory(String jurisdiction, TylerEnv env) {
    var version = getVersion(jurisdiction, env);
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(jurisdiction, env, v, USER_WSDL);
          return url.map(u -> new EfmUserService(u, v));
        });
  }

  public static Optional<EfmFirmService> getEfmFirmFactory(String jurisdiction, TylerEnv env) {
    var version = getVersion(jurisdiction, env);
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(jurisdiction, env, v, FIRM_WSDL);
          return url.map(u -> new EfmFirmService(u, v));
        });
  }

  /**
   * Gets Tyler server's root URL for a given jurisdiction / Tyler Env (i.e. california stage).
   *
   * @param jurisdiction
   * @param envEnum
   * @return
   */
  public static String getTylerServerRootUrl(String jurisdiction, TylerEnv envEnum) {
    String env = envEnum.name().toLowerCase();
    if (jurisdiction.equalsIgnoreCase("california")) {
      return "https://california-efm-" + env + ".tylertech.cloud/";
    }
    if (envEnum.equals(TylerEnv.PROD)) {
      return "https://" + jurisdiction + ".tylertech.cloud/";
    }
    return "https://" + jurisdiction + "-" + env + ".tylertech.cloud/";
  }

  private static Optional<TylerVersion> getVersion(String jurisdiction, TylerEnv tylerEnv) {
    Map<String, TylerVersion> versionMap =
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
      String jurisdiction, TylerEnv env, TylerVersion version, String suffix) {
    String wsdlPath =
        "wsdl/" + version.getVersionPath() + "/" + env.getPath() + "/" + jurisdiction + suffix;
    URL url = TylerClients.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.warn("Could not find the wsdl at the classpath:{}", wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
