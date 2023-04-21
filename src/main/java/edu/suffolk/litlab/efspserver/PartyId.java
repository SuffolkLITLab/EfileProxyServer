package edu.suffolk.litlab.efspserver;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Some reference in a filing to a party that could either be in the current filing or it could
 * already exist in the EFMs system. The ID is whichever of the "Kind" it is.
 *
 * @author brycew
 */
public class PartyId {
  private final String id;
  private final Kind kind;

  /** Factory method where the ID refers to a newly added party in this filing. */
  public static PartyId CurrentFilingNew(String id) {
    return new PartyId(id, Kind.CURRENT_FILING_NEW);
  }

  /** Factory method where the ID refers to an existing party in the EFM's system. */
  public static PartyId Already(String id) {
    return new PartyId(id, Kind.ALREADY_IN);
  }

  /** Private constructor, use {@link Already} and {@link CurrentFiling} instead. */
  private PartyId(String id, Kind kind) {
    this.id = id;
    this.kind = kind;
  }

  public boolean isNewInCurrentFiling() {
    return kind.equals(Kind.CURRENT_FILING_NEW);
  }

  public boolean isAlreadyInCase() {
    return kind.equals(Kind.ALREADY_IN);
  }

  /* ID string required by XML (needs to start with "id-"). */
  public String getIdString() {
    if (id.startsWith("id-")) {
      return id;
    } else {
      return "id-" + id;
    }
  }

  /** If we got the ID from Tyler, without the `id-` prefix. Otherwise our same thing. */
  public String getIdentificationString() {
    if (isNewInCurrentFiling()) {
      return getIdString();
    }
    return id;
  }

  private enum Kind {
    CURRENT_FILING_NEW,
    ALREADY_IN
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof PartyId)) {
      return false;
    }

    PartyId other = (PartyId) object;
    return this.id.equals(other.id) && this.kind.equals(other.kind);
  }

  @Override
  public int hashCode() {
    return (new HashCodeBuilder(17, 31)).append(id).append(kind).toHashCode();
  }

  @Override
  public String toString() {
    return "PartyId[id: " + id + ", kind: " + kind + "]";
  }
}
