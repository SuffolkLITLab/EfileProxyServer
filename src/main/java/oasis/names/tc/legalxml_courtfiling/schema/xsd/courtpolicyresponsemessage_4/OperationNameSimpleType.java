
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for OperationNameSimpleType.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="OperationNameSimpleType"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&amp;gt;
 *     &amp;lt;enumeration value="GetFeesCalculation"/&amp;gt;
 *     &amp;lt;enumeration value="GetCase"/&amp;gt;
 *     &amp;lt;enumeration value="GetCaseList"/&amp;gt;
 *     &amp;lt;enumeration value="GetDocument"/&amp;gt;
 *     &amp;lt;enumeration value="GetFilingList"/&amp;gt;
 *     &amp;lt;enumeration value="GetFilingStatus"/&amp;gt;
 *     &amp;lt;enumeration value="GetPolicy"/&amp;gt;
 *     &amp;lt;enumeration value="GetServiceInformation"/&amp;gt;
 *     &amp;lt;enumeration value="NotifyFilingReview"/&amp;gt;
 *     &amp;lt;enumeration value="NotifyDocketing"/&amp;gt;
 *     &amp;lt;enumeration value="RecordFiling"/&amp;gt;
 *     &amp;lt;enumeration value="ReviewFiling"/&amp;gt;
 *     &amp;lt;enumeration value="ServeFiling"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
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
