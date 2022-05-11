package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
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
    Connection conn = DatabaseCreator.makeSingleConnection(
        postgres.getDatabaseName(), postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
    ld = new LoginDatabase(conn); 
  }
  
  @AfterEach
  public void tearDown() throws SQLException {
    ld.getConnection().close();
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
    // If nothing can login, it will fail. Not if it should be a failure, but it is confusing from the user perspective.
    // Will keep it like this until we actively are hiding most of our functionality behind the API
    assertTrue(ld.login(cantDoAnything, "{}", okFunctions).isEmpty());
    
    Optional<NewTokens> activeTyler = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertTrue(activeTyler.isPresent());
    Optional<NewTokens> repeatLogin = ld.login(tylerOnly, "{\"tyler\": {}}", okFunctions);
    assertTrue(repeatLogin.isPresent());
    assertEquals(activeTyler.get(), repeatLogin.get());
    
    Optional<NewTokens> activeEverything = ld.login(everything, "{\"tyler\": {}, \"jeffnet\": {}}", okFunctions);
    assertTrue(activeEverything.isPresent());
  }
  
}
