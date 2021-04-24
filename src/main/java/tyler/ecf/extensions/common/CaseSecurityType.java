
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for CaseSecurityType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="CaseSecurityType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="PublicFilingPrivateView"/&amp;gt;
 *     &amp;lt;enumeration value="PublicFilingPublicView"/&amp;gt;
 *     &amp;lt;enumeration value="PrivateFilingPrivateView"/&amp;gt;
 *     &amp;lt;enumeration value="PrivateFilingPublicView"/&amp;gt;
 *     &amp;lt;enumeration value="Sealed"/&amp;gt;
 *     &amp;lt;enumeration value="Expunged"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "CaseSecurityType")
@XmlEnum
public enum CaseSecurityType {

    @XmlEnumValue("PublicFilingPrivateView")
    PUBLIC_FILING_PRIVATE_VIEW("PublicFilingPrivateView"),
    @XmlEnumValue("PublicFilingPublicView")
    PUBLIC_FILING_PUBLIC_VIEW("PublicFilingPublicView"),
    @XmlEnumValue("PrivateFilingPrivateView")
    PRIVATE_FILING_PRIVATE_VIEW("PrivateFilingPrivateView"),
    @XmlEnumValue("PrivateFilingPublicView")
    PRIVATE_FILING_PUBLIC_VIEW("PrivateFilingPublicView"),
    @XmlEnumValue("Sealed")
    SEALED("Sealed"),
    @XmlEnumValue("Expunged")
    EXPUNGED("Expunged");
    private final String value;

    CaseSecurityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CaseSecurityType fromValue(String v) {
        for (CaseSecurityType c: CaseSecurityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
