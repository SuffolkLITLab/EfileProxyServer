package edu.suffolk.litlab.efsp.server.services;

import static edu.suffolk.litlab.efsp.server.utils.EndpointReflection.replacePathParam;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringDefault;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.FilingResult;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.services.impl.EfmFilingInterface;
import edu.suffolk.litlab.efsp.server.setup.EfmRestCallbackInterface;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.MDCWrappers;
import edu.suffolk.litlab.efsp.server.utils.NeedsAuthorization;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import edu.suffolk.litlab.efsp.utils.NeverSubmitCollector;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.container.ResourceContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Produces({MediaType.APPLICATION_JSON})
public class FilingReviewService {

  private static Logger log = LoggerFactory.getLogger(FilingReviewService.class);

  /** From input accept type to the converter obj. */
  private final Map<String, InterviewToFilingInformationConverter> converterMap;

  /** From court to FilingInterface (could be different on a court to court basis. */
  private final Map<String, EfmFilingInterface> filingInterfaces;

  private final Map<String, EfmRestCallbackInterface> callbackInterfaces;
  private final OrgMessageSender msgSender;
  private final Supplier<LoginDatabase> ldSupplier;
  private final Supplier<UserDatabase> udSupplier;
  private final EndpointReflection ef;

  public FilingReviewService(
      Jurisdiction jurisdiction,
      Supplier<LoginDatabase> ldSupplier,
      Supplier<UserDatabase> udSupplier,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      Map<String, EfmFilingInterface> filingInterfaces,
      Map<String, EfmRestCallbackInterface> callbackInterfaces,
      OrgMessageSender msgSender) {
    this.converterMap = converterMap;
    this.filingInterfaces = filingInterfaces;
    this.callbackInterfaces = callbackInterfaces;
    this.ldSupplier = ldSupplier;
    this.udSupplier = udSupplier;
    this.msgSender = msgSender;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction.getName() + "/filingreview");
  }

  @GET
  @Path("/")
  public Response getAll() {
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(FilingReviewService.class))))
        .build();
  }

  @GET
  @Path("/courts")
  public Response getCourts(@Context HttpHeaders httpHeaders) throws SQLException {
    return Response.ok(filingInterfaces.keySet().stream().sorted().collect(Collectors.toList()))
        .build();
  }

  @GET
  @Path("/courts/{court_id}")
  public Response getEndpointsUnderCourt(@PathParam("court_id") String courtId) {
    Class<?> clazz = this.getClass();
    Method[] methods = clazz.getMethods();
    List<Method> subCourtMethods = new ArrayList<>();
    for (Method method : methods) {
      if (!method.getName().equals("getCourts") && !method.getName().equals("getAll")) {
        subCourtMethods.add(method);
      }
    }
    var retMap =
        ef.endPointsToMap(
            replacePathParam(
                ef.makeRestEndpoints(subCourtMethods, clazz), Map.of("court_id", courtId)));
    return Response.ok(retMap).build();
  }

  @GET
  @Path("/courts/{court_id}/filings/{filing_id}/status")
  @NeedsAuthorization
  public Response getFilingStatus(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.getFilingStatus");
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();

    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    var toRet = filer.getFilingStatus(courtId, filingId, activeToken.get());
    return toRet;
  }

  /** If 0 is passed for court, search all courts. */
  @GET
  @Path("/courts/{court_id}/filings")
  @NeedsAuthorization
  public Response getFilingList(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("user_id") String userId,
      @QueryParam("start_date") String startStr,
      @QueryParam("before_date") String beforeStr) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.getFilingList");
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = filingInterfaces.get(courtId);
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    try {
      LocalDate startDate = (startStr != null) ? LocalDate.parse(startStr) : null;
      LocalDate beforeDate = (beforeStr != null) ? LocalDate.parse(beforeStr) : null;
      // beforeDate is exclusive!
      return filer.getFilingList(courtId, userId, startDate, beforeDate, activeToken.get());
    } catch (DateTimeParseException ex) {
      return Response.status(400)
          .entity(
              "Dates given were incorrect, should be of the form: yyyy-MM-dd (ISO_LOCAL_DATE): "
                  + ex)
          .build();
    }
  }

  @GET
  @Path("/courts/{court_id}/filing/check")
  @NeedsAuthorization
  public Response checkFilingForReview(
      @Context HttpHeaders httpHeaders, @PathParam("court_id") String courtId, String allVars) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.checkFilingForReview");
    MediaType mediaType = httpHeaders.getMediaType();
    if (mediaType == null) {
      mediaType = MediaType.valueOf("application/json");
    }
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
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
    InfoCollector collector = new NeverSubmitCollector();
    Result<FilingInformation, FilingError> res =
        converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      log.error("Error on traverseInterview: {}", res.toString());
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<NullValue, FilingError> resEfm = filer.checkFiling(info, activeToken.get(), collector);
    if (resEfm.isErr()) {
      log.error("Error on checkFiling: {}", resEfm.toString());
      return Response.ok(collector.jsonSummary()).build();
    }
    return Response.ok(collector.jsonSummary()).build();
  }

  @POST
  @Path("/courts/{court_id}/filing/fees")
  @NeedsAuthorization
  public Response calculateFilingFees(
      @Context HttpHeaders httpHeaders, @PathParam("court_id") String courtId, String allVars) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.calculateFilingFees");
    MediaType mediaType = httpHeaders.getMediaType();
    if (mediaType == null) {
      mediaType = MediaType.valueOf("application/json");
    }
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
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
    log.trace("Court id: {}", courtId);
    InfoCollector collector = new FailFastCollector();
    Result<FilingInformation, FilingError> res =
        converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      log.error("Error when calculating filing fees: {}", res.toString());
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<Response, FilingError> fees = filer.getFilingFees(info, activeToken.get());
    return fees.match(err -> Response.status(400).entity(err.toJson()).build(), respon -> respon);
  }

  @GET
  @Path("/courts/{court_id}/filing/servicetypes")
  @NeedsAuthorization
  public Response getServiceTypes(
      @Context HttpHeaders httpHeaders, @PathParam("court_id") String courtId, String allVars) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.getServiceTypes");
    MediaType mediaType = httpHeaders.getMediaType();
    if (mediaType == null) {
      mediaType = MediaType.valueOf("application/json");
    }
    log.trace("Court id: {}", courtId);
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
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
    Result<FilingInformation, FilingError> res =
        converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<Response, FilingError> fees = filer.getServiceTypes(info, activeToken.get());
    return fees.match(err -> Response.status(400).entity(err.toJson()).build(), respon -> respon);
  }

  @GET
  @Path("/courts/{court_id}/policy")
  @NeedsAuthorization
  public Response getPolicy(
      @Context HttpHeaders httpHeaders, @PathParam("court_id") String courtId) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.getPolicy");
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }

    var toRet = filer.getPolicy(courtId, activeToken.get());
    return toRet;
  }

  @POST
  @Path("/courts/{court_id}/filing/status")
  public Response filingUpdateWebhook(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      String statusReport) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.filingUpdateWebhook");
    if (!callbackInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Court " + courtId + " doesn't exist").build();
    }
    var toRet = callbackInterfaces.get(courtId).statusCallback(httpHeaders, statusReport);
    return toRet;
  }

  // TODO(brycew): unclear why this API exists on the Tyler side if the same functionality is in
  // ReviewFiling. Just to be ECF compliant? Unclear, but consider removing this code
  /*
  @POST
  @Path("/courts/{court_id}/filing/serve")
  public Response serveFiling(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      String allVars) {
    return fileOrServe(httpHeaders, jurisdiction, courtId, allVars, EfmFilingInterface.ApiChoice.ServiceApi);
  }
  */

  @POST
  @Path("/courts/{court_id}/filings")
  @NeedsAuthorization
  public Response submitFilingForReview(
      @Context HttpHeaders httpHeaders, @PathParam("court_id") String courtId, String allVars) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.submitFilingForReview");
    var toRet = fileOrServe(httpHeaders, courtId, allVars, EfmFilingInterface.ApiChoice.FileApi);
    return toRet;
  }

  private Response fileOrServe(
      HttpHeaders httpHeaders,
      String courtId,
      String allVars,
      EfmFilingInterface.ApiChoice choice) {
    MediaType mediaType = httpHeaders.getMediaType();
    if (mediaType == null) {
      mediaType = MediaType.valueOf("application/json");
    }
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    Optional<String> activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    Optional<AtRest> atRest = Optional.empty();
    try (LoginDatabase ld = ldSupplier.get()) {
      atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (activeToken.isEmpty() || atRest.isEmpty()) {
        return Response.status(401).entity("Not logged in to file with " + courtId).build();
      }
    } catch (SQLException ex) {
      log.error("SQL Error: ", ex);
    }
    Result<FilingInformation, Response> maybeInfo =
        parseFiling(httpHeaders, allVars, filer, courtId, mediaType);
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
    JsonNode miscInfo = info.getMiscInfo();

    String confirmationTemplate = getStringDefault(miscInfo, "email_confirmation_contents", "");
    String confirmationSubject = getStringDefault(miscInfo, "email_confirmation_subject", "");
    String acceptedTemplate = getStringDefault(miscInfo, "acceptance_contents", "");
    String acceptedSubject = getStringDefault(miscInfo, "acceptance_subject", "");
    String rejectedTemplate = getStringDefault(miscInfo, "rejected_contents", "");
    String rejectedSubject = getStringDefault(miscInfo, "rejected_subject", "");
    String neutralTemplate = getStringDefault(miscInfo, "neutral_contents", "");
    String neutralSubject = getStringDefault(miscInfo, "neutral_subject", "");

    try (UserDatabase ud = udSupplier.get()) {
      // TODO(brycew): this is going to send case type code (i.e. random numbers to the user.
      // Should avoid if possible, but would have to return the full info from the Filer object
      // TODO(brycew): this also sends "the carroll has received", instead of "the Carrol County
      // Court",
      // the filer Object should return the full name of the court if possible, not the id
      ud.addToTable(
          user.getName().getFullName(),
          user.getId(),
          phoneNumber,
          user.getContactInfo().getEmail().orElse(""),
          filingIds,
          atRest.get().serverId,
          activeToken.get(),
          info.getCaseTypeCode(),
          courtId,
          ts,
          acceptedTemplate,
          acceptedSubject,
          rejectedTemplate,
          rejectedSubject,
          neutralTemplate,
          neutralSubject,
          filingResult.caseTitle,
          filingResult.envelopeId);

    } catch (SQLException ex) {
      log.error(
          "Couldn't add info to the database! Logging here for posterity: {}, {}, {}, {}, {}, {}, {}",
          user.getName().getFullName(),
          user.getId(),
          phoneNumber,
          user.getContactInfo().getEmail(),
          result,
          info.getCaseTypeCode(),
          ts,
          ex);
      return Response.ok().entity("Submitted, but error saving info to database").build();
    }
    msgSender.sendConfirmation(
        user.getContactInfo().getEmail().orElse(""),
        confirmationTemplate,
        confirmationSubject,
        atRest.get().serverId,
        user.getName().getFullName(),
        filingResult.courtName,
        filingIds,
        filingResult.caseCategoryName,
        filingResult.caseTitle,
        filingResult.envelopeId);
    return result.match(
        err -> Response.serverError().entity(err).build(), n -> Response.ok(filingResult).build());
  }

  private Result<FilingInformation, Response> parseFiling(
      HttpHeaders httpHeaders,
      String allVars,
      EfmFilingInterface filer,
      String courtId,
      MediaType mediaType) {
    log.trace("Court id: {}", courtId);
    if (!converterMap.containsKey(mediaType.toString())) {
      return Result.err(
          Response.status(415).entity("We only support " + converterMap.keySet()).build());
    }
    Result<FilingInformation, FilingError> maybeInfo =
        converterMap.get(mediaType.toString()).extractInformation(allVars);
    if (maybeInfo.isErr()) {
      return Result.err(
          Response.status(400).entity(maybeInfo.unwrapErrOrElseThrow().toJson()).build());
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    return Result.ok(info);
  }

  @GET
  @Path("/courts/{court_id}/filings/{filing_id}")
  @NeedsAuthorization
  public Response getFilingDetails(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.getFilingDetails");
    try {
      Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
      if (checked.isErr()) {
        return checked.unwrapErrOrElseThrow();
      }
      EfmFilingInterface filer = checked.unwrapOrElseThrow();
      var activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
      if (activeToken.isEmpty()) {
        return Response.status(401).entity("Not logged in to file with " + courtId).build();
      }
      return filer.getFilingDetails(courtId, filingId, activeToken.get());
    } finally {
    }
  }

  @GET
  @Path("/courts/{court_id}/filings/{filing_id}/service/{contact_id}")
  @NeedsAuthorization
  public Response getFilingService(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId,
      @PathParam("contact_id") String contactId) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.getFilingService");
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    var activeToken = getActiveToken(httpHeaders, filer.getHeaderKey());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    var toRet = filer.getFilingService(courtId, filingId, contactId, activeToken.get());
    return toRet;
  }

  @DELETE
  @Path("/courts/{court_id}/filings/{filing_id}")
  @NeedsAuthorization
  public Response cancelFiling(
      @Context ResourceContext context,
      @PathParam("court_id") String courtId,
      @PathParam("filing_id") String filingId) {
    MDC.put(MDCWrappers.OPERATION, "FilingReviewService.cancelFiling");
    Result<EfmFilingInterface, Response> checked = checkFilingInterfaces(courtId);
    if (checked.isErr()) {
      return checked.unwrapErrOrElseThrow();
    }
    EfmFilingInterface filer = checked.unwrapOrElseThrow();
    var toRet = filer.cancelFiling(courtId, filingId, activeToken.get());
    return toRet;
  }

  private Result<EfmFilingInterface, Response> checkFilingInterfaces(String courtId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Result.err(Response.status(404).entity("Cannot send filing to " + courtId).build());
    }
    return Result.ok(filingInterfaces.get(courtId));
  }
}
