package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.ecfcodes.NameAndCode;

/**
 * PartyType code / role code, and isOrg value isOrg is hacky, but Tyler expects us to create the
 * exact same case participants in a reply
 */
public record PartyInfo(NameAndCode type, PartyId partyId, boolean isOrg) {}
