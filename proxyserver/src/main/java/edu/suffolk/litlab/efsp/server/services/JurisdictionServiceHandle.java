package edu.suffolk.litlab.efsp.server.services;

import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JurisdictionServiceHandle {
  private static Logger log = LoggerFactory.getLogger(JurisdictionServiceHandle.class);

  private final Optional<AdminUserService> adminUser;
  private final Optional<CasesService> cases;
  private final Optional<CodesService> codes;
  private final Optional<CourtSchedulingService> courtScheduling;
  private final FilingReviewService filingReview;
  private final Optional<FirmAttorneyAndServiceService> firmAttorneyAndService;
  private final Optional<PaymentsService> payments;
  private final String jurisdiction;

  public JurisdictionServiceHandle(
      String jurisdiction,
      AdminUserService au,
      CasesService c,
      CodesService codes,
      CourtSchedulingService cs,
      FilingReviewService fr,
      FirmAttorneyAndServiceService fa,
      PaymentsService p) {
    this(
        jurisdiction,
        Optional.of(au),
        Optional.of(c),
        Optional.of(codes),
        Optional.of(cs),
        fr,
        Optional.of(fa),
        Optional.of(p));
  }

  public JurisdictionServiceHandle(
      String jurisdiction,
      AdminUserService au,
      CasesService c,
      CodesService codes,
      Optional<CourtSchedulingService> cs,
      FilingReviewService fr,
      FirmAttorneyAndServiceService fa,
      PaymentsService p) {
    this(
        jurisdiction,
        Optional.of(au),
        Optional.of(c),
        Optional.of(codes),
        cs,
        fr,
        Optional.of(fa),
        Optional.of(p));
  }

  public JurisdictionServiceHandle(
      String jurisdiction, FilingReviewService filingReview, CodesService codes) {
    this(
        jurisdiction,
        Optional.empty(),
        Optional.empty(),
        Optional.of(codes),
        Optional.empty(),
        filingReview,
        Optional.empty(),
        Optional.empty());
  }

  public JurisdictionServiceHandle(String jurisdiction, FilingReviewService filingReview) {
    this(
        jurisdiction,
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        filingReview,
        Optional.empty(),
        Optional.empty());
  }

  private JurisdictionServiceHandle(
      String jurisdiction,
      Optional<AdminUserService> adminUser,
      Optional<CasesService> cases,
      Optional<CodesService> codes,
      Optional<CourtSchedulingService> courtScheduling,
      FilingReviewService filingReview,
      Optional<FirmAttorneyAndServiceService> firmAttorneyAndService,
      Optional<PaymentsService> payments) {
    this.jurisdiction = jurisdiction;
    this.adminUser = adminUser;
    this.cases = cases;
    this.codes = codes;
    this.courtScheduling = courtScheduling;
    this.filingReview = filingReview;
    this.firmAttorneyAndService = firmAttorneyAndService;
    this.payments = payments;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("/jurisdictions/" + jurisdiction);
    var x = ef.findRESTEndpoints(List.of(JurisdictionServiceHandle.class));
    log.info("All endpoints for servicehandle: " + x);
    var map = ef.endPointsToMap(x);
    ArrayList<String> keysToRemove = new ArrayList<>();
    for (String key : map.keySet()) {
      var val = map.get(key);
      String url = val.get("url");
      if ((url.endsWith("adminusers") && adminUser.isEmpty())
          || (url.endsWith("codes") && codes.isEmpty())
          || (url.endsWith("cases") && cases.isEmpty())
          || (url.endsWith("scheduling") && courtScheduling.isEmpty())
          || (url.endsWith("firmattorneyservice") && firmAttorneyAndService.isEmpty())
          || (url.endsWith("payments") && payments.isEmpty())) {
        keysToRemove.add(key);
      }
    }
    for (String key : keysToRemove) {
      map.remove(key);
    }
    log.info("Hitting HATEOS endpoint for " + jurisdiction + ": map: " + map);
    return Response.ok(map).build();
  }

  @Path("/adminusers")
  public AdminUserService getAdminUserService() {
    return adminUser.orElse(null);
  }

  @Path("/codes")
  public CodesService getCodesService() {
    return codes.orElse(null);
  }

  @Path("/cases")
  public CasesService getCasesService() {
    return cases.orElse(null);
  }

  @Path("/scheduling")
  public CourtSchedulingService getCourtSchedulingService() {
    return courtScheduling.orElse(null);
  }

  @Path("/filingreview")
  public FilingReviewService getFilingReviewService() {
    return filingReview;
  }

  @Path("/firmattorneyservice")
  public FirmAttorneyAndServiceService getFirmAttorneyService() {
    return firmAttorneyAndService.orElse(null);
  }

  @Path("/payments")
  public PaymentsService getPaymentsService() {
    return payments.orElse(null);
  }
}
