package edu.suffolk.litlab.efsp.tyler;

import edu.suffolk.litlab.efsp.Jurisdiction;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.EfmFirmService;
import tyler.efm.EfmUserService;

public class TylerClients {
  private static final Logger log = LoggerFactory.getLogger(TylerClients.class);
  private static final String USER_WSDL = "-EFMUserServiceSingle.svc.wsdl";
  private static final String FIRM_WSDL = "-EFMFirmServiceSingle.svc.wsdl";
  private static final String VERSION_KEY_PREFIX = "edu.suffolk.litlab.efsp.tyler.version.";

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

  public static String getTylerServerRootUrl(TylerDomain domain) {
    if (domain.jurisdiction() == Jurisdiction.CALIFORNIA) {
      return "https://california-efm-" + domain.env().getName() + ".tylertech.cloud/";
    }
    if (domain.env() == TylerEnv.PROD) {
      return "https://" + domain.jurisdiction().getName() + ".tylertech.cloud/";
    }
    return "https://" + domain.getName() + ".tylertech.cloud/";
  }

  public static Optional<TylerVersion> getVersion(TylerDomain domain) {
    String propertiesFile = "application." + domain.env().getName() + ".properties";
    var props = new Properties();
    try (var is = TylerClients.class.getClassLoader().getResourceAsStream(propertiesFile)) {
      if (is == null) {
        log.warn("Could not find properties file:{}", propertiesFile);
        return Optional.empty();
      }
      props.load(is);
    } catch (IOException e) {
      log.warn("Failed to load properties file:{}", propertiesFile, e);
      return Optional.empty();
    }
    String key = VERSION_KEY_PREFIX + domain.jurisdiction().getName();
    String value = props.getProperty(key);
    if (value == null) {
      log.warn("No Tyler version configured for key:{}", key);
      return Optional.empty();
    }
    try {
      return Optional.of(TylerVersion.valueOf(value.trim()));
    } catch (IllegalArgumentException e) {
      log.warn("Unknown TylerVersion value '{}' for key '{}'", value, key);
      return Optional.empty();
    }
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
