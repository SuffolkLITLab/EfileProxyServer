package edu.suffolk.litlab.efspserver.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SoapX509CallbackHandler;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import gov.niem.niem.niem_core._2.EntityType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.baseresponse.BaseResponseType;

public class ServiceHelpers {
  private static Logger log = LoggerFactory.getLogger(
      ServiceHelpers.class);

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
  public static String BASE_LOCAL_URL;
  public static final String EXTERNAL_URL = GetEnv("EXTERNAL_URL").orElse("filingassemblymde.com:9000");
  public static final String SERVICE_URL = EXTERNAL_URL + ASSEMBLY_PORT;
  public static final String REST_CALLBACK_URL = EXTERNAL_URL + "/filingreview/jurisdictions/%s/courts/%s/filing/status"; 
  static Map<String, Integer> tylerToHttp = new HashMap<>();
  static {
    Optional<String> certPassword = GetEnv("CERT_PASSWORD");
    // The 9000 is hard coded (we'll always be running on 9000 inside the docker container,
    // but might be mapped to other things outside of it)
    if (certPassword.isPresent()) {
      BASE_LOCAL_URL = "https://0.0.0.0:9000";
    } else {
      BASE_LOCAL_URL = "http://0.0.0.0:9000";
    }

    tylerToHttp.clear();
    // First three are ones that the proxy should handle well. If we don't then it's our fault.
    // Message received in substitution message format but extended message format expected.
    tylerToHttp.put("-1000", 500);  
    // Message received in extended message format but substitution message format expected.
    tylerToHttp.put("-999", 500); 
    tylerToHttp.put("-20", 500);  // Schema validation error
    // Everything else
    tylerToHttp.put("-15", 504); // Communicitation with CMS timed out or failed
    // CMS is unavailable, cases that have not been E-filed previously won't be found at this time
    tylerToHttp.put("-10", 503); 
    tylerToHttp.put("-5", 403); // Insufficient permissions to complete operation
    tylerToHttp.put("-4", 401); // Authorization failed
    tylerToHttp.put("-2", 401); // Caller not authenticated
    tylerToHttp.put("-1", 502); // Unknown error
    tylerToHttp.put("0", 200); 
    tylerToHttp.put("77", 400); // IncludeParticipants is empty, this is a required query element
    tylerToHttp.put("78", 428);  // User has already been activated
    tylerToHttp.put("85", 428);  // Service Contact already attached to party
    tylerToHttp.put("86", 428);  // Service Contact not attached to party
    tylerToHttp.put("87", 428);  // Service Contact already attached to case
    tylerToHttp.put("88", 428);  // Service Contact already attached to party
    tylerToHttp.put("90", 400); // Invalid QuerySubmitterID
    tylerToHttp.put("91", 400); // Invalid DocumentSubmitterID 
    tylerToHttp.put("92", 400); // Invalid CaseTrackingID 
    tylerToHttp.put("93", 400); // Invalid StartDate 
    tylerToHttp.put("94", 400); // Invalid EndDate 
    tylerToHttp.put("95", 400); // Invalid FilingAttorneyID 
    tylerToHttp.put("96", 400); // Invalid FilingPartyID 
    tylerToHttp.put("97", 400); // Invalid PaymentID
    tylerToHttp.put("169", 422); // Invalid birthdate
    tylerToHttp.put("170", 422); // Invalid password (when making an account? TODO(brycew))
    tylerToHttp.put("344", 422); // Doesn't handle cross references
  }
  
