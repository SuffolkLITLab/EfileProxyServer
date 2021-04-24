
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for HAICodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="HAICodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="ONG"/&amp;gt;
 *     &amp;lt;enumeration value="PNK"/&amp;gt;
 *     &amp;lt;enumeration value="BLN"/&amp;gt;
 *     &amp;lt;enumeration value="GRY"/&amp;gt;
 *     &amp;lt;enumeration value="XXX"/&amp;gt;
 *     &amp;lt;enumeration value="SDY"/&amp;gt;
 *     &amp;lt;enumeration value="BRO"/&amp;gt;
 *     &amp;lt;enumeration value="BLU"/&amp;gt;
 *     &amp;lt;enumeration value="BLK"/&amp;gt;
 *     &amp;lt;enumeration value="RED"/&amp;gt;
 *     &amp;lt;enumeration value="WHI"/&amp;gt;
 *     &amp;lt;enumeration value="GRN"/&amp;gt;
 *     &amp;lt;enumeration value="PLE"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "HAICodeSimpleType")
@XmlEnum
public enum HAICodeSimpleType {


    /**
     * Orange
     * 
     */
    ONG,

    /**
     * Pink
     * 
     */
    PNK,

    /**
     * Blond or Strawberry
     * 
     */
    BLN,

    /**
     * Gray or Partially Gray
     * 
     */
    GRY,

    /**
     * UNKNOWN OR COMPLETELY BALD
     * 
     */
    XXX,

    /**
     * Sandy
     * 
     */
    SDY,

    /**
     * Brown
     * 
     */
    BRO,

    /**
     * Blue
     * 
     */
    BLU,

    /**
     * Black
     * 
     */
    BLK,

    /**
     * Red or Auburn
     * 
     */
    RED,

    /**
     * White
     * 
     */
    WHI,

    /**
     * Green
     * 
     */
    GRN,

    /**
     * Purple
     * 
     */
    PLE;

    public String value() {
        return name();
    }

    public static HAICodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
