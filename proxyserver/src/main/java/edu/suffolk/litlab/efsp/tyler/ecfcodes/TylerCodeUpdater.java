package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseAPI;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUpdater;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUpdater.CourtCodelistInfo;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUrlGetter;
import edu.suffolk.litlab.efsp.server.auth.UserNamePassword;
import edu.suffolk.litlab.efsp.server.ecf4.TylerEcf4Helper;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import edu.suffolk.litlab.efsp.server.utils.HeaderSigner;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.SoapX509CallbackHandler;
import edu.suffolk.litlab.efsp.tyler.Ecf4Helper;
import edu.suffolk.litlab.efsp.tyler.SoapClientChooser;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.soap.SOAPFaultException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType;

public class TylerCodeUpdater {

  private static final Logger log = LoggerFactory.getLogger(TylerCodeUpdater.class);

  /** Sets up the WSDL connection to Tyler, used for `getPolicy` to get the URL. */
  private static FilingReviewMDEPort loginWithTyler(
      Jurisdiction jurisdiction, String userEmail, String userPassword) {
    Optional<TylerUserFactory> userFactory = TylerClients.getEfmUserFactory(jurisdiction);
    if (userFactory.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " in Soap chooser for EFMUser");
    }
    log.info("Getting filing factory for {}", jurisdiction);
    Optional<FilingReviewMDEService> filingFactory =
        SoapClientChooser.getFilingReviewFactory(jurisdiction);
    if (filingFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in Soap Chooser for filing review factory");
    }
    TylerUserClient userPort = userFactory.get().makeUserClient(ServiceHelpers::setupServicePort);
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail(userEmail);
    authReq.setPassword(userPassword);
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    List<Header> headersList = UserNamePassword.makeHeaderList(authRes);
    FilingReviewMDEPort filingPort = filingFactory.get().getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) filingPort);
    Map<String, Object> ctx = ((BindingProvider) filingPort).getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    return filingPort;
  }

  private static String makeUrl(String endpoint, String tableName, String location) {
    return endpoint + "CodeService/codes/" + tableName + "/" + location.replace(" ", "%20");
  }

  public static boolean executeCommand(
      Supplier<CodeDatabaseAPI> cdSupplier,
      Jurisdiction jurisdiction,
      List<String> args,
      String x509Password) {
    SoapX509CallbackHandler.setX509Password(x509Password);
    String command = args.get(0);
    CodeUrlGetter urlGetter =
        new TylerCodeUrlGetter(new HeaderSigner(System.getenv("PATH_TO_KEYSTORE"), x509Password));
    CodeUpdater cu = new CodeUpdater();
    // DownloadIndiv doesn't connect to the database, just signs the req for the zip
    if (command.equalsIgnoreCase("downloadIndiv")) {
      String endpoint = TylerClients.getTylerServerRootUrl(jurisdiction);
      try {
        return cu.downloadIndiv(args, (table, loc) -> makeUrl(endpoint, table, loc), urlGetter);
      } catch (URISyntaxException e) {
        log.error("Exception when doing code updating! ", e);
        return false;
      }
    }

    try (CodeDatabaseAPI cd = cdSupplier.get()) {
      String codesSite = TylerClients.getTylerServerRootUrl(jurisdiction);

      FilingReviewMDEPort filingPort =
          loginWithTyler(
              jurisdiction,
              System.getenv("TYLER_USER_EMAIL"),
              System.getenv("TYLER_USER_PASSWORD"));
      Function<String, List<CourtCodelistInfo>> codelistGetter =
          (location) -> {
            var m = TylerEcf4Helper.prep(new CourtPolicyQueryMessageType(), location);
            try {
              CourtPolicyResponseMessageType p = filingPort.getPolicy(m);
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
                  "Got a SOAP excption getting policy for {} in {}: ", location, jurisdiction, ex);
              return List.of();
            }
          };
      var systemUrls =
          cd.systemTables().stream()
              .collect(Collectors.toMap((t) -> t, (t) -> makeUrl(codesSite, t, "")));

      HeaderSigner signer = new HeaderSigner(System.getenv("PATH_TO_KEYSTORE"), x509Password);
      var codeUrlGetter = new TylerCodeUrlGetter(signer);
      if (command.equalsIgnoreCase("replaceall")) {
        return cu.replaceAll(systemUrls, codelistGetter, codeUrlGetter, cd);
      } else if (command.equalsIgnoreCase("replacesome")) {
        return cu.replaceSome(
            systemUrls, codelistGetter, codeUrlGetter, cd, args.subList(1, args.size()));
      } else if (command.equalsIgnoreCase("refresh")) {
        return cu.updateAll(systemUrls, codelistGetter, codeUrlGetter, cd);
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
   * java -cp efspserver-with-deps.jar edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeUpdater refresh
   * </pre>
   *
   * <p>TODO(#111): use with this System property and class to try to fix parallel unmarshalling
   * -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efsp.server.JAXBForkJoinWorkerThreadFactory
   * \ https://stackoverflow.com/a/57551188/11416267
   */
  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      log.error("Need to pass in a subprogram: downloadIndiv, or refresh");
      System.exit(1);
    }

    List<Jurisdiction> jurisdictions =
        Stream.of(System.getenv("TYLER_JURISDICTIONS").split(" "))
            .map(Jurisdiction::parse)
            .toList();
    for (var jurisdiction : jurisdictions) {
      MDC.put(MDCWrappers.USER_ID, jurisdiction.getName());
      // Reusing USER for Jurisdiction, SESSION for the court / location, and REQUEST for the table
      // name.
      executeCommand(
          () -> CodeUpdater.makeCodeDatabase((ds) -> CodeDatabase.fromDS(jurisdiction, ds)),
          jurisdiction,
          List.of(args),
          System.getenv("X509_PASSWORD"));
    }
  }
}
