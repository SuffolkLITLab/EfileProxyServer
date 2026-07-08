package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import java.util.List;
import java.util.Map;

import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.TableColumns;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.UnsupportedTableException;

/** 
 * Court codes in Alaska are very long lived and don't change often.
 * Keeping them here for the moment. Marking other places where this
 * matters with TODO(ak-no-tables).
 */
public class CodeTableConstants {

  private static final Map<String, TableColumns> tableColumns;

  static {
    tableColumns = Map.ofEntries(
        Map.entry(CaseCategory.TABLE_NAME, new TableColumns(CaseCategory.columns, List.of(), true)),
        Map.entry(CaseType.TABLE_NAME, new TableColumns(CaseType.columns, List.of(), true)),
        Map.entry(BundleStatus.TABLE_NAME, new TableColumns(BundleStatus.columns, List.of(), true)),
        Map.entry(DocumentStatus.TABLE_NAME, new TableColumns(DocumentStatus.columns, List.of(), true)),
        Map.entry(DocumentType.TABLE_NAME, new TableColumns(DocumentType.columns, List.of(), true)),
        Map.entry(ErrorCode.TABLE_NAME, new TableColumns(ErrorCode.columns, List.of(), true)),
        Map.entry(FeeExceptionReason.TABLE_NAME, new TableColumns(FeeExceptionReason.columns, List.of(), true))
    );
  }

    public static final List<CaseCategory> categories = List.of(
        new CaseCategory("appellate", "Appellate", "AppellateCase"),
        new CaseCategory("bankruptcy", "Bankruptcy", "BankruptcyCase"),
        new CaseCategory("citation", "Citation", "CitationCase"),
        new CaseCategory("civil", "Civil", "CivilCase"),
        new CaseCategory("criminal", "Criminal", "CriminalCase"),
        new CaseCategory("domestic", "Domestic", "DomesticCase"),
        new CaseCategory("juvenile", "Juvenile", "JuvenileCase")
    );

  public static String getCreateTable(String tableName) throws UnsupportedTableException {
    if (createQueries.containsKey(tableName)) {
      return createQueries.get(tableName);
    }
    throw new UnsupportedTableException("No create query for table " + tableName);
  }

    private static final Map<String, String> createQueries = Map.of(
        CaseCategory.TABLE_NAME, CaseCategory.CREATE_QUERY,
        CaseType.TABLE_NAME, CaseType.CREATE_QUERY,
        BundleStatus.TABLE_NAME, BundleStatus.CREATE_QUERY,
        DocumentStatus.TABLE_NAME, DocumentStatus.CREATE_QUERY,
        DocumentType.TABLE_NAME, DocumentType.CREATE_QUERY,
        ErrorCode.TABLE_NAME, ErrorCode.CREATE_QUERY,
        FeeExceptionReason.TABLE_NAME, FeeExceptionReason.CREATE_QUERY
    );


    private static final Map<String, String> insertQueries = Map.of(
        CaseCategory.TABLE_NAME, CaseCategory.INSERT_QUERY,
        CaseType.TABLE_NAME, CaseType.INSERT_QUERY,
        BundleStatus.TABLE_NAME, BundleStatus.INSERT_QUERY,
        DocumentStatus.TABLE_NAME, DocumentStatus.INSERT_QUERY,
        DocumentType.TABLE_NAME, DocumentType.INSERT_QUERY,
        ErrorCode.TABLE_NAME, ErrorCode.INSERT_QUERY,
        FeeExceptionReason.TABLE_NAME, FeeExceptionReason.INSERT_QUERY
    );

    private static final Map<String, String> deleteFromQueries = Map.of(
        CaseCategory.TABLE_NAME, CaseCategory.DELETE_FROM_QUERY,
        CaseType.TABLE_NAME, CaseType.DELETE_FROM_QUERY,
        BundleStatus.TABLE_NAME, BundleStatus.DELETE_FROM_QUERY,
        DocumentStatus.TABLE_NAME, DocumentStatus.DELETE_FROM_QUERY,
        DocumentType.TABLE_NAME, DocumentType.DELETE_FROM_QUERY,
        ErrorCode.TABLE_NAME, ErrorCode.DELETE_FROM_QUERY,
        FeeExceptionReason.TABLE_NAME, FeeExceptionReason.DELETE_FROM_QUERY
    );

    private static final Map<String, String> deleteAllCourtsFromQueries = Map.of(
        CaseCategory.TABLE_NAME, CaseCategory.DELETE_ALL_COURTS_FROM_QUERY,
        CaseType.TABLE_NAME, CaseType.DELETE_ALL_COURTS_FROM_QUERY,
        BundleStatus.TABLE_NAME, BundleStatus.DELETE_ALL_COURTS_FROM_QUERY,
        DocumentStatus.TABLE_NAME, DocumentStatus.DELETE_ALL_COURTS_FROM_QUERY,
        DocumentType.TABLE_NAME, DocumentType.DELETE_ALL_COURTS_FROM_QUERY,
        ErrorCode.TABLE_NAME, ErrorCode.DELETE_ALL_COURTS_FROM_QUERY,
        FeeExceptionReason.TABLE_NAME, FeeExceptionReason.DELETE_ALL_COURTS_FROM_QUERY
    );

    public static String getDeleteFrom(String tableName) throws UnsupportedTableException {
      if (!deleteFromQueries.containsKey(tableName)) {
        throw new UnsupportedTableException("No delete from query for table " + tableName);
      }
      return deleteFromQueries.get(tableName);
    }

    public static String getAllDeleteFrom(String tableName) throws UnsupportedTableException {
      if (!deleteAllCourtsFromQueries.containsKey(tableName)) {
        throw new UnsupportedTableException("No delete all from query for table " + tableName);
      }
      return deleteAllCourtsFromQueries.get(tableName);
    }

    public static String getInsertInto(String tableName) throws UnsupportedTableException {
        if (!insertQueries.containsKey(tableName)) {
            throw new UnsupportedTableException("No insert query for table " + tableName);
        }
        return insertQueries.get(tableName);
    }

  public static TableColumns getTableColumns(String tableName) {
    return tableColumns.getOrDefault(tableName, new TableColumns(List.of(), List.of(), false));
  }
    
}
