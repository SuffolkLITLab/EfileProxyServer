
package ecf4.v2025_0.gov.niem.niem.fbi._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EthnicityCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="EthnicityCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="U"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
