package edu.suffolk.litlab.efsp.server.setup.tyler;

import static edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.setupFirmPort;
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
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.ComboCaseCodes;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
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
import edu.suffolk.litlab.efsp.server.ecf4.CoreMessageAndNames;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCourtSpecificSerializer;
import edu.suffolk.litlab.efsp.server.ecf4.PaymentFactory;
import edu.suffolk.litlab.efsp.server.ecf4.PolicyCacher;
import edu.suffolk.litlab.efsp.server.ecf4.QueryType;
import edu.suffolk.litlab.efsp.server.services.impl.EfmCheckableFilingInterface;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.SoapClientChooser;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerErrorCodes;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
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
import org.apache.cxf.headers.Header;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicServiceInformationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType;
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
  private static final PolicyCacher policyCacher = new PolicyCacher();
  private final Jurisdiction jurisdiction;

  public Ecf4Filer(TylerDomain domain, Supplier<CodeDatabase> cdSupplier) {
    this.jurisdiction = domain.jurisdiction();
    this.cdSupplier = cdSupplier;
    TylerLogin login = new TylerLogin(domain);
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
    Optional<CourtRecordMDEService> maybeCourt = SoapClientChooser.getCourtRecordFactory(domain);
    if (maybeCourt.isEmpty()) {
      throw new RuntimeException("Cannot find " + domain + " for court record factory");
    }
    this.recordFactory = maybeCourt.get();
    Optional<FilingReviewMDEService> maybeReview = SoapClientChooser.getFilingReviewFactory(domain);
    if (maybeReview.isEmpty()) {
      throw new RuntimeException("Cannot find " + domain + " for filing review factory");
    }
    this.filingFactory = maybeReview.get();
    Optional<ServiceMDEService> maybeServiceFac = SoapClientChooser.getServiceFactory(domain);
    if (maybeServiceFac.isEmpty()) {
      throw new RuntimeException("Cannot find " + domain + " for service mde factory");
    }
    this.serviceFactory = maybeServiceFac.get();
    Optional<TylerFirmFactory> maybeFirmFactory = TylerClients.getEfmFirmFactory(domain);
    if (maybeFirmFactory.isEmpty()) {
      throw new RuntimeException("Cannot find " + domain + " for firm mde factory");
    }
    this.firmFactory = maybeFirmFactory.get();
  }

  @Override
  public String getHeaderKey() {
    return this.headerKey;
  }

  private CoreMessageAndNames prepareFiling(
      FilingInformation info,
      InfoCollector collector,
      FilingReviewMDEPort filingPort,
      CourtRecordMDEPort recordPort,
      TylerFirmClient firmClient,
      QueryType queryType)
      throws FilingError {
    String existingCaseTitle = null;
    String caseCategoryName = "";
    try (CodeDatabase cd = cdSupplier.get()) {
      EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd, this.jurisdiction);
      Optional<CourtLocationInfo> maybeLocationInfo =
          cd.getFullLocationInfo(info.getCourtLocation());
      if (maybeLocationInfo.isEmpty()) {
        collector.error(
            FilingError.serverError(
                "Court setup wrong: can't find full location info for " + info.getCourtLocation()));
      }

      CourtLocationInfo locationInfo = maybeLocationInfo.orElse(new CourtLocationInfo());
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

      EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer(cd, locationInfo);
      boolean isInitialFiling =
          info.getPreviousCaseId().isEmpty() && info.getCaseDocketNumber().isEmpty();
      boolean isFirstIndexedFiling = info.getPreviousCaseId().isEmpty();
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

        String catCode = resp.getCase().getValue().getCaseCategoryText().getValue();
        String typeCode =
            EcfCaseTypeFactory.getCaseAugmentation(resp.getCase().getValue())
                .get()
                .getCaseTypeText()
                .getValue();
        Map<PartyId, Person> exisitingPartips =
            EcfCaseTypeFactory.getCaseParticipants(resp.getCase().getValue()).get();
        List<Optional<String>> maybeFilingCodes =
            info.getFilings().stream().map(f -> f.getFilingCode()).collect(Collectors.toList());
        if (maybeFilingCodes.stream().anyMatch(fc -> fc.isEmpty())) {
          InterviewVariable filingVar =
              collector.requestVar(
                  "al_court_bundle[i].filing_type",
                  "What filing type is this?",
                  "text",
                  List.of(),
                  Optional.empty());
          collector.addRequired(filingVar);
        }
        List<String> filingCodeStrs =
            maybeFilingCodes.stream().map(fc -> fc.orElse("")).collect(Collectors.toList());
        Map<String, Person> newPartyCodes =
            Stream.concat(info.getNewPlaintiffs().stream(), info.getNewDefendants().stream())
                .collect(Collectors.toMap(per -> per.getIdString(), per -> per));
        Map<String, Person> existingPartyCodes =
            exisitingPartips.entrySet().stream()
                .collect(
                    Collectors.toMap(
                        ent -> ent.getKey().getIdentificationString(), ent -> ent.getValue()));
        log.info("Existing cat, type, and filings: {}, {}, {}", catCode, typeCode, filingCodeStrs);
        allCodes =
            serializer.serializeCaseCodesIndexed(
                catCode, typeCode, filingCodeStrs, existingPartyCodes, newPartyCodes, collector);
      } else {
        allCodes = serializer.serializeCaseCodes(info, collector, isInitialFiling);
      }
      caseCategoryName = allCodes.cat.name;
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
              info.getMiscInfo(),
              serializer,
              collector,
              serviceContactXmlObjs);
      JAXBElement<? extends ecf4.latest.gov.niem.niem.niem_core._2.CaseType> assembledCase =
          pair.getLeft();
      log.info("Assembled case");

      Map<String, String> crossReferences =
          serializer.getCrossRefIds(info.getMiscInfo(), collector, allCodes.type.code);
      for (Map.Entry<String, String> ref : crossReferences.entrySet()) {
        IdentificationType id = niemObjFac.createIdentificationType();
        id.setIdentificationID(Ecf4Helper.convertString(ref.getValue()));
        id.setIdentificationCategory(
            niemObjFac.createIdentificationCategoryText(
                Ecf4Helper.convertText("CaseCrossReferenceNumber")));
        id.setIdentificationSourceText(Ecf4Helper.convertText(ref.getKey()));
        cfm.getDocumentIdentification().add(id);
      }

      Optional<Boolean> serviceOnInitial = locationInfo.allowserviceoninitial;
      if (serviceOnInitial.isEmpty()) {
        serviceOnInitial =
            Optional.of(
                cd.getDataField(locationInfo.code, "FilingServiceCheckBoxInitial").isvisible);
      }
      if (isInitialFiling
          && !serviceOnInitial.orElse(
              cd.getDataField(locationInfo.code, "FilingServiceCheckBoxInitial").isvisible)
          && info.getServiceContacts().size() > 0) {
        FilingError err =
            FilingError.malformedInterview(
                "Court " + locationInfo.name + " doesn't allow service on initial filings");
        collector.error(err);
      }
      DataFieldRow checkBoxSub =
          cd.getDataField(locationInfo.code, "FilingServiceCheckBoxSubsequent");
      if (!isInitialFiling && !checkBoxSub.isvisible && info.getServiceContacts().size() > 0) {
        FilingError err =
            FilingError.malformedInterview(
                "Court " + locationInfo.name + " doesn't allow service on subsequent filings");
        collector.error(err);
      }

      cfm.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
      cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
      cfm.setCase(assembledCase);

      MeasureType maxIndivDocSize =
          policy.getDevelopmentPolicyParameters().getValue().getMaximumAllowedAttachmentSize();
      long maxSize = Ecf4Helper.sizeMeasureAsBytes(maxIndivDocSize);
      long cumulativeBytes = 0;

      Optional<TylerFirmClient> firmClient = setupFirmPort(firmFactory, apiToken);
      boolean isIndividual =
          firmClient
              .map(
                  port -> {
                    try {
                      var resp = port.getFirm();
                      if (TylerErrorCodes.hasError(resp)) {
                        log.warn(
                            "GetFirm returned an error: {}, {}",
                            resp.getError().getErrorCode(),
                            resp.getError().getErrorText());
                      }
                      return resp.getFirm().isIsIndividual();
                    } catch (Exception ex) {
                      log.warn("Exception when getting firm info for individual?:", ex);
                      return true;
                    }
                  })
              .orElse(true);
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
                          .orElse(filingDoc.getFilingComments())
                      + " is too big! Must be max "
                      + maxSize
                      + ", is "
                      + bytes);
          collector.error(err);
        }
        cumulativeBytes += bytes;

        FilingCode fc = allCodes.filings.get(seqNum);

        collector.pushAttributeStack("al_court_bundle[" + seqNum + "]");
        JAXBElement<DocumentType> result =
            serializer.filingDocToXml(
                filingDoc,
                seqNum,
                isInitialFiling,
                allCodes.cat,
                allCodes.type,
                fc,
                isIndividual,
                info.getMiscInfo(),
                collector);
        collector.popAttributeStack();
        filingIdToObj.put(filingDoc.getIdString(), result.getValue());
        if (filingDoc.isLead()) {
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
                for (var association :
                    ecfCaseFactory.lateStageFilingAssociationAdd(
                        serializer, filingIdToObj, filingAssociations, pair.getRight())) {
                  aug.getFilingAssociation().add(association);
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
      ServiceMDEPort servicePort) {
    Optional<ServiceMDEPort> port = setupServicePort(apiToken);
    if (port.isEmpty()) {
      return Result.err(
          FilingError.serverError("Couldn't make a service MDE port with the given API token"));
    }
    ServiceReceiptMessageType receipt = port.get().serveFiling(cfm);
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
      FilingReviewMDEPort reviewPort,
      CourtRecordMDEPort recordPort,
      ApiChoice choice) {
    FilingReviewMDEPort filingPort;
    CoreFilingMessageType cfm;
    String existingCaseTitle = null;
    String caseCategoryName = null;
    String courtName = null;
    try {
      Optional<FilingReviewMDEPort> maybeFilingPort = setupFilingPort(apiToken);
      Optional<CourtRecordMDEPort> recordPort = setupRecordPort(apiToken);
      if (maybeFilingPort.isEmpty() || recordPort.isEmpty()) {
        FilingError err =
            FilingError.serverError("Couldn't create SOAP port object with token: " + apiToken);
        collector.error(err);
      }
      filingPort = maybeFilingPort.get();
      QueryType queryType =
          (choice.equals(ApiChoice.ServiceApi)) ? QueryType.Service : QueryType.Review;
      var coreAndExisting =
          prepareFiling(info, collector, apiToken, filingPort, recordPort.get(), queryType);
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
      return serveFilingIfReady(cfm, info, collector, servicePort);
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
  public Result<Response, FilingError> getFilingFees(FilingInformation info, String apiToken) {
    FailFastCollector collector = new FailFastCollector();
    CoreFilingMessageType cfm;
    Optional<FilingReviewMDEPort> filingPort = setupFilingPort(apiToken);
    Optional<CourtRecordMDEPort> recordPort = setupRecordPort(apiToken);
    if (filingPort.isEmpty() || recordPort.isEmpty()) {
      FilingError err =
          FilingError.serverError("Couldn't create SOAP port object with token: " + apiToken);
      return Result.err(err);
    }
    log.info("Getting Filing Fees");
    try {
      cfm =
          prepareFiling(
                  info, collector, apiToken, filingPort.get(), recordPort.get(), QueryType.Fees)
              .cfm;
    } catch (FilingError err) {
      log.error("Error when preparing Filing for getFilingFees", err);
      return Result.err(err);
    }

    var query = prep(new FeesCalculationQueryMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    var resp = filingPort.get().getFeesCalculation(query);

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
      FilingInformation info, FilingReviewMDEPort reviewPort, CourtRecordMDEPort recordPort) {
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
    Optional<FilingReviewMDEPort> filingPort = setupFilingPort(apiToken);
    Optional<CourtRecordMDEPort> recordPort = setupRecordPort(apiToken);
    if (filingPort.isEmpty() || recordPort.isEmpty()) {
      FilingError err =
          FilingError.serverError("Couldn't create SOAP port object with token: " + apiToken);
      return Result.err(err);
    }
    CoreFilingMessageType cfm;
    try {
      cfm =
          prepareFiling(
                  info, collector, apiToken, filingPort.get(), recordPort.get(), QueryType.Review)
              .cfm;
    } catch (FilingError err) {
      log.error("Error when preparing Filing", err);
      return Result.err(err);
    }

    ServiceTypesRequestMessageType query =
        prep(new ServiceTypesRequestMessageType(), info.getCourtLocation());
    query.setCoreFilingMessage(cfm);
    ServiceTypesResponseMessageType resp = filingPort.get().getServiceTypes(query);
    return Result.ok(
        Ecf4Helper.makeResponse(resp, () -> Response.ok(resp.getServiceType()).build()));
  }

  @Override
  public Response getFilingList(
      String courtId,
      String submitterId,
      java.time.LocalDate startDate,
      java.time.LocalDate beforeDate,
      FilingReviewMDEPort reviewPort) {
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
            + beforeDate
            + ", "
            + apiToken);

    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
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
    FilingListResponseMessageType resp = port.get().getFilingList(m);
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
  public Response getFilingStatus(String courtId, String filingId, FilingReviewMDEPort reviewPort) {
    try {
      List<String> courtIds = getAllLocations();
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
    FilingStatusQueryMessageType status =
        prep(statusObjFac.createFilingStatusQueryMessageType(), courtId);
    status.setDocumentIdentification(Ecf4Helper.convertId(filingId));
    FilingStatusResponseMessageType statusResp = port.get().getFilingStatus(status);

    return Ecf4Helper.makeResponse(statusResp, () -> Response.ok().entity(statusResp).build());
  }

  @Override
  public Response getFilingService(
      String courtId, String filingId, String contactId, FilingReviewMDEPort reviewPort) {
    Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    FilingServiceQueryMessageType req = new FilingServiceQueryMessageType();
    ServiceContactIdentificationType id = new ServiceContactIdentificationType();
    id.setIdentificationCategory(
        niemObjFac.createIdentificationCategoryText(Ecf4Helper.convertText("SERVICECONTACTID")));
    id.setIdentificationID(Ecf4Helper.convertString(contactId));
    req.setServiceContactIdentification(id);
    FilingServiceResponseMessageType resp = port.get().getFilingService(req);
    return Ecf4Helper.makeResponse(resp, () -> Response.ok(resp).build());
  }

  @Override
  public Response getFilingDetails(
      String courtId, String filingId, FilingReviewMDEPort reviewPort) {
    try {
      List<String> courtIds = getAllLocations();
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
    FilingDetailQueryMessageType m =
        prep(detailObjFac.createFilingDetailQueryMessageType(), courtId);
    m.setDocumentIdentification(Ecf4Helper.convertId(filingId));
    FilingDetailResponseMessageType resp = port.get().getFilingDetails(m);
    return Ecf4Helper.makeResponse(resp, () -> Response.ok().entity(resp).build());
  }

  @Override
  public Response getPolicy(String courtId, FilingReviewMDEPort reviewPort) {
    try {
      List<String> courtIds = getAllLocations();
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

    CourtPolicyResponseMessageType resp = policyCacher.getPolicyFor(port.get(), courtId);
    return Ecf4Helper.makeResponse(resp, () -> Response.ok(resp).build());
  }

  @Override
  public Response cancelFiling(String courtId, String filingId, FilingReviewMDEPort reviewPort) {
    try {
      List<String> courtIds = getAllLocations();
      if (!courtIds.contains(courtId)) {
        return Response.status(422).entity("Court " + courtId + " not in jurisdiction").build();
      }

      Optional<FilingReviewMDEPort> port = setupFilingPort(apiToken);
      if (port.isEmpty()) {
        return Response.status(403).build();
      }
      CancelFilingMessageType cancel = prep(cancelObjFac.createCancelFilingMessageType(), courtId);
      cancel.setDocumentIdentification(Ecf4Helper.convertId(filingId));
      CancelFilingResponseMessageType resp = port.get().cancelFiling(cancel);
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
}
