
package gov.niem.niem.nonauthoritative_code._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for MarriageCategoryCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="MarriageCategoryCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="unknown"/&amp;gt;
 *     &amp;lt;enumeration value="married"/&amp;gt;
 *     &amp;lt;enumeration value="common law"/&amp;gt;
 *     &amp;lt;enumeration value="civil union"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
