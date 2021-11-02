package edu.suffolk.litlab.efspserver.codes;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;
import org.oasis_open.docs.codelist.ns.genericode._1.Row;
import org.oasis_open.docs.codelist.ns.genericode._1.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.db.DatabaseInterface;

/** The class that interfaces with the database tables that contain the Tyler case codes.
 *
 * <p>Codes in this case doesn't mean programming code", it's more like code numbers
 * code names for all of the different case details and information.</p>
 *
 * @author brycew
 */
public class CodeDatabase extends DatabaseInterface {
  private static Logger log =
      LoggerFactory.getLogger(CodeDatabase.class);

  public CodeDatabase(String pgUrl, int pgPort, String pgDb) {
    super(pgUrl, pgPort, pgDb);
  }

  public CodeDatabase(String pgFullUrl, String pgDb) {
    super(pgFullUrl, pgDb);
  }

  @Override
  public void createTablesIfAbsent() throws SQLException {
    createTableIfAbsent("installedversion");
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
    PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery);
    existsSt.setString(1, tableName);
    ResultSet rs = existsSt.executeQuery();
    boolean next = rs.next();
    int firstVal = rs.getInt(1);
    //log.info("Maybe creating " + tableName + "? next: " + next + ", firstVal: " + firstVal);
    if (!next || firstVal <= 0) { // There's no table! Make one
      String createQuery = CodeTableConstants.getCreateTable(tableName);
      if (createQuery.isEmpty()) {
        log.warn("Will not create table with name: " + tableName);
        return;
      }
      PreparedStatement createSt = conn.prepareStatement(createQuery);
      log.info("Full statement: " + createSt.toString());
      createSt.executeUpdate();
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

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader sr = xmlInputFactory.createXMLStreamReader(inStream);
    Unmarshaller u = JAXBContext.newInstance(CodeListDocument.class).createUnmarshaller();
    final CodeListDocument doc = u.unmarshal(sr, CodeListDocument.class).getValue();

    String insertQuery = CodeTableConstants.getInsertInto(tableName, courtName);
    String versionUpdate = CodeTableConstants.updateVersion();
    try (PreparedStatement stmt = conn.prepareStatement(insertQuery);
        PreparedStatement update = conn.prepareStatement(versionUpdate)) {
      // TODO(brycew-later): dive deeper in the Column set, and see if any Data type isn't a normalizedString.
      //ColumnSet cs = doc.getColumnSet();
      for (Row r : doc.getSimpleCodeList().getRow()) {
        // HACK(brycew): jeez, this is horrible. Figure a better option
        Map<String, String> rowsVals = new HashMap<>();
        for (Value v : r.getValue()) {
          Column c = (Column) v.getColumnRef();
          rowsVals.put(c.getId(), v.getSimpleValue().getValue());
        }
        int idx = 1;
        Optional<List<String>> tc = CodeTableConstants.getTableColumns(tableName);
        for (String colName : tc.orElse(List.of())) {
          if (rowsVals.containsKey(colName)) {
            stmt.setString(idx, rowsVals.get(colName));
          } else {
            stmt.setString(idx, null);
          }
          idx += 1;
        }
        stmt.addBatch();
      }
      stmt.executeBatch();
      // The version table that we directly download references things by "___codes.zip", not the
      // table name. We can translate those here.
      String zipName = CodeTableConstants.getZipNameFromTable(tableName);
      update.setString(1, courtName);
      update.setString(2, zipName);
      update.setString(3, doc.getIdentification().getVersion());
      update.setString(4, doc.getIdentification().getVersion());
      update.executeUpdate();
    } catch (SQLException ex) {
      log.error("Tried to execute an insert, but failed! Exception: " + ex.toString());
      log.error("Going to rollback updates to this table");
      throw ex;
    }
  }

  public List<CaseCategory> getCaseCategoriesFor(String courtLocationId) {
    return safetyWrap(() -> {
      String query = CaseCategory.getCaseCategoriesForLoc();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      ResultSet rs = st.executeQuery();
      List<CaseCategory> cats = new ArrayList<>();
      while (rs.next()) {
        cats.add(new CaseCategory(rs)); 
      }
      return cats;
    });
  }
  
