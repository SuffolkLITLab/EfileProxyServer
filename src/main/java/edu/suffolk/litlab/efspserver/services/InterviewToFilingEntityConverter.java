package edu.suffolk.litlab.efspserver.services;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.FilingInformation;

public abstract class InterviewToFilingEntityConverter {
  
  public Result<FilingInformation, ExtractError> extractEntities(String interviewContents) {
    FailFastCollector collector = new FailFastCollector();
    return traverseInterview(interviewContents, collector);
  }
  
  public void findMissing(String interviewContents, InfoCollector collector) {
    traverseInterview(interviewContents, collector);
    return;
  }
  
  protected abstract Result<FilingInformation, ExtractError> 
      traverseInterview(String interviewContents, InfoCollector collector);
}
