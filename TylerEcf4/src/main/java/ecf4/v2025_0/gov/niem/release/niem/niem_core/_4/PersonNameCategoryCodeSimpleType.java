
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonNameCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PersonNameCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Alternate"/&gt;
 *     &lt;enumeration value="Asserted"/&gt;
 *     &lt;enumeration value="at birth"/&gt;
 *     &lt;enumeration value="Legal"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PersonNameCategoryCodeSimpleType")
@XmlEnum
public enum PersonNameCategoryCodeSimpleType {


    /**
     * Alternate
     * 
     */
    @XmlEnumValue("Alternate")
    ALTERNATE("Alternate"),

    /**
     * Asserted
     * 
     */
    @XmlEnumValue("Asserted")
    ASSERTED("Asserted"),

    /**
     * Name at birth
     * 
     */
    @XmlEnumValue("at birth")
    AT_BIRTH("at birth"),

    /**
     * Legal
     * 
     */
    @XmlEnumValue("Legal")
    LEGAL("Legal");
    private final String value;

    PersonNameCategoryCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersonNameCategoryCodeSimpleType fromValue(String v) {
        for (PersonNameCategoryCodeSimpleType c: PersonNameCategoryCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
