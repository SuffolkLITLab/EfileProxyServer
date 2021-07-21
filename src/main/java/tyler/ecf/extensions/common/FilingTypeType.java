
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilingTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="FilingTypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="EFile"/&gt;
 *     &lt;enumeration value="EFileAndServe"/&gt;
 *     &lt;enumeration value="Serve"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "FilingTypeType")
@XmlEnum
public enum FilingTypeType {


    /**
     * EFile Only
     * 
     */
    @XmlEnumValue("EFile")
    E_FILE("EFile"),

    /**
     * EFile and Serve
     * 
     */
    @XmlEnumValue("EFileAndServe")
    E_FILE_AND_SERVE("EFileAndServe"),

    /**
     * Service Only
     * 
     */
    @XmlEnumValue("Serve")
    SERVE("Serve");
    private final String value;

    FilingTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilingTypeType fromValue(String v) {
        for (FilingTypeType c: FilingTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
