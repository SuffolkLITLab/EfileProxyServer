package edu.suffolk.litlab.efspserver.ecf;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.CaseServiceContact;
import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
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
import gov.niem.niem.niem_core._2.PersonNameType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.Set;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryCriteriaType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseOfficialType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import tyler.ecf.extensions.common.CaseAugmentationType;
import tyler.ecf.extensions.common.FilingAssociationType;
import tyler.ecf.extensions.common.OrganizationIdentificationType;
import tyler.ecf.extensions.common.ProcedureRemedyType;
import tyler.ecf.extensions.common.ServicePartyDataType;

public class EcfCaseTypeFactory {
  private static Logger log =
      LoggerFactory.getLogger(EcfCaseTypeFactory.class);

  private CodeDatabase cd;

  public EcfCaseTypeFactory(CodeDatabase cd) {
    this.cd = cd;
  }

  public static Optional<CaseAugmentationType> getCaseAugmentation(
      gov.niem.niem.niem_core._2.CaseType filedCase) {
    List<JAXBElement<?>> restList = List.of();
    if (filedCase instanceof CivilCaseType civilCase) {
      restList = civilCase.getRest();
    } else if (filedCase instanceof DomesticCaseType domesCase) {
      restList = domesCase.getRest();
    } else if (filedCase instanceof CriminalCaseType criminalCase) {
      restList = criminalCase.getRest();
    }
    for (JAXBElement<?> elem : restList) {
      if (elem.getValue() instanceof CaseAugmentationType aug) {
        return Optional.of(aug);
      }
    }

    return Optional.empty();
  }
  
  /** TODO(brycew): finish this function, lots of possible rabbit holes here. */
  public static Optional<Map<PartyId, Person>> getCaseParticipants(
      gov.niem.niem.niem_core._2.CaseType filedCase) {
    Map<PartyId, Person> existingParticipants = new HashMap<>();
    Optional<CaseAugmentationType> maybeAug = getCaseAugmentation(filedCase);
    if (maybeAug.isEmpty()) {
      return Optional.empty();
    }
    
    for (var jaxPart : maybeAug.get().getCaseParticipant()) {
      String role = jaxPart.getValue().getCaseParticipantRoleCode().getValue();
      var entRep = jaxPart.getValue().getEntityRepresentation();
      boolean isOrg = false;
      String efmId = "";
      Name name = new Name("", "", "");
      if (entRep.getValue() instanceof PersonType perType) {
        isOrg = false;
        if (perType.getPersonName() != null) {
          PersonNameType xmlName = perType.getPersonName();
          String firstName = (xmlName.getPersonGivenName() != null) ? xmlName.getPersonGivenName().getValue() : "";
          String middleName = (xmlName.getPersonMiddleName() != null) ? xmlName.getPersonMiddleName().getValue() : "";
          String lastName = (xmlName.getPersonSurName() != null) ? xmlName.getPersonSurName().getValue() : "";
          name = new Name(firstName, middleName, lastName);
        }
        for (IdentificationType idType : perType.getPersonOtherIdentification()) {
          efmId = idType.getIdentificationID().getValue();
        }
      } else if (entRep.getValue() instanceof OrganizationType orgType) {
        isOrg = true;
        IdentificationType idType = orgType.getOrganizationIdentification().getValue();
        if (idType instanceof OrganizationIdentificationType orgIdObj) {
          for (IdentificationType orgId : orgIdObj.getIdentification()) {
            if (((TextType) orgId.getIdentificationCategory().getValue()).getValue().equals("CASEPARTYID")
                && orgId.getIdentificationID() != null) {
              efmId = orgId.getIdentificationID().getValue();
              break;
            }
          }
          if (efmId.isBlank() && orgIdObj.getIdentificationID() != null) {
            efmId = orgIdObj.getIdentificationID().getValue();
          }
        } else {
          if (idType != null && idType.getIdentificationID() != null) {
            efmId = idType.getIdentificationID().getValue();
          }
        }
        if (orgType.getOrganizationName() != null) {
          name = new Name(orgType.getOrganizationName().getValue());
        }
      }
      if (efmId.isBlank()) {
        log.warn("Need Id for participants on existing case");
        return Optional.empty();
      }
      Person per = Person.FromEfm(name, new ContactInformation(""), 
          Optional.empty(), Optional.empty(), Optional.empty(), isOrg, role, UUID.fromString(efmId));
      existingParticipants.put(PartyId.Already(efmId), per);
    }
    return Optional.of(existingParticipants);
  }

