package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;

import edu.suffolk.litlab.efspserver.FilingStuff;

public interface InterviewToFilingEntityConverter {
  
  public Result<FilingStuff, ExtractError> extractEntities(String interviewContents);
}
