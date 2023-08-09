package edu.suffolk.litlab.efspserver.tyler;

import java.math.BigDecimal;
import java.util.Map;

public class TylerConstants {
  // This is the amount that we take as a cut.
  public static BigDecimal ourCut = new BigDecimal("0.00");

  public static Map<String, BigDecimal> jurisdictionToTax =
      Map.of(
          "illinois", new BigDecimal("0.0625"),
          "massachusetts", new BigDecimal("0.0625"),
          "texas", new BigDecimal("0.0825"));
}
