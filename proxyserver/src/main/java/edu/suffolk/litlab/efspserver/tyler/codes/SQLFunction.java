package edu.suffolk.litlab.efspserver.tyler.codes;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<R> {
  R get() throws SQLException;
}
