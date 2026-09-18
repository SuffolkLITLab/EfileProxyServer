package edu.suffolk.litlab.efsp.tyler.ecf4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.CaseListResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import edu.suffolk.litlab.efsp.ecf4.EcfToReturn.Participants;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseAPI;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCodeType;
import edu.suffolk.litlab.efsp.model.cases.LegalPerson;
import edu.suffolk.litlab.efsp.model.cases.LegalPerson.PersonEnum;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TylerEcf4ToReturnTest {
  CodeDatabaseAPI cd;
  final String COURT_LOC = "coles";

  @BeforeEach
  public void setUp() {
    cd = mock(CodeDatabase.class);

    when(cd.getCaseCategoryNames(COURT_LOC))
        .thenReturn(List.of(new NameAndCodeType("Civil", "190921")));
    when(cd.getCaseTypeNamesFor(COURT_LOC, "190921", Optional.empty()))
        .thenReturn(List.of(new NameAndCodeType("not the right one", "123")));
  }

  private static CaseResponseMessageType readFromFile(InputStream inStream)
      throws FileNotFoundException, JAXBException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader sr = xmlInputFactory.createXMLStreamReader(inStream);
    Unmarshaller u =
        JAXBContext.newInstance(
                ObjectFactory.class, ecf4.latest.gov.niem.niem.structures._2.ObjectFactory.class)
            .createUnmarshaller();
    return u.unmarshal(sr, CaseResponseMessageType.class).getValue();
  }

  private static CaseListResponseMessageType readListFromFile(InputStream inStream)
      throws FileNotFoundException, JAXBException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader sr = xmlInputFactory.createXMLStreamReader(inStream);
    Unmarshaller u =
        JAXBContext.newInstance(
                ObjectFactory.class, ecf4.latest.gov.niem.niem.structures._2.ObjectFactory.class)
            .createUnmarshaller();
    return u.unmarshal(sr, CaseListResponseMessageType.class).getValue();
  }

  @Test
  public void shouldUnpackTylerParticipantsCorrectly()
      throws FileNotFoundException, JAXBException, XMLStreamException {
    var myCase = readFromFile(this.getClass().getResourceAsStream("/cases/case_resp.xml"));
    TylerEcfToReturn toReturn = new TylerEcfToReturn(myCase, cd);
    Participants participants = toReturn.getCaseParticipants();
    String abcKey = "7df2f0f0-abca-4cc1-a5b5-8b621955079d";
    assertThat(participants.idToPerson()).hasSize(2).containsKey(abcKey);
    LegalPerson abcFromData = participants.idToPerson().get(abcKey);
    assertThat(abcFromData.personType()).isEqualTo(PersonEnum.BUSINESS);
    assertThat(abcFromData.name().makeFullName()).isEqualTo("ABC CORP");
    assertThat(abcFromData.role()).isEqualTo("20646");

    String xyzKey = "e56ed9ec-b473-41cc-bfb6-fec4129422bb";
    assertThat(participants.idToPerson()).containsKey(xyzKey);
    LegalPerson xyzFromData = participants.idToPerson().get(xyzKey);
    assertThat(xyzFromData.personType()).isEqualTo(PersonEnum.BUSINESS);
    assertThat(xyzFromData.name().makeFullName()).isEqualTo("ORG XYZ");
    assertThat(xyzFromData.role()).isEqualTo("20641");
  }

  @Test
  public void shouldUnpackTylerCaseCorrectly() throws Exception {
    var myCase = readFromFile(this.getClass().getResourceAsStream("/cases/case_resp.xml"));
    TylerEcfToReturn toReturn = new TylerEcfToReturn(myCase, cd);
    var parsedCase = toReturn.toCase();
    assertThat(parsedCase.participants()).hasSize(2);
    assertThat(parsedCase.caseCategory().name()).isEqualTo("Civil");
    assertThat(parsedCase.caseCategory().code()).isEqualTo("190921");
    assertThat(parsedCase.caseType().name()).isEqualTo("(case type name not found)");
    assertThat(parsedCase.caseType().code()).isEqualTo("205200");
    assertThat(parsedCase.caseTitle()).isEqualTo("ABC CORP VS. ORG XYZ");
    assertThat(parsedCase.filedDate().toLocalDate()).isEqualTo(LocalDate.of(2022, 1, 27));
    assertThat(parsedCase.docketId()).isEqualTo("2022EV12");
    assertThat(parsedCase.trackingId()).isEqualTo("IL016025J2022EV12");
    assertThat(parsedCase.courtCode()).isEqualTo(COURT_LOC);
    assertThat(parsedCase.caseLineage()).contains("a08f60c4-832c-48b9-8ce0-7563a6613aaa");
    assertThat(parsedCase.hasUserFiledIntoCase()).isFalse();
  }

  @Test
  public void shouldntThrowNPE() throws Exception {
    for (var caseFile :
        List.of(
            "tmp_marion2.xml",
            "tmp_will_2.xml",
            "tmp2.xml",
            "will_full.xml")) { // , "will_just_search.xml")) {
      var myCase = readFromFile(this.getClass().getResourceAsStream("/cases/" + caseFile));
      TylerEcfToReturn toReturn = new TylerEcfToReturn(myCase, cd);
      toReturn.toCase();
    }
  }

  @Test
  public void shouldntThrowNPEOnList() throws Exception {
    var myCaseList =
        readListFromFile(this.getClass().getResourceAsStream("/cases/will_just_search.xml"));
    for (var myCase : myCaseList.getCase()) {
      TylerEcfToReturn toReturn = new TylerEcfToReturn(myCase.getValue(), cd);
      toReturn.toCase();
    }
  }
}
