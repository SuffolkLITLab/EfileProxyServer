
package ecf4.latest.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FreqRecurType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="FreqRecurType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="SECONDLY"/&gt;
 *     &lt;enumeration value="MINUTELY"/&gt;
 *     &lt;enumeration value="HOURLY"/&gt;
 *     &lt;enumeration value="DAILY"/&gt;
 *     &lt;enumeration value="WEEKLY"/&gt;
 *     &lt;enumeration value="MONTHLY"/&gt;
 *     &lt;enumeration value="YEARLY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FreqRecurType")
@XmlEnum
public enum FreqRecurType {

    SECONDLY,
    MINUTELY,
    HOURLY,
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY;

    public String value() {
        return name();
    }

    public static FreqRecurType fromValue(String v) {
        return valueOf(v);
    }

}
