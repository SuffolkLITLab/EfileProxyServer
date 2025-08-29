package edu.suffolk.litlab.efsp.stdlib;

import java.sql.SQLException;

@FunctionalInterface
public interface SQLGetter<R> {
  R get() throws SQLException;
}
