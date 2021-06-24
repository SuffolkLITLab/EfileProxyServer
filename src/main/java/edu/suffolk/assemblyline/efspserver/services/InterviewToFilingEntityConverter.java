package edu.suffolk.assemblyline.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.assemblyline.efspserver.FilingEntities;

public interface InterviewToFilingEntityConverter {
  
  public Result<FilingEntities, ExtractError> extractEntities(String interviewContents);
}
