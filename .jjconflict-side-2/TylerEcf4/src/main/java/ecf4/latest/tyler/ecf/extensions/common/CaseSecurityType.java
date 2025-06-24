
package ecf4.latest.tyler.ecf.extensions.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaseSecurityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CaseSecurityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="PublicFilingPrivateView"/&gt;
 *     &lt;enumeration value="PublicFilingPublicView"/&gt;
 *     &lt;enumeration value="PrivateFilingPrivateView"/&gt;
 *     &lt;enumeration value="PrivateFilingPublicView"/&gt;
 *     &lt;enumeration value="Sealed"/&gt;
 *     &lt;enumeration value="Expunged"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
