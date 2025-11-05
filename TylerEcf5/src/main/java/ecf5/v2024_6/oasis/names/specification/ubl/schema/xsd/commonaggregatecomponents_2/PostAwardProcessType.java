
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ElectronicCatalogueUsageIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ElectronicInvoiceAcceptedIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ElectronicOrderUsageIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ElectronicPaymentUsageIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Post Award Process. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a post award process. These processes following the agreement on a contract for supply of goods or services ( for example, after the awarding of a tender).&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Post Award Process&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for PostAwardProcessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostAwardProcessType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ElectronicCatalogueUsageIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ElectronicInvoiceAcceptedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ElectronicOrderUsageIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ElectronicPaymentUsageIndicator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostAwardProcessType", propOrder = {
    "electronicCatalogueUsageIndicator",
    "electronicInvoiceAcceptedIndicator",
    "electronicOrderUsageIndicator",
    "electronicPaymentUsageIndicator"
})
public class PostAwardProcessType {

    @XmlElement(name = "ElectronicCatalogueUsageIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ElectronicCatalogueUsageIndicatorType electronicCatalogueUsageIndicator;
    @XmlElement(name = "ElectronicInvoiceAcceptedIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ElectronicInvoiceAcceptedIndicatorType electronicInvoiceAcceptedIndicator;
    @XmlElement(name = "ElectronicOrderUsageIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ElectronicOrderUsageIndicatorType electronicOrderUsageIndicator;
    @XmlElement(name = "ElectronicPaymentUsageIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ElectronicPaymentUsageIndicatorType> electronicPaymentUsageIndicator;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Post Award Process. Electronic Catalogue Usage. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator to specify whether an electronic catalogue will be used during the post award phase.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Post Award Process&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Electronic Catalogue Usage&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ElectronicCatalogueUsageIndicatorType }
     *     
     */
    public ElectronicCatalogueUsageIndicatorType getElectronicCatalogueUsageIndicator() {
        return electronicCatalogueUsageIndicator;
    }

    /**
     * Sets the value of the electronicCatalogueUsageIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicCatalogueUsageIndicatorType }
     *     
     */
    public void setElectronicCatalogueUsageIndicator(ElectronicCatalogueUsageIndicatorType value) {
        this.electronicCatalogueUsageIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Post Award Process. Electronic Invoice Accepted. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator on whether the electronic invoice is allowed for this process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Post Award Process&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Electronic Invoice Accepted&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ElectronicInvoiceAcceptedIndicatorType }
     *     
     */
    public ElectronicInvoiceAcceptedIndicatorType getElectronicInvoiceAcceptedIndicator() {
        return electronicInvoiceAcceptedIndicator;
    }

    /**
     * Sets the value of the electronicInvoiceAcceptedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicInvoiceAcceptedIndicatorType }
     *     
     */
    public void setElectronicInvoiceAcceptedIndicator(ElectronicInvoiceAcceptedIndicatorType value) {
        this.electronicInvoiceAcceptedIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Post Award Process. Electronic Order Usage. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator on whether electronic ordering shall be used in the post award process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Post Award Process&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Electronic Order Usage&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ElectronicOrderUsageIndicatorType }
     *     
     */
    public ElectronicOrderUsageIndicatorType getElectronicOrderUsageIndicator() {
        return electronicOrderUsageIndicator;
    }

    /**
     * Sets the value of the electronicOrderUsageIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicOrderUsageIndicatorType }
     *     
     */
    public void setElectronicOrderUsageIndicator(ElectronicOrderUsageIndicatorType value) {
        this.electronicOrderUsageIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Post Award Process. Electronic Payment Usage. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator on whether electronic payment shall be used in the post award process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Post Award Process&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Electronic Payment Usage&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the electronicPaymentUsageIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the electronicPaymentUsageIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectronicPaymentUsageIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectronicPaymentUsageIndicatorType }
     * 
     * 
     */
    public List<ElectronicPaymentUsageIndicatorType> getElectronicPaymentUsageIndicator() {
        if (electronicPaymentUsageIndicator == null) {
            electronicPaymentUsageIndicator = new ArrayList<ElectronicPaymentUsageIndicatorType>();
        }
        return this.electronicPaymentUsageIndicator;
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
