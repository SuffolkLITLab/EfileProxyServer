
package ecf4.latest.gov.niem.niem.fbi._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RACCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="RACCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="B"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *     &lt;enumeration value="A"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
