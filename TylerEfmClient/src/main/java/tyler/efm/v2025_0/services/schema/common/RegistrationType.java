
package tyler.efm.v2025_0.services.schema.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistrationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="RegistrationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FirmAdministrator"/&gt;
 *     &lt;enumeration value="FirmAdminNewMember"/&gt;
 *     &lt;enumeration value="Individual"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
