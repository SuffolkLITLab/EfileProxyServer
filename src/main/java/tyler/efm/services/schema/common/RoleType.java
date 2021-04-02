
package tyler.efm.services.schema.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RoleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="RoleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="FirmAdmin"/&amp;gt;
 *     &amp;lt;enumeration value="Filer"/&amp;gt;
 *     &amp;lt;enumeration value="CriminalFilingFirmAdmin"/&amp;gt;
 *     &amp;lt;enumeration value="CriminalFilingFiler"/&amp;gt;
 *     &amp;lt;enumeration value="SiteAdmin"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
