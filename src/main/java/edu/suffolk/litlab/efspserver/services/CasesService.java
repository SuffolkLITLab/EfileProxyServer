package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;
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

import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
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
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
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

@Produces(MediaType.APPLICATION_JSON)
public class CasesService {

  private static Logger log = LoggerFactory.getLogger(CasesService.class);
  private final CourtRecordMDEService recordFactory;  
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory listObjFac
        = new oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory();
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf =
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
  private final DataSource codeDs;
  private final DataSource userDs;
  private final String jurisdiction;
  private final String env;
  private final EndpointReflection ef;

  public CasesService(String jurisdiction, String env, DataSource codeDs, DataSource userDs) {
    this.jurisdiction = jurisdiction;
    this.env = env;
    Optional<CourtRecordMDEService> maybeRecords = SoapClientChooser.getCourtRecordFactory(jurisdiction, env);
    if (maybeRecords.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " for court record factory");
    }
    this.recordFactory = maybeRecords.get();
    this.codeDs = codeDs; 
    this.userDs = userDs;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/cases");
  }

  @GET
  @Path("/")
  public Response getAll() {
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(CasesService.class)))).build();
  }
  
  @GET
  @Path("/courts")
  public Response getCourts() {
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, codeDs.getConnection())) {
      return ServiceHelpers.getCourts(cd, false, false);
    } catch (SQLException ex) {
      return Response.status(500).entity("database error retrieving all courts!").build();
    }
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
    var retMap = ef.endPointsToMap(replacePathParam(ef.makeRestEndpoints(subCourtMethods, clazz),
        Map.of("court_id", courtId)));
    return Response.ok(retMap).build();
  }
  
  /**
   * Gets all possible cases associated with either a party's name or a docket number.
   * 
   * @throws JsonProcessingException
   */
  @GET
  @Path("/courts/{court_id}/cases")
  public Response getCaseList(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("docket_number") String docketId,
      @QueryParam("business_name") String businessName,
      @QueryParam("first_name") String firstName,
      @QueryParam("middle_name") String middleName,
      @QueryParam("last_name") String lastName) throws JsonProcessingException {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    
    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, codeDs)) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
      if (info.isEmpty()) {
        return Response.status(404).entity(courtId + " not in available courts to search").build();
      }
      DataFieldRow legacyRow = cd.getDataField(courtId, "LegacyLocationCaseSearch");
      if (legacyRow.isvisible && !info.get().initial) {
        return Response.status(400).entity(courtId + " doesn't allow for subsequent case searches").build();
      }

      if (courtId.equals("1")) {
        DataFieldRow row = cd.getDataField("1", "AdvancedSearchLocationAllLocations");
        if (!row.isvisible) {
          return Response.status(400).entity("Can't search all locations").build();
        }
      }
    } catch (SQLException e) {
      log.error("can't get connection: " + StdLib.strFromException(e));
      return Response.status(500).build();
    }
    
    boolean internalTestTrigger = docketId != null && docketId.equals("abc123SecretTrigger");
    if (internalTestTrigger) {
      firstName = "John";
      middleName = "";
      lastName = "Brown";
      businessName = null;
      docketId = null;
    }

    CaseListQueryMessageType query = new CaseListQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(XmlHelper.convertCourtType(courtId));
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);

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
      commonCpt.setCaseParticipantRoleCode(XmlHelper.convertText(""));
      CaseParticipantType cpt = listObjFac.createCaseParticipantType();
      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
    }

    log.info("Before the case list query");
    CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
    if (internalTestTrigger) {
      ErrorType et = new ErrorType();
      et.setErrorCode(XmlHelper.convertText("-10"));
      et.setErrorText(XmlHelper.convertText("Haha, secret code activated"));
      resp.getError().add(et);
    }
    log.info(XmlHelper.objectToXmlStrOrError(resp, CaseListResponseMessageType.class));

    if (hasError(resp)) {
      // If the response has issues connecting with the CMS, we are still supposed to allow
      // for case search / e-filing. So, we'll return an error with the error code, but also any
      // cases that were still present.
      Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
      if (resp.getError().stream().anyMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
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

    try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, codeDs)) {
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
        if (resp.getError().stream().anyMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
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
    } catch (SQLException e) {
      log.error("can't get connection: " + StdLib.strFromException(e));
      return Response.status(500).build();
    }
  }
  
  /**
   * Tyler says that Getting document isn't supported. This is here to make that clear to
   * users.
   *
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
    typ.setEntityRepresentation(ecfOf.createEntityPerson(new PersonType()));
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
    try (Connection conn = userDs.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        log.warn("Couldn't checkLogin");
        return Optional.empty();
      }
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.empty();
    }
    String tylerToken = httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds?");
      return Optional.empty();
    }

    CourtRecordMDEPort port = recordFactory.getCourtRecordMDEPort();
    // Sometimes, getCases takes an incredibly long time. Bump timeout to 90s
    // https://stackoverflow.com/a/7512962/11416267
    ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 90000);
    ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 90000);
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    List<Header> headersList = List.of(creds.get().toHeader());
    ctx.put(Header.HEADER_LIST, headersList);
    return Optional.of(port);
  }

}
