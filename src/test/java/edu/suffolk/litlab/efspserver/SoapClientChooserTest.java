package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SoapClientChooserTest {
  
  @Test
  public void testJurisdictionEnvUrls() {
    assertEquals("https://texas-stage.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("texas", "stage"));
    assertEquals("https://texas.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("texas", "prod"));
    assertEquals("https://massachusetts-stage.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("massachusetts", "stage"));
    assertEquals("https://massachusetts.tylerhost.net/", SoapClientChooser.getCodeEndpointRootUrl("massachusetts", "prod"));
    assertEquals("https://illinois-stage.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("illinois", "stage"));
    assertEquals("https://illinois.tylertech.cloud/", SoapClientChooser.getCodeEndpointRootUrl("illinois", "prod"));
  }
}