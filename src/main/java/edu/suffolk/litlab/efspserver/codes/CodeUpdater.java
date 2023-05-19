package edu.suffolk.litlab.efspserver.codes;

import edu.suffolk.litlab.efspserver.HeaderSigner;
import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.SoapX509CallbackHandler;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.soap.SOAPFaultException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipInputStream;
import javax.sql.DataSource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

/**
 * Updates the Tyler "Codes" for each court in a jurisdiction.
 *
 * <p>There are 3 main steps to download a code for a Tyler court: 1. calling `getPolicy` (see
 * {@link FilingReviewMDEPort}) for a court to get the URLs that the codes are available at. - this
 * URL can change, but tbh doesn't change often. It takes approximately 1 for a call to getPolicy to
 * complete. 2. downloading the codes, which are zip files available at the above URL. - You need
 * the court itself, the table that you are downloading. Currently, we take the input stream and
 * divert it directly to the XMLStream reader, so we don't need to write out to a file. 3. updating
 * the Postgres codes database - this takes the XMLStreamReader, unmarshalls it into a java object,
 * and uses that to populate the code database. Most code for that is in {@link CodeDatabase}.
 *
 * <p>We parallelize this as much as possible, which means steps 1 and 2 are done in batch, and each
 * court / court-table item is done in parallel. Step 3, however, can't seem to be parallelized, due
 * to java issues. See https://github.com/SuffolkLITLab/EfileProxyServer/issues/111
 *
 * <p>For TX, IL, and MA, it takes ~45 minutes to refresh all of the codes.
 */
public class CodeUpdater {
  private static final Logger log = LoggerFactory.getLogger(CodeUpdater.class);
  static final Map<String, String> ncToTableName = new ConcurrentHashMap<String, String>();

  static {
    // TODO(brycew-later): there's little more info on these mappings and how they combine besides:
    // The name of an ECF element to be substituted by a court-specific codelist or extension
    // Is this actually an XPath? Should figure it out
    ncToTableName.put("nc:CaseCategoryText", "casecategory");
    ncToTableName.put("tyler:CaseTypeText", "casetype");
    ncToTableName.put("nc:LocationCountryName", "country");
    ncToTableName.put("tyler:DamageAmountCode", "damageamount");
    ncToTableName.put("tyler:DisclaimerRequirementCode", "disclaimerrequirement");
    ncToTableName.put("nc:BinaryFormatStandardName", "documenttype");
    ncToTableName.put("tyler:FilerTypeText", "filertype");
    ncToTableName.put("j:RegisterActionDescriptionText", "filing");
    ncToTableName.put("nc:BinaryCategoryText", "filingcomponent");
    ncToTableName.put("tyler:DocumentOptionalService", "optionalservices");
    ncToTableName.put("ecf:CaseParticipantRoleCode", "partytype");
    ncToTableName.put("tyler:RemedyCode", "procedureremedy");
    ncToTableName.put("nc:LocationStateName", "state");
    ncToTableName.put("ecf:FilingStatusCode", "filingstatus");
    ncToTableName.put("nc:PersonNameSuffixText", "namesuffix");
    ncToTableName.put("tyler:DataFieldConfigCode", "datafieldconfig");
    ncToTableName.put("ecf:ServiceRecipientID/nc:IdentificationSourceText", "servicetype");
    ncToTableName.put("nc:BinaryLocationURI", "filetype");
    ncToTableName.put("j:/ArrestCharge/j:ArrestLocation/nc:LocationName", "arrestlocation");
    ncToTableName.put("cext:BondTypeText", "bond");
    ncToTableName.put("cext:Charge/cext:ChargeStatute/j:StatuteLevelText", "degree");
    ncToTableName.put(
        "j:ArrestOfficial/j:EnforcementOfficialUnit/nc:OrganizationIdentification/nc:IdentificationID",
        "lawenforcementunit");
    ncToTableName.put("nc:DocumentIdentification/nc:IdentificationSourceText", "crossreference");
    ncToTableName.put("cext:GeneralOffenseText", "generaloffense");
    ncToTableName.put("cext:StatuteTypeText", "statutetype");
    ncToTableName.put(
        "ecf:PersonDriverLicense/nc:DriverLicenseIdentification/nc:IdentificationCategoryText",
        "driverlicensetype");
    ncToTableName.put(
        "cext:Charge/cext:ChargeStatute/j:StatuteCodeIdentification/nc:IdentificationID",
        "statute");
    ncToTableName.put("nc:PrimaryLanguage\\nc:LanguageCode", "language");
    ncToTableName.put(
        "nc:PersonPhysicalFeature\\nc:PhysicalFeatureCategoryCode", "physicalfeature");
    ncToTableName.put("nc:PersonHairColorCode", "haircolor");
    ncToTableName.put("nc:PersonEyeColorCode", "eyecolor");
    ncToTableName.put("nc:PersonEthnicityText", "ethnicity");
    ncToTableName.put("nc:PersonRaceText", "race");
    ncToTableName.put("tyler:CaseSubTypeText", "casesubtype");
    ncToTableName.put("cext:Charge\\cext:ChargePhaseText", "chargephase");
    ncToTableName.put("tyler:VehicleTypeCode", "vehicletype");
    ncToTableName.put("nc:VehicleMakeCode", "vehiclemake");
    ncToTableName.put("nc:VehicleColorPrimaryCode", "vehiclecolor");
    ncToTableName.put("tyler:MotionTypeCode", "motiontype");
    ncToTableName.put(
        "j:Citation\\nc:ActivityIdentification\\tyler:JurisdictionCode", "citationjurisdiction");
    ncToTableName.put("tyler:QuestionCode", "question");
    ncToTableName.put("tyler:AnswerCode", "answer");
  }

