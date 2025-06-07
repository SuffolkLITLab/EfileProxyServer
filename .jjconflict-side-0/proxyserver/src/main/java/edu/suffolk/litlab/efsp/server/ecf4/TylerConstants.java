package edu.suffolk.litlab.efsp.server.ecf4;

import edu.suffolk.litlab.efsp.Jurisdiction;
import java.math.BigDecimal;
import java.util.Map;

public class TylerConstants {
  // This is the amount that we take as a cut.
  public static BigDecimal ourCut = new BigDecimal("0.00");

  public static Map<Jurisdiction, BigDecimal> jurisdictionToTax =
      Map.of(
          Jurisdiction.ILLINOIS, new BigDecimal("0.0625"),
          Jurisdiction.MASSACHUSETTS, new BigDecimal("0.0625"),
          Jurisdiction.TEXAS, new BigDecimal("0.0825"));
}
