package edu.suffolk.litlab.efspserver.tyler.codes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
import edu.suffolk.litlab.efspserver.ecfcodes.CodeUpdater;

public class CodeDatabaseTest {
  private static Logger log = 
      LoggerFactory.getLogger(CodeDatabaseTest.class); 
  
  private CodeDatabase cd;
  
  @Container
  public PostgreSQLContainer<?> postgres =
    new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));
  
  @BeforeEach
  public void setUp() throws SQLException {
    postgres.start();
    Connection conn = DatabaseCreator.makeSingleConnection(
        postgres.getDatabaseName(), postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
    cd = new CodeDatabase("illinois", "stage", conn); 
    cd.createTablesIfAbsent();
  }
  
  @AfterEach
  public void tearDown() throws SQLException {
    cd.close();
  }
  
  @Test
  public void allNamespacesMapToTables() {
    for (String table : CodeUpdater.ecf4ElemToTableName.values()) {
      if (!table.equalsIgnoreCase("optionalservices")) {
        assertNotEquals(CodeTableConstants.getTableColumns(table).size(),
            0, "Expected " + table + " to exist");
        assertTrue(table.length() <= 63, "table name " + table + " should be <= 63 characters");
      }
    }
  }

  private void loadFromXmls() throws Exception {
    Map<String, List<String>> tableToCourts = Map.of(
        "location", List.of("0"),
        "optionalservices", List.of("adams"),
        "casecategory", List.of("adams"),
        "casetype", List.of("adams"),
        "casesubtype", List.of("adams"),
        "servicetype", List.of("adams"),
        "filingstatus", List.of("adams"));
    for (Map.Entry<String, List<String>> entry : tableToCourts.entrySet()) {
      String table = entry.getKey();
      cd.createTableIfAbsent(table);
      for (String court : entry.getValue()) {
        String filename = "/" + court + "_" + table + "_test.xml";
        log.info("Updating from file: " + filename);
        cd.updateTable(table, court, this.getClass().getResourceAsStream(filename)); 
      }
    }
  }
  
  @Test
  public void testFromNothing() throws Exception {
    loadFromXmls();

    List<CaseCategory> cats = cd.getCaseCategoriesFor("adams");
    assertFalse(cats.isEmpty());
    List<CaseType> types = cd.getCaseTypesFor("adams", "183527", Optional.empty()); 
    assertFalse(types.isEmpty());
    cd.getCaseSubtypesFor("adams", types.get(0).code);
    List<OptionalServiceCode> optServs = cd.getOptionalServices("adams", "183612");
    assertFalse(optServs.isEmpty());
    List<ServiceCodeType> services = cd.getServiceTypes("adams");
    assertFalse(services.isEmpty());
    
    Optional<CourtLocationInfo> info = cd.getFullLocationInfo("adams");
    List<String> allCourts = cd.getAllLocations();
    assertFalse(allCourts.isEmpty());
    List<String> fileable = cd.getFileableLocations();
    assertFalse(fileable.isEmpty());
    assertTrue(info.isPresent());
  }

  @Test
  public void testDeletes() throws Exception {
    loadFromXmls();


    var beforeDeleteKane = cd.getOptionalServices("adams", "183612");
    cd.deleteFromTable("optionalservices", "kane");
    var afterDeleteKane = cd.getOptionalServices("adams", "183612");
    assertEquals(beforeDeleteKane.size(), afterDeleteKane.size(), "Before and after deleting something else should be the same");
    cd.deleteFromTable("optionalservices", "adams");
    var afterDeleteAdams = cd.getOptionalServices("adams", "183612");
    assertEquals(0, afterDeleteAdams.size(), "Shouldn't be any adams stuff after deleting it");

    List<CaseCategory> catsBeforeDelete = cd.getCaseCategoriesFor("adams");
    assertFalse(catsBeforeDelete.isEmpty());
    cd.deleteFromTable("casecategory", "adams");
    List<CaseCategory> catsAfterDelete = cd.getCaseCategoriesFor("adams");
    assertEquals(0, catsAfterDelete.size(), "Should be no categories after deleting");
  }

}
