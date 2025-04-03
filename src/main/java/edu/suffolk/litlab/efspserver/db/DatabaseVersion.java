package edu.suffolk.litlab.efspserver.db;

import static edu.suffolk.litlab.efspserver.StdLib.strFromException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Updates all of the collective tables for a consistent "schema". Since this class should work
 * going back to extremely old versions of the code, this class should be completely self contained,
 * only using SQL queries from here.
 *
 * @author brycew
 */
public class DatabaseVersion {

  static final int CURRENT_VERSION = 10;
  private static Logger log = LoggerFactory.getLogger(DatabaseVersion.class);
  private final Connection codeConn;
  private final Connection userConn;

  // Copied from CodeTableConstants
  private static final String TABLE_EXISTS =
      """
        SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public'
        AND table_name = ? LIMIT 1;
      """;

  public DatabaseVersion(Connection codeConn, Connection userConn) {
    this.codeConn = codeConn;
    this.userConn = userConn;
  }

  public void createTablesIfAbsent(boolean brandNew) throws SQLException {
    String tableExistsQuery = TABLE_EXISTS;
    try (PreparedStatement existsSt = userConn.prepareStatement(tableExistsQuery)) {
      existsSt.setString(1, "schema_version");
      ResultSet rs = existsSt.executeQuery();
      if (!rs.next() || rs.getInt(1) <= 0) {
        String createSt =
            """
            CREATE TABLE schema_version ("version" integer NOT NULL)
            """;
        PreparedStatement pst = userConn.prepareStatement(createSt);
        int retVal = pst.executeUpdate();
        if (retVal < 0) {
          log.warn("Issue when creating schema_version: retVal == " + retVal);
        }
        if (brandNew) {
          setSchemaVersion(CURRENT_VERSION);
        } else {
          setSchemaVersion(0);
        }
      }
      return;
    }
  }

  public boolean setSchemaVersion(int newVersion) throws SQLException {
    String deleteSt = "DELETE FROM schema_version";
    try (Statement delete = userConn.createStatement()) {
      delete.executeUpdate(deleteSt);
    }
    String insertSt = "INSERT INTO schema_version (version) VALUES (?)";
    try (PreparedStatement insert = userConn.prepareStatement(insertSt)) {
      insert.setInt(1, newVersion);
      int retVal = insert.executeUpdate();
      // Only worked it if inserted 1 row (the new version)
      return retVal > 0;
    }
  }

  public int getSchemaVersion() throws SQLException {
    String select = "SELECT version from schema_version";
    try (Statement st = userConn.createStatement()) {
      ResultSet rs = st.executeQuery(select);
      while (rs.next()) {
        return rs.getInt(1);
      }
      return 0;
    }
  }

  public boolean updateToLatest() throws NoSuchAlgorithmException {
    try {
      int onDiskVersion = getSchemaVersion();
      userConn.setAutoCommit(false);
      codeConn.setAutoCommit(false);
      while (onDiskVersion < CURRENT_VERSION) {
        System.out.println(onDiskVersion + " " + CURRENT_VERSION);
        Savepoint savepoint = userConn.setSavepoint("beginning_update");
        log.info("Updating database from version " + onDiskVersion + " to " + (onDiskVersion + 1));
        try {
          boolean successful = updateDatabase(onDiskVersion);
          if (!successful) {
            return false;
          }
          onDiskVersion += 1;
        } catch (SQLException ex) {
          log.error(
              "Couldn't update from version "
                  + onDiskVersion
                  + " to "
                  + CURRENT_VERSION
                  + ": "
                  + strFromException(ex)
                  + ": , reverting to on disk db");
          try {
            userConn.rollback(savepoint);
          } catch (SQLException rollbackEx) {
            log.error("Couldn't rollback! Error: " + strFromException(rollbackEx));
            return false;
          }
          return false;
        }
      }
    } catch (SQLException ex) {
      log.error("Couldn't setup updating to latest! Error: " + strFromException(ex));
      return false;
    }
    return true;
  }

  private boolean updateDatabase(int onDiskVersion) throws NoSuchAlgorithmException, SQLException {
    if (onDiskVersion == 0) {
      update0To1();
    } else if (onDiskVersion == 1) {
      update1To2();
    } else if (onDiskVersion == 2) {
      update2To3();
    } else if (onDiskVersion == 3) {
      update3To4();
    } else if (onDiskVersion == 4) {
      update4To5();
    } else if (onDiskVersion == 5) {
      update5To6();
    } else if (onDiskVersion == 6) {
      update6To7();
    } else if (onDiskVersion == 7) {
      update7To8();
    } else if (onDiskVersion == 8) {
      update8To9();
    } else if (onDiskVersion == 9) {
      update9To10();
    }
    setSchemaVersion(onDiskVersion + 1);
    userConn.commit();
    return true;
  }

