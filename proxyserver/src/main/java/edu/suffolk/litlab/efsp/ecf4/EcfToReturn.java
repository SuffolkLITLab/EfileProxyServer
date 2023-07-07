package edu.suffolk.litlab.efsp.ecf4;

import edu.suffolk.litlab.efsp.model.cases.Attorney;
import edu.suffolk.litlab.efsp.model.cases.CaseResponse;
import edu.suffolk.litlab.efsp.model.cases.LegalPerson;
import java.util.List;
import java.util.Map;

public interface EcfToReturn {
  public record Participants(
      Map<String, LegalPerson> idToPerson,
      Map<String, Attorney> idToAttorney,
      Map<String, List<String>> personIdToAttorneys) {
    public List<LegalPerson> getPeople() {
      return List.copyOf(idToPerson.values());
    }
  }

  public Participants getCaseParticipants();

  public CaseResponse toCase();
}
