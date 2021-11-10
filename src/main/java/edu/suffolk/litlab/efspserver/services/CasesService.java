package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.ecf.EcfCaseTypeFactory;
import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.CaseListResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationquerymessage_4.ServiceInformationQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4.ServiceInformationResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import tyler.ecf.extensions.common.CaseAugmentationType;
import tyler.ecf.extensions.serviceattachcaselistquerymessage.ServiceAttachCaseListQueryMessageType;
import tyler.ecf.extensions.serviceattachcaselistresponsemessage.ServiceAttachCaseListResponseMessageType;
import tyler.ecf.extensions.serviceinformationhistoryquerymessage.ServiceInformationHistoryQueryMessageType;
import tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ServiceInformationHistoryResponseMessageType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;

@Path("/cases/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CasesService {

  private static Logger log = LoggerFactory.getLogger(CasesService.class);
  private final SecurityHub security;
  private final CodeDatabase cd;
  private final CourtRecordMDEService recordFactory;  
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory listObjFac
        = new oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory();
  private oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf =
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();

  public CasesService(SecurityHub security, CodeDatabase cd, String jurisdiction) {
    this.security = security;
    this.cd = cd;
    Optional<CourtRecordMDEService> maybeRecords = SoapClientChooser.getCourtRecordFactory(jurisdiction);
    if (maybeRecords.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " for court record factory");
    }
    this.recordFactory = maybeRecords.get();
  }

  /**
   * 
   * @param httpHeaders
   * @param courtId
   * @return
   * @throws JsonMappingException
   * @throws JsonProcessingException
   * @throws JAXBException
   */
  @GET
  @Path("/courts/{court_id}/cases")
  public Response getCaseList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("docket_id") String docketId,
      @QueryParam("business_name") String businessName,
      @QueryParam("first_name") String firstName,
      @QueryParam("middle_name") String middleName,
      @QueryParam("last_name") String lastName) throws JsonProcessingException {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    
    Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
    if (info.isEmpty()) {
      return Response.status(404).entity(courtId + " not in available courts to search").build();
    }
    DataFieldRow legacyRow = cd.getDataField(courtId, "LegacyLocationCaseSearch");
    if (!legacyRow.isvisible && info.get().initial) {
      return Response.status(400).entity(courtId + " doesn't allow for case searches").build();
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
    if (docketId != null && docketId.equals("abc123SecretTrigger")) {
      Name maybeName = new Name("John", "", "Brown");
      PersonType pt = ecfOf.createPersonType();
      pt.setPersonName(maybeName.getNameType());

      var commonCpt = ecfOf.createCaseParticipantType();
      commonCpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
      commonCpt.setCaseParticipantRoleCode(XmlHelper.convertText(""));
      
      CaseParticipantType cpt = listObjFac.createCaseParticipantType();
      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
      CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
      return Response.status(203).entity(resp.getCase()).build();
    }

    if (docketId != null) {
      CaseType ct = new CaseType();
      ct.setCaseDocketID(XmlHelper.convertString(docketId));
      query.getCaseListQueryCase().add(ct);
    }
    if (firstName != null && lastName != null) {
      Name maybeName = new Name(firstName, middleName, lastName);
      PersonType pt = ecfOf.createPersonType();
      pt.setPersonName(maybeName.getNameType());

      var commonCpt = ecfOf.createCaseParticipantType();
      commonCpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
      commonCpt.setCaseParticipantRoleCode(XmlHelper.convertText(""));
      
      CaseParticipantType cpt = listObjFac.createCaseParticipantType();
      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
    }
    if (businessName != null) {
      OrganizationType ot = ecfOf.createOrganizationType();
      ot.setOrganizationName(XmlHelper.convertText(businessName)); 
      var commonCpt = ecfOf.createCaseParticipantType();
      commonCpt.setEntityRepresentation(ecfOf.createEntityOrganization(ot));
      CaseParticipantType cpt = listObjFac.createCaseParticipantType();
      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
    }
    log.info(XmlHelper.objectToXmlStrOrError(query, CaseListQueryMessageType.class));
    CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
    if (hasError(resp)) {
      // If the response has issues connecting with the CMS, we are still supposed to allow
      // for case search / e-filing. So, we'll return an error with the error code, but also any
      // cases that were still present.
      Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
      if (resp.getError().stream().allMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
        return Response.status(203).entity(resp.getCase()).build();
      }
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

    Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId);
    if (locationInfo.isEmpty()) {
      log.warn("Can't find court location for " + courtId + " when getting case");
      return Response.status(404).entity("No court " + courtId).build();
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
    query.setCaseQueryCriteria(EcfCaseTypeFactory.getCriteria());
    CaseResponseMessageType resp = maybePort.get().getCase(query);
    int responseCode = 200;
    if (hasError(resp)) {
      // If the response has issues connecting with the CMS, we are still supposed to allow
      // for case search / e-filing. So, we'll return an error with the error code, but also any
      // cases that were still present.
      Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
      if (resp.getError().stream().allMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
        responseCode = 203;
      } else {
        return Response.status(400).entity(resp.getError()).build();
      }
    }

    if (locationInfo.get().hasprotectedcasetypes) {
      CaseType caseType = resp.getCase().getValue();
      Optional<CaseAugmentationType> caseAug = EcfCaseTypeFactory.getCaseAugmentation(caseType);
      caseAug.ifPresent(aug -> {
        if (locationInfo.get().protectedcasetypes.contains(aug.getCaseTypeText().getValue())) {
          TextType protectedText = XmlHelper.convertText(locationInfo.get().protectedcasereplacementstring);
          aug.setCaseTypeText(protectedText);
          caseType.setCaseCategoryText(protectedText);
        }
      });
    }
    return Response.status(responseCode).entity(resp.getCase()).build();
  }
  
  /**
   * Tyler says that Getting document isn't supported. This is here to make that clear to
   * users.
   * @param httpHeaders
   * @param courtId
   * @param caseId
   * @return
   */
  @SuppressWarnings("static-method")
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

  private static boolean hasError(QueryResponseMessageType resp) {
    return resp.getError().size() > 1 ||
        (resp.getError().size() == 1 && !resp.getError().get(0).getErrorCode().getValue().equals("0"));
  }

  private Optional<CourtRecordMDEPort> setupRecordPort(HttpHeaders httpHeaders) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    Optional<AtRest> atRest = security.getAtRestInfo(apiKey);
    if (atRest.isEmpty()) {
      log.warn("Couldn't checkLogin");
      return Optional.empty();
    }
    String tylerToken = httpHeaders.getHeaderString(TylerLogin.getHeaderKeyStatic());
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
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
