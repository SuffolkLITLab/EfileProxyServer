
package gov.niem.niem.nonauthoritative_code._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FamilyKinshipCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="FamilyKinshipCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="marriage"/&amp;gt;
 *     &amp;lt;enumeration value="foster"/&amp;gt;
 *     &amp;lt;enumeration value="biological"/&amp;gt;
 *     &amp;lt;enumeration value="adoption"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "FamilyKinshipCodeSimpleType")
@XmlEnum
public enum FamilyKinshipCodeSimpleType {

    @XmlEnumValue("marriage")
    MARRIAGE("marriage"),
    @XmlEnumValue("foster")
    FOSTER("foster"),
    @XmlEnumValue("biological")
    BIOLOGICAL("biological"),
    @XmlEnumValue("adoption")
    ADOPTION("adoption");
    private final String value;

    FamilyKinshipCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FamilyKinshipCodeSimpleType fromValue(String v) {
        for (FamilyKinshipCodeSimpleType c: FamilyKinshipCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
