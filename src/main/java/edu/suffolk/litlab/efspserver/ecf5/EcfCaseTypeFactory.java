package edu.suffolk.litlab.efspserver.ecf5;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.LowerCourtInfo;
import edu.suffolk.litlab.efspserver.PartyId;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.tyler.TylerCodesSerializer;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.ComboCaseCodes;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.PartyType;
import gov.niem.release.niem.domains.jxdm._6.CaseOfficialType;
import gov.niem.release.niem.niem_core._4.CaseType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.OrganizationType;
import gov.niem.release.niem.niem_core._4.PersonType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.OrganizationAugmentationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAugmentationType;
import jakarta.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.v5_0.extensions.common.FilingAttorneyEntityType;
import tyler.ecf.v5_0.extensions.common.FilingMessageAugmentationType;

public class EcfCaseTypeFactory {
  private static Logger log = LoggerFactory.getLogger(EcfCaseTypeFactory.class);

  private static final gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxdmObjFac =
      new gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
  private static final gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac =
      new gov.niem.release.niem.niem_core._4.ObjectFactory();
  private static final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac =
      new tyler.ecf.v5_0.extensions.common.ObjectFactory();
  private static final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory
      ecfObjFac = new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory();

  private final CodeDatabase cd;

  public EcfCaseTypeFactory(CodeDatabase cd, String jurisdiction) {
    this.cd = cd;
  }

  public static Optional<
          https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType>
      getEcfCaseAugmentation(CaseType caseType) {
    for (var casePoint : caseType.getCaseAugmentationPoint()) {
      if (casePoint.getValue()
          instanceof
          https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType
          ecfType) {
        return Optional.of(ecfType);
      }
    }
    return Optional.empty();
  }

  public static Optional<tyler.ecf.v5_0.extensions.common.CaseAugmentationType>
      getTylerCaseAugmentation(CaseType caseType) {
    for (var casePoint : caseType.getCaseAugmentationPoint()) {
      if (casePoint.getValue()
          instanceof tyler.ecf.v5_0.extensions.common.CaseAugmentationType tylerType) {
        return Optional.of(tylerType);
      }
    }
    return Optional.empty();
  }

  /**
   * Makes a case from specific info + unorganized JSON dumps.
   *
   * @param courtLocation the court's name a unique string. ex: 'adams'
   * @param comboCodes contains the case category, the case type code, and the case subtype code (if
   *     present)
   * @param info The full information about the filing
   * @param isInitialFiling
   * @param isFirstIndexedFiling
   * @param miscInfo
   * @param serializer
   * @param collector
   * @return two objects: the actual case object, and a map from party ID to the object inside the
   *     case, used to associate other elements to the party element later on.
   * @throws FilingError
   * @throws SQLException
   */
  public Pair<gov.niem.release.niem.niem_core._4.CaseType, XmlMaps> makeCaseTypeFromTylerCategory(
      CourtLocationInfo courtLocation,
      ComboCaseCodes comboCodes,
      FilingInformation info,
      boolean isInitialFiling,
      boolean isFirstIndexedFiling,
      JsonNode miscInfo, // TODO(brycew-later): if we get XML Answer files, this isn't generic
      EcfCourtSpecificSerializer serializer,
      TylerCodesSerializer tylerSerializer,
      InfoCollector collector)
      throws SQLException, FilingError {
    var myCaseType = niemObjFac.createCaseType();
    var pair =
        makeEcfCaseAug(
            info,
            isInitialFiling,
            isFirstIndexedFiling,
            comboCodes,
            collector,
            serializer,
            tylerSerializer,
            courtLocation);
    var ecfAug = pair.getLeft();
    var partyIdToRefObj = pair.getRight();
    var pair2 =
        makeJxdmCaseAug(courtLocation.code, info, tylerSerializer, partyIdToRefObj, collector);
    var jxdmAug = pair2.getLeft();
    var attorneyIdToRefObj = pair.getRight();

    // JXDM apparently needs to be first, according to Tyler
    myCaseType.getCaseAugmentationPoint().add(jxdmAug);
    myCaseType.getCaseAugmentationPoint().add(ecfAug);
    if (isInitialFiling) {
      myCaseType
          .getCaseAugmentationPoint()
          .add(makeSpecialAug(comboCodes, info, collector, miscInfo));
      myCaseType
          .getCaseAugmentationPoint()
          .add(makeTylerCaseAug(tylerSerializer, info, collector, comboCodes));
    }
    var xmlMaps = new XmlMaps(partyIdToRefObj, attorneyIdToRefObj);
    return Pair.of(myCaseType, xmlMaps);
  }

