package edu.suffolk.litlab.efspserver.codes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourtLocationInfo {
  public String code;
  /** The full (more) human readable name for the court. 
   * Some examples: adams -> Adams County, and cook:chd -> Cook County - Chancery
   */
  public String name;
  /** True if the court allows filing to new cases. */
  public boolean initial;
  /** True if the court allows filing to existing cases. */
  public boolean subsequent;
  public boolean disallowcopyingenvelopemultipletimes;
  public boolean allowfilingintononindexedcase;
  public List<String> allowablecardtypes;
  /** From Reference Guide: 
   *   "The Odyssey NodeID for a court location that is integrated with Tyler's Odyssey Case Manager"
   * Not really used, since we aren't integrating.
   */
  public String odysseynodeid;
  /** A UID for each instance of the CMS. From the Reference Guide:
   *    "This is only relevant to court agencies who use the EFM as well as Odyssey Case Manager APIs. 
   *     This information allows such agencies to use the OdysseyNodeID field in an EFM instance 
   *     that integrates to multiple Odyssey installations."
   *  Not used in this software.
   */
  public String cmsid;
  
  public String sendservicebeforereview;
  /** The "parent court location" of the current court, e.g. cook is parent of cook:chd. 
   * TODO(brycew): figure out if this needs to be fallen back on if certain codes don't exist. */
  public String parentnodeid;
  /** True if this location is actually a county, as opposed to a specific office / division.
   * Not used yet.
   * NOTE(brycew): doesn't make sense, several counties in IL have False in this entry. */
  public boolean iscounty;
  public String restrictbankaccountpayment;
  public boolean allowmultipleattorneys;
  /** True if a service contact will be emailed if they are detached from a case at this court. 
   * NOTE(brycew): shouldn't have to do anything with this: only relevant to 
   * OasisEcfWsCallback.notifyEvent, but just to whether certain events can happen. 
   */
  public boolean sendservicecontactremovednotifications;
  /** True if this court allows the filer to specify a maximum fee amount to which the reviewer 
   * can adjust filing sduring review. */
  public boolean allowmaxfeeamount;
  /** If false, the EFM will require a Party Responsible for Fees when a waiver is used at 
   * this location. */
  public boolean transferwaivedfeestocms;
  /** If false and paying by credit card, courts will "Authorize" the card to determine if 
   * sufficient credit exists on the credit card.
   * TODO(brycew): should be something we notify users of, but IDK if we need to do anything 
   * different with this setting?
   */
  public boolean skippreauth;
  public boolean hasconditionalservicetypes;
  /** True if the court requires the EFSP to mask the case category and type for some types. */
  public boolean hasprotectedcasetypes;
  /** The list of case type codes that are required to be masked. */
  public List<String> protectedcasetypes;
  /** The string that you have to use to replace the case category/type if it's protected. */
  public String protectedcasereplacementstring;
  public boolean allowzerofeeswithoutfilingparty;
  public Optional<Boolean> allowserviceoninitial;
  public boolean allowaddservicecontactsoninitial;
  /** True if the court allows redaction of documents. See TODO(#39) */
  public boolean allowredaction;
  /** The URL for interacting with the redaction service via HTTP (?) See TODO(#39) */
  public String redactionurl;
  /** The URL for launching the redaction viewer/editor. See TODO(#39). */
  public String redactionviewerurl;
  /** True if "Forced redaction" is enabled at this court. See TODO(#39). */
  public boolean enforceredaction;
  /* A document type code to indicate the document type to be include for redacted documents 
   * at this court. See TODO(#39). */
  public String redactiondocumenttype;
  /** Location specific override for the Data Field Config "DocumentDescription"
   * if 1, sets the default value to be the filing code description (comparable to FilingCode)
   * if 2, sets the default value to be the name of the uploaded file (comparable to FileName)
   * if NULL, the field will objy the Data Field Configuration
   */
  public String defaultdocumentdescription;
  public boolean allowwaiveronmail;
  /** TODO(#38) for follow up to this code. */
  public boolean showreturnonreject;
  /** The redaction fee for this location. See TODO(#39). */
  public String redactionfee;
  /** True if redaction fees will be waived. See TODO(#39). */
  public boolean allowwaiveronredaction;
  public boolean disallowelectronicserviceonnewcontacts;
  /** If false, Individual users aren't allowed to register accounts. 
   * NOTE(brycew): assuming this is only present in the System (0) location, because it doesn't 
   * make sense as a per court thing. */
  public boolean allowindividualregistration;
  /** A comma delimeted list of elements to be redacted. Possible values are: AccountNumber, 
   * CreditCard, DriversLicense, GovernmentID, Passport, SocialSecurityNumber, TaxDocument. 
   * See TODO(#39) */
  public List<String> redactiontargetconfig;
  
  public CourtLocationInfo() {}
  
  public CourtLocationInfo(ResultSet rs) throws SQLException {
    this.code = rs.getString(1);
    this.name = rs.getString(2);
    this.initial = Boolean.parseBoolean(rs.getString(3));
    this.subsequent = Boolean.parseBoolean(rs.getString(4));
    this.disallowcopyingenvelopemultipletimes = Boolean.parseBoolean(rs.getString(5));
    this.allowfilingintononindexedcase = Boolean.parseBoolean(rs.getString(6));
    String cardTypes = rs.getString(7);
    if (cardTypes == null || cardTypes.isBlank()) {
      this.allowablecardtypes = List.of(); 
    } else {
      this.allowablecardtypes = List.of(cardTypes.split(","));
    }
    this.odysseynodeid = rs.getString(8);
    this.cmsid = rs.getString(9);
    this.sendservicebeforereview = rs.getString(10);
    this.parentnodeid = rs.getString(11);
    this.iscounty = Boolean.parseBoolean(rs.getString(12));
    this.restrictbankaccountpayment = rs.getString(13);
    this.allowmultipleattorneys = Boolean.parseBoolean(rs.getString(14));
    this.sendservicecontactremovednotifications = Boolean.parseBoolean(rs.getString(15));
    this.allowmaxfeeamount = Boolean.parseBoolean(rs.getString(16));
    this.transferwaivedfeestocms = Boolean.parseBoolean(rs.getString(17));
    this.skippreauth = Boolean.parseBoolean(rs.getString(18));
    this.hasconditionalservicetypes = Boolean.parseBoolean(rs.getString(19));
    this.hasprotectedcasetypes = Boolean.parseBoolean(rs.getString(20));
    if (this.hasprotectedcasetypes) {
      this.protectedcasetypes = List.of(rs.getString(21).split(","));
    } else {
      this.protectedcasetypes = List.of();
    }
    this.allowzerofeeswithoutfilingparty = Boolean.parseBoolean(rs.getString(22));
    String serviceoninitial = rs.getString(23);
    if (serviceoninitial == null || serviceoninitial.isBlank()) {
      this.allowserviceoninitial = Optional.empty(); 
    } else {
      this.allowserviceoninitial = Optional.of(Boolean.parseBoolean(serviceoninitial)); 
    }
    this.allowaddservicecontactsoninitial = Boolean.parseBoolean(rs.getString(24));
    this.allowredaction = Boolean.parseBoolean(rs.getString(25));
    this.redactionurl = rs.getString(26);
    this.redactionviewerurl = rs.getString(27);
    this.enforceredaction = Boolean.parseBoolean(rs.getString(28));
    this.redactiondocumenttype = rs.getString(29);
    this.defaultdocumentdescription = rs.getString(30);
    this.allowwaiveronmail = Boolean.parseBoolean(rs.getString(31));
    /** TODO(#38): need to check for all instances of "reject", and possibly change to "return". */
    this.showreturnonreject = Boolean.parseBoolean(rs.getString(32));
    
    this.protectedcasereplacementstring = rs.getString(33);
    this.redactionfee = rs.getString(34);
    this.allowwaiveronredaction = Boolean.parseBoolean(rs.getString(35));
    this.disallowelectronicserviceonnewcontacts = Boolean.parseBoolean(rs.getString(36));
    this.allowindividualregistration = Boolean.parseBoolean(rs.getString(37));
    String targetConfig = rs.getString(38);
    if (targetConfig == null || targetConfig.isBlank()) {
      this.redactiontargetconfig = List.of();
    } else {
      this.redactiontargetconfig = List.of(targetConfig.split(","));
    }
  }
  
  public static String fullSingleQuery() {
    return """
        SELECT code, name, initial, subsequent, disallowcopyingenvelopemultipletimes,
            allowfilingintononindexedcase,
            allowablecardtypes, odysseynodeid, cmsid, sendservicebeforereview, parentnodeid,
            iscounty, restrictbankaccountpayment, allowmultipleattorneys, sendservicecontactremovednotifications,
            allowmaxfeeamount, transferwaivedfeestocms, skippreauth, hasconditionalservicetypes, 
            hasprotectedcasetypes, protectedcasetypes, allowzerofeeswithoutfilingparty,
            allowserviceoninitial, allowaddservicecontactsoninitial,
            allowredaction, redactionurl, redactionviewerurl, enforceredaction,
            redactiondocumenttype, defaultdocumentdescription, allowwaiveronmail, showreturnonreject,
            protectedcasereplacementstring, redactionfee, allowwaiveronredaction, disallowelectronicserviceonnewcontacts,
            allowindividualregistration, redactiontargetconfig
        FROM location
        WHERE code=?
        """;
  }
  
  public static String allOrderedQuery() {
    return "SELECT DISTINCT code FROM location ORDER BY code";
  }
  
  public static String allNames() {
    return "SELECT name, code FROM location ORDER BY code";
  }

}
