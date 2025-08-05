package edu.suffolk.litlab.efsp.server.services;

import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.NeedsAuthorization;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Path("/api_user_settings")
@Produces({MediaType.APPLICATION_JSON})
public class ApiUserSettingsService {
  private final Supplier<LoginDatabase> ldSupplier;

  public ApiUserSettingsService(Supplier<LoginDatabase> ldSupplier) {
    this.ldSupplier = ldSupplier;
  }

  @GET
  @Path("/")
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("");
    return Response.ok(
            ef.endPointsToMap(ef.findRESTEndpoints(List.of(ApiUserSettingsService.class))))
        .build();
  }

  @GET
  @Path("/name")
  @NeedsAuthorization
  public Response getName(@Context HttpHeaders httpHeaders) {
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      return Response.ok("\"" + atRest.get().serverName + "\"").build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    }
  }

  @GET
  @Path("/serverid")
  @NeedsAuthorization
  public Response getServerId(@Context HttpHeaders httpHeaders) {
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      return Response.ok("\"" + atRest.get().serverId + "\"").build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    }
  }

  @POST
  @Path("/name")
  @NeedsAuthorization
  public Response changeName(@Context HttpHeaders httpHeaders, String newName) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      ld.updateServerName(atRest.get(), apiKey, newName);
      return Response.ok("\"" + newName + "\"").build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @Path("/logs")
  @NeedsAuthorization
  public Response getLogs(@Context HttpHeaders httpHeaders) {
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      File f = new File(atRest.get().serverId.toString() + ".log");
      if (!f.exists()) {
        return Response.status(204).build();
      }
      return Response.ok(f, MediaType.APPLICATION_OCTET_STREAM)
          .header("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"")
          .build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    }
  }
}