  private JAXBElement<? extends Object> makeSpecialAug(
      ComboCaseCodes comboCodes, FilingInformation info, InfoCollector collector, JsonNode miscInfo)
      throws FilingError {
    if (comboCodes.cat.ecfcasetype.equals("CivilCase")) {
      Optional<BigDecimal> amountInControversy = Optional.empty();
      boolean anyAmountInControversy =
          comboCodes.filings.stream()
              .anyMatch(f -> f.amountincontroversy.equalsIgnoreCase("Required"));
      if (anyAmountInControversy) {
        JsonNode jsonAmt = info.getMiscInfo().get("amount_in_controversy");
        if (jsonAmt != null && jsonAmt.isNumber()) {
          amountInControversy = Optional.of(jsonAmt.decimalValue());
        } else {
          collector.addRequired(
              collector.requestVar("amount_in_controversy", "ad danum amount", "currency"));
        }
      }
      return makeCivilCaseAug(amountInControversy);
    } else if (comboCodes.cat.ecfcasetype.equals("DomesticCase")) {
      return makeDomesticCaseAug();
    } else if (comboCodes.cat.ecfcasetype.equals("AppellateCase")) {
      if (info.getLowerCourtInfo().isEmpty()) {
        collector.error(
            FilingError.malformedInterview(
                "AppellateCase included, but no lower court info given"));
      }
      return makeAppellateCaseAug(
          info.getLowerCourtInfo().orElse(new LowerCourtInfo("", "", "", "")));
    } else if (comboCodes.cat.ecfcasetype.equals("BankruptcyCase")
        || comboCodes.cat.ecfcasetype.equals("CitationCase")
        || comboCodes.cat.ecfcasetype.equals("JuvenileCase")
        || comboCodes.cat.ecfcasetype.equals("CriminalCase")) {
      // TODO(brycew): handle these
      InterviewVariable var =
          collector.requestVar(
              "efile_case_category",
              "The "
                  + comboCodes.cat.name
                  + " Case category requires an ECF case type that we know about but don't yet"
                  + " support ("
                  + comboCodes.cat.ecfcasetype
                  + ")",
              "text");
      collector.addWrong(var);
      FilingError err = FilingError.wrongValue(var);
      throw err;
    } else {
      InterviewVariable var =
          collector.requestVar(
              "efile_case_category",
              "The "
                  + comboCodes.cat.name
                  + " Case category requires an ECF case type that we don't know about or support ("
                  + comboCodes.cat.ecfcasetype
                  + ")",
              "text");
      collector.addWrong(var);
      FilingError err = FilingError.wrongValue(var);
      throw err;
    }
  }

  private JAXBElement<
          ? extends
              https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.CaseAugmentationType>
      makeCivilCaseAug(Optional<BigDecimal> amountInControversy) {
    var civObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory();
    var civAug = civObjFac.createCaseAugmentationType();
    amountInControversy.ifPresent(
        amt -> {
          civAug.setAmountInControversy(Ecf5Helper.convertAmount(amt));
        });
    civAug.getReliefTypeCode().add(niemObjFac.createTextType());
    // Passing null to things gives you <CausoOfActionCode/>, blank strings give
    // <CauseOfActionCode></CauseOfActionCode>
    civAug.setCauseOfActionCode(Ecf5Helper.convertText(null));
    return civObjFac.createCaseAugmentation(civAug);
  }

  private JAXBElement<
          ? extends
              https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic.CaseAugmentationType>
      makeDomesticCaseAug() {
    // TODO(brycew): no examples, gonna pause this one for now
    return null;
  }

