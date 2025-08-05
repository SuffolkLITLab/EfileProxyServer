package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.server.auth.TylerLogin;
import edu.suffolk.litlab.efsp.server.ecf4.SoapClientChooser;
import edu.suffolk.litlab.efsp.server.utils.NeedsAuthorization.AuthType;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efsp.utils.Hasher;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.ws.BindingProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;

@Component
@Provider
@NeedsAuthorization
@Priority(Priorities.AUTHENTICATION)
public class AuthenticateRequestInterceptor implements ContainerRequestFilter {
  private static final Logger log = LoggerFactory.getLogger(ObservabilityResetInterceptor.class);
  public static final String API_KEY_HEADER = "X-API-KEY";
  private final Supplier<LoginDatabase> ldSupplier;
  private final Map<Jurisdiction, TylerUserFactory> userFactories;
  private final Map<Jurisdiction, TylerFirmFactory> firmFactories;
  private final Map<Jurisdiction, FilingReviewMDEService> reviewFactories;
  private final Map<Jurisdiction, ServiceMDEService> serviceFactories;
  private final Map<Jurisdiction, CourtRecordMDEService> recordFactories;
  private final Map<Jurisdiction, CourtSchedulingMDE_Service> schedulingFactories;

  private @Context ResourceContext resourceContext;

  private @Context ResourceInfo info;

  public AuthenticateRequestInterceptor(
      Supplier<LoginDatabase> ldSupplier,
      List<Jurisdiction> jurisdictions,
      Optional<TylerEnv> env) {
    this.ldSupplier = ldSupplier;
    this.userFactories = new ConcurrentHashMap<>();
    this.firmFactories = new ConcurrentHashMap<>();
    this.reviewFactories = new ConcurrentHashMap<>();
    this.serviceFactories = new ConcurrentHashMap<>();
    this.recordFactories = new ConcurrentHashMap<>();
    this.schedulingFactories = new ConcurrentHashMap<>();

    if (env.isEmpty()) {
      // TylerEnv can be empty! So if it is, no Soap stuff.
      return;
    }
    // Just calls `get()` on optionals so we fail early if they aren't present
    for (var jurisdiction : jurisdictions) {
      var domain = new TylerDomain(jurisdiction, env.get());
      var userFactory = TylerClients.getEfmUserFactory(domain);
      userFactories.put(jurisdiction, userFactory.get());

      var firmFactory = TylerClients.getEfmFirmFactory(domain);
      firmFactories.put(jurisdiction, firmFactory.get());

      var reviewFactory = SoapClientChooser.getFilingReviewFactory(domain);
      reviewFactories.put(jurisdiction, reviewFactory.get());

      var serviceFactory = SoapClientChooser.getServiceFactory(domain);
      serviceFactories.put(jurisdiction, serviceFactory.get());

      var recordFactory = SoapClientChooser.getCourtRecordFactory(domain);
      recordFactories.put(jurisdiction, recordFactory.get());

      var schedulingFactory = SoapClientChooser.getCourtSchedulingFactory(domain);
      schedulingFactories.put(jurisdiction, schedulingFactory.get());
    }
  }

  @Context
  public void setResourceInfo(ResourceInfo resourceInfo) {
    this.info = resourceInfo;
  }

  @Context
  public void setResourceContext(ResourceContext resourceContext) {
    this.resourceContext = resourceContext;
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String apiKey = requestContext.getHeaders().getFirst(API_KEY_HEADER);
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        log.warn("No server API key found, aborting this call");
        requestContext.abortWith(Response.status(401).build());
        return;
      }
      var p = new ServerUser(atRest.get().serverId);
      var security = new EfspSecurityContext(p, "");
      requestContext.setSecurityContext(security);

