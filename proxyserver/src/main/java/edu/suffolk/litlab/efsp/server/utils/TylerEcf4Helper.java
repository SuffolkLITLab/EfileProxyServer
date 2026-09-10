package edu.suffolk.litlab.efsp.server.utils;

import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import edu.suffolk.litlab.efsp.server.auth.UserCreds;
import edu.suffolk.litlab.efsp.tyler.Ecf4Helper;
import edu.suffolk.litlab.efsp.tyler.TylerErrorCodes;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.BindingProvider;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
  private static final Logger log = LoggerFactory.getLogger(TylerEcf4Helper.class);

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

    // This will stop errors from occuring on other versions
    ctx.put("set-jaxb-validation-event-handler", "false");
  }

  public static void setupServicePort(BindingProvider bp, UserCreds creds) {
    setupServicePort(bp, creds.toHeaders());
  }

  public static void setupServicePort(BindingProvider bp, List<Header> headerList) {
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put(Header.HEADER_LIST, headerList);
    setupServicePort(bp);
  }

  public static boolean getIsIndividual(TylerFirmFactory firmFactory, UserCreds userCreds) {
    Optional<TylerFirmClient> firmClient = setupFirmPort(firmFactory, userCreds, true);
    boolean isIndividual =
        firmClient
            .map(
                port -> {
                  try {
                    var resp = port.getFirm();
                    if (TylerErrorCodes.hasError(resp)) {
                      log.warn(
                          "GetFirm returned an error: {}, {}",
                          resp.getError().getErrorCode(),
                          resp.getError().getErrorText());
                    }
                    return resp.getFirm().isIsIndividual();
                  } catch (Exception ex) {
                    log.warn("Exception when getting firm info for individual?:", ex);
                    return true;
                  }
                })
            .orElse(true);
    return isIndividual;
  }

  public static Optional<TylerFirmClient> setupFirmPort(
      TylerFirmFactory firmFactory, UserCreds userCreds) {
    return setupFirmPort(firmFactory, userCreds, true);
  }

  public static Optional<TylerFirmClient> setupFirmPort(
      TylerFirmFactory firmFactory, UserCreds creds, boolean needsSoapHeader) {
    if (needsSoapHeader) {
      return Optional.of(
          firmFactory.makeFirmClient((port) -> setupServicePort(port, creds.toHeaders())));
    } else {
      return Optional.of(firmFactory.makeFirmClient(TylerEcf4Helper::setupServicePort));
    }
  }
}
