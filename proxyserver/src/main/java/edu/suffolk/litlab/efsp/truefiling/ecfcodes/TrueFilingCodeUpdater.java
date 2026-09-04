package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseAPI;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUpdater;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUpdater.CourtCodelistInfo;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUrlGetter;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import edu.suffolk.litlab.efsp.truefiling.SoapClientChooser;
import imagesoft.ecf.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.soap.SOAPFaultException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class TrueFilingCodeUpdater {

  public static final Logger log = LoggerFactory.getLogger(TrueFilingCodeUpdater.class);

  public static boolean executeCommand(
      Supplier<CodeDatabaseAPI> cdSupplier, Jurisdiction jurisdiction, List<String> args) {
    String command = args.get(0);
    CodeUpdater cu = new CodeUpdater();
    CodeUrlGetter urlGetter = new TFCodeUrlGetter();

    Map<String, String> courtUrls = Map.of();

    // DownloadIndiv doesn't connect to the database, just signs the req for the zip
    if (command.equalsIgnoreCase("downloadIndiv")) {
      try {
        return cu.downloadIndiv(args, (table, loc) -> courtUrls.get(table), urlGetter);
      } catch (URISyntaxException e) {
        log.error("Exception when doing code updating! ", e);
        return false;
      }
    }
    FilingReviewMDEService service = SoapClientChooser.getFilingReviewFactory(jurisdiction);
    Function<String, List<CourtCodelistInfo>> codelistGetter =
        (location) -> {
          var m =
              Ecf4Helper.prep(
                  new CourtPolicyQueryMessageType(),
                  location,
                  "https://efile-test.suffolklitlab.org");
          var port = service.getFilingReviewMDEPort();
          SoapClientChooser.setupServicePort((BindingProvider) port);
          try {
            CourtPolicyResponseMessageType p = port.getPolicy(m);
            var the_stream = p.getRuntimePolicyParameters().getCourtCodelist().stream();
            Function<CourtCodelistType, CourtCodelistInfo> ahh =
                (cc1) -> {
                  return new CourtCodelistInfo(
                      cc1.getECFElementName().getValue(),
                      cc1.getCourtCodelistURI().getIdentificationID().getValue(),
                      Ecf4Helper.parseDate(cc1.getEffectiveDate()));
                };
            List<CourtCodelistInfo> the_list = the_stream.map(ahh).toList();
            return the_list;
          } catch (SOAPFaultException ex) {
            log.warn(
                "Got a SOAP excption getting policy for {} in {}: ",
                location,
                Jurisdiction.ALASKA,
                ex);
            return List.of();
          }
        };

    try (CodeDatabaseAPI cd = cdSupplier.get()) {
      if (command.equalsIgnoreCase("replaceall")) {
        return cu.replaceAll(courtUrls, codelistGetter, urlGetter, cd);
      } else if (command.equalsIgnoreCase("replacesome")) {
        return cu.replaceSome(
            courtUrls, codelistGetter, urlGetter, cd, args.subList(1, args.size()));
      } else {
        log.error("Command {} isn't a real command", command);
        return false;
      }
    } catch (SQLException | IOException | JAXBException | URISyntaxException e) {
      log.error("Exception when doing code updating! ", e);
      return false;
    }
  }

  /**
   * Run with:
   *
   * <pre>
   * java -cp efspserver-with-deps.jar edu.suffolk.litlab.efsp.truefiling.ecfcodes.CodeUpdater refresh
   * </pre>
   */
  public static void main(String[] args) throws Exception {
    MDC.put(MDCWrappers.USER_ID, Jurisdiction.ALASKA.getName());
    if (args.length < 1) {
      log.error("Need to pass in a subprogram: downloadIndiv, or refresh");
      System.exit(1);
    }

    // Reusing USER for Jurisdiction, SESSION for the court / location, and REQUEST for the table
    // name.
    executeCommand(
        () -> CodeUpdater.makeCodeDatabase((ds) -> TFCodeDatabase.fromDS(Jurisdiction.ALASKA, ds)),
        Jurisdiction.ALASKA,
        List.of(args));
  }
}
