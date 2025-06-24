package edu.suffolk.litlab.efsp.server.ecf4;

import static edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper.convertBool;
import static edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper.convertDateTime;
import static edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper.convertId;
import static edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper.convertNormalized;
import static edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper.convertString;
import static edu.suffolk.litlab.efsp.server.utils.Ecfv5XmlHelper.convertText;
import static edu.suffolk.litlab.efsp.utils.JsonHelpers.isNull;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.Result;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.CaseAugmentationType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.CaseOfficialType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.CourtEventType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.AmountType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.CaseType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DateType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.EntityType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.PersonType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Decimal;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseOfficialAugmentationType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventAugmentationType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.OrganizationAugmentationType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAugmentationType;
import ecf4.latest.tyler.ecf.v5_0.extensions.common.FilingAttorneyEntityType;
import ecf4.latest.tyler.ecf.v5_0.extensions.common.FilingPartyEntityType;
import ecf4.latest.tyler.ecf.v5_0.extensions.common.FilingReferenceType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.ComboCaseCodes;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;
import edu.suffolk.litlab.efsp.model.FilingDoc;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ecfv5CaseTypeFactory {
  private static Logger log = LoggerFactory.getLogger(Ecfv5CaseTypeFactory.class);

  private final ecf4.latest.gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac;
  private final ecf4.latest.tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac;
  private final ecf4.latest.gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxObjFac;
  private final ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory
      oasisObjFac;
  private final ecf4.latest.gov.niem.release.niem.proxy.xsd._4.ObjectFactory proxyObjFac;
  private final ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil
          .ObjectFactory
      oasisCivilObjFac;

  public Ecfv5CaseTypeFactory() {
    this.niemObjFac = new ecf4.latest.gov.niem.release.niem.niem_core._4.ObjectFactory();
    this.tylerObjFac = new ecf4.latest.tyler.ecf.v5_0.extensions.common.ObjectFactory();
    this.proxyObjFac = new ecf4.latest.gov.niem.release.niem.proxy.xsd._4.ObjectFactory();
    this.oasisObjFac =
        new ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory();
    this.jxObjFac = new ecf4.latest.gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
    this.oasisCivilObjFac =
        new ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil
            .ObjectFactory();
  }

  public Result<CaseType, FilingError> createCaseType(
      FilingInformation info,
      ComboCaseCodes allCodes,
      CodeDatabase cd,
      EcfCourtSpecificSerializer serializer,
      InfoCollector collector,
      Optional<Map<PartyId, Person>> existingParties) {
    Optional<BigDecimal> maybeAmt = Optional.empty();
    if (allCodes.filings.stream()
        .anyMatch(f -> f.amountincontroversy.equalsIgnoreCase("Required"))) {
      log.info(info.getMiscInfo().toPrettyString());
      JsonNode jsonAmt = info.getMiscInfo().get("amount_in_controversy");
      if (isNull(jsonAmt) || !jsonAmt.isNumber()) {
        return Result.err(FilingError.malformedInterview("Amount in controversy required"));
      }
      maybeAmt = Optional.of(jsonAmt.decimalValue());
    }

    CaseType ct = niemObjFac.createCaseType();

    info.getPreviousCaseId().ifPresent(id -> ct.setCaseTrackingID(convertString(id)));

    // TODO(#47): Time Zones
    DateType currentDate = convertDateTime(Instant.now(), 1);
    CourtEventType event = jxObjFac.createCourtEventType();
    int i = 0;
    for (FilingDoc doc : info.getFilings()) {
      CourtEventAugmentationType e = oasisObjFac.createCourtEventAugmentationType();
      e.setCourtEventEnteredOnDocketDate(currentDate);
      e.setCourtEventTypeCode(convertText(allCodes.filings.get(i).code));
      doc.getMotionType()
          .ifPresentOrElse(
              mot -> {
                e.setCourtLocationCode(tylerObjFac.createMotionTypeCode(convertText(mot)));
              },
              () -> {
                e.setCourtLocationCode(tylerObjFac.createMotionTypeCode(convertText("")));
              });
      event.getCourtEventAugmentationPoint().add(oasisObjFac.createCourtEventAugmentation(e));
      i++;
    }

    var ecfAug = oasisObjFac.createCaseAugmentationType();
    ecfAug.getRest().add(oasisObjFac.createCaseCategoryCode(convertText(allCodes.cat.code)));
    ecfAug.getRest().add(oasisObjFac.createCaseTypeCode(convertNormalized(allCodes.type.code)));

    // TODO(brycew-later): write ecfv5 versions of this. Right now, don't have time to reimplement
    // everything, so checking with old ecfv4 code and building here
    List<PartyType> partyTypes = cd.getPartyTypeFor(info.getCourtLocation(), allCodes.type.code);
    Map<PartyId, EntityType> idToCaseParty = new HashMap<PartyId, EntityType>();

    try {
      i = 0;
      for (Person per : info.getNewPlaintiffs()) {
        collector.pushAttributeStack("plaintiffs[" + i + ']');
        EntityType ent = serializeCaseParticipant(per, info, collector, partyTypes, idToCaseParty);
        collector.popAttributeStack();
        ecfAug.getRest().add(oasisObjFac.createCaseParty(ent));
        i++;
      }
      i = 0;
      for (Person per : info.getNewDefendants()) {
        collector.pushAttributeStack("defendants[" + i + ']');
        EntityType ent = serializeCaseParticipant(per, info, collector, partyTypes, idToCaseParty);
        collector.popAttributeStack();
        ecfAug.getRest().add(oasisObjFac.createCaseParty(ent));
        i++;
      }
      for (Map.Entry<PartyId, List<String>> partyAndAtt : info.getPartyAttorneyMap().entrySet()) {
        if (!partyAndAtt.getValue().isEmpty() && partyAndAtt.getKey().isAlreadyInCase()) {
          if (existingParties.isEmpty()) {
            collector.error(
                FilingError.serverError(
                    "PartyAttorney maps references parties not in "
                        + "current filing, but we don't have that datastructure."));
          }
          if (!existingParties.get().containsKey(partyAndAtt.getKey())) {
            collector.addWrong(
                collector.requestVar(
                    "party_to_attorneys",
                    "Can't find the existing party ID in the existing parties",
                    "text",
                    List.of(),
                    Optional.of(partyAndAtt.getKey().toString())));
          }
          EntityType ent =
              serializeExistingParticipant(
                  partyAndAtt.getKey().getIdString(),
                  existingParties.get().get(partyAndAtt.getKey()));
          idToCaseParty.put(partyAndAtt.getKey(), ent);
          ecfAug.getRest().add(oasisObjFac.createCaseParty(ent));
        }
      }
    } catch (FilingError err) {
      return Result.err(err);
    }

    CaseAugmentationType jAug = jxObjFac.createCaseAugmentationType();
    jAug.getCaseCourtEvent().add(event);
    i = 1;
    for (String attorneyId : info.getAttorneyIds()) {
      List<PartyId> partiesRepresented = info.getPartyRepByAttorney(attorneyId);
      if (partiesRepresented.isEmpty()) {
        return Result.err(
            FilingError.malformedInterview(
                "Attorney " + attorneyId + " doesn't represent any parties"));
      }
      CaseOfficialType cot = jxObjFac.createCaseOfficialType();
      PersonType per = niemObjFac.createPersonType();
      per.setId("Attorney" + i);
      IdentificationType idTy = niemObjFac.createIdentificationType();
      idTy.setIdentificationID(convertString(attorneyId));
      idTy.setIdentificationSourceText(convertText("ATTORNEYID"));
      per.getPersonOtherIdentification().add(idTy);
      cot.setRoleOfPerson(per);
      CaseOfficialAugmentationType caseOffAug = oasisObjFac.createCaseOfficialAugmentationType();
      for (PartyId id : partiesRepresented) {
        if (idToCaseParty.containsKey(id)) {
          EntityType representedEnt = niemObjFac.createEntityType();
          representedEnt.setRef(idToCaseParty.get(id));
          caseOffAug.getCaseRepresentedParty().add(representedEnt);
        } else {
          log.warn(
              "Attorney " + attorneyId + " represents party " + id + ", but party doesn't exist?");
        }
      }
      cot.getCaseOfficialAugmentationPoint()
          .add(oasisObjFac.createCaseOfficialAugmentation(caseOffAug));
      jAug.getCaseOfficial().add(cot);
      i++;
    }
    ct.getCaseAugmentationPoint().add(jxObjFac.createCaseAugmentation(jAug));

    ct.getCaseAugmentationPoint().add(oasisObjFac.createCaseAugmentation(ecfAug));
    var oasisAug = oasisCivilObjFac.createCaseAugmentationType();
    if (maybeAmt.isPresent()) {
      Decimal d = proxyObjFac.createDecimal();
      d.setValue(maybeAmt.get());
      AmountType at = niemObjFac.createAmountType();
      at.setAmount(d);
      oasisAug.setAmountInControversy(at);
    }
    oasisAug.setJuryDemandIndicator(convertBool(false));
    ct.getCaseAugmentationPoint().add(oasisCivilObjFac.createCaseAugmentation(oasisAug));

    var tylerAug = tylerObjFac.createCaseAugmentationType();
    // HACK(brycew): ECF allows multiple filers for an envelope, but this stupid Tyler call only
    // takes a single Party Id.
    List<PartyId> partyIds = info.getFilers();
    Optional<PartyId> firstFiler =
        (partyIds.isEmpty()) ? Optional.empty() : Optional.of(partyIds.get(0));
    firstFiler.ifPresent(
        fil -> {
          FilingPartyEntityType fpet = tylerObjFac.createFilingPartyEntityType();
          if (fil.isNewInCurrentFiling()) {
            FilingReferenceType frt = tylerObjFac.createFilingReferenceType();
            frt.setRef(idToCaseParty.get(fil));
            fpet.setPartyReference(frt);
          } else {
            fpet.setPartyIdentification(convertId(fil.getIdentificationString()));
          }
          tylerAug.setFilingParty(fpet);
        });

    Optional<String> filingAttorneyId = info.getFilings().get(0).getFilingAttorney();
    if (filingAttorneyId.isPresent()) {
      FilingAttorneyEntityType attorneyEnt = tylerObjFac.createFilingAttorneyEntityType();
      attorneyEnt.setAttorneyIdentification(convertId(filingAttorneyId.get()));
      tylerAug.setFilingAttorney(attorneyEnt);
    }

    try {
      Map<String, String> crossReferences =
          serializer.getCrossRefIds(info.getMiscInfo(), collector, allCodes.type.code);
      for (Map.Entry<String, String> refs : crossReferences.entrySet()) {
        IdentificationType idType = niemObjFac.createIdentificationType();
        idType.setIdentificationID(convertString(refs.getValue()));
        idType.setIdentificationSourceText(convertText(refs.getKey()));
        tylerAug.getCrossReferenceNumber().add(idType);
      }
    } catch (FilingError err) {
      return Result.err(err);
    }
    ct.getCaseAugmentationPoint().add(tylerObjFac.createCaseAugmentation(tylerAug));

    return Result.ok(ct);
  }

  /** id should start with a letter and not contain spaces. */
  private EntityType serializeExistingParticipant(String id, Person existingParty) {
    EntityType ent = niemObjFac.createEntityType();
    ent.setId(id);
    if (existingParty.isOrg()) {
      OrganizationType orgType = niemObjFac.createOrganizationType();
      orgType.setOrganizationIdentification(convertId(id, "PARTYID"));
      ent.setEntityRepresentation(niemObjFac.createOrganization(orgType));
    } else {
      PersonType perType = niemObjFac.createPersonType();
      perType.getPersonOtherIdentification().add(convertId(id, "PARTYID"));
      ent.setEntityRepresentation(niemObjFac.createEntityPerson(perType));
    }
    return ent;
  }

  private EntityType serializeCaseParticipant(
      Person per,
      FilingInformation info,
      InfoCollector collector,
      List<PartyType> partyTypes,
      Map<PartyId, EntityType> idToCaseParty)
      throws FilingError {
    Optional<PartyType> matchingType =
        partyTypes.stream().filter(pt -> pt.code.equalsIgnoreCase(per.getRole())).findFirst();
    if (matchingType.isEmpty()) {
      List<String> partyTypeChoices =
          partyTypes.stream().map(p -> p.code).collect(Collectors.toList());
      InterviewVariable ptVar =
          collector.requestVar(
              "party_type",
              "Legal role of the party",
              "choices",
              partyTypeChoices,
              Optional.of(per.getRole()));
      collector.addWrong(ptVar);
    }
    EntityType ent = niemObjFac.createEntityType();
    ent.setId(per.getIdString());

    PartyId key = per.getPartyId();
    if (per.isOrg()) {
      OrganizationType orgType = niemObjFac.createOrganizationType();
      OrganizationAugmentationType orgAug = oasisObjFac.createOrganizationAugmentationType();
      orgAug.getCaseParticipantRoleCode().add(convertText(matchingType.get().code));
      if (!info.getPartyAttorneyMap().containsKey(key)
          || info.getPartyAttorneyMap().get(key).isEmpty()) {
        orgAug.setParticipantID(convertId("SRL"));
      } else {
        orgAug.setParticipantID(null);
      }
      orgType
          .getOrganizationAugmentationPoint()
          .add(oasisObjFac.createOrganizationAugmentation(orgAug));
      ent.setEntityRepresentation(niemObjFac.createEntityOrganization(orgType));
    } else {
      PersonType perType = niemObjFac.createPersonType();
      PersonAugmentationType pat = oasisObjFac.createPersonAugmentationType();
      pat.getCaseParticipantRoleCode().add(convertText(matchingType.get().code));
      if (!info.getPartyAttorneyMap().containsKey(key)
          || info.getPartyAttorneyMap().get(key).isEmpty()) {
        pat.setParticipantID(convertId("SRL"));
      } else {
        pat.setParticipantID(null);
      }
      perType.getPersonAugmentationPoint().add(oasisObjFac.createPersonAugmentation(pat));
      ent.setEntityRepresentation(niemObjFac.createEntityPerson(perType));
    }
    idToCaseParty.put(key, ent);
    return ent;
  }
}
