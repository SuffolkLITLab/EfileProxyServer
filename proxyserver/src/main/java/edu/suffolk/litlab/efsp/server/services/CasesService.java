package edu.suffolk.litlab.efsp.server.services;

import static edu.suffolk.litlab.efsp.server.utils.EndpointReflection.replacePathParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webcohesion.enunciate.metadata.rs.ResourceGroup;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.server.auth.EfspSecurityContext;
import edu.suffolk.litlab.efsp.server.auth.NeedsAuthorization;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import edu.suffolk.litlab.efsp.server.services.api.CaseSearchAPI;
import edu.suffolk.litlab.efsp.server.services.api.CaseSearchAPI.ReturnType;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.MDC;

/**
 * Introduces some abstraction between our current API (returning all raw API info) and a more
 * structured, culled down version of the API that returns information without all of the silly NIEM
 * abstractions. Would choose between different versions of the API with a separate X-API-VERSION
 * header.
 */
@ResourceGroup(value = "Case Services")
@Produces(MediaType.APPLICATION_JSON)
public class CasesService {
  private final CaseSearchAPI delegate;
  private final EndpointReflection ef;

  public CasesService(Jurisdiction jurisdiction, CaseSearchAPI delegate) {
    this.delegate = delegate;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction.getName() + "/cases");
  }

  @GET
  @Path("/")
  public Response getAll() {
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(CasesService.class))))
        .build();
  }

  @GET
  @Path("/courts")
  public Response getCourts() {
    return delegate.getCourts();
  }

  @GET
  @Path("/courts/{court_id}")
  public Response getEndpointsUnderCourt(@PathParam("court_id") String courtId) {
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCourtMethods = new ArrayList<>();
    for (Method method : methods) {
      if (!method.getName().equals("getCourts") && !method.getName().equals("getAll")) {
        subCourtMethods.add(method);
      }
    }
    var retMap =
        ef.endPointsToMap(
            replacePathParam(
                ef.makeRestEndpoints(subCourtMethods, clazz), Map.of("court_id", courtId)));
    return Response.ok(retMap).build();
  }

  /**
   * Gets all possible cases associated with either a party's name or a docket number.
   *
   * <p>Should either provide the docker_number, business name, or all parts of a participant's
   * name.
   *
   * @return A list of cases.
   * @responseExample application/json classpath:examples/case_list_resp.json
   * @throws JsonProcessingException
   */
  @GET
  @Path("/courts/{court_id}/cases")
  @NeedsAuthorization
  public Response getCaseList(
      @Context SecurityContext security,
      @HeaderParam("X-API-VERSION") ReturnType apiVersion,
      @PathParam("court_id") String courtId,
      @QueryParam("docket_number") String docketId,
      @QueryParam("business_name") String businessName,
      @QueryParam("first_name") String firstName,
      @QueryParam("middle_name") String middleName,
      @QueryParam("last_name") String lastName)
      throws JsonProcessingException {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getCaseList");
    if (apiVersion == null) {
      apiVersion = ReturnType.LEGACY_XML;
    }
    EfspSecurityContext efspSecurity = (EfspSecurityContext) security;
    var creds = efspSecurity.getUserCreds();
    if (docketId != null) {
      return delegate.queryCases(courtId, docketId, creds, apiVersion);
    }

    if (firstName != null && lastName != null) {
      Name name = new Name(firstName, middleName, lastName);
      return delegate.queryCases(courtId, name, false, creds, apiVersion);
    }
    if (businessName != null) {
      return delegate.queryCases(courtId, new Name(businessName), false, creds, apiVersion);
    }
    return Response.status(400).entity("Pass in something to search by").build();
  }

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}")
  @NeedsAuthorization
  public Response getCase(
      @Context SecurityContext security,
      @HeaderParam("X-API-VERSION") ReturnType apiVersion,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getCase");
    if (apiVersion == null) {
      apiVersion = ReturnType.LEGACY_XML;
    }
    EfspSecurityContext efspSecurity = (EfspSecurityContext) security;
    var creds = efspSecurity.getUserCreds();
    return delegate.getCase(courtId, caseId, creds, apiVersion);
  }

  /**
   * Tyler says that Getting document isn't supported. This is here to make that clear to users.
   *
   * @param httpHeaders
   * @param courtId
   * @param caseId
   * @return
   */
  @SuppressWarnings("static-method")
  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/documents")
  @NeedsAuthorization
  public Response getDocument(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    return Response.status(405).build();
  }

  @GET
  @Path("/courts/{court_id}/service-contacts/{service_contact_id}/cases")
  @NeedsAuthorization
  public Response getServiceAttachCaseList(
      @Context SecurityContext security,
      @PathParam("court_id") String courtId,
      @PathParam("service_contact_id") String serviceId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceAttachCaseList");
    EfspSecurityContext efspSecurity = (EfspSecurityContext) security;
    var creds = efspSecurity.getUserCreds();
    return delegate.queryServiceAttachCases(courtId, serviceId, creds, ReturnType.LEGACY_XML);
  }

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information")
  @NeedsAuthorization
  public Response getServiceInformation(
      @Context SecurityContext security,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceInformation");
    EfspSecurityContext efspSecurity = (EfspSecurityContext) security;
    var creds = efspSecurity.getUserCreds();
    return delegate.getServiceInformation(courtId, caseId, creds, ReturnType.LEGACY_XML);
  }

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information-history")
  @NeedsAuthorization
  public Response getServiceInformationHistory(
      @Context SecurityContext security,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceInformationHistory");
    EfspSecurityContext efspSecurity = (EfspSecurityContext) security;
    var creds = efspSecurity.getUserCreds();
    return delegate.getServiceInformationHistory(courtId, caseId, creds, ReturnType.LEGACY_XML);
  }
}
