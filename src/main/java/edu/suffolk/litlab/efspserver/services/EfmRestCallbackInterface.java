package edu.suffolk.litlab.efspserver.services;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public interface EfmRestCallbackInterface {

  public Response statusCallback(HttpHeaders httpHeaders, String statusResport);
}
