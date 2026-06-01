package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.ecfcodes.tyler.PartyType;

/**
 * PartyType code / role code, and isOrg value isOrg is hacky, but Tyler expects us to create the
 * exact same case participants in a reply
 */
public record PartyInfo(PartyType type, PartyId partyId, boolean isOrg) {}
