package edu.suffolk.litlab.efsp.utils;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.model.FilingInformation;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;

public abstract class InterviewToFilingInformationConverter {

  public Result<FilingInformation, FilingError> extractInformation(
      String interviewContents, CodesParser parser) {
    FailFastCollector collector = new FailFastCollector();
    return traverseInterview(interviewContents, parser, collector);
  }

  public abstract Result<FilingInformation, FilingError> traverseInterview(
      String interviewContents, CodesParser parser, InfoCollector collector);
}
