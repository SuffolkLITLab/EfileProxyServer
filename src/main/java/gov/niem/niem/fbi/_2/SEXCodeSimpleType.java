
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for SEXCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="SEXCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="U"/&amp;gt;
 *     &amp;lt;enumeration value="F"/&amp;gt;
 *     &amp;lt;enumeration value="M"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
