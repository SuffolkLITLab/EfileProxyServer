package edu.suffolk.litlab.efspserver.codes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;
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

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.DatabaseInterface;

/** The class that interfaces with the database tables that contain the Tyler case codes.
 *
 * <p>Codes in this case doesn't mean programming code", it's more like code numbers
 * code names for all of the different case details and information.</p>
 *
 * @author brycew
 */
public class CodeDatabase implements DatabaseInterface, AutoCloseable {
  private final static Logger log =
      LoggerFactory.getLogger(CodeDatabase.class);
  
  private final Connection conn;
  /** The DNS domain (tyler jurisdiction + tyler environment, illinois-stage). */
  private final String tylerDomain;

  public CodeDatabase(String jurisdiction, String env, Connection conn) {
    this.tylerDomain = jurisdiction + "-" + env;
    this.conn = conn;
  }
  
  public CodeDatabase(String jurisdiction, String env, DataSource ds) {
    this.tylerDomain = jurisdiction + "-" + env;
    Connection the_conn;
    try {
      the_conn = ds.getConnection();
    } catch (SQLException e) {
      log.error("In CodeDatabase constructor, can't get connection: " + StdLib.strFromException(e));
      the_conn = null;
    }
    this.conn = the_conn;
  }
  
  public Connection getConnection() {
    return conn;
  }

  @Override
  public void close() throws SQLException {
    if (this.conn != null) {
      this.conn.close();
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

  public void updateTable(String tableName, String courtName, XMLStreamReader xsr) throws JAXBException, SQLException, XMLStreamException {
    Unmarshaller u = JAXBContext.newInstance(CodeListDocument.class).createUnmarshaller();
    final CodeListDocument doc = u.unmarshal(xsr, CodeListDocument.class).getValue();
    updateTable(tableName, courtName, doc);
  }

  public void updateTable(String tableName, String courtName, CodeListDocument doc) throws JAXBException, SQLException, XMLStreamException {
    String insertQuery = CodeTableConstants.getInsertInto(tableName);
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
        singleInsert(stmt, tableName, courtName, rowsVals);
        stmt.addBatch();
      }
      stmt.executeBatch();
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
      log.error("Tried to execute an insert, but failed! Exception: {}", StdLib.strFromException(ex)); 
      log.error("Going to rollback updates to this table");
      throw ex;
    }
  }
  
