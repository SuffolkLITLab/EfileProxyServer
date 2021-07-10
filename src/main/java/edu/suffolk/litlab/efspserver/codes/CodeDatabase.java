package edu.suffolk.litlab.efspserver.codes;

import edu.suffolk.litlab.efspserver.DatabaseInterface;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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

  public void createTableIfAbsent(String tableName) throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      log.warn("Must be valid table name: " + tableName + " is not");
      return;
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
      throw new SQLException();
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
      stmt.executeBatch();
      if (!courtName.isEmpty()) {
        update.setString(1, doc.getIdentification().getVersion());
        update.setString(2, courtName);
        update.setString(3, tableName);
        update.executeUpdate();
      }
      // TODO(brycew): handle error here too
    } catch (SQLException ex) {
      log.error("Tried to execute an insert, but failed! Exception: " + ex.toString());
      log.error("Going to rollback updates to this table");
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

  public List<CaseType> getCaseTypesFor(String courtLocationId, String caseCategory)
      throws SQLException {
    if (conn == null) {
      throw new SQLException();
    }

    String query = CodeTableConstants.getCaseTypesFor();
    PreparedStatement st = conn.prepareStatement(query);
    st.setString(1, courtLocationId);
    st.setString(2, caseCategory);
    ResultSet rs = st.executeQuery();
    List<CaseType> cats = new ArrayList<CaseType>();
    while (rs.next()) {
      cats.add(new CaseType(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
          rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
    }
    return cats;
  }

  public Optional<DataFieldRow> getDataField(String courtLocationId, String dataName)
      throws SQLException {
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
    log.info("Query was " + query);
    ResultSet rs = st.executeQuery(query);
    Map<String, List<String>> courtTables = new HashMap<String, List<String>>();
    while (rs.next()) {
      log.debug("!!Result " + rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
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
      log.warn("Table " + tableName + " cannot be deleted");
      return false;
    }
    PreparedStatement st = conn.prepareStatement(deleteFromTable);
    st.setString(1, courtLocation);
    log.info(st.toString());
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

}
