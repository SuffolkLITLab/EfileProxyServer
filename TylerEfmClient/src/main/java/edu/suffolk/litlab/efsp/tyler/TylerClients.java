package edu.suffolk.litlab.efsp.tyler;

import edu.suffolk.litlab.efsp.Jurisdiction;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;
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

  private static final Map<Jurisdiction, TylerVersion> STAGE_VERSION_MAP =
      loadVersionMap(TylerEnv.STAGE);
  private static final Map<Jurisdiction, TylerVersion> PROD_VERSION_MAP =
      loadVersionMap(TylerEnv.PROD);

  private static Map<Jurisdiction, TylerVersion> loadVersionMap(TylerEnv env) {
    String propertiesFile = "application." + env.getName() + ".properties";
    var props = new Properties();
    try (var is = new FileInputStream(propertiesFile)) {
      props.load(is);
    } catch (FileNotFoundException ex) {
      try (var secondIs = TylerClients.class.getClassLoader().getResourceAsStream(propertiesFile)) {
        if (secondIs == null) {
          throw new RuntimeException(
              "Couldn't load config file as file in current dir or as class resource. "
                  + propertiesFile);
        }
        props.load(secondIs);
      } catch (IOException e) {
        throw new RuntimeException(
            "Failed to load properties file as class resource " + propertiesFile, e);
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to load properties file: " + propertiesFile, e);
    }
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
    Map<Jurisdiction, TylerVersion> versionMap =
        switch (domain.env()) {
          case STAGE -> STAGE_VERSION_MAP;
          case PROD -> PROD_VERSION_MAP;
        };
    return Optional.ofNullable(versionMap.get(domain.jurisdiction()));
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
