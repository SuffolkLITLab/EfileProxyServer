
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaseTypeCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CaseTypeCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *     &lt;enumeration value="Appellate"/&gt;
 *     &lt;enumeration value="Bankruptcy"/&gt;
 *     &lt;enumeration value="Citation"/&gt;
 *     &lt;enumeration value="Civil"/&gt;
 *     &lt;enumeration value="Criminal"/&gt;
 *     &lt;enumeration value="Domestic"/&gt;
 *     &lt;enumeration value="Juvenile"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CaseTypeCodeSimpleType")
@XmlEnum
public enum CaseTypeCodeSimpleType {


    /**
     * Appellate case type
     * 
     */
    @XmlEnumValue("Appellate")
    APPELLATE("Appellate"),

    /**
     * Bankruptcy case type
     * 
     */
    @XmlEnumValue("Bankruptcy")
    BANKRUPTCY("Bankruptcy"),

    /**
     * Citation case type
     * 
     */
    @XmlEnumValue("Citation")
    CITATION("Citation"),

    /**
     * Civil case type
     * 
     */
    @XmlEnumValue("Civil")
    CIVIL("Civil"),

    /**
     * Criminal case type
     * 
     */
    @XmlEnumValue("Criminal")
    CRIMINAL("Criminal"),

    /**
     * Domestic case type
     * 
     */
    @XmlEnumValue("Domestic")
    DOMESTIC("Domestic"),

    /**
     * Juvenile case type
     * 
     */
    @XmlEnumValue("Juvenile")
    JUVENILE("Juvenile");
    private final String value;

    CaseTypeCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CaseTypeCodeSimpleType fromValue(String v) {
        for (CaseTypeCodeSimpleType c: CaseTypeCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
