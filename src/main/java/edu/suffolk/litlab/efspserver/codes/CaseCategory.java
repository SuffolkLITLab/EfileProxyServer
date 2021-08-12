package edu.suffolk.litlab.efspserver.codes;

import java.util.Optional;

public class CaseCategory {
  /// The Tyler specific code for this case category. E.g.: 183528
  public Optional<String> code;
  /// A human understandable name for this category. Can be broad, like "Probate", or
  /// specific, like "Law Magistrate: Damages over $10,000 up to $50,000"
  public String name;
  /// The ECF Case Type Schema Name. These are things like "AppellateCase", "BankruptcyCase", etc.
  /// The full list is at https://docs.oasis-open.org/legalxml-courtfiling/specs/ecf/v4.01/ecf-v4.01-spec/errata02/os/ecf-v4.01-spec-errata02-os-complete.html#_Toc425241622
  public String ecfcasetype;
  // TODO(brycew): turn these into enums
  /// > Indicates the behavior of the Procedure/Remedy code field for initial filings 
  /// E.g.: (Not Available, Available, Required)
  public String procedureremedyinitial;
  /** Indicates the behavior of the Procedure/Remedy code field for subsequent filings 
   * E.g.: (Not Available, Available, Required)
   */
  public String procedureremedysubsequent;
  /** Indicates the behavior of the DamageAmount code field for initial filings.
   * E.g.: (Not Available, Available, Required)
   */
  public String damageamountinitial;
  public String damageamountsubsequent;
  
  public CaseCategory(String name, String ecfCaseType) {
    this("", name, ecfCaseType, "Not Available", "Not Available", "Not Available", "Not Available");
  }
  
  // TODO(brycew): the tyler docs list a "damageamountsubsequent", but that's not in the 
  // Table. Is that my fault, or something to investigate?
  public CaseCategory(String code, String name, String ecfCaseType, String procedureremedyinitial,
      String procedureSub, String damageinitial, String damagesubsequent) {
    try {
      this.code = Optional.of(code);
    } catch (NumberFormatException ex) {
      this.code = Optional.empty();
    }
    this.name = name;
    this.ecfcasetype = ecfCaseType;
    this.procedureremedyinitial = procedureremedyinitial;
    this.procedureremedysubsequent = procedureSub;
    this.damageamountinitial = damageinitial;
    this.damageamountsubsequent = damagesubsequent;
  }
  
  public String getCode() {
    return code.orElse("no code?");
  }

  public static String getCaseCategoriesForLoc() {
    return """  
        SELECT code, name, ecfcasetype, procedureremedyinitial,
        procedureremedysubsequent, damageamountinitial, damageamountsubsequent
        FROM casecategory WHERE location=?""";
  }

  public static String getCaseCategoryForLoc() {
    return """  
        SELECT code, name, ecfcasetype, procedureremedyinitial,
        procedureremedysubsequent, damageamountinitial, damageamountsubsequent
        FROM casecategory WHERE location=? AND name=?""";
 }
  
}
