package edu.suffolk.litlab.efspserver.ecf5;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.replacePathParam;

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
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.OrganizationType;
import gov.niem.release.niem.niem_core._4.PersonType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.CaseListQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.GetCaseListRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseListRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseListResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDEService;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.BindingProvider;
import tyler.ecf.v5_0.extensions.common.CaseListQueryCriteriaAugmentationType;

public class CasesService extends CasesServiceAPI {
  private static Logger log = LoggerFactory.getLogger(CasesService.class);
  private final CourtRecordMDEService recordFactory;
  private final Supplier<LoginDatabase> ldSupplier;
  private final Supplier<CodeDatabase> cdSupplier;
  private final String jurisdiction;
  private final EndpointReflection ef;
  private final gov.niem.release.niem.niem_core._4.ObjectFactory niemCoreObjFac = new gov.niem.release.niem.niem_core._4.ObjectFactory();
  private final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerCommonObjFac = new tyler.ecf.v5_0.extensions.common.ObjectFactory();

  public CasesService(String jurisdiction, String env, Supplier<LoginDatabase> ldSupplier, Supplier<CodeDatabase> cdSupplier) {
    this.jurisdiction = jurisdiction;
    Optional<CourtRecordMDEService> maybeRecords = SoapClientChooser.getCourtRecordFactory(jurisdiction, env);
    if (maybeRecords.isEmpty()) {
      throw new RuntimeException("Can find " + jurisdiction + " in " + env + " for court record factory");
    }
    this.recordFactory = maybeRecords.get();
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
    Optional<CourtRecordMDE> maybePort = setupRecordPort(httpHeaders);
    if (maybePort.isEmpty()) {
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
    }

    GetCaseListRequestMessageType query = new GetCaseListRequestMessageType();
    query.setCaseCourt(Ecf5Helper.convertCourt(courtId));
    var did = new IdentificationType();
    did.setIdentificationID(Ecf5Helper.convertString("1"));
    did.setIdentificationSourceText(Ecf5Helper.convertText("FilingAssembly"));
    did.setIdentificationCategoryDescriptionText(Ecf5Helper.convertText("messageID"));
    query.getDocumentIdentification().add(did);
    query.setSendingMDELocationID(Ecf5Helper.convertId(ServiceHelpers.EXTERNAL_URL));
    query.setServiceInteractionProfileCode(Ecf5Helper.convertNormalizedString("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-5.0"));
    query.setDocumentPostDate(Ecf5Helper.convertNow());
    
    if (docketId != null) {
      CaseListQueryCriteriaType criteria = new CaseListQueryCriteriaType();
      CaseListQueryCriteriaAugmentationType aug = new CaseListQueryCriteriaAugmentationType();
      aug.setCaseNumberText(Ecf5Helper.convertText(docketId));
      criteria.getObjectAugmentationPoint().add(tylerCommonObjFac.createCaseListQueryCriteriaAugmentation(aug));
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

    GetCaseListResponseType resp = maybePort.get().getCaseList(req);
    log.info(Ecf5Helper.objectToXmlStrOrError(resp, GetCaseListResponseType.class));

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

  private static boolean hasError(QueryResponseMessageType resp) {
    return resp.getError().size() > 1
        || (resp.getError().size() == 1
            && !resp.getError().get(0).getErrorCode().getValue().equals("0"));
  }

  private Optional<CourtRecordMDE> setupRecordPort(HttpHeaders httpHeaders) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    Optional<AtRest> atRest = Optional.empty();
    String tylerToken =
        httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
    try (LoginDatabase ld = ldSupplier.get()) {
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
    Optional<TylerUserNamePassword> creds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds?");
      MDCWrappers.removeAllMDCs();
      return Optional.empty();
    }

    CourtRecordMDE port = recordFactory.getCourtRecordMDE();
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
    return Optional.of(port);
  }
}
