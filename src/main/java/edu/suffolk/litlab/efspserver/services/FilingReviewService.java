package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.UserDatabase;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import gov.niem.niem.niem_core._2.EntityType;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.FilingListResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.MatchingFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.FilingStatusResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType;
import tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType;
import tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType;
import tyler.efm.services.schema.common.ErrorType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

@Path("/filingreview/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FilingReviewService {

  private static Logger log = 
      LoggerFactory.getLogger(FilingReviewService.class); 

  private FilingReviewMDEService filingFactory;
  private CodeDatabase cd;
  private UserDatabase ud;
  private Map<String, InterviewToFilingEntityConverter> converterMap;
  private Map<String, EfmFilingInterface> filingInterfaces;
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory 
      statusObjFac;
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory 
      listObjFac;
  private tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory 
      detailObjFac;
  private tyler.ecf.extensions.cancelfilingmessage.ObjectFactory 
      cancelObjFac;
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory 
      commonObjFac; 
  
  public FilingReviewService(
      CodeDatabase cd, 
      UserDatabase ud,
      Map<String, InterviewToFilingEntityConverter> converterMap,
      Map<String, EfmFilingInterface> filingInterfaces) {
    this.converterMap = converterMap;
    this.filingInterfaces = filingInterfaces;
    this.cd = cd;
    this.ud = ud;
    statusObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory();
    listObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory();
    commonObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    init();
  }
  
  final void init() {
    URL filingReviewUrl = FilingReviewMDEService.WSDL_LOCATION;
    filingFactory = new FilingReviewMDEService(filingReviewUrl,
        FilingReviewMDEService.SERVICE);
  }
  
  @GET
  @Path("/courts")
  public Response getCourts(@Context HttpHeaders httpHeaders) {
    // TODO(brycew): login when we don't need tyler stuff?
    try {
      List<String> courtIds = cd.getAllLocations();
      return Response.ok().entity(courtIds).build();
    } catch (SQLException ex) {
      return Response.status(500).entity("DevOps Error: Could not connect to database: " 
        + ex.toString()).build();
    }
  }
  
  @GET
  @Path("/court/{court_id}/filings/{filing_id}/status")
  public Response getFilingStatus(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, 
      @PathParam("filing_id") String filingId) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      FilingStatusQueryMessageType status = statusObjFac.createFilingStatusQueryMessageType();
      status.setCaseCourt(XmlHelper.convertCourtType(courtId));
      status.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
      status.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      status.setDocumentIdentification(XmlHelper.convertId(filingId));
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      EntityType typ = new EntityType();
      typ.setEntityRepresentation(elem2);
      status.setQuerySubmitter(typ);
      FilingStatusResponseMessageType statusResp = port.get().getFilingStatus(status);
      return ServiceHelpers.mapTylerCodesToHttp(statusResp.getError(), 
          () -> Response.ok().entity(status).build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
  }
  
  @GET
  @Path("/court/{court_id}/filings/")
  public Response getFilingList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      FilingListQueryMessageType m = listObjFac.createFilingListQueryMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      m.setQuerySubmitter(typ);
      m.setDocumentSubmitter(null); // cof.createEntityPerson(null));
      m.setCaseCourt(XmlHelper.convertCourtType(courtId));
      m.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
      m.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      m.getDateRange().add(null);
      FilingListResponseMessageType resp = port.get().getFilingList(m);
      for (MatchingFilingType match : resp.getMatchingFiling()) {
        log.trace("Matched: " + match.getCaseTrackingID() + ", " + match);
      }
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> {
            if (resp.getMatchingFiling().size() <= 0) {
              return Response.noContent().build();
            }
            return Response.ok().entity(resp.getMatchingFiling()).build();
          });
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
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
    if (!converterMap.containsKey(mediaType.toString())) {
      return Response.status(415).entity("We only support " + converterMap.keySet()).build();
    } 
    Result<FilingInformation, ExtractError> maybeInfo = 
        converterMap.get(mediaType.toString()).extractEntities(allVars);
    if (maybeInfo.isErr()) {
      return Response.status(400).entity(maybeInfo.unwrapErrOrElseThrow().toJson()).build();
    }
    FilingInformation info = maybeInfo.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    Result<UUID, ErrorType> result = 
        filingInterfaces.get(courtId).sendFiling(info);
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
          result.unwrapOrElseThrow(), info.getCaseType(), 
          ts);
      ud.commit();
    } catch (SQLException ex) {
      log.error("Couldn't add info to the database! Logging here for posterity: " 
                + "%s %s %s %s %s".formatted(user.getName().getFullName(), user.getId(), 
                        phoneNumber, user.getContactInfo().getEmail(),
                        result, info.getCaseType(), ts));
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
    
    EfmFilingInterface filingInterface = new JeffNetFiler(System.getenv("JEFFERSON_ENDPOINT"), System.getenv("JEFFERSON_TOKEN"));
    Optional<ErrorType> err = filingInterface.sendFiling(courtId, plaintiffs, 
        defendants, caseCategory, "25384", regActionDesc, List.of(filing), componentCode);
    if (err.isEmpty()) {
      System.err.println("No error!");
      return Response.ok().build();
    } else {
      System.err.println("Err!: " + err.get().getErrorText());
      return Response.serverError().entity(err.get()).build();
    }
    */
  }

  @GET
  @Path("/court/{court_id}/filings/{filing_id}")
  public Response getFilingDetails(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("filing_id") String filingId) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      FilingDetailQueryMessageType m = detailObjFac.createFilingDetailQueryMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      m.setQuerySubmitter(typ);
      m.setCaseCourt(XmlHelper.convertCourtType(courtId));
      m.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
      m.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      m.setDocumentIdentification(XmlHelper.convertId(filingId));
      FilingDetailResponseMessageType resp = port.get().getFilingDetails(m);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> Response.ok().entity(resp).build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
  }

  @DELETE
  @Path("/court/{court_id}/filings/{filing_id}")
  public Response cancelFiling(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("filing_id") String filingId) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      CancelFilingMessageType cancel = cancelObjFac.createCancelFilingMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      cancel.setQuerySubmitter(typ);
      cancel.setCaseCourt(XmlHelper.convertCourtType(courtId));
      cancel.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
      cancel.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cancel.setDocumentIdentification(XmlHelper.convertId(filingId));
      CancelFilingResponseMessageType resp = port.get().cancelFiling(cancel);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> Response.noContent().build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
  }
  
  private Optional<FilingReviewMDEPort> setupFilingPort(HttpHeaders httpHeaders) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromHeaders(httpHeaders);
    if (creds.isEmpty()) {
      return Optional.empty();
    }

    FilingReviewMDEPort port = makeFilingPort(filingFactory); 
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      System.err.println(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }
  
  private static FilingReviewMDEPort makeFilingPort(FilingReviewMDEService filingFactory) {
    FilingReviewMDEPort port = filingFactory.getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }
  
}
