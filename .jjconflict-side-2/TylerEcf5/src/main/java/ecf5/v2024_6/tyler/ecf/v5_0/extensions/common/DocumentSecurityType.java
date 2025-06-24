
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


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
