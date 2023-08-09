package edu.suffolk.litlab.efspserver.ecf5;

import static edu.suffolk.litlab.efspserver.StdLib.exists;
import static edu.suffolk.litlab.efspserver.StdLib.strFromException;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.CaseServiceContact;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.JsonHelpers;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.services.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.FilingResult;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.tyler.TylerCodesSerializer;
import edu.suffolk.litlab.efspserver.tyler.TylerLogin;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.ComboCaseCodes;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.Disclaimer;
import edu.suffolk.litlab.efspserver.tyler.codes.ServiceCodeType;
import gov.niem.release.niem.niem_core._4.DateRangeType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.CancelFilingMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caseresponse.GetCaseResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ElectronicServiceInformationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.FilingStatusType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.MessageStatusAugmentationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest.FilingListQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistresponse.GetFilingListResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest.FilingStatusQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.CancelFilingRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.CancelFilingResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCaseRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetFilingListRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetFilingListResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetFilingStatusResponseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ReviewFilingRequestType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDEService;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.v5_0.extensions.filingservicerequest.GetFilingServiceMessageType;
import tyler.ecf.v5_0.extensions.servicetypesrequest.GetServiceTypesMessageType;
import tyler.ecf.v5_0.extensions.tylerfilingreviewmde.TylerFilingReviewMDE;
import tyler.ecf.v5_0.extensions.tylerfilingreviewmde.TylerFilingReviewMDEService;
import tyler.ecf.v5_0.extensions.wrappers.GetFilingServiceRequestType;
import tyler.ecf.v5_0.extensions.wrappers.GetServiceTypesRequestType;

public class Ecf5Filer extends EfmCheckableFilingInterface {
  private static Logger log = LoggerFactory.getLogger(Ecf5Filer.class);
  private final String jurisdiction;

  private static final PolicyCacher policyCacher = new PolicyCacher();
  private final CourtPolicyMDEService policyServFactory;
  private final FilingReviewMDEService reviewServFactory;
  private final TylerFilingReviewMDEService tylerReviewServFactory;
  private final String headerKey;
  private final Supplier<CodeDatabase> cdSupplier;

  // Object factories for the XML
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.ObjectFactory
      cancelObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest
          .ObjectFactory
      filinglistObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest
          .ObjectFactory
      filingstatusObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory
      paymentObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.ObjectFactory
      filingObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ObjectFactory
      wrapperObjFac;
  private final gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac;
  private final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac;
  private final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory ecfObjFac;

  public Ecf5Filer(String jurisdiction, String env, Supplier<CodeDatabase> cdSupplier) {
    this.jurisdiction = jurisdiction;
    TylerLogin login = new TylerLogin(jurisdiction, env);
    this.headerKey = login.getHeaderKey();
    Optional<CourtPolicyMDEService> maybePolicy =
        SoapClientChooser.getCourtPolicyFactory(jurisdiction, env);
    if (maybePolicy.isEmpty()) {
      throw new RuntimeException(
          "Cannot find " + jurisdiction + " in " + env + " for court policy service factory");
    }
    this.policyServFactory = maybePolicy.get();

    Optional<FilingReviewMDEService> maybeReview =
        SoapClientChooser.getFilingReviewFactory(jurisdiction, env);
    if (maybeReview.isEmpty()) {
      throw new RuntimeException(
          "Cannot find " + jurisdiction + " in " + env + " for filing review service factory");
    }
    this.reviewServFactory = maybeReview.get();

    Optional<TylerFilingReviewMDEService> maybeTylerReview =
        SoapClientChooser.getTylerFilingReviewFactory(jurisdiction, env);
    if (maybeTylerReview.isEmpty()) {
      throw new RuntimeException(
          "Cannot find "
              + jurisdiction
              + " in "
              + env
              + " for Tyler filing review service factory");
    }
    this.tylerReviewServFactory = maybeTylerReview.get();

    this.cdSupplier = cdSupplier;

    this.cancelObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.ObjectFactory();
    this.filinglistObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest
            .ObjectFactory();
    this.filingstatusObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest
            .ObjectFactory();
    this.filingObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.ObjectFactory();
    this.paymentObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory();
    this.wrapperObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ObjectFactory();
    this.niemObjFac = new gov.niem.release.niem.niem_core._4.ObjectFactory();
    this.tylerObjFac = new tyler.ecf.v5_0.extensions.common.ObjectFactory();
    this.ecfObjFac = new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory();
  }

