package edu.suffolk.litlab.efsp.tyler;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;
import edu.suffolk.litlab.efsp.ConfigurationLoader;
import edu.suffolk.litlab.efsp.Jurisdiction;
import jakarta.xml.ws.WebServiceFeature;
import java.net.URL;
import java.util.Optional;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles working in multiple Tyler Jurisdictions. Needs to have all of the WSDL files hardcoded
 * here, and present in the src/main/resources folder.
 */
public class SoapClientChooser {

  private static final Logger log = LoggerFactory.getLogger(SoapClientChooser.class);

  private static final String SERVICE_SUFFIX = "-ECF-4.0-ServiceMDEService.wsdl";
  private static final String REVIEW_SUFFIX = "-ECF-4.0-FilingReviewMDEService.wsdl";
  private static final String RECORD_SUFFIX = "-ECF-4.0-CourtRecordMDEService.wsdl";
  private static final String SCHEDULE_SUFFIX = "-v5-CourtSchedulingMDE.wsdl";

  private static Optional<Boolean> shouldLogRequests = Optional.empty();

  public static boolean shouldLogRequests() {
    if (shouldLogRequests.isEmpty()) {
      shouldLogRequests = Optional.of(ConfigurationLoader.shouldLogRequests());
    }
    return shouldLogRequests.orElse(false);
  }

  public static WebServiceFeature getLoggingFeature() {
    LoggingFeature loggingFeature = new LoggingFeature();
    loggingFeature.setPrettyLogging(true);
    return loggingFeature;
  }

  private static URL getRes(TylerDomain domain, TylerVersion version, String suffix) {
    String wsdlPath =
        "wsdl/"
            + version.getVersionPath()
            + "/"
            + domain.env().getName()
            + "/"
            + domain.jurisdiction().getName()
            + suffix;
    URL url = SoapClientChooser.class.getClassLoader().getResource(wsdlPath);
    if (url == null) {
      log.error("Can not initialize the default wsdl from pclass path: {}", wsdlPath);
      throw new RuntimeException("Can't load Bad WSDL Path: " + wsdlPath);
    }
    return url;
  }

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(Jurisdiction jurisdiction) {
    var version = TylerClients.getVersion(jurisdiction);
    var domain = new TylerDomain(jurisdiction, TylerClients.getTylerEnv());
    return version.map(
        v -> {
          boolean shouldLog = shouldLogRequests();
          URL url = getRes(domain, v, REVIEW_SUFFIX);
          if (shouldLog) {
            return new FilingReviewMDEService(url, getLoggingFeature());
          } else {
            return new FilingReviewMDEService(url);
          }
        });
  }

  public static Optional<ServiceMDEService> getServiceFactory(Jurisdiction jurisdiction) {
    var version = TylerClients.getVersion(jurisdiction);
    var domain = new TylerDomain(jurisdiction, TylerClients.getTylerEnv());

    return version.map(
        v -> {
          boolean shouldLog = shouldLogRequests();
          URL url = getRes(domain, v, SERVICE_SUFFIX);
          if (shouldLog) {
            return new ServiceMDEService(url, getLoggingFeature());
          } else {
            return new ServiceMDEService(url);
          }
        });
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(Jurisdiction jurisdiction) {
    var version = TylerClients.getVersion(jurisdiction);
    var domain = new TylerDomain(jurisdiction, TylerClients.getTylerEnv());
    return version.map(
        v -> {
          boolean shouldLog = shouldLogRequests();
          URL url = getRes(domain, v, RECORD_SUFFIX);
          if (shouldLog) {
            return new CourtRecordMDEService(url, getLoggingFeature());
          } else {
            return new CourtRecordMDEService(url);
          }
        });
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(
      Jurisdiction jurisdiction) {
    if (jurisdiction.getApi() != Jurisdiction.Api.ECF_4_Schedule) {
      return Optional.empty();
    }
    var version = TylerClients.getVersion(jurisdiction);
    var domain = new TylerDomain(jurisdiction, TylerClients.getTylerEnv());
    return version.map(
        v -> {
          boolean shouldLog = shouldLogRequests();
          URL url = getRes(domain, v, SCHEDULE_SUFFIX);
          if (shouldLog) {
            return new CourtSchedulingMDE_Service(url, getLoggingFeature());
          } else {
            return new CourtSchedulingMDE_Service(url);
          }
        });
  }
}
