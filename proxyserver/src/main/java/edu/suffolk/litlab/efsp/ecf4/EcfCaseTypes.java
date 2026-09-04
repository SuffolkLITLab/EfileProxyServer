package edu.suffolk.litlab.efsp.ecf4;

/**
 * Straight from ECF4 Spec:
 * https://docs.oasis-open.org/legalxml-courtfiling/specs/ecf/v4.01/ecf-v4.01-spec/os/ecf-v4.01-spec-os.html#_Toc343512773
 *
 * <p>Enumerated in a few other places, but none of the XML has a straight enum to use.
 */
public enum EcfCaseTypes {
  AppellateCase,
  BankruptcyCase,
  CitationCase,
  CivilCase,
  CriminalCase,
  DomesticCase,
  JuvenileCase;
}