  private JAXBElement<
          ? extends
              https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate.CaseAugmentationType>
      makeAppellateCaseAug(LowerCourtInfo lowerCourt) {
    var applObjFac =
        new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate.ObjectFactory();
    var aug = applObjFac.createCaseAugmentationType();
    var applCase = jxdmObjFac.createAppellateCaseType();
    var jAug = jxdmObjFac.createCaseAugmentationType();
    jAug.setCaseCourt(Ecf5Helper.convertCourt(lowerCourt.lowerCourtCode));
    var ecfAug = ecfObjFac.createCaseAugmentationType();
    ecfAug
        .getRest()
        .add(jxdmObjFac.createCaseNumberText(Ecf5Helper.convertText(lowerCourt.caseDocketId)));
    var niemCase = niemObjFac.createCaseType();
    niemCase.getCaseAugmentationPoint().add(ecfObjFac.createCaseAugmentation(ecfAug));
    jAug.getCaseLineageCase().add(niemCase);
    applCase.getCaseAugmentationPoint().add(jxdmObjFac.createCaseAugmentation(jAug));
    var origCase = niemObjFac.createCaseType();
    origCase.setCaseTitleText(Ecf5Helper.convertText(lowerCourt.caseTitleText));
    var origAug = jxdmObjFac.createCaseAugmentationType();
    var official = jxdmObjFac.createCaseOfficialType();
    var officialPerson = niemObjFac.createPersonType();
    var personNameText = niemObjFac.createPersonNameTextType();
    personNameText.setValue(lowerCourt.lowerCourtJudgeName);
    var personName = niemObjFac.createPersonNameType();
    personName.setPersonFullName(personNameText);
    officialPerson.setPersonName(personName);
    official.setRoleOfPerson(officialPerson);
    origAug.getCaseJudge().add(official);
    origCase.getCaseAugmentationPoint().add(jxdmObjFac.createCaseAugmentation(origAug));
    applCase.getAppellateCaseOriginalCase().add(origCase);
    aug.setAppellateCase(applCase);
    return applObjFac.createCaseAugmentation(aug);
  }

