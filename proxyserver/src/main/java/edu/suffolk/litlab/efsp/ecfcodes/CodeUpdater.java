package edu.suffolk.litlab.efsp.ecfcodes;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.UnsupportedTableException;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import jakarta.xml.bind.JAXBException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Updates the Tyler "Codes" for each court in a jurisdiction.
 *
 * <p>There are 3 main steps to download a code for a Tyler court: 1. calling
 * `FilingReview::getPolicy` for a court to get the URLs that the codes are available at. - this URL
 * can change, but tbh doesn't change often. It takes approximately 1 for a call to getPolicy to
 * complete. 2. downloading the codes, which are zip files available at the above URL. - You need
 * the court itself, the table that you are downloading. Currently, we take the input stream and
 * divert it directly to the XMLStream reader, so we don't need to write out to a file. 3. updating
 * the Postgres codes database - this takes the XMLStreamReader, unmarshalls it into a java object,
 * and uses that to populate the code database. Most code for that is in tyler.CodeDatabase.
 *
 * <p>We parallelize this as much as possible, which means steps 1 and 2 are done in batch, and each
 * court / court-table item is done in parallel. Step 3, however, can't seem to be parallelized, due
 * to java issues. See https://github.com/SuffolkLITLab/EfileProxyServer/issues/111
 *
 * <p>For TX, IL, and MA, it takes ~45 minutes to refresh all of the codes.
 */
public class CodeUpdater {
  private static final Logger log = LoggerFactory.getLogger(CodeUpdater.class);

  public CodeUpdater() {}

  private Duration downloadDuration = Duration.ZERO;
  private Duration updateDuration = Duration.ZERO;
  private Duration soapDuration = Duration.ZERO;

  /**
   * @param toRead
   * @param signedTime
   * @param process
   * @return
   * @throws URISyntaxException
   */
  private boolean downloadAndProcessZip(
      CodeUrlGetter urlGetter, String url, Function<InputStream, Boolean> process)
      throws URISyntaxException {
    Instant startTable = Instant.now();
    try (InputStream urlStream = urlGetter.get(url)) {
      // Write out the zip file
      downloadDuration = downloadDuration.plus(Duration.between(startTable, Instant.now()));

      Instant updateTableLoc = Instant.now();
      boolean success = process.apply(urlStream);
      updateDuration = updateDuration.plus(Duration.between(updateTableLoc, Instant.now()));
      return success;
    } catch (IOException ex) {
      // Some system codes (everything but "country", "state", "filingstatus", "datafieldconfig",
      // and "servicetype") are expected to 500. Not really sure why they give us bad URLs.
      log.warn("Skipping, got exception accessing zip: ", ex);
      return false;
    }
  }

  private boolean downloadSystemTables(
      Map<String, String> codelistUrls, CodeDatabaseAPI cd, CodeUrlGetter urlGetter)
      throws SQLException, IOException, JAXBException, URISyntaxException {
    MDC.put(MDCWrappers.SESSION_ID, "system");

    for (String tableName : codelistUrls.keySet()) {
      MDC.put(MDCWrappers.REQUEST_ID, tableName);
      cd.createTableIfAbsent(tableName);
    }

    MDC.put(MDCWrappers.REQUEST_ID, "installedversion");
    // On first download, there won't be installed versions of things yet.
    cd.createTableIfAbsent("installedversion");
    MDC.remove(MDCWrappers.REQUEST_ID);

    cd.commit();

    Savepoint sp = cd.setSavepoint("systemTables");

    boolean refreshed = urlGetter.refresh("");
    if (!refreshed) {
      log.error("Couldn't sign the current time: rolling back");
      cd.rollback(sp);
      return false;
    }

    for (var tableAndUrl : codelistUrls.entrySet()) {
      // Let SQL exceptions through here; table names are hard coded, so if they break
      // we need to know.
      var tableName = tableAndUrl.getKey();
      cd.deleteFromTable(tableName);
      final Function<InputStream, Boolean> process =
          (is) -> {
            MDC.put(MDCWrappers.REQUEST_ID, tableName);
            try {
              // "0" is used as the system court location.
              cd.updateTable(tableName, "0", is);
              return true;
            } catch (final Exception e1) {
              log.error("Error when updating table", e1);
              return false;
            }
          };
      boolean success = downloadAndProcessZip(urlGetter, tableAndUrl.getValue(), process);
      MDC.remove(MDCWrappers.REQUEST_ID);
      if (!success) {
        cd.rollback(sp);
        return false;
      }
    }
    cd.commit();
    MDC.remove(MDCWrappers.SESSION_ID);
    return true;
  }

