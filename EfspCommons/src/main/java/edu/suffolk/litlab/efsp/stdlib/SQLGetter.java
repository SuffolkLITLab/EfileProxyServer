package edu.suffolk.litlab.efsp.stdlib;

import java.sql.SQLException;

/**
 * A "Supplier" function type that could throw a SQLException.
 *
 * <p>Necessary because the built-in Supplier doesn't allow throwing checked exceptions.
 *
 * @param <R> the type returned by this interface
 * @see edu.suffolk.litlab.efsp.stdlib.SQLFunction
 */
@FunctionalInterface
public interface SQLGetter<R> {
  R get() throws SQLException;
}
