package edu.suffolk.litlab.efsp.server.ecf4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.tyler.ecf.extensions.common.CapabilityType;
import edu.suffolk.litlab.efsp.docassemble.FilingDocDocassembleJacksonDeserializer;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseCategory;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CaseType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FileType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingCode;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.FilingComponent;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.PartyInfo;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.model.Person.Gender;
import edu.suffolk.litlab.efsp.server.ecf4.tyler.TylerCodesParser;
import edu.suffolk.litlab.efsp.utils.AllWrongCollector;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EcfCourtSpecificSerializerTest {

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
    when(cd.getAllowedFileTypes("not_real"))
        .thenReturn(List.of(new FileType("PDF", "pdf", ".pdf", "not_real")));
    when(cd.getFilingComponents("not_real", "6553"))
        .thenReturn(List.of(new FilingComponent("332", "", "", false, true, 0, "", "")));
    when(cd.getDataFields(eq("not_real")))
        .thenReturn(
            new DataFields(
                List.of(
                    Map.of(
                        "PartyGender",
                        new DataFieldRow("PartyGender", "Party Gender", true, false, ""),
                        "PartyPhone",
                        new DataFieldRow(
                            "PartyPhone",
                            "Party Phone",
                            true,
                            false,
                            "",
                            "",
                            "",
                            "Do not use hyphens or other characters--just numbers",
                            "^(\\+0?1\\s)?\\(?\\d{3}\\)?\\d{3}\\d{4}$",
                            "",
                            false,
                            ""),
                        "DocumentDescription",
                        new DataFieldRow(
                            "DocumentDescription", "Document Description", true, false, "")))));
    collector = new FailFastCollector();
  }

  @Test
  public void shouldBeEmptyPersonIfIsUser() throws FilingError, JAXBException {
    ContactInformation info = new ContactInformation("bob@example.com");
    CourtLocationInfo loc = new CourtLocationInfo("not_real");
    EcfCourtSpecificSerializer courtSer = new EcfCourtSpecificSerializer(cd, loc);
    PartyType partyType = PartyType.TestObj("1234", "Special", "not_real");

    Person user =
        Person.FromInput(
            new Name("Bob", "", "Zombie"),
            info,
            Optional.of(Gender.MALE),
            Optional.of("Spanish"),
            Optional.empty(),
            false,
            true,
            Optional.of("1234"),
            Optional.empty());
    PartyInfo partyInfo = new PartyInfo(partyType, user.getPartyId(), user.isOrg());
    CaseParticipantType cpt = courtSer.serializeEcfCaseParticipant(user, partyInfo, collector);
    assertEquals("1234", cpt.getCaseParticipantRoleCode().getValue());
    assertTrue(
        cpt.getEntityRepresentation().getValue()
            instanceof ecf4.latest.gov.niem.niem.niem_core._2.PersonType);
    var pt =
        (ecf4.latest.gov.niem.niem.niem_core._2.PersonType)
            cpt.getEntityRepresentation().getValue();
    assertTrue(pt.getPersonCapability().getValue() instanceof CapabilityType);
    CapabilityType ct = (CapabilityType) pt.getPersonCapability().getValue();
    assertTrue(ct.getIAmThisUserIndicator().isValue());
    // The rest of the object should effectively be empty
    // assertNull(pt.getPersonSex());
    // assertNull(pt.getPersonStateIdentification());
    Ecf4Helper.objectToXmlStr(cpt, CaseParticipantType.class);

    Person org =
        Person.FromInput(
            new Name("Business Org", "", ""),
            info,
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            true,
            true,
            Optional.of("1234"),
            Optional.empty());
    PartyInfo orgInfo = new PartyInfo(partyType, org.getPartyId(), org.isOrg());
    CaseParticipantType cptOrg = courtSer.serializeEcfCaseParticipant(org, orgInfo, collector);
    assertEquals("1234", cptOrg.getCaseParticipantRoleCode().getValue());
    assertTrue(cptOrg.getEntityRepresentation().getValue() instanceof OrganizationType);
    OrganizationType orgPt = ((OrganizationType) cptOrg.getEntityRepresentation().getValue());
    assertTrue(orgPt.getRest().size() > 0);
    Ecf4Helper.objectToXmlStr(cptOrg, CaseParticipantType.class);

    Person per =
        Person.FromInput(
            new Name("Bob", "", "Zombie"),
            info,
            Optional.of(Gender.MALE),
            Optional.of("Spanish"),
            Optional.empty(),
            false,
            false,
            Optional.of("1234"),
            Optional.empty());
    PartyInfo perInfo = new PartyInfo(partyType, per.getPartyId(), per.isOrg());
    CaseParticipantType cptPer = courtSer.serializeEcfCaseParticipant(per, perInfo, collector);
    System.out.println(Ecf4Helper.objectToXmlStr(cpt, CaseParticipantType.class));
    assertEquals(cptPer.getCaseParticipantRoleCode().getValue(), "1234");
    assertTrue(cptPer.getEntityRepresentation().getValue() instanceof PersonType);
    PersonType perPt = ((PersonType) cptPer.getEntityRepresentation().getValue());
    assertTrue(
        perPt.getPersonSex() != null,
        "Person sex should be not null, but was " + perPt.getPersonSex());
    List<JAXBElement<?>> langs = perPt.getPersonPrimaryLanguage().getLanguage();
    assertTrue(langs.size() > 0);
    // assertEquals("Spanish", ((LanguageCodeType) langs.get(0).getValue()).getValue());
    Ecf4Helper.objectToXmlStr(cptPer, CaseParticipantType.class);
  }

  @Test
  public void shouldAllowAtLeastOnePhone() throws FilingError {
    collector = new AllWrongCollector();
    ContactInformation info =
        new ContactInformation(
            List.of("1234567890", "(123) 456-7890"),
            Optional.empty(),
            Optional.of("bob@example.com"));
    CourtLocationInfo loc = new CourtLocationInfo("not_real");
    EcfCourtSpecificSerializer courtSer = new EcfCourtSpecificSerializer(cd, loc);
    var contactInfoType = courtSer.serializeEcfContactInformation(info, collector);
    assertThat(contactInfoType.getContactMeans()).hasSize(3);
    assertThat(collector.getWrong()).hasSize(0);
  }

  @Test
  public void shouldParseDoc() throws IOException, FilingError {
    collector = new AllWrongCollector();
    CourtLocationInfo loc = new CourtLocationInfo("not_real");
    loc.allowserviceoninitial = CourtLocationInfo.BoolOrDefault.TRUE;

    CaseCategory caseCategory = new CaseCategory("7", "Civil", null, null, null, null, null);
    CaseType caseType = new CaseType("100", "Divorce", "7", "true", "100", null, null, "not_real");
    FilingCode filing =
        new FilingCode(
            "6553",
            "Initial Filing",
            "100",
            "7",
            "100",
            "0",
            false,
            null,
            null,
            null,
            false,
            false,
            null,
            "not_real");

    var varToPartyId = Map.of("users[0]", PartyId.CurrentFilingNew("abc"));
    JsonNode node = readFile("one_attachment.json");
    var parser = new TylerCodesParser(cd, loc);
    var doc =
        FilingDocDocassembleJacksonDeserializer.fromNode(
            node, varToPartyId, 2, List.of(filing), parser, collector);

    EcfCourtSpecificSerializer cookSer = new EcfCourtSpecificSerializer(cd, loc);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode miscNode = mapper.createObjectNode();
    var xmlDoc =
        cookSer.filingDocToXml(
            doc.get(), true, caseCategory, caseType, filing, true, miscNode, collector);
    assertThat(xmlDoc.getValue().getDocumentSequenceID().getValue()).isEqualTo("2");
    assertThat(xmlDoc.getValue().getDocumentDescriptionText().getValue())
        .isEqualTo("The Motion to Stay Eviction for Bob Ma");
  }

  private JsonNode readFile(String jsonFile) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(this.getClass().getResourceAsStream("/filingdocs/" + jsonFile));
  }
}
