package edu.suffolk.litlab.efspserver.ecf;

import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CaseType;
import edu.suffolk.litlab.efspserver.codes.FilingCode;
import edu.suffolk.litlab.efspserver.codes.PartyType;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public class ComboCaseCodes {

  public final CaseCategory cat;
  public final CaseType type;
  public final List<FilingCode> filings;
  /**
   * String: either UUID for new parties, or Tyler PARTYID for existing parties Pair is PartyType
   * code / role code, and isOrg value isOrg is hacky, but Tyler expects us to create the exact same
   * case participants in a reply
   */
  public final Map<String, Pair<PartyType, Boolean>> partyInfo;

  public ComboCaseCodes(
      CaseCategory cat,
      CaseType type,
      List<FilingCode> filings,
      Map<String, Pair<PartyType, Boolean>> allPartyInfo) {
    this.cat = cat;
    this.type = type;
    this.filings = filings;
    this.partyInfo = allPartyInfo;
  }
}
