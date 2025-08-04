package edu.suffolk.litlab.efsp.server.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * The interface for Case search queries.
 *
 * <p>Introduces some abstraction between our current API (returning all raw API info) and a more
 * structured, culled down version of the API that returns information without all of the silly NIEM
 * abstractions. Would choose between different versions of the API with a separate X-API-VERSION header.
 */
@Produces(MediaType.APPLICATION_JSON)
public abstract class CasesServiceAPI {

  @GET
  @Path("/")
  public abstract Response getAll();

  @GET
  @Path("/courts")
  public abstract Response getCourts();

  @GET
  @Path("/courts/{court_id}")
  public abstract Response getEndpointsUnderCourt(@PathParam("court_id") String courtId);

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/documents")
  public abstract Response getDocument(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId);

  /** Gets all possible cases associated with either a party's name or a docket number. */
  @GET
  @Path("/courts/{court_id}/cases")
  public abstract Response getCaseList(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("docket_number") String docketId,
      @QueryParam("business_name") String businessName,
      @QueryParam("first_name") String firstName,
      @QueryParam("middle_name") String middleName,
      @QueryParam("last_name") String lastName);

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}")
  public abstract Response getCase(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId);

  @GET
  @Path("/courts/{court_id}/service-contacts/{service_contact_id}/cases")
  public abstract Response getServiceAttachCaseList(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("service_contact_id") String serviceId);

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information")
  public abstract Response getServiceInformation(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId);

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information-history")
  public abstract Response getServiceInformationHistory(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId);
}
