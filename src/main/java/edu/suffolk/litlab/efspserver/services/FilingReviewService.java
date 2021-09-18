package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.UserDatabase;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.Date;
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
  private Map<String, EfmFilingInterface> filingInterfaces;
  private Map<String, EfmRestCallbackInterface> callbackInterfaces;
  private SecurityHub security;
  private OrgMessageSender msgSender;
  public FilingReviewService(
      UserDatabase ud,
      Map<String, InterviewToFilingEntityConverter> converterMap,
      Map<String, EfmFilingInterface> filingInterfaces,
      Map<String, EfmRestCallbackInterface> callbackInterfaces,
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
  @Path("/courts")
  public Response getCourts(@Context HttpHeaders httpHeaders) {
    return Response.ok(filingInterfaces.keySet().stream().sorted().collect(Collectors.toList())).build();
  }

  @GET
  @Path("/courts/{court_id}/filings/{filing_id}/status")
  public Response getFilingStatus(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }

    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).getFilingStatus(courtId, filingId, activeToken.get());
 }

  /** If 0 is passed for court, search all courts. */
  @GET
  @Path("/courts/{court_id}/filings")
  public Response getFilingList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("user_id") String userId, @QueryParam("start_date") String startStr,
      @QueryParam("end_date") String endStr) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot check for filings in " + courtId).build();
    }
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date startDate = (startStr != null) ? dateFormat.parse(startStr) : null;
      Date endDate = (endStr != null) ? dateFormat.parse(endStr) : null;
      return filingInterfaces.get(courtId).getFilingList(courtId, userId, startDate, endDate,
          activeToken.get());
    } catch (ParseException ex) {
      return Response.status(400).entity(
          "Dates given were incorrect, should be of the form: yyyy-MM-dd: " + ex).build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing/check")
  public Response checkFilingForReview(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
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
    Result<NullValue, FilingError> resEfm = filingInterfaces.get(courtId).checkFiling(info, activeToken.get(), collector);
    if (resEfm.isErr()) {
      log.warn(resEfm.toString());
      return Response.status(422).entity(collector.jsonSummary()).build();
    }
    return Response.ok(collector.jsonSummary()).build();
  }

  @GET
  @Path("/courts/{court_id}/filing/fees")
  public Response getFilingFees(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
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
    Result<Response, FilingError> fees = filingInterfaces.get(courtId).getFilingFees(info, activeToken.get());
    return fees.match(
        err -> Response.status(400).entity(err.toJson()).build(),
        respon -> respon);
  }

  @GET
  @Path("/courts/{court_id}/filing/servicetypes")
  public Response getServiceTypes(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
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
    Result<Response, FilingError> fees = filingInterfaces.get(courtId).getServiceTypes(info, activeToken.get());
    return fees.match(
        err -> Response.status(400).entity(err.toJson()).build(),
        respon -> respon);
  }


  @GET
  @Path("/courts/{court_id}/policy")
  public Response getPolicy(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId) {
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Court " + courtId + " doesn't exist").build();
    }

    return filingInterfaces.get(courtId).getPolicy(courtId, activeToken.get());
  }

  @POST
  @Path("/courts/{court_id}/filing/status")
  public Response filingUpdateWebhook(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String statusReport) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Got callback for filing! media type: " + mediaType + ", court id: " + courtId);
    log.trace("Everything they sent: " + statusReport);

    if (!callbackInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Court " + courtId + " doesn't exist").build();
    }

    return callbackInterfaces.get(courtId).statusCallback(httpHeaders, statusReport);
  }

  @POST
  @Path("/courts/{court_id}/filings")
  public Response submitFilingForReview(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    Optional<AtRest> atRest = security.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    Result<FilingInformation, Response> maybeInfo = parseFiling(httpHeaders, allVars, courtId, mediaType);
    if (maybeInfo.isErr()) {
      return maybeInfo.unwrapErrOrElseThrow();
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<List<UUID>, FilingError> result =
        filingInterfaces.get(courtId).sendFiling(info, activeToken.get(), EfmFilingInterface.ApiChoice.FileApi);
    if (result.isErr()) {
      return Response.status(500).entity(result.unwrapErrOrElseThrow().toJson()).build();
    }
    // Add this information to the transaction database
    List<Person> filers = info.getFilers();
    if (filers.isEmpty()) {
      log.error("No people to add as filers? %s".formatted(info));
      return Response.ok().entity("Couldn't log the user who submitted!").build();
    }
    Person user = filers.get(0);
    Optional<String> phoneNumber = Optional.empty();
    if (user.getContactInfo().getPhoneNumbers().size() > 0) {
      // TODO(brycew): should we store multiple phone numbers as backup?
      phoneNumber = Optional.of(user.getContactInfo().getPhoneNumbers().get(0));
    }
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    try {
      ud.addToTable(user.getName().getFullName(), user.getId(),
          phoneNumber, user.getContactInfo().getEmail().orElse(""),
          result.unwrapOrElseThrow(), atRest.get().serverId, activeToken.get(),
          info.getCaseType(), courtId, ts);

      msgSender.sendConfirmation(user.getContactInfo().getEmail().orElse(""),
          atRest.get().serverId, user.getName().getFullName(), result.unwrapOrElseThrow(),
          courtId, info.getCaseType());
    } catch (SQLException ex) {
      log.error("Couldn't add info to the database! Logging here for posterity: "
                + "%s %s %s %s %s".formatted(user.getName().getFullName(), user.getId(),
                        phoneNumber, user.getContactInfo().getEmail(),
                        result, info.getCaseType(), ts));
      log.error("Error: " + ex);
      return Response.ok().entity("Submitted, but error saving info to database").build();
    }
    return result.match(
        err -> Response.serverError().entity(err).build(),
        n -> Response.ok().build()
    );
  }

  @POST
  @Path("/courts/{court_id}/filings/serve")
  public Response serveFiling(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    Optional<AtRest> atRest = security.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    Result<FilingInformation, Response> maybeInfo = parseFiling(httpHeaders, allVars, courtId, mediaType);
    if (maybeInfo.isErr()) {
      return maybeInfo.unwrapErrOrElseThrow();
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<List<UUID>, FilingError> result =
        filingInterfaces.get(courtId).sendFiling(info, activeToken.get(), EfmFilingInterface.ApiChoice.ServiceApi);
    if (result.isErr()) {
      return Response.status(500).entity(result.unwrapErrOrElseThrow().toJson()).build();
    }
    return Response.status(501).build();
  }

  private Result<FilingInformation, Response> parseFiling(HttpHeaders httpHeaders, String allVars,
      String courtId, MediaType mediaType) {
    log.trace("Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    log.trace("All vars: " + allVars.substring(0, Integer.min(100, allVars.length() - 1)));
    Optional<AtRest> atRest = security.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty() || atRest.isEmpty()) {
      return Result.err(Response.status(401).entity("Not logged in to file with " + courtId).build());
    }
    if (!filingInterfaces.containsKey(courtId)) {
      return Result.err(Response.status(404).entity("Cannot send filing to " + courtId).build());
    }
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
  @Path("/courts/{court_id}/filings/{filing_id}")
  public Response getFilingDetails(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("filing_id") String filingId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).getFilingDetails(courtId, filingId, activeToken.get());
  }

  @GET
  @Path("/courts/{court_id}/filings/{filing_id}/service/{contact_id}")
  public Response getFilingService(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId,
      @PathParam("contact_id") String contactId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).getFilingService(courtId, filingId, contactId, activeToken.get());
  }

  @DELETE
  @Path("/courts/{court_id}/filings/{filing_id}")
  public Response cancelFiling(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("filing_id") String filingId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = getActiveToken(httpHeaders, filingInterfaces.get(courtId).getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).cancelFiling(courtId, filingId, activeToken.get());
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

}
