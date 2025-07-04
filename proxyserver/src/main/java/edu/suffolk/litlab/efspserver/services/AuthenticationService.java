package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import edu.suffolk.litlab.efspserver.db.NewTokens;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Path("/authenticate")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationService {

  private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

  private final SecurityHub security;

  public AuthenticationService(SecurityHub security) {
    this.security = security;
  }

  /**
   * Log in the user to all of the requested e-filing EFMs.
   *
   * @param loginInfo should be a JSON object, with the following keys:
   *     <ul>
   *       <li>api_key: the api key for this server
   *       <li>tyler-myJurisdiction: an object ('myJurisdiction' can be any jurisdiction), with
   *           these tyler jurisdiction values:
   *           <ul>
   *             <li>username: Any tyler jurisdiction username. Example: 'illinois'
   *             <li>password: The jurisdiction's password
   *           </ul>
   *     </ul>
   *
   * @return 200 and the logged in tokens to hang on to and send in with every call
   */
  @StatusCodes({
    @ResponseCode(code = 200, condition = "success"),
    @ResponseCode(code = 403, condition = "login information not valid")
  })
  @POST
  public Response authenticateUser(String loginInfo) {
    MDC.put(MDCWrappers.OPERATION, "AuthenticationService.authenticateUser");
    ObjectMapper mapper = new ObjectMapper();
    String apiKey;
    try {
      JsonNode node = mapper.readTree(loginInfo);
      if (!node.isObject() || !node.has("api_key") || !node.get("api_key").isTextual()) {
        log.error("Call didn't pass in an api_key in the auth call");
        return Response.status(401).build();
      }
      apiKey = node.get("api_key").asText();
    } catch (JsonProcessingException e) {
      log.error(e.toString());
      return Response.status(401).build();
    }
    if (apiKey == null || apiKey.isBlank()) {
      log.error("Call passed in a null / blank api_key");
      return Response.status(401).build();
    }
    log.info("Invoking User Auth for an apiKey");
    Optional<NewTokens> activeToken = security.login(apiKey, loginInfo);
    MDCWrappers.removeAllMDCs();
    return activeToken
        .map((toks) -> Response.ok(toks).build())
        .orElse(Response.status(403).build());
  }
}
