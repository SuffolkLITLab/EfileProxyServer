package edu.suffolk.litlab.efsp.server.ecf4;

import static edu.suffolk.litlab.efsp.tyler.TylerEnv.*;
import static edu.suffolk.litlab.efsp.tyler.TylerJurisdiction.*;

import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.tyler.TylerJurisdiction;
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

  static final Map<TylerDomain, String> serviceMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE), "wsdl/stage/illinois-ECF-4.0-ServiceMDEService.wsdl",
          new TylerDomain(ILLINOIS, PROD), "wsdl/prod/illinois-ECF-4.0-ServiceMDEService.wsdl",
          new TylerDomain(MASSACHUSETTS, STAGE),
              "wsdl/stage/massachusetts-ECF-4.0-ServiceMDEService.wsdl",
          new TylerDomain(MASSACHUSETTS, PROD),
              "wsdl/prod/massachusetts-ECF-4.0-ServiceMDEService.wsdl",
          new TylerDomain(CALIFORNIA, STAGE),
              "wsdl/stage/california-ECF-4.0-ServiceMDEService.wsdl",
          new TylerDomain(TEXAS, STAGE), "wsdl/stage/texas-ECF-4.0-ServiceMDEService.wsdl",
          new TylerDomain(INDIANA, STAGE), "wsdl/stage/indiana-ECF-4.0-ServiceMDEService.wsdl");

  static final Map<TylerDomain, String> filingReviewMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE),
              "wsdl/stage/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          new TylerDomain(ILLINOIS, PROD), "wsdl/prod/illinois-ECF-4.0-FilingReviewMDEService.wsdl",
          new TylerDomain(MASSACHUSETTS, STAGE),
              "wsdl/stage/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl",
          new TylerDomain(MASSACHUSETTS, PROD),
              "wsdl/prod/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl",
          new TylerDomain(CALIFORNIA, STAGE),
              "wsdl/stage/california-ECF-4.0-FilingReviewMDEService.wsdl",
          new TylerDomain(TEXAS, STAGE), "wsdl/stage/texas-ECF-4.0-FilingReviewMDEService.wsdl",
          new TylerDomain(INDIANA, STAGE),
              "wsdl/stage/indiana-ECF-4.0-FilingReviewMDEService.wsdl");

  static final Map<TylerDomain, String> courtRecordMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE),
              "wsdl/stage/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          new TylerDomain(ILLINOIS, PROD), "wsdl/prod/illinois-ECF-4.0-CourtRecordMDEService.wsdl",
          new TylerDomain(MASSACHUSETTS, STAGE),
              "wsdl/stage/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl",
          new TylerDomain(MASSACHUSETTS, PROD),
              "wsdl/prod/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl",
          new TylerDomain(CALIFORNIA, STAGE),
              "wsdl/stage/california-ECF-4.0-CourtRecordMDEService.wsdl",
          new TylerDomain(TEXAS, STAGE), "wsdl/stage/texas-ECF-4.0-CourtRecordMDEService.wsdl",
          new TylerDomain(INDIANA, STAGE), "wsdl/stage/indiana-ECF-4.0-CourtRecordMDEService.wsdl");

  static final Map<TylerDomain, String> courtSchedulingMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE), "wsdl/stage/illinois-v5-CourtSchedulingMDE.wsdl",
          new TylerDomain(ILLINOIS, PROD), "wsdl/prod/illinois-v5-CourtSchedulingMDE.wsdl");

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, filingReviewMDEWsdls);
    return url.map(u -> new FilingReviewMDEService(u));
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(
      TylerJurisdiction jurisdiction, TylerEnv env) {
    return getFilingReviewFactory(jurisdiction, env);
  }

  public static Optional<ServiceMDEService> getServiceFactory(TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, serviceMDEWsdls);
    return url.map(u -> new ServiceMDEService(u));
  }

  public static Optional<ServiceMDEService> getServiceFactory(
      TylerJurisdiction jurisdiction, TylerEnv env) {
    return getServiceFactory(jurisdiction, env);
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, courtRecordMDEWsdls);
    return url.map(u -> new CourtRecordMDEService(u));
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(
      TylerJurisdiction jurisdiction, TylerEnv env) {
    return getCourtRecordFactory(jurisdiction, env);
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, courtSchedulingMDEWsdls);
    return url.map(u -> new CourtSchedulingMDE_Service(u));
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      TylerJurisdiction jurisdiction, TylerEnv env) {
    return getCourtSchedulingFactory(jurisdiction, env);
  }

  private static Optional<URL> urlFrom(
      TylerDomain wsdlDomain, Map<TylerDomain, String> domainToWsdl) {
    if (!domainToWsdl.containsKey(wsdlDomain)) {
      return Optional.empty();
    }

    String wsdlPath = domainToWsdl.get(wsdlDomain);
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    // TODO(bryce): do this at start up, not in a random call.
    if (url == null) {
      log.info("Can not initialize the default wsdl from {}", "classpath:" + wsdlPath);
      return Optional.empty();
    }

    return Optional.of(url);
  }
}
