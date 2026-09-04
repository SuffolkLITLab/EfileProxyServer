package edu.suffolk.litlab.efsp.ecfcodes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class CodeDatabaseUtils {
  /** This exception is returned when a given table name isn't in the pre-approved list of names. */
  public static class UnsupportedTableException extends SQLException {
    private static final long serialVersionUID = 42L;

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

  public static record TableColumns(
      List<Column> mainList, List<String> primaryKeys, boolean needsExtraLocCol) {}

  public static record Column(String name, String type) {}

  /**
   * Returns an INSERT statement for the given table + court. The statement includes a ON CONFLICT
   * (all columns...) DO NOTHING clause.
   *
   * @param tableName The name of the DB table (i.e. code list) to insert into
   * @param courtName The Court Location ID to add codes for
   */
  public static String createInsertQuery(String tableName, TableColumns tc) {
    StringBuilder insertLocation = new StringBuilder();
    insertLocation.append("INSERT INTO \"" + tableName + "\" (");
    StringBuilder colNames = new StringBuilder();
    boolean isFirst = true;
    for (Column col : tc.mainList()) {
      if (isFirst) {
        isFirst = false;
      } else {
        colNames.append(", ");
      }
      colNames.append("\"" + col.name() + "\"");
    }
    if (tc.needsExtraLocCol()) {
      colNames.append(", location");
    }
    colNames.append(", jurisdiction");
    insertLocation.append(colNames.toString());
    insertLocation.append(") VALUES (");
    for (int i = 0; i < tc.mainList().size(); i++) {
      if (i > 0) {
        insertLocation.append(", ");
      }
      insertLocation.append("?");
    }
    if (tc.needsExtraLocCol()) {
      insertLocation.append(", ?");
    }
    insertLocation.append(", ?");
    insertLocation.append(")");
    return insertLocation.toString();
  }

  public static String createTableQuery(String tableName, TableColumns tc) {
    StringBuilder createLocation = new StringBuilder();
    createLocation.append("CREATE TABLE " + tableName + "(");
    boolean isFirst = true;
    for (Column col : tc.mainList()) {
      if (isFirst) {
        isFirst = false;
      } else {
        createLocation.append(", ");
      }
      createLocation.append("\"" + col.name() + "\" " + col.type());
    }
    if (tc.needsExtraLocCol()) {
      createLocation.append(", \"location\" varchar(80)");
    }
    createLocation.append(", \"jurisdiction\" varchar(80)");

    if (!tc.primaryKeys().isEmpty()) {
      createLocation.append(
          ", PRIMARY KEY(" + tc.primaryKeys().stream().collect(Collectors.joining(",")) + ")");
    }
    createLocation.append(")");
    return createLocation.toString();
  }

  public static PreparedStatement singleInsert(
      PreparedStatement stmt,
      TableColumns columns,
      Map<String, String> rowVals,
      String courtName,
      String jurisStr)
      throws SQLException {
    int idx = 1;
    for (var col : columns.mainList) {
      if (col.type.equalsIgnoreCase("boolean")) {
        if (rowVals.containsKey(col.name)) {
          stmt.setBoolean(idx, Boolean.parseBoolean(rowVals.get(col.name)));
        } else {
          stmt.setNull(idx, Types.BOOLEAN);
        }
      } else if (col.type.equalsIgnoreCase("integer")) {
        if (rowVals.containsKey(col.name)) {
          stmt.setInt(idx, Integer.parseInt(rowVals.get(col.name)));
        } else {
          stmt.setNull(idx, Types.INTEGER);
        }
      } else if (col.type.equalsIgnoreCase("uuid")) {
        if (rowVals.containsKey(col.name)) {
          stmt.setObject(idx, UUID.fromString(rowVals.get(col.name)));
        } else {
          stmt.setNull(idx, Types.JAVA_OBJECT);
        }
      } else {
        // colType.equalsIgnoreCase("text") || colType.startsWith("varchar")
        if (rowVals.containsKey(col.name)) {
          stmt.setString(idx, rowVals.get(col.name));
        } else {
          stmt.setString(idx, null);
        }
      }
      idx += 1;
    }
    if (columns.needsExtraLocCol) {
      stmt.setString(idx, courtName);
      idx += 1;
    }
    stmt.setString(idx, jurisStr);
    return stmt;
  }
}
