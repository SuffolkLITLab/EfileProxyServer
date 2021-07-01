package edu.suffolk.assemblyline.efspserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LegalIssuesTaxonomyCodesTest {

  LegalIssuesTaxonomyCodes codes;

  @BeforeEach
  public void setUp() throws CsvValidationException, IOException {
  }
  
  @Test
  public void testThrowsOnBadFile() {
    assertThrows(NullPointerException.class, () -> new LegalIssuesTaxonomyCodes(null));  
    assertThrows(CsvValidationException.class, () -> {
      new LegalIssuesTaxonomyCodes(this.getClass().getResourceAsStream(
          "/bad.csv"));
    });
  }
  
  @Test
  public void testCorrectEcfMappings() throws CsvValidationException, IOException {
    codes = new LegalIssuesTaxonomyCodes(this.getClass().getResourceAsStream("/taxonomy.csv"));
    Set<String> bankruptcy = codes.allEcfCaseTypes(List.of("MO-13-00-00-00"));
    assertEquals(Set.of("BankruptcyCase"), bankruptcy);
    
    Set<String> domestic = codes.allEcfCaseTypes(List.of("MO-00-00-00-00", "HE-00-00-00-00"));
    assertEquals(Set.of("CivilCase"), domestic);
   
    Set<String> domesticAndCivil = 
        codes.allEcfCaseTypes(List.of("FA-06-00-00-00", "TO-04-00-00-00"));
    assertEquals(Set.of("DomesticCase", "CivilCase"), domesticAndCivil);
  }

}