  public List<CaseCategory> getFilableCaseCategories(String courtLocationId, Optional<Boolean> initial) {
    return safetyWrap(() -> {
      PreparedStatement st;
      if (initial.isPresent()) {
        st = CaseCategory.prepFilableQueryTiming(conn, courtLocationId, initial.get());
      } else {
        st = CaseCategory.prepFileableQuery(conn, courtLocationId); 
      }
      ResultSet rs = st.executeQuery();
      List<CaseCategory> cats = new ArrayList<>();
      while (rs.next()) {
        cats.add(new CaseCategory(rs)); 
      }
      return cats;
      
    });
  }

  public Optional<CaseCategory> getCaseCategoryWithKey(String courtLocationId, String caseCatCode) {
    return safetyWrapOpt(() -> {
      String query = CaseCategory.getCaseCategoryWithKey();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      st.setString(2, caseCatCode);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        CaseCategory newCat = new CaseCategory(rs); 
        return Optional.of(newCat);
      } else {
        log.error("No categories for code " + caseCatCode + " at " + courtLocationId);
        return Optional.empty();
      }
    });
    
  }

  public List<CaseType> getCaseTypesFor(String courtLocationId, String caseCategoryCode, Optional<Boolean> initial) {
    return safetyWrap(() -> {
      PreparedStatement st;
      if (initial.isPresent()) {
        st = CaseType.prepQueryTiming(conn, courtLocationId, caseCategoryCode, initial);  
      } else {
        st = CaseType.prepQueryBroad(conn, courtLocationId, caseCategoryCode);
      }
      ResultSet rs = st.executeQuery();
      List<CaseType> types = new ArrayList<>();
      while (rs.next()) {
        types.add(new CaseType(rs));
      }
      return types;
    });
  }
  
  public Optional<CaseType> getCaseTypeWith(String courtLocationId, String caseTypeCode) {
    return safetyWrapOpt(() -> {
      PreparedStatement st = CaseType.prepQueryWithCode(conn, courtLocationId, caseTypeCode);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        return Optional.of(new CaseType(rs));
      } else {
        return Optional.empty();
      }
    });
  }
  
  public List<NameAndCode> getCaseSubtypesFor(String courtLocationId, String caseType)
      throws SQLException {
    if (conn == null) {
      log.error("SQL connection not created in CaseSubtypes yet");
      throw new SQLException();
    }

    String query = CodeTableConstants.getCaseSubtypesFor();
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, courtLocationId);
    st.setString(2, caseType);
    ResultSet rs = st.executeQuery();
    List<NameAndCode> subtypes = new ArrayList<NameAndCode>();
    while (rs.next()) {
      subtypes.add(new NameAndCode(rs.getString(2), rs.getString(1)));
    }
    return subtypes;
  }

  public DataFieldRow getDataField(String courtLocationId, String dataName) {
    if (conn == null) {
      log.error("SQL connection not created in DataField yet");
      return DataFieldRow.MissingDataField(dataName);
    }

    try {
      String query = CodeTableConstants.getAllFromDataFieldConfigForLoc();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      st.setString(2, dataName);
      ResultSet rs = st.executeQuery();
      if (!rs.next()) {
        return DataFieldRow.MissingDataField(dataName);
      }
      DataFieldRow dfr = new DataFieldRow(rs.getString(1), rs.getString(2), rs.getString(3),
          rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
          rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
      return dfr;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return DataFieldRow.MissingDataField(dataName);
    }
  }

  public List<NameAndCode> getProcedureOrRemedy(String courtLocationId, String caseCategory) {
    if (conn == null) {
      log.error("SQL connection not created in ProcedureOrRemedy yet");
      return List.of();
    }

    String query = CodeTableConstants.getProcedureOrRemedy();
    try {
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      st.setString(2, caseCategory);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> names = new ArrayList<NameAndCode>();
      while (rs.next()) {
        names.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return names;
    } catch (SQLException ex) {
      log.error("SQLExeception: " + ex);
      return List.of();
    }
  }

  public List<FilingCode> getFilingType(String courtLocationId, String categoryCode, String typeCode, boolean initial) {
    return safetyWrap(() -> {
      PreparedStatement specificSt = FilingCode.prepQueryWithCaseInfo(conn, initial, courtLocationId, categoryCode, typeCode);
      ResultSet rs = specificSt.executeQuery();
      List<FilingCode> filingTypes = new ArrayList<FilingCode>();
      while (rs.next()) {
        filingTypes.add(new FilingCode(rs));
      }
      // If there's nothing for the specific category and type, then get filing types without categories or types
      if (filingTypes.isEmpty()) {
        PreparedStatement broadSt = FilingCode.prepQueryNoCaseInfo(conn, initial, courtLocationId);
        broadSt.setString(1, courtLocationId);
        ResultSet broadRs = broadSt.executeQuery();
        while(broadRs.next()) {
          filingTypes.add(new FilingCode(broadRs));
        }
      }
      return filingTypes;
    });
  }

  public Optional<FilingCode> getFilingTypeWith(String courtLocationId, String filingCode) {
    return safetyWrapOpt(() -> {
      PreparedStatement st = FilingCode.prepQueryWithKey(conn, courtLocationId, filingCode); 
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        return Optional.of(new FilingCode(rs));
      } else {
        return Optional.empty();
      }
    });
    
  }


  public List<NameAndCode> getDamageAmount(String courtLocationId, String caseCategory) {
    return safetyWrap(() -> {
      String query = CodeTableConstants.getDamageAmount();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      st.setString(2, caseCategory);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> amounts = new ArrayList<NameAndCode>();
      while (rs.next()) {
        amounts.add(new NameAndCode(rs.getString(2), rs.getString(1)));
      }
      return amounts;
    });
  }

  public List<PartyType> getPartyTypeFor(String courtLocationId, String typeCode) {
    return safetyWrap(() -> {
      String query = PartyType.getPartyTypeFromCaseType();
      PreparedStatement caseSt = conn.prepareStatement(query);
      caseSt.setString(1, courtLocationId);
      caseSt.setString(2, typeCode);
      ResultSet rs = caseSt.executeQuery();
      List<PartyType> partyTypes = new ArrayList<>();
      while (rs.next()) {
        partyTypes.add(new PartyType(rs));
      }
      if (partyTypes.isEmpty()) {
        String broadQuery = PartyType.getPartyTypeNoCaseType();
        PreparedStatement broadSt = conn.prepareStatement(broadQuery);
        broadSt.setString(1, courtLocationId);
        ResultSet broadRs = broadSt.executeQuery();
        while (broadRs.next()) {
          partyTypes.add(new PartyType(broadRs));
        }
      }
      return partyTypes;
    });
  }

  public List<CrossReference> getCrossReference(String courtLocationId, String caseTypeId) {
    return safetyWrap(() -> {
      PreparedStatement st = conn.prepareStatement(CrossReference.query());
      st.setString(1, courtLocationId);
      st.setString(2, caseTypeId);
      ResultSet rs = st.executeQuery();
      List<CrossReference> types = new ArrayList<>();
      while (rs.next()) {
        types.add(new CrossReference(rs));
      }
      return types;
    });
  }

  public List<ServiceCodeType> getServiceTypes(String courtLocationId) {
    return safetyWrap(() -> {
      String query  = ServiceCodeType.query();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      ResultSet rs = st.executeQuery();
      List<ServiceCodeType> types = new ArrayList<>();
      while (rs.next()) {
        types.add(new ServiceCodeType(rs));
      }
      return types;
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

  public List<DocumentTypeTableRow> getDocumentTypes(String courtLocationId, String filingCodeId) {
    if (conn == null) {
      log.error("SQL connection not created in Document Type yet");
      return List.of();
    }

    try {
      String specificQuery = DocumentTypeTableRow.getDocumentTypeWithFilingCode();
      PreparedStatement specificSt = conn.prepareStatement(specificQuery);
      specificSt.setString(1, courtLocationId);
      specificSt.setString(2, filingCodeId);
      ResultSet spefRs = specificSt.executeQuery();
      List<DocumentTypeTableRow> docTypes = new ArrayList<DocumentTypeTableRow>();
      while (spefRs.next()) {
        docTypes.add(new DocumentTypeTableRow(spefRs));
      }
      if (docTypes.isEmpty()) {
        String broadQuery = DocumentTypeTableRow.getDocumentTypeNoFiling();
        PreparedStatement broadSt = conn.prepareStatement(broadQuery);
        broadSt.setString(1, courtLocationId);
        ResultSet broadRs = broadSt.executeQuery();
        while (broadRs.next()) {
          docTypes.add(new DocumentTypeTableRow(broadRs));
        }
      }
      return docTypes;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return List.of();
    }
  }

  public List<NameAndCode> getMotionTypes(String courtLocationId, String filingCodeId) {
    if (conn == null) {
      log.error("SQL connection not created in MotionTypes yet");
      return List.of();
    }

    try {
      String query = CodeTableConstants.getMotionTypes();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      st.setString(2, filingCodeId);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> motions = new ArrayList<NameAndCode>();
      while (rs.next()) {
        motions.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return motions;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return List.of();
    }
  }

  public List<NameAndCode> getNameSuffixes(String courtLocationId) {
    if (conn == null) {
      log.error("SQL connection not created in NameSuffixes yet");
      return List.of();
    }

    try {
      String query = CodeTableConstants.getNameSuffixes();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> motions = new ArrayList<NameAndCode>();
      while (rs.next()) {
        motions.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return motions;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return List.of();
    }
  }

  public List<FilingComponent> getFilingComponents(String courtLocationId, String filingCodeId) {
    if (conn == null) {
      log.error("SQL connection not created in FilingComponents yet");
      return List.of();
    }

    try {
      String query = FilingComponent.getFilingComponents();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      st.setString(2, filingCodeId);
      ResultSet rs = st.executeQuery();
      List<FilingComponent> components = new ArrayList<FilingComponent>();
      while (rs.next()) {
        components.add(new FilingComponent(rs));
      }
      return components;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return List.of();
    }
  }

  public List<String> getStateCodes(String country) {
    if (conn == null) {
      log.error("Connection not started in state codes?");
      return List.of();
    }

    String query = CodeTableConstants.getSpecificStatesForCountryForLoc();
    try {
      PreparedStatement st = conn.prepareStatement(query);
      // TODO(brycew-later): Tyler docs say state is a system table, but there's one per court?
      // Hardcoding the system "0" for now
      st.setString(1, "0");
      st.setString(2, country);
      ResultSet rs = st.executeQuery();
      List<String> stateCodes = new ArrayList<String>();
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
    return safetyWrap(() -> {
      String query = FileType.fileTypeQueries();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtId);
      ResultSet rs = st.executeQuery();
      List<FileType> types = new ArrayList<FileType>();
      while (rs.next()) {
        types.add(new FileType(rs));
      }
      return types;
    });
  }

  public List<FilerType> getFilerTypes(String courtId) {
    return safetyWrap(() -> {
      String query = FilerType.query();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtId);
      ResultSet rs = st.executeQuery();
      List<FilerType> types = new ArrayList<FilerType>();
      while (rs.next()) {
        types.add(new FilerType(rs));
      }
      return types;
    });
  }

  public List<NameAndCode> getFilingStatuses(String courtId) {
    if (conn == null) {
      log.error("connection not started in FilingStatus");
      return List.of();
    }

    String query = CodeTableConstants.getFilingStatuses();
    try {
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtId);
      ResultSet rs = st.executeQuery();
      List<NameAndCode> names = new ArrayList<NameAndCode>();
      while (rs.next()) {
        names.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return names;
    } catch (SQLException ex) {
      log.error("SQLExecption: " + ex);
      return List.of();
    }
  }

  public List<OptionalServiceCode> getOptionalServices(String courtId, String filingCode) {
    return safetyWrap(() -> {
      PreparedStatement st = OptionalServiceCode.prepQuery(conn, courtId, filingCode);
      ResultSet rs = st.executeQuery();
      List<OptionalServiceCode> services = new ArrayList<OptionalServiceCode>();
      while (rs.next()) {
        services.add(new OptionalServiceCode(rs));
      }
      return services;
    });
  }

  public List<String> getLanguages(String courtLocationId) {
    return safetyWrap(() -> {
      String query = CodeTableConstants.getLanguages();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocationId);
      ResultSet rs = st.executeQuery();
      List<String> languages = new ArrayList<String>();
      while (rs.next()) {
        languages.add(rs.getString(2));
      }
      return languages;
    });
  }

  /** Returns map of court locations to the list of tables they need to update. */
  public Map<String, List<String>> getVersionsToUpdate() throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    Statement st = conn.createStatement();
    String query = CodeTableConstants.needToUpdateVersion();
    log.info("Query was " + query);
    ResultSet rs = st.executeQuery(query);
    Map<String, List<String>> courtTables = new HashMap<String, List<String>>();
    while (rs.next()) {
      if (rs.getString(3) != null) {
        log.info("Updating for location: " + rs.getString(1) + ", codelist: " + rs.getString(2)
            + ", current version is " + rs.getString(3) + ", " + rs.getString(4) + " is available");
      } else {
        log.info("Updating for location: " + rs.getString(1) + ", codelist: " + rs.getString(2)
            + ", no current version");
      }
      if (!courtTables.containsKey(rs.getString(1))) {
        courtTables.put(rs.getString(1), new ArrayList<String>());
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
    return courtTables;
  }

  public boolean dropTables(Iterable<String> tablesToDrop) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    Statement st = conn.createStatement();
    for (String table : tablesToDrop) {
      // Not how to check for things that don't work, eh
      String dropIfPresent = CodeTableConstants.dropTable(table);
      if (!dropIfPresent.isEmpty()) {
        st.executeUpdate(dropIfPresent);
      }
    }
    return true;
  }

  public boolean deleteFromTable(String tableName, String courtLocation) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    String deleteFromTable = CodeTableConstants.deleteFromTable(tableName);
    if (deleteFromTable.isEmpty()) {
      if (courtLocation.equals("0")) {
        log.warn("Why are we removing location=0 entries from " + tableName + "?");
        return false;
      } else {
        log.warn("Table " + tableName + " cannot be deleted from");
        return false;
      }
    }
    PreparedStatement st = conn.prepareStatement(deleteFromTable);
    st.setString(1, courtLocation);
    log.debug(st.toString());
    st.executeUpdate();
    return true;
  }

  /**
   * Gets all court location identifiers (CLI) stored in the database. updateTable
   * should have been called on the `location` table before this works.
   *
   * @return              a list of all valid CLIs for this jurisdiction
   * @throws SQLException if something goes wrong, or if the connection hasn't
   *                      been made yet
   */
  public List<String> getAllLocations() throws SQLException {
    if (conn == null) {
      log.error("SQL connection is null during getAllLocations");
      return List.of();
    }
    try {
      Statement st = conn.createStatement();
      String query = CourtLocationInfo.allOrderedQuery();
      ResultSet rs = st.executeQuery(query);
      List<String> locs = new ArrayList<String>();
      while (rs.next()) {
        locs.add(rs.getString(1));
      }

      return locs;
    } catch (SQLException ex) {
      log.error("SQLException: " + ex);
      if (!conn.getAutoCommit()) {
        conn.commit();
      }
      return List.of();
    }
  }

  public List<NameAndCode> getLocationNames() {
    return safetyWrap(() -> {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(CourtLocationInfo.allNames());
      List<NameAndCode> names = new ArrayList<NameAndCode>();
      while (rs.next()) {
        names.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return names;
    });
  }

  public List<String> getFileableLocations() {
    return safetyWrap(() -> {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(CourtLocationInfo.fileableQuery());
      List<String> codes = new ArrayList<String>();
      while (rs.next()) {
        codes.add(rs.getString(1));
      }
      return codes;
    });
  }
  
  public List<NameAndCode> getFileableLocationNames() {
    return safetyWrap(() -> {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(CourtLocationInfo.fileableQuery());
      List<NameAndCode> codes = new ArrayList<NameAndCode>();
      while (rs.next()) {
        codes.add(new NameAndCode(rs.getString(1), rs.getString(2)));
      }
      return codes;
    });
  }


  public Optional<CourtLocationInfo> getFullLocationInfo(String courtId) {
    return safetyWrapOpt(() -> {
      PreparedStatement st = conn.prepareStatement(CourtLocationInfo.fullSingleQuery());
      st.setString(1, courtId);
      ResultSet rs = st.executeQuery();
      if (rs.next()) {
        CourtLocationInfo info = new CourtLocationInfo(rs);
        return Optional.of(info);
      } else {
        log.error("CourtLocation " + courtId + " not found!");
        return Optional.empty();
      }
    });
  }
  

  public List<Disclaimer> getDisclaimerRequirements(String courtLocation) {
    return safetyWrap(() -> {
      String query = Disclaimer.getDisclaimerRequirements();
      PreparedStatement st = conn.prepareStatement(query);
      st.setString(1, courtLocation);
      ResultSet rs = st.executeQuery();
      List<Disclaimer> disclaimers = new ArrayList<Disclaimer>();
      while (rs.next()) {
        disclaimers.add(new Disclaimer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
      }
      return disclaimers;
    });
  }

}
