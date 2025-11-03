
package ecf4.latest.gov.niem.release.niem.domains.humanservices._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlacementLocationCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="PlacementLocationCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Family"/&gt;
 *     &lt;enumeration value="Father"/&gt;
 *     &lt;enumeration value="Fictive Kin"/&gt;
 *     &lt;enumeration value="Foster Group Home"/&gt;
 *     &lt;enumeration value="Foster Home"/&gt;
 *     &lt;enumeration value="Foster Home Adoptive"/&gt;
 *     &lt;enumeration value="Habitative Foster Home"/&gt;
 *     &lt;enumeration value="Mother"/&gt;
 *     &lt;enumeration value="Psychiatric Hospital"/&gt;
 *     &lt;enumeration value="RSA"/&gt;
 *     &lt;enumeration value="RTC"/&gt;
 *     &lt;enumeration value="TFH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PlacementLocationCodeSimpleType")
@XmlEnum
public enum PlacementLocationCodeSimpleType {


    /**
     * Family
     * 
     */
    @XmlEnumValue("Family")
    FAMILY("Family"),

    /**
     * Father
     * 
     */
    @XmlEnumValue("Father")
    FATHER("Father"),

    /**
     * Symbolic Relative (also known as Fictive Kin)
     * 
     */
    @XmlEnumValue("Fictive Kin")
    FICTIVE_KIN("Fictive Kin"),

    /**
     * Foster Group Home
     * 
     */
    @XmlEnumValue("Foster Group Home")
    FOSTER_GROUP_HOME("Foster Group Home"),

    /**
     * Foster Home
     * 
     */
    @XmlEnumValue("Foster Home")
    FOSTER_HOME("Foster Home"),

    /**
     * Foster Home Adoptive
     * 
     */
    @XmlEnumValue("Foster Home Adoptive")
    FOSTER_HOME_ADOPTIVE("Foster Home Adoptive"),

    /**
     * Habitative Foster Home
     * 
     */
    @XmlEnumValue("Habitative Foster Home")
    HABITATIVE_FOSTER_HOME("Habitative Foster Home"),

    /**
     * Mother
     * 
     */
    @XmlEnumValue("Mother")
    MOTHER("Mother"),

    /**
     * Psychiatric Hospital
     * 
     */
    @XmlEnumValue("Psychiatric Hospital")
    PSYCHIATRIC_HOSPITAL("Psychiatric Hospital"),

    /**
     * Residential Substance Abuse Treatment Center
     * 
     */
    RSA("RSA"),

    /**
     * Residential Treatment Center
     * 
     */
    RTC("RTC"),

    /**
     * Therapeutic Foster Home
     * 
     */
    TFH("TFH");
    private final String value;

    PlacementLocationCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlacementLocationCodeSimpleType fromValue(String v) {
        for (PlacementLocationCodeSimpleType c: PlacementLocationCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
