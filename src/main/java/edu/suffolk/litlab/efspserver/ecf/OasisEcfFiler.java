package edu.suffolk.litlab.efspserver.ecf;

import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.CaseServiceContact;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.codes.Disclaimer;
import edu.suffolk.litlab.efspserver.codes.FilingCode;
import edu.suffolk.litlab.efspserver.codes.FilingComponent;
import edu.suffolk.litlab.efspserver.codes.ServiceCodeType;
import edu.suffolk.litlab.efspserver.services.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.FilingResult;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import gov.niem.niem.niem_core._2.DateRangeType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Date;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.BindingProvider;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicServiceInformationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4.FeesCalculationResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.FilingListResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.MatchingFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.FilingStatusResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4.ServiceReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.ServiceMDEPort;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType;
import tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType;
import tyler.ecf.extensions.common.DocumentType;
import tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType;
import tyler.ecf.extensions.filingservicequerymessage.FilingServiceQueryMessageType;
import tyler.ecf.extensions.filingservicequerymessage.ServiceContactIdentificationType;
import tyler.ecf.extensions.filingserviceresponsemessage.FilingServiceResponseMessageType;
import tyler.ecf.extensions.servicetypesrequestmessage.ServiceTypesRequestMessageType;
import tyler.ecf.extensions.servicetypesresponsemessage.ServiceTypesResponseMessageType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;

public class OasisEcfFiler extends EfmCheckableFilingInterface {
  private static Logger log =
      LoggerFactory.getLogger(OasisEcfFiler.class);
  private CodeDatabase cd;
  private final String headerKey;
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory
      statusObjFac;
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory
      listObjFac;
  private final tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory detailObjFac;
  private final tyler.ecf.extensions.cancelfilingmessage.ObjectFactory cancelObjFac;
  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory
      commonObjFac;
  private final gov.niem.niem.niem_core._2.ObjectFactory niemObjFac;
  private final gov.niem.niem.proxy.xsd._2.ObjectFactory proxyObjFac;
  private final CourtRecordMDEService recordFactory; 
  private final FilingReviewMDEService filingFactory;
  private final ServiceMDEService serviceFactory; 


  public OasisEcfFiler(String jurisdiction, CodeDatabase cd) {
    this.cd = cd;
    TylerLogin login = new TylerLogin(jurisdiction);
    this.headerKey = login.getHeaderKey();
    statusObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory();
    listObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory();
    detailObjFac = new tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory();
    cancelObjFac = new tyler.ecf.extensions.cancelfilingmessage.ObjectFactory();
    commonObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    niemObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
    proxyObjFac = new gov.niem.niem.proxy.xsd._2.ObjectFactory();
    Optional<CourtRecordMDEService> maybeCourt = SoapClientChooser.getCourtRecordFactory(jurisdiction);
    if (maybeCourt.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for court record factory");
    }
    this.recordFactory = maybeCourt.get();
    Optional<FilingReviewMDEService> maybeReview = SoapClientChooser.getFilingReviewFactory(jurisdiction);
    if (maybeReview.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for filing review factory");
    }
    this.filingFactory = maybeReview.get();
    Optional<ServiceMDEService> maybeServiceFac = SoapClientChooser.getServiceFactory(jurisdiction);
    if (maybeServiceFac.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for service mde factory");
    }
    this.serviceFactory = maybeServiceFac.get();

  }

  @Override
  public String getHeaderKey() {
    return this.headerKey;
  }

