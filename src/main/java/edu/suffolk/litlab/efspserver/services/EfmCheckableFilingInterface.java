package edu.suffolk.litlab.efspserver.services;

import java.util.List;
import java.util.UUID;

import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.FilingInformation;

public abstract class EfmCheckableFilingInterface implements EfmFilingInterface {

  @Override
  public Result<List<UUID>, FilingError> sendFiling(FilingInformation info, String apiToken) {
    FailFastCollector collector = new FailFastCollector();
    return submitFilingIfReady(info, collector, apiToken);
  }

  @Override
  public void checkFiling(FilingInformation info, InfoCollector collector) {
    submitFilingIfReady(info, collector, "");
    return;
  }
  
  /**
   * Core logic behind {@link sendFiling} and {@link checkFiling}.
   * @param info The Java intermediatary object with all filing info
   * @param collector The class that holds errors or missingVars
   * @return Same return type as {@link sendFiling}
   */
  public abstract Result<List<UUID>, FilingError> submitFilingIfReady(
      FilingInformation info, InfoCollector collector, String apiToken);

}
