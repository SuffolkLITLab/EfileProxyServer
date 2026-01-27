
package ecf4.latest.tyler.ecf.extensions.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaseRelationSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CaseRelationSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="SubsequentAction"/&gt;
 *     &lt;enumeration value="AppellateCase"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CaseRelationSimpleType")
@XmlEnum
public enum CaseRelationSimpleType {

    @XmlEnumValue("SubsequentAction")
    SUBSEQUENT_ACTION("SubsequentAction"),
    @XmlEnumValue("AppellateCase")
    APPELLATE_CASE("AppellateCase");
    private final String value;

    CaseRelationSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CaseRelationSimpleType fromValue(String v) {
        for (CaseRelationSimpleType c: CaseRelationSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
