
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LossRiskResponsibilityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LossRiskType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialTermsType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for DeliveryTermsType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DeliveryTermsType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LossRiskResponsibilityCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LossRisk" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryTermsType", propOrder = {
    "id",
    "specialTerms",
    "lossRiskResponsibilityCode",
    "lossRisk",
    "amount",
    "deliveryLocation",
    "allowanceCharge"
})
public class DeliveryTermsType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "SpecialTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecialTermsType specialTerms;
    @XmlElement(name = "LossRiskResponsibilityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LossRiskResponsibilityCodeType lossRiskResponsibilityCode;
    @XmlElement(name = "LossRisk", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LossRiskType lossRisk;
    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AmountType amount;
    @XmlElement(name = "DeliveryLocation")
    protected LocationType deliveryLocation;
    @XmlElement(name = "AllowanceCharge")
    protected AllowanceChargeType allowanceCharge;

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
     * Gets the value of the specialTerms property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialTermsType }
     *     
     */
    public SpecialTermsType getSpecialTerms() {
        return specialTerms;
    }

    /**
     * Sets the value of the specialTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialTermsType }
     *     
     */
    public void setSpecialTerms(SpecialTermsType value) {
        this.specialTerms = value;
    }

    /**
     * Gets the value of the lossRiskResponsibilityCode property.
     * 
     * @return
     *     possible object is
     *     {@link LossRiskResponsibilityCodeType }
     *     
     */
    public LossRiskResponsibilityCodeType getLossRiskResponsibilityCode() {
        return lossRiskResponsibilityCode;
    }

    /**
     * Sets the value of the lossRiskResponsibilityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LossRiskResponsibilityCodeType }
     *     
     */
    public void setLossRiskResponsibilityCode(LossRiskResponsibilityCodeType value) {
        this.lossRiskResponsibilityCode = value;
    }

    /**
     * Gets the value of the lossRisk property.
     * 
     * @return
     *     possible object is
     *     {@link LossRiskType }
     *     
     */
    public LossRiskType getLossRisk() {
        return lossRisk;
    }

    /**
     * Sets the value of the lossRisk property.
     * 
     * @param value
     *     allowed object is
     *     {@link LossRiskType }
     *     
     */
    public void setLossRisk(LossRiskType value) {
        this.lossRisk = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Gets the value of the deliveryLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getDeliveryLocation() {
        return deliveryLocation;
    }

    /**
     * Sets the value of the deliveryLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setDeliveryLocation(LocationType value) {
        this.deliveryLocation = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * @return
     *     possible object is
     *     {@link AllowanceChargeType }
     *     
     */
    public AllowanceChargeType getAllowanceCharge() {
        return allowanceCharge;
    }

    /**
     * Sets the value of the allowanceCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceChargeType }
     *     
     */
    public void setAllowanceCharge(AllowanceChargeType value) {
        this.allowanceCharge = value;
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
