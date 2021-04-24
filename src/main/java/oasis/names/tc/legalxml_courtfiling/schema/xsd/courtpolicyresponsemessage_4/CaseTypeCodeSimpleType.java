
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CaseTypeCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="CaseTypeCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&amp;gt;
 *     &amp;lt;enumeration value="Appellate"/&amp;gt;
 *     &amp;lt;enumeration value="Bankruptcy"/&amp;gt;
 *     &amp;lt;enumeration value="Citation"/&amp;gt;
 *     &amp;lt;enumeration value="Civil"/&amp;gt;
 *     &amp;lt;enumeration value="Criminal"/&amp;gt;
 *     &amp;lt;enumeration value="Domestic"/&amp;gt;
 *     &amp;lt;enumeration value="Juvenile"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
