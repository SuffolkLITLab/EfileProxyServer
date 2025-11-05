
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PaymentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}AccountName"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}WaiverIndicator"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CardType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CardLast4" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ExpirationMonth" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ExpirationYear" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TransactionAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TransactionResponse" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}TransactionID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}OrderID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentType", propOrder = {
    "accountName",
    "waiverIndicator",
    "cardType",
    "cardLast4",
    "expirationMonth",
    "expirationYear",
    "transactionAmount",
    "transactionResponse",
    "transactionID",
    "orderID"
})
public class PaymentType {

    @XmlElement(name = "AccountName", required = true)
    protected TextType accountName;
    @XmlElement(name = "WaiverIndicator", required = true)
    protected Boolean waiverIndicator;
    @XmlElement(name = "CardType")
    protected TextType cardType;
    @XmlElement(name = "CardLast4")
    protected NonNegativeDecimalType cardLast4;
    @XmlElement(name = "ExpirationMonth")
    protected NonNegativeDecimalType expirationMonth;
    @XmlElement(name = "ExpirationYear")
    protected NonNegativeDecimalType expirationYear;
    @XmlElement(name = "TransactionAmount")
    protected AmountType transactionAmount;
    @XmlElement(name = "TransactionResponse")
    protected TextType transactionResponse;
    @XmlElement(name = "TransactionID")
    protected TextType transactionID;
    @XmlElement(name = "OrderID")
    protected TextType orderID;

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAccountName(TextType value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the waiverIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getWaiverIndicator() {
        return waiverIndicator;
    }

    /**
     * Sets the value of the waiverIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaiverIndicator(Boolean value) {
        this.waiverIndicator = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCardType(TextType value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardLast4 property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getCardLast4() {
        return cardLast4;
    }

    /**
     * Sets the value of the cardLast4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setCardLast4(NonNegativeDecimalType value) {
        this.cardLast4 = value;
    }

    /**
     * Gets the value of the expirationMonth property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Sets the value of the expirationMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setExpirationMonth(NonNegativeDecimalType value) {
        this.expirationMonth = value;
    }

    /**
     * Gets the value of the expirationYear property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getExpirationYear() {
        return expirationYear;
    }

    /**
     * Sets the value of the expirationYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setExpirationYear(NonNegativeDecimalType value) {
        this.expirationYear = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTransactionAmount(AmountType value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the transactionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTransactionResponse() {
        return transactionResponse;
    }

    /**
     * Sets the value of the transactionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTransactionResponse(TextType value) {
        this.transactionResponse = value;
    }

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTransactionID(TextType value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setOrderID(TextType value) {
        this.orderID = value;
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
