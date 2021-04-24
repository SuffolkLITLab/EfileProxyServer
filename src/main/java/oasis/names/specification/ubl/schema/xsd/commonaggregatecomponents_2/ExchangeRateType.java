
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExchangeMarketIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MathematicOperatorCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceCurrencyBaseRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetCurrencyBaseRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetCurrencyCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ExchangeRateType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ExchangeRateType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SourceCurrencyCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SourceCurrencyBaseRate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetCurrencyCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetCurrencyBaseRate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExchangeMarketID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CalculationRate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MathematicOperatorCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Date" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ForeignExchangeContract" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangeRateType", propOrder = {
    "sourceCurrencyCode",
    "sourceCurrencyBaseRate",
    "targetCurrencyCode",
    "targetCurrencyBaseRate",
    "exchangeMarketID",
    "calculationRate",
    "mathematicOperatorCode",
    "date",
    "foreignExchangeContract"
})
public class ExchangeRateType {

    @XmlElement(name = "SourceCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected SourceCurrencyCodeType sourceCurrencyCode;
    @XmlElement(name = "SourceCurrencyBaseRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SourceCurrencyBaseRateType sourceCurrencyBaseRate;
    @XmlElement(name = "TargetCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TargetCurrencyCodeType targetCurrencyCode;
    @XmlElement(name = "TargetCurrencyBaseRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TargetCurrencyBaseRateType targetCurrencyBaseRate;
    @XmlElement(name = "ExchangeMarketID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExchangeMarketIDType exchangeMarketID;
    @XmlElement(name = "CalculationRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CalculationRateType calculationRate;
    @XmlElement(name = "MathematicOperatorCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MathematicOperatorCodeType mathematicOperatorCode;
    @XmlElement(name = "Date", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DateType date;
    @XmlElement(name = "ForeignExchangeContract")
    protected ContractType foreignExchangeContract;

    /**
     * Gets the value of the sourceCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link SourceCurrencyCodeType }
     *     
     */
    public SourceCurrencyCodeType getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    /**
     * Sets the value of the sourceCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceCurrencyCodeType }
     *     
     */
    public void setSourceCurrencyCode(SourceCurrencyCodeType value) {
        this.sourceCurrencyCode = value;
    }

    /**
     * Gets the value of the sourceCurrencyBaseRate property.
     * 
     * @return
     *     possible object is
     *     {@link SourceCurrencyBaseRateType }
     *     
     */
    public SourceCurrencyBaseRateType getSourceCurrencyBaseRate() {
        return sourceCurrencyBaseRate;
    }

    /**
     * Sets the value of the sourceCurrencyBaseRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceCurrencyBaseRateType }
     *     
     */
    public void setSourceCurrencyBaseRate(SourceCurrencyBaseRateType value) {
        this.sourceCurrencyBaseRate = value;
    }

    /**
     * Gets the value of the targetCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link TargetCurrencyCodeType }
     *     
     */
    public TargetCurrencyCodeType getTargetCurrencyCode() {
        return targetCurrencyCode;
    }

    /**
     * Sets the value of the targetCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetCurrencyCodeType }
     *     
     */
    public void setTargetCurrencyCode(TargetCurrencyCodeType value) {
        this.targetCurrencyCode = value;
    }

    /**
     * Gets the value of the targetCurrencyBaseRate property.
     * 
     * @return
     *     possible object is
     *     {@link TargetCurrencyBaseRateType }
     *     
     */
    public TargetCurrencyBaseRateType getTargetCurrencyBaseRate() {
        return targetCurrencyBaseRate;
    }

    /**
     * Sets the value of the targetCurrencyBaseRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetCurrencyBaseRateType }
     *     
     */
    public void setTargetCurrencyBaseRate(TargetCurrencyBaseRateType value) {
        this.targetCurrencyBaseRate = value;
    }

    /**
     * Gets the value of the exchangeMarketID property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeMarketIDType }
     *     
     */
    public ExchangeMarketIDType getExchangeMarketID() {
        return exchangeMarketID;
    }

    /**
     * Sets the value of the exchangeMarketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeMarketIDType }
     *     
     */
    public void setExchangeMarketID(ExchangeMarketIDType value) {
        this.exchangeMarketID = value;
    }

    /**
     * Gets the value of the calculationRate property.
     * 
     * @return
     *     possible object is
     *     {@link CalculationRateType }
     *     
     */
    public CalculationRateType getCalculationRate() {
        return calculationRate;
    }

    /**
     * Sets the value of the calculationRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculationRateType }
     *     
     */
    public void setCalculationRate(CalculationRateType value) {
        this.calculationRate = value;
    }

    /**
     * Gets the value of the mathematicOperatorCode property.
     * 
     * @return
     *     possible object is
     *     {@link MathematicOperatorCodeType }
     *     
     */
    public MathematicOperatorCodeType getMathematicOperatorCode() {
        return mathematicOperatorCode;
    }

    /**
     * Sets the value of the mathematicOperatorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MathematicOperatorCodeType }
     *     
     */
    public void setMathematicOperatorCode(MathematicOperatorCodeType value) {
        this.mathematicOperatorCode = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDate(DateType value) {
        this.date = value;
    }

    /**
     * Gets the value of the foreignExchangeContract property.
     * 
     * @return
     *     possible object is
     *     {@link ContractType }
     *     
     */
    public ContractType getForeignExchangeContract() {
        return foreignExchangeContract;
    }

    /**
     * Sets the value of the foreignExchangeContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractType }
     *     
     */
    public void setForeignExchangeContract(ContractType value) {
        this.foreignExchangeContract = value;
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
