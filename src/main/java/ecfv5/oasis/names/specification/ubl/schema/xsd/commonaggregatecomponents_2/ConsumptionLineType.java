
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ParentDocumentLineReferenceIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a line item for utility consumption. To specify more than one utility item, use separate consumption lines.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ConsumptionLineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsumptionLineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ParentDocumentLineReferenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InvoicedQuantity"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineExtensionAmount"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Period" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Delivery" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UtilityItem"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Price" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UnstructuredPrice" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsumptionLineType", propOrder = {
    "id",
    "parentDocumentLineReferenceID",
    "invoicedQuantity",
    "lineExtensionAmount",
    "period",
    "delivery",
    "allowanceCharge",
    "taxTotal",
    "utilityItem",
    "price",
    "unstructuredPrice"
})
public class ConsumptionLineType {

    @XmlElement(name = "ID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "ParentDocumentLineReferenceID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ParentDocumentLineReferenceIDType parentDocumentLineReferenceID;
    @XmlElement(name = "InvoicedQuantity", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected InvoicedQuantityType invoicedQuantity;
    @XmlElement(name = "LineExtensionAmount", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LineExtensionAmountType lineExtensionAmount;
    @XmlElement(name = "Period")
    protected PeriodType period;
    @XmlElement(name = "Delivery")
    protected List<DeliveryType> delivery;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "UtilityItem", required = true)
    protected UtilityItemType utilityItem;
    @XmlElement(name = "Price")
    protected PriceType price;
    @XmlElement(name = "UnstructuredPrice")
    protected UnstructuredPriceType unstructuredPrice;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;1&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Parent_ Document Line Reference Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the transaction line on a related document (such as an invoice) that covers this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Parent&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Document Line Reference Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Consumption&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ParentDocumentLineReferenceIDType }
     *     
     */
    public ParentDocumentLineReferenceIDType getParentDocumentLineReferenceID() {
        return parentDocumentLineReferenceID;
    }

    /**
     * Sets the value of the parentDocumentLineReferenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentDocumentLineReferenceIDType }
     *     
     */
    public void setParentDocumentLineReferenceID(ParentDocumentLineReferenceIDType value) {
        this.parentDocumentLineReferenceID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Invoiced_ Quantity. Quantity&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The quantity invoiced.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Invoiced&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Quantity&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Quantity&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Quantity. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link InvoicedQuantityType }
     *     
     */
    public InvoicedQuantityType getInvoicedQuantity() {
        return invoicedQuantity;
    }

    /**
     * Sets the value of the invoicedQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoicedQuantityType }
     *     
     */
    public void setInvoicedQuantity(InvoicedQuantityType value) {
        this.invoicedQuantity = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Line Extension Amount. Amount&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The monetary amount, including discount, to be charged for this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Line Extension Amount&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Amount&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Amount. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    /**
     * Sets the value of the lineExtensionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link LineExtensionAmountType }
     *     
     */
    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Period&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The period of time covered by this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Period&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Period&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Period&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPeriod(PeriodType value) {
        this.period = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Delivery&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A delivery of the utility item on this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Delivery&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Delivery&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Delivery&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the delivery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delivery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelivery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryType }
     * 
     * 
     */
    public List<DeliveryType> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryType>();
        }
        return this.delivery;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Allowance Charge&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An allowance or charge that applies to this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Allowance Charge&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Allowance Charge&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Allowance Charge&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
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
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Tax Total&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A total amount of taxes of a particular kind applicable to this consumption line.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Tax Total&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Tax Total&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Tax Total&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
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
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Utility Item&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The utility item consumed.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Utility Item&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Utility Item&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Utility Item&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link UtilityItemType }
     *     
     */
    public UtilityItemType getUtilityItem() {
        return utilityItem;
    }

    /**
     * Sets the value of the utilityItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilityItemType }
     *     
     */
    public void setUtilityItem(UtilityItemType value) {
        this.utilityItem = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Price&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The price associated with this consumption line, expressed in a data structure containing multiple properties.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Price&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Price&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Price&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PriceType }
     *     
     */
    public PriceType getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceType }
     *     
     */
    public void setPrice(PriceType value) {
        this.price = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Consumption Line. Unstructured Price&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The price associated with this consumption line expressed in a less structured form that includes just the amount and the time of use.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Consumption Line&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Unstructured Price&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Unstructured Price&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Unstructured Price&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link UnstructuredPriceType }
     *     
     */
    public UnstructuredPriceType getUnstructuredPrice() {
        return unstructuredPrice;
    }

    /**
     * Sets the value of the unstructuredPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnstructuredPriceType }
     *     
     */
    public void setUnstructuredPrice(UnstructuredPriceType value) {
        this.unstructuredPrice = value;
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
