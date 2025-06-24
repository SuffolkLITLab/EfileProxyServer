package edu.suffolk.litlab.efsp.stdlib;

import java.sql.SQLException;

/**
 * A "Function" function type that could throw a SQLException.
 *
 * <p>Necessary because the built-in Function interface doesn't allow throwing checked exceptions.
 *
 * @param <T> the input type for this interface
 * @param <R> the type returned by this interface
 * @see edu.suffolk.litlab.efsp.stdlib.SQLGetter
 */
@FunctionalInterface
public interface SQLFunction<T, R> {
  R apply(T input) throws SQLException;
}
