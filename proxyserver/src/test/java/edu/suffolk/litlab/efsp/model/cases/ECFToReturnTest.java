package edu.suffolk.litlab.efsp.model.cases;

import gov.niem.niem.niem_core._2.PersonNameType;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.domains.Domain;

public class ECFToReturnTest {

  @Property
  @Domain(PersonNameExamples.class)
  boolean allNamesArentBlank(@ForAll PersonNameType pnt) {
    return !ECFToReturn.toName(pnt).getFullName().isBlank();
  }

  @Property
  @Domain(PersonNameExamples.class)
  boolean allTitlesArentBlank(@ForAll PersonNameType pnt) {
    return !ECFToReturn.toName(pnt).getTitleName().isBlank();
  }
}
