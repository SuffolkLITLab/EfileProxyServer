package edu.suffolk.litlab.efsp.tyler;


import static org.assertj.core.api.Assertions.assertThat;

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
        for (String jurisdiction: List.of("texas", "massachusetts", "illinois", "indiana", "california", "wales")) {
            for (TylerEnv env: TylerEnv.values()) {
                assertThat(TylerClients.getEfmFirmFactory(jurisdiction, env)).isNotNull();
                assertThat(TylerClients.getEfmUserFactory(jurisdiction, env)).isNotNull();
            }
        }
        assertThat(TylerClients.getEfmUserFactory("texas", TylerEnv.TEST)).isEmpty();
        assertThat(TylerClients.getEfmUserFactory("massachusetts", TylerEnv.PROD)).isNotEmpty();
        assertThat(TylerClients.getEfmUserFactory("illinois", TylerEnv.STAGE)).isNotEmpty();
    }

  @Test
  public void testJurisdictionEnvUrls() throws IOException, URISyntaxException{
    testJurisdictionEnvUrl("https://texas-stage.tylertech.cloud/", TylerClients.getTylerServerRootUrl("texas", TylerEnv.STAGE));
    testJurisdictionEnvUrl("https://texas.tylertech.cloud/", TylerClients.getTylerServerRootUrl("texas", TylerEnv.PROD));
    testJurisdictionEnvUrl("https://massachusetts-stage.tylertech.cloud/", TylerClients.getTylerServerRootUrl("massachusetts", TylerEnv.STAGE));
    testJurisdictionEnvUrl("https://massachusetts.tylertech.cloud/", TylerClients.getTylerServerRootUrl("massachusetts", TylerEnv.PROD));
    testJurisdictionEnvUrl("https://illinois-stage.tylertech.cloud/", TylerClients.getTylerServerRootUrl("illinois", TylerEnv.STAGE));
    testJurisdictionEnvUrl("https://illinois.tylertech.cloud/", TylerClients.getTylerServerRootUrl("illinois", TylerEnv.PROD));
  }

  public void testJurisdictionEnvUrl(String urlExpected, String urlGenerated) throws IOException, URISyntaxException {
    assertThat(urlGenerated).isEqualTo(urlExpected);
    URL url = (new URI(urlGenerated)).toURL();
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    int resp = conn.getResponseCode();
    assertThat(resp).withFailMessage("The generated URL ({}) returns an invalid HTTP error code: {}", urlGenerated, resp).isLessThan(400);
  }
}
