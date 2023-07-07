package edu.suffolk.litlab.efsp.model.cases;

import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCaseTypeFactory;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.OrganizationType;
import gov.niem.niem.niem_core._2.PersonNameType;
import gov.niem.niem.niem_core._2.PersonType;
import java.util.Optional;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import tyler.ecf.extensions.common.CaseAugmentationType;

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

  public static Person toPerson(CaseResponseMessageType resp) {
    CaseType caseType = resp.getCase().getValue();
    Optional<CaseAugmentationType> caseAug = EcfCaseTypeFactory.getCaseAugmentation(caseType);
    CaseParticipantType t = caseAug.get().getCaseParticipant().get(0).getValue();
    Object o = t.getEntityRepresentation();
    if (o instanceof OrganizationType ot) {

    } else if (o instanceof PersonType pt) {
      PersonNameType pnt = pt.getPersonName();
    }

    return null;
  }

  // TODO: GetCaseResponseMessageType c;
}
