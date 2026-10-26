package edu.suffolk.litlab.efsp.truefiling.ecf4;

import static org.assertj.core.api.Assertions.assertThat;

import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import org.junit.jupiter.api.Test;

public class EcfCourtSpecificSerializerTest {

  EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer();

  @Test
  public void testNoProSeMarkerInParticipant() {
    Person per = Person.TestPerson(new Name("Bob", "", "Dylan"), null, false);
    var entity = serializer.serializeCaseEntity(per);
    assertThat(((PersonType) entity.getValue()).getPersonStateIdentification()).isNull();

    var niemEntity = serializer.serializeNiemEntity(per);
    var stateId =
        ((gov.niem.niem.niem_core._2.PersonType) niemEntity.getEntityRepresentation().getValue())
            .getPersonStateIdentification();
    assertThat(stateId).isNotNull();
    assertThat(stateId.getIdentificationID().getValue()).isEqualTo("Pro Per");
  }
}
