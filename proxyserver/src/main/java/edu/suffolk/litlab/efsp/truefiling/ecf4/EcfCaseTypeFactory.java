package edu.suffolk.litlab.efsp.truefiling.ecf4;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecf4.EcfCaseTypes;
import edu.suffolk.litlab.efsp.ecf4.QueryType;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.CaseCategory;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodeDatabase;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import gov.niem.niem.iso_4217._2.CurrencyCodeSimpleType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryCriteriaType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseOfficialType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EcfCaseTypeFactory {
  private static Logger log = LoggerFactory.getLogger(EcfCaseTypeFactory.class);

  private final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory
      ecfCommonObjFac;
  private final gov.niem.niem.niem_core._2.ObjectFactory of;
  private final gov.niem.niem.structures._2.ObjectFactory structObjFac;

  public EcfCaseTypeFactory(TFCodeDatabase cd, Jurisdiction jurisdiction) {
    this.ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    this.of = new gov.niem.niem.niem_core._2.ObjectFactory();
    this.structObjFac = new gov.niem.niem.structures._2.ObjectFactory();
  }

  public static Optional<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> getJCaseAugmentation(
      gov.niem.niem.niem_core._2.CaseType filedCase) {
    List<JAXBElement<?>> restList = List.of();
    if (filedCase instanceof CivilCaseType civilCase) {
      restList = civilCase.getRest();
    } else if (filedCase instanceof DomesticCaseType domesCase) {
      restList = domesCase.getRest();
    } else if (filedCase instanceof CriminalCaseType criminalCase) {
      restList = criminalCase.getRest();
    } else if (filedCase instanceof AppellateCaseType appellate) {
      restList = appellate.getRest();
    }
    for (JAXBElement<?> elem : restList) {
      if (elem.getValue() instanceof gov.niem.niem.domains.jxdm._4.CaseAugmentationType aug) {
        return Optional.of(aug);
      }
    }
    return Optional.empty();
  }

  public static CaseQueryCriteriaType getCriteria() {
    CaseQueryCriteriaType crit = new CaseQueryCriteriaType();
    return crit;
  }

  /**
   * Dumb XML requires you to have the Object itself before you can reference it, you can't just use
   * the ID. But we don't have the filing document objects when making the case.
   */
  public record ComboCaseCodes(
      CaseCategory cat,
      NameAndCode type,
      List<NameAndCode> filings,
      Map<PartyId, PartyInfo> partyInfo) {}

  /**
   * Makes a case from specific info + unorganized JSON dumps.
   *
   * @param courtLocation the court's name a unique string. ex: 'adams'
   * @param comboCodes contains the case category, the case type code, and the case subtype code (if
   *     present)
   * @param info The full information about the filing
   * @param isInitialFiling
   * @param isFirstIndexedFiling
   * @param queryType
   * @param serializer
   * @param collector
   * @param serviceContactToXmlObjs
   * @return two objects: the actual case object, and a map from party ID to the object inside the
   *     case, used to associate other elements to the party element later on.
   * @throws FilingError
   * @throws SQLException
   */
  public Pair<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>, Map<String, Object>>
      makeCaseTypeFromCaseCategory(
          String courtLocation,
          ComboCaseCodes comboCodes,
          FilingInformation info,
          boolean isInitialFiling,
          boolean isFirstIndexedFiling,
          // HACK(brycew): hacky: needed because "fees" querys and "service" put the payment stuff
          // in the tyler Aug
          QueryType queryType,
          EcfCourtSpecificSerializer serializer,
          InfoCollector collector)
          throws SQLException, FilingError {
    JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug =
        makeNiemCaseAug(courtLocation, info.getPreviousCaseId());
    var pair =
        makeEcfCaseAug(
            courtLocation,
            comboCodes,
            info,
            isInitialFiling,
            isFirstIndexedFiling,
            queryType,
            serializer);
    JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType>
        ecfAug = pair.getLeft();
    JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase;
    var ecftype = comboCodes.cat().ecfCaseType();
    if (ecftype == EcfCaseTypes.CivilCase) {
      myCase =
          makeCivilCaseType(
              caseAug,
              ecfAug,
              info.getCaseDocketNumber(),
              comboCodes.cat(),
              info.getPreviousCaseId(),
              info.getAmountInControversy());
    } else if (ecftype == EcfCaseTypes.DomesticCase) {
      myCase =
          makeDomesticCaseType(
              caseAug,
              ecfAug,
              info.getCaseDocketNumber(),
              info.getPreviousCaseId(),
              info.isContestedCase());
    } else if (ecftype == EcfCaseTypes.AppellateCase) {
      myCase = makeAppellateCaseType(caseAug, ecfAug, info, collector);
    } else if (ecftype == EcfCaseTypes.BankruptcyCase
        || ecftype == EcfCaseTypes.CitationCase
        || ecftype == EcfCaseTypes.JuvenileCase
        || ecftype == EcfCaseTypes.CriminalCase) {
      // TODO(brycew): handle these
      InterviewVariable var =
          collector.requestVar(
              "efile_case_category",
              "The "
                  + comboCodes.cat().name()
                  + " Case category requires an ECF case type that we know about but don't yet"
                  + " support ("
                  + ecftype
                  + ")",
              "text",
              List.of(),
              Optional.of(comboCodes.cat().code()));
      collector.addWrong(var);
      FilingError err = FilingError.wrongValue(var);
      throw err;
    } else {
      InterviewVariable var =
          collector.requestVar(
              "efile_case_category",
              "The "
                  + comboCodes.cat().name()
                  + " Case category requires an ECF case type that we don't know about or support ("
                  + ecftype
                  + ")",
              "text",
              List.of(),
              Optional.of(comboCodes.cat().code()));
      collector.addWrong(var);
      FilingError err = FilingError.wrongValue(var);
      throw err;
    }
    // NOTE: TrueFilling specifically puts the Case category in the Case type entry
    myCase.getValue().setCaseCategoryText(Ecf4Helper.convertText(comboCodes.type().code()));
    return Pair.of(myCase, pair.getRight());
  }

  private static JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> makeNiemCaseAug(
      String courtLocationId, Optional<String> trackingId) {
    var jof = new gov.niem.niem.domains.jxdm._4.ObjectFactory();
    var caseAug = jof.createCaseAugmentationType();
    caseAug.setCaseCourt(Ecf4Helper.convertCourtType(courtLocationId));
    trackingId.ifPresent(
        tracking -> {
          var coreObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
          var ct = coreObjFac.createCaseType();
          ct.setCaseTrackingID(Ecf4Helper.convertString(tracking));
          caseAug.getCaseLineageCase().add(ct);
        });
    return jof.createCaseAugmentation(caseAug);
  }

  private Pair<
          JAXBElement<
              oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType>,
          Map<String, Object>>
      makeEcfCaseAug(
          String courtLocation,
          ComboCaseCodes comboCodes,
          FilingInformation info,
          boolean isInitialFiling,
          boolean isFirstIndexedFiling,
          QueryType queryType,
          EcfCourtSpecificSerializer serializer)
          throws SQLException, FilingError {
    var ecfAug = ecfCommonObjFac.createCaseAugmentationType();

    Set<String> presentPartyTypes = new HashSet<>();
    Map<String, Object> partyIdToRefObj = new HashMap<>();
    for (Person plaintiff : info.getNewPlaintiffs()) {
      var pInfo = comboCodes.partyInfo().get(plaintiff.getPartyId());
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(plaintiff, pInfo);
      ecfAug.getCaseParticipant().add(cp);
      partyIdToRefObj.put(plaintiff.getIdString(), cp.getEntityRepresentation().getValue());
      presentPartyTypes.add(pInfo.type().code());
    }

    for (Person defendant : info.getNewDefendants()) {
      var pInfo = comboCodes.partyInfo().get(defendant.getPartyId());
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(defendant, pInfo);
      ecfAug.getCaseParticipant().add(cp);
      partyIdToRefObj.put(defendant.getIdString(), cp.getEntityRepresentation().getValue());
      presentPartyTypes.add(pInfo.type().code());
    }

    int attorneyCount = 1;
    Map<String, PersonType> attorneyIdToXmlId = new HashMap<>();
    for (String attorneyId : info.getAttorneyIds()) {
      IdentificationType id = of.createIdentificationType();
      id.setIdentificationCategory(
          of.createIdentificationCategoryText(Ecf4Helper.convertText("ATTORNEYID")));
      id.setIdentificationID(Ecf4Helper.convertString(attorneyId));
      PersonType pt = ecfCommonObjFac.createPersonType();
      pt.getPersonOtherIdentification().add(id);
      String xmlId = "attorneyCount-" + Integer.toString(attorneyCount);
      pt.setId(xmlId);
      CaseParticipantType cp = ecfCommonObjFac.createCaseParticipantType();
      cp.setEntityRepresentation(ecfCommonObjFac.createEntityPerson(pt));
      // All attorneys have the role code of ATTY
      cp.setCaseParticipantRoleCode(Ecf4Helper.convertText("ATTY"));
      ecfAug.getCaseParticipant().add(cp);
      attorneyIdToXmlId.put(attorneyId, pt);
      attorneyCount += 1;
    }

    // Add all of the existing parties that are referenced somehow (either adding new attorney,
    // service contact, or filing party) to the XML
    var stream =
        Stream.concat(
                Stream.concat(
                    info.getServiceContacts().stream()
                        .filter(c -> c.partyAssociated.isPresent())
                        .map(c -> c.partyAssociated.get()),
                    info.getPartyAttorneyMap().entrySet().stream().map(pa -> pa.getKey())),
                info.getFilings().stream().flatMap(filing -> filing.getFilingPartyIds().stream()))
            .distinct();
    Iterable<PartyId> iterator = stream::iterator;
    for (PartyId partyId : iterator) {
      log.info("Referenced PartyId ({})", partyId);
      if (partyId.isAlreadyInCase()) {
        CaseParticipantType cpt = ecfCommonObjFac.createCaseParticipantType();
        IdentificationType id = of.createIdentificationType();
        id.setIdentificationCategory(
            of.createIdentificationCategoryText(Ecf4Helper.convertText("CASEPARTYID")));
        id.setIdentificationID(Ecf4Helper.convertString(partyId.getIdentificationString()));
        var pInfo = comboCodes.partyInfo().get(partyId);
        boolean isOrg = false;
        if (pInfo == null) {
          log.warn("PartyId ({}) has null info in combocodes. Why? Assuming person", partyId);
          log.warn(
              "Service contacts: "
                  + info.getServiceContacts().stream()
                      .filter(c -> c.partyAssociated.isPresent())
                      .map(c -> c.partyAssociated.get()));
          log.warn(
              "Party attorneys: "
                  + info.getPartyAttorneyMap().entrySet().stream().map(pa -> pa.getKey()));
          log.warn(
              "Filing party IDs:"
                  + info.getFilings().stream()
                      .flatMap(filing -> filing.getFilingPartyIds().stream()));
        } else {
          isOrg = pInfo.isOrg();
        }
        if (isOrg) {
          OrganizationType ot = ecfCommonObjFac.createOrganizationType();
          ot.setOrganizationIdentification(id);
          ot.setId(partyId.getIdString());
          cpt.setEntityRepresentation(ecfCommonObjFac.createEntityOrganization(ot));
          partyIdToRefObj.put(partyId.getIdString(), ot);
        } else {
          PersonType pt = ecfCommonObjFac.createPersonType();
          pt.setId(partyId.getIdString());
          pt.getPersonOtherIdentification().add(id);
          cpt.setEntityRepresentation(ecfCommonObjFac.createEntityPerson(pt));
          partyIdToRefObj.put(partyId.getIdString(), pt);
        }
        if (pInfo != null && pInfo.type() != null) {
          cpt.setCaseParticipantRoleCode(Ecf4Helper.convertText(pInfo.type().code()));
        } else {
          cpt.setCaseParticipantRoleCode(
              Ecf4Helper.convertText("")); // Will likely cause an error, but what can we do now?
        }
        ecfAug.getCaseParticipant().add(cpt);
      }
    }

    for (Map.Entry<PartyId, List<String>> partyAttys : info.getPartyAttorneyMap().entrySet()) {
      log.info("Setting Attorneys for : {}", partyAttys.getKey());
      Object partyObj = partyIdToRefObj.get(partyAttys.getKey().getIdString());
      if (partyObj == null) {
        log.warn(
            "Can't handle current filing participant ({}) not already added?!",
            partyAttys.getKey().getIdString());
        continue;
      }
      ReferenceType repdRef = structObjFac.createReferenceType();
      repdRef.setRef(partyObj);
      if (partyAttys.getValue().isEmpty()) {
        // Is Self-Represented
        CaseOfficialType t = ecfCommonObjFac.createCaseOfficialType();
        t.getCaseRepresentedPartyReference().add(repdRef);
        ReferenceType selfRepresentedRep = structObjFac.createReferenceType();
        selfRepresentedRep.setRef(partyObj);
        t.setRoleOfPersonReference(selfRepresentedRep);
        ecfAug.getCaseOtherEntityAttorney().add(t);
      } else {
        for (String attyId : partyAttys.getValue()) {
          CaseOfficialType t = ecfCommonObjFac.createCaseOfficialType();
          t.getCaseRepresentedPartyReference().add(repdRef);
          ReferenceType attRef = structObjFac.createReferenceType();
          attRef.setRef(attorneyIdToXmlId.get(attyId));
          t.setRoleOfPersonReference(attRef);
          ecfAug.getCaseOtherEntityAttorney().add(t);
        }
      }
    }

    /*
    List<CaseServiceContact> attachedContacts =
        info.getServiceContacts().stream()
            .filter(c -> c.partyAssociated.isPresent())
            .collect(Collectors.toList());
    boolean anyServicePartyAttached = attachedContacts.size() > 0;
    //ecfAug.setAttachServiceContactIndicator(Ecf4Helper.convertBool(anyServicePartyAttached));
    for (CaseServiceContact attachedContact : attachedContacts) {
      ServicePartyDataType ref = tylerObjFac.createServicePartyDataType();
      ReferenceType servRef = structObjFac.createReferenceType();
      servRef.setRef(serviceContactXmlObjs.get(attachedContact.refId));
      ref.setServiceReference(servRef);
      attachedContact.partyAssociated.ifPresent(
          partyId -> {
            if (partyIdToRefObj.containsKey(partyId.getIdString())) {
              ReferenceType partyRef = structObjFac.createReferenceType();
              partyRef.setRef(partyIdToRefObj.get(partyId.getIdString()));
              ref.setPartyReference(partyRef);
            } else {
              log.warn(
                  "Couldn't find partyId: " + partyId + ", not in " + partyIdToRefObj.keySet());
            }
          });
      ecfAug.getExtendedData().add(tylerObjFac.createServicePartyReference(ref));
    } */

    // HACK(brycew): hacky: needed because "fees" querys and "service" put the payment stuff in the
    // tyler Aug, but not the review api.
    // if (queryType.equals(QueryType.Fees) || queryType.equals(QueryType.Service)) {
    // if (info.getPaymentId() == null || info.getPaymentId().isBlank()) {
    //  collector.addRequired(collector.requestVar("tyler_payment_id", "The ID of the payment
    // method", "text"));
    // }
    //  ecfAug.setProviderCharge(
    //      PaymentFactory.makeProviderChargeType(info.getPaymentId(), this.jurisdiction));
    // }

    /*info.getMaxFeeAmount()
        .ifPresent(
            amnt -> {
              AmountType amountType = new AmountType();
              amountType.setCurrencyCode(CurrencyCodeSimpleType.USD);
              amountType.setValue(amnt);
              ecfAug.setMaxFeeAmount(amountType);
            });
    */

    return Pair.of(ecfCommonObjFac.createCaseAugmentation(ecfAug), partyIdToRefObj);
  }

  /*private Optional<ProcedureRemedyType> makeProcedureRemedyType(Optional<NameAndCode> procRemCode) {
    return procRemCode.map(
        code -> {
          ProcedureRemedyType type = new ProcedureRemedyType();
          type.getRemedyCode().add(Ecf4Helper.convertText(code.getCode()));
          return type;
        });
  }*/

  /**
   * Makes a civil case to include in queries like FeesQuery and ReviewFiling.
   *
   * @param caseAug The Niem JXDM augmentation type, contains the case court
   * @param ecfAug The ECF case augmentation type, contains most of the case info
   * @param amountInControversy "The ad damnum value. Only applicable if the filing code is
   *     configured AmountInControversy=Required. When enabled this value affects the calculations
   *     for fees and return date."
   * @return A complete Civil Case type
   */
  private JAXBElement<CivilCaseType> makeCivilCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType>
          ecfAug,
      Optional<String> caseDocketId,
      NameAndCode caseCategory,
      Optional<String> caseTrackingId,
      Optional<BigDecimal> amountInControversy) {
    var ecfCivilObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory();
    var ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    CivilCaseType c = ecfCivilObjFac.createCivilCaseType();
    c.setCaseCategoryText(Ecf4Helper.convertText(caseCategory.code()));
    c.setActivityDateRepresentation(of.createActivityDate(Ecf4Helper.convertDate(LocalDate.now())));
    c.setCaseTitleText(Ecf4Helper.convertText("*** NO CASE DESCRIPTION PROVIDED BY COURT ***"));
    caseDocketId.ifPresent(
        docket -> {
          c.setCaseDocketID(Ecf4Helper.convertString(docket));
        });
    caseTrackingId.ifPresent(
        trackingId -> {
          c.setCaseTrackingID(Ecf4Helper.convertString(trackingId));
        });
    c.getRest().add(caseAug);
    c.getRest().add(ecfAug);
    c.getRest().add(ecfCommonObjFac.createCauseOfActionCode(Ecf4Helper.convertText("CIV750LT")));
    c.getRest().add(ecfCivilObjFac.createClassActionIndicator(Ecf4Helper.convertBool(false)));
    c.getRest().add(ecfCivilObjFac.createJuryDemandIndicator(Ecf4Helper.convertBool(false)));
    c.getRest().add(ecfCivilObjFac.createReliefTypeCode(new TextType()));

    amountInControversy.ifPresent(
        amt -> {
          AmountType amount = new AmountType();
          amount.setValue(amt);
          amount.setCurrencyCode(CurrencyCodeSimpleType.USD);
          c.getRest().add(ecfCivilObjFac.createAmountInControversy(amount));
        });
    return ecfCivilObjFac.createCivilCase(c);
  }

  /**
   * Required JSON info from DA interview: - lower_court_case.title - lower_court_case.docket_number
   * - lower_court_case.judge - trial_court.name (specifically lower_court_case.court.name)
   */
  private static JAXBElement<AppellateCaseType> makeAppellateCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType>
          ecfAug,
      FilingInformation info,
      InfoCollector collector)
      throws FilingError {
    var ecfAppellateObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.ObjectFactory();
    var niemObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
    AppellateCaseType appl = ecfAppellateObjFac.createAppellateCaseType();
    info.getCaseDocketNumber()
        .ifPresent(
            docket -> {
              appl.setCaseDocketID(Ecf4Helper.convertString(docket));
            });
    info.getPreviousCaseId()
        .ifPresent(
            trackingId -> {
              appl.setCaseTrackingID(Ecf4Helper.convertString(trackingId));
            });

    appl.getRest().add(caseAug);

    CaseType ct = niemObjFac.createCaseType();

    if (info.getLowerCourtInfo().isPresent()) {
      var lowerInfo = info.getLowerCourtInfo().get();
      InterviewVariable lowerNameVar =
          collector.requestVar(
              "trial_court.name",
              "The lower court name",
              "text",
              List.of(),
              Optional.ofNullable(lowerInfo).map(l -> l.toString()));
      /*
      if (lowerInfo.lowerCourtCode == null || lowerInfo.lowerCourtCode.isBlank()) {
        // Lower court code doesn't seem to actually be required on the eFileMA site and its kind of
        // broken, so commenting this out
        // collector.addRequired(lowerNameVar);
        ecfAug.getValue().setLowerCourtText(Ecf4Helper.convertText(""));
      } else {
        ecfAug.getValue().setLowerCourtText(Ecf4Helper.convertText(lowerInfo.lowerCourtCode));
      }
      */
      if (lowerInfo.lowerCourtJudgeName == null || lowerInfo.lowerCourtJudgeName.isBlank()) {
        InterviewVariable var =
            collector.requestVar(
                "judge", "The name of the Judge who gave the lower court decision", "text");
        collector.addRequired(var);
      }
      // ecfAug
      //    .getValue()
      //    .setLowerCourtJudgeText(Ecf4Helper.convertText(lowerInfo.lowerCourtJudgeName));
      if (lowerInfo.caseTitleText.isBlank()) {
        InterviewVariable var =
            collector.requestVar("title", "The name of the lower court case", "text");
        collector.addRequired(var);
      }
      ct.setCaseTitleText(Ecf4Helper.convertText(lowerInfo.caseTitleText));
      if (lowerInfo.caseDocketId.isBlank()) {
        InterviewVariable var =
            collector.requestVar(
                "docket_number", "The docket number of the lower court case", "text");
        collector.addRequired(var);
      }
      ct.setCaseDocketID(Ecf4Helper.convertString(lowerInfo.caseDocketId));
      appl.getRest().add(ecfAug);
      appl.getAppellateCaseOriginalCase().add(ct);
    } else { // No lower court information at all, even docket number
      // this info all seems to be optional, but there isn't a known way right now to reach this
      // branch
      // collector.addRequired(lowerNameVar);
    }

    return ecfAppellateObjFac.createAppellateCase(appl);
  }

  private static JAXBElement<DomesticCaseType> makeDomesticCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType>
          ecfAug,
      Optional<String> caseDocketId,
      Optional<String> caseTrackingId,
      boolean contestedCase) {
    var ecfDomesticObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory();
    var ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    DomesticCaseType d = ecfDomesticObjFac.createDomesticCaseType();
    caseDocketId.ifPresent(
        docket -> {
          d.setCaseDocketID(Ecf4Helper.convertString(docket));
        });
    caseTrackingId.ifPresent(
        trackingId -> {
          d.setCaseTrackingID(Ecf4Helper.convertString(trackingId));
        });
    d.getRest().add(caseAug);
    d.getRest().add(ecfAug);
    JAXBElement<TextType> causeOfAction = ecfCommonObjFac.createCauseOfActionCode(new TextType());
    d.getRest().add(causeOfAction);
    d.getRest()
        .add(ecfDomesticObjFac.createCaseContestedIndicator(Ecf4Helper.convertBool(contestedCase)));
    d.getRest().add(ecfDomesticObjFac.createDomesticCasePerson(new PersonType()));
    return ecfDomesticObjFac.createDomesticCase(d);
  }

  /*
  private JAXBElement<CriminalCaseType> makeCriminalCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType> ecfAug) {
    // BIG OLD TODO(#86): make all of the TODO's separate issues/tickets to implement criminal
    // stuff. There's alot here.
    // TODO(#86): support criminal case filings

    // TODO(#86): there are just too many tables for separate TODOs.
    // Most of these are empty in IL, so we aren't supporting for now.
    // Listing them individually:
    // * vehicletype, i.e. Four Door, 34 PU, Moped, etc.
    // * vehiclemake
    // * vehiclecolor
    // * statuetypes, a whole lot, lol
    // * statute
    // * race: PersonRaceText in ReviewFiling
    // * question: QuestionAnswer in ReviewFiling
    // * answer: QuestionAnswer in ReviewFiling
    // * bond: relates to CaseChargeBondAmount, CaseChargeBondType, and BondTypeText in ReviewFiling
    // * arrestlocation
    // * chargephase: in ReviewFiling Criminal
    // * citationjurisdiction
    // * haircolor
    // * general offense
    // * lawenforcementunit: EnforcementOfficialText
    // * eyecolor
    // * ethnicity
    // * physicalfeature: personphysicalfeature, and physicalfeature
    // * degree: statutelevelchange
    return null;
  }
  */
}
