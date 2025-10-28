package edu.suffolk.litlab.efsp.server.ecf4;

import edu.suffolk.litlab.efsp.tyler.TylerEnv;
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

  // TODO(#284): finish this refactor to use TylerEnvs instead of strings
  private static final Map<String, URL> serviceMDEWsdls =
      Map.of(
          "illinois-stage", getRes("wsdl/stage/illinois-ECF-4.0-ServiceMDEService.wsdl"),
          "illinois-test", getRes("wsdl/test/illinois-ECF-4.0-ServiceMDEService.wsdl"),
          "illinois-prod", getRes("wsdl/prod/illinois-ECF-4.0-ServiceMDEService.wsdl"),
          "massachusetts-stage", getRes("wsdl/stage/massachusetts-ECF-4.0-ServiceMDEService.wsdl"),
          "massachusetts-prod", getRes("wsdl/prod/massachusetts-ECF-4.0-ServiceMDEService.wsdl"),
          "california-stage", getRes("wsdl/stage/california-ECF-4.0-ServiceMDEService.wsdl"),
          "texas-stage", getRes("wsdl/stage/texas-ECF-4.0-ServiceMDEService.wsdl"),
          "indiana-stage", getRes("wsdl/stage/indiana-ECF-4.0-ServiceMDEService.wsdl"),
          "vermont-stage", getRes("wsdl/stage/vermont-ECF-4.0-ServiceMDEService.wsdl"));

  private static final Map<String, URL> filingReviewMDEWsdls =
      Map.of(
          "illinois-stage", getRes("wsdl/stage/illinois-ECF-4.0-FilingReviewMDEService.wsdl"),
          "illinois-test", getRes("wsdl/test/illinois-ECF-4.0-FilingReviewMDEService.wsdl"),
          "illinois-prod", getRes("wsdl/prod/illinois-ECF-4.0-FilingReviewMDEService.wsdl"),
          "massachusetts-stage",
              getRes("wsdl/stage/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl"),
          "massachusetts-prod",
              getRes("wsdl/prod/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl"),
          "california-stage", getRes("wsdl/stage/california-ECF-4.0-FilingReviewMDEService.wsdl"),
          "texas-stage", getRes("wsdl/stage/texas-ECF-4.0-FilingReviewMDEService.wsdl"),
          "indiana-stage", getRes("wsdl/stage/indiana-ECF-4.0-FilingReviewMDEService.wsdl"),
          "vermont-stage", getRes("wsdl/stage/vermont-ECF-4.0-FilingReviewMDEService.wsdl"));

  private static final Map<String, URL> courtRecordMDEWsdls =
      Map.of(
          "illinois-stage", getRes("wsdl/stage/illinois-ECF-4.0-CourtRecordMDEService.wsdl"),
          "illinois-test", getRes("wsdl/test/illinois-ECF-4.0-CourtRecordMDEService.wsdl"),
          "illinois-prod", getRes("wsdl/prod/illinois-ECF-4.0-CourtRecordMDEService.wsdl"),
          "massachusetts-stage",
              getRes("wsdl/stage/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl"),
          "massachusetts-prod",
              getRes("wsdl/prod/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl"),
          "california-stage", getRes("wsdl/stage/california-ECF-4.0-CourtRecordMDEService.wsdl"),
          "texas-stage", getRes("wsdl/stage/texas-ECF-4.0-CourtRecordMDEService.wsdl"),
          "indiana-stage", getRes("wsdl/stage/indiana-ECF-4.0-CourtRecordMDEService.wsdl"),
          "vermont-stage", getRes("wsdl/stage/vermont-ECF-4.0-CourtRecordMDEService.wsdl"));

  private static final Map<String, URL> courtSchedulingMDEWsdls =
      Map.of(
          "illinois-stage",
          getRes("wsdl/stage/illinois-v5-CourtSchedulingMDE.wsdl"),
          "illinois-prod",
          getRes("wsdl/prod/illinois-v5-CourtSchedulingMDE.wsdl"));

  private static URL getRes(String wsdlPath) {
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.error("Can not initialize the default wsdl from classpath: {}", wsdlPath);
      throw new RuntimeException("Can't load Bad WSDL Path: " + wsdlPath);
    }
    return url;
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, filingReviewMDEWsdls);
    return url.map(u -> new FilingReviewMDEService(u));
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(
      String jurisdiction, TylerEnv env) {
    return getFilingReviewFactory(jurisdiction + "-" + env.getName());
  }

  public static Optional<ServiceMDEService> getServiceFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, serviceMDEWsdls);
    return url.map(u -> new ServiceMDEService(u));
  }

  public static Optional<ServiceMDEService> getServiceFactory(String jurisdiction, TylerEnv env) {
    return getServiceFactory(jurisdiction + "-" + env.getName());
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, courtRecordMDEWsdls);
    return url.map(u -> new CourtRecordMDEService(u));
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(
      String jurisdiction, TylerEnv env) {
    return getCourtRecordFactory(jurisdiction + "-" + env.getName());
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, courtSchedulingMDEWsdls);
    return url.map(u -> new CourtSchedulingMDE_Service(u));
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      String jurisdiction, TylerEnv env) {
    return getCourtSchedulingFactory(jurisdiction + "-" + env.getName());
  }

  private static Optional<URL> urlFromString(String wsdlDomain, Map<String, URL> domainToWsdl) {
    if (!domainToWsdl.containsKey(wsdlDomain)) {
      return Optional.empty();
    }

    URL url = domainToWsdl.get(wsdlDomain);
    return Optional.of(url);
  }
}