  private void update0To1() throws NoSuchAlgorithmException, SQLException {
    // This version mistakenly had API keys directly stored in the db instead of their hashes.
    String query = "SELECT server_id, api_key FROM at_rest_keys";
    try (Statement st = userConn.createStatement()) {
      ResultSet rs = st.executeQuery(query);
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      String updateTable =
          """
          INSERT INTO at_rest_keys ("server_id", "api_key")
          VALUES (?, ?) ON CONFLICT (server_id) DO UPDATE SET api_key=?
          """;
      while (rs.next()) {
        UUID serverId = (UUID) rs.getObject(1);
        String apiKey = rs.getString(2);
        String hashedKey =
            new String(Hex.encode(digest.digest(apiKey.getBytes(StandardCharsets.UTF_8))));
        try (PreparedStatement insertSt = userConn.prepareStatement(updateTable)) {
          insertSt.setObject(1, serverId);
          insertSt.setObject(2, hashedKey);
          insertSt.setObject(3, hashedKey);
          insertSt.executeUpdate();
        }
      }
    }
  }

  private void update1To2() throws SQLException {
    // Conincides with the "jurisdiction" refactor: all codes need to also note which jurisdiction /
    // domain they came from.
    // Need to add the "domain text" column to every code table, with the value "illinois-stage" as
    // the value.
    final String alterCodes = "ALTER TABLE %s ADD COLUMN domain text";
    final String updateCodes = "UPDATE %s SET domain='illinois-stage'";
    final String alterNotNull = "ALTER TABLE %s ALTER COLUMN domain SET NOT NULL";

    final List<String> tableNames =
        List.of(
            "location",
            "error",
            "version",
            "installedversion",
            "country",
            "state",
            "filingstatus",
            "datafieldconfig",
            "answer",
            "arrestlocation",
            "bond",
            "casecategory",
            "casesubtype",
            "casetype",
            "chargephase",
            "citationjurisdiction",
            "crossreference",
            "damageamount",
            "degree",
            "disclaimerrequirement",
            "driverlicensetype",
            "documenttype",
            "ethnicity",
            "eyecolor",
            "filertype",
            "filetype",
            "filing",
            "filingcomponent",
            "generaloffense",
            "haircolor",
            "language",
            "lawenforcementunit",
            "motiontype",
            "namesuffix",
            "optionalservices",
            "partytype",
            "physicalfeature",
            "procedureremedy",
            "question",
            "race",
            "servicetype",
            "statute",
            "statutetype",
            "vehiclecolor",
            "vehiclemake",
            "vehicletype");

    // Also need to make the indices on domain + location for the bigger tables.
    final String osIndex = "CREATE INDEX ON optionalservices (domain)";
    final String fIndex = "CREATE INDEX ON filing (domain)";
    final String fcIndex = "CREATE INDEX ON filingcomponent (domain)";
    final String rmPkey = "ALTER TABLE installedversion DROP CONSTRAINT installedversion_pkey";
    final String makePkey =
        "ALTER TABLE installedversion ADD PRIMARY KEY (location, codelist, domain)";

    try (Statement st = codeConn.createStatement()) {
      for (String tableName : tableNames) {
        st.executeUpdate(alterCodes.formatted(tableName));
        st.executeUpdate(updateCodes.formatted(tableName));
        st.executeUpdate(alterNotNull.formatted(tableName));
      }

      st.executeUpdate(osIndex);
      st.executeUpdate(fIndex);
      st.executeUpdate(fcIndex);

      st.executeUpdate(rmPkey);
      st.executeUpdate(makePkey);
    }
    codeConn.commit();
  }

  private void update2To3() throws SQLException {
    final String alterMsgTmpls =
        """
        ALTER TABLE submitted_filings
          ADD COLUMN accepted_msg_template text,
          ADD COLUMN rejected_msg_template text,
          ADD COLUMN neutral_msg_template text\
        """;

    try (Statement st = userConn.createStatement()) {
      st.executeUpdate(alterMsgTmpls);
    }
    userConn.commit();
  }