  /**
   * The path to the keystore file, containing the x509 cert used to sign headers to download zips.
   */
  private final String pathToKeystore;

  private final String x509Password;

  public CodeUpdater(String pathToKeystore, String x509Password) {
    this.pathToKeystore = pathToKeystore;
    this.x509Password = x509Password;
  }

  /**
   * Either downloads the codes file from Tyler, or opens an already downloaded local zip file.
   *
   * <p>Code for HttpConnection: https://stackoverflow.com/a/1485730/11416267
   *
   * @return InputStream
   * @throws IOException
   */
  public static InputStream getCodesZip(String toRead, String authHeader) throws IOException {
    if (toRead.startsWith("http://") || toRead.startsWith("https://")) {
      URL url = new URL(toRead);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("tyl-efm-api", authHeader);
      return conn.getInputStream();
    } else {
      return new FileInputStream(toRead);
    }
  }

  private Duration downloads = Duration.ZERO;
  private Duration updates = Duration.ZERO;
  private Duration soaps = Duration.ZERO;

  /**
   * @param toRead
   * @param signedTime
   * @param process
   * @return
   */
  private boolean downloadAndProcessZip(
      String toRead, String signedTime, Function<InputStream, Boolean> process) {
    Instant startTable = Instant.now(Clock.systemUTC());
    try (InputStream urlStream = getCodesZip(toRead, signedTime)) {
      // Write out the zip file
      downloads = downloads.plus(Duration.between(startTable, Instant.now(Clock.systemUTC())));

      ZipInputStream zip = new ZipInputStream(urlStream);
      zip.getNextEntry();

      Instant updateTableLoc = Instant.now(Clock.systemUTC());
      boolean success = process.apply(zip);
      updates = updates.plus(Duration.between(updateTableLoc, Instant.now(Clock.systemUTC())));
      zip.close();
      return success;
    } catch (IOException ex) {
      // Some system codes (everything but "country", "state", "filingstatus", "datafieldconfig",
      // and "servicetype") are expected to 500. Not really sure why they give us bad URLs.
      log.warn("Skipping " + toRead + ", got exception accessing zip: " + ex.toString());
      return false;
    }
  }

