package edu.suffolk.litlab.efspserver.ecf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.eq;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;

import edu.suffolk.litlab.efspserver.ContactInformation;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.CrossReference;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.codes.PartyType;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import tyler.ecf.extensions.common.CapabilityType;

public class EcfCourtSpecificSerializerTest {
  
  CodeDatabase cd;
  InfoCollector collector;
  private static final String caseType = "78334";
  
  @BeforeEach
  public void setUp() {
    cd = mock(CodeDatabase.class);
    List<CrossReference> refs = List.of(
        new CrossReference("76343", "PIN#", caseType, "True", "False", "", "", "", "cook:cd1"),
        new CrossReference("87374", "Cook County Attorney/Self-Represented Litigant Code", caseType, 
                "False", "True", "^[0-9]{5}$", "Case type requires a 5-digit Case Cross Reference number and Case Cross Reference type \"Cook County Attorney Code\", if self-represented use 99500.", "COOKCOUNTYATTORNEY", "cook:cd1")
        );
    List<CrossReference> blank = List.of();
    when(cd.getCrossReference("cook:cd1", caseType)).thenReturn(refs);
    when(cd.getCrossReference("adams", caseType)).thenReturn(blank);
    when(cd.getLanguages("not_real")).thenReturn(List.of("English", "Polish", "Spanish"));
    when(cd.getDataField(eq("not_real"), anyString())).thenReturn(DataFieldRow.MissingDataField(""));
    when(cd.getDataField(eq("not_real"), eq("PartyGender"))).thenReturn(
        new DataFieldRow("PartyGender", "Party Gender", "True", "False", "", "", "", "", "", "", "", ""));
    collector = new FailFastCollector();
  }
  
  @Test
  public void shouldBeEmptyPersonIfIsUser() throws FilingError, JAXBException {
    ContactInformation info = new ContactInformation("bob@example.com");
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "not_real";
    EcfCourtSpecificSerializer courtSer = new EcfCourtSpecificSerializer(cd, loc);
    List<PartyType> okPartyTypes = List.of(PartyType.TestObj("1234", "Special", "not_real"));

    Person user = new Person(new Name("Bob", "", "Zombie"), info, Optional.of("Male"), Optional.of("Spanish"), Optional.empty(), false, true, "1234");
    CaseParticipantType cpt = courtSer.serializeEcfCaseParticipant(user, collector, okPartyTypes);
    assertEquals(cpt.getCaseParticipantRoleCode().getValue(), "1234");
    assertTrue(cpt.getEntityRepresentation().getValue() instanceof gov.niem.niem.niem_core._2.PersonType);
    var pt = (gov.niem.niem.niem_core._2.PersonType) cpt.getEntityRepresentation().getValue();
    assertTrue(pt.getPersonCapability().getValue() instanceof CapabilityType);
    CapabilityType ct = (CapabilityType) pt.getPersonCapability().getValue();
    assertTrue(ct.getIAmThisUserIndicator().isValue());
    // The rest of the object should effectively be empty
    // assertNull(pt.getPersonSex());
    //assertNull(pt.getPersonStateIdentification());
    XmlHelper.objectToXmlStr(cpt, CaseParticipantType.class);
    
    
    Person org = new Person(new Name("Business Org", "", ""), info, Optional.empty(), Optional.empty(), Optional.empty(), true, true, "1234");
    CaseParticipantType cptOrg = courtSer.serializeEcfCaseParticipant(org, collector, okPartyTypes);
    assertEquals(cptOrg.getCaseParticipantRoleCode().getValue(), "1234");
    assertTrue(cptOrg.getEntityRepresentation().getValue() instanceof OrganizationType);
    OrganizationType orgPt = ((OrganizationType) cptOrg.getEntityRepresentation().getValue());
    assertTrue(orgPt.getRest().size() > 0); 
    XmlHelper.objectToXmlStr(cptOrg, CaseParticipantType.class);
    
    Person per= new Person(new Name("Bob", "", "Zombie"), info, Optional.of("Male"), Optional.of("Spanish"), Optional.empty(), false, false, "1234");
    CaseParticipantType cptPer = courtSer.serializeEcfCaseParticipant(per, collector, okPartyTypes);
    assertEquals(cptPer.getCaseParticipantRoleCode().getValue(), "1234");
    assertTrue(cptPer.getEntityRepresentation().getValue() instanceof PersonType);
    PersonType perPt = ((PersonType) cptPer.getEntityRepresentation().getValue());
    assertTrue(perPt.getPersonSex() != null);
    List<JAXBElement<?>> langs = perPt.getPersonPrimaryLanguage().getLanguage();
    assertTrue(langs.size() > 0);
    assertEquals(((LanguageCodeType) langs.get(0).getValue()).getValue(), "Spanish");
    XmlHelper.objectToXmlStr(cptPer, CaseParticipantType.class);
  }

  @Test
  public void shouldThrowIfRequiredButNotPresent() {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    EcfCourtSpecificSerializer cookSer = new EcfCourtSpecificSerializer(cd, loc);
    try {
      cookSer.getCrossRefIds(NullNode.getInstance(), collector, caseType);
      fail("Should have thrown a FilingError when CrossReferences are required, but none passed in");
    } catch (FilingError err) {
      // Expected!
    }
  }
  
  @Test
  public void shouldBeOkayIfNoneRequired() throws FilingError {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "adams";
    EcfCourtSpecificSerializer adamsSer = new EcfCourtSpecificSerializer(cd, loc);
    Map<String, String> crossRefIds = adamsSer.getCrossRefIds(NullNode.getInstance(), collector, "78334");
    assertTrue(crossRefIds.isEmpty());
  }
  
  @Test
  public void shouldAllowRequiredWithoutOptionalRefs() throws FilingError, JsonMappingException, JsonProcessingException {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    EcfCourtSpecificSerializer cookSer = new EcfCourtSpecificSerializer(cd, loc);
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree("""
        {
          "cross_references": {
            "87374": "99500"
          }
        }       
        """);
    Map<String, String> crossRefIds = cookSer.getCrossRefIds(node, collector, caseType);
    assertEquals(crossRefIds.size(), 1);
    assertEquals(crossRefIds.get("87374"), "99500");
    JsonNode nodeDADict = mapper.readTree("""
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
    JsonNode node = mapper.readTree("""
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
    node = mapper.readTree("""
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
