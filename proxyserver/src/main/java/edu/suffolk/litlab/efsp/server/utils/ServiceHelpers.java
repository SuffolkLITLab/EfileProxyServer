package edu.suffolk.litlab.efsp.server.utils;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.GetEnv;

import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.server.auth.TylerLogin;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.BindingProvider;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class ServiceHelpers {
  private static Logger log = LoggerFactory.getLogger(ServiceHelpers.class);

  /**
   * One of the ways that you can communicate over ECF. For more information, see
   * https://docs.oasis-open.org/legalxml-courtfiling/specs/ecf/v4.01/ecf-v4.01-spec/errata02/os/ecf-v4.01-spec-errata02-os-complete.html#_Toc425241629
   */
  public static final String MDE_PROFILE_CODE =
      "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-2.0";

  public static final String MDE_PROFILE_CODE_5 =
      "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-5.0";

  public static String ASSEMBLY_PORT = "/filingassembly/callbacks/FilingAssemblyMDEPort";
  public static String ASSEMBLY_PORT_V5 = "/filingassembly/callbacks/FilingAssemblyMDEPortEcfv5";
  private static String EXTERNAL_DOMAIN = GetEnv("EXTERNAL_DOMAIN").orElse("filingassemblymde.com");
  public static final String BASE_LOCAL_URL;
  public static final String BASE_ACME_URL;
  public static final String EXTERNAL_URL;
  public static final String SERVICE_URL;
  public static final String REST_CALLBACK_URL;

  static {
    Optional<String> certPassword = GetEnv("CERT_PASSWORD");
    File CERT_KEY_STORE = new File("src/main/config/tls_server_cert.jks");

    // The 9000 is hard coded (we'll always be running on 9000 inside the docker
    // container,
    // but might be mapped to other things outside of it)
    if (EXTERNAL_DOMAIN.startsWith("http://")) {
      EXTERNAL_DOMAIN = EXTERNAL_DOMAIN.substring(7);
    }
    if (EXTERNAL_DOMAIN.startsWith("https://")) {
      EXTERNAL_DOMAIN = EXTERNAL_DOMAIN.substring(8);
    }
    if (certPassword.isPresent() && CERT_KEY_STORE.isFile()) {
      EXTERNAL_URL = "https://" + EXTERNAL_DOMAIN;
      BASE_LOCAL_URL = "https://0.0.0.0:9000";
      BASE_ACME_URL = "http://0.0.0.0:9009";
    } else {
      EXTERNAL_URL = "http://" + EXTERNAL_DOMAIN;
      BASE_LOCAL_URL = "http://0.0.0.0:9009";
      BASE_ACME_URL = "";
    }

    SERVICE_URL = EXTERNAL_URL + ASSEMBLY_PORT;
    REST_CALLBACK_URL = EXTERNAL_URL + "/filingreview/jurisdictions/%s/courts/%s/filing/status";
  }

  public static Optional<TylerUserNamePassword> userCredsFromAuthorization(
      String userColonPassword) {
    if (userColonPassword == null) {
      return Optional.empty();
    }
    if (!userColonPassword.contains(":")) {
      return Optional.empty();
    }
    String email = userColonPassword.split(":")[0];
    String password = userColonPassword.split(":")[1];
    return Optional.of(new TylerUserNamePassword(email, password));
  }

  /**
   * Sets up a connection to Tyler's SOAP API WITHOUT any Auth headers, but does handle the X.509
   * certificate and signing parameters.
   *
   * <p>Can be used to make an Auth request, or can have the header inserted later.
   */
  public static void setupServicePort(BindingProvider bp) {
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", SoapX509CallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
  }

  public static void setupServicePort(BindingProvider bp, TylerUserNamePassword creds) {
    setupServicePort(bp, List.of(creds.toHeader()));
  }

  public static void setupServicePort(BindingProvider bp, List<Header> headerList) {
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put(Header.HEADER_LIST, headerList);
    setupServicePort(bp);
  }

  /**
   * Helper for getting all of the valid courts that can be passed to a particular endpoint,
   *
   * @param cd
   * @param fileableOnly
   * @param withNames
   * @return
   */
  public static Response.ResponseBuilder getCourts(
      CodeDatabase cd, boolean fileableOnly, boolean withNames) {
    if (fileableOnly) {
      // 0 and 1 are special "system" courts that have defaults for all courts.
      // They aren't available for filing, so filter out of either query here
      if (withNames) {
        return Response.ok(
            cd.getFileableLocationNames().stream()
                .filter(c -> !c.getCode().equals("0") && !c.getCode().equals("1"))
                .sorted()
                .collect(Collectors.toList()));
      } else {
        return Response.ok(
            cd.getFileableLocations().stream()
                .filter(c -> !c.equals("0") && !c.equals("1"))
                .sorted()
                .collect(Collectors.toList()));
      }
    } else {
      if (withNames) {
        return Response.ok(cd.getLocationNames());
      } else {
        return Response.ok(cd.getAllLocations());
      }
    }
  }

  public static Optional<TylerFirmClient> setupFirmPort(
      TylerFirmFactory firmFactory,
      HttpHeaders httpHeaders,
      Supplier<LoginDatabase> ldSupplier,
      String jurisdiction) {
    return setupFirmPort(firmFactory, httpHeaders, ldSupplier, true, jurisdiction);
  }

  // TODO(bryce): should this take not a firm service but a normal port?
  public static Optional<TylerFirmClient> setupFirmPort(
      TylerFirmFactory firmFactory,
      HttpHeaders httpHeaders,
      Supplier<LoginDatabase> ldSupplier,
      boolean needsSoapHeader,
      String jurisdiction) {
    String activeToken = httpHeaders.getHeaderString("X-API-KEY");
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(activeToken);
      if (atRest.isEmpty()) {
        log.warn("Couldn't find server api key");
        return Optional.empty();
      }
      if (needsSoapHeader) {
        String tylerToken =
            httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
        MDC.put(MDCWrappers.USER_ID, ld.makeHash(tylerToken));
        return setupFirmPort(firmFactory, tylerToken);
      } else {
        return Optional.of(firmFactory.makeFirmClient(ServiceHelpers::setupServicePort));
      }
    } catch (SQLException ex) {
      log.error("SQL Error with firm port: ", ex);
      return Optional.empty();
    }
  }

  public static Optional<TylerFirmClient> setupFirmPort(
      TylerFirmFactory firmFactory, String tylerToken) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from {}?", tylerToken);
      return Optional.empty();
    }

    return Optional.of(
        firmFactory.makeFirmClient((port) -> ServiceHelpers.setupServicePort(port, creds.get())));
  }
}
