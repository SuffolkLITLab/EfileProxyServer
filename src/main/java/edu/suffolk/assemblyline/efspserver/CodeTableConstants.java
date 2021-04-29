package edu.suffolk.assemblyline.efspserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class CodeTableConstants {
  private static final Map<String, List<Pair<String, String>>> systemTableColumns = 
      new HashMap<String, List<Pair<String, String>>>();
  private static final Map<String, List<Pair<String, String>>> bothTableColumns = 
      new HashMap<String, List<Pair<String, String>>>();
  private static final Map<String, List<Pair<String, String>>> courtTableColumns = 
      new HashMap<String, List<Pair<String, String>>>();

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
        new ImmutablePair<String, String>("version", "text")));

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

    bothTableColumns.put("datafield", List.of(new ImmutablePair<String, String>("code", "text"),
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

    courtTableColumns.put("optionalservice",
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
        new ImmutablePair<String, String>("disclaimertext", "text"),
        new ImmutablePair<String, String>("efspcode", "text")));
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

  private class TableColumns {
    public List<Pair<String, String>> mainList;
    public boolean needsExtraLocCol = false;
  }

  private static Optional<TableColumns> getTableColumnInfo(String tableName) {
    CodeTableConstants ctc = new CodeTableConstants();
    TableColumns tableCols = ctc.new TableColumns();
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
    return Optional.of(tableCols);
  }
  
  public static Optional<List<String>> getTableColumns(String tableName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    return tableCols.map(
        // Convert the list of column name + types to a list of just column names
        (tc) -> tc.mainList.stream().map((e) -> e.getLeft()).collect(Collectors.toList()));
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
    createLocation.append(")");
    return createLocation.toString();
  }

  public static String getInsertInto(String tableName, String courtName) {
    Optional<TableColumns> tableCols = getTableColumnInfo(tableName);
    if (tableCols.isEmpty()) {
      return "";
    }
    if (tableCols.get().needsExtraLocCol && courtName.isEmpty()) {
      System.err.println("court name can't be empty");
      return "";
    }
    StringBuilder insertLocation = new StringBuilder();
    insertLocation.append("INSERT INTO \"" + tableName + "\" (");
    boolean isFirst = true;
    for (Pair<String, String> col : tableCols.get().mainList) {
      if (isFirst) {
        isFirst = false;
      } else {
        insertLocation.append(", ");
      }
      insertLocation.append("\"" + col.getLeft() + "\"");
    }
    if (tableCols.get().needsExtraLocCol) {
      insertLocation.append(", location");
    }
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
