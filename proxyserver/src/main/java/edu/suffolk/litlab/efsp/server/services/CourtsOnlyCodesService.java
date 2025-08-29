package edu.suffolk.litlab.efsp.server.services;

import static edu.suffolk.litlab.efsp.server.utils.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.Method;
import java.sql.SQLException;
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
  private final Jurisdiction jurisdiction;

  public CourtsOnlyCodesService(Jurisdiction jurisdiction, Map<String, String> courts) {
    this.jurisdiction = jurisdiction;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction.getName() + "/codes");
    this.courts = courts;
  }

  public Response getAll() {
    var retMap = ef.endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return cors(Response.ok(retMap));
  }

  public Response getCourts(HttpHeaders httpHeaders, boolean fileableOnly, boolean withNames) {
    // Assume all fileable.
    if (withNames) {
      return cors(
          Response.ok(
              courts.entrySet().stream()
                  .map(e -> new NameAndCode(e.getValue(), e.getKey()))
                  .collect(Collectors.toList())));
    } else {
      return cors(Response.ok(courts.keySet().stream().sorted().collect(Collectors.toList())));
    }
  }

  public Response getCodesUnderCourt(String courtId) {
    var errResp = okayCourt(courtId);
    if (errResp.isPresent()) {
      log.info("Wrong court queried?: {} in jurisdiction {}", courtId, jurisdiction);
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
      return cors(
          Response.ok(
              Map.of("name", this.courts.get(courtId), "code", courtId, "efmType", "jeffnet")));
    } else {
      log.info("Wrong court queried?: {} in jurisdiction {}", courtId, jurisdiction);
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

  @Override
  public Response getCategories(String courtId, boolean fileableOnly, String timing)
      throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCategories'");
  }

  @Override
  public Response getCategoryByCode(String courtId, String catCode) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCategoryByCode'");
  }

  @Override
  public Response getCaseTypes(String courtId, String categoryId, String timing)
      throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCaseTypes'");
  }

  @Override
  public Response getNameSuffixes(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getNameSuffixes'");
  }

  @Override
  public Response getCaseSubtypes(String courtId, String caseTypeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCaseSubtypes'");
  }

  @Override
  public Response getServiceTypes(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getServiceTypes'");
  }

  @Override
  public Response getProcedureOrRemedies(String courtId, String categoryId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getProcedureOrRemedies'");
  }

  @Override
  public Response getFilingTypes(String courtId, String categoryId, String typeId, boolean initial)
      throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingTypes'");
  }

  @Override
  public Response getFilerTypes(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilerTypes'");
  }

  @Override
  public Response getDamageAmounts(String courtId, String categoryId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDamageAmounts'");
  }

  @Override
  public Response getAllPartyTypes(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllPartyTypes'");
  }

  @Override
  public Response getPartyTypeFromAll(String courtId, String partyTypeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPartyTypeFromAll'");
  }

  @Override
  public Response getPartyTypes(String courtId, String caseTypeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPartyTypes'");
  }

  @Override
  public Response getPartyType(String courtId, String caseTypeId, String partyTypeId)
      throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getPartyType'");
  }

  @Override
  public Response getCrossReferencesOld(String courtId, String caseTypeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCrossReferencesOld'");
  }

  @Override
  public Response getCrossReferences(String courtId, String caseTypeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCrossReferences'");
  }

  @Override
  public Response getDocumentTypes(String courtId, String filingCodeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDocumentTypes'");
  }

  @Override
  public Response getMotionTypes(String courtId, String filingCodeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getMotionTypes'");
  }

  @Override
  public Response getAllowedFileTypes(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllowedFileTypes'");
  }

  @Override
  public Response getFilingStatuses(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingStatuses'");
  }

  @Override
  public Response getFilingComponents(String courtId, String filingCodeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingComponents'");
  }

  @Override
  public Response getOptionalServices(String courtId, String filingCodeId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOptionalServices'");
  }

  @Override
  public Response getStates(String courtId, String country) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getStates'");
  }

  @Override
  public Response getLanguages(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getLanguages'");
  }

  @Override
  public Response getDataFields(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDataFields'");
  }

  @Override
  public Response getDataField(String courtId, String fieldName) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDataField'");
  }

  @Override
  public Response getOptionalService(String courtId, String optServCode) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getOptionalService'");
  }

  @Override
  public Response getDisclaimerRequirements(String courtId) throws SQLException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDisclaimerRequirements'");
  }
}
