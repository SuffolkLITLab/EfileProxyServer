
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MajorDesignElementNameCodeSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="MajorDesignElementNameCodeSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *     &lt;enumeration value="CourtRecord"/&gt;
 *     &lt;enumeration value="FilingAssembly"/&gt;
 *     &lt;enumeration value="FilingReview"/&gt;
 *     &lt;enumeration value="Service"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
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
