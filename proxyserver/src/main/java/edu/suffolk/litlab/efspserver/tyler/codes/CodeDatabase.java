package edu.suffolk.litlab.efspserver.tyler.codes;

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.ecfcodes.CodeDatabaseAPI;
import jakarta.xml.bind.JAXBException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.sql.DataSource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.commons.lang3.tuple.Pair;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;
import org.oasis_open.docs.codelist.ns.genericode._1.Row;
import org.oasis_open.docs.codelist.ns.genericode._1.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class that interfaces with the database tables that contain the Tyler case codes.
 *
 * <p>Codes in this case doesn't mean programming code", it's more like code numbers code names for
 * all of the different case details and information.
 *
 * @author brycew
 */
public class CodeDatabase extends CodeDatabaseAPI {
  private static final Logger log = LoggerFactory.getLogger(CodeDatabase.class);

  /** The DNS domain (tyler jurisdiction + tyler environment, illinois-stage). */
  private final String tylerDomain;

  public CodeDatabase(String jurisdiction, String env, Connection conn) {
    super(conn);
    this.tylerDomain = jurisdiction + "-" + env;
  }

  public static CodeDatabase fromDS(String jurisdiction, String env, DataSource ds) {
    try {
      CodeDatabase cd = new CodeDatabase(jurisdiction, env, ds.getConnection());
      return cd;
    } catch (SQLException e) {
      log.error("In CodeDatabase constructor, can't get connection: " + StdLib.strFromException(e));
      throw new RuntimeException(e);
    }
  }

  @Override
  public void createTablesIfAbsent() throws SQLException {
    createTableIfAbsent("location");
    createTableIfAbsent("installedversion");
  }

  public String getDomain() {
    return tylerDomain;
  }

  public void createTableIfAbsent(String tableName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      log.warn("Must be valid table name: " + tableName + " is not");
      return;
    }

