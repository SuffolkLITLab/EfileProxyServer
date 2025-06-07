
package ecf4.latest.gov.niem.release.niem.domains.humanservices._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParentChildKinshipCategoryCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="ParentChildKinshipCategoryCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Adoption"/&gt;
 *     &lt;enumeration value="Biological"/&gt;
 *     &lt;enumeration value="Foster"/&gt;
 *     &lt;enumeration value="Guardianship"/&gt;
 *     &lt;enumeration value="Marriage"/&gt;
 *     &lt;enumeration value="Putative"/&gt;
 *     &lt;enumeration value="Surrogate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParentChildKinshipCategoryCodeSimpleType")
@XmlEnum
public enum ParentChildKinshipCategoryCodeSimpleType {


    /**
     * Adoption
     * 
     */
    @XmlEnumValue("Adoption")
    ADOPTION("Adoption"),

    /**
     * Biological
     * 
     */
    @XmlEnumValue("Biological")
    BIOLOGICAL("Biological"),

    /**
     * Foster
     * 
     */
    @XmlEnumValue("Foster")
    FOSTER("Foster"),

    /**
     * Guardianship
     * 
     */
    @XmlEnumValue("Guardianship")
    GUARDIANSHIP("Guardianship"),

    /**
     * Marriage
     * 
     */
    @XmlEnumValue("Marriage")
    MARRIAGE("Marriage"),

    /**
     * Putative
     * 
     */
    @XmlEnumValue("Putative")
    PUTATIVE("Putative"),

    /**
     * Surrogate
     * 
     */
    @XmlEnumValue("Surrogate")
    SURROGATE("Surrogate");
    private final String value;

    ParentChildKinshipCategoryCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParentChildKinshipCategoryCodeSimpleType fromValue(String v) {
        for (ParentChildKinshipCategoryCodeSimpleType c: ParentChildKinshipCategoryCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
