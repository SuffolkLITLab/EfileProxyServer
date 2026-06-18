package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.tyler.ecfcodes.OptionalServiceCode;
import java.math.BigDecimal;
import java.util.Optional;

public record OptionalService(
    OptionalServiceCode code, Optional<Integer> multiplier, Optional<BigDecimal> feeAmount) {}
