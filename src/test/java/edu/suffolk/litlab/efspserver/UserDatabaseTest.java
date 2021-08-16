package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.postgresql.ds.common.BaseDataSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import edu.suffolk.litlab.efspserver.db.Transaction;
import edu.suffolk.litlab.efspserver.db.UserDatabase;

public class UserDatabaseTest {
  
  private UserDatabase ud;
  
  @Container
  public PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));
  
  /** Start's the Container and creates the UserDatabase. 
   * More info on the TestContainer Library at: https://www.testcontainers.org/,
   * it's pretty nice.
   */
  @BeforeEach 
  public void setUp() throws SQLException {
    postgres.start();
    ud = new UserDatabase(postgres.getJdbcUrl(), postgres.getDatabaseName());
    ud.createDbConnection(postgres.getUsername(), postgres.getPassword());
  }

  @Test
  public void testSimpleContainer() throws SQLException {
    BaseDataSource ds = new PGSimpleDataSource();
    ds.setUrl(postgres.getJdbcUrl()); 
    ds.setUser(postgres.getUsername());
    ds.setPassword(postgres.getPassword());
    ds.setDatabaseName(postgres.getDatabaseName());
    Connection conn = ds.getConnection();
    Statement statement = conn.createStatement();
    statement.execute("SELECT 1");
    ResultSet result = statement.getResultSet();
    assertTrue(result.next());
    assertEquals(result.getInt(1), 1);
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
        "Motion to File", courtId, new Timestamp(System.currentTimeMillis()));
    ud.commit();
    
    Optional<Transaction> transaction = ud.findTransaction(transactionId);
    assertTrue(transaction.isPresent());
    assertEquals(transaction.get().email, email);
    assertTrue(transaction.get().phoneNumber.isEmpty());
    assertEquals(transaction.get().name, name);
    assertEquals(transaction.get().serverId, serverId);
    assertEquals(transaction.get().courtId, courtId);
    
    ud.removeFromTable(transactionId);
    transaction = ud.findTransaction(transactionId);
    assertTrue(transaction.isEmpty());
  }

}
