
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UtilityStatementTypeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ConsumptionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ConsumptionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UtilityStatementTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyWaterSupply" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TelecommunicationsSupply" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LegalMonetaryTotal"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionType", propOrder = {
    "utilityStatementTypeCode",
    "mainPeriod",
    "allowanceCharge",
    "taxTotal",
    "energyWaterSupply",
    "telecommunicationsSupply",
    "legalMonetaryTotal"
})
public class ConsumptionType {

    @XmlElement(name = "UtilityStatementTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UtilityStatementTypeCodeType utilityStatementTypeCode;
    @XmlElement(name = "MainPeriod")
    protected PeriodType mainPeriod;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "EnergyWaterSupply")
    protected EnergyWaterSupplyType energyWaterSupply;
    @XmlElement(name = "TelecommunicationsSupply")
    protected TelecommunicationsSupplyType telecommunicationsSupply;
    @XmlElement(name = "LegalMonetaryTotal", required = true)
    protected MonetaryTotalType legalMonetaryTotal;

    /**
     * Gets the value of the utilityStatementTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link UtilityStatementTypeCodeType }
     *     
     */
    public UtilityStatementTypeCodeType getUtilityStatementTypeCode() {
        return utilityStatementTypeCode;
    }

    /**
     * Sets the value of the utilityStatementTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilityStatementTypeCodeType }
     *     
     */
    public void setUtilityStatementTypeCode(UtilityStatementTypeCodeType value) {
        this.utilityStatementTypeCode = value;
    }

    /**
     * Gets the value of the mainPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getMainPeriod() {
        return mainPeriod;
    }

    /**
     * Sets the value of the mainPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setMainPeriod(PeriodType value) {
        this.mainPeriod = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the allowanceCharge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAllowanceCharge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * Gets the value of the taxTotal property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the taxTotal property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTaxTotal().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TaxTotalType }
     * 
     * 
     */
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    /**
     * Gets the value of the energyWaterSupply property.
     * 
     * @return
     *     possible object is
     *     {@link EnergyWaterSupplyType }
     *     
     */
    public EnergyWaterSupplyType getEnergyWaterSupply() {
        return energyWaterSupply;
    }

    /**
     * Sets the value of the energyWaterSupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyWaterSupplyType }
     *     
     */
    public void setEnergyWaterSupply(EnergyWaterSupplyType value) {
        this.energyWaterSupply = value;
    }

    /**
     * Gets the value of the telecommunicationsSupply property.
     * 
     * @return
     *     possible object is
     *     {@link TelecommunicationsSupplyType }
     *     
     */
    public TelecommunicationsSupplyType getTelecommunicationsSupply() {
        return telecommunicationsSupply;
    }

    /**
     * Sets the value of the telecommunicationsSupply property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelecommunicationsSupplyType }
     *     
     */
    public void setTelecommunicationsSupply(TelecommunicationsSupplyType value) {
        this.telecommunicationsSupply = value;
    }

    /**
     * Gets the value of the legalMonetaryTotal property.
     * 
     * @return
     *     possible object is
     *     {@link MonetaryTotalType }
     *     
     */
    public MonetaryTotalType getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * Sets the value of the legalMonetaryTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryTotalType }
     *     
     */
    public void setLegalMonetaryTotal(MonetaryTotalType value) {
        this.legalMonetaryTotal = value;
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
