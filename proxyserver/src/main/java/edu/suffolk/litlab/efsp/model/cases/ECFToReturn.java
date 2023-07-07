package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCaseTypeFactory;
import jakarta.xml.bind.JAXBElement;
import ecf4.latest.gov.niem.niem.niem_core._2.CaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.OrganizationType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import ecf4.latest.tyler.ecf.extensions.common.CaseAugmentationType;
import ecf4.latest.tyler.ecf.extensions.common.OrganizationIdentificationType;

/** A class for parsing ECF types into our internal model types */
public class ECFToReturn {

  /** TODO: should replace EcfCaseTypeFactory.getCaseParticipants. */
  public static Name toName(PersonNameType pnt) {
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

  /** TODO(brycew): finish this function, lots of possible rabbit holes here. */
  public static Person toPerson(CaseParticipantType partip) {
    String role = partip.getCaseParticipantRoleCode().getValue();
    var entRep = partip.getEntityRepresentation();
    boolean isOrg = false;
      String efmId = "";
      Name name = new Name("", "", "");
      if (entRep.getValue() instanceof PersonType perType) {
        isOrg = false;
        if (perType.getPersonName() != null) {
          PersonNameType xmlName = perType.getPersonName();
          String firstName =
              (xmlName.getPersonGivenName() != null) ? xmlName.getPersonGivenName().getValue() : "";
          String middleName =
              (xmlName.getPersonMiddleName() != null)
                  ? xmlName.getPersonMiddleName().getValue()
                  : "";
          String lastName =
              (xmlName.getPersonSurName() != null) ? xmlName.getPersonSurName().getValue() : "";
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
      }
      Person per =
          Person.FromEfm(
              name,
              new ContactInformation(""),
              Optional.empty(),
              Optional.empty(),
              Optional.empty(),
              isOrg,
              role,
              UUID.fromString(efmId));
    return per;
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


  public static Optional<Map<PartyId, Person>> getCaseParticipants(
      ecf4.latest.gov.niem.niem.niem_core._2.CaseType filedCase) {
    var existingParticipants = new HashMap<PartyId, Person>();
    var maybeAug = getCaseAugmentation(filedCase);
    if (maybeAug.isEmpty()) {
      return Optional.empty();
    }

    for (var jaxPart : maybeAug.get().getCaseParticipant()) {
      String role = jaxPart.getValue().getCaseParticipantRoleCode().getValue();
      if (role.equalsIgnoreCase("ATTY")) {
        // TODO: parse attorneys
        continue;
      }
      Person per = toPerson(jaxPart.getValue());
      existingParticipants.put(PartyId.Already(per.getId().toString()), per);
    }
    return Optional.of(existingParticipants);
  }

  public static CaseResponse toCase(CaseResponseMessageType resp) {
    CaseType caseType = resp.getCase().getValue();
    Optional<CaseAugmentationType> caseAug = EcfCaseTypeFactory.getCaseAugmentation(caseType);
    var partips = getCaseParticipants(caseType);
    var caseResp = new CaseResponse();
    return caseResp;
  }

  // TODO: GetCaseResponseMessageType c;
}
