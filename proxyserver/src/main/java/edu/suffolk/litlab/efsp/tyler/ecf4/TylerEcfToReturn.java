package edu.suffolk.litlab.efsp.tyler.ecf4;

import ecf4.latest.gov.niem.niem.niem_core._2.CaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import ecf4.latest.tyler.ecf.extensions.common.CaseAugmentationType;
import ecf4.latest.tyler.ecf.extensions.common.OrganizationIdentificationType;
import edu.suffolk.litlab.efsp.ecf4.EcfToReturn;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseAPI;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCodeType;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.cases.Attorney;
import edu.suffolk.litlab.efsp.model.cases.CaseResponse;
import edu.suffolk.litlab.efsp.model.cases.LegalPerson;
import edu.suffolk.litlab.efsp.model.cases.LegalPerson.PersonEnum;
import jakarta.xml.bind.JAXBElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import net.shibboleth.shared.primitive.LoggerFactory;
import org.slf4j.Logger;

/** A class for parsing ECF types into our internal model types */
public class TylerEcfToReturn implements EcfToReturn {
  public Logger log = LoggerFactory.getLogger(TylerEcfToReturn.class);

  public final CaseType theCase;
  public final CodeDatabaseAPI cd;

  public TylerEcfToReturn(CaseResponseMessageType resp, CodeDatabaseAPI cd) {
    this.theCase = resp.getCase().getValue();
    this.cd = cd;
  }

  public TylerEcfToReturn(CaseType theCase, CodeDatabaseAPI cd) {
    this.theCase = theCase;
    this.cd = cd;
  }

  public RuntimeException whenError() {
    return whenError("");
  }

  public RuntimeException whenError(String msg) {
    return new RuntimeException(
        "Can't collect all of the information needed from the case response: "
            + msg
            + ": "
            + theCase);
  }

  /** TODO: should replace EcfCaseTypeFactory.getCaseParticipants. */
  public static Name toName(PersonNameType pnt) {
    if (pnt == null) {
      return new Name("", "", "");
    }
    var givenName = "";
    if (pnt.getPersonGivenName() != null) {
      givenName = pnt.getPersonGivenName().getValue();
    }
    var middleName = "";
    if (pnt.getPersonMiddleName() != null) {
      middleName = pnt.getPersonMiddleName().getValue();
    }
    var surName = "";
    if (pnt.getPersonSurName() != null) {
      surName = pnt.getPersonSurName().getValue();
    }
    return new Name(givenName, middleName, surName);
  }

  public ContactInformation toContactInfo(PersonAugmentationType perAug) {
    // TODO(brycew): finish this function, lots of possible rabbit holes here.
    return new ContactInformation("");
  }

