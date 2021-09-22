package edu.suffolk.litlab.efspserver.ecf;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.CaseServiceContact;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.PaymentFactory;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.codes.FilerType;
import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.codes.PartyType;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import gov.niem.niem.iso_4217._2.CurrencyCodeSimpleType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseOfficialType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import tyler.ecf.extensions.common.FilingAssociationType;
import tyler.ecf.extensions.common.ProcedureRemedyType;
import tyler.ecf.extensions.common.ProviderChargeType;
import tyler.ecf.extensions.common.ServicePartyDataType;

public class EcfCaseTypeFactory {
  private static Logger log =
      LoggerFactory.getLogger(EcfCaseTypeFactory.class);

  private CodeDatabase cd;

  public EcfCaseTypeFactory(CodeDatabase cd) {
    this.cd = cd;
  }

  /**
   * Makes a case from specific info + unorganized JSON dumps.
   *
   * @param courtLocationId the court's name a unique string. ex: 'adams'
   * @param caseCategory the {@link CaseCategory} object, from a code database
   * @param caseType the case type code from the casetype table
   * @param caseSubType the case subtype code, empty if not present
   * @param plaintiffs List of plaintiff person objects
   * @param defendants List of defendant person objects
   * @param filingIds The UIDs of all of the filings
   * @param paymentId The UID of the tyler payment account, from GetPaymentAccountList
   * @return
   * @throws FilingError
   */
  public JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>
      makeCaseTypeFromTylerCategory(
      CourtLocationInfo courtLocation,
      CaseCategory initialCaseCategory,
      CaseType caseType,
      FilingInformation info,
      boolean anyAmountInControversy,
      boolean isInitialFiling,
      boolean isFirstIndexedFiling,
      List<String> filingIds,
      // HACK(brycew): hacky: needed because fee querys put the payment stuff in the tyler Aug
      String queryType,
      JsonNode miscInfo, // TODO(brycew-later): if we get XML Answer files, this isn't generic
      EcfCourtSpecificSerializer serializer,
      InfoCollector collector
  ) throws SQLException, FilingError {
    CaseCategory caseCategory = initialCaseCategory;
    String caseCategoryCode = caseCategory.code.get();
    JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug =
        makeNiemCaseAug(courtLocation.code);
    JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug =
              makeTylerCaseAug(courtLocation, caseCategory,
                  caseType, info, isInitialFiling, isFirstIndexedFiling,
                  filingIds, queryType, miscInfo, serializer, collector);
    if (caseCategory.ecfcasetype.equals("CivilCase")) {
      Optional<BigDecimal> amountInControversy = Optional.empty();
      if (anyAmountInControversy) {
        JsonNode jsonAmt = info.getMiscInfo().get("amount_in_controversy");
        if (jsonAmt != null && jsonAmt.isBigDecimal()) {
          amountInControversy = Optional.of(jsonAmt.decimalValue());
        } else {
          collector.addRequired(collector.requestVar("amount_in_controversy", "ad danum amount", "currency"));
        }
      }
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase =
          makeCivilCaseType(caseAug, tylerAug, amountInControversy);
      myCase.getValue().setCaseCategoryText(XmlHelper.convertText(caseCategoryCode));
      return myCase;
    } else if (caseCategory.ecfcasetype.equals("DomesticCase")) {
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase =
          makeDomesticCaseType(caseAug, tylerAug, miscInfo);
      myCase.getValue().setCaseCategoryText(XmlHelper.convertText(caseCategoryCode));
      return myCase;
    } else {
      InterviewVariable var = collector.requestVar("tyler_case_category", "The " + caseCategory.name 
          + " Case category requires an ECF case type that we don't support", "text");
      collector.addWrong(var);
      FilingError err = FilingError.wrongValue(var); 
      throw err;
    }
  }

  private JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType>
      makeNiemCaseAug(String courtLocationId) {
    gov.niem.niem.domains.jxdm._4.ObjectFactory jof =
        new gov.niem.niem.domains.jxdm._4.ObjectFactory();
    gov.niem.niem.domains.jxdm._4.CaseAugmentationType caseAug = jof.createCaseAugmentationType();
    caseAug.setCaseCourt(XmlHelper.convertCourtType(courtLocationId));
    return jof.createCaseAugmentation(caseAug);
  }

