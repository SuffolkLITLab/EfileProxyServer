
package oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4;

import gov.niem.niem.niem_core._2.DocumentType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A court's response to a FilingListQueryMessage.
 * 
 * <p>Java class for MatchingFilingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchingFilingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingStatus"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchingFilingType", propOrder = {
    "caseTrackingID",
    "filingStatus"
})
public class MatchingFilingType
    extends DocumentType
{

    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElement(name = "FilingStatus", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected FilingStatusType filingStatus;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the filingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatusType }
     *     
     */
    public FilingStatusType getFilingStatus() {
        return filingStatus;
    }

    /**
     * Sets the value of the filingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatusType }
     *     
     */
    public void setFilingStatus(FilingStatusType value) {
        this.filingStatus = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
