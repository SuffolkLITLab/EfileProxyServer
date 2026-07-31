package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import static edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.createInsertQuery;
import static edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.createTableQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.Column;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.TableColumns;
import edu.suffolk.litlab.efsp.ecfcodes.CodeDatabaseUtils.UnsupportedTableException;

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
    List<Column> locationColumns = new ArrayList<Column>();
    locationColumns.add(new Column("code", "text"));
    locationColumns.add(new Column("name", "text"));
    locationColumns.add(new Column("initial", "text"));
    locationColumns.add(new Column("subsequent", "text"));
    locationColumns.add(new Column("disallowcopyingenvelopemultipletimes", "text"));
    locationColumns.add(new Column("allowfilingintononindexedcase", "text"));
    locationColumns.add(new Column("allowablecardtypes", "text"));
    locationColumns.add(new Column("odysseynodeid", "text"));
    locationColumns.add(new Column("cmsid", "text"));
    locationColumns.add(new Column("sendservicebeforereview", "text"));
    locationColumns.add(new Column("parentnodeid", "text"));
    locationColumns.add(new Column("iscounty", "text"));
    locationColumns.add(new Column("restrictbankaccountpayment", "text"));
    locationColumns.add(new Column("allowmultipleattorneys", "text"));
    locationColumns.add(new Column("sendservicecontactremovednotifications", "text"));
    locationColumns.add(new Column("allowmaxfeeamount", "text"));
    locationColumns.add(new Column("transferwaivedfeestocms", "text"));
    locationColumns.add(new Column("skippreauth", "text"));
    locationColumns.add(new Column("allowhearing", "text")); 
    locationColumns.add(new Column("allowreturndate", "text")); 
    locationColumns.add(new Column("showdamageamount", "text")); // Isn't in document anymore?
    locationColumns.add(new Column("hasconditionalservicetypes", "text"));
    locationColumns.add(new Column("hasprotectedcasetypes", "text"));
    locationColumns.add(new Column("protectedcasetypes", "text"));
    locationColumns.add(new Column("allowzerofeeswithoutfilingparty", "text"));
    locationColumns.add(new Column("allowserviceoninitial", "text"));
    locationColumns.add(new Column("allowaddservicecontactsoninitial", "text"));
    locationColumns.add(new Column("allowredaction", "text"));
    locationColumns.add(new Column("redactionurl", "text"));
    locationColumns.add(new Column("redactionviewerurl", "text"));
    locationColumns.add(new Column("redactiontargetconfig", "text"));
    locationColumns.add(new Column("enforceredaction", "text"));
    locationColumns.add(new Column("redactiondocumenttype", "text"));
    locationColumns.add(new Column("defaultdocumentdescription", "text"));
    locationColumns.add(new Column("allowwaiveronmail", "text"));
    locationColumns.add(new Column("showreturnonreject", "text"));
    locationColumns.add(new Column("protectedcasereplacementstring", "text"));
    locationColumns.add(new Column("allowchargeupdate", "text")); // Isn't in document anymore?
    locationColumns.add(new Column("allowpartyid", "text")); // Isn't in documentation anymore?
    locationColumns.add(new Column("redactionfee", "text"));
    locationColumns.add(new Column("allowwaiveronredaction", "text"));
    locationColumns.add(new Column("disallowelectronicserviceonnewcontacts", "text"));
    locationColumns.add(new Column("allowindividualregistration", "text"));
    TableColumns locationTc = makeTableColumnInfo(false, locationColumns);
    tableColumns = Map.ofEntries(
        Map.entry("location", locationTc),
        Map.entry("error", makeSystemColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text")))),
        Map.entry("version", makeSystemColumnInfo(List.of(
          new Column("location", "text"),
          new Column("codelist", "text"), 
          new Column("version", "text")))),
        // custom table, the version that's currently installed
        // Custom table so we can just drop the existing version table when updating.
        Map.entry("installedversion", makeTableColumnInfo(false, List.of(
          new Column("location", "text"),
          new Column("codelist", "text"), 
          new Column("installedversion", "text")),
          List.of("location", "codelist", "jurisdiction"))),
        //////////// Tables that are both system wide, and court specific
        Map.entry("country", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text")))),
        Map.entry("state", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("countrycode", "text")))),
        Map.entry("filingstatus", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text")))),
        Map.entry("datafieldconfig", makeCourtColumnInfo(List.of(
          new Column("code", "varchar(80)"),
          new Column("name", "text"), 
          new Column("isvisible", "boolean"),
          new Column("isrequired", "boolean"), 
          new Column("helptext", "text"),
          new Column("ghosttext", "text"),
          new Column("contextualhelpdata", "text"),
          new Column("validationmessage", "text"),
          new Column("regularexpression", "text"),
          new Column("defaultvalueexpression", "text"),
          new Column("isreadonly", "boolean")))),
        ///////// Tables for courts specifically
        Map.entry("answer", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("answertext", "text"),
          new Column("questionid", "text"),
          new Column("efspcode", "text")))),
        Map.entry("arrestlocation", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text")))),
        Map.entry("bond", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text")))),
        Map.entry("casecategory", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("ecfcasetype", "text"),
          new Column("procedureremedyinitial", "text"),
          new Column("procedureremedysubsequent", "text"),
          new Column("damageamountinitial", "text"),
          new Column("damageamountsubsequent", "text"),
          new Column("efspcode", "text")))),
        Map.entry("casesubtype", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("casetypeid", "text"),
          new Column("efspcode", "text")))),
        Map.entry("casetype", makeCourtColumnInfo(List.of(
          new Column("code", "varchar(40)"),
          new Column("name", "text"),
          new Column("casecategory", "text"),
          new Column("initial", "text"),
          new Column("fee", "text"),
          new Column("willfileddate", "text"),
          new Column("efspcode", "text")))),
        Map.entry("chargephase", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text")))),
        Map.entry("citationjurisdiction", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text")))),
        Map.entry("crossreference", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("casetypeid", "text"),
          new Column("isdefault", "text"),
          new Column("isrequired", "text"),
          new Column("validationregex", "text"),
          new Column("customvalidationfailuremessage", "text"),
          new Column("efspcode", "text")))),
        Map.entry("damageamount", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("casecategory", "text"),
          new Column("efspcode", "text")))),
        Map.entry("degree", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("statuecodeid", "text"),
          new Column("efspcode", "text")))),
        Map.entry("disclaimerrequirement", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("listorder", "text"),
          new Column("requirementtext", "text"),
          new Column("efspcode", "text")))),
        Map.entry("driverlicensetype", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text")))),
        Map.entry("documenttype", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("filingcodeid", "text"),
          new Column("iscourtuseonly", "text"),
          new Column("isdefault", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("ethnicity", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("eyecolor", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("filertype", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("default", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("filetype", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("extension", "text"),
          new Column("efspcode", "text")))),
        Map.entry("filing", makeCourtColumnInfo(List.of(
          new Column("code", "varchar(40)"), 
          new Column("name", "text"),
          new Column("fee", "text"),
          new Column("casecategory", "text"),
          new Column("casetypeid", "text"),
          new Column("filingtype", "text"),
          new Column("iscourtuseonly", "boolean"),
          new Column("civilclaimamount", "text"),
          new Column("probateestateamount", "text"),
          new Column("amountincontroversy", "text"),
          new Column("useduedate", "boolean"),
          new Column("isproposedorder", "boolean"),
          new Column("efspcode", "text")))),
        Map.entry("filingcomponent", makeCourtColumnInfo(List.of(
          new Column("code", "varchar(40)"), 
          new Column("name", "text"),
          new Column("filingcodeid", "varchar(40)"),
          new Column("required", "boolean"),
          new Column("allowmultiple", "boolean"),
          new Column("displayorder", "integer"),
          new Column("efspcode", "text")))),
        Map.entry("generaloffense", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("statutecodeid", "text"),
          new Column("efspcode", "text")))),
        Map.entry("haircolor", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("language", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("lawenforcementunit", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("motiontype", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("filingcodeid", "text"),
          new Column("efspcode", "text")))),
        Map.entry("namesuffix", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("partytype", makeCourtColumnInfo(List.of(
          new Column("code", "varchar(40)"), 
          new Column("name", "text"),
          new Column("isavailablefornewparties", "boolean"),
          new Column("casetypeid", "text"),
          new Column("isrequired", "boolean"),
          new Column("amount", "text"),
          new Column("numberofpartiestoignore", "text"),
          new Column("sendforredaction", "text"),
          new Column("dateofdeath", "text"),
          new Column("displayorder", "text"),
          new Column("efspcode", "text")))),
        Map.entry("physicalfeature", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("procedureremedy",makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("casecategory", "text"),
          new Column("efspcode", "text")))),
        Map.entry("question", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("questiontext", "text"),
          new Column("helptext", "text"), 
          new Column("isrequired", "text"),
          new Column("efspcode", "text")))),
        Map.entry("race", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text")))),
        Map.entry("servicetype", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("servicemethod", "text"),
          new Column("fee", "text"), 
          new Column("disclaimertext", "text")))),
        Map.entry("statute", makeCourtColumnInfo(List.of(
          new Column("code", "text"), 
          new Column("name", "text"),
          new Column("word", "text"), 
          new Column("referenceid", "text"),
          new Column("efspcode", "text")))),
        Map.entry("statutetype", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("vehiclecolor", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("vehiclemake", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("vehicletype", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"), 
          new Column("efspcode", "text")))),
        Map.entry("refundreason", makeCourtColumnInfo(List.of(
          new Column("code", "text"),
          new Column("name", "text"),
          new Column("efspcode", "text"))))
    );
    for (Map.Entry<String, TableColumns> table : tableColumns.entrySet()) {
      createQueries.put(table.getKey(), createTableQuery(table.getKey(), table.getValue()));
      insertQueries.put(table.getKey(), createInsertQuery(table.getKey(), table.getValue()));
      deleteAllCourtsFromQueries.put(table.getKey(), "DELETE FROM " + table.getKey() + " WHERE jurisdiction=?");
      if (table.getValue().needsExtraLocCol()) {
        deleteFromQueries.put(table.getKey(), "DELETE FROM " + table.getKey() + " WHERE jurisdiction=? AND location=?");
      }
    }
    
    tableIndices.put("filing", List.of(
        "CREATE INDEX ON filing (location)",
        "CREATE INDEX ON filing (casecategory)",
        "CREATE INDEX ON filing (casetypeid)",
        "CREATE INDEX ON filing (jurisdiction)"));
    tableIndices.put("filingcomponent", List.of(
        "CREATE INDEX ON filingcomponent (location)", 
        "CREATE INDEX ON filingcomponent (filingcodeid)",
        "CREATE INDEX ON filingcomponent (jurisdiction)")); 
  }

  public static String getZipNameFromTable(String tableName) {
    if (tableName.equalsIgnoreCase("location")) {
      return "locations.zip";
    } else {
      return tableName + "codes.zip";
    }
  }

  private static TableColumns makeCourtColumnInfo(List<Column> mainList) {
    return makeTableColumnInfo(true, mainList, List.of());
  }

  private static TableColumns makeSystemColumnInfo(List<Column> mainList) {
    return makeTableColumnInfo(false, mainList, List.of());
  }

  private static TableColumns makeTableColumnInfo(boolean needsExtraLocCol,
      List<Column> mainList) {
    return makeTableColumnInfo(needsExtraLocCol, mainList, List.of());
  }

  private static TableColumns makeTableColumnInfo(boolean needsExtraLocCol,
      List<Column> mainList, List<String> primaryKeys) {
    TableColumns tableCols = new TableColumns(mainList, primaryKeys, needsExtraLocCol);
    return tableCols;
  }

  public static TableColumns getTableColumns(String tableName) {
    return tableColumns.getOrDefault(tableName, new TableColumns(List.of(), List.of(), false));
  }
  
  public static String updateVersion() {
    return """
        INSERT INTO installedversion (location, codelist, installedversion, jurisdiction) VALUES(?, ?, ?, ?)
        ON CONFLICT (jurisdiction, location, codelist) DO UPDATE SET installedversion=?""";
  }

  public static String needToUpdateVersion() {
    return """
        SELECT v.location, v.codelist, iv.installedversion, v.version
        FROM version AS v LEFT OUTER JOIN installedversion AS iv
        ON (v.jurisdiction=iv.jurisdiction AND v.location=iv.location AND v.codelist=iv.codelist)
        WHERE v.jurisdiction=? AND ((iv.installedversion IS NULL) OR (v.version != iv.installedversion))""";
  }

  public static String getCaseSubtypesFor() {
    return """
        SELECT code, name
        FROM casesubtype WHERE jurisdiction=? AND location=? AND casetypeid=?""";
  }

  public static String getProcedureOrRemedy() {
    return "SELECT name, code FROM procedureremedy WHERE jurisdiction=? AND location=? AND casecategory=?";
  }

  public static String getMotionTypes() {
    return "SELECT name, code FROM motiontype WHERE jurisdiction=? AND location=? AND filingcodeid=?";
  }

  public static String getSpecificStatesForCountryForLoc() {
    return "SELECT code, name, countrycode, location "
        + " FROM state WHERE jurisdiction=? AND location=? and countrycode=?";
  }

  public static String getFilingStatuses() {
    return "SELECT name, code FROM filingstatus WHERE jurisdiction=? AND location=?";
  }

  public static String getLanguages() {
    return "SELECT code, name, efspcode, location FROM language WHERE jurisdiction=? AND location=?";
  }

  public static String getDamageAmount() {
    return "SELECT code, name, efspcode, location FROM damageamount WHERE jurisdiction=? AND location=? AND casecategory=?";
  }

  public static String getNameSuffixes() {
    return "SELECT name, code FROM namesuffix WHERE jurisdiction=? AND location=?";
  }

  public static String vacuumAnalyzeAll() {
    return "VACUUM ANALYZE";
  }


  public static boolean tableHasLocation(String tableName) {
    return tableColumns.containsKey(tableName) && tableColumns.get(tableName).needsExtraLocCol();
  }

  public static String getCreateTable(String tableName) throws UnsupportedTableException {
    if (createQueries.containsKey(tableName)) {
      return createQueries.get(tableName);
    }
    throw new UnsupportedTableException("No create query for table " + tableName);
  }

  public static List<String> getCreateIndex(String tableName) {
    if (!tableIndices.containsKey(tableName)) {
      return List.of();
    }
    return tableIndices.get(tableName);
  }
  
  public static String getInsertInto(String tableName) throws UnsupportedTableException {
    if (!insertQueries.containsKey(tableName)) {
      throw new UnsupportedTableException("No insert query for table " + tableName);
    }
    return insertQueries.get(tableName);
  }
  
  public static String getDeleteFrom(String tableName) throws UnsupportedTableException {
    if (!deleteFromQueries.containsKey(tableName)) {
      throw new UnsupportedTableException("No 'delete from' query for table " + tableName);
    }
    return deleteFromQueries.get(tableName);
  }

  public static String getDeleteAllCourtsFrom(String tableName) throws UnsupportedTableException {
    if (!deleteAllCourtsFromQueries.containsKey(tableName)) {
      throw new UnsupportedTableException("No 'delete all courts from' query for table " + tableName);
    }
    return deleteAllCourtsFromQueries.get(tableName);
  }
}
