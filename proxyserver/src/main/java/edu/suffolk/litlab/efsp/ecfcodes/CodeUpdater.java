package edu.suffolk.litlab.efsp.ecfcodes;

import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.server.ecf4.SoapClientChooser;
import edu.suffolk.litlab.efsp.server.utils.HeaderSigner;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.SoapX509CallbackHandler;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
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
import tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType;
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

  // TODO(brycew-later): there's little more info on these mappings and how they combine besides:
  // The name of an ECF element to be substituted by a court-specific codelist or extension
  // Is this actually an XPath? Should figure it out
  public static final Map<String, String> ecf4ElemToTableName =
      Map.ofEntries(
          Map.entry("cext:BondTypeText", "bond"),
          Map.entry("cext:Charge/cext:ChargeStatute/j:StatuteLevelText", "degree"),
          Map.entry("cext:Charge\\cext:ChargePhaseText", "chargephase"),
          Map.entry("cext:GeneralOffenseText", "generaloffense"),
          Map.entry("cext:StatuteTypeText", "statutetype"),
          Map.entry(
              "cext:Charge/cext:ChargeStatute/j:StatuteCodeIdentification/nc:IdentificationID",
              "statute"),
          Map.entry("ecf:CaseParticipantRoleCode", "partytype"),
          Map.entry("ecf:FilingStatusCode", "filingstatus"),
          Map.entry("ecf:ServiceRecipientID/nc:IdentificationSourceText", "servicetype"),
          Map.entry(
              "ecf:PersonDriverLicense/nc:DriverLicenseIdentification/nc:IdentificationCategoryText",
              "driverlicensetype"),
          Map.entry("j:/ArrestCharge/j:ArrestLocation/nc:LocationName", "arrestlocation"),
          Map.entry("j:RegisterActionDescriptionText", "filing"),
          Map.entry(
              "j:ArrestOfficial/j:EnforcementOfficialUnit/nc:OrganizationIdentification/nc:IdentificationID",
              "lawenforcementunit"),
          Map.entry(
              "j:Citation\\nc:ActivityIdentification\\tyler:JurisdictionCode",
              "citationjurisdiction"),
          Map.entry("nc:CaseCategoryText", "casecategory"),
          Map.entry("nc:LocationCountryName", "country"),
          Map.entry("nc:BinaryFormatStandardName", "documenttype"),
          Map.entry("nc:BinaryCategoryText", "filingcomponent"),
          Map.entry("nc:LocationStateName", "state"),
          Map.entry("nc:PersonNameSuffixText", "namesuffix"),
          Map.entry("nc:BinaryLocationURI", "filetype"),
          Map.entry("nc:DocumentIdentification/nc:IdentificationSourceText", "crossreference"),
          Map.entry("nc:PrimaryLanguage\\nc:LanguageCode", "language"),
          Map.entry("nc:PersonPhysicalFeature\\nc:PhysicalFeatureCategoryCode", "physicalfeature"),
          Map.entry("nc:PersonHairColorCode", "haircolor"),
          Map.entry("nc:PersonEyeColorCode", "eyecolor"),
          Map.entry("nc:PersonEthnicityText", "ethnicity"),
          Map.entry("nc:PersonRaceText", "race"),
          Map.entry("nc:VehicleMakeCode", "vehiclemake"),
          Map.entry("nc:VehicleColorPrimaryCode", "vehiclecolor"),
          Map.entry("tyler:CaseTypeText", "casetype"),
          Map.entry("tyler:DamageAmountCode", "damageamount"),
          Map.entry("tyler:DisclaimerRequirementCode", "disclaimerrequirement"),
          Map.entry("tyler:FilerTypeText", "filertype"),
          Map.entry("tyler:CaseSubTypeText", "casesubtype"),
          Map.entry("tyler:VehicleTypeCode", "vehicletype"),
          Map.entry("tyler:MotionTypeCode", "motiontype"),
          Map.entry("tyler:AnswerCode", "answer"),
          Map.entry("tyler:QuestionCode", "question"),
          Map.entry("tyler:RemedyCode", "procedureremedy"),
          Map.entry("tyler:DataFieldConfigCode", "datafieldconfig"),
          Map.entry("tyler:DocumentOptionalService", "optionalservices"));

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
      log.warn("Skipping {}, got exception accessing zip: ", toRead, ex);
      return false;
    }
  }

  private boolean downloadSystemTables(String baseUrl, CodeDatabase cd, HeaderSigner signer)
      throws SQLException, IOException, JAXBException {
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

    cd.commit();

    Savepoint sp = cd.setSavepoint("systemTables");

    Optional<String> signedTime = signer.signedCurrentTime();
    if (signedTime.isEmpty()) {
      log.error("Couldn't sign the current time: rolling back");
      cd.rollback(sp);
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
              log.error("Error when updating table", e1);
              return false;
            }
          };
      boolean updateSuccess =
          downloadAndProcessZip(baseUrl + urlSuffix.getValue(), signedTime.get(), process);
      if (!updateSuccess) {
        cd.rollback(sp);
        return false;
      }
    }
    cd.commit();
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
  private record DownloadedCodes(
      String tableName, String location, XMLStreamReader xsr, InputStream input) {}

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
              log.error("Error when downloading XMLs", e);
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
          var m = Ecf4Helper.prep(new CourtPolicyQueryMessageType(), location);
          try {
            CourtPolicyResponseMessageType p = filingPort.getPolicy(m);
            policies.put(location, p);
          } catch (SOAPFaultException ex) {
            log.warn(
                "Got a SOAP excption getting policy for {} in {}: ", location, jurisdiction, ex);
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
                    (cc1) -> ecf4ElemToTableName.get(cc1.getECFElementName().getValue()),
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
      log.error("Couldn't get signed time to download codes, skipping all");
      return false;
    }
    Map<String, DownloadedCodes> downloaded =
        streamDownload(signedTime.get(), location, toDownload.parallel(), tables);
    downloads = downloads.plus(Duration.between(downloadStart, Instant.now(Clock.systemUTC())));
    log.info("Location: {}: Downloads took: {}", location, downloads);

    Instant updateStart = Instant.now(Clock.systemUTC());
    for (DownloadedCodes down : downloaded.values()) {
      try {
        cd.updateTable(down.tableName(), down.location(), down.xsr());
      } catch (Exception ex) {
        log.error("Couldn't update table?", ex);
      } finally {
        StdLib.closeQuitely(down.xsr());
        down.input().close();
      }
    }
    updates = updates.plus(Duration.between(updateStart, Instant.now(Clock.systemUTC())));

    cd.commit();
    log.info("Location: {}: updates took: {}", location, updates);
    return true;
  }

  /** Returns true if successful, false if not successful */
  public boolean updateAll(String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd)
      throws SQLException, IOException, JAXBException {
    HeaderSigner signer = new HeaderSigner(this.pathToKeystore, this.x509Password);
    if (!downloadSystemTables(baseUrl, cd, signer)) {
      log.warn(
          "System tables didn't update, but we needed them "
              + " to actually figure out new versions");
      return false;
    }

    // Drop each of tables that need to be updated
    Savepoint sp = cd.setSavepoint("court update savepoint");
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
      if (courtLocation.isBlank()) {
        log.warn("Ignoring tables with an empty court!");
        continue;
      }
      List<String> tables = courtAndTables.getValue();
      log.debug(
          "In {}, removing entries for court {} for tables: {}",
          cd.getDomain(),
          courtLocation,
          tables);
      for (String table : tables) {
        Instant deleteFromTable = Instant.now(Clock.systemUTC());

        // No longer checking for false here -- see PR.
        // Will ignore tables that don't exist.
        cd.deleteFromTable(table, courtLocation);

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
        cd.rollback(sp);
        return false;
      }
    }
    cd.commit();
    cd.setAutoCommit(true);
    cd.vacuumAll();
    return true;
  }

  /**
   * Downloads all of the codes from scratch, deleting all of the existing info already in tables.
   */
  public boolean replaceAll(String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd)
      throws SQLException, IOException, JAXBException {
    return replaceSome(baseUrl, filingPort, cd, List.of());
  }

  public boolean replaceSome(
      String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd, List<String> locs)
      throws SQLException, IOException, JAXBException {
    HeaderSigner signer = new HeaderSigner(this.pathToKeystore, this.x509Password);
    log.info("Downloading system tables for {}", cd.getDomain());
    boolean success = downloadSystemTables(baseUrl, cd, signer);

    var tablesToDeleteDomain = ecf4ElemToTableName.values();
    for (String table : tablesToDeleteDomain) {
      cd.createTableIfAbsent(table);
      cd.deleteFromTable(table);
    }
    cd.commit();

    downloads = Duration.ZERO;
    soaps = Duration.ZERO;
    updates = Duration.ZERO;
    if (locs.isEmpty()) {
      locs = cd.getAllLocations();
    }
    // Remove the "0" or top level court, which doesn't usually have individual court tables
    locs.remove("0");
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
    cd.commit();
    cd.setAutoCommit(true);
    cd.vacuumAll();
    return success;
  }

  /** Sets up the WSDL connection to Tyler, used for `getPolicy` to get the URL. */
  private static FilingReviewMDEPort loginWithTyler(
      String jurisdiction, String env, String userEmail, String userPassword) {
    Optional<TylerUserFactory> userFactory =
        TylerClients.getEfmUserFactory(jurisdiction, TylerEnv.parse(env));
    if (userFactory.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " in Soap chooser for EFMUser");
    }
    log.info("Getting filing factory for {} {}", jurisdiction, env);
    Optional<FilingReviewMDEService> filingFactory =
        SoapClientChooser.getFilingReviewFactory(jurisdiction, env);
    if (filingFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in Soap Chooser for filing review factory");
    }
    TylerUserClient userPort = userFactory.get().makeUserClient(ServiceHelpers::setupServicePort);
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
      log.warn("{} is not {}, not downloading here", args.get(1), jurisdiction);
      return false;
    }

    String table = args.get(2);
    String location = (args.size() == 4) ? args.get(3) : "";
    HeaderSigner hs = new HeaderSigner(this.pathToKeystore, this.x509Password);
    String endpoint = TylerClients.getTylerServerRootUrl(jurisdiction, TylerEnv.parse(env));
    return downloadAndProcessZip(
        makeCodeUrl(endpoint, table, location),
        hs.signedCurrentTime().get(),
        (in) -> {
          String newFile = location.replace(':', '_') + "_" + table + "_test.xml";
          try (FileOutputStream fw = new FileOutputStream(newFile)) {
            fw.write(in.readAllBytes());
          } catch (IOException e) {
            log.error("Error when writing xml", e);
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
      cd.setAutoCommit(false);
      String codesSite = TylerClients.getTylerServerRootUrl(jurisdiction, TylerEnv.parse(env));
      FilingReviewMDEPort filingPort =
          loginWithTyler(
              jurisdiction,
              env,
              System.getenv("TYLER_USER_EMAIL"),
              System.getenv("TYLER_USER_PASSWORD"));
      CodeUpdater cu = new CodeUpdater(System.getenv("PATH_TO_KEYSTORE"), x509Password);
      if (command.equalsIgnoreCase("replaceall")) {
        return cu.replaceAll(codesSite, filingPort, cd);
      } else if (command.equalsIgnoreCase("replacesome")) {
        return cu.replaceSome(codesSite, filingPort, cd, args.subList(1, args.size()));
      } else if (command.equalsIgnoreCase("refresh")) {
        return cu.updateAll(codesSite, filingPort, cd);
      } else if (command.equalsIgnoreCase("downloadIndiv")) {
        return cu.downloadIndiv(args, jurisdiction, env);
      } else {
        log.error("Command {} isn't a real command", command);
        return false;
      }
    } catch (SQLException | IOException | JAXBException e) {
      log.error("Exception when doing code updating! ", e);
      return false;
    }
  }

  /**
   * Run with:
   *
   * <pre>
   * java -cp efspserver-with-deps.jar edu.suffolk.litlab.efsp.ecfcodes.CodeUpdater refresh
   * </pre>
   *
   * <p>TODO(#111): use with this System property and class to try to fix parallel unmarshalling
   * -Djava.util.concurrent.ForkJoinPool.common.threadFactory=edu.suffolk.litlab.efsp.server.JAXBForkJoinWorkerThreadFactory
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
