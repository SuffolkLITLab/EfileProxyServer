
package ecf4.latest.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RangeValueType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="RangeValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="THISANDFUTURE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RangeValueType")
@XmlEnum
public enum RangeValueType {

    THISANDFUTURE;

    public String value() {
        return name();
    }

    public static RangeValueType fromValue(String v) {
        return valueOf(v);
    }

}
