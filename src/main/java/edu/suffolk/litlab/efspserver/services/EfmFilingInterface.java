package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import tyler.efm.services.schema.common.ErrorType;

public interface EfmFilingInterface {
  public Result<NullValue, ErrorType> sendFiling(FilingInformation stuff);
}