  private JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType>
      makeTylerCaseAug(
          CourtLocationInfo courtLocation,
          CaseCategory caseCategory,
          CaseType caseType,
          FilingInformation info,
          boolean isInitialFiling,
          boolean isFirstIndexedFiling,
          List<String> filingIds,
          String queryType,
          JsonNode miscInfo,
          EcfCourtSpecificSerializer serializer,
          InfoCollector collector
  ) throws SQLException, FilingError {
    // NOTE: in the code tables, only a handful of outliers have more than 1 code for the same category per location
    // SELECT x.code_count, x.name, x.location from
    //    (select COUNT(code) as code_count, name, location from casecategory group by name, location)
    // as x where x.code_count > 1 order by location;

    // But, what do they have different from each other? Not sure
    tyler.ecf.extensions.common.ObjectFactory tylerObjFac =
        new tyler.ecf.extensions.common.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    gov.niem.niem.niem_core._2.ObjectFactory of = new gov.niem.niem.niem_core._2.ObjectFactory();
    gov.niem.niem.structures._2.ObjectFactory structObjFac =
        new gov.niem.niem.structures._2.ObjectFactory();

    tyler.ecf.extensions.common.CaseAugmentationType ecfAug =
        tylerObjFac.createCaseAugmentationType();


    if (caseType.code.isEmpty()){
      log.warn("Type's code is empty?: " + caseType);
    }
    else {
      log.info("Setting case type text to " + caseType.toString());
      ecfAug.setCaseTypeText(XmlHelper.convertText(caseType.code));
    }


    DataFieldRow subTypeConfig = cd.getDataField(courtLocation.code, "CaseInformationCaseSubType");
    if (subTypeConfig.isvisible) {
      List<NameAndCode> subTypes = cd.getCaseSubtypesFor(courtLocation.code, caseType.code);
      Optional<NameAndCode> maybeSubtype = subTypes.stream()
          .filter(type -> type.getName().equals(info.getCaseSubtype()))
          .findFirst();

      if (maybeSubtype.isPresent()) {
        ecfAug.setCaseSubTypeText(XmlHelper.convertText(maybeSubtype.get().getCode()));
      } else if (subTypeConfig.isrequired) {
        InterviewVariable subTypeVar = collector.requestVar("tyler_case_subtype", "Sub type of the case", "choices",
            subTypes.stream().map(nac -> nac.getName()).collect(Collectors.toList()));
        collector.addWrong(subTypeVar);
      }
    }

    List<PartyType> partyTypes = cd.getPartyTypeFor(courtLocation.code, caseType.code);
    List<String> partyTypeNames = partyTypes.stream().map(p -> p.name).collect(Collectors.toList());
    Set<String> requiredTypes = partyTypes.stream().filter(t -> t.isrequired).map(t -> t.name).collect(Collectors.toSet());
    Set<String> existingTypes = new HashSet<String>();
    for (Person plaintiff : info.getPlaintiffs()) {
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(plaintiff, collector, partyTypes, partyTypeNames);
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
      existingTypes.add(plaintiff.getRole());
    }

    for (Person defendant : info.getDefendants()) {
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(defendant, collector, partyTypes, partyTypeNames);
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
      existingTypes.add(defendant.getRole());
    }
    
    if (isFirstIndexedFiling) {  // We can assume that the initial filing handled all of the required parties
      requiredTypes.removeAll(existingTypes);
      if (!requiredTypes.isEmpty()) {
        FilingError err = FilingError.serverError("DEV ERROR: All required parties not covered by existing party types. ("
            + existingTypes + ". Missing " + requiredTypes);
        collector.error(err);
      }
    }

    int attorneyCount = 1;
    Map<String, String> attorneyIdToXmlId = new HashMap<String, String>();
    for (String attorneyId : info.getAttorneyIds()) {
      IdentificationType id = of.createIdentificationType();
      id.setIdentificationCategory(of.createIdentificationCategoryText(XmlHelper.convertText("ATTORNEYID")));
      id.setIdentificationID(XmlHelper.convertString(attorneyId));
      PersonType pt = ecfCommonObjFac.createPersonType();
      pt.getPersonOtherIdentification().add(id);
      String xmlId = Integer.toString(attorneyCount);
      pt.setId(xmlId);
      CaseParticipantType cp = ecfCommonObjFac.createCaseParticipantType();
      cp.setEntityRepresentation(ecfCommonObjFac.createEntityPerson(pt));
      // All attorneys have the role code of ATTY
      cp.setCaseParticipantRoleCode(XmlHelper.convertText("ATTY"));
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
      attorneyIdToXmlId.put(attorneyId, xmlId);
      attorneyCount += 1;
    }

    DataFieldRow attRow = cd.getDataField(info.getCourtLocation(), "PartyAttorney");
    for (Map.Entry<String, List<String>> partyAtts : info.getPartyAttorneyMap().entrySet()) {
      String partyId = partyAtts.getKey();
      ReferenceType repdRef = structObjFac.createReferenceType();
      repdRef.setRef(partyId);
      if (!attRow.isvisible) {
        continue;
      }
      if (partyAtts.getValue().isEmpty()) {
        if (attRow.isrequired) {
          InterviewVariable var = collector.requestVar("party_to_attorney",
              "Attorneys are required for this court", "DADict");
          collector.addRequired(var);
        }
        CaseOfficialType t = ecfCommonObjFac.createCaseOfficialType();
        t.getCaseRepresentedPartyReference().add(repdRef);
        ReferenceType attRef = structObjFac.createReferenceType();
        attRef.setRef(partyId);
        t.setRoleOfPersonReference(attRef);

        ecfAug.getCaseOtherEntityAttorney().add(t);
      } else {
        if (!courtLocation.allowmultipleattorneys && partyAtts.getValue().size() > 1) {
          FilingError err = FilingError.malformedInterview("Court " + info.getCourtLocation() + " doesn't allow multiple lawyers per case party.");
          collector.error(err);
        }
        for (String attId : partyAtts.getValue()) {
          CaseOfficialType t = ecfCommonObjFac.createCaseOfficialType();
          t.getCaseRepresentedPartyReference().add(repdRef);
          ReferenceType attRef = structObjFac.createReferenceType();
          attRef.setRef(attorneyIdToXmlId.get(attId));
          t.setRoleOfPersonReference(attRef);

          ecfAug.getCaseOtherEntityAttorney().add(t);
        }
      }
    }

    List<CaseServiceContact> attachedContacts = info.getServiceContacts().stream().filter(c -> c.partyAssociated.isPresent()).collect(Collectors.toList());
    boolean anyServicePartyAttached = attachedContacts.size() > 0;
    gov.niem.niem.proxy.xsd._2.Boolean servPartyIndic = XmlHelper.convertBool(anyServicePartyAttached);
    ecfAug.setAttachServiceContactIndicator(servPartyIndic);
    for (CaseServiceContact attachedContact : attachedContacts) {
      ServicePartyDataType ref = tylerObjFac.createServicePartyDataType();
      ReferenceType servRef = structObjFac.createReferenceType();
      servRef.setRef(attachedContact.refId);
      ref.setServiceReference(servRef);
      ReferenceType partyRef = structObjFac.createReferenceType();
      partyRef.setRef(attachedContact.partyAssociated.get());
      ref.setPartyReference(partyRef);
      ecfAug.getExtendedData().add(tylerObjFac.createServicePartyReference(ref));
    }


    Optional<ProcedureRemedyType> res = makeProcedureRemedyType(isInitialFiling,
        caseCategory, courtLocation.code, miscInfo, collector);

    Optional<ProcedureRemedyType> resPlus = addDamageAmountType(
        res, isInitialFiling, caseCategory, courtLocation.code, miscInfo, collector);
    if (resPlus.isPresent()) {
      ecfAug.setProcedureRemedy(resPlus.get());
    }

    // Filing
    DataFieldRow filertype = cd.getDataField(courtLocation.code, "FilingFilerType");
    if (filertype.isvisible) {
      List<FilerType> allTypes = cd.getFilerTypes(courtLocation.code);
      String filerTypeName = "filer_type";
      JsonNode filerTypeNode = miscInfo.get(filerTypeName);
      InterviewVariable var = collector.requestVar(filerTypeName,
         "Metadata about the filer of this case", "choices",
         allTypes.stream().map(t -> t.name).collect(Collectors.toList()));
      if (filerTypeNode != null && filerTypeNode.isTextual()) {
        String filerType = filerTypeNode.asText();
        Optional<FilerType> typeInfo = allTypes.stream().filter(t -> t.name.equalsIgnoreCase(filerType)).findFirst();
        if (typeInfo.isPresent()) {
          ecfAug.setFilerTypeText(XmlHelper.convertText(typeInfo.get().code));
        } else {
          collector.addWrong(var);
        }
      } else {
        Optional<FilerType> defaultType = allTypes.stream().filter(t -> t.isDefault).findFirst();
        if (defaultType.isPresent()) {
          ecfAug.setFilerTypeText(XmlHelper.convertText(defaultType.get().code));
        } else if (filertype.isrequired) {
          collector.addRequired(var);
        }
      }
    }
    
    if (courtLocation.allowreturndate && info.getReturnDate().isPresent()) {
      ecfAug.setReturnDate(XmlHelper.convertDate(info.getReturnDate().get()));
    }

    DataFieldRow filingcaseparties =
        cd.getDataField(courtLocation.code, "FilingEventCaseParties");
    gov.niem.niem.structures._2.ObjectFactory structOf =
        new gov.niem.niem.structures._2.ObjectFactory();
    if (filingcaseparties.isrequired) {
      for (String filingId : filingIds) {
        gov.niem.niem.structures._2.ReferenceType rt = structOf.createReferenceType();
        rt.setId(filingId);
        FilingAssociationType association = tylerObjFac.createFilingAssociationType();
        association.setPartyReference(rt);
        ecfAug.getFilingAssociation().add(association);
      }
    }

    if (queryType.equalsIgnoreCase("fees")) {
      PaymentFactory pf = new PaymentFactory();
      ProviderChargeType pct = pf.makeProviderChargeType(info.getPaymentId());
      ecfAug.setProviderCharge(pct);
    }
    if (miscInfo.has("max_fee_amount") && courtLocation.allowmaxfeeamount) {
      AmountType amountType = new AmountType();
      amountType.setCurrencyCode(CurrencyCodeSimpleType.USD);
      if (miscInfo.get("max_fee_amount").isBigDecimal()) {
        BigDecimal amnt = miscInfo.get("max_fee_amount").decimalValue();
        amountType.setValue(amnt);
        ecfAug.setMaxFeeAmount(amountType);
      } else {
        FilingError err = FilingError.malformedInterview("max_fee_amount needs to be a decimal (float) value");
        collector.error(err);
      }
    }

    log.info("Full ecfAug: " + ecfAug);

    return tylerObjFac.createCaseAugmentation(ecfAug);
  }

