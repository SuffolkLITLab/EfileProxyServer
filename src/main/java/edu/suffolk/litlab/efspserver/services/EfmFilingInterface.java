package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import tyler.efm.services.schema.common.ErrorType;

public interface EfmFilingInterface {
  /**
   * Actually sends the filing information to the EFM if it can.
   * @param info All of the information, parsed from an InterviewToFilingEntityConverter
   * @return Either a list of UUIDs for each filing actually made to the
   *   EFM, or an error if it couldn't make the filing.
   *   The list is because a single filing can include child envelopes or child
   *   filings, or just need to be split up into multiple filings. We shouldn't care
   *   about how that split happens, we just need to know the UUIDs for each of the filings
   *   for the callbacks. If it's > 1, should be the same number as the FilingDocs in info
   */
  public Result<List<UUID>, ErrorType> sendFiling(FilingInformation info);
  
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
