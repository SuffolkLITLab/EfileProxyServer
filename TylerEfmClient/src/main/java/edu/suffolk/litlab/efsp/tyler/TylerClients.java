package edu.suffolk.litlab.efsp.tyler;

import edu.suffolk.litlab.efsp.ConfigurationLoader;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ServerEnv;
import java.net.URL;
import java.util.EnumMap;
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
  private static final String VERSION_KEY_PREFIX = "edu.suffolk.litlab.efsp.tyler.version.";

  private static boolean shouldLogRequests = false;

  private static Map<Jurisdiction, TylerVersion> VERSION_MAP;

  private static Map<Jurisdiction, TylerVersion> loadVersionMap() {
    var props = ConfigurationLoader.loadConfig();
    var map = new EnumMap<Jurisdiction, TylerVersion>(Jurisdiction.class);
    for (Jurisdiction jurisdiction : Jurisdiction.values()) {
      String key = VERSION_KEY_PREFIX + jurisdiction.getName();
      String value = props.getProperty(key);
      if (value != null) {
        try {
          map.put(jurisdiction, TylerVersion.valueOf(value.trim()));
        } catch (IllegalArgumentException e) {
          throw new RuntimeException(
              "Unknown TylerVersion value '" + value.trim() + "' for key '" + key + "'");
        }
      }
    }
    return map;
  }

  public static final TylerEnv getTylerEnv() {
    return TylerEnv.from(ServerEnv.fromEnvVar());
  }

  /**
   * Gets the EfmUserService from the individual jursdiction and env arguments.
   *
   * @param jurisdiction e.g. "illinois".
   * @param env e.g. "stage", "test", or "prod"
   */
  public static Optional<TylerUserFactory> getEfmUserFactory(Jurisdiction jurisdiction) {
    var version = getVersion(jurisdiction);
    var domain = new TylerDomain(jurisdiction, getTylerEnv());
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, USER_WSDL);
          return url.map(u -> new TylerUserFactory(new EfmUserService(u), v, shouldLogRequests));
        });
  }

  public static Optional<TylerFirmFactory> getEfmFirmFactory(Jurisdiction jurisdiction) {
    var version = getVersion(jurisdiction);
    var domain = new TylerDomain(jurisdiction, getTylerEnv());
    return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, FIRM_WSDL);
          return url.map(u -> new TylerFirmFactory(new EfmFirmService(u), v, shouldLogRequests));
        });
  }

  /**
   * Gets Tyler server's root URL for a given jurisdiction / Tyler Env (i.e. california stage).
   *
   * @param jurisdiction
   * @param envEnum
   * @return
   */
  public static String getTylerServerRootUrl(Jurisdiction jurisdiction) {
    TylerDomain domain = new TylerDomain(jurisdiction, getTylerEnv());
    if (domain.jurisdiction() == Jurisdiction.CALIFORNIA) {
      return "https://california-efm-" + domain.env().getName() + ".tylertech.cloud/";
    }
    if (domain.env() == TylerEnv.PROD) {
      return "https://" + domain.jurisdiction().getName() + ".tylertech.cloud/";
    }
    return "https://" + domain.getName() + ".tylertech.cloud/";
  }

  public static Optional<TylerVersion> getVersion(Jurisdiction jurisdiction) {
    if (VERSION_MAP == null) {
      VERSION_MAP = loadVersionMap();
      shouldLogRequests = ConfigurationLoader.shouldLogRequests();
    }
    return Optional.ofNullable(VERSION_MAP.get(jurisdiction));
  }

  private static Optional<URL> createLocalWsdlUrl(
      TylerDomain domain, TylerVersion version, String suffix) {
    var envName = domain.env().getName();
    var jurisName = domain.jurisdiction().getName();
    String wsdlPath = "wsdl/" + version.getVersionPath() + "/" + envName + "/" + jurisName + suffix;
    URL url = TylerClients.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.warn("Could not find the wsdl at the classpath:{}", wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
