package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.EcfCaseTypeFactory;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.PaymentFactory;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
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
import javax.ws.rs.core.HttpHeaders;
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

public class OasisEcfFiler implements EfmFilingInterface {
  private static Logger log = 
      LoggerFactory.getLogger(OasisEcfFiler.class); 
  
  private FilingReviewMDEService filingServiceFactory;
  private List<Header> headersList;
  private CodeDatabase cd;

  final void init() {
    URL filingReviewUrl = FilingReviewMDEService.WSDL_LOCATION;
    filingFactory = new FilingReviewMDEService(filingReviewUrl,
        FilingReviewMDEService.SERVICE);
  }

  public OasisEcfFiler(List<Header> headersList, CodeDatabase cd) {
    this.filingServiceFactory = new FilingReviewMDEService(FilingReviewMDEService.WSDL_LOCATION, 
        FilingReviewMDEService.SERVICE);
    this.headersList = headersList;
    this.cd = cd;
    statusObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory();
    listObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory();
    commonObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    init();
  }
  
  private FilingReviewMDEPort makeFilingService(List<Header> headersList) {
    FilingReviewMDEPort port = filingServiceFactory.getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    return port;
  }
  
  @Override
  public void checkFiling(FilingInformation info, InfoCollector collector) {
    //TODO(brycew): actually check the filing
    return;
  } 
  
  @Override
  public Result<UUID, tyler.efm.services.schema.common.ErrorType> sendFiling(
      FilingInformation stuff) {
    FilingReviewMDEPort filingPort = makeFilingService(this.headersList);
    EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd);
    try {
      // TODO(brycew): mapping from string case categories to Tyler code case categories, etc.
      Optional<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>> assembledCase = 
          ecfCaseFactory.makeCaseTypeFromTylerCategory(
              stuff.getCourtLocation(), stuff.getCaseCategory(), stuff.getCaseType(), 
              stuff.getCaseSubtype(),
              stuff.getPlaintiffs(), stuff.getDefendants(),
              stuff.getFilings().stream().map((f) -> f.getIdString()).collect(Collectors.toList()), 
              stuff.getPaymentId(), 
              "review", JsonNodeFactory.instance.objectNode());
      if (assembledCase.isEmpty()) {
        tyler.efm.services.schema.common.ErrorType err = 
            new tyler.efm.services.schema.common.ErrorType();
        err.setErrorCode("-1");
        // TODO(brycew): get actual info on why the assembled case was empty
        err.setErrorText("The assembled case was empty!");
        return Result.err(err);
      }
      oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory coreObjFac =
          new oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory();
      CoreFilingMessageType cfm = coreObjFac.createCoreFilingMessageType();
      cfm.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
      cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cfm.setCase(assembledCase.get());
      int seqNum = 0;
      for (FilingDoc filingDoc : stuff.getFilings()) {
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
      PaymentMessageType pmt = pf.makePaymentMessage(stuff.getPaymentId());
      ReviewFilingRequestMessageType rfrm = wsOf.createReviewFilingRequestMessageType();
      rfrm.setCoreFilingMessage(cfm);
      rfrm.setPaymentMessage(pmt);

      log.debug(XmlHelper.objectToXmlStrOrError(
          rfrm, ReviewFilingRequestMessageType.class));
      MessageReceiptMessageType mrmt = filingPort.reviewFiling(rfrm);
      if (mrmt.getError().size() > 0) {
        for (oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType err : mrmt
            .getError()) {
          log.warn(err.getErrorCode().getValue() + ", " + err.getErrorText().getValue());
        }
      }
      List<IdentificationType> ids = mrmt.getDocumentIdentification();
      Optional<String> caseId = ids.stream().filter((id) -> {
        TextType text = (TextType) id.getIdentificationCategory().getValue();
        return text.getValue().toUpperCase().equals("CASEID");
      }).map((id) -> id.getIdentificationID().getValue()).findFirst();
      if (caseId.isEmpty()) {
        log.error("Couldn't get back the case id from Tyler!");
      }

      log.info(XmlHelper.objectToXmlStrOrError(mrmt, MessageReceiptMessageType.class));
      return Result.ok(UUID.fromString(caseId.get())); 
    } catch (IOException ex) {
      tyler.efm.services.schema.common.ErrorType err = 
          new tyler.efm.services.schema.common.ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Got IOException assembling the filing: " + ex);
      return Result.err(err);
    } catch (SQLException ex) {
      tyler.efm.services.schema.common.ErrorType err = 
          new tyler.efm.services.schema.common.ErrorType();
      err.setErrorCode("-1");
      err.setErrorText("Got SQLException assembling the filing: " + ex);
      return Result.err(err);
    }
  }

  @Override
  public Response getFilingList(String courtId, HttpHeaders httpHeaders) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
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
  public Response getFilingStatus(String courtId, String filingId, HttpHeaders httpHeaders) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
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
  public Response getFilingDetails(String courtId, String filingId, HttpHeaders httpHeaders) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
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
  public Response cancelFiling(String courtId, String filingId, HttpHeaders httpHeaders) {
    try {
      List<String> courtIds = cd.getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(httpHeaders);
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
  public String getApiKey() {
    // No real API key we need to save
    return "";
  }

  private Optional<FilingReviewMDEPort> setupFilingPort(HttpHeaders httpHeaders) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromHeaders(httpHeaders);
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
