package edu.suffolk.litlab.efsp.ecfcodes;

import edu.suffolk.litlab.efsp.db.Database;
import edu.suffolk.litlab.efsp.stdlib.SQLFunction;
import edu.suffolk.litlab.efsp.stdlib.SQLGetter;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ECF says that certain parts of the information model of the data that we exchange with the EFM is
 * contained in Genericode code lists. The EfileProxyServer saves those Genericode code lists in a
 * SQL database, for immediate use.
 *
 * <p>This class is the exposed interface between the SQL databases that store genericode info and
 * the rest of the proxy server, particularly { CodeUpdater }. It should be instanianted once per
 * jurisiction.
 */
public abstract class CodeDatabaseAPI extends Database {
  private static final Logger log = LoggerFactory.getLogger(CodeDatabaseAPI.class);

  public CodeDatabaseAPI(Connection conn) {
    super(conn);
  }

  /**
   * The domain (the juristiction + environment, e.g. illinois-stage) that this database is working
   * over.
   */
  public abstract TylerDomain getDomain();

  /**
   * Gets all court location identifiers (CLI) stored in the database.
   *
   * @return a list of all valid CLIs for this jurisdiction
   */
  public abstract List<String> getAllLocations();

  public abstract void updateTable(String tableName, String courtName, InputStream is)
      throws SQLException, CodeDocException;

  /** The iterator (rows) will be consumed by this function. */
  public abstract void updateTable(
      String tableName, String courtName, String newVersion, Iterator<Map<String, String>> rows)
      throws SQLException;

  public abstract boolean deleteFromTable(String tableName) throws SQLException;

  /**
   * Deletes all entries in a domain from a table in the given table from <code>courtLocation</code>
   * .
   */
  public abstract boolean deleteFromTable(String tableName, String courtLocation)
      throws SQLException;

  public abstract void createTableIfAbsent(String tableName) throws SQLException;

  /** Returns a map from court names to tables that needed to be updated for it. */
  public abstract Map<String, List<String>> getVersionsToUpdate() throws SQLException;

  // TODO(brycew): needed for compatibility, but should be renamed to something more general
  // i.e. 'postUpdateClean'
  public abstract void vacuumAll();

  /**
   * Gets all distinct case category names that have the search term in them.
   *
   * @param searchTerm
   * @return
   */
  public abstract List<String> searchCaseCategory(String searchTerm);

  public abstract List<String> courtCoverageCaseCategory(String searchTerm);

  /**
   * Get the code and court locations of the case categories that match the given name exactly.
   *
   * @param categoryName
   * @return
   */
  public abstract List<CodeAndLocation> retrieveCaseCategoryByName(String categoryName);

  public abstract List<NameAndCode> getCaseCategoryNames(String courtLocationId);

  // Note: to get the full object, need to have the child code database type object.

  /**
   * Gets all distinct case type names that have the search term in them.
   *
   * @param searchTerm
   * @return
   */
  public abstract List<String> searchCaseType(String searchTerm);

  public abstract List<String> courtCoverageCaseType(String searchTerm);

  /**
   * Get the code and court locations of the case types that match the given name exactly.
   *
   * @param caseTypeName
   * @return
   */
  public abstract List<CodeAndLocation> retrieveCaseTypeByName(String caseTypeName);

  public abstract List<NameAndCode> getCaseTypeNamesFor(
      String courtLocationId, String caseCategoryCode, Optional<Boolean> initial);

  /** Runs all of the logic for search queries (both name searches and court coverage searches). */
  protected List<String> genericSearch(
      String searchTerm, SQLFunction<String, PreparedStatement> queryMaker) {
    String finalSearchTerm = CodeDatabaseUtils.likeWildcard(searchTerm);
    return safetyWrap(
        () -> {
          try (PreparedStatement st = queryMaker.apply(finalSearchTerm)) {
            List<String> types = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(rs.getString(1));
            }
            return types;
          }
        });
  }

  protected <T> List<T> safetyWrap(SQLGetter<List<T>> sup) {
    if (conn == null) {
      log.error("SQL connection not created yet!");
      return List.of();
    }
    try {
      return sup.get();
    } catch (SQLException ex) {
      log.error("SQL excption: ", ex);
      return List.of();
    }
  }

  protected <T> Optional<T> safetyWrapOpt(SQLGetter<Optional<T>> sup) {
    if (conn == null) {
      log.error("SQL connection not created yet!");
      return Optional.empty();
    }
    try {
      return sup.get();
    } catch (SQLException ex) {
      log.error("SQL excption: ", ex);
      return Optional.empty();
    }
  }
}
