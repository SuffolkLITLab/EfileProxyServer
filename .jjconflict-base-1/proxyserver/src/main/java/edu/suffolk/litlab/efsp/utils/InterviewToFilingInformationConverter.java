package edu.suffolk.litlab.efsp.utils;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.model.FilingInformation;

public abstract class InterviewToFilingInformationConverter {

  public Result<FilingInformation, FilingError> extractInformation(String interviewContents) {
    FailFastCollector collector = new FailFastCollector();
    return traverseInterview(interviewContents, collector);
  }

  public abstract Result<FilingInformation, FilingError> traverseInterview(
      String interviewContents, InfoCollector collector);
}