  private CoreFilingMessageType prepareFiling(FilingInformation info,
      InfoCollector collector, String apiToken, FilingReviewMDEPort filingPort, CourtRecordMDEPort recordPort, String queryType) throws FilingError {
    EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd);
    try {
      Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(info.getCourtLocation());
      if (locationInfo.isEmpty()) {
        collector.error(FilingError.serverError("Court setup wrong: can't find full location info for " + info.getCourtLocation()));
      }
      
      CourtPolicyQueryMessageType policyQuery = prep(new CourtPolicyQueryMessageType(), info.getCourtLocation());
      CourtPolicyResponseMessageType policy = filingPort.getPolicy(policyQuery);

      if (!locationInfo.get().allowfilingintononindexedcase && info.getCaseDocketNumber().isPresent()
          && info.getPreviousCaseId().isEmpty()) {
        FilingError err = FilingError.malformedInterview("Court " + info.getCourtLocation()
            + " doesn't allow subsequent filing into non-indexed cases. If this case is in the " 
            + "court system, provide the Case tracking ID. If it's not, don't provide the docket " 
            + "number.");
        collector.error(err);
      }
      
      EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer(cd, locationInfo.get());
      boolean isInitialFiling = info.getPreviousCaseId().isEmpty() && info.getCaseDocketNumber().isEmpty();
      boolean isFirstIndexedFiling = info.getPreviousCaseId().isEmpty(); 
      ComboCaseCodes allCodes;
      if (!isFirstIndexedFiling) {
        CaseQueryMessageType query = new CaseQueryMessageType();
        ServiceHelpers.prep(query, info.getCourtLocation());
        query.setCaseTrackingID(XmlHelper.convertString(info.getPreviousCaseId().get()));
        query.setCaseQueryCriteria(EcfCaseTypeFactory.getCriteria());
        CaseResponseMessageType resp = recordPort.getCase(query);
        resp.getCase().getValue().getCaseTrackingID();
        String catCode = resp.getCase().getValue().getCaseCategoryText().getValue();
        String typeCode = EcfCaseTypeFactory.getCaseTypeCode(resp.getCase().getValue()).get().getCaseTypeText().getValue(); 
        List<Optional<String>> maybeFilingCodes = info.getFilings().stream().map(f -> f.getFilingCode()).collect(Collectors.toList()); 
        if (maybeFilingCodes.stream().anyMatch(fc -> fc.isEmpty())) {
          InterviewVariable filingVar = collector.requestVar("court_bundle[i].tyler_filing_type", "What filing type is this?", "text"); 
          collector.addRequired(filingVar);
        }
        List<String> filingCodeStrs = maybeFilingCodes.stream().map(fc -> fc.orElse("")).collect(Collectors.toList());
        log.info("Existing cat, type, and filings: " + catCode + "," + typeCode + "," + filingCodeStrs);
        allCodes = serializer.serializeCaseCodesIndexed(catCode, typeCode, filingCodeStrs, collector);
      } else {
        allCodes = serializer.serializeCaseCodes(info, collector, isInitialFiling);
      }

      var coreObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory();
      CoreFilingMessageType cfm = coreObjFac.createCoreFilingMessageType();

      int i = 0;
      Map<String, Object> serviceContactXmlObjs = new HashMap<>();
      for (CaseServiceContact servContact : info.getServiceContacts()) {
        ElectronicServiceInformationType servInfo = commonObjFac.createElectronicServiceInformationType();
        List<ServiceCodeType> types =  cd.getServiceTypes(info.getCourtLocation());
        Optional<ServiceCodeType> serviceCode = types.stream().filter(t -> t.code.equalsIgnoreCase(servContact.serviceType)).findFirst();
        InterviewVariable var = collector.requestVar("service_contact[" + i + "].service_type", "service type should be", "choices",
            types.stream().map(t -> t.code).collect(Collectors.toList()));
        if (serviceCode.isEmpty()) {
          collector.addWrong(var);
        }
        /*
        if (serviceCode.get().code.equals("-580") && isInitialFiling && locationInfo.get().disallowelectronicserviceonnewcontacts) { // Eservice
          collector.addWrong(var.appendDesc(", but can't be e-service for an initial contact"));
        }
        */
        IdentificationType id = XmlHelper.convertId(servContact.guid, "SERVICECONTACTID"); 
        id.setIdentificationSourceText(XmlHelper.convertText(serviceCode.get().code));
        servInfo.setServiceRecipientID(id);
        servInfo.setId(servContact.refId);
        servInfo.setReceivingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
        servInfo.setReceivingMDELocationID(XmlHelper.convertId(ServiceHelpers.ASSEMBLY_PORT)); 
        serviceContactXmlObjs.put(servContact.refId, servInfo);
        cfm.getElectronicServiceInformation().add(servInfo);
      }

      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> assembledCase =
          ecfCaseFactory.makeCaseTypeFromTylerCategory(
              locationInfo.get(), allCodes, 
              info, isInitialFiling, isFirstIndexedFiling,
              info.getFilings()
                  .stream()
                  .map(f -> f.getIdString())
                  .collect(Collectors.toList()),
              queryType, info.getMiscInfo(), serializer, collector, serviceContactXmlObjs);

      Map<String, String> crossReferences = serializer.getCrossRefIds(info.getMiscInfo(), collector, allCodes.type.code);
      for (Map.Entry<String, String> ref : crossReferences.entrySet()) {
        IdentificationType id = niemObjFac.createIdentificationType();
        id.setIdentificationID(XmlHelper.convertString(ref.getValue()));
        id.setIdentificationCategory(niemObjFac.createIdentificationCategoryText(
            XmlHelper.convertText("CaseCrossReferenceNumber"))); 
        id.setIdentificationSourceText(XmlHelper.convertText(ref.getKey()));
        cfm.getDocumentIdentification().add(id);
      }

      Optional<Boolean> serviceOnInitial = locationInfo.get().allowserviceoninitial;
      if (serviceOnInitial.isEmpty()) {
        serviceOnInitial = Optional.of(cd.getDataField(locationInfo.get().code, "FilingServiceCheckBoxInitial").isvisible);
      }
      if (isInitialFiling && !serviceOnInitial.get()
          && info.getServiceContacts().size() > 0) {
        FilingError err = FilingError.malformedInterview("Court " + locationInfo.get().name + " doesn't allow service on initial filings");
        collector.error(err);
      }
      DataFieldRow checkBoxSub = cd.getDataField(locationInfo.get().code, "FilingServiceCheckBoxSubsequent");
      if (!isInitialFiling && !checkBoxSub.isvisible && info.getServiceContacts().size() > 0) {
        FilingError err = FilingError.malformedInterview("Court " + locationInfo.get().name + " doesn't allow service on subsequent filings");
        collector.error(err);
      }

      cfm.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
      cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cfm.setCase(assembledCase);
      int seqNum = 0;
      
      MeasureType maxIndivDocSize = policy.getDevelopmentPolicyParameters().getValue().getMaximumAllowedAttachmentSize();
      long maxSize = XmlHelper.sizeMeasureAsBytes(maxIndivDocSize);
      long cumulativeBytes = 0;
      for (FilingDoc filingDoc : info.getFilings()) {
        long bytes = filingDoc.getFileContents().length;
        if (bytes > maxSize) {
          FilingError err = FilingError.malformedInterview("Document " + filingDoc.getFileName() 
              + " is too big! Must be max " + maxSize + ", is " + bytes);
          collector.error(err);
        }
        cumulativeBytes += bytes;

        FilingCode fc = allCodes.filings.get(seqNum);
        List<FilingComponent> components = cd.getFilingComponents(info.getCourtLocation(), fc.code);
        if (components.isEmpty()) {
          InterviewVariable filingComponentVar = collector.requestVar("filing_component", "The filing component: Lead or Attachment", "text");
          collector.addRequired(filingComponentVar);
          if (collector.finished()) {
            throw FilingError.missingRequired(filingComponentVar);
          }
        }

        JAXBElement<DocumentType> result =
                serializer.filingDocToXml(filingDoc, seqNum, allCodes.cat, allCodes.type,
                    fc, components, info.getMiscInfo(), collector);
        if (filingDoc.isLead()) {
          cfm.getFilingLeadDocument().add(result);
        } else {
          cfm.getFilingConnectedDocument().add(result);
        }
        seqNum += 1;
      }
      MeasureType maxTotalDocSize = policy.getDevelopmentPolicyParameters().getValue().getMaximumAllowedMessageSize();
      long maxTotal = XmlHelper.sizeMeasureAsBytes(maxTotalDocSize);
      if (cumulativeBytes > maxTotal) {
        FilingError err = FilingError.malformedInterview("All Documents combined are too big! Must be max" 
            + maxSize + ", are " + cumulativeBytes);
        collector.error(err);
      }
      log.info("Full ecfAug: " + XmlHelper.objectToXmlStr(cfm, CoreFilingMessageType.class));
      return cfm;
    } catch (IOException | SQLException | JAXBException ex) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      log.error("IO Error when making filing! " + ex.toString() + " " + sw.toString());
      throw FilingError.serverError("Got Exception assembling the filing: " + ex);
    }
  }
  
  private Result<FilingResult, FilingError> serveFilingIfReady(CoreFilingMessageType cfm, 
      FilingInformation info, InfoCollector collector, String apiToken) {
    Optional<ServiceMDEPort> port = setupServicePort(apiToken);
    if (port.isEmpty()) {
      return Result.err(FilingError.serverError("Couldn't make a service MDE port with the given API token"));
    }
    ServiceReceiptMessageType receipt = port.get().serveFiling(cfm);
    StringBuilder sb = new StringBuilder();
    boolean anyErrors = false;
    for (oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType err : receipt.getError()) {
      if (!err.getErrorCode().getValue().equalsIgnoreCase("0")) {
        anyErrors = true;
        sb.append("\n  * " + err.getErrorText().getValue());
      }
    }
    if (anyErrors) {
      try {
        FilingError err = FilingError.serverError(sb.toString());
        collector.error(err);
        return Result.err(err);
      } catch (FilingError err) {
        return Result.err(err);
      }
    }
    List<UUID> ids = receipt.getServiceRecipientStatus().stream()
        .map(st -> {
          String id = st.getServiceRecipientID().getIdentificationID().getValue();
          return UUID.fromString(id);
        })
        .collect(Collectors.toList());
    return Result.ok(new FilingResult(ids, info.getLeadContact())); 
  }

  @Override
  public Result<FilingResult, FilingError> submitFilingIfReady(FilingInformation info,
    InfoCollector collector, String apiToken, ApiChoice choice) {
    FilingReviewMDEPort filingPort;
    CoreFilingMessageType cfm;
    try {
      Optional<FilingReviewMDEPort> maybeFilingPort = setupFilingPort(apiToken);
      Optional<CourtRecordMDEPort> recordPort = setupRecordPort(apiToken);
      if (maybeFilingPort.isEmpty() || recordPort.isEmpty()) {
        FilingError err = FilingError
            .serverError("Couldn't create SOAP port object with token: " + apiToken);
        collector.error(err);
      }
      filingPort = maybeFilingPort.get();
      String queryType = (choice.equals(ApiChoice.ServiceApi))? "service" : "review";
      cfm = prepareFiling(info, collector, apiToken, filingPort, recordPort.get(), queryType);
    } catch (FilingError err) {
      return Result.err(err);
    }
    if (choice.equals(ApiChoice.ServiceApi)) {
      return serveFilingIfReady(cfm, info, collector, apiToken);
    }

    var wsOf = new oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory();
    PaymentMessageType pmt = PaymentFactory.makePaymentMessage(info.getPaymentId());
    ReviewFilingRequestMessageType rfrm = wsOf.createReviewFilingRequestMessageType();
    rfrm.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    rfrm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    rfrm.setCoreFilingMessage(cfm);
    rfrm.setPaymentMessage(pmt);

    log.debug(XmlHelper.objectToXmlStrOrError(rfrm, ReviewFilingRequestMessageType.class));
    if (!collector.okToSubmit()) {
      return Result.ok(new FilingResult(List.of(), null)); 
    }
    MessageReceiptMessageType mrmt = filingPort.reviewFiling(rfrm);
    if (mrmt.getError().size() > 0) {
      for (var err : mrmt.getError()) {
        if (!err.getErrorCode().getValue().equals("0")) {
          log.warn("Error from Tyler: " + err.getErrorCode().getValue() + ", "
              + err.getErrorText().getValue());
        }
      }
    }
    BiFunction<IdentificationType, String, Boolean> filterId = (id, idType) -> {
      TextType text = (TextType) id.getIdentificationCategory().getValue();
      return text.getValue().equalsIgnoreCase(idType);
    };
    List<IdentificationType> ids = mrmt.getDocumentIdentification();
    List<String> filingIdStrs = ids.stream().filter(id -> filterId.apply(id, "FILINGID"))
        .map((id) -> id.getIdentificationID().getValue()).collect(Collectors.toList());   
    Optional<String> caseId = ids.stream().filter(id -> filterId.apply(id, "CASEID"))
        .map(id -> id.getIdentificationID().getValue()).findFirst();
    Optional<String> envelopeId = ids.stream().filter(id -> filterId.apply(id, "ENVELOPEID"))
        .map(id -> id.getIdentificationID().getValue()).findFirst();
    if (filingIdStrs.isEmpty()) {
      log.error("Couldn't get back the filing id from Tyler!");
      return Result.err(
          FilingError.serverError("Couldn't get back filing id from tyler: " 
            + mrmt.getError().stream().reduce("", (str, err) -> {
              return str + ", " + err.getErrorText();
            }, (str, str2) -> str + str2))); 
    }
    log.info(XmlHelper.objectToXmlStrOrError(mrmt, MessageReceiptMessageType.class));
    return Result.ok(new FilingResult(
        caseId.get(), envelopeId.get(), filingIdStrs.stream().map(str -> UUID.fromString(str)).collect(Collectors.toList()), 
        info.getLeadContact()));
  }

  @Override
  public Result<Response, FilingError> getFilingFees(FilingInformation info, String apiToken) {
    FailFastCollector collector = new FailFastCollector();
    CoreFilingMessageType cfm;
    Optional<FilingReviewMDEPort> filingPort = setupFilingPort(apiToken);
    Optional<CourtRecordMDEPort> recordPort = setupRecordPort(apiToken);
    if (filingPort.isEmpty() || recordPort.isEmpty()) {
      FilingError err = FilingError
          .serverError("Couldn't create SOAP port object with token: " + apiToken);
      return Result.err(err);
    }
    try {
      cfm = prepareFiling(info, collector, apiToken, filingPort.get(), recordPort.get(), "fees");
    } catch (FilingError err) {
      return Result.err(err);
    }

    FeesCalculationQueryMessageType query = prep(new FeesCalculationQueryMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    FeesCalculationResponseMessageType resp = filingPort.get().getFeesCalculation(query);

    Response httpResponse = ServiceHelpers.makeResponse(resp, () -> Response.ok(resp).build());
    return Result.ok(httpResponse);
  }

  @Override
  public Result<Response, FilingError> getServiceTypes(FilingInformation info, String apiToken) {
    Optional<CourtLocationInfo> court = cd.getFullLocationInfo(info.getCourtLocation());
    if (court.isEmpty()) {
      return Result.ok(Response.status(404).entity("No court " + info.getCourtLocation()).build());
    }
    if (!court.get().hasconditionalservicetypes) {
      return Result.ok(Response.status(400).entity("Court " + info.getCourtLocation()
          + " doesn't have conditional service types. Check the code list instead").build());
    }
    FailFastCollector collector = new FailFastCollector();
    Optional<FilingReviewMDEPort> filingPort = setupFilingPort(apiToken);
    Optional<CourtRecordMDEPort> recordPort = setupRecordPort(apiToken);
    if (filingPort.isEmpty() || recordPort.isEmpty()) {
      FilingError err = FilingError
          .serverError("Couldn't create SOAP port object with token: " + apiToken);
      return Result.err(err);
    }
    CoreFilingMessageType cfm;
    try {
      cfm = prepareFiling(info, collector, apiToken, filingPort.get(), recordPort.get(), "review");
    } catch (FilingError err) {
      return Result.err(err);
    }

    ServiceTypesRequestMessageType query = prep(new ServiceTypesRequestMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    ServiceTypesResponseMessageType resp = filingPort.get().getServiceTypes(query);
    return Result.ok(ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
        () -> Response.ok(resp.getServiceType()).build()));
  }


  @Override
  public Response getFilingList(String courtId, String userId, java.time.LocalDate startDate,
      java.time.LocalDate endDate, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (courtId != null && !courtId.equals("0") && !courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?" + ex);
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    FilingListQueryMessageType m = prep(listObjFac.createFilingListQueryMessageType(), courtId);
    if (courtId.equals("0") || courtId == null) {
      // Search all courts
      m.setCaseCourt(null);
    }
    if (userId != null && !userId.isBlank()) {
      IdentificationType id = niemObjFac.createIdentificationType();
      id.setIdentificationID(XmlHelper.convertString(userId));
      gov.niem.niem.niem_core._2.PersonType per = niemObjFac.createPersonType();
      per.getPersonOtherIdentification().add(id);
      EntityType entity = niemObjFac.createEntityType();
      entity.setEntityRepresentation(niemObjFac.createPerson(per));
      m.setDocumentSubmitter(entity);
    } else {
      m.setDocumentSubmitter(null);
    }
    if (startDate != null && endDate != null) {
      try {
        GregorianCalendar startCal = new GregorianCalendar();
        startCal.set(startDate.getYear(), startDate.getMonthValue(), startDate.getDayOfMonth());
        DatatypeFactory fac = DatatypeFactory.newInstance();
        Date actualStart = proxyObjFac.createDate();
        actualStart.setValue(fac.newXMLGregorianCalendar(startCal));
        DateType niemStart = niemObjFac.createDateType();
        niemStart.setDateRepresentation(niemObjFac.createDate(actualStart));

        GregorianCalendar endCal = new GregorianCalendar();
        endCal.set(endDate.getYear(), endDate.getMonthValue(), endDate.getDayOfMonth());
        Date actualEnd = proxyObjFac.createDate();
        actualEnd.setValue(fac.newXMLGregorianCalendar(endCal));
        DateType niemEnd = niemObjFac.createDateType();
        niemEnd.setDateRepresentation(niemObjFac.createDate(actualEnd));

        DateRangeType range = niemObjFac.createDateRangeType();
        range.setStartDate(niemStart);
        range.setEndDate(niemEnd);
        m.getDateRange().add(range);
      } catch (DatatypeConfigurationException ex) {
        log.error("Why is datatypeconfigurationexception checked?: " + ex);
        return Response.status(500).build();
      }
    }
    FilingListResponseMessageType resp = port.get().getFilingList(m);
    for (MatchingFilingType match : resp.getMatchingFiling()) {
      log.trace("Matched: " + match.getCaseTrackingID() + ", " + match);
    }
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), () -> {
        if (resp.getMatchingFiling().size() <= 0) {
          return Response.noContent().build();
        }
        return Response.ok().entity(resp.getMatchingFiling()).build();
    });
  }

  @Override
  public Response getFilingStatus(String courtId, String filingId, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    FilingStatusQueryMessageType status = prep(statusObjFac.createFilingStatusQueryMessageType(), courtId);
    status.setDocumentIdentification(XmlHelper.convertId(filingId));
    FilingStatusResponseMessageType statusResp = port.get().getFilingStatus(status);
      
    return ServiceHelpers.mapTylerCodesToHttp(statusResp.getError(),
        () -> Response.ok().entity(statusResp).build());
  }

  @Override
  public Response getFilingService(String courtId, String filingId, String contactId, String apiToken) {
    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    FilingServiceQueryMessageType req = new FilingServiceQueryMessageType();
    ServiceContactIdentificationType id = new ServiceContactIdentificationType();
    id.setIdentificationCategory(niemObjFac.createIdentificationCategoryText(
        XmlHelper.convertText("SERVICECONTACTID")));
    id.setIdentificationID(XmlHelper.convertString(contactId));
    req.setServiceContactIdentification(id);
    FilingServiceResponseMessageType resp = port.get().getFilingService(req);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), () -> Response.ok(resp).build());
  }


  @Override
  public Response getFilingDetails(String courtId, String filingId, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    FilingDetailQueryMessageType m = prep(detailObjFac.createFilingDetailQueryMessageType(), courtId);
    m.setDocumentIdentification(XmlHelper.convertId(filingId));
    FilingDetailResponseMessageType resp = port.get().getFilingDetails(m);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
        () -> Response.ok().entity(resp).build());
  }

  @Override
  public Response getPolicy(String courtId, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500).entity("Couldn't access database: " + ex).build();
    }
    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }

    CourtPolicyQueryMessageType query = prep(new CourtPolicyQueryMessageType(), courtId);
    CourtPolicyResponseMessageType resp = port.get().getPolicy(query);

    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), () -> Response.ok(resp).build());
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
      if (port.isEmpty()) {
        return Response.status(403).build();
      }
      CancelFilingMessageType cancel = prep(cancelObjFac.createCancelFilingMessageType(), courtId);
      cancel.setDocumentIdentification(XmlHelper.convertId(filingId));
      CancelFilingResponseMessageType resp = port.get().cancelFiling(cancel);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> Response.noContent().build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
  }

  @Override
  public Response disclaimers(String courtId) {
    List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);
    return Response.status(200).entity(disclaimers).build();
  }

  @Override
  public String getOrgName() {
    // No real API key we need to save
    return "tyler";
  }

  private static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    return ServiceHelpers.prep(newMsg, courtId);
  }

  private Optional<FilingReviewMDEPort> setupFilingPort(String apiToken) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(apiToken);
    if (creds.isEmpty()) {
      return Optional.empty();
    }

    FilingReviewMDEPort port = makeFilingPort();
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      log.error(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }
  
  private Optional<ServiceMDEPort> setupServicePort(String apiToken) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(apiToken);
    if (creds.isEmpty()) {
      return Optional.empty();
    }

    ServiceMDEPort port = makeServicePort();
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      log.error(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }

  private Optional<CourtRecordMDEPort> setupRecordPort(String apiToken) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(apiToken);
    if (creds.isEmpty()) {
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

  private FilingReviewMDEPort makeFilingPort() {
    FilingReviewMDEPort port = filingFactory.getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }
  
  private ServiceMDEPort makeServicePort() {
    ServiceMDEPort port = serviceFactory.getServiceMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }

}
