package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;
import java.util.UUID;
import tyler.efm.services.schema.common.ErrorType;

public interface EfmFilingInterface {
  public Result<UUID, ErrorType> sendFiling(FilingInformation info);
}
