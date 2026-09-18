package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public record CourtLocationInfo(
    String code,

    /**
     * The full (more) human readable name for the court. Some examples: adams -> Adams County, and
     * cook:chd -> Cook County - Chancery
     */
    String name,

    /** True if the court allows filing to new cases. */
    boolean initial,

    /** True if the court allows filing to existing cases. */
    boolean subsequent,
    boolean disallowcopyingenvelopemultipletimes,
    boolean allowfilingintononindexedcase,
    List<String> allowablecardtypes,

    /**
     * From Reference Guide: "The Odyssey NodeID for a court location that is integrated with
     * Tyler's Odyssey Case Manager" Not really used, since we aren't integrating.
     */
    String odysseynodeid,

    /**
     * A UID for each instance of the CMS. From the Reference Guide: "This is only relevant to court
     * agencies who use the EFM as well as Odyssey Case Manager APIs. This information allows such
     * agencies to use the OdysseyNodeID field in an EFM instance that integrates to multiple
     * Odyssey installations." Not used in this software.
     */
    String cmsid,
    String sendservicebeforereview,

    /**
     * The "parent court location" of the current court, e.g. cook is parent of cook:chd. TODO(#53):
     * figure out if this needs to be fallen back on if certain codes don't exist.
     */
    String parentnodeid,

    /**
     * True if this location is actually a county, as opposed to a specific office / division. Not
     * used yet. NOTE(brycew): doesn't make sense, several counties in IL have False in this entry.
     */
    boolean iscounty,
    String restrictbankaccountpayment,
    boolean allowmultipleattorneys,

    /**
     * True if a service contact will be emailed if they are detached from a case at this court.
     * NOTE(brycew): shouldn't have to do anything with this: only relevant to
     * OasisEcfWsCallback.notifyEvent, but just to whether certain events can happen.
     */
    boolean sendservicecontactremovednotifications,

    /**
     * True if this court allows the filer to specify a maximum fee amount to which the reviewer can
     * adjust filing sduring review.
     */
    boolean allowmaxfeeamount,

    /**
     * If false, the EFM will require a Party Responsible for Fees when a waiver is used at this
     * location.
     */
    boolean transferwaivedfeestocms,

    /**
     * If false and paying by credit card, courts will "Authorize" the card to determine if
     * sufficient credit exists on the credit card. TODO(brycew-later): should be something we
     * notify users of, but IDK if we need to do anything different with this setting?
     */
    boolean skippreauth,
    boolean allowreturndate,
    boolean showdamageamount,
    boolean hasconditionalservicetypes,

    /** True if the court requires the EFSP to mask the case category and type for some types. */
    boolean hasprotectedcasetypes,

    /** The list of case type codes that are required to be masked. */
    List<String> protectedcasetypes,

    /** The string that you have to use to replace the case category/type if it's protected. */
    String protectedcasereplacementstring,
    boolean allowzerofeeswithoutfilingparty,
    // if default, check DataField FilingServiceCheckBoxInitial
    BoolOrDefault allowserviceoninitial,
    boolean allowaddservicecontactsoninitial,

    /** True if the court allows redaction of documents. See TODO(#39) */
    boolean allowredaction,

    /** The URL for interacting with the redaction service via HTTP (?) See TODO(#39) */
    String redactionurl,

    /** The URL for launching the redaction viewer/editor. See TODO(#39). */
    String redactionviewerurl,

    /** True if "Forced redaction" is enabled at this court. See TODO(#39). */
    boolean enforceredaction,

    /* A document type code to indicate the document type to be include for redacted documents
     * at this court. See TODO(#39). */
    String redactiondocumenttype,

    /**
     * Location specific override for the Data Field Config "DocumentDescription" if 1, sets the
     * default value to be the filing code description (comparable to FilingCode) if 2, sets the
     * default value to be the name of the uploaded file (comparable to FileName) if NULL, the field
     * will objy the Data Field Configuration
     */
    String defaultdocumentdescription,
    boolean allowwaiveronmail,

    /** TODO(#38) for follow up to this code. */
    boolean showreturnonreject,
    boolean allowchargeupdate,
    boolean allowpartyid,

    /** The redaction fee for this location. See TODO(#39). */
    String redactionfee,

    /** True if redaction fees will be waived. See TODO(#39). */
    boolean allowwaiveronredaction,
    boolean disallowelectronicserviceonnewcontacts,

    /**
     * If false, Individual users aren't allowed to register accounts. NOTE(brycew): assuming this
     * is only present in the System (0) location, because it doesn't make sense as a per court
     * thing.
     */
    boolean allowindividualregistration,

    /**
     * A comma delimeted list of elements to be redacted. Possible values are: AccountNumber,
     * CreditCard, DriversLicense, GovernmentID, Passport, SocialSecurityNumber, TaxDocument. See
     * TODO(#39)
     */
    List<String> redactiontargetconfig,
    boolean allowhearing,
    String efmType) {

  public static enum BoolOrDefault {
    TRUE,
    FALSE,
    DEFAULT
  }

  private static BoolOrDefault boolOrDefault(String val) {
    if (val == null || val.isBlank()) {
      return BoolOrDefault.DEFAULT;
    } else {
      if (Boolean.parseBoolean(val)) {
        return BoolOrDefault.TRUE;
      } else {
        return BoolOrDefault.FALSE;
      }
    }
  }

  private static List<String> commaSep(String val) {
    if (val == null || val.isBlank()) {
      return List.of();
    } else {
      return List.of(val.split(","));
    }
  }

  public CourtLocationInfo(String code, boolean initial, boolean subsequent) {
    this(
        code,
        "Court with code " + code,
        initial,
        subsequent,
        false,
        false,
        List.of(),
        "",
        "",
        "",
        "",
        false,
        "",
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        List.of(),
        "",
        false,
        BoolOrDefault.DEFAULT,
        false,
        false,
        "",
        "",
        false,
        "",
        "",
        false,
        false,
        false,
        false,
        "",
        false,
        false,
        false,
        List.of(),
        false,
        "ecf");
  }

  // For testing
  public CourtLocationInfo(
      String code, boolean initial, boolean subsequent, BoolOrDefault allowserviceoninitial) {
    this(
        code,
        code,
        initial,
        subsequent,
        false,
        false,
        List.of(),
        "",
        "",
        "",
        "",
        false,
        "",
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        List.of(),
        "",
        false,
        allowserviceoninitial,
        false,
        false,
        "",
        "",
        false,
        "",
        "",
        false,
        false,
        false,
        false,
        "",
        false,
        false,
        false,
        List.of(),
        false,
        "ecf");
  }

  public CourtLocationInfo(
      String code,
      boolean allowmultipleattorneys,
      boolean allowindividualregistration,
      boolean showreturnonreject) {
    this(
        code,
        code,
        false,
        false,
        false,
        false,
        List.of(),
        "",
        "",
        "",
        "",
        false,
        "",
        allowmultipleattorneys,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        List.of(),
        "",
        false,
        BoolOrDefault.DEFAULT,
        false,
        false,
        "",
        "",
        false,
        "",
        "",
        false,
        showreturnonreject,
        false,
        false,
        "",
        false,
        false,
        allowindividualregistration,
        List.of(),
        false,
        "ecf");
  }

  public CourtLocationInfo(ResultSet rs) throws SQLException {
    this(
        rs.getString(1),
        rs.getString(2),
        Boolean.parseBoolean(rs.getString(3)),
        Boolean.parseBoolean(rs.getString(4)),
        Boolean.parseBoolean(rs.getString(5)),
        Boolean.parseBoolean(rs.getString(6)),
        commaSep(rs.getString(7)),
        rs.getString(8),
        rs.getString(9),
        rs.getString(10),
        rs.getString(11),
        Boolean.parseBoolean(rs.getString(12)),
        rs.getString(13),
        Boolean.parseBoolean(rs.getString(14)),
        Boolean.parseBoolean(rs.getString(15)),
        Boolean.parseBoolean(rs.getString(16)),
        Boolean.parseBoolean(rs.getString(17)),
        Boolean.parseBoolean(rs.getString(18)),
        Boolean.parseBoolean(rs.getString(19)),
        Boolean.parseBoolean(rs.getString(20)),
        Boolean.parseBoolean(rs.getString(21)),
        Boolean.parseBoolean(rs.getString(22)),
        (Boolean.parseBoolean(rs.getString(22))) ? List.of(rs.getString(23).split(",")) : List.of(),
        rs.getString(35),
        Boolean.parseBoolean(rs.getString(24)),
        boolOrDefault(rs.getString(25)),
        Boolean.parseBoolean(rs.getString(26)),
        Boolean.parseBoolean(rs.getString(27)),
        rs.getString(28),
        rs.getString(29),
        Boolean.parseBoolean(rs.getString(30)),
        rs.getString(31),
        rs.getString(32),
        Boolean.parseBoolean(rs.getString(33)),
        /**
         * TODO(#38): need to check for all instances of "reject", and possibly change to "return".
         */
        Boolean.parseBoolean(rs.getString(34)),
        Boolean.parseBoolean(rs.getString(36)),
        Boolean.parseBoolean(rs.getString(37)),
        rs.getString(38),
        Boolean.parseBoolean(rs.getString(39)),
        Boolean.parseBoolean(rs.getString(40)),
        Boolean.parseBoolean(rs.getString(41)),
        commaSep(rs.getString(42)),
        Boolean.parseBoolean(rs.getString(43)),
        "ecf");
  }

  public static String parentQuery() {
    return """
    SELECT code, parentnodeid
    FROM location
    WHERE jurisdiction=? AND code=?
    """;
  }

  public static String fullSingleQuery() {
    return """
    SELECT code, name, initial, subsequent, disallowcopyingenvelopemultipletimes,
        allowfilingintononindexedcase,
        allowablecardtypes, odysseynodeid, cmsid, sendservicebeforereview, parentnodeid,
        iscounty, restrictbankaccountpayment, allowmultipleattorneys, sendservicecontactremovednotifications,
        allowmaxfeeamount, transferwaivedfeestocms, skippreauth, allowreturndate, showdamageamount,
        hasconditionalservicetypes,
        hasprotectedcasetypes, protectedcasetypes, allowzerofeeswithoutfilingparty,
        allowserviceoninitial, allowaddservicecontactsoninitial,
        allowredaction, redactionurl, redactionviewerurl, enforceredaction,
        redactiondocumenttype, defaultdocumentdescription, allowwaiveronmail, showreturnonreject,
        protectedcasereplacementstring, allowchargeupdate, allowpartyid, redactionfee,
        allowwaiveronredaction, disallowelectronicserviceonnewcontacts,
        allowindividualregistration, redactiontargetconfig, allowhearing
    FROM location
    WHERE jurisdiction=? AND code=?
    """;
  }

  public static String allOrderedQuery() {
    return "SELECT DISTINCT code FROM location WHERE jurisdiction=? ORDER BY code";
  }

  public static String allNames() {
    return "SELECT name, code FROM location WHERE jurisdiction=? ORDER BY code";
  }

  public static String fileableQuery() {
    return """
    SELECT name, code
    FROM location
    WHERE jurisdiction=? AND (initial ILIKE 'true' OR subsequent ILIKE 'true')
    """;
  }

  public static String fileableInitialQuery() {
    return """
    SELECT name, code
    FROM location
    WHERE jurisdiction=? AND (initial ILIKE 'true')
    """;
  }

  public static String fileableSubsequentQuery() {
    return """
    SELECT name, code
    FROM location
    WHERE jurisdiction=? AND (subsequent ILIKE 'true')
    """;
  }
}
