package edu.suffolk.litlab.efspserver.codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeTableConstants {
  private static Logger log = 
      LoggerFactory.getLogger(CodeTableConstants.class); 

  private static final Map<String, List<Pair<String, String>>> systemTableColumns = 
      new HashMap<String, List<Pair<String, String>>>();
  private static final Map<String, List<Pair<String, String>>> bothTableColumns = 
      new HashMap<String, List<Pair<String, String>>>();
  private static final Map<String, List<Pair<String, String>>> courtTableColumns = 
      new HashMap<String, List<Pair<String, String>>>();
  
  private static final Map<String, List<String>> tablePrimaryKeys =
      new HashMap<String, List<String>>();

  // TODO(brycew): the types are confusing here: some are only ever ints, but
  // are coded as normalizedStrings in the XML. Unclear what to make ints in the
  // DB.
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
    locationColumns.add(new ImmutablePair<String, String>("showdamageamount", "text"));
    locationColumns.add(new ImmutablePair<String, String>("hasconditionalservicetypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("hasprotectedcasetypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("protectedcasetypes", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowzerofeeswithoutfilingparty", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowserviceoninitial", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowaddservicecontactsoninitial", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowredaction", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactionurl", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactionviewerurl", "text"));
    locationColumns.add(new ImmutablePair<String, String>("enforceredaction", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactiondocumenttype", "text"));
    locationColumns.add(new ImmutablePair<String, String>("defaultdocumentdescription", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowwaiveronmail", "text"));
    locationColumns.add(new ImmutablePair<String, String>("showreturnonreject", "text"));
    locationColumns.add(new ImmutablePair<String, String>("protectedcasereplacementstring", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowchargeupdate", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowpartyid", "text"));
    locationColumns.add(new ImmutablePair<String, String>("redactionfee", "text"));
    locationColumns.add(new ImmutablePair<String, String>("allowwaiveronredaction", "text"));
    systemTableColumns.put("location", locationColumns);

    systemTableColumns.put("error", List.of(
        new ImmutablePair<String, String>("code", "text"), 
        new ImmutablePair<String, String>("name", "text")));

    systemTableColumns.put("version", List.of(
        new ImmutablePair<String, String>("location", "text"),
        new ImmutablePair<String, String>("codelist", "text"), 
        new ImmutablePair<String, String>("version", "text")
    ));

    // custom table, the version that's currently installed
    // Custom table so we can just drop the existing version table when updating.
    systemTableColumns.put("installedversion", List.of(
        new ImmutablePair<String, String>("location", "text"),
        new ImmutablePair<String, String>("codelist", "text"), 
        new ImmutablePair<String, String>("installedversion", "text") 
    ));
    
    tablePrimaryKeys.put("installedversion", List.of("location", "codelist"));

    //////////// Tables that are both system wide, and court specific

    bothTableColumns.put("country", List.of(
        new ImmutablePair<String, String>("code", "text"), 
        new ImmutablePair<String, String>("name", "text")));

    bothTableColumns.put("state", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("countrycode", "text")));

    bothTableColumns.put("filingstatus",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text")));

    bothTableColumns.put("datafieldconfig", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("isvisible", "text"),
        new ImmutablePair<String, String>("isrequired", "text"), 
        new ImmutablePair<String, String>("helptext", "text"),
        new ImmutablePair<String, String>("ghosttext", "text"),
        new ImmutablePair<String, String>("contextualhelpdata", "text"),
        new ImmutablePair<String, String>("validationmessage", "text"),
        new ImmutablePair<String, String>("regularexpression", "text"),
        new ImmutablePair<String, String>("defaultvalueexpression", "text"),
        new ImmutablePair<String, String>("isreadonly", "text")));

    ///////// Tables for courts specifically
    courtTableColumns.put("answer",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("answertext", "text"),
            new ImmutablePair<String, String>("questionid", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("arrestlocation", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("bond", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("casecategory",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("ecfcasetype", "text"),
            new ImmutablePair<String, String>("procedureremedyinitial", "text"),
            new ImmutablePair<String, String>("procedureremedysubsequent", "text"),
            new ImmutablePair<String, String>("damageamountinitial", "text"),
            new ImmutablePair<String, String>("damageamountsubsequent", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("casesubtype",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("casetypeid", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("casetype",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("casecategory", "text"),
            new ImmutablePair<String, String>("initial", "text"),
            new ImmutablePair<String, String>("fee", "text"),
            new ImmutablePair<String, String>("willfileddate", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("casetype",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("casecategory", "text"),
            new ImmutablePair<String, String>("initial", "text"),
            new ImmutablePair<String, String>("fee", "text"),
            new ImmutablePair<String, String>("willfileddate", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("chargephase", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("citationjurisdiction", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("crossreference", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("casetypeid", "text"),
        new ImmutablePair<String, String>("isdefault", "text"),
        new ImmutablePair<String, String>("isrequired", "text"),
        new ImmutablePair<String, String>("validationregex", "text"),
        new ImmutablePair<String, String>("customvalidationfailuremessage", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("damageamount",
        List.of(new ImmutablePair<String, String>("code", "text"),
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("casecategory", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("degree",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("statuecodeid", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("disclaimerrequirement",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("listorder", "text"),
            new ImmutablePair<String, String>("requirementtext", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));
    
    courtTableColumns.put("driverlicensetype", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("efspcode", "text")
    )); 

    courtTableColumns.put("documenttype", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("filingcodeid", "text"),
        new ImmutablePair<String, String>("iscourtuseonly", "text"),
        new ImmutablePair<String, String>("isdefault", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("ethnicity", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("eyecolor", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("filertype",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("default", "text"), 
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("filetype",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("extension", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("filing",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("fee", "text"), 
            new ImmutablePair<String, String>("casecategory", "text"),
            new ImmutablePair<String, String>("casetypeid", "text"),
            new ImmutablePair<String, String>("filingtype", "text"),
            new ImmutablePair<String, String>("iscourtuseonly", "text"),
            new ImmutablePair<String, String>("civilclaimamount", "text"),
            new ImmutablePair<String, String>("probateestateamount", "text"),
            new ImmutablePair<String, String>("amountincontroversy", "text"),
            new ImmutablePair<String, String>("useduedate", "text"),
            new ImmutablePair<String, String>("isproposedorder", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("filingcomponent",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("filingcodeid", "text"),
            new ImmutablePair<String, String>("required", "text"),
            new ImmutablePair<String, String>("allowmultiple", "text"),
            new ImmutablePair<String, String>("displayorder", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("generaloffense",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("statutecodeid", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("haircolor", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("haircolor", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("language", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("lawenforcementunit", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("motiontype",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("filingcodeid", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("namesuffix", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("optionalservices",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("displayorder", "text"), 
            new ImmutablePair<String, String>("fee", "text"),
            new ImmutablePair<String, String>("filingcodeid", "text"),
            new ImmutablePair<String, String>("multiplier", "text"),
            new ImmutablePair<String, String>("altfeedesc", "text"),
            new ImmutablePair<String, String>("hasfeeprompt", "text"),
            new ImmutablePair<String, String>("feeprompttext", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("partytype",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("isavailablefornewparties", "text"),
            new ImmutablePair<String, String>("casetypeid", "text"),
            new ImmutablePair<String, String>("isrequired", "text"),
            new ImmutablePair<String, String>("amount", "text"),
            new ImmutablePair<String, String>("numberofpartiestoignore", "text"),
            new ImmutablePair<String, String>("sendforredaction", "text"),
            new ImmutablePair<String, String>("dateofdeath", "text"),
            new ImmutablePair<String, String>("displayorder", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("physicalfeature", List.of(
        new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));

    courtTableColumns.put("procedureremedy",
        List.of(new ImmutablePair<String, String>("code", "text"), 
            new ImmutablePair<String, String>("name", "text"),
            new ImmutablePair<String, String>("casecategory", "text"),
            new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("question", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("questiontext", "text"),
        new ImmutablePair<String, String>("helptext", "text"), 
        new ImmutablePair<String, String>("isrequired", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("race", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("servicetype", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("servicemethod", "text"),
        new ImmutablePair<String, String>("fee", "text"), 
        new ImmutablePair<String, String>("disclaimertext", "text")));
    courtTableColumns.put("statute", List.of(new ImmutablePair<String, String>("code", "text"), 
        new ImmutablePair<String, String>("name", "text"),
        new ImmutablePair<String, String>("word", "text"), 
        new ImmutablePair<String, String>("referenceid", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("statutetype", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("vehiclecolor", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("vehiclemake", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));
    courtTableColumns.put("vehicletype", List.of(new ImmutablePair<String, String>("code", "text"),
        new ImmutablePair<String, String>("name", "text"), 
        new ImmutablePair<String, String>("efspcode", "text")));
  }

  private static class TableColumns {
    public List<Pair<String, String>> mainList;
    public List<String> primaryKeys;
    public boolean needsExtraLocCol = false;
  }

  private static Optional<TableColumns> getTableColumnInfo(String tableName) {
    TableColumns tableCols = new TableColumns();
    if (systemTableColumns.containsKey(tableName)) {
      tableCols.mainList = systemTableColumns.get(tableName);
    } else {
      tableCols.needsExtraLocCol = true;
      if (bothTableColumns.containsKey(tableName)) {
        tableCols.mainList = bothTableColumns.get(tableName);
      } else if (courtTableColumns.containsKey(tableName)) {
        tableCols.mainList = courtTableColumns.get(tableName);
      } else {
        return Optional.empty();
      }
    }
    if (tablePrimaryKeys.containsKey(tableName)) {
      tableCols.primaryKeys = tablePrimaryKeys.get(tableName);
    } else {
      tableCols.primaryKeys = List.of();
    }
    return Optional.of(tableCols);
  }
  
  public static Optional<List<String>> getTableColumns(String tableName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    return tableCols.map(
        // Drops the type in the column name + type pairs. 
        (tc) -> tc.mainList.stream().map((e) -> e.getLeft()).collect(Collectors.toList()));
  }

  public static String getTableExists() {
    return """ 
        SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public'
        AND table_name = ? LIMIT 1;""";
  }
  
  public static String updateVersion() {
    return """
        INSERT INTO installedversion (location, codelist, installedversion) VALUES(?, ?, ?)
        ON CONFLICT (location, codelist) DO UPDATE SET installedversion=?"""; 
  }
  
  public static String needToUpdateVersion() {
    return """
        SELECT v.location, v.codelist, iv.installedversion, v.version
        FROM version AS v LEFT OUTER JOIN installedversion AS iv
        ON (v.location=iv.location AND v.codelist=iv.codelist)
        WHERE (iv.installedversion IS NULL) OR (v.version != iv.installedversion)""";
  }
  
  public static String getCaseSubtypesFor() {
    return "SELECT code, name "
        + "FROM casesubtype WHERE location=? AND casetypeid=?";
  }

  
  
  /** Gets all columns from datafieldconfig table
   * Need to provide the location (1) and the code (2) of the field.
   * For example, 'adams' and 'FilingEventCaseParties'
   *
   * @return the String to make a SQL PreparedStatement from
   */
  public static String getAllFromDataFieldConfigForLoc() {
    return "SELECT code, name, isvisible, isrequired, helptext, ghosttext, contextualhelpdata, "
        + "validationmessage, regularexpression, defaultvalueexpression, isreadonly, location "
        + "FROM datafieldconfig WHERE location=? AND code=?";
  }
  
  public static String getProcedureOrRemedy() {
    return "SELECT name, code FROM procedureremedy WHERE location=? AND casecategory=?";
  }

  public static String getMotionTypes() {
    return "SELECT name, code FROM motiontypes WHERE location=? AND filingcodeid=?";
  }

  public static String getSpecificStatesForCountryForLoc() {
    return "SELECT code, name, countrycode, location "
        + " FROM state WHERE location=? and countrycode=?";
  }
  
  public static String getLanguages() {
    return "SELECT code, name, efspcode, location FROM languages WHERE location=?";
  }

  public static String getDamageAmount() {
    return "SELECT code, name, efspcode, location FROM damageamount WHERE location=? AND casecategory=?";
  }
  
  /** Will only delete from non-system tables. */
  public static String deleteFromTable(String tableName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    if (tableCols.isEmpty() || !tableCols.get().needsExtraLocCol) {
      return "";
    }
    return "DELETE FROM " + tableName + " WHERE location=?";
  }
  
  /** Gets the statement that will drop the specified table, but only if it pre-specified. */
  public static String dropTable(String tableName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    if (tableCols.isEmpty()) {
      return "";
    }
    return "DROP TABLE IF EXISTS " + tableName;
  }

  public static String getCreateTable(String tableName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    if (tableCols.isEmpty()) {
      return "";
    }
    StringBuilder createLocation = new StringBuilder();
    createLocation.append("CREATE TABLE " + tableName + "(");
    boolean isFirst = true;
    for (Pair<String, String> col : tableCols.get().mainList) {
      if (isFirst) {
        isFirst = false;
      } else {
        createLocation.append(", ");
      }
      createLocation.append("\"" + col.getLeft() + "\" " + col.getRight());
    }
    if (tableCols.get().needsExtraLocCol) {
      createLocation.append(", \"location\" text");
    }
    if (!tableCols.get().primaryKeys.isEmpty()) {
      createLocation.append(", PRIMARY KEY(" 
          + tableCols.get().primaryKeys.stream().collect(Collectors.joining(",")) 
          + ")");
    }
    createLocation.append(")");
    return createLocation.toString();
  }

  /**
   * Returns an INSERT statement for the given table + court.
   * The statement includes a ON CONFLICT (all columns...) DO NOTHING clause.
   *
   * @param tableName The name of the DB table (i.e. code list) to insert into
   * @param courtName The Court Location ID to add codes for
   */
  public static String getInsertInto(String tableName, String courtName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    if (tableCols.isEmpty()) {
      return "";
    }
    if (tableCols.get().needsExtraLocCol && courtName.isEmpty()) {
      log.warn("court name can't be empty");
      return "";
    }
    StringBuilder insertLocation = new StringBuilder();
    insertLocation.append("INSERT INTO \"" + tableName + "\" (");
    StringBuilder colNames = new StringBuilder();
    boolean isFirst = true;
    for (Pair<String, String> col : tableCols.get().mainList) {
      if (isFirst) {
        isFirst = false;
      } else {
        colNames.append(", ");
      }
      colNames.append("\"" + col.getLeft() + "\"");
    }
    if (tableCols.get().needsExtraLocCol) {
      colNames.append(", location");
    }
    insertLocation.append(colNames.toString());
    insertLocation.append(") VALUES (");
    for (int i = 0; i < tableCols.get().mainList.size(); i++) {
      if (i > 0) {
        insertLocation.append(", ");
      }
      insertLocation.append("?");
    }
    if (tableCols.get().needsExtraLocCol) {
      insertLocation.append(", '" + courtName + "'");
    }
    insertLocation.append(")");
    return insertLocation.toString();
  }

}