  // Adds the case_title column to new transactions
  private void update3To4() throws SQLException {
    final String alterTransactionWithCaseTitle =
        """
        ALTER TABLE submitted_filings
          ADD COLUMN case_title text\
        """;
    try (Statement st = userConn.createStatement()) {
      st.executeUpdate(alterTransactionWithCaseTitle);
    }
    userConn.commit();
  }

  private void update4To5() throws SQLException {
    final String alterMsgSubjectTones =
        """
        ALTER TABLE submitted_filings
          ADD COLUMN accepted_msg_subject text,
          ADD COLUMN rejected_msg_subject text,
          ADD COLUMN neutral_msg_subject text\
        """;
    final String alterMsgSubjects =
        """
        ALTER TABLE message_settings
          ADD COLUMN confirmation_subject_line text\
        """;
    try (Statement st = userConn.createStatement()) {
      st.executeUpdate(alterMsgSubjectTones);
      st.executeUpdate(alterMsgSubjects);
    }
    userConn.commit();
  }

  public void update5To6() throws SQLException {
    final String createRefundReason =
        """
        CREATE TABLE refundreason (
          "code" text,
          "name" text,
          "efspcode" text,
          "location" text,
          "domain" text
        )\
        """;
    try (Statement st = userConn.createStatement()) {
      st.executeUpdate(createRefundReason);
    }
    userConn.commit();
  }

  private void update6To7() throws SQLException {
    // 6 made the table in the wrong database. Idk
    // how it passed tests.
    try (Statement st = userConn.createStatement()) {
      st.executeUpdate("DROP TABLE IF EXISTS refundreason");
    }
    // There were a few manual patches that need to be considered
    try (Statement st = codeConn.createStatement()) {
      st.executeUpdate("DROP TABLE IF EXISTS refundreason");
    }
    final String createRefundReason =
        """
        CREATE TABLE refundreason (
          "code" text,
          "name" text,
          "efspcode" text,
          "location" text,
          "domain" text
        )\
        """;
    try (Statement st = codeConn.createStatement()) {
      st.executeUpdate(createRefundReason);
    }
    userConn.commit();
    codeConn.commit();
  }

