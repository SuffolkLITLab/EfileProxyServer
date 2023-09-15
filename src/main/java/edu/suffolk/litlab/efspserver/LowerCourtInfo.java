package edu.suffolk.litlab.efspserver;

import com.hubspot.algebra.Result;

public class LowerCourtInfo {
  public final String caseTitleText;
  public final String caseDocketId;
  public final String lowerCourtCode;
  public final String lowerCourtJudgeName;

  public LowerCourtInfo(
      String caseTitleText,
      String caseDocketId,
      String lowerCourtCode,
      String lowerCourtJudgeName) {
    this.caseTitleText = caseTitleText;
    this.caseDocketId = caseDocketId;
    this.lowerCourtCode = lowerCourtCode;
    this.lowerCourtJudgeName = lowerCourtJudgeName;
  }

  public static Result<LowerCourtInfo, String> makeLowerCourtInfo(
      String caseTitleText,
      String caseDocketId,
      String lowerCourtName,
      String lowerCourtJudgeName) {
    if (caseTitleText.length() > 5000) {
      return Result.err(
          "case title text cannot be longer that 5000 characters (is "
              + caseTitleText.length()
              + ")");
    }
    if (caseDocketId.length() > 30) {
      return Result.err(
          "Case docket id cannot be longer than 30 characters. (is " + caseDocketId.length() + ")");
    }
    if (lowerCourtName.length() > 30) {
      return Result.err(
          "Lower Court Name cannot be longer than 30 characters (is "
              + lowerCourtName.length()
              + ")");
    }
    if (lowerCourtJudgeName.length() > 150) {
      return Result.err(
          "Lower court judge name cannot be longer that 150 characters (is "
              + lowerCourtJudgeName.length()
              + ")");
    }
    return Result.ok(
        new LowerCourtInfo(caseTitleText, caseDocketId, lowerCourtName, lowerCourtJudgeName));
  }
}
