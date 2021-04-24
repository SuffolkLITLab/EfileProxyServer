
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualPickupDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualPickupTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EarliestPickupDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EarliestPickupTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestPickupDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestPickupTimeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for PickupType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PickupType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualPickupDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualPickupTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EarliestPickupDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EarliestPickupTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestPickupDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestPickupTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PickupLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PickupParty" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PickupType", propOrder = {
    "id",
    "actualPickupDate",
    "actualPickupTime",
    "earliestPickupDate",
    "earliestPickupTime",
    "latestPickupDate",
    "latestPickupTime",
    "pickupLocation",
    "pickupParty"
})
public class PickupType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "ActualPickupDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualPickupDateType actualPickupDate;
    @XmlElement(name = "ActualPickupTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualPickupTimeType actualPickupTime;
    @XmlElement(name = "EarliestPickupDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EarliestPickupDateType earliestPickupDate;
    @XmlElement(name = "EarliestPickupTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EarliestPickupTimeType earliestPickupTime;
    @XmlElement(name = "LatestPickupDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestPickupDateType latestPickupDate;
    @XmlElement(name = "LatestPickupTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestPickupTimeType latestPickupTime;
    @XmlElement(name = "PickupLocation")
    protected LocationType pickupLocation;
    @XmlElement(name = "PickupParty")
    protected PartyType pickupParty;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the actualPickupDate property.
     * 
     * @return
     *     possible object is
     *     {@link ActualPickupDateType }
     *     
     */
    public ActualPickupDateType getActualPickupDate() {
        return actualPickupDate;
    }

    /**
     * Sets the value of the actualPickupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualPickupDateType }
     *     
     */
    public void setActualPickupDate(ActualPickupDateType value) {
        this.actualPickupDate = value;
    }

    /**
     * Gets the value of the actualPickupTime property.
     * 
     * @return
     *     possible object is
     *     {@link ActualPickupTimeType }
     *     
     */
    public ActualPickupTimeType getActualPickupTime() {
        return actualPickupTime;
    }

    /**
     * Sets the value of the actualPickupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualPickupTimeType }
     *     
     */
    public void setActualPickupTime(ActualPickupTimeType value) {
        this.actualPickupTime = value;
    }

    /**
     * Gets the value of the earliestPickupDate property.
     * 
     * @return
     *     possible object is
     *     {@link EarliestPickupDateType }
     *     
     */
    public EarliestPickupDateType getEarliestPickupDate() {
        return earliestPickupDate;
    }

    /**
     * Sets the value of the earliestPickupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarliestPickupDateType }
     *     
     */
    public void setEarliestPickupDate(EarliestPickupDateType value) {
        this.earliestPickupDate = value;
    }

    /**
     * Gets the value of the earliestPickupTime property.
     * 
     * @return
     *     possible object is
     *     {@link EarliestPickupTimeType }
     *     
     */
    public EarliestPickupTimeType getEarliestPickupTime() {
        return earliestPickupTime;
    }

    /**
     * Sets the value of the earliestPickupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EarliestPickupTimeType }
     *     
     */
    public void setEarliestPickupTime(EarliestPickupTimeType value) {
        this.earliestPickupTime = value;
    }

    /**
     * Gets the value of the latestPickupDate property.
     * 
     * @return
     *     possible object is
     *     {@link LatestPickupDateType }
     *     
     */
    public LatestPickupDateType getLatestPickupDate() {
        return latestPickupDate;
    }

    /**
     * Sets the value of the latestPickupDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestPickupDateType }
     *     
     */
    public void setLatestPickupDate(LatestPickupDateType value) {
        this.latestPickupDate = value;
    }

    /**
     * Gets the value of the latestPickupTime property.
     * 
     * @return
     *     possible object is
     *     {@link LatestPickupTimeType }
     *     
     */
    public LatestPickupTimeType getLatestPickupTime() {
        return latestPickupTime;
    }

    /**
     * Sets the value of the latestPickupTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestPickupTimeType }
     *     
     */
    public void setLatestPickupTime(LatestPickupTimeType value) {
        this.latestPickupTime = value;
    }

    /**
     * Gets the value of the pickupLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getPickupLocation() {
        return pickupLocation;
    }

    /**
     * Sets the value of the pickupLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setPickupLocation(LocationType value) {
        this.pickupLocation = value;
    }

    /**
     * Gets the value of the pickupParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPickupParty() {
        return pickupParty;
    }

    /**
     * Sets the value of the pickupParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPickupParty(PartyType value) {
        this.pickupParty = value;
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