  private Optional<ProcedureRemedyType> makeProcedureRemedyType(
      boolean initial,
      CaseCategory cat,
      String courtLocationId, JsonNode miscInfo, InfoCollector collector) throws SQLException, FilingError {
    List<NameAndCode> procedureRemedies = cd.getProcedureOrRemedy(courtLocationId, cat.getCode());
    DataFieldRow procedureView = DataFieldRow.MissingDataField(cat.name);
    String procBehavior = (initial) ? cat.procedureremedyinitial : cat.procedureremedysubsequent;
    if (!procBehavior.isEmpty() && !procBehavior.equals("Not Available")) {
      procedureView = cd.getDataField(courtLocationId,
          "CivilCaseProcedureView" + ((initial) ? "Initial" : "Subsequent"));
    }
    InterviewVariable var;
    if (procedureRemedies.isEmpty()) {
      var = collector.requestVar("procedure_remedy", "Procedure Remedy", "text");
    } else {
      var = collector.requestVar("procedure_remedy", "Procedure Remedy", "choices",
          procedureRemedies.stream()
              .map(nac -> nac.getName())
              .collect(Collectors.toList()));
    }
    ProcedureRemedyType type = new ProcedureRemedyType();
    JsonNode proRem = miscInfo.get("procedure_remedy");
    if (proRem != null && !proRem.isNull() && proRem.isTextual()) {
      if (procedureView.isvisible) {
        List<NameAndCode> maybeProcedures = procedureRemedies.stream().filter(nac -> nac.getName().equals(proRem.asText())).collect(Collectors.toList());
        if (!maybeProcedures.isEmpty()) {
          for (NameAndCode nac : maybeProcedures) {
            type.getRemedyCode().add(XmlHelper.convertText(nac.getCode()));
          }
          return Optional.of(type);
        }
        collector.addWrong(var);
      } else {
        log.info("Dropping procedure_remedy " + proRem.asText() + ", since isvisible is false for " + courtLocationId);
      }
    } else {
      if (procedureView.isrequired) {
        collector.addRequired(var);
      } else {
        collector.addOptional(var);
      }
    }
    return Optional.empty();
  }

