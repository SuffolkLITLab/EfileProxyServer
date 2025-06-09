
package gov.niem.niem.nonauthoritative_code._2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FamilyKinshipCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="FamilyKinshipCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="marriage"/&gt;
 *     &lt;enumeration value="foster"/&gt;
 *     &lt;enumeration value="biological"/&gt;
 *     &lt;enumeration value="adoption"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
