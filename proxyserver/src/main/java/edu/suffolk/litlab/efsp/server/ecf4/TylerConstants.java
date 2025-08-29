package edu.suffolk.litlab.efsp.server.ecf4;

import edu.suffolk.litlab.efsp.tyler.TylerJurisdiction;
import java.math.BigDecimal;
import java.util.Map;

public class TylerConstants {
  // This is the amount that we take as a cut.
  public static BigDecimal ourCut = new BigDecimal("0.00");

  public static Map<TylerJurisdiction, BigDecimal> jurisdictionToTax =
      Map.of(
          TylerJurisdiction.ILLINOIS, new BigDecimal("0.0625"),
          TylerJurisdiction.MASSACHUSETTS, new BigDecimal("0.0625"),
          TylerJurisdiction.TEXAS, new BigDecimal("0.0825"));
}
