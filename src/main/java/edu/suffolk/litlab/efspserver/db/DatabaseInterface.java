package edu.suffolk.litlab.efspserver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DatabaseInterface {
  private static Logger log = 
      LoggerFactory.getLogger(UserDatabase.class); 

  /** Of the full jdbc form, with no db name: e.g. "jdcb:postgresql://localhost:9000" */
  private final String pgFullUrl;
  protected final String pgDb;

  protected Connection conn;

  public DatabaseInterface(String pgUrl, int pgPort, String pgDb) {
    this.pgFullUrl = "jdbc:postgresql://" + pgUrl + ":" + Integer.toString(pgPort);
    this.pgDb = pgDb;
  }
  
  public DatabaseInterface(String pgFullUrl, String pgDb) {
    this.pgFullUrl = pgFullUrl;
    this.pgDb = pgDb;
  }
  
  public abstract void createTablesIfAbsent() throws SQLException;

  /**
   * Creates an internally held connection to the database with the given user and
   * password.
   *
   * @param  pgUser               The user of the PostgreSQL database
   * @param  pgPassword           The password for the above user
   * @throws SQLException         if the connection cannot be completed for some
   *                              reason
   * @throws SQLException if it can't connect to the database for some reason
   */
  public void createDbConnection(String pgUser, String pgPassword) throws SQLException {
    if (conn != null) {
      conn.close();
    }
    String url = this.pgFullUrl + "/" + this.pgDb;
    Properties props = new Properties();
    props.setProperty("user", pgUser);
    props.setProperty("password", pgPassword);
    try {
      conn = DriverManager.getConnection(url, props);
      conn.setAutoCommit(false);
    } catch (SQLException ex) {
      log.error("Error code is: " + ex.getErrorCode());
      createGivenDatabase(pgUser, pgPassword, this.pgDb);
      conn = DriverManager.getConnection(url, props);
      conn.setAutoCommit(false);
    }
  }
  
  /** Creates the database if it doesn't already exist. */
  protected boolean createGivenDatabase(String pgUser, String pgPassword, 
      String newDb) throws SQLException {
    // TODO(brycew): maybe check this earlier
    if (!this.pgDb.matches("[a-zA-Z_]+")) {
      throw new SQLException(
          "Won't make a database named " + this.pgDb + ": only alpha and _ allowed");
    }

    // TODO(brycew): Make the retry wrapper general, and maybe better formed?
    long startTime = System.currentTimeMillis();
    long RETRY_TIME_MILLIS = 5000;
    long SLEEP_TIME_MILLIS = 1000;
    while (System.currentTimeMillis() - startTime < RETRY_TIME_MILLIS) {
      // Check if the named database exists before creating it
      log.info("Trying to connect to the default database");
      String tempUrl = this.pgFullUrl + "/postgres";
      try {
        Properties props = new Properties();
        props.setProperty("user", pgUser);
        props.setProperty("password", pgPassword);
        Connection tempConn = DriverManager.getConnection(tempUrl, props);
        log.trace("Got connection");
        ResultSet rs = tempConn.getMetaData().getCatalogs();
        boolean needToMakeDb = true;
        while (rs.next()) {
          log.debug("Database: " + rs.getString(1));
          if (rs.getString(1).equals(newDb)) {
            needToMakeDb = false;
          }
        }
        log.debug("Need to make DB: " + needToMakeDb);
        if (needToMakeDb) {
          log.info("Making a database named " + newDb);
          Statement st = tempConn.createStatement();
          st.executeUpdate("CREATE DATABASE " + newDb);
          st.close();
        }
        return true;
      } catch (SQLException ex) {
        log.warn(ex.toString());
        try {
          log.info("Sleeping...");
          Thread.sleep(SLEEP_TIME_MILLIS);
        } catch (InterruptedException interruptEx) {
          log.error("Interrupted? " + interruptEx.toString());
          // explicitly do nothing
        }
      }
    }
    return false;
  }

  /** Returns true if the connection is already open. */
  public boolean connectionIsOpen() {
    try {
      return conn != null && !conn.isClosed();
    } catch (SQLException ex) {
      return false;
    }
  }

  public Savepoint setSavePoint(String savepoint) throws SQLException {
    return conn.setSavepoint(savepoint);
  }

  public void rollback(Savepoint savepoint) throws SQLException {
    conn.rollback(savepoint);
  }

  public void commit() throws SQLException {
    conn.commit();
  }
  
  public void setAutocommit(boolean on) throws SQLException {
    if (conn != null) {
      conn.setAutoCommit(on);
    }
  }
}