  private Pair<
          JAXBElement<
              https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType>,
          Map<String, Object>>
      makeEcfCaseAug(
          FilingInformation info,
          boolean isInitialFiling,
          boolean isFirstIndexedFiling,
          ComboCaseCodes comboCodes,
          InfoCollector collector,
          EcfCourtSpecificSerializer serializer,
          TylerCodesSerializer tylerSerializer,
          CourtLocationInfo courtLocation)
          throws FilingError {
    var ecfAug = ecfObjFac.createCaseAugmentationType();
    var cat = ecfObjFac.createCaseCategoryCode(Ecf5Helper.convertText(comboCodes.cat.code));
    var newInd = ecfObjFac.createCaseNewIndicator(Ecf5Helper.convertBool(isInitialFiling));
    var type =
        ecfObjFac.createCaseTypeCode(Ecf5Helper.convertNormalizedString(comboCodes.type.code));
    Optional<JAXBElement<IdentificationType>> maybeCaseId =
        info.getPreviousCaseId()
            .map(id -> ecfObjFac.createCaseTrackingID(Ecf5Helper.convertId(id)));
    // expected jxdm:CaseNumberText
    // niem:
    // Metadata,
    // organizationassociation
    // personassociation
    // personorganizationassociation
    List<PartyType> partyTypes = cd.getPartyTypeFor(courtLocation.code, comboCodes.type.code);
    Set<String> presentPartyTypes = new HashSet<>();
    Map<String, Object> partyIdToRefObj = new HashMap<>();

    List<JAXBElement<EntityType>> parties = new ArrayList<>();
    int i = 0;
    for (Person plaintiff : info.getNewPlaintiffs()) {
      collector.pushAttributeStack("plaintiffs[" + i + "]");
      var partip = serializer.createFullEcfCaseParticipant(plaintiff, collector, partyTypes);
      parties.add(partip);
      collector.popAttributeStack();
      partyIdToRefObj.put(
          plaintiff.getIdString(), partip.getValue().getEntityRepresentation().getValue());
      presentPartyTypes.add(plaintiff.getRole());
    }

    i = 0;
    for (Person defendant : info.getNewDefendants()) {
      collector.pushAttributeStack("plaintiffs[" + i + "]");
      var partip = serializer.createFullEcfCaseParticipant(defendant, collector, partyTypes);
      parties.add(partip);
      collector.popAttributeStack();
      partyIdToRefObj.put(
          defendant.getIdString(), partip.getValue().getEntityRepresentation().getValue());
      presentPartyTypes.add(defendant.getRole());
    }

    // We need to make sure the initial filing handles all required parties: subsequents we can
    // assume the required parties are there
    if (isFirstIndexedFiling) {
      tylerSerializer.vetRequiredPartyTypes(presentPartyTypes, partyTypes, collector);
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
      log.info("Referenced PartyId (" + partyId + ")");
      if (partyId.isAlreadyInCase()) {
        if (partyId.getIdentificationString().contains(" ")) {
          FilingError err =
              FilingError.serverError(
                  "Party ID " + partyId.getIdentificationString() + " should be a GUID but isn't");
          collector.error(err);
        }
        var efmId = Ecf5Helper.convertId(partyId.getIdentificationString());
        var pInfo = comboCodes.partyInfo.get(partyId.getIdentificationString());
        boolean isOrg = false;
        if (pInfo == null) {
          log.warn("PartyId (" + partyId + ") has null info in combocodes. Why? Assuming person");
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
          isOrg = pInfo.getRight();
        }
        var entity = niemObjFac.createEntityType();
        if (isOrg) {
          OrganizationType ot = niemObjFac.createOrganizationType();
          OrganizationAugmentationType oat = ecfObjFac.createOrganizationAugmentationType();
          oat.setParticipantID(efmId);
          ot.setId(partyId.getIdString());
          ot.getOrganizationAugmentationPoint().add(ecfObjFac.createOrganizationAugmentation(oat));
          entity.setEntityRepresentation(niemObjFac.createEntityOrganization(ot));
          partyIdToRefObj.put(partyId.getIdString(), ot);
        } else {
          PersonType pt = niemObjFac.createPersonType();
          PersonAugmentationType pat = ecfObjFac.createPersonAugmentationType();
          pat.setParticipantID(efmId);
          pt.setId(partyId.getIdString());
          pt.getPersonAugmentationPoint().add(ecfObjFac.createPersonAugmentation(pat));
          entity.setEntityRepresentation(niemObjFac.createEntityPerson(pt));
          partyIdToRefObj.put(partyId.getIdString(), pt);
        }
        // No role code needed in ECF 5!
        parties.add(ecfObjFac.createCaseParty(entity));
      }
    }

    // Need to put all of the REST things in order, otherwise it fails the schema validation.
    ecfAug.getRest().add(cat);
    ecfAug.getRest().add(newInd);
    for (var party : parties) {
      ecfAug.getRest().add(party);
    }
    maybeCaseId.ifPresent(tracking -> ecfAug.getRest().add(tracking));
    ecfAug.getRest().add(type);
    return Pair.of(ecfObjFac.createCaseAugmentation(ecfAug), partyIdToRefObj);
  }

  private static JAXBElement<? extends tyler.ecf.v5_0.extensions.common.CaseAugmentationType>
      makeTylerCaseAug(
          TylerCodesSerializer tylerSerializer,
          FilingInformation info,
          InfoCollector collector,
          ComboCaseCodes comboCodes)
          throws FilingError {
    var tylerAug = tylerObjFac.createCaseAugmentationType();
    var subType =
        tylerSerializer
            .vetSubType(info.getCaseSubtypeCode(), comboCodes.type.code, collector)
            .orElse("");
    tylerAug.setCaseSubTypeCode(Ecf5Helper.convertText(subType));
    // TODO(brycew): WillFiledDate
    // TODO(brycew): wtf is CaseAddress
    return tylerObjFac.createCaseAugmentation(tylerAug);
  }

