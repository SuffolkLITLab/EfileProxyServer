package edu.suffolk.litlab.efspserver.services;

public class FailFastCollector extends InfoCollector {

  @Override
  public boolean finished() {
    if (!okToSubmit()) {
      return true;
    }
    return false;
  }
}
