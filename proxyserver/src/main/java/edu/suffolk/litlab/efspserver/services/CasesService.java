package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efspserver.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efspserver.ecf4.SoapClientChooser;
import edu.suffolk.litlab.efspserver.tyler.TylerLogin;
import edu.suffolk.litlab.efspserver.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFieldRow;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import javax.sql.DataSource;
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
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory
      listObjFac =
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory();
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfOf =
      new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
  private final DataSource userDs;
  private final Supplier<CodeDatabase> cdSupplier;
  private final String jurisdiction;
  private final EndpointReflection ef;

  public CasesService(
      String jurisdiction, String env, DataSource userDs, Supplier<CodeDatabase> cdSupplier) {
    this.jurisdiction = jurisdiction;
    Optional<CourtRecordMDEService> maybeRecords =
        SoapClientChooser.getCourtRecordFactory(jurisdiction, env);
    if (maybeRecords.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " for court record factory");
    }
    this.recordFactory = maybeRecords.get();
    this.cdSupplier = cdSupplier;
    this.userDs = userDs;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/cases");
  }

  @GET
  @Path("/")
  public Response getAll() {
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(CasesService.class))))
        .build();
  }

  @GET
  @Path("/courts")
  public Response getCourts() {
    try (CodeDatabase cd = cdSupplier.get()) {
      return ServiceHelpers.getCourts(cd, false, false).build();
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
    var retMap =
        ef.endPointsToMap(
            replacePathParam(
                ef.makeRestEndpoints(subCourtMethods, clazz), Map.of("court_id", courtId)));
    return Response.ok(retMap).build();
  }

  /**
   * Gets all possible cases associated with either a party's name or a docket number.
   *
   * @throws JsonProcessingException
   */
  @GET
  @Path("/courts/{court_id}/cases")
  public Response getCaseList(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @QueryParam("docket_number") String docketId,
      @QueryParam("business_name") String businessName,
      @QueryParam("first_name") String firstName,
      @QueryParam("middle_name") String middleName,
      @QueryParam("last_name") String lastName)
      throws JsonProcessingException {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getCaseList");
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    try (CodeDatabase cd = cdSupplier.get()) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
      if (info.isEmpty()) {
        return Response.status(404).entity(courtId + " not in available courts to search").build();
      }

      // NOTE(brycew): Tyler's docs for "LegacyLocationCaseSearch" says:
      // "Provides requirements regarding restricting search location to only those locations which
      // allow initial filings. When IsVisible=True, only locations which allow initial filings
      // will be allowed." Unfortunately, this doesnt make any sense, and we can still search at
      // locations where LegacyLocation is true and initial is False. So turning this off for now.
      // DataFieldRow legacyRow = cd.getDataField(courtId, "LegacyLocationCaseSearch");

      // if (legacyRow.isvisible && !info.get().initial) {
      //  return Response.status(400)
      //      .entity(courtId + " doesn't allow for subsequent case searches")
      //      .build();
      // }

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

    CaseListQueryMessageType query = new CaseListQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);

    if (docketId != null) {
      CaseType ct = new CaseType();
      ct.setCaseDocketID(Ecf4Helper.convertString(docketId));
      query.getCaseListQueryCase().add(ct);
    }

    if (firstName != null && lastName != null) {
      Name maybeName = new Name(firstName, middleName, lastName);
      PersonType pt = ecfOf.createPersonType();
      pt.setPersonName(maybeName.getNameType());

      var commonCpt = ecfOf.createCaseParticipantType();
      commonCpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
      commonCpt.setCaseParticipantRoleCode(Ecf4Helper.convertText(""));

      CaseParticipantType cpt = listObjFac.createCaseParticipantType();
      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
    }
    if (businessName != null) {
      OrganizationType ot = ecfOf.createOrganizationType();
      ot.setOrganizationName(Ecf4Helper.convertText(businessName));
      var commonCpt = ecfOf.createCaseParticipantType();
      commonCpt.setEntityRepresentation(ecfOf.createEntityOrganization(ot));
      commonCpt.setCaseParticipantRoleCode(Ecf4Helper.convertText(""));
      CaseParticipantType cpt = listObjFac.createCaseParticipantType();
      cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
      query.getCaseListQueryCaseParticipant().add(cpt);
    }

    log.info("Before the case list query");
    CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
    log.info(Ecf4Helper.objectToXmlStrOrError(resp, CaseListResponseMessageType.class));

    MDCWrappers.removeAllMDCs();
    if (hasError(resp)) {
      // If the response has issues connecting with the CMS, we are still supposed to allow
      // for case search / e-filing. So, we'll return an error with the error code, but also any
      // cases that were still present.
      Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
      if (resp.getError().stream()
          .anyMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
        return Response.status(203).entity(resp.getCase()).build();
      }
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getCase()).build();
  }

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}")
  public Response getCase(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getCase");
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      MDCWrappers.removeAllMDCs();
      return Response.status(401).build();
    }

    try (CodeDatabase cd = cdSupplier.get()) {
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
      query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
      query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
      query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      query.setCaseTrackingID(Ecf4Helper.convertString(caseId));
      query.setCaseQueryCriteria(EcfCaseTypeFactory.getCriteria());
      CaseResponseMessageType resp = maybePort.get().getCase(query);
      int responseCode = 200;
      if (hasError(resp)) {
        // If the response has issues connecting with the CMS, we are still supposed to allow
        // for case search / e-filing. So, we'll return an error with the error code, but also any
        // cases that were still present.
        Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
        if (resp.getError().stream()
            .anyMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
          responseCode = 203;
        } else {
          return Response.status(400).entity(resp.getError()).build();
        }
      }

      if (locationInfo.get().hasprotectedcasetypes) {
        CaseType caseType = resp.getCase().getValue();
        Optional<CaseAugmentationType> caseAug = EcfCaseTypeFactory.getCaseAugmentation(caseType);
        caseAug.ifPresent(
            aug -> {
              if (locationInfo
                  .get()
                  .protectedcasetypes
                  .contains(aug.getCaseTypeText().getValue())) {
                TextType protectedText =
                    Ecf4Helper.convertText(locationInfo.get().protectedcasereplacementstring);
                aug.setCaseTypeText(protectedText);
                caseType.setCaseCategoryText(protectedText);
              }
            });
      }
      return Response.status(responseCode).entity(resp.getCase()).build();
    } catch (SQLException e) {
      log.error("can't get connection: " + StdLib.strFromException(e));
      return Response.status(500).build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  /**
   * Tyler says that Getting document isn't supported. This is here to make that clear to users.
   *
   * @param httpHeaders
   * @param courtId
   * @param caseId
   * @return
   */
  @SuppressWarnings("static-method")
  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/documents")
  public Response getDocument(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    return Response.status(405).build();
  }

  @GET
  @Path("/courts/{court_id}/service-contacts/{service_contact_id}/cases")
  public Response getServiceAttachCaseList(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("service_contact_id") String serviceId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceAttachCaseList");
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    ServiceAttachCaseListQueryMessageType query = new ServiceAttachCaseListQueryMessageType();
    EntityType typ = new EntityType();
    typ.setEntityRepresentation(ecfOf.createEntityPerson(new PersonType()));
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setServiceContactIdentification(Ecf4Helper.convertId(serviceId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ServiceAttachCaseListResponseMessageType resp = maybePort.get().getServiceAttachCaseList(query);
    MDCWrappers.removeAllMDCs();
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getCase()).build();
  }

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information")
  public Response getServiceInformation(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceInformation");
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    ServiceInformationQueryMessageType query = new ServiceInformationQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setCaseTrackingID(Ecf4Helper.convertString(caseId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ServiceInformationResponseMessageType resp = maybePort.get().getServiceInformation(query);
    MDCWrappers.removeAllMDCs();
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getServiceRecipient()).build();
  }

  @GET
  @Path("/courts/{court_id}/cases/{case_tracking_id}/service-information-history")
  public Response getServiceInformationHistory(
      @Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId,
      @PathParam("case_tracking_id") String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceInformationHistory");
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    ServiceInformationHistoryQueryMessageType query =
        new ServiceInformationHistoryQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setCaseTrackingID(Ecf4Helper.convertString(caseId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    ServiceInformationHistoryResponseMessageType resp =
        maybePort.get().getServiceInformationHistory(query);
    MDCWrappers.removeAllMDCs();
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    return Response.ok(resp.getServiceRecipient()).build();
  }

  private static boolean hasError(QueryResponseMessageType resp) {
    return resp.getError().size() > 1
        || (resp.getError().size() == 1
            && !resp.getError().get(0).getErrorCode().getValue().equals("0"));
  }

  private Optional<CourtRecordMDEPort> setupRecordPort(HttpHeaders httpHeaders) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    Optional<AtRest> atRest = Optional.empty();
    String tylerToken =
        httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
    try (LoginDatabase ld = new LoginDatabase(userDs.getConnection())) {
      atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        log.warn("Couldn't checkLogin");
        return Optional.empty();
      }
      MDC.put(MDCWrappers.USER_ID, ld.makeHash(tylerToken));
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.empty();
    }
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds?");
      MDCWrappers.removeAllMDCs();
      return Optional.empty();
    }

    CourtRecordMDEPort port = recordFactory.getCourtRecordMDEPort();

    // Sometimes, getCases takes an incredibly long time. Bump timeout to 3 minutes
    Client client = ClientProxy.getClient(port);
    HTTPConduit http = (HTTPConduit) client.getConduit();
    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    httpClientPolicy.setConnectionTimeout(180_000);
    httpClientPolicy.setReceiveTimeout(180_000);
    http.setClient(httpClientPolicy);

    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    List<Header> headersList = List.of(creds.get().toHeader());
    ctx.put(Header.HEADER_LIST, headersList);
    return Optional.of(port);
  }
}
