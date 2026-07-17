package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import java.util.List;

// Seed list, pulled from docassemble-MotionToStayEviction's efiling.yml. Add more as they come up.
public class KnownCodeLookups {

  public static final List<MaintainedCodeCheck> ALL =
      List.of(
          new MaintainedCodeCheck(
              "massachusetts",
              "appeals:acsj",
              MaintainedCodeCheck.CodeTable.CASE_CATEGORY,
              List.of("Appeals Court Single Justice - Civil", "Civil"),
              "8151",
              "https://github.com/SuffolkLITLab/docassemble-MotionToStayEviction/blob/"
                  + "213bd40790525bb45fbc5b012c5649325c7e0bae/docassemble/MotionToStayEviction/"
                  + "data/questions/efiling.yml#L33-L34",
              null),
          new MaintainedCodeCheck(
              "massachusetts",
              "appeals:acsj",
              MaintainedCodeCheck.CodeTable.CASE_TYPE,
              List.of("MAC Rule 6.0"),
              "12644",
              "https://github.com/SuffolkLITLab/docassemble-MotionToStayEviction/blob/"
                  + "213bd40790525bb45fbc5b012c5649325c7e0bae/docassemble/MotionToStayEviction/"
                  + "data/questions/efiling.yml#L36-L38",
              "8151"));

  private KnownCodeLookups() {}
}
