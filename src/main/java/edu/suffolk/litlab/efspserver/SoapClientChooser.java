package edu.suffolk.litlab.efspserver;

import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;

/**
 * Handles working in multiple Tyler Jurisdictions. Needs to have all of the WSDL files hardcoded
 * here, and present in the src/main/resources folder.
 */
public class SoapClientChooser {

  private static final Logger log = LoggerFactory.getLogger(SoapClientChooser.class);

  static final Map<String, String> efmUserWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-EFMUserServiceSingle.svc.wsdl",
          "illinois-test", "wsdl/test/illinois-EFMUserServiceSingle.svc.wsdl",
          "illinois-prod", "wsdl/prod/illinois-EFMUserServiceSingle.svc.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-EFMUserServiceSingle.svc.wsdl",
          "texas-stage", "wsdl/stage/texas-EFMUserServiceSingle.svc.wsdl",
          "indiana-stage", "wsdl/stage/indiana-EFMUserServiceSingle.svc.wsdl");

  static final Map<String, String> efmFirmWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-EFMFirmServiceSingle.svc.wsdl",
          "illinois-test", "wsdl/test/illinois-EFMFirmServiceSingle.svc.wsdl",
          "illinois-prod", "wsdl/prod/illinois-EFMFirmServiceSingle.svc.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-EFMFirmServiceSingle.svc.wsdl",
          "texas-stage", "wsdl/stage/texas-EFMFirmServiceSingle.svc.wsdl",
          "indiana-stage", "wsdl/stage/indiana-EFMFirmServiceSingle.svc.wsdl");

  static final Map<String, String> serviceMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-ECF-4.0-ServiceMDEService.wsdl",
          "illinois-test", "wsdl/test/illinois-ECF-4.0-ServiceMDEService.wsdl",
          "illinois-prod", "wsdl/prod/illinois-ECF-4.0-ServiceMDEService.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-ECF-4.0-ServiceMDEService.wsdl",
          "texas-stage", "wsdl/stage/texas-ECF-4.0-ServiceMDEService.wsdl",
          "indiana-stage", "wsdl/stage/indiana-ECF-4.0-ServiceMDEService.wsdl");

  static final Map<String, String> filingReviewMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          "illinois-test", "wsdl/test/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          "illinois-prod", "wsdl/prod/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl",
          "texas-stage", "wsdl/stage/texas-ECF-4.0-FilingReviewMDEService.wsdl",
          "indiana-stage", "wsdl/stage/indiana-ECF-4.0-FilingReviewMDEService.wsdl");

  static final Map<String, String> courtRecordMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          "illinois-test", "wsdl/test/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          "illinois-prod", "wsdl/prod/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl",
          "texas-stage", "wsdl/stage/texas-ECF-4.0-CourtRecordMDEService.wsdl",
          "indiana-stage", "wsdl/stage/indiana-ECF-4.0-CourtRecordMDEService.wsdl");

  static final Map<String, String> courtSchedulingMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-v5-CourtSchedulingMDE.wsdl",
          "illinois-test", "wsdl/test/illinois-v5-CourtSchedulingMDE.wsdl",
          "illinois-prod", "wsdl/prod/illinois-v5-CourtSchedulingMDE.wsdl");

  public static String getCodeEndpointRootUrl(String jurisdiction, String env) {
    if ((jurisdiction.equalsIgnoreCase("massachusetts")
            || jurisdiction.equalsIgnoreCase("illinois"))
        && env.equalsIgnoreCase("prod")) {
      return "https://" + jurisdiction + ".tylerhost.net/";
    }
    if (env.equalsIgnoreCase("prod")) {
      return "https://" + jurisdiction + ".tylertech.cloud/";
    }
    return "https://" + jurisdiction + "-" + env + ".tylertech.cloud/";
  }

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

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, filingReviewMDEWsdls);
    return url.map(u -> new FilingReviewMDEService(u));
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(
      String jurisdiction, String env) {
    return getFilingReviewFactory(jurisdiction + "-" + env);
  }

  public static Optional<ServiceMDEService> getServiceFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, serviceMDEWsdls);
    return url.map(u -> new ServiceMDEService(u));
  }

  public static Optional<ServiceMDEService> getServiceFactory(String jurisdiction, String env) {
    return getServiceFactory(jurisdiction + "-" + env);
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, courtRecordMDEWsdls);
    return url.map(u -> new CourtRecordMDEService(u));
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(
      String jurisdiction, String env) {
    return getCourtRecordFactory(jurisdiction + "-" + env);
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, courtSchedulingMDEWsdls);
    return url.map(u -> new CourtSchedulingMDE_Service(u));
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      String jurisdiction, String env) {
    return getCourtSchedulingFactory(jurisdiction + "-" + env);
  }

  private static Optional<URL> urlFromString(String wsdlDomain, Map<String, String> domainToWsdl) {
    if (!domainToWsdl.containsKey(wsdlDomain)) {
      return Optional.empty();
    }

    String wsdlPath = domainToWsdl.get(wsdlDomain);
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.info("Can not initialize the default wsdl from {}", "classpath:" + wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
