package edu.suffolk.litlab.efspserver.services;

import java.util.List;

public interface CodesAPI {
  /**
   * The domain (the juristiction + environment, e.g. illinois-stage) that this database is working
   * over.
   */
  public abstract String getDomain();

  /**
   * Gets all court location identifiers (CLI) stored in the database.
   *
   * @return a list of all valid CLIs for this jurisdiction
   */
  public abstract List<String> getAllLocations();
}