  private boolean downloadSystemTables(String baseUrl, CodeDatabase cd, HeaderSigner signer)
      throws SQLException, IOException, JAXBException, XMLStreamException {
    Map<String, String> codeUrls =
        Map.of(
            "version",
            "/CodeService/codes/version/",
            "location",
            "/CodeService/codes/location/",
            // NOTE: the Tyler docs say "error" is available from `GetPolicy'. That is wrong.
            "error",
            "/CodeService/codes/error");

    for (Map.Entry<String, String> urlSuffix : codeUrls.entrySet()) {
      cd.createTableIfAbsent(urlSuffix.getKey());
    }

    // On first download, there won't be installed versions of things yet.
    cd.createTableIfAbsent("installedversion");

    cd.getConnection().commit();

    Savepoint sp = cd.getConnection().setSavepoint("systemTables");

    Optional<String> signedTime = signer.signedCurrentTime();
    if (signedTime.isEmpty()) {
      log.error("Couldn't sign the current time: rolling back");
      cd.getConnection().rollback(sp);
      return false;
    }

    for (Map.Entry<String, String> urlSuffix : codeUrls.entrySet()) {
      cd.deleteFromTable(urlSuffix.getKey());
      final Function<InputStream, Boolean> process =
          (is) -> {
            try {
              // "0" is used as the system court location.
              cd.updateTable(urlSuffix.getKey(), "0", is);
              return true;
            } catch (final Exception e1) {
              log.error(StdLib.strFromException(e1));
              return false;
            }
          };
      boolean updateSuccess =
          downloadAndProcessZip(baseUrl + urlSuffix.getValue(), signedTime.get(), process);
      if (!updateSuccess) {
        cd.getConnection().rollback(sp);
        return false;
      }
    }
    cd.getConnection().commit();
    return true;
  }

  /**
   * Internal class, meant to pass around information between the "getPolicy URL" stage and the
   * "download zip" stage.
   */
  private static class CodeToDownload {
    final String tableName;
    final String url;

    public CodeToDownload(String tableName, String url) {
      this.tableName = tableName;
      this.url = url;
    }
  }

  /**
   * Internal class, meant to pass around information between the "download zip" stage and the
   * "update postgres" stage.
   */
  private static class DownloadedCodes {
    final String tableName;
    final String location;
    final XMLStreamReader xsr;
    final InputStream input;

    public DownloadedCodes(
        String tableName, String location, XMLStreamReader xsr, InputStream input) {
      this.tableName = tableName;
      this.location = location;
      this.xsr = xsr;
      this.input = input;
    }
  }

  /**
   * @param authHeader The header needed to download the codes
   * @param location The court code
   * @param courtCodeList The list of codes to download for this court
   * @param tables
   * @return a map of the actually downloaded codes
   */
  private static Map<String, DownloadedCodes> streamDownload(
      String authHeader,
      String location,
      Stream<CodeToDownload> courtCodeList,
      Optional<List<String>> tables) {
    var codeLists = new ConcurrentHashMap<String, DownloadedCodes>();
    courtCodeList.forEach(
        toDownload -> {
          if (tables.isEmpty() || tables.get().contains(toDownload.tableName)) {
            try {
              InputStream urlStream = getCodesZip(toDownload.url, authHeader);
              ZipInputStream zip = new ZipInputStream(urlStream);
              zip.getNextEntry();
              XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
              XMLStreamReader sr = xmlInputFactory.createXMLStreamReader(zip);
              codeLists.put(
                  toDownload.tableName,
                  new DownloadedCodes(toDownload.tableName, location, sr, urlStream));
            } catch (IOException | XMLStreamException e) {
              log.error(StdLib.strFromException(e));
            }
          }
        });
    return codeLists;
  }

  private static Map<String, CourtPolicyResponseMessageType> streamPolicies(
      Stream<String> locations, String jurisdiction, FilingReviewMDEPort filingPort) {
    var policies = new ConcurrentHashMap<String, CourtPolicyResponseMessageType>();
    locations.forEach(
        location -> {
          var m = ServiceHelpers.prep(new CourtPolicyQueryMessageType(), location);
          try {
            CourtPolicyResponseMessageType p = filingPort.getPolicy(m);
            policies.put(location, p);
          } catch (SOAPFaultException ex) {
            log.warn(
                "Got a SOAP Fault excption when getting the policy for "
                    + location
                    + " in "
                    + jurisdiction
                    + ": "
                    + StdLib.strFromException(ex));
          }
        });
    return policies;
  }

