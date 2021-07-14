package edu.suffolk.litlab.efspserver.services;

public class AllWrongCollector extends InfoCollector {

  @Override
  public boolean finished() {
    if (err.isPresent()) {
      return true;
    }
    return false;
  }
}
