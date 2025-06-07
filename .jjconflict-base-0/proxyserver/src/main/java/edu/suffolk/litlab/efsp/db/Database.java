package edu.suffolk.litlab.efsp.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

public abstract class Database implements AutoCloseable {
  protected final Connection conn;

  public Database(Connection conn) {
    this.conn = conn;
  }

  @Override
  public void close() throws SQLException {
    if (this.conn != null) {
      this.conn.close();
    }
  }

  public void setAutoCommit(boolean val) throws SQLException {
    if (this.conn != null) {
      this.conn.setAutoCommit(val);
    }
  }

  public void commit() throws SQLException {
    if (this.conn != null) {
      this.conn.commit();
    } else {
      throw new SQLException("Connection is null!");
    }
  }

  public Savepoint setSavepoint(String str) throws SQLException {
    if (this.conn != null) {
      return this.conn.setSavepoint(str);
    }
    throw new SQLException("Connection is null!");
  }

  public void rollback(Savepoint sp) throws SQLException {
    if (this.conn != null) {
      this.conn.rollback(sp);
    } else {
      throw new SQLException("Connection is null!");
    }
  }

  public abstract void createTablesIfAbsent() throws SQLException;
}
