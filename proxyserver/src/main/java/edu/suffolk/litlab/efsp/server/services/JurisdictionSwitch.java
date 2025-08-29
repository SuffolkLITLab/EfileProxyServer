package edu.suffolk.litlab.efsp.server.services;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Map;

@Path("/jurisdictions")
public class JurisdictionSwitch {

  private final Map<Jurisdiction, JurisdictionServiceHandle> jurisdictions;

  public JurisdictionSwitch(Map<Jurisdiction, JurisdictionServiceHandle> jurisdictions) {
    this.jurisdictions = jurisdictions;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("/jurisdictions");
    return Response.ok(
            ef.pathParamsToMap(jurisdictions.keySet().stream().map(Jurisdiction::getName)))
        .build();
  }

  /**
   * Chooses the specific jurisdiction (i.e. US State or other court system) that you are filing
   * into.
   *
   * @param jurisdictionId the full name of the state, usually lower case ("massachusetts", or
   *     "illinois").
   * @return
   */
  @Path("{jurisdiction_id}")
  public JurisdictionServiceHandle getJurisdictionService(
      @PathParam("jurisdiction_id") String jurisdictionId) {
    Jurisdiction jurisdiction = Jurisdiction.parse(jurisdictionId);
    return jurisdictions.get(jurisdiction);
  }
}