  public static CaseQueryCriteriaType getCriteria() {
    CaseQueryCriteriaType crit = new CaseQueryCriteriaType();
    // TODO(brycew-later): should this be configurable?
    crit.setIncludeParticipantsIndicator(XmlHelper.convertBool(true));
    crit.setIncludeDocketEntryIndicator(XmlHelper.convertBool(false));
    crit.setIncludeCalendarEventIndicator(XmlHelper.convertBool(false));
    crit.setDocketEntryTypeCodeFilterText(XmlHelper.convertText("false"));
    crit.setCalendarEventTypeCodeFilterText(XmlHelper.convertText("false"));
    return crit;
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
      ComboCaseCodes comboCodes, 
      FilingInformation info,
      boolean isInitialFiling,
      boolean isFirstIndexedFiling,
      List<String> filingIds,
      // HACK(brycew): hacky: needed because "fees" querys and "service" put the payment stuff in the tyler Aug
      String queryType,
      JsonNode miscInfo, // TODO(brycew-later): if we get XML Answer files, this isn't generic
      EcfCourtSpecificSerializer serializer,
      InfoCollector collector,
      Map<String, Object> serviceContactToXmlObjs
  ) throws SQLException, FilingError {
    JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug =
        makeNiemCaseAug(courtLocation.code, info.getPreviousCaseId());
    JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug =
              makeTylerCaseAug(courtLocation, comboCodes,
                  info, isInitialFiling, isFirstIndexedFiling,
                  filingIds, queryType, miscInfo, serializer, collector, serviceContactToXmlObjs);
    if (comboCodes.cat.ecfcasetype.equals("CivilCase")) {
      Optional<BigDecimal> amountInControversy = Optional.empty();
      boolean anyAmountInControversy = comboCodes.filings.stream().anyMatch(f -> f.amountincontroversy.equalsIgnoreCase("Required"));
      if (anyAmountInControversy) {
        JsonNode jsonAmt = info.getMiscInfo().get("amount_in_controversy");
        if (jsonAmt != null && jsonAmt.isNumber()) {
          amountInControversy = Optional.of(jsonAmt.decimalValue());
        } else {
          collector.addRequired(collector.requestVar("amount_in_controversy", "ad danum amount", "currency"));
        }
      }
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase =
          makeCivilCaseType(caseAug, tylerAug, info.getCaseDocketNumber(), info.getPreviousCaseId(), amountInControversy);
      myCase.getValue().setCaseCategoryText(XmlHelper.convertText(comboCodes.cat.code));
      return myCase;
    } else if (comboCodes.cat.ecfcasetype.equals("DomesticCase")) {
      JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> myCase =
          makeDomesticCaseType(caseAug, tylerAug, info.getCaseDocketNumber(), info.getPreviousCaseId(), miscInfo);
      myCase.getValue().setCaseCategoryText(XmlHelper.convertText(comboCodes.cat.code));
      return myCase;
    } else {
      InterviewVariable var = collector.requestVar("tyler_case_category", "The " + comboCodes.cat.name 
          + " Case category requires an ECF case type that we don't support", "text");
      collector.addWrong(var);
      FilingError err = FilingError.wrongValue(var); 
      throw err;
    }
  }

  private static JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType>
      makeNiemCaseAug(String courtLocationId, Optional<String> trackingId) {
    var jof = new gov.niem.niem.domains.jxdm._4.ObjectFactory();
    var caseAug = jof.createCaseAugmentationType();
    caseAug.setCaseCourt(XmlHelper.convertCourtType(courtLocationId));
    trackingId.ifPresent(tracking -> {
      var coreObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
      var ct = coreObjFac.createCaseType();
      ct.setCaseTrackingID(XmlHelper.convertString(tracking));
      caseAug.getCaseLineageCase().add(ct);
    });
    return jof.createCaseAugmentation(caseAug);
  }

