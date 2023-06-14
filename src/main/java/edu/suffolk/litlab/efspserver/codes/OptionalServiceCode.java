package edu.suffolk.litlab.efspserver.codes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Column;
import org.oasis_open.docs.codelist.ns.genericode._1.Value;

public class OptionalServiceCode {
  public final String code;
  public final String name;
  /**
   * An int to represent the order in which to present the optional services. Will always be
   * present, but might skip numbers or two rows might have the same value: ordering doesn't matter
   * then.
   */
  public final int displayorder;
  /** The Fee associated with this optional service. */
  public final String fee;
  /** This service is only allowed for this given filing code id. */
  public final String filingcodeid;
  /**
   * Uses a fee multiplier: for instance, if true, a request for 3 certified copies would have a
   * value of 3.
   */
  public final boolean multiplier;
  /** A textual description for a fee that has a calculated value. */
  public final String altfeedesc;
  /** True if the filer must provide a fee amount (?). */
  public final boolean hasfeeprompt;
  /** Text presented to the filer when prompting for the fee amount. */
  public final String feeprompttext;

  public OptionalServiceCode(
      String code,
      String name,
      int displayorder,
      String fee,
      String filingcodeid,
      boolean multiplier,
      String altfeedesc,
      boolean hasfeeprompt,
      String feeprompttext) {
    this.code = code;
    this.name = name;
    this.displayorder = displayorder;
    this.fee = fee;
    this.filingcodeid = filingcodeid;
    this.multiplier = multiplier;
    this.altfeedesc = altfeedesc;
    this.hasfeeprompt = hasfeeprompt;
    this.feeprompttext = feeprompttext;
  }

