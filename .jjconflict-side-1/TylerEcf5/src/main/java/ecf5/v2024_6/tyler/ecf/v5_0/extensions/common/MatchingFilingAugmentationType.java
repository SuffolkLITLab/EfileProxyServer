
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for MatchingFilingAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchingFilingAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OriginalEnvelopeID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ParentEnvelope" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ChildEnvelope" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ProcedureRemedy" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilerTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CrossReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ReturnDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}EnvelopeLevelComment" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Payment" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ServiceRecipient" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}EnvelopeFee" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingFee" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingAttorney" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}MaxFeeAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RefundVoidCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchingFilingAugmentationType", propOrder = {
    "originalEnvelopeID",
    "parentEnvelope",
    "childEnvelope",
    "procedureRemedy",
    "filerTypeCode",
    "crossReference",
    "returnDate",
    "envelopeLevelComment",
    "payment",
    "serviceRecipient",
    "envelopeFee",
    "filingFee",
    "filingAttorney",
    "filingParty",
    "maxFeeAmount",
    "refundVoidCharge"
})
public class MatchingFilingAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "OriginalEnvelopeID")
    protected IdentificationType originalEnvelopeID;
    @XmlElement(name = "ParentEnvelope")
    protected ParentEnvelopeType parentEnvelope;
    @XmlElement(name = "ChildEnvelope")
    protected ChildEnvelopeType childEnvelope;
    @XmlElement(name = "ProcedureRemedy")
    protected ProcedureRemedyType procedureRemedy;
    @XmlElement(name = "FilerTypeCode")
    protected TextType filerTypeCode;
    @XmlElement(name = "CrossReference")
    protected List<CrossReferenceType> crossReference;
    @XmlElement(name = "ReturnDate")
    protected DateType returnDate;
    @XmlElement(name = "EnvelopeLevelComment")
    protected TextType envelopeLevelComment;
    @XmlElement(name = "Payment")
    protected PaymentType payment;
    @XmlElement(name = "ServiceRecipient")
    protected List<ServiceRecipientType> serviceRecipient;
    @XmlElement(name = "EnvelopeFee")
    protected FeeType envelopeFee;
    @XmlElement(name = "FilingFee")
    protected FeeType filingFee;
    @XmlElement(name = "FilingAttorney")
    protected FilingAttorneyEntityType filingAttorney;
    @XmlElement(name = "FilingParty")
    protected FilingPartyEntityType filingParty;
    @XmlElement(name = "MaxFeeAmount")
    protected AmountType maxFeeAmount;
    @XmlElement(name = "RefundVoidCharge")
    protected List<RefundVoidChargeType> refundVoidCharge;

    /**
     * Gets the value of the originalEnvelopeID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getOriginalEnvelopeID() {
        return originalEnvelopeID;
    }

    /**
     * Sets the value of the originalEnvelopeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setOriginalEnvelopeID(IdentificationType value) {
        this.originalEnvelopeID = value;
    }

    /**
     * Gets the value of the parentEnvelope property.
     * 
     * @return
     *     possible object is
     *     {@link ParentEnvelopeType }
     *     
     */
    public ParentEnvelopeType getParentEnvelope() {
        return parentEnvelope;
    }

    /**
     * Sets the value of the parentEnvelope property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentEnvelopeType }
     *     
     */
    public void setParentEnvelope(ParentEnvelopeType value) {
        this.parentEnvelope = value;
    }

    /**
     * Gets the value of the childEnvelope property.
     * 
     * @return
     *     possible object is
     *     {@link ChildEnvelopeType }
     *     
     */
    public ChildEnvelopeType getChildEnvelope() {
        return childEnvelope;
    }

    /**
     * Sets the value of the childEnvelope property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChildEnvelopeType }
     *     
     */
    public void setChildEnvelope(ChildEnvelopeType value) {
        this.childEnvelope = value;
    }

    /**
     * Gets the value of the procedureRemedy property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public ProcedureRemedyType getProcedureRemedy() {
        return procedureRemedy;
    }

    /**
     * Sets the value of the procedureRemedy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public void setProcedureRemedy(ProcedureRemedyType value) {
        this.procedureRemedy = value;
    }

    /**
     * Gets the value of the filerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilerTypeCode() {
        return filerTypeCode;
    }

    /**
     * Sets the value of the filerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilerTypeCode(TextType value) {
        this.filerTypeCode = value;
    }

    /**
     * Gets the value of the crossReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the crossReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrossReferenceType }
     * 
     * 
     */
    public List<CrossReferenceType> getCrossReference() {
        if (crossReference == null) {
            crossReference = new ArrayList<CrossReferenceType>();
        }
        return this.crossReference;
    }

    /**
     * Gets the value of the returnDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setReturnDate(DateType value) {
        this.returnDate = value;
    }

    /**
     * Gets the value of the envelopeLevelComment property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEnvelopeLevelComment() {
        return envelopeLevelComment;
    }

    /**
     * Sets the value of the envelopeLevelComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEnvelopeLevelComment(TextType value) {
        this.envelopeLevelComment = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPayment(PaymentType value) {
        this.payment = value;
    }

    /**
     * Gets the value of the serviceRecipient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the serviceRecipient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceRecipient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRecipientType }
     * 
     * 
     */
    public List<ServiceRecipientType> getServiceRecipient() {
        if (serviceRecipient == null) {
            serviceRecipient = new ArrayList<ServiceRecipientType>();
        }
        return this.serviceRecipient;
    }

    /**
     * Gets the value of the envelopeFee property.
     * 
     * @return
     *     possible object is
     *     {@link FeeType }
     *     
     */
    public FeeType getEnvelopeFee() {
        return envelopeFee;
    }

    /**
     * Sets the value of the envelopeFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeeType }
     *     
     */
    public void setEnvelopeFee(FeeType value) {
        this.envelopeFee = value;
    }

    /**
     * Gets the value of the filingFee property.
     * 
     * @return
     *     possible object is
     *     {@link FeeType }
     *     
     */
    public FeeType getFilingFee() {
        return filingFee;
    }

    /**
     * Sets the value of the filingFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeeType }
     *     
     */
    public void setFilingFee(FeeType value) {
        this.filingFee = value;
    }

    /**
     * Gets the value of the filingAttorney property.
     * 
     * @return
     *     possible object is
     *     {@link FilingAttorneyEntityType }
     *     
     */
    public FilingAttorneyEntityType getFilingAttorney() {
        return filingAttorney;
    }

    /**
     * Sets the value of the filingAttorney property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingAttorneyEntityType }
     *     
     */
    public void setFilingAttorney(FilingAttorneyEntityType value) {
        this.filingAttorney = value;
    }

    /**
     * Gets the value of the filingParty property.
     * 
     * @return
     *     possible object is
     *     {@link FilingPartyEntityType }
     *     
     */
    public FilingPartyEntityType getFilingParty() {
        return filingParty;
    }

    /**
     * Sets the value of the filingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingPartyEntityType }
     *     
     */
    public void setFilingParty(FilingPartyEntityType value) {
        this.filingParty = value;
    }

    /**
     * Gets the value of the maxFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getMaxFeeAmount() {
        return maxFeeAmount;
    }

    /**
     * Sets the value of the maxFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setMaxFeeAmount(AmountType value) {
        this.maxFeeAmount = value;
    }

    /**
     * Gets the value of the refundVoidCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the refundVoidCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefundVoidCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefundVoidChargeType }
     * 
     * 
     */
    public List<RefundVoidChargeType> getRefundVoidCharge() {
        if (refundVoidCharge == null) {
            refundVoidCharge = new ArrayList<RefundVoidChargeType>();
        }
        return this.refundVoidCharge;
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
