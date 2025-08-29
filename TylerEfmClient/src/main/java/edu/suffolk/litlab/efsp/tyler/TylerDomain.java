package edu.suffolk.litlab.efsp.tyler;

/**
 * A combination of a Tyler jurisdiction and env, resulting in a specific set of servers to send
 * requests to.
 */
public record TylerDomain(TylerJurisdiction jurisdiction, TylerEnv env) {
  public String getName() {
    return jurisdiction.getName() + "-" + env.getName();
  }
}
