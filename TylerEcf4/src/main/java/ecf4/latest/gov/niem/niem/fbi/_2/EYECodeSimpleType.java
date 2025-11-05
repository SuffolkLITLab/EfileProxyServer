
package ecf4.latest.gov.niem.niem.fbi._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EYECodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="EYECodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="MUL"/&gt;
 *     &lt;enumeration value="GRY"/&gt;
 *     &lt;enumeration value="BLK"/&gt;
 *     &lt;enumeration value="MAR"/&gt;
 *     &lt;enumeration value="GRN"/&gt;
 *     &lt;enumeration value="BLU"/&gt;
 *     &lt;enumeration value="HAZ"/&gt;
 *     &lt;enumeration value="BRO"/&gt;
 *     &lt;enumeration value="XXX"/&gt;
 *     &lt;enumeration value="PNK"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EYECodeSimpleType")
@XmlEnum
public enum EYECodeSimpleType {


    /**
     * MULTICOLORED
     * 
     */
    MUL,

    /**
     * GRAY
     * 
     */
    GRY,

    /**
     * BLACK
     * 
     */
    BLK,

    /**
     * MAROON
     * 
     */
    MAR,

    /**
     * GREEN
     * 
     */
    GRN,

    /**
     * BLUE
     * 
     */
    BLU,

    /**
     * HAZEL
     * 
     */
    HAZ,

    /**
     * BROWN
     * 
     */
    BRO,

    /**
     * UNKNOWN
     * 
     */
    XXX,

    /**
     * PINK
     * 
     */
    PNK;

    public String value() {
        return name();
    }

    public static EYECodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
