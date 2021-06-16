package edu.suffolk.assemblyline.efspserver.services;

import edu.suffolk.assemblyline.efspserver.ClientCallbackHandler;
import edu.suffolk.assemblyline.efspserver.TylerUserNamePassword;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.xml.ws.BindingProvider;

public class ServiceHelpers {

  static Map<String, Integer> tylerToHttp;
  static String SERVICE_URL = "https://filingassemblymde.com";

  /**
   * One of the ways that you can communicate over ECF. For more information, see
   * https://docs.oasis-open.org/legalxml-courtfiling/specs/ecf/v4.01/ecf-v4.01-spec/errata02/os/ecf-v4.01-spec-errata02-os-complete.html#_Toc425241629
   */
  public static final String MDE_PROFILE_CODE = 
      "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-2.0";

  static {
    tylerToHttp = new HashMap<String, Integer>();
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
    tylerToHttp.put("169", 422); // Invalid birthdate
    tylerToHttp.put("170", 422); // Invalid password (when making an account? TODO(brycew))
    
    
  }
  
  public static Optional<TylerUserNamePassword> userCredsFromHeaders(HttpHeaders httpHeaders) {
    List<String> headers = httpHeaders.getRequestHeader("authorization");
    if (headers == null || headers.isEmpty()) {
      headers = httpHeaders.getRequestHeader("Authorization");
    }
    
    if (headers == null || headers.isEmpty()) {
      return Optional.empty();
    }
    // TODO(brycew) is this RFC-7235 conforming?
    String[] parts = headers.get(0).split(" ");
    if (parts.length != 2 || !parts[0].equals("Basic")) {
      return Optional.empty();
    }
    
    System.err.println("Parts: " + parts[0] + ", " + parts[1]);
    System.err.println("Parts 1 contains 27? " + parts[1].indexOf(27));
    System.err.println("Parts 1 contains 27? " + parts[1].indexOf(39));
    String creds = new String(Base64.getDecoder().decode(parts[1]));
    String email = creds.split(":")[0];
    String password = creds.split(":")[1];
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
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
  }

  /** Returns true on errors from the Tyler / Admin side of the API. */
  public static boolean checkErrors(tyler.efm.services.schema.common.ErrorType error) {
    if (!error.getErrorCode().equals("0")) {
      System.err.println("Error!: " + error.getErrorCode() + ": " + error.getErrorText());
      return true;
    }
    return false;
  }
  
  /** Returns true on errors from the ECF side of the API. They work the same as the Tyler ones. */
  public static boolean checkErrors(
      oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType error) {
    if (error.getErrorCode() != null && !error.getErrorCode().getValue().equals("0")) {
      System.err.println("Error!: " + error.getErrorCode().getValue() 
          + ": " + error.getErrorText());
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
    for (oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType error : errors) {
      if (!checkErrors(error)) {
        continue;
      }

      if (tylerToHttp.containsKey(error.getErrorCode().getValue())) {
        return Response.status(tylerToHttp.get(error.getErrorCode().getValue()))
            .entity(error.getErrorText().getValue()).build();
      }
    
      // 422 as semantic issues covers most of the error codes
      return Response.status(422).entity(error.getErrorText()).build(); 
    }
    return defaultRespFunc.get();
  }
}
