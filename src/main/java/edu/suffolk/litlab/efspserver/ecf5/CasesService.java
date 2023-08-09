package edu.suffolk.litlab.efspserver.ecf5;

import static edu.suffolk.litlab.efspserver.ecf5.Ecf5Helper.prep;
import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.services.CasesServiceAPI;
import edu.suffolk.litlab.efspserver.services.EndpointReflection;
import edu.suffolk.litlab.efspserver.services.MDCWrappers;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import edu.suffolk.litlab.efspserver.tyler.TylerLogin;
import edu.suffolk.litlab.efspserver.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFieldRow;
import gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import gov.niem.release.niem.niem_core._4.CaseType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.OrganizationType;
import gov.niem.release.niem.niem_core._4.PersonType;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.CaseListQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.GetCaseListRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse.GetCaseListResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.CaseQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.GetCaseRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caseresponse.GetCaseResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest.GetServiceInformationRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse.GetServiceInformationResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseListRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseListResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetServiceInformationRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDEService;
import jakarta.ws.rs.core.HttpHeaders;
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
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.ecf.v5_0.extensions.common.CaseListQueryCriteriaAugmentationType;
import tyler.ecf.v5_0.extensions.servicecaselist.GetServiceCaseListMessageType;
import tyler.ecf.v5_0.extensions.servicecaselistresponse.GetServiceCaseListResponseMessageType;
import tyler.ecf.v5_0.extensions.serviceinformationhistory.GetServiceInformationHistoryMessageType;
import tyler.ecf.v5_0.extensions.tylercourtrecordmde.TylerCourtRecordMDE;
import tyler.ecf.v5_0.extensions.tylercourtrecordmde.TylerCourtRecordMDEService;
import tyler.ecf.v5_0.extensions.wrappers.GetServiceCaseListRequestType;
import tyler.ecf.v5_0.extensions.wrappers.GetServiceCaseListResponseType;
import tyler.ecf.v5_0.extensions.wrappers.GetServiceInformationHistoryRequestType;

public class CasesService extends CasesServiceAPI {
  private static Logger log = LoggerFactory.getLogger(CasesService.class);
  private final CourtRecordMDEService recordFactory;
  private final TylerCourtRecordMDEService tylerRecordFactory;
  private final Supplier<LoginDatabase> ldSupplier;
  private final Supplier<CodeDatabase> cdSupplier;
  private final String jurisdiction;
  private final EndpointReflection ef;
  private final gov.niem.release.niem.niem_core._4.ObjectFactory niemCoreObjFac =
      new gov.niem.release.niem.niem_core._4.ObjectFactory();
  private final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerCommonObjFac =
      new tyler.ecf.v5_0.extensions.common.ObjectFactory();

  public CasesService(
      String jurisdiction,
      String env,
      Supplier<LoginDatabase> ldSupplier,
      Supplier<CodeDatabase> cdSupplier) {
    this.jurisdiction = jurisdiction;
    Optional<CourtRecordMDEService> maybeRecords =
        SoapClientChooser.getCourtRecordFactory(jurisdiction, env);
    if (maybeRecords.isEmpty()) {
      throw new RuntimeException(
          "Can find " + jurisdiction + " in " + env + " for court record factory");
    }
    this.recordFactory = maybeRecords.get();
    Optional<TylerCourtRecordMDEService> maybeTylerRecords =
        SoapClientChooser.getTylerCourtRecordFactory(jurisdiction, env);
    if (maybeTylerRecords.isEmpty()) {
      throw new RuntimeException(
          "Can find " + jurisdiction + " in " + env + " for tyler court record factory");
    }
    this.tylerRecordFactory = maybeTylerRecords.get();
    this.cdSupplier = cdSupplier;
    this.ldSupplier = ldSupplier;
    this.ef = new EndpointReflection("/jurisdictions/" + jurisdiction + "/cases");
  }

