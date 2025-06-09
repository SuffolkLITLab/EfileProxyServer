package edu.suffolk.litlab.efspserver.services;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

public interface EfmRestCallbackInterface {

  public Response statusCallback(HttpHeaders httpHeaders, String statusResport);
}
