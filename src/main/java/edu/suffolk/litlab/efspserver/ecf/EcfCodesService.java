package edu.suffolk.litlab.efspserver.ecf;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.CrossReference;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.codes.Disclaimer;
import edu.suffolk.litlab.efspserver.codes.DocumentTypeTableRow;
import edu.suffolk.litlab.efspserver.codes.FileType;
import edu.suffolk.litlab.efspserver.codes.FilingCode;
import edu.suffolk.litlab.efspserver.codes.FilingComponent;
import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.codes.OptionalServiceCode;
import edu.suffolk.litlab.efspserver.codes.PartyType;
import edu.suffolk.litlab.efspserver.codes.ServiceCodeType;
import edu.suffolk.litlab.efspserver.services.CodesService;
import edu.suffolk.litlab.efspserver.services.EndpointReflection;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
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
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Produces({MediaType.APPLICATION_JSON})
public class EcfCodesService implements CodesService {
  private static Logger log = LoggerFactory.getLogger(EcfCodesService.class);
  private static final Set<String> underCourtMethodNames =
      Set.of(
          "getCourtLocationCodes",
          "getCategories",
          "getCaseTypes",
          "getNameSuffixes",
          "getServiceTypes",
          "getProcedureOrRemedies",
          "getFilingTypes",
          "getDamageAmounts",
          "getDataField",
          "getDisclaimerRequirements",
          "getLanguages",
          "getStates",
          "getFilingStatuses",
          "getAllowedFileTypes",
          "getPartyTypes",
          "getCaseSubtypes",
          "getCrossReferences",
          "getOptionalServices",
          "getFilingComponents",
          "getDocumentTypes",
          "getMotionTypes");

  private static final Set<String> underCaseTypeMethodNames =
      Set.of("getCaseSubtypes", "getPartyTypes", "getCrossReferences");

  private static final Set<String> underFilingCodeMethodNames =
      Set.of("getOptionalServices", "getFilingComponents", "getDocumentTypes", "getMotionTypes");

  private final DataSource ds;
  private final String jurisdiction;
  private final String env;
  private final EndpointReflection ef;

  public EcfCodesService(String jurisdiction, String env, DataSource ds) {
    this.jurisdiction = jurisdiction;
    this.env = env;
    this.ds = ds;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/codes");
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    var retMap = ef.endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return cors(Response.ok(retMap));
  }

