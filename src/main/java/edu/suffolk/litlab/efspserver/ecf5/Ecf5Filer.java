package edu.suffolk.litlab.efspserver.ecf5;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.services.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.FilingResult;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.tyler.TylerLogin;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.CancelFilingMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.CancelFilingRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.CancelFilingResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDEService;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ecf5Filer extends EfmCheckableFilingInterface {
  private static Logger log = LoggerFactory.getLogger(Ecf5Filer.class);

  private static final PolicyCacher policyCacher = new PolicyCacher();
  private final CourtPolicyMDEService policyServFactory;
  private final FilingReviewMDEService reviewServFactory;
  private final String headerKey;
  private final Supplier<CodeDatabase> cdSupplier;

  // Object factories for the XML
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.ObjectFactory
      cancelObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ObjectFactory
      wrapperObjFac;

  public Ecf5Filer(String jurisdiction, String env, Supplier<CodeDatabase> cdSupplier) {
    TylerLogin login = new TylerLogin(jurisdiction, env);
    this.headerKey = login.getHeaderKey();
    Optional<CourtPolicyMDEService> maybePolicy =
        SoapClientChooser.getCourtPolicyFactory(jurisdiction, env);
    if (maybePolicy.isEmpty()) {
      throw new RuntimeException(
          "Cannot find " + jurisdiction + " in " + env + " for court policy service factory");
    }
    this.policyServFactory = maybePolicy.get();

    Optional<FilingReviewMDEService> maybeReview =
        SoapClientChooser.getFilingReviewFactory(jurisdiction, env);
    if (maybeReview.isEmpty()) {
      throw new RuntimeException(
          "Cannot find " + jurisdiction + " in " + env + " for court policy service factory");
    }
    this.reviewServFactory = maybeReview.get();
    this.cdSupplier = cdSupplier;

    this.cancelObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.ObjectFactory();
    this.wrapperObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ObjectFactory();
  }

  @Override
  public Result<FilingResult, FilingError> submitFilingIfReady(
      FilingInformation info, InfoCollector collector, String apiToken, ApiChoice choice) {
    throw new UnsupportedOperationException("Unimplemented method 'submitFilingIfReady'");
  }

  @Override
  public Result<Response, FilingError> getFilingFees(FilingInformation info, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingFees'");
  }

  @Override
  public Result<Response, FilingError> getServiceTypes(FilingInformation info, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getServiceTypes'");
  }

  @Override
  public Response getFilingList(
      String courtId,
      String submitterId,
      LocalDate startDate,
      LocalDate beforeDate,
      String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingList'");
  }

  @Override
  public Response getFilingStatus(String courtId, String filingId, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingStatus'");
  }

  @Override
  public Response getFilingDetails(String courtId, String filingId, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingDetails'");
  }

  @Override
  public Response getFilingService(
      String courtId, String filingId, String contactId, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingService'");
  }

  @Override
  public Response getPolicy(String courtId, String apiToken) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500)
          .entity("Couldn't access database: " + StdLib.strFromException(ex))
          .build();
    }
    Optional<CourtPolicyMDE> port = Ecf5Helper.setupPolicyPort(policyServFactory, apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    GetPolicyResponseMessageType resp = policyCacher.getPolicyFor(port.get(), courtId);
    return Response.ok(resp).build();
  }

  private List<String> getAllLocations() throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cd.getAllLocations();
    }
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, String apiToken) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDE> port = Ecf5Helper.setupReviewPort(reviewServFactory, apiToken);
      if (port.isEmpty()) {
        return Response.status(403).build();
      }
      CancelFilingMessageType cancel =
          Ecf5Helper.prep(cancelObjFac.createCancelFilingMessageType(), courtId);
      cancel
          .getDocumentIdentification()
          .add(Ecf5Helper.convertId(filingId, "FilingReview", "filingID"));
      CancelFilingRequestType cancelWrapper = wrapperObjFac.createCancelFilingRequestType();
      cancelWrapper.setCancelFilingMessage(cancel);
      CancelFilingResponseType resp = port.get().cancelFiling(cancelWrapper);
      return Ecf5Helper.mapTylerCodesToHttp(
          resp.getMessageStatus(), () -> Response.noContent().build());
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?: " + StdLib.strFromException(ex));
      return Response.status(500).entity("Ops error: could not connect to database").build();
    }
  }

  @Override
  public Response disclaimers(String courtId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'disclaimers'");
  }

  @Override
  public String getOrgName() {
    // No real API key we need to save
    return "tyler";
  }

  @Override
  public String getHeaderKey() {
    return this.headerKey;
  }
}