  private void update7To8() throws SQLException {
    // Version 8 will:
    // * turn location into char varying (80) (max seen is 20) (will use only 1 byte per row + chars
    // instead of 4)
    // * turn code into char varying (40) (max seen is 7)
    // * turn filingcodeid into char varying (40) (max seen is also 7)
    // * turn hasfeeprompt and multiplier, and other boolean things to booleans
    // * split the Optional services table into two tables, to compress and save space.
    // https://stackoverflow.com/a/7162961/11416267
    // *
    try (Statement st = codeConn.createStatement()) {
      final String shrinkOptSrv =
          """
          ALTER TABLE optionalservices
            ALTER COLUMN code TYPE varchar(40),
            ALTER COLUMN filingcodeid TYPE varchar(40),
            ALTER COLUMN domain TYPE varchar(80),
            ALTER COLUMN location TYPE varchar(80),
            ALTER COLUMN displayorder TYPE smallint USING displayorder::smallint,
            ALTER COLUMN multiplier TYPE boolean USING multiplier::boolean,
            ALTER COLUMN hasfeeprompt TYPE boolean USING hasfeeprompt::boolean
          """;
      st.executeUpdate(shrinkOptSrv);
      final String newOptSrv_FilingList =
          """
          CREATE TABLE optionalservices_filinglist AS
            SELECT code, filingcodeid, domain, location FROM optionalservices
          """;
      st.executeUpdate(newOptSrv_FilingList);
      // * split optionalservices into two tables:
      final String newOptSrv =
          """
          ALTER TABLE optionalservices
            DROP COLUMN filingcodeid
          """;
      st.executeUpdate(newOptSrv);
      final String copyOptSrv =
          """
          CREATE TABLE dedup_optionalservices AS
            SELECT DISTINCT * FROM optionalservices
          """;
      st.executeUpdate(copyOptSrv);
      st.executeUpdate("DROP TABLE optionalservices");
      st.executeUpdate("ALTER TABLE dedup_optionalservices RENAME TO optionalservices");
      // Then, we'll remake the indices;
      st.executeUpdate("CREATE INDEX ON optionalservices (location)");
      st.executeUpdate("CREATE INDEX ON optionalservices (domain)");
      st.executeUpdate("CREATE INDEX ON optionalservices_filinglist (filingcodeid)");
      st.executeUpdate("CREATE INDEX ON optionalservices_filinglist (location)");
      st.executeUpdate("CREATE INDEX ON optionalservices_filinglist (domain)");
      final String shrinkFilingCode =
          """
          ALTER TABLE filing
            ALTER COLUMN code TYPE varchar(40),
            ALTER COLUMN isproposedorder TYPE boolean USING isproposedorder::boolean,
            ALTER COLUMN iscourtuseonly TYPE boolean USING iscourtuseonly::boolean,
            ALTER COLUMN useduedate TYPE boolean USING useduedate::boolean
          """;
      st.executeUpdate(shrinkFilingCode);
      final String shrinkFilingComponent =
          """
          ALTER TABLE filingcomponent
            ALTER COLUMN code TYPE varchar(40),
            ALTER COLUMN filingcodeid TYPE varchar(40),
            ALTER COLUMN required TYPE boolean USING required::boolean,
            ALTER COLUMN allowmultiple TYPE boolean USING allowmultiple::boolean,
            ALTER COLUMN displayorder TYPE smallint USING displayorder::smallint
          """;
      st.executeUpdate(shrinkFilingComponent);
      final String shrinkPartyType =
          """
          ALTER TABLE partytype
            ALTER COLUMN code TYPE varchar(40),
            ALTER COLUMN isrequired TYPE boolean USING isrequired::boolean,
            ALTER COLUMN isavailablefornewparties TYPE boolean USING isavailablefornewparties::boolean
          """;
      st.executeUpdate(shrinkPartyType);
      final String shrinkCaseType =
          """
          ALTER TABLE casetype
            ALTER COLUMN code TYPE varchar(40)
          """;
      st.executeUpdate(shrinkCaseType);
      final String shrinkDatafieldConfig =
          """
          ALTER TABLE datafieldconfig
            ALTER COLUMN isvisible TYPE boolean USING isvisible::boolean,
            ALTER COLUMN isrequired TYPE boolean USING isrequired::boolean,
            ALTER COLUMN isreadonly TYPE boolean USING isreadonly::boolean
          """;
      st.executeUpdate(shrinkDatafieldConfig);
      for (var tableName :
          List.of(
              "country",
              "state",
              "filingstatus",
              "filingcomponent",
              "partytype",
              "casetype",
              "filing",
              "datafieldconfig",
              "answer",
              "arrestlocation",
              "bond",
              "casecategory",
              "casesubtype",
              "chargephase",
              "citationjurisdiction",
              "crossreference",
              "damageamount",
              "degree",
              "disclaimerrequirement",
              "driverlicensetype",
              "documenttype",
              "ethnicity",
              "eyecolor",
              "filertype",
              "filetype",
              "generaloffense",
              "haircolor",
              "language",
              "lawenforcementunit",
              "motiontype",
              "namesuffix",
              "physicalfeature",
              "procedureremedy",
              "question",
              "race",
              "servicetype",
              "statute",
              "statutetype",
              "vehiclecolor",
              "vehiclemake",
              "vehicletype",
              "refundreason")) {
        st.executeUpdate(
            """
            ALTER TABLE %s
              ALTER COLUMN domain TYPE varchar(80),
              ALTER COLUMN location TYPE varchar(80)
            """
                .formatted(tableName));
      }
    }
    codeConn.commit();
  }

  public void update8To9() throws SQLException {
    final String alterUserDb =
        """
        ALTER TABLE submitted_filings
          ADD COLUMN envelope_id text\
        """;

    try (Statement st = userConn.createStatement()) {
      st.executeUpdate(alterUserDb);
    }
    userConn.commit();
  }

  public void update9To10() throws SQLException {
    try (Statement st = codeConn.createStatement()) {
      // There were issues in the insert code, so there are likely way too many opt services again.
      final String reDistinctOpt =
          """
          CREATE TABLE dedup_optionalservices AS
          SELECT DISTINCT * FROM optionalservices
          """;
      st.executeUpdate(reDistinctOpt);
      st.executeUpdate("DROP TABLE optionalservices");
      st.executeUpdate("ALTER TABLE dedup_optionalservices RENAME TO optionalservices");
      // Then, we'll remake the indices
      st.executeUpdate("CREATE INDEX ON optionalservices (location)");
      st.executeUpdate("CREATE INDEX ON optionalservices (domain)");
    }
    codeConn.commit();
  }
}
