
package gov.niem.niem.fbi._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HAICodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="HAICodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="ONG"/&gt;
 *     &lt;enumeration value="PNK"/&gt;
 *     &lt;enumeration value="BLN"/&gt;
 *     &lt;enumeration value="GRY"/&gt;
 *     &lt;enumeration value="XXX"/&gt;
 *     &lt;enumeration value="SDY"/&gt;
 *     &lt;enumeration value="BRO"/&gt;
 *     &lt;enumeration value="BLU"/&gt;
 *     &lt;enumeration value="BLK"/&gt;
 *     &lt;enumeration value="RED"/&gt;
 *     &lt;enumeration value="WHI"/&gt;
 *     &lt;enumeration value="GRN"/&gt;
 *     &lt;enumeration value="PLE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
