package edu.suffolk.litlab.efspserver.tyler.codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class CodeTableConstants {
  /*
   * a list of CREATE INDEX queries you should run for on creation of these tables.
   */
  private static final Map<String, List<String>> tableIndices = new HashMap<>();
  private static final Map<String, TableColumns> tableColumns;
  private static final Map<String, String> createQueries = new HashMap<>();
  private static final Map<String, String> insertQueries = new HashMap<>();
  private static final Map<String, String> deleteFromQueries = new HashMap<>();
  private static final Map<String, String> deleteAllCourtsFromQueries = new HashMap<>();

  static {
    List<Pair<String, String>> locationColumns = new ArrayList<Pair<String, String>>();
    locationColumns.add(new ImmutablePair<String, String>("code", "text"));
    locationColumns.add(new ImmutablePair<String, String>("name", "text"));
    locationColumns.add(new ImmutablePair<String, String>("initial", "text"));
    locationColumns.add(new ImmutablePair<String, String>("subsequent", "text"));
    locationColumns.add(new ImmutablePair<String, String>("disallowcopyingenvelopemultipletimes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowfilingintononindexedcase", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowablecardtypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("odysseynodeid", "text"));
    locationColumns.add(new ImmutablePair<String, String>("cmsid", "text"));
    locationColumns.add(new ImmutablePair<String, String>("sendservicebeforereview", "text"));
    locationColumns.add(new ImmutablePair<String, String>("parentnodeid", "text"));
    locationColumns.add(new ImmutablePair<String, String>("iscounty", "text"));
    locationColumns.add(new ImmutablePair<String, String>("restrictbankaccountpayment", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowmultipleattorneys", "text"));
    locationColumns.add(new ImmutablePair<String, String>("sendservicecontactremovednotifications", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowmaxfeeamount", "text"));
    locationColumns.add(new ImmutablePair<String, String>("transferwaivedfeestocms", "text"));
    locationColumns.add(new ImmutablePair<String, String>("skippreauth", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowhearing", "text")); 
    locationColumns.add(new ImmutablePair<String, String>("allowreturndate", "text")); 
    locationColumns.add(new ImmutablePair<String, String>("showdamageamount", "text")); // Isn't in document anymore?
    locationColumns.add(new ImmutablePair<String, String>("hasconditionalservicetypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("hasprotectedcasetypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("protectedcasetypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowzerofeeswithoutfilingparty", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowserviceoninitial", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowaddservicecontactsoninitial", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowredaction", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactionurl", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactionviewerurl", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactiontargetconfig", "text"));
    locationColumns.add(new ImmutablePair<String, String>("enforceredaction", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactiondocumenttype", "text"));
    locationColumns.add(new ImmutablePair<String, String>("defaultdocumentdescription", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowwaiveronmail", "text"));
    locationColumns.add(new ImmutablePair<String, String>("showreturnonreject", "text"));
    locationColumns.add(new ImmutablePair<String, String>("protectedcasereplacementstring", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowchargeupdate", "text")); // Isn't in document anymore?
    locationColumns.add(new ImmutablePair<String, String>("allowpartyid", "text")); // Isn't in documentation anymore?
    locationColumns.add(new ImmutablePair<String, String>("redactionfee", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowwaiveronredaction", "text"));
    locationColumns.add(new ImmutablePair<String, String>("disallowelectronicserviceonnewcontacts", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowindividualregistration", "text"));
    TableColumns locationTc = makeTableColumnInfo(false, locationColumns);
    tableColumns = Map.ofEntries(
        Map.entry("location", locationTc),
        Map.entry("error", makeSystemColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text")))),
        Map.entry("version", makeSystemColumnInfo(List.of(
          new ImmutablePair<String, String>("location", "text"),
          new ImmutablePair<String, String>("codelist", "text"), 
          new ImmutablePair<String, String>("version", "text")))),
        // custom table, the version that's currently installed
        // Custom table so we can just drop the existing version table when updating.
        Map.entry("installedversion", makeTableColumnInfo(false, List.of(
          new ImmutablePair<String, String>("location", "text"),
          new ImmutablePair<String, String>("codelist", "text"), 
          new ImmutablePair<String, String>("installedversion", "text")),
          List.of("location", "codelist", "domain"))),
        //////////// Tables that are both system wide, and court specific
        Map.entry("country", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text")))),
        Map.entry("state", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("countrycode", "text")))),
        Map.entry("filingstatus", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text")))),
        Map.entry("datafieldconfig", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "varchar(80)"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("isvisible", "boolean"),
          new ImmutablePair<String, String>("isrequired", "boolean"), 
          new ImmutablePair<String, String>("helptext", "text"),
          new ImmutablePair<String, String>("ghosttext", "text"),
          new ImmutablePair<String, String>("contextualhelpdata", "text"),
          new ImmutablePair<String, String>("validationmessage", "text"),
          new ImmutablePair<String, String>("regularexpression", "text"),
          new ImmutablePair<String, String>("defaultvalueexpression", "text"),
          new ImmutablePair<String, String>("isreadonly", "boolean")))),
        ///////// Tables for courts specifically
        Map.entry("answer", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("answertext", "text"),
          new ImmutablePair<String, String>("questionid", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("arrestlocation", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("bond", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("casecategory", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("ecfcasetype", "text"),
          new ImmutablePair<String, String>("procedureremedyinitial", "text"),
          new ImmutablePair<String, String>("procedureremedysubsequent", "text"),
          new ImmutablePair<String, String>("damageamountinitial", "text"),
          new ImmutablePair<String, String>("damageamountsubsequent", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("casesubtype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("casetypeid", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("casetype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "varchar(40)"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("casecategory", "text"),
          new ImmutablePair<String, String>("initial", "text"),
          new ImmutablePair<String, String>("fee", "text"),
          new ImmutablePair<String, String>("willfileddate", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("chargephase", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("citationjurisdiction", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("crossreference", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("casetypeid", "text"),
          new ImmutablePair<String, String>("isdefault", "text"),
          new ImmutablePair<String, String>("isrequired", "text"),
          new ImmutablePair<String, String>("validationregex", "text"),
          new ImmutablePair<String, String>("customvalidationfailuremessage", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("damageamount", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("casecategory", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("degree", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("statuecodeid", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("disclaimerrequirement", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"), 
          new ImmutablePair<>("name", "text"),
          new ImmutablePair<>("listorder", "text"),
          new ImmutablePair<>("requirementtext", "text"),
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("driverlicensetype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("documenttype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("filingcodeid", "text"),
          new ImmutablePair<String, String>("iscourtuseonly", "text"),
          new ImmutablePair<String, String>("isdefault", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("ethnicity", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("eyecolor", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("filertype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("default", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("filetype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("extension", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("filing", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "varchar(40)"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("fee", "text"),
          new ImmutablePair<String, String>("casecategory", "text"),
          new ImmutablePair<String, String>("casetypeid", "text"),
          new ImmutablePair<String, String>("filingtype", "text"),
          new ImmutablePair<String, String>("iscourtuseonly", "boolean"),
          new ImmutablePair<String, String>("civilclaimamount", "text"),
          new ImmutablePair<String, String>("probateestateamount", "text"),
          new ImmutablePair<String, String>("amountincontroversy", "text"),
          new ImmutablePair<String, String>("useduedate", "boolean"),
          new ImmutablePair<String, String>("isproposedorder", "boolean"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("filingcomponent", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "varchar(40)"), 
          new ImmutablePair<>("name", "text"),
          new ImmutablePair<>("filingcodeid", "varchar(40)"),
          new ImmutablePair<>("required", "boolean"),
          new ImmutablePair<>("allowmultiple", "boolean"),
          new ImmutablePair<>("displayorder", "integer"),
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("generaloffense", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"), 
          new ImmutablePair<>("name", "text"),
          new ImmutablePair<>("statutecodeid", "text"),
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("haircolor", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"), 
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("language", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("lawenforcementunit", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("motiontype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("filingcodeid", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("namesuffix", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("partytype", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "varchar(40)"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("isavailablefornewparties", "boolean"),
          new ImmutablePair<String, String>("casetypeid", "text"),
          new ImmutablePair<String, String>("isrequired", "boolean"),
          new ImmutablePair<String, String>("amount", "text"),
          new ImmutablePair<String, String>("numberofpartiestoignore", "text"),
          new ImmutablePair<String, String>("sendforredaction", "text"),
          new ImmutablePair<String, String>("dateofdeath", "text"),
          new ImmutablePair<String, String>("displayorder", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("physicalfeature", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("procedureremedy",makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"), 
          new ImmutablePair<String, String>("name", "text"),
          new ImmutablePair<String, String>("casecategory", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("question", makeCourtColumnInfo(List.of(
          new ImmutablePair<String, String>("code", "text"),
          new ImmutablePair<String, String>("name", "text"), 
          new ImmutablePair<String, String>("questiontext", "text"),
          new ImmutablePair<String, String>("helptext", "text"), 
          new ImmutablePair<String, String>("isrequired", "text"),
          new ImmutablePair<String, String>("efspcode", "text")))),
        Map.entry("race", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"),
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("servicetype", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"), 
          new ImmutablePair<>("servicemethod", "text"),
          new ImmutablePair<>("fee", "text"), 
          new ImmutablePair<>("disclaimertext", "text")))),
        Map.entry("statute", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"), 
          new ImmutablePair<>("name", "text"),
          new ImmutablePair<>("word", "text"), 
          new ImmutablePair<>("referenceid", "text"),
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("statutetype", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"), 
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("vehiclecolor", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"), 
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("vehiclemake", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"), 
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("vehicletype", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"), 
          new ImmutablePair<>("efspcode", "text")))),
        Map.entry("refundreason", makeCourtColumnInfo(List.of(
          new ImmutablePair<>("code", "text"),
          new ImmutablePair<>("name", "text"),
          new ImmutablePair<>("efspcode", "text"))))
    );
    for (Map.Entry<String, TableColumns> table : tableColumns.entrySet()) {
      createQueries.put(table.getKey(), createTableQuery(table.getKey(), table.getValue()));
      insertQueries.put(table.getKey(), createInsertQuery(table.getKey(), table.getValue()));
      deleteAllCourtsFromQueries.put(table.getKey(), "DELETE FROM " + table.getKey() + " WHERE domain=?");
      if (table.getValue().needsExtraLocCol) {
        deleteFromQueries.put(table.getKey(), "DELETE FROM " + table.getKey() + " WHERE domain=? AND location=?");
      }
    }
    
    tableIndices.put("filing", List.of(
        "CREATE INDEX ON filing (location)",
        "CREATE INDEX ON filing (casecategory)",
        "CREATE INDEX ON filing (casetypeid)",
        "CREATE INDEX ON filing (domain)"));
    tableIndices.put("filingcomponent", List.of(
        "CREATE INDEX ON filingcomponent (location)", 
        "CREATE INDEX ON filingcomponent (filingcodeid)",
        "CREATE INDEX ON filingcomponent (domain)")); 
  }

  public static String getZipNameFromTable(String tableName) {
    if (tableName.equalsIgnoreCase("location")) {
      return "locations.zip";
    } else {
      return tableName + "codes.zip";
    }
  }

  private static class TableColumns {
    public List<Pair<String, String>> mainList = List.of();
    public List<String> primaryKeys = List.of();
    public boolean needsExtraLocCol = false;
  }

  private static TableColumns makeCourtColumnInfo(List<Pair<String, String>> mainList) {
    return makeTableColumnInfo(true, mainList, List.of());
  }

  private static TableColumns makeSystemColumnInfo(List<Pair<String, String>> mainList) {
    return makeTableColumnInfo(false, mainList, List.of());
  }

  private static TableColumns makeTableColumnInfo(boolean needsExtraLocCol,
      List<Pair<String, String>> mainList) {
    return makeTableColumnInfo(needsExtraLocCol, mainList, List.of());
  }

  private static TableColumns makeTableColumnInfo(boolean needsExtraLocCol,
      List<Pair<String, String>> mainList, List<String> primaryKeys) {
    TableColumns tableCols = new TableColumns();
    tableCols.mainList = mainList;
    tableCols.primaryKeys = primaryKeys;
    tableCols.needsExtraLocCol = needsExtraLocCol;
    return tableCols;
  }

  public static List<String> getTableColumns(String tableName) {
    // Drops the type in the column name + type pairs.
    return tableColumns.getOrDefault(tableName, new TableColumns())
        .mainList.stream().map((e) -> e.getLeft()).collect(Collectors.toList());
  }

  public static List<Pair<String, String>> getTableColumnsWithType(String tableName) {
    return tableColumns.getOrDefault(tableName, new TableColumns()).mainList;
  }
  
  public static boolean isCourtTable(String tableName) {
    return tableColumns.getOrDefault(tableName, new TableColumns()).needsExtraLocCol;
  }

  public static String getTableExists() {
    return """
        SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public'
        AND table_name = ? LIMIT 1;""";
  }

  public static String getIndicesExist() {
    return """
        SELECT COUNT(*) FROM pg_catalog.pg_indexes where schemaname='public'
        AND tablename = ? LIMIT 1;""";
  }

  public static String updateVersion() {
    return """
        INSERT INTO installedversion (location, codelist, installedversion, domain) VALUES(?, ?, ?, ?)
        ON CONFLICT (domain, location, codelist) DO UPDATE SET installedversion=?""";
  }

  public static String needToUpdateVersion() {
    return """
        SELECT v.location, v.codelist, iv.installedversion, v.version
        FROM version AS v LEFT OUTER JOIN installedversion AS iv
        ON (v.domain=iv.domain AND v.location=iv.location AND v.codelist=iv.codelist)
        WHERE v.domain=? AND ((iv.installedversion IS NULL) OR (v.version != iv.installedversion))""";
  }

  public static String getCaseSubtypesFor() {
    return """
        SELECT code, name
        FROM casesubtype WHERE domain=? AND location=? AND casetypeid=?""";
  }

  public static String getProcedureOrRemedy() {
    return "SELECT name, code FROM procedureremedy WHERE domain=? AND location=? AND casecategory=?";
  }

  public static String getMotionTypes() {
    return "SELECT name, code FROM motiontype WHERE domain=? AND location=? AND filingcodeid=?";
  }

  public static String getSpecificStatesForCountryForLoc() {
    return "SELECT code, name, countrycode, location "
        + " FROM state WHERE domain=? AND location=? and countrycode=?";
  }

  public static String getFilingStatuses() {
    return "SELECT name, code FROM filingstatus WHERE domain=? AND location=?";
  }

  public static String getLanguages() {
    return "SELECT code, name, efspcode, location FROM language WHERE domain=? AND location=?";
  }

  public static String getDamageAmount() {
    return "SELECT code, name, efspcode, location FROM damageamount WHERE domain=? AND location=? AND casecategory=?";
  }

  public static String getNameSuffixes() {
    return "SELECT name, code FROM namesuffix WHERE domain=? AND location=?";
  }

  public static String vacuumAnalyzeAll() {
    return "VACUUM ANALYZE";
  }

  public static boolean tableHasLocation(String tableName) {
    return tableColumns.containsKey(tableName) && tableColumns.get(tableName).needsExtraLocCol;
  }

  public static String getCreateTable(String tableName) {
    if (createQueries.containsKey(tableName)) {
      return createQueries.get(tableName);
    }
    return "";
  }

  public static List<String> getCreateIndex(String tableName) {
    if (!tableIndices.containsKey(tableName)) {
      return List.of();
    }
    return tableIndices.get(tableName);
  }
  
  public static String getInsertInto(String tableName) {
    if (!insertQueries.containsKey(tableName)) {
      return "";
    }
    return insertQueries.get(tableName);
  }
  
  public static String getDeleteFrom(String tableName) {
    if (!deleteFromQueries.containsKey(tableName)) {
      return "";
    }
    return deleteFromQueries.get(tableName);
  }

  public static String getDeleteAllCourtsFrom(String tableName) {
    if (!deleteAllCourtsFromQueries.containsKey(tableName)) {
      return "";
    }
    return deleteAllCourtsFromQueries.get(tableName);
  }

  /**
   * Returns an INSERT statement for the given table + court. The statement
   * includes a ON CONFLICT (all columns...) DO NOTHING clause.
   *
   * @param tableName The name of the DB table (i.e. code list) to insert into
   * @param courtName The Court Location ID to add codes for
   */
  private static String createInsertQuery(String tableName, TableColumns tc) {
    StringBuilder insertLocation = new StringBuilder();
    insertLocation.append("INSERT INTO \"" + tableName + "\" (");
    StringBuilder colNames = new StringBuilder();
    boolean isFirst = true;
    for (Pair<String, String> col : tc.mainList) {
      if (isFirst) {
        isFirst = false;
      } else {
        colNames.append(", ");
      }
      colNames.append("\"" + col.getLeft() + "\"");
    }
    if (tc.needsExtraLocCol) {
      colNames.append(", location");
    }
    colNames.append(", domain");
    insertLocation.append(colNames.toString());
    insertLocation.append(") VALUES (");
    for (int i = 0; i < tc.mainList.size(); i++) {
      if (i > 0) {
        insertLocation.append(", ");
      }
      insertLocation.append("?");
    }
    if (tc.needsExtraLocCol) {
      insertLocation.append(", ?"); 
    }
    insertLocation.append(", ?");
    insertLocation.append(")");
    return insertLocation.toString();
  }

  private static String createTableQuery(String tableName, TableColumns tc) {
    StringBuilder createLocation = new StringBuilder();
    createLocation.append("CREATE TABLE " + tableName + "(");
    boolean isFirst = true;
    for (Pair<String, String> col : tc.mainList) {
      if (isFirst) {
        isFirst = false;
      } else {
        createLocation.append(", ");
      }
      createLocation.append("\"" + col.getLeft() + "\" " + col.getRight());
    }
    if (tc.needsExtraLocCol) {
      createLocation.append(", \"location\" varchar(80)");
    }
    createLocation.append(", \"domain\" varchar(80)");

    if (!tc.primaryKeys.isEmpty()) {
      createLocation.append(
          ", PRIMARY KEY(" + tc.primaryKeys.stream().collect(Collectors.joining(",")) + ")");
    }
    createLocation.append(")");
    return createLocation.toString();
  }
}
