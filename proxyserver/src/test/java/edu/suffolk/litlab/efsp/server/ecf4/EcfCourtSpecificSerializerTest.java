package edu.suffolk.litlab.efsp.server.ecf4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.tyler.ecf.extensions.common.CapabilityType;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CrossReference;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFields;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.utils.AllWrongCollector;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
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
    when(cd.getDataFields(eq("not_real")))
        .thenReturn(
            new DataFields(
                List.of(
                    Map.of(
                        "PartyGender",
                        new DataFieldRow(
                            "PartyGender",
                            "Party Gender",
                            true,
                            false,
                            "",
                            "",
                            "",
                            "",
                            "",
                            "",
                            false,
                            ""),
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
                            "")))));
    collector = new FailFastCollector();
  }

  @Test
  public void shouldBeEmptyPersonIfIsUser() throws FilingError, JAXBException {
    ContactInformation info = new ContactInformation("bob@example.com");
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "not_real";
    EcfCourtSpecificSerializer courtSer = new EcfCourtSpecificSerializer(cd, loc);
    List<PartyType> okPartyTypes = List.of(PartyType.TestObj("1234", "Special", "not_real"));

    Person user =
        Person.FromInput(
            new Name("Bob", "", "Zombie"),
            info,
            Optional.of("Male"),
            Optional.of("Spanish"),
            Optional.empty(),
            false,
            true,
            "1234",
            Optional.empty());
    CaseParticipantType cpt = courtSer.serializeEcfCaseParticipant(user, collector, okPartyTypes);
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
            "1234",
            Optional.empty());
    CaseParticipantType cptOrg = courtSer.serializeEcfCaseParticipant(org, collector, okPartyTypes);
    assertEquals("1234", cptOrg.getCaseParticipantRoleCode().getValue());
    assertTrue(cptOrg.getEntityRepresentation().getValue() instanceof OrganizationType);
    OrganizationType orgPt = ((OrganizationType) cptOrg.getEntityRepresentation().getValue());
    assertTrue(orgPt.getRest().size() > 0);
    Ecf4Helper.objectToXmlStr(cptOrg, CaseParticipantType.class);

    Person per =
        Person.FromInput(
            new Name("Bob", "", "Zombie"),
            info,
            Optional.of("Male"),
            Optional.of("Spanish"),
            Optional.empty(),
            false,
            false,
            "1234",
            Optional.empty());
    CaseParticipantType cptPer = courtSer.serializeEcfCaseParticipant(per, collector, okPartyTypes);
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
            List.of("1234567890", "123-456-7890 ", "123-abc"),
            Optional.empty(),
            Optional.of("bob@example.com"));
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "not_real";
    EcfCourtSpecificSerializer courtSer = new EcfCourtSpecificSerializer(cd, loc);
    var contactInfoType = courtSer.serializeEcfContactInformation(info, collector);
    assertThat(contactInfoType.getContactMeans()).hasSize(2);
    assertThat(collector.getWrong()).hasSize(0);
  }

  @Test
  public void shouldThrowIfRequiredButNotPresent() {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    EcfCourtSpecificSerializer cookSer = new EcfCourtSpecificSerializer(cd, loc);
    try {
      cookSer.getCrossRefIds(NullNode.getInstance(), collector, caseType);
      fail(
          "Should have thrown a FilingError when CrossReferences are required, but none passed in");
    } catch (FilingError err) {
      // Expected!
    }
  }

  @Test
  public void shouldBeOkayIfNoneRequired() throws FilingError {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "adams";
    EcfCourtSpecificSerializer adamsSer = new EcfCourtSpecificSerializer(cd, loc);
    Map<String, String> crossRefIds =
        adamsSer.getCrossRefIds(NullNode.getInstance(), collector, "78334");
    assertTrue(crossRefIds.isEmpty());
  }

  @Test
  public void shouldAllowRequiredWithoutOptionalRefs()
      throws FilingError, JsonMappingException, JsonProcessingException {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    EcfCourtSpecificSerializer cookSer = new EcfCourtSpecificSerializer(cd, loc);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node =
        mapper.readTree(
            """
            {
              "cross_references": {
                "87374": "99500"
              }
            }
            """);
    Map<String, String> crossRefIds = cookSer.getCrossRefIds(node, collector, caseType);
    assertEquals(crossRefIds.size(), 1);
    assertEquals(crossRefIds.get("87374"), "99500");
    JsonNode nodeDADict =
        mapper.readTree(
            """
            {
              "cross_references": {
                "_class" : "DADict",
                "elements": {
                  "87374": "99502",
                  "76343": "12345"
                }
              }
            }
            """);
    collector = new FailFastCollector();
    Map<String, String> crossRefIdsDADict = cookSer.getCrossRefIds(nodeDADict, collector, caseType);
    assertEquals(crossRefIdsDADict.size(), 2);
    assertEquals(crossRefIdsDADict.get("87374"), "99502");
    assertEquals(crossRefIdsDADict.get("76343"), "12345");
  }

  @Test
  public void shouldThrowOnBadCrossRefKey() throws JsonMappingException, JsonProcessingException {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    EcfCourtSpecificSerializer cookSer = new EcfCourtSpecificSerializer(cd, loc);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node =
        mapper.readTree(
            """
            {
              "cross_references": {
                "_class": "DADict",
                "elements": {
                  "87374": "99500",
                  "12345": "bad key"
                }
              }
            }
            """);
    try {
      cookSer.getCrossRefIds(node, collector, caseType);
      fail("Should have failed, we passed a cross reference code that isn't really there");
    } catch (FilingError err) {
      // Expected!
    }
    node =
        mapper.readTree(
            """
            {
              "cross_references": {
                "_class": "DADict",
                "elements": {
                  "87374": "123456"
                }
              }
            }
            """);
    try {
      cookSer.getCrossRefIds(node, collector, caseType);
      fail("Should have failed, we passed a value for a cross reference code that was too long");
    } catch (FilingError err) {
      // Expected!
    }
  }
}
