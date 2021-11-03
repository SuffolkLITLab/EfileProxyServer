package edu.suffolk.litlab.efspserver.codes;

import edu.suffolk.litlab.efspserver.HeaderSigner;
import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.SoapX509CallbackHandler;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.ws.BindingProvider;

import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
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

public class CodeUpdater {
  private static Logger log =
      LoggerFactory.getLogger(CodeUpdater.class);

  public static final Map<String, String> ncToTableName = new HashMap<String, String>();

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
    ncToTableName.put("nc:PersonPhysicalFeature\\nc:PhysicalFeatureCategoryCode",
        "physicalfeature");
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
    ncToTableName.put("j:Citation\\nc:ActivityIdentification\\tyler:JurisdictionCode",
        "citationjurisdiction");
    ncToTableName.put("tyler:QuestionCode", "question");
    ncToTableName.put("tyler:AnswerCode", "answer");
  }

  private final String pathToKeystore;
  private final String x509Password;

  public CodeUpdater(String pathToKeystore, String x509Password) {
    this.pathToKeystore = pathToKeystore;
    this.x509Password = x509Password;
  }

  /**
   * https://stackoverflow.com/a/1485730/11416267
   *
   * @return
   * @throws IOException
   */
  public static InputStream getHtml(String urlToRead, String authHeader) throws IOException {
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("tyl-efm-api", authHeader);
    return conn.getInputStream();
  }

  private Duration downloads = Duration.ZERO;
  private Duration updates = Duration.ZERO;

  private boolean downloadAndProcessZip(String url, String signedTime, String tableName,
      String location, Function<InputStream, Boolean> process) {
    Instant startTable = Instant.now(Clock.systemUTC());
    try (InputStream urlStream = getHtml(url, signedTime)) {
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
      log.warn("Skipping " + url + ", got exception downloading zip: " + ex.toString());
      return false;
    }
  }

  private boolean downloadSystemTables(String baseUrl, CodeDatabase cd, HeaderSigner signer)
      throws SQLException, IOException, JAXBException, XMLStreamException {
    Map<String, String> codeUrls = Map.of("version", "/CodeService/codes/version/",
        "location", "/CodeService/codes/location/",
        // NOTE: the Tyler docs say this is available from `GetPolicy'. That is wrong.
        "error", "/CodeService/codes/error");

    Savepoint sp = cd.setSavePoint("systemTables");
    cd.dropTables(codeUrls.entrySet().stream().map((e) -> e.getKey()).collect(Collectors.toList()));

    // On first download, there won't be installed versions of things yet.
    cd.createTableIfAbsent("installedversion");

    Optional<String> signedTime = signer.signedCurrentTime();
    if (signedTime.isEmpty()) {
      log.error("Couldn't sign the current time: rolling back");
      cd.rollback(sp);
      return false;
    }

    for (Map.Entry<String, String> urlSuffix : codeUrls.entrySet()) {
      boolean updateSuccess = false;
      Function<InputStream, Boolean> process = (is) -> {
        try {
          // "0" is used as the system court location.
          cd.updateTable(urlSuffix.getKey(), "0", is);
          return true;
        } catch (Exception e1) {
          log.error(e1.toString());
          return false;
        }
      };
      updateSuccess = downloadAndProcessZip(baseUrl + urlSuffix.getValue(), signedTime.get(),
          urlSuffix.getKey(), "", process);
      if (!updateSuccess) {
        cd.rollback(sp);
        return false;
      }
    }
    cd.commit();
    return true;
  }

  /**
   *
   * @param location
   * @param codes If empty, all versions will be downloaded
   * @param cd
   * @param signer
   * @param conn
   */
  private boolean downloadCourtTables(String location, Optional<List<String>> codes, CodeDatabase cd,
      HeaderSigner signer, FilingReviewMDEPort filingPort)
      throws JAXBException, IOException, SQLException {
    log.debug("Location: " + location);
    CourtPolicyQueryMessageType m = ServiceHelpers.prep(new CourtPolicyQueryMessageType(), location);
    CourtPolicyResponseMessageType p = filingPort.getPolicy(m);

    for (CourtCodelistType ccl : p.getRuntimePolicyParameters().getCourtCodelist()) {
      String ecfElem = ccl.getECFElementName().getValue();
      if (ncToTableName.containsKey(ecfElem)) {
        String tableName = ncToTableName.get(ecfElem);
        if (codes.isEmpty() || codes.get().contains(tableName)) {
          boolean updateSuccess = false;
          // TODO(brycew-later): check that the effective date is later than today
          // JAXBElement<?> obj = ccl.getEffectiveDate().getDateRepresentation();

          // Tyler gives us URLs w/ spaces, which aren't valid. This makes them valid
          String url = ccl.getCourtCodelistURI().getIdentificationID().getValue().replace(" ",
              "%20");
          Optional<String> signedTime = signer.signedCurrentTime();
          if (signedTime.isEmpty()) {
            log.error("Couldn't get signed time to download codeds, skipping all");
            return false;
          }

          Function<InputStream, Boolean> process = (is) -> {
            try {
              cd.updateTable(tableName, location, is);
              return true;
            } catch (Exception e1) {
              log.error(e1.toString());
              return false;
            }
          };
          updateSuccess = downloadAndProcessZip(url, signedTime.get(), tableName, location, process);
          if (!updateSuccess) {
            return false;
          }
        }
      } else {
        log.error(ecfElem + " not in the nc map!");
      }
    }
    cd.commit();
    log.info("Downloads took: " + downloads + ", and updates took: " + updates);
    return true;
  }

  public void updateAll(String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd)
      throws SQLException, IOException, JAXBException, XMLStreamException {
    HeaderSigner signer = new HeaderSigner(this.pathToKeystore, this.x509Password);
    if (!downloadSystemTables(baseUrl, cd, signer)) {
      log.warn("System tables didn't update, but we needed them "
          + " to actually figure out new versions");
      return;
    }

    // Drop each of tables that need to be updated
    Map<String, List<String>> versionsToUpdate = cd.getVersionsToUpdate();
    for (Entry<String, List<String>> courtAndTables : versionsToUpdate.entrySet()) {
      String courtLocation = courtAndTables.getKey();
      Savepoint sp = cd.setSavePoint("court" + courtLocation + "savepoint");
      List<String> tables = courtAndTables.getValue();
      for (String table : tables) {
       Instant deleteFromTable = Instant.now(Clock.systemUTC());
        if (!cd.deleteFromTable(table, courtLocation)) {
          log.warn("Couldn't delete from " + table + " at " + courtLocation + ", aborting");
          cd.rollback(sp);
          return;
        }
        updates = updates.plus(Duration.between(deleteFromTable, Instant.now(Clock.systemUTC())));
      }
      log.info("Removed entries for court " + courtLocation + " for tables: " + tables);
      if (!downloadCourtTables(courtLocation, Optional.of(tables), cd, signer, filingPort)) {
        log.warn("Failed updating court " + courtLocation + "'s tables " + tables);
        cd.rollback(sp);
        return;
      }
    }
    cd.commit();
  }

  public void downloadAll(String baseUrl, FilingReviewMDEPort filingPort, CodeDatabase cd)
      throws SQLException, IOException, JAXBException, XMLStreamException {
    HeaderSigner signer = new HeaderSigner(this.pathToKeystore, this.x509Password);
    log.info("Downloading system tables");
    downloadSystemTables(baseUrl, cd, signer);

    List<String> tablesToDrop = ncToTableName.entrySet().stream().map((e) -> e.getValue())
        .collect(Collectors.toUnmodifiableList());
    cd.dropTables(tablesToDrop);
    cd.commit();

    downloads = Duration.ZERO;
    updates = Duration.ZERO;
    List<String> locs = cd.getAllLocations();
    for (String location : locs) {
      log.info("Downloading tables for " + location);
      downloadCourtTables(location, Optional.empty(), cd, signer, filingPort);
    }
    log.info("Downloads took: " + downloads + ", and updates took: " + updates);
    cd.commit();
  }
  
  public static FilingReviewMDEPort loginWithTyler(String jurisdiction, String userEmail, String userPassword) throws JAXBException {
    Optional<EfmUserService> userService = SoapClientChooser.getEfmUserFactory(jurisdiction);
    if (userService.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " in Soap chooser for EFMUser");
    }
    Optional<FilingReviewMDEService> filingFactory = SoapClientChooser.getFilingReviewFactory(jurisdiction); 
    if (filingFactory.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " in Soap Chooser for filing review factory");
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
    Map<String, Object> ctx = ((BindingProvider)filingPort).getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    return filingPort;
  }
  
  public static void executeCommand(String command, String codesSite, CodeDatabase cd,
      String x509Password) {
    SoapX509CallbackHandler.setX509Password(x509Password);
    try {
      // TODO(brycew): need to still handle a whole slate of jurisdiction things
      String jurisdiction = System.getenv("TYLER_JURISDICTION");
      String tylerEnv = System.getenv("TYLER_ENV");
      if (tylerEnv != null) {
        jurisdiction += "-" + tylerEnv;
      }
      FilingReviewMDEPort filingPort = loginWithTyler(
          jurisdiction, System.getenv("TYLER_USER_EMAIL"),
          System.getenv("TYLER_USER_PASSWORD")); 
      CodeDatabase usingCd;
      if (cd == null) {
        usingCd = new CodeDatabase(System.getenv("POSTGRES_URL"),
            Integer.parseInt(System.getenv("POSTGRES_PORT")),
            System.getenv("POSTGRES_CODES_DB"));
        usingCd.createDbConnection(System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"));
      } else {
        usingCd = cd;
      }
      usingCd.setAutocommit(false);
      CodeUpdater cu = new CodeUpdater(System.getenv("PATH_TO_KEYSTORE"), x509Password);
      if (command.equalsIgnoreCase("downloadall")) {
        cu.downloadAll(codesSite, filingPort, usingCd);
      } else if (command.equalsIgnoreCase("refresh")) {
        cu.updateAll(codesSite, filingPort, usingCd);
      } else {
        log.error("Command " + command + " isn't a real command");
        return;
      }
    } catch (SQLException | IOException | JAXBException | XMLStreamException e) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      log.error("Exception when making doing code updating! " + e.toString() + " " + sw.toString());
      return;
    }
  }

  public static void downloadIndiv(String[] args) throws Exception {
    if (args.length < 2) {
      log.error("Need to pass in args: downloadIndiv <table> <location or blank for system>");
      System.exit(1);
    }
    CodeDatabase cd = new CodeDatabase(System.getenv("POSTGRES_URL"),
        Integer.parseInt(System.getenv("POSTGRES_PORT")),
        System.getenv("POSTGRES_CODES_DB"));
    cd.createDbConnection(System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"));

    String path = System.getenv("PATH_TO_KEYSTORE");
    String pass = System.getenv("X509_PASSWORD");
    CodeUpdater cu = new CodeUpdater(path, pass);
    HeaderSigner hs = new HeaderSigner(path, pass);
    String location = (args.length == 3) ? args[2] : "";
    String table = args[1];
    cu.downloadAndProcessZip(System.getenv("TYLER_ENDPOINT") + "CodeService/codes/" + table + "/" + location, hs.signedCurrentTime().get(),
          table, location, (in) -> {
            String newFile = location.replace(':', '_') + "_" + table + "_test.xml";
            try {
              FileOutputStream fw = new FileOutputStream(newFile);
              fw.write(in.readAllBytes());
              fw.close();
            } catch (IOException e) {
              log.error(e.toString());
              return false;
            }
            return true;
          });
  }

  /** Run with `mvn exec:java@CodeUpdater -Dexec.args="refresh". */
  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      log.error("Need to pass in a subprogram: downloadIndiv, or refresh");
      System.exit(1);
    }
    if (args[0].equalsIgnoreCase("downloadIndiv")) {
      downloadIndiv(args);
    } else {
      executeCommand(args[0], System.getenv("TYLER_ENDPOINT"), null, System.getenv("X509_PASSWORD"));
    }
  }
}
