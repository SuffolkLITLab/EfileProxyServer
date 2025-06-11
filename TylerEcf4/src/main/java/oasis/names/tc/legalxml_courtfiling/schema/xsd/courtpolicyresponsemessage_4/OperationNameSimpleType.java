
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OperationNameSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="OperationNameSimpleType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *     &lt;enumeration value="GetFeesCalculation"/&gt;
 *     &lt;enumeration value="GetCase"/&gt;
 *     &lt;enumeration value="GetCaseList"/&gt;
 *     &lt;enumeration value="GetDocument"/&gt;
 *     &lt;enumeration value="GetFilingList"/&gt;
 *     &lt;enumeration value="GetFilingStatus"/&gt;
 *     &lt;enumeration value="GetPolicy"/&gt;
 *     &lt;enumeration value="GetServiceInformation"/&gt;
 *     &lt;enumeration value="NotifyFilingReview"/&gt;
 *     &lt;enumeration value="NotifyDocketing"/&gt;
 *     &lt;enumeration value="RecordFiling"/&gt;
 *     &lt;enumeration value="ReviewFiling"/&gt;
 *     &lt;enumeration value="ServeFiling"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "OperationNameSimpleType")
@XmlEnum
public enum OperationNameSimpleType {


    /**
     * GetFeesCalculation query
     * 
     */
    @XmlEnumValue("GetFeesCalculation")
    GET_FEES_CALCULATION("GetFeesCalculation"),

    /**
     * GetCase query
     * 
     */
    @XmlEnumValue("GetCase")
    GET_CASE("GetCase"),

    /**
     * GetFeesCaseList query
     * 
     */
    @XmlEnumValue("GetCaseList")
    GET_CASE_LIST("GetCaseList"),

    /**
     * GetDocument query
     * 
     */
    @XmlEnumValue("GetDocument")
    GET_DOCUMENT("GetDocument"),

    /**
     * GetFilingList query
     * 
     */
    @XmlEnumValue("GetFilingList")
    GET_FILING_LIST("GetFilingList"),

    /**
     * GetFilingStatus query
     * 
     */
    @XmlEnumValue("GetFilingStatus")
    GET_FILING_STATUS("GetFilingStatus"),

    /**
     * GetPolicy query
     * 
     */
    @XmlEnumValue("GetPolicy")
    GET_POLICY("GetPolicy"),

    /**
     * GetServiceInformation query
     * 
     */
    @XmlEnumValue("GetServiceInformation")
    GET_SERVICE_INFORMATION("GetServiceInformation"),

    /**
     * NotifyFilingReview message
     * 
     */
    @XmlEnumValue("NotifyFilingReview")
    NOTIFY_FILING_REVIEW("NotifyFilingReview"),

    /**
     * NotifyDocketing message
     * 
     */
    @XmlEnumValue("NotifyDocketing")
    NOTIFY_DOCKETING("NotifyDocketing"),

    /**
     * RecordFiling message
     * 
     */
    @XmlEnumValue("RecordFiling")
    RECORD_FILING("RecordFiling"),

    /**
     * ReviewFiling message
     * 
     */
    @XmlEnumValue("ReviewFiling")
    REVIEW_FILING("ReviewFiling"),

    /**
     * ServeFiling message
     * 
     */
    @XmlEnumValue("ServeFiling")
    SERVE_FILING("ServeFiling");
    private final String value;

    OperationNameSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OperationNameSimpleType fromValue(String v) {
        for (OperationNameSimpleType c: OperationNameSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
