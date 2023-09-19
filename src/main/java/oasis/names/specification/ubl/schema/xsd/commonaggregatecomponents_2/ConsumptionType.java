
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UtilityStatementTypeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition/&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ConsumptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UtilityStatementTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyWaterSupply" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TelecommunicationsSupply" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LegalMonetaryTotal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Utility Statement Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Code specifying the type of the UtilityStatement&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Utility Statement Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Electricity&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Main_ Period. Period&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An association to period(s) to which the UtilityStatement applies&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Main&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Period&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Period&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Allowance Charge&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An association to Allowances and Charges that apply to the UtilityStatement as a whole&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Allowance Charge&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Allowance Charge&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Tax Total&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An association to tax total for specific tax types/rates&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Tax Total&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Tax Total&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Energy Water Supply&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An association to the total amount payable on the UtilityStatement including Allowances, Charges and Taxes.
     * This class is mandatory and sums the totals on UtilityChargeableConsumption level (for each ConsumptionPoint). This class must not be confused with the UBL MonetaryTotal class.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Energy Water Supply&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Energy Water Supply&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Telecommunications Supply&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An association to the total amount payable on the UtilityStatement including Allowances, Charges and Taxes.
     * This class is mandatory and sums the totals on UtilityChargeableConsumption level (for each ConsumptionPoint). This class must not be confused with the UBL MonetaryTotal class.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Telecommunications Supply&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Telecommunications Supply&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption. Legal_ Monetary Total. Monetary Total&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An association to the total amount payable on the UtilityStatement including Allowances, Charges and Taxes.
     * This class is mandatory and sums the totals on UtilityChargeableConsumption level (for each ConsumptionPoint). This class must not be confused with the UBL MonetaryTotal class.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Legal&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Monetary Total&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Monetary Total&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
