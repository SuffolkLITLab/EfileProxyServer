package edu.suffolk.litlab.efsp.server.ecf4;

import static edu.suffolk.litlab.efsp.Jurisdiction.*;
import static edu.suffolk.litlab.efsp.tyler.TylerEnv.*;

import edu.suffolk.litlab.efsp.tyler.TylerDomain;
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

  private static final Map<TylerDomain, URL> serviceMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE),
              getRes("wsdl/stage/illinois-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(ILLINOIS, PROD),
              getRes("wsdl/prod/illinois-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(MASSACHUSETTS, STAGE),
              getRes("wsdl/stage/massachusetts-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(MASSACHUSETTS, PROD),
              getRes("wsdl/prod/massachusetts-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(CALIFORNIA, STAGE),
              getRes("wsdl/stage/california-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(TEXAS, STAGE), getRes("wsdl/stage/texas-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(INDIANA, STAGE),
              getRes("wsdl/stage/indiana-ECF-4.0-ServiceMDEService.wsdl"),
          new TylerDomain(VERMONT, STAGE),
              getRes("wsdl/stage/vermont-ECF-4.0-ServiceMDEService.wsdl"));

  private static final Map<TylerDomain, URL> filingReviewMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE),
              getRes("wsdl/stage/illinois-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(ILLINOIS, PROD),
              getRes("wsdl/prod/illinois-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(MASSACHUSETTS, STAGE),
              getRes("wsdl/stage/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(MASSACHUSETTS, PROD),
              getRes("wsdl/prod/massachusetts-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(CALIFORNIA, STAGE),
              getRes("wsdl/stage/california-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(TEXAS, STAGE),
              getRes("wsdl/stage/texas-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(INDIANA, STAGE),
              getRes("wsdl/stage/indiana-ECF-4.0-FilingReviewMDEService.wsdl"),
          new TylerDomain(VERMONT, STAGE),
              getRes("wsdl/stage/vermont-ECF-4.0-FilingReviewMDEService.wsdl"));

  private static final Map<TylerDomain, URL> courtRecordMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE),
              getRes("wsdl/stage/illinois-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(ILLINOIS, PROD),
              getRes("wsdl/prod/illinois-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(MASSACHUSETTS, STAGE),
              getRes("wsdl/stage/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(MASSACHUSETTS, PROD),
              getRes("wsdl/prod/massachusetts-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(CALIFORNIA, STAGE),
              getRes("wsdl/stage/california-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(TEXAS, STAGE),
              getRes("wsdl/stage/texas-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(INDIANA, STAGE),
              getRes("wsdl/stage/indiana-ECF-4.0-CourtRecordMDEService.wsdl"),
          new TylerDomain(VERMONT, STAGE),
              getRes("wsdl/stage/vermont-ECF-4.0-CourtRecordMDEService.wsdl"));

  private static final Map<TylerDomain, URL> courtSchedulingMDEWsdls =
      Map.of(
          new TylerDomain(ILLINOIS, STAGE),
              getRes("wsdl/stage/illinois-v5-CourtSchedulingMDE.wsdl"),
          new TylerDomain(ILLINOIS, PROD), getRes("wsdl/prod/illinois-v5-CourtSchedulingMDE.wsdl"));

  private static URL getRes(String wsdlPath) {
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.error("Can not initialize the default wsdl from classpath: {}", wsdlPath);
      throw new RuntimeException("Can't load Bad WSDL Path: " + wsdlPath);
    }
    return url;
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, filingReviewMDEWsdls);
    return url.map(u -> new FilingReviewMDEService(u));
  }

  public static Optional<ServiceMDEService> getServiceFactory(TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, serviceMDEWsdls);
    return url.map(u -> new ServiceMDEService(u));
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, courtRecordMDEWsdls);
    return url.map(u -> new CourtRecordMDEService(u));
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      TylerDomain wsdlDomain) {
    Optional<URL> url = urlFrom(wsdlDomain, courtSchedulingMDEWsdls);
    return url.map(u -> new CourtSchedulingMDE_Service(u));
  }

  private static Optional<URL> urlFrom(TylerDomain wsdlDomain, Map<TylerDomain, URL> domainToWsdl) {
    if (!domainToWsdl.containsKey(wsdlDomain)) {
      return Optional.empty();
    }

    URL url = domainToWsdl.get(wsdlDomain);
    return Optional.of(url);
  }
}
