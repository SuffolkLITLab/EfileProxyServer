package edu.suffolk.litlab.efspserver.ecf5;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.servicemde.ServiceMDEService;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.v5_0.extensions.tylercourtrecordmde.TylerCourtRecordMDEService;
import tyler.ecf.v5_0.extensions.tylerfilingreviewmde.TylerFilingReviewMDEService;

/**
 * Handles working in multiple Tyler Jurisdictions. Needs to have all of the WSDL files hardcoded
 * here, and present in the src/main/resources folder.
 */
public class SoapClientChooser {

  private static final Logger log = LoggerFactory.getLogger(SoapClientChooser.class);

  static final Map<String, String> serviceMDEWsdls =
      Map.of("illinois-stage", "wsdl/stage/illinois-ecf5-ServiceMDEService.wsdl");

  static final Map<String, String> filingReviewMDEWsdls =
      Map.of("illinois-stage", "wsdl/stage/illinois-ecf5-FilingReviewMDEService.wsdl");

  static final Map<String, String> tylerFilingReviewMDEWsdls =
      Map.of("illinois-stage", "wsdl/stage/illinois-ecf5-TylerFilingReviewMDEService.wsdl");

  static final Map<String, String> courtRecordMDEWsdls =
      Map.of("illinois-stage", "wsdl/stage/illinois-ecf5-CourtRecordMDEService.wsdl");

  static final Map<String, String> tylerCourtRecordMDEWsdls =
      Map.of("illinois-stage", "wsdl/stage/illinois-ecf5-TylerCourtRecordMDEService.wsdl");

  static final Map<String, String> courtSchedulingMDEWsdls =
      Map.of(
          "illinois-stage", "wsdl/stage/illinois-v5-CourtSchedulingMDE.wsdl",
          "illinois-test", "wsdl/test/illinois-v5-CourtSchedulingMDE.wsdl",
          "illinois-prod", "wsdl/prod/illinois-v5-CourtSchedulingMDE.wsdl");

  static final Map<String, String> courtPolicyMDEWsdls =
      Map.of("illinois-stage", "wsdl/stage/illinois-ecf5-CourtPolicyMDEService.wsdl");

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

  public static Optional<TylerCourtRecordMDEService> getTylerCourtRecordFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, tylerCourtRecordMDEWsdls);
    return url.map(u -> new TylerCourtRecordMDEService(u));
  }

  public static Optional<TylerCourtRecordMDEService> getTylerCourtRecordFactory(
      String jurisdiction, String env) {
    return getTylerCourtRecordFactory(jurisdiction + "-" + env);
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, courtSchedulingMDEWsdls);
    return url.map(u -> new CourtSchedulingMDE_Service(u));
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      String jurisdiction, String env) {
    return getCourtSchedulingFactory(jurisdiction + "-" + env);
  }

  public static Optional<CourtPolicyMDEService> getCourtPolicyFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, courtPolicyMDEWsdls);
    return url.map(u -> new CourtPolicyMDEService(u));
  }

  public static Optional<CourtPolicyMDEService> getCourtPolicyFactory(
      String jurisdiction, String env) {
    return getCourtPolicyFactory(jurisdiction + "-" + env);
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(
      String jurisdiction, String env) {
    return getFilingReviewFactory(jurisdiction + "-" + env);
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, filingReviewMDEWsdls);
    return url.map(u -> new FilingReviewMDEService(u));
  }

  public static Optional<TylerFilingReviewMDEService> getTylerFilingReviewFactory(
      String jurisdiction, String env) {
    return getTylerFilingReviewFactory(jurisdiction + "-" + env);
  }

  public static Optional<TylerFilingReviewMDEService> getTylerFilingReviewFactory(
      String wsdlDomain) {
    Optional<URL> url = urlFromString(wsdlDomain, tylerFilingReviewMDEWsdls);
    return url.map(u -> new TylerFilingReviewMDEService(u));
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
