package edu.suffolk.litlab.efsp.server.services.impl;

import static edu.suffolk.litlab.efsp.server.utils.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.server.services.CodesService;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection.Endpoint;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.FileableCourtType;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.CaseCategory;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.CaseType;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodeDatabase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueFilingCodesService extends CodesService {
  private static Logger log = LoggerFactory.getLogger(TrueFilingCodesService.class);
  private static final Set<String> underCourtMethodNames =
      Set.of(
          "getCourtLocationCodes",
          "getCategories",
          "getCaseTypes",
          "getFilingTypes",
          "getFilingStatuses",
          "getAllowedFileTypes",
          "getPartyTypes",
          "getCaseSubtypes",
          "getFilingComponents",
          "getDocumentTypes");

  private static final Set<String> underCaseTypeMethodNames = Set.of("getPartyTypes");

  private final Supplier<TFCodeDatabase> cdSupplier;
  private final EndpointReflection ef;

  public TrueFilingCodesService(Jurisdiction jurisdiction, Supplier<TFCodeDatabase> cdSupplier) {
    this.cdSupplier = cdSupplier;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction.getName() + "/codes");
  }

  @Override
  public Response getAll() {
    var retMap = ef.endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return cors(Response.ok(retMap));
  }

  @Override
  public Response getCourts(
      HttpHeaders httpHeaders, boolean fileable, String fileableType, boolean withNames) {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      FileableCourtType param;
      if (fileableType.isBlank()) {
        param = (fileable) ? FileableCourtType.INITIAL_OR_SUBSEQUENT : FileableCourtType.NONE;
      } else {
        param = FileableCourtType.valueOf(fileableType);
      }
      return cors(ServiceHelpers.getCourts(cd, param, withNames));
    } catch (SQLException ex) {
      return cors(Response.status(500).entity("SQLException on server!"));
    }
  }

  @Override
  public Response getCodesUnderCourt(String courtId) {
    var errResp = okayCourt(courtId);
    if (errResp.isPresent()) {
      return errResp.get();
    }

    Predicate<Method> underCourtName = m -> underCourtMethodNames.contains(m.getName());
    Set<Endpoint> endpoints = getEndpointsFromMethods(this.getClass(), underCourtName);
    endpoints.addAll(getEndpointsFromMethods(this.getClass().getSuperclass(), underCourtName));

    var retMap = ef.endPointsToMap(replacePathParam(endpoints, Map.of("court_id", courtId)));
    return cors(Response.ok(retMap));
  }

  @Override
  public Response getCourtLocationCodes(String courtId) {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      Optional<NameAndCode> info =
          cd.getLocationNames().stream().filter(nac -> nac.getCode().equals(courtId)).findFirst();
      if (info.isEmpty()) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      return cors(Response.ok(info.get()));
    } catch (SQLException ex) {
      return cors(Response.status(500).entity("SQLException on server!"));
    }
  }

  /**
   * Returns detailed into on a specific case type, as well as being a HATEOS endpoint (i.e. points
   * to other endpoints).
   */
  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}")
  public Response getCodesUnderCaseType(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      Optional<CaseType> maybeType = cd.getCaseTypeWith(courtId, UUID.fromString(caseTypeId));
      if (maybeType.isEmpty()) {
        return Response.status(404)
            .entity("\"Case type " + caseTypeId + " does not exist in court " + courtId + "\"")
            .build();
      }

      Predicate<Method> underCaseType = (m) -> underCaseTypeMethodNames.contains(m.getName());
      Set<Endpoint> endpoints = getEndpointsFromMethods(this.getClass(), underCaseType);
      endpoints.addAll(getEndpointsFromMethods(this.getClass().getSuperclass(), underCaseType));
      var retMap =
          new HashMap<String, Object>(
              ef.endPointsToMap(
                  replacePathParam(
                      endpoints, Map.of("court_id", courtId, "case_type_id", caseTypeId))));
      retMap.putAll(maybeType.get().toMap());
      return cors(Response.ok(retMap));
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}")
  public Response getCodesUnderFilingTypes(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCode)
      throws SQLException {
    return cors(Response.status(405));
  }

  //////////////  Search endpoints (i.e. info gathering across courts) //////////////////

  /** Enum that's used across the search endpoints. */
  public enum DesiredResult {
    /// If you want to return the original names of the codes being searched.
    NAMES,
    /// If you want to return the courts that have at least one code that matches the term.
    COURT_COVERAGE;

    public static DesiredResult parse(String resultStr) {
      if (resultStr == null || resultStr.isBlank()) {
        // Default to Names, as originally you could only search for names.
        return NAMES;
      }
      return DesiredResult.valueOf(resultStr.toUpperCase());
    }
  }

  /**
   * Finds categories in any court that match the given term.
   *
   * <p>If the "result" query parameter is set to "COURT_COVERAGE", instead returns all courts that
   * contain at least one case category that is matched by the term. Can be used to confirm that all
   * of the expected courts you want to file in contain a case category that you can use.
   *
   * <p>Used primarly for exploration and gaining a better understanding of jurisdiction naming
   * conventions. Likely shouldn't be used while a user is filing.
   */
  @GET
  @Path("/categories")
  public Response searchCategories(
      @QueryParam("search") String searchTerm, @QueryParam("result") String resultStr)
      throws SQLException {
    DesiredResult desiredResult = DesiredResult.parse(resultStr);
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return switch (desiredResult) {
        case DesiredResult.NAMES -> cors(Response.ok(cd.searchCaseCategory(searchTerm)));
        case DesiredResult.COURT_COVERAGE ->
            cors(Response.ok(cd.courtCoverageCaseCategory(searchTerm)));
      };
    }
  }

  @GET
  @Path("/categories/{retrieve_name}")
  public Response retrieveCategories(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrieveCaseCategoryByName(retrieveName)));
    }
  }

  /**
   * Finds case types in any court that match the given term.
   *
   * <p>If the "result" query parameter is set to "COURT_COVERAGE", instead returns all courts that
   * contain at least one case type that is matched by the term. Can be used to confirm that all of
   * the expected courts you want to file in contain a case type that you can use.
   *
   * <p>Used primarly for exploration and gaining a better understanding of jurisdiction naming
   * conventions. Likely shouldn't be used while a user is filing.
   */
  @GET
  @Path("/case_types")
  public Response searchCaseTypes(
      @QueryParam("search") String searchTerm, @QueryParam("result") String resultStr)
      throws SQLException {
    DesiredResult desiredResult = DesiredResult.parse(resultStr);
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return switch (desiredResult) {
        case DesiredResult.NAMES -> cors(Response.ok(cd.searchCaseType(searchTerm)));
        case DesiredResult.COURT_COVERAGE ->
            cors(Response.ok(cd.courtCoverageCaseType(searchTerm)));
      };
    }
  }

  @GET
  @Path("/case_types/{retrieve_name}")
  public Response retrieveCaseTypes(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrieveCaseTypeByName(retrieveName)));
    }
  }

  /**
   * Finds filings types in any court that match the given term.
   *
   * <p>If the "result" query parameter is set to "COURT_COVERAGE", instead returns all courts that
   * contain at least one filing type that is matched by the term. Can be used to confirm that all
   * of the expected courts you want to file in contain a filing type that you can use.
   *
   * <p>Used primarily for exploration and gaining a better understanding of jurisdiction naming
   * conventions. Likely shouldn't be used while a user is filing.
   */
  @GET
  @Path("/filing_types")
  public Response searchFilingTypes(
      @QueryParam("search") String searchTerm, @QueryParam("result") String resultStr)
      throws SQLException {
    throw new UnsupportedOperationException();
    /*
    DesiredResult desiredResult = DesiredResult.parse(resultStr);
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return switch (desiredResult) {
        case DesiredResult.NAMES -> cors(Response.ok(cd.searchFilingType(searchTerm)));
        case DesiredResult.COURT_COVERAGE ->
            cors(Response.ok(cd.courtCoverageFilingType(searchTerm)));
      };
    }
    */
  }

  @GET
  @Path("/filing_types/{retrieve_name}")
  public Response retrieveFilingTypes(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    throw new UnsupportedOperationException();
  }

  /**
   * Finds party types in any court that match the given term.
   *
   * <p>If the "result" query parameter is set to "COURT_COVERAGE", instead returns all courts that
   * contain at least one party type that is matched by the term. Can be used to confirm that all of
   * the expected courts you want to file in contain a party type that you can use.
   *
   * <p>NOTE: party types are usually tightly coupled to the type of case they are in, so a general
   * search like this might not be as useful.
   *
   * <p>Used primarly for exploration and gaining a better understanding of jurisdiction naming
   * conventions. Likely shouldn't be used while a user is filing.
   */
  @GET
  @Path("/party_types")
  public Response searchPartyTypes(
      @QueryParam("search") String searchTerm, @QueryParam("result") String resultStr)
      throws SQLException {
    throw new UnsupportedOperationException();
    /*
    DesiredResult desiredResult = DesiredResult.parse(resultStr);
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return switch (desiredResult) {
        case DesiredResult.NAMES -> cors(Response.ok(cd.searchPartyType(searchTerm)));
        case DesiredResult.COURT_COVERAGE ->
            cors(Response.ok(cd.courtCoveragePartyType(searchTerm)));
      };
    }
    */
  }

  @GET
  @Path("/party_types/{retrieve_name}")
  public Response retrievePartyTypes(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    throw new UnsupportedOperationException();
    /*
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrievePartyType(retrieveName)));
    }
    */
  }

  /**
   * Finds optional services in any court that match the given term.
   *
   * <p>If the "result" query parameter is set to "COURT_COVERAGE", instead returns all courts that
   * contain at least one optional service that is matched by the term. Can be used to confirm that
   * all of the expected courts you want to file in contain an optional service that you can use.
   *
   * <p>Used primarly for exploration and gaining a better understanding of jurisdiction naming
   * conventions. Likely shouldn't be used while a user is filing.
   */
  @GET
  @Path("/optional_services")
  public Response searchOptionalServices(
      @QueryParam("search") String searchTerm, @QueryParam("result") String resultStr)
      throws SQLException {
    return cors(Response.status(405));
  }

  @GET
  @Path("/optional_services/{retrieve_name}")
  public Response retrieveOptionalServices(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    return cors(Response.status(405));
  }

  ////////////// Core query APIs //////////////////

  @Override
  public Response getCategories(String courtId, boolean fileableOnly, String timing)
      throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      List<CaseCategory> categories = cd.getCaseCategories(courtId);
      return cors(Response.ok(categories));
    }
  }

  @Override
  public Response getCategoryByCode(String courtId, String catCode) throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      for (var cat : cd.getCaseCategories(courtId)) {
        if (cat.getCode().equals(catCode)) {
          return cors(Response.ok(cat));
        }
      }
      return cors(Response.ok(null));
    }
  }

  @Override
  public Response getCaseTypes(String courtId, String categoryId, String timing)
      throws SQLException {
    if (categoryId == null || categoryId.isBlank()) {
      return cors(
          Response.status(400)
              .entity(
                  "\"You need to limit the number of case types by providing a category_id: see"
                      + " /categories\""));
    }

    try (TFCodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      Optional<Boolean> isInitial = Optional.empty();
      if (timing == null || timing.isBlank()) {
        isInitial = Optional.empty();
      } else if (timing.equalsIgnoreCase("Initial")) {
        isInitial = Optional.of(true);
      } else if (timing.equalsIgnoreCase("Subsequent")) {
        isInitial = Optional.of(false);
      } else {
        log.warn("timing param expected to be initial / subsequent: was: {}", timing);
      }
      List<NameAndCode> caseTypes = cd.getCaseTypeNamesFor(courtId, categoryId, isInitial);

      return cors(Response.ok(caseTypes));
    }
  }

  @Override
  public Response getNameSuffixes(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getCaseSubtypes(String courtId, String caseTypeId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getServiceTypes(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getProcedureOrRemedies(String courtId, String categoryId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getFilingTypes(String courtId, String categoryId, String typeId, boolean initial)
      throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> filingTypes = cd.getDocumentTypes(courtId, typeId);

      return cors(Response.ok(filingTypes));
    }
  }

  @Override
  public Response getFilerTypes(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getDamageAmounts(String courtId, String categoryId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getAllPartyTypes(String courtId) throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> partyTypes = cd.getPartyTypeFor(courtId);
      return cors(Response.ok(partyTypes));
    }
  }

  @Override
  public Response getPartyTypeFromAll(String courtId, String partyTypeId) throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> partyTypes = cd.getPartyTypeFor(courtId);
      for (NameAndCode pt : partyTypes) {
        if (pt.code().equals(partyTypeId)) {
          return cors(Response.ok(pt));
        }
      }

      return cors(Response.status(404).entity("\"No such party type: " + partyTypeId + "\""));
    }
  }

  @Override
  public Response getPartyTypes(String courtId, String caseTypeId) throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<NameAndCode> partyTypes = cd.getPartyTypeFor(courtId);
      return cors(Response.ok(partyTypes));
    }
  }

  @Override
  public Response getPartyType(String courtId, String caseTypeId, String partyTypeId)
      throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<NameAndCode> partyTypes = cd.getPartyTypeFor(courtId);
      for (NameAndCode pt : partyTypes) {
        if (pt.code().equals(partyTypeId)) {
          return cors(Response.ok(pt));
        }
      }

      return cors(Response.status(404).entity("\"No such party type: " + partyTypeId + "\""));
    }
  }

  @Override
  @Deprecated
  public Response getCrossReferencesOld(String courtId, String caseTypeId) throws SQLException {
    return getCrossReferences(courtId, caseTypeId);
  }

  @Override
  public Response getCrossReferences(String courtId, String caseTypeId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getDocumentTypes(String courtId, String filingCodeId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getMotionTypes(String courtId, String filingCodeId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getAllowedFileTypes(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getFilingStatuses(String courtId) throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.getDocumentStatuses(courtId)));
    }
  }

  @Override
  public Response getFilingComponents(String courtId, String filingCodeId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getOptionalServices(String courtId, String filingCodeId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getStates(String courtId, String country) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getLanguages(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getDataFields(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getDataField(String courtId, String fieldName) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getOptionalService(String courtId, String optServCode) throws SQLException {
    return cors(Response.status(405));
  }

  @Override
  public Response getDisclaimerRequirements(String courtId) throws SQLException {
    return cors(Response.status(405));
  }

  private Optional<Response> okayCourt(String courtId) {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return okayCourt(cd, courtId);
    } catch (SQLException ex) {
      log.error("SQL Error when checking court", ex);
      return Optional.of(Response.status(500).entity("Error in server database").build());
    }
  }

  private static Optional<Response> okayCourt(TFCodeDatabase cd, String courtId) {
    if (!cd.getAllLocations().contains(courtId)) {
      return Optional.of(
          Response.status(404).entity("\"Court " + courtId + " does not exist\"").build());
    }
    return Optional.empty();
  }

  private Set<Endpoint> getEndpointsFromMethods(Class<?> clazz, Predicate<Method> condition) {
    List<Method> validMethods = new ArrayList<>();
    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
      if (condition.test(method)) {
        validMethods.add(method);
      }
    }
    return ef.makeRestEndpoints(validMethods, clazz);
  }
}
