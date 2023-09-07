package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;

public class SoapClientChooserTest {
  
  public void testJurisdictionEnvUrl(String urlExpected, String urlGenerated) throws IOException {
    assertEquals(urlExpected, urlGenerated);
    URL url = new URL(urlGenerated);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    int resp = conn.getResponseCode();
    assertTrue("The generated URL (" + urlGenerated + ") returns an invalid HTTP error code: " + Integer.toString(resp), resp < 400);
  }

  @Test
  public void testJurisdictionEnvUrls() throws IOException {
    testJurisdictionEnvUrl("https://texas-stage.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("texas", "stage"));
    testJurisdictionEnvUrl("https://texas.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("texas", "prod"));
    testJurisdictionEnvUrl("https://massachusetts-stage.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("massachusetts", "stage"));
    testJurisdictionEnvUrl("https://massachusetts.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("massachusetts", "prod"));
    testJurisdictionEnvUrl("https://illinois-stage.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("illinois", "stage"));
    testJurisdictionEnvUrl("https://illinois.tylerhost.net/", SoapClientChooser.getCodeEndpointRootUrl("illinois", "prod"));
  }
}