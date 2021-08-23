package edu.suffolk.litlab.efspserver.ecf;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.PaymentFactory;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.Disclaimer;
import edu.suffolk.litlab.efspserver.codes.FilingCode;
import edu.suffolk.litlab.efspserver.codes.FilingComponent;
import edu.suffolk.litlab.efspserver.services.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
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
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
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
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

public class OasisEcfFiler extends EfmCheckableFilingInterface {
  private static Logger log = 
      LoggerFactory.getLogger(OasisEcfFiler.class); 
  
  private FilingReviewMDEService filingServiceFactory;
  private CodeDatabase cd;

  final void init() {
    URL filingReviewUrl = FilingReviewMDEService.WSDL_LOCATION;
    filingFactory = new FilingReviewMDEService(filingReviewUrl,
        FilingReviewMDEService.SERVICE);
  }

  public OasisEcfFiler(CodeDatabase cd) {
    this.filingServiceFactory = new FilingReviewMDEService(FilingReviewMDEService.WSDL_LOCATION, 
        FilingReviewMDEService.SERVICE);
    this.cd = cd;
    statusObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory();
    listObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory();
    commonObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    niemObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
    init();
  }
  
  private Optional<FilingReviewMDEPort> makeFilingService(String tylerToken) { 
    Optional<TylerUserNamePassword> tylerCreds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
    if (tylerCreds.isEmpty()) {
      return Optional.empty();
    }
    FilingReviewMDEPort port = filingServiceFactory.getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      ctx.put(Header.HEADER_LIST, List.of(tylerCreds.get().toHeader()));
    } catch (JAXBException e) {
      log.warn(e.toString());
      return Optional.empty();
    }
    return Optional.of(port);
  }

  @Override
  public List<String> getCourts() {
    // TODO(brycew): login when we don't need tyler stuff?
    try {
      return cd.getAllLocations();
    } catch (SQLException ex) {
      log.warn("DevOps Error: could not connect to database: " + ex.toString());
      return List.of();
    }
  }

  private Result<CoreFilingMessageType, FilingError> prepareFiling(FilingInformation info,
      InfoCollector collector, String apiToken) {
    EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd);
    try {
      // TODO(brycew): mapping from string case categories to Tyler code case categories, etc.
      EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer(cd, info.getCourtLocation());
    
      Optional<CaseCategory> maybeCaseCat = cd.getCaseCategoryFor(info.getCourtLocation(), info.getCaseCategory());
      if (maybeCaseCat.isEmpty()) {
        List<CaseCategory> categories = cd.getCaseCategoriesFor(info.getCourtLocation());
        // TODO(brycew): handle that these variables could be different from different deserializers
        InterviewVariable var = collector.requestVar("tyler_case_category", "", "choice", 
            categories.stream().map(cat -> cat.name).collect(Collectors.toList()));
        collector.addWrong(var);
        // Foundational error: Category is sorely needed
        return Result.err(FilingError.wrongValue(var));
      }
      CaseCategory caseCategory = maybeCaseCat.get();
      
      List<CaseType> caseTypes = cd.getCaseTypesFor(info.getCourtLocation(), caseCategory.code.get());
      if (caseTypes.isEmpty()) {
        FilingError err = FilingError.serverError("There are no caseTypes for " 
            + info.getCourtLocation() + " and " + caseCategory.code.get());
        collector.error(err);
        return Result.err(err);
      }
      Optional<CaseType> maybeType = caseTypes.stream()
          .filter(type -> type.name.equals(info.getCaseType()))
          .findFirst();
     
      if (maybeType.isEmpty()) {
        InterviewVariable var = collector.requestVar("tyler_case_type",  "",  "choice",
            caseTypes.stream().map(type -> type.name).collect(Collectors.toList()));
        collector.addWrong(var);
        return Result.err(FilingError.wrongValue(var));
      } 

      List<FilingCode> filings = cd.getFilingType(info.getCourtLocation(), 
          caseCategory.code.get(), maybeType.get().code, maybeType.get().initial);
      if (filings.isEmpty()) {
        log.error("Need a filing type! FilingTypes are empty, so " + caseCategory + " and " + maybeType.get() + " are restricted");
        InterviewVariable var = collector.requestVar("filing", "TODO(brycew): description", "text");
        collector.addWrong(var);
        // Is foundational, so returning now
        return Result.err(FilingError.wrongValue(var));
      }
    
      InterviewVariable var = collector.requestVar("filing", "TODO(brycew): description", "text", filings.stream().map(f -> f.name).collect(Collectors.toList()));
      JsonNode filingJson = info.getMiscInfo().get("filing");
      if (filingJson == null || filingJson.isNull() || !filingJson.isTextual()) {
        log.error("filing not present in the info!: " + info.getMiscInfo());
        collector.addRequired(var);
        return Result.err(FilingError.missingRequired(var));
      }
    
      Optional<FilingCode> maybeFiling = filings.stream()
          .filter(fil -> fil.name.equals(filingJson.asText()))
          .findFirst();
      if (maybeFiling.isEmpty()) {
        log.error("Nothing matches filing in the info: " + filingJson.asText());
        collector.addWrong(var);
        return Result.err(FilingError.missingRequired(var));
      }
    
      Result<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>, FilingError> assembledCase = 
          ecfCaseFactory.makeCaseTypeFromTylerCategory(
              info.getCourtLocation(), caseCategory, maybeType.get(),
              maybeFiling.get(),
              info.getCaseSubtype(),
              info.getPlaintiffs(), info.getPlantiffPartyType(),
              info.getDefendants(), info.getDefendantPartyType(),
              info.getFilings()
                  .stream()
                  .map(f -> f.getIdString())
                  .collect(Collectors.toList()), 
              info.getPaymentId(), 
              "review", info.getMiscInfo(), serializer, collector); 
      if (assembledCase.isErr()) {
        collector.error(assembledCase.unwrapErrOrElseThrow());
        return Result.err(assembledCase.unwrapErrOrElseThrow());
      }

      List<FilingComponent> components = cd.getFilingComponents(info.getCourtLocation(), maybeFiling.get().code);
      if (components.isEmpty()) {
        InterviewVariable filingComponentVar = collector.requestVar("filing_component", "The filing component: Lead or Attachment", "text");
        collector.addRequired(filingComponentVar);
       if (collector.finished()) {
         return Result.err(FilingError.missingRequired(filingComponentVar));
        }
      }
      
      oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory coreObjFac =
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory();
      CoreFilingMessageType cfm = coreObjFac.createCoreFilingMessageType();
      cfm.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL)); 
      cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cfm.setCase(assembledCase.unwrapOrElseThrow());
      int seqNum = 0;
      for (FilingDoc filingDoc : info.getFilings()) {
        Result<JAXBElement<DocumentType>, FilingError> result = 
                serializer.filingDocToXml(filingDoc, seqNum, caseCategory, maybeType.get(), 
                    maybeFiling.get(), components,
                        info.getMiscInfo(), collector);
        if (result.isErr()) {
          return result.mapOk(ok -> null);
        }
        JAXBElement<DocumentType> d = result.unwrapOrElseThrow();
        if (filingDoc.isLead()) {
          cfm.getFilingLeadDocument().add(d);
        } else {
          cfm.getFilingConnectedDocument().add(d); 
        }
        seqNum += 1;
      }
      return Result.ok(cfm);
    } catch (IOException ex) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      log.error("IO Error when making filing! " + ex.toString() + " " + sw.toString());
      return Result.err(FilingError.serverError("Got IOException assembling the filing: " + ex));
    } catch (SQLException ex) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      ex.printStackTrace(pw);
      log.error("SQL Error when making filing! " + ex.toString() + " " + sw.toString());    
      return Result.err(FilingError.serverError("Got SQLException assembling the filing: " + ex));
    }
  }
      
  public Result<List<UUID>, FilingError> submitFilingIfReady(FilingInformation info,
    InfoCollector collector, String apiToken) {
    Result<CoreFilingMessageType, FilingError> maybeCfm = prepareFiling(info, collector, apiToken);
    if (maybeCfm.isErr()) {
      return maybeCfm.mapOk(ok -> null);
    }

    oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory wsOf = 
        new oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory();
    PaymentFactory pf = new PaymentFactory();
    PaymentMessageType pmt = pf.makePaymentMessage(info.getPaymentId());
    ReviewFilingRequestMessageType rfrm = wsOf.createReviewFilingRequestMessageType();
    rfrm.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL)); 
    rfrm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    rfrm.setCoreFilingMessage(maybeCfm.unwrapOrElseThrow());
    rfrm.setPaymentMessage(pmt);

    log.debug(XmlHelper.objectToXmlStrOrError(rfrm, ReviewFilingRequestMessageType.class));
    if (!collector.okToSubmit()) {
      return Result.err(FilingError.serverError("Not submitting!"));
    }

    Optional<FilingReviewMDEPort> filingPort = makeFilingService(apiToken);
    if (filingPort.isEmpty()) {
      FilingError err = FilingError
          .serverError("Couldn't create SOAP port object with token: " + apiToken);
      collector.error(err);
      return Result.err(err);
    }
    MessageReceiptMessageType mrmt = filingPort.get().reviewFiling(rfrm);
    if (mrmt.getError().size() > 0) {
      for (oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType err : mrmt
          .getError()) {
        log.warn("Error from Tyler: " + err.getErrorCode().getValue() + ", "
            + err.getErrorText().getValue());
      }
    }
    List<IdentificationType> ids = mrmt.getDocumentIdentification();
    Optional<String> caseId = ids.stream().filter((id) -> {
      TextType text = (TextType) id.getIdentificationCategory().getValue();
      return text.getValue().toUpperCase().equals("FILINGID");
    }).map((id) -> id.getIdentificationID().getValue()).findFirst();
    if (caseId.isEmpty()) {
      log.error("Couldn't get back the filing id from Tyler!");
      return Result.err(
          FilingError.serverError("Couldn't get back filing id from tyler: " + mrmt.toString()));
    }

    log.info(XmlHelper.objectToXmlStrOrError(mrmt, MessageReceiptMessageType.class));
    return Result.ok(List.of(UUID.fromString(caseId.get())));
  }

  @Override
  public Result<Response, FilingError> getFilingFees(FilingInformation info, String apiToken) {
    FailFastCollector collector = new FailFastCollector();
    Result<CoreFilingMessageType, FilingError> maybeCfm = prepareFiling(info, collector, apiToken);
    if (maybeCfm.isErr()) {
      return maybeCfm.mapOk(ok -> null);
    }
    Optional<FilingReviewMDEPort> filingPort = makeFilingService(apiToken);
    if (filingPort.isEmpty()) {
      FilingError err = FilingError
          .serverError("Couldn't create SOAP port object with token: " + apiToken);
      return Result.err(err);
    }
    
    FeesCalculationQueryMessageType query = new FeesCalculationQueryMessageType();
    query.setCoreFilingMessage(maybeCfm.unwrapOrElseThrow());
    query.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL)); 
    query.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    FeesCalculationResponseMessageType resp = filingPort.get().getFeesCalculation(query);
    
    Response httpResponse = ServiceHelpers.makeResponse(resp, () -> Response.ok(resp).build());
    return Result.ok(httpResponse);
  }

  
  @Override
  public Response getFilingList(String courtId, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      FilingListQueryMessageType m = prep(listObjFac.createFilingListQueryMessageType(), courtId);
      m.setDocumentSubmitter(null); // cof.createEntityPerson(null));
      m.getDateRange().add(null);
      FilingListResponseMessageType resp = port.get().getFilingList(m);
      for (MatchingFilingType match : resp.getMatchingFiling()) {
        log.trace("Matched: " + match.getCaseTrackingID() + ", " + match);
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

  @Override
  public Response getFilingStatus(String courtId, String filingId, String apiToken) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      FilingStatusQueryMessageType status = prep(statusObjFac.createFilingStatusQueryMessageType(), courtId);
      status.setDocumentIdentification(XmlHelper.convertId(filingId));
      FilingStatusResponseMessageType statusResp = port.get().getFilingStatus(status);
      return ServiceHelpers.mapTylerCodesToHttp(statusResp.getError(), 
          () -> Response.ok().entity(status).build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
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

      Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
      if (port.isEmpty()) { 
        return Response.status(403).build();
      }
      FilingDetailQueryMessageType m = prep(detailObjFac.createFilingDetailQueryMessageType(), courtId);
      m.setDocumentIdentification(XmlHelper.convertId(filingId));
      FilingDetailResponseMessageType resp = port.get().getFilingDetails(m);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> Response.ok().entity(resp).build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
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
    try {
      List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);
      return Response.status(200).entity(disclaimers).build();
    } catch (SQLException e) {
      log.error("SQLException: " + e);
      return Response.status(500).build();
    }
  }

  @Override
  public String getOrgName() {
    // No real API key we need to save
    return "tyler";
  }

  private <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    newMsg.setQuerySubmitter(typ);
    newMsg.setCaseCourt(XmlHelper.convertCourtType(courtId));
    newMsg.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    newMsg.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    return newMsg;
  }

  private Optional<FilingReviewMDEPort> setupFilingPort(String apiToken) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(apiToken); 
    if (creds.isEmpty()) {
      return Optional.empty();
    }

    FilingReviewMDEPort port = makeFilingPort(filingFactory); 
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
  
  private static FilingReviewMDEPort makeFilingPort(FilingReviewMDEService filingFactory) {
    FilingReviewMDEPort port = filingFactory.getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }
  
  private FilingReviewMDEService filingFactory;
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
  private gov.niem.niem.niem_core._2.ObjectFactory
      niemObjFac;

}