  @Override
  public Result<FilingResult, FilingError> submitFilingIfReady(
      FilingInformation info, InfoCollector collector, String apiToken, ApiChoice choice) {
    Optional<FilingReviewMDE> port = Ecf5Helper.setupReviewPort(reviewServFactory, apiToken);
    if (port.isEmpty()) {
      return Result.err(
          FilingError.serverError("Coludn't make a servec MDE port with the given API key"));
    }

    String existingCaseTitle = null;
    String caseCategoryName = "";
    CoreMessageAndNames core;
    try {
      core = prepareFiling(info, collector);
      existingCaseTitle = core.existingCaseTitle;
      caseCategoryName = core.caseCategoryName;
    } catch (FilingError err) {
      return Result.err(err);
    }

    var msg = core.filingMsg;

    ReviewFilingRequestType req = wrapperObjFac.createReviewFilingRequestType();
    req.getFilingMessage().add(msg);
    req.setPaymentMessage(
        PaymentFactory.makePaymentMessage(info.getPaymentId(), this.jurisdiction));

    var resp = port.get().reviewFiling(req);

    BiFunction<IdentificationType, String, Boolean> filterId =
        (id, idType) -> {
          String text = id.getIdentificationCategoryDescriptionText().getValue();
          return text.equalsIgnoreCase(idType);
        };

    List<IdentificationType> ids =
        resp.getMessageStatus().getMessageStatusAugmentationPoint().stream()
            .filter(augPoint -> augPoint.getValue() instanceof MessageStatusAugmentationType)
            .flatMap(
                augPoint ->
                    ((MessageStatusAugmentationType) augPoint.getValue())
                        .getDocumentIdentification().stream())
            .toList();

    List<String> filingIdStrs =
        ids.stream()
            .filter(id -> filterId.apply(id, "filingID"))
            .map(id -> id.getIdentificationID().getValue())
            .collect(Collectors.toList());
    Optional<String> caseId =
        ids.stream()
            .filter(id -> filterId.apply(id, "caseID"))
            .map(id -> id.getIdentificationID().getValue())
            .findFirst();
    Optional<String> envelopeId =
        ids.stream()
            .filter(id -> filterId.apply(id, "envelopeID"))
            .map(id -> id.getIdentificationID().getValue())
            .findFirst();
    if (filingIdStrs.isEmpty()) {
      log.error("Couldn't get back the filing id from Tyler!");
      return Result.err(
          FilingError.serverError(
              "Couldn't get back filing id from tyler: "
                  + resp.getMessageStatus().getMessageContentError().stream()
                      .reduce(
                          "",
                          (str, err) -> {
                            return str
                                + ", "
                                + err.getErrorDescription().getErrorCodeDescriptionText();
                          },
                          (str, str2) -> str + str2)));
    }
    String caseTitle = (exists(existingCaseTitle)) ? existingCaseTitle : info.makeCaseTitle();

    return Result.ok(
        new FilingResult(
            caseId.get(),
            envelopeId.get(),
            filingIdStrs.stream().map(str -> UUID.fromString(str)).collect(Collectors.toList()),
            info.getLeadContact(),
            caseTitle,
            caseCategoryName,
            courtName));
  }