  private String makeCodeUrl(String baseUrl, String tableName, String location) {
    return baseUrl + "CodeService/codes/" + tableName + "/" + location.replace(" ", "%20");
  }

  /**
   * @param tables If empty, all versions will be downloaded
   */
  private boolean downloadCourtTables(
      String location,
      Optional<List<String>> tables,
      CodeDatabase cd,
      HeaderSigner signer,
      CourtPolicyResponseMessageType policyResp,
      String baseUrl)
      throws JAXBException, IOException, SQLException {
    log.info("Doing updates for: {}, tables: {}", location, tables);
    Instant downloadStart = Instant.now(Clock.systemUTC());
    // TODO(brycew-later): check that the effective date is later than today
    // JAXBElement<?> obj = ccl.getEffectiveDate().getDateRepresentation();
    Map<String, String> urlMap =
        policyResp.getRuntimePolicyParameters().getCourtCodelist().stream()
            .collect(
                Collectors.toMap(
                    (cc1) -> ncToTableName.get(cc1.getECFElementName().getValue()),
                    // Tyler gives us URLs w/ spaces, which aren't valid. This makes them valid
                    (cc1) ->
                        cc1.getCourtCodelistURI()
                            .getIdentificationID()
                            .getValue()
                            .replace(" ", "%20")));
    Stream<CodeToDownload> toDownload;
    if (tables.isEmpty()) {
      toDownload =
          urlMap.entrySet().stream().map((ent) -> new CodeToDownload(ent.getKey(), ent.getValue()));
    } else {
      toDownload =
          tables.get().stream()
              .map(
                  tableName -> {
                    String guessUrl = makeCodeUrl(baseUrl, tableName, location);
                    return new CodeToDownload(tableName, urlMap.getOrDefault(tableName, guessUrl));
                  });
    }
    Optional<String> signedTime = signer.signedCurrentTime();
    if (signedTime.isEmpty()) {
      log.error("Couldn't get signed time to download codeds, skipping all");
      return false;
    }
    Map<String, DownloadedCodes> downloaded =
        streamDownload(signedTime.get(), location, toDownload.parallel(), tables);
    downloads = downloads.plus(Duration.between(downloadStart, Instant.now(Clock.systemUTC())));
    log.info("Location: {}: Downloads took: {}", location, downloads);

    Instant updateStart = Instant.now(Clock.systemUTC());
    for (DownloadedCodes down : downloaded.values()) {
      try {
        cd.updateTable(down.tableName, down.location, down.xsr);
      } catch (Exception ex) {
        log.error("Couldn't update table? {}", StdLib.strFromException(ex));
      } finally {
        StdLib.closeQuitely(down.xsr);
        down.input.close();
      }
    }
    updates = updates.plus(Duration.between(updateStart, Instant.now(Clock.systemUTC())));

    cd.getConnection().commit();
    log.info("Location: {}: updates took: {}", location, updates);
    return true;
  }

