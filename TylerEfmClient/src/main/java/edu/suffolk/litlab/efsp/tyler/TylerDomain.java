package edu.suffolk.litlab.efsp.tyler;

import edu.suffolk.litlab.efsp.Jurisdiction;

/**
 * A combination of a Tyler jurisdiction and env, resulting in a specific set of servers to send
 * requests to.
 */
public record TylerDomain(Jurisdiction jurisdiction, TylerEnv env) {
  public String getName() {
    return jurisdiction.getName() + "-" + env.getName();
  }
}
