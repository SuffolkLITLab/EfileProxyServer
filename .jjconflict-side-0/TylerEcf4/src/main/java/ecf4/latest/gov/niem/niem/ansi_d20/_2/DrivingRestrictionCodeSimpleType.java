
package ecf4.latest.gov.niem.niem.ansi_d20._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrivingRestrictionCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="DrivingRestrictionCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="J"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *     &lt;enumeration value="L"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *     &lt;enumeration value="O"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="K"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
