package edu.suffolk.assemblyline.efspserver.services;

import edu.suffolk.assemblyline.efspserver.Filing;
import edu.suffolk.assemblyline.efspserver.Person;
import edu.suffolk.assemblyline.efspserver.codes.CaseCategory;
import java.util.List;
import java.util.Optional;
import tyler.efm.services.schema.common.ErrorType;

public interface EfmFilingInterface {
  // TODO(brycew): needs a good algebraic error type instead of optional tbh
  public Optional<ErrorType> sendFiling(String courtLocationId, 
      List<Person> plaintiffs,
      List<Person> defendants,
      CaseCategory caseCategoryCode, String caseType, String caseSubtype, List<Filing> filings,
      String paymentId);
 
}
