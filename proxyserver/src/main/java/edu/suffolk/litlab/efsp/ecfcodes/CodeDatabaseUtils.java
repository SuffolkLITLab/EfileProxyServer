package edu.suffolk.litlab.efsp.ecfcodes;

import java.sql.SQLException;

public class CodeDatabaseUtils {
  /** This exception is returned when a given table name isn't in the pre-approved list of names. */
  public static class UnsupportedTableException extends SQLException {
    public UnsupportedTableException(String message) {
      super(message);
    }
  }

  public static String getTableExists() {
    return """
        SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public'
        AND table_name = ? LIMIT 1;""";
  }

  public static String getIndicesExist() {
    return """
        SELECT COUNT(*) FROM pg_catalog.pg_indexes where schemaname='public'
        AND tablename = ? LIMIT 1;""";
  }

  /**
   * In most cases, we want to find all instances of the search term, not the exact term. It's a
   * LIKE compare, so add the 0 or more characters on either side.
   *
   * @param searchTerm
   * @return
   */
  public static String likeWildcard(String searchTerm) {
    if (searchTerm == null) {
      return "%";
    }
    return "%" + searchTerm + "%";
  }
}
