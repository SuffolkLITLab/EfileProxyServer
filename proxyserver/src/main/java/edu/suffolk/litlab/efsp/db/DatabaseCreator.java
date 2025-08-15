package edu.suffolk.litlab.efsp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseCreator {
  private static Logger log = LoggerFactory.getLogger(UserDatabase.class);

  /**
   * @param pgUser The user of the PostgreSQL database
   * @param pgPassword The password for the above user
   */
  public static DataSource makeDataSource(
      String pgUrl,
      int pgPort,
      String pgDb,
      String pgUser,
      String pgPassword,
      int maxConnections,
      int waitForConnMillis)
      throws ClassNotFoundException, SQLException {
    return makeDataSource(
        "jdbc:postgresql://" + pgUrl + ":" + Integer.toString(pgPort),
        pgDb,
        pgUser,
        pgPassword,
        maxConnections,
        waitForConnMillis);
  }

  /** Of the full jdbc form, with no db name: e.g. "jdcb:postgresql://localhost:9000" */
  public static DataSource makeDataSource(
      String pgFullUrl,
      String pgDb,
      String pgUser,
      String pgPassword,
      int maxConnections,
      int waitForConnMillis)
      throws ClassNotFoundException, SQLException {
    DriverAdapterCPDS cpds = new DriverAdapterCPDS();
    cpds.setDriver("org.postgresql.Driver");
    cpds.setUrl(pgFullUrl + "/" + pgDb);
    cpds.setUser(pgUser);
    cpds.setPassword(pgPassword);
    SharedPoolDataSource tds = new SharedPoolDataSource();
    tds.setConnectionPoolDataSource(cpds);
    tds.setDefaultAutoCommit(true);
    tds.setMaxTotal(maxConnections);
    tds.setDefaultMaxWait(Duration.ofMillis(waitForConnMillis));
    try (Connection conn = tds.getConnection()) {
      conn.setAutoCommit(true);
    } catch (SQLException ex) {
      createNewDatabase(pgDb, pgFullUrl, pgUser, pgPassword);
      Connection conn = tds.getConnection();
      conn.setAutoCommit(true);
      conn.close();
    }
    return tds;
  }

  public static Connection makeSingleConnection(
      String pgDb, String pgFullUrl, String pgUser, String pgPassword) throws SQLException {
    String tempUrl = pgFullUrl + "/" + pgDb;
    Properties props = new Properties();
    props.setProperty("user", pgUser);
    props.setProperty("password", pgPassword);
    return DriverManager.getConnection(tempUrl, props);
  }

  /** Creates the database if it doesn't already exist. */
  private static boolean createNewDatabase(
      String pgDb, String pgFullUrl, String pgUser, String pgPassword) throws SQLException {
    if (!pgDb.matches("^[a-zA-Z_]+$")) {
      throw new SQLException("Won't make a database named " + pgDb + ": only alpha and _ allowed");
    }

    long startTime = System.currentTimeMillis();
    long RETRY_TIME_MILLIS = 5000;
    long SLEEP_TIME_MILLIS = 1000;
    while (System.currentTimeMillis() - startTime < RETRY_TIME_MILLIS) {
      // Check if the named database exists before creating it
      log.info("Trying to connect to the default database");
      try (Connection tempConn = makeSingleConnection("postgres", pgFullUrl, pgUser, pgPassword)) {
        log.trace("Got connection");
        ResultSet rs = tempConn.getMetaData().getCatalogs();
        boolean needToMakeDb = true;
        while (rs.next()) {
          log.debug("Database: {}", rs.getString(1));
          if (rs.getString(1).equals(pgDb)) {
            needToMakeDb = false;
          }
        }
        log.debug("Need to make DB: {}", needToMakeDb);
        if (needToMakeDb) {
          log.info("Making a database named {}", pgDb);
          try (Statement st = tempConn.createStatement()) {
            st.executeUpdate("CREATE DATABASE " + pgDb);
          }
        }
        return true;
      } catch (SQLException ex) {
        log.warn(ex.toString());
        try {
          log.info("Sleeping...");
          Thread.sleep(SLEEP_TIME_MILLIS);
        } catch (InterruptedException interruptEx) {
          log.error("Interrupted? ", interruptEx);
          // explicitly do nothing
        }
      }
    }
    return false;
  }
}
