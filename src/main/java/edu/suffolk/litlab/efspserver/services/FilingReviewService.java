package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.UserDatabase;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/filingreview/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FilingReviewService {

  private static Logger log = 
      LoggerFactory.getLogger(FilingReviewService.class); 

  private UserDatabase ud;
  private Map<String, InterviewToFilingEntityConverter> converterMap;
  private Map<String, EfmFilingInterface> filingInterfaces;
  private Map<String, EfmRestCallbackInterface> callbackInterfaces;
  private SecurityHub security;
  public FilingReviewService(
      UserDatabase ud,
      Map<String, InterviewToFilingEntityConverter> converterMap,
      Map<String, EfmFilingInterface> filingInterfaces,
      Map<String, EfmRestCallbackInterface> callbackInterfaces,
      SecurityHub security) {
    this.converterMap = converterMap;
    this.filingInterfaces = filingInterfaces;
    this.callbackInterfaces = callbackInterfaces;
    this.ud = ud;
    this.security = security;
  }
  
  @GET
  @Path("/courts")
  public Response getCourts(@Context HttpHeaders httpHeaders) {
    return Response.ok(filingInterfaces.keySet().stream().collect(Collectors.toList())).build();
  }
  
  @GET
  @Path("/court/{court_id}/filings/{filing_id}/status")
  public Response getFilingStatus(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, 
      @PathParam("filing_id") String filingId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = security.checkLogin(httpHeaders.getHeaderString("X-API-KEY"), filingInterfaces.get(courtId).getOrgName());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).getFilingStatus(courtId, filingId, activeToken.get());
 }
  
  @GET
  @Path("/court/{court_id}/filings/")
  public Response getFilingList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = security.checkLogin(httpHeaders.getHeaderString("X-API-KEY"), filingInterfaces.get(courtId).getOrgName());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).getFilingList(courtId, activeToken.get());
  }
  
  @POST
  @Path("/court/{court_id}/check_filing")
  public Response checkFilingForReview(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("Checking a filing: Media type: " + mediaType);  
    log.trace("Court id: " + courtId);
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    if (!converterMap.containsKey(mediaType.toString())) {
      return Response.status(415).entity("We only support " + converterMap.keySet()).build();
    }
    InfoCollector collector = new AllWrongCollector();
    converterMap.get(mediaType.toString()).findMissing(allVars, collector);
    return Response.ok(collector.jsonSummary()).build();
  }
  
  @POST
  @Path("/court/{court_id}/filing/status")
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
  @Path("/court/{court_id}/filing")
  public Response submitFilingForReview(@Context HttpHeaders httpHeaders, 
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    log.trace("New FilingDoc: Media type: " + mediaType);
    log.trace("Court id: " + courtId);
    log.trace("All vars: " + allVars.substring(0, Integer.min(100, allVars.length() - 1)));
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = security.checkLogin(httpHeaders.getHeaderString("X-API-KEY"), 
        filingInterfaces.get(courtId).getOrgName());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    if (!converterMap.containsKey(mediaType.toString())) {
      return Response.status(415).entity("We only support " + converterMap.keySet()).build();
    } 
    Result<FilingInformation, FilingError> maybeInfo = 
        converterMap.get(mediaType.toString()).extractEntities(allVars);
    if (maybeInfo.isErr()) {
      return Response.status(400).entity(maybeInfo.unwrapErrOrElseThrow().toJson()).build();
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<List<UUID>, FilingError> result = 
        filingInterfaces.get(courtId).sendFiling(info, activeToken.get());
    if (result.isErr()) {
      return Response.status(500).entity(result.unwrapErrOrElseThrow()).build();
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
          result.unwrapOrElseThrow(), activeToken.get(), 
          info.getCaseType(), courtId, ts);
    } catch (SQLException ex) {
      log.error("Couldn't add info to the database! Logging here for posterity: " 
                + "%s %s %s %s %s".formatted(user.getName().getFullName(), user.getId(), 
                        phoneNumber, user.getContactInfo().getEmail(),
                        result, info.getCaseType(), ts));
      log.error("Error: " + ex);
      // TODO(brycew): change to "created"
      return Response.ok().entity("Error saving info to database").build();
    }
    return result.match(
        err -> Response.serverError().entity(err).build(),
        // TODO(brycew): change to "created"
        n -> Response.ok().build()
    );
    /*
    // filing code: complaint (27967): got from filing table, location = 'adams',
    // casecategory='210',
    // and filingtype='Both' or 'Initial'
    String regActionDesc = "27967";
    // SELECT * from filingcomponent where location = 'adams' and
    // filingcodeid='27967';
    String componentCode = "332";
    String fileName = "quality_check_overlay.pdf";
    InputStream x = getClass().getResourceAsStream("/" + fileName); 
    FilingDoc filing = new FilingDoc(fileName, x, regActionDesc,
        plaintiffs.stream().map((p) -> p.getId()).collect(Collectors.toList()), "5766",
        componentCode, FilingTypeType.E_FILE);

    // Manual combination: Decided on Adams, then it's a family, so "Family" name in
    // catecategory table
    // The code for those in adams in 210. Then, get all casetype where
    // casecategory='210'
    // Subtype is never used, the table is empty?
    CaseCategory caseCategory = new CaseCategory("210", "Family", "DomesticCase", "Not Available",
        "Not Available", "Not Available");
    
    Optional<ErrorType> err = filingInterface.sendFiling(courtId, plaintiffs, 
        defendants, caseCategory, "25384", regActionDesc, List.of(filing), componentCode);
    */
  }

  @GET
  @Path("/court/{court_id}/filings/{filing_id}")
  public Response getFilingDetails(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("filing_id") String filingId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = security.checkLogin(httpHeaders.getHeaderString("X-API-KEY"), filingInterfaces.get(courtId).getOrgName());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).getFilingDetails(courtId, filingId, activeToken.get());
  }

  @DELETE
  @Path("/court/{court_id}/filings/{filing_id}")
  public Response cancelFiling(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("filing_id") String filingId) {
    if (!filingInterfaces.containsKey(courtId)) {
      return Response.status(404).entity("Cannot send filing to " + courtId).build();
    }
    Optional<String> activeToken = security.checkLogin(httpHeaders.getHeaderString("X-API-KEY"), filingInterfaces.get(courtId).getOrgName());
    if (activeToken.isEmpty()) {
      return Response.status(401).entity("Not logged in to file with " + courtId).build();
    }
    return filingInterfaces.get(courtId).cancelFiling(courtId, filingId, activeToken.get());
  }
  
}
