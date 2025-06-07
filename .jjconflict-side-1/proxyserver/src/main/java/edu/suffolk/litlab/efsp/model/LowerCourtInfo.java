package edu.suffolk.litlab.efsp.model;

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

  @Override
  public String toString() {
    return "[LowerCourtInfo: "
        + caseTitleText
        + ", "
        + caseDocketId
        + ", "
        + lowerCourtCode
        + ", "
        + lowerCourtJudgeName
        + "]";
  }
}
