package edu.suffolk.litlab.efsp.ecf5;

import java.net.URL;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecf5.CourtPolicyMDEService;
import ecf5.CourtRecordMDEService;
import ecf5.CourtSchedulingMDEService;
import ecf5.FilingReviewMDEService;
import ecf5.ServiceMDEService;
import ecf5.TylerCourtRecordMDEService;
import ecf5.TylerCourtSchedulingMDEService;
import ecf5.TylerFilingAssemblyMDEService;
import ecf5.TylerFilingReviewMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;

public class SoapClientChooserV5 {
    private static final Logger log = LoggerFactory.getLogger(SoapClientChooserV5.class);

    private static final String COURT_POLICY_WSDL = "-ECF5-CourtPolicyMDEService.wsdl";
    private static final String COURT_RECORD_WSDL = "-ECF5-CourtRecordMDEService.wsdl";
    private static final String COURT_SCHED_WSDL = "-ECF5-CourtSchedulingMDEService.wsdl";
    private static final String FILING_REVIEW_WSDL = "-ECF5-FilingReviewMDEService.wsdl";
    private static final String SERVICE_WSDL = "-ECF5-ServiceMDEService.wsdl";
    private static final String TYLER_COURT_RECORD_WSDL = "-ECF5-TylerCourtRecordMDEService.wsdl";
    private static final String TYLER_COURT_SCHED_WSDL = "-ECF5-TylerCourtSchedulingMDEService.wsdl";
    private static final String TYLER_FILING_ASSEM_WSDL = "-ECF5-TylerFilingAssemblyMDEService.wsdl";
    private static final String TYLER_FILING_REVIEW_WSDL = "-ECF5-TylerFilingReviewMDEService.wsdl";

    public static Optional<Function<Consumer<BindingProvider>, CourtPolicyClient>> getCourtPolicyFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, COURT_POLICY_WSDL);
          return url.map(u -> (consume) -> new CourtPolicyClient(new CourtPolicyMDEService(u), v, consume));
        }
      );
    }

    public static Optional<Function<Consumer<BindingProvider>, CourtRecordClient>> getCourtRecordFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, COURT_RECORD_WSDL);
          return url.map(u -> (consume) -> new CourtRecordClient(new CourtRecordMDEService(u), v, consume));
        }
      );

    }

    public static Optional<Function<Consumer<BindingProvider>, CourtSchedulingClient>> getCourtSchedulingFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, COURT_SCHED_WSDL);
          return url.map(u -> (consume) -> new CourtSchedulingClient(new CourtSchedulingMDEService(u), v, consume));
        }
      );

    }

    public static Optional<Function<Consumer<BindingProvider>, FilingReviewClient>> getFilingReviewClientFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, FILING_REVIEW_WSDL);
          return url.map(u -> (consume) -> new FilingReviewClient(new FilingReviewMDEService(u), v, consume));
        }
      );

    }

    public static Optional<Function<Consumer<BindingProvider>, ServiceClient>> getServiceFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, SERVICE_WSDL);
          return url.map(u -> (consume) -> new ServiceClient(new ServiceMDEService(u), v, consume));
        }
      );

    }

    public static Optional<Function<Consumer<BindingProvider>, TylerCourtRecordClient>> getTylerCourtRecordFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, TYLER_COURT_RECORD_WSDL);
          return url.map(u -> (consume) -> new TylerCourtRecordClient(new TylerCourtRecordMDEService(u), v, consume));
        }
      );
    }

    public static Optional<Function<Consumer<BindingProvider>, TylerCourtSchedulingClient>> getTylerCourtSchedulingFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, TYLER_COURT_SCHED_WSDL);
          return url.map(u -> (consume) -> new TylerCourtSchedulingClient(new TylerCourtSchedulingMDEService(u), v, consume));
        }
      );

    }
    
    public static Optional<Function<Consumer<BindingProvider>, TylerFilingAssemblyClient>> getTylerFilingAssemblyFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, TYLER_FILING_ASSEM_WSDL);
          return url.map(u -> (consume) -> new TylerFilingAssemblyClient(new TylerFilingAssemblyMDEService(u), v, consume));
        }
      );

    }

    public static Optional<Function<Consumer<BindingProvider>, TylerFilingReviewClient>> getTylerFilingReviewFactory(TylerDomain domain) {
      var version = TylerClients.getVersion(domain);
      return version.flatMap(
        v -> {
          var url = createLocalWsdlUrl(domain, v, TYLER_FILING_REVIEW_WSDL);
          return url.map(u -> (consume) -> new TylerFilingReviewClient(new TylerFilingReviewMDEService(u), v, consume));
        }
      );

    }

    private static Optional<URL> createLocalWsdlUrl(
        TylerDomain domain, TylerVersion version, String suffix) {
      String wsdlPath = "wsdl/" + version.getVersionPath() + "/" + domain.env().getName() + "/" + domain.jurisdiction().getName() + suffix;
      URL url = SoapClientChooserV5.class.getClassLoader().getResource(wsdlPath);
      if (url == null) {
        log.warn("Could not find the v5 wsdl at the class path: {}", wsdlPath);
        return Optional.empty();
      }
      return Optional.of(url);
    }
}
