package edu.suffolk.litlab.efspserver;

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
}
