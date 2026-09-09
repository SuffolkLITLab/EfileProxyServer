package edu.suffolk.litlab.efsp.server.services.impl;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.exists;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecf4.QueryType;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.FilingResult;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.auth.UserCreds;
import edu.suffolk.litlab.efsp.server.services.api.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efsp.server.truefiling.PolicyCacher;
import edu.suffolk.litlab.efsp.server.truefiling.TFEcf4Helper;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.EcfError;
import edu.suffolk.litlab.efsp.stdlib.NonEmptyString;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import edu.suffolk.litlab.efsp.truefiling.SoapClientChooser;
import edu.suffolk.litlab.efsp.truefiling.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.truefiling.ecf4.EcfCourtSpecificSerializer;
import edu.suffolk.litlab.efsp.truefiling.ecf4.PaymentFactory;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodeDatabase;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodesParser;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.TextType;
import imagesoft.ecf.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import imagesoft.ecf.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import jakarta.annotation.Nullable;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** TrueFilingFiler */
public class TrueFilingFiler extends EfmCheckableFilingInterface {
  private static Logger log = LoggerFactory.getLogger(TrueFilingFiler.class);
  private final Supplier<TFCodeDatabase> cdSupplier;

  private final PolicyCacher policyCacher;
  private final Jurisdiction jurisdiction;
  private final CourtRecordMDEService recordFactory;
  private final FilingReviewMDEService filingFactory;

  public TrueFilingFiler(
      Jurisdiction jurisdiction, Supplier<TFCodeDatabase> cdSupplier, PolicyCacher policyCacher) {
    this.jurisdiction = jurisdiction;
    this.recordFactory = SoapClientChooser.getCourtRecordFactory(jurisdiction);
    this.filingFactory = SoapClientChooser.getFilingReviewFactory(jurisdiction);
    this.cdSupplier = cdSupplier;
    if (policyCacher != null) {
      this.policyCacher = policyCacher;
    } else {
      this.policyCacher = new PolicyCacher();
    }
  }

  @Override
  public Response disclaimers(String courtId) {
    return Response.status(200).entity(List.of()).build();
  }

  @Override
  public String getOrgName() {
    return "truefiling";
  }

  private FilingReviewMDEPort setupFilingPort(UserCreds creds) {
    FilingReviewMDEPort port = filingFactory.getFilingReviewMDEPort();
    SoapClientChooser.setupServicePort((BindingProvider) port);
    ServiceHelpers.changeTimeout((BindingProvider) port, 180_000);
    return port;
  }

  private CourtRecordMDEPort setupRecordPort(UserCreds creds) {
    CourtRecordMDEPort port = recordFactory.getCourtRecordMDEPort();
    SoapClientChooser.setupServicePort((BindingProvider) port);
    ServiceHelpers.changeTimeout((BindingProvider) port, 180_000);
    return port;
  }

