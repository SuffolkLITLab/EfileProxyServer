
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumerIncentiveTacticTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DisplayTacticTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeatureTacticTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TradeItemPackingLabelingTypeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Event Tactic Enumeration. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to define a set of codes that describes a retail tactic.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Event Tactic Enumeration&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for EventTacticEnumerationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventTacticEnumerationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumerIncentiveTacticTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DisplayTacticTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FeatureTacticTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TradeItemPackingLabelingTypeCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTacticEnumerationType", propOrder = {
    "consumerIncentiveTacticTypeCode",
    "displayTacticTypeCode",
    "featureTacticTypeCode",
    "tradeItemPackingLabelingTypeCode"
})
public class EventTacticEnumerationType {

    @XmlElement(name = "ConsumerIncentiveTacticTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumerIncentiveTacticTypeCodeType consumerIncentiveTacticTypeCode;
    @XmlElement(name = "DisplayTacticTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DisplayTacticTypeCodeType displayTacticTypeCode;
    @XmlElement(name = "FeatureTacticTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FeatureTacticTypeCodeType featureTacticTypeCode;
    @XmlElement(name = "TradeItemPackingLabelingTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TradeItemPackingLabelingTypeCodeType tradeItemPackingLabelingTypeCode;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Event Tactic Enumeration. Consumer Incentive Tactic Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the type of consumer incentive. Examples include:Free Item, Temporary Price reduction&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Event Tactic Enumeration&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Consumer Incentive Tactic Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ConsumerIncentiveTacticTypeCodeType }
     *     
     */
    public ConsumerIncentiveTacticTypeCodeType getConsumerIncentiveTacticTypeCode() {
        return consumerIncentiveTacticTypeCode;
    }

    /**
     * Sets the value of the consumerIncentiveTacticTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerIncentiveTacticTypeCodeType }
     *     
     */
    public void setConsumerIncentiveTacticTypeCode(ConsumerIncentiveTacticTypeCodeType value) {
        this.consumerIncentiveTacticTypeCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Event Tactic Enumeration. Display Tactic Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the type of display. Examples Include: ON_COUNTER_DISPLAY, FLOOR_GRAPHICS FLOOR_STACK_DISPLAY&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Event Tactic Enumeration&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Display Tactic Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link DisplayTacticTypeCodeType }
     *     
     */
    public DisplayTacticTypeCodeType getDisplayTacticTypeCode() {
        return displayTacticTypeCode;
    }

    /**
     * Sets the value of the displayTacticTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayTacticTypeCodeType }
     *     
     */
    public void setDisplayTacticTypeCode(DisplayTacticTypeCodeType value) {
        this.displayTacticTypeCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Event Tactic Enumeration. Feature Tactic Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying a special feature. Examples Include: BILLBOARD DIRECT_MAIL_AD, FLYER&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Event Tactic Enumeration&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Feature Tactic Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link FeatureTacticTypeCodeType }
     *     
     */
    public FeatureTacticTypeCodeType getFeatureTacticTypeCode() {
        return featureTacticTypeCode;
    }

    /**
     * Sets the value of the featureTacticTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeatureTacticTypeCodeType }
     *     
     */
    public void setFeatureTacticTypeCode(FeatureTacticTypeCodeType value) {
        this.featureTacticTypeCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Event Tactic Enumeration. Trade Item Packing Labeling Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the type of trade item packing and labeling. Examples Include: BONUS_SIZE CO_BRANDED_TRADE_ITEM&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Event Tactic Enumeration&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Trade Item Packing Labeling Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TradeItemPackingLabelingTypeCodeType }
     *     
     */
    public TradeItemPackingLabelingTypeCodeType getTradeItemPackingLabelingTypeCode() {
        return tradeItemPackingLabelingTypeCode;
    }

    /**
     * Sets the value of the tradeItemPackingLabelingTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeItemPackingLabelingTypeCodeType }
     *     
     */
    public void setTradeItemPackingLabelingTypeCode(TradeItemPackingLabelingTypeCodeType value) {
        this.tradeItemPackingLabelingTypeCode = value;
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
