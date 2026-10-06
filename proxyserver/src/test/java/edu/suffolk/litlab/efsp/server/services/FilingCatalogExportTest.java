package edu.suffolk.litlab.efsp.server.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.DatabaseVersionTest;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Tag("Docker")
public class FilingCatalogExportTest {
  private static final PostgreSQLContainer POSTGRES =
      new PostgreSQLContainer(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));
  private static final ObjectMapper JSON = new ObjectMapper();

  @BeforeAll
  static void start() {
    POSTGRES.start();
  }

  @AfterAll
  static void stop() {
    POSTGRES.stop();
  }

  private Connection connect() throws SQLException {
    return DriverManager.getConnection(
        POSTGRES.getJdbcUrl(), POSTGRES.getUsername(), POSTGRES.getPassword());
  }

  private void execute(String sql) throws SQLException {
    try (Connection conn = connect();
        Statement st = conn.createStatement()) {
      st.execute(sql);
    }
  }

  private JsonNode manifest() throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(Jurisdiction.ILLINOIS, connect())) {
      return JSON.valueToTree(cd.getFilingCatalogManifest());
    }
  }

  private Optional<JsonNode> catalog(String court) throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(Jurisdiction.ILLINOIS, connect())) {
      return cd.getFilingCatalogCourt(court).map(JSON::valueToTree);
    }
  }

  @BeforeEach
  void seed() throws SQLException {
    try (CodeDatabase cd = new CodeDatabase(Jurisdiction.ILLINOIS, connect())) {
      cd.createTablesIfAbsent();
      for (String table : List.of("casecategory", "casetype", "filing")) {
        cd.createTableIfAbsent(table);
      }
    }
    execute(
        """
        TRUNCATE location, installedversion, casecategory, casetype, filing;
        INSERT INTO location (code, name, initial, subsequent, jurisdiction) VALUES
          ('court', 'Example County', 'True', 'True', 'illinois'),
          ('other', 'Other County', 'True', 'True', 'illinois'),
          ('parent', 'Parent grouping', 'False', 'False', 'illinois'),
          ('foreign', 'Foreign court', 'True', 'True', 'vermont');
        INSERT INTO installedversion (location, codelist, installedversion, jurisdiction)
          SELECT location, codelist, '1', 'illinois'
          FROM (VALUES ('court'), ('other')) AS loc(location)
          CROSS JOIN (VALUES ('casecategorycodes.zip'), ('casetypecodes.zip'), ('filingcodes.zip')) AS lists(codelist);
        INSERT INTO casecategory (code, name, ecfcasetype, location, jurisdiction) VALUES
          ('civil', 'Civil', 'CivilCase', 'court', 'illinois'),
          ('criminal', 'Criminal', 'CriminalCase', 'court', 'illinois');
        INSERT INTO casetype (code, name, casecategory, initial, location, jurisdiction) VALUES
          ('eviction', 'Eviction', 'civil', 'True', 'court', 'illinois'),
          ('debt', 'Debt collection', 'civil', 'False', 'court', 'illinois');
        INSERT INTO filing (code, name, casecategory, casetypeid, filingtype, iscourtuseonly, location, jurisdiction) VALUES
          ('complaint', 'Complaint', '', '', 'Initial', 'False', 'court', 'illinois'),
          ('answer', 'Answer', '', '', 'Subsequent', 'False', 'court', 'illinois'),
          ('motion', 'Motion to dismiss', NULL, 'eviction', 'Subsequent', 'False', 'court', 'illinois'),
          ('internal', 'Internal only', '', '', 'Both', 'True', 'court', 'illinois'),
          ('foreign', 'Foreign filing', '', '', 'Both', 'False', 'court', 'vermont');
        """);
  }

  @Test
  void installedVersionsAndCourtNamesIdentifyOnlyChangedCourts() throws Exception {
    JsonNode first = manifest();
    assertEquals(first, manifest());
    assertEquals(2, first.get("courts").size());
    execute(
        "UPDATE installedversion SET installedversion='2' WHERE location='court' AND codelist='filingcodes.zip'");
    JsonNode changed = manifest();
    assertNotEquals(first.at("/courts/0/revision"), changed.at("/courts/0/revision"));
    assertEquals(first.at("/courts/1"), changed.at("/courts/1"));
    execute("UPDATE location SET name='Renamed County' WHERE code='court'");
    assertNotEquals(changed.at("/courts/0/revision"), manifest().at("/courts/0/revision"));
  }

  @Test
  void incompleteActiveCourtRejectsTheManifest() throws Exception {
    execute("DELETE FROM installedversion WHERE location='court' AND codelist='filingcodes.zip'");
    assertThrows(SQLException.class, this::manifest);
  }

  @Test
  void exportPreservesRelationshipsAndExcludesInternalAndForeignCodes() throws Exception {
    JsonNode data = catalog("court").orElseThrow();
    assertEquals(1, data.get("categories").size());
    assertEquals(2, data.get("case_types").size());
    assertEquals(3, data.get("filing_types").size());
    assertEquals("eviction", data.at("/filing_types/2/case_type").asText());
    assertTrue(data.at("/filing_types/2/case_category").isNull());
    assertTrue(data.at("/case_types/1/initial").asBoolean());
    assertEquals(manifest().at("/courts/0"), data.get("court"));
    assertTrue(catalog("missing").isEmpty());
  }
}
