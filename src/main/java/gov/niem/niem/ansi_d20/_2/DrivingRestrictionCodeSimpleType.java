
package gov.niem.niem.ansi_d20._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DrivingRestrictionCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="DrivingRestrictionCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="J"/&amp;gt;
 *     &amp;lt;enumeration value="I"/&amp;gt;
 *     &amp;lt;enumeration value="W"/&amp;gt;
 *     &amp;lt;enumeration value="L"/&amp;gt;
 *     &amp;lt;enumeration value="C"/&amp;gt;
 *     &amp;lt;enumeration value="O"/&amp;gt;
 *     &amp;lt;enumeration value="B"/&amp;gt;
 *     &amp;lt;enumeration value="K"/&amp;gt;
 *     &amp;lt;enumeration value="F"/&amp;gt;
 *     &amp;lt;enumeration value="E"/&amp;gt;
 *     &amp;lt;enumeration value="D"/&amp;gt;
 *     &amp;lt;enumeration value="G"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "DrivingRestrictionCodeSimpleType")
@XmlEnum
public enum DrivingRestrictionCodeSimpleType {


    /**
     * Other
     * 
     */
    J,

    /**
     * Limited - other
     * 
     */
    I,

    /**
     * Farm Waiver
     * 
     */
    W,

    /**
     * Vehicles without Air Brakes
     * 
     */
    L,

    /**
     * Mechanical Aid
     * 
     */
    C,

    /**
     * Except Tractor-Trailer
     * 
     */
    O,

    /**
     * Corrective lenses must be worn
     * 
     */
    B,

    /**
     * CDL Intrastate Only
     * 
     */
    K,

    /**
     * Outside Mirror
     * 
     */
    F,

    /**
     * Automatic Transmission
     * 
     */
    E,

    /**
     * Prosthetic Aid
     * 
     */
    D,

    /**
     * Limit to Daylight Only
     * 
     */
    G;

    public String value() {
        return name();
    }

    public static DrivingRestrictionCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
