package edu.suffolk.litlab.efsp.server.services;

import static edu.suffolk.litlab.efsp.server.utils.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.Disclaimer;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FileType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilerType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.OptionalServiceCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.ServiceCodeType;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection.Endpoint;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
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
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcfCodesService extends CodesService {
  private static Logger log = LoggerFactory.getLogger(EcfCodesService.class);
  private static final Set<String> underCourtMethodNames =
      Set.of(
          "getCourtLocationCodes",
          "getCategories",
          "getCaseTypes",
          "getNameSuffixes",
          "getServiceTypes",
          "getDataFields",
          "getProcedureOrRemedies",
          "getFilingTypes",
          "getDamageAmounts",
          "getDataField",
          "getDisclaimerRequirements",
          "getLanguages",
          "getStates",
          "getFilingStatuses",
          "getFilerTypes",
          "getAllowedFileTypes",
          "getPartyTypes",
          "getCaseSubtypes",
          "getCrossReferences",
          "getOptionalServices",
          "getOptionalService",
          "getFilingComponents",
          "getDocumentTypes",
          "getMotionTypes");

  private static final Set<String> underCaseTypeMethodNames =
      Set.of("getCaseSubtypes", "getPartyTypes", "getCrossReferences");

  private static final Set<String> underFilingCodeMethodNames =
      Set.of("getOptionalServices", "getFilingComponents", "getDocumentTypes", "getMotionTypes");

  private final Supplier<CodeDatabase> cdSupplier;
  private final EndpointReflection ef;

  public EcfCodesService(String jurisdiction, Supplier<CodeDatabase> cdSupplier) {
    this.cdSupplier = cdSupplier;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/codes");
  }

  @Override
  public Response getAll() {
    var retMap = ef.endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return cors(Response.ok(retMap));
  }

  @Override
  public Response getCourts(HttpHeaders httpHeaders, boolean fileableOnly, boolean withNames) {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(ServiceHelpers.getCourts(cd, fileableOnly, withNames));
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
    try (CodeDatabase cd = cdSupplier.get()) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
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
    try (CodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      Optional<CaseType> maybeType = cd.getCaseTypeWith(courtId, caseTypeId);
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
    try (CodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      var maybeCode = cd.getFilingTypeWith(courtId, filingCode);
      if (maybeCode.isEmpty()) {
        return cors(
            Response.status(404)
                .entity(
                    "\"Filing code " + filingCode + " in court " + courtId + " does not exist\""));
      }
      Predicate<Method> underFilingCode = (m) -> underFilingCodeMethodNames.contains(m.getName());
      Set<Endpoint> endpoints = getEndpointsFromMethods(this.getClass(), underFilingCode);
      endpoints.addAll(getEndpointsFromMethods(this.getClass().getSuperclass(), underFilingCode));

      var retMap =
          new HashMap<String, Object>(
              ef.endPointsToMap(
                  replacePathParam(
                      endpoints, Map.of("court_id", courtId, "filing_code_id", filingCode))));
      retMap.putAll(maybeCode.get().toMap());
      return cors(Response.ok(retMap));
    }
  }

  //////////////  Search endpoints (i.e. info gathering across courts) //////////////////

  @GET
  @Path("/categories")
  public Response searchCategories(@QueryParam("search") String searchTerm) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.searchCaseCategory(searchTerm)));
    }
  }

  @GET
  @Path("/categories/{retrieve_name}")
  public Response retrieveCategories(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrieveCaseCategoryByName(retrieveName)));
    }
  }

  @GET
  @Path("/case_types")
  public Response searchCaseTypes(@QueryParam("search") String searchTerm) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.searchCaseType(searchTerm)));
    }
  }

  @GET
  @Path("/case_types/{retrieve_name}")
  public Response retrieveCaseTypes(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrieveCaseTypeByName(retrieveName)));
    }
  }

  @GET
  @Path("/filing_types")
  public Response searchFilingTypes(@QueryParam("search") String searchTerm) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.searchFilingType(searchTerm)));
    }
  }

  @GET
  @Path("/filing_types/{retrieve_name}")
  public Response retrieveFilingTypes(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrieveFilingTypeByName(retrieveName)));
    }
  }

  @GET
  @Path("/party_types")
  public Response searchPartyTypes(@QueryParam("search") String searchTerm) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.searchPartyType(searchTerm)));
    }
  }

  @GET
  @Path("/party_types/{retrieve_name}")
  public Response retrievePartyTypes(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrievePartyType(retrieveName)));
    }
  }

  @GET
  @Path("/optional_services")
  public Response searchOptionalServices(@QueryParam("search") String searchTerm)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.searchOptionalServices(searchTerm)));
    }
  }

  @GET
  @Path("/optional_services/{retrieve_name}")
  public Response retrieveOptionalServices(@PathParam("retrieve_name") String retrieveName)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cors(Response.ok(cd.retrieveOptionalServices(retrieveName)));
    }
  }

  ////////////// Core query APIs //////////////////

  @Override
  public Response getCategories(String courtId, boolean fileableOnly, String timing)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      if (!fileableOnly) {
        List<CaseCategory> categories = cd.getCaseCategoriesFor(courtId);
        return cors(Response.ok(categories));
      }

      Optional<Boolean> isInitial = Optional.empty();
      log.info("Timing input: " + timing);
      if (timing == null || timing.isBlank()) {
        isInitial = Optional.empty();
      } else if (timing.equalsIgnoreCase("Initial")) {
        isInitial = Optional.of(true);
      } else if (timing.equalsIgnoreCase("Subsequent")) {
        isInitial = Optional.of(false);
      } else {
        log.warn("timing param expected to be initial / subsequent: was: " + timing);
      }
      log.info("Timing pass along: " + isInitial);
      List<CaseCategory> categories = cd.getFilableCaseCategories(courtId, isInitial);
      return cors(Response.ok(categories));
    }
  }

  @Override
  public Response getCategoryByCode(String courtId, String catCode) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      var errResp = okayCourt(cd, courtId);
      if (errResp.isPresent()) {
        return errResp.get();
      }
      return cors(Response.ok(cd.getCaseCategoryWithCode(courtId, catCode).orElse(null)));
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

    try (CodeDatabase cd = cdSupplier.get()) {
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
        log.warn("timing param expected to be initial / subsequent: was: " + timing);
      }
      List<CaseType> caseTypes = cd.getCaseTypesFor(courtId, categoryId, isInitial);

      return cors(Response.ok(caseTypes));
    }
  }

  @Override
  public Response getNameSuffixes(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<NameAndCode> suffixes = cd.getNameSuffixes(courtId);
      return cors(Response.ok(suffixes));
    }
  }

  @Override
  public Response getCaseSubtypes(String courtId, String caseTypeId) throws SQLException {

    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> caseSubtypes = cd.getCaseSubtypesFor(courtId, caseTypeId);

      return cors(Response.ok(caseSubtypes));
    }
  }

  @Override
  public Response getServiceTypes(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<ServiceCodeType> types = cd.getServiceTypes(courtId);
      return cors(Response.ok(types));
    }
  }

  @Override
  public Response getProcedureOrRemedies(String courtId, String categoryId) throws SQLException {

    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> procedureRemedies = cd.getProcedureOrRemedy(courtId, categoryId);

      return cors(Response.ok(procedureRemedies));
    }
  }

  @Override
  public Response getFilingTypes(String courtId, String categoryId, String typeId, boolean initial)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<FilingCode> filingTypes = cd.getFilingType(courtId, categoryId, typeId, initial);

      return cors(Response.ok(filingTypes));
    }
  }

  @Override
  public Response getFilerTypes(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<FilerType> filerTypes = cd.getFilerTypes(courtId);
      return cors(Response.ok(filerTypes));
    }
  }

  @Override
  public Response getDamageAmounts(String courtId, String categoryId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> damageAmounts = cd.getDamageAmount(courtId, categoryId);

      return cors(Response.ok(damageAmounts));
    }
  }

  @Override
  public Response getAllPartyTypes(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, null);

      return cors(Response.ok(partyTypes));
    }
  }

  @Override
  public Response getPartyTypeFromAll(String courtId, String partyTypeId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, null);
      for (PartyType pt : partyTypes) {
        if (pt.code.equals(partyTypeId)) {
          return cors(Response.ok(pt));
        }
      }

      return cors(Response.status(404).entity("\"No such party type: " + partyTypeId + "\""));
    }
  }

  @Override
  public Response getPartyTypes(String courtId, String caseTypeId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, caseTypeId);

      return cors(Response.ok(partyTypes));
    }
  }

  @Override
  public Response getPartyType(String courtId, String caseTypeId, String partyTypeId)
      throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, caseTypeId);
      for (PartyType pt : partyTypes) {
        if (pt.code.equals(partyTypeId)) {
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
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<CrossReference> refs = cd.getCrossReference(courtId, caseTypeId);
      return cors(Response.ok(refs));
    }
  }

  @Override
  public Response getDocumentTypes(String courtId, String filingCodeId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<DocumentTypeTableRow> documentTypes = cd.getDocumentTypes(courtId, filingCodeId);

      return Response.ok(documentTypes).build();
    }
  }

  @Override
  public Response getMotionTypes(String courtId, String filingCodeId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<NameAndCode> motionTypes = cd.getMotionTypes(courtId, filingCodeId);

      return Response.ok(motionTypes).build();
    }
  }

  @Override
  public Response getAllowedFileTypes(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<FileType> fileTypes = cd.getAllowedFileTypes(courtId);

      return Response.ok(fileTypes).build();
    }
  }

  @Override
  public Response getFilingStatuses(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<NameAndCode> statuses = cd.getFilingStatuses(courtId);
      return Response.ok(statuses).build();
    }
  }

  @Override
  public Response getFilingComponents(String courtId, String filingCodeId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<FilingComponent> filingComponents = cd.getFilingComponents(courtId, filingCodeId);

      return Response.ok(filingComponents).build();
    }
  }

  @Override
  public Response getOptionalServices(String courtId, String filingCodeId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }

      List<OptionalServiceCode> optionalServiceCode = cd.getOptionalServices(courtId, filingCodeId);
      return Response.ok(optionalServiceCode).build();
    }
  }

  @Override
  public Response getStates(String courtId, String country) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      List<String> stateCodes = cd.getStateCodes(courtId, country);

      return cors(Response.ok(stateCodes));
    }
  }

  @Override
  public Response getLanguages(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<String> languages = cd.getLanguageNames(courtId);

      return cors(Response.ok(languages));
    }
  }

  @Override
  public Response getDataFields(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      var datafields = cd.getDataFieldNames(courtId);

      return cors(Response.ok(datafields));
    }
  }

  @Override
  // TODO(brycew-later): consider a bulk way of getting multiple codes, will be
  // used heavily in the DA UI
  public Response getDataField(String courtId, String fieldName) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      var maybeErr = okayCourt(cd, courtId);
      if (maybeErr.isPresent()) {
        return maybeErr.get();
      }
      return cors(Response.ok(cd.getDataField(courtId, fieldName)));
    }
  }

  @Override
  public Response getOptionalService(String courtId, String optServCode) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      var maybeErr = okayCourt(cd, courtId);
      if (maybeErr.isPresent()) {
        return maybeErr.get();
      }
      return cors(Response.ok(cd.getOptionalServicesByCode(courtId, optServCode)));
    }
  }

  @Override
  public Response getDisclaimerRequirements(String courtId) throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);

      return cors(Response.ok(disclaimers));
    }
  }

  private Optional<Response> okayCourt(String courtId) {
    try (CodeDatabase cd = cdSupplier.get()) {
      return okayCourt(cd, courtId);
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.of(Response.status(500).entity("Error in server database").build());
    }
  }

  private static Optional<Response> okayCourt(CodeDatabase cd, String courtId) {
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
