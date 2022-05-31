package edu.suffolk.litlab.efspserver;

import java.net.URL;
import java.util.Map;
import java.util.Optional;

import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;

/** Handles working in multiple Tyler Jurisdictions. 
 * Needs to have all of the WSDL files hardcoded here, and
 * present in the src/main/resources folder. 
 */
public class SoapClientChooser {

  static Map<String, String> efmUserWsdls = Map.of(
      "illinois-stage", "wsdl/illinois/stage/EFMUserServiceSingle.svc.wsdl",
      "illinois-test",  "wsdl/illinois/test/EFMUserServiceSingle.svc.wsdl",
      "massachusetts-stage", "wsdl/massachusetts/stage/EFMUserServiceSingle.svc.wsdl");

  static Map<String, String> efmFirmWsdls = Map.of(
      "illinois-stage", "wsdl/illinois/stage/EFMFirmServiceSingle.svc.wsdl",
      "illinois-test",  "wsdl/illinois/test/EFMFirmServiceSingle.svc.wsdl",
      "massachusetts-stage", "wsdl/massachusetts/stage/EFMFirmServiceSingle.svc.wsdl");

  static Map<String, String> serviceMDEWsdls = Map.of(
      "illinois-stage", "wsdl/illinois/stage/ECF-4.0-ServiceMDEService.wsdl",
      "illinois-test",  "wsdl/illinois/test/ECF-4.0-ServiceMDEService.wsdl",
      "massachusetts-stage", "wsdl/massachusetts/stage/ECF-4.0-ServiceMDEService.wsdl");

  static Map<String, String> filingReviewMDEWsdls = Map.of(
      "illinois-stage", "wsdl/illinois/stage/ECF-4.0-FilingReviewMDEService.wsdl",
      "illinois-test",  "wsdl/illinois/test/ECF-4.0-FilingReviewMDEService.wsdl",
      "massachusetts-stage", "wsdl/massachusetts/stage/ECF-4.0-FilingReviewMDEService.wsdl");

  static Map<String, String> courtRecordMDEWsdls = Map.of(
      "illinois-stage", "wsdl/illinois/stage/ECF-4.0-CourtRecordMDEService.wsdl",
      "illinois-test",  "wsdl/illinois/test/ECF-4.0-CourtRecordMDEService.wsdl",
      "massachusetts-stage", "wsdl/massachusetts/stage/ECF-4.0-CourtRecordMDEService.wsdl");

  public static String getEndpointRootUrl(String jurisdiction, String env) {
    if (jurisdiction.equalsIgnoreCase("illinois") && env.equalsIgnoreCase("stage")) {
      return "https://" + jurisdiction + "-" + env + ".tylertech.cloud/";
    }
    return "https://" + jurisdiction + "-" + env + ".tylerhost.net/";
  }

  /** 
   * Gets the EfmUserService if the provided domain is present and correct.
   * 
   * @param wsdlDomain is the jurisdiction (e.g. "illinois"), "-", and the running
   *   environment, (e.g. "stage"). So the whole thing is "illinois-stage".
   */
  public static Optional<EfmUserService> getEfmUserFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, efmUserWsdls);
    return url.map(u -> new EfmUserService(u));
  }
  
  /**
   * Gets the EfmUserService from the individual jursdiction and env arguments.
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
  
  public static Optional<FilingReviewMDEService> getFilingReviewFactory(String jurisdiction, String env) {
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

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(String jurisdiction, String env) {
    return getCourtRecordFactory(jurisdiction + "-" + env);
  }
  

  private static Optional<URL> urlFromString(String wsdlDomain, Map<String, String> domainToWsdl) {
    if (!domainToWsdl.containsKey(wsdlDomain)) {
      return Optional.empty();
    }

    String wsdlPath = domainToWsdl.get(wsdlDomain);
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      java.util.logging.Logger.getLogger(ServiceMDEService.class.getName())
             .log(java.util.logging.Level.INFO,
                 "Can not initialize the default wsdl from {0}", "classpath:" + wsdlPath); 
      return Optional.empty();
    }
    
    return Optional.of(url);
  }
}
