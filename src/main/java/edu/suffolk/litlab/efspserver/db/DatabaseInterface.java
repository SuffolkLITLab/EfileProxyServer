package edu.suffolk.litlab.efspserver.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseInterface {
  public void createTablesIfAbsent() throws SQLException;
  
  public Connection getConnection();
}