  private JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType>
      makeTylerCaseAug(
          CourtLocationInfo courtLocation,
          ComboCaseCodes comboCodes,
          FilingInformation info,
          boolean isInitialFiling,
          boolean isFirstIndexedFiling,
          List<String> filingIds,
          String queryType,
          JsonNode miscInfo,
          EcfCourtSpecificSerializer serializer,
          InfoCollector collector,
          Map<String, Object> serviceContactXmlObjs
  ) throws SQLException, FilingError {
    var tylerObjFac = new tyler.ecf.extensions.common.ObjectFactory();
    var ecfCommonObjFac = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    var of = new gov.niem.niem.niem_core._2.ObjectFactory();
    var structObjFac = new gov.niem.niem.structures._2.ObjectFactory();
    var ecfAug = tylerObjFac.createCaseAugmentationType();

    if (comboCodes.type.code.isEmpty()){
      log.warn("Type's code is empty?: " + comboCodes);
    } else {
      log.info("Setting case type text to " + comboCodes.type.toString());
      ecfAug.setCaseTypeText(XmlHelper.convertText(comboCodes.type.code));
    }

    DataFieldRow subTypeConfig = cd.getDataField(courtLocation.code, "CaseInformationCaseSubType");
    if (subTypeConfig.isvisible) {
      List<NameAndCode> subTypes = cd.getCaseSubtypesFor(courtLocation.code, comboCodes.type.code);
      Optional<NameAndCode> maybeSubtype = subTypes.stream()
          .filter(type -> type.getCode().equals(info.getCaseSubtypeCode()))
          .findFirst();

      if (maybeSubtype.isPresent()) {
        ecfAug.setCaseSubTypeText(XmlHelper.convertText(maybeSubtype.get().getCode()));
      } else if (subTypeConfig.isrequired) {
        InterviewVariable subTypeVar = collector.requestVar("tyler_case_subtype", "Sub type of the case", "choices",
            subTypes.stream().map(nac -> nac.getName()).collect(Collectors.toList()));
        collector.addWrong(subTypeVar);
      }
    }

    List<PartyType> partyTypes = cd.getPartyTypeFor(courtLocation.code, comboCodes.type.code);
    Set<String> requiredTypes = partyTypes.stream().filter(t -> t.isrequired).map(t -> t.code).collect(Collectors.toSet());
    Set<String> hereTypes = new HashSet<>();
    Map<String, Object> partyIdToRefObj = new HashMap<>();
    int i = 0;
    for (Person plaintiff : info.getNewPlaintiffs()) {
      collector.pushAttributeStack("plaintiffs[" + i + ']');
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(plaintiff, collector, partyTypes);
      collector.popAttributeStack();
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
      partyIdToRefObj.put(plaintiff.getIdString(), cp.getEntityRepresentation().getValue());
      hereTypes.add(plaintiff.getRole());
    }

    i = 0;
    for (Person defendant : info.getNewDefendants()) {
      collector.pushAttributeStack("defendants[" + i + ']');
      CaseParticipantType cp = serializer.serializeEcfCaseParticipant(defendant, collector, partyTypes);
      collector.popAttributeStack();
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
      partyIdToRefObj.put(defendant.getIdString(), cp.getEntityRepresentation().getValue());
      hereTypes.add(defendant.getRole());
    }
    
    // We need to make sure the initial filing handles all required parties: subsequents we can
    // assume the required parties are there
    if (isFirstIndexedFiling) {  
      requiredTypes.removeAll(hereTypes);
      if (!requiredTypes.isEmpty()) {
        FilingError err = FilingError.serverError("DEV ERROR: All required parties not covered by existing party types. ("
            + hereTypes + ". Missing " + requiredTypes);
        collector.error(err);
      }
    }

    int attorneyCount = 1;
    Map<String, PersonType> attorneyIdToXmlId = new HashMap<>();
    for (String attorneyId : info.getAttorneyIds()) {
      IdentificationType id = of.createIdentificationType();
      id.setIdentificationCategory(of.createIdentificationCategoryText(XmlHelper.convertText("ATTORNEYID")));
      id.setIdentificationID(XmlHelper.convertString(attorneyId));
      PersonType pt = ecfCommonObjFac.createPersonType();
      pt.getPersonOtherIdentification().add(id);
      String xmlId = "attorneyCount-" + Integer.toString(attorneyCount);
      pt.setId(xmlId);
      CaseParticipantType cp = ecfCommonObjFac.createCaseParticipantType();
      cp.setEntityRepresentation(ecfCommonObjFac.createEntityPerson(pt));
      // All attorneys have the role code of ATTY
      cp.setCaseParticipantRoleCode(XmlHelper.convertText("ATTY"));
      ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cp));
      attorneyIdToXmlId.put(attorneyId, pt);
      attorneyCount += 1;
    }

    DataFieldRow attRow = cd.getDataField(info.getCourtLocation(), "PartyAttorney");
    for (Map.Entry<PartyId, List<String>> partyAttys : info.getPartyAttorneyMap().entrySet()) {
      log.info("Setting Attorneys for : " + partyAttys.getKey());
      Object partyObj;
      if (!partyAttys.getKey().isInCurrentFiling()){
        if (partyAttys.getKey().id.contains(" ")) {
          FilingError err = FilingError.serverError("Party ID " + partyAttys.getKey().id + " should be a GUID but isn't");
          collector.error(err);
        }
        CaseParticipantType cpt = ecfCommonObjFac.createCaseParticipantType();
        IdentificationType id = of.createIdentificationType();
        id.setIdentificationCategory(of.createIdentificationCategoryText(XmlHelper.convertText("CASEPARTYID")));
        id.setIdentificationID(XmlHelper.convertString(partyAttys.getKey().id));
        if (comboCodes.partyInfo.get(partyAttys.getKey().id).getRight()) {
          OrganizationIdentificationType orgId = tylerObjFac.createOrganizationIdentificationType();
          orgId.getIdentification().add(id);
          OrganizationType ot = ecfCommonObjFac.createOrganizationType();
          ot.setOrganizationIdentification(tylerObjFac.createIdentification(id));
          ot.setId("id-" + partyAttys.getKey().id);
          cpt.setEntityRepresentation(ecfCommonObjFac.createEntityOrganization(ot));
          partyObj = ot;
        } else {
          PersonType pt = ecfCommonObjFac.createPersonType();
          pt.setId("id-" + partyAttys.getKey().id);
          pt.getPersonOtherIdentification().add(id);
          cpt.setEntityRepresentation(ecfCommonObjFac.createEntityPerson(pt));
          partyObj = pt;
        }
        cpt.setCaseParticipantRoleCode(XmlHelper.convertText(comboCodes.partyInfo.get(partyAttys.getKey().id).getLeft().code));
        ecfAug.getCaseParticipant().add(ecfCommonObjFac.createCaseParticipant(cpt));
      } else if (partyIdToRefObj.containsKey(partyAttys.getKey().id)) {
        partyObj = partyIdToRefObj.get(partyAttys.getKey().id);
      } else {
        log.warn("Can't handle current filing participant not already added?!");
        continue;
      }
      ReferenceType repdRef = structObjFac.createReferenceType();
      repdRef.setRef(partyObj);
      if (!attRow.isvisible) {
        continue;
      }
      if (partyAttys.getValue().isEmpty()) {
        // Is Self-Represented
        if (attRow.isrequired) {
          InterviewVariable var = collector.requestVar("party_to_attorney",
              "Attorneys are required for this court", "DADict");
          collector.addRequired(var);
        }
        CaseOfficialType t = ecfCommonObjFac.createCaseOfficialType();
        t.getCaseRepresentedPartyReference().add(repdRef);
        ReferenceType selfRepresentedRep = structObjFac.createReferenceType();
        selfRepresentedRep.setRef(partyObj);
        t.setRoleOfPersonReference(selfRepresentedRep);
        ecfAug.getCaseOtherEntityAttorney().add(t);
      } else {
        if (!courtLocation.allowmultipleattorneys && partyAttys.getValue().size() > 1) {
          FilingError err = FilingError.malformedInterview("Court " + info.getCourtLocation() + " doesn't allow multiple lawyers per case party.");
          collector.error(err);
        }
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

    List<CaseServiceContact> attachedContacts = info.getServiceContacts().stream().filter(c -> c.partyAssociated.isPresent()).collect(Collectors.toList());
    boolean anyServicePartyAttached = attachedContacts.size() > 0;
    ecfAug.setAttachServiceContactIndicator(XmlHelper.convertBool(anyServicePartyAttached));
    for (CaseServiceContact attachedContact : attachedContacts) {
      ServicePartyDataType ref = tylerObjFac.createServicePartyDataType();
      ReferenceType servRef = structObjFac.createReferenceType();
      servRef.setRef(serviceContactXmlObjs.get(attachedContact.refId));
      ref.setServiceReference(servRef);
      attachedContact.partyAssociated.ifPresent(partyId -> {
        ReferenceType partyRef = structObjFac.createReferenceType();
        partyRef.setRef(partyIdToRefObj.get(partyId));
        ref.setPartyReference(partyRef);
      });

      ecfAug.getExtendedData().add(tylerObjFac.createServicePartyReference(ref));
    }


    Optional<ProcedureRemedyType> res = makeProcedureRemedyType(isInitialFiling,
        comboCodes.cat, courtLocation.code, miscInfo, collector);

    Optional<ProcedureRemedyType> resPlus = addDamageAmountType(
        res, isInitialFiling, comboCodes.cat, courtLocation.code, miscInfo, collector);
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

    DataFieldRow filingcaseparties = cd.getDataField(courtLocation.code, "FilingEventCaseParties");
    var structOf = new gov.niem.niem.structures._2.ObjectFactory();
    if (filingcaseparties.isrequired) {
      for (String filingId : filingIds) {
        gov.niem.niem.structures._2.ReferenceType rt = structOf.createReferenceType();
        rt.setId(filingId);
        FilingAssociationType association = tylerObjFac.createFilingAssociationType();
        association.setPartyReference(rt);
        ecfAug.getFilingAssociation().add(association);
      }
    }

    if (queryType.equalsIgnoreCase("fees") || queryType.equalsIgnoreCase("service")) {
      if (info.getPaymentId() == null || info.getPaymentId().isBlank()) {
        collector.addRequired(collector.requestVar("tyler_payment_id", "The ID of the payment method", "text"));
      }
      ecfAug.setProviderCharge(PaymentFactory.makeProviderChargeType(info.getPaymentId()));
    }

    if (miscInfo.has("max_fee_amount") && courtLocation.allowmaxfeeamount) {
      AmountType amountType = new AmountType();
      amountType.setCurrencyCode(CurrencyCodeSimpleType.USD);
      if (miscInfo.get("max_fee_amount").isNumber()) {
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
    String procedureViewName = "CivilCaseProcedureView" + ((initial) ? "Initial" : "Subsequent");
    DataFieldRow procedureView = DataFieldRow.MissingDataField(procedureViewName);
    String procBehavior = (initial) ? cat.procedureremedyinitial : cat.procedureremedysubsequent;
    if (!procBehavior.isEmpty() && !procBehavior.equals("Not Available")) {
      procedureView = cd.getDataField(courtLocationId, procedureViewName);
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
    InterviewVariable docVar;
    if (damageAmounts.isEmpty()) {
      docVar = collector.requestVar("procedure_remedy", "Procedure Remedy", "text");
    } else {
      docVar = collector.requestVar("procedure_remedy", "Procedure Remedy", "choices",
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
          collector.addWrong(docVar);
        }
      } else {
        log.info("Dropping damage_amount " + jsonDmg.asText() + ", since isvisible is false for " + courtLocationId);
      }
    } else {
      if (damageConfig.isrequired) {
        collector.addRequired(docVar);
      } else {
        collector.addOptional(docVar);
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
  private static JAXBElement<CivilCaseType> makeCivilCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug,
      Optional<String> caseDocketId,
      Optional<String> caseTrackingId,
      Optional<BigDecimal> amountInControversy) {
    var ecfCivilObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory();
    var ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    CivilCaseType c = ecfCivilObjFac.createCivilCaseType();
    caseDocketId.ifPresent(docket -> {
      c.setCaseDocketID(XmlHelper.convertString(docket));
    });
    caseTrackingId.ifPresent(trackingId -> {
      c.setCaseTrackingID(XmlHelper.convertString(trackingId));
    });
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

  private static JAXBElement<DomesticCaseType> makeDomesticCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug,
      Optional<String> caseDocketId,
      Optional<String> caseTrackingId,
      JsonNode node) {
    var ecfDomesticObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory();
    var ecfCommonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    DomesticCaseType d = ecfDomesticObjFac.createDomesticCaseType();
    caseDocketId.ifPresent(docket -> {
      d.setCaseDocketID(XmlHelper.convertString(docket));
    });
    caseTrackingId.ifPresent(trackingId -> {
      d.setCaseTrackingID(XmlHelper.convertString(trackingId));
    });
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

  /*
  private JAXBElement<CriminalCaseType> makeCriminalCaseType(
      JAXBElement<gov.niem.niem.domains.jxdm._4.CaseAugmentationType> caseAug,
      JAXBElement<tyler.ecf.extensions.common.CaseAugmentationType> tylerAug) {
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