  public LegalPerson toPerson(CaseParticipantType partip) {
    String role = partip.getCaseParticipantRoleCode().getValue();
    var entRep = partip.getEntityRepresentation();
    PersonEnum perEnum = PersonEnum.INDIVIDUAL;
    String efmId = "";
    Name name = new Name("", "", "");
    ContactInformation contactInfo = new ContactInformation("");
    if (entRep.getValue() instanceof PersonType perType) {
      perEnum = PersonEnum.INDIVIDUAL;
      name = toName(perType.getPersonName());
      for (IdentificationType idType : perType.getPersonOtherIdentification()) {
        efmId = idType.getIdentificationID().getValue();
      }
      contactInfo = toContactInfo(perType.getPersonAugmentation());
    } else if (entRep.getValue() instanceof OrganizationType orgType) {
      perEnum = PersonEnum.BUSINESS;
      IdentificationType idType = orgType.getOrganizationIdentification().getValue();
      if (idType instanceof OrganizationIdentificationType orgIdObj) {
        for (IdentificationType orgId : orgIdObj.getIdentification()) {
          if (((TextType) orgId.getIdentificationCategory().getValue())
                  .getValue()
                  .equals("CASEPARTYID")
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
      // TODO: figure out where the org info actually is here.
      // contactInfo = toContactInfo(orgType.getRest());
    }
    log.info("efmId: {}", efmId);
    LegalPerson per =
        new LegalPerson(name, contactInfo, UUID.fromString(efmId.strip()), role, perEnum);
    return per;
  }

  private String getOtherId(List<IdentificationType> ids, String category) {
    for (var otherId : ids) {
      var idCat = otherId.getIdentificationCategory();
      if (idCat.getValue() instanceof TextType tt && extractText(tt).equalsIgnoreCase(category)) {
        return extractText(otherId.getIdentificationID());
      }
    }
    return "";
  }

  public Attorney toAttorney(Object entityRep, String barNumber) {
    if (entityRep instanceof PersonType personType) {
      var name = toName(personType.getPersonName());
      var attyId = getOtherId(personType.getPersonOtherIdentification(), "ATTORNEYID");
      return new Attorney(name, new ContactInformation(""), attyId, barNumber);
    }
    throw whenError("attorney " + barNumber + " is ill formed");
  }

  public static Optional<ecf4.latest.tyler.ecf.extensions.common.CaseAugmentationType>
      getCaseAugmentation(ecf4.latest.gov.niem.niem.niem_core._2.CaseType filedCase) {
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
      if (elem.getValue()
          instanceof ecf4.latest.tyler.ecf.extensions.common.CaseAugmentationType aug) {
        return Optional.of(aug);
      }
    }
    return Optional.empty();
  }

  public Participants getCaseParticipants(
      ecf4.latest.gov.niem.niem.niem_core._2.CaseType filedCase) {
    var existingParticipants = new HashMap<String, LegalPerson>();
    var idToAttorney = new HashMap<String, Attorney>();
    var perToAttorneys = new HashMap<String, List<String>>();
    var maybeAug = getCaseAugmentation(filedCase);
    if (maybeAug.isEmpty()) {
      return new Participants(Map.of(), Map.of(), Map.of());
    }
    var tylerAug = maybeAug.get();
    for (var attyEntity : tylerAug.getCaseOtherEntityAttorney()) {
      var barNumber =
          extractText(
              attyEntity
                  .getJudicialOfficialBarMembership()
                  .getJudicialOfficialBarIdentification()
                  .getIdentificationID());
      var atty = toAttorney(attyEntity.getRoleOfPersonReference().getRef(), barNumber);
      idToAttorney.put(atty.attorneyId(), atty);

      for (var partyRep : attyEntity.getCaseRepresentedPartyReference()) {
        var partyObj = partyRep.getRef();
        String partyId = "";
        if (partyObj instanceof PersonType pt) {
          partyId = getOtherId(pt.getPersonOtherIdentification(), "CASEPARTYID");
        } else if (partyObj instanceof OrganizationType ot) {
          var orgId =
              (OrganizationIdentificationType) ot.getOrganizationIdentification().getValue();
          partyId = getOtherId(orgId.getIdentification(), "CASEPARTYID");
        }
        if (perToAttorneys.containsKey(partyId)) {
          perToAttorneys.get(partyId).add(atty.attorneyId());
        } else {
          var newList = new ArrayList<String>();
          newList.add(atty.attorneyId());
          perToAttorneys.put(partyId, newList);
        }
      }
    }

    for (var jaxPart : maybeAug.get().getCaseParticipant()) {
      String role = jaxPart.getValue().getCaseParticipantRoleCode().getValue();
      if (role.equalsIgnoreCase("ATTY")) {
        // Ignore them, we already got them up above
        continue;
      } else {
        LegalPerson per = toPerson(jaxPart.getValue());
        existingParticipants.put(per.efmId().toString(), per);
      }
    }
    return new Participants(existingParticipants, idToAttorney, perToAttorneys);
  }

  private String extractText(TextType text) {
    if (text == null || text.getValue() == null) {
      return "";
    } else {
      return text.getValue();
    }
  }

  private String extractText(ecf4.latest.gov.niem.niem.proxy.xsd._2.String text) {
    if (text == null || text.getValue() == null) {
      return "";
    } else {
      return text.getValue();
    }
  }

  private boolean extractBool(ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean theBool) {
    if (theBool == null) {
      return false;
    } else {
      return theBool.isValue();
    }
  }

  private NameAndCode getCaseCategory(CaseType caseObj, String courtCode) {
    var code = extractText(caseObj.getCaseCategoryText());
    if (code == null || code.isBlank()) {
      throw this.whenError();
    }
    var maybeCode =
        cd.getCaseCategoryNames(courtCode).stream()
            .filter(nac -> nac.getCode().equals(code))
            .findFirst();
    return maybeCode.orElse(new NameAndCodeType("(category name not found)", code));
  }

  private NameAndCode getCaseType(
      CaseAugmentationType tylerAug, String courtCode, NameAndCode caseCategory) {
    var code = extractText(tylerAug.getCaseTypeText());
    if (code == null || code.isBlank()) {
      throw this.whenError();
    }
    var maybeCode =
        cd.getCaseTypeNamesFor(courtCode, caseCategory.code(), Optional.empty()).stream()
            .filter(nac -> nac.getCode().equals(code))
            .findFirst();
    return maybeCode.orElse(new NameAndCodeType("(case type name not found)", code));
  }

  private LocalDateTime getDateTime(JAXBElement<? extends Object> dateRep) {
    if (dateRep != null
        && dateRep.getValue() instanceof ecf4.latest.gov.niem.niem.niem_core._2.DateType date) {
      var dateRep2 = date.getDateRepresentation().getValue();
      if (dateRep2 instanceof ecf4.latest.gov.niem.niem.proxy.xsd._2.DateTime datetime) {
        var greg = datetime.getValue();
        return LocalDateTime.of(
            greg.getYear(),
            greg.getMonth(),
            greg.getDay(),
            greg.getHour(),
            greg.getMinute(),
            greg.getSecond());
      } else if (dateRep2 instanceof ecf4.latest.gov.niem.niem.proxy.xsd._2.Date dateProx) {
        var greg = dateProx.getValue();
        return LocalDateTime.of(
            LocalDate.of(greg.getYear(), greg.getMonth(), greg.getDay()), LocalTime.MIDNIGHT);
      }
    }
    // TODO: re-evaluate if this is the right default / fallback.
    return LocalDateTime.now();
  }

  @Override
  public Participants getCaseParticipants() {
    return getCaseParticipants(theCase);
  }

  @Override
  public CaseResponse toCase() {
    // TODO: catch all NPEs?
    CaseType caseObj = theCase;
    var maybeJAug = EcfCaseTypeFactory.getJCaseAugmentation(caseObj);
    var jCaseAug = maybeJAug.orElseThrow(this::whenError);
    var courtCode =
        jCaseAug
            .getCaseCourt()
            .getOrganizationIdentification()
            .getValue()
            .getIdentificationID()
            .getValue();
    var lineage =
        jCaseAug.getCaseLineageCase().stream()
            .map(oldCase -> extractText(oldCase.getCaseTrackingID()))
            .toList();
    Optional<CaseAugmentationType> maybeTyler = EcfCaseTypeFactory.getCaseAugmentation(caseObj);
    var tylerAug = maybeTyler.orElseThrow(this::whenError);
    var hasUserFiledIntoCase = extractBool(tylerAug.getHasUserFiledIntoCaseIndicator());
    var partips = getCaseParticipants(caseObj);
    NameAndCode caseCategory = getCaseCategory(caseObj, courtCode);
    NameAndCode caseType = getCaseType(tylerAug, courtCode, caseCategory);
    String caseTitle = extractText(caseObj.getCaseTitleText());
    String docketId = extractText(caseObj.getCaseDocketID());
    String trackingId = extractText(caseObj.getCaseTrackingID());
    LocalDateTime filedDate = getDateTime(caseObj.getActivityDateRepresentation());
    var caseResp =
        new CaseResponse(
            partips.getPeople(),
            Map.of(), // / Attorneys
            caseCategory,
            caseType,
            caseTitle,
            filedDate,
            docketId,
            trackingId,
            courtCode,
            lineage,
            hasUserFiledIntoCase);
    return caseResp;
  }
}
