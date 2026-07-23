package edu.suffolk.litlab.efsp.server.services.impl;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.FilingResult;
import edu.suffolk.litlab.efsp.server.services.api.EfmFilingInterface;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;

public abstract class EfmCheckableFilingInterface implements EfmFilingInterface {

  @Override
  public Result<FilingResult, FilingError> sendFiling(
      FilingInformation info, TylerUserNamePassword creds, String userUuid, ApiChoice choice) {
    FailFastCollector collector = new FailFastCollector();
    return submitFilingIfReady(info, collector, creds, userUuid, choice);
  }

  @Override
  public Result<NullValue, FilingError> checkFiling(
      FilingInformation info,
      TylerUserNamePassword creds,
      String userUuid,
      InfoCollector collector) {
    return submitFilingIfReady(info, collector, creds, userUuid, ApiChoice.FileApi)
        .mapOk(n -> null);
  }

  /**
   * Core logic behind {@link sendFiling} and {@link checkFiling}.
   *
   * @param info The Java intermediatary object with all filing info
   * @param collector The class that holds errors or missingVars
   * @return Same return type as {@link sendFiling}
   */
  public abstract Result<FilingResult, FilingError> submitFilingIfReady(
      FilingInformation info,
      InfoCollector collector,
      TylerUserNamePassword creds,
      String userUuid,
      ApiChoice choice);
}
