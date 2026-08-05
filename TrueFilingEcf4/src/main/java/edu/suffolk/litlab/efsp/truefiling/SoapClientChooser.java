package edu.suffolk.litlab.efsp.truefiling;

import edu.suffolk.litlab.efsp.ConfigurationLoader;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ServerEnv;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import imagesoft.ecf.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import imagesoft.ecf.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import jakarta.xml.ws.BindingProvider;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The TrueFiling version of the Tyler class */
public class SoapClientChooser {

  private static final Logger log = LoggerFactory.getLogger(SoapClientChooser.class);

  private static final String REVIEW_SUFFIX = "-ECF-4.0-FilingReviewMDEService.wsdl";
  private static final String RECORD_SUFFIX = "-ECF-4.0-CourtRecordMDEService.wsdl";

  private static Optional<Boolean> shouldLogRequests;

  private static URL getRes(TrueFilingDomain domain, String suffix) {
    String wsdlPath =
        "wsdl/WebServices"
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

  public static final TrueFilingEnv getTrueFilingEnv() {
    return TrueFilingEnv.from(ServerEnv.fromEnvVar());
  }

  public static boolean shouldLogRequests() {
    if (shouldLogRequests.isEmpty()) {
      shouldLogRequests = Optional.of(ConfigurationLoader.shouldLogRequests());
    }
    return shouldLogRequests.orElse(false);
  }

  public static FilingReviewMDEService getFilingReviewFactory(Jurisdiction jurisdiction) {
    var domain = new TrueFilingDomain(jurisdiction, getTrueFilingEnv());
    URL url = getRes(domain, REVIEW_SUFFIX);
    if (shouldLogRequests()) {
      LoggingFeature loggingFeature = new LoggingFeature();
      loggingFeature.setPrettyLogging(true);
      return new FilingReviewMDEService(url, loggingFeature);
    }
    return new FilingReviewMDEService(url);
  }

  public static CourtRecordMDEService getCourtRecordFactory(Jurisdiction jurisdiction) {
    var domain = new TrueFilingDomain(jurisdiction, getTrueFilingEnv());
    URL url = getRes(domain, RECORD_SUFFIX);
    if (shouldLogRequests()) {
      LoggingFeature loggingFeature = new LoggingFeature();
      loggingFeature.setPrettyLogging(true);
      return new CourtRecordMDEService(url, loggingFeature);
    }
    return new CourtRecordMDEService(url);
  }

  /** Should be called on the "Port" objects made from the services. */
  public static void setupServicePort(BindingProvider bp) {
    Map<String, Object> ctx = bp.getRequestContext();
    var integratorId = StdLib.GetEnv("TRUEFILING_INTEGRATOR_ID");
    if (integratorId.isPresent()) {
      ctx.put(Message.PROTOCOL_HEADERS, Map.of("IntegratorId", integratorId.get()));
    } else {
      log.error("True filing integrator id not an environment var, calls will fail");
      ctx.put(Message.PROTOCOL_HEADERS, Map.of("IntegratorId", List.of()));
    }
    ctx.put("set-jaxb-validation-event-handler", "false");
  }
}
