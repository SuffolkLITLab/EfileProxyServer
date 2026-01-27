
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactInformationAvailabilityCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="ContactInformationAvailabilityCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="day"/&gt;
 *     &lt;enumeration value="emergency"/&gt;
 *     &lt;enumeration value="evening"/&gt;
 *     &lt;enumeration value="night"/&gt;
 *     &lt;enumeration value="primary"/&gt;
 *     &lt;enumeration value="secondary"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ContactInformationAvailabilityCodeSimpleType")
@XmlEnum
public enum ContactInformationAvailabilityCodeSimpleType {


    /**
     * Daytime
     * 
     */
    @XmlEnumValue("day")
    DAY("day"),

    /**
     * Emergency
     * 
     */
    @XmlEnumValue("emergency")
    EMERGENCY("emergency"),

    /**
     * Late day or early night
     * 
     */
    @XmlEnumValue("evening")
    EVENING("evening"),

    /**
     * Late night
     * 
     */
    @XmlEnumValue("night")
    NIGHT("night"),

    /**
     * Primary
     * 
     */
    @XmlEnumValue("primary")
    PRIMARY("primary"),

    /**
     * Secondary or alternate
     * 
     */
    @XmlEnumValue("secondary")
    SECONDARY("secondary");
    private final String value;

    ContactInformationAvailabilityCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContactInformationAvailabilityCodeSimpleType fromValue(String v) {
        for (ContactInformationAvailabilityCodeSimpleType c: ContactInformationAvailabilityCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
