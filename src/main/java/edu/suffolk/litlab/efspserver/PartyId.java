package edu.suffolk.litlab.efspserver;

public class PartyId {
  public final String id;
  public final Kind kind;
  
  public static PartyId CurrentFiling(String id) {
    return new PartyId(id, Kind.CURRENT_FILING);
  }
    
  public static PartyId Already(String id) {
    return new PartyId(id, Kind.ALREADY_IN);
  }
    
  private PartyId(String id, Kind kind) {
    this.id = id;
    this.kind = kind;
  }
    
  public boolean isInCurrentFiling() {
    return kind.equals(Kind.CURRENT_FILING);
  }

  private enum Kind {
    CURRENT_FILING,
    ALREADY_IN
  }
}
