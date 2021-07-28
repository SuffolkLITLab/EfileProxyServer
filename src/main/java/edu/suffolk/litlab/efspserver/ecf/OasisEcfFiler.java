package edu.suffolk.litlab.efspserver.ecf;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.PaymentFactory;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.services.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import java.io.IOException;
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
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
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
import tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType;
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

  @Override
  public Result<List<UUID>, FilingError> submitFilingIfReady(FilingInformation info,
      InfoCollector collector, String apiToken) {
    Optional<FilingReviewMDEPort> filingPort = makeFilingService(apiToken); 
    if (filingPort.isEmpty()) {
      return Result.err(FilingError.serverError("Couldn't create SOAP port object with token: " + apiToken));
    }
    EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd);
    try {
      // TODO(brycew): mapping from string case categories to Tyler code case categories, etc.
      Result<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>, FilingError> assembledCase = 
          ecfCaseFactory.makeCaseTypeFromTylerCategory(
              info.getCourtLocation(), info.getCaseCategory(), info.getCaseType(), 
              info.getCaseSubtype(),
              info.getPlaintiffs(), info.getDefendants(),
              info.getFilings().stream().map((f) -> f.getIdString()).collect(Collectors.toList()), 
              info.getPaymentId(), 
              "review", collector); 
      if (assembledCase.isErr()) {
        return Result.err(assembledCase.unwrapErrOrElseThrow());
      }
      oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory coreObjFac =
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory();
      CoreFilingMessageType cfm = coreObjFac.createCoreFilingMessageType();
      cfm.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL)); 
      cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cfm.setCase(assembledCase.unwrapOrElseThrow());
      int seqNum = 0;
      for (FilingDoc filingDoc : info.getFilings()) {
        if (filingDoc.isLead()) {
          cfm.getFilingLeadDocument().add(filingDoc.asDocument(seqNum));
        } else {
          cfm.getFilingConnectedDocument().add(filingDoc.asDocument(seqNum));
        }
        seqNum += 1;
      }
      oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory wsOf = 
          new oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory();
      PaymentFactory pf = new PaymentFactory();
      PaymentMessageType pmt = pf.makePaymentMessage(info.getPaymentId());
      ReviewFilingRequestMessageType rfrm = wsOf.createReviewFilingRequestMessageType();
      rfrm.setCoreFilingMessage(cfm);
      rfrm.setPaymentMessage(pmt);

      log.debug(XmlHelper.objectToXmlStrOrError(
          rfrm, ReviewFilingRequestMessageType.class));
      MessageReceiptMessageType mrmt = filingPort.get().reviewFiling(rfrm);
      if (mrmt.getError().size() > 0) {
        for (oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType err : mrmt
            .getError()) {
          log.warn(err.getErrorCode().getValue() + ", " + err.getErrorText().getValue());
        }
      }
      List<IdentificationType> ids = mrmt.getDocumentIdentification();
      Optional<String> caseId = ids.stream().filter((id) -> {
        TextType text = (TextType) id.getIdentificationCategory().getValue();
        return text.getValue().toUpperCase().equals("FILINGID");
      }).map((id) -> id.getIdentificationID().getValue()).findFirst();
      if (caseId.isEmpty()) {
        log.error("Couldn't get back the filing id from Tyler!");
        return Result.err(FilingError.serverError("Couldn't get back filing id from tyler: " + mrmt.toString()));
      }

      log.info(XmlHelper.objectToXmlStrOrError(mrmt, MessageReceiptMessageType.class));
      return Result.ok(List.of(UUID.fromString(caseId.get()))); 
    } catch (IOException ex) {
      return Result.err(FilingError.serverError("Got IOException assembling the filing: " + ex));
    } catch (SQLException ex) {
      return Result.err(FilingError.serverError("Got SQLException assembling the filing: " + ex));
    }
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
      FilingListQueryMessageType m = listObjFac.createFilingListQueryMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      m.setQuerySubmitter(typ);
      m.setDocumentSubmitter(null); // cof.createEntityPerson(null));
      m.setCaseCourt(XmlHelper.convertCourtType(courtId));
      m.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
      m.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
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
      FilingStatusQueryMessageType status = statusObjFac.createFilingStatusQueryMessageType();
      status.setCaseCourt(XmlHelper.convertCourtType(courtId));
      status.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
      status.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      status.setDocumentIdentification(XmlHelper.convertId(filingId));
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      EntityType typ = new EntityType();
      typ.setEntityRepresentation(elem2);
      status.setQuerySubmitter(typ);
      FilingStatusResponseMessageType statusResp = port.get().getFilingStatus(status);
      return ServiceHelpers.mapTylerCodesToHttp(statusResp.getError(), 
          () -> Response.ok().entity(status).build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
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
      FilingDetailQueryMessageType m = detailObjFac.createFilingDetailQueryMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      m.setQuerySubmitter(typ);
      m.setCaseCourt(XmlHelper.convertCourtType(courtId));
      m.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
      m.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      m.setDocumentIdentification(XmlHelper.convertId(filingId));
      FilingDetailResponseMessageType resp = port.get().getFilingDetails(m);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> Response.ok().entity(resp).build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
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
      CancelFilingMessageType cancel = cancelObjFac.createCancelFilingMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      cancel.setQuerySubmitter(typ);
      cancel.setCaseCourt(XmlHelper.convertCourtType(courtId));
      cancel.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
      cancel.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cancel.setDocumentIdentification(XmlHelper.convertId(filingId));
      CancelFilingResponseMessageType resp = port.get().cancelFiling(cancel);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(),
          () -> Response.noContent().build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
  }

  @Override
  public String getOrgName() {
    // No real API key we need to save
    return "tyler";
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
      System.err.println(ex.toString());
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

}
