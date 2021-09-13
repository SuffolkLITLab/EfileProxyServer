
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InformationType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Trading Terms. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class for describing the terms of a trade agreement.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Trading Terms&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for TradingTermsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TradingTermsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Information" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Reference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ApplicableAddress" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradingTermsType", propOrder = {
    "information",
    "reference",
    "applicableAddress"
})
public class TradingTermsType {

    @XmlElement(name = "Information", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InformationType> information;
    @XmlElement(name = "Reference", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferenceType reference;
    @XmlElement(name = "ApplicableAddress")
    protected AddressType applicableAddress;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Trading Terms. Information. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Text describing the terms of a trade agreement.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Trading Terms&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Information&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Unless credit terms have been expressly agreed by Dell, payment for the products or services shall be made in full before physical delivery of products or services. Customer shall pay for all shipping and handling charges. &lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the information property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the information property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InformationType }
     * 
     * 
     */
    public List<InformationType> getInformation() {
        if (information == null) {
            information = new ArrayList<InformationType>();
        }
        return this.information;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Trading Terms. Reference. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference quoting the basis of the terms&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Trading Terms&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Reference&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;http://www1.ap.dell.com/content/topics/topic.aspx/ap/policy/en/au/sales_terms_au?c=au&amp;amp;l=en&amp;amp;s=gen&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setReference(ReferenceType value) {
        this.reference = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Trading Terms. Applicable_ Address. Address&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The address at which these trading terms apply.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Trading Terms&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Applicable&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Address&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Address&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Address&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getApplicableAddress() {
        return applicableAddress;
    }

    /**
     * Sets the value of the applicableAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setApplicableAddress(AddressType value) {
        this.applicableAddress = value;
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
