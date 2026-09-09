package edu.suffolk.litlab.efsp.server.truefiling;

import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.EcfError;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TFEcf4Helper {
  private static final Logger log = LoggerFactory.getLogger(Ecf4Helper.class);

  public static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    return Ecf4Helper.prep(newMsg, courtId, ServiceHelpers.SENDING_MDE_LOCATION);
  }

  public static Response makeResponse(
      QueryResponseMessageType resp, Supplier<Response> defaultRespFunc) {
    return mapErrorCodesToHttp(checkErrors(resp.getError()), defaultRespFunc);
  }

  public static List<EcfError> checkErrors(
      List<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType> errors) {
    return errors.stream().flatMap(err -> checkError(err).stream()).toList();
  }

  /** Returns the error type on errors from the ECF side of the API. */
  public static Optional<EcfError> checkError(
      oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType error) {
    var errCode = error.getErrorCode();
    if (errCode != null && !errCode.getValue().equals("0")) {
      log.error("Error!: {}: {}", errCode.getValue(), error.getErrorText().getValue());
      return Optional.of(new EcfError(errCode.getValue(), error.getErrorText().getValue()));
    }
    return Optional.empty();
  }

  public static Response mapErrorCodesToHttp(List<EcfError> err, Supplier<Response> defaultResp) {
    if (!err.isEmpty()) {
      var mainErr = err.getFirst();
      // TODO: map TrueFiling error stuff?
      // 422 as semantic issues covers most of the error codes
      return Response.status(422).entity(mainErr.text()).build();
    }
    return defaultResp.get();
  }
}
