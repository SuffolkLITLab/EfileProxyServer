package edu.suffolk.litlab.efsp.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.db.model.NewTokens;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@Tag("Docker")
public class LoginDatabaseTest {
  private static final Logger log = LoggerFactory.getLogger(LoginDatabaseTest.class);

  private LoginDatabase ld;

  @Container
  public PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));

  @BeforeEach
  public void setUp() throws SQLException, NoSuchAlgorithmException {
    postgres.start();
    Connection conn =
        DatabaseCreator.makeSingleConnection(
            postgres.getDatabaseName(),
            postgres.getJdbcUrl(),
            postgres.getUsername(),
            postgres.getPassword());
    ld = new LoginDatabase(conn);
  }

  @AfterEach
  public void tearDown() throws SQLException {
    ld.close();
  }

  @Test
  public void testFromNothing() throws SQLException {
    ld.createTablesIfAbsent();
    String cantDoAnything = ld.addNewUser("cantDoAnything", false, false);
    String tylerOnly = ld.addNewUser("tylerOnly", true, false);
    String everything = ld.addNewUser("everything", true, true);
    Map<String, Function<JsonNode, Optional<Map<String, String>>>> okFunctions =
        Map.of(
            "tyler",
                (info) -> Optional.of(Map.of("tyler_token", "tylerTOKEN", "tyler_id", "12345")),
            "jeffnet", (info) -> Optional.of(Map.of("jeffnet_token", "jeffNetToken123")));

    assertTrue(ld.login("fakeKey", "", okFunctions).isEmpty());
    // Do nothing should still succeed login (they can ping our codes API)
    var doNothing = ld.login(cantDoAnything, "{}", okFunctions);
    assertTrue(doNothing.isPresent());
    assertTrue(doNothing.get().getTokens().isEmpty());

    log.info("TylerOnly key: " + tylerOnly);
    Optional<NewTokens> activeTyler = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertTrue(activeTyler.isPresent());
    Optional<NewTokens> repeatLogin = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertTrue(repeatLogin.isPresent());
    assertEquals(activeTyler.get(), repeatLogin.get());

    Optional<NewTokens> activeEverything =
        ld.login(everything, "{\"tyler\": {}, \"jeffnet\": {}}", okFunctions);
    assertTrue(activeEverything.isPresent());
  }
}
