package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.FilingInformation;

public interface InterviewToFilingEntityConverter {
  
  public Result<FilingInformation, ExtractError> extractEntities(String interviewContents);
}
