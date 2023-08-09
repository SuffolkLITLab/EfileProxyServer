package edu.suffolk.litlab.efspserver.tyler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;

import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.tyler.codes.CrossReference;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.tyler.codes.DataFields;

public class TylerCodesSerializerTest {
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
    when(cd.getLanguageNames("not_real")).thenReturn(List.of("English", "Polish", "Spanish"));
    when(cd.getDataFields(eq("not_real"))).thenReturn(new DataFields(
        List.of(Map.of("PartyGender",
               new DataFieldRow("PartyGender", "Party Gender", true, false, "", "", "", "", "", "", false, "")))
        ));
    collector = new FailFastCollector();
  }
  
  @Test
  public void shouldThrowIfRequiredButNotPresent() {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    TylerCodesSerializer cookSer = new TylerCodesSerializer(cd, loc, cd.getDataFields(loc.code));
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
    var dataFields = cd.getDataFields(loc.code);
    TylerCodesSerializer adamsSer = new TylerCodesSerializer(cd, loc, dataFields);
    Map<String, String> crossRefIds = adamsSer.getCrossRefIds(NullNode.getInstance(), collector, "78334");
    assertTrue(crossRefIds.isEmpty());
  }
  
  @Test
  public void shouldAllowRequiredWithoutOptionalRefs() throws FilingError, JsonMappingException, JsonProcessingException {
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "cook:cd1";
    var dataFields = cd.getDataFields(loc.code);
    TylerCodesSerializer cookSer = new TylerCodesSerializer(cd, loc, dataFields);
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
    var dataFields = cd.getDataFields(loc.code);
    TylerCodesSerializer cookSer = new TylerCodesSerializer(cd, loc, dataFields);
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
