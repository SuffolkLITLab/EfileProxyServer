package edu.suffolk.litlab.efspserver.tyler;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SoapClientChooserTest {
  
  @Test
  public void testJurisdictionEnvUrls() {
    assertEquals("https://texas-stage.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("texas", "stage"));
    assertEquals("https://texas.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("texas", "prod"));
    assertEquals("https://massachusetts-stage.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("massachusetts", "stage"));
    assertEquals("https://massachusetts.tylerhost.net/", TylerUrls.getCodeEndpointRootUrl("massachusetts", "prod"));
    assertEquals("https://illinois-stage.tylertech.cloud/", TylerUrls.getCodeEndpointRootUrl("illinois", "stage"));
    assertEquals("https://illinois.tylerhost.net/", TylerUrls.getCodeEndpointRootUrl("illinois", "prod"));
  }
}