  /** Returns true if successful, false if not successful */
  public boolean updateAll(String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd)
      throws SQLException, IOException, JAXBException, XMLStreamException {
    HeaderSigner signer = new HeaderSigner(this.pathToKeystore, this.x509Password);
    if (!downloadSystemTables(baseUrl, cd, signer)) {
      log.warn(
          "System tables didn't update, but we needed them "
              + " to actually figure out new versions");
      return false;
    }

    // Drop each of tables that need to be updated
    Savepoint sp = cd.getConnection().setSavepoint("court update savepoint");
    Map<String, List<String>> versionsToUpdate = cd.getVersionsToUpdate();
    Instant startDel = Instant.now(Clock.systemUTC());
    Set<String> allTables = new HashSet<>();
    int n = 0;
    log.info("Making tables if absent");
    for (var tables : versionsToUpdate.values()) {
      n += tables.size();
      allTables.addAll(tables);
    }
    for (String table : allTables) {
      cd.createTableIfAbsent(table);
    }
    log.info("Removing {} court entries, over {} queries", versionsToUpdate.size(), n);
    for (Entry<String, List<String>> courtAndTables : versionsToUpdate.entrySet()) {
      final String courtLocation = courtAndTables.getKey();
      List<String> tables = courtAndTables.getValue();
      log.debug(
          "In {}, removing entries for court {} for tables: {}",
          cd.getDomain(),
          courtLocation,
          tables);
      for (String table : tables) {
        Instant deleteFromTable = Instant.now(Clock.systemUTC());
        if (!cd.deleteFromTable(table, courtLocation)) {
          log.error("Couldn't delete from {} at {}, aborting", table, courtLocation);
          cd.getConnection().rollback(sp);
          return false;
        }
        updates = updates.plus(Duration.between(deleteFromTable, Instant.now(Clock.systemUTC())));
      }
    }
    log.info(
        "Took {} to remove existing tables",
        Duration.between(startDel, Instant.now(Clock.systemUTC())));
    Instant startPolicy = Instant.now(Clock.systemUTC());
    Map<String, CourtPolicyResponseMessageType> policies =
        streamPolicies(versionsToUpdate.keySet().stream().parallel(), cd.getDomain(), filingPort);
    soaps = soaps.plus(Duration.between(startPolicy, Instant.now(Clock.systemUTC())));
    log.info("Soaps: {}", soaps);

    for (var policy : policies.entrySet()) {
      final String courtLocation = policy.getKey();
      final List<String> tables = versionsToUpdate.get(courtLocation);
      if (!downloadCourtTables(
          courtLocation, Optional.of(tables), cd, signer, policy.getValue(), baseUrl)) {
        log.warn("Failed updating court {}'s tables {}", courtLocation, tables);
        cd.getConnection().rollback(sp);
        return false;
      }
    }
    cd.getConnection().commit();
    cd.getConnection().setAutoCommit(true);
    cd.vacuumAll();
    return true;
  }

  /**
   * Downloads all of the codes from scratch, deleting all of the existing info already in tables.
   */
  public boolean replaceAll(String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd)
      throws SQLException, IOException, JAXBException, XMLStreamException {
    HeaderSigner signer = new HeaderSigner(this.pathToKeystore, this.x509Password);
    log.info("Downloading system tables for {}", cd.getDomain());
    boolean success = downloadSystemTables(baseUrl, cd, signer);

    var tablesToDeleteDomain = ncToTableName.values();
    for (String table : tablesToDeleteDomain) {
      cd.createTableIfAbsent(table);
      cd.deleteFromTable(table);
    }
    cd.getConnection().commit();

    downloads = Duration.ZERO;
    soaps = Duration.ZERO;
    updates = Duration.ZERO;
    List<String> locs = cd.getAllLocations();
    Instant startPolicy = Instant.now(Clock.systemUTC());
    Map<String, CourtPolicyResponseMessageType> policies =
        streamPolicies(locs.stream(), cd.getDomain(), filingPort);
    soaps = soaps.plus(Duration.between(startPolicy, Instant.now(Clock.systemUTC())));
    log.info("Soaps: {}", soaps);
    for (var policy : policies.entrySet()) {
      final String location = policy.getKey();
      log.info("Downloading tables for {}", location);
      success &=
          downloadCourtTables(location, Optional.empty(), cd, signer, policy.getValue(), baseUrl);
    }
    log.info("Downloads took: {}, and updates took: {}, soaps took: {}", downloads, updates, soaps);
    cd.getConnection().commit();
    cd.getConnection().setAutoCommit(true);
    cd.vacuumAll();
    return success;
  }

