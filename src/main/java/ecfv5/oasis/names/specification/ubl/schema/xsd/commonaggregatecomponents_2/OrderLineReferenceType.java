
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineStatusCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SalesOrderLineIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Order Line Reference. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to define a reference to an order line.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Order Line Reference&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for OrderLineReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderLineReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineID"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SalesOrderLineID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OrderReference" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderLineReferenceType", propOrder = {
    "lineID",
    "salesOrderLineID",
    "uuid",
    "lineStatusCode",
    "orderReference"
})
public class OrderLineReferenceType {

    @XmlElement(name = "LineID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LineIDType lineID;
    @XmlElement(name = "SalesOrderLineID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SalesOrderLineIDType salesOrderLineID;
    @XmlElement(name = "UUID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UUIDType uuid;
    @XmlElement(name = "LineStatusCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineStatusCodeType lineStatusCode;
    @XmlElement(name = "OrderReference")
    protected OrderReferenceType orderReference;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Order Line Reference. Line Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the referenced order line, assigned by the buyer.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Order Line Reference&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Line Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link LineIDType }
     *     
     */
    public LineIDType getLineID() {
        return lineID;
    }

    /**
     * Sets the value of the lineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineIDType }
     *     
     */
    public void setLineID(LineIDType value) {
        this.lineID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Order Line Reference. Sales Order_ Line Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the referenced order line, assigned by the seller.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Order Line Reference&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Sales Order&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Line Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link SalesOrderLineIDType }
     *     
     */
    public SalesOrderLineIDType getSalesOrderLineID() {
        return salesOrderLineID;
    }

    /**
     * Sets the value of the salesOrderLineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesOrderLineIDType }
     *     
     */
    public void setSalesOrderLineID(SalesOrderLineIDType value) {
        this.salesOrderLineID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Order Line Reference. UUID. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A universally unique identifier for this order line reference.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Order Line Reference&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;UUID&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link UUIDType }
     *     
     */
    public UUIDType getUUID() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link UUIDType }
     *     
     */
    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Order Line Reference. Line Status Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the status of the referenced order line with respect to its original state.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Order Line Reference&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Line Status Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Line Status&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Line Status_ Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link LineStatusCodeType }
     *     
     */
    public LineStatusCodeType getLineStatusCode() {
        return lineStatusCode;
    }

    /**
     * Sets the value of the lineStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineStatusCodeType }
     *     
     */
    public void setLineStatusCode(LineStatusCodeType value) {
        this.lineStatusCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Order Line Reference. Order Reference&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference to the Order containing the referenced order line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Order Line Reference&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Order Reference&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Order Reference&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Order Reference&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link OrderReferenceType }
     *     
     */
    public OrderReferenceType getOrderReference() {
        return orderReference;
    }

    /**
     * Sets the value of the orderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReferenceType }
     *     
     */
    public void setOrderReference(OrderReferenceType value) {
        this.orderReference = value;
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
