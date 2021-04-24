
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstallmentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicingPartyReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentMeansIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentPercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentTermsDetailsURIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltyAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltySurchargePercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidPaymentReferenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceEventCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SettlementDiscountAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SettlementDiscountPercentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for PaymentTermsType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PaymentTermsType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentMeansID" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrepaidPaymentReferenceID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceEventCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SettlementDiscountPercent" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PenaltySurchargePercent" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentPercent" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SettlementDiscountAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PenaltyAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentTermsDetailsURI" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentDueDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstallmentDueDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InvoicingPartyReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SettlementPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PenaltyPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExchangeRate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTermsType", propOrder = {
    "id",
    "paymentMeansID",
    "prepaidPaymentReferenceID",
    "note",
    "referenceEventCode",
    "settlementDiscountPercent",
    "penaltySurchargePercent",
    "paymentPercent",
    "amount",
    "settlementDiscountAmount",
    "penaltyAmount",
    "paymentTermsDetailsURI",
    "paymentDueDate",
    "installmentDueDate",
    "invoicingPartyReference",
    "settlementPeriod",
    "penaltyPeriod",
    "exchangeRate",
    "validityPeriod"
})
public class PaymentTermsType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PaymentMeansID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PaymentMeansIDType> paymentMeansID;
    @XmlElement(name = "PrepaidPaymentReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrepaidPaymentReferenceIDType prepaidPaymentReferenceID;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "ReferenceEventCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReferenceEventCodeType referenceEventCode;
    @XmlElement(name = "SettlementDiscountPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SettlementDiscountPercentType settlementDiscountPercent;
    @XmlElement(name = "PenaltySurchargePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PenaltySurchargePercentType penaltySurchargePercent;
    @XmlElement(name = "PaymentPercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentPercentType paymentPercent;
    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AmountType amount;
    @XmlElement(name = "SettlementDiscountAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SettlementDiscountAmountType settlementDiscountAmount;
    @XmlElement(name = "PenaltyAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PenaltyAmountType penaltyAmount;
    @XmlElement(name = "PaymentTermsDetailsURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentTermsDetailsURIType paymentTermsDetailsURI;
    @XmlElement(name = "PaymentDueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentDueDateType paymentDueDate;
    @XmlElement(name = "InstallmentDueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InstallmentDueDateType installmentDueDate;
    @XmlElement(name = "InvoicingPartyReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InvoicingPartyReferenceType invoicingPartyReference;
    @XmlElement(name = "SettlementPeriod")
    protected PeriodType settlementPeriod;
    @XmlElement(name = "PenaltyPeriod")
    protected PeriodType penaltyPeriod;
    @XmlElement(name = "ExchangeRate")
    protected ExchangeRateType exchangeRate;
    @XmlElement(name = "ValidityPeriod")
    protected PeriodType validityPeriod;

    /**
     * Gets the value of the id property.
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
     * Gets the value of the paymentMeansID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the paymentMeansID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPaymentMeansID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMeansIDType }
     * 
     * 
     */
    public List<PaymentMeansIDType> getPaymentMeansID() {
        if (paymentMeansID == null) {
            paymentMeansID = new ArrayList<PaymentMeansIDType>();
        }
        return this.paymentMeansID;
    }

    /**
     * Gets the value of the prepaidPaymentReferenceID property.
     * 
     * @return
     *     possible object is
     *     {@link PrepaidPaymentReferenceIDType }
     *     
     */
    public PrepaidPaymentReferenceIDType getPrepaidPaymentReferenceID() {
        return prepaidPaymentReferenceID;
    }

    /**
     * Sets the value of the prepaidPaymentReferenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaidPaymentReferenceIDType }
     *     
     */
    public void setPrepaidPaymentReferenceID(PrepaidPaymentReferenceIDType value) {
        this.prepaidPaymentReferenceID = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the note property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getNote().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Gets the value of the referenceEventCode property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceEventCodeType }
     *     
     */
    public ReferenceEventCodeType getReferenceEventCode() {
        return referenceEventCode;
    }

    /**
     * Sets the value of the referenceEventCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceEventCodeType }
     *     
     */
    public void setReferenceEventCode(ReferenceEventCodeType value) {
        this.referenceEventCode = value;
    }

    /**
     * Gets the value of the settlementDiscountPercent property.
     * 
     * @return
     *     possible object is
     *     {@link SettlementDiscountPercentType }
     *     
     */
    public SettlementDiscountPercentType getSettlementDiscountPercent() {
        return settlementDiscountPercent;
    }

    /**
     * Sets the value of the settlementDiscountPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementDiscountPercentType }
     *     
     */
    public void setSettlementDiscountPercent(SettlementDiscountPercentType value) {
        this.settlementDiscountPercent = value;
    }

    /**
     * Gets the value of the penaltySurchargePercent property.
     * 
     * @return
     *     possible object is
     *     {@link PenaltySurchargePercentType }
     *     
     */
    public PenaltySurchargePercentType getPenaltySurchargePercent() {
        return penaltySurchargePercent;
    }

    /**
     * Sets the value of the penaltySurchargePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PenaltySurchargePercentType }
     *     
     */
    public void setPenaltySurchargePercent(PenaltySurchargePercentType value) {
        this.penaltySurchargePercent = value;
    }

    /**
     * Gets the value of the paymentPercent property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentPercentType }
     *     
     */
    public PaymentPercentType getPaymentPercent() {
        return paymentPercent;
    }

    /**
     * Sets the value of the paymentPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentPercentType }
     *     
     */
    public void setPaymentPercent(PaymentPercentType value) {
        this.paymentPercent = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Gets the value of the settlementDiscountAmount property.
     * 
     * @return
     *     possible object is
     *     {@link SettlementDiscountAmountType }
     *     
     */
    public SettlementDiscountAmountType getSettlementDiscountAmount() {
        return settlementDiscountAmount;
    }

    /**
     * Sets the value of the settlementDiscountAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementDiscountAmountType }
     *     
     */
    public void setSettlementDiscountAmount(SettlementDiscountAmountType value) {
        this.settlementDiscountAmount = value;
    }

    /**
     * Gets the value of the penaltyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link PenaltyAmountType }
     *     
     */
    public PenaltyAmountType getPenaltyAmount() {
        return penaltyAmount;
    }

    /**
     * Sets the value of the penaltyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link PenaltyAmountType }
     *     
     */
    public void setPenaltyAmount(PenaltyAmountType value) {
        this.penaltyAmount = value;
    }

    /**
     * Gets the value of the paymentTermsDetailsURI property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsDetailsURIType }
     *     
     */
    public PaymentTermsDetailsURIType getPaymentTermsDetailsURI() {
        return paymentTermsDetailsURI;
    }

    /**
     * Sets the value of the paymentTermsDetailsURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsDetailsURIType }
     *     
     */
    public void setPaymentTermsDetailsURI(PaymentTermsDetailsURIType value) {
        this.paymentTermsDetailsURI = value;
    }

    /**
     * Gets the value of the paymentDueDate property.
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
     * Gets the value of the installmentDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link InstallmentDueDateType }
     *     
     */
    public InstallmentDueDateType getInstallmentDueDate() {
        return installmentDueDate;
    }

    /**
     * Sets the value of the installmentDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstallmentDueDateType }
     *     
     */
    public void setInstallmentDueDate(InstallmentDueDateType value) {
        this.installmentDueDate = value;
    }

    /**
     * Gets the value of the invoicingPartyReference property.
     * 
     * @return
     *     possible object is
     *     {@link InvoicingPartyReferenceType }
     *     
     */
    public InvoicingPartyReferenceType getInvoicingPartyReference() {
        return invoicingPartyReference;
    }

    /**
     * Sets the value of the invoicingPartyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoicingPartyReferenceType }
     *     
     */
    public void setInvoicingPartyReference(InvoicingPartyReferenceType value) {
        this.invoicingPartyReference = value;
    }

    /**
     * Gets the value of the settlementPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getSettlementPeriod() {
        return settlementPeriod;
    }

    /**
     * Sets the value of the settlementPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setSettlementPeriod(PeriodType value) {
        this.settlementPeriod = value;
    }

    /**
     * Gets the value of the penaltyPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPenaltyPeriod() {
        return penaltyPeriod;
    }

    /**
     * Sets the value of the penaltyPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPenaltyPeriod(PeriodType value) {
        this.penaltyPeriod = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRateType }
     *     
     */
    public ExchangeRateType getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRateType }
     *     
     */
    public void setExchangeRate(ExchangeRateType value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the validityPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * Sets the value of the validityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setValidityPeriod(PeriodType value) {
        this.validityPeriod = value;
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
