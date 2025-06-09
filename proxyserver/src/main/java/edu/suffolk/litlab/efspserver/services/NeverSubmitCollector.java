package edu.suffolk.litlab.efspserver.services;

/**
 * Similar to {@link AllWrongCollector}, but will never actually submit to the EFM.
 *
 * @author brycew
 */
public class NeverSubmitCollector extends InfoCollector {

  @Override
  public boolean finished() {
    if (err.isPresent()) {
      return true;
    }
    return false;
  }

  @Override
  public boolean okToSubmit() {
    return false;
  }
}
