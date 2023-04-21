package edu.suffolk.litlab.efspserver.services;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;

@Path("/api_user_settings")
@Produces({MediaType.APPLICATION_JSON})
public class ApiUserSettingsService {
  private static Logger log =
    LoggerFactory.getLogger(ApiUserSettingsService.class);
  
  private final DataSource ds;

  public ApiUserSettingsService(DataSource ds) {
    this.ds = ds;
  }

  @GET
  @Path("/")
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("");
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(ApiUserSettingsService.class)))).build();
  }

  @GET
  @Path("/name")
  public Response getName(@Context HttpHeaders httpHeaders) {
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      return Response.ok("\"" + atRest.get().serverName + "\"").build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Path("/serverid")
  public Response getServerId(@Context HttpHeaders httpHeaders) {
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      return Response.ok("\"" + atRest.get().serverId + "\"").build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @POST
  @Path("/name")
  public Response changeName(@Context HttpHeaders httpHeaders, String newName) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      ld.updateServerName(atRest.get(), apiKey, newName);
      return Response.ok("\"" + newName + "\"").build();
    } catch (SQLException ex) {
      return Response.status(500).build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @Path("/logs")
  public Response getLogs(@Context HttpHeaders httpHeaders) {
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
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
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }
}
