
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentSecurityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="DocumentSecurityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="PublicView"/&gt;
 *     &lt;enumeration value="PrivateView"/&gt;
 *     &lt;enumeration value="Sealed"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DocumentSecurityType")
@XmlEnum
public enum DocumentSecurityType {

    @XmlEnumValue("PublicView")
    PUBLIC_VIEW("PublicView"),
    @XmlEnumValue("PrivateView")
    PRIVATE_VIEW("PrivateView"),
    @XmlEnumValue("Sealed")
    SEALED("Sealed");
    private final String value;

    DocumentSecurityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DocumentSecurityType fromValue(String v) {
        for (DocumentSecurityType c: DocumentSecurityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
