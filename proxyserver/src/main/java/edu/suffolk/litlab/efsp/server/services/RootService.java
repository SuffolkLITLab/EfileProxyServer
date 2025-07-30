package edu.suffolk.litlab.efsp.server.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
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
    var endPoints =
        ef.getClassPaths(
            List.of(
                AuthenticationService.class,
                JurisdictionSwitch.class,
                MessageSettingsService.class,
                ApiUserSettingsService.class));
    endPoints.put("getVersionInfo", ServiceHelpers.EXTERNAL_URL + "/about");
    return Response.ok(endPoints).build();
  }

  @GET
  @Path("/about")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getVersionInfo() {
    final var properties = new Properties();
    ObjectMapper mapper = new ObjectMapper();
    try (var is = RootService.class.getResourceAsStream("/version.properties")) {
      properties.load(is);
      ObjectNode rootNode = mapper.createObjectNode();
      rootNode.put("version", properties.getProperty("version"));
      String commit = properties.getProperty("commit");
      if (commit != null && !commit.isBlank()) {
        rootNode.put("commit", commit);
      }
      return Response.ok(mapper.writer().writeValueAsString(rootNode)).build();
    } catch (IOException e) {
      return Response.status(500).entity("Could not load version info").build();
    }
  }
}
