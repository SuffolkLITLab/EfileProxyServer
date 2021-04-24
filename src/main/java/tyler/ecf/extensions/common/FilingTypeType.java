
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for FilingTypeType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="FilingTypeType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *     &amp;lt;enumeration value="EFile"/&amp;gt;
 *     &amp;lt;enumeration value="EFileAndServe"/&amp;gt;
 *     &amp;lt;enumeration value="Serve"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
