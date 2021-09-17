package edu.suffolk.litlab.efspserver.codes;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<R> {
  R get() throws SQLException;
}
