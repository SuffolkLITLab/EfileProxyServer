package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

public interface EfmFilingInterface {
  public enum ApiChoice {
    FileApi,
    ServiceApi;
  };
  
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
  public Result<List<UUID>, FilingError> sendFiling(FilingInformation info, String apiToken, ApiChoice choice);
  
  public Result<NullValue, FilingError> checkFiling(FilingInformation info, String apiToken, InfoCollector collector);
  
  public Result<Response, FilingError> getFilingFees(FilingInformation info, String apiToken);

  public Result<Response, FilingError> getServiceTypes(FilingInformation info, String apiToken);
  
  // TODO(brycew-later): make this a little more independent of HTTP
  public Response getFilingList(String courtId, String submitterId, LocalDate startDate, 
      LocalDate endDate, String apiToken); 
  
  public Response getFilingStatus(String courtId, String filingId, String apiToken);
  
  public Response getFilingDetails(String courtId, String filingId, String apiToken);

  public Response getFilingService(String courtId, String filingId, String contactId, String apiToken);

  public Response getPolicy(String courtId, String apiToken);
  
  public Response cancelFiling(String courtId, String filingId, String apiToken);
  
  /** TYLER ONLY at the moment: returns a list of disclaimers that must be shown to the user
   * before filing.
   * @param courtId The court location Id where the filing is taking place
   * @return A response, that has a JSON list of the disclaimer information (code, name, listorder, text)
   */
  public Response disclaimers(String courtId);
  
  /** Used to properly verify with the SecurityHub. */
  public String getOrgName();

  /** Used to get the proper header that contains the right token. */
  public String getHeaderKey();
}
