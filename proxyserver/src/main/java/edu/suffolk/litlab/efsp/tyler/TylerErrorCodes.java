package edu.suffolk.litlab.efsp.tyler;

import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;

public class TylerErrorCodes {
  private static final Logger log = LoggerFactory.getLogger(TylerErrorCodes.class);

  // First three are ones that the proxy should handle well. If we don't then it's
  // our fault.
  public static Map<String, Integer> tylerToHttp =
      Map.ofEntries(
          // Received in substitution msg format but extended msg format expected.
          Map.entry("-1000", 500),
          // Received in extended msg format but substitution msg format expected.
          Map.entry("-999", 500),
          Map.entry("-20", 500), // Schema validation error
          // Everything else
          Map.entry("-15", 504), // Communicitation with CMS timed out or failed
          // CMS is unavailable, cases that have not been E-filed previously won't be
          // found at this time
          Map.entry("-10", 503),
          Map.entry("-5", 403), // Insufficient permissions to complete operation
          Map.entry("-4", 401), // Authorization failed
          Map.entry("-2", 401), // Caller not authenticated
          Map.entry("-1", 502), // Unknown error
          Map.entry("0", 200),
          Map.entry("77", 400), // IncludeParticipants is empty, this is a required query element
          Map.entry("78", 428), // User has already been activated
          Map.entry("85", 428), // Service Contact already attached to party
          Map.entry("86", 428), // Service Contact not attached to party
          Map.entry("87", 428), // Service Contact already attached to case
          Map.entry("88", 428), // Service Contact already attached to party
          Map.entry("90", 400), // Invalid QuerySubmitterID
          Map.entry("91", 400), // Invalid DocumentSubmitterID
          Map.entry("92", 400), // Invalid CaseTrackingID
          Map.entry("93", 400), // Invalid StartDate
          Map.entry("94", 400), // Invalid EndDate
          Map.entry("95", 400), // Invalid FilingAttorneyID
          Map.entry("96", 400), // Invalid FilingPartyID
          Map.entry("97", 400), // Invalid PaymentID
          Map.entry("168", 400), // Lower court code not found
          Map.entry("169", 422), // Invalid birthdate
          Map.entry("170", 422), // Invalid password (when making an account? TODO(brycew))
          Map.entry("177", 403), // Operation not available for individual filers
          Map.entry("344", 422) // Doesn't handle cross references
          );

  // The list of codes that we shouldn't error log on / shouldn't send error notification emails
  // for.
  private static List<String> nonAlertingCodes =
      List.of(
          "-4", // Authentication failed, invalid/expired authentication token or email/password
          // combination
          "52", // The Email Address is already in use.
          "55", // No user is registered with that email address.
          "60", // Username not found
          "78" // User has already been activated.
          );

  public static boolean hasError(BaseResponseType resp) {
    return checkErrors(resp.getError());
  }

  public static Response makeResponse(BaseResponseType resp, Supplier<Response> defaultRespFunc) {
    return TylerErrorCodes.mapTylerCodesToHttp(resp.getError(), defaultRespFunc);
  }

  /** Returns true on errors from the Tyler / Admin side of the API. */
  public static boolean checkErrors(tyler.efm.latest.services.schema.common.ErrorType error) {
    var code = error.getErrorCode();
    if (code.equals("0")) {
      return false;
    }

    if (nonAlertingCodes.contains(code)) {
      log.warn("Got a non-urgent erroring response from Tyler: {}: {}", code, error.getErrorText());
    } else {
      log.error("Error from Tyler!: {}: {}", code, error.getErrorText());
    }
    return true;
  }

  public static Response mapTylerCodesToHttp(
      tyler.efm.latest.services.schema.common.ErrorType error, Supplier<Response> defaultRespFunc) {
    if (!checkErrors(error)) {
      return defaultRespFunc.get();
    }

    if (TylerErrorCodes.tylerToHttp.containsKey(error.getErrorCode())) {
      return Response.status(TylerErrorCodes.tylerToHttp.get(error.getErrorCode()))
          .entity(error.getErrorText())
          .build();
    }

    // 422 as semantic issues covers most of the error codes
    return Response.status(422).entity(error.getErrorText()).build();
  }
}
