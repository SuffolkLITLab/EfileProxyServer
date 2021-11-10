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
import edu.suffolk.litlab.efspserver.db.NewTokens;

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
    String tylerOnly = ld.addNewUser("tylerOnly", true, false);
    String everything = ld.addNewUser("everything", true, true);
    Map<String, Function<JsonNode, Optional<Map<String, String>>>> okFunctions = Map.of(
        "tyler", (info) -> Optional.of(Map.of("tyler_token", "tylerTOKEN", "tyler_id", "12345")),
        "jeffnet", (info) -> Optional.of(Map.of("jeffnet_token", "jeffNetToken123")));

    assertTrue(ld.login("fakeKey", "", okFunctions).isEmpty());
    
    Optional<NewTokens> activeCantDoAnything = ld.login(cantDoAnything, "{}", okFunctions);
    assertTrue(activeCantDoAnything.isPresent());
    Optional<NewTokens> repeatLogin = ld.login(cantDoAnything, "{}", okFunctions);
    assertTrue(repeatLogin.isPresent());
    assertEquals(activeCantDoAnything.get(), repeatLogin.get());
    
    Optional<NewTokens> activeTyler = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertTrue(activeTyler.isPresent());
    
    Optional<NewTokens> activeEverything = ld.login(everything, "{\"tyler\": {}, \"jeffnet\": {}}", okFunctions);
    assertTrue(activeEverything.isPresent());
  }
  
}
