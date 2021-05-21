package edu.suffolk.assemblyline.efspserver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
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

public class CodeDatabase {
  private final String pgUrl;
  private final String pgPort;
  private final String pgDb;

  private Connection conn;

  public CodeDatabase() {
    this(System.getenv("POSTGRES_URL"), System.getenv("POSTGRES_PORT"),
        System.getenv("POSTGRES_CODES_DB"));
  }

  public CodeDatabase(String pgUrl, String pgPort, String pgDb) {
    this.pgUrl = pgUrl;
    this.pgPort = pgPort;
    this.pgDb = pgDb;
  }

  public void createTableIfAbsent(String tableName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      System.err.println("Must be valid table name: " + tableName + " is not");
    }

    // TODO(brycew): eventually make the create tables have foreign keys and
    // required
    // from the Id/ columnRefs
    String tableExistsQuery = CodeTableConstants.getTableExists();
    PreparedStatement existsSt = conn.prepareStatement(tableExistsQuery);
    existsSt.setString(1, tableName);
    ResultSet rs = existsSt.executeQuery();
    if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
      String createQuery = CodeTableConstants.getCreateTable(tableName);
      if (createQuery.isEmpty()) {
        System.out.println("Will not create table with name: " + tableName);
        return;
      }
      PreparedStatement createSt = conn.prepareStatement(createQuery);
      System.out.println("Full statement: " + createSt.toString());
      createSt.executeUpdate();
    }

  }

  public void updateTable(String tableName, String courtName, InputStream inStream)
      throws JAXBException, SQLException, XMLStreamException {
    if (conn == null) {
      throw new SQLException();
    }
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      System.err.println("Must be valid table name: " + tableName + " is not");
    }

    createTableIfAbsent(tableName);

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    XMLStreamReader sr = xmlInputFactory.createXMLStreamReader(inStream);
    Unmarshaller u = JAXBContext.newInstance(CodeListDocument.class).createUnmarshaller();
    final CodeListDocument doc = u.unmarshal(sr, CodeListDocument.class).getValue();

    String insertQuery = CodeTableConstants.getInsertInto(tableName, courtName);
    String updateQuery = CodeTableConstants.updateVersion();
    try (PreparedStatement stmt = conn.prepareStatement(insertQuery);
        PreparedStatement update = conn.prepareStatement(updateQuery)) {
      for (Row r : doc.getSimpleCodeList().getRow()) {
        // HACK(brycew): jeez, this is horrible. Figure a better option
        Map<String, String> rowsVals = new HashMap<String, String>();
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
            stmt.setNull(idx, Types.VARCHAR);
          }
          idx += 1;
        }
        stmt.addBatch();
      }
      int[] addedRowsPerQuery = stmt.executeBatch();
      if (!courtName.isEmpty()) {
        update.setString(1, doc.getIdentification().getVersion());
        update.setString(2, courtName);
        update.setString(3, tableName);
        update.executeUpdate();
      }
      // TODO(brycew): handle error here too
    } catch (SQLException ex) {
      System.err.println("Tried to execute an insert, but failed! Exception: " + ex.toString());
      System.err.println("Going to rollback updates to this table");
      throw ex;
    }
  }

  public List<CaseCategory> getCaseCategoriesFor(String courtLocationId) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    String query = CodeTableConstants.getCaseCategoryForLoc();
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, courtLocationId);
    ResultSet rs = st.executeQuery();
    List<CaseCategory> cats = new ArrayList<CaseCategory>();
    while (rs.next()) {
      cats.add(new CaseCategory(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
          rs.getString(5), rs.getString(6)));
    }
    return cats;
  }
  
  public Optional<DataFieldRow> getDataField(String courtLocationId, String dataName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    
    String query = CodeTableConstants.getAllFromDataFieldForLoc();
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, courtLocationId);
    st.setString(2, dataName);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) {
      return Optional.empty();
    }
    
    DataFieldRow dfr = new DataFieldRow(rs.getString(1), rs.getString(2), rs.getString(3), 
        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), 
        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
    
    return Optional.of(dfr);
  }

  public List<PartyType> getPartyTypeFor(String courtLocationId, String caseCategory)
      throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }

    String query = CodeTableConstants.getPartyTypeFromCaseType();
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, courtLocationId);
    st.setString(2, caseCategory);
    ResultSet rs = st.executeQuery();
    List<PartyType> partyTypes = new ArrayList<PartyType>();
    while (rs.next()) {
      partyTypes
          .add(new PartyType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5)));
    }
    return partyTypes;
  }

  /** Returns map of court locations to the list of tables they need to update. */
  public Map<String, List<String>> getVersionsToUpdate() throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    Statement st = conn.createStatement();
    String query = CodeTableConstants.needToUpdateVersion();
    System.err.println("Query was " + query);
    ResultSet rs = st.executeQuery(query);
    Map<String, List<String>> courtTables = new HashMap<String, List<String>>();
    while (rs.next()) {
      System.err
          .println("!!Result " + rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
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
      System.err.println("Table " + tableName + " cannot be deleted");
      return false;
    }
    PreparedStatement st = conn.prepareStatement(deleteFromTable);
    System.err.println(st.toString());
    st.setString(1, courtLocation);
    System.err.println(st.toString());
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
    String query = "SELECT DISTINCT code FROM location ORDER BY code";
    if (conn == null) {
      throw new SQLException();
    }
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    List<String> locs = new ArrayList<String>();
    while (rs.next()) {
      locs.add(rs.getString(1));
    }

    return locs;
  }

  /**
   * Creates an internally held connection to the database with environment
   * variables POSTGRES_USER and POSTGRES_PASSWORD.
   */
  public void createDbConnection() throws SQLException {
    createDbConnection(System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"));
  }

  /**
   * Creates an internally held connection to the database with the given user and
   * password.
   *
   * @param  pgUser       The user of the PostgreSQL database
   * @param  pgPassword   The password for the above user
   * @throws SQLException if the connection cannot be completed for some reason
   */
  public void createDbConnection(String pgUser, String pgPassword) throws SQLException {
    // TODO(brycew): automatically make a 'tyler_efm_codes' database if it doesn't
    // exist.
    String url = "jdbc:postgresql://" + this.pgUrl + ":" + this.pgPort + "/" + this.pgDb;
    Properties props = new Properties();
    props.setProperty("user", pgUser);
    props.setProperty("password", pgPassword);
    conn = DriverManager.getConnection(url, props);
    conn.setAutoCommit(false);
  }

  public Savepoint setSavePoint(String savepoint) throws SQLException {
    return conn.setSavepoint(savepoint);
  }

  public void rollback(Savepoint savepoint) throws SQLException {
    conn.rollback(savepoint);
  }

  public void commit() throws SQLException {
    conn.commit();
  }

}
