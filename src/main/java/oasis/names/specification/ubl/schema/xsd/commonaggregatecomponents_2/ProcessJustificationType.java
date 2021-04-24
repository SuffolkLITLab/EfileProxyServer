
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousCancellationReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcessReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcessReasonType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ProcessJustificationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ProcessJustificationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousCancellationReasonCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcessReasonCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcessReason" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessJustificationType", propOrder = {
    "previousCancellationReasonCode",
    "processReasonCode",
    "processReason",
    "description"
})
public class ProcessJustificationType {

    @XmlElement(name = "PreviousCancellationReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreviousCancellationReasonCodeType previousCancellationReasonCode;
    @XmlElement(name = "ProcessReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProcessReasonCodeType processReasonCode;
    @XmlElement(name = "ProcessReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ProcessReasonType> processReason;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;

    /**
     * Gets the value of the previousCancellationReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link PreviousCancellationReasonCodeType }
     *     
     */
    public PreviousCancellationReasonCodeType getPreviousCancellationReasonCode() {
        return previousCancellationReasonCode;
    }

    /**
     * Sets the value of the previousCancellationReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousCancellationReasonCodeType }
     *     
     */
    public void setPreviousCancellationReasonCode(PreviousCancellationReasonCodeType value) {
        this.previousCancellationReasonCode = value;
    }

    /**
     * Gets the value of the processReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessReasonCodeType }
     *     
     */
    public ProcessReasonCodeType getProcessReasonCode() {
        return processReasonCode;
    }

    /**
     * Sets the value of the processReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessReasonCodeType }
     *     
     */
    public void setProcessReasonCode(ProcessReasonCodeType value) {
        this.processReasonCode = value;
    }

    /**
     * Gets the value of the processReason property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the processReason property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getProcessReason().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessReasonType }
     * 
     * 
     */
    public List<ProcessReasonType> getProcessReason() {
        if (processReason == null) {
            processReason = new ArrayList<ProcessReasonType>();
        }
        return this.processReason;
    }

    /**
     * Gets the value of the description property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the description property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
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