  public OptionalServiceCode(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        rs.getInt(3),
        rs.getString(4),
        rs.getString(5),
        rs.getBoolean(6),
        rs.getString(7),
        rs.getBoolean(8),
        rs.getString(9));
  }

  public static PreparedStatement prepQuery(
      Connection conn, String domain, String courtId, String filingCodeId) throws SQLException {
    PreparedStatement st = conn.prepareStatement(query());
    st.setString(1, domain);
    st.setString(2, courtId);
    st.setString(3, filingCodeId);
    return st;
  }

  public static String query() {
    return """
        SELECT os.code, os.name, os.displayorder, os.fee, os_fl.filingcodeid, os.multiplier, os.altfeedesc, os.hasfeeprompt,
          os.feeprompttext
        FROM optionalservices as os JOIN optionalservices_filinglist as os_fl ON os.domain=os_fl.domain AND os.location=os_fl.location AND os.code=os_fl.code
        WHERE os.domain=? AND os.location=? AND os_fl.filingcodeid=?
        """;
  }

  public static void createFromOptionalServiceTable(Connection conn) throws SQLException {
    final String CREATE_MAIN =
        """
      CREATE TABLE optionalservices (
          "code" varchar(40),
          "name" text,
          "displayorder" integer,
          "fee" text,
          "multiplier" boolean,
          "altfeedesc" text,
          "hasfeeprompt" boolean,
          "feeprompttext" text,
          "efspcode" text,
          "domain" varchar(80),
          "location" varchar(80)
      )
          """;
    final String CREATE_FL =
        """
      CREATE TABLE optionalservices_filinglist (
          "code" varchar(40),
          "filingcodeid" varchar(40),
          "domain" varchar(80),
          "location" varchar(80)
      )
        """;
    try (Statement createSt = conn.createStatement()) {
      createSt.executeUpdate(CREATE_MAIN);
      createSt.executeUpdate(CREATE_FL);
    }
  }

  public static void createIndices(Connection conn) throws SQLException {
    var indices =
        List.of(
            "CREATE INDEX ON optionalservices (location)",
            "CREATE INDEX ON optionalservices (domain)",
            "CREATE INDEX ON optionalservices_filinglist (location)",
            "CREATE INDEX ON optionalservices_filinglist (domain)");
    try (Statement statement = conn.createStatement()) {
      for (var myStr : indices) {
        statement.executeUpdate(myStr);
      }
    }
  }

  public static void deleteFromOptionalServiceTable(
      String courtLocation, String tylerDomain, Connection conn) throws SQLException {
    final String DELETE_FROM =
        (courtLocation == null)
            ? "DELETE FROM optionalservices WHERE domain=?"
            : "DELETE FROM optionalservices WHERE domain=? AND location=?";
    final String DELETE_FROM_FL =
        (courtLocation == null)
            ? "DELETE FROM optionalservices_filinglist WHERE domain=?"
            : "DELETE FROM optionalservices_filinglist WHERE domain=? AND location=?";
    try (PreparedStatement stmt = conn.prepareStatement(DELETE_FROM);
        PreparedStatement stmtFL = conn.prepareStatement(DELETE_FROM_FL)) {
      stmt.setString(1, tylerDomain);
      stmtFL.setString(1, tylerDomain);
      if (courtLocation != null) {
        stmt.setString(2, courtLocation);
        stmtFL.setString(2, courtLocation);
      }
      stmt.executeUpdate();
      stmtFL.executeUpdate();
    }
  }

  public static void updateOptionalServiceTable(
      String courtName, String tylerDomain, CodeListDocument doc, Connection conn)
      throws SQLException {
    String insertMainQuery =
        """
      INSERT INTO "optionalservices" ("code", "name", "displayorder", "fee", "multiplier", "altfeedesc", "hasfeeprompt",
        "feeprompttext", "efspcode", "domain", "location"
      ) VALUES (
        ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
      )
        """;
    String insertFLQuery =
        """
      INSERT INTO "optionalservices_filinglist" ("code", "filingcodeid", "domain", "location"
      ) VALUES (
        ?, ?, ?, ?
      )
        """;
    try (PreparedStatement stmt = conn.prepareStatement(insertMainQuery);
        PreparedStatement stmtFilingList = conn.prepareStatement(insertFLQuery)) {
      for (var r : doc.getSimpleCodeList().getRow()) {
        // HACK(brycew): jeez, this is horrible. Figure a better option
        for (Value v : r.getValue()) {
          Column c = (Column) v.getColumnRef();
          String colName = c.getId();
          if (colName.equals("code")) {
            stmt.setString(1, v.getSimpleValue().getValue());
            stmtFilingList.setString(1, v.getSimpleValue().getValue());
          } else if (colName.equals("filingcodeid")) {
            stmtFilingList.setString(2, v.getSimpleValue().getValue());
          } else if (colName.equals("name")) {
            stmt.setString(2, v.getSimpleValue().getValue());
          } else if (colName.equals("displayorder")) {
            stmt.setInt(3, Integer.parseInt(v.getSimpleValue().getValue()));
          } else if (colName.equals("fee")) {
            stmt.setString(4, v.getSimpleValue().getValue());
          } else if (colName.equals("multiplier")) {
            stmt.setBoolean(5, Boolean.parseBoolean(v.getSimpleValue().getValue()));
          } else if (colName.equals("altfeedesc")) {
            stmt.setString(6, v.getSimpleValue().getValue());
          } else if (colName.equals("hasfeeprompt")) {
            stmt.setBoolean(7, Boolean.parseBoolean(v.getSimpleValue().getValue()));
          } else if (colName.equals("feeprompttext")) {
            stmt.setString(8, v.getSimpleValue().getValue());
          } else if (colName.equals("efspcode")) {
            stmt.setString(9, v.getSimpleValue().getValue());
          }
        }
        stmt.setString(10, tylerDomain);
        stmtFilingList.setString(3, tylerDomain);
        stmt.setString(11, courtName);
        stmtFilingList.setString(4, courtName);
        stmt.addBatch();
        stmtFilingList.addBatch();
      }
      stmt.executeBatch();
      stmtFilingList.executeBatch();
    }
  }
}
