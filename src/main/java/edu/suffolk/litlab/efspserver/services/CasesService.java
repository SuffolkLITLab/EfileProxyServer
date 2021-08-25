package edu.suffolk.litlab.efspserver.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.db.LoginInfo;
import edu.suffolk.litlab.efspserver.docassemble.NameDocassembleDeserializer;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.EntityType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.CaseListResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryCriteriaType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationquerymessage_4.ServiceInformationQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4.ServiceInformationResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import tyler.ecf.extensions.serviceattachcaselistquerymessage.ServiceAttachCaseListQueryMessageType;
import tyler.ecf.extensions.serviceattachcaselistresponsemessage.ServiceAttachCaseListResponseMessageType;
import tyler.ecf.extensions.serviceinformationhistoryquerymessage.ServiceInformationHistoryQueryMessageType;
import tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ServiceInformationHistoryResponseMessageType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;

@Path("/cases/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CasesService {

  private static Logger log = LoggerFactory.getLogger(CasesService.class);
  private SecurityHub security;
  private CodeDatabase cd;
  private static CourtRecordMDEService recordFactory = new CourtRecordMDEService(
      CourtRecordMDEService.WSDL_LOCATION, 
      CourtRecordMDEService.SERVICE);
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType cpt
        = new oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType();
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf = 
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType commonCpt = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType();

  public CasesService(SecurityHub security, CodeDatabase cd) {
    this.security = security;
    this.cd = cd;
  }
  
  @GET
  @Path("/courts/{court_id}/cases")
  public Response getCaseList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      String queryInfo) throws JsonMappingException, JsonProcessingException, JAXBException {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    try {
      List<String> allLocs = cd.getAllLocations();
      if (!allLocs.contains(courtId)) {
        return Response.status(404).entity(courtId + " not in available courts to search").build();
      }
    } catch (SQLException e) {
      log.error(e.toString()); 
    }
    
    if (courtId.equals("1")) {
      DataFieldRow row = cd.getDataField("1", "AdvancedSearchLocationAllLocations");
      if (!row.isvisible) {
        return Response.status(400).entity("Can't search all locations").build();
      }
    }
    
    CaseListQueryMessageType query = new CaseListQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(XmlHelper.convertCourtType(courtId));
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(queryInfo);
    if (node.has("docket_id") && node.get("docket_id").isTextual()) {
      String docketId = node.get("docket_id").asText();
      CaseType ct = new CaseType();
      ct.setCaseDocketID(XmlHelper.convertString(docketId));
      query.getCaseListQueryCase().add(ct);
    }
    if (node.has("person_name") && node.get("person_name").isObject()) {
      FailFastCollector collector = new FailFastCollector();
      Name maybeName;
      try {
        maybeName = NameDocassembleDeserializer.fromNode(node.get("person_name"), collector);
      } catch (FilingError err) {
        return Response.status(400).entity("Name needs to be a JSON object with first, middle, last, etc.").build();
      }
      PersonType pt = ecfOf.createPersonType();
      pt.setPersonName(maybeName.getNameType());
      
      
      commonCpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
      commonCpt.setCaseParticipantRoleCode(XmlHelper.convertText(""));

      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
    }
    CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getCase()).build();
  }
  
  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}")
  public Response getCase(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("case_tracking_id") String caseId) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    
    CaseQueryMessageType query = new CaseQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(XmlHelper.convertCourtType(courtId));
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    query.setCaseTrackingID(XmlHelper.convertString(caseId));
    CaseQueryCriteriaType crit = new CaseQueryCriteriaType();
    // TODO(brycew): should this be configurable?
    crit.setIncludeParticipantsIndicator(XmlHelper.convertBool(true));
    crit.setIncludeDocketEntryIndicator(XmlHelper.convertBool(false));
    crit.setIncludeCalendarEventIndicator(XmlHelper.convertBool(false));
    crit.setDocketEntryTypeCodeFilterText(XmlHelper.convertText("false"));
    crit.setCalendarEventTypeCodeFilterText(XmlHelper.convertText("false"));
    query.setCaseQueryCriteria(crit);
    CaseResponseMessageType resp = maybePort.get().getCase(query);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getCase()).build();
  }
  
  /**
   * Tyler says that Getting document isn't supported. This is here to make that clear to
   * users.
   * @param httpHeaders
   * @param courtId
   * @param caseId
   * @return
   */
  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/documents")
  public Response getDocument(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("case_tracking_id") String caseId) {
    return Response.status(405).build();
  }
  
  @GET
  @Path("/courts/{court_id}/service-contacts/{service_contact_id}/cases")
  public Response getServiceAttachCaseList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, 
      @PathParam("service_contact_id") String serviceId) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    
    ServiceAttachCaseListQueryMessageType query = new ServiceAttachCaseListQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(XmlHelper.convertCourtType(courtId));
    query.setServiceContactIdentification(XmlHelper.convertId(serviceId));
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ServiceAttachCaseListResponseMessageType resp = maybePort.get().getServiceAttachCaseList(query);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getCase()).build();
  }
  
  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information")
  public Response getServiceInformation(@Context HttpHeaders httpHeaders, 
      @PathParam("court_id") String courtId, @PathParam("case_tracking_id") String caseId) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    
    ServiceInformationQueryMessageType query = new ServiceInformationQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(XmlHelper.convertCourtType(courtId));
    query.setCaseTrackingID(XmlHelper.convertString(caseId));
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ServiceInformationResponseMessageType resp = maybePort.get().getServiceInformation(query);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getServiceRecipient()).build();
  }
  
  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information-history")
  public Response getServiceInformationHistory(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, @PathParam("case_tracking_id") String caseId) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    ServiceInformationHistoryQueryMessageType query = new ServiceInformationHistoryQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(XmlHelper.convertCourtType(courtId));
    query.setCaseTrackingID(XmlHelper.convertString(caseId));
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ServiceInformationHistoryResponseMessageType resp = maybePort.get().getServiceInformationHistory(query);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getServiceRecipient()).build();
  }
  
  private boolean hasError(QueryResponseMessageType resp) {
    return resp.getError().size() > 1 || 
        (resp.getError().size() == 1 && !resp.getError().get(0).getErrorCode().getValue().equals("0"));
  }

  private Optional<CourtRecordMDEPort> setupRecordPort(HttpHeaders httpHeaders) {
    String activeToken = httpHeaders.getHeaderString("X-API-KEY");
    Optional<LoginInfo> tylerCreds = security.checkLogin(activeToken, "tyler");
    if (tylerCreds.isEmpty()) {
      log.warn("Couldn't checkLogin");
      return Optional.empty();
    }
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerCreds.get().usableToken);
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
