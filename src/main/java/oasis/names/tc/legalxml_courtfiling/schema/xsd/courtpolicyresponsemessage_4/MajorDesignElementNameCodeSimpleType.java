
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for MajorDesignElementNameCodeSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="MajorDesignElementNameCodeSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&amp;gt;
 *     &amp;lt;enumeration value="CourtRecord"/&amp;gt;
 *     &amp;lt;enumeration value="FilingAssembly"/&amp;gt;
 *     &amp;lt;enumeration value="FilingReview"/&amp;gt;
 *     &amp;lt;enumeration value="Service"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "MajorDesignElementNameCodeSimpleType")
@XmlEnum
public enum MajorDesignElementNameCodeSimpleType {


    /**
     * CourtRecord MDE
     * 
     */
    @XmlEnumValue("CourtRecord")
    COURT_RECORD("CourtRecord"),

    /**
     * FilingAssembly MDE
     * 
     */
    @XmlEnumValue("FilingAssembly")
    FILING_ASSEMBLY("FilingAssembly"),

    /**
     * FilingReview MDE
     * 
     */
    @XmlEnumValue("FilingReview")
    FILING_REVIEW("FilingReview"),

    /**
     * Service MDE
     * 
     */
    @XmlEnumValue("Service")
    SERVICE("Service");
    private final String value;

    MajorDesignElementNameCodeSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MajorDesignElementNameCodeSimpleType fromValue(String v) {
        for (MajorDesignElementNameCodeSimpleType c: MajorDesignElementNameCodeSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
