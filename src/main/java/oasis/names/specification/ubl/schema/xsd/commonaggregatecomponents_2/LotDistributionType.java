
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GroupingLotsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumLotsAwardedNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumLotsSubmittedNumericType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Lot Distribution. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class defining how to treat different lots in a single procurement.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Lot Distribution&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for LotDistributionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LotDistributionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumLotsAwardedNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumLotsSubmittedNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GroupingLots" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LotDistributionType", propOrder = {
    "maximumLotsAwardedNumeric",
    "maximumLotsSubmittedNumeric",
    "groupingLots"
})
public class LotDistributionType {

    @XmlElement(name = "MaximumLotsAwardedNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumLotsAwardedNumericType maximumLotsAwardedNumeric;
    @XmlElement(name = "MaximumLotsSubmittedNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumLotsSubmittedNumericType maximumLotsSubmittedNumeric;
    @XmlElement(name = "GroupingLots", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<GroupingLotsType> groupingLots;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Lot Distribution. Maximum Lots Awarded. Numeric&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The maximum number of lots that can be awarded to a single tenderer.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Lot Distribution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Maximum Lots Awarded&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Numeric&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Numeric. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MaximumLotsAwardedNumericType }
     *     
     */
    public MaximumLotsAwardedNumericType getMaximumLotsAwardedNumeric() {
        return maximumLotsAwardedNumeric;
    }

    /**
     * Sets the value of the maximumLotsAwardedNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumLotsAwardedNumericType }
     *     
     */
    public void setMaximumLotsAwardedNumeric(MaximumLotsAwardedNumericType value) {
        this.maximumLotsAwardedNumeric = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Lot Distribution. Maximum Lots Submitted. Numeric&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The maximum number of lots to which a tenderer can submit an offer to.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Lot Distribution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Maximum Lots Submitted&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Numeric&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Numeric. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MaximumLotsSubmittedNumericType }
     *     
     */
    public MaximumLotsSubmittedNumericType getMaximumLotsSubmittedNumeric() {
        return maximumLotsSubmittedNumeric;
    }

    /**
     * Sets the value of the maximumLotsSubmittedNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumLotsSubmittedNumericType }
     *     
     */
    public void setMaximumLotsSubmittedNumeric(MaximumLotsSubmittedNumericType value) {
        this.maximumLotsSubmittedNumeric = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Lot Distribution. Grouping Lots. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Description on how to combine lots when submitting a tender.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Lot Distribution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Grouping Lots&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the groupingLots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the groupingLots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupingLots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupingLotsType }
     * 
     * 
     */
    public List<GroupingLotsType> getGroupingLots() {
        if (groupingLots == null) {
            groupingLots = new ArrayList<GroupingLotsType>();
        }
        return this.groupingLots;
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
