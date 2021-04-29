package edu.suffolk.assemblyline.efspserver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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
import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;
import org.oasis_open.docs.codelist.ns.genericode._1.Row;
import org.oasis_open.docs.codelist.ns.genericode._1.Value;

public class CodeDatabase {
  private final String pgUrl;
  private final String pgPort;
  private final String pgDb;
  
  public CodeDatabase() {
    this(System.getenv("POSTGRES_URL"), System.getenv("POSTGRES_PORT"), 
        System.getenv("POSTGRES_CODES_DB"));
  }
  
  public CodeDatabase(String pgUrl, String pgPort, String pgDb) {
    this.pgUrl = pgUrl;
    this.pgPort = pgPort;
    this.pgDb = pgDb;
  }

  public void updateTable(String tableName, String courtName, 
      InputStream inStream, Connection dbConn) throws JAXBException, SQLException {
    if (tableName.contains("(") || tableName.contains(")") || tableName.contains(" ")) {
      System.err.println("Must be valid table name: " + tableName + " is not");
    }
    String tableExistsQuery = CodeTableConstants.getTableExists();
    JAXBContext jc = JAXBContext.newInstance(CodeListDocument.class);
    Unmarshaller u = jc.createUnmarshaller();
    JAXBElement<CodeListDocument> doc = 
        (JAXBElement<CodeListDocument>) u.unmarshal(inStream); 
    final CodeListDocument trueDoc = doc.getValue();
    
    PreparedStatement existsSt = dbConn.prepareStatement(tableExistsQuery); 
    existsSt.setString(1, tableName);
    //System.out.println("tableExistsQuery: " + existsSt.toString());
    ResultSet rs = existsSt.executeQuery();
    if (!rs.next() || rs.getInt(1) <= 0) { // There's no table! Make one
      //System.out.println("rs: " + rs.getInt(1) + ", " + rs.getFetchSize());
      String createQuery = CodeTableConstants.getCreateTable(tableName); 
      if (createQuery.isEmpty()) {
        System.out.println("Will not create table with name: " + tableName
            + ", court: " + courtName);
      }
      PreparedStatement createSt = dbConn.prepareStatement(createQuery);
      System.out.println("Full statement: " + createSt.toString());
      int created = createSt.executeUpdate();
      // TODO(brycew): check for returned < 0?
    }

    // TODO(brycew): eventually make the create tables have foreign keys and required
    // from the Id/ columnRefs

    String insertQuery = CodeTableConstants.getInsertInto(tableName, courtName);
    try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)){
      dbConn.setAutoCommit(false);
      for (Row r : trueDoc.getSimpleCodeList().getRow()) {
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
            System.err.println("Couldn't find " + colName + " in row vals");
            stmt.setNull(idx, Types.VARCHAR);
          }
          idx += 1;
        }
        stmt.addBatch();
      }
      int[] addedRowsPerQuery = stmt.executeBatch();
      //if (addedRowsPerQuery <= 0) {
      //  System.err.println("Boo, for " + stmt.toString() + ", row wasn't added?");
        // TODO(brycew): handle error here too
      //}
    } catch (SQLException ex) {
      System.err.println("Tried to execute an insert, but failed! Exception: " + ex.toString());
      System.err.println("Going to rollback updates to this table");
      dbConn.rollback();
      throw ex;
    }
    dbConn.commit();
  }
  
  public List<String> getAllLocations() throws SQLException {
    String query = "SELECT DISTINCT code FROM location ORDER BY code";
    Connection dbConn = createDbConnection();
    Statement st = dbConn.createStatement();
    ResultSet rs = st.executeQuery(query);
    List<String> locs = new ArrayList<String>();
    while (rs.next()) {
      locs.add(rs.getString(1));
    } 
 
    return locs;
  }

  /**
   * Writes a CSV file from the given codes map object. Mostly for easy viewing of the codes.
   */
  public void writeCsv(Map<String, Map<String, String>> codes, 
                              String outFileName) throws IOException {
    File outFile = new File(outFileName);
    BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

    writer.append(String.join(";", codes.keySet()));
    
    List<String> colOrder = new ArrayList<String>();
    for (Map.Entry<String, Map<String, String>> entry : codes.entrySet()) {
      colOrder.add(entry.getKey()); 
      writer.append(entry.getKey());
      writer.append(";");
    }
    writer.newLine();
    
    for (Map.Entry<String, Map<String, String>> entry : codes.entrySet()) {
      for (String col : colOrder) {
        writer.append(entry.getValue().get(col));
        writer.append(";");
      }
      writer.newLine();
    }

    writer.close();
  }

  public Connection createDbConnection() throws SQLException {
    return createDbConnection(System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"));
  }

  public Connection createDbConnection(String pgUser, String pgPassword) throws SQLException {
    // TODO(brycew): automatically make a 'tyler_efm_codes' database if it doesn't exist.
    String url = "jdbc:postgresql://" + this.pgUrl + ":" + this.pgPort + "/" + this.pgDb;
    Properties props = new Properties();
    props.setProperty("user", pgUser); 
    props.setProperty("password", pgPassword);
    Connection conn = DriverManager.getConnection(url, props);
    return conn;
  }

}
