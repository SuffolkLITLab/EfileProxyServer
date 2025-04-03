package edu.suffolk.litlab.efspserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import edu.suffolk.litlab.efspserver.tyler.TylerUrls;

@Tag("TylerBreakable")
public class SoapClientChooserTest {
  
  public void testJurisdictionEnvUrl(String urlExpected, String urlGenerated) throws IOException {
    assertThat(urlGenerated).isEqualTo(urlExpected);
    URL url = new URL(urlGenerated);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    int resp = conn.getResponseCode();
    assertTrue(resp < 400, () -> "The generated URL (" + urlGenerated + ") returns an invalid HTTP error code: " + Integer.toString(resp));
  }

  @Test
  public void testJurisdictionEnvUrls() throws IOException {
    testJurisdictionEnvUrl("https://texas-stage.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("texas", "stage"));
    testJurisdictionEnvUrl("https://texas.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("texas", "prod"));
    testJurisdictionEnvUrl("https://massachusetts-stage.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("massachusetts", "stage"));
    testJurisdictionEnvUrl("https://massachusetts.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("massachusetts", "prod"));
    testJurisdictionEnvUrl("https://illinois-stage.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("illinois", "stage"));
    testJurisdictionEnvUrl("https://illinois.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("illinois", "prod"));
  }
}