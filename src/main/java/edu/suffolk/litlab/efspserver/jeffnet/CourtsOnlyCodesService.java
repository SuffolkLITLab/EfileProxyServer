package edu.suffolk.litlab.efspserver.jeffnet;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efspserver.services.CodesService;
import edu.suffolk.litlab.efspserver.services.EndpointReflection;
import edu.suffolk.litlab.efspserver.tyler.codes.NameAndCode;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourtsOnlyCodesService extends CodesService {
  private static Logger log = LoggerFactory.getLogger(CourtsOnlyCodesService.class);

  private final Map<String, String> courts; // map court code names to full names
  private final EndpointReflection ef;
  private final String jurisdiction;

  public CourtsOnlyCodesService(String jurisdiction, Map<String, String> courts) {
    this.jurisdiction = jurisdiction;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/codes");
    this.courts = courts;
  }

  public Response getAll() {
    var retMap = ef.endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return cors(Response.ok(retMap));
  }

  public Response getCourts(
      HttpHeaders httpHeaders, boolean fileableOnly, boolean withNames) {
    // Assume all fileable.
    if (withNames) {
      return cors(Response.ok(
              courts.entrySet().stream().sorted()
                  .map(e -> new NameAndCode(e.getValue(), e.getKey()))
                  .collect(Collectors.toList())));
    } else {
      return cors(Response.ok(courts.keySet().stream().sorted().collect(Collectors.toList())));
    }
  }

  public Response getCodesUnderCourt(String courtId) {
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
    return cors(Response.ok(retMap));
  }

  public Response getCourtLocationCodes(String courtId) {
    if (this.courts.containsKey(courtId)) {
      return cors(Response.ok(
              Map.of("name", this.courts.get(courtId), "code", courtId, "efmType", "jeffnet")));
    } else {
      log.info("Wrong court queried?: " + courtId + " in jurisdiction " + jurisdiction);
      return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
    }
  }

  private Optional<Response> okayCourt(String courtId) {
    if (this.courts.containsKey(courtId)) {
      return Optional.empty();
    } else {
      return Optional.of(
          cors(Response.status(404).entity("\"Court " + courtId + " does not exist\"")));
    }
  }
}
