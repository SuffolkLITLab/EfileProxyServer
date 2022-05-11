package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.endPointsToMap;
import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

@Path("/codes")
@Produces({MediaType.APPLICATION_JSON})
public class CodesService {
  private static Logger log = LoggerFactory.getLogger(CodesService.class);
  private static final Set<String> underCourtMethodNames = Set.of(
      "getCourtLocationCodes", "getCategories", "getCaseTypes", 
      "getNameSuffixes", "getServiceTypes",
      "getProcedureOrRemedies", "getFilingTypes", "getDamageAmounts",
      "getDataField", "getDisclaimerRequirements", "getLanguages",
      "getStates", "getFilingStatuses", "getAllowedFileTypes"
      );
  
  private static final Set<String> underCaseTypeMethodNames = Set.of(
      "getCaseSubtypes", "getPartyTypes", 
      "getCrossReferences"
      );
  
  private static final Set<String> underFilingCodeMethodNames = Set.of(
      "getOptionalServices", "getFilingComponents", "getDocumentTypes",
      "getMotionTypes"
      );

  private final DataSource ds;
  
  public CodesService(DataSource ds) {
    this.ds = ds;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection();
    var retMap = endPointsToMap(ef.findRESTEndpoints(List.of(this.getClass())));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts")
  public Response getCourts(@Context HttpHeaders httpHeaders, 
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileableOnly,
      @DefaultValue("false") @QueryParam("with_names") boolean withNames) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (fileableOnly) {
        // 0 and 1 are special "system" courts that have defaults for all courts.
        // They aren't available for filing, so filter out of either query here
        if (withNames) {
          return Response.ok(cd.getFileableLocationNames().stream()
              .filter(c -> !c.getCode().equals("0") && !c.getCode().equals("1")).sorted()
              .collect(Collectors.toList())).build();
        } else {
          return Response.ok(cd.getFileableLocations().stream()
              .filter(c -> !c.equals("0") && !c.equals("1")).sorted().collect(Collectors.toList()))
              .build();
        }
      } else {
        if (withNames) {
          return Response.ok(cd.getLocationNames()).build();
        } else {
          return Response.ok(cd.getAllLocations()).build();
        }
      }
    }
  }
  
  @GET
  @Path("/courts/{court_id}")
  public Response getCodesUnderCourt(@PathParam("court_id") String courtId) {
    EndpointReflection ef = new EndpointReflection();
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCourtMethods = new ArrayList<>();
    for (Method method : methods) {
      if (underCourtMethodNames.contains(method.getName())) {
        subCourtMethods.add(method);
      }
    }
    var retMap = endPointsToMap(replacePathParam(ef.makeRestEndpoints(subCourtMethods, clazz),
        Map.of("court_id", courtId)));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts/{court_id}/codes")
  public Response getCourtLocationCodes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
      if (info.isEmpty()) {
        return Response.status(404).build();
      }
      return Response.ok(info.get()).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}")
  public Response getCodesUnderCaseType(@PathParam("court_id") String courtId,
      @PathParam("case_type_id") String caseTypeId) {
    EndpointReflection ef = new EndpointReflection();
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCaseMethods = new ArrayList<>();
    for (Method method : methods) {
      if (underCaseTypeMethodNames.contains(method.getName())) {
        subCaseMethods.add(method);
      }
    }
    var retMap = endPointsToMap(replacePathParam(ef.makeRestEndpoints(subCaseMethods, clazz),
        Map.of("court_id", courtId, "case_type_id", caseTypeId)));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}")
  public Response getCodesUnderFilingCode(@PathParam("court_id") String courtId,
      @PathParam("filing_code_id") String filingCode) {
    EndpointReflection ef = new EndpointReflection();
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCaseMethods = new ArrayList<>();
    for (Method method : methods) {
      if (underFilingCodeMethodNames.contains(method.getName())) {
        subCaseMethods.add(method);
      }
    }
    var retMap = endPointsToMap(replacePathParam(ef.makeRestEndpoints(subCaseMethods, clazz),
        Map.of("court_id", courtId, "filing_code_id", filingCode)));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts/{court_id}/categories")
  public Response getCategories(@PathParam("court_id") String courtId,
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileableOnly,
      @QueryParam("timing") String timing) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      if (!fileableOnly) {
        List<CaseCategory> categories = cd.getCaseCategoriesFor(courtId);
        return Response.ok(categories).build();
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
      return Response.ok(categories).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types")
  public Response getCaseTypes(@PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId, @QueryParam("timing") String timing)
      throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
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

      return Response.ok(caseTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/name_suffixes")
  public Response getNameSuffixes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }

      List<NameAndCode> suffixes = cd.getNameSuffixes(courtId);
      return Response.ok(suffixes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/case_subtypes")
  public Response getCaseSubtypes(@PathParam("court_id") String courtId,
      @PathParam("case_type_id") String caseTypeId) throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<NameAndCode> caseSubtypes = cd.getCaseSubtypesFor(courtId, caseTypeId);

      return Response.ok(caseSubtypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/service_types")
  public Response getServiceTypes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist: " + courtId).build();
      }
      List<ServiceCodeType> types = cd.getServiceTypes(courtId);
      return Response.ok(types).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/procedures_or_remedies")
  public Response getProcedureOrRemedies(@PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId) throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<NameAndCode> procedureRemedies = cd.getProcedureOrRemedy(courtId, categoryId);

      return Response.ok(procedureRemedies).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_types")
  public Response getFilingTypes(@PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId, @QueryParam("type_id") String typeId,
      @QueryParam("initial") boolean initial) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {

      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<FilingCode> filingTypes = cd.getFilingType(courtId, categoryId, typeId, initial);

      return Response.ok(filingTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/damage_amounts")
  public Response getDamageAmounts(@PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId) throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<NameAndCode> damageAmounts = cd.getDamageAmount(courtId, categoryId);

      return Response.ok(damageAmounts).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/party_types")
  public Response getPartyTypes(@PathParam("court_id") String courtId,
      @PathParam("case_type_id") String caseTypeId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, caseTypeId);

      return Response.ok(partyTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/casetypes/{case_type_id}/cross_references")
  public Response getCrossReferences(@PathParam("court_id") String courtId,
      @PathParam("case_type_id") String caseTypeId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }

      List<CrossReference> refs = cd.getCrossReference(courtId, caseTypeId);
      return Response.ok(refs).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/document_types")
  public Response getDocumentTypes(@PathParam("court_id") String courtId,
      @PathParam("filing_code_id") String filingCodeId) throws SQLException {

    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<DocumentTypeTableRow> documentTypes = cd.getDocumentTypes(courtId, filingCodeId);

      return Response.ok(documentTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/motion_types")
  public Response getMotionTypes(@PathParam("court_id") String courtId,
      @PathParam("filing_code_id") String filingCodeId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {

      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<NameAndCode> motionTypes = cd.getMotionTypes(courtId, filingCodeId);

      return Response.ok(motionTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/allowed_file_types")
  public Response getAllowedFileTypes(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<FileType> fileTypes = cd.getAllowedFileTypes(courtId);

      return Response.ok(fileTypes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_statuses")
  public Response getFilingStatuses(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " does not exist").build();
      }
      List<NameAndCode> statuses = cd.getFilingStatuses(courtId);
      return Response.ok(statuses).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/filing_components")
  public Response getFilingComponents(@PathParam("court_id") String courtId,
      @PathParam("filing_code_id") String filingCodeId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<FilingComponent> filingComponents = cd.getFilingComponents(courtId, filingCodeId);

      return Response.ok(filingComponents).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/optional_services")
  public Response getOptionalServices(@PathParam("court_id") String courtId,
      @PathParam("filing_code_id") String filingCodeId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(400).entity("Court does not exist " + courtId).build();
      }

      List<OptionalServiceCode> optionalServiceCode = cd.getOptionalServices(courtId, filingCodeId);
      return Response.ok(optionalServiceCode).build();
    }
  }

  @GET
  @Path("/countries/{country}/states")
  public Response getStates(@PathParam("country") String country) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      List<String> stateCodes = cd.getStateCodes(country);

      return Response.ok(stateCodes).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/languages")
  public Response getLanguages(@PathParam("court_id") String courtId) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<String> languages = cd.getLanguages(courtId);

      return Response.ok(languages).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/datafields/{field_name}")
  // TODO(brycew-later): consider a bulk way of getting multiple codes, will be
  // used heavily in the DA UI
  public Response getDataField(@PathParam("court_id") String courtId,
      @PathParam("field_name") String fieldName) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      DataFieldRow datafieldrow = cd.getDataField(courtId, fieldName);

      return Response.ok(datafieldrow).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/disclaimer_requirements")
  public Response getDisclaimerRequirements(@PathParam("court_id") String courtId)
      throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(ds.getConnection())) {
      if (!cd.getAllLocations().contains(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);

      return Response.ok(disclaimers).build();
    }
  }

}