  /** Sets up the WSDL connection to Tyler, used for `getPolicy` to get the URL. */
  private static FilingReviewMDEPort loginWithTyler(
      String jurisdiction, String env, String userEmail, String userPassword) {
    Optional<EfmUserService> userService = SoapClientChooser.getEfmUserFactory(jurisdiction, env);
    if (userService.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " in Soap chooser for EFMUser");
    }
    log.info("Getting filing factory for {} {}", jurisdiction, env);
    Optional<FilingReviewMDEService> filingFactory =
        SoapClientChooser.getFilingReviewFactory(jurisdiction, env);
    if (filingFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in Soap Chooser for filing review factory");
    }
    IEfmUserService userPort = userService.get().getBasicHttpBindingIEfmUserService();
    ServiceHelpers.setupServicePort((BindingProvider) userPort);
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail(userEmail);
    authReq.setPassword(userPassword);
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    List<Header> headersList = TylerUserNamePassword.makeHeaderList(authRes);
    FilingReviewMDEPort filingPort = filingFactory.get().getFilingReviewMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) filingPort);
    Map<String, Object> ctx = ((BindingProvider) filingPort).getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    return filingPort;
  }

  /** Downloads a single codes zip. For Debugging. */
  public boolean downloadIndiv(List<String> args, String jurisdiction, String env) {
    if (args.size() < 3) {
      log.error(
          "Need to pass in args: downloadIndiv <jurisdiction> <table> <location or blank for"
              + " system>");
      return false;
    }

    if (!jurisdiction.equalsIgnoreCase(args.get(1))) {
      log.warn(args.get(1) + " is not " + jurisdiction + ", not downloading here");
      return false;
    }

    String table = args.get(2);
    String location = (args.size() == 4) ? args.get(3) : "";
    HeaderSigner hs = new HeaderSigner(this.pathToKeystore, this.x509Password);
    String endpoint = SoapClientChooser.getCodeEndpointRootUrl(jurisdiction, env);
    return downloadAndProcessZip(
        makeCodeUrl(endpoint, table, location),
        hs.signedCurrentTime().get(),
        (in) -> {
          String newFile = location.replace(':', '_') + "_" + table + "_test.xml";
          try (FileOutputStream fw = new FileOutputStream(newFile)) {
            fw.write(in.readAllBytes());
          } catch (IOException e) {
            log.error(StdLib.strFromException(e));
            return false;
          }
          return true;
        });
  }

  public static boolean executeCommand(
      CodeDatabase cd, String jurisdiction, String env, List<String> args, String x509Password) {
    SoapX509CallbackHandler.setX509Password(x509Password);
    String command = args.get(0);
    try {
      cd.getConnection().setAutoCommit(false);
      String codesSite = SoapClientChooser.getCodeEndpointRootUrl(jurisdiction, env);
      FilingReviewMDEPort filingPort =
          loginWithTyler(
              jurisdiction,
              env,
              System.getenv("TYLER_USER_EMAIL"),
              System.getenv("TYLER_USER_PASSWORD"));
      CodeUpdater cu = new CodeUpdater(System.getenv("PATH_TO_KEYSTORE"), x509Password);
      if (command.equalsIgnoreCase("replaceall")) {
        return cu.replaceAll(codesSite, filingPort, cd);
      } else if (command.equalsIgnoreCase("refresh")) {
        return cu.updateAll(codesSite, filingPort, cd);
      } else if (command.equalsIgnoreCase("downloadIndiv")) {
        return cu.downloadIndiv(args, jurisdiction, env);
      } else {
        log.error("Command " + command + " isn't a real command");
        return false;
      }
    } catch (SQLException | IOException | JAXBException | XMLStreamException e) {
      log.error("Exception when doing code updating! " + StdLib.strFromException(e));
      return false;
    }
  }

  /**
   * Run with: `mvn exec:java@CodeUpdater -Dexec.args="refresh"` TODO(#111): use with this System
   * property and class to try to fix parallel unmarshalling
   * -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efspserver.JAXBForkJoinWorkerThreadFactory
   * \ https://stackoverflow.com/a/57551188/11416267
   */
  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      log.error("Need to pass in a subprogram: downloadIndiv, or refresh");
      System.exit(1);
    }
    DataSource ds =
        DatabaseCreator.makeDataSource(
            System.getenv("POSTGRES_URL"),
            Integer.parseInt(System.getenv("POSTGRES_PORT")),
            System.getenv("POSTGRES_CODES_DB"),
            System.getenv("POSTGRES_USER"),
            System.getenv("POSTGRES_PASSWORD"),
            5,
            100);

    List<String> jurisdictions = List.of(System.getenv("TYLER_JURISDICTIONS").split(" "));
    String env = System.getenv("TYLER_ENV");
    for (String jurisdiction : jurisdictions) {
      try (Connection conn = ds.getConnection()) {
        executeCommand(
            new CodeDatabase(jurisdiction, env, conn),
            jurisdiction,
            env,
            List.of(args),
            System.getenv("X509_PASSWORD"));
      }
    }
  }
}
