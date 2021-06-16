package edu.suffolk.assemblyline.efspserver.services;

import edu.suffolk.assemblyline.efspserver.TylerUserNamePassword;
import edu.suffolk.assemblyline.efspserver.XmlHelper;
import edu.suffolk.assemblyline.efspserver.codes.CodeDatabase;
import gov.niem.niem.niem_core._2.EntityType;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
import tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType;
import tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType;
import tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

@Path("/filingreview/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FilingReviewService {

  private FilingReviewMDEService filingFactory;
  private CodeDatabase cd;
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
  
  public FilingReviewService(CodeDatabase cd) {
    this.cd = cd;
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
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
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
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
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
        System.err.println(match.getCaseTrackingID());
        System.err.println(match);
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
