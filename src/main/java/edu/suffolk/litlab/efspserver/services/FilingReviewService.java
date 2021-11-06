package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.UserDatabase;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

@Path("/filingreview/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class FilingReviewService {

  private static Logger log =
      LoggerFactory.getLogger(FilingReviewService.class);

  private UserDatabase ud;
  private Map<String, InterviewToFilingEntityConverter> converterMap;
  private Map<String, Map<String, EfmFilingInterface>> filingInterfaces;
  private Map<String, Map<String, EfmRestCallbackInterface>> callbackInterfaces;
  private SecurityHub security;
  private OrgMessageSender msgSender;

  public FilingReviewService(
      UserDatabase ud,
      Map<String, InterviewToFilingEntityConverter> converterMap,
      Map<String, Map<String, EfmFilingInterface>> filingInterfaces,
      Map<String, Map<String, EfmRestCallbackInterface>> callbackInterfaces,
      SecurityHub security,
      OrgMessageSender msgSender) {
    this.converterMap = converterMap;
    this.filingInterfaces = filingInterfaces;
    this.callbackInterfaces = callbackInterfaces;
    this.ud = ud;
    this.security = security;
    this.msgSender = msgSender;
  }

  @GET
  @Path("/jurisdictions")
  public Response getJurisdictions(@Context HttpHeaders httpHeaders) {
    return Response.ok(filingInterfaces.keySet().stream().sorted().collect(Collectors.toList())).build();
  }

  @GET
  @Path("/jurisdictions/{jurisdiction}/courts")
  public Response getCourts(@Context HttpHeaders httpHeaders, 
      @PathParam("jurisdiction") String jurisdiction) throws SQLException {
    return Response.ok(filingInterfaces.get(jurisdiction).keySet().stream().sorted().collect(Collectors.toList())).build();
  }
  
  @GET
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filings/{filing_id}/status")
  public Response getFilingStatus(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId) {
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();

    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filer.getFilingStatus(courtId, filingId, activeToken.get());
 }

  /** If 0 is passed for court, search all courts. */
  @GET
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filings")
  public Response getFilingList(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId,
      @QueryParam("user_id") String userId, 
      @QueryParam("start_date") String startStr,
      @QueryParam("end_date") String endStr) {
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (!filingInterfaces.containsKey(jurisdiction)) {
      return Response.status(404).entity("Jurisdiction " + jurisdiction + " doesn't exist").build();
    }

    if (!filingInterfaces.get(jurisdiction).containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = filingInterfaces.get(jurisdiction).get(courtId);
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    try {
      LocalDate startDate = (startStr != null) ? LocalDate.parse(startStr) : null;
      LocalDate endDate = (endStr != null) ? LocalDate.parse(endStr) : null;
      return filer.getFilingList(courtId, userId, startDate, endDate,
          activeToken.get());
    } catch (DateTimeParseException ex) {
      return Response.status(400).entity(
          "Dates given were incorrect, should be of the form: yyyy-MM-dd (ISO_LOCAL_DATE): " + ex).build();
    }
  }

  @GET
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filing/check")
  public Response checkFilingForReview(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId, 
      String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId + " in " + jurisdiction).build();
    }
    if (!converterMap.containsKey(mediaType.toString())) {
      return Response.status(415).entity("We only support " + converterMap.keySet()).build();
    }
    InfoCollector collector = new NeverSubmitCollector();
    Result<FilingInformation, FilingError> res = converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      log.warn(res.toString());
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<NullValue, FilingError> resEfm = filer.checkFiling(info, activeToken.get(), collector);
    if (resEfm.isErr()) {
      log.warn(resEfm.toString());
      return Response.status(422).entity(collector.jsonSummary()).build();
    }
    return Response.ok(collector.jsonSummary()).build();
  }

  @POST
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filing/fees")
  public Response calculateFilingFees(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId, 
      String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!converterMap.containsKey(mediaType.toString())) {
      return Response.status(415).entity("We only support " + converterMap.keySet()).build();
    }
    InfoCollector collector = new FailFastCollector();
    Result<FilingInformation, FilingError> res = converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<Response, FilingError> fees = filer.getFilingFees(info, activeToken.get());
    return fees.match(
        err -> Response.status(400).entity(err.toJson()).build(),
        respon -> respon);
  }

  @GET
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filing/servicetypes")
  public Response getServiceTypes(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId, 
      String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!converterMap.containsKey(mediaType.toString())) {
      return Response.status(415).entity("We only support " + converterMap.keySet()).build();
    }
    InfoCollector collector = new FailFastCollector();
    Result<FilingInformation, FilingError> res = converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<Response, FilingError> fees = filer.getServiceTypes(info, activeToken.get());
    return fees.match(
        err -> Response.status(400).entity(err.toJson()).build(),
        respon -> respon);
  }


  @GET
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/policy")
  public Response getPolicy(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId) {
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }

    return filer.getPolicy(courtId, activeToken.get());
  }

  @POST
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filing/status")
  public Response filingUpdateWebhook(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction, 
      @PathParam("court_id") String courtId, 
      String statusReport) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Got callback for filing! media type: " + mediaType + ", court id: " + courtId);
    log.trace("Everything they sent: " + statusReport);
    
    if (!callbackInterfaces.containsKey(jurisdiction)) {
      return Response.status(404).entity("Jurisdiction " + jurisdiction + " doesn't exist").build();
    }

    if (!callbackInterfaces.get(jurisdiction).containsKey(courtId)) {
      return Response.status(404).entity("Court " + courtId + " in " + jurisdiction + " doesn't exist").build();
    }

    return callbackInterfaces.get(jurisdiction).get(courtId).statusCallback(httpHeaders, statusReport);
  }

  // TODO(brycew): unclear why this API exists on the Tyler side if the same functionality is in
  // ReviewFiling. Just to be ECF compliant? Unclear, but consider removing this code
  /* 
  @POST
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filing/serve")
  public Response serveFiling(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId, 
      String allVars) {
    return fileOrServe(httpHeaders, jurisdiction, courtId, allVars, EfmFilingInterface.ApiChoice.ServiceApi);
  }
  */

  @POST
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filings")
  public Response submitFilingForReview(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction, 
      @PathParam("court_id") String courtId, 
      String allVars) {
    return fileOrServe(httpHeaders, jurisdiction, courtId, allVars, EfmFilingInterface.ApiChoice.FileApi);
  }
  
  private Response fileOrServe(HttpHeaders httpHeaders, String jurisdiction, String courtId, String allVars, EfmFilingInterface.ApiChoice choice) {
    MediaType mediaType = httpHeaders.getMediaType();
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<AtRest> atRest = security.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty() || atRest.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    Result<FilingInformation, Response> maybeInfo = parseFiling(httpHeaders, allVars, filer, courtId, mediaType);
    if (maybeInfo.isErr()) {
      return maybeInfo.unwrapErrOrElseThrow();
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<FilingResult, FilingError> result =
        filer.sendFiling(info, activeToken.get(), EfmFilingInterface.ApiChoice.FileApi);
    if (result.isErr()) {
      return Response.status(500).entity(result.unwrapErrOrElseThrow().toJson()).build();
    }
    // Add this information to the transaction database
    Person user = result.unwrapOrElseThrow().leadContact; 
    if (user == null) {
      return Response.status(500).entity("Got Tyler submission, but no lead contact?").build(); 
    }
    FilingResult filingResult = result.unwrapOrElseThrow();
    List<UUID> filingIds = filingResult.filingIds;
    Optional<String> phoneNumber = Optional.empty();
    if (user != null && user.getContactInfo().getPhoneNumbers().size() > 0) {
      // TODO(brycew-later): should we store multiple phone numbers as backup?
      phoneNumber = Optional.of(user.getContactInfo().getPhoneNumbers().get(0));
    }
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    try {
      // TODO(brycew): this is going to send case type code (i.e. random numbers to the user. 
      // Should avoid if possible, but would have to return the full info from the Filer object 
      // TODO(brycew): this also sends "the carroll has received", instead of "the Carrol County Court",
      // the filer Object should return the full name of the court if possible, not the id
      ud.addToTable(user.getName().getFullName(), user.getId(),
          phoneNumber, user.getContactInfo().getEmail().orElse(""),
          filingIds, atRest.get().serverId, activeToken.get(),
          info.getCaseTypeCode(), courtId, ts);

      msgSender.sendConfirmation(user.getContactInfo().getEmail().orElse(""),
          atRest.get().serverId, user.getName().getFullName(), filingIds, 
          courtId, info.getCaseTypeCode());
    } catch (SQLException ex) {
      log.error("Couldn't add info to the database! Logging here for posterity: "
                + "%s %s %s %s %s".formatted(user.getName().getFullName(), user.getId(),
                        phoneNumber, user.getContactInfo().getEmail(),
                        result, info.getCaseTypeCode(), ts));
      log.error("Error: " + ex);
      return Response.ok().entity("Submitted, but error saving info to database").build();
    }
    return result.match(
        err -> Response.serverError().entity(err).build(),
        n -> Response.ok(filingResult).build()
    );
  }

  private Result<FilingInformation, Response> parseFiling(HttpHeaders httpHeaders, String allVars,
      EfmFilingInterface filer, String courtId, MediaType mediaType) {
    log.trace("Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    log.trace("All vars: " + allVars.substring(0, Integer.min(100, allVars.length() - 1)));
    if (!converterMap.containsKey(mediaType.toString())) {
      return Result.err(Response.status(415).entity("We only support " + converterMap.keySet()).build());
    }
    Result<FilingInformation, FilingError> maybeInfo =
        converterMap.get(mediaType.toString()).extractEntities(allVars);
    if (maybeInfo.isErr()) {
      return Result.err(Response.status(400).entity(maybeInfo.unwrapErrOrElseThrow().toJson()).build());
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    return Result.ok(info);
  }

  @GET
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filings/{filing_id}")
  public Response getFilingDetails(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction, 
      @PathParam("court_id") String courtId, 
      @PathParam("filing_id") String filingId) {
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filer.getFilingDetails(courtId, filingId, activeToken.get());
  }

  @GET
  @Path("/jurisdicitons/{jurisdicition}/courts/{court_id}/filings/{filing_id}/service/{contact_id}")
  public Response getFilingService(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId,
      @PathParam("contact_id") String contactId) {
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filer.getFilingService(courtId, filingId, contactId, activeToken.get());
  }

  @DELETE
  @Path("/jurisdictions/{jurisdiction}/courts/{court_id}/filings/{filing_id}")
  public Response cancelFiling(@Context HttpHeaders httpHeaders,
      @PathParam("jurisdiction") String jurisdiction,
      @PathParam("court_id") String courtId, 
      @PathParam("filing_id") String filingId) {
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(jurisdiction, courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filer.cancelFiling(courtId, filingId, activeToken.get());
  }

  private Optional<String> getActiveToken(HttpHeaders httpHeaders, String orgHeaderKey) {
    String serverKey = httpHeaders.getHeaderString("X-API-KEY");
    Optional<AtRest> atRest = security.getAtRestInfo(serverKey);
    if (atRest.isEmpty()) {
      return Optional.empty();
    }

    String orgToken = httpHeaders.getHeaderString(orgHeaderKey);
    if (orgToken == null || orgToken.isBlank()) {
      return Optional.empty();
    }
    return Optional.of(orgToken);
  }
  
  private Result<EfmFilingInterface, Response> checkFilingInterfaces(String jurisdictionId, String courtId) {
    if (!filingInterfaces.containsKey(jurisdictionId)) {
      return Result.err(Response.status(404).entity("Jurisdiction " + jurisdictionId + " doesn't exist").build());
    }

    if (!filingInterfaces.get(jurisdictionId).containsKey(courtId)) {
      return Result.err(Response.status(404).entity("Cannot send filing to " + courtId).build());
    }
    return Result.ok(filingInterfaces.get(jurisdictionId).get(courtId));
  }

}
