
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for DocumentSecurityType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="DocumentSecurityType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="PublicView"/&amp;gt;
 *     &amp;lt;enumeration value="PrivateView"/&amp;gt;
 *     &amp;lt;enumeration value="Sealed"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