  @Override
  public Response getAll() {
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(CasesService.class))))
        .build();
  }

  @Override
  public Response getCourts() {
    throw new RuntimeException("not implemented");
  }

  @Override
  public Response getEndpointsUnderCourt(String courtId) {
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

  @Override
  public Response getCaseList(
      HttpHeaders httpHeaders,
      String courtId,
      String docketId,
      String businessName,
      String firstName,
      String middleName,
      String lastName) {
    MDC.put(MDCWrappers.OPERATION, "ecf5.CasesService.getCaseList");
    CourtRecordMDE port = recordFactory.getCourtRecordMDE();
    if (!setupRecordPort(httpHeaders, (BindingProvider) port)) {
      MDCWrappers.removeAllMDCs();
      return Response.status(401).build();
    }

    try (CodeDatabase cd = cdSupplier.get()) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
      if (info.isEmpty()) {
        return Response.status(404).entity(courtId + " not in available courts to search").build();
      }
      DataFieldRow legacyRow = cd.getDataField(courtId, "LegacyLocationCaseSearch");
      if (legacyRow.isvisible && !info.get().initial) {
        return Response.status(400)
            .entity(courtId + " doesn't allow for subsequent case searches")
            .build();
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
    } finally {
      MDCWrappers.removeAllMDCs();
    }

    GetCaseListRequestMessageType query = prep(new GetCaseListRequestMessageType(), courtId);

    if (docketId != null) {
      CaseListQueryCriteriaType criteria = new CaseListQueryCriteriaType();
      CaseListQueryCriteriaAugmentationType aug = new CaseListQueryCriteriaAugmentationType();
      aug.setCaseNumberText(Ecf5Helper.convertText(docketId));
      criteria
          .getObjectAugmentationPoint()
          .add(tylerCommonObjFac.createCaseListQueryCriteriaAugmentation(aug));
      query.setCaseListQueryCriteria(criteria);
    }

    if (firstName != null && lastName != null) {
      Name maybeName = new Name(firstName, middleName, lastName);
      PersonType pt = niemCoreObjFac.createPersonType();
      pt.setPersonName(maybeName.getNameTypeEcf5());
      EntityType et = niemCoreObjFac.createEntityType();
      et.setEntityRepresentation(niemCoreObjFac.createEntityPerson(pt));
      CaseListQueryCriteriaType criteria = new CaseListQueryCriteriaType();
      criteria.setCaseParticipant(et);
      query.setCaseListQueryCriteria(criteria);
    }
    if (businessName != null) {
      OrganizationType ot = niemCoreObjFac.createOrganizationType();
      ot.setOrganizationName(Ecf5Helper.convertText(businessName));
      EntityType et = niemCoreObjFac.createEntityType();
      et.setEntityRepresentation(niemCoreObjFac.createEntityOrganization(ot));
      CaseListQueryCriteriaType criteria = new CaseListQueryCriteriaType();
      criteria.setCaseParticipant(et);
      query.setCaseListQueryCriteria(criteria);
    }
    GetCaseListRequestType req = new GetCaseListRequestType();
    req.setGetCaseListRequestMessage(query);

    GetCaseListResponseType resp = port.getCaseList(req);
    log.info(Ecf5Helper.objectToXmlStrOrError(resp, GetCaseListResponseType.class));

    GetCaseListResponseMessageType result = resp.getGetCaseListResponseMessage();
    MDCWrappers.removeAllMDCs();
    if (hasError(result)) {
      // If the response has issues connecting with the CMS, we are still supposed to allow
      // for case search / e-filing. So, we'll return an error with the error code, but also any
      // cases that were still present.
      Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10", "136");
      if (resp.getGetCaseListResponseMessage().getMessageStatus().getMessageContentError().stream()
          .anyMatch(
              err ->
                  cmsConnectionErrors.contains(
                      err.getErrorDescription().getErrorCodeText().getValue()))) {
        return Response.status(203).entity(result.getCase()).build();
      }
      return Response.status(400)
          .entity(result.getMessageStatus().getMessageHandlingError())
          .build();
    }
    return Response.ok(result.getCase()).build();
  }

  public static GetCaseRequestType makeCaseRequest(String courtId, String caseId) {
    GetCaseRequestMessageType query = prep(new GetCaseRequestMessageType(), courtId);
    CaseQueryCriteriaType criteria = new CaseQueryCriteriaType();
    criteria.setCaseTrackingID(Ecf5Helper.convertId(caseId));
    criteria.setIncludeParticipantsIndicator(Ecf5Helper.convertBool(true));

    // The below three lines set things in the XML that are required, but not supported,
    // i.e. they should always be false / empty, for silly tyler reasons.
    criteria.setIncludeCalendarEventIndicator(Ecf5Helper.convertBool(false));
    criteria.setIncludeDocketEntryIndicator(Ecf5Helper.convertBool(false));
    criteria.setCaseNumberText(Ecf5Helper.convertText(""));

    query.setCaseQueryCriteria(criteria);
    GetCaseRequestType msg = new GetCaseRequestType();
    msg.setGetCaseRequestMessage(query);
    return msg;
  }

  @Override
  public Response getCase(HttpHeaders httpHeaders, String courtId, String caseId) {
    MDC.put(MDCWrappers.OPERATION, "ecf5.CasesService.getCase");
    CourtRecordMDE port = recordFactory.getCourtRecordMDE();
    if (!setupRecordPort(httpHeaders, (BindingProvider) port)) {
      MDCWrappers.removeAllMDCs();
      return Response.status(401).build();
    }

    try (CodeDatabase cd = cdSupplier.get()) {
      Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId);
      if (locationInfo.isEmpty()) {
        log.warn("Can't find court location for " + courtId + " when getting case");
        return Response.status(404).entity("No court " + courtId).build();
      }
      GetCaseRequestType msg = makeCaseRequest(courtId, caseId);
      GetCaseResponseType resp = port.getCase(msg);
      GetCaseResponseMessageType result = resp.getGetCaseResponseMessage();
      int responseCode = 200;
      if (hasError(result)) {
        // If the response has issues connecting with the CMS, we are still supposed to allow
        // for case search / e-filing. So, we'll return an error with the error code, but also any
        // cases that were still present.
        Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
        if (result.getMessageStatus().getMessageContentError().stream()
            .anyMatch(
                err ->
                    cmsConnectionErrors.contains(
                        err.getErrorDescription().getErrorCodeText().getValue()))) {
          responseCode = 203;
        } else {
          return Response.status(400).entity(result.getMessageStatus()).build();
        }
      }

      if (locationInfo.get().hasprotectedcasetypes) {
        CaseType caseType = result.getCase().getValue();
        Optional<CaseAugmentationType> caseAug =
            Ecfv5CaseTypeFactory.getEcfCaseAugmentation(caseType);
        caseAug.ifPresent(
            aug -> {
              NormalizedString casetypeStr = null;
              List<JAXBElement<?>> restList = aug.getRest();
              for (var restItem : restList) {
                if (restItem.getValue() instanceof NormalizedString normalStr) {
                  casetypeStr = normalStr;
                  break;
                }
              }
              if (casetypeStr != null
                  && locationInfo.get().protectedcasetypes.contains(casetypeStr.getValue())) {
                casetypeStr.setValue(locationInfo.get().protectedcasereplacementstring);
              }
            });
      }
      return Response.status(responseCode).entity(result.getCase()).build();
    } catch (SQLException e) {
      log.error("can't get connection: " + StdLib.strFromException(e));
      return Response.status(500).build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  /** Tyler says that Getting document isn't supported. This is here to make that clear to users. */
  @Override
  public Response getDocument(HttpHeaders httpHeaders, String courtId, String caseId) {
    return Response.status(405).build();
  }

  @Override
  public Response getServiceAttachCaseList(
      HttpHeaders httpHeaders, String courtId, String serviceId) {
    MDC.put(MDCWrappers.OPERATION, "ecf5.CasesService.getServiceAttachCaseList");
    TylerCourtRecordMDE port = tylerRecordFactory.getTTylerCourtRecordMDE();
    if (!setupRecordPort(httpHeaders, (BindingProvider) port)) {
      MDCWrappers.removeAllMDCs();
      return Response.status(401).build();
    }
    GetServiceCaseListMessageType query = prep(new GetServiceCaseListMessageType(), courtId);
    query.setServiceRecipientID(Ecf5Helper.convertId(serviceId));
    GetServiceCaseListRequestType msg = new GetServiceCaseListRequestType();
    msg.setGetServiceCaseListMessage(query);
    GetServiceCaseListResponseType resp = port.getServiceCaseList(msg);
    GetServiceCaseListResponseMessageType result = resp.getGetServiceCaseListResponseMessage();
    if (hasError(result)) {
      return Response.status(400).entity(result).build();
    }
    return Response.ok(result).build();
  }

  @Override
  public Response getServiceInformation(HttpHeaders httpHeaders, String courtId, String caseId) {
    MDC.put(MDCWrappers.OPERATION, "ecf5.CasesService.getServiceAttachCaseList");
    CourtRecordMDE port = recordFactory.getCourtRecordMDE();
    if (!setupRecordPort(httpHeaders, (BindingProvider) port)) {
      return Response.status(401).build();
    }

    GetServiceInformationRequestMessageType query =
        prep(new GetServiceInformationRequestMessageType(), courtId);
    query.getCaseTrackingID().add(Ecf5Helper.convertId(caseId));
    // Required by the schema, but will never be used
    query.setCaseNumberText(Ecf5Helper.convertText(""));
    GetServiceInformationRequestType msg = new GetServiceInformationRequestType();
    msg.setGetServiceInformationRequestMessage(query);
    var resp = port.getServiceInformation(msg);
    GetServiceInformationResponseMessageType result =
        resp.getGetServiceInformationResponseMessage();
    MDCWrappers.removeAllMDCs();
    if (hasError(result)) {
      return Response.status(400).entity(result).build();
    }
    // Only returning the list of service recipient's, b/c that all
    // that Tyler has documented / seems to actually return from this response
    return Response.ok(result.getServiceRecipient()).build();
  }

  public Response getServiceInformationHistory(
      HttpHeaders httpHeaders, String courtId, String caseId) {
    MDC.put(MDCWrappers.OPERATION, "CasesService.getServiceInformationHistory");
    TylerCourtRecordMDE port = tylerRecordFactory.getTTylerCourtRecordMDE();
    if (!setupRecordPort(httpHeaders, (BindingProvider) port)) {
      return Response.status(401).build();
    }
    var query = prep(new GetServiceInformationHistoryMessageType(), courtId);
    query.getCaseTrackingID().add(Ecf5Helper.convertId(caseId));
    GetServiceInformationHistoryRequestType msg = new GetServiceInformationHistoryRequestType();
    msg.setGetServiceInformationHistoryMessage(query);
    var resp = port.getServiceInformationHistory(msg);
    MDCWrappers.removeAllMDCs();
    var result = resp.getGetServiceInformationHistoryResponseMessage();
    if (hasError(result)) {
      return Response.status(400).entity(result).build();
    }
    return Response.ok(result).build();
  }

  private static boolean hasError(ResponseMessageType resp) {
    MessageStatusType status = resp.getMessageStatus();
    return (!status.getMessageHandlingError().getErrorCodeText().getValue().equals("0")
        || status.getMessageContentError().size() >= 1);
  }

  /** Returns true if it works. */
  private boolean setupRecordPort(HttpHeaders httpHeaders, BindingProvider port) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    Optional<AtRest> atRest = Optional.empty();
    String tylerToken =
        httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
    try (LoginDatabase ld = ldSupplier.get()) {
      atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        log.warn("Couldn't checkLogin");
        return false;
      }
      MDC.put(MDCWrappers.USER_ID, ld.makeHash(tylerToken));
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return false;
    }
    Optional<TylerUserNamePassword> creds =
        TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds?");
      MDCWrappers.removeAllMDCs();
      return false;
    }

    // Sometimes, getCases takes an incredibly long time. Bump timeout to 90s
    // https://stackoverflow.com/a/7512962/11416267
    ((BindingProvider) port)
        .getRequestContext()
        .put("com.sun.xml.internal.ws.connect.timeout", 90000);
    ((BindingProvider) port)
        .getRequestContext()
        .put("com.sun.xml.internal.ws.request.timeout", 90000);
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    List<Header> headersList = List.of(creds.get().toHeader());
    ctx.put(Header.HEADER_LIST, headersList);
    return true;
  }
}
