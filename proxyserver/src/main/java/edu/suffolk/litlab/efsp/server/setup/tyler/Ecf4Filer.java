package edu.suffolk.litlab.efsp.server.setup.tyler;

import static edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.getIsIndividual;
import static edu.suffolk.litlab.efsp.stdlib.StdLib.exists;

import com.hubspot.algebra.Result;
import ecf4.latest.gov.niem.niem.niem_core._2.DateRangeType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.MeasureType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Date;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicServiceInformationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.FilingListResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.MatchingFilingType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.FilingStatusResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4.ServiceReceiptMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.ServiceMDEPort;
import ecf4.latest.tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType;
import ecf4.latest.tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType;
import ecf4.latest.tyler.ecf.extensions.common.DocumentType;
import ecf4.latest.tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import ecf4.latest.tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType;
import ecf4.latest.tyler.ecf.extensions.filingservicequerymessage.FilingServiceQueryMessageType;
import ecf4.latest.tyler.ecf.extensions.filingservicequerymessage.ServiceContactIdentificationType;
import ecf4.latest.tyler.ecf.extensions.filingserviceresponsemessage.FilingServiceResponseMessageType;
import ecf4.latest.tyler.ecf.extensions.servicetypesrequestmessage.ServiceTypesRequestMessageType;
import ecf4.latest.tyler.ecf.extensions.servicetypesresponsemessage.ServiceTypesResponseMessageType;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.ServiceMDEService;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.ComboCaseCodes;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.Disclaimer;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.ServiceCodeType;
import edu.suffolk.litlab.efsp.model.CaseServiceContact;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.FilingResult;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.auth.TylerLogin;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCourtSpecificSerializer;
import edu.suffolk.litlab.efsp.server.ecf4.PaymentFactory;
import edu.suffolk.litlab.efsp.server.ecf4.PolicyCacher;
import edu.suffolk.litlab.efsp.server.ecf4.QueryType;
import edu.suffolk.litlab.efsp.server.ecf4.tyler.TylerCodesParser;
import edu.suffolk.litlab.efsp.server.services.impl.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.SoapClientChooser;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import jakarta.annotation.Nullable;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ecf4Filer extends EfmCheckableFilingInterface {
  private static Logger log = LoggerFactory.getLogger(Ecf4Filer.class);
  private final Supplier<CodeDatabase> cdSupplier;
  private final String headerKey;
  private final ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd
          .filingstatusquerymessage_4.ObjectFactory
      statusObjFac;
  private final ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4
          .ObjectFactory
      listObjFac;
  private final ecf4.latest.tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory
      detailObjFac;
  private final ecf4.latest.tyler.ecf.extensions.cancelfilingmessage.ObjectFactory cancelObjFac;
  private final ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
          .ObjectFactory
      commonObjFac;
  private final ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory niemObjFac;
  private final ecf4.latest.gov.niem.niem.proxy.xsd._2.ObjectFactory proxyObjFac;
  private final CourtRecordMDEService recordFactory;
  private final FilingReviewMDEService filingFactory;
  private final TylerFirmFactory firmFactory;
  private final ServiceMDEService serviceFactory;
  private final PolicyCacher policyCacher;
  private final Jurisdiction jurisdiction;

  public Ecf4Filer(
      Jurisdiction jurisdiction, Supplier<CodeDatabase> cdSupplier, PolicyCacher policyCacher) {
    this.jurisdiction = jurisdiction;
    this.cdSupplier = cdSupplier;
    TylerLogin login = new TylerLogin(jurisdiction);
    this.headerKey = login.getHeaderKey();
    statusObjFac =
        new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4
            .ObjectFactory();
    listObjFac =
        new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4
            .ObjectFactory();
    detailObjFac = new ecf4.latest.tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory();
    cancelObjFac = new ecf4.latest.tyler.ecf.extensions.cancelfilingmessage.ObjectFactory();
    commonObjFac =
        new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
            .ObjectFactory();
    niemObjFac = new ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory();
    proxyObjFac = new ecf4.latest.gov.niem.niem.proxy.xsd._2.ObjectFactory();
    Optional<CourtRecordMDEService> maybeCourt =
        SoapClientChooser.getCourtRecordFactory(jurisdiction);
    if (maybeCourt.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for court record factory");
    }
    this.recordFactory = maybeCourt.get();
    Optional<FilingReviewMDEService> maybeReview =
        SoapClientChooser.getFilingReviewFactory(jurisdiction);
    if (maybeReview.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for filing review factory");
    }
    this.filingFactory = maybeReview.get();
    Optional<ServiceMDEService> maybeServiceFac = SoapClientChooser.getServiceFactory(jurisdiction);
    if (maybeServiceFac.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for service mde factory");
    }
    this.serviceFactory = maybeServiceFac.get();
    Optional<TylerFirmFactory> maybeFirmFactory = TylerClients.getEfmFirmFactory(jurisdiction);
    if (maybeFirmFactory.isEmpty()) {
      throw new RuntimeException("Cannot find " + jurisdiction + " for firm mde factory");
    }
    this.firmFactory = maybeFirmFactory.get();
    if (policyCacher != null) {
      this.policyCacher = policyCacher;
    } else {
      this.policyCacher = new PolicyCacher();
    }
  }

  @Override
  public String getHeaderKey() {
    return this.headerKey;
  }

  public Optional<CodesParser> getParser(String courtId, TylerUserNamePassword creds) {
    CodeDatabase cd = cdSupplier.get();
    return getParser(cd, courtId, creds);
  }

  private Optional<CodesParser> getParser(
      CodeDatabase cd, String courtId, TylerUserNamePassword creds) {
    var filingPort = setupFilingPort(creds);
    boolean isIndividual = getIsIndividual(firmFactory, Optional.of(creds));
    var policy =
        policyCacher.getPolicyFor(filingPort, courtId).getDevelopmentPolicyParameters().getValue();
    return TylerCodesParser.makeParser(cd, policy, courtId, isIndividual);
  }

  public record CoreMessageAndNames(
      CoreFilingMessageType cfm,
      @Nullable String existingCaseTitle,
      String caseCategoryName,
      String courtName) {}

  private CoreMessageAndNames prepareFiling(
      FilingInformation info,
      InfoCollector collector,
      TylerUserNamePassword creds,
      FilingReviewMDEPort filingPort,
      CourtRecordMDEPort recordPort,
      QueryType queryType)
      throws FilingError {
    String existingCaseTitle = null;
    try (CodeDatabase cd = cdSupplier.get()) {
      EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd, this.jurisdiction);
      Optional<CourtLocationInfo> maybeLocationInfo =
          cd.getFullLocationInfo(info.getCourtLocation());
      if (maybeLocationInfo.isEmpty()) {
        collector.error(
            FilingError.serverError(
                "Court setup wrong: can't find full location info for " + info.getCourtLocation()));
      }

      CourtLocationInfo locationInfo =
          maybeLocationInfo.orElse(new CourtLocationInfo(info.getCourtLocation()));
      String courtName = locationInfo.name;

      CourtPolicyResponseMessageType policy =
          policyCacher.getPolicyFor(filingPort, info.getCourtLocation());

      if (!locationInfo.allowfilingintononindexedcase
          && info.getCaseDocketNumber().isPresent()
          && info.getPreviousCaseId().isEmpty()) {
        FilingError err =
            FilingError.malformedInterview(
                "Court "
                    + info.getCourtLocation()
                    + " doesn't allow subsequent filing into non-indexed cases. If this case is in"
                    + " the court system, provide the Case tracking ID. If it's not, don't provide"
                    + " the docket number.");
        collector.error(err);
      }

      EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer();
      var maybeParser = getParser(cd, locationInfo.code, creds);
      if (maybeParser.isEmpty()) {
        collector.error(
            FilingError.serverError(
                "Court setup or apiToken wrong: can't get parser for " + info.getCourtLocation()));
      }
      var parser = maybeParser.get();
      boolean isInitialFiling =
          info.getPreviousCaseId().isEmpty() && info.getCaseDocketNumber().isEmpty();
      boolean isFirstIndexedFiling = info.getPreviousCaseId().isEmpty();
      var newParties =
          Stream.concat(info.getNewPlaintiffs().stream(), info.getNewDefendants().stream())
              .toList();
      ComboCaseCodes allCodes;
      if (!isFirstIndexedFiling) {
        CaseQueryMessageType query = new CaseQueryMessageType();
        Ecf4Helper.prep(query, info.getCourtLocation());
        query.setCaseTrackingID(Ecf4Helper.convertString(info.getPreviousCaseId().get()));
        query.setCaseQueryCriteria(EcfCaseTypeFactory.getCriteria());
        CaseResponseMessageType resp = recordPort.getCase(query);
        if (resp.getCase() != null && resp.getCase().getValue() != null) {
          if (resp.getCase().getValue().getCaseTitleText() != null) {
            existingCaseTitle = resp.getCase().getValue().getCaseTitleText().getValue();
          }
        } else {
          var filingVar =
              collector.requestVar(
                  "previous_case_id",
                  "Could not find the given case id (" + info.getPreviousCaseId().get() + ")",
                  "text",
                  List.of(),
                  info.getPreviousCaseId());
          collector.addWrong(filingVar);
        }

        String catStr = resp.getCase().getValue().getCaseCategoryText().getValue();
        var catRes = parser.vetCaseCat(catStr);
        if (catRes.isErr()) {
          var variable =
              collector.addCodeError(
                  catRes.expectErr(""),
                  collector
                      .varBuilder()
                      .name("case category (fom the court)")
                      .description("(shouldn't be wrong)"));
          // Foundational error: Category is sorely needed
          throw FilingError.wrongValue(variable);
        }
        CaseCategory catCode = catRes.expect("");
        String typeStr =
            EcfCaseTypeFactory.getCaseAugmentation(resp.getCase().getValue())
                .get()
                .getCaseTypeText()
                .getValue();
        var typeRes = parser.vetCaseType(typeStr, catCode, isInitialFiling);
        if (typeRes.isErr()) {
          var variable =
              collector.addCodeError(
                  typeRes.expectErr(""),
                  collector
                      .varBuilder()
                      .name("case type (fom tyler)")
                      .description("(shouldn't be wrong)"));
          throw FilingError.wrongValue(variable);
        }
        CaseType typeCode = typeRes.expect("");
        Map<PartyId, Person> exisitingPartips =
            EcfCaseTypeFactory.getCaseParticipants(resp.getCase().getValue()).get();
        List<FilingCode> filingCodes =
            info.getFilings().stream().map(f -> f.getFilingCode()).toList();
        var existingParties = exisitingPartips.values();
        log.info("Existing cat, type, and filings: {}, {}, {}", catCode, typeCode, filingCodes);
        var partyTypesRes =
            parser.vetPartyTypes(newParties, existingParties, typeCode, isFirstIndexedFiling);
        if (partyTypesRes.isErr()) {
          var interviewVar =
              collector.addCodeError(
                  partyTypesRes.expectErr(""),
                  collector.varBuilder().name("(new and exisiting parties)"));
          throw FilingError.wrongValue(interviewVar);
        }
        var partyTypes = partyTypesRes.expect("");
        allCodes = new ComboCaseCodes(catCode, typeCode, filingCodes, partyTypes);
      } else {
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
        allCodes = serializer.serializeCaseCodes(info, partyTypes, collector, isInitialFiling);
      }
      String caseCategoryName = allCodes.cat().name;
      log.info("have all codes");

      var coreObjFac =
          new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4
              .ObjectFactory();
      CoreFilingMessageType cfm = coreObjFac.createCoreFilingMessageType();

      int i = 0;
      Map<String, Object> serviceContactXmlObjs = new HashMap<>();
      for (CaseServiceContact servContact : info.getServiceContacts()) {
        ElectronicServiceInformationType servInfo =
            commonObjFac.createElectronicServiceInformationType();
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
                  types.stream().map(t -> t.code).collect(Collectors.toList()),
                  Optional.of(servContact.serviceType));
          collector.addWrong(var);
        }
        /*
        if (serviceCode.get().code.equals("-580") && isInitialFiling && locationInfo.get().disallowelectronicserviceonnewcontacts) { // Eservice
          collector.addWrong(var.appendDesc(", but can't be e-service for an initial contact"));
        }
        */
        IdentificationType id = Ecf4Helper.convertId(servContact.guid, "SERVICECONTACTID");
        id.setIdentificationSourceText(Ecf4Helper.convertText(serviceCode.get().code));
        servInfo.setServiceRecipientID(id);
        servInfo.setId(servContact.refId);
        servInfo.setReceivingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
        servInfo.setReceivingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.ASSEMBLY_PORT));
        serviceContactXmlObjs.put(servContact.refId, servInfo);
        cfm.getElectronicServiceInformation().add(servInfo);
      }

      log.info("Assembling case");
      var pair =
          ecfCaseFactory.makeCaseTypeFromTylerCategory(
              locationInfo,
              allCodes,
              info,
              isInitialFiling,
              isFirstIndexedFiling,
              queryType,
              serializer,
              collector,
              serviceContactXmlObjs);
      JAXBElement<? extends ecf4.latest.gov.niem.niem.niem_core._2.CaseType> assembledCase =
          pair.getLeft();
      log.info("Assembled case");

      Map<String, String> crossReferences = info.getCrossRefs();
      for (Map.Entry<String, String> ref : crossReferences.entrySet()) {
        IdentificationType id = niemObjFac.createIdentificationType();
        id.setIdentificationID(Ecf4Helper.convertString(ref.getValue()));
        id.setIdentificationCategory(
            niemObjFac.createIdentificationCategoryText(
                Ecf4Helper.convertText("CaseCrossReferenceNumber")));
        id.setIdentificationSourceText(Ecf4Helper.convertText(ref.getKey()));
        cfm.getDocumentIdentification().add(id);
      }

      cfm.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
      cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cfm.setCase(assembledCase);

      MeasureType maxIndivDocSize =
          policy.getDevelopmentPolicyParameters().getValue().getMaximumAllowedAttachmentSize();
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

        FilingCode fc = allCodes.filings().get(seqNum);

        collector.pushAttributeStack("al_court_bundle[" + seqNum + "]");
        JAXBElement<DocumentType> result =
            serializer.filingDocToXml(
                filingDoc, isInitialFiling, allCodes.cat(), allCodes.type(), fc);
        collector.popAttributeStack();
        filingIdToObj.put(filingDoc.getIdString(), result.getValue());
        if (filingDoc.sequenceNum() == 0) {
          cfm.getFilingLeadDocument().add(result);
        } else {
          cfm.getFilingConnectedDocument().add(result);
        }
        seqNum += 1;
        log.info("Added a document to the XML");
      }
      MeasureType maxTotalDocSize =
          policy.getDevelopmentPolicyParameters().getValue().getMaximumAllowedMessageSize();
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
      EcfCaseTypeFactory.getCaseAugmentation(assembledCase.getValue())
          .ifPresent(
              aug -> {
                Map<String, List<PartyId>> filingAssociations =
                    info.getFilings().stream()
                        .collect(
                            Collectors.toMap(f -> f.getIdString(), f -> f.getFilingPartyIds()));
                if (parser.useFilingAssociations()) {
                  for (var association :
                      ecfCaseFactory.lateStageFilingAssociationAdd(
                          filingIdToObj, filingAssociations, pair.getRight())) {
                    aug.getFilingAssociation().add(association);
                  }
                }
              });
      log.info(
          "Full cfm: {}",
          Ecf4Helper.objectToXmlStrOrError(cfm, CoreFilingMessageType.class)
              .replaceAll("<ns2:BinaryBase64Object>[^<]+<\\/ns2:BinaryBase64Object>", ""));
      return new CoreMessageAndNames(cfm, existingCaseTitle, caseCategoryName, courtName);
    } catch (IOException | SQLException ex) {
      log.error("IO Error when making filing!", ex);
      throw FilingError.serverError("Got Exception assembling the filing: " + ex);
    }
  }

  private Result<FilingResult, FilingError> serveFilingIfReady(
      CoreFilingMessageType cfm,
      FilingInformation info,
      InfoCollector collector,
      TylerUserNamePassword creds) {
    ServiceMDEPort port = setupServicePort(creds);
    ServiceReceiptMessageType receipt = port.serveFiling(cfm);
    StringBuilder sb = new StringBuilder();
    boolean anyErrors = false;
    for (var err : receipt.getError()) {
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
    List<UUID> ids =
        receipt.getServiceRecipientStatus().stream()
            .map(
                st -> {
                  String id = st.getServiceRecipientID().getIdentificationID().getValue();
                  return UUID.fromString(id);
                })
            .collect(Collectors.toList());
    return Result.ok(new FilingResult(ids, info.getLeadContact()));
  }

  @Override
  public Result<FilingResult, FilingError> submitFilingIfReady(
      FilingInformation info,
      InfoCollector collector,
      TylerUserNamePassword creds,
      ApiChoice choice) {
    FilingReviewMDEPort filingPort;
    CoreFilingMessageType cfm;
    String existingCaseTitle = null;
    String caseCategoryName = null;
    String courtName = null;
    try {
      filingPort = setupFilingPort(creds);
      CourtRecordMDEPort recordPort = setupRecordPort(creds);
      QueryType queryType =
          (choice.equals(ApiChoice.ServiceApi)) ? QueryType.Service : QueryType.Review;
      var coreAndExisting =
          prepareFiling(info, collector, creds, filingPort, recordPort, queryType);
      cfm = coreAndExisting.cfm;
      caseCategoryName = coreAndExisting.caseCategoryName;
      courtName = coreAndExisting.courtName;
      existingCaseTitle = coreAndExisting.existingCaseTitle;
      // if (!queryType.equals(QueryType.Service)
      //    && (info.getPaymentId() == null || info.getPaymentId().isBlank())) {
      //  collector.addRequired(collector.requestVar("tyler_payment_id", "The ID of the payment
      // method", "text"));
      // }
    } catch (FilingError err) {
      log.error("Error when preparing Filing", err);
      return Result.err(err);
    }

    if (!collector.okToSubmit()) {
      return Result.ok(new FilingResult(List.of(), null));
    }

    if (choice.equals(ApiChoice.ServiceApi)) {
      return serveFilingIfReady(cfm, info, collector, creds);
    }

    var wsOf =
        new ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4
            .ObjectFactory();
    PaymentMessageType pmt =
        PaymentFactory.makePaymentMessage(info.getPaymentId(), this.jurisdiction);
    ReviewFilingRequestMessageType rfrm = wsOf.createReviewFilingRequestMessageType();
    rfrm.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    rfrm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    rfrm.setCoreFilingMessage(cfm);
    rfrm.setPaymentMessage(pmt);

    log.atDebug()
        .setMessage("{}")
        .addArgument(
            () -> Ecf4Helper.objectToXmlStrOrError(rfrm, ReviewFilingRequestMessageType.class))
        .log();
    MessageReceiptMessageType mrmt = filingPort.reviewFiling(rfrm);
    if (mrmt.getError().size() > 0) {
      var err = Ecf4Helper.checkErrors(mrmt.getError());
      logTylerErrorsWithContext(err, info);
    }
    BiFunction<IdentificationType, String, Boolean> filterId =
        (id, idType) -> {
          TextType text = (TextType) id.getIdentificationCategory().getValue();
          return text.getValue().equalsIgnoreCase(idType);
        };
    List<IdentificationType> ids = mrmt.getDocumentIdentification();
    List<String> filingIdStrs =
        ids.stream()
            .filter(id -> filterId.apply(id, "FILINGID"))
            .map((id) -> id.getIdentificationID().getValue())
            .collect(Collectors.toList());
    Optional<String> caseId =
        ids.stream()
            .filter(id -> filterId.apply(id, "CASEID"))
            .map(id -> id.getIdentificationID().getValue())
            .findFirst();
    Optional<String> envelopeId =
        ids.stream()
            .filter(id -> filterId.apply(id, "ENVELOPEID"))
            .map(id -> id.getIdentificationID().getValue())
            .findFirst();
    if (filingIdStrs.isEmpty()) {
      log.error("Couldn't get back the filing id from Tyler!");
      return Result.err(
          FilingError.serverError(
              "Couldn't get back filing id from tyler: "
                  + mrmt.getError().stream()
                      .reduce(
                          "",
                          (str, err) -> {
                            return str + ", " + err.getErrorText();
                          },
                          (str, str2) -> str + str2)));
    }
    String caseTitle = (exists(existingCaseTitle)) ? existingCaseTitle : info.makeCaseTitle();
    log.info(Ecf4Helper.objectToXmlStrOrError(mrmt, MessageReceiptMessageType.class));
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

  @Override
  public Result<Response, FilingError> getFilingFees(
      FilingInformation info, TylerUserNamePassword creds) {
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

    var query = prep(new FeesCalculationQueryMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    var resp = filingPort.getFeesCalculation(query);

    var err = Ecf4Helper.checkErrors(resp.getError());
    logTylerErrorsWithContext(err, info);

    Response httpResponse = Ecf4Helper.mapTylerCodesToHttp(err, () -> Response.ok(resp).build());
    return Result.ok(httpResponse);
  }

  private void logTylerErrorsWithContext(List<Ecf4Helper.Error> errs, FilingInformation info) {
    errs.forEach(
        error -> {
          String errContext =
              switch (error.code()) {
                case "95" ->
                    "FilingAttorneyIDs: %s"
                        .formatted(
                            info.getFilings().stream().map(f -> f.getFilingAttorney()).toList());
                case "96" ->
                    "FilingPartyIDs: %s"
                        .formatted(
                            info.getFilings().stream()
                                .flatMap(f -> f.getFilingPartyIds().stream())
                                .toList());
                case "97" -> "PaymentID: %s".formatted(info.getPaymentId());
                case "168" -> "Lower court code: %s".formatted(info.getLowerCourtInfo());
                case "169" ->
                    "Birthdates: %s"
                        .formatted(
                            Stream.concat(
                                    info.getNewPlaintiffs().stream(),
                                    info.getNewDefendants().stream())
                                .flatMap(p -> p.getBirthdate().stream())
                                .toList());
                default -> "No context for %s".formatted(error.code());
              };
          log.error("Error message from Tyler: {}. Context: {}", error, errContext);
        });
  }

  private Optional<CourtLocationInfo> getCourtInfo(FilingInformation info) {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cd.getFullLocationInfo(info.getCourtLocation());
    } catch (SQLException ex) {
      log.error("IN EcfEfiler, can't get CodesDB: ", ex);
      return Optional.empty();
    }
  }

  private List<String> getAllLocations() throws SQLException {
    try (CodeDatabase cd = cdSupplier.get()) {
      return cd.getAllLocations();
    }
  }

  @Override
  public Result<Response, FilingError> getServiceTypes(
      FilingInformation info, TylerUserNamePassword creds) {
    Optional<CourtLocationInfo> court = getCourtInfo(info);
    if (court.isEmpty()) {
      return Result.ok(Response.status(404).entity("No court " + info.getCourtLocation()).build());
    }
    if (!court.get().hasconditionalservicetypes) {
      return Result.ok(
          Response.status(400)
              .entity(
                  "Court "
                      + info.getCourtLocation()
                      + " doesn't have conditional service types. Check the code list instead")
              .build());
    }

    FailFastCollector collector = new FailFastCollector();
    FilingReviewMDEPort filingPort = setupFilingPort(creds);
    CourtRecordMDEPort recordPort = setupRecordPort(creds);
    CoreFilingMessageType cfm;
    try {
      cfm = prepareFiling(info, collector, creds, filingPort, recordPort, QueryType.Review).cfm;
    } catch (FilingError err) {
      log.error("Error when preparing Filing", err);
      return Result.err(err);
    }

    ServiceTypesRequestMessageType query =
        prep(new ServiceTypesRequestMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    ServiceTypesResponseMessageType resp = filingPort.getServiceTypes(query);
    return Result.ok(
        Ecf4Helper.makeResponse(resp, () -> Response.ok(resp.getServiceType()).build()));
  }

  @Override
  public Response getFilingList(
      String courtId,
      String submitterId,
      java.time.LocalDate startDate,
      java.time.LocalDate beforeDate,
      TylerUserNamePassword creds) {
    try {
      List<String> courtIds = getAllLocations();
      if (courtId != null && !courtId.equals("0") && !courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      log.error("Couldn't connect to database?", ex);
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
    log.info(
        "Getting filing list with these params: "
            + courtId
            + ", "
            + submitterId
            + ", "
            + startDate
            + ", "
            + beforeDate);

    FilingReviewMDEPort port = setupFilingPort(creds);
    FilingListQueryMessageType m = prep(listObjFac.createFilingListQueryMessageType(), courtId);
    if (courtId == null || courtId.equals("0")) {
      // Search all courts
      m.setCaseCourt(null);
    }
    if (submitterId != null && !submitterId.isBlank()) {
      IdentificationType id = niemObjFac.createIdentificationType();
      id.setIdentificationID(Ecf4Helper.convertString(submitterId));
      var person = niemObjFac.createPersonType();
      person.getPersonOtherIdentification().add(id);
      EntityType entity = niemObjFac.createEntityType();
      entity.setEntityRepresentation(niemObjFac.createEntityPerson(person));
      m.setDocumentSubmitter(entity);
    } else {
      m.setDocumentSubmitter(null);
    }
    if (startDate != null && beforeDate != null) {
      try {
        GregorianCalendar startCal = new GregorianCalendar();
        startCal.set(startDate.getYear(), startDate.getMonthValue(), startDate.getDayOfMonth());
        DatatypeFactory fac = DatatypeFactory.newInstance();
        Date actualStart = proxyObjFac.createDate();
        actualStart.setValue(fac.newXMLGregorianCalendar(startCal));
        DateType niemStart = niemObjFac.createDateType();
        niemStart.setDateRepresentation(niemObjFac.createDate(actualStart));

        // endCal is exclusive!
        GregorianCalendar endCal = new GregorianCalendar();
        endCal.set(beforeDate.getYear(), beforeDate.getMonthValue(), beforeDate.getDayOfMonth());
        Date actualEnd = proxyObjFac.createDate();
        actualEnd.setValue(fac.newXMLGregorianCalendar(endCal));
        DateType niemEnd = niemObjFac.createDateType();
        niemEnd.setDateRepresentation(niemObjFac.createDate(actualEnd));

        DateRangeType range = niemObjFac.createDateRangeType();
        range.setStartDate(niemStart);
        range.setEndDate(niemEnd);
        m.getDateRange().add(range);
      } catch (DatatypeConfigurationException ex) {
        log.error("Why is datatypeconfigurationexception checked?: ", ex);
        return Response.status(500).build();
      }
    }
    log.info(
        "Final query: " + Ecf4Helper.objectToXmlStrOrError(m, FilingListQueryMessageType.class));
    FilingListResponseMessageType resp = port.getFilingList(m);
    for (MatchingFilingType match : resp.getMatchingFiling()) {
      log.trace("Matched: {}, {}", match.getCaseTrackingID(), match);
    }
    return Ecf4Helper.makeResponse(
        resp,
        () -> {
          if (resp.getMatchingFiling().size() <= 0) {
            return Response.noContent().build();
          }
          return Response.ok().entity(resp.getMatchingFiling()).build();
        });
  }

  @Override
  public Response getFilingStatus(String courtId, String filingId, TylerUserNamePassword creds) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(404).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    FilingReviewMDEPort port = setupFilingPort(creds);
    FilingStatusQueryMessageType status =
        prep(statusObjFac.createFilingStatusQueryMessageType(), courtId);
    status.setDocumentIdentification(Ecf4Helper.convertId(filingId));
    FilingStatusResponseMessageType statusResp = port.getFilingStatus(status);

    return Ecf4Helper.makeResponse(statusResp, () -> Response.ok().entity(statusResp).build());
  }

  @Override
  public Response getFilingService(
      String courtId, String filingId, String contactId, TylerUserNamePassword creds) {
    FilingReviewMDEPort port = setupFilingPort(creds);
    FilingServiceQueryMessageType req = new FilingServiceQueryMessageType();
    ServiceContactIdentificationType id = new ServiceContactIdentificationType();
    id.setIdentificationCategory(
        niemObjFac.createIdentificationCategoryText(Ecf4Helper.convertText("SERVICECONTACTID")));
    id.setIdentificationID(Ecf4Helper.convertString(contactId));
    req.setServiceContactIdentification(id);
    FilingServiceResponseMessageType resp = port.getFilingService(req);
    return Ecf4Helper.makeResponse(resp, () -> Response.ok(resp).build());
  }

  @Override
  public Response getFilingDetails(String courtId, String filingId, TylerUserNamePassword creds) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }

    FilingReviewMDEPort port = setupFilingPort(creds);
    FilingDetailQueryMessageType m =
        prep(detailObjFac.createFilingDetailQueryMessageType(), courtId);
    m.setDocumentIdentification(Ecf4Helper.convertId(filingId));
    FilingDetailResponseMessageType resp = port.getFilingDetails(m);
    return Ecf4Helper.makeResponse(resp, () -> Response.ok().entity(resp).build());
  }

  @Override
  public Response getPolicy(String courtId, TylerUserNamePassword creds) {
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
    return Ecf4Helper.makeResponse(resp, () -> Response.ok(resp).build());
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, TylerUserNamePassword creds) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      FilingReviewMDEPort port = setupFilingPort(creds);
      CancelFilingMessageType cancel = prep(cancelObjFac.createCancelFilingMessageType(), courtId);
      cancel.setDocumentIdentification(Ecf4Helper.convertId(filingId));
      CancelFilingResponseMessageType resp = port.cancelFiling(cancel);
      return Ecf4Helper.makeResponse(resp, () -> Response.noContent().build());
    } catch (SQLException ex) {
      return Response.status(500).entity("Ops Error: Could not connect to database").build();
    }
  }

  @Override
  public Response disclaimers(String courtId) {
    try (CodeDatabase cd = cdSupplier.get()) {
      List<Disclaimer> disclaimers = cd.getDisclaimerRequirements(courtId);
      return Response.status(200).entity(disclaimers).build();
    } catch (SQLException ex) {
      log.error("In disclaimer get, couldn't get codes db: ", ex);
      return Response.status(500).build();
    }
  }

  @Override
  public String getOrgName() {
    // No real API key we need to save
    return "tyler";
  }

  private static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    return Ecf4Helper.prep(newMsg, courtId);
  }

  private FilingReviewMDEPort setupFilingPort(TylerUserNamePassword creds) {
    FilingReviewMDEPort port = makeFilingPort();
    Client client = ClientProxy.getClient(port);
    HTTPConduit http = (HTTPConduit) client.getConduit();
    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    httpClientPolicy.setConnectionTimeout(180_000);
    httpClientPolicy.setReceiveTimeout(180_000);
    http.setClient(httpClientPolicy);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    List<Header> headersList = List.of(creds.toHeader());
    ctx.put(Header.HEADER_LIST, headersList);
    return port;
  }

  private ServiceMDEPort setupServicePort(TylerUserNamePassword creds) {
    ServiceMDEPort port = makeServicePort();
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    List<Header> headersList = List.of(creds.toHeader());
    ctx.put(Header.HEADER_LIST, headersList);
    return port;
  }

  private CourtRecordMDEPort setupRecordPort(TylerUserNamePassword creds) {
    CourtRecordMDEPort port = recordFactory.getCourtRecordMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    List<Header> headersList = List.of(creds.toHeader());
    ctx.put(Header.HEADER_LIST, headersList);
    return port;
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
