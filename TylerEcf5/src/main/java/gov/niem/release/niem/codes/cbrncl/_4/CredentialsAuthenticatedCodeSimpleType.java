
package gov.niem.release.niem.codes.cbrncl._4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CredentialsAuthenticatedCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CredentialsAuthenticatedCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="Authenticated"/&gt;
 *     &lt;enumeration value="Not Authenticated"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CredentialsAuthenticatedCodeSimpleType")
@XmlEnum
public enum CredentialsAuthenticatedCodeSimpleType {


    /**
     * The credentials have been authenticated.
     * 
     */
    @XmlEnumValue("Authenticated")
    AUTHENTICATED("Authenticated"),

    /**
     * The credentials have not been authenticated.
     * 
     */
    @XmlEnumValue("Not Authenticated")
    NOT_AUTHENTICATED("Not Authenticated");
    private final String value;

    CredentialsAuthenticatedCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CredentialsAuthenticatedCodeSimpleType fromValue(String v) {
        for (CredentialsAuthenticatedCodeSimpleType c: CredentialsAuthenticatedCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
