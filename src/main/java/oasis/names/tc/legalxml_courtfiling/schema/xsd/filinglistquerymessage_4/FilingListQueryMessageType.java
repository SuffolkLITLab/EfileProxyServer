
package oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateRangeType;
import gov.niem.niem.niem_core._2.EntityType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * This is query to get a list of filings by Filer Identification, Case ID, and/or time period.
 * 
 * &lt;p&gt;Java class for FilingListQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FilingListQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentSubmitter" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DateRange" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingListQueryMessageType", propOrder = {
    "caseTrackingID",
    "documentSubmitter",
    "dateRange"
})
public class FilingListQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElement(name = "DocumentSubmitter", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected EntityType documentSubmitter;
    @XmlElement(name = "DateRange", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<DateRangeType> dateRange;

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
     * Gets the value of the documentSubmitter property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getDocumentSubmitter() {
        return documentSubmitter;
    }

    /**
     * Sets the value of the documentSubmitter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setDocumentSubmitter(EntityType value) {
        this.documentSubmitter = value;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the dateRange property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDateRange().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DateRangeType }
     * 
     * 
     */
    public List<DateRangeType> getDateRange() {
        if (dateRange == null) {
            dateRange = new ArrayList<DateRangeType>();
        }
        return this.dateRange;
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