  /**
   * @param courtLocationId
   * @param info
   * @param tylerSerializer
   * @param partyIdToRefObj
   * @param collector
   * @return The JXDM case aug, and the mapping from "id-" + attorney ID to the attorney's XML
   *     object.
   * @throws FilingError
   */
  private static Pair<
          JAXBElement<gov.niem.release.niem.domains.jxdm._6.CaseAugmentationType>,
          Map<String, Object>>
      makeJxdmCaseAug(
          String courtLocationId,
          FilingInformation info,
          TylerCodesSerializer tylerSerializer,
          Map<String, Object> partyIdToRefObj,
          InfoCollector collector)
          throws FilingError {
    var caseAug = jxdmObjFac.createCaseAugmentationType();
    caseAug.setCaseCourt(Ecf5Helper.convertCourt(courtLocationId));
    Map<String, Object> attorneys = new HashMap<>();
    tylerSerializer
        .vetPartyAttorneyMap(info.getPartyAttorneyMap(), partyIdToRefObj, collector)
        .ifPresent(
            pam -> {
              for (Map.Entry<PartyId, List<String>> partyAttys :
                  info.getPartyAttorneyMap().entrySet()) {
                for (String attyId : partyAttys.getValue()) {
                  CaseOfficialType t = jxdmObjFac.createCaseOfficialType();
                  PersonType pt = niemObjFac.createPersonType();
                  var pat = ecfObjFac.createPersonAugmentationType();
                  pat.setParticipantID(Ecf5Helper.convertId(attyId));
                  pt.getPersonAugmentationPoint().add(ecfObjFac.createPersonAugmentation(pat));
                  pt.setId("id-" + attyId);
                  attorneys.put("id-" + attyId, pt);
                  t.setRoleOfPerson(pt);
                  var officialAug = ecfObjFac.createCaseOfficialAugmentationType();
                  var entity = niemObjFac.createEntityType();
                  entity.setRef(partyIdToRefObj.get(partyAttys.getKey().getIdString()));
                  officialAug.getCaseRepresentedParty();
                  t.getCaseOfficialAugmentationPoint();
                  caseAug.getCaseOfficial().add(t);
                }
              }
            });
    caseAug.getCaseOfficial();
    return Pair.of(jxdmObjFac.createCaseAugmentation(caseAug), attorneys);
  }

  public boolean setFilingAttorney(
      FilingMessageAugmentationType filingMessageAug,
      FilingInformation info,
      TylerCodesSerializer tylerSerializer,
      InfoCollector collector,
      boolean isIndividual,
      XmlMaps xmlMaps)
      throws FilingError {
    var attys =
        info.getFilings().stream()
            .map(doc -> doc.getFilingAttorney())
            .filter(atty -> atty.isPresent())
            .map(atty -> atty.orElse(""))
            .distinct()
            .toList();
    if (attys.size() > 1) {
      log.warn(
          "Passed in multiple filing attorneys: in ECF5, there is only 1, envelope wide filing"
              + " attorney. Only the first one will be used.");
    }
    var maybeAtty = attys.stream().findFirst();
    var refType =
        tylerSerializer
            .vetFilingAttorney(maybeAtty, isIndividual, collector)
            .map(atty -> xmlMaps.attorneys.get("id-" + atty))
            .map(
                ref -> {
                  var tylerRefType = tylerObjFac.createReferenceType();
                  tylerRefType.setRef(ref);
                  return tylerRefType;
                })
            .orElse(null);
    FilingAttorneyEntityType filingAtty = tylerObjFac.createFilingAttorneyEntityType();
    filingAtty.setAttorneyReference(refType);
    filingMessageAug.setFilingAttorney(filingAtty);
    return true;
  }

  public boolean setFilingParty(
      FilingMessageAugmentationType filingMessageAug, FilingInformation info, XmlMaps xmlMaps)
      throws FilingError {
    var parties =
        info.getFilings().stream()
            .flatMap(doc -> doc.getFilingPartyIds().stream())
            .distinct()
            .toList();
    if (parties.size() > 1) {
      log.warn(
          "Passed in multiple filing parties: in ECF5, there is only 1, envelope wide filing"
              + " attorney. Only use one.");
    }
    parties.stream()
        .findFirst()
        .ifPresent(
            p -> {
              var entity = tylerObjFac.createFilingPartyEntityType();
              var refParty = tylerObjFac.createReferenceType();
              refParty.setRef(xmlMaps.parties.get(p.getIdString()));
              entity.setPartyReference(refParty);
              filingMessageAug.setFilingParty(entity);
            });
    return true;
  }
}