  @Override
  public Result<Response, FilingError> getFilingFees(FilingInformation info, UserCreds creds) {
    FailFastCollector collector = new FailFastCollector();
    CoreFilingMessageType cfm;
    FilingReviewMDEPort filingPort = setupFilingPort(creds);
    CourtRecordMDEPort recordPort = setupRecordPort(creds);
    log.info("Getting Filing Fees");
    try {
      cfm = prepareFiling(info, collector, creds, filingPort, recordPort, QueryType.Fees).cfm;
    } catch (FilingError err) {
      log.error("Error when preparing Filing for getFilingFees", err);
      return Result.err(err);
    }

    var query = TFEcf4Helper.prep(new FeesCalculationQueryMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    var resp = filingPort.getFeesCalculation(query);

    var err = TFEcf4Helper.checkErrors(resp.getError());
    logErrorsWithContext(err, info);

    Response httpResponse = TFEcf4Helper.mapErrorCodesToHttp(err, () -> Response.ok(resp).build());
    return Result.ok(httpResponse);
  }

  public record CoreMessageAndNames(
      CoreFilingMessageType cfm,
      Person leadContact,
      @Nullable String existingCaseTitle,
      String caseCategoryName,
      String courtName) {}

  private CoreMessageAndNames prepareFiling(
      FilingInformation info,
      InfoCollector collector,
      UserCreds creds,
      FilingReviewMDEPort filingPort,
      CourtRecordMDEPort recordPort,
      QueryType queryType)
      throws FilingError {
    String existingCaseTitle = null;
    try (TFCodeDatabase cd = cdSupplier.get()) {
      String courtName = info.getCourtLocation();
      EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd, this.jurisdiction);
      var policy = policyCacher.getPolicyFor(filingPort, info.getCourtLocation());
      var maybeParser = getParser(info.getCourtLocation(), creds);
      if (maybeParser.isEmpty()) {
        collector.error(
            FilingError.serverError(
                "Could setup or apiToken wrong: can't get parser for " + info.getCourtLocation()));
      }
      var parser = maybeParser.get();
      EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer();
      try {
        boolean isInitialFiling =
            info.getPreviousCaseId().isEmpty() && info.getCaseDocketNumber().isEmpty();
        boolean isFirstIndexedFiling = info.getPreviousCaseId().isEmpty();
        String caseCategoryName = info.getCaseCategoryCode().name();

        var cfm = new CoreFilingMessageType();
        cfm.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SENDING_MDE_LOCATION));
        cfm.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
        // TODO: handle when it's not an existing filing
        var newParties =
            Stream.concat(info.getNewPlaintiffs().stream(), info.getNewDefendants().stream())
                .toList();
        var partyTypesRes =
            parser.vetPartyTypes(
                newParties, List.of(), info.getCaseTypeCode(), isFirstIndexedFiling);
        if (partyTypesRes.isErr()) {
          var interviewVar =
              collector.addCodeError(
                  partyTypesRes.expectErr(""), collector.varBuilder().name("(new parties)"));
          throw FilingError.wrongValue(interviewVar);
        }
        var partyTypes = partyTypesRes.expect("");
        var allCodes = serializer.serializeCaseCodes(info, partyTypes);
        JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> assembledCase =
            ecfCaseFactory
                .makeCaseTypeFromCaseCategory(
                    courtName,
                    allCodes,
                    info,
                    isInitialFiling,
                    isFirstIndexedFiling,
                    queryType,
                    serializer,
                    collector)
                .getLeft();
        cfm.setCase(assembledCase);

        var leadContact = repairLeadContact(info.getLeadContact(), info);
        cfm.setDocumentSubmitter(serializer.serializeNiemEntity(leadContact));

        // filing lead documents
        MeasureType maxIndivDocSize =
            policy.getDevelopmentPolicyParameters().getMaximumAllowedAttachmentSize();
        long maxSize = Ecf4Helper.sizeMeasureAsBytes(maxIndivDocSize);
        long cumulativeBytes = 0;

        Map<String, Object> filingIdToObj = new HashMap<>();
        int seqNum = 0;
        for (FilingDoc filingDoc : info.getFilings()) {

          long bytes = filingDoc.allAttachmentsLength();
          if (bytes > maxSize) {
            FilingError err =
                FilingError.malformedInterview(
                    "Document "
                        + filingDoc
                            .getDescription()
                            .map(d -> d.get())
                            .orElse(filingDoc.getFilingComments().orElse(""))
                        + " is too big! Must be max "
                        + maxSize
                        + ", is "
                        + bytes);
            collector.error(err);
          }
          cumulativeBytes += bytes;

          NameAndCode fc = allCodes.filings().get(seqNum);
          collector.pushAttributeStack("al_court_bundle[" + seqNum + "]");
          DocumentType result = serializer.filingDocToXml(filingDoc, fc);
          collector.popAttributeStack();
          filingIdToObj.put(filingDoc.getIdString(), result);
          // NOTE: all truefiling docs are lead documents?
          cfm.getFilingLeadDocument().add(result);
          seqNum += 1;
          log.info("Added a document to the XML");
        }
        MeasureType maxTotalDocSize =
            policy.getDevelopmentPolicyParameters().getMaximumAllowedMessageSize();
        long maxTotal = Ecf4Helper.sizeMeasureAsBytes(maxTotalDocSize);
        if (cumulativeBytes > maxTotal) {
          FilingError err =
              FilingError.malformedInterview(
                  "All Documents combined are too big! Must be max"
                      + maxSize
                      + ", are "
                      + cumulativeBytes);
          collector.error(err);
        }
        log.info(
            "Full cfm: {}",
            Ecf4Helper.objectToXmlStrOrError(cfm, CoreFilingMessageType.class)
                .replaceAll("<ns2:BinaryBase64Object>[^<]+<\\/ns2:BinaryBase64Object>", ""));
        return new CoreMessageAndNames(
            cfm, leadContact, existingCaseTitle, caseCategoryName, courtName);
      } finally {
        try {
          parser.close();
        } catch (Exception ex) {
          log.error("Couldn't close parser: ", ex);
        }
      }
    } catch (IOException | SQLException ex) {
      log.error("Error when making filing!", ex);
      throw FilingError.serverError("Got Exception assembling the filing: " + ex);
    }
  }

  private void logErrorsWithContext(List<EcfError> errs, FilingInformation info) {
    // TODO: add context for all of the errors
    // Error[code=1234, text=Invalid ReviewFilingRequestMessage.]
    // Error[code=1233, text=Invalid ReviewFilingRequestMessage, bundle validation error(s) occured.
    // - Filing Type Summons Complaint/Petition/Application is Required to Submit Case Init Bundle.]
    // Error[code=1241, text=An error occurred while executing the request.]
    // Error[code=1233, text=Invalid ReviewFilingRequestMessage, bundle validation error(s) occured.
    // - Filing Type Summons Complaint/Petition/Application is Required to Submit Case Init Bundle.]
    // Error[code=1233, text=Invalid ReviewFilingRequestMessage, bundle validation error(s) occured.
    // - Filing TypeLaw Enforcement Information Sheet (DV-127) - CONFIDENTIAL is Required to Submit
    // Case Init Bundle.]
    // Error[code=1233, text=Invalid ReviewFilingRequestMessage, bundle validation error(s) occured.
    // - Only one filing fee document can be submitted for each new case. Please choose a different
    // filing type for any other case initiation documents in your bundle.]
    // Error[code=1034, text=Invalid ReviewFilingRequestMessage,
    // FilingConnectedDocument[0]/DocumentMetadata/ParentDocumentReference is required
    errs.forEach(
        error -> {
          log.error("Error message from TrueFiling: {}. Context: {}", error, info);
        });
  }

  @Override
  public Result<Response, FilingError> getServiceTypes(FilingInformation info, UserCreds creds) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getServiceTypes'");
  }

  @Override
  public Response getFilingList(
      String courtId,
      String submitterId,
      LocalDate startDate,
      LocalDate beforeDate,
      UserCreds creds) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingList'");
  }

  @Override
  public Response getFilingStatus(String courtId, String filingId, UserCreds creds) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingStatus'");
  }

  @Override
  public Response getFilingDetails(String courtId, String filingId, UserCreds creds) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingDetails'");
  }

  @Override
  public Response getFilingService(
      String courtId, String filingId, String contactId, UserCreds creds) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getFilingService'");
  }

  @Override
  public Response getPolicy(String courtId, UserCreds creds) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500).entity("Couldn't access database: " + ex).build();
    }
    FilingReviewMDEPort port = setupFilingPort(creds);
    CourtPolicyResponseMessageType resp = policyCacher.getPolicyFor(port, courtId);
    return TFEcf4Helper.makeResponse(resp, () -> Response.ok(resp).build());
  }

  private List<String> getAllLocations() throws SQLException {
    try (TFCodeDatabase cd = cdSupplier.get()) {
      return cd.getAllLocations();
    }
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, UserCreds creds) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'cancelFiling'");
  }

  @Override
  public Optional<CodesParser> getParser(String courtId, UserCreds creds) {
    TFCodeDatabase cd = cdSupplier.get();
    var filingPort = setupFilingPort(creds);
    var policy = policyCacher.getPolicyFor(filingPort, courtId).getDevelopmentPolicyParameters();
    return TFCodesParser.makeParser(cd, policy, courtId);
  }

  @Override
  public Result<FilingResult, FilingError> submitFilingIfReady(
      FilingInformation info,
      InfoCollector collector,
      UserCreds creds,
      Optional<NonEmptyString> userUuid,
      ApiChoice choice) {
    FilingReviewMDEPort filingPort;
    CoreFilingMessageType cfm;
    CoreMessageAndNames coreAndExisting;
    String existingCaseTitle = null;
    String caseCategoryName = null;
    String courtName = null;
    try {
      filingPort = setupFilingPort(creds);
      CourtRecordMDEPort recordPort = setupRecordPort(creds);
      QueryType queryType =
          (choice.equals(ApiChoice.ServiceApi)) ? QueryType.Service : QueryType.Review;
      coreAndExisting = prepareFiling(info, collector, creds, filingPort, recordPort, queryType);
      cfm = coreAndExisting.cfm;
      caseCategoryName = coreAndExisting.caseCategoryName;
      courtName = coreAndExisting.courtName;
      existingCaseTitle = coreAndExisting.existingCaseTitle;
    } catch (FilingError err) {
      log.error("Error when preparing Filing", err);
      return Result.err(err);
    }

    var wsOf =
        new oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4
            .ObjectFactory();
    PaymentMessageType pmt = PaymentFactory.makePaymentMessage(coreAndExisting.leadContact());
    ReviewFilingRequestMessageType rfrm = wsOf.createReviewFilingRequestMessageType();
    rfrm.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SENDING_MDE_LOCATION));
    rfrm.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
    rfrm.setCoreFilingMessage(cfm);
    rfrm.setPaymentMessage(pmt);

    if (!collector.okToSubmit()) {
      return Result.ok(new FilingResult(List.of(), null));
    }

    if (choice.equals(ApiChoice.ServiceApi)) {
      throw new UnsupportedOperationException("Unimplemented method 'submitFilingIfReady'");
    }

    log.atDebug()
        .setMessage("{}")
        .addArgument(
            () -> Ecf4Helper.objectToXmlStrOrError(rfrm, ReviewFilingRequestMessageType.class))
        .log();
    MessageReceiptMessageType mrmt = filingPort.reviewFiling(rfrm);
    if (mrmt.getError().size() > 0) {
      var err = Ecf4Helper.checkErrors(mrmt.getError());
      log.error("{}, {}", err, info);
    }
    BiFunction<IdentificationType, String, Boolean> filterId =
        (id, idType) -> {
          TextType text = (TextType) id.getIdentificationCategory().getValue();
          return text.getValue().equalsIgnoreCase(idType);
        };
    List<IdentificationType> ids = mrmt.getDocumentIdentification();
    Optional<String> transactionId =
        ids.stream()
            .filter(id -> filterId.apply(id, "TRANSACTIONID"))
            .map(id -> id.getIdentificationID().getValue())
            .findFirst();
    Optional<String> bundleId =
        ids.stream()
            .filter(id -> filterId.apply(id, "BUNDLEID"))
            .map(id -> id.getIdentificationID().getValue())
            .findFirst();
    if (bundleId.isEmpty()) {
      log.error("Couldn't get back the filing id from truefiling!");
      return Result.err(
          FilingError.serverError(
              "Couldn't get back filing id from truefiling: "
                  + mrmt.getError().stream()
                      .reduce(
                          "",
                          (str, err) -> {
                            return str + ", " + err.getErrorText();
                          },
                          (str, str2) -> str + str2)));
    }
    String caseTitle = (exists(existingCaseTitle)) ? existingCaseTitle : info.makeCaseTitle();

    // We don't get back a tracking id from just the submission; return the id.
    String caseId = info.getPreviousCaseId().orElse("");
    log.info(Ecf4Helper.objectToXmlStrOrError(mrmt, MessageReceiptMessageType.class));
    return Result.ok(
        new FilingResult(
            caseId,
            bundleId.get(),
            List.of(UUID.fromString(transactionId.get())),
            coreAndExisting.leadContact(),
            caseTitle,
            caseCategoryName,
            courtName));
  }

  public Person repairLeadContact(Optional<Person> maybeLeadContact, FilingInformation info) {
    Supplier<Person> userInfo =
        () -> {
          if (info.getNewPlaintiffs().size() > 0) {
            return info.getNewPlaintiffs().get(0);
          }
          if (info.getNewDefendants().size() > 0) {
            return info.getNewDefendants().get(0);
          }
          return Person.TestPerson(new Name(""), "", false);
        };
    Person leadContact = maybeLeadContact.orElseGet(userInfo);
    return leadContact;
  }
}
