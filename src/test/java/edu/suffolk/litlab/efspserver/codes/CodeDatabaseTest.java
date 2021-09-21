package edu.suffolk.litlab.efspserver.codes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class CodeDatabaseTest {
  private static Logger log = 
      LoggerFactory.getLogger(CodeDatabaseTest.class); 
  
  private CodeDatabase cd;
  
  @Container
  public PostgreSQLContainer<?> postgres =
    new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));
  
  @BeforeEach
  public void setUp() throws Exception {
    postgres.start();
    cd = new CodeDatabase(postgres.getJdbcUrl(), postgres.getDatabaseName());
    cd.createDbConnection(postgres.getUsername(), postgres.getPassword());
    cd.createTablesIfAbsent();
  }
  
  @Test
  public void allNamespacesMapToTables() {
    Collection<String> tables = CodeUpdater.ncToTableName.values();
    for (String table : tables) {
      assertNotEquals(CodeTableConstants.getTableColumns(table).orElse(List.of()).size(),
          0, "Expected " + table + " to exist");
    }
  }
  
  @Test
  public void testFromNothing() throws Exception {
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
    List<String> filable = cd.getFiliableCourts();
    assertFalse(filable.isEmpty());
    assertTrue(info.isPresent());
  }
  // TODO(brycew-later): test that all database column names are <= 63 characters (NAMEDATALEN - 1)

}
