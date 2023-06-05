package edu.suffolk.litlab.efspserver.ecf5;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.services.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.FilingResult;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.tyler.TylerLogin;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDEService;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Ecf5Filer extends EfmCheckableFilingInterface {

  private static final PolicyCacher policyCacher = new PolicyCacher();
  private final CourtPolicyMDEService policyServFactory;
  private final String headerKey;

  public Ecf5Filer(String jurisdiction, String env) {
    TylerLogin login = new TylerLogin(jurisdiction, env);
    this.headerKey = login.getHeaderKey();
    Optional<CourtPolicyMDEService> maybePolicy =
        SoapClientChooser.getCourtPolicyFactory(jurisdiction, env);
    if (maybePolicy.isEmpty()) {
      throw new RuntimeException(
          "Cannot find " + jurisdiction + " in " + env + " for court policy service factory");
    }
    this.policyServFactory = maybePolicy.get();
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
    return List.of("adams");
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'cancelFiling'");
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
