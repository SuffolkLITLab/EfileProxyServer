package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.ecfcodes.CodeAndLocation;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseAPI;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDocException;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDocIterator;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TFCodeDatabase extends CodeDatabaseAPI {
  private static final Logger log = LoggerFactory.getLogger(TFCodeDatabase.class);

  private final Jurisdiction jurisdiction;

  public TFCodeDatabase(Jurisdiction jurisdiction, Connection conn) {
    super(conn);
    this.jurisdiction = jurisdiction;
  }

  public static TFCodeDatabase fromDS(Jurisdiction jurisdiction, DataSource ds) {
    try {
      TFCodeDatabase cd = new TFCodeDatabase(jurisdiction, ds.getConnection());
      return cd;
    } catch (SQLException e) {
      log.error("In TFCodeDatabase constructor, can't get connection: ", e);
      throw new RuntimeException(e);
    }
  }

  @Override
  public Jurisdiction getJurisdiction() {
    return jurisdiction;
  }

  // TODO: should this be in the parent class?
  private String jurisStr() {
    return jurisdiction.getName();
  }

  private static final Map<String, String> ecf4Map =
      Map.of(
          "CaseCategoryCodes", "truefiling_casecategory",
          "FeeExceptionReasonCodes", "truefiling_feeexceptionreason",
          "ErrorCodes", "truefiling_errorcode",
          "BundleStatusCodes", "truefiling_bundlestatus",
          "CaseTypeCodes", "truefiling_casetype",
          "DocumentStatusCodes", "truefiling_documentstatus",
          "DocumentTypeCodes", "truefiling_documenttype");

  @Override
  public Map<String, String> xmlElemToTableName() {
    return ecf4Map;
  }

  @Override
  public Set<String> systemTables() {
    return Set.of();
  }

  @Override
  public List<String> getAllLocations() {
    // Only AK Trial Court
    return List.of("55da5b11-2bc4-4881-abd1-b0dfdb506bb1");
  }

  @Override
  public List<NameAndCode> getLocationNames() {
    return List.of(new NameAndCode("Alaska Court", "55da5b11-2bc4-4881-abd1-b0dfdb506bb1"));
  }

  @Override
  public List<NameAndCode> getFileableLocationNames() {
    return List.of(new NameAndCode("Alaska Court", "55da5b11-2bc4-4881-abd1-b0dfdb506bb1"));
  }

  @Override
  public List<NameAndCode> getFileableInitialLocationNames() {
    return List.of(new NameAndCode("Alaska Court", "55da5b11-2bc4-4881-abd1-b0dfdb506bb1"));
  }

  @Override
  public List<NameAndCode> getFileableSubsequentLocationNames() {
    return List.of(new NameAndCode("Alaska Court", "55da5b11-2bc4-4881-abd1-b0dfdb506bb1"));
  }

  @Override
  public void updateTable(String tableName, String courtName, InputStream is)
      throws SQLException, CodeDocException {
    if (conn == null) {
      throw new SQLException("Null connection!");
    }
    validTable(tableName);
    createTableIfAbsent(tableName);
    // TODO: also handle indicies
    // createIndicesIfAbsent(tableName);

    CodeDocIterator iterator = CodeDocIterator.setup(is);
    updateTable(tableName, courtName, iterator.getVersion(), iterator);
  }

  @Override
  public void updateTable(
      String tableName, String courtName, String newVersion, Iterator<Map<String, String>> rows)
      throws SQLException {
    // Ignore version here, they don't use that.
    String insertQuery = CodeTableConstants.getInsertInto(tableName);
    try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
      while (rows.hasNext()) {
        Map<String, String> rowsVals = rows.next();
        CodeDatabaseUtils.singleInsert(
            stmt, CodeTableConstants.getTableColumns(tableName), rowsVals, courtName, jurisStr());
        stmt.addBatch();
      }
      stmt.executeBatch();
    }
  }

  @Override
  public boolean deleteFromTable(String tableName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    final String deleteFromTable = CodeTableConstants.getAllDeleteFrom(tableName);
    try (PreparedStatement st = conn.prepareStatement(deleteFromTable)) {
      st.setString(1, jurisStr());
      st.executeUpdate();
    }
    return true;
  }

  @Override
  public boolean deleteFromTable(String tableName, String courtLocation) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    final String deleteFromTable = CodeTableConstants.getDeleteFrom(tableName);
    try (PreparedStatement st = conn.prepareStatement(deleteFromTable)) {
      st.setString(1, jurisStr());
      st.setString(2, courtLocation);
      st.executeUpdate();
    }
    return true;
  }

  @Override
  public void createTableIfAbsent(String tableName) throws SQLException {
    boolean exists = tableExists(tableName);
    if (!exists) {
      try (Statement createSt = conn.createStatement()) {
        createSt.executeUpdate(CodeTableConstants.getCreateTable(tableName));
      }
    }
  }

  @Override
  public Map<String, List<String>> getVersionsToUpdate() throws SQLException {
    // TODO: just redownload the whole thing
    return Map.of(getAllLocations().get(0), ecf4Map.values().stream().toList());
  }

  @Override
  public void vacuumAll() {
    try {
      String vacuum = "VACUUM ANALYZE";
      try (PreparedStatement vacuumSt = conn.prepareStatement(vacuum)) {
        log.info("Full vacuum statement: {}", vacuumSt);
        vacuumSt.executeUpdate();
      }
    } catch (SQLException ex) {
      log.error("Error when vacuuming in {}", this.jurisdiction, ex);
    }
  }

  @Override
  public List<String> searchCaseCategory(String searchTerm) {
    return genericSearch(
        searchTerm,
        (term) -> {
          String query = CaseCategory.searchCaseCategories();
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, jurisStr());
          st.setString(2, term);
          return st;
        });
  }

  @Override
  public List<String> courtCoverageCaseCategory(String searchTerm) {
    return genericSearch(
        searchTerm,
        (term) -> {
          String query = CaseCategory.courtCoverageCaseCategories();
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, jurisStr());
          st.setString(2, term);
          return st;
        });
  }

  @Override
  public List<CodeAndLocation> retrieveCaseCategoryByName(String categoryName) {
    return safetyWrap(
        () -> {
          String query = CaseCategory.retrieveCaseCategoryForName();
          List<CodeAndLocation> cats = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, jurisStr());
            st.setString(2, categoryName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              cats.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
          }
          return cats;
        });
  }

  @Override
  public List<NameAndCode> getCaseCategoryNames(String courtLocationId) {
    // courtLocation is unused.
    return safetyWrap(
        () -> {
          String query = CaseCategory.getCaseCategoriesForLoc();
          List<NameAndCode> cats = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, jurisStr());
            st.setString(2, courtLocationId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              cats.add(new NameAndCode(rs.getString(2), rs.getString(1)));
            }
          }
          log.info("all cats: {}", cats);
          return cats;
        });
  }

  @Override
  public List<String> searchCaseType(String searchTerm) {
    return genericSearch(searchTerm, (term) -> CaseType.prepSearchQuery(conn, jurisStr(), term));
  }

  @Override
  public List<String> courtCoverageCaseType(String searchTerm) {
    return genericSearch(searchTerm, (term) -> CaseType.prepCourtCoverage(conn, jurisStr(), term));
  }

  @Override
  public List<CodeAndLocation> retrieveCaseTypeByName(String caseTypeName) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st = CaseType.prepRetrieveQuery(conn, jurisStr(), caseTypeName)) {
            List<CodeAndLocation> types = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
            return types;
          }
        });
  }

  @Override
  public List<NameAndCode> getCaseTypeNamesFor(
      String courtLocationId, String caseCategoryCode, Optional<Boolean> initial) {
    return safetyWrap(
        () -> {
          // initial is ignored
          PreparedStatement st =
              CaseType.prepQuery(conn, jurisStr(), courtLocationId, caseCategoryCode);
          ResultSet rs = st.executeQuery();
          List<NameAndCode> nacs = new ArrayList<>();
          // TODO(bryce): can be more efficient, just grabbing the name and code and not all of the
          // other data.
          while (rs.next()) {
            nacs.add(new NameAndCode(rs.getString(3), rs.getString(2)));
          }
          st.close();
          return nacs;
        });
  }

  public List<NameAndCode> getCauseOfActionCodes() {
    // From a spreadsheet that i3v gave us.
    return List.of(
        new NameAndCode("Sexual Assault: Long-Term", "CIV750LT"),
        new NameAndCode("Sexual Assault: Short-Term", "CIV750ST"),
        new NameAndCode("Stalking: Long-Term", "CIV752SL"),
        new NameAndCode("Stalking: Short-Term", "CIV752SE"),
        new NameAndCode("Domestic Violence: Long-Term", "DV100LT"),
        new NameAndCode("Domestic Violence: Short-Term", "DV100ST"));
  }

  public List<NameAndCode> getBundleStatuses(String location) {
    return safetyWrap(
        () -> {
          PreparedStatement st = BundleStatus.prepQuery(conn, jurisStr(), location);
          ResultSet rs = st.executeQuery();
          List<NameAndCode> nacs = new ArrayList<>();
          while (rs.next()) {
            nacs.add(new NameAndCode(rs.getString(1), rs.getString(1)));
          }
          st.close();
          return nacs;
        });
  }

  public List<NameAndCode> getDocumentStatuses(String location) {
    return safetyWrap(
        () -> {
          PreparedStatement st = DocumentStatus.prepQuery(conn, jurisStr(), location);
          ResultSet rs = st.executeQuery();
          List<NameAndCode> nacs = new ArrayList<>();
          while (rs.next()) {
            nacs.add(new NameAndCode(rs.getString(1), rs.getString(1)));
          }
          st.close();
          return nacs;
        });
  }

  public List<NameAndCode> getDocumentTypes(String location, String caseTypeId) {
    return safetyWrap(
        () -> {
          PreparedStatement st = DocumentType.prepQuery(conn, jurisStr(), location, caseTypeId);
          ResultSet rs = st.executeQuery();
          List<NameAndCode> nacs = new ArrayList<>();
          while (rs.next()) {
            nacs.add(new NameAndCode(rs.getString(5), rs.getString(1)));
          }
          st.close();
          return nacs;
        });
  }

  public List<NameAndCode> getErrorCodes(String location) {
    return safetyWrap(
        () -> {
          PreparedStatement st = ErrorCode.prepQuery(conn, jurisStr(), location);
          ResultSet rs = st.executeQuery();
          List<NameAndCode> nacs = new ArrayList<>();
          while (rs.next()) {
            nacs.add(new NameAndCode(rs.getString(2), rs.getString(1)));
          }
          st.close();
          return nacs;
        });
  }

  public List<NameAndCode> getFeeExceptionReasons(String location) {
    return safetyWrap(
        () -> {
          PreparedStatement st = FeeExceptionReason.prepQuery(conn, jurisStr(), location);
          ResultSet rs = st.executeQuery();
          List<NameAndCode> nacs = new ArrayList<>();
          while (rs.next()) {
            nacs.add(new NameAndCode(rs.getString(2), rs.getString(1)));
          }
          st.close();
          return nacs;
        });
  }

  @Override
  public void createTablesIfAbsent() throws SQLException {
    createTableIfAbsent(CaseCategory.TABLE_NAME);
  }

}