  /**
   * Internal class, meant to pass around information between the "getPolicy URL" stage and the
   * "download zip" stage.
   */
  private static record CodeToDownload(String tableName, String url) {}

  /**
   * Internal class, meant to pass around information between the "download zip" stage and the
   * "update postgres" stage.
   */
  private record DownloadedCodes(String tableName, String location, InputStream input) {}

  /**
   * @param authHeader The header needed to download the codes
   * @param location The court code
   * @param courtCodeList The list of codes to download for this court
   * @param tables
   * @return a map of the actually downloaded codes
   */
  private static Map<String, DownloadedCodes> streamDownload(
      CodeUrlGetter urlGetter,
      String location,
      Stream<CodeToDownload> courtCodeList,
      Optional<List<String>> tables) {
    var codeLists = new ConcurrentHashMap<String, DownloadedCodes>();
    courtCodeList.forEach(
        toDownload -> {
          if (tables.isEmpty() || tables.get().contains(toDownload.tableName)) {
            try {
              log.info("Getting URL for: {}", toDownload);
              InputStream urlStream = urlGetter.get(toDownload.url);
              codeLists.put(
                  toDownload.tableName,
                  new DownloadedCodes(toDownload.tableName, location, urlStream));
            } catch (IOException | URISyntaxException e) {
              log.error("Error when downloading XMLs", e);
            }
          }
        });
    return codeLists;
  }

  private static Map<String, List<CourtCodelistInfo>> streamPolicies(
      Stream<String> locations,
      Jurisdiction jurisdiction,
      Function<String, List<CourtCodelistInfo>> courtCodeGetter) {
    var policies = new ConcurrentHashMap<String, List<CourtCodelistInfo>>();
    locations.forEach(
        location -> {
          policies.put(location, courtCodeGetter.apply(location));
        });
    return policies;
  }

  // An agnostic type for CourtCodelistType
  public record CourtCodelistInfo(String ecfElement, String uri, LocalDate effectiveDate) {}

  /**
   * @param tables If empty, all versions will be downloaded
   */
  private boolean downloadCourtTables(
      String location,
      Optional<List<String>> tables,
      CodeDatabaseAPI cd,
      CodeUrlGetter urlGetter,
      List<CourtCodelistInfo> policyResp)
      throws JAXBException, IOException, SQLException {
    MDC.put(MDCWrappers.SESSION_ID, location);
    log.info("Doing updates for: {},\ttables: {}", location, tables);
    Instant downloadStart = Instant.now();
    // TODO(brycew-later): check that the effective date is later than today
    // JAXBElement<?> obj = ccl.getEffectiveDate().getDateRepresentation();
    Map<String, String> urlMap =
        policyResp.stream()
            .collect(
                Collectors.toMap(
                    (cc1) -> cd.xmlElemToTableName().get(cc1.ecfElement()),
                    // Tyler gives us URLs w/ spaces, which aren't valid. This makes them valid
                    (cc1) -> cc1.uri().replace(" ", "%20")));
    Stream<CodeToDownload> toDownload;
    if (tables.isEmpty()) {
      toDownload =
          urlMap.entrySet().stream().map((ent) -> new CodeToDownload(ent.getKey(), ent.getValue()));
    } else {
      toDownload =
          tables.get().stream()
              .filter(tableName -> urlMap.containsKey(tableName))
              .map(tableName -> new CodeToDownload(tableName, urlMap.get(tableName)));
    }
    boolean refreshed = urlGetter.refresh(location);
    if (!refreshed) {
      log.error("Couldn't get signed time to download codes, skipping all");
      MDC.remove(MDCWrappers.SESSION_ID);
      return false;
    }
    Map<String, DownloadedCodes> downloaded =
        streamDownload(urlGetter, location, toDownload.parallel(), tables);
    var downloadInc = Duration.between(downloadStart, Instant.now());
    downloadDuration = downloadDuration.plus(downloadInc);
    log.info(
        "Location: {}:\tDownloads took: {} (total: {})", location, downloadInc, downloadDuration);

    Instant updateStart = Instant.now();
    for (DownloadedCodes down : downloaded.values()) {
      MDC.put(MDCWrappers.REQUEST_ID, down.tableName());
      try {
        cd.updateTable(down.tableName(), down.location(), down.input());
      } catch (Exception ex) {
        log.error("Couldn't update table?", ex);
      } finally {
        down.input().close();
      }
    }
    var updateInc = Duration.between(updateStart, Instant.now());
    updateDuration = updateDuration.plus(updateInc);

    cd.commit();
    log.info("Location: {}:\tupdates took: {} (total: {})", location, updateInc, updateDuration);
    MDC.remove(MDCWrappers.REQUEST_ID);
    MDC.remove(MDCWrappers.SESSION_ID);
    return true;
  }

