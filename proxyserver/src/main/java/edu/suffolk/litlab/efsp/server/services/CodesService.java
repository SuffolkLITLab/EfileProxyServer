package edu.suffolk.litlab.efsp.server.services;

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
import java.sql.SQLException;

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

  @GET
  @Path("/courts/{court_id}/categories")
  public abstract Response getCategories(
      @PathParam("court_id") String courtId,
      @DefaultValue("false") @QueryParam("fileable_only") boolean fileableOnly,
      @QueryParam("timing") String timing)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/categories/{cat_code}")
  public abstract Response getCategoryByCode(
      @PathParam("court_id") String courtId, @PathParam("cat_code") String catCode)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/case_types")
  public abstract Response getCaseTypes(
      @PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId,
      @QueryParam("timing") String timing)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/name_suffixes")
  public abstract Response getNameSuffixes(@PathParam("court_id") String courtId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/case_subtypes")
  public abstract Response getCaseSubtypes(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/service_types")
  public abstract Response getServiceTypes(@PathParam("court_id") String courtId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/procedures_or_remedies")
  public abstract Response getProcedureOrRemedies(
      @PathParam("court_id") String courtId, @QueryParam("category_id") String categoryId)
      throws SQLException;

  /**
   * @param courtId The court id where these filing types are present.
   * @param categoryId (optional) used to filter by filing types that can only be used with this
   *     case category.
   * @param typeId (optional) used to filter by filing types that can only be used with this case
   *     type
   * @param initial if true, shows filing types that can be used on initial filings (or initial and
   *     subsequent filings). If false, shows filings that can be used on subsequent filings.
   * @return The filing info
   * @responseExample application/json { "code": "29217", "name": "Proposed Order", "fee": "",
   *     "casecategory": "", "casetypeid": "", "filingtype": "Both", "iscourtuseonly": false,
   *     "civilclaimamount": "Not Available", "probateestateamount": "Not Available",
   *     "amountincontroversy": "Not Available", "useduedate": false, "isproposedorder": false,
   *     "efspcode": "", "location": "adams" }
   * @throws SQLException
   */
  @GET
  @Path("/courts/{court_id}/filing_types")
  public abstract Response getFilingTypes(
      @PathParam("court_id") String courtId,
      @QueryParam("category_id") String categoryId,
      @QueryParam("type_id") String typeId,
      @QueryParam("initial") boolean initial)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/filer_types")
  public abstract Response getFilerTypes(@PathParam("court_id") String courtId) throws SQLException;

  @GET
  @Path("/courts/{court_id}/damage_amounts")
  public abstract Response getDamageAmounts(
      @PathParam("court_id") String courtId, @QueryParam("category_id") String categoryId)
      throws SQLException;

  /**
   * Used for when you need to populate the party types names for a case search or something similar
   *
   * @param courtId
   * @return
   * @throws SQLException
   */
  @GET
  @Path("/courts/{court_id}/party_types")
  public abstract Response getAllPartyTypes(@PathParam("court_id") String courtId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/party_types/{party_type_id}")
  public abstract Response getPartyTypeFromAll(
      @PathParam("court_id") String courtId, @PathParam("party_type_id") String partyTypeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/party_types")
  public abstract Response getPartyTypes(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/party_types/{party_type_id}")
  public abstract Response getPartyType(
      @PathParam("court_id") String courtId,
      @PathParam("case_type_id") String caseTypeId,
      @PathParam("party_type_id") String partyTypeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/casetypes/{case_type_id}/cross_references")
  @Deprecated
  public abstract Response getCrossReferencesOld(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/case_types/{case_type_id}/cross_references")
  public abstract Response getCrossReferences(
      @PathParam("court_id") String courtId, @PathParam("case_type_id") String caseTypeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/document_types")
  public abstract Response getDocumentTypes(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/motion_types")
  public abstract Response getMotionTypes(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/allowed_file_types")
  public abstract Response getAllowedFileTypes(@PathParam("court_id") String courtId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/filing_statuses")
  public abstract Response getFilingStatuses(@PathParam("court_id") String courtId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/filing_components")
  public abstract Response getFilingComponents(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/filing_types/{filing_code_id}/optional_services")
  public abstract Response getOptionalServices(
      @PathParam("court_id") String courtId, @PathParam("filing_code_id") String filingCodeId)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/countries/{country}/states")
  public abstract Response getStates(
      @PathParam("court_id") String courtId, @PathParam("country") String country)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/languages")
  public abstract Response getLanguages(@PathParam("court_id") String courtId) throws SQLException;

  @GET
  @Path("/courts/{court_id}/datafields")
  public abstract Response getDataFields(@PathParam("court_id") String courtId) throws SQLException;

  @GET
  @Path("/courts/{court_id}/datafields/{field_name}")
  // TODO(brycew-later): consider a bulk way of getting multiple codes, will be
  // used heavily in the DA UI
  public abstract Response getDataField(
      @PathParam("court_id") String courtId, @PathParam("field_name") String fieldName)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/optional_services/{opt_serv_code}")
  public abstract Response getOptionalService(
      @PathParam("court_id") String courtId, @PathParam("opt_serv_code") String optServCode)
      throws SQLException;

  @GET
  @Path("/courts/{court_id}/disclaimer_requirements")
  public abstract Response getDisclaimerRequirements(@PathParam("court_id") String courtId)
      throws SQLException;

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
