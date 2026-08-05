package edu.suffolk.litlab.efsp.truefiling;

import edu.suffolk.litlab.efsp.Jurisdiction;

public record TrueFilingDomain(Jurisdiction jurisdiction, TrueFilingEnv env) {
  public String getName() {
    return jurisdiction.getName() + "-" + env.getName();
  }
}
