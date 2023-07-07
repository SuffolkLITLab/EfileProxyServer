package edu.suffolk.litlab.efsp.model.cases;

import ecf4.latest.gov.niem.niem.niem_core._2.AddressType;
import ecf4.latest.gov.niem.niem.niem_core._2.ContactInformationType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameTextType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Provide;
import net.jqwik.api.domains.DomainContextBase;

public class PersonExamples extends DomainContextBase {

  @Provide
  Arbitrary<PersonNameTextType> nameTexts() {
    return Arbitraries.strings()
        .map(
            (x) -> {
              var pntt = new PersonNameTextType();
              pntt.setValue(x);
              return pntt;
            });
  }

  @Provide
  Arbitrary<PersonNameType> names() {
    Arbitrary<PersonNameTextType> firsts = Arbitraries.defaultFor(PersonNameTextType.class);
    Arbitrary<PersonNameTextType> middles = Arbitraries.defaultFor(PersonNameTextType.class);
    Arbitrary<PersonNameTextType> lasts = Arbitraries.defaultFor(PersonNameTextType.class);
    return Combinators.combine(firsts, middles, lasts)
        .as(
            (f, m, l) -> {
              var pnt = new PersonNameType();
              pnt.setPersonGivenName(f);
              pnt.setPersonMiddleName(m);
              pnt.setPersonSurName(l);
              return pnt;
            });
  }

  @Provide
  Arbitrary<AddressType> addressTypes() {
    Arbitrary<String> recipientName = Arbitraries.strings();
    Arbitrary<String> cityName = Arbitraries.strings();
    Arbitrary<String> addressDeliveryPoint = Arbitraries.strings();
    Arbitrary<String> postalCode = Arbitraries.strings();


  }

  @Provide
  Arbitrary<ContactInformationType> contactTypes() {
    
  }

  @Provide
  Arbitrary<CaseParticipantType> participants() {
    Arbitrary<String> roleCodes = Arbitraries.strings();
    Arbitrary<
  }
}