  /**
   * Creates all of the tables to update. If it can't create them, it removes them from the list.
   */
  private Map<String, List<String>> makeOrRemoveUnsupportedTables(
      Map<String, List<String>> versionsToUpdate, CodeDatabaseAPI cd) throws SQLException {
    var allTables = new HashSet<String>();
    log.info("Making tables (if any are absent)");
    for (var tables : versionsToUpdate.values()) {
      allTables.addAll(tables);
    }

    var brokenTables = new HashSet<String>();
    for (String table : allTables) {
      try {
        cd.createTableIfAbsent(table);
      } catch (UnsupportedTableException ex) {
        log.warn("Ignoring table {} from Tyler's report (not in our allow list)", table);
        brokenTables.add(table);
      }
    }

    var toReturn = new HashMap<String, List<String>>();
    for (var courtAndTables : versionsToUpdate.entrySet()) {
      String courtLocation = courtAndTables.getKey();
      if (courtLocation.isBlank()) {
        log.warn("Ignoring tables with an empty court!");
        continue;
      }
      List<String> tables = courtAndTables.getValue();
      tables.removeAll(brokenTables);
      if (tables.isEmpty()) {
        continue;
      }
      toReturn.put(courtLocation, tables);
    }

    return toReturn;
  }

  /**
   * Returns true if successful, false if not successful
   *
   * @throws URISyntaxException
   */
  public boolean updateAll(
      Map<String, String> systemUrls,
      Function<String, List<CourtCodelistInfo>> codeInfoGetter,
      CodeUrlGetter urlGetter,
      CodeDatabaseAPI cd)
      throws SQLException, IOException, JAXBException, URISyntaxException {
    cd.setAutoCommit(false);
    if (!downloadSystemTables(systemUrls, cd, urlGetter)) {
      log.warn(
          "System tables didn't update, but we needed them "
              + " to actually figure out new versions");
      return false;
    }

    // Drop each of tables that need to be updated
    Savepoint sp = cd.setSavepoint("court update savepoint");
    Map<String, List<String>> rawVersionsToUpdate = cd.getVersionsToUpdate();
    Map<String, List<String>> versionsToUpdate =
        makeOrRemoveUnsupportedTables(rawVersionsToUpdate, cd);
    Instant startDel = Instant.now();
    log.info(
        "Removing {} court entries, over {} queries",
        versionsToUpdate.size(),
        versionsToUpdate.values().stream().map(List::size).reduce(0, (a, b) -> a + b));
    for (Entry<String, List<String>> courtAndTables : versionsToUpdate.entrySet()) {
      final String courtLocation = courtAndTables.getKey();
      List<String> tables = courtAndTables.getValue();
      log.debug(
          "In {},\nremoving entries for court {} for tables: {}",
          cd.getJurisdiction(),
          courtLocation,
          tables);
      for (String table : tables) {
        Instant delTime = Instant.now();

        // Will ignore tables that don't exist.
        cd.deleteFromTable(table, courtLocation);

        updateDuration = updateDuration.plus(Duration.between(delTime, Instant.now()));
      }
    }
    log.info("Took {} to remove existing tables", Duration.between(startDel, Instant.now()));
    Instant startPolicy = Instant.now();
    Map<String, List<CourtCodelistInfo>> policies =
        streamPolicies(
            versionsToUpdate.keySet().stream().parallel(), cd.getJurisdiction(), codeInfoGetter);
    var soapInc = Duration.between(startPolicy, Instant.now());
    soapDuration = soapDuration.plus(soapInc);
    log.info("Soaps took: {} (total: {})", soapInc, soapDuration);

    for (var policy : policies.entrySet()) {
      final String courtLocation = policy.getKey();
      final List<String> tables = versionsToUpdate.get(courtLocation);
      if (!downloadCourtTables(
          courtLocation, Optional.of(tables), cd, urlGetter, policy.getValue())) {
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
   *
   * @throws URISyntaxException
   */
  public boolean replaceAll(
      Map<String, String> systemUrls,
      Function<String, List<CourtCodelistInfo>> codeInfoGetter,
      CodeUrlGetter urlGetter,
      CodeDatabaseAPI cd)
      throws SQLException, IOException, JAXBException, URISyntaxException {
    return replaceSome(systemUrls, codeInfoGetter, urlGetter, cd, List.of());
  }

  public boolean replaceSome(
      Map<String, String> systemUrls,
      Function<String, List<CourtCodelistInfo>> codeInfoGetter,
      CodeUrlGetter urlGetter,
      CodeDatabaseAPI cd,
      List<String> locs)
      throws SQLException, IOException, JAXBException, URISyntaxException {
    cd.setAutoCommit(false);
    log.info("Downloading system tables for {}", cd.getJurisdiction());
    boolean success = downloadSystemTables(systemUrls, cd, urlGetter);

    var tablesToDeleteDomain = cd.xmlElemToTableName().values();
    for (String table : tablesToDeleteDomain) {
      cd.createTableIfAbsent(table);
      cd.deleteFromTable(table);
    }
    cd.commit();

    downloadDuration = Duration.ZERO;
    soapDuration = Duration.ZERO;
    updateDuration = Duration.ZERO;
    if (locs.isEmpty()) {
      locs = cd.getAllLocations();
    }
    if (locs.contains("0")) {
      // Remove the "0" or top level court, which doesn't usually have individual court tables
      locs = new ArrayList<>(locs);
      locs.remove("0");
    }
    Instant startPolicy = Instant.now();
    var policies = streamPolicies(locs.parallelStream(), cd.getJurisdiction(), codeInfoGetter);
    soapDuration = soapDuration.plus(Duration.between(startPolicy, Instant.now()));
    log.info("Soaps: {}", soapDuration);
    for (var policy : policies.entrySet()) {
      final String location = policy.getKey();
      log.info("Downloading tables for {}", location);
      success &= downloadCourtTables(location, Optional.empty(), cd, urlGetter, policy.getValue());
    }
    log.info(
        "Downloads took: {}, updates took: {}, soaps took: {}",
        downloadDuration,
        updateDuration,
        soapDuration);
    cd.commit();
    cd.setAutoCommit(true);
    cd.vacuumAll();
    return success;
  }

  /**
   * Downloads a single codes zip. For Debugging.
   *
   * @throws URISyntaxException
   */
  public boolean downloadIndiv(
      List<String> args, BiFunction<String, String, String> makeUrl, CodeUrlGetter urlGetter)
      throws URISyntaxException {
    if (args.size() < 3) {
      log.error(
          "Need to pass in args: downloadIndiv <jurisdiction> <table> <location or blank for"
              + " system>");
      return false;
    }

    String table = args.get(2);
    String location = (args.size() == 4) ? args.get(3) : "";
    return downloadAndProcessZip(
        urlGetter,
        makeUrl.apply(table, location),
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

  /** Should just be called from main. */
  public static CodeDatabaseAPI makeCodeDatabase(Function<DataSource, CodeDatabaseAPI> dbMaker) {
    try {
      DataSource ds =
          DatabaseCreator.makeDataSource(
              System.getenv("POSTGRES_URL"),
              Integer.parseInt(System.getenv("POSTGRES_PORT")),
              System.getenv("POSTGRES_CODES_DB"),
              System.getenv("POSTGRES_USER"),
              System.getenv("POSTGRES_PASSWORD"),
              10,
              100);

      return dbMaker.apply(ds);
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
