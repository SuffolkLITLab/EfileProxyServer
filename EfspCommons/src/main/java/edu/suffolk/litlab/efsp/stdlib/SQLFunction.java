package edu.suffolk.litlab.efsp.stdlib;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLFunction<T, R> {
  R apply(T input) throws SQLException;
}
