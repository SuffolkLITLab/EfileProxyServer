package edu.suffolk.litlab.efsp.server.setup;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

public interface EfmRestCallbackInterface {

  public Response statusCallback(HttpHeaders httpHeaders, String statusResport);
}
