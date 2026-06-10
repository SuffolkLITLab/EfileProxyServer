package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.server.auth.TylerLogin;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efsp.utils.Hasher;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Provider
@NeedsAuthorization
@Priority(Priorities.AUTHENTICATION)
public class AuthenticateRequestInterceptor implements ContainerRequestFilter {
  private static final Logger log = LoggerFactory.getLogger(AuthenticateRequestInterceptor.class);
  public static final String API_KEY_HEADER = "X-API-KEY";
  private final Supplier<LoginDatabase> ldSupplier;

  public AuthenticateRequestInterceptor(Supplier<LoginDatabase> ldSupplier) {
    this.ldSupplier = ldSupplier;
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String apiKey = requestContext.getHeaders().getFirst(API_KEY_HEADER);
    log.warn("requestContext headers: {}", requestContext.getHeaders());
    // log.warn("requestContext path: {}", requestContext.getUriInfo().getAbsolutePath());
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        log.warn("No matching server API key found for {}, aborting this call", apiKey);
        requestContext.abortWith(Response.status(401).build());
        return;
      }
      var maybeJurisdiction =
          getJurisdiction(requestContext.getUriInfo().getAbsolutePath().getPath());
      var maybeCreds = maybeJurisdiction.flatMap(j -> getCreds(requestContext, j));
      var p = maybeCreds.map(creds -> new TylerUserFromServer(creds));
      var security = new EfspSecurityContext(p, atRest.get(), "");
      requestContext.setSecurityContext(security);
    } catch (SQLException ex) {
      log.error("SQL when trying to check API Key / login:", ex);
      requestContext.abortWith(Response.status(500).build());
      return;
    }
  }

  public static Optional<Jurisdiction> getJurisdiction(String path) {
    // Endpoints outside "jurisdictions/" are taken by server admins, not tyler users.
    if (path.contains("/jurisdictions/")) {
      int start = path.indexOf("/jurisdictions/");
      path = path.substring(start).replace("/jurisdictions/", "");
      var parts = path.split("/");
      try {
        return Optional.of(Jurisdiction.parse(parts[0]));
      } catch (IllegalArgumentException ex) {
        log.warn("Invalid jurisdiction ({}) in path: {}", parts[0], path);
      }
    }

    log.warn("Couldn't find jurisdiction from path ({})", path);
    return Optional.empty();
  }

  /**
   * Gets the Tyler login token of the request, if it's present.
   *
   * <p>Based on what the current path of the request is (it needs to be under "jurisdictions/..."
   * to get the right login token).
   */
  public static Optional<TylerUserNamePassword> getCreds(
      ContainerRequestContext requestContext, Jurisdiction jurisdiction) {
    String tylerToken =
        requestContext.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
    var maybeCreds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (maybeCreds.isPresent()) {
      MDC.put(MDCWrappers.USER_ID, Hasher.makeHash(tylerToken));
    } else {
      if (tylerToken != null && !tylerToken.isBlank()) {
        MDC.put(MDCWrappers.USER_ID, "(invalid token)");
      }
    }
    return maybeCreds;
  }
}
