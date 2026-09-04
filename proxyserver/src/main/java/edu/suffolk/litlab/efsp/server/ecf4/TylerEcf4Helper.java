package edu.suffolk.litlab.efsp.server.ecf4;

import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.Ecf4Helper;
// import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.TylerErrorCodes;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.function.Supplier;

/**
 * Helper class that easily converts Java native types to Cumbersome XML Schema types, particularly
 * those from Oasis's ECF standard, and the National Information Exchange Model (NIEM).
 *
 * <p>Some information about NIEM: Many of the types here all include the
 * "SimpleObjectAttributeGroup", which, "provides a collection of attributes which are appropriate
 * for definition of object types", including an ID attribute, a Metadata attribute, and a Link
 * Metadata attribute that directly reference objects via IDs instead of including the object as an
 * element. TBH, I'm not sure what the design decisions that dictate the use of them are, but they
 * exist.
 *
 * @author Bryce Willey
 */
public class TylerEcf4Helper {

  public static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    return Ecf4Helper.prep(newMsg, courtId, ServiceHelpers.EXTERNAL_URL);
  }

  public static Response makeResponse(
      QueryResponseMessageType resp, Supplier<Response> defaultRespFunc) {
    return mapTylerCodesToHttp(Ecf4Helper.checkErrors(resp.getError()), defaultRespFunc);
  }

  public static Response mapTylerCodesToHttp(
      List<Ecf4Helper.Error> err, Supplier<Response> defaultResp) {
    if (!err.isEmpty()) {
      var mainErr = err.getFirst();
      if (TylerErrorCodes.tylerToHttp.containsKey(mainErr.code())) {
        return Response.status(TylerErrorCodes.tylerToHttp.get(mainErr.code()))
            .entity(mainErr.text())
            .build();
      }

      // 422 as semantic issues covers most of the error codes
      return Response.status(422).entity(mainErr.text()).build();
    }
    return defaultResp.get();
  }

  public static void setupReplys(CaseFilingType reply) {
    Ecf4Helper.setupReplys(reply, ServiceHelpers.SERVICE_URL);
  }
}
