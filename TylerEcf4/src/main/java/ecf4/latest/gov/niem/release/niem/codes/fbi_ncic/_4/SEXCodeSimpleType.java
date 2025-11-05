
package ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SEXCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SEXCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SEXCodeSimpleType")
@XmlEnum
public enum SEXCodeSimpleType {


    /**
     * FEMALE
     * 
     */
    F,

    /**
     * MALE
     * 
     */
    M,

    /**
     * UNKNOWN
     * 
     */
    U;

    public String value() {
        return name();
    }

    public static SEXCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
