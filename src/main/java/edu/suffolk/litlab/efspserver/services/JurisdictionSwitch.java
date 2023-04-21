package edu.suffolk.litlab.efspserver.services;

import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jurisdictions")
public class JurisdictionSwitch {

  private final Map<String, JurisdictionServiceHandle> jurisdictions;

  public JurisdictionSwitch(Map<String, JurisdictionServiceHandle> jurisdictions) {
    this.jurisdictions = jurisdictions;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("/jurisdictions");
    return Response.ok(ef.pathParamsToMap(jurisdictions.keySet().stream())).build();
  }

  @Path("{jurisdiction_id}")
  public JurisdictionServiceHandle getJurisdictionService(
      @PathParam("jurisdiction_id") String jurisdictionId) {
    return jurisdictions.get(jurisdictionId);
  }
}
