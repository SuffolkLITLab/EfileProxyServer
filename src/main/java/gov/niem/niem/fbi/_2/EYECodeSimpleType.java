
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for EYECodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="EYECodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="MUL"/&amp;gt;
 *     &amp;lt;enumeration value="GRY"/&amp;gt;
 *     &amp;lt;enumeration value="BLK"/&amp;gt;
 *     &amp;lt;enumeration value="MAR"/&amp;gt;
 *     &amp;lt;enumeration value="GRN"/&amp;gt;
 *     &amp;lt;enumeration value="BLU"/&amp;gt;
 *     &amp;lt;enumeration value="HAZ"/&amp;gt;
 *     &amp;lt;enumeration value="BRO"/&amp;gt;
 *     &amp;lt;enumeration value="XXX"/&amp;gt;
 *     &amp;lt;enumeration value="PNK"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
