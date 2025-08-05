package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.server.auth.TylerLogin;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.ws.BindingProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Provider
@NeedsAuthorization
@Priority(Priorities.AUTHENTICATION)
public class AuthenticateRequestInterceptor implements ContainerRequestFilter {
  private static final Logger log = LoggerFactory.getLogger(ObservabilityResetInterceptor.class);
  public static final String API_KEY_HEADER = "X-API-KEY";
  private final Supplier<LoginDatabase> ldSupplier;
  private final Map<String, TylerUserFactory> userFactories;
  private final Map<String, TylerFirmFactory> firmFactories;

  private @Context ResourceInfo info;

  public AuthenticateRequestInterceptor(Supplier<LoginDatabase> ldSupplier) {
    this.ldSupplier = ldSupplier;
    this.userFactories = new ConcurrentHashMap<>();
    this.firmFactories = new ConcurrentHashMap<>();
  }

  @Context
  public void setResourceInfo(ResourceInfo resourceInfo) {
    this.info = resourceInfo;
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String apiKey = requestContext.getHeaders().getFirst(API_KEY_HEADER);
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        log.warn("No server API key found, aborting this call");
        requestContext.abortWith(Response.status(401).build());
      }
      var p = new ServerUser(atRest.get().serverId); 
      var security = new EfspSecurityContext(p, "");
      requestContext.setSecurityContext(security);

      var maybeToken = getToken(requestContext);
      maybeToken.ifPresent(
          token -> {
            String hash = ld.makeHash(token);
            // Only need uniqueness for the hash, not exactness (nowhere near that scale).
            MDC.put(MDCWrappers.USER_ID, hash.substring(0, 9));
            var jurisdiction = getJurisdiction(requestContext).get();
            Method method = info.getResourceMethod();

            if (method != null) {
              NeedsAuthorization annotation = method.getAnnotation(NeedsAuthorization.class);
              for (NeedsAuthorization.AuthType permission : annotation.permissions()) {
                switch (permission) {
                  case USER_PORT:
                      
                      Optional<TylerUserNamePassword> creds =
                          TylerUserNamePassword.userCredsFromAuthorization(token);
                      break;
                }
                
              }
            }
          });
    } catch (SQLException ex) {
      log.error("SQL when trying to check API Key / login:", ex);
      requestContext.abortWith(Response.status(500).build());
      return;
    }
  }

  private Optional<TylerUserClient> setupUserPort(String tylerToken) {
      Optional<TylerUserNamePassword> creds =
          TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
      if (creds.isEmpty()) {
        return Optional.empty();
      }
      Consumer<BindingProvider> setup =
          (BindingProvider bp) -> {
            ServiceHelpers.setupServicePort(bp);
            Map<String, Object> ctx = bp.getRequestContext();
            List<Header> headersList = List.of(creds.get().toHeader());
            ctx.put(Header.HEADER_LIST, headersList);
          };
      return Optional.of(userFactory.makeUserClient(setup));

  }

  private Optional<String> getJurisdiction(ContainerRequestContext requestContext) {
    String path = requestContext.getUriInfo().getPath();
    // Endpoints outside "jurisdictions/" are taken by server admins, not tyler users.
    if (!path.startsWith("jurisdictions/")) {
      return Optional.empty();
    }
    var parts = path.split("/");
    if (parts.length <= 1) {
      return Optional.empty();
    }
    // TODO: compare to ensure this is within our expected jursdictions
    return Optional.of(parts[1]);
  }

  /**
   * Gets the Tyler login token of the request, if it's present.
   *
   * <p>Based on what the current path of the request is (it needs to be under "jurisdictions/..."
   * to get the right login token).
   */
  private Optional<String> getToken(ContainerRequestContext requestContext) {
    var maybeJurisdiction = getJurisdiction(requestContext);
    return maybeJurisdiction.flatMap(jurisdiction -> {
      String tylerToken =
          requestContext.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
      if (tylerToken == null || tylerToken.isBlank()) {
        return Optional.empty();
      }
      return Optional.of(tylerToken);
    });
  }
}
