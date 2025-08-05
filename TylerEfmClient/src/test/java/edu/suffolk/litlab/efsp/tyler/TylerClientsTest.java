package edu.suffolk.litlab.efsp.tyler;

import static org.assertj.core.api.Assertions.assertThat;

import static edu.suffolk.litlab.efsp.tyler.TylerJurisdiction.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("TylerBreakable")
public class TylerClientsTest {

  @Test
  public void allFactoriesShouldNotThrow() {
    for (var jurisdiction :
        List.of(TEXAS, MASSACHUSETTS, ILLINOIS, INDIANA, CALIFORNIA)) {
      for (TylerEnv env : TylerEnv.values()) {
        assertThat(TylerClients.getEfmFirmFactory(jurisdiction, env)).isNotNull();
        assertThat(TylerClients.getEfmUserFactory(jurisdiction, env)).isNotNull();
      }
    }
    assertThat(TylerClients.getEfmUserFactory(MASSACHUSETTS, TylerEnv.PROD)).isNotEmpty();
    assertThat(TylerClients.getEfmUserFactory(ILLINOIS, TylerEnv.STAGE)).isNotEmpty();
  }

  @Test
  public void testJurisdictionEnvUrls() throws IOException, URISyntaxException {
    testJurisdictionEnvUrl(
        "https://texas-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(TEXAS, TylerEnv.STAGE));
    testJurisdictionEnvUrl(
        "https://texas.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(TEXAS, TylerEnv.PROD));
    testJurisdictionEnvUrl(
        "https://massachusetts-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(MASSACHUSETTS, TylerEnv.STAGE));
    testJurisdictionEnvUrl(
        "https://massachusetts.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(MASSACHUSETTS, TylerEnv.PROD));
    testJurisdictionEnvUrl(
        "https://illinois-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(ILLINOIS, TylerEnv.STAGE));
    testJurisdictionEnvUrl(
        "https://illinois.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(ILLINOIS, TylerEnv.PROD));
  }

  public void testJurisdictionEnvUrl(String urlExpected, String urlGenerated)
      throws IOException, URISyntaxException {
    assertThat(urlGenerated).isEqualTo(urlExpected);
    URL url = (new URI(urlGenerated)).toURL();
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    int resp = conn.getResponseCode();
    assertThat(resp)
        .withFailMessage(
            "The generated URL (<%s>) returns an invalid HTTP error code: <%s>", urlGenerated, resp)
        .isLessThan(400);
  }
}
