
package gov.niem.release.niem.codes.fbi_ncic._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EYECodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="EYECodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="BLK"/&gt;
 *     &lt;enumeration value="BLU"/&gt;
 *     &lt;enumeration value="BR0"/&gt;
 *     &lt;enumeration value="GRN"/&gt;
 *     &lt;enumeration value="GRY"/&gt;
 *     &lt;enumeration value="HAZ"/&gt;
 *     &lt;enumeration value="MAR"/&gt;
 *     &lt;enumeration value="MUL"/&gt;
 *     &lt;enumeration value="PNK"/&gt;
 *     &lt;enumeration value="XXX"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EYECodeSimpleType")
@XmlEnum
public enum EYECodeSimpleType {


    /**
     * BLACK
     * 
     */
    BLK("BLK"),

    /**
     * BLUE
     * 
     */
    BLU("BLU"),

    /**
     * BROWN
     * 
     */
    @XmlEnumValue("BR0")
    BR_0("BR0"),

    /**
     * GREEN
     * 
     */
    GRN("GRN"),

    /**
     * GRAY
     * 
     */
    GRY("GRY"),

    /**
     * HAZEL
     * 
     */
    HAZ("HAZ"),

    /**
     * MAROON
     * 
     */
    MAR("MAR"),

    /**
     * MULTICOLORED
     * 
     */
    MUL("MUL"),

    /**
     * PINK
     * 
     */
    PNK("PNK"),

    /**
     * UNKNOWN
     * 
     */
    XXX("XXX");
    private final String value;

    EYECodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EYECodeSimpleType fromValue(String v) {
        for (EYECodeSimpleType c: EYECodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
