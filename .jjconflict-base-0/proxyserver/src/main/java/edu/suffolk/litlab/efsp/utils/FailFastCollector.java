package edu.suffolk.litlab.efsp.utils;

public class FailFastCollector extends InfoCollector {

  @Override
  public boolean finished() {
    if (!okToSubmit()) {
      return true;
    }
    return false;
  }
}
