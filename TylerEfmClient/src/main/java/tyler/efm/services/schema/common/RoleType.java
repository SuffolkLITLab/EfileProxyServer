
package tyler.efm.services.schema.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="RoleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FirmAdmin"/&gt;
 *     &lt;enumeration value="Filer"/&gt;
 *     &lt;enumeration value="CriminalFilingFirmAdmin"/&gt;
 *     &lt;enumeration value="CriminalFilingFiler"/&gt;
 *     &lt;enumeration value="SiteAdmin"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RoleType")
@XmlEnum
public enum RoleType {

    @XmlEnumValue("FirmAdmin")
    FIRM_ADMIN("FirmAdmin"),
    @XmlEnumValue("Filer")
    FILER("Filer"),
    @XmlEnumValue("CriminalFilingFirmAdmin")
    CRIMINAL_FILING_FIRM_ADMIN("CriminalFilingFirmAdmin"),
    @XmlEnumValue("CriminalFilingFiler")
    CRIMINAL_FILING_FILER("CriminalFilingFiler"),
    @XmlEnumValue("SiteAdmin")
    SITE_ADMIN("SiteAdmin");
    private final String value;

    RoleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleType fromValue(String v) {
        for (RoleType c: RoleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
