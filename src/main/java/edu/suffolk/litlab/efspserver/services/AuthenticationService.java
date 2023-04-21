package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efspserver.db.NewTokens;
import java.util.Optional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

  @POST
  public Response authenticateUser(@Context HttpHeaders httpHeaders, String loginInfo) {
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