  @GET
  @Path("/courts")
  public Response getCourts(
      @Context HttpHeaders httpHeaders,
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileableOnly,
      @DefaultValue("false") @QueryParam("with_names") boolean withNames) {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      return cors(ServiceHelpers.getCourts(cd, fileableOnly, withNames));
    } catch (SQLException ex) {
      return cors(Response.status(500).entity("SQLException on server!"));
    }
  }

  @GET
  @Path("/courts/{court_id}")
  public Response getCodesUnderCourt(@PathParam("court_id") String courtId) {
    var errResp = okayCourt(courtId);
    if (errResp.isPresent()) {
      return errResp.get();
    }
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCourtMethods = new ArrayList<>();
    for (Method method : methods) {
      if (underCourtMethodNames.contains(method.getName())) {
        subCourtMethods.add(method);
      }
    }
    var retMap =
        ef.endPointsToMap(
            replacePathParam(
                ef.makeRestEndpoints(subCourtMethods, clazz), Map.of("court_id", courtId)));
    return cors(Response.ok(retMap));
  }

  @GET
  @Path("/courts/{court_id}/codes")
  public Response getCourtLocationCodes(@PathParam("court_id") String courtId) {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
      if (info.isEmpty()) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      return cors(Response.ok(info.get()));
    } catch (SQLException ex) {
      return cors(Response.status(500).entity("SQLException on server!"));
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}")
  public Response getCodesUnderCaseType(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId) {
    var errResp = okayCourt(courtId);
    if (errResp.isPresent()) {
      return errResp.get();
    }
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCaseMethods = new ArrayList<>();
    for (Method method : methods) {
      if (underCaseTypeMethodNames.contains(method.getName())) {
        subCaseMethods.add(method);
      }
    }
    var retMap =
        ef.endPointsToMap(
            replacePathParam(
                ef.makeRestEndpoints(subCaseMethods, clazz),
                Map.of("court_id", courtId, "case_type_id", caseTypeId)));
    return cors(Response.ok(retMap));
  }

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}")
  public Response getCodesUnderFilingTypes(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCode)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
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
      Class<?> clazz = this.getClass();
      Method[] methods = clazz.getMethods();
      List<Method> subCaseMethods = new ArrayList<>();
      for (Method method : methods) {
        if (underFilingCodeMethodNames.contains(method.getName())) {
          subCaseMethods.add(method);
        }
      }

      var retMap =
          new HashMap<String, Object>(
              ef.endPointsToMap(
                  replacePathParam(
                      ef.makeRestEndpoints(subCaseMethods, clazz),
                      Map.of("court_id", courtId, "filing_code_id", filingCode))));
      retMap.putAll(maybeCode.get().toMap());
      return cors(Response.ok(retMap));
    }
  }

  @GET
  @Path("/courts/{court_id}/categories")
  public Response getCategories(
      @PathParam("court_id") String courtId,
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileableOnly,
      @QueryParam("timing") String timing)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
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

  @GET
  @Path("/courts/{court_id}/case_types")
  public Response getCaseTypes(
      @PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId,
      @QueryParam("timing") String timing)
      throws SQLException {

    if (categoryId == null || categoryId.isBlank()) {
      return cors(
          Response.status(400)
              .entity(
                  "\"You need to limit the number of case types by providing a category_id: see"
                      + " /categories\""));
    }

    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
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

  @GET
  @Path("/courts/{court_id}/name_suffixes")
  public Response getNameSuffixes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<NameAndCode> suffixes = cd.getNameSuffixes(courtId);
      return cors(Response.ok(suffixes));
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/case_subtypes")
  public Response getCaseSubtypes(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> caseSubtypes = cd.getCaseSubtypesFor(courtId, caseTypeId);

      return cors(Response.ok(caseSubtypes));
    }
  }

  @GET
  @Path("/courts/{court_id}/service_types")
  public Response getServiceTypes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<ServiceCodeType> types = cd.getServiceTypes(courtId);
      return cors(Response.ok(types));
    }
  }

  @GET
  @Path("/courts/{court_id}/procedures_or_remedies")
  public Response getProcedureOrRemedies(
      @PathParam("court_id") String courtId, @QueryParam("category_id") String categoryId)
      throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> procedureRemedies = cd.getProcedureOrRemedy(courtId, categoryId);

      return cors(Response.ok(procedureRemedies));
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types")
  public Response getFilingTypes(
      @PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId,
      @QueryParam("type_id") String typeId,
      @QueryParam("initial") boolean initial)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {

      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<FilingCode> filingTypes = cd.getFilingType(courtId, categoryId, typeId, initial);

      return cors(Response.ok(filingTypes));
    }
  }

  @GET
  @Path("/courts/{court_id}/damage_amounts")
  public Response getDamageAmounts(
      @PathParam("court_id") String courtId, @QueryParam("category_id") String categoryId)
      throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<NameAndCode> damageAmounts = cd.getDamageAmount(courtId, categoryId);

      return cors(Response.ok(damageAmounts));
    }
  }

  /**
   * Used for when you need to populate the party types names for a case search or something similar
   *
   * @param courtId
   * @return
   * @throws SQLException
   */
  @GET
  @Path("/courts/{court_id}/party_types")
  public Response getAllPartyTypes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, null);

      return cors(Response.ok(partyTypes));
    }
  }

  @GET
  @Path("/courts/{court_id}/party_types/{party_type_id}")
  public Response getPartyTypeFromAll(
      @PathParam("court_id") String courtId, @PathParam("party_type_id") String partyTypeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
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

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/party_types")
  public Response getPartyTypes(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }
      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, caseTypeId);

      return cors(Response.ok(partyTypes));
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/party_types/{party_type_id}")
  public Response getPartyType(
      @PathParam("court_id") String courtId,
      @PathParam("case_type_id") String caseTypeId,
      @PathParam("party_type_id") String partyTypeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
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

  @GET
  @Path("/courts/{court_id}/casetypes/{case_type_id}/cross_references")
  public Response getCrossReferences(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return cors(Response.status(404).entity("\"Court " + courtId + " does not exist\""));
      }

      List<CrossReference> refs = cd.getCrossReference(courtId, caseTypeId);
      return cors(Response.ok(refs));
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/document_types")
  public Response getDocumentTypes(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<DocumentTypeTableRow> documentTypes = cd.getDocumentTypes(courtId, filingCodeId);

      return Response.ok(documentTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/motion_types")
  public Response getMotionTypes(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {

      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<NameAndCode> motionTypes = cd.getMotionTypes(courtId, filingCodeId);

      return Response.ok(motionTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/allowed_file_types")
  public Response getAllowedFileTypes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<FileType> fileTypes = cd.getAllowedFileTypes(courtId);

      return Response.ok(fileTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_statuses")
  public Response getFilingStatuses(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<NameAndCode> statuses = cd.getFilingStatuses(courtId);
      return Response.ok(statuses).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/filing_components")
  public Response getFilingComponents(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<FilingComponent> filingComponents = cd.getFilingComponents(courtId, filingCodeId);

      return Response.ok(filingComponents).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/optional_services")
  public Response getOptionalServices(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }

      List<OptionalServiceCode> optionalServiceCode = cd.getOptionalServices(courtId, filingCodeId);
      return Response.ok(optionalServiceCode).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/countries/{country}/states")
  public Response getStates(
      @PathParam("court_id") String courtId, @PathParam("country") String country)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      List<String> stateCodes = cd.getStateCodes(courtId, country);

      return cors(Response.ok(stateCodes));
    }
  }

  @GET
  @Path("/courts/{court_id}/languages")
  public Response getLanguages(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<String> languages = cd.getLanguages(courtId);

      return cors(Response.ok(languages));
    }
  }

  @GET
  @Path("/courts/{court_id}/datafields")
  public Response getDataFields(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      var datafields = cd.getDataFieldNames(courtId);

      return cors(Response.ok(datafields));
    }
  }

  @GET
  @Path("/courts/{court_id}/datafields/{field_name}")
  // TODO(brycew-later): consider a bulk way of getting multiple codes, will be
  // used heavily in the DA UI
  public Response getDataField(
      @PathParam("court_id") String courtId, @PathParam("field_name") String fieldName)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      DataFieldRow datafieldrow = cd.getDataField(courtId, fieldName);

      return cors(Response.ok(datafieldrow));
    }
  }

  @GET
  @Path("/courts/{court_id}/disclaimer_requirements")
  public Response getDisclaimerRequirements(@PathParam("court_id") String courtId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("\"Court " + courtId + " does not exist\"").build();
      }
      List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);

      return cors(Response.ok(disclaimers));
    }
  }

  private Optional<Response> okayCourt(String courtId) {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection())) {
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




  /**
   * Adds proper CORS headers to all responses to the codes API, which is public
   *
   * <p>See https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS and
   * https://stackoverflow.com/a/28996470/11416267.
   */
  private static Response cors(Response.ResponseBuilder rb) {
    return rb.header("Access-Control-Allow-Origin", "*").build();
  }

  @OPTIONS
  @Path("{path : .*}")
  public Response options() {
    return Response.ok("")
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
        .header("Access-Control-Allow-Credentials", "true")
        .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        .header("Access-Control-Max-Age", "1209600")
        .build();
  }
}
