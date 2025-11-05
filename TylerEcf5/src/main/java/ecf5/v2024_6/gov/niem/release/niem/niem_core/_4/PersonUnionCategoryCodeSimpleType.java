
package gov.niem.release.niem.niem_core._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonUnionCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PersonUnionCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="civil union"/&gt;
 *     &lt;enumeration value="common law"/&gt;
 *     &lt;enumeration value="domestic partnership"/&gt;
 *     &lt;enumeration value="married"/&gt;
 *     &lt;enumeration value="unknown"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PersonUnionCategoryCodeSimpleType")
@XmlEnum
public enum PersonUnionCategoryCodeSimpleType {


    /**
     * civil union
     * 
     */
    @XmlEnumValue("civil union")
    CIVIL_UNION("civil union"),

    /**
     * common law
     * 
     */
    @XmlEnumValue("common law")
    COMMON_LAW("common law"),

    /**
     * domestic partnership
     * 
     */
    @XmlEnumValue("domestic partnership")
    DOMESTIC_PARTNERSHIP("domestic partnership"),

    /**
     * married
     * 
     */
    @XmlEnumValue("married")
    MARRIED("married"),

    /**
     * unknown
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    PersonUnionCategoryCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersonUnionCategoryCodeSimpleType fromValue(String v) {
        for (PersonUnionCategoryCodeSimpleType c: PersonUnionCategoryCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
