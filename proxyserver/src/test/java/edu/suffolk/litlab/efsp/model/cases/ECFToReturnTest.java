package edu.suffolk.litlab.efsp.model.cases;

import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType;
import edu.suffolk.litlab.efsp.tyler.ecf4.TylerEcfToReturn;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.domains.Domain;

public class ECFToReturnTest {

  @Property
  @Domain(PersonExamples.class)
  boolean allNamesArentBlank(@ForAll PersonNameType pnt) {
    return !TylerEcfToReturn.toName(pnt).makeFullName().isBlank();
  }

  @Property
  @Domain(PersonExamples.class)
  boolean allTitlesArentBlank(@ForAll PersonNameType pnt) {
    return !TylerEcfToReturn.toName(pnt).makeTitleName().isBlank();
  }
}
