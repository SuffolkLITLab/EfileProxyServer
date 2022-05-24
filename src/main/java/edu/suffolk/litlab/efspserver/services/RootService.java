package edu.suffolk.litlab.efspserver.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class RootService {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("");
    return Response.ok(ef.getClassPaths(List.of(
        AuthenticationService.class,
        JurisdictionSwitch.class,
        MessageSettingsService.class
    ))).build();
  }
}