  private Optional<ProcedureRemedyType> addDamageAmountType(
      Optional<ProcedureRemedyType> existingType,
      boolean initial, CaseCategory cat,
      String courtLocationId, JsonNode miscInfo, InfoCollector collector) throws SQLException, FilingError {
    List<NameAndCode> damageAmounts = cd.getDamageAmount(courtLocationId, cat.getCode());
    DataFieldRow damageConfig = cd.getDataField(courtLocationId, "DamageAmount"); 
    String damgBehavior = (initial) ? cat.damageamountinitial : cat.damageamountsubsequent;
    if (!damgBehavior.isEmpty() && !damgBehavior.equals("Not Available")) {
      damageConfig = cd.getDataField(courtLocationId,
          "CivilCaseDamageAmount" + ((initial) ? "Initial" : "Subsequent"));
    }
    InterviewVariable var;
    if (damageAmounts.isEmpty()) {
      var = collector.requestVar("procedure_remedy", "Procedure Remedy", "text");
    } else {
      var = collector.requestVar("procedure_remedy", "Procedure Remedy", "choices",
          damageAmounts.stream()
              .map(nac -> nac.getName())
              .collect(Collectors.toList()));
    }
    JsonNode jsonDmg = miscInfo.get("damage_amount");
    if (jsonDmg!= null && !jsonDmg.isNull() && jsonDmg.isTextual()) {
      if (damageConfig.isvisible) {
        Optional<NameAndCode> maybeDmg = damageAmounts.stream().filter(nac -> nac.getName().equals(jsonDmg.asText())).findFirst();
        if (maybeDmg.isPresent()) {
          ProcedureRemedyType type = existingType.orElse(new ProcedureRemedyType());
          type.setDamageAmountCode(XmlHelper.convertText(maybeDmg.get().getCode()));
          return Optional.of(type);
        } else {
          collector.addWrong(var);
        }
      } else {
        log.info("Dropping damage_amount " + jsonDmg.asText() + ", since isvisible is false for " + courtLocationId);
      }
    } else {
      if (damageConfig.isrequired) {
        collector.addRequired(var);
      } else {
        collector.addOptional(var);
      }
    }
    return existingType;
  }

