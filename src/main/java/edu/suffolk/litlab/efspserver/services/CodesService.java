package edu.suffolk.litlab.efspserver.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.codes.Disclaimer;
import edu.suffolk.litlab.efspserver.codes.DocumentTypeTableRow;
import edu.suffolk.litlab.efspserver.codes.FileType;
import edu.suffolk.litlab.efspserver.codes.FilingCode;
import edu.suffolk.litlab.efspserver.codes.FilingComponent;
import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.codes.PartyType;

@Path("/codes/")
@Produces({MediaType.APPLICATION_JSON})
public class CodesService {
  private static Logger log = LoggerFactory.getLogger(CodesService.class); 
  private Map<String, EfmFilingInterface> filingInterfaces;

  private CodeDatabase cd;
  public CodesService(CodeDatabase cd, Map<String, EfmFilingInterface> filingInterfaces) {
    this.cd = cd;
    this.filingInterfaces = filingInterfaces;
  }

  @GET
  @Path("/courts/")
  public Response getCourts(@Context HttpHeaders httpHeaders
    ) throws SQLException {
      List<String> courts;

      courts = cd.getAllLocations();

    return Response.ok(courts).build();
  }
  
  @GET
  @Path("/courts/{court_id}/categories")
  public Response getCategories(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId) throws SQLException {
      List<CaseCategory> categories;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      categories = cd.getCaseCategoriesFor(courtId);

    return Response.ok(categories).build();
  }

  @GET
  @Path("/courts/{court_id}/case_types")
  public Response getCaseTypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @QueryParam("category_id") String categoryId) throws SQLException {
      List<CaseType> caseTypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      caseTypes = cd.getCaseTypesFor(courtId, categoryId);

    return Response.ok(caseTypes).build();
  }

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/case_subtypes")
  public Response getCaseSubtypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("case_type_id}") String caseTypeId) throws SQLException {
      List<NameAndCode> caseSubtypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      caseSubtypes = cd.getCaseSubtypesFor(courtId, caseTypeId);

    return Response.ok(caseSubtypes).build();
  }

  @GET
  @Path("/courts/{court_id}/procedure_or_remedies")
  public Response getProcedureOrRemedies(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @QueryParam("category_id") String categoryId) throws SQLException {
      List<NameAndCode> procedureRemedies;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      procedureRemedies = cd.getProcedureOrRemedy(courtId, categoryId);

    return Response.ok(procedureRemedies).build();
  }

  @GET
  @Path("/courts/{court_id}/filing_types")
  public Response getFilingTypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @QueryParam("category_id") String categoryId,
    @QueryParam("type_id") String typeId,
    @QueryParam("initial") boolean initial) throws SQLException {
      List<FilingCode> filingTypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      filingTypes = cd.getFilingType(courtId, categoryId, typeId, initial);

    return Response.ok(filingTypes).build();
  }  

  @GET
  @Path("/courts/{court_id}/damage_amounts")
  public Response getDamageAmounts(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @QueryParam("category_id") String categoryId) throws SQLException {
      List<NameAndCode> damageAmounts;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      damageAmounts = cd.getDamageAmount(courtId, categoryId);

    return Response.ok(damageAmounts).build();
  }  


  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/party_types")
  public Response getPartyTypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("case_type_id}") String caseTypeId) throws SQLException {
      List<PartyType> partyTypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      partyTypes = cd.getPartyTypeFor(courtId, caseTypeId);

    return Response.ok(partyTypes).build();
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/document_types")
  public Response getDocumentTypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("filing_code_id}") String filingCodeId) throws SQLException {
      List<DocumentTypeTableRow> documentTypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      documentTypes = cd.getDocumentTypes(courtId, filingCodeId);

    return Response.ok(documentTypes).build();
  }

  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/motion_types")
  public Response getMotionTypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("filing_code_id}") String filingCodeId) throws SQLException {
      List<NameAndCode> motionTypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      motionTypes = cd.getMotionTypes(courtId, filingCodeId);

    return Response.ok(motionTypes).build();
  }

  @GET
  @Path("/courts/{court_id}/allowed_file_types")
  public Response getAllowedFileTypes(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId) throws SQLException {
      List<FileType> fileTypes;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      fileTypes = cd.getAllowedFileTypes(courtId);

    return Response.ok(fileTypes).build();
  }



  @GET
  @Path("/courts/{court_id}/filing_codes/{filing_code_id}/filing_components")
  public Response getFilingComponents(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("filing_code_id}") String filingCodeId) throws SQLException {
      List<FilingComponent> filingComponents;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      filingComponents = cd.getFilingComponents(courtId, filingCodeId);

    return Response.ok(filingComponents).build();
  }  

  @GET
  @Path("/countries/{country}/states/")
  public Response getStates(@Context HttpHeaders httpHeaders, 
    @PathParam("country") String country) throws SQLException {
      List<String> stateCodes;

      stateCodes = cd.getStateCodes(country);

    return Response.ok(stateCodes).build();
  }  

  @GET
  @Path("/courts/{court_id}/languages/")
  public Response getLanguages(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId) throws SQLException {
      List<String> languages;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      languages = cd.getLanguages(courtId);

    return Response.ok(languages).build();
  }

  @GET
  @Path("/courts/{court_id}/datafield/{field_name}")
  public Response getDataField(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("field_name") String fieldName) throws SQLException {
      DataFieldRow datafieldrow;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      datafieldrow = cd.getDataField(courtId, fieldName);

    return Response.ok(datafieldrow).build();
  }  

  @GET
  @Path("/courts/{court_id}/disclaimer_requirements")
  public Response getDisclaimerRequirements(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId,
    @PathParam("field_name") String fieldName) throws SQLException {
      List<Disclaimer> disclaimers;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      disclaimers = cd.getDisclaimerRequirements(courtId);

    return Response.ok(disclaimers).build();
  }
  
  

}
