package edu.suffolk.litlab.efsp.tyler;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;
import java.net.URL;
import java.util.Optional;
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

  public static Optional<FilingReviewMDEService> getFilingReviewFactory(TylerDomain domain) {
    var version = TylerClients.getVersion(domain);
    return version.map(v -> new FilingReviewMDEService(getRes(domain, v, REVIEW_SUFFIX)));
  }

  public static Optional<ServiceMDEService> getServiceFactory(TylerDomain domain) {
    var version = TylerClients.getVersion(domain);
    return version.map(v -> new ServiceMDEService(getRes(domain, v, SERVICE_SUFFIX)));
  }

  public static Optional<CourtRecordMDEService> getCourtRecordFactory(TylerDomain domain) {
    var version = TylerClients.getVersion(domain);
    return version.map(v -> new CourtRecordMDEService(getRes(domain, v, RECORD_SUFFIX)));
  }

  public static Optional<CourtSchedulingMDE_Service> getCourtSchedulingFactory(TylerDomain domain) {
    var version = TylerClients.getVersion(domain);
    return version.map(v -> new CourtSchedulingMDE_Service(getRes(domain, v, SCHEDULE_SUFFIX)));
  }
}
