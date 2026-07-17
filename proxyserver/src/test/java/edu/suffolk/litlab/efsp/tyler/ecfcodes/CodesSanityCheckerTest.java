package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.db.DatabaseVersionTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Tag("Docker")
public class CodesSanityCheckerTest {

  private CodeDatabase cd;

  @Container
  public PostgreSQLContainer postgres =
      new PostgreSQLContainer(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));

  @BeforeEach
  public void setUp() throws SQLException {
    postgres.start();
    Connection conn =
        DatabaseCreator.makeSingleConnection(
            postgres.getDatabaseName(),
            postgres.getJdbcUrl(),
            postgres.getUsername(),
            postgres.getPassword());
    cd = new CodeDatabase(Jurisdiction.ILLINOIS, conn);
    cd.createTablesIfAbsent();
  }

  @AfterEach
  public void tearDown() throws SQLException {
    cd.close();
  }

  private void loadFromXmls() throws Exception {
    Map<String, List<String>> tableToCourts =
        Map.of(
            "location", List.of("0"),
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
        cd.updateTable(table, court, this.getClass().getResourceAsStream(filename));
      }
    }
  }

  // Illinois/adams doesn't have any KnownCodeLookups entries seeded (those are
  // all MA's so far), so this mainly proves the whole pipeline runs
  // cleanly against a real Postgres schema without throwing.
  @Test
  public void runAllDoesNotThrow() throws Exception {
    loadFromXmls();
    var checker = new CodesSanityChecker(cd, "illinois");
    assertDoesNotThrow(checker::runAll);
  }
}
