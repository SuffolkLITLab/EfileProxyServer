package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.EcfCaseTypeFactory;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.PaymentFactory;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

public class OasisEcfFiler implements EfmFilingInterface {
  private static Logger log = 
      LoggerFactory.getLogger(OasisEcfFiler.class); 
  
  private FilingReviewMDEService filingServiceFactory;
  private List<Header> headersList;
  private CodeDatabase cd;

  public OasisEcfFiler(List<Header> headersList, CodeDatabase cd) {
    this.filingServiceFactory = new FilingReviewMDEService(FilingReviewMDEService.WSDL_LOCATION, 
        FilingReviewMDEService.SERVICE);
    this.headersList = headersList;
    this.cd = cd;
  }
  
  private FilingReviewMDEPort makeFilingService(List<Header> headersList) {
    FilingReviewMDEPort port = filingServiceFactory.getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    return port;
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

}
