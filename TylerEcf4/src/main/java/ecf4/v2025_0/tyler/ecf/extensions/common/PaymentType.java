
package ecf4.v2025_0.tyler.ecf.extensions.common;

import ecf4.v2025_0.gov.niem.niem.niem_core._2.AmountType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
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
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}AccountName"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}WaiverIndicator"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CardType"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}Last4Digits"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ExpirationMonth"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ExpirationYear"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TransactionAmount"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TransactionResponse"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TransactionID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}OrderID"/&gt;
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
