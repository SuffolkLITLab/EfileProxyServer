package edu.suffolk.litlab.efsp.ecfcodes;

import edu.suffolk.litlab.efsp.db.Database;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;

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
      throws JAXBException, SQLException, XMLStreamException;

  public abstract void updateTable(String tableName, String courtName, CodeListDocument doc)
      throws SQLException;

  public void updateTable(String tableName, String courtName, XMLStreamReader xsr)
      throws JAXBException, SQLException {
    Unmarshaller u = JAXBContext.newInstance(CodeListDocument.class).createUnmarshaller();
    final CodeListDocument doc = u.unmarshal(xsr, CodeListDocument.class).getValue();
    this.updateTable(tableName, courtName, doc);
  }

  public abstract boolean deleteFromTable(String tableName) throws SQLException;

  public abstract boolean deleteFromTable(String tableName, String courtLocation)
      throws SQLException;

  public abstract void createTableIfAbsent(String tableName) throws SQLException;

  public abstract Map<String, List<String>> getVersionsToUpdate() throws SQLException;

  // TODO(brycew): needed for compatibility, but should be renamed to something more general
  // i.e. 'postUpdateClean'
  public abstract void vacuumAll();
}