    // TODO(brycew-later): eventually make the create tables have foreign keys and
    // required from the Id / columnRefs
    String tableExistsQuery = CodeTableConstants.getTableExists();
    try (PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery)) {
      existsSt.setString(1, tableName);
      ResultSet rs = existsSt.executeQuery();
      boolean next = rs.next();
      int firstVal = rs.getInt(1);
      if (!next || firstVal <= 0) { // There's no table! Make one
        if (tableName.equals("optionalservices")) {
          log.info("Creating optionalservices");
          OptionalServiceCode.createFromOptionalServiceTable(conn);
        } else {
          String createQuery = CodeTableConstants.getCreateTable(tableName);
          if (createQuery.isEmpty()) {
            log.warn("Will not create table with name: " + tableName);
            return;
          }
          try (Statement createSt = conn.createStatement()) {
            log.info("Full statement: {}", createQuery);
            createSt.executeUpdate(createQuery);
          }
        }
      }
      rs.close();
    }
  }

  public void createIndicesIfAbsent(String tableName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      log.warn("Must be a valid table name: " + tableName + " is not");
      return;
    }

    String indicesExist = CodeTableConstants.getIndicesExist();
    try (PreparedStatement existsSt = conn.prepareStatement(indicesExist)) {
      existsSt.setString(1, tableName);
      ResultSet rs = existsSt.executeQuery();
      boolean next = rs.next();
      int firstVal = rs.getInt(1);
      if (!next || firstVal <= 0) {
        if (tableName.equals("optionalservices")) {
          OptionalServiceCode.createIndices(conn);
        } else {
          // Create the indices: might take a while
          List<String> createIndices = CodeTableConstants.getCreateIndex(tableName);
          for (String createIndex : createIndices) {
            try (PreparedStatement createSt = conn.prepareStatement(createIndex)) {
              createSt.executeUpdate();
            }
          }
        }
      }
    }
  }

  public void updateTable(String tableName, String courtName, InputStream inStream)
      throws JAXBException, SQLException, XMLStreamException {
    if (conn == null) {
      throw new SQLException("Null connection!");
    }
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      log.warn("Must be valid table name: " + tableName + " is not");
      return;
    }

    createTableIfAbsent(tableName);
    createIndicesIfAbsent(tableName);

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inStream);
    updateTable(tableName, courtName, xsr);
    xsr.close();
  }

  public void updateTable(String tableName, String courtName, CodeListDocument doc)
      throws SQLException {
    String versionUpdate = CodeTableConstants.updateVersion();
    try (PreparedStatement update = conn.prepareStatement(versionUpdate)) {
      if (tableName.equals("optionalservices")) {
        OptionalServiceCode.updateOptionalServiceTable(courtName, this.tylerDomain, doc, this.conn);
      } else {
        updateTableInner(tableName, courtName, doc);
      }
      // The version table that we directly download references things by "___codes.zip", not the
      // table name. We can translate those here.
      String zipName = CodeTableConstants.getZipNameFromTable(tableName);
      update.setString(1, courtName);
      update.setString(2, zipName);
      update.setString(3, doc.getIdentification().getVersion());
      update.setString(4, tylerDomain);
      update.setString(5, doc.getIdentification().getVersion());
      update.executeUpdate();
    } catch (SQLException ex) {
      log.error(
          "Tried to execute an insert, but failed! Exception: {}", StdLib.strFromException(ex));
      log.error("Going to rollback updates to this table");
      throw ex;
    }
  }

  public void updateTableInner(String tableName, String courtName, CodeListDocument doc)
      throws SQLException {
    String insertQuery = CodeTableConstants.getInsertInto(tableName);
    try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
      // TODO(brycew-later): dive deeper in the Column set, and see if any Data type isn't a
      // normalizedString.
      // ColumnSet cs = doc.getColumnSet();
      for (Row r : doc.getSimpleCodeList().getRow()) {
        // HACK(brycew): jeez, this is horrible. Figure a better option
        Map<String, String> rowsVals = new HashMap<>();
        for (Value v : r.getValue()) {
          Column c = (Column) v.getColumnRef();
          rowsVals.put(c.getId(), v.getSimpleValue().getValue());
        }
        singleInsert(stmt, tableName, courtName, rowsVals);
        stmt.addBatch();
      }
      stmt.executeBatch();
    }
  }

  public PreparedStatement singleInsert(
      PreparedStatement stmt, String tableName, String courtName, Map<String, String> rowsVals)
      throws SQLException {
    int idx = 1;
    List<Pair<String, String>> tc = CodeTableConstants.getTableColumnsWithType(tableName);
    for (Pair<String, String> col : tc) {
      String colName = col.getLeft();
      String colType = col.getRight();
      if (colType.equalsIgnoreCase("boolean")) {
        if (rowsVals.containsKey(colName)) {
          stmt.setBoolean(idx, Boolean.parseBoolean(rowsVals.get(colName)));
        } else {
          stmt.setNull(idx, Types.BOOLEAN);
        }
      } else if (colType.equalsIgnoreCase("integer")) {
        if (rowsVals.containsKey(colName)) {
          stmt.setInt(idx, Integer.parseInt(rowsVals.get(colName)));
        } else {
          stmt.setNull(idx, Types.INTEGER);
        }
      } else {
        // colType.equalsIgnoreCase("text") || colType.startsWith("varchar")
        if (rowsVals.containsKey(colName)) {
          stmt.setString(idx, rowsVals.get(colName));
        } else {
          stmt.setString(idx, null);
        }
      }
      idx += 1;
    }
    if (CodeTableConstants.isCourtTable(tableName)) {
      stmt.setString(idx, courtName);
      idx += 1;
    }
    stmt.setString(idx, this.tylerDomain);
    return stmt;
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

  /**
   * Gets all distinct case category names that have the search term in them.
   *
   * @param searchTerm
   * @return
   */
  public List<String> searchCaseCategory(String searchTerm) {
    String finalSearchTerm = likeWildcard(searchTerm);
    return safetyWrap(
        () -> {
          String query = CaseCategory.searchCaseCategories();
          List<String> cats = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, finalSearchTerm);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              cats.add(rs.getString(1));
            }
          }
          return cats;
        });
  }

  /**
   * Get the code and court locations of the case categories that match the given name exactly.
   *
   * @param categoryName
   * @return
   */
  public List<CodeAndLocation> retrieveCaseCategoryByName(String categoryName) {
    return safetyWrap(
        () -> {
          String query = CaseCategory.retrieveCaseCategoryForName();
          List<CodeAndLocation> cats = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, categoryName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              cats.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
          }
          return cats;
        });
  }

  public List<CaseCategory> getCaseCategoriesFor(String courtLocationId) {
    return safetyWrap(
        () -> {
          String query = CaseCategory.getCaseCategoriesForLoc();
          List<CaseCategory> cats = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              cats.add(new CaseCategory(rs));
            }
          }
          return cats;
        });
  }

  public List<CaseCategory> getFilableCaseCategories(
      String courtLocationId, Optional<Boolean> initial) {
    return safetyWrap(
        () -> {
          PreparedStatement st;
          if (initial.isPresent()) {
            st =
                CaseCategory.prepFilableQueryTiming(
                    conn, this.tylerDomain, courtLocationId, initial.get());
          } else {
            st = CaseCategory.prepFileableQuery(conn, this.tylerDomain, courtLocationId);
          }
          ResultSet rs = st.executeQuery();
          List<CaseCategory> cats = new ArrayList<>();
          while (rs.next()) {
            cats.add(new CaseCategory(rs));
          }
          st.close();
          return cats;
        });
  }

  public Optional<CaseCategory> getCaseCategoryWithCode(
      String courtLocationId, String caseCatCode) {
    return safetyWrapOpt(
        () -> {
          String query = CaseCategory.getCaseCategoryWithCode();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            st.setString(3, caseCatCode);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
              CaseCategory newCat = new CaseCategory(rs);
              return Optional.of(newCat);
            } else {
              log.warn("No categories for code " + caseCatCode + " at " + courtLocationId);
              return Optional.empty();
            }
          }
        });
  }

  /**
   * Gets all distinct case type names that have the search term in them.
   *
   * @param searchTerm
   * @return
   */
  public List<String> searchCaseType(String searchTerm) {
    String finalSearchTerm = likeWildcard(searchTerm);
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              CaseType.prepSearchQuery(conn, tylerDomain, finalSearchTerm)) {
            List<String> types = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(rs.getString(1));
            }
            return types;
          }
        });
  }

  /**
   * Get the code and court locations of the case types that match the given name exactly.
   *
   * @param caseTypeName
   * @return
   */
  public List<CodeAndLocation> retrieveCaseTypeByName(String caseTypeName) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st = CaseType.prepRetrieveQuery(conn, tylerDomain, caseTypeName)) {
            List<CodeAndLocation> types = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
            return types;
          }
        });
  }

  public List<CaseType> getCaseTypesFor(
      String courtLocationId, String caseCategoryCode, Optional<Boolean> initial) {
    return safetyWrap(
        () -> {
          PreparedStatement st;
          if (initial.isPresent()) {
            st =
                CaseType.prepQueryTiming(
                    conn, tylerDomain, courtLocationId, caseCategoryCode, initial);
          } else {
            st = CaseType.prepQueryBroad(conn, tylerDomain, courtLocationId, caseCategoryCode);
          }
          ResultSet rs = st.executeQuery();
          List<CaseType> types = new ArrayList<>();
          while (rs.next()) {
            types.add(new CaseType(rs));
          }
          st.close();
          return types;
        });
  }

  public Optional<CaseType> getCaseTypeWith(String courtLocationId, String caseTypeCode) {
    return safetyWrapOpt(
        () -> {
          try (PreparedStatement st =
              CaseType.prepQueryWithCode(conn, tylerDomain, courtLocationId, caseTypeCode)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
              return Optional.of(new CaseType(rs));
            } else {
              return Optional.empty();
            }
          }
        });
  }

  public List<NameAndCode> getCaseSubtypesFor(String courtLocationId, String caseType) {
    return safetyWrap(
        () -> {
          String query = CodeTableConstants.getCaseSubtypesFor();
          List<NameAndCode> subtypes = new ArrayList<NameAndCode>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            st.setString(3, caseType);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              subtypes.add(new NameAndCode(rs.getString(2), rs.getString(1)));
            }
          }
          return subtypes;
        });
  }

  public DataFieldRow getDataField(String courtLocationId, String dataName) {
    if (conn == null) {
      log.error("SQL connection not created in DataField yet");
      return DataFieldRow.MissingDataField(dataName);
    }

    try {
      List<String> parentList = getParentList(courtLocationId);
      String query = DataFieldRow.getAllFromDataFieldConfigForLoc();
      for (String currentCourt : parentList) {
        try (PreparedStatement st = conn.prepareStatement(query)) {
          st.setString(1, tylerDomain);
          st.setString(2, currentCourt);
          st.setString(3, dataName);
          ResultSet rs = st.executeQuery();
          if (!rs.next()) {
            continue;
          }
          DataFieldRow dfr =
              new DataFieldRow(
                  rs.getString(1),
                  rs.getString(2),
                  rs.getBoolean(3),
                  rs.getBoolean(4),
                  rs.getString(5),
                  rs.getString(6),
                  rs.getString(7),
                  rs.getString(8),
                  rs.getString(9),
                  rs.getString(10),
                  rs.getBoolean(11),
                  rs.getString(12));
          return dfr;
        }
      }
      return DataFieldRow.MissingDataField(dataName);
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return DataFieldRow.MissingDataField(dataName);
    }
  }

  public List<NameAndCode> getDataFieldNames(String courtLocationId) {
    if (conn == null) {
      log.error("SQL connection not created in DataField yet");
      return List.of();
    }

    try {
      List<String> parentList = getParentList(courtLocationId);
      String query = DataFieldRow.getAllDataFieldNames();
      var dataFields = new ArrayList<NameAndCode>();
      Set<String> codesInList = new HashSet<>();
      for (String currentCourt : parentList) {
        try (PreparedStatement st = conn.prepareStatement(query)) {
          st.setString(1, tylerDomain);
          st.setString(2, currentCourt);
          ResultSet rs = st.executeQuery();
          while (rs.next()) {
            var code = rs.getString(1);
            if (!codesInList.contains(code)) {
              dataFields.add(new NameAndCode(rs.getString(2), rs.getString(1)));
              codesInList.add(rs.getString(1));
            }
          }
        }
      }
      return dataFields;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return List.of();
    }
  }

  /** gets all data fields if dataNames is empty, otherwise just those that match the code. */
  public DataFields getDataFields(String courtLocationId) {
    if (conn == null) {
      log.error("SQL connection not created in DataField yet");
      return new DataFields();
    }

    try {
      List<String> parentList = getParentList(courtLocationId);
      String query = DataFieldRow.getAllDataFieldConfigsForLoc();
      List<Map<String, DataFieldRow>> allDataFields = new ArrayList<>();
      for (String currentCourt : parentList) {
        try (PreparedStatement st = conn.prepareStatement(query)) {
          st.setString(1, tylerDomain);
          st.setString(2, currentCourt);
          ResultSet rs = st.executeQuery();
          var dataFieldMap = new HashMap<String, DataFieldRow>();
          while (rs.next()) {
            DataFieldRow dfr =
                new DataFieldRow(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getBoolean(3),
                    rs.getBoolean(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getBoolean(11),
                    rs.getString(12));
            dataFieldMap.put(dfr.code, dfr);
          }
          allDataFields.add(dataFieldMap);
        }
      }
      return new DataFields(allDataFields);
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return new DataFields();
    }
  }

  public List<NameAndCode> getProcedureOrRemedy(String courtLocationId, String caseCategory) {
    if (conn == null) {
      log.error("SQL connection not created in ProcedureOrRemedy yet");
      return List.of();
    }

    String query = CodeTableConstants.getProcedureOrRemedy();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      st.setString(3, caseCategory);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> names = new ArrayList<>();
      while (rs.next()) {
        names.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return names;
    } catch (SQLException ex) {
      log.error("SQLExeception: " + ex);
      return List.of();
    }
  }

  /**
   * Gets all distinct filing type names that have the search term in them.
   *
   * @param searchTerm
   * @return
   */
  public List<String> searchFilingType(String searchTerm) {
    String finalSearchTerm = likeWildcard(searchTerm);
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              FilingCode.prepSearchQuery(conn, tylerDomain, finalSearchTerm)) {
            List<String> types = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(rs.getString(1));
            }
            return types;
          }
        });
  }

  /**
   * Get the code and court locations of the filing types that match the given name exactly.
   *
   * @param caseTypeName
   * @return
   */
  public List<CodeAndLocation> retrieveFilingTypeByName(String caseTypeName) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              FilingCode.prepRetrieveQuery(conn, tylerDomain, caseTypeName)) {
            List<CodeAndLocation> types = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
            return types;
          }
        });
  }

  public List<FilingCode> getFilingType(
      String courtLocationId, String categoryCode, String typeCode, boolean initial) {
    return safetyWrap(
        () -> {
          List<FilingCode> filingTypes = new ArrayList<>();
          try (PreparedStatement specificSt =
              FilingCode.prepQueryWithCaseInfo(
                  conn, initial, tylerDomain, courtLocationId, categoryCode, typeCode)) {
            ResultSet rs = specificSt.executeQuery();
            while (rs.next()) {
              filingTypes.add(new FilingCode(rs));
            }
            // If there's nothing for the specific category and type, then get filing types without
            // categories or types
            if (filingTypes.isEmpty()) {
              try (PreparedStatement broadSt =
                  FilingCode.prepQueryNoCaseInfo(conn, initial, tylerDomain, courtLocationId)) {
                ResultSet broadRs = broadSt.executeQuery();
                while (broadRs.next()) {
                  filingTypes.add(new FilingCode(broadRs));
                }
              }
            }
          }
          return filingTypes;
        });
  }

  public Optional<FilingCode> getFilingTypeWith(String courtLocationId, String filingCode) {
    return safetyWrapOpt(
        () -> {
          try (PreparedStatement st =
              FilingCode.prepQueryWithCode(conn, tylerDomain, courtLocationId, filingCode)) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
              return Optional.of(new FilingCode(rs));
            } else {
              return Optional.empty();
            }
          }
        });
  }

  public void vacuumAll() {
    try {
      String vacuum = CodeTableConstants.vacuumAnalyzeAll();
      try (PreparedStatement vacuumSt = conn.prepareStatement(vacuum)) {
        log.info("Full vacuum statement: " + vacuumSt.toString());
        vacuumSt.executeUpdate();
      }
    } catch (SQLException ex) {
      log.error("Error when vacuuming in " + this.tylerDomain + ": " + StdLib.strFromException(ex));
    }
  }

  public List<NameAndCode> getDamageAmount(String courtLocationId, String caseCategory) {
    return safetyWrap(
        () -> {
          String query = CodeTableConstants.getDamageAmount();
          List<NameAndCode> amounts = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            st.setString(3, caseCategory);
            try (ResultSet rs = st.executeQuery()) {
              while (rs.next()) {
                amounts.add(new NameAndCode(rs.getString(2), rs.getString(1)));
              }
            }
          }
          return amounts;
        });
  }

  /**
   * Gets all distinct filing type names that have the search term in them.
   *
   * @param searchTerm
   * @return
   */
  public List<String> searchPartyType(String searchTerm) {
    String finalSearchTerm = likeWildcard(searchTerm);
    return safetyWrap(
        () -> {
          String query = PartyType.searchPartyType();
          List<String> types = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, finalSearchTerm);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(rs.getString(1));
            }
            return types;
          }
        });
  }

  public List<CodeAndLocation> retrievePartyType(String partyTypeName) {
    return safetyWrap(
        () -> {
          String query = PartyType.retrievePartyTypeFromName();
          List<CodeAndLocation> types = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, partyTypeName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
            return types;
          }
        });
  }

  /**
   * Gets the party types that are allowed for a given court and case type.
   *
   * @param courtLocationId
   * @param caseTypeCode Nullable, if null, gets all party types for court, otherwise, just for that
   *     case type.
   * @return a list of party types
   */
  public List<PartyType> getPartyTypeFor(String courtLocationId, String caseTypeCode) {
    return safetyWrap(
        () -> {
          String query = PartyType.getPartyTypeFromCaseType();
          List<PartyType> partyTypes = new ArrayList<>();
          try (PreparedStatement caseSt = conn.prepareStatement(query)) {
            caseSt.setString(1, tylerDomain);
            caseSt.setString(2, courtLocationId);
            if (caseTypeCode != null) {
              caseSt.setString(3, caseTypeCode);
              try (ResultSet rs = caseSt.executeQuery()) {
                while (rs.next()) {
                  partyTypes.add(new PartyType(rs));
                }
              }
            }
            if (partyTypes.isEmpty()) {
              String broadQuery = PartyType.getPartyTypeNoCaseType();
              try (PreparedStatement broadSt = conn.prepareStatement(broadQuery)) {
                broadSt.setString(1, tylerDomain);
                broadSt.setString(2, courtLocationId);
                try (ResultSet broadRs = broadSt.executeQuery()) {
                  while (broadRs.next()) {
                    partyTypes.add(new PartyType(broadRs));
                  }
                }
              }
            }
          }
          return partyTypes;
        });
  }

  public List<PartyType> getPartyTypeByCode(String courtLocationId, String partyTypeCode) {
    return safetyWrap(
        () -> {
          String query = PartyType.retrievePartyTypeFromName();
          List<PartyType> types = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            st.setString(3, partyTypeCode);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(new PartyType(rs));
            }
            return types;
          }
        });
  }

  public List<CrossReference> getCrossReference(String courtLocationId, String caseTypeId) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st = conn.prepareStatement(CrossReference.query())) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            st.setString(3, caseTypeId);
            ResultSet rs = st.executeQuery();
            var types = new ArrayList<CrossReference>();
            while (rs.next()) {
              types.add(new CrossReference(rs));
            }
            return types;
          }
        });
  }

  public List<ServiceCodeType> getServiceTypes(String courtLocationId) {
    return safetyWrap(
        () -> {
          String query = ServiceCodeType.query();
          List<ServiceCodeType> types = new ArrayList<>();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              types.add(new ServiceCodeType(rs));
            }
          }
          return types;
        });
  }

  public List<DocumentTypeTableRow> getDocumentTypes(String courtLocationId, String filingCodeId) {
    if (conn == null) {
      log.error("SQL connection not created in Document Type yet");
      return List.of();
    }

    String specificQuery = DocumentTypeTableRow.getDocumentTypeWithFilingCode();
    try (PreparedStatement specificSt = conn.prepareStatement(specificQuery)) {
      specificSt.setString(1, tylerDomain);
      specificSt.setString(2, courtLocationId);
      specificSt.setString(3, filingCodeId);
      ResultSet spefRs = specificSt.executeQuery();
      var docTypes = new ArrayList<DocumentTypeTableRow>();
      while (spefRs.next()) {
        docTypes.add(new DocumentTypeTableRow(spefRs));
      }
      if (docTypes.isEmpty()) {
        String broadQuery = DocumentTypeTableRow.getDocumentTypeNoFiling();
        try (PreparedStatement broadSt = conn.prepareStatement(broadQuery)) {
          broadSt.setString(1, tylerDomain);
          broadSt.setString(2, courtLocationId);
          ResultSet broadRs = broadSt.executeQuery();
          while (broadRs.next()) {
            docTypes.add(new DocumentTypeTableRow(broadRs));
          }
        }
      }
      return docTypes;
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return List.of();
    }
  }

  public List<NameAndCode> getMotionTypes(String courtLocationId, String filingCodeId) {
    if (conn == null) {
      log.error("SQL connection not created in MotionTypes yet");
      return List.of();
    }

    String query = CodeTableConstants.getMotionTypes();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      st.setString(3, filingCodeId);
      ResultSet rs = st.executeQuery();
      var motions = new ArrayList<NameAndCode>();
      while (rs.next()) {
        motions.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return motions;
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return List.of();
    }
  }

  public List<NameAndCode> getNameSuffixes(String courtLocationId) {
    if (conn == null) {
      log.error("SQL connection not created in NameSuffixes yet");
      return List.of();
    }

    String query = CodeTableConstants.getNameSuffixes();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      ResultSet rs = st.executeQuery();
      var motions = new ArrayList<NameAndCode>();
      while (rs.next()) {
        motions.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return motions;
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return List.of();
    }
  }

  public List<FilingComponent> getFilingComponents(String courtLocationId, String filingCodeId) {
    if (conn == null) {
      log.error("SQL connection not created in FilingComponents yet");
      return List.of();
    }

    String query = FilingComponent.getFilingComponents();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      st.setString(3, filingCodeId);
      ResultSet rs = st.executeQuery();
      List<FilingComponent> components = new ArrayList<>();
      while (rs.next()) {
        components.add(new FilingComponent(rs));
      }
      return components;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return List.of();
    }
  }

  public List<String> getStateCodes(String courtId, String country) {
    if (conn == null) {
      log.error("Connection not started in state codes?");
      return List.of();
    }

    String query = CodeTableConstants.getSpecificStatesForCountryForLoc();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      // TODO(brycew-later): Tyler docs say state is a system table, but there's one per court?
      st.setString(1, tylerDomain);
      st.setString(2, courtId);
      st.setString(3, country);
      ResultSet rs = st.executeQuery();
      List<String> stateCodes = new ArrayList<>();
      while (rs.next()) {
        stateCodes.add(rs.getString(1));
      }
      if (!stateCodes.isEmpty()) {
        return stateCodes;
      }
      // If the court table doesn't have the states, then dropdown to the "system" court (0).
      // TODO(brycew): should drop down to the parent court first?
      st.setString(2, "0");
      rs = st.executeQuery();
      while (rs.next()) {
        stateCodes.add(rs.getString(1));
      }
      return stateCodes;
    } catch (SQLException ex) {
      log.error("Got a SQL exception in StateCodes: " + ex);
      return List.of();
    }
  }

  public List<FileType> getAllowedFileTypes(String courtId) {
    return safetyWrap(
        () -> {
          String query = FileType.fileTypeQueries();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtId);
            ResultSet rs = st.executeQuery();
            List<FileType> types = new ArrayList<>();
            while (rs.next()) {
              types.add(new FileType(rs));
            }
            return types;
          }
        });
  }

  public List<FilerType> getFilerTypes(String courtId) {
    return safetyWrap(
        () -> {
          String query = FilerType.query();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtId);
            ResultSet rs = st.executeQuery();
            List<FilerType> types = new ArrayList<>();
            while (rs.next()) {
              types.add(new FilerType(rs));
            }
            return types;
          }
        });
  }

  public List<NameAndCode> getFilingStatuses(String courtId) {
    if (conn == null) {
      log.error("connection not started in FilingStatus");
      return List.of();
    }

    String query = CodeTableConstants.getFilingStatuses();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtId);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> names = new ArrayList<>();
      while (rs.next()) {
        names.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return names;
    } catch (SQLException ex) {
      log.error("SQLExecption: " + ex);
      return List.of();
    }
  }

  public List<String> searchOptionalServices(String searchTerm) {
    final String finalSearchTerm = likeWildcard(searchTerm);
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              OptionalServiceCode.prepSearch(conn, tylerDomain, finalSearchTerm)) {
            List<String> optServs = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              optServs.add(rs.getString(1));
            }
            return optServs;
          }
        });
  }

  public List<CodeAndLocation> retrieveOptionalServices(String optServName) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              OptionalServiceCode.prepRetrieve(conn, tylerDomain, optServName)) {
            List<CodeAndLocation> optServs = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              optServs.add(new CodeAndLocation(rs.getString(1), rs.getString(2)));
            }
            return optServs;
          }
        });
  }

  public List<OptionalServiceCode> getOptionalServicesByCode(String courtId, String optServCode) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              OptionalServiceCode.prepQueryWithCode(conn, tylerDomain, courtId, optServCode)) {
            List<OptionalServiceCode> optServs = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              optServs.add(new OptionalServiceCode(rs));
            }
            return optServs;
          }
        });
  }

  public List<OptionalServiceCode> getOptionalServices(String courtId, String filingCode) {
    return safetyWrap(
        () -> {
          try (PreparedStatement st =
              OptionalServiceCode.prepQuery(conn, tylerDomain, courtId, filingCode)) {
            ResultSet rs = st.executeQuery();
            List<OptionalServiceCode> services = new ArrayList<>();
            while (rs.next()) {
              services.add(new OptionalServiceCode(rs));
            }
            return services;
          }
        });
  }

  public List<String> getLanguageNames(String courtLocationId) {
    return safetyWrap(
        () -> {
          String query = CodeTableConstants.getLanguages();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            ResultSet rs = st.executeQuery();
            List<String> languages = new ArrayList<>();
            while (rs.next()) {
              languages.add(rs.getString(2));
            }
            return languages;
          }
        });
  }

  public List<NameAndCode> getLanguages(String courtLocationId) {
    return safetyWrap(
        () -> {
          String query = CodeTableConstants.getLanguages();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocationId);
            ResultSet rs = st.executeQuery();
            List<NameAndCode> languages = new ArrayList<>();
            while (rs.next()) {
              languages.add(new NameAndCode(rs.getString(2), rs.getString(1)));
            }
            return languages;
          }
        });
  }

  /** Returns map of court locations to the list of tables they need to update. */
  public Map<String, List<String>> getVersionsToUpdate() throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    String query = CodeTableConstants.needToUpdateVersion();
    Map<String, List<String>> courtTables = new HashMap<>();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, this.tylerDomain);
      ResultSet rs = st.executeQuery();
      log.info("Query was " + st.toString());
      while (rs.next()) {
        if (!courtTables.containsKey(rs.getString(1))) {
          courtTables.put(rs.getString(1), new ArrayList<>());
        }
        String tableName = rs.getString(2);
        if (tableName.endsWith(".zip")) {
          tableName = tableName.substring(0, tableName.length() - 4);
        }
        if (tableName.endsWith("codes")) {
          tableName = tableName.substring(0, tableName.length() - 5);
        }
        if (tableName.equals("locations")) {
          tableName = "location";
        }
        courtTables.get(rs.getString(1)).add(tableName);
      }
    }
    return courtTables;
  }

  public boolean deleteFromTable(String tableName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    if (tableName.equals("optionalservices")) {
      OptionalServiceCode.deleteFromOptionalServiceTable(null, tylerDomain, conn);
    } else {
      final String deleteFromTable = CodeTableConstants.getDeleteAllCourtsFrom(tableName);
      // TODO(brycew): make variant that deletes everything with a specific jurisdiction
      try (PreparedStatement st = conn.prepareStatement(deleteFromTable)) {
        st.setString(1, tylerDomain);
        log.debug(st.toString());
        st.executeUpdate();
      }
    }
    return true;
  }

  public boolean deleteFromTable(String tableName, String courtLocation) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    if (courtLocation == null || courtLocation.isBlank()) {
      log.warn("Don't call this without a valid court: just don't use the var");
      return false;
    }
    if (tableName.equals("optionalservices")) {
      OptionalServiceCode.deleteFromOptionalServiceTable(courtLocation, tylerDomain, conn);
      return true;
    }
    // TODO(brycew): make variant that deletes everything with a specific jurisdiction
    final String deleteFromTableStr = CodeTableConstants.getDeleteFrom(tableName);
    boolean tableHasCourt = !deleteFromTableStr.isBlank();
    if (!tableHasCourt) {
      log.warn(
          "Cannot remove the "
              + courtLocation
              + " from "
              + tableName
              + ", a table with no court locations");
      return false;
    }
    try (PreparedStatement st = conn.prepareStatement(deleteFromTableStr)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocation);
      st.executeUpdate();
    }
    return true;
  }

  /**
   * Gets all court location identifiers (CLI) stored in the database. updateTable should have been
   * called on the `location` table before this works.
   *
   * @return a list of all valid CLIs for this jurisdiction
   */
  public List<String> getAllLocations() {
    if (conn == null) {
      log.error("SQL connection is null during getAllLocations");
      return List.of();
    }
    try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.allOrderedQuery())) {
      st.setString(1, tylerDomain);
      ResultSet rs = st.executeQuery();
      var locs = new ArrayList<String>();
      while (rs.next()) {
        locs.add(rs.getString(1));
      }
      rs.close();
      return locs;
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return List.of();
    }
  }

  public List<NameAndCode> getLocationNames() {
    return safetyWrap(
        () -> {
          try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.allNames())) {
            st.setString(1, tylerDomain);
            ResultSet rs = st.executeQuery();
            var names = new ArrayList<NameAndCode>();
            while (rs.next()) {
              names.add(new NameAndCode(rs.getString(1), rs.getString(2)));
            }
            return names;
          }
        });
  }

  public List<String> getFileableLocations() {
    return safetyWrap(
        () -> {
          try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.fileableQuery())) {
            st.setString(1, tylerDomain);
            ResultSet rs = st.executeQuery();
            var codes = new ArrayList<String>();
            while (rs.next()) {
              codes.add(rs.getString(1));
            }
            return codes;
          }
        });
  }

  public List<NameAndCode> getFileableLocationNames() {
    return safetyWrap(
        () -> {
          try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.fileableQuery())) {
            st.setString(1, tylerDomain);
            ResultSet rs = st.executeQuery();
            var codes = new ArrayList<NameAndCode>();
            while (rs.next()) {
              codes.add(new NameAndCode(rs.getString(1), rs.getString(2)));
            }
            return codes;
          }
        });
  }

  public Optional<CourtLocationInfo> getFullLocationInfo(String courtId) {
    return safetyWrapOpt(
        () -> {
          try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.fullSingleQuery())) {
            st.setString(1, tylerDomain);
            st.setString(2, courtId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
              CourtLocationInfo info = new CourtLocationInfo(rs);
              return Optional.of(info);
            } else {
              log.warn("CourtLocation " + courtId + " not found!");
              return Optional.empty();
            }
          }
        });
  }

  /**
   * Gets the full line of succession for a given court, so given "cook:dv6", this would return
   * ["cook:dv6", "cook:dv", "cook", "1", "0"]
   */
  public List<String> getParentList(String courtId) {
    List<String> parentList = new ArrayList<String>();
    String currentCourt = courtId;
    while (!currentCourt.isBlank()) {
      parentList.add(currentCourt);
      try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.parentQuery())) {
        st.setString(1, tylerDomain);
        st.setString(2, currentCourt);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          currentCourt = rs.getString(2);
        } else {
          log.warn("CourtLocation " + currentCourt + ", ancestor of " + courtId + " not found!");
          return parentList;
        }
      } catch (SQLException ex) {
        log.error(
            "CourtLocation "
                + currentCourt
                + ", ancestor of "
                + courtId
                + " made a SQL error: "
                + StdLib.strFromException(ex));
        return parentList;
      }
    }
    return parentList;
  }

  public List<Disclaimer> getDisclaimerRequirements(String courtLocation) {
    return safetyWrap(
        () -> {
          String query = Disclaimer.getDisclaimerRequirements();
          try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, tylerDomain);
            st.setString(2, courtLocation);
            ResultSet rs = st.executeQuery();
            List<Disclaimer> disclaimers = new ArrayList<>();
            while (rs.next()) {
              disclaimers.add(
                  new Disclaimer(
                      rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return disclaimers;
          }
        });
  }

  private <T> List<T> safetyWrap(SQLFunction<List<T>> sup) {
    if (conn == null) {
      log.error("SQL connection not created yet!");
      return List.of();
    }
    try {
      return sup.get();
    } catch (SQLException ex) {
      log.error("SQL excption: " + ex);
      return List.of();
    }
  }

  private <T> Optional<T> safetyWrapOpt(SQLFunction<Optional<T>> sup) {
    if (conn == null) {
      log.error("SQL connection not created yet!");
      return Optional.empty();
    }
    try {
      return sup.get();
    } catch (SQLException ex) {
      log.error("SQL excption: " + ex);
      return Optional.empty();
    }
  }
}
