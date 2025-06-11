
package gov.niem.release.niem.codes.cbrncl._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SystemOperatingModeCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SystemOperatingModeCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Exercise"/&gt;
 *     &lt;enumeration value="Ops"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *     &lt;enumeration value="Test"/&gt;
 *     &lt;enumeration value="Unknown"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SystemOperatingModeCodeSimpleType")
@XmlEnum
public enum SystemOperatingModeCodeSimpleType {


    /**
     * The system is in use by an exercise.
     * 
     */
    @XmlEnumValue("Exercise")
    EXERCISE("Exercise"),

    /**
     * The system is in live operational use.
     * 
     */
    @XmlEnumValue("Ops")
    OPS("Ops"),

    /**
     * The system is in an unspecified operating mode. A description of this model needs to be provided in the element SystemOperatingModeText.
     * 
     */
    @XmlEnumValue("Other")
    OTHER("Other"),

    /**
     * The system is in test operations.
     * 
     */
    @XmlEnumValue("Test")
    TEST("Test"),

    /**
     * The operating mode of the system is unknown.
     * 
     */
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    SystemOperatingModeCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SystemOperatingModeCodeSimpleType fromValue(String v) {
        for (SystemOperatingModeCodeSimpleType c: SystemOperatingModeCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
