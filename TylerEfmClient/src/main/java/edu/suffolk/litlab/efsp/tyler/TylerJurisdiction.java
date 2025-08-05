package edu.suffolk.litlab.efsp.tyler;

// Currently supported Jurisdictions
public enum TylerJurisdiction {
    CALIFORNIA("california"),
    ILLINOIS("illinois"),
    INDIANA("indiana"),
    MASSACHUSETTS("massachusetts"),
    TEXAS("texas");

    private String name;

    private TylerJurisdiction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TylerJurisdiction parse(String value) {
        for (var j: TylerJurisdiction.values()) {
            if (value.equalsIgnoreCase(j.getName())) {
                return j;
            }
        }
        throw new IllegalArgumentException("Can't make a `TylerJurisdiction` from " + value);
    }
}
