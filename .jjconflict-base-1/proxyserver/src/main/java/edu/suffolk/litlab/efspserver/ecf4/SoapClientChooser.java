package edu.suffolk.litlab.efspserver.ecf4;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;

/**
 * Handles working in multiple Tyler Jurisdictions. Needs to have all of the WSDL files hardcoded
 * here, and present in the src/main/resources folder.
 */
public class SoapClientChooser {

  private static final Logger log = LoggerFactory.getLogger(SoapClientChooser.class);

  static final Map<String, String> serviceMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-ECF-4.0-ServiceMDEService.wsdl",
          "illinois-test", "wsdl/test/illinois-ECF-4.0-ServiceMDEService.wsdl",
          "illinois-prod", "wsdl/prod/illinois-ECF-4.0-ServiceMDEService.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-ECF-4.0-ServiceMDEService.wsdl",
          "massachusetts-prod", "wsdl/prod/massachusetts-ECF-4.0-ServiceMDEService.wsdl",
          "california-stage", "wsdl/stage/california-ECF-4.0-ServiceMDEService.wsdl",
          "texas-stage", "wsdl/stage/texas-ECF-4.0-ServiceMDEService.wsdl",
          "indiana-stage", "wsdl/stage/indiana-ECF-4.0-ServiceMDEService.wsdl");

  static final Map<String, String> filingReviewMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          "illinois-test", "wsdl/test/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          "illinois-prod", "wsdl/prod/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl",
          "massachusetts-prod", "wsdl/prod/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl",
          "california-stage", "wsdl/stage/california-ECF-4.0-FilingReviewMDEService.wsdl",
          "texas-stage", "wsdl/stage/texas-ECF-4.0-FilingReviewMDEService.wsdl",
          "indiana-stage", "wsdl/stage/indiana-ECF-4.0-FilingReviewMDEService.wsdl");

  static final Map<String, String> courtRecordMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          "illinois-test", "wsdl/test/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          "illinois-prod", "wsdl/prod/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          "massachusetts-stage", "wsdl/stage/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl",
          "massachusetts-prod", "wsdl/prod/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl",
          "california-stage", "wsdl/stage/california-ECF-4.0-CourtRecordMDEService.wsdl",
          "texas-stage", "wsdl/stage/texas-ECF-4.0-CourtRecordMDEService.wsdl",
          "indiana-stage", "wsdl/stage/indiana-ECF-4.0-CourtRecordMDEService.wsdl");

  static final Map<String, String> courtSchedulingMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-v5-CourtSchedulingMDE.wsdl",
          "illinois-test", "wsdl/test/illinois-v5-CourtSchedulingMDE.wsdl",
          "illinois-prod", "wsdl/prod/illinois-v5-CourtSchedulingMDE.wsdl");

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