  public PreparedStatement singleInsert(PreparedStatement stmt, String tableName, String courtName, 
      Map<String, String> rowsVals) throws SQLException {
    int idx = 1;
    List<String> tc = CodeTableConstants.getTableColumns(tableName);
    for (String colName : tc) {
      if (rowsVals.containsKey(colName)) {
        stmt.setString(idx, rowsVals.get(colName));
      } else {
        stmt.setString(idx, null);
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

  public List<CaseCategory> getCaseCategoriesFor(String courtLocationId) {
    return safetyWrap(() -> {
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
  
  public List<CaseCategory> getFilableCaseCategories(String courtLocationId, Optional<Boolean> initial) {
    return safetyWrap(() -> {
      PreparedStatement st;
      if (initial.isPresent()) {
        st = CaseCategory.prepFilableQueryTiming(conn, this.tylerDomain ,courtLocationId, initial.get());
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

  public Optional<CaseCategory> getCaseCategoryWithKey(String courtLocationId, String caseCatCode) {
    return safetyWrapOpt(() -> {
      String query = CaseCategory.getCaseCategoryWithKey();
      try (PreparedStatement st = conn.prepareStatement(query)) {
        st.setString(1, tylerDomain);
        st.setString(2, courtLocationId);
        st.setString(3, caseCatCode);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          CaseCategory newCat = new CaseCategory(rs); 
          return Optional.of(newCat);
        } else {
          log.error("No categories for code " + caseCatCode + " at " + courtLocationId);
          return Optional.empty();
        }
      }
    });
    
  }

  public List<CaseType> getCaseTypesFor(String courtLocationId, String caseCategoryCode, Optional<Boolean> initial) {
    return safetyWrap(() -> {
      PreparedStatement st;
      if (initial.isPresent()) {
        st = CaseType.prepQueryTiming(conn, tylerDomain, courtLocationId, caseCategoryCode, initial);  
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
    return safetyWrapOpt(() -> {
      try (PreparedStatement st = CaseType.prepQueryWithCode(conn, tylerDomain, courtLocationId, caseTypeCode)) {
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          return Optional.of(new CaseType(rs));
        } else {
          return Optional.empty();
        }
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
  }

  public DataFieldRow getDataField(String courtLocationId, String dataName) {
    if (conn == null) {
      log.error("SQL connection not created in DataField yet");
      return DataFieldRow.MissingDataField(dataName);
    }

    String query = DataFieldRow.getAllFromDataFieldConfigForLoc();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      st.setString(3, dataName);
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
  
  public List<NameAndCode> getDataFieldNames(String courtLocationId) {
    if (conn == null) {
      log.error("SQL connection not created in DataField yet");
      return List.of();
    }

    String query = DataFieldRow.getAllDataFieldNames();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      ResultSet rs = st.executeQuery();
      var dataFields = new ArrayList<NameAndCode>(); 
      while (rs.next()) {
        dataFields.add(new NameAndCode(rs.getString(2), rs.getString(1))); 
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
      return new DataFields(Map.of()); 
    }

    String query = DataFieldRow.getAllDataFieldConfigsForLoc();
    try (PreparedStatement st = conn.prepareStatement(query)) {
      st.setString(1, tylerDomain);
      st.setString(2, courtLocationId);
      ResultSet rs = st.executeQuery();
      var dataFieldMap = new HashMap<String, DataFieldRow>();
      while (rs.next()) {
        DataFieldRow dfr = new DataFieldRow(rs.getString(1), rs.getString(2), rs.getString(3),
            rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
            rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
        dataFieldMap.put(dfr.code, dfr);
      }
      return new DataFields(dataFieldMap);
    } catch (SQLException ex) {
      log.error("SQLException: " + ex.toString());
      return new DataFields(Map.of()); 
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

  public List<FilingCode> getFilingType(String courtLocationId, String categoryCode, String typeCode, 
      boolean initial) {
    return safetyWrap(() -> {
      List<FilingCode> filingTypes = new ArrayList<FilingCode>();
      try (PreparedStatement specificSt = 
          FilingCode.prepQueryWithCaseInfo(conn, initial, tylerDomain, courtLocationId, categoryCode, typeCode)) {
        ResultSet rs = specificSt.executeQuery();
        while (rs.next()) {
          filingTypes.add(new FilingCode(rs));
        }
        // If there's nothing for the specific category and type, then get filing types without categories or types
        if (filingTypes.isEmpty()) {
          try (PreparedStatement broadSt = FilingCode.prepQueryNoCaseInfo(
              conn, initial, tylerDomain, courtLocationId)) {
            ResultSet broadRs = broadSt.executeQuery();
            while(broadRs.next()) {
              filingTypes.add(new FilingCode(broadRs));
            }
          }
        }
      }
      return filingTypes;
    });
  }

  public Optional<FilingCode> getFilingTypeWith(String courtLocationId, String filingCode) {
    return safetyWrapOpt(() -> {
      try (PreparedStatement st = FilingCode.prepQueryWithKey(conn, tylerDomain, courtLocationId, filingCode)) {
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          return Optional.of(new FilingCode(rs));
        } else {
          return Optional.empty();
        }
      }
    });
    
  }
  
  public void vacuumAll() throws SQLException {
    String vacuum = CodeTableConstants.vacuumAnalyzeAll();
    try (PreparedStatement vacuumSt = conn.prepareStatement(vacuum)) {
      log.info("Full vacuum statement: " + vacuumSt.toString());
      vacuumSt.executeUpdate();
    }
  }


  public List<NameAndCode> getDamageAmount(String courtLocationId, String caseCategory) {
    return safetyWrap(() -> {
      String query = CodeTableConstants.getDamageAmount();
      List<NameAndCode> amounts = new ArrayList<NameAndCode>();
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
   * Gets the party types that are allowed for a given court and case type.
   * @param courtLocationId
   * @param typeCode Nullable, if null, gets all party types for court, otherwise, just for that case type.
   * @return a list of party types
   */
  public List<PartyType> getPartyTypeFor(String courtLocationId, String typeCode) {
    return safetyWrap(() -> {
      String query = PartyType.getPartyTypeFromCaseType();
      List<PartyType> partyTypes = new ArrayList<>();
      try (PreparedStatement caseSt = conn.prepareStatement(query)) {
        caseSt.setString(1, tylerDomain);
        caseSt.setString(2, courtLocationId);
        if (typeCode != null) {
          caseSt.setString(3, typeCode);
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

  public List<CrossReference> getCrossReference(String courtLocationId, String caseTypeId) {
    return safetyWrap(() -> {
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
    return safetyWrap(() -> {
      String query  = ServiceCodeType.query();
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
      List<String> stateCodes = new ArrayList<String>();
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
    return safetyWrap(() -> {
      String query = FileType.fileTypeQueries();
      try (PreparedStatement st = conn.prepareStatement(query)) {
        st.setString(1, tylerDomain);
        st.setString(2, courtId);
        ResultSet rs = st.executeQuery();
        List<FileType> types = new ArrayList<FileType>();
        while (rs.next()) {
          types.add(new FileType(rs));
        }
        return types;
      }
    });
  }

  public List<FilerType> getFilerTypes(String courtId) {
    return safetyWrap(() -> {
      String query = FilerType.query();
      try (PreparedStatement st = conn.prepareStatement(query)) {
        st.setString(1, tylerDomain);
        st.setString(2, courtId);
        ResultSet rs = st.executeQuery();
        List<FilerType> types = new ArrayList<FilerType>();
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
      try (PreparedStatement st = OptionalServiceCode.prepQuery(conn, tylerDomain, courtId, filingCode)) {
        ResultSet rs = st.executeQuery();
        List<OptionalServiceCode> services = new ArrayList<OptionalServiceCode>();
        while (rs.next()) {
          services.add(new OptionalServiceCode(rs));
        }
        return services;
      }
    });
  }

  public List<String> getLanguages(String courtLocationId) {
    return safetyWrap(() -> {
      String query = CodeTableConstants.getLanguages();
      try (PreparedStatement st = conn.prepareStatement(query)) {
        st.setString(1, tylerDomain);
        st.setString(2, courtLocationId);
        ResultSet rs = st.executeQuery();
        List<String> languages = new ArrayList<String>();
        while (rs.next()) {
          languages.add(rs.getString(2));
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
    String deleteFromTable = CodeTableConstants.getDeleteAllJurisdictionFrom(tableName);
    // TODO(brycew): make variant that deletes everything with a specific jurisdiction
    try (PreparedStatement st = conn.prepareStatement(deleteFromTable)) {
      st.setString(1, tylerDomain);
      log.debug(st.toString());
      st.executeUpdate();
    }
    return true;
  }

  public boolean deleteFromTable(String tableName, String courtLocation) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    String deleteFromTableStr = CodeTableConstants.getDeleteFrom(tableName);
    if (courtLocation == null || courtLocation.isBlank()) {
      log.warn("Don't call this without a valid court: just don't use the var");
      return false;
    }
    // TODO(brycew): make variant that deletes everything with a specific jurisdiction
    boolean tableHasCourt = !deleteFromTableStr.isBlank();
    if (!tableHasCourt) {
      log.warn("Cannot remove the " + courtLocation + " from " + tableName + ", a table with no court locations");
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
   * Gets all court location identifiers (CLI) stored in the database. updateTable
   * should have been called on the `location` table before this works.
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
    return safetyWrap(() -> {
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
    return safetyWrap(() -> {
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
    return safetyWrap(() -> {
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
    return safetyWrapOpt(() -> {
      try (PreparedStatement st = conn.prepareStatement(CourtLocationInfo.fullSingleQuery())) {
        st.setString(1, tylerDomain);
        st.setString(2, courtId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
          CourtLocationInfo info = new CourtLocationInfo(rs);
          return Optional.of(info);
        } else {
          log.error("CourtLocation " + courtId + " not found!");
          return Optional.empty();
        }
      }
    });
  }
  

  public List<Disclaimer> getDisclaimerRequirements(String courtLocation) {
    return safetyWrap(() -> {
      String query = Disclaimer.getDisclaimerRequirements();
      try  (PreparedStatement st = conn.prepareStatement(query)) {
        st.setString(1, tylerDomain);
        st.setString(2, courtLocation);
        ResultSet rs = st.executeQuery();
        List<Disclaimer> disclaimers = new ArrayList<Disclaimer>();
        while (rs.next()) {
          disclaimers.add(new Disclaimer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return disclaimers;
      }
    });
  }

}
