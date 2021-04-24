
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CurrentChargeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CurrentChargeTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OneTimeChargeTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OneTimeChargeTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackSizeNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberIDTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubscriberIDTypeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for UtilityItemType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="UtilityItemType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberIDType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SubscriberIDTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackSizeNumeric" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CurrentChargeType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CurrentChargeTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OneTimeChargeType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OneTimeChargeTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxCategory" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contract" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UtilityItemType", propOrder = {
    "id",
    "subscriberID",
    "subscriberIDType",
    "subscriberIDTypeCode",
    "description",
    "packQuantity",
    "packSizeNumeric",
    "consumptionType",
    "consumptionTypeCode",
    "currentChargeType",
    "currentChargeTypeCode",
    "oneTimeChargeType",
    "oneTimeChargeTypeCode",
    "taxCategory",
    "contract"
})
public class UtilityItemType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "SubscriberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberIDType subscriberID;
    @XmlElement(name = "SubscriberIDType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberIDTypeType subscriberIDType;
    @XmlElement(name = "SubscriberIDTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SubscriberIDTypeCodeType subscriberIDTypeCode;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "PackQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackQuantityType packQuantity;
    @XmlElement(name = "PackSizeNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackSizeNumericType packSizeNumeric;
    @XmlElement(name = "ConsumptionType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeType consumptionType;
    @XmlElement(name = "ConsumptionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionTypeCodeType consumptionTypeCode;
    @XmlElement(name = "CurrentChargeType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CurrentChargeTypeType currentChargeType;
    @XmlElement(name = "CurrentChargeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CurrentChargeTypeCodeType currentChargeTypeCode;
    @XmlElement(name = "OneTimeChargeType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OneTimeChargeTypeType oneTimeChargeType;
    @XmlElement(name = "OneTimeChargeTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OneTimeChargeTypeCodeType oneTimeChargeTypeCode;
    @XmlElement(name = "TaxCategory")
    protected TaxCategoryType taxCategory;
    @XmlElement(name = "Contract")
    protected ContractType contract;

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
     * Gets the value of the subscriberID property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberIDType }
     *     
     */
    public SubscriberIDType getSubscriberID() {
        return subscriberID;
    }

    /**
     * Sets the value of the subscriberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberIDType }
     *     
     */
    public void setSubscriberID(SubscriberIDType value) {
        this.subscriberID = value;
    }

    /**
     * Gets the value of the subscriberIDType property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberIDTypeType }
     *     
     */
    public SubscriberIDTypeType getSubscriberIDType() {
        return subscriberIDType;
    }

    /**
     * Sets the value of the subscriberIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberIDTypeType }
     *     
     */
    public void setSubscriberIDType(SubscriberIDTypeType value) {
        this.subscriberIDType = value;
    }

    /**
     * Gets the value of the subscriberIDTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriberIDTypeCodeType }
     *     
     */
    public SubscriberIDTypeCodeType getSubscriberIDTypeCode() {
        return subscriberIDTypeCode;
    }

    /**
     * Sets the value of the subscriberIDTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriberIDTypeCodeType }
     *     
     */
    public void setSubscriberIDTypeCode(SubscriberIDTypeCodeType value) {
        this.subscriberIDTypeCode = value;
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
     * Gets the value of the packQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link PackQuantityType }
     *     
     */
    public PackQuantityType getPackQuantity() {
        return packQuantity;
    }

    /**
     * Sets the value of the packQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackQuantityType }
     *     
     */
    public void setPackQuantity(PackQuantityType value) {
        this.packQuantity = value;
    }

    /**
     * Gets the value of the packSizeNumeric property.
     * 
     * @return
     *     possible object is
     *     {@link PackSizeNumericType }
     *     
     */
    public PackSizeNumericType getPackSizeNumeric() {
        return packSizeNumeric;
    }

    /**
     * Sets the value of the packSizeNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackSizeNumericType }
     *     
     */
    public void setPackSizeNumeric(PackSizeNumericType value) {
        this.packSizeNumeric = value;
    }

    /**
     * Gets the value of the consumptionType property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTypeType }
     *     
     */
    public ConsumptionTypeType getConsumptionType() {
        return consumptionType;
    }

    /**
     * Sets the value of the consumptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTypeType }
     *     
     */
    public void setConsumptionType(ConsumptionTypeType value) {
        this.consumptionType = value;
    }

    /**
     * Gets the value of the consumptionTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionTypeCodeType }
     *     
     */
    public ConsumptionTypeCodeType getConsumptionTypeCode() {
        return consumptionTypeCode;
    }

    /**
     * Sets the value of the consumptionTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionTypeCodeType }
     *     
     */
    public void setConsumptionTypeCode(ConsumptionTypeCodeType value) {
        this.consumptionTypeCode = value;
    }

    /**
     * Gets the value of the currentChargeType property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentChargeTypeType }
     *     
     */
    public CurrentChargeTypeType getCurrentChargeType() {
        return currentChargeType;
    }

    /**
     * Sets the value of the currentChargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentChargeTypeType }
     *     
     */
    public void setCurrentChargeType(CurrentChargeTypeType value) {
        this.currentChargeType = value;
    }

    /**
     * Gets the value of the currentChargeTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentChargeTypeCodeType }
     *     
     */
    public CurrentChargeTypeCodeType getCurrentChargeTypeCode() {
        return currentChargeTypeCode;
    }

    /**
     * Sets the value of the currentChargeTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentChargeTypeCodeType }
     *     
     */
    public void setCurrentChargeTypeCode(CurrentChargeTypeCodeType value) {
        this.currentChargeTypeCode = value;
    }

    /**
     * Gets the value of the oneTimeChargeType property.
     * 
     * @return
     *     possible object is
     *     {@link OneTimeChargeTypeType }
     *     
     */
    public OneTimeChargeTypeType getOneTimeChargeType() {
        return oneTimeChargeType;
    }

    /**
     * Sets the value of the oneTimeChargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneTimeChargeTypeType }
     *     
     */
    public void setOneTimeChargeType(OneTimeChargeTypeType value) {
        this.oneTimeChargeType = value;
    }

    /**
     * Gets the value of the oneTimeChargeTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link OneTimeChargeTypeCodeType }
     *     
     */
    public OneTimeChargeTypeCodeType getOneTimeChargeTypeCode() {
        return oneTimeChargeTypeCode;
    }

    /**
     * Sets the value of the oneTimeChargeTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneTimeChargeTypeCodeType }
     *     
     */
    public void setOneTimeChargeTypeCode(OneTimeChargeTypeCodeType value) {
        this.oneTimeChargeTypeCode = value;
    }

    /**
     * Gets the value of the taxCategory property.
     * 
     * @return
     *     possible object is
     *     {@link TaxCategoryType }
     *     
     */
    public TaxCategoryType getTaxCategory() {
        return taxCategory;
    }

    /**
     * Sets the value of the taxCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCategoryType }
     *     
     */
    public void setTaxCategory(TaxCategoryType value) {
        this.taxCategory = value;
    }

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setContract(ContractType value) {
        this.contract = value;
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
