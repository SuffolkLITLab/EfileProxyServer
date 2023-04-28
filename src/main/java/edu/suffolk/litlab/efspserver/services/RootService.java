package edu.suffolk.litlab.efspserver.services;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Path("/")
public class RootService {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("");
    return Response.ok(
            ef.getClassPaths(
                List.of(
                    AuthenticationService.class,
                    JurisdictionSwitch.class,
                    MessageSettingsService.class,
                    ApiUserSettingsService.class)))
        .build();
  }

  @GET
  @Path("/about")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVersionInfo() {
    final var properties = new Properties();
    try (var is = RootService.class.getResourceAsStream("/version.properties")) {
      properties.load(is);
      return Response.ok("{\"version\": \"" + properties.getProperty("version") + "\"}").build();
    } catch (IOException e) {
      return Response.status(500).entity("Could not load version info").build();
    }
  }
}
