
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConditionDeviationIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimeDeviationIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TransportStatusType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TransportStatusType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimeDeviationIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConditionDeviationIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UpdatedDelivery" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UpdatedDespatch" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}StatusLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReferencedTransportHandlingUnit" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportStatusType", propOrder = {
    "timeDeviationIndicator",
    "conditionDeviationIndicator",
    "updatedDelivery",
    "updatedDespatch",
    "statusLocation",
    "referencedTransportHandlingUnit"
})
public class TransportStatusType {

    @XmlElement(name = "TimeDeviationIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TimeDeviationIndicatorType timeDeviationIndicator;
    @XmlElement(name = "ConditionDeviationIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ConditionDeviationIndicatorType conditionDeviationIndicator;
    @XmlElement(name = "UpdatedDelivery")
    protected DeliveryType updatedDelivery;
    @XmlElement(name = "UpdatedDespatch")
    protected DespatchType updatedDespatch;
    @XmlElement(name = "StatusLocation")
    protected LocationType statusLocation;
    @XmlElement(name = "ReferencedTransportHandlingUnit")
    protected List<TransportHandlingUnitType> referencedTransportHandlingUnit;

    /**
     * Gets the value of the timeDeviationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link TimeDeviationIndicatorType }
     *     
     */
    public TimeDeviationIndicatorType getTimeDeviationIndicator() {
        return timeDeviationIndicator;
    }

    /**
     * Sets the value of the timeDeviationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeDeviationIndicatorType }
     *     
     */
    public void setTimeDeviationIndicator(TimeDeviationIndicatorType value) {
        this.timeDeviationIndicator = value;
    }

    /**
     * Gets the value of the conditionDeviationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionDeviationIndicatorType }
     *     
     */
    public ConditionDeviationIndicatorType getConditionDeviationIndicator() {
        return conditionDeviationIndicator;
    }

    /**
     * Sets the value of the conditionDeviationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionDeviationIndicatorType }
     *     
     */
    public void setConditionDeviationIndicator(ConditionDeviationIndicatorType value) {
        this.conditionDeviationIndicator = value;
    }

    /**
     * Gets the value of the updatedDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryType }
     *     
     */
    public DeliveryType getUpdatedDelivery() {
        return updatedDelivery;
    }

    /**
     * Sets the value of the updatedDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryType }
     *     
     */
    public void setUpdatedDelivery(DeliveryType value) {
        this.updatedDelivery = value;
    }

    /**
     * Gets the value of the updatedDespatch property.
     * 
     * @return
     *     possible object is
     *     {@link DespatchType }
     *     
     */
    public DespatchType getUpdatedDespatch() {
        return updatedDespatch;
    }

    /**
     * Sets the value of the updatedDespatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link DespatchType }
     *     
     */
    public void setUpdatedDespatch(DespatchType value) {
        this.updatedDespatch = value;
    }

    /**
     * Gets the value of the statusLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getStatusLocation() {
        return statusLocation;
    }

    /**
     * Sets the value of the statusLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setStatusLocation(LocationType value) {
        this.statusLocation = value;
    }

    /**
     * Gets the value of the referencedTransportHandlingUnit property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the referencedTransportHandlingUnit property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getReferencedTransportHandlingUnit().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportHandlingUnitType }
     * 
     * 
     */
    public List<TransportHandlingUnitType> getReferencedTransportHandlingUnit() {
        if (referencedTransportHandlingUnit == null) {
            referencedTransportHandlingUnit = new ArrayList<TransportHandlingUnitType>();
        }
        return this.referencedTransportHandlingUnit;
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
