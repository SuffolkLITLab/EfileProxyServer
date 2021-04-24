
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstShipmentAvailibilityDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestProposalAcceptanceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PromotionalEventTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubmissionDateType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for PromotionalEventType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PromotionalEventType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PromotionalEventTypeCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubmissionDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FirstShipmentAvailibilityDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestProposalAcceptanceDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PromotionalSpecification" maxOccurs="unbounded"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromotionalEventType", propOrder = {
    "promotionalEventTypeCode",
    "submissionDate",
    "firstShipmentAvailibilityDate",
    "latestProposalAcceptanceDate",
    "promotionalSpecification"
})
public class PromotionalEventType {

    @XmlElement(name = "PromotionalEventTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PromotionalEventTypeCodeType promotionalEventTypeCode;
    @XmlElement(name = "SubmissionDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubmissionDateType submissionDate;
    @XmlElement(name = "FirstShipmentAvailibilityDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FirstShipmentAvailibilityDateType firstShipmentAvailibilityDate;
    @XmlElement(name = "LatestProposalAcceptanceDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestProposalAcceptanceDateType latestProposalAcceptanceDate;
    @XmlElement(name = "PromotionalSpecification", required = true)
    protected List<PromotionalSpecificationType> promotionalSpecification;

    /**
     * Gets the value of the promotionalEventTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link PromotionalEventTypeCodeType }
     *     
     */
    public PromotionalEventTypeCodeType getPromotionalEventTypeCode() {
        return promotionalEventTypeCode;
    }

    /**
     * Sets the value of the promotionalEventTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PromotionalEventTypeCodeType }
     *     
     */
    public void setPromotionalEventTypeCode(PromotionalEventTypeCodeType value) {
        this.promotionalEventTypeCode = value;
    }

    /**
     * Gets the value of the submissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link SubmissionDateType }
     *     
     */
    public SubmissionDateType getSubmissionDate() {
        return submissionDate;
    }

    /**
     * Sets the value of the submissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmissionDateType }
     *     
     */
    public void setSubmissionDate(SubmissionDateType value) {
        this.submissionDate = value;
    }

    /**
     * Gets the value of the firstShipmentAvailibilityDate property.
     * 
     * @return
     *     possible object is
     *     {@link FirstShipmentAvailibilityDateType }
     *     
     */
    public FirstShipmentAvailibilityDateType getFirstShipmentAvailibilityDate() {
        return firstShipmentAvailibilityDate;
    }

    /**
     * Sets the value of the firstShipmentAvailibilityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirstShipmentAvailibilityDateType }
     *     
     */
    public void setFirstShipmentAvailibilityDate(FirstShipmentAvailibilityDateType value) {
        this.firstShipmentAvailibilityDate = value;
    }

    /**
     * Gets the value of the latestProposalAcceptanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link LatestProposalAcceptanceDateType }
     *     
     */
    public LatestProposalAcceptanceDateType getLatestProposalAcceptanceDate() {
        return latestProposalAcceptanceDate;
    }

    /**
     * Sets the value of the latestProposalAcceptanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestProposalAcceptanceDateType }
     *     
     */
    public void setLatestProposalAcceptanceDate(LatestProposalAcceptanceDateType value) {
        this.latestProposalAcceptanceDate = value;
    }

    /**
     * Gets the value of the promotionalSpecification property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the promotionalSpecification property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPromotionalSpecification().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionalSpecificationType }
     * 
     * 
     */
    public List<PromotionalSpecificationType> getPromotionalSpecification() {
        if (promotionalSpecification == null) {
            promotionalSpecification = new ArrayList<PromotionalSpecificationType>();
        }
        return this.promotionalSpecification;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
