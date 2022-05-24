package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JurisdictionServiceHandle {
  
  private final Optional<AdminUserService> adminUser;
  private final Optional<CasesService> cases;
  private final Optional<CodesService> codes;
  private final Optional<CourtSchedulingService> courtScheduling;
  private final FilingReviewService filingReview;
  private final Optional<FirmAttorneyAndServiceService> firmAttorneyAndService; 
  private final Optional<PaymentsService> payments;
  private final String jurisdiction;
  
  public JurisdictionServiceHandle(String jurisdiction, AdminUserService au, CasesService c, CodesService codes, CourtSchedulingService cs,
      FilingReviewService fr, FirmAttorneyAndServiceService fa, PaymentsService p) {
    this(jurisdiction, Optional.of(au), Optional.of(c), Optional.of(codes), Optional.of(cs), fr, Optional.of(fa), Optional.of(p));
  }
  
  public JurisdictionServiceHandle(String jurisdiction, FilingReviewService filingReview) {
    this(jurisdiction, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), filingReview, Optional.empty(), Optional.empty());
  }

  private JurisdictionServiceHandle(String jurisdiction, Optional<AdminUserService> adminUser,
      Optional<CasesService> cases, Optional<CodesService> codes, Optional<CourtSchedulingService> courtScheduling,
      FilingReviewService filingReview, Optional<FirmAttorneyAndServiceService> firmAttorneyAndService,
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
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(JurisdictionServiceHandle.class)))).build();
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
