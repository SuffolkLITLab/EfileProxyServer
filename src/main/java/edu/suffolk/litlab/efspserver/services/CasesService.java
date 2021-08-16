package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import gov.niem.niem.niem_core._2.CaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.CaseListResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;

@Path("/cases/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CasesService {

  private static Logger log = LoggerFactory.getLogger(CasesService.class);
  private SecurityHub security;
  private static CourtRecordMDEService recordFactory = new CourtRecordMDEService(
      CourtRecordMDEService.WSDL_LOCATION, 
      CourtRecordMDEService.SERVICE);
  
  public CasesService(SecurityHub security) {
    this.security = security;
  }
  
  @GET
  @Path("/court/{court_id}/case")
  public Response getCaseList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("person_name") String personName,
      @QueryParam("docket_id") String docketId,
      @QueryParam("org_name") String orgName) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(403).build();
    }
    
    CaseListQueryMessageType query = new CaseListQueryMessageType();
    if (!docketId.isBlank()) {
      CaseType ct = new CaseType();
      ct.setCaseDocketID(XmlHelper.convertString(docketId));
      query.getCaseListQueryCase().add(ct);
    }
    if (!personName.isBlank()) {
      CaseParticipantType cpt = new CaseParticipantType();
      // TODO(brycew): CONTINUE: add case participant for org and person here
      query.getCaseListQueryCaseParticipant().add(cpt);
    }
    CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
    return Response.ok(resp.getCase()).build();
  }
  

  private Optional<CourtRecordMDEPort> setupRecordPort(HttpHeaders httpHeaders) {
    String activeToken = httpHeaders.getHeaderString("X-API-KEY");
    Optional<String> tylerCreds = security.checkLogin(activeToken, "tyler");
    if (tylerCreds.isEmpty()) {
      log.warn("Couldn't checkLogin");
      return Optional.empty();
    }
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerCreds.get());
    if (creds.isEmpty()) {
      log.warn("No creds?");
      return Optional.empty();
    }

    CourtRecordMDEPort port = recordFactory.getCourtRecordMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      log.warn(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }

}
