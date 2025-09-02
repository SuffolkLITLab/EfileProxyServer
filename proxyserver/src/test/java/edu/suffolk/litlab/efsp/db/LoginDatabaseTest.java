package edu.suffolk.litlab.efsp.db;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.db.model.NewTokens;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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

  private static final String TYLER_TOKEN = "tylerTOKEN";
  private static final String JEFFNET_TOKEN = "jeffNetToken123";
  private Map<String, Function<JsonNode, Optional<Map<String, String>>>> okFunctions =
      Map.of(
          "tyler", (info) -> Optional.of(Map.of("tyler_token", TYLER_TOKEN, "tyler_id", "12345")),
          "jeffnet", (info) -> Optional.of(Map.of("jeffnet_token", JEFFNET_TOKEN)));

  @Container
  public static PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));

  @BeforeAll
  public static void dbSetup() {
    postgres.start();
  }

  @BeforeEach
  public void setUp() throws SQLException {
    Connection conn =
        DatabaseCreator.makeSingleConnection(
            postgres.getDatabaseName(),
            postgres.getJdbcUrl(),
            postgres.getUsername(),
            postgres.getPassword());
    ld = new LoginDatabase(conn);
    ld.createTablesIfAbsent();
  }

  @AfterEach
  public void tearDown() throws SQLException {
    ld.close();
  }

  @Test
  public void testNoOp() throws SQLException {
    String cantDoAnything = ld.addNewUser("cantDoAnything", false, false);

    assertThat(ld.login("fakeKey", "", okFunctions)).isEmpty();
    // Do nothing should still succeed login (they can ping our codes API)
    var doNothing = ld.login(cantDoAnything, "{}", okFunctions);
    assertThat(doNothing).isPresent();
    assertThat(doNothing.get().getTokens()).isEmpty();

    var inactiveTyler = ld.login(cantDoAnything, "{\"tyler\": {}}", okFunctions);
    assertThat(inactiveTyler).isEmpty();
  }

  @Test
  public void testTylerLogin() throws SQLException {
    String tylerOnly = ld.addNewUser("tylerOnly", true, false);

    log.info("TylerOnly key: {}", tylerOnly);
    Optional<NewTokens> activeTyler = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertThat(activeTyler).isPresent();
    Optional<NewTokens> repeatLogin = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertThat(repeatLogin).isPresent();
    assertThat(activeTyler.get()).isEqualTo(repeatLogin.get());

    Optional<NewTokens> withJeffnet =
        ld.login(tylerOnly, "{\"tyler\": {}, \"jeffnet\": {}}", okFunctions);
    assertThat(withJeffnet).isEmpty();

    Optional<NewTokens> withUnsupported =
        ld.login(tylerOnly, "{\"tyler\": {}, \"unsupported\": {}}", okFunctions);
    assertThat(withUnsupported).isEmpty();
  }

  @Test
  public void testEverything() throws SQLException {
    String everything = ld.addNewUser("everything", true, true);
    Optional<NewTokens> activeEverything =
        ld.login(everything, "{\"tyler\": {}, \"jeffnet\": {}}", okFunctions);
    assertThat(activeEverything).isPresent();
    var tokens = activeEverything.get().getTokens();
    assertThat(tokens.get("tyler_token")).isEqualTo(TYLER_TOKEN);
    assertThat(tokens.get("jeffnet_token")).isEqualTo(JEFFNET_TOKEN);
  }
}
