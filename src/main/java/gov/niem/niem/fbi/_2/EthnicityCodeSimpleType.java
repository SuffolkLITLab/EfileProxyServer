
package gov.niem.niem.fbi._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for EthnicityCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="EthnicityCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="U"/&amp;gt;
 *     &amp;lt;enumeration value="H"/&amp;gt;
 *     &amp;lt;enumeration value="N"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "EthnicityCodeSimpleType")
@XmlEnum
public enum EthnicityCodeSimpleType {


    /**
     * unknown
     * 
     */
    U,

    /**
     * Hispanic
     * 
     */
    H,

    /**
     * non Hispanic
     * 
     */
    N;

    public String value() {
        return name();
    }

    public static EthnicityCodeSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
