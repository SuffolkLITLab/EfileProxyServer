package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.db.LoginDatabase;

public class LoginDatabaseTest {

  private LoginDatabase ld;
  
  @Container
  public PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));
  
  @BeforeEach
  public void setUp() throws SQLException {
    postgres.start();
    ld = new LoginDatabase(postgres.getJdbcUrl(), postgres.getDatabaseName());
    ld.createDbConnection(postgres.getUsername(), postgres.getPassword());
  }
  
  @Test
  public void testFromNothing() throws SQLException {
    ld.createTablesIfAbsent();
    String cantDoAnything = ld.addNewUser("cantDoAnything", false, false);
    // TODO(brycew): how does JUnit handle excepts? Try add new with null
    String tylerOnly = ld.addNewUser("tylerOnly", true, false);
    String jeffNetOnly = ld.addNewUser("jeffNetOnly", false, true);
    String everything = ld.addNewUser("everything", true, true);
    Map<String, Function<JsonNode, Optional<Map<String, String>>>> okFunctions = Map.of(
        "tyler", (info) -> Optional.of(Map.of("tyler_token", "tylerTOKEN", "tyler_id", "12345")),
        "jeffnet", (info) -> Optional.of(Map.of("jeffnet_token", "jeffNetToken123")));

    assertTrue(ld.checkLogin(null, null).isEmpty());
    assertTrue(ld.checkLogin(jeffNetOnly, "jeffnet").isEmpty());
    assertTrue(ld.login("fakeKey", "", okFunctions).isEmpty());
    
    Optional<String> activeCantDoAnything = ld.login(cantDoAnything, "{}", okFunctions);
    assertTrue(activeCantDoAnything.isPresent());
    Optional<String> repeatLogin = ld.login(cantDoAnything, "{}", okFunctions);
    assertTrue(repeatLogin.isPresent());
    assertEquals(activeCantDoAnything.get(), repeatLogin.get());
    assertTrue(ld.checkLogin(activeCantDoAnything.get(), "tyler").isEmpty());
    
    Optional<String> activeTyler = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertTrue(activeTyler.isPresent());
    assertTrue(ld.checkLogin(activeTyler.get(), "tyler").isPresent());
    assertTrue(ld.checkLogin(activeTyler.get(), "jeffnet").isEmpty());
    
    Optional<String> activeEverything = ld.login(everything, "{\"tyler\": {}, \"jeffnet\": {}}", okFunctions);
    assertTrue(activeEverything.isPresent());
    assertTrue(ld.checkLogin(activeEverything.get(), "tyler").isPresent());
    assertTrue(ld.checkLogin(activeEverything.get(), "jeffnet").isPresent());
    // TODO(brycew): revoke user?
  }
  
}