  private CoreMessageAndNames prepareFiling(
      FilingInformation info,
      InfoCollector collector,
      CourtPolicyMDE policyPort,
      CourtRecordMDE recordPort)
      throws FilingError {
    String existingCaseTitle = null;
    String caseCategoryName = "";
    try (CodeDatabase cd = cdSupplier.get()) {
      EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd, this.jurisdiction);
      var maybeLocationInfo = cd.getFullLocationInfo(info.getCourtLocation());
      if (maybeLocationInfo.isEmpty()) {
        collector.error(
            FilingError.serverError(
                "Court setup wrong: can't find full location info for " + info.getCourtLocation()));
      }

      var locationInfo = maybeLocationInfo.orElse(new CourtLocationInfo());
      String courtName = locationInfo.name;
      GetPolicyResponseMessageType policy =
          policyCacher.getPolicyFor(policyPort, info.getCourtLocation());

      if (!locationInfo.allowfilingintononindexedcase
          && info.getCaseDocketNumber().isPresent()
          && info.getPreviousCaseId().isEmpty()) {
        FilingError err =
            FilingError.malformedInterview(
                "Court "
                    + info.getCourtLocation()
                    + "doesn't allow subsequent filing into non-indexed cases. If this case is in"
                    + " the court system, provide the Case tracking ID. If it's not, don't provide"
                    + " the docket number.");
        collector.error(err);
      }

      var allDataFields = cd.getDataFields(locationInfo.code);
      TylerCodesSerializer tylerSerializer =
          new TylerCodesSerializer(cd, locationInfo, allDataFields);
      EcfCourtSpecificSerializer serializer =
          new EcfCourtSpecificSerializer(cd, locationInfo, allDataFields);
      boolean isInitialFiling =
          info.getPreviousCaseId().isEmpty() && info.getCaseDocketNumber().isEmpty();
      boolean isFirstIndexedFiling = info.getPreviousCaseId().isEmpty();
      ComboCaseCodes allCodes;
      if (!isFirstIndexedFiling) {
        // Get the existing case.
        GetCaseRequestType msg =
            CasesService.makeCaseRequest(locationInfo.code, info.getPreviousCaseId().get());
        GetCaseResponseMessageType resp = recordPort.getCase(msg).getGetCaseResponseMessage();
        if (resp.getCase() != null && resp.getCase().getValue() != null) {
          if (resp.getCase().getValue().getCaseTitleText() != null) {
            existingCaseTitle = resp.getCase().getValue().getCaseTitleText().getValue();
          }
          allCodes = serializer.serializeCaseCodesIndexed(info, collector, resp);
        } else {
          var filingVar =
              collector.requestVar(
                  "previous_case_id",
                  "Could not find the given case id (" + info.getPreviousCaseId().get() + ")",
                  "text");
          collector.addWrong(filingVar);
          allCodes = new ComboCaseCodes();
        }
      } else {
        allCodes = tylerSerializer.serializeCaseCodes(info, collector, isInitialFiling);
      }

      caseCategoryName = allCodes.cat.name;
      var msg = filingObjFac.createFilingMessageType();

      int i = 0;
      Map<String, Object> serviceContactXmlObjs = new HashMap<>();
      for (CaseServiceContact servContact : info.getServiceContacts()) {
        ElectronicServiceInformationType servInfo =
            ecfObjFac.createElectronicServiceInformationType();
        List<ServiceCodeType> types = cd.getServiceTypes(info.getCourtLocation());
        Optional<ServiceCodeType> serviceCode =
            types.stream()
                .filter(t -> t.code.equalsIgnoreCase(servContact.serviceType))
                .findFirst();
        if (serviceCode.isEmpty()) {
          InterviewVariable var =
              collector.requestVar(
                  "service_contact[" + i + "].service_type",
                  "service type should be",
                  "choices",
                  types.stream().map(t -> t.code).collect(Collectors.toList()));
          collector.addWrong(var);
        }
        var aug = tylerObjFac.createElectronicServiceAugmentationType();
        var servRecipient = tylerObjFac.createServiceRecipientType();
        var servContactID = Ecf5Helper.convertId(servContact.guid);
        servContactID.setIdentificationCategoryAbstract(
            tylerObjFac.createServiceTypeCode(
                Ecf5Helper.convertNormalizedString(serviceCode.get().code)));
        servRecipient.setServiceContactID(servContactID);
        serviceContactXmlObjs.put(servContact.refId, servInfo);
        aug.getServiceRecipient().add(servRecipient);
        msg.getElectronicServiceInformation().add(servInfo);
      }
      var pair =
          ecfCaseFactory.makeCaseTypeFromTylerCategory(
              locationInfo,
              allCodes,
              info,
              isInitialFiling,
              isFirstIndexedFiling,
              info.getMiscInfo(),
              serializer,
              tylerSerializer,
              collector,
              serviceContactXmlObjs);

      msg.setCase(niemObjFac.createCase(pair.getLeft()));
      return new CoreMessageAndNames(msg, null, null, null);
    } catch (SQLException ex) {
      log.error("IO Error when making filing! " + strFromException(ex));
      throw FilingError.serverError("Got Exception assembling the filing: " + ex);
    }
  }

  @Override
  public Result<Response, FilingError> getFilingFees(FilingInformation info, String apiToken) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingFees'");
  }

  @Override
  public Result<Response, FilingError> getServiceTypes(FilingInformation info, String apiToken) {
    String courtId = info.getCourtLocation();
    try {
      List<String> courtIds = getAllLocations();
      if (courtId != null && !courtId.equals("0") && !courtIds.contains(courtId)) {
        return Result.ok(
            Response.status(404).entity("Court " + courtId + " not in jurisdiction").build());
      }
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?" + ex);
      return Result.ok(
          Response.status(500).entity("Ops Error: Could not connect to database").build());
    }

    Optional<TylerFilingReviewMDE> port =
        Ecf5Helper.setupTylerReviewPort(tylerReviewServFactory, apiToken);
    if (port.isEmpty()) {
      return Result.err(
          FilingError.serverError("Couldn't create SOAP port object with token: " + apiToken));
    }

    var req = new GetServiceTypesRequestType();
    var msg = Ecf5Helper.prep(new GetServiceTypesMessageType(), courtId);
    msg.setCaseNewIndicator(
        Ecf5Helper.convertBool(
            info.getPreviousCaseId().isEmpty() && info.getCaseDocketNumber().isEmpty()));
    msg.setCaseTypeCode(Ecf5Helper.convertNormalizedString(info.getCaseTypeCode()));
    for (var filing : info.getFilings()) {
      filing
          .getFilingCode()
          .ifPresent(f -> msg.getRegisterActionDescriptionCode().add(Ecf5Helper.convertText(f)));
    }
    Optional<BigDecimal> maybeAmt =
        JsonHelpers.getNumberMember(info.getMiscInfo(), "amount_in_controversy");
    maybeAmt.ifPresent(amt -> msg.setAmountInControversy(Ecf5Helper.convertAmount(amt)));

    req.setGetServiceTypesMessage(msg);
    var resp = port.get().getServiceTypes(req);
    return Result.ok(
        Ecf5Helper.mapTylerCodesToHttp(
            resp.getGetServiceTypesResponseMessage().getMessageStatus(),
            () -> Response.ok().entity(resp.getGetServiceTypesResponseMessage()).build()));
  }

  @Override
  public Response getFilingList(
      String courtId,
      String submitterId,
      LocalDate startDate,
      LocalDate beforeDate,
      String caseNumber,
      String envelopeNumber,
      String filingStatus,
      String apiToken) {
    try {
      List<String> courtIds = getAllLocations();
      if (courtId != null && !courtId.equals("0") && !courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?" + ex);
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    Optional<FilingReviewMDE> port = Ecf5Helper.setupReviewPort(reviewServFactory, apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }

    var reqType =
        Ecf5Helper.prep(filinglistObjFac.createGetFilingListRequestMessageType(), courtId);
    if (courtId == null || courtId.equals("0")) {
      // Search all courts
      reqType.setCaseCourt(null);
    }

    var filingListQueryCriteria = new FilingListQueryCriteriaType();
    if (submitterId != null && !submitterId.isBlank()) {
      var id = Ecf5Helper.convertId(submitterId);
      gov.niem.release.niem.niem_core._4.PersonType per = niemObjFac.createPersonType();
      per.getPersonOtherIdentification().add(id);
      var entity = niemObjFac.createEntityType();
      entity.setEntityRepresentation(niemObjFac.createEntityPerson(per));
      filingListQueryCriteria.setDocumentSubmitter(entity);
    } else {
      filingListQueryCriteria.setDocumentSubmitter(null);
    }

    if (startDate != null && beforeDate != null) {
      var niemStart = Ecf5Helper.convertDate(startDate);
      // endCal is exclusive!
      var niemEnd = Ecf5Helper.convertDate(beforeDate);

      DateRangeType range = niemObjFac.createDateRangeType();
      range.setStartDate(niemStart);
      range.setEndDate(niemEnd);
      filingListQueryCriteria.setDateRange(range);
    }

    if (caseNumber != null && !caseNumber.isBlank()) {
      filingListQueryCriteria.setCaseNumberText(Ecf5Helper.convertText(caseNumber));
    }

    if (envelopeNumber != null && !envelopeNumber.isBlank()) {
      filingListQueryCriteria.setDocumentIdentification(Ecf5Helper.convertId(envelopeNumber));
    }

    if (filingStatus != null && !filingStatus.isBlank()) {
      var aug = tylerObjFac.createFilingListQueryCriteriaAugmentationType();
      var fst = new FilingStatusType();
      fst.setFilingReviewStatusCode(Ecf5Helper.convertNormalizedString(filingStatus));
      aug.setFilingStatus(fst);
      filingListQueryCriteria
          .getObjectAugmentationPoint()
          .add(tylerObjFac.createFilingListQueryCriteriaAugmentation(aug));
    }
    reqType.setFilingListQueryCriteria(filingListQueryCriteria);

    GetFilingListRequestType listWrapper = wrapperObjFac.createGetFilingListRequestType();
    listWrapper.setGetFilingListRequestMessage(reqType);

    GetFilingListResponseType resp = port.get().getFilingList(listWrapper);
    GetFilingListResponseMessageType respMsg = resp.getGetFilingListResponseMessage();

    return Ecf5Helper.mapTylerCodesToHttp(
        respMsg.getMessageStatus(),
        () -> {
          if (respMsg.getMatchingFiling().size() <= 0) {
            return Response.noContent().build();
          }
          return Response.ok()
              .entity(resp.getGetFilingListResponseMessage().getMatchingFiling())
              .build();
        });
  }

  @Override
  /**
   * In ECF5 there isn't a separate filing status vs filing details call, filing status returns
   * everything.
   */
  public Response getFilingStatus(String courtId, String filingId, String apiToken) {
    return getFilingInfoFromTyler(courtId, filingId, apiToken, false);
  }

  @Override
  public Response getFilingDetails(String courtId, String filingId, String apiToken) {
    return getFilingInfoFromTyler(courtId, filingId, apiToken, true);
  }

  private Response getFilingInfoFromTyler(
      String courtId, String filingId, String apiToken, boolean includeDetails) {
    try {
      List<String> courtIds = getAllLocations();
      if (courtId != null && !courtId.equals("0") && !courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?" + ex);
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    Optional<FilingReviewMDE> port = Ecf5Helper.setupReviewPort(reviewServFactory, apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }

    var req_msg =
        Ecf5Helper.prep(filingstatusObjFac.createGetFilingStatusRequestMessageType(), courtId);
    var queryCriteria = new FilingStatusQueryCriteriaType();
    queryCriteria.getDocumentIdentification().add(Ecf5Helper.convertId(filingId));

    var aug = tylerObjFac.createGetFilingStatusRequestMessageAugmentationType();
    aug.setIncludeFilingDetailIndicator(Ecf5Helper.convertBool(includeDetails));
    req_msg
        .getObjectAugmentationPoint()
        .add(tylerObjFac.createGetFilingStatusRequestMessageAugmentation(aug));

    var wrapper = wrapperObjFac.createGetFilingStatusRequestType();
    wrapper.setGetFilingStatusRequestMessage(req_msg);
    GetFilingStatusResponseType resp = port.get().getFilingStatus(wrapper);
    return Ecf5Helper.mapTylerCodesToHttp(
        resp.getGetFilingStatusResponseMessage().getMessageStatus(),
        () -> Response.ok().entity(resp.getGetFilingStatusResponseMessage()).build());
  }

  @Override
  public Response getFilingService(
      String courtId, String filingId, String contactId, String apiToken) {
    try {
      List<String> courtIds = getAllLocations();
      if (courtId != null && !courtId.equals("0") && !courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?" + ex);
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    Optional<TylerFilingReviewMDE> port =
        Ecf5Helper.setupTylerReviewPort(tylerReviewServFactory, apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }

    var req = new GetFilingServiceRequestType();
    var msg = new GetFilingServiceMessageType();
    msg.setServiceRecipientID(Ecf5Helper.convertId(contactId));
    msg.getDocumentIdentification().add(Ecf5Helper.convertId(filingId));
    req.setGetFilingServiceMessage(msg);

    var resp = port.get().getFilingService(req);
    return Ecf5Helper.mapTylerCodesToHttp(
        resp.getGetFilingServiceResponseMessage().getMessageStatus(),
        () -> Response.ok().entity(resp.getGetFilingServiceResponseMessage()).build());
  }

  @Override
  public Response getPolicy(String courtId, String apiToken) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500)
          .entity("Couldn't access database: " + StdLib.strFromException(ex))
          .build();
    }
    Optional<CourtPolicyMDE> port = Ecf5Helper.setupPolicyPort(policyServFactory, apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    GetPolicyResponseMessageType resp = policyCacher.getPolicyFor(port.get(), courtId);
    return Response.ok(resp).build();
  }

  private List<String> getAllLocations() throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cd.getAllLocations();
    }
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, String apiToken) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDE> port = Ecf5Helper.setupReviewPort(reviewServFactory, apiToken);
      if (port.isEmpty()) {
        return Response.status(403).build();
      }
      CancelFilingMessageType cancel =
          Ecf5Helper.prep(cancelObjFac.createCancelFilingMessageType(), courtId);
      cancel
          .getDocumentIdentification()
          .add(Ecf5Helper.convertId(filingId, "FilingReview", "filingID"));
      CancelFilingRequestType cancelWrapper = wrapperObjFac.createCancelFilingRequestType();
      cancelWrapper.setCancelFilingMessage(cancel);
      CancelFilingResponseType resp = port.get().cancelFiling(cancelWrapper);
      return Ecf5Helper.mapTylerCodesToHttp(
          resp.getMessageStatus(), () -> Response.noContent().build());
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?: " + StdLib.strFromException(ex));
      return Response.status(500).entity("Ops error: could not connect to database").build();
    }
  }

  @Override
  public Response disclaimers(String courtId) {
    try (CodeDatabase cd = cdSupplier.get()) {
      List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);
      return Response.status(200).entity(disclaimers).build();
    } catch (SQLException ex) {
      log.error("In disclaimer get, couldn't get codes db: " + StdLib.strFromException(ex));
      return Response.status(500).build();
    }
  }

  @Override
  public String getOrgName() {
    // No real API key we need to save
    return "tyler";
  }

  @Override
  public String getHeaderKey() {
    return this.headerKey;
  }
}
