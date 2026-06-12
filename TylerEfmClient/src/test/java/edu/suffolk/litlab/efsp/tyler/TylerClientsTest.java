package edu.suffolk.litlab.efsp.tyler;

import static edu.suffolk.litlab.efsp.Jurisdiction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ServerEnv;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

@Tag("TylerBreakable")
public class TylerClientsTest {

  private static MockedStatic<ServerEnv> serverEnv;

  @BeforeAll
  static void startUp() {
    serverEnv = Mockito.mockStatic(ServerEnv.class);
    ServerEnv[] envs = {ServerEnv.PROD, ServerEnv.TEST};
    when(ServerEnv.values()).thenReturn(envs);
  }

  @AfterAll
  static void shutdown() {
    serverEnv.close();
  }

  @Test
  public void allFactoriesShouldNotThrow() {
    for (ServerEnv env : ServerEnv.values()) {
      when(ServerEnv.fromEnvVar()).thenReturn(env);
      for (Jurisdiction jurisdiction :
          List.of(TEXAS, MASSACHUSETTS, ILLINOIS, INDIANA, CALIFORNIA, VERMONT)) {
        assertThat(TylerClients.getEfmFirmFactory(jurisdiction)).isNotNull();
        assertThat(TylerClients.getEfmUserFactory(jurisdiction)).isNotNull();
      }
    }
    when(ServerEnv.fromEnvVar()).thenReturn(ServerEnv.PROD);
    assertThat(TylerClients.getEfmUserFactory(MASSACHUSETTS)).isNotEmpty();
    when(ServerEnv.fromEnvVar()).thenReturn(ServerEnv.TEST);
    assertThat(TylerClients.getEfmUserFactory(ILLINOIS)).isNotEmpty();
  }

  @Test
  public void testJurisdictionEnvUrls() throws IOException, URISyntaxException {
    when(ServerEnv.fromEnvVar()).thenReturn(ServerEnv.TEST);
    testJurisdictionEnvUrl(
        "https://texas-stage.tylertech.cloud/", TylerClients.getTylerServerRootUrl(TEXAS));
    testJurisdictionEnvUrl(
        "https://massachusetts-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(MASSACHUSETTS));
    testJurisdictionEnvUrl(
        "https://illinois-stage.tylertech.cloud/", TylerClients.getTylerServerRootUrl(ILLINOIS));

    when(ServerEnv.fromEnvVar()).thenReturn(ServerEnv.PROD);
    testJurisdictionEnvUrl(
        "https://texas.tylertech.cloud/", TylerClients.getTylerServerRootUrl(TEXAS));
    testJurisdictionEnvUrl(
        "https://massachusetts.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(MASSACHUSETTS));
    testJurisdictionEnvUrl(
        "https://illinois.tylertech.cloud/", TylerClients.getTylerServerRootUrl(ILLINOIS));
  }

  private void testJurisdictionEnvUrl(String urlExpected, String urlGenerated)
      throws IOException, URISyntaxException {
    assertThat(urlGenerated).isEqualTo(urlExpected);
    URL url = (new URI(urlGenerated)).toURL();
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    int resp = conn.getResponseCode();
    assertThat(resp)
        .withFailMessage(
            "The generated URL (<%s>) returns an invalid HTTP error code: <%s>", urlGenerated, resp)
        .matches(
            status -> status < 400 || status == 503); // Sometimes Tyler's stage servers are down
  }
}
