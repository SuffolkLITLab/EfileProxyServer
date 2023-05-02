package edu.suffolk.litlab.efspserver.services;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

public interface CodesService {

  public Response getAll();

  public Response getCourts(HttpHeaders httpHeaders, boolean fileable, boolean withNames);

  public Response getCodesUnderCourt(String courtId);

  public Response getCourtLocationCodes(String courtId);
}
