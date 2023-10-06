package edu.suffolk.litlab.efspserver.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class UserDatabaseTest {
  
  private UserDatabase ud;
  
  @Container
  public PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));
  
  /** Start's the Container and creates the UserDatabase. 
   * More info on the TestContainer Library at: https://www.testcontainers.org/,
   * it's pretty nice.
   */
  @BeforeEach 
  public void setUp() throws SQLException {
    postgres.start();
    Connection conn = DatabaseCreator.makeSingleConnection(
        postgres.getDatabaseName(), postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
    ud = new UserDatabase(conn);
  }
  
  @AfterEach
  public void tearDown() throws SQLException {
    ud.close();
  }

  @Test
  public void testFromNothing() throws SQLException {
    UUID userId = UUID.randomUUID();
    UUID transactionId = UUID.randomUUID();
    UUID serverId = UUID.randomUUID();
    String name = "User1 McUserFace";
    String email = "test@example.com";
    String courtId = "jefferson";
    String apiKey = "abcdef12345";
    ud.createTablesIfAbsent();
    ud.addToTable(name, userId, 
        Optional.empty(), email, transactionId, serverId, apiKey,
        "Motion to File", courtId, new Timestamp(System.currentTimeMillis()),
        "", "", "", "", "", "", "my title", "2021ENVL");
    
    Optional<Transaction> transaction = ud.findTransaction(transactionId);
    assertTrue(transaction.isPresent());
    assertEquals(transaction.get().email, email);
    assertTrue(transaction.get().phoneNumber.isEmpty());
    assertEquals(transaction.get().name, name);
    assertEquals(transaction.get().serverId, serverId);
    assertEquals(transaction.get().courtId, courtId);
    assertEquals(transaction.get().caseTitle, "my title");
    
    ud.removeFromTable(transactionId);
    transaction = ud.findTransaction(transactionId);
    assertTrue(transaction.isEmpty());
  }

}