  /**
   * Makes a civil case to include in queries like FeesQuery and ReviewFiling.
   *
   * @param caseAug The Niem JXDM augmentation type, contains the case court
   * @param tylerAug The Tyler case augementation type, contains most of the case info
   * @param amountInControversy "The ad damnum value. Only applicable if the filing code is
   *     configured AmountInControversy=Required. When enabled this value affects the
   *     calculations for fees and return date."
   * @return A complete Civil Case type
   */
  private JAXBElement<CivilCaseType> makeCivilCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug,
      Optional<BigDecimal> amountInControversy) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory ecfCivilObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();

    CivilCaseType c = ecfCivilObjFac.createCivilCaseType();
    c.getRest().add(caseAug);
    c.getRest().add(tylerAug);
    JAXBElement<TextType> causeOfAction = ecfCommonObjFac.createCauseOfActionCode(new TextType());
    c.getRest().add(causeOfAction);

    if (amountInControversy.isPresent()) {
      AmountType amount = new AmountType();
      amount.setValue(amountInControversy.get());
      amount.setCurrencyCode(CurrencyCodeSimpleType.USD);
      c.getRest().add(ecfCivilObjFac.createAmountInControversy(amount));
    }
    c.getRest().add(ecfCivilObjFac.createClassActionIndicator(XmlHelper.convertBool(false)));
    c.getRest().add(ecfCivilObjFac.createJurisdictionalGroundsCode(XmlHelper.convertText("")));
    c.getRest().add(ecfCivilObjFac.createJuryDemandIndicator(XmlHelper.convertBool(false)));
    JAXBElement<TextType> relief = ecfCivilObjFac.createReliefTypeCode(new TextType());
    c.getRest().add(relief);
    return ecfCivilObjFac.createCivilCase(c);
  }

  private JAXBElement<DomesticCaseType> makeDomesticCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug,
      JsonNode node) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory ecfDomesticObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    DomesticCaseType d = ecfDomesticObjFac.createDomesticCaseType();
    d.getRest().add(caseAug);
    d.getRest().add(tylerAug);
    JAXBElement<TextType> causeOfAction = ecfCommonObjFac.createCauseOfActionCode(new TextType());
    d.getRest().add(causeOfAction);
    boolean contestedCase = false;
    JsonNode jsonContested = node.get("is_contested_case");
    if (jsonContested != null && jsonContested.isBoolean()) {
      contestedCase = jsonContested.asBoolean();
    }
    d.getRest().add(ecfDomesticObjFac.createCaseContestedIndicator(
        XmlHelper.convertBool(contestedCase)));
    d.getRest().add(ecfDomesticObjFac.createDomesticCasePerson(new PersonType()));
    return ecfDomesticObjFac.createDomesticCase(d);
  }

  private JAXBElement<CriminalCaseType> makeCriminalCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug) {
    // BIG OLD TODO(brycew-later): make all of the TODO's separate issues/tickets to implement criminal
    // stuff. There's alot here.
    // TODO(brycew-later): support criminal case filings

    // TODO(brycew-later): there are just too many tables for separate TODOs.
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
}
