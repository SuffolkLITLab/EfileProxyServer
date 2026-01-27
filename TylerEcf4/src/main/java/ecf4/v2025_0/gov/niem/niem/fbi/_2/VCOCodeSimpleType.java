
package ecf4.v2025_0.gov.niem.niem.fbi._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VCOCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="VCOCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="COM"/&gt;
 *     &lt;enumeration value="BRZ"/&gt;
 *     &lt;enumeration value="MVE"/&gt;
 *     &lt;enumeration value="DGR"/&gt;
 *     &lt;enumeration value="CPR"/&gt;
 *     &lt;enumeration value="BLK"/&gt;
 *     &lt;enumeration value="TRQ"/&gt;
 *     &lt;enumeration value="MAR"/&gt;
 *     &lt;enumeration value="DBL"/&gt;
 *     &lt;enumeration value="BRO"/&gt;
 *     &lt;enumeration value="GLD"/&gt;
 *     &lt;enumeration value="SIL"/&gt;
 *     &lt;enumeration value="TPE"/&gt;
 *     &lt;enumeration value="RED"/&gt;
 *     &lt;enumeration value="CRM"/&gt;
 *     &lt;enumeration value="CAM"/&gt;
 *     &lt;enumeration value="AME"/&gt;
 *     &lt;enumeration value="BLU"/&gt;
 *     &lt;enumeration value="GRY"/&gt;
 *     &lt;enumeration value="ONG"/&gt;
 *     &lt;enumeration value="PNK"/&gt;
 *     &lt;enumeration value="TAN"/&gt;
 *     &lt;enumeration value="TEA"/&gt;
 *     &lt;enumeration value="YEL"/&gt;
 *     &lt;enumeration value="MUL/COL"/&gt;
 *     &lt;enumeration value="GRN"/&gt;
 *     &lt;enumeration value="PLE"/&gt;
 *     &lt;enumeration value="WHI"/&gt;
 *     &lt;enumeration value="LGR"/&gt;
 *     &lt;enumeration value="LBL"/&gt;
 *     &lt;enumeration value="LAV"/&gt;
 *     &lt;enumeration value="BGE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "VCOCodeSimpleType")
@XmlEnum
public enum VCOCodeSimpleType {


    /**
     * CHROME, STAINLESS STEEL
     * 
     */
    COM("COM"),

    /**
     * BRONZE
     * 
     */
    BRZ("BRZ"),

    /**
     * MAUVE
     * 
     */
    MVE("MVE"),

    /**
     * GREEN, DARK
     * 
     */
    DGR("DGR"),

    /**
     * COPPER
     * 
     */
    CPR("CPR"),

    /**
     * BLACK
     * 
     */
    BLK("BLK"),

    /**
     * TURQUOISE (BLUE)
     * 
     */
    TRQ("TRQ"),

    /**
     * MAROON, BURGUNDY (PURPLE)
     * 
     */
    MAR("MAR"),

    /**
     * BLUE, DARK
     * 
     */
    DBL("DBL"),

    /**
     * BROWN
     * 
     */
    BRO("BRO"),

    /**
     * GOLD
     * 
     */
    GLD("GLD"),

    /**
     * SILVER
     * 
     */
    SIL("SIL"),

    /**
     * TAUPE
     * 
     */
    TPE("TPE"),

    /**
     * RED
     * 
     */
    RED("RED"),

    /**
     * CREAM, IVORY
     * 
     */
    CRM("CRM"),

    /**
     * CAMOUFLAGE
     * 
     */
    CAM("CAM"),

    /**
     * AMETHYST
     * 
     */
    AME("AME"),

    /**
     * BLUE
     * 
     */
    BLU("BLU"),

    /**
     * GRAY
     * 
     */
    GRY("GRY"),

    /**
     * ORANGE
     * 
     */
    ONG("ONG"),

    /**
     * PINK
     * 
     */
    PNK("PNK"),

    /**
     * TAN
     * 
     */
    TAN("TAN"),

    /**
     * TEAL
     * 
     */
    TEA("TEA"),

    /**
     * YELLOW
     * 
     */
    YEL("YEL"),

    /**
     * MULTICOLORED
     * 
     */
    @XmlEnumValue("MUL/COL")
    MUL_COL("MUL/COL"),

    /**
     * GREEN
     * 
     */
    GRN("GRN"),

    /**
     * PURPLE
     * 
     */
    PLE("PLE"),

    /**
     * WHITE
     * 
     */
    WHI("WHI"),

    /**
     * GREEN, LIGHT
     * 
     */
    LGR("LGR"),

    /**
     * BLUE, LIGHT
     * 
     */
    LBL("LBL"),

    /**
     * LAVENDER (PURPLE)
     * 
     */
    LAV("LAV"),

    /**
     * BEIGE
     * 
     */
    BGE("BGE");
    private final String value;

    VCOCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VCOCodeSimpleType fromValue(String v) {
        for (VCOCodeSimpleType c: VCOCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
