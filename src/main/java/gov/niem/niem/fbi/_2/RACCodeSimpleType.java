
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RACCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="RACCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="B"/&amp;gt;
 *     &amp;lt;enumeration value="I"/&amp;gt;
 *     &amp;lt;enumeration value="U"/&amp;gt;
 *     &amp;lt;enumeration value="W"/&amp;gt;
 *     &amp;lt;enumeration value="A"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "RACCodeSimpleType")
@XmlEnum
public enum RACCodeSimpleType {


    /**
     * BLACK
     * 
     */
    B,

    /**
     * AMERICAN INDIAN
     * 
     */
    I,

    /**
     * UNKNOWN
     * 
     */
    U,

    /**
     * WHITE
     * 
     */
    W,

    /**
     * ASIAN
     * 
     */
    A;

    public String value() {
        return name();
    }

    public static RACCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
