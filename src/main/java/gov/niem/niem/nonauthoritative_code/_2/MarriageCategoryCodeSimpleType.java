
package gov.niem.niem.nonauthoritative_code._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarriageCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="MarriageCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="unknown"/&gt;
 *     &lt;enumeration value="married"/&gt;
 *     &lt;enumeration value="common law"/&gt;
 *     &lt;enumeration value="civil union"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MarriageCategoryCodeSimpleType")
@XmlEnum
public enum MarriageCategoryCodeSimpleType {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("married")
    MARRIED("married"),
    @XmlEnumValue("common law")
    COMMON_LAW("common law"),
    @XmlEnumValue("civil union")
    CIVIL_UNION("civil union");
    private final String value;

    MarriageCategoryCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MarriageCategoryCodeSimpleType fromValue(String v) {
        for (MarriageCategoryCodeSimpleType c: MarriageCategoryCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
