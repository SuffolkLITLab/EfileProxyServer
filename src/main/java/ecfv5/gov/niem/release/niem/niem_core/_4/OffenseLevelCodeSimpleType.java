
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OffenseLevelCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="OffenseLevelCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="G"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OffenseLevelCodeSimpleType")
@XmlEnum
public enum OffenseLevelCodeSimpleType {


    /**
     * Felony
     * 
     */
    F,

    /**
     * Gross Misdemeanor
     * 
     */
    G,

    /**
     * Misdemeanor
     * 
     */
    M,

    /**
     * Petty Misdemeanor
     * 
     */
    P;

    public String value() {
        return name();
    }

    public static OffenseLevelCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