      Method method = info.getResourceMethod();
      List<NeedsAuthorization.AuthType> permissions = List.of();
      if (method != null) {
        permissions = Arrays.asList(method.getAnnotation(NeedsAuthorization.class).permissions());
      }
      if (permissions.size() == 0) {
        // No permissions are needed (just an internal DB call, doesn't call Tyler), continue with
        // the call
        return;
      }
      var maybeJuris = getJurisdiction(requestContext);
      if (maybeJuris.isEmpty()) {
        log.error(
            "Unable to find the jurisdiction for this call, does the method actually need to call Tyler?");
        requestContext.abortWith(Response.status(401).build());
        return;
      }
      var jurisdiction = maybeJuris.get();
      Optional<TylerUserNamePassword> maybeCreds = getCreds(requestContext, jurisdiction);
      maybeCreds.ifPresent(
          creds -> {
            String hash = Hasher.makeHash(creds.toCredsString());
            // Only need uniqueness for the hash, not exactness (nowhere near that scale).
            MDC.put(MDCWrappers.USER_ID, hash.substring(0, 9));
          });
      boolean needsCreds =
          permissions.stream().anyMatch(perm -> perm != AuthType.USER_PORT_NO_HEADER);
      if (needsCreds && maybeCreds.isEmpty()) {
        log.warn("No Tyler token passed when needed to call Tyler, aborting this call");
        requestContext.abortWith(Response.status(401).build());
        return;
      }
      for (NeedsAuthorization.AuthType permission : permissions) {
        switch (permission) {
          case USER_PORT:
            setupUserPort(jurisdiction, maybeCreds.get());
            break;
          case USER_PORT_NO_HEADER:
            setupUserPortNoCreds(jurisdiction);
            break;
          case FIRM_PORT:
            setupFirmPort(jurisdiction, maybeCreds.get());
            break;
          case REVIEW_MDE:
            setupReviewMde(jurisdiction, maybeCreds.get());
            break;
          case SERVICE_MDE:
            setupServiceMde(jurisdiction, maybeCreds.get());
            break;
          case CASE_MDE:
            setupCaseMde(jurisdiction, maybeCreds.get());
            break;
          case SCHEDULE_MDE:
            setupScheduleMde(jurisdiction, maybeCreds.get());
            break;
        }
      }
    } catch (SQLException ex) {
      log.error("SQL when trying to check API Key / login:", ex);
      requestContext.abortWith(Response.status(500).build());
      return;
    }
  }

  private Consumer<BindingProvider> templateSetup(TylerUserNamePassword creds) {
    return (bp) -> ServiceHelpers.setupServicePort(bp, creds);
  }

  private void setupUserPort(Jurisdiction jurisdiction, TylerUserNamePassword creds) {
    TylerUserClient client = userFactories.get(jurisdiction).makeUserClient(templateSetup(creds));
    resourceContext.initResource(client);
  }

  private void setupUserPortNoCreds(Jurisdiction jurisdiction) {
    TylerUserClient client =
        userFactories.get(jurisdiction).makeUserClient(ServiceHelpers::setupServicePort);
    resourceContext.initResource(client);
  }

  private void setupFirmPort(Jurisdiction jurisdiction, TylerUserNamePassword creds) {
    TylerFirmClient client = firmFactories.get(jurisdiction).makeFirmClient(templateSetup(creds));
    resourceContext.initResource(client);
  }

  private void setupCaseMde(Jurisdiction jurisdiction, TylerUserNamePassword creds) {
    var factory = recordFactories.get(jurisdiction);
    var port = factory.getCourtRecordMDEPort();

    // Sometimes, getCases takes an incredibly long time. Bump timeout to 3 minutes
    Client client = ClientProxy.getClient(port);
    HTTPConduit http = (HTTPConduit) client.getConduit();
    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    httpClientPolicy.setConnectionTimeout(180_000);
    httpClientPolicy.setReceiveTimeout(180_000);
    http.setClient(httpClientPolicy);

    ServiceHelpers.setupServicePort((BindingProvider) port, creds);
    resourceContext.initResource(port);
  }

  private void setupReviewMde(Jurisdiction jurisdiction, TylerUserNamePassword creds) {
    var factory = reviewFactories.get(jurisdiction);
    var port = factory.getFilingReviewMDEPort();

    // Sometimes, getCases takes an incredibly long time. Bump timeout to 3 minutes
    setTimeout(ClientProxy.getClient(port), 180_000);

    ServiceHelpers.setupServicePort((BindingProvider) port, creds);
    resourceContext.initResource(port);
  }

  private void setupServiceMde(Jurisdiction jurisdiction, TylerUserNamePassword creds) {
    var factory = serviceFactories.get(jurisdiction);
    var port = factory.getServiceMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port, creds);
    resourceContext.initResource(port);
  }

  private void setupScheduleMde(Jurisdiction jurisdiction, TylerUserNamePassword creds) {
    var factory = schedulingFactories.get(jurisdiction);
    var port = factory.getCourtSchedulingMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port, creds);
    resourceContext.initResource(port);
  }

  private void setTimeout(Client client, int timeout) {
    // Sometimes, getCases takes an incredibly long time. Bump timeout to 3 minutes
    HTTPConduit http = (HTTPConduit) client.getConduit();
    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    httpClientPolicy.setConnectionTimeout(timeout);
    httpClientPolicy.setReceiveTimeout(timeout);
    http.setClient(httpClientPolicy);
  }

  private Optional<Jurisdiction> getJurisdiction(ContainerRequestContext requestContext) {
    String path = requestContext.getUriInfo().getPath();
    // Endpoints outside "jurisdictions/" are taken by server admins, not tyler users.
    if (!path.startsWith("jurisdictions/")) {
      return Optional.empty();
    }
    var parts = path.split("/");
    if (parts.length <= 1) {
      return Optional.empty();
    }

    try {
      return Optional.of(Jurisdiction.parse(parts[1]));
    } catch (IllegalArgumentException ex) {
      log.warn("Invalid jurisdiction ({}) in path: {}", parts[1], path);
      return Optional.empty();
    }
  }

  /**
   * Gets the Tyler login token of the request, if it's present.
   *
   * <p>Based on what the current path of the request is (it needs to be under "jurisdictions/..."
   * to get the right login token).
   */
  private Optional<TylerUserNamePassword> getCreds(
      ContainerRequestContext requestContext, Jurisdiction jurisdiction) {
    String tylerToken =
        requestContext.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
    return TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
  }
}
