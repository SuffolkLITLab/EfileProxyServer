package edu.suffolk.litlab.efspserver.tyler;

import java.net.URL;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;

public class TylerUrls {
  private static final Logger log = LoggerFactory.getLogger(TylerUrls.class);

  static final Map<String, String> efmUserWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-EFMUserServiceSingle.svc.wsdl",
          "illinois-test", "wsdl/test/illinois-EFMUserServiceSingle.svc.wsdl",
          "illinois-prod", "wsdl/prod/illinois-EFMUserServiceSingle.svc.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-EFMUserServiceSingle.svc.wsdl",
          "massachusetts-prod", "wsdl/prod/massachusetts-EFMUserServiceSingle.svc.wsdl",
          "california-stage", "wsdl/stage/california-EFMUserServiceSingle.svc.wsdl",
          "texas-stage", "wsdl/stage/texas-EFMUserServiceSingle.svc.wsdl",
          "indiana-stage", "wsdl/stage/indiana-EFMUserServiceSingle.svc.wsdl");

  static final Map<String, String> efmFirmWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-EFMFirmServiceSingle.svc.wsdl",
          "illinois-test", "wsdl/test/illinois-EFMFirmServiceSingle.svc.wsdl",
          "illinois-prod", "wsdl/prod/illinois-EFMFirmServiceSingle.svc.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-EFMFirmServiceSingle.svc.wsdl",
          "massachusetts-prod", "wsdl/prod/massachusetts-EFMFirmServiceSingle.svc.wsdl",
          "california-stage", "wsdl/stage/california-EFMFirmServiceSingle.svc.wsdl",
          "texas-stage", "wsdl/stage/texas-EFMFirmServiceSingle.svc.wsdl",
          "indiana-stage", "wsdl/stage/indiana-EFMFirmServiceSingle.svc.wsdl");

  /**
   * Gets the EfmUserService if the provided domain is present and correct.
   *
   * @param wsdlDomain is the jurisdiction (e.g. "illinois"), "-", and the running environment,
   *     (e.g. "stage"). So the whole thing is "illinois-stage".
   */
  public static Optional<EfmUserService> getEfmUserFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, efmUserWsdls);
    return url.map(u -> new EfmUserService(u));
  }

  /**
   * Gets the EfmUserService from the individual jursdiction and env arguments.
   *
   * @param jurisdiction e.g. "illinois".
   * @param env e.g. "stage", "test", or "prod"
   */
  public static Optional<EfmUserService> getEfmUserFactory(String jurisdiction, String env) {
    return getEfmUserFactory(jurisdiction + "-" + env);
  }

  public static Optional<EfmFirmService> getEfmFirmFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, efmFirmWsdls);
    return url.map(u -> new EfmFirmService(u));
  }

  public static Optional<EfmFirmService> getEfmFirmFactory(String jurisdiction, String env) {
    return getEfmFirmFactory(jurisdiction + "-" + env);
  }

  public static String getCodeEndpointRootUrl(String jurisdiction, String env) {
    if (jurisdiction.equalsIgnoreCase("illinois") && env.equalsIgnoreCase("prod")) {
      return "https://" + jurisdiction + ".tylerhost.net/";
    }
    if (jurisdiction.equalsIgnoreCase("california")) {
      return "https://california-efm-" + env + ".tylertech.cloud/";
    }
    if (env.equalsIgnoreCase("prod")) {
      return "https://" + jurisdiction + ".tylertech.cloud/";
    }
    return "https://" + jurisdiction + "-" + env + ".tylertech.cloud/";
  }

  private static Optional<URL> urlFromString(String wsdlDomain, Map<String, String> domainToWsdl) {
    if (!domainToWsdl.containsKey(wsdlDomain)) {
      return Optional.empty();
    }

    String wsdlPath = domainToWsdl.get(wsdlDomain);
    URL url = TylerUrls.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.info("Can not initialize the default wsdl from {}", "classpath:" + wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
