
package oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The payment submitted with a filing. The payment may consist of a fee for filing of the document(s) submitted, or for a fine or other payment due to the court.
 * 
 * &lt;p&gt;Java class for PaymentMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PaymentMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0}FeeExceptionReasonCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0}FeeExceptionSupportingText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0}PayerName"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Address"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Payment"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentMessageType", propOrder = {
    "feeExceptionReasonCode",
    "feeExceptionSupportingText",
    "payerName",
    "allowanceCharge",
    "address",
    "payment"
})
public class PaymentMessageType {

    @XmlElement(name = "FeeExceptionReasonCode")
    protected String feeExceptionReasonCode;
    @XmlElement(name = "FeeExceptionSupportingText")
    protected String feeExceptionSupportingText;
    @XmlElement(name = "PayerName", required = true)
    protected String payerName;
    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "Address", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", required = true)
    protected AddressType address;
    @XmlElement(name = "Payment", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", required = true)
    protected PaymentType payment;

    /**
     * Gets the value of the feeExceptionReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeExceptionReasonCode() {
        return feeExceptionReasonCode;
    }

    /**
     * Sets the value of the feeExceptionReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeExceptionReasonCode(String value) {
        this.feeExceptionReasonCode = value;
    }

    /**
     * Gets the value of the feeExceptionSupportingText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeExceptionSupportingText() {
        return feeExceptionSupportingText;
    }

    /**
     * Sets the value of the feeExceptionSupportingText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeExceptionSupportingText(String value) {
        this.feeExceptionSupportingText = value;
    }

    /**
     * Gets the value of the payerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * Sets the value of the payerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayerName(String value) {
        this.payerName = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the allowanceCharge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAllowanceCharge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
