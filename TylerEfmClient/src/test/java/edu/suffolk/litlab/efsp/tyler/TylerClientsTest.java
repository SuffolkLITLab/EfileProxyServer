package edu.suffolk.litlab.efsp.tyler;

import static edu.suffolk.litlab.efsp.Jurisdiction.*;
import static edu.suffolk.litlab.efsp.tyler.TylerEnv.*;
import static org.assertj.core.api.Assertions.assertThat;

import edu.suffolk.litlab.efsp.Jurisdiction;
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
    for (Jurisdiction jurisdiction :
        List.of(TEXAS, MASSACHUSETTS, ILLINOIS, INDIANA, CALIFORNIA, VERMONT)) {
      for (TylerEnv env : TylerEnv.values()) {
        var domain = new TylerDomain(jurisdiction, env);
        assertThat(TylerClients.getEfmFirmFactory(domain)).isNotNull();
        assertThat(TylerClients.getEfmUserFactory(domain)).isNotNull();
      }
    }
    assertThat(TylerClients.getEfmUserFactory(new TylerDomain(MASSACHUSETTS, TylerEnv.PROD)))
        .isNotEmpty();
    assertThat(TylerClients.getEfmUserFactory(new TylerDomain(ILLINOIS, TylerEnv.STAGE)))
        .isNotEmpty();
  }

  @Test
  public void testJurisdictionEnvUrls() throws IOException, URISyntaxException {
    testJurisdictionEnvUrl(
        "https://texas-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(new TylerDomain(TEXAS, STAGE)));
    testJurisdictionEnvUrl(
        "https://texas.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(new TylerDomain(TEXAS, PROD)));
    testJurisdictionEnvUrl(
        "https://massachusetts-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(new TylerDomain(MASSACHUSETTS, STAGE)));
    testJurisdictionEnvUrl(
        "https://massachusetts.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(new TylerDomain(MASSACHUSETTS, PROD)));
    testJurisdictionEnvUrl(
        "https://illinois-stage.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(new TylerDomain(ILLINOIS, STAGE)));
    testJurisdictionEnvUrl(
        "https://illinois.tylertech.cloud/",
        TylerClients.getTylerServerRootUrl(new TylerDomain(ILLINOIS, PROD)));
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
