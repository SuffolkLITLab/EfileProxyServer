package edu.suffolk.litlab.efspserver.services;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;

public interface EfmRestCallbackInterface {
  
  public Response statusCallback(HttpHeaders httpHeaders, String statusResport);
  
}
