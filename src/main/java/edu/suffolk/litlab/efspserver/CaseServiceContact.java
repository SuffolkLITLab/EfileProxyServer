package edu.suffolk.litlab.efspserver;

import java.util.Optional;
import java.util.UUID;

public class CaseServiceContact {
  public final String guid;
  public final String serviceType;
  /** If present, it's the name of the Person Obj Id that this contact is associated with. */
  public final Optional<PartyId> partyAssociated;

  public final String refId;

  public CaseServiceContact(String guid, String serviceType, Optional<PartyId> partyAssociated) {
    this.guid = guid;
    this.serviceType = serviceType;
    this.partyAssociated = partyAssociated;
    this.refId = "serv-" + UUID.randomUUID().toString();
  }
}
