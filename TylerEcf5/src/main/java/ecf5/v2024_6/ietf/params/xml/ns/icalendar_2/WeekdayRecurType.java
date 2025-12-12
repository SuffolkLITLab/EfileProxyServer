
package ecf5.v2024_6.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WeekdayRecurType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="WeekdayRecurType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="SU"/&gt;
 *     &lt;enumeration value="MO"/&gt;
 *     &lt;enumeration value="TU"/&gt;
 *     &lt;enumeration value="WE"/&gt;
 *     &lt;enumeration value="TH"/&gt;
 *     &lt;enumeration value="FR"/&gt;
 *     &lt;enumeration value="SA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WeekdayRecurType")
@XmlEnum
public enum WeekdayRecurType {

    SU,
    MO,
    TU,
    WE,
    TH,
    FR,
    SA;

    public String value() {
        return name();
    }

    public static WeekdayRecurType fromValue(String v) {
        return valueOf(v);
    }

}
