package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import static org.assertj.core.api.Assertions.assertThat;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.db.DatabaseVersionTest;
import edu.suffolk.litlab.efsp.ecfcodes.NameAndCodeType;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import net.jqwik.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@Tag("Docker")
public class TFCodeDatabaseTest {
  private static TFCodeDatabase cd;

  private static final String COURT_LOCATION = "55da5b11-2bc4-4881-abd1-b0dfdb506bb1";

  private static final String CASE_CATEGORY_TABLE = "truefiling_casecategory";
  private static final String CASE_TYPE_TABLE = "truefiling_casetype";
  private static final String BUNDLE_STATUS_TABLE = "truefiling_bundlestatus";
  private static final String DOCUMENT_STATUS_TABLE = "truefiling_documentstatus";
  private static final String DOCUMENT_TYPE_TABLE = "truefiling_documenttype";
  private static final String ERROR_CODES_TABLE = "truefiling_errorcode";
  private static final String FEE_EXCEPTION_REASON_TABLE = "truefiling_feeexceptionreason";

  private static final String PATH_PREFIX = "/genericode_examples/akcourt/";

  @Container
  public static PostgreSQLContainer postgres =
      new PostgreSQLContainer(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));

  @BeforeAll
  public static void setUp() throws SQLException {
    postgres.start();
    Connection conn =
        DatabaseCreator.makeSingleConnection(
            postgres.getDatabaseName(),
            postgres.getJdbcUrl(),
            postgres.getUsername(),
            postgres.getPassword());
    cd = new TFCodeDatabase(Jurisdiction.ALASKA, conn);
    cd.createTablesIfAbsent();
    cd.createTableIfAbsent(CASE_CATEGORY_TABLE);
    cd.createTableIfAbsent(CASE_TYPE_TABLE);
    cd.createTableIfAbsent(DOCUMENT_STATUS_TABLE);
    cd.createTableIfAbsent(DOCUMENT_TYPE_TABLE);
    cd.createTableIfAbsent(BUNDLE_STATUS_TABLE);
    cd.createTableIfAbsent(FEE_EXCEPTION_REASON_TABLE);
    cd.createTableIfAbsent(ERROR_CODES_TABLE);
  }

  @Test
  public void testAllLocations() throws SQLException {
    assertThat(cd.getAllLocations()).containsOnly(COURT_LOCATION);
  }

  @Test
  public void testCaseCategory() throws Exception {
    cd.updateTable(CASE_CATEGORY_TABLE, COURT_LOCATION, loadFromXml("case_category_test.gc.xml"));
    assertThat(cd.getCaseCategoryNames(COURT_LOCATION))
        .contains(
            new NameAndCodeType("Bankruptcy", "bankruptcy"), new NameAndCodeType("Civil", "civil"));
  }

  @Test
  public void testCaseType() throws Exception {
    cd.updateTable(CASE_TYPE_TABLE, COURT_LOCATION, loadFromXml("case_type_test.gc.xml"));
    assertThat(cd.getCaseTypeNamesFor(COURT_LOCATION, "criminal", Optional.empty()))
        .contains(
            new NameAndCodeType("Minor Offense", "MO1AG"),
            new NameAndCodeType("Crim Dist Ct Felony", "CRDF1HA"));
  }

  @Test
  public void testBundleStatus() throws Exception {
    cd.updateTable(BUNDLE_STATUS_TABLE, COURT_LOCATION, loadFromXml("bundle_status_test.gc.xml"));
    assertThat(cd.getBundleStatuses(COURT_LOCATION))
        .contains(new NameAndCodeType("Filed", "Filed"), new NameAndCodeType("Paid", "Paid"));
  }

  @Test
  public void testDocumentStatus() throws Exception {
    cd.updateTable(
        DOCUMENT_STATUS_TABLE, COURT_LOCATION, loadFromXml("document_status_test.gc.xml"));
    assertThat(cd.getDocumentStatuses(COURT_LOCATION))
        .contains(new NameAndCodeType("Accepted", "Accepted"), new NameAndCodeType("New", "New"));
  }

  @Test
  public void testDocumentType() throws Exception {
    cd.updateTable(DOCUMENT_TYPE_TABLE, COURT_LOCATION, loadFromXml("document_type_test.gc.xml"));
    assertThat(cd.getDocumentTypes(COURT_LOCATION, "1e17822a-9cef-4613-9b26-059fcf845f66"))
        .contains(
            new NameAndCodeType(
                "Agreement, Consent, or Waiver", "af0e891c-8bcb-4a22-9ec1-b1475d41d408"),
            new NameAndCodeType(
                "Application for Change of Plea Hearing (Form CR-316)",
                "4f2dfa01-eb4f-4b9a-aba6-197d67187388"));
  }

  @Test
  public void testErrorCodes() throws Exception {
    cd.updateTable(ERROR_CODES_TABLE, COURT_LOCATION, loadFromXml("error_codes.gc.xml"));
    assertThat(cd.getErrorCodes(COURT_LOCATION))
        .contains(
            new NameAndCodeType("XML Validation Error", "1000"),
            new NameAndCodeType("CourtId undefined", "1001"));
  }

  @Test
  public void testFeeExceptionReason() throws Exception {
    cd.updateTable(
        FEE_EXCEPTION_REASON_TABLE,
        COURT_LOCATION,
        loadFromXml("fee_exception_reason_test.gc.xml"));
  }

  private InputStream loadFromXml(String filename) throws Exception {
    return this.getClass().getResourceAsStream(PATH_PREFIX + filename);
  }
}
