
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ClauseCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ClauseType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MandateTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumPaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumPaymentInstructionsNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SignatureIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for PaymentMandateType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PaymentMandateType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MandateTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Clause" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ClauseCode" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumPaymentInstructionsNumeric" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumPaidAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SignatureID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayerParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayerFinancialAccount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentReversalPeriod" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMandateType", propOrder = {
    "id",
    "mandateTypeCode",
    "clause",
    "clauseCode",
    "maximumPaymentInstructionsNumeric",
    "maximumPaidAmount",
    "signatureID",
    "payerParty",
    "payerFinancialAccount",
    "validityPeriod",
    "paymentReversalPeriod"
})
public class PaymentMandateType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "MandateTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MandateTypeCodeType mandateTypeCode;
    @XmlElement(name = "Clause", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ClauseType> clause;
    @XmlElement(name = "ClauseCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ClauseCodeType> clauseCode;
    @XmlElement(name = "MaximumPaymentInstructionsNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumPaymentInstructionsNumericType maximumPaymentInstructionsNumeric;
    @XmlElement(name = "MaximumPaidAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumPaidAmountType maximumPaidAmount;
    @XmlElement(name = "SignatureID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SignatureIDType signatureID;
    @XmlElement(name = "PayerParty")
    protected PartyType payerParty;
    @XmlElement(name = "PayerFinancialAccount")
    protected FinancialAccountType payerFinancialAccount;
    @XmlElement(name = "ValidityPeriod")
    protected PeriodType validityPeriod;
    @XmlElement(name = "PaymentReversalPeriod")
    protected PeriodType paymentReversalPeriod;

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
     * Gets the value of the mandateTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link MandateTypeCodeType }
     *     
     */
    public MandateTypeCodeType getMandateTypeCode() {
        return mandateTypeCode;
    }

    /**
     * Sets the value of the mandateTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateTypeCodeType }
     *     
     */
    public void setMandateTypeCode(MandateTypeCodeType value) {
        this.mandateTypeCode = value;
    }

    /**
     * Gets the value of the clause property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the clause property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getClause().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseType }
     * 
     * 
     */
    public List<ClauseType> getClause() {
        if (clause == null) {
            clause = new ArrayList<ClauseType>();
        }
        return this.clause;
    }

    /**
     * Gets the value of the clauseCode property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the clauseCode property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getClauseCode().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ClauseCodeType }
     * 
     * 
     */
    public List<ClauseCodeType> getClauseCode() {
        if (clauseCode == null) {
            clauseCode = new ArrayList<ClauseCodeType>();
        }
        return this.clauseCode;
    }

    /**
     * Gets the value of the maximumPaymentInstructionsNumeric property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumPaymentInstructionsNumericType }
     *     
     */
    public MaximumPaymentInstructionsNumericType getMaximumPaymentInstructionsNumeric() {
        return maximumPaymentInstructionsNumeric;
    }

    /**
     * Sets the value of the maximumPaymentInstructionsNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumPaymentInstructionsNumericType }
     *     
     */
    public void setMaximumPaymentInstructionsNumeric(MaximumPaymentInstructionsNumericType value) {
        this.maximumPaymentInstructionsNumeric = value;
    }

    /**
     * Gets the value of the maximumPaidAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumPaidAmountType }
     *     
     */
    public MaximumPaidAmountType getMaximumPaidAmount() {
        return maximumPaidAmount;
    }

    /**
     * Sets the value of the maximumPaidAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumPaidAmountType }
     *     
     */
    public void setMaximumPaidAmount(MaximumPaidAmountType value) {
        this.maximumPaidAmount = value;
    }

    /**
     * Gets the value of the signatureID property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureIDType }
     *     
     */
    public SignatureIDType getSignatureID() {
        return signatureID;
    }

    /**
     * Sets the value of the signatureID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureIDType }
     *     
     */
    public void setSignatureID(SignatureIDType value) {
        this.signatureID = value;
    }

    /**
     * Gets the value of the payerParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPayerParty() {
        return payerParty;
    }

    /**
     * Sets the value of the payerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPayerParty(PartyType value) {
        this.payerParty = value;
    }

    /**
     * Gets the value of the payerFinancialAccount property.
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
     * Gets the value of the paymentReversalPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPaymentReversalPeriod() {
        return paymentReversalPeriod;
    }

    /**
     * Sets the value of the paymentReversalPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPaymentReversalPeriod(PeriodType value) {
        this.paymentReversalPeriod = value;
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
