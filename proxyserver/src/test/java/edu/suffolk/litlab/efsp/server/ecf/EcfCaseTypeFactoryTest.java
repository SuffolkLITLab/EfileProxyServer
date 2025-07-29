package edu.suffolk.litlab.efsp.server.ecf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.docassemble.DocassembleToFilingInformationConverter;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.server.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import gov.niem.niem.niem_core._2.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EcfCaseTypeFactoryTest {

  CodeDatabase cd;
  InfoCollector collector;
  private static final String caseType = "78334";

  @BeforeEach
  public void setUp() {
    cd = mock(CodeDatabase.class);
    List<CrossReference> refs =
        List.of(
            new CrossReference("76343", "PIN#", caseType, "True", "False", "", "", "", "cook:cd1"),
            new CrossReference(
                "87374",
                "Cook County Attorney/Self-Represented Litigant Code",
                caseType,
                "False",
                "True",
                "^[0-9]{5}$",
                "Case type requires a 5-digit Case Cross Reference number and Case Cross Reference"
                    + " type \"Cook County Attorney Code\", if self-represented use 99500.",
                "COOKCOUNTYATTORNEY",
                "cook:cd1"));
    List<CrossReference> blank = List.of();
    when(cd.getCrossReference("cook:cd1", caseType)).thenReturn(refs);
    when(cd.getCrossReference("adams", caseType)).thenReturn(blank);
    when(cd.getLanguageNames("not_real")).thenReturn(List.of("English", "Polish", "Spanish"));
    when(cd.getDataField(eq("not_real"), anyString()))
        .thenReturn(DataFieldRow.MissingDataField(""));
    when(cd.getDataField(eq("not_real"), eq("PartyGender")))
        .thenReturn(
            new DataFieldRow(
                "PartyGender", "Party Gender", true, false, "", "", "", "", "", "", false, ""));
    collector = new FailFastCollector();
  }

  private static CaseResponseMessageType readFromFile(InputStream inStream)
      throws FileNotFoundException, JAXBException, XMLStreamException {
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader sr = xmlInputFactory.createXMLStreamReader(inStream);
    Unmarshaller u =
        JAXBContext.newInstance(
                ObjectFactory.class, gov.niem.niem.structures._2.ObjectFactory.class)
            .createUnmarshaller();
    return u.unmarshal(sr, CaseResponseMessageType.class).getValue();
  }

  @Test
  public void shouldUnpackTylerCaseCorrectly()
      throws FileNotFoundException, JAXBException, XMLStreamException {
    gov.niem.niem.niem_core._2.CaseType myCase =
        readFromFile(this.getClass().getResourceAsStream("/case_resp.xml")).getCase().getValue();
    System.out.println(
        Ecf4Helper.objectToXmlStrOrError(myCase, gov.niem.niem.niem_core._2.CaseType.class));
    Optional<Map<PartyId, Person>> participants = EcfCaseTypeFactory.getCaseParticipants(myCase);
    assertTrue(participants.isPresent());
    assertEquals(participants.get().size(), 2);
    PartyId abcKey = PartyId.Already("7df2f0f0-abca-4cc1-a5b5-8b621955079d");
    assertTrue(participants.get().containsKey(abcKey));
    Person abcFromData = participants.get().get(abcKey);
    assertTrue(abcFromData.isOrg());
    assertEquals(abcFromData.getName().getFullName(), "ABC CORP");
    assertEquals(abcFromData.getRole(), "20646");

    PartyId xyzKey = PartyId.Already("e56ed9ec-b473-41cc-bfb6-fec4129422bb");
    assertTrue(participants.get().containsKey(xyzKey));
    Person xyzFromData = participants.get().get(xyzKey);
    assertTrue(xyzFromData.isOrg());
    assertEquals(xyzFromData.getName().getFullName(), "ORG XYZ");
    assertEquals(xyzFromData.getRole(), "20641");
  }

  @Test
  public void shouldMatchExistingPartyPersonOrOrgXmlWrappers() throws Exception {
    // gov.niem.niem.niem_core._2.CaseType myCase =
    // readFromFile(this.getClass().getResourceAsStream("/case_resp.xml")).getCase().getValue();
    // EcfCaseTypeFactory caseFactory = new EcfCaseTypeFactory(cd, "illinois");
    EcfCaseTypeFactory.getCriteria();
    InterviewToFilingInformationConverter converter =
        new DocassembleToFilingInformationConverter(null);
    Result<FilingInformation, FilingError> infoRes = converter.extractInformation("");
    assertTrue(infoRes.isErr());
    return;

    // TODO(brycew): get a better system for reading in JSON examples from D
    /*
    assertTrue(infoRes.isOk());
    FilingInformation info = infoRes.unwrapOrElseThrow();
    CourtLocationInfo loc = new CourtLocationInfo();
    ComboCaseCodes combos = new ComboCaseCodes(
        new CaseCategory("code", "name", "", "", "", "", ""),
        new CaseType(null, null, null, null, null, null, null, null),
        List.of(new FilingCode(null, null, null, null, null, null, null, null, null, null, null, null, null, null)),
        Map.of("id", Pair.of(new PartyType("", "", "", "", "", "", "", "", "", "", "", ""), true)));
    loc.code = "coles";
    EcfCourtSpecificSerializer courtSer = new EcfCourtSpecificSerializer(cd, loc);
    JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType> retVal =
        caseFactory.makeCaseTypeFromTylerCategory(loc, combos, info, false, false,
            List.of("177239"), "filing", info.getMiscInfo(), courtSer, collector, Map.of());
    assertTrue(retVal.getValue() != null);
    */
  }
}
