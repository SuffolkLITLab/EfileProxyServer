
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for VCOCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="VCOCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="COM"/&amp;gt;
 *     &amp;lt;enumeration value="BRZ"/&amp;gt;
 *     &amp;lt;enumeration value="MVE"/&amp;gt;
 *     &amp;lt;enumeration value="DGR"/&amp;gt;
 *     &amp;lt;enumeration value="CPR"/&amp;gt;
 *     &amp;lt;enumeration value="BLK"/&amp;gt;
 *     &amp;lt;enumeration value="TRQ"/&amp;gt;
 *     &amp;lt;enumeration value="MAR"/&amp;gt;
 *     &amp;lt;enumeration value="DBL"/&amp;gt;
 *     &amp;lt;enumeration value="BRO"/&amp;gt;
 *     &amp;lt;enumeration value="GLD"/&amp;gt;
 *     &amp;lt;enumeration value="SIL"/&amp;gt;
 *     &amp;lt;enumeration value="TPE"/&amp;gt;
 *     &amp;lt;enumeration value="RED"/&amp;gt;
 *     &amp;lt;enumeration value="CRM"/&amp;gt;
 *     &amp;lt;enumeration value="CAM"/&amp;gt;
 *     &amp;lt;enumeration value="AME"/&amp;gt;
 *     &amp;lt;enumeration value="BLU"/&amp;gt;
 *     &amp;lt;enumeration value="GRY"/&amp;gt;
 *     &amp;lt;enumeration value="ONG"/&amp;gt;
 *     &amp;lt;enumeration value="PNK"/&amp;gt;
 *     &amp;lt;enumeration value="TAN"/&amp;gt;
 *     &amp;lt;enumeration value="TEA"/&amp;gt;
 *     &amp;lt;enumeration value="YEL"/&amp;gt;
 *     &amp;lt;enumeration value="MUL/COL"/&amp;gt;
 *     &amp;lt;enumeration value="GRN"/&amp;gt;
 *     &amp;lt;enumeration value="PLE"/&amp;gt;
 *     &amp;lt;enumeration value="WHI"/&amp;gt;
 *     &amp;lt;enumeration value="LGR"/&amp;gt;
 *     &amp;lt;enumeration value="LBL"/&amp;gt;
 *     &amp;lt;enumeration value="LAV"/&amp;gt;
 *     &amp;lt;enumeration value="BGE"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
