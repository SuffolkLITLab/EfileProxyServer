package edu.suffolk.litlab.efspserver.ecf;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.Result;

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
import edu.suffolk.litlab.efspserver.codes.FilingCode;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;
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
  public Result<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>, FilingError> 
      makeCaseTypeFromTylerCategory(
      CourtLocationInfo courtLocation,
      CaseCategory initialCaseCategory,
      CaseType caseType,
      FilingInformation info,
      FilingCode filing,
      List<String> filingIds,
      // HACK(brycew): hacky: needed because fee querys put the payment stuff in the tyler Aug
      String queryType, 
      JsonNode miscInfo, // TODO(brycew): if we get XML Answer files, this isn't generic
      EcfCourtSpecificSerializer serializer,
      InfoCollector collector
  ) throws SQLException, FilingError {
    CaseCategory caseCategory = initialCaseCategory; 
    String caseCategoryCode = caseCategory.code.get();
    JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug = 
        makeNiemCaseAug(courtLocation.code);
    JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug = 
              makeTylerCaseAug(courtLocation, caseCategory, 
                  caseType, info, 
                  filingIds, queryType, miscInfo, serializer, collector);
    // TODO(brycew): handle ensuring the passed in values work with the court codes
    if (caseCategory.ecfcasetype.equals("CivilCase")) {
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase = 
          makeCivilCaseType(
              caseAug, tylerAug, filing,
              // TODO(brycew) from the gson
              new BigDecimal(500.0));
      myCase.getValue().setCaseCategoryText(XmlHelper.convertText(caseCategoryCode)); 
      return Result.ok(myCase);
    } else if (caseCategory.ecfcasetype.equals("DomesticCase")) {
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase = 
          makeDomesticCaseType(caseAug, tylerAug, miscInfo);
      myCase.getValue().setCaseCategoryText(XmlHelper.convertText(caseCategoryCode)); 
      return Result.ok(myCase);
    } else {
      // TODO(brycew): start passing back why we couldn't make a case from this info
      return Result.err(FilingError.serverError("TODO(brycew): why couldn't we make this case?"));
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
    List<PartyType> requiredTypes = partyTypes.stream().filter(t -> t.isrequired).collect(Collectors.toList());
    if (requiredTypes.size() > 2) { 
      FilingError err = FilingError.serverError("DEV ERROR: there are more than 2 required parties ("
          + requiredTypes + "), but only 2 are supported");
      collector.error(err);
      throw err;
    }
    if (requiredTypes.stream().filter(t -> !t.name.equals(info.getPlaintiffPartyType()) && !t.name.equals(info.getDefendantPartyType())).findAny().isPresent()) {
      FilingError err = FilingError.serverError("DEV ERROR: All required parties (" + requiredTypes + ") not covered by plaintiff and defendant party types. ("
          + info.getPlaintiffPartyType() + " " + info.getDefendantPartyType()); 
      collector.error(err);
      throw err;
    }
    List<String> partyTypeNames = partyTypes.stream().map(p -> p.name).collect(Collectors.toList());
    if (!partyTypeNames.contains(info.getPlaintiffPartyType())) {
      InterviewVariable plaintiffVar = collector.requestVar("plaintiff_party_type", "Legal role of the plaintiff", "choices", partyTypeNames);
      collector.addWrong(plaintiffVar);
    }

    if (!partyTypeNames.contains(info.getDefendantPartyType())) {
      InterviewVariable defendantVar = collector.requestVar("defendant_party_type", "Legal role of the defendant", "choices", partyTypeNames);
      collector.addWrong(defendantVar);
    }
    
    for (Person plaintiff : info.getPlaintiffs()) {
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(plaintiff, collector); 
      TextType tt = of.createTextType();
      partyTypes.stream()
          .filter(pt -> pt.name.equalsIgnoreCase(info.getPlaintiffPartyType()))
          .findFirst()
          .ifPresent(pt -> tt.setValue(pt.code));
      cp.setCaseParticipantRoleCode(tt);
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
    }

    for (Person defendant : info.getDefendants()) {
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(defendant, collector);
      TextType tt = of.createTextType();
      partyTypes.stream()
          .filter((pt) -> pt.name.equalsIgnoreCase(info.getDefendantPartyType()))
          .findFirst()
          .ifPresent((pt) -> tt.setValue(pt.code));
      cp.setCaseParticipantRoleCode(tt);
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
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
          throw err;
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
    
    
    boolean initial = caseType.initial;
    Optional<ProcedureRemedyType> res = makeProcedureRemedyType(initial, 
        caseCategory, courtLocation.code, miscInfo, collector);

    Optional<ProcedureRemedyType> resPlus = addDamageAmountType(
        res, initial, caseCategory, courtLocation.code, miscInfo, collector);
    if (resPlus.isPresent()) {
      ecfAug.setProcedureRemedy(resPlus.get());
    }

    // Filing
    DataFieldRow filertype = cd.getDataField(courtLocation.code, "FilingFilerType");
    if (filertype.isvisible) {
      List<FilerType> allTypes = cd.getFilerTypes(courtLocation.code);
      String filerTypeName = "filer_type";
      JsonNode filerTypeNode = miscInfo.get(filerTypeName);
      InterviewVariable var = collector.requestVar("filer_type", 
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
    // TODO(brycew): FilingComponent
    // TODO(brycew): optional service
    

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
      // TODO(brycew): should I parse from String instead? Unclear
      if (miscInfo.get("max_fee_amount").isBigDecimal()) {
        BigDecimal amnt = miscInfo.get("max_fee_amount").decimalValue();
        amountType.setValue(amnt);
        ecfAug.setMaxFeeAmount(amountType);
      } else {
        throw FilingError.malformedInterview("max_fee_amount needs to be a decimal (float) value");
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
    // TODO(brycew): what the heck to do with the DataFieldConfig code = "DamageAmount"? No examples
    DataFieldRow damageConfig = DataFieldRow.MissingDataField(cat.name);
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
      FilingCode filing,
      BigDecimal amountInControversy) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory ecfCivilObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory ecfCommonObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    
    CivilCaseType c = ecfCivilObjFac.createCivilCaseType();
    c.getRest().add(caseAug);
    c.getRest().add(tylerAug);
    JAXBElement<TextType> causeOfAction = ecfCommonObjFac.createCauseOfActionCode(new TextType());
    c.getRest().add(causeOfAction);

    if (filing.amountincontroversy.equals("Required")) {
      AmountType amount = new AmountType();
      amount.setValue(amountInControversy);
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
    // BIG OLD TODO(brycew): make all of the TODO's separate issues/tickets to implement criminal
    // stuff. There's alot here.
    // TODO(brycew): support criminal case filings
    
    // TODO(brycew): there are just too many tables for separate TODOs. 
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
