package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import java.util.UUID;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import tyler.efm.services.schema.common.ErrorType;

public interface EfmFilingInterface {
  public Result<UUID, ErrorType> sendFiling(FilingInformation info);
  
  public void checkFiling(FilingInformation info, InfoCollector collector);
  
  // TODO(brycew): make this a little more independent of HTTP
  public Response getFilingList(String courtId, HttpHeaders httpHeaders); 
  
  public Response getFilingStatus(String courtId, String filingId, HttpHeaders httpHeaders);
  
  public Response getFilingDetails(String courtId, String filingId, HttpHeaders httpHeaders);
  
  public Response cancelFiling(String courtId, String filingId, HttpHeaders httpHeaders);
  
  // Used if there is some specific API Key that is needed for this interface to work.
  // Used to save it in the UserDatabase so it can be used by the Callback 
  public String getApiKey();
}
