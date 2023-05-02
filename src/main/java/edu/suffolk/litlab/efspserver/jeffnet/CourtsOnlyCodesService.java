package edu.suffolk.litlab.efspserver.jeffnet;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.services.CodesService;
import edu.suffolk.litlab.efspserver.services.EndpointReflection;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Produces({MediaType.APPLICATION_JSON})
public class CourtsOnlyCodesService implements CodesService {
  private static Logger log = LoggerFactory.getLogger(CourtsOnlyCodesService.class);

  private final Map<String, String> courts; // map court code names to full names
  private final EndpointReflection ef;
  private final String jurisdiction;

  public CourtsOnlyCodesService(String jurisdiction, Map<String, String> courts) {
    this.jurisdiction = jurisdiction;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/codes");
    this.courts = courts;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    var retMap = ef.endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts")
  public Response getCourts(
      @Context HttpHeaders httpHeaders,
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileableOnly,
      @DefaultValue("false") @QueryParam("with_names") boolean withNames) {
    // Assume all fileable.
    if (withNames) {
      return Response.ok(
              courts.entrySet().stream()
                  .map(e -> new NameAndCode(e.getValue(), e.getKey()))
                  .collect(Collectors.toList()))
          .build();
    } else {
      return Response.ok(courts.keySet().stream().sorted().collect(Collectors.toList())).build();
    }
  }

  @GET
  @Path("/courts/{court_id}")
  public Response getCodesUnderCourt(@PathParam("court_id") String courtId) {
    var errResp = okayCourt(courtId);
    if (errResp.isPresent()) {
      log.info("Wrong court queried?: " + courtId + " in jurisdiction " + jurisdiction);
      return errResp.get();
    }
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCourtMethods = new ArrayList<>();
    for (Method method : methods) {
      if (method.getName().equals("getCourtLocationCodes")) {
        subCourtMethods.add(method);
      }
    }
    var retMap =
        ef.endPointsToMap(
            replacePathParam(
                ef.makeRestEndpoints(subCourtMethods, clazz), Map.of("court_id", courtId)));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts/{court_id}/codes")
  public Response getCourtLocationCodes(@PathParam("court_id") String courtId) {
    if (this.courts.containsKey(courtId)) {
      return Response.ok(
              Map.of("name", this.courts.get(courtId), "code", courtId, "efmType", "jeffnet"))
          .build();
    } else {
      log.info("Wrong court queried?: " + courtId + " in jurisdiction " + jurisdiction);
      return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
    }
  }

  private Optional<Response> okayCourt(String courtId) {
    if (this.courts.containsKey(courtId)) {
      return Optional.empty();
    } else {
      return Optional.of(
          Response.status(404).entity("\"Court " + courtId + " does not exist\"").build());
    }
  }
}
