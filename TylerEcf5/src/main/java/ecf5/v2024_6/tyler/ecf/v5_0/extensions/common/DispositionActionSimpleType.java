
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DispositionActionSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="DispositionActionSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="MOOT"/&gt;
 *     &lt;enumeration value="GRANTED"/&gt;
 *     &lt;enumeration value="DENIED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DispositionActionSimpleType")
@XmlEnum
public enum DispositionActionSimpleType {

    MOOT,
    GRANTED,
    DENIED;

    public String value() {
        return name();
    }

    public static DispositionActionSimpleType fromValue(String v) {
        return valueOf(v);
    }

}
