
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BatchQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumerUnitQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for DeliveryUnitType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DeliveryUnitType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BatchQuantity"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumerUnitQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousRiskIndicator" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryUnitType", propOrder = {
    "batchQuantity",
    "consumerUnitQuantity",
    "hazardousRiskIndicator"
})
public class DeliveryUnitType {

    @XmlElement(name = "BatchQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected BatchQuantityType batchQuantity;
    @XmlElement(name = "ConsumerUnitQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumerUnitQuantityType consumerUnitQuantity;
    @XmlElement(name = "HazardousRiskIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousRiskIndicatorType hazardousRiskIndicator;

    /**
     * Gets the value of the batchQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BatchQuantityType }
     *     
     */
    public BatchQuantityType getBatchQuantity() {
        return batchQuantity;
    }

    /**
     * Sets the value of the batchQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchQuantityType }
     *     
     */
    public void setBatchQuantity(BatchQuantityType value) {
        this.batchQuantity = value;
    }

    /**
     * Gets the value of the consumerUnitQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerUnitQuantityType }
     *     
     */
    public ConsumerUnitQuantityType getConsumerUnitQuantity() {
        return consumerUnitQuantity;
    }

    /**
     * Sets the value of the consumerUnitQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerUnitQuantityType }
     *     
     */
    public void setConsumerUnitQuantity(ConsumerUnitQuantityType value) {
        this.consumerUnitQuantity = value;
    }

    /**
     * Gets the value of the hazardousRiskIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public HazardousRiskIndicatorType getHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * Sets the value of the hazardousRiskIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public void setHazardousRiskIndicator(HazardousRiskIndicatorType value) {
        this.hazardousRiskIndicator = value;
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
