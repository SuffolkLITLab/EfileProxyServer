
package tyler.efm.services.schema.common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for PaymentAccountType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PaymentAccountType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="AccountToken" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="CardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CardLast4" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="CardMonth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CardYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="CardHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="PaymentAccountID" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="FirmID" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="PaymentAccountTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountType", propOrder = {
    "accountName",
    "accountToken",
    "cardType",
    "cardLast4",
    "cardMonth",
    "cardYear",
    "cardHolderName",
    "active"
})
public class PaymentAccountType {

    @XmlElement(name = "AccountName")
    protected String accountName;
    @XmlElement(name = "AccountToken", required = true, nillable = true)
    protected String accountToken;
    @XmlElementRef(name = "CardType", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardType;
    @XmlElement(name = "CardLast4", required = true, nillable = true)
    protected String cardLast4;
    @XmlElementRef(name = "CardMonth", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cardMonth;
    @XmlElementRef(name = "CardYear", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> cardYear;
    @XmlElementRef(name = "CardHolderName", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cardHolderName;
    @XmlElementRef(name = "Active", namespace = "urn:tyler:efm:services:schema:Common", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> active;
    @XmlAttribute(name = "PaymentAccountID")
    protected String paymentAccountID;
    @XmlAttribute(name = "FirmID")
    protected String firmID;
    @XmlAttribute(name = "PaymentAccountTypeCode")
    protected String paymentAccountTypeCode;

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
     * Gets the value of the accountToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountToken() {
        return accountToken;
    }

    /**
     * Sets the value of the accountToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountToken(String value) {
        this.accountToken = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardType(JAXBElement<String> value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardLast4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardLast4() {
        return cardLast4;
    }

    /**
     * Sets the value of the cardLast4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardLast4(String value) {
        this.cardLast4 = value;
    }

    /**
     * Gets the value of the cardMonth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCardMonth() {
        return cardMonth;
    }

    /**
     * Sets the value of the cardMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCardMonth(JAXBElement<Integer> value) {
        this.cardMonth = value;
    }

    /**
     * Gets the value of the cardYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCardYear() {
        return cardYear;
    }

    /**
     * Sets the value of the cardYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCardYear(JAXBElement<Integer> value) {
        this.cardYear = value;
    }

    /**
     * Gets the value of the cardHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the value of the cardHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCardHolderName(JAXBElement<String> value) {
        this.cardHolderName = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setActive(JAXBElement<Boolean> value) {
        this.active = value;
    }

    /**
     * Gets the value of the paymentAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountID() {
        return paymentAccountID;
    }

    /**
     * Sets the value of the paymentAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountID(String value) {
        this.paymentAccountID = value;
    }

    /**
     * Gets the value of the firmID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmID() {
        return firmID;
    }

    /**
     * Sets the value of the firmID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmID(String value) {
        this.firmID = value;
    }

    /**
     * Gets the value of the paymentAccountTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountTypeCode() {
        return paymentAccountTypeCode;
    }

    /**
     * Sets the value of the paymentAccountTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountTypeCode(String value) {
        this.paymentAccountTypeCode = value;
    }

}
