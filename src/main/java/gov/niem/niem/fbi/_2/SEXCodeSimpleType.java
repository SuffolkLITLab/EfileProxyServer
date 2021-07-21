
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SEXCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SEXCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="F"/&gt;
 *     &lt;enumeration value="M"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SEXCodeSimpleType")
@XmlEnum
public enum SEXCodeSimpleType {


    /**
     * UNKNOWN - FOR UNIDENTIFIED ONLY
     * 
     */
    U,

    /**
     * FEMALE
     * 
     */
    F,

    /**
     * MALE
     * 
     */
    M;

    public String value() {
        return name();
    }

    public static SEXCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
