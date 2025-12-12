
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PartialWaiverType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartialWaiverType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ParentEnvelopeID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OutstandingBalance" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WaiverDecision"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WaiverPercentage"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PaymentSystemURL" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WaiverStartDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WaiverEndDate"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartialWaiverType", propOrder = {
    "parentEnvelopeID",
    "outstandingBalance",
    "waiverDecision",
    "waiverPercentage",
    "paymentSystemURL",
    "waiverStartDate",
    "waiverEndDate"
})
public class PartialWaiverType {

    @XmlElement(name = "ParentEnvelopeID")
    protected TextType parentEnvelopeID;
    @XmlElement(name = "OutstandingBalance")
    protected AmountType outstandingBalance;
    @XmlElement(name = "WaiverDecision", required = true)
    protected TextType waiverDecision;
    @XmlElement(name = "WaiverPercentage", required = true)
    protected TextType waiverPercentage;
    @XmlElement(name = "PaymentSystemURL")
    protected TextType paymentSystemURL;
    @XmlElement(name = "WaiverStartDate", required = true)
    protected DateType waiverStartDate;
    @XmlElement(name = "WaiverEndDate", required = true)
    protected DateType waiverEndDate;

    /**
     * Gets the value of the parentEnvelopeID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getParentEnvelopeID() {
        return parentEnvelopeID;
    }

    /**
     * Sets the value of the parentEnvelopeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setParentEnvelopeID(TextType value) {
        this.parentEnvelopeID = value;
    }

    /**
     * Gets the value of the outstandingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getOutstandingBalance() {
        return outstandingBalance;
    }

    /**
     * Sets the value of the outstandingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setOutstandingBalance(AmountType value) {
        this.outstandingBalance = value;
    }

    /**
     * Gets the value of the waiverDecision property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getWaiverDecision() {
        return waiverDecision;
    }

    /**
     * Sets the value of the waiverDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setWaiverDecision(TextType value) {
        this.waiverDecision = value;
    }

    /**
     * Gets the value of the waiverPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getWaiverPercentage() {
        return waiverPercentage;
    }

    /**
     * Sets the value of the waiverPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setWaiverPercentage(TextType value) {
        this.waiverPercentage = value;
    }

    /**
     * Gets the value of the paymentSystemURL property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPaymentSystemURL() {
        return paymentSystemURL;
    }

    /**
     * Sets the value of the paymentSystemURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPaymentSystemURL(TextType value) {
        this.paymentSystemURL = value;
    }

    /**
     * Gets the value of the waiverStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getWaiverStartDate() {
        return waiverStartDate;
    }

    /**
     * Sets the value of the waiverStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setWaiverStartDate(DateType value) {
        this.waiverStartDate = value;
    }

    /**
     * Gets the value of the waiverEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getWaiverEndDate() {
        return waiverEndDate;
    }

    /**
     * Sets the value of the waiverEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setWaiverEndDate(DateType value) {
        this.waiverEndDate = value;
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
