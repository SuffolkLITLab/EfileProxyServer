
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecificationIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for PromotionalSpecificationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PromotionalSpecificationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecificationID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PromotionalEventLineItem" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EventTactic" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PromotionalSpecificationType", propOrder = {
    "specificationID",
    "promotionalEventLineItem",
    "eventTactic"
})
public class PromotionalSpecificationType {

    @XmlElement(name = "SpecificationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecificationIDType specificationID;
    @XmlElement(name = "PromotionalEventLineItem", required = true)
    protected List<PromotionalEventLineItemType> promotionalEventLineItem;
    @XmlElement(name = "EventTactic")
    protected List<EventTacticType> eventTactic;

    /**
     * Gets the value of the specificationID property.
     * 
     * @return
     *     possible object is
     *     {@link SpecificationIDType }
     *     
     */
    public SpecificationIDType getSpecificationID() {
        return specificationID;
    }

    /**
     * Sets the value of the specificationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecificationIDType }
     *     
     */
    public void setSpecificationID(SpecificationIDType value) {
        this.specificationID = value;
    }

    /**
     * Gets the value of the promotionalEventLineItem property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the promotionalEventLineItem property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPromotionalEventLineItem().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionalEventLineItemType }
     * 
     * 
     */
    public List<PromotionalEventLineItemType> getPromotionalEventLineItem() {
        if (promotionalEventLineItem == null) {
            promotionalEventLineItem = new ArrayList<PromotionalEventLineItemType>();
        }
        return this.promotionalEventLineItem;
    }

    /**
     * Gets the value of the eventTactic property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the eventTactic property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getEventTactic().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link EventTacticType }
     * 
     * 
     */
    public List<EventTacticType> getEventTactic() {
        if (eventTactic == null) {
            eventTactic = new ArrayList<EventTacticType>();
        }
        return this.eventTactic;
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
