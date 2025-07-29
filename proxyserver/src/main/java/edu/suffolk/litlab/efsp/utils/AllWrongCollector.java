package edu.suffolk.litlab.efsp.utils;

public class AllWrongCollector extends InfoCollector {

  @Override
  public boolean finished() {
    if (err.isPresent()) {
      return true;
    }
    return false;
  }
}
