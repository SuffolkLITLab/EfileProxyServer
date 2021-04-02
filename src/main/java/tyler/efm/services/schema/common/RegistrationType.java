
package tyler.efm.services.schema.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for RegistrationType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="RegistrationType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="FirmAdministrator"/&amp;gt;
 *     &amp;lt;enumeration value="FirmAdminNewMember"/&amp;gt;
 *     &amp;lt;enumeration value="Individual"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "RegistrationType")
@XmlEnum
public enum RegistrationType {

    @XmlEnumValue("FirmAdministrator")
    FIRM_ADMINISTRATOR("FirmAdministrator"),
    @XmlEnumValue("FirmAdminNewMember")
    FIRM_ADMIN_NEW_MEMBER("FirmAdminNewMember"),
    @XmlEnumValue("Individual")
    INDIVIDUAL("Individual");
    private final String value;

    RegistrationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RegistrationType fromValue(String v) {
        for (RegistrationType c: RegistrationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
