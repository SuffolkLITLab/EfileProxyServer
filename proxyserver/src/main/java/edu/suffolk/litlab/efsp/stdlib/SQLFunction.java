package edu.suffolk.litlab.efsp.stdlib;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<R> {
  R get() throws SQLException;
}
