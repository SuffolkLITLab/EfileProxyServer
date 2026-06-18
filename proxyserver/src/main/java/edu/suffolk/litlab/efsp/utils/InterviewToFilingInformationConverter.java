package edu.suffolk.litlab.efsp.utils;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.ecfcodes.CodesParser;
import edu.suffolk.litlab.efsp.model.FilingInformation;

public abstract class InterviewToFilingInformationConverter {

  public Result<FilingInformation, FilingError> extractInformation(
      String interviewContents, CodesParser parser) {
    FailFastCollector collector = new FailFastCollector();
    return traverseInterview(interviewContents, parser, collector);
  }

  public abstract Result<FilingInformation, FilingError> traverseInterview(
      String interviewContents, CodesParser parser, InfoCollector collector);
}
