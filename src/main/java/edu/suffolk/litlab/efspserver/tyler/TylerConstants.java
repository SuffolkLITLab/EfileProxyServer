package edu.suffolk.litlab.efspserver.tyler;

import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class TylerConstants {
  // This is the amount that we take as a cut.
  public static BigDecimal ourCut = new BigDecimal("0.00");

  public static Map<String, BigDecimal> jurisdictionToTax =
      Map.of(
          "illinois", new BigDecimal("0.0625"),
          "massachusetts", new BigDecimal("0.0625"),
          "texas", new BigDecimal("0.0825"));

  public static String documentToStr(
      Optional<String> documentDescription,
      Optional<String> fileName,
      Optional<String> reviewComments,
      Optional<String> rejectedReason,
      CourtLocationInfo courtInfo) {
    StringBuilder docText = new StringBuilder();

    if (documentDescription.isEmpty() && reviewComments.isEmpty() && rejectedReason.isEmpty()) {
      docText.append(
          fileName
              .map(name -> "The review was about the document with file name " + name)
              .orElse(""));
    } else {
      docText.append(
          documentDescription.map(desc -> "The document (" + desc + ") ").orElse("The document"));
      docText.append(fileName.map(name -> "with file name " + name).orElse(""));
      docText.append(
          reviewComments
              .map(comment -> " has the following review comments: " + comment)
              .orElse(""));
      docText.append(
          rejectedReason
              .map(
                  reason -> {
                    if (courtInfo.showreturnonreject) {
                      return ", was returned for the following reason: " + reason;
                    } else {
                      return ", was rejected for the following reason: " + reason;
                    }
                  })
              .orElse(""));
    }

    if (docText.length() > 0) {
      docText.append(".");
      if (!docText.substring(0, 12).equals("The document")) {
        docText.insert(0, "The document ");
      }
    }
    return docText.toString();
  }
}
