
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineNumberNumericType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for EventLineItemType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="EventLineItemType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineNumberNumeric" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ParticipatingLocationsLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RetailPlannedImpact" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupplyItem"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventLineItemType", propOrder = {
    "lineNumberNumeric",
    "participatingLocationsLocation",
    "retailPlannedImpact",
    "supplyItem"
})
public class EventLineItemType {

    @XmlElement(name = "LineNumberNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineNumberNumericType lineNumberNumeric;
    @XmlElement(name = "ParticipatingLocationsLocation")
    protected LocationType participatingLocationsLocation;
    @XmlElement(name = "RetailPlannedImpact")
    protected List<RetailPlannedImpactType> retailPlannedImpact;
    @XmlElement(name = "SupplyItem", required = true)
    protected ItemType supplyItem;

    /**
     * Gets the value of the lineNumberNumeric property.
     * 
     * @return
     *     possible object is
     *     {@link LineNumberNumericType }
     *     
     */
    public LineNumberNumericType getLineNumberNumeric() {
        return lineNumberNumeric;
    }

    /**
     * Sets the value of the lineNumberNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineNumberNumericType }
     *     
     */
    public void setLineNumberNumeric(LineNumberNumericType value) {
        this.lineNumberNumeric = value;
    }

    /**
     * Gets the value of the participatingLocationsLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getParticipatingLocationsLocation() {
        return participatingLocationsLocation;
    }

    /**
     * Sets the value of the participatingLocationsLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setParticipatingLocationsLocation(LocationType value) {
        this.participatingLocationsLocation = value;
    }

    /**
     * Gets the value of the retailPlannedImpact property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the retailPlannedImpact property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRetailPlannedImpact().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link RetailPlannedImpactType }
     * 
     * 
     */
    public List<RetailPlannedImpactType> getRetailPlannedImpact() {
        if (retailPlannedImpact == null) {
            retailPlannedImpact = new ArrayList<RetailPlannedImpactType>();
        }
        return this.retailPlannedImpact;
    }

    /**
     * Gets the value of the supplyItem property.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getSupplyItem() {
        return supplyItem;
    }

    /**
     * Sets the value of the supplyItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setSupplyItem(ItemType value) {
        this.supplyItem = value;
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
