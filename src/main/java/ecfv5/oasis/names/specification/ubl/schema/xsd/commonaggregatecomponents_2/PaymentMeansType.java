
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionNoteType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentChannelCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentMeansCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a means of payment.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for PaymentMeansType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentMeansType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentMeansCode"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentDueDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentChannelCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstructionID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstructionNote" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CardAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayerFinancialAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayeeFinancialAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CreditAccount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentMandate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TradeFinancing" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMeansType", propOrder = {
    "id",
    "paymentMeansCode",
    "paymentDueDate",
    "paymentChannelCode",
    "instructionID",
    "instructionNote",
    "paymentID",
    "cardAccount",
    "payerFinancialAccount",
    "payeeFinancialAccount",
    "creditAccount",
    "paymentMandate",
    "tradeFinancing"
})
public class PaymentMeansType {

    @XmlElement(name = "ID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PaymentMeansCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PaymentMeansCodeType paymentMeansCode;
    @XmlElement(name = "PaymentDueDate", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentDueDateType paymentDueDate;
    @XmlElement(name = "PaymentChannelCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentChannelCodeType paymentChannelCode;
    @XmlElement(name = "InstructionID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InstructionIDType instructionID;
    @XmlElement(name = "InstructionNote", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InstructionNoteType> instructionNote;
    @XmlElement(name = "PaymentID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentIDType> paymentID;
    @XmlElement(name = "CardAccount")
    protected CardAccountType cardAccount;
    @XmlElement(name = "PayerFinancialAccount")
    protected FinancialAccountType payerFinancialAccount;
    @XmlElement(name = "PayeeFinancialAccount")
    protected FinancialAccountType payeeFinancialAccount;
    @XmlElement(name = "CreditAccount")
    protected CreditAccountType creditAccount;
    @XmlElement(name = "PaymentMandate")
    protected PaymentMandateType paymentMandate;
    @XmlElement(name = "TradeFinancing")
    protected TradeFinancingType tradeFinancing;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
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
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payment Means Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the type of this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Payment Means Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Payment Means&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Payment Means_ Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PaymentMeansCodeType }
     *     
     */
    public PaymentMeansCodeType getPaymentMeansCode() {
        return paymentMeansCode;
    }

    /**
     * Sets the value of the paymentMeansCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMeansCodeType }
     *     
     */
    public void setPaymentMeansCode(PaymentMeansCodeType value) {
        this.paymentMeansCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payment Due Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date on which payment is due for this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Payment Due Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PaymentDueDateType }
     *     
     */
    public PaymentDueDateType getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * Sets the value of the paymentDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDueDateType }
     *     
     */
    public void setPaymentDueDate(PaymentDueDateType value) {
        this.paymentDueDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payment Channel Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the payment channel for this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Payment Channel Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PaymentChannelCodeType }
     *     
     */
    public PaymentChannelCodeType getPaymentChannelCode() {
        return paymentChannelCode;
    }

    /**
     * Sets the value of the paymentChannelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentChannelCodeType }
     *     
     */
    public void setPaymentChannelCode(PaymentChannelCodeType value) {
        this.paymentChannelCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Instruction Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the payment instruction.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Instruction Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link InstructionIDType }
     *     
     */
    public InstructionIDType getInstructionID() {
        return instructionID;
    }

    /**
     * Sets the value of the instructionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionIDType }
     *     
     */
    public void setInstructionID(InstructionIDType value) {
        this.instructionID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Instruction_ Note. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Free-form text conveying information that is not contained explicitly in other structures.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Instruction&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Note&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the instructionNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instructionNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstructionNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstructionNoteType }
     * 
     * 
     */
    public List<InstructionNoteType> getInstructionNote() {
        if (instructionNote == null) {
            instructionNote = new ArrayList<InstructionNoteType>();
        }
        return this.instructionNote;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payment Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for a payment made using this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Payment Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the paymentID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentIDType }
     * 
     * 
     */
    public List<PaymentIDType> getPaymentID() {
        if (paymentID == null) {
            paymentID = new ArrayList<PaymentIDType>();
        }
        return this.paymentID;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Card Account&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A credit card, debit card, or charge card account that constitutes this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Card Account&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Card Account&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Card Account&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CardAccountType }
     *     
     */
    public CardAccountType getCardAccount() {
        return cardAccount;
    }

    /**
     * Sets the value of the cardAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAccountType }
     *     
     */
    public void setCardAccount(CardAccountType value) {
        this.cardAccount = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payer_ Financial Account. Financial Account&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The payer's financial account.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Payer&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Financial Account&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Financial Account&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Financial Account&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link FinancialAccountType }
     *     
     */
    public FinancialAccountType getPayerFinancialAccount() {
        return payerFinancialAccount;
    }

    /**
     * Sets the value of the payerFinancialAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAccountType }
     *     
     */
    public void setPayerFinancialAccount(FinancialAccountType value) {
        this.payerFinancialAccount = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payee_ Financial Account. Financial Account&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The payee's financial account.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Payee&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Financial Account&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Financial Account&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Financial Account&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link FinancialAccountType }
     *     
     */
    public FinancialAccountType getPayeeFinancialAccount() {
        return payeeFinancialAccount;
    }

    /**
     * Sets the value of the payeeFinancialAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAccountType }
     *     
     */
    public void setPayeeFinancialAccount(FinancialAccountType value) {
        this.payeeFinancialAccount = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Credit Account&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A credit account associated with this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Credit Account&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Credit Account&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Credit Account&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CreditAccountType }
     *     
     */
    public CreditAccountType getCreditAccount() {
        return creditAccount;
    }

    /**
     * Sets the value of the creditAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditAccountType }
     *     
     */
    public void setCreditAccount(CreditAccountType value) {
        this.creditAccount = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Payment Mandate&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The payment mandate associated with this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Payment Mandate&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Payment Mandate&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Payment Mandate&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PaymentMandateType }
     *     
     */
    public PaymentMandateType getPaymentMandate() {
        return paymentMandate;
    }

    /**
     * Sets the value of the paymentMandate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMandateType }
     *     
     */
    public void setPaymentMandate(PaymentMandateType value) {
        this.paymentMandate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Payment Means. Trade Financing&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A trade finance agreement applicable to this means of payment.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Payment Means&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Trade Financing&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Trade Financing&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Trade Financing&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TradeFinancingType }
     *     
     */
    public TradeFinancingType getTradeFinancing() {
        return tradeFinancing;
    }

    /**
     * Sets the value of the tradeFinancing property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeFinancingType }
     *     
     */
    public void setTradeFinancing(TradeFinancingType value) {
        this.tradeFinancing = value;
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
