
package ecfv5.ietf.params.xml.ns.icalendar_2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalscaleValueType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CalscaleValueType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GREGORIAN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CalscaleValueType")
@XmlEnum
public enum CalscaleValueType {

    GREGORIAN;

    public String value() {
        return name();
    }

    public static CalscaleValueType fromValue(String v) {
        return valueOf(v);
    }

}
