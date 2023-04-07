package edu.suffolk.litlab.efspserver.services;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

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
        MessageSettingsService.class,
        ApiUserSettingsService.class
    ))).build();
  }

  @GET
  @Path("/about")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVersionInfo() {
    final var properties = new Properties();
    try {
      properties.load(RootService.class.getResourceAsStream("/version.properties"));
      return Response.ok("{\"version\": \"" + properties.getProperty("version") + "\"}").build();
    } catch (IOException e) {
      return Response.status(500).entity("Could not load version info").build();
    }
  }
}
