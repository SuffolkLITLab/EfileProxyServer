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

  private static final Map<TylerJurisdiction, TylerVersion> STAGE_VERSION_MAP =
      Map.of(
          TylerJurisdiction.CALIFORNIA, TylerVersion.v2024_6,
          TylerJurisdiction.ILLINOIS, TylerVersion.v2024_6,
          TylerJurisdiction.INDIANA, TylerVersion.v2024_6,
          TylerJurisdiction.MASSACHUSETTS, TylerVersion.v2025_0,
          TylerJurisdiction.TEXAS, TylerVersion.v2024_6);

  private static final Map<TylerJurisdiction, TylerVersion> PROD_VERSION_MAP =
      Map.of(
          TylerJurisdiction.ILLINOIS, TylerVersion.v2024_6,
          TylerJurisdiction.MASSACHUSETTS, TylerVersion.v2022_1);

  /**
   * Gets the EfmUserService from the individual jursdiction and env arguments.
   *
   * @param domain e.g. TylerJurisdiction.ILLINOIS, TylerEnv.STAGE.
   */
  public static Optional<TylerUserFactory> getEfmUserFactory(TylerDomain domain) {
    var version = getVersion(domain);
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, USER_WSDL);
          return url.map(u -> new TylerUserFactory(new EfmUserService(u), v));
        });
  }

  public static Optional<TylerFirmFactory> getEfmFirmFactory(TylerDomain domain) {
    var version = getVersion(domain);
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, FIRM_WSDL);
          return url.map(u -> new TylerFirmFactory(new EfmFirmService(u), v));
        });
  }

  /**
   * Gets Tyler server's root URL for a given jurisdiction / Tyler Env (i.e. california stage).
   *
   * <p>TODO(brycew): turn this into a URL type? Find where it's used.
   *
   * @param domain
   * @return
   */
  public static String getTylerServerRootUrl(TylerDomain domain) {
    if (domain.jurisdiction() == TylerJurisdiction.CALIFORNIA) {
      return "https://california-efm-" + domain.env().getName() + ".tylertech.cloud/";
    }
    if (domain.env() == TylerEnv.PROD) {
      return "https://" + domain.jurisdiction().getName() + ".tylertech.cloud/";
    }
    return "https://" + domain.getName() + ".tylertech.cloud/";
  }

  private static Optional<TylerVersion> getVersion(TylerDomain domain) {
    Map<TylerJurisdiction, TylerVersion> versionMap =
        switch (domain.env()) {
          case TylerEnv.STAGE -> STAGE_VERSION_MAP;
          case TylerEnv.PROD -> PROD_VERSION_MAP;
        };

    if (!versionMap.containsKey(domain.jurisdiction())) {
      return Optional.empty();
    }

    return Optional.of(versionMap.get(domain.jurisdiction()));
  }

  private static Optional<URL> createLocalWsdlUrl(
      TylerDomain domain, TylerVersion version, String suffix) {
    String wsdlPath =
        "wsdl/"
            + version.getVersionPath()
            + "/"
            + domain.env().getName()
            + "/"
            + domain.jurisdiction().getName()
            + suffix;
    URL url = TylerClients.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.warn("Could not find the wsdl at the classpath:{}", wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
