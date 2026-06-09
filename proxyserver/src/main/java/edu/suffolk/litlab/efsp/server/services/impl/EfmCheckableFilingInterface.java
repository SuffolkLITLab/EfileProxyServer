package edu.suffolk.litlab.efsp.server.services.impl;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.model.FilingResult;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import edu.suffolk.litlab.efsp.utils.FailFastCollector;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;

public abstract class EfmCheckableFilingInterface implements EfmFilingInterface {

  @Override
  public Result<FilingResult, FilingError> sendFiling(
      FilingInformation info, TylerUserNamePassword creds, ApiChoice choice) {
    FailFastCollector collector = new FailFastCollector();
    return submitFilingIfReady(info, collector, creds, choice);
  }

  @Override
  public Result<NullValue, FilingError> checkFiling(
      FilingInformation info, TylerUserNamePassword creds, InfoCollector collector) {
    return submitFilingIfReady(info, collector, creds, ApiChoice.FileApi).mapOk(n -> null);
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
      ApiChoice choice);
}
