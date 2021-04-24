
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrozenPeriodDaysNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumInventoryQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MultipleOrderQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderIntervalDaysNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReplenishmentOwnerDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetInventoryQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetServicePercentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ItemManagementProfileType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ItemManagementProfileType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FrozenPeriodDaysNumeric" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumInventoryQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MultipleOrderQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OrderIntervalDaysNumeric" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReplenishmentOwnerDescription" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetServicePercent" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetInventoryQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EffectivePeriod"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Item"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemLocationQuantity" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemManagementProfileType", propOrder = {
    "frozenPeriodDaysNumeric",
    "minimumInventoryQuantity",
    "multipleOrderQuantity",
    "orderIntervalDaysNumeric",
    "replenishmentOwnerDescription",
    "targetServicePercent",
    "targetInventoryQuantity",
    "effectivePeriod",
    "item",
    "itemLocationQuantity"
})
public class ItemManagementProfileType {

    @XmlElement(name = "FrozenPeriodDaysNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FrozenPeriodDaysNumericType frozenPeriodDaysNumeric;
    @XmlElement(name = "MinimumInventoryQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumInventoryQuantityType minimumInventoryQuantity;
    @XmlElement(name = "MultipleOrderQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MultipleOrderQuantityType multipleOrderQuantity;
    @XmlElement(name = "OrderIntervalDaysNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OrderIntervalDaysNumericType orderIntervalDaysNumeric;
    @XmlElement(name = "ReplenishmentOwnerDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReplenishmentOwnerDescriptionType replenishmentOwnerDescription;
    @XmlElement(name = "TargetServicePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TargetServicePercentType targetServicePercent;
    @XmlElement(name = "TargetInventoryQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TargetInventoryQuantityType targetInventoryQuantity;
    @XmlElement(name = "EffectivePeriod", required = true)
    protected PeriodType effectivePeriod;
    @XmlElement(name = "Item", required = true)
    protected ItemType item;
    @XmlElement(name = "ItemLocationQuantity")
    protected ItemLocationQuantityType itemLocationQuantity;

    /**
     * Gets the value of the frozenPeriodDaysNumeric property.
     * 
     * @return
     *     possible object is
     *     {@link FrozenPeriodDaysNumericType }
     *     
     */
    public FrozenPeriodDaysNumericType getFrozenPeriodDaysNumeric() {
        return frozenPeriodDaysNumeric;
    }

    /**
     * Sets the value of the frozenPeriodDaysNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link FrozenPeriodDaysNumericType }
     *     
     */
    public void setFrozenPeriodDaysNumeric(FrozenPeriodDaysNumericType value) {
        this.frozenPeriodDaysNumeric = value;
    }

    /**
     * Gets the value of the minimumInventoryQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link MinimumInventoryQuantityType }
     *     
     */
    public MinimumInventoryQuantityType getMinimumInventoryQuantity() {
        return minimumInventoryQuantity;
    }

    /**
     * Sets the value of the minimumInventoryQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumInventoryQuantityType }
     *     
     */
    public void setMinimumInventoryQuantity(MinimumInventoryQuantityType value) {
        this.minimumInventoryQuantity = value;
    }

    /**
     * Gets the value of the multipleOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link MultipleOrderQuantityType }
     *     
     */
    public MultipleOrderQuantityType getMultipleOrderQuantity() {
        return multipleOrderQuantity;
    }

    /**
     * Sets the value of the multipleOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleOrderQuantityType }
     *     
     */
    public void setMultipleOrderQuantity(MultipleOrderQuantityType value) {
        this.multipleOrderQuantity = value;
    }

    /**
     * Gets the value of the orderIntervalDaysNumeric property.
     * 
     * @return
     *     possible object is
     *     {@link OrderIntervalDaysNumericType }
     *     
     */
    public OrderIntervalDaysNumericType getOrderIntervalDaysNumeric() {
        return orderIntervalDaysNumeric;
    }

    /**
     * Sets the value of the orderIntervalDaysNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderIntervalDaysNumericType }
     *     
     */
    public void setOrderIntervalDaysNumeric(OrderIntervalDaysNumericType value) {
        this.orderIntervalDaysNumeric = value;
    }

    /**
     * Gets the value of the replenishmentOwnerDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ReplenishmentOwnerDescriptionType }
     *     
     */
    public ReplenishmentOwnerDescriptionType getReplenishmentOwnerDescription() {
        return replenishmentOwnerDescription;
    }

    /**
     * Sets the value of the replenishmentOwnerDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplenishmentOwnerDescriptionType }
     *     
     */
    public void setReplenishmentOwnerDescription(ReplenishmentOwnerDescriptionType value) {
        this.replenishmentOwnerDescription = value;
    }

    /**
     * Gets the value of the targetServicePercent property.
     * 
     * @return
     *     possible object is
     *     {@link TargetServicePercentType }
     *     
     */
    public TargetServicePercentType getTargetServicePercent() {
        return targetServicePercent;
    }

    /**
     * Sets the value of the targetServicePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetServicePercentType }
     *     
     */
    public void setTargetServicePercent(TargetServicePercentType value) {
        this.targetServicePercent = value;
    }

    /**
     * Gets the value of the targetInventoryQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link TargetInventoryQuantityType }
     *     
     */
    public TargetInventoryQuantityType getTargetInventoryQuantity() {
        return targetInventoryQuantity;
    }

    /**
     * Sets the value of the targetInventoryQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetInventoryQuantityType }
     *     
     */
    public void setTargetInventoryQuantity(TargetInventoryQuantityType value) {
        this.targetInventoryQuantity = value;
    }

    /**
     * Gets the value of the effectivePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Sets the value of the effectivePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEffectivePeriod(PeriodType value) {
        this.effectivePeriod = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setItem(ItemType value) {
        this.item = value;
    }

    /**
     * Gets the value of the itemLocationQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ItemLocationQuantityType }
     *     
     */
    public ItemLocationQuantityType getItemLocationQuantity() {
        return itemLocationQuantity;
    }

    /**
     * Sets the value of the itemLocationQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemLocationQuantityType }
     *     
     */
    public void setItemLocationQuantity(ItemLocationQuantityType value) {
        this.itemLocationQuantity = value;
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
