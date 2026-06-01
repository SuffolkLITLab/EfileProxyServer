package edu.suffolk.litlab.efsp.ecfcodes.tyler;

import edu.suffolk.litlab.efsp.model.PartyId;
import edu.suffolk.litlab.efsp.model.PartyInfo;
import java.util.List;
import java.util.Map;

public record ComboCaseCodes(
    CaseCategory cat,
    CaseType type,
    List<FilingCode> filings,

    /**
     * String: either UUID for new parties, or Tyler PARTYID for existing parties Pair is PartyType
     * code / role code, and isOrg value isOrg is hacky, but Tyler expects us to create the exact
     * same case participants in a reply
     */
    Map<PartyId, PartyInfo> partyInfo) {

  public ComboCaseCodes() {
    this(
        new CaseCategory("", "", "", "", "", "", ""),
        new CaseType("", "", "", "", "", "", "", ""),
        List.of(),
        Map.of());
  }
}
