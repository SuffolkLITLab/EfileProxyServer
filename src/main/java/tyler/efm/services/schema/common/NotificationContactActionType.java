
package tyler.efm.services.schema.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NotificationContactActionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="NotificationContactActionType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AddUpdate"/&gt;
 *     &lt;enumeration value="Remove"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "NotificationContactActionType")
@XmlEnum
public enum NotificationContactActionType {

    @XmlEnumValue("AddUpdate")
    ADD_UPDATE("AddUpdate"),
    @XmlEnumValue("Remove")
    REMOVE("Remove");
    private final String value;

    NotificationContactActionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NotificationContactActionType fromValue(String v) {
        for (NotificationContactActionType c: NotificationContactActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
