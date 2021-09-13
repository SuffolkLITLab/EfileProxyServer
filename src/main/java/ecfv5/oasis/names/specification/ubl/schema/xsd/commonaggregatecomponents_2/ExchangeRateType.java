
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationRateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExchangeMarketIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MathematicOperatorCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceCurrencyBaseRateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceCurrencyCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetCurrencyBaseRateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TargetCurrencyCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to define an exchange rate.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ExchangeRateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExchangeRateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SourceCurrencyCode"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SourceCurrencyBaseRate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetCurrencyCode"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TargetCurrencyBaseRate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExchangeMarketID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CalculationRate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MathematicOperatorCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Date" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ForeignExchangeContract" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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

    @XmlElement(name = "SourceCurrencyCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected SourceCurrencyCodeType sourceCurrencyCode;
    @XmlElement(name = "SourceCurrencyBaseRate", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SourceCurrencyBaseRateType sourceCurrencyBaseRate;
    @XmlElement(name = "TargetCurrencyCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TargetCurrencyCodeType targetCurrencyCode;
    @XmlElement(name = "TargetCurrencyBaseRate", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TargetCurrencyBaseRateType targetCurrencyBaseRate;
    @XmlElement(name = "ExchangeMarketID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExchangeMarketIDType exchangeMarketID;
    @XmlElement(name = "CalculationRate", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CalculationRateType calculationRate;
    @XmlElement(name = "MathematicOperatorCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MathematicOperatorCodeType mathematicOperatorCode;
    @XmlElement(name = "Date", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DateType date;
    @XmlElement(name = "ForeignExchangeContract")
    protected ContractType foreignExchangeContract;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Source_ Currency Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The reference currency for this exchange rate; the currency from which the exchange is being made.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Source&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Currency Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Currency&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Currency_ Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Source_ Currency Base Rate. Rate&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;In the case of a source currency with denominations of small value, the unit base.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Source&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Currency Base Rate&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Rate&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Rate. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Target_ Currency Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The target currency for this exchange rate; the currency to which the exchange is being made.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Target&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Currency Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Currency&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Currency_ Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Target_ Currency Base Rate. Rate&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;In the case of a target currency with denominations of small value, the unit base.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Target&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Currency Base Rate&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Rate&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Rate. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Exchange Market Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the currency exchange market used as the source of this exchange rate.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Exchange Market Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Calculation Rate. Rate&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The factor applied to the source currency to calculate the target currency.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Calculation Rate&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Rate&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Rate. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Mathematic Operator Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying whether the calculation rate is a multiplier or a divisor.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Mathematic Operator Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Operator&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Operator_ Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date on which the exchange rate was established.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Exchange Rate. Foreign Exchange_ Contract. Contract&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A contract for foreign exchange.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Exchange Rate&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Foreign Exchange&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Contract&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Contract&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Contract&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
