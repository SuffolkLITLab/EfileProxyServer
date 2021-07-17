package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import java.util.UUID;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import tyler.efm.services.schema.common.ErrorType;

public interface EfmFilingInterface {
  public Result<UUID, ErrorType> sendFiling(FilingInformation info);
  
  // TODO(brycew): make this a little more independent of HTTP
  public Response getFilingList(String courtId, HttpHeaders httpHeaders); 
  
  public Response getFilingStatus(String courtId, String filingId, HttpHeaders httpHeaders);
  
  public String getApiKey();
  
  // TODO(brycew): how to phrase checkFiling on the filing side
  
  // TODO(brycew): all the other ones, including
  // * submitFilingForReview
  // * getFilingDetails
  // * cancelFiling
  // * setupFilingPort
}
