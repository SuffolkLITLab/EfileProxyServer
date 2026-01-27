
package ecf4.v2025_0.gov.niem.release.niem.codes.fbi_ncic._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RACECodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="RACECodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="A"/&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RACECodeSimpleType")
@XmlEnum
public enum RACECodeSimpleType {


    /**
     * ASIAN OR PACIFIC ISLANDER - A PERSON HAVING ORIGINS IN ANY OF THE ORIGINAL PEOPLES OF THE FAR EAST, SOUTHEAST ASIA, THE INDIAN SUBCONTINENT OR THE PACIFIC ISLANDS.
     * 
     */
    A,

    /**
     * BLACK - A PERSON HAVING ORIGINS IN ANY OF THE BLACK RACIAL GROUPS OF AFRICA.
     * 
     */
    B,

    /**
     * AMERICAN INDIAN OR ALASKAN NATIVE - A PERSON HAVING ORIGINS IN ANY OF THE ORIGINAL PEOPLES OF THE AMERICAS AND MAINTAINING CULTURAL IDENTIFICATION THROUGH TRIBAL AFFILIATIONS OR COMMUNITY RECOGNITION.
     * 
     */
    I,

    /**
     * UNKNOWN.
     * 
     */
    U,

    /**
     * WHITE - A PERSON HAVING ORIGINS IN ANY OF THE ORIGINAL PEOPLES OF EUROPE, NORTH AFRICA, OR MIDDLE EAST.
     * 
     */
    W;

    public String value() {
        return name();
    }

    public static RACECodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