  public static Optional<TylerUserNamePassword> userCredsFromAuthorization(String userColonPassword) {
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

  /** Sets up a connection to Tyler's SOAP API WITHOUT any Auth headers,
   * but does handle the X.509 certificate and signing parameters.
   *
   * <p>Can be used to make an Auth request, or can have the header inserted later.</p>
   */
  public static void setupServicePort(BindingProvider bp) {
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", SoapX509CallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
  }
  
  public static Response makeResponse(BaseResponseType resp, Supplier<Response> defaultRespFunc) {
    return mapTylerCodesToHttp(resp.getError(), defaultRespFunc);
  }

  public static Response makeResponse(QueryResponseMessageType resp, Supplier<Response> defaultRespFunc) {
    return mapTylerCodesToHttp(resp.getError(), defaultRespFunc);
  }
  
  public static boolean hasError(BaseResponseType resp) {
    return checkErrors(resp.getError());
  }

  /** Returns true on errors from the Tyler / Admin side of the API. */
  public static boolean checkErrors(tyler.efm.services.schema.common.ErrorType error) {
    if (!error.getErrorCode().equals("0")) {
      log.error("Error!: " + error.getErrorCode() + ": " + error.getErrorText());
      return true;
    }
    return false;
  }
  
  /** Returns true on errors from the ECF side of the API. They work the same as the Tyler ones. */
  public static boolean checkErrors(
      oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType error) {
    if (error.getErrorCode() != null && !error.getErrorCode().getValue().equals("0")) {
      log.error("Error!: " + error.getErrorCode().getValue() 
          + ": " + error.getErrorText().getValue());
      return true;
    }
    return false;
  }
  

  public static Response mapTylerCodesToHttp(tyler.efm.services.schema.common.ErrorType error,
      Supplier<Response> defaultRespFunc) {
    if (!checkErrors(error)) {
      return defaultRespFunc.get();
    }

    if (tylerToHttp.containsKey(error.getErrorCode())) {
      return Response.status(tylerToHttp.get(error.getErrorCode()))
          .entity(error.getErrorText()).build();
    }
    
    // 422 as semantic issues covers most of the error codes
    return Response.status(422).entity(error.getErrorText()).build(); 
  }

  public static Response mapTylerCodesToHttp(
      List<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType> errors,
      Supplier<Response> defaultRespFunc) {
    for (var error : errors) {
      if (!checkErrors(error)) {
        continue;
      }

      if (tylerToHttp.containsKey(error.getErrorCode().getValue())) {
        return Response.status(tylerToHttp.get(error.getErrorCode().getValue()))
            .entity(error.getErrorText().getValue()).build();
      }
    
      // 422 as semantic issues covers most of the error codes
      return Response.status(422).entity(error.getErrorText().getValue()).build(); 
    }
    return defaultRespFunc.get();
  }
  
  public static void setupReplys(CaseFilingType reply) {
    reply.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    reply.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
  }

  public static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    EntityType typ = new EntityType();
    var commonObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    newMsg.setQuerySubmitter(typ);
    newMsg.setCaseCourt(XmlHelper.convertCourtType(courtId));
    newMsg.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    newMsg.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    return newMsg;
  }

  public static Optional<IEfmFirmService> setupFirmPort(EfmFirmService firmFactory, HttpHeaders httpHeaders, DataSource userDs, String jurisdiction) {
    return setupFirmPort(firmFactory, httpHeaders, userDs, true, jurisdiction);
  }
  
  public static Optional<IEfmFirmService> setupFirmPort(EfmFirmService firmFactory, HttpHeaders httpHeaders, 
      DataSource userDs, boolean needsSoapHeader, String jurisdiction) {
    String activeToken = httpHeaders.getHeaderString("X-API-KEY");
    try (Connection conn = userDs.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest= ld.getAtRestInfo(activeToken); 
      if (atRest.isEmpty()) {
        log.warn("Couldn't find server api key");
        return Optional.empty();
      }
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.empty();
    }
    if (needsSoapHeader) {
      String tylerToken = httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
      return setupFirmPort(firmFactory, tylerToken);
    }
    IEfmFirmService port = firmFactory.getBasicHttpBindingIEfmFirmService();
    setupServicePort((BindingProvider) port);
    return Optional.of(port);
  }
    
  public static Optional<IEfmFirmService> setupFirmPort(EfmFirmService firmFactory, String tylerToken) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from " + tylerToken + "?");
      return Optional.empty();
    }

    IEfmFirmService port = firmFactory.getBasicHttpBindingIEfmFirmService();
    setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      log.warn(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }
  
  /** Helper for getting all of the valid courts that can be passed to a particular endpoint,
   * 
   * @param cd
   * @param fileableOnly
   * @param withNames
   * @return
   */
  public static Response getCourts(CodeDatabase cd, boolean fileableOnly, boolean withNames) {
    if (fileableOnly) {
      // 0 and 1 are special "system" courts that have defaults for all courts.
      // They aren't available for filing, so filter out of either query here
      if (withNames) {
        return Response.ok(cd.getFileableLocationNames().stream()
            .filter(c -> !c.getCode().equals("0") && !c.getCode().equals("1")).sorted()
            .collect(Collectors.toList())).build();
      } else {
        return Response.ok(cd.getFileableLocations().stream()
            .filter(c -> !c.equals("0") && !c.equals("1")).sorted().collect(Collectors.toList()))
            .build();
      }
    } else {
      if (withNames) {
        return Response.ok(cd.getLocationNames()).build();
      } else {
        return Response.ok(cd.getAllLocations()).build();
      }
    }
  }

  /** Quick wrapper to get an env var as an optional. */
  public static Optional<String> GetEnv(String envVarName) {
    String val = System.getenv(envVarName);
    if (val == null || val.isBlank()) {
      return Optional.empty();
    }
    return Optional.of(val);
  }


}
