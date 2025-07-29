package edu.suffolk.litlab.efsp.model;

import java.math.BigDecimal;
import java.util.Optional;

public class OptionalService {
  public final String code;
  public final Optional<Integer> multiplier;
  public final Optional<BigDecimal> feeAmount;

  public OptionalService(
      String code, Optional<Integer> multiplier, Optional<BigDecimal> feeAmount) {
    this.code = code;
    this.multiplier = multiplier;
    this.feeAmount = feeAmount;
  }
}
