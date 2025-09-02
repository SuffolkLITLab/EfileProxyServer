package edu.suffolk.litlab.efsp.db;

import static org.assertj.core.api.Assertions.assertThat;

import edu.suffolk.litlab.efsp.db.model.AtRest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@Tag("Docker")
public class LoginDatabaseTest {

  private LoginDatabase ld;

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
  public void checkBadApiKey() {
    assertThat(ld.getAtRestInfo("")).isEmpty();
    assertThat(ld.getAtRestInfo("fakeKey")).isEmpty();
  }

  @Test
  public void canEditServerInfo() throws SQLException {
    String apiKey = ld.addNewUser("this_name_is_no_good", false, false);

    Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
    assertThat(atRest).isPresent();
    assertThat(atRest.get().serverName).isEqualTo("this_name_is_no_good");

    ld.updateServerName(atRest.get(), apiKey, "good_name");
    Optional<AtRest> newAtRest = ld.getAtRestInfo(apiKey);
    assertThat(newAtRest).isPresent();
    assertThat(newAtRest.get().serverName).isEqualTo("good_name");
  }
}
