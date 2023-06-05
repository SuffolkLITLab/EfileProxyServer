package edu.suffolk.litlab.efspserver.services;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * The endpoints for the court specific configurations that clients need to use to file properly.
 * "Codes" is short for genericodes, a XML standard that ECF uses to communicate these
 * configurations to EFSPs, and we use it to refer to any such court configurations.
 */
@Produces({MediaType.APPLICATION_JSON})
public abstract class CodesService {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public abstract Response getAll();

  @GET
  @Path("/courts")
  public abstract Response getCourts(
      @Context HttpHeaders httpHeaders,
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileable,
      @DefaultValue("false") @QueryParam("with_names") boolean withNames);

  @GET
  @Path("/courts/{court_id}")
  public abstract Response getCodesUnderCourt(@PathParam("court_id") String courtId);

  @GET
  @Path("/courts/{court_id}/codes")
  public abstract Response getCourtLocationCodes(@PathParam("court_id") String courtId);

  /**
   * Adds proper CORS headers to all responses to the codes API, which is public
   *
   * <p>See https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS and
   * https://stackoverflow.com/a/28996470/11416267.
   */
  protected static Response cors(Response.ResponseBuilder rb) {
    return rb.header("Access-Control-Allow-Origin", "*").build();
  }

  @OPTIONS
  @Path("{path : .*}")
  public Response options() {
    return Response.ok("")
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
        .header("Access-Control-Allow-Credentials", "true")
        .header("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD")
        .header("Access-Control-Max-Age", "1209600")
        .build();
  }
}
