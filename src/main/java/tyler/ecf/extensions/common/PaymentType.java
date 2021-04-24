
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * &lt;p&gt;Java class for PaymentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PaymentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}AccountName"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}WaiverIndicator"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CardType"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}Last4Digits"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ExpirationMonth"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ExpirationYear"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TransactionAmount"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TransactionResponse"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TransactionID"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}OrderID"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentType", propOrder = {
    "accountName",
    "waiverIndicator",
    "cardType",
    "last4Digits",
    "expirationMonth",
    "expirationYear",
    "transactionAmount",
    "transactionResponse",
    "transactionID",
    "orderID"
})
public class PaymentType {

    @XmlElement(name = "AccountName", required = true)
    protected String accountName;
    @XmlElement(name = "WaiverIndicator", required = true)
    protected Boolean waiverIndicator;
    @XmlElement(name = "CardType", required = true)
    protected String cardType;
    @XmlElement(name = "Last4Digits", required = true)
    protected String last4Digits;
    @XmlElement(name = "ExpirationMonth")
    protected int expirationMonth;
    @XmlElement(name = "ExpirationYear")
    protected int expirationYear;
    @XmlElement(name = "TransactionAmount", required = true)
    protected AmountType transactionAmount;
    @XmlElement(name = "TransactionResponse", required = true)
    protected String transactionResponse;
    @XmlElement(name = "TransactionID", required = true)
    protected String transactionID;
    @XmlElement(name = "OrderID", required = true)
    protected String orderID;

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
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
     *     {@link String }
     *     
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the last4Digits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLast4Digits() {
        return last4Digits;
    }

    /**
     * Sets the value of the last4Digits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLast4Digits(String value) {
        this.last4Digits = value;
    }

    /**
     * Gets the value of the expirationMonth property.
     * 
     */
    public int getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * Sets the value of the expirationMonth property.
     * 
     */
    public void setExpirationMonth(int value) {
        this.expirationMonth = value;
    }

    /**
     * Gets the value of the expirationYear property.
     * 
     */
    public int getExpirationYear() {
        return expirationYear;
    }

    /**
     * Sets the value of the expirationYear property.
     * 
     */
    public void setExpirationYear(int value) {
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
     *     {@link String }
     *     
     */
    public String getTransactionResponse() {
        return transactionResponse;
    }

    /**
     * Sets the value of the transactionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionResponse(String value) {
        this.transactionResponse = value;
    }

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

}
